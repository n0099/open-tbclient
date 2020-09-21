package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes4.dex */
public class b implements a {
    private a bnP;
    private AbsHListView bnQ;

    public b(AbsHListView absHListView) {
        this.bnQ = absHListView;
    }

    public void a(a aVar) {
        this.bnP = aVar;
    }

    public boolean Ol() {
        return this.bnP != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.bnP.onCreateActionMode(actionMode, menu)) {
            this.bnQ.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.bnP.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.bnP.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.bnP.onDestroyActionMode(actionMode);
        this.bnQ.mChoiceActionMode = null;
        this.bnQ.clearChoices();
        this.bnQ.mDataChanged = true;
        this.bnQ.rememberSyncState();
        this.bnQ.requestLayout();
        this.bnQ.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.bnP.a(actionMode, i, j, z);
        if (this.bnQ.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
