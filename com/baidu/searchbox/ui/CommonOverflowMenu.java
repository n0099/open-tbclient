package com.baidu.searchbox.ui;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import java.util.List;
/* loaded from: classes13.dex */
public class CommonOverflowMenu extends BdMenu {
    private int mDelatX;
    private int mDelatY;
    private int mGravity;
    private CommonOverflowMenuView mMenuView;

    public CommonOverflowMenu(View view) {
        super(view);
        setPopupWindowWidth(view.getResources().getDimensionPixelSize(com.baidu.android.common.ui.R.dimen.discovery_feedback_width));
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    protected View getMenuView(Context context) {
        CommonOverflowMenuView commonOverflowMenuView = new CommonOverflowMenuView(context);
        commonOverflowMenuView.setOrientation(1);
        this.mMenuView = commonOverflowMenuView;
        return commonOverflowMenuView;
    }

    public void setItemTextColor(int i) {
        this.mMenuView.setItemTextColor(i);
    }

    public void setMenuBackgroundRes(int i) {
        this.mMenuView.setBackgroundResource(i);
    }

    public void setItemBackgroundRes(int i) {
        this.mMenuView.setItemBackground(i);
    }

    public void setMenuDivider(int i, int i2) {
        this.mMenuView.setItemDivider(i, i2);
    }

    public void setShowAtLocation(int i, int i2, int i3) {
        this.mGravity = i;
        this.mDelatX = i2;
        this.mDelatY = i3;
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    protected void ensureMenuLoaded(View view, List<BdMenuItem> list) {
        if (view instanceof CommonOverflowMenuView) {
            CommonOverflowMenuView commonOverflowMenuView = (CommonOverflowMenuView) view;
            commonOverflowMenuView.setMaxHeightRes(com.baidu.android.common.ui.R.dimen.bd_action_bar_menu_max_height);
            commonOverflowMenuView.layoutMenu(list);
        }
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    protected void showMenu(PopupWindow popupWindow) {
        popupWindow.showAtLocation(this.mViewToAttach, this.mGravity, this.mDelatX, this.mDelatY);
        if (popupWindow.isShowing()) {
            popupWindow.setAnimationStyle(com.baidu.android.common.ui.R.style.brower_menu);
            popupWindow.update(this.mDelatX, this.mDelatY, -1, -1, true);
        }
    }
}
