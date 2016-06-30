package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DataSetObserver {
    final /* synthetic */ e yO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.yO = eVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        e.a aVar;
        e.a aVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.yO.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.yO.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        aVar = this.yO.yN;
        if (aVar != null) {
            aVar2 = this.yO.yN;
            aVar2.jy();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.yO.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.yO.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
