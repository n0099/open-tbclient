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
    private HashMap<BdUniqueId, a> Vh;
    private HashMap<BdUniqueId, j> Vi;
    ab Vk;

    public BdTypeRecyclerView(Context context) {
        super(context);
        this.Vk = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Vk = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Vk = null;
        init();
    }

    private void init() {
        if (this.Vk == null) {
            this.Vk = new ab();
        }
        if (this.Vh == null) {
            this.Vh = new HashMap<>();
        }
        if (this.Vi == null) {
            this.Vi = new HashMap<>();
        }
        super.setOnItemClickListener(new BdRecyclerView.a() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.1
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
            public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.Vk != null) {
                    BdTypeRecyclerView.this.Vk.onItemClick(viewGroup, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new BdRecyclerView.b() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.2
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.b
            public boolean b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.Vk != null) {
                    return BdTypeRecyclerView.this.Vk.onItemLongClick(viewGroup, view, i, j);
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
                if (aVar.pf() != null) {
                    bdUniqueId = aVar.pf();
                    if (!this.Vi.containsKey(bdUniqueId)) {
                        j jVar = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar.a(aVar);
                        this.Vk.addAdapter(jVar);
                        this.Vi.put(bdUniqueId, jVar);
                    }
                }
                if (aVar.pg() != null) {
                    bdUniqueId = aVar.pg();
                    if (!this.Vi.containsKey(bdUniqueId)) {
                        j jVar2 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar2.a(aVar);
                        this.Vk.addAdapter(jVar2);
                        this.Vi.put(bdUniqueId, jVar2);
                    }
                }
                if (aVar.ph() != null) {
                    bdUniqueId = aVar.ph();
                    if (!this.Vi.containsKey(bdUniqueId)) {
                        j jVar3 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar3.a(aVar);
                        this.Vk.addAdapter(jVar3);
                        this.Vi.put(bdUniqueId, jVar3);
                    }
                }
                if (aVar.pi() != null) {
                    bdUniqueId = aVar.pi();
                    if (!this.Vi.containsKey(bdUniqueId)) {
                        j jVar4 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar4.a(aVar);
                        this.Vk.addAdapter(jVar4);
                        this.Vi.put(bdUniqueId, jVar4);
                    }
                }
                if (bdUniqueId == null) {
                    this.Vk.addAdapter(aVar);
                } else {
                    this.Vh.put(aVar.Uh, aVar);
                }
            }
        }
        setAdapter(this.Vk);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void setData(List<? extends q> list) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            if (qVar != null) {
                if (this.Vh.containsKey(qVar.getType())) {
                    a aVar = this.Vh.get(qVar.getType());
                    if (aVar.pf() != null) {
                        i iVar = new i();
                        iVar.g(aVar.pf());
                        iVar.a(qVar);
                        arrayList.add(iVar);
                    }
                    if (aVar.pg() != null) {
                        i iVar2 = new i();
                        iVar2.g(aVar.pg());
                        iVar2.a(qVar);
                        arrayList.add(iVar2);
                    }
                    if (aVar.ph() != null) {
                        i iVar3 = new i();
                        iVar3.g(aVar.ph());
                        iVar3.a(qVar);
                        arrayList.add(iVar3);
                    }
                    if (aVar.pi() != null) {
                        i iVar4 = new i();
                        iVar4.g(aVar.pi());
                        iVar4.a(qVar);
                        arrayList.add(iVar4);
                    }
                } else {
                    arrayList.add(qVar);
                }
            }
        }
        this.Vk.setData(arrayList);
    }

    public void setDataWithPartChange(List<q> list, int i, int i2) {
        this.Vk.a(list, i, i2);
    }

    public void removeItem(int i) {
        this.Vk.o(i, getHeaderViewsCount());
    }

    public void m(int i, int i2) {
        this.Vk.k(i, i2, getHeaderViewsCount());
    }

    @Override // com.baidu.adp.widget.ListView.v
    public List<q> getData() {
        return this.Vk.getData();
    }

    public q getItem(int i) {
        return this.Vk.getItem(i);
    }

    public int getCount() {
        return this.Vk.getCount();
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
