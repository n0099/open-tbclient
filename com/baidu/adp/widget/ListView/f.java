package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DataSetObserver {
    final /* synthetic */ e Bq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Bq = eVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        e.a aVar;
        e.a aVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.Bq.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.Bq.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        aVar = this.Bq.Bp;
        if (aVar != null) {
            aVar2 = this.Bq.Bp;
            aVar2.ko();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.Bq.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.Bq.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
