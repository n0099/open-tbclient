package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdListView vg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(BdListView bdListView) {
        this.vg = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j jVar;
        j jVar2;
        h hVar;
        w wVar;
        w wVar2;
        h hVar2;
        h hVar3;
        AdapterView.OnItemClickListener onItemClickListener;
        AdapterView.OnItemClickListener onItemClickListener2;
        h hVar4;
        x xVar;
        x xVar2;
        h hVar5;
        h hVar6;
        jVar = this.vg.uH;
        int headersCount = jVar.getHeadersCount();
        if (i < headersCount) {
            hVar4 = this.vg.uV;
            if (hVar4 != null) {
                hVar5 = this.vg.uV;
                if (view == hVar5.getView()) {
                    hVar6 = this.vg.uV;
                    hVar6.onClick();
                    return;
                }
            }
            xVar = this.vg.uL;
            if (xVar != null) {
                xVar2 = this.vg.uL;
                xVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - headersCount;
        jVar2 = this.vg.uH;
        ListAdapter wrappedAdapter = jVar2.getWrappedAdapter();
        if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
            onItemClickListener = this.vg.uI;
            if (onItemClickListener != null) {
                onItemClickListener2 = this.vg.uI;
                onItemClickListener2.onItemClick(adapterView, view, i2, j);
                return;
            }
            return;
        }
        hVar = this.vg.uW;
        if (hVar != null) {
            hVar2 = this.vg.uW;
            if (view == hVar2.getView()) {
                hVar3 = this.vg.uW;
                hVar3.onClick();
                return;
            }
        }
        wVar = this.vg.uM;
        if (wVar != null) {
            wVar2 = this.vg.uM;
            wVar2.onClick(view);
        }
    }
}
