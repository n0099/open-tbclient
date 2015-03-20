package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends DataSetObserver {
    final /* synthetic */ g HB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.HB = gVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        i iVar;
        i iVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.HB.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.HB.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        iVar = this.HB.HA;
        if (iVar != null) {
            iVar2 = this.HB.HA;
            iVar2.mU();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.HB.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.HB.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
