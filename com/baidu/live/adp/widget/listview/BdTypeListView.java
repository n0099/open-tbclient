package com.baidu.live.adp.widget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class BdTypeListView extends BdListView implements ITypeListView<BdTypeListView> {
    TypeAdapter mTypeAdapter;

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
            this.mTypeAdapter = new TypeAdapter();
        }
        super.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.live.adp.widget.listview.BdTypeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (BdTypeListView.this.mTypeAdapter != null) {
                    BdTypeListView.this.mTypeAdapter.onItemClick(adapterView, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.live.adp.widget.listview.BdTypeListView.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (BdTypeListView.this.mTypeAdapter != null) {
                    return BdTypeListView.this.mTypeAdapter.onItemLongClick(adapterView, view, i, j);
                }
                return false;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.live.adp.widget.listview.BdTypeListView' to match base method */
    @Override // com.baidu.live.adp.widget.listview.BdListView, com.baidu.live.adp.widget.listview.IListView
    /* renamed from: getListView */
    public BdListView getListView2() {
        return this;
    }

    @Override // com.baidu.live.adp.widget.listview.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
    }

    @Override // com.baidu.live.adp.widget.listview.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
    }

    @Override // com.baidu.live.adp.widget.listview.ITypeListView
    public void addAdapter(AbsDelegateAdapter<IAdapterData, TypeAdapter.ViewHolder> absDelegateAdapter) {
        this.mTypeAdapter.addAdapter(absDelegateAdapter);
        setAdapter((ListAdapter) this.mTypeAdapter);
    }

    @Override // com.baidu.live.adp.widget.listview.ITypeListView
    public void addAdapters(List<AbsDelegateAdapter> list) {
        Iterator<AbsDelegateAdapter> it = list.iterator();
        while (it.hasNext()) {
            this.mTypeAdapter.addAdapter(it.next());
        }
        setAdapter((ListAdapter) this.mTypeAdapter);
    }

    @Override // com.baidu.live.adp.widget.listview.ITypeListView
    public void setData(List<IAdapterData> list) {
        this.mTypeAdapter.setData(list);
    }

    @Override // com.baidu.live.adp.widget.listview.ITypeListView
    public List<IAdapterData> getData() {
        return this.mTypeAdapter.getData();
    }

    @Override // com.baidu.live.adp.widget.listview.ITypeListView
    public IAdapterData getItem(int i) {
        return this.mTypeAdapter.getItem(i);
    }
}
