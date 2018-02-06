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
    private static String Jr;
    private static String Js;
    private static String Jt;
    private static String Ju;
    private final int Hr;
    private final int Hs;
    private final int Ht;
    private CharSequence Hu;
    private char Hv;
    private char Hw;
    private Drawable Hx;
    private MenuItem.OnMenuItemClickListener Hz;
    private SubMenuBuilder Jj;
    private Runnable Jk;
    private int Jl;
    private View Jm;
    private ActionProvider Jn;
    private MenuItemCompat.OnActionExpandListener Jo;
    private ContextMenu.ContextMenuInfo Jq;
    private final int mId;
    private Intent mIntent;
    MenuBuilder mMenu;
    private CharSequence mTitle;
    private int Hy = 0;
    private int mFlags = 16;
    private boolean Jp = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.Jl = 0;
        this.mMenu = menuBuilder;
        this.mId = i2;
        this.Hr = i;
        this.Hs = i3;
        this.Ht = i4;
        this.mTitle = charSequence;
        this.Jl = i5;
    }

    public boolean invoke() {
        if ((this.Hz == null || !this.Hz.onMenuItemClick(this)) && !this.mMenu.a(this.mMenu.getRootMenu(), this)) {
            if (this.Jk != null) {
                this.Jk.run();
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
            return this.Jn != null && this.Jn.onPerformDefaultAction();
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
        return this.Hr;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.mId;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.Hs;
    }

    public int getOrdering() {
        return this.Ht;
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
        this.Jk = runnable;
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.Hw;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.Hw != c) {
            this.Hw = Character.toLowerCase(c);
            this.mMenu.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.Hv;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.Hv != c) {
            this.Hv = c;
            this.mMenu.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.Hv = c;
        this.Hw = Character.toLowerCase(c2);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char eX() {
        return this.mMenu.isQwertyMode() ? this.Hw : this.Hv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String eY() {
        char eX = eX();
        if (eX == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(Jr);
        switch (eX) {
            case '\b':
                sb.append(Jt);
                break;
            case '\n':
                sb.append(Js);
                break;
            case ' ':
                sb.append(Ju);
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
        return this.Jj;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.Jj != null;
    }

    public void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.Jj = subMenuBuilder;
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
        if (this.Jj != null) {
            this.Jj.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.mMenu.getContext().getString(i));
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.Hu != null ? this.Hu : this.mTitle;
        if (Build.VERSION.SDK_INT < 18 && charSequence != null && !(charSequence instanceof String)) {
            return charSequence.toString();
        }
        return charSequence;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.Hu = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.mTitle;
        }
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        if (this.Hx != null) {
            return this.Hx;
        }
        if (this.Hy != 0) {
            Drawable drawable = AppCompatResources.getDrawable(this.mMenu.getContext(), this.Hy);
            this.Hy = 0;
            this.Hx = drawable;
            return drawable;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.Hy = 0;
        this.Hx = drawable;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.Hx = null;
        this.Hy = i;
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
            D(z);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(boolean z) {
        int i = this.mFlags;
        this.mFlags = (z ? 2 : 0) | (this.mFlags & (-3));
        if (i != this.mFlags) {
            this.mMenu.onItemsChanged(false);
        }
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.Jn == null || !this.Jn.overridesItemVisibility()) ? (this.mFlags & 8) == 0 : (this.mFlags & 8) == 0 && this.Jn.isVisible();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E(boolean z) {
        int i = this.mFlags;
        this.mFlags = (z ? 0 : 8) | (this.mFlags & (-9));
        return i != this.mFlags;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (E(z)) {
            this.mMenu.a(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.Hz = onMenuItemClickListener;
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
        this.Jq = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.Jq;
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
        return (this.Jl & 1) == 1;
    }

    public boolean requiresActionButton() {
        return (this.Jl & 2) == 2;
    }

    public void setIsActionButton(boolean z) {
        if (z) {
            this.mFlags |= 32;
        } else {
            this.mFlags &= -33;
        }
    }

    public boolean showsTextAsAction() {
        return (this.Jl & 4) == 4;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.Jl = i;
                this.mMenu.b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(View view) {
        this.Jm = view;
        this.Jn = null;
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
        if (this.Jm != null) {
            return this.Jm;
        }
        if (this.Jn != null) {
            this.Jm = this.Jn.onCreateActionView(this);
            return this.Jm;
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
        return this.Jn;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        if (this.Jn != null) {
            this.Jn.reset();
        }
        this.Jm = null;
        this.Jn = actionProvider;
        this.mMenu.onItemsChanged(true);
        if (this.Jn != null) {
            this.Jn.setVisibilityListener(new ActionProvider.VisibilityListener() { // from class: android.support.v7.view.menu.MenuItemImpl.1
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
            if (this.Jo == null || this.Jo.onMenuItemActionExpand(this)) {
                return this.mMenu.expandItemActionView(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.Jl & 8) == 0) {
            return false;
        }
        if (this.Jm == null) {
            return true;
        }
        if (this.Jo == null || this.Jo.onMenuItemActionCollapse(this)) {
            return this.mMenu.collapseItemActionView(this);
        }
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener onActionExpandListener) {
        this.Jo = onActionExpandListener;
        return this;
    }

    public boolean hasCollapsibleActionView() {
        if ((this.Jl & 8) != 0) {
            if (this.Jm == null && this.Jn != null) {
                this.Jm = this.Jn.onCreateActionView(this);
            }
            return this.Jm != null;
        }
        return false;
    }

    public void setActionViewExpanded(boolean z) {
        this.Jp = z;
        this.mMenu.onItemsChanged(false);
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.Jp;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}
