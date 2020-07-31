package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes4.dex */
public class b implements a {
    private a bfj;
    private AbsHListView bfk;

    public b(AbsHListView absHListView) {
        this.bfk = absHListView;
    }

    public void a(a aVar) {
        this.bfj = aVar;
    }

    public boolean HP() {
        return this.bfj != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.bfj.onCreateActionMode(actionMode, menu)) {
            this.bfk.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.bfj.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.bfj.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.bfj.onDestroyActionMode(actionMode);
        this.bfk.mChoiceActionMode = null;
        this.bfk.clearChoices();
        this.bfk.mDataChanged = true;
        this.bfk.rememberSyncState();
        this.bfk.requestLayout();
        this.bfk.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.bfj.a(actionMode, i, j, z);
        if (this.bfk.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
