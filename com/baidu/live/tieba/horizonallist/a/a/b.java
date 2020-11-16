package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes4.dex */
public class b implements a {
    private a byj;
    private AbsHListView byk;

    public b(AbsHListView absHListView) {
        this.byk = absHListView;
    }

    public void a(a aVar) {
        this.byj = aVar;
    }

    public boolean Sk() {
        return this.byj != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.byj.onCreateActionMode(actionMode, menu)) {
            this.byk.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.byj.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.byj.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.byj.onDestroyActionMode(actionMode);
        this.byk.mChoiceActionMode = null;
        this.byk.clearChoices();
        this.byk.mDataChanged = true;
        this.byk.rememberSyncState();
        this.byk.requestLayout();
        this.byk.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.byj.a(actionMode, i, j, z);
        if (this.byk.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
