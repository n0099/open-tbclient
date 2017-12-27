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
    q avI;

    public BdTypeRecyclerView(Context context) {
        super(context);
        this.avI = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avI = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avI = null;
        init();
    }

    private void init() {
        if (this.avI == null) {
            this.avI = new q();
        }
        super.setOnItemClickListener(new h.a() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.1
            @Override // com.baidu.adp.widget.ListView.h.a
            public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.avI != null) {
                    BdTypeRecyclerView.this.avI.a(viewGroup, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new h.b() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.2
            @Override // com.baidu.adp.widget.ListView.h.b
            public boolean b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.avI != null) {
                    return BdTypeRecyclerView.this.avI.b(viewGroup, view, i, j);
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
            this.avI.addAdapter(it.next());
        }
        setAdapter(this.avI);
    }

    @Override // com.baidu.adp.widget.ListView.n
    public void setData(List<i> list) {
        this.avI.setData(list);
    }

    @Override // com.baidu.adp.widget.ListView.n
    public List<i> getData() {
        return this.avI.getData();
    }

    public i getItem(int i) {
        return this.avI.getItem(i);
    }
}
