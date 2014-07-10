package android.support.v4.view;

import android.os.Build;
import android.view.MenuItem;
import android.view.View;
/* loaded from: classes.dex */
public class MenuItemCompat {
    static final MenuVersionImpl IMPL;
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;

    /* loaded from: classes.dex */
    interface MenuVersionImpl {
        MenuItem setActionView(MenuItem menuItem, View view);

        boolean setShowAsAction(MenuItem menuItem, int i);
    }

    /* loaded from: classes.dex */
    class BaseMenuVersionImpl implements MenuVersionImpl {
        BaseMenuVersionImpl() {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public boolean setShowAsAction(MenuItem menuItem, int i) {
            return false;
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public MenuItem setActionView(MenuItem menuItem, View view) {
            return menuItem;
        }
    }

    /* loaded from: classes.dex */
    class HoneycombMenuVersionImpl implements MenuVersionImpl {
        HoneycombMenuVersionImpl() {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public boolean setShowAsAction(MenuItem menuItem, int i) {
            MenuItemCompatHoneycomb.setShowAsAction(menuItem, i);
            return true;
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public MenuItem setActionView(MenuItem menuItem, View view) {
            return MenuItemCompatHoneycomb.setActionView(menuItem, view);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombMenuVersionImpl();
        } else {
            IMPL = new BaseMenuVersionImpl();
        }
    }

    public static boolean setShowAsAction(MenuItem menuItem, int i) {
        return IMPL.setShowAsAction(menuItem, i);
    }

    public static MenuItem setActionView(MenuItem menuItem, View view) {
        return IMPL.setActionView(menuItem, view);
    }
}
