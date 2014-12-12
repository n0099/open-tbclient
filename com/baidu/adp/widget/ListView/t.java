package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdListView xm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(BdListView bdListView) {
        this.xm = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        k kVar;
        k kVar2;
        i iVar;
        x xVar;
        x xVar2;
        i iVar2;
        i iVar3;
        AdapterView.OnItemClickListener onItemClickListener;
        AdapterView.OnItemClickListener onItemClickListener2;
        i iVar4;
        y yVar;
        y yVar2;
        i iVar5;
        i iVar6;
        kVar = this.xm.wN;
        int headersCount = kVar.getHeadersCount();
        if (i < headersCount) {
            iVar4 = this.xm.xb;
            if (iVar4 != null) {
                iVar5 = this.xm.xb;
                if (view == iVar5.getView()) {
                    iVar6 = this.xm.xb;
                    iVar6.onClick();
                    return;
                }
            }
            yVar = this.xm.wR;
            if (yVar != null) {
                yVar2 = this.xm.wR;
                yVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - headersCount;
        kVar2 = this.xm.wN;
        ListAdapter wrappedAdapter = kVar2.getWrappedAdapter();
        if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
            onItemClickListener = this.xm.wO;
            if (onItemClickListener != null) {
                onItemClickListener2 = this.xm.wO;
                onItemClickListener2.onItemClick(adapterView, view, i2, j);
                return;
            }
            return;
        }
        iVar = this.xm.xc;
        if (iVar != null) {
            iVar2 = this.xm.xc;
            if (view == iVar2.getView()) {
                iVar3 = this.xm.xc;
                iVar3.onClick();
                return;
            }
        }
        xVar = this.xm.wS;
        if (xVar != null) {
            xVar2 = this.xm.wS;
            xVar2.onClick(view);
        }
    }
}
