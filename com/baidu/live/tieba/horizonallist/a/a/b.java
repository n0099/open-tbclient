package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes4.dex */
public class b implements a {
    private a brC;
    private AbsHListView brD;

    public b(AbsHListView absHListView) {
        this.brD = absHListView;
    }

    public void a(a aVar) {
        this.brC = aVar;
    }

    public boolean Pq() {
        return this.brC != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.brC.onCreateActionMode(actionMode, menu)) {
            this.brD.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.brC.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.brC.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.brC.onDestroyActionMode(actionMode);
        this.brD.mChoiceActionMode = null;
        this.brD.clearChoices();
        this.brD.mDataChanged = true;
        this.brD.rememberSyncState();
        this.brD.requestLayout();
        this.brD.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.brC.a(actionMode, i, j, z);
        if (this.brD.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
