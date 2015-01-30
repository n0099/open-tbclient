package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView {
    ap xB;

    public BdTypeListView(Context context) {
        super(context);
        this.xB = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xB = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xB = null;
        init();
    }

    private void init() {
        if (this.xB == null) {
            this.xB = new ap();
        }
        super.setOnItemClickListener(new ak(this));
        super.setOnItemLongClickListener(new al(this));
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
            this.xB.a(it.next());
        }
        setAdapter((ListAdapter) this.xB);
    }

    public void setData(List<am> list) {
        this.xB.setData(list);
    }

    public List<am> getData() {
        return this.xB.getData();
    }

    public am aD(int i) {
        return this.xB.getItem(i);
    }
}
