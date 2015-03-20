package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView {
    al Iq;

    public BdTypeListView(Context context) {
        super(context);
        this.Iq = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Iq = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Iq = null;
        init();
    }

    private void init() {
        if (this.Iq == null) {
            this.Iq = new al();
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

    public void g(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.Iq.a(it.next());
        }
        setAdapter((ListAdapter) this.Iq);
    }

    public void setData(List<ai> list) {
        this.Iq.setData(list);
    }

    public List<ai> getData() {
        return this.Iq.getData();
    }

    public ai aA(int i) {
        return this.Iq.getItem(i);
    }
}
