package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
@RestrictTo
/* loaded from: classes2.dex */
public final class MenuItemImpl implements SupportMenuItem {
    private static String Js;
    private static String Jt;
    private static String Ju;
    private static String Jv;
    private MenuItem.OnMenuItemClickListener HA;
    private final int Hs;
    private final int Ht;
    private final int Hu;
    private CharSequence Hv;
    private char Hw;
    private char Hx;
    private Drawable Hy;
    private SubMenuBuilder Jk;
    private Runnable Jl;
    private int Jm;
    private View Jn;
    private ActionProvider Jo;
    private MenuItemCompat.OnActionExpandListener Jp;
    private ContextMenu.ContextMenuInfo Jr;
    private final int mId;
    private Intent mIntent;
    MenuBuilder mMenu;
    private CharSequence mTitle;
    private int Hz = 0;
    private int mFlags = 16;
    private boolean Jq = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.Jm = 0;
        this.mMenu = menuBuilder;
        this.mId = i2;
        this.Hs = i;
        this.Ht = i3;
        this.Hu = i4;
        this.mTitle = charSequence;
        this.Jm = i5;
    }

    public boolean invoke() {
        if ((this.HA == null || !this.HA.onMenuItemClick(this)) && !this.mMenu.a(this.mMenu.getRootMenu(), this)) {
            if (this.Jl != null) {
                this.Jl.run();
                return true;
            }
            if (this.mIntent != null) {
                try {
                    this.mMenu.getContext().startActivity(this.mIntent);
                    return true;
                } catch (ActivityNotFoundException e) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
                }
            }
            return this.Jo != null && this.Jo.onPerformDefaultAction();
        }
        return true;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.mFlags & 16) != 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.mFlags |= 16;
        } else {
            this.mFlags &= -17;
        }
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.Hs;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.mId;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.Ht;
    }

    public int getOrdering() {
        return this.Hu;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.mIntent;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public MenuItem setCallback(Runnable runnable) {
        this.Jl = runnable;
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.Hx;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.Hx != c) {
            this.Hx = Character.toLowerCase(c);
            this.mMenu.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.Hw;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.Hw != c) {
            this.Hw = c;
            this.mMenu.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.Hw = c;
        this.Hx = Character.toLowerCase(c2);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char eX() {
        return this.mMenu.isQwertyMode() ? this.Hx : this.Hw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String eY() {
        char eX = eX();
        if (eX == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(Js);
        switch (eX) {
            case '\b':
                sb.append(Ju);
                break;
            case '\n':
                sb.append(Jt);
                break;
            case ' ':
                sb.append(Jv);
                break;
            default:
                sb.append(eX);
                break;
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean eZ() {
        return this.mMenu.isShortcutsVisible() && eX() != 0;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.Jk;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.Jk != null;
    }

    public void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.Jk = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.mTitle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence a(MenuView.ItemView itemView) {
        return (itemView == null || !itemView.prefersCondensedTitle()) ? getTitle() : getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        this.mMenu.onItemsChanged(false);
        if (this.Jk != null) {
            this.Jk.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.mMenu.getContext().getString(i));
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.Hv != null ? this.Hv : this.mTitle;
        if (Build.VERSION.SDK_INT < 18 && charSequence != null && !(charSequence instanceof String)) {
            return charSequence.toString();
        }
        return charSequence;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.Hv = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.mTitle;
        }
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        if (this.Hy != null) {
            return this.Hy;
        }
        if (this.Hz != 0) {
            Drawable drawable = AppCompatResources.getDrawable(this.mMenu.getContext(), this.Hz);
            this.Hz = 0;
            this.Hy = drawable;
            return drawable;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.Hz = 0;
        this.Hy = drawable;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.Hy = null;
        this.Hz = i;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.mFlags & 1) == 1;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.mFlags;
        this.mFlags = (z ? 1 : 0) | (this.mFlags & (-2));
        if (i != this.mFlags) {
            this.mMenu.onItemsChanged(false);
        }
        return this;
    }

    public void setExclusiveCheckable(boolean z) {
        this.mFlags = (z ? 4 : 0) | (this.mFlags & (-5));
    }

    public boolean isExclusiveCheckable() {
        return (this.mFlags & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.mFlags & 2) == 2;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.mFlags & 4) != 0) {
            this.mMenu.c(this);
        } else {
            B(z);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(boolean z) {
        int i = this.mFlags;
        this.mFlags = (z ? 2 : 0) | (this.mFlags & (-3));
        if (i != this.mFlags) {
            this.mMenu.onItemsChanged(false);
        }
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.Jo == null || !this.Jo.overridesItemVisibility()) ? (this.mFlags & 8) == 0 : (this.mFlags & 8) == 0 && this.Jo.isVisible();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C(boolean z) {
        int i = this.mFlags;
        this.mFlags = (z ? 0 : 8) | (this.mFlags & (-9));
        return i != this.mFlags;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (C(z)) {
            this.mMenu.a(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.HA = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        if (this.mTitle != null) {
            return this.mTitle.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.Jr = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.Jr;
    }

    public void actionFormatChanged() {
        this.mMenu.b(this);
    }

    public boolean shouldShowIcon() {
        return this.mMenu.eW();
    }

    public boolean isActionButton() {
        return (this.mFlags & 32) == 32;
    }

    public boolean requestsActionButton() {
        return (this.Jm & 1) == 1;
    }

    public boolean requiresActionButton() {
        return (this.Jm & 2) == 2;
    }

    public void setIsActionButton(boolean z) {
        if (z) {
            this.mFlags |= 32;
        } else {
            this.mFlags &= -33;
        }
    }

    public boolean showsTextAsAction() {
        return (this.Jm & 4) == 4;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.Jm = i;
                this.mMenu.b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(View view) {
        this.Jn = view;
        this.Jo = null;
        if (view != null && view.getId() == -1 && this.mId > 0) {
            view.setId(this.mId);
        }
        this.mMenu.b(this);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(int i) {
        Context context = this.mMenu.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        if (this.Jn != null) {
            return this.Jn;
        }
        if (this.Jo != null) {
            this.Jn = this.Jo.onCreateActionView(this);
            return this.Jn;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    public ActionProvider getSupportActionProvider() {
        return this.Jo;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        if (this.Jo != null) {
            this.Jo.reset();
        }
        this.Jn = null;
        this.Jo = actionProvider;
        this.mMenu.onItemsChanged(true);
        if (this.Jo != null) {
            this.Jo.setVisibilityListener(new ActionProvider.VisibilityListener() { // from class: android.support.v7.view.menu.MenuItemImpl.1
                @Override // android.support.v4.view.ActionProvider.VisibilityListener
                public void onActionProviderVisibilityChanged(boolean z) {
                    MenuItemImpl.this.mMenu.a(MenuItemImpl.this);
                }
            });
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (hasCollapsibleActionView()) {
            if (this.Jp == null || this.Jp.onMenuItemActionExpand(this)) {
                return this.mMenu.expandItemActionView(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.Jm & 8) == 0) {
            return false;
        }
        if (this.Jn == null) {
            return true;
        }
        if (this.Jp == null || this.Jp.onMenuItemActionCollapse(this)) {
            return this.mMenu.collapseItemActionView(this);
        }
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener onActionExpandListener) {
        this.Jp = onActionExpandListener;
        return this;
    }

    public boolean hasCollapsibleActionView() {
        if ((this.Jm & 8) != 0) {
            if (this.Jn == null && this.Jo != null) {
                this.Jn = this.Jo.onCreateActionView(this);
            }
            return this.Jn != null;
        }
        return false;
    }

    public void setActionViewExpanded(boolean z) {
        this.Jq = z;
        this.mMenu.onItemsChanged(false);
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.Jq;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}
