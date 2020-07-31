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
    private ICardInfo XH;
    private TbPageContext XI;
    private com.baidu.tieba.frs.aggregation.a XJ;
    private com.baidu.tieba.frs.videomiddlepage.c XK;
    private j XL;
    private List<j> XM;
    private f XN;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.XM = new ArrayList();
        this.XI = tbPageContext;
        this.XJ = aVar;
        this.XK = cVar;
        this.XN = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: h */
    public a b(ViewGroup viewGroup) {
        e a;
        if (this.XH == null || (a = com.baidu.tieba.lego.card.b.cBb().a(this.XI, this.XH, 2)) == null) {
            return null;
        }
        if (a instanceof j) {
            this.XM.add((j) a);
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
        if (dVar == null || dVar.pL() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.XH = dVar.pL();
        return b(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo pM = dVar.pM();
            int i2 = 2;
            if (pM != null && pM.legoCard != null && pM.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.c c = g.c(pM, i2, i);
            c.MI(str2);
            com.baidu.tieba.recapp.report.d.dcY().a(c);
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
        if (aVar.pQ() instanceof h) {
            h hVar = (h) aVar.pQ();
            hVar.setAutoPlayCallBack(this.XJ);
            hVar.setOnVideoContainerForegroundClickListener(this.XK);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.pO();
        if (aVar.pQ() != null) {
            aVar.pQ().setPosition(i);
            aVar.pQ().aE(dVar.pL());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.XH = dVar.pL();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void pR() {
        if (this.XL != null) {
            this.XL.azN();
        }
    }

    public void pS() {
        if (this.XL != null) {
            this.XL.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        this.XL = jVar;
        if (this.XN != null) {
            this.XN.a(this.XL);
        }
    }

    public boolean pT() {
        if (this.XL != null) {
            return this.XL.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (j jVar : this.XM) {
            if (jVar != null) {
                jVar.onDestroy();
            }
        }
    }
}
