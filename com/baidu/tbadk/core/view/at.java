package com.baidu.tbadk.core.view;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements AbsListView.RecyclerListener {
    private int mId;

    public at(int i) {
        this.mId = 0;
        this.mId = i;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(this.mId);
        if (findViewById != null && (findViewById instanceof UserPhotoLayout)) {
            ((UserPhotoLayout) findViewById).reset();
        }
    }
}
