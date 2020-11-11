package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes4.dex */
public class b implements a {
    private a bzU;
    private AbsHListView bzV;

    public b(AbsHListView absHListView) {
        this.bzV = absHListView;
    }

    public void a(a aVar) {
        this.bzU = aVar;
    }

    public boolean ST() {
        return this.bzU != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.bzU.onCreateActionMode(actionMode, menu)) {
            this.bzV.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.bzU.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.bzU.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.bzU.onDestroyActionMode(actionMode);
        this.bzV.mChoiceActionMode = null;
        this.bzV.clearChoices();
        this.bzV.mDataChanged = true;
        this.bzV.rememberSyncState();
        this.bzV.requestLayout();
        this.bzV.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.bzU.a(actionMode, i, j, z);
        if (this.bzV.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
