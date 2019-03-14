package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements r<BdTypeRecyclerView> {
    u PI;

    public BdTypeRecyclerView(Context context) {
        super(context);
        this.PI = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PI = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.PI = null;
        init();
    }

    private void init() {
        if (this.PI == null) {
            this.PI = new u();
        }
        super.setOnItemClickListener(new BdRecyclerView.a() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.1
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
            public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.PI != null) {
                    BdTypeRecyclerView.this.PI.a(viewGroup, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new BdRecyclerView.b() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.2
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.b
            public boolean b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.PI != null) {
                    return BdTypeRecyclerView.this.PI.b(viewGroup, view, i, j);
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
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, com.baidu.adp.widget.ListView.o
    /* renamed from: getListView */
    public BdRecyclerView getListView2() {
        return this;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void addAdapters(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.PI.addAdapter(it.next());
        }
        setAdapter(this.PI);
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void setData(List<m> list) {
        this.PI.setData(list);
    }

    public void setDataWithPartChange(List<m> list, int i, int i2) {
        this.PI.a(list, i, i2);
    }

    public void s(int i, int i2) {
        this.PI.s(i, i2);
    }

    @Override // com.baidu.adp.widget.ListView.r
    public List<m> getData() {
        return this.PI.getData();
    }

    public m getItem(int i) {
        return this.PI.getItem(i);
    }

    public int getCount() {
        return this.PI.getCount();
    }
}
