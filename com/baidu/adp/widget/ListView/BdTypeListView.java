package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView {
    x IF;

    public BdTypeListView(Context context) {
        super(context);
        this.IF = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.IF = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.IF = null;
        init();
    }

    private void init() {
        if (this.IF == null) {
            this.IF = new x();
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

    public void g(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.IF.a(it.next());
        }
        setAdapter((ListAdapter) this.IF);
    }

    public void setData(List<u> list) {
        this.IF.setData(list);
    }

    public List<u> getData() {
        return this.IF.getData();
    }

    public u aB(int i) {
        return this.IF.getItem(i);
    }
}
