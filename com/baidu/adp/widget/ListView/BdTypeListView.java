package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView {
    x Im;

    public BdTypeListView(Context context) {
        super(context);
        this.Im = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Im = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Im = null;
        init();
    }

    private void init() {
        if (this.Im == null) {
            this.Im = new x();
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
            this.Im.a(it.next());
        }
        setAdapter((ListAdapter) this.Im);
    }

    public void setData(List<u> list) {
        this.Im.setData(list);
    }

    public List<u> getData() {
        return this.Im.getData();
    }

    public u aA(int i) {
        return this.Im.getItem(i);
    }
}
