package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements v<BdTypeListView> {
    private HashMap<BdUniqueId, a> VJ;
    private HashMap<BdUniqueId, j> VK;
    af mTypeAdapter;

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
            this.mTypeAdapter = new af();
        }
        if (this.VJ == null) {
            this.VJ = new HashMap<>();
        }
        if (this.VK == null) {
            this.VK = new HashMap<>();
        }
        super.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.adp.widget.ListView.BdTypeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (BdTypeListView.this.mTypeAdapter != null) {
                    BdTypeListView.this.mTypeAdapter.onItemClick(adapterView, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.adp.widget.ListView.BdTypeListView.2
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
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.adp.widget.ListView.s
    /* renamed from: getListView */
    public BdListView getListView2() {
        return this;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void addAdapters(List<a> list) {
        for (a<q, af.a> aVar : list) {
            if (aVar != null) {
                BdUniqueId bdUniqueId = null;
                if (aVar.qE() != null) {
                    bdUniqueId = aVar.qE();
                    if (!this.VK.containsKey(bdUniqueId)) {
                        j jVar = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar.a(aVar);
                        this.mTypeAdapter.addAdapter(jVar);
                        this.VK.put(bdUniqueId, jVar);
                    }
                }
                if (aVar.qF() != null) {
                    bdUniqueId = aVar.qF();
                    if (!this.VK.containsKey(bdUniqueId)) {
                        j jVar2 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar2.a(aVar);
                        this.mTypeAdapter.addAdapter(jVar2);
                        this.VK.put(bdUniqueId, jVar2);
                    }
                }
                if (aVar.qG() != null) {
                    bdUniqueId = aVar.qG();
                    if (!this.VK.containsKey(bdUniqueId)) {
                        j jVar3 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar3.a(aVar);
                        this.mTypeAdapter.addAdapter(jVar3);
                        this.VK.put(bdUniqueId, jVar3);
                    }
                }
                if (aVar.qH() != null) {
                    bdUniqueId = aVar.qH();
                    if (!this.VK.containsKey(bdUniqueId)) {
                        j jVar4 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar4.a(aVar);
                        this.mTypeAdapter.addAdapter(jVar4);
                        this.VK.put(bdUniqueId, jVar4);
                    }
                }
                if (bdUniqueId == null) {
                    this.mTypeAdapter.addAdapter(aVar);
                } else {
                    this.VJ.put(aVar.UM, aVar);
                }
            }
        }
        setAdapter((ListAdapter) this.mTypeAdapter);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void setData(List<? extends q> list) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            if (qVar != null) {
                if (this.VJ.containsKey(qVar.getType())) {
                    a aVar = this.VJ.get(qVar.getType());
                    if (aVar.qE() != null) {
                        i iVar = new i();
                        iVar.g(aVar.qE());
                        iVar.a(qVar);
                        arrayList.add(iVar);
                    }
                    if (aVar.qF() != null) {
                        i iVar2 = new i();
                        iVar2.g(aVar.qF());
                        iVar2.a(qVar);
                        arrayList.add(iVar2);
                    }
                    if (aVar.qG() != null) {
                        i iVar3 = new i();
                        iVar3.g(aVar.qG());
                        iVar3.a(qVar);
                        arrayList.add(iVar3);
                    }
                    if (aVar.qH() != null) {
                        i iVar4 = new i();
                        iVar4.g(aVar.qH());
                        iVar4.a(qVar);
                        arrayList.add(iVar4);
                    }
                } else {
                    arrayList.add(qVar);
                }
            }
        }
        this.mTypeAdapter.setData(arrayList);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public List<q> getData() {
        return this.mTypeAdapter.getData();
    }

    public q getItem(int i) {
        return this.mTypeAdapter.getItem(i);
    }
}
