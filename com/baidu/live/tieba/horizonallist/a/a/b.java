package com.baidu.live.tieba.horizonallist.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
/* loaded from: classes3.dex */
public class b implements a {
    private a aZI;
    private AbsHListView aZJ;

    public b(AbsHListView absHListView) {
        this.aZJ = absHListView;
    }

    public void a(a aVar) {
        this.aZI = aVar;
    }

    public boolean Gw() {
        return this.aZI != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.aZI.onCreateActionMode(actionMode, menu)) {
            this.aZJ.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.aZI.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.aZI.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.aZI.onDestroyActionMode(actionMode);
        this.aZJ.mChoiceActionMode = null;
        this.aZJ.clearChoices();
        this.aZJ.mDataChanged = true;
        this.aZJ.rememberSyncState();
        this.aZJ.requestLayout();
        this.aZJ.setLongClickable(true);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.aZI.a(actionMode, i, j, z);
        if (this.aZJ.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }
}
