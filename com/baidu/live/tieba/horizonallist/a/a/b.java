package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes3.dex */
public class b implements a {
    private a ayu;
    private AbsHListView ayv;

    public b(AbsHListView absHListView) {
        this.ayv = absHListView;
    }

    public void a(a aVar) {
        this.ayu = aVar;
    }

    public boolean zB() {
        return this.ayu != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.ayu.onCreateActionMode(actionMode, menu)) {
            this.ayv.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.ayu.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.ayu.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.ayu.onDestroyActionMode(actionMode);
        this.ayv.mChoiceActionMode = null;
        this.ayv.clearChoices();
        this.ayv.mDataChanged = true;
        this.ayv.rememberSyncState();
        this.ayv.requestLayout();
        this.ayv.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.ayu.a(actionMode, i, j, z);
        if (this.ayv.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
