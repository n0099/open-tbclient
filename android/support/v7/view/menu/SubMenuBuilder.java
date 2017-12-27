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
    private MenuBuilder JO;
    private MenuItemImpl JP;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.JO = menuBuilder;
        this.JP = menuItemImpl;
    }

    @Override // android.support.v7.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.JO.setQwertyMode(z);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public boolean isQwertyMode() {
        return this.JO.isQwertyMode();
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public void setShortcutsVisible(boolean z) {
        this.JO.setShortcutsVisible(z);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public boolean isShortcutsVisible() {
        return this.JO.isShortcutsVisible();
    }

    public Menu getParentMenu() {
        return this.JO;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.JP;
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public void setCallback(MenuBuilder.Callback callback) {
        this.JO.setCallback(callback);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public MenuBuilder getRootMenu() {
        return this.JO.getRootMenu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.view.menu.MenuBuilder
    public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.a(menuBuilder, menuItem) || this.JO.a(menuBuilder, menuItem);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.JP.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.JP.setIcon(i);
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
        return this.JO.expandItemActionView(menuItemImpl);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return this.JO.collapseItemActionView(menuItemImpl);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public String getActionViewStatesKey() {
        int itemId = this.JP != null ? this.JP.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }
}
