package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes6.dex */
public class b implements a {
    private a alH;
    private AbsHListView alI;

    public b(AbsHListView absHListView) {
        this.alI = absHListView;
    }

    public void a(a aVar) {
        this.alH = aVar;
    }

    public boolean uS() {
        return this.alH != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.alH.onCreateActionMode(actionMode, menu)) {
            this.alI.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.alH.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.alH.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.alH.onDestroyActionMode(actionMode);
        this.alI.mChoiceActionMode = null;
        this.alI.clearChoices();
        this.alI.mDataChanged = true;
        this.alI.rememberSyncState();
        this.alI.requestLayout();
        this.alI.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.alH.a(actionMode, i, j, z);
        if (this.alI.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
