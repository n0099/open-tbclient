package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes3.dex */
public class b implements a {
    private a aSu;
    private AbsHListView aSv;

    public b(AbsHListView absHListView) {
        this.aSv = absHListView;
    }

    public void a(a aVar) {
        this.aSu = aVar;
    }

    public boolean EF() {
        return this.aSu != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.aSu.onCreateActionMode(actionMode, menu)) {
            this.aSv.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.aSu.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.aSu.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.aSu.onDestroyActionMode(actionMode);
        this.aSv.mChoiceActionMode = null;
        this.aSv.clearChoices();
        this.aSv.mDataChanged = true;
        this.aSv.rememberSyncState();
        this.aSv.requestLayout();
        this.aSv.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.aSu.a(actionMode, i, j, z);
        if (this.aSv.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
