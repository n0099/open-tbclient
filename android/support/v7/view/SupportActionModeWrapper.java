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
    final ActionMode GD;
    final Context mContext;

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.mContext = context;
        this.GD = actionMode;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.GD.getTag();
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.GD.setTag(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.GD.setTitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.GD.setSubtitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.GD.invalidate();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.GD.finish();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu) this.GD.getMenu());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.GD.getTitle();
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.GD.setTitle(i);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.GD.getSubtitle();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.GD.setSubtitle(i);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.GD.getCustomView();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.GD.setCustomView(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.GD.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.GD.getTitleOptionalHint();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.GD.setTitleOptionalHint(z);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.GD.isTitleOptional();
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class CallbackWrapper implements ActionMode.Callback {
        final ActionMode.Callback GE;
        final ArrayList<SupportActionModeWrapper> GF = new ArrayList<>();
        final SimpleArrayMap<Menu, Menu> GG = new SimpleArrayMap<>();
        final Context mContext;

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.mContext = context;
            this.GE = callback;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.GE.onCreateActionMode(getActionModeWrapper(actionMode), d(menu));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.GE.onPrepareActionMode(getActionModeWrapper(actionMode), d(menu));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.GE.onActionItemClicked(getActionModeWrapper(actionMode), MenuWrapperFactory.wrapSupportMenuItem(this.mContext, (SupportMenuItem) menuItem));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.GE.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        private Menu d(Menu menu) {
            Menu menu2 = this.GG.get(menu);
            if (menu2 == null) {
                Menu wrapSupportMenu = MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu) menu);
                this.GG.put(menu, wrapSupportMenu);
                return wrapSupportMenu;
            }
            return menu2;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
            int size = this.GF.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = this.GF.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.GD == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.mContext, actionMode);
            this.GF.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }
    }
}
