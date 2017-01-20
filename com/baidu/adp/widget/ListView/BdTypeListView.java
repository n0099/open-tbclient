package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.y;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView {
    y mTypeAdapter;

    public BdTypeListView(Context context) {
        super(context);
        this.mTypeAdapter = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTypeAdapter = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTypeAdapter = null;
        init();
    }

    private void init() {
        if (this.mTypeAdapter == null) {
            this.mTypeAdapter = new y();
        }
        super.setOnItemClickListener(new t(this));
        super.setOnItemLongClickListener(new u(this));
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
    }

    public void addAdapter(a<v, y.a> aVar) {
        this.mTypeAdapter.addAdapter(aVar);
        setAdapter((ListAdapter) this.mTypeAdapter);
    }

    public void addAdapters(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.mTypeAdapter.addAdapter(it.next());
        }
        setAdapter((ListAdapter) this.mTypeAdapter);
    }

    public void setData(List<v> list) {
        this.mTypeAdapter.setData(list);
    }

    public List<v> getData() {
        return this.mTypeAdapter.getData();
    }

    public v getItem(int i) {
        return this.mTypeAdapter.getItem(i);
    }
}
