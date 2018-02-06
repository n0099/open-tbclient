package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class m extends ActionBar {
    DecorToolbar DO;
    boolean DP;
    Window.Callback DQ;
    private boolean DR;
    private boolean DS;
    private ListMenuPresenter DU;
    private ArrayList<ActionBar.OnMenuVisibilityListener> DT = new ArrayList<>();
    private final Runnable DV = new Runnable() { // from class: android.support.v7.app.m.1
        @Override // java.lang.Runnable
        public void run() {
            m.this.el();
        }
    };
    private final Toolbar.OnMenuItemClickListener DW = new Toolbar.OnMenuItemClickListener() { // from class: android.support.v7.app.m.2
        @Override // android.support.v7.widget.Toolbar.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return m.this.DQ.onMenuItemSelected(0, menuItem);
        }
    };

    public m(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.DO = new ToolbarWidgetWrapper(toolbar, false);
        this.DQ = new d(callback);
        this.DO.setWindowCallback(this.DQ);
        toolbar.setOnMenuItemClickListener(this.DW);
        this.DO.setWindowTitle(charSequence);
    }

    public Window.Callback ek() {
        return this.DQ;
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view) {
        setCustomView(view, new ActionBar.LayoutParams(-2, -2));
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.DO.setCustomView(view);
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(this.DO.getContext()).inflate(i, this.DO.getViewGroup(), false));
    }

    @Override // android.support.v7.app.ActionBar
    public void setIcon(int i) {
        this.DO.setIcon(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setIcon(Drawable drawable) {
        this.DO.setIcon(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(int i) {
        this.DO.setLogo(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(Drawable drawable) {
        this.DO.setLogo(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeButtonEnabled(boolean z) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setElevation(float f) {
        ViewCompat.setElevation(this.DO.getViewGroup(), f);
    }

    @Override // android.support.v7.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.DO.getViewGroup());
    }

    @Override // android.support.v7.app.ActionBar
    public Context getThemedContext() {
        return this.DO.getContext();
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(Drawable drawable) {
        this.DO.setNavigationIcon(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(int i) {
        this.DO.setNavigationIcon(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.DO.setNavigationContentDescription(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(int i) {
        this.DO.setNavigationContentDescription(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z) {
    }

    @Override // android.support.v7.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v7.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.DO.setDropdownParams(spinnerAdapter, new h(onNavigationListener));
    }

    @Override // android.support.v7.app.ActionBar
    public void setSelectedNavigationItem(int i) {
        switch (this.DO.getNavigationMode()) {
            case 1:
                this.DO.setDropdownSelectedPosition(i);
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    @Override // android.support.v7.app.ActionBar
    public int getSelectedNavigationIndex() {
        return -1;
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationItemCount() {
        return 0;
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(CharSequence charSequence) {
        this.DO.setTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(int i) {
        this.DO.setTitle(i != 0 ? this.DO.getContext().getText(i) : null);
    }

    @Override // android.support.v7.app.ActionBar
    public void setWindowTitle(CharSequence charSequence) {
        this.DO.setWindowTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean requestFocus() {
        ViewGroup viewGroup = this.DO.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public void setSubtitle(CharSequence charSequence) {
        this.DO.setSubtitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setSubtitle(int i) {
        this.DO.setSubtitle(i != 0 ? this.DO.getContext().getText(i) : null);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int i) {
        setDisplayOptions(i, -1);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int i, int i2) {
        this.DO.setDisplayOptions((this.DO.getDisplayOptions() & (i2 ^ (-1))) | (i & i2));
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? 1 : 0, 1);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : 0, 2);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? 8 : 0, 8);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? 16 : 0, 16);
    }

    @Override // android.support.v7.app.ActionBar
    public void setBackgroundDrawable(Drawable drawable) {
        this.DO.setBackgroundDrawable(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public View getCustomView() {
        return this.DO.getCustomView();
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getTitle() {
        return this.DO.getTitle();
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getSubtitle() {
        return this.DO.getSubtitle();
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationMode() {
        return 0;
    }

    @Override // android.support.v7.app.ActionBar
    public void setNavigationMode(int i) {
        if (i == 2) {
            throw new IllegalArgumentException("Tabs not supported in this configuration");
        }
        this.DO.setNavigationMode(i);
    }

    @Override // android.support.v7.app.ActionBar
    public int getDisplayOptions() {
        return this.DO.getDisplayOptions();
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void removeTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void removeTabAt(int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void selectTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab getTabAt(int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public int getTabCount() {
        return 0;
    }

    @Override // android.support.v7.app.ActionBar
    public int getHeight() {
        return this.DO.getHeight();
    }

    @Override // android.support.v7.app.ActionBar
    public void show() {
        this.DO.setVisibility(0);
    }

    @Override // android.support.v7.app.ActionBar
    public void hide() {
        this.DO.setVisibility(8);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isShowing() {
        return this.DO.getVisibility() == 0;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean openOptionsMenu() {
        return this.DO.showOverflowMenu();
    }

    @Override // android.support.v7.app.ActionBar
    public boolean invalidateOptionsMenu() {
        this.DO.getViewGroup().removeCallbacks(this.DV);
        ViewCompat.postOnAnimation(this.DO.getViewGroup(), this.DV);
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean collapseActionView() {
        if (this.DO.hasExpandedActionView()) {
            this.DO.collapseActionView();
            return true;
        }
        return false;
    }

    void el() {
        Menu menu = getMenu();
        MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
        if (menuBuilder != null) {
            menuBuilder.stopDispatchingItemsChanged();
        }
        try {
            menu.clear();
            if (!this.DQ.onCreatePanelMenu(0, menu) || !this.DQ.onPreparePanel(0, null, menu)) {
                menu.clear();
            }
        } finally {
            if (menuBuilder != null) {
                menuBuilder.startDispatchingItemsChanged();
            }
        }
    }

    @Override // android.support.v7.app.ActionBar
    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu menu = getMenu();
        if (menu != null) {
            menu.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            menu.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBar
    public void onDestroy() {
        this.DO.getViewGroup().removeCallbacks(this.DV);
    }

    @Override // android.support.v7.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.DT.add(onMenuVisibilityListener);
    }

    @Override // android.support.v7.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.DT.remove(onMenuVisibilityListener);
    }

    @Override // android.support.v7.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.DS) {
            this.DS = z;
            int size = this.DT.size();
            for (int i = 0; i < size; i++) {
                this.DT.get(i).onMenuVisibilityChanged(z);
            }
        }
    }

    View b(Menu menu) {
        c(menu);
        if (menu == null || this.DU == null || this.DU.getAdapter().getCount() <= 0) {
            return null;
        }
        return (View) this.DU.getMenuView(this.DO.getViewGroup());
    }

    private void c(Menu menu) {
        if (this.DU == null && (menu instanceof MenuBuilder)) {
            MenuBuilder menuBuilder = (MenuBuilder) menu;
            Context context = this.DO.getContext();
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.DU = new ListMenuPresenter(contextThemeWrapper, R.layout.abc_list_menu_item_layout);
            this.DU.setCallback(new c());
            menuBuilder.addMenuPresenter(this.DU);
        }
    }

    /* loaded from: classes2.dex */
    private class d extends WindowCallbackWrapper {
        public d(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !m.this.DP) {
                m.this.DO.setMenuPrepared();
                m.this.DP = true;
            }
            return onPreparePanel;
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            switch (i) {
                case 0:
                    Menu menu = m.this.DO.getMenu();
                    if (onPreparePanel(i, null, menu) && onMenuOpened(i, menu)) {
                        return m.this.b(menu);
                    }
                    break;
            }
            return super.onCreatePanelView(i);
        }
    }

    private Menu getMenu() {
        if (!this.DR) {
            this.DO.setMenuCallbacks(new a(), new b());
            this.DR = true;
        }
        return this.DO.getMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class a implements MenuPresenter.Callback {
        private boolean Df;

        a() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (m.this.DQ != null) {
                m.this.DQ.onMenuOpened(108, menuBuilder);
                return true;
            }
            return false;
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (!this.Df) {
                this.Df = true;
                m.this.DO.dismissPopupMenus();
                if (m.this.DQ != null) {
                    m.this.DQ.onPanelClosed(108, menuBuilder);
                }
                this.Df = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class c implements MenuPresenter.Callback {
        c() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (m.this.DQ != null) {
                m.this.DQ.onPanelClosed(0, menuBuilder);
            }
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder == null && m.this.DQ != null) {
                m.this.DQ.onMenuOpened(0, menuBuilder);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class b implements MenuBuilder.Callback {
        b() {
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (m.this.DQ != null) {
                if (m.this.DO.isOverflowMenuShowing()) {
                    m.this.DQ.onPanelClosed(108, menuBuilder);
                } else if (m.this.DQ.onPreparePanel(0, null, menuBuilder)) {
                    m.this.DQ.onMenuOpened(108, menuBuilder);
                }
            }
        }
    }
}
