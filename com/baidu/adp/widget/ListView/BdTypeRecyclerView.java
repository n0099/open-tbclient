package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements v<BdTypeRecyclerView> {
    private HashMap<BdUniqueId, a> Vo;
    private HashMap<BdUniqueId, j> Vp;
    ab Vr;

    public BdTypeRecyclerView(Context context) {
        super(context);
        this.Vr = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Vr = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Vr = null;
        init();
    }

    private void init() {
        if (this.Vr == null) {
            this.Vr = new ab();
        }
        if (this.Vo == null) {
            this.Vo = new HashMap<>();
        }
        if (this.Vp == null) {
            this.Vp = new HashMap<>();
        }
        super.setOnItemClickListener(new BdRecyclerView.a() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.1
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
            public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.Vr != null) {
                    BdTypeRecyclerView.this.Vr.onItemClick(viewGroup, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new BdRecyclerView.b() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.2
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.b
            public boolean b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.Vr != null) {
                    return BdTypeRecyclerView.this.Vr.onItemLongClick(viewGroup, view, i, j);
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
        for (a<q, ad.a> aVar : list) {
            if (aVar != null) {
                BdUniqueId bdUniqueId = null;
                if (aVar.pe() != null) {
                    bdUniqueId = aVar.pe();
                    if (!this.Vp.containsKey(bdUniqueId)) {
                        j jVar = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar.a(aVar);
                        this.Vr.addAdapter(jVar);
                        this.Vp.put(bdUniqueId, jVar);
                    }
                }
                if (aVar.pf() != null) {
                    bdUniqueId = aVar.pf();
                    if (!this.Vp.containsKey(bdUniqueId)) {
                        j jVar2 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar2.a(aVar);
                        this.Vr.addAdapter(jVar2);
                        this.Vp.put(bdUniqueId, jVar2);
                    }
                }
                if (aVar.pg() != null) {
                    bdUniqueId = aVar.pg();
                    if (!this.Vp.containsKey(bdUniqueId)) {
                        j jVar3 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar3.a(aVar);
                        this.Vr.addAdapter(jVar3);
                        this.Vp.put(bdUniqueId, jVar3);
                    }
                }
                if (aVar.ph() != null) {
                    bdUniqueId = aVar.ph();
                    if (!this.Vp.containsKey(bdUniqueId)) {
                        j jVar4 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar4.a(aVar);
                        this.Vr.addAdapter(jVar4);
                        this.Vp.put(bdUniqueId, jVar4);
                    }
                }
                if (bdUniqueId == null) {
                    this.Vr.addAdapter(aVar);
                } else {
                    this.Vo.put(aVar.Un, aVar);
                }
            }
        }
        setAdapter(this.Vr);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void setData(List<? extends q> list) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            if (qVar != null) {
                if (this.Vo.containsKey(qVar.getType())) {
                    a aVar = this.Vo.get(qVar.getType());
                    if (aVar.pe() != null) {
                        i iVar = new i();
                        iVar.g(aVar.pe());
                        iVar.a(qVar);
                        arrayList.add(iVar);
                    }
                    if (aVar.pf() != null) {
                        i iVar2 = new i();
                        iVar2.g(aVar.pf());
                        iVar2.a(qVar);
                        arrayList.add(iVar2);
                    }
                    if (aVar.pg() != null) {
                        i iVar3 = new i();
                        iVar3.g(aVar.pg());
                        iVar3.a(qVar);
                        arrayList.add(iVar3);
                    }
                    if (aVar.ph() != null) {
                        i iVar4 = new i();
                        iVar4.g(aVar.ph());
                        iVar4.a(qVar);
                        arrayList.add(iVar4);
                    }
                } else {
                    arrayList.add(qVar);
                }
            }
        }
        this.Vr.setData(arrayList);
    }

    public void setDataWithPartChange(List<q> list, int i, int i2) {
        this.Vr.a(list, i, i2);
    }

    public void removeItem(int i) {
        this.Vr.o(i, getHeaderViewsCount());
    }

    public void m(int i, int i2) {
        this.Vr.k(i, i2, getHeaderViewsCount());
    }

    @Override // com.baidu.adp.widget.ListView.v
    public List<q> getData() {
        return this.Vr.getData();
    }

    public q getItem(int i) {
        return this.Vr.getItem(i);
    }

    public int getCount() {
        return this.Vr.getCount();
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
