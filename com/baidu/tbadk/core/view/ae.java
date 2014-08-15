package com.baidu.tbadk.core.view;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements AbsListView.RecyclerListener {
    private int a;

    public ae(int i) {
        this.a = 0;
        this.a = i;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(this.a);
        if (findViewById != null && (findViewById instanceof UserPhotoLayout)) {
            ((UserPhotoLayout) findViewById).a();
        }
    }
}
