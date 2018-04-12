package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements m<BdTypeRecyclerView> {
    p Gk;

    public BdTypeRecyclerView(Context context) {
        super(context);
        this.Gk = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Gk = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Gk = null;
        init();
    }

    private void init() {
        if (this.Gk == null) {
            this.Gk = new p();
        }
        super.setOnItemClickListener(new BdRecyclerView.a() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.1
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
            public void a(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.Gk != null) {
                    BdTypeRecyclerView.this.Gk.a(viewGroup, view2, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new BdRecyclerView.b() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.2
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.b
            public boolean b(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.Gk != null) {
                    return BdTypeRecyclerView.this.Gk.b(viewGroup, view2, i, j);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView
    @Deprecated
    public void setOnItemClickListener(BdRecyclerView.a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView
    public void setOnItemLongClickListener(BdRecyclerView.b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeRecyclerView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, com.baidu.adp.widget.ListView.j
    /* renamed from: getListView */
    public BdRecyclerView getListView2() {
        return this;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public void addAdapters(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.Gk.addAdapter(it.next());
        }
        setAdapter(this.Gk);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public void setData(List<h> list) {
        this.Gk.setData(list);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public List<h> getData() {
        return this.Gk.getData();
    }

    public h getItem(int i) {
        return this.Gk.getItem(i);
    }
}
