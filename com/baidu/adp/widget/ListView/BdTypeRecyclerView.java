package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.h;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends h implements n<BdTypeRecyclerView> {
    q avF;

    public BdTypeRecyclerView(Context context) {
        super(context);
        this.avF = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avF = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avF = null;
        init();
    }

    private void init() {
        if (this.avF == null) {
            this.avF = new q();
        }
        super.setOnItemClickListener(new h.a() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.1
            @Override // com.baidu.adp.widget.ListView.h.a
            public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.avF != null) {
                    BdTypeRecyclerView.this.avF.a(viewGroup, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new h.b() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.2
            @Override // com.baidu.adp.widget.ListView.h.b
            public boolean b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.avF != null) {
                    return BdTypeRecyclerView.this.avF.b(viewGroup, view, i, j);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.adp.widget.ListView.h
    @Deprecated
    public void setOnItemClickListener(h.a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.h
    public void setOnItemLongClickListener(h.b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.h, com.baidu.adp.widget.ListView.k
    public BdTypeRecyclerView getListView() {
        return this;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public void addAdapters(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.avF.addAdapter(it.next());
        }
        setAdapter(this.avF);
    }

    @Override // com.baidu.adp.widget.ListView.n
    public void setData(List<i> list) {
        this.avF.setData(list);
    }

    @Override // com.baidu.adp.widget.ListView.n
    public List<i> getData() {
        return this.avF.getData();
    }

    public i getItem(int i) {
        return this.avF.getItem(i);
    }
}
