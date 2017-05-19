package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DataSetObserver {
    final /* synthetic */ e Ig;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Ig = eVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        e.a aVar;
        e.a aVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.Ig.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.Ig.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        aVar = this.Ig.If;
        if (aVar != null) {
            aVar2 = this.Ig.If;
            aVar2.lm();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.Ig.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.Ig.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
