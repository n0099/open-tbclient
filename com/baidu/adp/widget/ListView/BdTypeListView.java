package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements s<BdTypeListView> {
    private HashMap<BdUniqueId, a> Xn;
    private HashMap<BdUniqueId, h> Xo;
    TypeAdapter mTypeAdapter;

    public BdTypeListView(Context context) {
        super(context);
        this.mTypeAdapter = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTypeAdapter = null;
        init();
    }

    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTypeAdapter = null;
        init();
    }

    private void init() {
        if (this.mTypeAdapter == null) {
            this.mTypeAdapter = new TypeAdapter();
        }
        if (this.Xn == null) {
            this.Xn = new HashMap<>();
        }
        if (this.Xo == null) {
            this.Xo = new HashMap<>();
        }
        super.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.adp.widget.ListView.BdTypeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (BdTypeListView.this.mTypeAdapter != null) {
                    BdTypeListView.this.mTypeAdapter.onItemClick(adapterView, view, i, j);
                }
            }
        });
        super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.adp.widget.ListView.BdTypeListView.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (BdTypeListView.this.mTypeAdapter != null) {
                    return BdTypeListView.this.mTypeAdapter.onItemLongClick(adapterView, view, i, j);
                }
                return false;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.adp.widget.ListView.p
    /* renamed from: getListView */
    public BdListView getListView2() {
        return this;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
    }

    @Override // com.baidu.adp.widget.ListView.s
    public void addAdapters(List<a> list) {
        for (a<n, TypeAdapter.ViewHolder> aVar : list) {
            if (aVar != null) {
                BdUniqueId bdUniqueId = null;
                if (aVar.ql() != null) {
                    bdUniqueId = aVar.ql();
                    if (!this.Xo.containsKey(bdUniqueId)) {
                        h hVar = new h(aVar.mContext, bdUniqueId, aVar.mPageId);
                        hVar.a(aVar);
                        this.mTypeAdapter.addAdapter(hVar);
                        this.Xo.put(bdUniqueId, hVar);
                    }
                }
                if (aVar.qm() != null) {
                    bdUniqueId = aVar.qm();
                    if (!this.Xo.containsKey(bdUniqueId)) {
                        h hVar2 = new h(aVar.mContext, bdUniqueId, aVar.mPageId);
                        hVar2.a(aVar);
                        this.mTypeAdapter.addAdapter(hVar2);
                        this.Xo.put(bdUniqueId, hVar2);
                    }
                }
                if (aVar.qn() != null) {
                    bdUniqueId = aVar.qn();
                    if (!this.Xo.containsKey(bdUniqueId)) {
                        h hVar3 = new h(aVar.mContext, bdUniqueId, aVar.mPageId);
                        hVar3.a(aVar);
                        this.mTypeAdapter.addAdapter(hVar3);
                        this.Xo.put(bdUniqueId, hVar3);
                    }
                }
                if (aVar.qo() != null) {
                    bdUniqueId = aVar.qo();
                    if (!this.Xo.containsKey(bdUniqueId)) {
                        h hVar4 = new h(aVar.mContext, bdUniqueId, aVar.mPageId);
                        hVar4.a(aVar);
                        this.mTypeAdapter.addAdapter(hVar4);
                        this.Xo.put(bdUniqueId, hVar4);
                    }
                }
                if (bdUniqueId == null) {
                    this.mTypeAdapter.addAdapter(aVar);
                } else {
                    this.Xn.put(aVar.Wm, aVar);
                }
            }
        }
        setAdapter((ListAdapter) this.mTypeAdapter);
    }

    @Override // com.baidu.adp.widget.ListView.s
    public void setData(List<? extends n> list) {
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if (nVar != null) {
                if (this.Xn.containsKey(nVar.getType())) {
                    a aVar = this.Xn.get(nVar.getType());
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
        this.mTypeAdapter.setData(arrayList);
    }

    @Override // com.baidu.adp.widget.ListView.s
    public List<n> getData() {
        return this.mTypeAdapter.getData();
    }

    public n getItem(int i) {
        return this.mTypeAdapter.getItem(i);
    }
}
