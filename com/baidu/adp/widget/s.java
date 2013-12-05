package com.baidu.adp.widget;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PinnedHeaderListView f616a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PinnedHeaderListView pinnedHeaderListView) {
        this.f616a = pinnedHeaderListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f616a.requestLayout();
        this.f616a.invalidate();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f616a.h = -1;
        this.f616a.requestLayout();
        this.f616a.invalidate();
    }
}
