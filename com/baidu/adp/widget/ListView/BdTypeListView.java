package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.x;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView {
    x Jl;

    public BdTypeListView(Context context) {
        super(context);
        this.Jl = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Jl = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Jl = null;
        init();
    }

    private void init() {
        if (this.Jl == null) {
            this.Jl = new x();
        }
        super.setOnItemClickListener(new s(this));
        super.setOnItemLongClickListener(new t(this));
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
    }

    public void a(a<u, x.a> aVar) {
        this.Jl.a(aVar);
        setAdapter((ListAdapter) this.Jl);
    }

    public void g(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.Jl.a(it.next());
        }
        setAdapter((ListAdapter) this.Jl);
    }

    public void setData(List<u> list) {
        this.Jl.setData(list);
    }

    public List<u> getData() {
        return this.Jl.getData();
    }

    public u aG(int i) {
        return this.Jl.getItem(i);
    }
}
