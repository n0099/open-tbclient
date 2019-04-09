package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.swan.apps.a;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.apps.res.widget.a.a {
    private int aGp;
    private int aGq;
    private CommonOverflowMenuView aGr;
    private int mGravity;

    @Override // com.baidu.swan.apps.res.widget.a.a
    protected View getMenuView(Context context) {
        CommonOverflowMenuView commonOverflowMenuView = new CommonOverflowMenuView(context);
        commonOverflowMenuView.setOrientation(1);
        this.aGr = commonOverflowMenuView;
        return commonOverflowMenuView;
    }

    public void m(int i, int i2, int i3) {
        this.mGravity = i;
        this.aGp = i2;
        this.aGq = i3;
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
        popupWindow.showAtLocation(this.mViewToAttach, this.mGravity, this.aGp, this.aGq);
        if (popupWindow.isShowing()) {
            popupWindow.setAnimationStyle(a.i.brower_menu);
            popupWindow.update(this.aGp, this.aGq, -1, -1, true);
        }
    }
}
