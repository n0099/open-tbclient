package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdListView xj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(BdListView bdListView) {
        this.xj = bdListView;
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
        kVar = this.xj.wK;
        int headersCount = kVar.getHeadersCount();
        if (i < headersCount) {
            iVar4 = this.xj.wY;
            if (iVar4 != null) {
                iVar5 = this.xj.wY;
                if (view == iVar5.getView()) {
                    iVar6 = this.xj.wY;
                    iVar6.onClick();
                    return;
                }
            }
            yVar = this.xj.wO;
            if (yVar != null) {
                yVar2 = this.xj.wO;
                yVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - headersCount;
        kVar2 = this.xj.wK;
        ListAdapter wrappedAdapter = kVar2.getWrappedAdapter();
        if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
            onItemClickListener = this.xj.wL;
            if (onItemClickListener != null) {
                onItemClickListener2 = this.xj.wL;
                onItemClickListener2.onItemClick(adapterView, view, i2, j);
                return;
            }
            return;
        }
        iVar = this.xj.wZ;
        if (iVar != null) {
            iVar2 = this.xj.wZ;
            if (view == iVar2.getView()) {
                iVar3 = this.xj.wZ;
                iVar3.onClick();
                return;
            }
        }
        xVar = this.xj.wP;
        if (xVar != null) {
            xVar2 = this.xj.wP;
            xVar2.onClick(view);
        }
    }
}
