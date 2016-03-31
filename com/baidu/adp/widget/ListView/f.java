package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DataSetObserver {
    final /* synthetic */ e Iw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Iw = eVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        e.a aVar;
        e.a aVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.Iw.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.Iw.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        aVar = this.Iw.Iv;
        if (aVar != null) {
            aVar2 = this.Iw.Iv;
            aVar2.nh();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.Iw.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.Iw.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
