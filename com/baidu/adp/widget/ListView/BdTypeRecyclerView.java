package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements r<BdTypeRecyclerView> {
    u AK;

    public BdTypeRecyclerView(Context context) {
        super(context);
        this.AK = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.AK = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.AK = null;
        init();
    }

    private void init() {
        if (this.AK == null) {
            this.AK = new u();
        }
        super.setOnItemClickListener(new BdRecyclerView.a() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.1
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
            public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.AK != null) {
                    BdTypeRecyclerView.this.AK.onItemClick(viewGroup, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new BdRecyclerView.b() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.2
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.b
            public boolean b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.AK != null) {
                    return BdTypeRecyclerView.this.AK.onItemLongClick(viewGroup, view, i, j);
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
            this.AK.addAdapter(it.next());
        }
        setAdapter(this.AK);
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void setData(List<m> list) {
        this.AK.setData(list);
    }

    public void setDataWithPartChange(List<m> list, int i, int i2) {
        this.AK.a(list, i, i2);
    }

    public void removeItem(int i) {
        this.AK.removeItem(i);
    }

    public void l(int i, int i2) {
        this.AK.l(i, i2);
    }

    @Override // com.baidu.adp.widget.ListView.r
    public List<m> getData() {
        return this.AK.getData();
    }

    public m getItem(int i) {
        return this.AK.getItem(i);
    }

    public int getCount() {
        return this.AK.getCount();
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }
}
