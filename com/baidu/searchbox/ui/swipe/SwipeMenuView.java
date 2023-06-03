package com.baidu.searchbox.ui.swipe;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class SwipeMenuView extends LinearLayout implements View.OnClickListener {
    public SwipeMenuLayout mLayout;
    public SwipeMenuListView mListView;
    public SwipeMenu mMenu;
    public OnSwipeItemClickListener mOnItemClickListener;
    public int mPosition;

    /* loaded from: classes4.dex */
    public interface OnSwipeItemClickListener {
        void onItemClick(SwipeMenuView swipeMenuView, SwipeMenu swipeMenu, int i);
    }

    public SwipeMenuView(SwipeMenu swipeMenu, SwipeMenuListView swipeMenuListView) {
        super(swipeMenu.getContext());
        this.mListView = swipeMenuListView;
        this.mMenu = swipeMenu;
        int i = 0;
        for (SwipeMenuItem swipeMenuItem : swipeMenu.getMenuItems()) {
            addItem(swipeMenuItem, i);
            i++;
        }
    }

    private void addItem(SwipeMenuItem swipeMenuItem, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(swipeMenuItem.getWidth(), -1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setId(i);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(swipeMenuItem.getBackground());
        linearLayout.setOnClickListener(this);
        addView(linearLayout);
        if (swipeMenuItem.getIcon() != null) {
            linearLayout.addView(createIcon(swipeMenuItem));
        }
        if (!TextUtils.isEmpty(swipeMenuItem.getTitle())) {
            linearLayout.addView(createTitle(swipeMenuItem));
        }
    }

    private ImageView createIcon(SwipeMenuItem swipeMenuItem) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(swipeMenuItem.getIcon());
        return imageView;
    }

    private TextView createTitle(SwipeMenuItem swipeMenuItem) {
        TextView textView = new TextView(getContext());
        textView.setText(swipeMenuItem.getTitle());
        textView.setGravity(17);
        textView.setTextSize(0, swipeMenuItem.getTitlePxSize());
        textView.setTextColor(swipeMenuItem.getTitleColor());
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.mOnItemClickListener != null && this.mLayout.isOpen()) {
            this.mOnItemClickListener.onItemClick(this, this.mMenu, view2.getId());
        }
    }

    public void setLayout(SwipeMenuLayout swipeMenuLayout) {
        this.mLayout = swipeMenuLayout;
    }

    public void setOnSwipeItemClickListener(OnSwipeItemClickListener onSwipeItemClickListener) {
        this.mOnItemClickListener = onSwipeItemClickListener;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public OnSwipeItemClickListener getOnSwipeItemClickListener() {
        return this.mOnItemClickListener;
    }

    public int getPosition() {
        return this.mPosition;
    }
}
