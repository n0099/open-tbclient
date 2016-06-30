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
    y zG;

    public BdTypeListView(Context context) {
        super(context);
        this.zG = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zG = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zG = null;
        init();
    }

    private void init() {
        if (this.zG == null) {
            this.zG = new y();
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
        this.zG.a(aVar);
        setAdapter((ListAdapter) this.zG);
    }

    public void g(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.zG.a(it.next());
        }
        setAdapter((ListAdapter) this.zG);
    }

    public void setData(List<v> list) {
        this.zG.setData(list);
    }

    public List<v> getData() {
        return this.zG.getData();
    }

    public v at(int i) {
        return this.zG.getItem(i);
    }
}
