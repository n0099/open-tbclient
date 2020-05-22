package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.swan.apps.a;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.apps.res.widget.a.a {
    private CommonOverflowMenuView cvo;
    private int mDelatX;
    private int mDelatY;
    private int mGravity;

    @Override // com.baidu.swan.apps.res.widget.a.a
    protected View getMenuView(Context context) {
        CommonOverflowMenuView commonOverflowMenuView = new CommonOverflowMenuView(context);
        commonOverflowMenuView.setOrientation(1);
        this.cvo = commonOverflowMenuView;
        return commonOverflowMenuView;
    }

    public void setShowAtLocation(int i, int i2, int i3) {
        this.mGravity = i;
        this.mDelatX = i2;
        this.mDelatY = i3;
    }

    @Override // com.baidu.swan.apps.res.widget.a.a
    protected void ensureMenuLoaded(View view, List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (view instanceof CommonOverflowMenuView) {
            CommonOverflowMenuView commonOverflowMenuView = (CommonOverflowMenuView) view;
            commonOverflowMenuView.setMaxHeightRes(a.d.aiapps_bd_action_bar_menu_max_height);
            commonOverflowMenuView.layoutMenu(list);
        }
    }

    @Override // com.baidu.swan.apps.res.widget.a.a
    protected void showMenu(PopupWindow popupWindow) {
        popupWindow.showAtLocation(this.mViewToAttach, this.mGravity, this.mDelatX, this.mDelatY);
        if (popupWindow.isShowing()) {
            popupWindow.setAnimationStyle(a.i.brower_menu);
            popupWindow.update(this.mDelatX, this.mDelatY, -1, -1, true);
        }
    }
}
