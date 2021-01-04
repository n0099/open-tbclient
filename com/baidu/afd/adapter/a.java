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
    private ICardInfo aaJ;
    private TbPageContext aaK;
    private com.baidu.tieba.frs.aggregation.a aaL;
    private c aaM;
    private k aaN;
    private List<k> aaO;
    private f aaP;
    private d adFacadeData;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aaO = new ArrayList();
        this.aaK = tbPageContext;
        this.aaL = aVar;
        this.aaM = cVar;
        this.aaP = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: h */
    public AdCardViewHolder e(ViewGroup viewGroup) {
        e a2;
        if (this.aaJ == null || (a2 = com.baidu.tieba.lego.card.b.ddl().a(this.aaK, this.aaJ, 2)) == null) {
            return null;
        }
        if (a2 instanceof k) {
            this.aaO.add((k) a2);
        }
        a2.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.afd.adapter.a.1
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i, HashMap<String, Object> hashMap) {
                a.this.a(a.this.adFacadeData, false, a.this.adFacadeData.getPageNum(), "", (String) null);
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str, String str2, HashMap<String, Object> hashMap) {
                a.this.a(a.this.adFacadeData, false, a.this.adFacadeData.getPageNum(), "", (String) null);
            }
        });
        return new AdCardViewHolder(a2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public AdCardViewHolder a(ViewGroup viewGroup, d dVar) {
        if (dVar == null || dVar.qT() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.aaJ = dVar.qT();
        return e(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo qU = dVar.qU();
            int i2 = 2;
            if (qU != null && qU.legoCard != null && qU.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.c b2 = h.b(qU, i2, i);
            b2.Sa(str2);
            com.baidu.tieba.recapp.report.e.dFV().a(b2);
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
        if (adCardViewHolder.qY() instanceof com.baidu.tieba.lego.card.view.h) {
            com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) adCardViewHolder.qY();
            hVar.setAutoPlayCallBack(this.aaL);
            hVar.setOnVideoContainerForegroundClickListener(this.aaM);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.qW();
        if (adCardViewHolder.qY() != null) {
            adCardViewHolder.qY().setPosition(i);
            adCardViewHolder.qY().aN(dVar.qT());
        }
        return adCardViewHolder.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, d dVar) {
        this.adFacadeData = dVar;
        this.aaJ = dVar.qT();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void qZ() {
        if (this.aaN != null) {
            this.aaN.aUC();
        }
    }

    public void ra() {
        if (this.aaN != null) {
            this.aaN.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(k kVar) {
        this.aaN = kVar;
        if (this.aaP != null) {
            this.aaP.a(this.aaN);
        }
    }

    public boolean rb() {
        if (this.aaN != null) {
            return this.aaN.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (k kVar : this.aaO) {
            if (kVar != null) {
                kVar.onDestroy();
            }
        }
    }
}
