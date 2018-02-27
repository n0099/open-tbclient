package android.support.v7.view;

import android.support.annotation.RestrictTo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class ActionMode {
    private boolean Gv;
    private Object rr;

    /* loaded from: classes2.dex */
    public interface Callback {
        boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem);

        boolean onCreateActionMode(ActionMode actionMode, Menu menu);

        void onDestroyActionMode(ActionMode actionMode);

        boolean onPrepareActionMode(ActionMode actionMode, Menu menu);
    }

    public abstract void finish();

    public abstract View getCustomView();

    public abstract Menu getMenu();

    public abstract MenuInflater getMenuInflater();

    public abstract CharSequence getSubtitle();

    public abstract CharSequence getTitle();

    public abstract void invalidate();

    public abstract void setCustomView(View view);

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(CharSequence charSequence);

    public abstract void setTitle(int i);

    public abstract void setTitle(CharSequence charSequence);

    public void setTag(Object obj) {
        this.rr = obj;
    }

    public Object getTag() {
        return this.rr;
    }

    public void setTitleOptionalHint(boolean z) {
        this.Gv = z;
    }

    public boolean getTitleOptionalHint() {
        return this.Gv;
    }

    public boolean isTitleOptional() {
        return false;
    }

    @RestrictTo
    public boolean isUiFocusable() {
        return true;
    }
}
