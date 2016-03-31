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
    x Jr;

    public BdTypeListView(Context context) {
        super(context);
        this.Jr = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Jr = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Jr = null;
        init();
    }

    private void init() {
        if (this.Jr == null) {
            this.Jr = new x();
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
        this.Jr.a(aVar);
        setAdapter((ListAdapter) this.Jr);
    }

    public void g(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.Jr.a(it.next());
        }
        setAdapter((ListAdapter) this.Jr);
    }

    public void setData(List<u> list) {
        this.Jr.setData(list);
    }

    public List<u> getData() {
        return this.Jr.getData();
    }

    public u aF(int i) {
        return this.Jr.getItem(i);
    }
}
