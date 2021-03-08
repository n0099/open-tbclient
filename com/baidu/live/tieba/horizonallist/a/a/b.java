package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes10.dex */
public class b implements a {
    private a bIB;
    private AbsHListView bIC;

    public b(AbsHListView absHListView) {
        this.bIC = absHListView;
    }

    public void a(a aVar) {
        this.bIB = aVar;
    }

    public boolean TF() {
        return this.bIB != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.bIB.onCreateActionMode(actionMode, menu)) {
            this.bIC.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.bIB.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.bIB.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.bIB.onDestroyActionMode(actionMode);
        this.bIC.mChoiceActionMode = null;
        this.bIC.clearChoices();
        this.bIC.mDataChanged = true;
        this.bIC.rememberSyncState();
        this.bIC.requestLayout();
        this.bIC.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.bIB.a(actionMode, i, j, z);
        if (this.bIC.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
