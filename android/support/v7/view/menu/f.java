package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.internal.view.SupportMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class f extends a<SupportMenu> implements Menu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, SupportMenu supportMenu) {
        super(context, supportMenu);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return b(((SupportMenu) this.HO).add(charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return b(((SupportMenu) this.HO).add(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return b(((SupportMenu) this.HO).add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return b(((SupportMenu) this.HO).add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(((SupportMenu) this.HO).addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return a(((SupportMenu) this.HO).addSubMenu(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return a(((SupportMenu) this.HO).addSubMenu(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return a(((SupportMenu) this.HO).addSubMenu(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((SupportMenu) this.HO).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = b(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        aQ(i);
        ((SupportMenu) this.HO).removeItem(i);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        aP(i);
        ((SupportMenu) this.HO).removeGroup(i);
    }

    @Override // android.view.Menu
    public void clear() {
        eO();
        ((SupportMenu) this.HO).clear();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((SupportMenu) this.HO).setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        ((SupportMenu) this.HO).setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        ((SupportMenu) this.HO).setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return ((SupportMenu) this.HO).hasVisibleItems();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return b(((SupportMenu) this.HO).findItem(i));
    }

    @Override // android.view.Menu
    public int size() {
        return ((SupportMenu) this.HO).size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return b(((SupportMenu) this.HO).getItem(i));
    }

    @Override // android.view.Menu
    public void close() {
        ((SupportMenu) this.HO).close();
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((SupportMenu) this.HO).performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((SupportMenu) this.HO).isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return ((SupportMenu) this.HO).performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        ((SupportMenu) this.HO).setQwertyMode(z);
    }
}
