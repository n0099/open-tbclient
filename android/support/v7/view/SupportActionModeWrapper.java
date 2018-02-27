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
    final ActionMode Gx;
    final Context mContext;

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.mContext = context;
        this.Gx = actionMode;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.Gx.getTag();
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.Gx.setTag(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.Gx.setTitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.Gx.setSubtitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.Gx.invalidate();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.Gx.finish();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu) this.Gx.getMenu());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.Gx.getTitle();
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.Gx.setTitle(i);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.Gx.getSubtitle();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.Gx.setSubtitle(i);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.Gx.getCustomView();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.Gx.setCustomView(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.Gx.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.Gx.getTitleOptionalHint();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.Gx.setTitleOptionalHint(z);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.Gx.isTitleOptional();
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class CallbackWrapper implements ActionMode.Callback {
        final ActionMode.Callback Gy;
        final Context mContext;
        final ArrayList<SupportActionModeWrapper> Gz = new ArrayList<>();
        final SimpleArrayMap<Menu, Menu> GA = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.mContext = context;
            this.Gy = callback;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.Gy.onCreateActionMode(getActionModeWrapper(actionMode), d(menu));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.Gy.onPrepareActionMode(getActionModeWrapper(actionMode), d(menu));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.Gy.onActionItemClicked(getActionModeWrapper(actionMode), MenuWrapperFactory.wrapSupportMenuItem(this.mContext, (SupportMenuItem) menuItem));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.Gy.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        private Menu d(Menu menu) {
            Menu menu2 = this.GA.get(menu);
            if (menu2 == null) {
                Menu wrapSupportMenu = MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu) menu);
                this.GA.put(menu, wrapSupportMenu);
                return wrapSupportMenu;
            }
            return menu2;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
            int size = this.Gz.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = this.Gz.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.Gx == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.mContext, actionMode);
            this.Gz.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }
    }
}
