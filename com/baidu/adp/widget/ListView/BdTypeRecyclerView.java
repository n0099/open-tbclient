package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements v<BdTypeRecyclerView> {
    ad WB;
    private HashMap<BdUniqueId, a> Wy;
    private HashMap<BdUniqueId, j> Wz;

    public BdTypeRecyclerView(Context context) {
        super(context);
        this.WB = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.WB = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.WB = null;
        init();
    }

    private void init() {
        if (this.WB == null) {
            this.WB = new ad();
        }
        if (this.Wy == null) {
            this.Wy = new HashMap<>();
        }
        if (this.Wz == null) {
            this.Wz = new HashMap<>();
        }
        super.setOnItemClickListener(new BdRecyclerView.a() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.1
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
            public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.WB != null) {
                    BdTypeRecyclerView.this.WB.onItemClick(viewGroup, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new BdRecyclerView.b() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.2
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.b
            public boolean b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.WB != null) {
                    return BdTypeRecyclerView.this.WB.onItemLongClick(viewGroup, view, i, j);
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
                    if (!this.Wz.containsKey(bdUniqueId)) {
                        j jVar = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar.a(aVar);
                        this.WB.addAdapter(jVar);
                        this.Wz.put(bdUniqueId, jVar);
                    }
                }
                if (aVar.qK() != null) {
                    bdUniqueId = aVar.qK();
                    if (!this.Wz.containsKey(bdUniqueId)) {
                        j jVar2 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar2.a(aVar);
                        this.WB.addAdapter(jVar2);
                        this.Wz.put(bdUniqueId, jVar2);
                    }
                }
                if (aVar.qL() != null) {
                    bdUniqueId = aVar.qL();
                    if (!this.Wz.containsKey(bdUniqueId)) {
                        j jVar3 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar3.a(aVar);
                        this.WB.addAdapter(jVar3);
                        this.Wz.put(bdUniqueId, jVar3);
                    }
                }
                if (aVar.qM() != null) {
                    bdUniqueId = aVar.qM();
                    if (!this.Wz.containsKey(bdUniqueId)) {
                        j jVar4 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar4.a(aVar);
                        this.WB.addAdapter(jVar4);
                        this.Wz.put(bdUniqueId, jVar4);
                    }
                }
                if (bdUniqueId == null) {
                    this.WB.addAdapter(aVar);
                } else {
                    this.Wy.put(aVar.Vx, aVar);
                }
            }
        }
        setAdapter(this.WB);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void setData(List<? extends q> list) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            if (qVar != null) {
                if (this.Wy.containsKey(qVar.getType())) {
                    a aVar = this.Wy.get(qVar.getType());
                    if (aVar.qJ() != null) {
                        i iVar = new i();
                        iVar.g(aVar.qJ());
                        if (qVar instanceof BaseCardInfo) {
                            iVar.position = ((BaseCardInfo) qVar).position;
                            iVar.setSupportType(BaseCardInfo.SupportType.TOP);
                        }
                        iVar.a(qVar);
                        arrayList.add(iVar);
                    }
                    if (aVar.qK() != null) {
                        i iVar2 = new i();
                        iVar2.g(aVar.qK());
                        if (qVar instanceof BaseCardInfo) {
                            iVar2.position = ((BaseCardInfo) qVar).position;
                            iVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        }
                        iVar2.a(qVar);
                        arrayList.add(iVar2);
                    }
                    if (aVar.qL() != null) {
                        i iVar3 = new i();
                        iVar3.g(aVar.qL());
                        if (qVar instanceof BaseCardInfo) {
                            iVar3.position = ((BaseCardInfo) qVar).position;
                            iVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        }
                        iVar3.a(qVar);
                        arrayList.add(iVar3);
                    }
                    if (aVar.qM() != null) {
                        i iVar4 = new i();
                        iVar4.g(aVar.qM());
                        if (qVar instanceof BaseCardInfo) {
                            iVar4.position = ((BaseCardInfo) qVar).position;
                            iVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        }
                        iVar4.a(qVar);
                        arrayList.add(iVar4);
                    }
                } else {
                    arrayList.add(qVar);
                }
            }
        }
        this.WB.setData(arrayList);
    }

    public void setDataWithPartChange(List<q> list, int i, int i2) {
        this.WB.a(list, i, i2);
    }

    public void removeItem(int i) {
        this.WB.q(i, getHeaderViewsCount());
    }

    public void o(int i, int i2) {
        this.WB.k(i, i2, getHeaderViewsCount());
    }

    @Override // com.baidu.adp.widget.ListView.v
    public List<q> getData() {
        return this.WB.getData();
    }

    public q getItem(int i) {
        return this.WB.getItem(i);
    }

    public int getCount() {
        return this.WB.getCount();
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
