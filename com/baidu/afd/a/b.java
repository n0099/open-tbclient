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
    private ICardInfo RK;
    private TbPageContext RL;
    private com.baidu.tieba.frs.aggregation.a RO;
    private com.baidu.tieba.frs.videomiddlepage.b RP;
    private i RQ;
    private List<i> RR;
    private f RT;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.b bVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.RR = new ArrayList();
        this.RL = tbPageContext;
        this.RO = aVar;
        this.RP = bVar;
        this.RT = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        e a;
        if (this.RK == null || (a = com.baidu.tieba.lego.card.b.aTm().a(this.RL, this.RK, 2)) == null) {
            return null;
        }
        if (a instanceof i) {
            this.RR.add((i) a);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public a onCreateViewHolder(ViewGroup viewGroup, com.baidu.afd.d dVar) {
        if (dVar == null || dVar.po() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.RK = dVar.po();
        return onCreateViewHolder(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo pp = dVar.pp();
            int i2 = 2;
            if (pp != null && pp.legoCard != null && pp.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(pp, i2, i);
            c.tI(str2);
            com.baidu.tieba.recapp.report.c.bqQ().a(c);
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
        if (aVar.pt() instanceof g) {
            g gVar = (g) aVar.pt();
            gVar.setAutoPlayCallBack(this.RO);
            gVar.setOnVideoContainerForegroundClickListener(this.RP);
            gVar.setCurrentPlayCallBack(this);
        }
        dVar.pr();
        if (aVar.pt() != null) {
            aVar.pt().setPosition(i);
            aVar.pt().W(dVar.po());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.RK = dVar.po();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void pu() {
        if (this.RQ != null) {
            this.RQ.pausePlay();
        }
    }

    public void pv() {
        if (this.RQ != null) {
            this.RQ.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(i iVar) {
        this.RQ = iVar;
        if (this.RT != null) {
            this.RT.a(this.RQ);
        }
    }

    public boolean pw() {
        if (this.RQ != null) {
            return this.RQ.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (i iVar : this.RR) {
            if (iVar != null) {
                iVar.onDestroy();
            }
        }
    }
}
