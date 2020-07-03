package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes3.dex */
public class b implements a {
    private a beP;
    private AbsHListView beQ;

    public b(AbsHListView absHListView) {
        this.beQ = absHListView;
    }

    public void a(a aVar) {
        this.beP = aVar;
    }

    public boolean HJ() {
        return this.beP != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.beP.onCreateActionMode(actionMode, menu)) {
            this.beQ.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.beP.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.beP.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.beP.onDestroyActionMode(actionMode);
        this.beQ.mChoiceActionMode = null;
        this.beQ.clearChoices();
        this.beQ.mDataChanged = true;
        this.beQ.rememberSyncState();
        this.beQ.requestLayout();
        this.beQ.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.beP.a(actionMode, i, j, z);
        if (this.beQ.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
