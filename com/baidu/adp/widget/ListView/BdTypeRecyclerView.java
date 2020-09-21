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
    private HashMap<BdUniqueId, a> Wc;
    private HashMap<BdUniqueId, j> We;
    ad Wg;

    public BdTypeRecyclerView(Context context) {
        super(context);
        this.Wg = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Wg = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wg = null;
        init();
    }

    private void init() {
        if (this.Wg == null) {
            this.Wg = new ad();
        }
        if (this.Wc == null) {
            this.Wc = new HashMap<>();
        }
        if (this.We == null) {
            this.We = new HashMap<>();
        }
        super.setOnItemClickListener(new BdRecyclerView.a() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.1
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
            public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.Wg != null) {
                    BdTypeRecyclerView.this.Wg.onItemClick(viewGroup, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new BdRecyclerView.b() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.2
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.b
            public boolean b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.Wg != null) {
                    return BdTypeRecyclerView.this.Wg.onItemLongClick(viewGroup, view, i, j);
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
                if (aVar.qJ() != null) {
                    bdUniqueId = aVar.qJ();
                    if (!this.We.containsKey(bdUniqueId)) {
                        j jVar = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar.a(aVar);
                        this.Wg.addAdapter(jVar);
                        this.We.put(bdUniqueId, jVar);
                    }
                }
                if (aVar.qK() != null) {
                    bdUniqueId = aVar.qK();
                    if (!this.We.containsKey(bdUniqueId)) {
                        j jVar2 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar2.a(aVar);
                        this.Wg.addAdapter(jVar2);
                        this.We.put(bdUniqueId, jVar2);
                    }
                }
                if (aVar.qL() != null) {
                    bdUniqueId = aVar.qL();
                    if (!this.We.containsKey(bdUniqueId)) {
                        j jVar3 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar3.a(aVar);
                        this.Wg.addAdapter(jVar3);
                        this.We.put(bdUniqueId, jVar3);
                    }
                }
                if (aVar.qM() != null) {
                    bdUniqueId = aVar.qM();
                    if (!this.We.containsKey(bdUniqueId)) {
                        j jVar4 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar4.a(aVar);
                        this.Wg.addAdapter(jVar4);
                        this.We.put(bdUniqueId, jVar4);
                    }
                }
                if (bdUniqueId == null) {
                    this.Wg.addAdapter(aVar);
                } else {
                    this.Wc.put(aVar.Vf, aVar);
                }
            }
        }
        setAdapter(this.Wg);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void setData(List<? extends q> list) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            if (qVar != null) {
                if (this.Wc.containsKey(qVar.getType())) {
                    a aVar = this.Wc.get(qVar.getType());
                    if (aVar.qJ() != null) {
                        i iVar = new i();
                        iVar.g(aVar.qJ());
                        iVar.a(qVar);
                        arrayList.add(iVar);
                    }
                    if (aVar.qK() != null) {
                        i iVar2 = new i();
                        iVar2.g(aVar.qK());
                        iVar2.a(qVar);
                        arrayList.add(iVar2);
                    }
                    if (aVar.qL() != null) {
                        i iVar3 = new i();
                        iVar3.g(aVar.qL());
                        iVar3.a(qVar);
                        arrayList.add(iVar3);
                    }
                    if (aVar.qM() != null) {
                        i iVar4 = new i();
                        iVar4.g(aVar.qM());
                        iVar4.a(qVar);
                        arrayList.add(iVar4);
                    }
                } else {
                    arrayList.add(qVar);
                }
            }
        }
        this.Wg.setData(arrayList);
    }

    public void setDataWithPartChange(List<q> list, int i, int i2) {
        this.Wg.a(list, i, i2);
    }

    public void removeItem(int i) {
        this.Wg.q(i, getHeaderViewsCount());
    }

    public void o(int i, int i2) {
        this.Wg.k(i, i2, getHeaderViewsCount());
    }

    @Override // com.baidu.adp.widget.ListView.v
    public List<q> getData() {
        return this.Wg.getData();
    }

    public q getItem(int i) {
        return this.Wg.getItem(i);
    }

    public int getCount() {
        return this.Wg.getCount();
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
