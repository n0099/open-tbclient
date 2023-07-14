package com.baidu.searchbox.ui;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import java.util.List;
/* loaded from: classes4.dex */
public class CommonWhiteMenu extends BdMenu {
    public int mDelatX;
    public int mDelatY;
    public int mGravity;
    public CommonWhiteMenuView mMenuView;
    public final int mPopupWidth;

    public CommonWhiteMenu(View view2) {
        super(view2);
        int dimensionPixelSize = view2.getResources().getDimensionPixelSize(com.baidu.tieba.R.dimen.home_skin_setting_menu_width);
        this.mPopupWidth = dimensionPixelSize;
        setPopupWindowWidth(dimensionPixelSize);
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    public View getMenuView(Context context) {
        CommonWhiteMenuView commonWhiteMenuView = new CommonWhiteMenuView(context);
        commonWhiteMenuView.setOrientation(1);
        this.mMenuView = commonWhiteMenuView;
        return commonWhiteMenuView;
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
            popupWindow.setAnimationStyle(com.baidu.tieba.R.style.obfuscated_res_0x7f10041e);
            popupWindow.update(this.mDelatX, this.mDelatY, -1, -1, true);
        }
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    public void ensureMenuLoaded(View view2, List<BdMenuItem> list) {
        if (view2 instanceof CommonWhiteMenuView) {
            ((CommonWhiteMenuView) view2).layoutMenu(list);
        }
    }

    public void setMenuDivider(int i, int i2) {
        this.mMenuView.setItemDivider(i, i2);
    }

    public CommonWhiteMenuView getCommonMenuView() {
        CommonWhiteMenuView commonWhiteMenuView = this.mMenuView;
        if (commonWhiteMenuView == null) {
            return null;
        }
        return commonWhiteMenuView;
    }

    public int getWidth() {
        return this.mPopupWidth;
    }

    public void setShowAtLocation(int i, int i2, int i3) {
        this.mGravity = i;
        this.mDelatX = i2;
        this.mDelatY = i3;
    }
}
