package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes2.dex */
public class b implements a {
    private a auc;
    private AbsHListView aud;

    public b(AbsHListView absHListView) {
        this.aud = absHListView;
    }

    public void a(a aVar) {
        this.auc = aVar;
    }

    public boolean xi() {
        return this.auc != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.auc.onCreateActionMode(actionMode, menu)) {
            this.aud.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.auc.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.auc.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.auc.onDestroyActionMode(actionMode);
        this.aud.mChoiceActionMode = null;
        this.aud.clearChoices();
        this.aud.mDataChanged = true;
        this.aud.rememberSyncState();
        this.aud.requestLayout();
        this.aud.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.auc.a(actionMode, i, j, z);
        if (this.aud.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
