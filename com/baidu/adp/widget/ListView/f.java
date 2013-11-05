package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f566a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f566a = eVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.f566a.g;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.f566a.g;
            dataSetObserver2.onChanged();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.f566a.g;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.f566a.g;
            dataSetObserver2.onInvalidated();
        }
    }
}
