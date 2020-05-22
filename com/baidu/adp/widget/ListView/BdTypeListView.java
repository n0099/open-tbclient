package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements t<BdTypeListView> {
    private HashMap<BdUniqueId, a> UJ;
    aa mTypeAdapter;

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
            this.mTypeAdapter = new aa();
        }
        if (this.UJ == null) {
            this.UJ = new HashMap<>();
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
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.adp.widget.ListView.q
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

    @Override // com.baidu.adp.widget.ListView.t
    public void addAdapters(List<a> list) {
        for (a<o, aa.a> aVar : list) {
            BdUniqueId bdUniqueId = null;
            if (aVar != null) {
                if (aVar.oO() != null) {
                    bdUniqueId = aVar.oO();
                    i iVar = new i(aVar.mContext, bdUniqueId, aVar.mPageId);
                    iVar.a(aVar);
                    this.mTypeAdapter.addAdapter(iVar);
                }
                if (aVar.oP() != null) {
                    bdUniqueId = aVar.oP();
                    i iVar2 = new i(aVar.mContext, bdUniqueId, aVar.mPageId);
                    iVar2.a(aVar);
                    this.mTypeAdapter.addAdapter(iVar2);
                }
                if (aVar.oQ() != null) {
                    bdUniqueId = aVar.oQ();
                    i iVar3 = new i(aVar.mContext, bdUniqueId, aVar.mPageId);
                    iVar3.a(aVar);
                    this.mTypeAdapter.addAdapter(iVar3);
                }
                if (aVar.oR() != null) {
                    bdUniqueId = aVar.oR();
                    i iVar4 = new i(aVar.mContext, bdUniqueId, aVar.mPageId);
                    iVar4.a(aVar);
                    this.mTypeAdapter.addAdapter(iVar4);
                }
            }
            if (bdUniqueId == null) {
                this.mTypeAdapter.addAdapter(aVar);
            } else {
                this.UJ.put(aVar.TK, aVar);
            }
        }
        setAdapter((ListAdapter) this.mTypeAdapter);
    }

    @Override // com.baidu.adp.widget.ListView.t
    public void setData(List<o> list) {
        ArrayList arrayList = new ArrayList();
        for (o oVar : list) {
            if (oVar != null) {
                if (this.UJ.containsKey(oVar.getType())) {
                    a aVar = this.UJ.get(oVar.getType());
                    if (aVar.oO() != null) {
                        h hVar = new h();
                        hVar.g(aVar.oO());
                        hVar.a(oVar);
                        arrayList.add(hVar);
                    }
                    if (aVar.oP() != null) {
                        h hVar2 = new h();
                        hVar2.g(aVar.oP());
                        hVar2.a(oVar);
                        arrayList.add(hVar2);
                    }
                    if (aVar.oQ() != null) {
                        h hVar3 = new h();
                        hVar3.g(aVar.oQ());
                        hVar3.a(oVar);
                        arrayList.add(hVar3);
                    }
                    if (aVar.oR() != null) {
                        h hVar4 = new h();
                        hVar4.g(aVar.oR());
                        hVar4.a(oVar);
                        arrayList.add(hVar4);
                    }
                } else {
                    arrayList.add(oVar);
                }
            }
        }
        this.mTypeAdapter.setData(arrayList);
    }

    @Override // com.baidu.adp.widget.ListView.t
    public List<o> getData() {
        return this.mTypeAdapter.getData();
    }

    public o getItem(int i) {
        return this.mTypeAdapter.getItem(i);
    }
}
