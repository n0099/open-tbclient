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
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class CommonOverflowMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {
    public HashMap<BdMenuItem, ImageView> mBdMenuItemIconMap;
    public List<TextView> mBdMenuItemTexList;
    public SparseArray<View> mChildView;
    public View mContentView;
    public int mDividerHeight;
    public List<ImageView> mDividerList;
    public int mDividerRes;
    public int mItemBgRes;
    public ColorStateList mItemTextColor;
    public LinearLayout mLinearContent;
    public boolean mMenuLoaded;
    public Object mNightModeRegister;
    public BoxScrollView mScrollView;

    public CommonOverflowMenuView(Context context) {
        super(context);
        this.mItemBgRes = com.baidu.tieba.R.drawable.obfuscated_res_0x7f0805b0;
        this.mDividerRes = com.baidu.tieba.R.color.obfuscated_res_0x7f06076c;
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
        this.mItemBgRes = com.baidu.tieba.R.drawable.obfuscated_res_0x7f0805b0;
        this.mDividerRes = com.baidu.tieba.R.color.obfuscated_res_0x7f06076c;
        this.mDividerHeight = 1;
        this.mDividerList = new ArrayList();
        this.mBdMenuItemTexList = new ArrayList();
        this.mBdMenuItemIconMap = new HashMap<>();
        this.mMenuLoaded = false;
        this.mChildView = new SparseArray<>();
        this.mNightModeRegister = new Object();
        init(context);
    }

    public void setItemDivider(int i, int i2) {
        this.mDividerRes = i;
        this.mDividerHeight = i2;
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d061e, (ViewGroup) this, true);
        this.mContentView = inflate;
        this.mLinearContent = (LinearLayout) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09174c);
        this.mScrollView = (BoxScrollView) this.mContentView.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09174f);
        setFocusable(true);
        setFocusableInTouchMode(true);
        updateUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void itemOnclick(BdMenuItem bdMenuItem) {
        BdMenuItem.OnItemClickListener onClickListener = bdMenuItem.getOnClickListener();
        if (onClickListener != null) {
            onClickListener.onClick(bdMenuItem);
        }
    }

    public void setItemBackground(int i) {
        this.mItemBgRes = i;
    }

    public void setItemTextColor(int i) {
        this.mItemTextColor = getResources().getColorStateList(i);
    }

    public void setMaxHeightPixel(int i) {
        this.mScrollView.setMaxHeight(i);
    }

    public void setMaxHeightRes(int i) {
        this.mScrollView.setMaxHeight(getContext().getResources().getDimensionPixelSize(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUI() {
        this.mItemTextColor = getResources().getColorStateList(com.baidu.tieba.R.color.obfuscated_res_0x7f060726);
        setBackground(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f0805af));
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

    public int getItemBgRes() {
        return this.mItemBgRes;
    }

    public LinearLayout getLinearContent() {
        return this.mLinearContent;
    }

    public ColorStateList getTextColor() {
        return this.mItemTextColor;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NightModeHelper.subscribeNightModeChangeEvent(this.mNightModeRegister, new NightModeChangeListener() { // from class: com.baidu.searchbox.ui.CommonOverflowMenuView.2
            @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
            public void onNightModeChanged(boolean z) {
                CommonOverflowMenuView.this.updateUI();
            }
        });
        updateUI();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NightModeHelper.unsubscribeNightModeChangedEvent(this.mNightModeRegister);
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        this.mMenuLoaded = false;
    }

    public View getMenuItemView(Context context, BdMenuItem bdMenuItem) {
        if (bdMenuItem instanceof BdMenuItemCheck) {
            View inflate = LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0832, (ViewGroup) this.mLinearContent, false);
            inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0911a2).setBackgroundResource(this.mItemBgRes);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0911ee);
            this.mBdMenuItemTexList.add(textView);
            textView.setText(bdMenuItem.getTitle());
            ((CheckBox) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0906f1)).setChecked(bdMenuItem.isChecked());
            textView.setTextColor(this.mItemTextColor);
            inflate.setEnabled(bdMenuItem.isEnabled());
            textView.setEnabled(bdMenuItem.isEnabled());
            return inflate;
        }
        View inflate2 = LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0831, (ViewGroup) this.mLinearContent, false);
        inflate2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0911a2).setBackgroundResource(this.mItemBgRes);
        ImageView imageView = (ImageView) inflate2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0914f5);
        this.mBdMenuItemIconMap.put(bdMenuItem, imageView);
        imageView.setImageDrawable(bdMenuItem.getIcon());
        TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091f55);
        this.mBdMenuItemTexList.add(textView2);
        textView2.setText(bdMenuItem.getTitle());
        textView2.setTextColor(this.mItemTextColor);
        inflate2.setEnabled(bdMenuItem.isEnabled());
        imageView.setEnabled(bdMenuItem.isEnabled());
        textView2.setEnabled(bdMenuItem.isEnabled());
        return inflate2;
    }

    public void layoutMenu(List<BdMenuItem> list) {
        if (this.mMenuLoaded) {
            return;
        }
        this.mLinearContent.removeAllViews();
        this.mChildView.clear();
        Context context = getContext();
        if (this.mDividerHeight < 0) {
            this.mDividerHeight = context.getResources().getDimensionPixelSize(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070794);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mDividerHeight);
        int i = 0;
        for (final BdMenuItem bdMenuItem : list) {
            View menuItemView = getMenuItemView(context, bdMenuItem);
            if (bdMenuItem.isEnabled()) {
                menuItemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.CommonOverflowMenuView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        CommonOverflowMenuView.this.itemOnclick(bdMenuItem);
                    }
                });
            }
            this.mLinearContent.addView(menuItemView);
            this.mChildView.append(bdMenuItem.getItemId(), menuItemView);
            if (i < list.size() - 1) {
                ImageView imageView = new ImageView(context);
                this.mDividerList.add(imageView);
                imageView.setBackgroundColor(getResources().getColor(this.mDividerRes));
                this.mLinearContent.addView(imageView, layoutParams);
            }
            i++;
        }
        this.mMenuLoaded = true;
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
        View view2;
        if (bdMenuItem != null && (bdMenuItem instanceof BdMenuItemCheck) && (view2 = this.mChildView.get(bdMenuItem.getItemId())) != null) {
            view2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0911a2).setBackgroundResource(this.mItemBgRes);
            TextView textView = (TextView) view2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0911ee);
            textView.setText(bdMenuItem.getTitle());
            ((CheckBox) view2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0906f1)).setChecked(bdMenuItem.isChecked());
            textView.setTextColor(this.mItemTextColor);
            view2.setEnabled(bdMenuItem.isEnabled());
            textView.setEnabled(bdMenuItem.isEnabled());
        }
    }
}
