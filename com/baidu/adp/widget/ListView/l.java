package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends DataSetObserver {
    final /* synthetic */ k wM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.wM = kVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        m mVar;
        m mVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.wM.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.wM.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        mVar = this.wM.wL;
        if (mVar != null) {
            mVar2 = this.wM.wL;
            mVar2.jG();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.wM.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.wM.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
