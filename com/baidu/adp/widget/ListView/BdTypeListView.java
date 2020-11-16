package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements v<BdTypeListView> {
    private HashMap<BdUniqueId, a> Wy;
    private HashMap<BdUniqueId, j> Wz;
    af mTypeAdapter;

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
            this.mTypeAdapter = new af();
        }
        if (this.Wy == null) {
            this.Wy = new HashMap<>();
        }
        if (this.Wz == null) {
            this.Wz = new HashMap<>();
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
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.adp.widget.ListView.s
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
                        this.mTypeAdapter.addAdapter(jVar);
                        this.Wz.put(bdUniqueId, jVar);
                    }
                }
                if (aVar.qK() != null) {
                    bdUniqueId = aVar.qK();
                    if (!this.Wz.containsKey(bdUniqueId)) {
                        j jVar2 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar2.a(aVar);
                        this.mTypeAdapter.addAdapter(jVar2);
                        this.Wz.put(bdUniqueId, jVar2);
                    }
                }
                if (aVar.qL() != null) {
                    bdUniqueId = aVar.qL();
                    if (!this.Wz.containsKey(bdUniqueId)) {
                        j jVar3 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar3.a(aVar);
                        this.mTypeAdapter.addAdapter(jVar3);
                        this.Wz.put(bdUniqueId, jVar3);
                    }
                }
                if (aVar.qM() != null) {
                    bdUniqueId = aVar.qM();
                    if (!this.Wz.containsKey(bdUniqueId)) {
                        j jVar4 = new j(aVar.mContext, bdUniqueId, aVar.mPageId);
                        jVar4.a(aVar);
                        this.mTypeAdapter.addAdapter(jVar4);
                        this.Wz.put(bdUniqueId, jVar4);
                    }
                }
                if (bdUniqueId == null) {
                    this.mTypeAdapter.addAdapter(aVar);
                } else {
                    this.Wy.put(aVar.Vx, aVar);
                }
            }
        }
        setAdapter((ListAdapter) this.mTypeAdapter);
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
        this.mTypeAdapter.setData(arrayList);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public List<q> getData() {
        return this.mTypeAdapter.getData();
    }

    public q getItem(int i) {
        return this.mTypeAdapter.getItem(i);
    }
}
