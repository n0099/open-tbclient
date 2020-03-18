package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes3.dex */
public class b implements a {
    private a ayI;
    private AbsHListView ayJ;

    public b(AbsHListView absHListView) {
        this.ayJ = absHListView;
    }

    public void a(a aVar) {
        this.ayI = aVar;
    }

    public boolean zI() {
        return this.ayI != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.ayI.onCreateActionMode(actionMode, menu)) {
            this.ayJ.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.ayI.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.ayI.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.ayI.onDestroyActionMode(actionMode);
        this.ayJ.mChoiceActionMode = null;
        this.ayJ.clearChoices();
        this.ayJ.mDataChanged = true;
        this.ayJ.rememberSyncState();
        this.ayJ.requestLayout();
        this.ayJ.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.ayI.a(actionMode, i, j, z);
        if (this.ayJ.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
