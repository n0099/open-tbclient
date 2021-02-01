package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes11.dex */
public class b implements a {
    private a bHb;
    private AbsHListView bHc;

    public b(AbsHListView absHListView) {
        this.bHc = absHListView;
    }

    public void a(a aVar) {
        this.bHb = aVar;
    }

    public boolean TC() {
        return this.bHb != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.bHb.onCreateActionMode(actionMode, menu)) {
            this.bHc.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.bHb.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.bHb.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.bHb.onDestroyActionMode(actionMode);
        this.bHc.mChoiceActionMode = null;
        this.bHc.clearChoices();
        this.bHc.mDataChanged = true;
        this.bHc.rememberSyncState();
        this.bHc.requestLayout();
        this.bHc.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.bHb.a(actionMode, i, j, z);
        if (this.bHc.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
