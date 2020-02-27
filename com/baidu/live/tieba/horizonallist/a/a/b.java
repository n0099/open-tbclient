package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes3.dex */
public class b implements a {
    private a ays;
    private AbsHListView ayt;

    public b(AbsHListView absHListView) {
        this.ayt = absHListView;
    }

    public void a(a aVar) {
        this.ays = aVar;
    }

    public boolean zz() {
        return this.ays != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.ays.onCreateActionMode(actionMode, menu)) {
            this.ayt.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.ays.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.ays.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.ays.onDestroyActionMode(actionMode);
        this.ayt.mChoiceActionMode = null;
        this.ayt.clearChoices();
        this.ayt.mDataChanged = true;
        this.ayt.rememberSyncState();
        this.ayt.requestLayout();
        this.ayt.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.ays.a(actionMode, i, j, z);
        if (this.ayt.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
