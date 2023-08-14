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
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.android.ext.widget.menu.BdMenuItemCheck;
import java.util.List;
/* loaded from: classes4.dex */
public class CommonWhiteMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {
    public SparseArray<View> mChildView;
    public View mContentView;
    public int mDividerHeight;
    public int mDividerRes;
    public int mItemBgRes;
    public ColorStateList mItemTextColor;
    public boolean mMenuLoaded;

    public CommonWhiteMenuView(Context context) {
        super(context);
        this.mDividerHeight = 1;
        this.mMenuLoaded = false;
        this.mChildView = new SparseArray<>();
        init(context);
    }

    private void init(Context context) {
        this.mContentView = LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.home_skin_menu_layout, (ViewGroup) this, true);
        initColorAndBg();
        setFocusable(true);
        setFocusableInTouchMode(true);
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

    public CommonWhiteMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDividerHeight = 1;
        this.mMenuLoaded = false;
        this.mChildView = new SparseArray<>();
        init(context);
    }

    public void setItemDivider(int i, int i2) {
        this.mDividerRes = i;
        this.mDividerHeight = i2;
    }

    private void initColorAndBg() {
        this.mItemTextColor = getResources().getColorStateList(com.baidu.tieba.R.color.home_skin_menu_text_color);
        this.mDividerRes = com.baidu.tieba.R.color.home_skin_menu_item_divider_color;
        this.mItemBgRes = com.baidu.tieba.R.drawable.home_skin_setting_item_bg_selector;
        setBackground(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f0813b8));
    }

    public int getItemBgRes() {
        return this.mItemBgRes;
    }

    public ColorStateList getTextColor() {
        return this.mItemTextColor;
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        this.mMenuLoaded = false;
    }

    public View getMenuItemView(Context context, BdMenuItem bdMenuItem) {
        int color;
        if (bdMenuItem instanceof BdMenuItemCheck) {
            View inflate = LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.skin_menu_checkbox_item, (ViewGroup) this, false);
            inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09118d).setBackground(getResources().getDrawable(getItemBgRes()));
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0911d8);
            textView.setText(bdMenuItem.getTitle());
            CheckBox checkBox = (CheckBox) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0906ed);
            checkBox.setButtonDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.skin_checkbox_private));
            checkBox.setChecked(bdMenuItem.isChecked());
            textView.setTextColor(getTextColor());
            inflate.setEnabled(true);
            textView.setEnabled(true);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.skin_menu_item, (ViewGroup) this, false);
        inflate2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09118d).setBackground(getResources().getDrawable(this.mItemBgRes));
        TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091f32);
        textView2.setText(bdMenuItem.getTitle());
        inflate2.setEnabled(bdMenuItem.isEnabled());
        textView2.setEnabled(bdMenuItem.isEnabled());
        if (bdMenuItem.isEnabled()) {
            color = getResources().getColor(com.baidu.tieba.R.color.home_skin_menu_text_color);
        } else {
            color = getResources().getColor(com.baidu.tieba.R.color.home_skin_menu_text_disable_color);
        }
        textView2.setTextColor(color);
        return inflate2;
    }

    public void layoutMenu(List<BdMenuItem> list) {
        initColorAndBg();
        if (this.mMenuLoaded) {
            return;
        }
        removeAllViews();
        this.mChildView.clear();
        Context context = getContext();
        if (this.mDividerHeight < 0) {
            this.mDividerHeight = 1;
        }
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mDividerHeight);
        int i = 0;
        for (final BdMenuItem bdMenuItem : list) {
            View menuItemView = getMenuItemView(context, bdMenuItem);
            if (bdMenuItem.isEnabled()) {
                menuItemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.CommonWhiteMenuView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        CommonWhiteMenuView.this.itemOnclick(bdMenuItem);
                    }
                });
            }
            addView(menuItemView);
            this.mChildView.append(bdMenuItem.getItemId(), menuItemView);
            if (i < list.size() - 1) {
                ImageView imageView = new ImageView(context);
                imageView.setBackgroundColor(getResources().getColor(this.mDividerRes));
                addView(imageView, layoutParams);
            }
            i++;
        }
        this.mMenuLoaded = true;
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
        int color;
        if (bdMenuItem != null && (bdMenuItem instanceof BdMenuItemCheck)) {
            View view2 = this.mChildView.get(bdMenuItem.getItemId());
            if (view2 != null) {
                view2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09118d).setBackground(getResources().getDrawable(getItemBgRes()));
                TextView textView = (TextView) view2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0911d8);
                textView.setText(bdMenuItem.getTitle());
                CheckBox checkBox = (CheckBox) view2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0906ed);
                checkBox.setButtonDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.skin_checkbox_private));
                checkBox.setChecked(bdMenuItem.isChecked());
                textView.setTextColor(getResources().getColorStateList(com.baidu.tieba.R.color.home_skin_menu_text_color));
                view2.setEnabled(bdMenuItem.isEnabled());
                textView.setEnabled(bdMenuItem.isEnabled());
                return;
            }
            return;
        }
        View view3 = this.mChildView.get(bdMenuItem.getItemId());
        view3.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09118d).setBackground(getResources().getDrawable(getItemBgRes()));
        TextView textView2 = (TextView) view3.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091f32);
        textView2.setText(bdMenuItem.getTitle());
        view3.setEnabled(bdMenuItem.isEnabled());
        textView2.setEnabled(bdMenuItem.isEnabled());
        if (bdMenuItem.isEnabled()) {
            color = getResources().getColor(com.baidu.tieba.R.color.home_skin_menu_text_color);
        } else {
            color = getResources().getColor(com.baidu.tieba.R.color.home_skin_menu_text_disable_color);
        }
        textView2.setTextColor(color);
    }
}
