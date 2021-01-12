package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes10.dex */
public class b implements a {
    private a bDr;
    private AbsHListView bDs;

    public b(AbsHListView absHListView) {
        this.bDs = absHListView;
    }

    public void a(a aVar) {
        this.bDr = aVar;
    }

    public boolean RV() {
        return this.bDr != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.bDr.onCreateActionMode(actionMode, menu)) {
            this.bDs.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.bDr.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.bDr.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.bDr.onDestroyActionMode(actionMode);
        this.bDs.mChoiceActionMode = null;
        this.bDs.clearChoices();
        this.bDs.mDataChanged = true;
        this.bDs.rememberSyncState();
        this.bDs.requestLayout();
        this.bDs.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.bDr.a(actionMode, i, j, z);
        if (this.bDs.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
