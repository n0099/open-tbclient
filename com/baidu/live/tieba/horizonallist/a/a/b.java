package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes2.dex */
public class b implements a {
    private a atq;
    private AbsHListView atr;

    public b(AbsHListView absHListView) {
        this.atr = absHListView;
    }

    public void a(a aVar) {
        this.atq = aVar;
    }

    public boolean wS() {
        return this.atq != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.atq.onCreateActionMode(actionMode, menu)) {
            this.atr.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.atq.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.atq.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.atq.onDestroyActionMode(actionMode);
        this.atr.mChoiceActionMode = null;
        this.atr.clearChoices();
        this.atr.mDataChanged = true;
        this.atr.rememberSyncState();
        this.atr.requestLayout();
        this.atr.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.atq.a(actionMode, i, j, z);
        if (this.atr.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
