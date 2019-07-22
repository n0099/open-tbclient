package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.swan.apps.a;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.apps.res.widget.a.a {
    private int aIQ;
    private int aIR;
    private CommonOverflowMenuView aIS;
    private int mGravity;

    @Override // com.baidu.swan.apps.res.widget.a.a
    protected View getMenuView(Context context) {
        CommonOverflowMenuView commonOverflowMenuView = new CommonOverflowMenuView(context);
        commonOverflowMenuView.setOrientation(1);
        this.aIS = commonOverflowMenuView;
        return commonOverflowMenuView;
    }

    public void l(int i, int i2, int i3) {
        this.mGravity = i;
        this.aIQ = i2;
        this.aIR = i3;
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
        popupWindow.showAtLocation(this.mViewToAttach, this.mGravity, this.aIQ, this.aIR);
        if (popupWindow.isShowing()) {
            popupWindow.setAnimationStyle(a.i.brower_menu);
            popupWindow.update(this.aIQ, this.aIR, -1, -1, true);
        }
    }
}
