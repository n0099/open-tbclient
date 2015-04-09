package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends DataSetObserver {
    final /* synthetic */ g HD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.HD = gVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        i iVar;
        i iVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.HD.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.HD.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        iVar = this.HD.HC;
        if (iVar != null) {
            iVar2 = this.HD.HC;
            iVar2.mU();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.HD.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.HD.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
