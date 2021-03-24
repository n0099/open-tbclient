package com.baidu.ala.widget.multicolumn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import d.b.b.j.e.a;
import d.b.b.j.e.n;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class BdTypeMultiColumnListView extends BdMultiColumnListView {
    public TypeAdapter mTypeAdapter;

    public BdTypeMultiColumnListView(Context context) {
        super(context);
        this.mTypeAdapter = null;
        init();
    }

    private void init() {
        if (this.mTypeAdapter == null) {
            this.mTypeAdapter = new TypeAdapter();
        }
        super.setOnItemClickListener(new PLA_AdapterView.d() { // from class: com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView.1
            @Override // com.huewu.pla.lib.internal.PLA_AdapterView.d
            public void onItemClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i, long j) {
                TypeAdapter typeAdapter = BdTypeMultiColumnListView.this.mTypeAdapter;
                if (typeAdapter != null) {
                    typeAdapter.f(pLA_AdapterView, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new PLA_AdapterView.e() { // from class: com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView.2
            @Override // com.huewu.pla.lib.internal.PLA_AdapterView.e
            public boolean onItemLongClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i, long j) {
                TypeAdapter typeAdapter = BdTypeMultiColumnListView.this.mTypeAdapter;
                if (typeAdapter != null) {
                    return typeAdapter.g(pLA_AdapterView, view, i, j);
                }
                return false;
            }
        });
    }

    public void addAdapter(a<n, TypeAdapter.ViewHolder> aVar) {
        this.mTypeAdapter.c(aVar);
        setAdapter((ListAdapter) this.mTypeAdapter);
    }

    public void addAdapters(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.mTypeAdapter.c(it.next());
        }
        setAdapter((ListAdapter) this.mTypeAdapter);
    }

    public List<n> getData() {
        return this.mTypeAdapter.d();
    }

    public n getItem(int i) {
        return this.mTypeAdapter.getItem(i);
    }

    public void setData(List<? extends n> list) {
        this.mTypeAdapter.h(list);
    }

    @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView, com.huewu.pla.lib.internal.PLA_AdapterView
    @Deprecated
    public void setOnItemClickListener(PLA_AdapterView.d dVar) {
    }

    @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView, com.huewu.pla.lib.internal.PLA_AdapterView
    @Deprecated
    public void setOnItemLongClickListener(PLA_AdapterView.e eVar) {
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
}
