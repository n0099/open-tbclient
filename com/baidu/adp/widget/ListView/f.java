package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DataSetObserver {
    final /* synthetic */ e Hv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Hv = eVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        e.a aVar;
        e.a aVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.Hv.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.Hv.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        aVar = this.Hv.Hu;
        if (aVar != null) {
            aVar2 = this.Hv.Hu;
            aVar2.nu();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.Hv.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.Hv.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
