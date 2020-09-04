package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes7.dex */
public class b implements a {
    private a bkW;
    private AbsHListView bkX;

    public b(AbsHListView absHListView) {
        this.bkX = absHListView;
    }

    public void a(a aVar) {
        this.bkW = aVar;
    }

    public boolean NI() {
        return this.bkW != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.bkW.onCreateActionMode(actionMode, menu)) {
            this.bkX.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.bkW.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.bkW.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.bkW.onDestroyActionMode(actionMode);
        this.bkX.mChoiceActionMode = null;
        this.bkX.clearChoices();
        this.bkX.mDataChanged = true;
        this.bkX.rememberSyncState();
        this.bkX.requestLayout();
        this.bkX.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.bkW.a(actionMode, i, j, z);
        if (this.bkX.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
