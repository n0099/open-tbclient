package com.baidu.afd.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.g;
import com.baidu.tieba.lego.card.view.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.afd.d, a> implements f {
    private ICardInfo Pm;
    private TbPageContext Pn;
    private com.baidu.tieba.frs.aggregation.a Po;
    private com.baidu.tieba.frs.videomiddlepage.b Pp;
    private i Pq;
    private List<i> Pr;
    private f Ps;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.b bVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Pr = new ArrayList();
        this.Pn = tbPageContext;
        this.Po = aVar;
        this.Pp = bVar;
        this.Ps = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: d */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        e a;
        if (this.Pm == null || (a = com.baidu.tieba.lego.card.b.aQa().a(this.Pn, this.Pm, 2)) == null) {
            return null;
        }
        if (a instanceof i) {
            this.Pr.add((i) a);
        }
        a.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.afd.a.b.1
            @Override // com.baidu.tieba.lego.card.a
            public void b(int i, HashMap<String, Object> hashMap) {
                b.this.a(b.this.adFacadeData, false, b.this.adFacadeData.getPageNum(), "", (String) null);
            }

            @Override // com.baidu.tieba.lego.card.a
            public void b(String str, String str2, HashMap<String, Object> hashMap) {
                b.this.a(b.this.adFacadeData, false, b.this.adFacadeData.getPageNum(), "", (String) null);
            }
        });
        return new a(a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo ok = dVar.ok();
            int i2 = 2;
            if (ok != null && ok.legoCard != null && ok.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(ok, i2, i);
            c.ta(str2);
            com.baidu.tieba.recapp.report.b.bpD().a(c);
            com.baidu.tieba.lego.card.b.c.a(dVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar, a aVar) {
        if (dVar == null || aVar == null) {
            return null;
        }
        if (aVar.oo() instanceof g) {
            g gVar = (g) aVar.oo();
            gVar.setAutoPlayCallBack(this.Po);
            gVar.setOnVideoContainerForegroundClickListener(this.Pp);
            gVar.setCurrentPlayCallBack(this);
        }
        dVar.om();
        if (aVar.oo() != null) {
            aVar.oo().setPosition(i);
            aVar.oo().T(dVar.oj());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Pm = dVar.oj();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void op() {
        if (this.Pq != null) {
            this.Pq.pausePlay();
        }
    }

    public void oq() {
        if (this.Pq != null) {
            this.Pq.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(i iVar) {
        this.Pq = iVar;
        if (this.Ps != null) {
            this.Ps.a(this.Pq);
        }
    }

    public boolean or() {
        if (this.Pq != null) {
            return this.Pq.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (i iVar : this.Pr) {
            if (iVar != null) {
                iVar.onDestroy();
            }
        }
    }
}
