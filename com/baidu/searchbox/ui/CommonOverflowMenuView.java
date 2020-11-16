package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.ext.widget.dialog.BoxScrollView;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.android.ext.widget.menu.BdMenuItemCheck;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes19.dex */
public class CommonOverflowMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {
    private HashMap<BdMenuItem, ImageView> mBdMenuItemIconMap;
    private List<TextView> mBdMenuItemTexList;
    private SparseArray<View> mChildView;
    private View mContentView;
    private int mDividerHeight;
    private List<ImageView> mDividerList;
    private int mDividerRes;
    private int mItemBgRes;
    private ColorStateList mItemTextColor;
    private LinearLayout mLinearContent;
    private boolean mMenuLoaded;
    private Object mNightModeRegister;
    private BoxScrollView mScrollView;

    public CommonOverflowMenuView(Context context) {
        super(context);
        this.mItemBgRes = com.baidu.android.common.ui.R.drawable.discovery_home_menu_item_selector;
        this.mDividerRes = com.baidu.android.common.ui.R.color.home_menu_separator_color;
        this.mDividerHeight = 1;
        this.mDividerList = new ArrayList();
        this.mBdMenuItemTexList = new ArrayList();
        this.mBdMenuItemIconMap = new HashMap<>();
        this.mMenuLoaded = false;
        this.mChildView = new SparseArray<>();
        this.mNightModeRegister = new Object();
        init(context);
    }

    public CommonOverflowMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemBgRes = com.baidu.android.common.ui.R.drawable.discovery_home_menu_item_selector;
        this.mDividerRes = com.baidu.android.common.ui.R.color.home_menu_separator_color;
        this.mDividerHeight = 1;
        this.mDividerList = new ArrayList();
        this.mBdMenuItemTexList = new ArrayList();
        this.mBdMenuItemIconMap = new HashMap<>();
        this.mMenuLoaded = false;
        this.mChildView = new SparseArray<>();
        this.mNightModeRegister = new Object();
        init(context);
    }

    private void init(Context context) {
        this.mContentView = LayoutInflater.from(context).inflate(com.baidu.android.common.ui.R.layout.menu_scroll_view, (ViewGroup) this, true);
        this.mLinearContent = (LinearLayout) this.mContentView.findViewById(com.baidu.android.common.ui.R.id.menu_linear);
        this.mScrollView = (BoxScrollView) this.mContentView.findViewById(com.baidu.android.common.ui.R.id.menu_scrollview);
        setFocusable(true);
        setFocusableInTouchMode(true);
        updateUI();
    }

    public void setItemBackground(int i) {
        this.mItemBgRes = i;
    }

    public void setItemTextColor(int i) {
        this.mItemTextColor = getResources().getColorStateList(i);
    }

    public void setItemDivider(int i, int i2) {
        this.mDividerRes = i;
        this.mDividerHeight = i2;
    }

    public void layoutMenu(List<BdMenuItem> list) {
        if (!this.mMenuLoaded) {
            this.mLinearContent.removeAllViews();
            this.mChildView.clear();
            Context context = getContext();
            if (this.mDividerHeight < 0) {
                this.mDividerHeight = context.getResources().getDimensionPixelSize(com.baidu.android.common.ui.R.dimen.pulldown_divider_height);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mDividerHeight);
            int i = 0;
            Iterator<BdMenuItem> it = list.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    final BdMenuItem next = it.next();
                    View menuItemView = getMenuItemView(context, next);
                    if (next.isEnabled()) {
                        menuItemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.CommonOverflowMenuView.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                CommonOverflowMenuView.this.itemOnclick(next);
                            }
                        });
                    }
                    this.mLinearContent.addView(menuItemView);
                    this.mChildView.append(next.getItemId(), menuItemView);
                    if (i2 < list.size() - 1) {
                        ImageView imageView = new ImageView(context);
                        this.mDividerList.add(imageView);
                        imageView.setBackgroundColor(getResources().getColor(this.mDividerRes));
                        this.mLinearContent.addView(imageView, layoutParams);
                    }
                    i = i2 + 1;
                } else {
                    this.mMenuLoaded = true;
                    return;
                }
            }
        }
    }

    protected View getMenuItemView(Context context, BdMenuItem bdMenuItem) {
        if (bdMenuItem instanceof BdMenuItemCheck) {
            View inflate = LayoutInflater.from(context).inflate(com.baidu.android.common.ui.R.layout.pulldown_item_checkbox, (ViewGroup) this.mLinearContent, false);
            inflate.findViewById(com.baidu.android.common.ui.R.id.item).setBackgroundResource(this.mItemBgRes);
            TextView textView = (TextView) inflate.findViewById(com.baidu.android.common.ui.R.id.item_title);
            this.mBdMenuItemTexList.add(textView);
            textView.setText(bdMenuItem.getTitle());
            ((CheckBox) inflate.findViewById(com.baidu.android.common.ui.R.id.checkbox_id)).setChecked(bdMenuItem.isChecked());
            textView.setTextColor(this.mItemTextColor);
            inflate.setEnabled(bdMenuItem.isEnabled());
            textView.setEnabled(bdMenuItem.isEnabled());
            return inflate;
        }
        View inflate2 = LayoutInflater.from(context).inflate(com.baidu.android.common.ui.R.layout.pulldown_item, (ViewGroup) this.mLinearContent, false);
        inflate2.findViewById(com.baidu.android.common.ui.R.id.item).setBackgroundResource(this.mItemBgRes);
        ImageView imageView = (ImageView) inflate2.findViewById(com.baidu.android.common.ui.R.id.left_img);
        this.mBdMenuItemIconMap.put(bdMenuItem, imageView);
        imageView.setImageDrawable(bdMenuItem.getIcon());
        TextView textView2 = (TextView) inflate2.findViewById(com.baidu.android.common.ui.R.id.right_txt);
        this.mBdMenuItemTexList.add(textView2);
        textView2.setText(bdMenuItem.getTitle());
        textView2.setTextColor(this.mItemTextColor);
        inflate2.setEnabled(bdMenuItem.isEnabled());
        imageView.setEnabled(bdMenuItem.isEnabled());
        textView2.setEnabled(bdMenuItem.isEnabled());
        return inflate2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void itemOnclick(BdMenuItem bdMenuItem) {
        BdMenuItem.OnItemClickListener onClickListener = bdMenuItem.getOnClickListener();
        if (onClickListener != null) {
            onClickListener.onClick(bdMenuItem);
        }
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        this.mMenuLoaded = false;
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
        View view;
        if (bdMenuItem != null && (bdMenuItem instanceof BdMenuItemCheck) && (view = this.mChildView.get(bdMenuItem.getItemId())) != null) {
            view.findViewById(com.baidu.android.common.ui.R.id.item).setBackgroundResource(this.mItemBgRes);
            TextView textView = (TextView) view.findViewById(com.baidu.android.common.ui.R.id.item_title);
            textView.setText(bdMenuItem.getTitle());
            ((CheckBox) view.findViewById(com.baidu.android.common.ui.R.id.checkbox_id)).setChecked(bdMenuItem.isChecked());
            textView.setTextColor(this.mItemTextColor);
            view.setEnabled(bdMenuItem.isEnabled());
            textView.setEnabled(bdMenuItem.isEnabled());
        }
    }

    public void setMaxHeightRes(int i) {
        this.mScrollView.setMaxHeight(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMaxHeightPixel(int i) {
        this.mScrollView.setMaxHeight(i);
    }

    public LinearLayout getLinearContent() {
        return this.mLinearContent;
    }

    public ColorStateList getTextColor() {
        return this.mItemTextColor;
    }

    public int getItemBgRes() {
        return this.mItemBgRes;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        NightModeHelper.subscribeNightModeChangeEvent(this.mNightModeRegister, new NightModeChangeListener() { // from class: com.baidu.searchbox.ui.CommonOverflowMenuView.2
            @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
            public void onNightModeChanged(boolean z) {
                CommonOverflowMenuView.this.updateUI();
            }
        });
        updateUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUI() {
        this.mItemTextColor = getResources().getColorStateList(com.baidu.android.common.ui.R.color.discovery_home_menu_text_color);
        setBackground(getResources().getDrawable(com.baidu.android.common.ui.R.drawable.discovery_feedback_menu_bg));
        for (ImageView imageView : this.mDividerList) {
            imageView.setBackgroundColor(getResources().getColor(this.mDividerRes));
        }
        for (TextView textView : this.mBdMenuItemTexList) {
            textView.setTextColor(this.mItemTextColor);
        }
        for (Map.Entry<BdMenuItem, ImageView> entry : this.mBdMenuItemIconMap.entrySet()) {
            entry.getValue().setImageDrawable(entry.getKey().getIcon());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NightModeHelper.unsubscribeNightModeChangedEvent(this.mNightModeRegister);
    }
}
