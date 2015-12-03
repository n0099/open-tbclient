package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DataSetObserver {
    final /* synthetic */ e HN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.HN = eVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        e.a aVar;
        e.a aVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.HN.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.HN.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        aVar = this.HN.HM;
        if (aVar != null) {
            aVar2 = this.HN.HM;
            aVar2.nB();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.HN.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.HN.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
