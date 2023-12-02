package com.baidu.searchbox.ui;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import java.util.List;
/* loaded from: classes4.dex */
public class CommonOverflowMenu extends BdMenu {
    public int mDelatX;
    public int mDelatY;
    public int mGravity;
    public CommonOverflowMenuView mMenuView;

    public CommonOverflowMenu(View view2) {
        super(view2);
        setPopupWindowWidth(view2.getResources().getDimensionPixelSize(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070350));
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    public View getMenuView(Context context) {
        CommonOverflowMenuView commonOverflowMenuView = new CommonOverflowMenuView(context);
        commonOverflowMenuView.setOrientation(1);
        this.mMenuView = commonOverflowMenuView;
        return commonOverflowMenuView;
    }

    public void setItemBackgroundRes(int i) {
        this.mMenuView.setItemBackground(i);
    }

    public void setItemTextColor(int i) {
        this.mMenuView.setItemTextColor(i);
    }

    public void setMenuBackgroundRes(int i) {
        this.mMenuView.setBackgroundResource(i);
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    public void showMenu(PopupWindow popupWindow) {
        popupWindow.showAtLocation(this.mViewToAttach, this.mGravity, this.mDelatX, this.mDelatY);
        if (popupWindow.isShowing()) {
            popupWindow.setAnimationStyle(com.baidu.tieba.R.style.obfuscated_res_0x7f1003c1);
            popupWindow.update(this.mDelatX, this.mDelatY, -1, -1, true);
        }
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    public void ensureMenuLoaded(View view2, List<BdMenuItem> list) {
        if (view2 instanceof CommonOverflowMenuView) {
            CommonOverflowMenuView commonOverflowMenuView = (CommonOverflowMenuView) view2;
            commonOverflowMenuView.setMaxHeightRes(com.baidu.tieba.R.dimen.obfuscated_res_0x7f0701a7);
            commonOverflowMenuView.layoutMenu(list);
        }
    }

    public void setMenuDivider(int i, int i2) {
        this.mMenuView.setItemDivider(i, i2);
    }

    public void setShowAtLocation(int i, int i2, int i3) {
        this.mGravity = i;
        this.mDelatX = i2;
        this.mDelatY = i3;
    }
}
