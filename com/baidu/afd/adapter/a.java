package com.baidu.afd.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.d;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.frs.videomiddlepage.c;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.k;
import com.baidu.tieba.recapp.report.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<d, AdCardViewHolder> implements f {
    private ICardInfo aaD;
    private TbPageContext aaE;
    private com.baidu.tieba.frs.aggregation.a aaF;
    private c aaG;
    private k aaH;
    private List<k> aaI;
    private f aaJ;
    private d adFacadeData;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aaI = new ArrayList();
        this.aaE = tbPageContext;
        this.aaF = aVar;
        this.aaG = cVar;
        this.aaJ = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: h */
    public AdCardViewHolder e(ViewGroup viewGroup) {
        e a2;
        if (this.aaD == null || (a2 = com.baidu.tieba.lego.card.b.dbz().a(this.aaE, this.aaD, 2)) == null) {
            return null;
        }
        if (a2 instanceof k) {
            this.aaI.add((k) a2);
        }
        a2.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.afd.adapter.a.1
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i, HashMap<String, Object> hashMap) {
                a.this.a(a.this.adFacadeData, a.this.adFacadeData.getPageNum());
            }

            @Override // com.baidu.tieba.lego.card.a
            public void b(String str, String str2, HashMap<String, Object> hashMap) {
                a.this.a(a.this.adFacadeData, a.this.adFacadeData.getPageNum());
            }
        });
        return new AdCardViewHolder(a2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public AdCardViewHolder a(ViewGroup viewGroup, d dVar) {
        if (dVar == null || dVar.qR() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.aaD = dVar.qR();
        return e(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, int i) {
        if (dVar != null) {
            AdvertAppInfo qS = dVar.qS();
            int i2 = 2;
            if (qS != null && qS.legoCard != null && qS.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.e.dEu().a(h.b(qS, i2, i));
            com.baidu.tieba.lego.card.a.c.a(dVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, d dVar, AdCardViewHolder adCardViewHolder) {
        if (dVar == null || adCardViewHolder == null) {
            return null;
        }
        if (adCardViewHolder.qW() instanceof com.baidu.tieba.lego.card.view.h) {
            com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) adCardViewHolder.qW();
            hVar.setAutoPlayCallBack(this.aaF);
            hVar.setOnVideoContainerForegroundClickListener(this.aaG);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.qU();
        if (adCardViewHolder.qW() != null) {
            adCardViewHolder.qW().setPosition(i);
            adCardViewHolder.qW().aN(dVar.qR());
        }
        return adCardViewHolder.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, d dVar) {
        this.adFacadeData = dVar;
        this.aaD = dVar.qR();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void qX() {
        if (this.aaH != null) {
            this.aaH.pausePlay();
        }
    }

    public void qY() {
        if (this.aaH != null) {
            this.aaH.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(k kVar) {
        this.aaH = kVar;
        if (this.aaJ != null) {
            this.aaJ.a(this.aaH);
        }
    }

    public boolean qZ() {
        if (this.aaH != null) {
            return this.aaH.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (k kVar : this.aaI) {
            if (kVar != null) {
                kVar.onDestroy();
            }
        }
    }
}
