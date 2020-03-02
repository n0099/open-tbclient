package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes3.dex */
public class b implements a {
    private a ayt;
    private AbsHListView ayu;

    public b(AbsHListView absHListView) {
        this.ayu = absHListView;
    }

    public void a(a aVar) {
        this.ayt = aVar;
    }

    public boolean zB() {
        return this.ayt != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.ayt.onCreateActionMode(actionMode, menu)) {
            this.ayu.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.ayt.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.ayt.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.ayt.onDestroyActionMode(actionMode);
        this.ayu.mChoiceActionMode = null;
        this.ayu.clearChoices();
        this.ayu.mDataChanged = true;
        this.ayu.rememberSyncState();
        this.ayu.requestLayout();
        this.ayu.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.ayt.a(actionMode, i, j, z);
        if (this.ayu.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
