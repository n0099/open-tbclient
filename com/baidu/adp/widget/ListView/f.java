package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DataSetObserver {
    final /* synthetic */ e Ie;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Ie = eVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        e.a aVar;
        e.a aVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.Ie.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.Ie.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        aVar = this.Ie.Id;
        if (aVar != null) {
            aVar2 = this.Ie.Id;
            aVar2.lm();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.Ie.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.Ie.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
