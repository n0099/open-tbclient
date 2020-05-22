package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements t<BdTypeRecyclerView> {
    private HashMap<BdUniqueId, a> UJ;
    z UM;

    public BdTypeRecyclerView(Context context) {
        super(context);
        this.UM = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.UM = null;
        init();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.UM = null;
        init();
    }

    private void init() {
        if (this.UM == null) {
            this.UM = new z();
        }
        if (this.UJ == null) {
            this.UJ = new HashMap<>();
        }
        super.setOnItemClickListener(new BdRecyclerView.a() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.1
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
            public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.UM != null) {
                    BdTypeRecyclerView.this.UM.onItemClick(viewGroup, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new BdRecyclerView.b() { // from class: com.baidu.adp.widget.ListView.BdTypeRecyclerView.2
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.b
            public boolean b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                if (BdTypeRecyclerView.this.UM != null) {
                    return BdTypeRecyclerView.this.UM.onItemLongClick(viewGroup, view, i, j);
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
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, com.baidu.adp.widget.ListView.q
    /* renamed from: getListView */
    public BdRecyclerView getListView2() {
        return this;
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
                    this.UM.addAdapter(iVar);
                }
                if (aVar.oP() != null) {
                    bdUniqueId = aVar.oP();
                    i iVar2 = new i(aVar.mContext, bdUniqueId, aVar.mPageId);
                    iVar2.a(aVar);
                    this.UM.addAdapter(iVar2);
                }
                if (aVar.oQ() != null) {
                    bdUniqueId = aVar.oQ();
                    i iVar3 = new i(aVar.mContext, bdUniqueId, aVar.mPageId);
                    iVar3.a(aVar);
                    this.UM.addAdapter(iVar3);
                }
                if (aVar.oR() != null) {
                    bdUniqueId = aVar.oR();
                    i iVar4 = new i(aVar.mContext, bdUniqueId, aVar.mPageId);
                    iVar4.a(aVar);
                    this.UM.addAdapter(iVar4);
                }
            }
            if (bdUniqueId == null) {
                this.UM.addAdapter(aVar);
            } else {
                this.UJ.put(aVar.TK, aVar);
            }
        }
        setAdapter(this.UM);
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
        this.UM.setData(arrayList);
    }

    public void setDataWithPartChange(List<o> list, int i, int i2) {
        this.UM.a(list, i, i2);
    }

    public void removeItem(int i) {
        this.UM.removeItem(i);
    }

    public void l(int i, int i2) {
        this.UM.k(i, i2, getHeaderViewsCount());
    }

    @Override // com.baidu.adp.widget.ListView.t
    public List<o> getData() {
        return this.UM.getData();
    }

    public o getItem(int i) {
        return this.UM.getItem(i);
    }

    public int getCount() {
        return this.UM.getCount();
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
