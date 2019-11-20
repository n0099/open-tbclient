package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes6.dex */
public class b implements a {
    private a alp;
    private AbsHListView alq;

    public b(AbsHListView absHListView) {
        this.alq = absHListView;
    }

    public void a(a aVar) {
        this.alp = aVar;
    }

    public boolean uT() {
        return this.alp != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.alp.onCreateActionMode(actionMode, menu)) {
            this.alq.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.alp.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.alp.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.alp.onDestroyActionMode(actionMode);
        this.alq.mChoiceActionMode = null;
        this.alq.clearChoices();
        this.alq.mDataChanged = true;
        this.alq.rememberSyncState();
        this.alq.requestLayout();
        this.alq.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.alp.a(actionMode, i, j, z);
        if (this.alq.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
