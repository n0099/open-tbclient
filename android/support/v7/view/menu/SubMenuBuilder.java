package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
@RestrictTo
/* loaded from: classes2.dex */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuBuilder JN;
    private MenuItemImpl JO;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.JN = menuBuilder;
        this.JO = menuItemImpl;
    }

    @Override // android.support.v7.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.JN.setQwertyMode(z);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public boolean isQwertyMode() {
        return this.JN.isQwertyMode();
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public void setShortcutsVisible(boolean z) {
        this.JN.setShortcutsVisible(z);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public boolean isShortcutsVisible() {
        return this.JN.isShortcutsVisible();
    }

    public Menu getParentMenu() {
        return this.JN;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.JO;
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public void setCallback(MenuBuilder.Callback callback) {
        this.JN.setCallback(callback);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public MenuBuilder getRootMenu() {
        return this.JN.getRootMenu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.view.menu.MenuBuilder
    public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.a(menuBuilder, menuItem) || this.JN.a(menuBuilder, menuItem);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.JO.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.JO.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.setHeaderIconInt(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.setHeaderIconInt(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.setHeaderTitleInt(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.setHeaderTitleInt(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        return this.JN.expandItemActionView(menuItemImpl);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return this.JN.collapseItemActionView(menuItemImpl);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public String getActionViewStatesKey() {
        int itemId = this.JO != null ? this.JO.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }
}
