package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.swan.apps.a;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.res.widget.a.a {
    private int dtm;
    private int dtn;
    private CommonOverflowMenuView dto;
    private int mGravity;

    @Override // com.baidu.swan.apps.res.widget.a.a
    protected View getMenuView(Context context) {
        CommonOverflowMenuView commonOverflowMenuView = new CommonOverflowMenuView(context);
        commonOverflowMenuView.setOrientation(1);
        this.dto = commonOverflowMenuView;
        return commonOverflowMenuView;
    }

    public void v(int i, int i2, int i3) {
        this.mGravity = i;
        this.dtm = i2;
        this.dtn = i3;
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
        popupWindow.showAtLocation(this.mViewToAttach, this.mGravity, this.dtm, this.dtn);
        if (popupWindow.isShowing()) {
            popupWindow.setAnimationStyle(a.i.brower_menu);
            popupWindow.update(this.dtm, this.dtn, -1, -1, true);
        }
    }
}
