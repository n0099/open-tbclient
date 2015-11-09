package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView {
    x In;

    public BdTypeListView(Context context) {
        super(context);
        this.In = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.In = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.In = null;
        init();
    }

    private void init() {
        if (this.In == null) {
            this.In = new x();
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

    public void h(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.In.a(it.next());
        }
        setAdapter((ListAdapter) this.In);
    }

    public void setData(List<u> list) {
        this.In.setData(list);
    }

    public List<u> getData() {
        return this.In.getData();
    }

    public u aA(int i) {
        return this.In.getItem(i);
    }
}
