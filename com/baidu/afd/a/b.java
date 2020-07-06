package com.baidu.afd.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.h;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.recapp.report.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.afd.d, a> implements f {
    private ICardInfo XP;
    private TbPageContext XQ;
    private com.baidu.tieba.frs.aggregation.a XR;
    private com.baidu.tieba.frs.videomiddlepage.c XS;
    private j XT;
    private List<j> XU;
    private f XV;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.XU = new ArrayList();
        this.XQ = tbPageContext;
        this.XR = aVar;
        this.XS = cVar;
        this.XV = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: h */
    public a b(ViewGroup viewGroup) {
        e a;
        if (this.XP == null || (a = com.baidu.tieba.lego.card.b.cxd().a(this.XQ, this.XP, 2)) == null) {
            return null;
        }
        if (a instanceof j) {
            this.XU.add((j) a);
        }
        a.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.afd.a.b.1
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i, HashMap<String, Object> hashMap) {
                b.this.a(b.this.adFacadeData, false, b.this.adFacadeData.getPageNum(), "", (String) null);
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str, String str2, HashMap<String, Object> hashMap) {
                b.this.a(b.this.adFacadeData, false, b.this.adFacadeData.getPageNum(), "", (String) null);
            }
        });
        return new a(a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public a a(ViewGroup viewGroup, com.baidu.afd.d dVar) {
        if (dVar == null || dVar.pK() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.XP = dVar.pK();
        return b(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo pL = dVar.pL();
            int i2 = 2;
            if (pL != null && pL.legoCard != null && pL.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.c c = g.c(pL, i2, i);
            c.Ma(str2);
            com.baidu.tieba.recapp.report.d.cZR().a(c);
            com.baidu.tieba.lego.card.b.c.a(dVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar, a aVar) {
        if (dVar == null || aVar == null) {
            return null;
        }
        if (aVar.pP() instanceof h) {
            h hVar = (h) aVar.pP();
            hVar.setAutoPlayCallBack(this.XR);
            hVar.setOnVideoContainerForegroundClickListener(this.XS);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.pN();
        if (aVar.pP() != null) {
            aVar.pP().setPosition(i);
            aVar.pP().aE(dVar.pK());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.XP = dVar.pK();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void pQ() {
        if (this.XT != null) {
            this.XT.awZ();
        }
    }

    public void pR() {
        if (this.XT != null) {
            this.XT.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        this.XT = jVar;
        if (this.XV != null) {
            this.XV.a(this.XT);
        }
    }

    public boolean pS() {
        if (this.XT != null) {
            return this.XT.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (j jVar : this.XU) {
            if (jVar != null) {
                jVar.onDestroy();
            }
        }
    }
}
