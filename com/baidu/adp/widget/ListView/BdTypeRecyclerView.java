package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.af;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements v<BdTypeRecyclerView> {
    private HashMap<BdUniqueId, a> VJ;
    private HashMap<BdUniqueId, j> VK;
    ad VM;

    public BdTypeRecyclerView(Context context) {
        super(context);
        this.VM = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VM = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.VM = null;
        init();
    }

    private void init() {
        if (this.VM == null) {
            this.VM = new ad();
        }
        if (this.VJ == null) {
            this.VJ = new HashMap<>();
        }
        if (this.VK == null) {
            this.VK = new HashMap<>();
        }
        super.setOnItemClickListener(new BdRecyclerView.a() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.1
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
            public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.VM != null) {
                    BdTypeRecyclerView.this.VM.onItemClick(viewGroup, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new BdRecyclerView.b() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.2
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.b
            public boolean b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.VM != null) {
                    return BdTypeRecyclerView.this.VM.onItemLongClick(viewGroup, view, i, j);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView
    @Deprecated
    public void setOnItemClickListener(BdRecyclerView.a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView
    public void setOnItemLongClickListener(BdRecyclerView.b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeRecyclerView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, com.baidu.adp.widget.ListView.s
    /* renamed from: getListView */
    public BdRecyclerView getListView2() {
        return this;
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
                        this.VM.addAdapter(jVar);
                        this.VK.put(bdUniqueId, jVar);
                    }
                }
                if (aVar.qF() != null) {
                    bdUniqueId = aVar.qF();
                    if (!this.VK.containsKey(bdUniqueId)) {
                        j jVar2 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar2.a(aVar);
                        this.VM.addAdapter(jVar2);
                        this.VK.put(bdUniqueId, jVar2);
                    }
                }
                if (aVar.qG() != null) {
                    bdUniqueId = aVar.qG();
                    if (!this.VK.containsKey(bdUniqueId)) {
                        j jVar3 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar3.a(aVar);
                        this.VM.addAdapter(jVar3);
                        this.VK.put(bdUniqueId, jVar3);
                    }
                }
                if (aVar.qH() != null) {
                    bdUniqueId = aVar.qH();
                    if (!this.VK.containsKey(bdUniqueId)) {
                        j jVar4 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar4.a(aVar);
                        this.VM.addAdapter(jVar4);
                        this.VK.put(bdUniqueId, jVar4);
                    }
                }
                if (bdUniqueId == null) {
                    this.VM.addAdapter(aVar);
                } else {
                    this.VJ.put(aVar.UM, aVar);
                }
            }
        }
        setAdapter(this.VM);
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
        this.VM.setData(arrayList);
    }

    public void setDataWithPartChange(List<q> list, int i, int i2) {
        this.VM.a(list, i, i2);
    }

    public void removeItem(int i) {
        this.VM.q(i, getHeaderViewsCount());
    }

    public void o(int i, int i2) {
        this.VM.k(i, i2, getHeaderViewsCount());
    }

    @Override // com.baidu.adp.widget.ListView.v
    public List<q> getData() {
        return this.VM.getData();
    }

    public q getItem(int i) {
        return this.VM.getItem(i);
    }

    public int getCount() {
        return this.VM.getCount();
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }
}
