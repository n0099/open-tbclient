package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
@RestrictTo
/* loaded from: classes2.dex */
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
    private static Method QO;
    private MenuItemHoverListener QP;

    static {
        try {
            QO = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        } catch (NoSuchMethodException e) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.support.v7.widget.ListPopupWindow
    l s(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }

    public void setEnterTransition(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.QJ.setEnterTransition((Transition) obj);
        }
    }

    public void setExitTransition(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.QJ.setExitTransition((Transition) obj);
        }
    }

    public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
        this.QP = menuItemHoverListener;
    }

    public void setTouchModal(boolean z) {
        if (QO != null) {
            try {
                QO.invoke(this.QJ, Boolean.valueOf(z));
            } catch (Exception e) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // android.support.v7.widget.MenuItemHoverListener
    public void onItemHoverEnter(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.QP != null) {
            this.QP.onItemHoverEnter(menuBuilder, menuItem);
        }
    }

    @Override // android.support.v7.widget.MenuItemHoverListener
    public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.QP != null) {
            this.QP.onItemHoverExit(menuBuilder, menuItem);
        }
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class MenuDropDownListView extends l {
        private MenuItemHoverListener QP;
        final int QR;
        final int QS;
        private MenuItem QT;

        @Override // android.support.v7.widget.l, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // android.support.v7.widget.l, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // android.support.v7.widget.l, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // android.support.v7.widget.l, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // android.support.v7.widget.l
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent motionEvent, int i) {
            return super.onForwardedEvent(motionEvent, i);
        }

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.QR = 21;
                this.QS = 22;
                return;
            }
            this.QR = 22;
            this.QS = 21;
        }

        public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
            this.QP = menuItemHoverListener;
        }

        public void clearSelection() {
            setSelection(-1);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.QR) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView != null && i == this.QS) {
                setSelection(-1);
                ((MenuAdapter) getAdapter()).getAdapterMenu().close(false);
                return true;
            } else {
                return super.onKeyDown(i, keyEvent);
            }
        }

        @Override // android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            MenuAdapter menuAdapter;
            MenuItemImpl menuItemImpl;
            int pointToPosition;
            int i2;
            if (this.QP != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                    menuAdapter = (MenuAdapter) adapter;
                }
                if (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i2 = pointToPosition - i) < 0 || i2 >= menuAdapter.getCount()) {
                    menuItemImpl = null;
                } else {
                    menuItemImpl = menuAdapter.getItem(i2);
                }
                MenuItem menuItem = this.QT;
                if (menuItem != menuItemImpl) {
                    MenuBuilder adapterMenu = menuAdapter.getAdapterMenu();
                    if (menuItem != null) {
                        this.QP.onItemHoverExit(adapterMenu, menuItem);
                    }
                    this.QT = menuItemImpl;
                    if (menuItemImpl != null) {
                        this.QP.onItemHoverEnter(adapterMenu, menuItemImpl);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }
}
