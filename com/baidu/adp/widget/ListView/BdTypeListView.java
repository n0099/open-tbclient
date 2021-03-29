package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
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
public class BdTypeListView extends BdListView implements s<BdTypeListView> {
    public TypeAdapter K;
    public HashMap<BdUniqueId, d.b.b.j.e.a> L;
    public HashMap<BdUniqueId, h> M;

    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TypeAdapter typeAdapter = BdTypeListView.this.K;
            if (typeAdapter != null) {
                typeAdapter.f(adapterView, view, i, j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemLongClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            TypeAdapter typeAdapter = BdTypeListView.this.K;
            if (typeAdapter != null) {
                return typeAdapter.g(adapterView, view, i, j);
            }
            return false;
        }
    }

    public BdTypeListView(Context context) {
        super(context);
        this.K = null;
        H();
    }

    public n G(int i) {
        return this.K.getItem(i);
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

    @Override // d.b.b.j.e.s
    public void a(List<d.b.b.j.e.a> list) {
        for (d.b.b.j.e.a<n, TypeAdapter.ViewHolder> aVar : list) {
            if (aVar != null) {
                BdUniqueId bdUniqueId = null;
                if (aVar.y() != null) {
                    bdUniqueId = aVar.y();
                    if (!this.M.containsKey(bdUniqueId)) {
                        h hVar = new h(aVar.f42358e, bdUniqueId, aVar.i);
                        hVar.j0(aVar);
                        this.K.c(hVar);
                        this.M.put(bdUniqueId, hVar);
                    }
                }
                if (aVar.w() != null) {
                    bdUniqueId = aVar.w();
                    if (!this.M.containsKey(bdUniqueId)) {
                        h hVar2 = new h(aVar.f42358e, bdUniqueId, aVar.i);
                        hVar2.j0(aVar);
                        this.K.c(hVar2);
                        this.M.put(bdUniqueId, hVar2);
                    }
                }
                if (aVar.x() != null) {
                    bdUniqueId = aVar.x();
                    if (!this.M.containsKey(bdUniqueId)) {
                        h hVar3 = new h(aVar.f42358e, bdUniqueId, aVar.i);
                        hVar3.j0(aVar);
                        this.K.c(hVar3);
                        this.M.put(bdUniqueId, hVar3);
                    }
                }
                if (aVar.v() != null) {
                    bdUniqueId = aVar.v();
                    if (!this.M.containsKey(bdUniqueId)) {
                        h hVar4 = new h(aVar.f42358e, bdUniqueId, aVar.i);
                        hVar4.j0(aVar);
                        this.K.c(hVar4);
                        this.M.put(bdUniqueId, hVar4);
                    }
                }
                if (bdUniqueId == null) {
                    this.K.c(aVar);
                } else {
                    this.L.put(aVar.f42361h, aVar);
                }
            }
        }
        setAdapter((ListAdapter) this.K);
    }

    @Override // d.b.b.j.e.s
    public List<n> getData() {
        return this.K.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, d.b.b.j.e.p
    /* renamed from: getListView */
    public BdListView getListView2() {
        return this;
    }

    @Override // d.b.b.j.e.s
    public void setData(List<? extends n> list) {
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if (nVar != null) {
                if (this.L.containsKey(nVar.getType())) {
                    d.b.b.j.e.a aVar = this.L.get(nVar.getType());
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

    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.K = null;
        H();
    }
}
