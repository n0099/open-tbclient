package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView {
    al Ii;

    public BdTypeListView(Context context) {
        super(context);
        this.Ii = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ii = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ii = null;
        init();
    }

    private void init() {
        if (this.Ii == null) {
            this.Ii = new al();
        }
        super.setOnItemClickListener(new ag(this));
        super.setOnItemLongClickListener(new ah(this));
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
            this.Ii.a(it.next());
        }
        setAdapter((ListAdapter) this.Ii);
    }

    public void setData(List<ai> list) {
        this.Ii.setData(list);
    }

    public List<ai> getData() {
        return this.Ii.getData();
    }

    public ai ay(int i) {
        return this.Ii.getItem(i);
    }
}
