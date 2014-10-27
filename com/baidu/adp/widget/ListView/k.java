package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends DataSetObserver {
    final /* synthetic */ j uF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.uF = jVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        l lVar;
        l lVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.uF.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.uF.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        lVar = this.uF.uE;
        if (lVar != null) {
            lVar2 = this.uF.uE;
            lVar2.hL();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.uF.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.uF.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
