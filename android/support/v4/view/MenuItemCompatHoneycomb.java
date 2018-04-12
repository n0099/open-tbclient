package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;
/* loaded from: classes2.dex */
class MenuItemCompatHoneycomb {
    MenuItemCompatHoneycomb() {
    }

    public static void setShowAsAction(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static MenuItem setActionView(MenuItem menuItem, View view2) {
        return menuItem.setActionView(view2);
    }

    public static MenuItem setActionView(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }

    public static View getActionView(MenuItem menuItem) {
        return menuItem.getActionView();
    }
}
