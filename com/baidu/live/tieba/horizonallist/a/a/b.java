package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes7.dex */
public class b implements a {
    private a bkT;
    private AbsHListView bkU;

    public b(AbsHListView absHListView) {
        this.bkU = absHListView;
    }

    public void a(a aVar) {
        this.bkT = aVar;
    }

    public boolean NI() {
        return this.bkT != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.bkT.onCreateActionMode(actionMode, menu)) {
            this.bkU.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.bkT.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.bkT.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.bkT.onDestroyActionMode(actionMode);
        this.bkU.mChoiceActionMode = null;
        this.bkU.clearChoices();
        this.bkU.mDataChanged = true;
        this.bkU.rememberSyncState();
        this.bkU.requestLayout();
        this.bkU.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.bkT.a(actionMode, i, j, z);
        if (this.bkU.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
