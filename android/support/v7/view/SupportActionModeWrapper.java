package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
@TargetApi(11)
@RestrictTo
/* loaded from: classes2.dex */
public class SupportActionModeWrapper extends android.view.ActionMode {
    final ActionMode GC;
    final Context mContext;

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.mContext = context;
        this.GC = actionMode;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.GC.getTag();
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.GC.setTag(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.GC.setTitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.GC.setSubtitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.GC.invalidate();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.GC.finish();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu) this.GC.getMenu());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.GC.getTitle();
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.GC.setTitle(i);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.GC.getSubtitle();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.GC.setSubtitle(i);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.GC.getCustomView();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.GC.setCustomView(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.GC.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.GC.getTitleOptionalHint();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.GC.setTitleOptionalHint(z);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.GC.isTitleOptional();
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class CallbackWrapper implements ActionMode.Callback {
        final ActionMode.Callback GD;
        final ArrayList<SupportActionModeWrapper> GE = new ArrayList<>();
        final SimpleArrayMap<Menu, Menu> GF = new SimpleArrayMap<>();
        final Context mContext;

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.mContext = context;
            this.GD = callback;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.GD.onCreateActionMode(getActionModeWrapper(actionMode), d(menu));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.GD.onPrepareActionMode(getActionModeWrapper(actionMode), d(menu));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.GD.onActionItemClicked(getActionModeWrapper(actionMode), MenuWrapperFactory.wrapSupportMenuItem(this.mContext, (SupportMenuItem) menuItem));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.GD.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        private Menu d(Menu menu) {
            Menu menu2 = this.GF.get(menu);
            if (menu2 == null) {
                Menu wrapSupportMenu = MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu) menu);
                this.GF.put(menu, wrapSupportMenu);
                return wrapSupportMenu;
            }
            return menu2;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
            int size = this.GE.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = this.GE.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.GC == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.mContext, actionMode);
            this.GE.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }
    }
}
