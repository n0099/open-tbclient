package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DataSetObserver {
    final /* synthetic */ e IE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.IE = eVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        e.a aVar;
        e.a aVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.IE.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.IE.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        aVar = this.IE.IC;
        if (aVar != null) {
            aVar2 = this.IE.IC;
            aVar2.li();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.IE.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.IE.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
