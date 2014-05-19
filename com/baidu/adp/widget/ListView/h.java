package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends DataSetObserver {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.a.g;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.a.g;
            dataSetObserver2.onChanged();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.a.g;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.a.g;
            dataSetObserver2.onInvalidated();
        }
    }
}
