package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
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
public class BdTypeListView extends BdListView implements s<BdTypeListView> {
    public TypeAdapter K;
    public HashMap<BdUniqueId, d.a.c.j.e.a> L;
    public HashMap<BdUniqueId, h> M;

    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            TypeAdapter typeAdapter = BdTypeListView.this.K;
            if (typeAdapter != null) {
                typeAdapter.f(adapterView, view, i2, j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemLongClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
            TypeAdapter typeAdapter = BdTypeListView.this.K;
            if (typeAdapter != null) {
                return typeAdapter.g(adapterView, view, i2, j);
            }
            return false;
        }
    }

    public BdTypeListView(Context context) {
        super(context);
        this.K = null;
        H();
    }

    public n G(int i2) {
        return this.K.getItem(i2);
    }

    public final void H() {
        if (this.K == null) {
            this.K = new TypeAdapter();
        }
        if (this.L == null) {
            this.L = new HashMap<>();
        }
        if (this.M == null) {
            this.M = new HashMap<>();
        }
        super.setOnItemClickListener(new a());
        super.setOnItemLongClickListener(new b());
    }

    @Override // d.a.c.j.e.s
    public void a(List<d.a.c.j.e.a> list) {
        for (d.a.c.j.e.a<n, TypeAdapter.ViewHolder> aVar : list) {
            if (aVar != null) {
                BdUniqueId bdUniqueId = null;
                if (aVar.x() != null) {
                    bdUniqueId = aVar.x();
                    if (!this.M.containsKey(bdUniqueId)) {
                        h hVar = new h(aVar.f39564e, bdUniqueId, aVar.f39568i);
                        hVar.g0(aVar);
                        this.K.c(hVar);
                        this.M.put(bdUniqueId, hVar);
                    }
                }
                if (aVar.v() != null) {
                    bdUniqueId = aVar.v();
                    if (!this.M.containsKey(bdUniqueId)) {
                        h hVar2 = new h(aVar.f39564e, bdUniqueId, aVar.f39568i);
                        hVar2.g0(aVar);
                        this.K.c(hVar2);
                        this.M.put(bdUniqueId, hVar2);
                    }
                }
                if (aVar.w() != null) {
                    bdUniqueId = aVar.w();
                    if (!this.M.containsKey(bdUniqueId)) {
                        h hVar3 = new h(aVar.f39564e, bdUniqueId, aVar.f39568i);
                        hVar3.g0(aVar);
                        this.K.c(hVar3);
                        this.M.put(bdUniqueId, hVar3);
                    }
                }
                if (aVar.u() != null) {
                    bdUniqueId = aVar.u();
                    if (!this.M.containsKey(bdUniqueId)) {
                        h hVar4 = new h(aVar.f39564e, bdUniqueId, aVar.f39568i);
                        hVar4.g0(aVar);
                        this.K.c(hVar4);
                        this.M.put(bdUniqueId, hVar4);
                    }
                }
                if (bdUniqueId == null) {
                    this.K.c(aVar);
                } else {
                    this.L.put(aVar.f39567h, aVar);
                }
            }
        }
        setAdapter((ListAdapter) this.K);
    }

    @Override // d.a.c.j.e.s
    public List<n> getData() {
        return this.K.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, d.a.c.j.e.p
    /* renamed from: getListView */
    public BdListView getListView2() {
        return this;
    }

    @Override // d.a.c.j.e.s
    public void setData(List<? extends n> list) {
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if (nVar != null) {
                if (this.L.containsKey(nVar.getType())) {
                    d.a.c.j.e.a aVar = this.L.get(nVar.getType());
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
        this.K.h(arrayList);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
    }

    public BdTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K = null;
        H();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.K = null;
        H();
    }
}
