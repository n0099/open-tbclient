package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
abstract class a<T> extends b<T> {
    private Map<SupportMenuItem, MenuItem> HG;
    private Map<SupportSubMenu, SubMenu> HH;
    final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, T t) {
        super(t);
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem b(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
            if (this.HG == null) {
                this.HG = new ArrayMap();
            }
            MenuItem menuItem2 = this.HG.get(menuItem);
            if (menuItem2 == null) {
                MenuItem wrapSupportMenuItem = MenuWrapperFactory.wrapSupportMenuItem(this.mContext, supportMenuItem);
                this.HG.put(supportMenuItem, wrapSupportMenuItem);
                return wrapSupportMenuItem;
            }
            return menuItem2;
        }
        return menuItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (subMenu instanceof SupportSubMenu) {
            SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
            if (this.HH == null) {
                this.HH = new ArrayMap();
            }
            SubMenu subMenu2 = this.HH.get(supportSubMenu);
            if (subMenu2 == null) {
                SubMenu wrapSupportSubMenu = MenuWrapperFactory.wrapSupportSubMenu(this.mContext, supportSubMenu);
                this.HH.put(supportSubMenu, wrapSupportSubMenu);
                return wrapSupportSubMenu;
            }
            return subMenu2;
        }
        return subMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eO() {
        if (this.HG != null) {
            this.HG.clear();
        }
        if (this.HH != null) {
            this.HH.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void aP(int i) {
        if (this.HG != null) {
            Iterator<SupportMenuItem> it = this.HG.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void aQ(int i) {
        if (this.HG != null) {
            Iterator<SupportMenuItem> it = this.HG.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
