package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends DataSetObserver {
    final /* synthetic */ k wJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.wJ = kVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        m mVar;
        m mVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.wJ.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.wJ.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        mVar = this.wJ.wI;
        if (mVar != null) {
            mVar2 = this.wJ.wI;
            mVar2.jz();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.wJ.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.wJ.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
