package com.baidu.ala.widget.multicolumn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.a;
import com.baidu.adp.widget.ListView.n;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class BdTypeMultiColumnListView extends BdMultiColumnListView {
    TypeAdapter mTypeAdapter;

    public BdTypeMultiColumnListView(Context context) {
        super(context);
        this.mTypeAdapter = null;
        init();
    }

    public BdTypeMultiColumnListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTypeAdapter = null;
        init();
    }

    public BdTypeMultiColumnListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTypeAdapter = null;
        init();
    }

    private void init() {
        if (this.mTypeAdapter == null) {
            this.mTypeAdapter = new TypeAdapter();
        }
        super.setOnItemClickListener(new PLA_AdapterView.c() { // from class: com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView.1
            @Override // com.huewu.pla.lib.internal.PLA_AdapterView.c
            public void onItemClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i, long j) {
                if (BdTypeMultiColumnListView.this.mTypeAdapter != null) {
                    BdTypeMultiColumnListView.this.mTypeAdapter.onItemClick(pLA_AdapterView, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new PLA_AdapterView.d() { // from class: com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView.2
            @Override // com.huewu.pla.lib.internal.PLA_AdapterView.d
            public boolean onItemLongClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i, long j) {
                if (BdTypeMultiColumnListView.this.mTypeAdapter != null) {
                    return BdTypeMultiColumnListView.this.mTypeAdapter.onItemLongClick(pLA_AdapterView, view, i, j);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView, com.huewu.pla.lib.internal.PLA_AdapterView
    @Deprecated
    public void setOnItemClickListener(PLA_AdapterView.c cVar) {
    }

    @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView, com.huewu.pla.lib.internal.PLA_AdapterView
    @Deprecated
    public void setOnItemLongClickListener(PLA_AdapterView.d dVar) {
    }

    public void addAdapter(a<n, TypeAdapter.ViewHolder> aVar) {
        this.mTypeAdapter.addAdapter(aVar);
        setAdapter((ListAdapter) this.mTypeAdapter);
    }

    public void addAdapters(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.mTypeAdapter.addAdapter(it.next());
        }
        setAdapter((ListAdapter) this.mTypeAdapter);
    }

    public void setData(List<? extends n> list) {
        this.mTypeAdapter.setData(list);
    }

    public List<n> getData() {
        return this.mTypeAdapter.getData();
    }

    public n getItem(int i) {
        return this.mTypeAdapter.getItem(i);
    }
}
