package com.baidu.android.ext.widget.menu;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.android.common.ui.R;
import java.util.List;
/* loaded from: classes12.dex */
public class BdContextMenu extends BdMenu {
    private static final boolean DEBUG = false;
    private static final String TAG = "BdContextMenu";
    private BdContextMenuView mMenuView;

    public BdContextMenu(View view) {
        super(view);
        setPopupWindowWidth(view.getResources().getDimensionPixelSize(R.dimen.context_menu_max_width));
        setBackgroundDarken(true);
        setHaveAnimation(true);
    }

    public void updateMenu() {
        onMenuSetChanged(getView());
        ensureMenuLoaded(getView(), this.mItems);
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    protected View getMenuView(Context context) {
        BdContextMenuView bdContextMenuView = new BdContextMenuView(context);
        this.mMenuView = bdContextMenuView;
        return bdContextMenuView;
    }

    public void setLayoutInCenter(boolean z) {
        this.mMenuView.setLayoutInCenter(z);
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    protected void ensureMenuLoaded(View view, List<BdMenuItem> list) {
        ((BdContextMenuView) view).layoutMenu(list);
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    protected void showMenu(PopupWindow popupWindow) {
        popupWindow.showAtLocation(this.mViewToAttach, 17, 0, 0);
    }

    private void onMenuSetChanged(View view) {
        ((BdContextMenuView) view).onMenuSetChanged();
    }
}
