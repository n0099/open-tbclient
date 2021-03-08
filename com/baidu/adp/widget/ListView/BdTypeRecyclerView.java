package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements s<BdTypeRecyclerView> {
    private HashMap<BdUniqueId, a> YG;
    private HashMap<BdUniqueId, h> YH;
    RecyclerViewTypeAdapter YJ;

    public BdTypeRecyclerView(Context context) {
        super(context);
        this.YJ = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YJ = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.YJ = null;
        init();
    }

    private void init() {
        if (this.YJ == null) {
            this.YJ = new RecyclerViewTypeAdapter();
        }
        if (this.YG == null) {
            this.YG = new HashMap<>();
        }
        if (this.YH == null) {
            this.YH = new HashMap<>();
        }
        super.setOnItemClickListener(new BdRecyclerView.a() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.1
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
            public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.YJ != null) {
                    BdTypeRecyclerView.this.YJ.onItemClick(viewGroup, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new BdRecyclerView.b() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.2
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.b
            public boolean b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.YJ != null) {
                    return BdTypeRecyclerView.this.YJ.onItemLongClick(viewGroup, view, i, j);
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
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, com.baidu.adp.widget.ListView.p
    /* renamed from: getListView */
    public BdRecyclerView getListView2() {
        return this;
    }

    @Override // com.baidu.adp.widget.ListView.s
    public void addAdapters(List<a> list) {
        for (a<n, TypeAdapter.ViewHolder> aVar : list) {
            if (aVar != null) {
                BdUniqueId bdUniqueId = null;
                if (aVar.ql() != null) {
                    bdUniqueId = aVar.ql();
                    if (!this.YH.containsKey(bdUniqueId)) {
                        h hVar = new h(aVar.mContext, bdUniqueId, aVar.mPageId);
                        hVar.a(aVar);
                        this.YJ.addAdapter(hVar);
                        this.YH.put(bdUniqueId, hVar);
                    }
                }
                if (aVar.qm() != null) {
                    bdUniqueId = aVar.qm();
                    if (!this.YH.containsKey(bdUniqueId)) {
                        h hVar2 = new h(aVar.mContext, bdUniqueId, aVar.mPageId);
                        hVar2.a(aVar);
                        this.YJ.addAdapter(hVar2);
                        this.YH.put(bdUniqueId, hVar2);
                    }
                }
                if (aVar.qn() != null) {
                    bdUniqueId = aVar.qn();
                    if (!this.YH.containsKey(bdUniqueId)) {
                        h hVar3 = new h(aVar.mContext, bdUniqueId, aVar.mPageId);
                        hVar3.a(aVar);
                        this.YJ.addAdapter(hVar3);
                        this.YH.put(bdUniqueId, hVar3);
                    }
                }
                if (aVar.qo() != null) {
                    bdUniqueId = aVar.qo();
                    if (!this.YH.containsKey(bdUniqueId)) {
                        h hVar4 = new h(aVar.mContext, bdUniqueId, aVar.mPageId);
                        hVar4.a(aVar);
                        this.YJ.addAdapter(hVar4);
                        this.YH.put(bdUniqueId, hVar4);
                    }
                }
                if (bdUniqueId == null) {
                    this.YJ.addAdapter(aVar);
                } else {
                    this.YG.put(aVar.XG, aVar);
                }
            }
        }
        setAdapter(this.YJ);
    }

    @Override // com.baidu.adp.widget.ListView.s
    public void setData(List<? extends n> list) {
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if (nVar != null) {
                if (this.YG.containsKey(nVar.getType())) {
                    a aVar = this.YG.get(nVar.getType());
                    if (aVar.ql() != null) {
                        g gVar = new g();
                        gVar.g(aVar.ql());
                        if (nVar instanceof BaseCardInfo) {
                            gVar.position = ((BaseCardInfo) nVar).position;
                            gVar.setSupportType(BaseCardInfo.SupportType.TOP);
                        }
                        gVar.a(nVar);
                        arrayList.add(gVar);
                    }
                    if (aVar.qm() != null) {
                        g gVar2 = new g();
                        gVar2.g(aVar.qm());
                        if (nVar instanceof BaseCardInfo) {
                            gVar2.position = ((BaseCardInfo) nVar).position;
                            gVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        }
                        gVar2.a(nVar);
                        arrayList.add(gVar2);
                    }
                    if (aVar.qn() != null) {
                        g gVar3 = new g();
                        gVar3.g(aVar.qn());
                        if (nVar instanceof BaseCardInfo) {
                            gVar3.position = ((BaseCardInfo) nVar).position;
                            gVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        }
                        gVar3.a(nVar);
                        arrayList.add(gVar3);
                    }
                    if (aVar.qo() != null) {
                        g gVar4 = new g();
                        gVar4.g(aVar.qo());
                        if (nVar instanceof BaseCardInfo) {
                            gVar4.position = ((BaseCardInfo) nVar).position;
                            gVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        }
                        gVar4.a(nVar);
                        arrayList.add(gVar4);
                    }
                } else {
                    arrayList.add(nVar);
                }
            }
        }
        this.YJ.setData(arrayList);
    }

    public void setDataWithPartChange(List<n> list, int i, int i2) {
        this.YJ.a(list, i, i2);
    }

    public void removeItem(int i) {
        this.YJ.r(i, getHeaderViewsCount());
    }

    public void p(int i, int i2) {
        this.YJ.k(i, i2, getHeaderViewsCount());
    }

    @Override // com.baidu.adp.widget.ListView.s
    public List<n> getData() {
        return this.YJ.getData();
    }

    public n getItem(int i) {
        return this.YJ.getItem(i);
    }

    public int getCount() {
        return this.YJ.getCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }
}
