package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes11.dex */
public class b implements a {
    private a bId;
    private AbsHListView bIe;

    public b(AbsHListView absHListView) {
        this.bIe = absHListView;
    }

    public void a(a aVar) {
        this.bId = aVar;
    }

    public boolean VO() {
        return this.bId != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.bId.onCreateActionMode(actionMode, menu)) {
            this.bIe.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.bId.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.bId.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.bId.onDestroyActionMode(actionMode);
        this.bIe.mChoiceActionMode = null;
        this.bIe.clearChoices();
        this.bIe.mDataChanged = true;
        this.bIe.rememberSyncState();
        this.bIe.requestLayout();
        this.bIe.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.bId.a(actionMode, i, j, z);
        if (this.bIe.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
