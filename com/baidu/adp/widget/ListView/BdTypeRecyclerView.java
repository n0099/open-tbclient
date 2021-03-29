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
import d.b.b.j.e.g;
import d.b.b.j.e.h;
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements s<BdTypeRecyclerView> {
    public RecyclerViewTypeAdapter x;
    public HashMap<BdUniqueId, d.b.b.j.e.a> y;
    public HashMap<BdUniqueId, h> z;

    /* loaded from: classes.dex */
    public class a implements BdRecyclerView.i {
        public a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void c(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            RecyclerViewTypeAdapter recyclerViewTypeAdapter = BdTypeRecyclerView.this.x;
            if (recyclerViewTypeAdapter != null) {
                recyclerViewTypeAdapter.q(viewGroup, view, i, j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements BdRecyclerView.j {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.j
        public boolean a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            RecyclerViewTypeAdapter recyclerViewTypeAdapter = BdTypeRecyclerView.this.x;
            if (recyclerViewTypeAdapter != null) {
                return recyclerViewTypeAdapter.r(viewGroup, view, i, j);
            }
            return false;
        }
    }

    public BdTypeRecyclerView(Context context) {
        super(context);
        this.x = null;
        C();
    }

    public n B(int i) {
        return this.x.getItem(i);
    }

    public final void C() {
        if (this.x == null) {
            this.x = new RecyclerViewTypeAdapter();
        }
        if (this.y == null) {
            this.y = new HashMap<>();
        }
        if (this.z == null) {
            this.z = new HashMap<>();
        }
        super.setOnItemClickListener(new a());
        super.setOnItemLongClickListener(new b());
    }

    public void D(int i) {
        this.x.s(i, getHeaderViewsCount());
    }

    public void E(int i, int i2) {
        this.x.u(i, i2, getHeaderViewsCount());
    }

    @Override // d.b.b.j.e.s
    public void a(List<d.b.b.j.e.a> list) {
        for (d.b.b.j.e.a<n, TypeAdapter.ViewHolder> aVar : list) {
            if (aVar != null) {
                BdUniqueId bdUniqueId = null;
                if (aVar.y() != null) {
                    bdUniqueId = aVar.y();
                    if (!this.z.containsKey(bdUniqueId)) {
                        h hVar = new h(aVar.f42358e, bdUniqueId, aVar.i);
                        hVar.j0(aVar);
                        this.x.c(hVar);
                        this.z.put(bdUniqueId, hVar);
                    }
                }
                if (aVar.w() != null) {
                    bdUniqueId = aVar.w();
                    if (!this.z.containsKey(bdUniqueId)) {
                        h hVar2 = new h(aVar.f42358e, bdUniqueId, aVar.i);
                        hVar2.j0(aVar);
                        this.x.c(hVar2);
                        this.z.put(bdUniqueId, hVar2);
                    }
                }
                if (aVar.x() != null) {
                    bdUniqueId = aVar.x();
                    if (!this.z.containsKey(bdUniqueId)) {
                        h hVar3 = new h(aVar.f42358e, bdUniqueId, aVar.i);
                        hVar3.j0(aVar);
                        this.x.c(hVar3);
                        this.z.put(bdUniqueId, hVar3);
                    }
                }
                if (aVar.v() != null) {
                    bdUniqueId = aVar.v();
                    if (!this.z.containsKey(bdUniqueId)) {
                        h hVar4 = new h(aVar.f42358e, bdUniqueId, aVar.i);
                        hVar4.j0(aVar);
                        this.x.c(hVar4);
                        this.z.put(bdUniqueId, hVar4);
                    }
                }
                if (bdUniqueId == null) {
                    this.x.c(aVar);
                } else {
                    this.y.put(aVar.f42361h, aVar);
                }
            }
        }
        setAdapter(this.x);
    }

    public int getCount() {
        return this.x.getCount();
    }

    @Override // d.b.b.j.e.s
    public List<n> getData() {
        return this.x.m();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeRecyclerView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, d.b.b.j.e.p
    /* renamed from: getListView */
    public BdRecyclerView getListView2() {
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // d.b.b.j.e.s
    public void setData(List<? extends n> list) {
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if (nVar != null) {
                if (this.y.containsKey(nVar.getType())) {
                    d.b.b.j.e.a aVar = this.y.get(nVar.getType());
                    if (aVar.y() != null) {
                        g gVar = new g();
                        gVar.n(aVar.y());
                        if (nVar instanceof BaseCardInfo) {
                            gVar.position = ((BaseCardInfo) nVar).position;
                            gVar.setSupportType(BaseCardInfo.SupportType.TOP);
                        }
                        gVar.j(nVar);
                        arrayList.add(gVar);
                    }
                    if (aVar.w() != null) {
                        g gVar2 = new g();
                        gVar2.n(aVar.w());
                        if (nVar instanceof BaseCardInfo) {
                            gVar2.position = ((BaseCardInfo) nVar).position;
                            gVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        }
                        gVar2.j(nVar);
                        arrayList.add(gVar2);
                    }
                    if (aVar.x() != null) {
                        g gVar3 = new g();
                        gVar3.n(aVar.x());
                        if (nVar instanceof BaseCardInfo) {
                            gVar3.position = ((BaseCardInfo) nVar).position;
                            gVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        }
                        gVar3.j(nVar);
                        arrayList.add(gVar3);
                    }
                    if (aVar.v() != null) {
                        g gVar4 = new g();
                        gVar4.n(aVar.v());
                        if (nVar instanceof BaseCardInfo) {
                            gVar4.position = ((BaseCardInfo) nVar).position;
                            gVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        }
                        gVar4.j(nVar);
                        arrayList.add(gVar4);
                    }
                } else {
                    arrayList.add(nVar);
                }
            }
        }
        this.x.setData(arrayList);
    }

    public void setDataWithPartChange(List<n> list, int i, int i2) {
        this.x.v(list, i, i2);
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView
    @Deprecated
    public void setOnItemClickListener(BdRecyclerView.i iVar) {
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView
    public void setOnItemLongClickListener(BdRecyclerView.j jVar) {
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = null;
        C();
    }

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = null;
        C();
    }
}
