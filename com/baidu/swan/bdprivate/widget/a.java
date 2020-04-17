package com.baidu.swan.bdprivate.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.swan.bdprivate.b;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.apps.res.widget.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private BdContextMenuView cEm;

    public a(View view) {
        super(view);
        setPopupWindowWidth(view.getResources().getDimensionPixelSize(b.c.aiapps_context_menu_max_width));
        setBackgroundDarken(true);
        setHaveAnimation(true);
    }

    @Override // com.baidu.swan.apps.res.widget.a.a
    protected View getMenuView(Context context) {
        BdContextMenuView bdContextMenuView = new BdContextMenuView(context);
        this.cEm = bdContextMenuView;
        return bdContextMenuView;
    }

    public void setLayoutInCenter(boolean z) {
        this.cEm.setLayoutInCenter(z);
    }

    @Override // com.baidu.swan.apps.res.widget.a.a
    protected void ensureMenuLoaded(View view, List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (DEBUG) {
            Log.d("BdContextMenu", "Ensure menu loaded!");
        }
        ((BdContextMenuView) view).layoutMenu(list);
    }

    @Override // com.baidu.swan.apps.res.widget.a.a
    protected void showMenu(PopupWindow popupWindow) {
        if (DEBUG) {
            Log.d("BdContextMenu", "Show menu!");
        }
        popupWindow.showAtLocation(this.mViewToAttach, 17, 0, 0);
    }
}
