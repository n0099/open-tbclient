package android.support.v7.view;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;
@RestrictTo
/* loaded from: classes2.dex */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {
    private ActionMode.Callback EN;
    private WeakReference<View> EO;
    private ActionBarContextView Eq;
    private Context mContext;
    private boolean mFinished;
    private boolean mFocusable;
    private MenuBuilder mMenu;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z) {
        this.mContext = context;
        this.Eq = actionBarContextView;
        this.EN = callback;
        this.mMenu = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.mMenu.setCallback(this);
        this.mFocusable = z;
    }

    @Override // android.support.v7.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.Eq.setTitle(charSequence);
    }

    @Override // android.support.v7.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.Eq.setSubtitle(charSequence);
    }

    @Override // android.support.v7.view.ActionMode
    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    @Override // android.support.v7.view.ActionMode
    public void setSubtitle(int i) {
        setSubtitle(this.mContext.getString(i));
    }

    @Override // android.support.v7.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.Eq.setTitleOptional(z);
    }

    @Override // android.support.v7.view.ActionMode
    public boolean isTitleOptional() {
        return this.Eq.isTitleOptional();
    }

    @Override // android.support.v7.view.ActionMode
    public void setCustomView(View view) {
        this.Eq.setCustomView(view);
        this.EO = view != null ? new WeakReference<>(view) : null;
    }

    @Override // android.support.v7.view.ActionMode
    public void invalidate() {
        this.EN.onPrepareActionMode(this, this.mMenu);
    }

    @Override // android.support.v7.view.ActionMode
    public void finish() {
        if (!this.mFinished) {
            this.mFinished = true;
            this.Eq.sendAccessibilityEvent(32);
            this.EN.onDestroyActionMode(this);
        }
    }

    @Override // android.support.v7.view.ActionMode
    public Menu getMenu() {
        return this.mMenu;
    }

    @Override // android.support.v7.view.ActionMode
    public CharSequence getTitle() {
        return this.Eq.getTitle();
    }

    @Override // android.support.v7.view.ActionMode
    public CharSequence getSubtitle() {
        return this.Eq.getSubtitle();
    }

    @Override // android.support.v7.view.ActionMode
    public View getCustomView() {
        if (this.EO != null) {
            return this.EO.get();
        }
        return null;
    }

    @Override // android.support.v7.view.ActionMode
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.Eq.getContext());
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.EN.onActionItemClicked(this, menuItem);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            new MenuPopupHelper(this.Eq.getContext(), subMenuBuilder).show();
        }
        return true;
    }

    public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        invalidate();
        this.Eq.showOverflowMenu();
    }

    @Override // android.support.v7.view.ActionMode
    public boolean isUiFocusable() {
        return this.mFocusable;
    }
}
