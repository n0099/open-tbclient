package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView {
    ao vy;

    public BdTypeListView(Context context) {
        super(context);
        this.vy = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vy = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vy = null;
        init();
    }

    private void init() {
        if (this.vy == null) {
            this.vy = new ao();
        }
        super.setOnItemClickListener(new aj(this));
        super.setOnItemLongClickListener(new ak(this));
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
    }

    public void e(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.vy.a(it.next());
        }
        setAdapter((ListAdapter) this.vy);
    }

    public void setData(List<al> list) {
        this.vy.setData(list);
    }

    public List<al> getData() {
        return this.vy.getData();
    }

    public al ai(int i) {
        return this.vy.getItem(i);
    }
}
