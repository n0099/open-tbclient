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
import d.a.c.j.e.g;
import d.a.c.j.e.h;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements s<BdTypeRecyclerView> {
    public RecyclerViewTypeAdapter x;
    public HashMap<BdUniqueId, d.a.c.j.e.a> y;
    public HashMap<BdUniqueId, h> z;

    /* loaded from: classes.dex */
    public class a implements BdRecyclerView.i {
        public a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
            RecyclerViewTypeAdapter recyclerViewTypeAdapter = BdTypeRecyclerView.this.x;
            if (recyclerViewTypeAdapter != null) {
                recyclerViewTypeAdapter.h(viewGroup, view, i2, j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements BdRecyclerView.j {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.j
        public boolean a(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
            RecyclerViewTypeAdapter recyclerViewTypeAdapter = BdTypeRecyclerView.this.x;
            if (recyclerViewTypeAdapter != null) {
                return recyclerViewTypeAdapter.i(viewGroup, view, i2, j);
            }
            return false;
        }
    }

    public BdTypeRecyclerView(Context context) {
        super(context);
        this.x = null;
        C();
    }

    public n B(int i2) {
        return this.x.getItem(i2);
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

    public void D(int i2) {
        this.x.j(i2, getHeaderViewsCount());
    }

    public void E(int i2, int i3) {
        this.x.k(i2, i3, getHeaderViewsCount());
    }

    @Override // d.a.c.j.e.s
    public void a(List<d.a.c.j.e.a> list) {
        for (d.a.c.j.e.a<n, TypeAdapter.ViewHolder> aVar : list) {
            if (aVar != null) {
                BdUniqueId bdUniqueId = null;
                if (aVar.x() != null) {
                    bdUniqueId = aVar.x();
                    if (!this.z.containsKey(bdUniqueId)) {
                        h hVar = new h(aVar.f39228e, bdUniqueId, aVar.f39232i);
                        hVar.g0(aVar);
                        this.x.c(hVar);
                        this.z.put(bdUniqueId, hVar);
                    }
                }
                if (aVar.v() != null) {
                    bdUniqueId = aVar.v();
                    if (!this.z.containsKey(bdUniqueId)) {
                        h hVar2 = new h(aVar.f39228e, bdUniqueId, aVar.f39232i);
                        hVar2.g0(aVar);
                        this.x.c(hVar2);
                        this.z.put(bdUniqueId, hVar2);
                    }
                }
                if (aVar.w() != null) {
                    bdUniqueId = aVar.w();
                    if (!this.z.containsKey(bdUniqueId)) {
                        h hVar3 = new h(aVar.f39228e, bdUniqueId, aVar.f39232i);
                        hVar3.g0(aVar);
                        this.x.c(hVar3);
                        this.z.put(bdUniqueId, hVar3);
                    }
                }
                if (aVar.u() != null) {
                    bdUniqueId = aVar.u();
                    if (!this.z.containsKey(bdUniqueId)) {
                        h hVar4 = new h(aVar.f39228e, bdUniqueId, aVar.f39232i);
                        hVar4.g0(aVar);
                        this.x.c(hVar4);
                        this.z.put(bdUniqueId, hVar4);
                    }
                }
                if (bdUniqueId == null) {
                    this.x.c(aVar);
                } else {
                    this.y.put(aVar.f39231h, aVar);
                }
            }
        }
        setAdapter(this.x);
    }

    public int getCount() {
        return this.x.getCount();
    }

    @Override // d.a.c.j.e.s
    public List<n> getData() {
        return this.x.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeRecyclerView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, d.a.c.j.e.p
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

    @Override // d.a.c.j.e.s
    public void setData(List<? extends n> list) {
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if (nVar != null) {
                if (this.y.containsKey(nVar.getType())) {
                    d.a.c.j.e.a aVar = this.y.get(nVar.getType());
                    if (aVar.x() != null) {
                        g gVar = new g();
                        gVar.m(aVar.x());
                        if (nVar instanceof BaseCardInfo) {
                            gVar.position = ((BaseCardInfo) nVar).position;
                            gVar.setSupportType(BaseCardInfo.SupportType.TOP);
                        }
                        gVar.l(nVar);
                        arrayList.add(gVar);
                    }
                    if (aVar.v() != null) {
                        g gVar2 = new g();
                        gVar2.m(aVar.v());
                        if (nVar instanceof BaseCardInfo) {
                            gVar2.position = ((BaseCardInfo) nVar).position;
                            gVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        }
                        gVar2.l(nVar);
                        arrayList.add(gVar2);
                    }
                    if (aVar.w() != null) {
                        g gVar3 = new g();
                        gVar3.m(aVar.w());
                        if (nVar instanceof BaseCardInfo) {
                            gVar3.position = ((BaseCardInfo) nVar).position;
                            gVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        }
                        gVar3.l(nVar);
                        arrayList.add(gVar3);
                    }
                    if (aVar.u() != null) {
                        g gVar4 = new g();
                        gVar4.m(aVar.u());
                        if (nVar instanceof BaseCardInfo) {
                            gVar4.position = ((BaseCardInfo) nVar).position;
                            gVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        }
                        gVar4.l(nVar);
                        arrayList.add(gVar4);
                    }
                } else {
                    arrayList.add(nVar);
                }
            }
        }
        this.x.setData(arrayList);
    }

    public void setDataWithPartChange(List<n> list, int i2, int i3) {
        this.x.l(list, i2, i3);
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

    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x = null;
        C();
    }
}
