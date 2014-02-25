package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;
/* loaded from: classes.dex */
class MenuItemCompatHoneycomb {
    MenuItemCompatHoneycomb() {
    }

    public static void setShowAsAction(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static MenuItem setActionView(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }
}
