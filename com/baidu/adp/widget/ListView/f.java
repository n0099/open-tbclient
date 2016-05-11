package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DataSetObserver {
    final /* synthetic */ e yP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.yP = eVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        e.a aVar;
        e.a aVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.yP.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.yP.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        aVar = this.yP.yO;
        if (aVar != null) {
            aVar2 = this.yP.yO;
            aVar2.jv();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.yP.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.yP.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
