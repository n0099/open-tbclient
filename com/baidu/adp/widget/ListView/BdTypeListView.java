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
    y Ai;

    public BdTypeListView(Context context) {
        super(context);
        this.Ai = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ai = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ai = null;
        init();
    }

    private void init() {
        if (this.Ai == null) {
            this.Ai = new y();
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

    public void a(a<v, y.a> aVar) {
        this.Ai.a(aVar);
        setAdapter((ListAdapter) this.Ai);
    }

    public void g(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.Ai.a(it.next());
        }
        setAdapter((ListAdapter) this.Ai);
    }

    public void setData(List<v> list) {
        this.Ai.setData(list);
    }

    public List<v> getData() {
        return this.Ai.getData();
    }

    public v aw(int i) {
        return this.Ai.getItem(i);
    }
}
