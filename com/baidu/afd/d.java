package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.h {
    private ICardInfo Ti;
    public g Tj;
    public boolean Tk;
    private AdvertAppInfo Tm;
    private e adModel;
    private boolean Tl = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.Tj = gVar;
        return dVar;
    }

    public ICardInfo pQ() {
        return this.Ti;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return pQ() != null ? b.Tc : b.Tb;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlay(boolean z) {
        if (pQ() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) pQ()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setWaitConfirm(boolean z) {
        if (pQ() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) pQ()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.Ti = eVar != null ? eVar.To : null;
        if (this.Ti instanceof h) {
            ((h) this.Ti).setAdFacadeData(this);
        }
        this.Tl = true;
    }

    public AdvertAppInfo pR() {
        if (this.Tm == null) {
            this.Tm = new AdvertAppInfo();
            if (this.Tj != null) {
                Map<String, String> pP = this.Tj.pP();
                this.Tm.adPosition = String.valueOf(this.Tj.pO());
                this.Tm.tid = pP != null ? pP.get("thread_id") : "";
                this.Tm.setFid(pP != null ? Long.valueOf(pP.get("forum_id")).longValue() : 0L);
            }
            this.Tm.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Tm.page = "VIDEO_LIST";
        }
        return this.Tm;
    }

    public int getPageNum() {
        if (this.Tj != null) {
            return this.Tj.pN();
        }
        return 0;
    }

    public e pS() {
        return this.adModel;
    }

    public void pT() {
        if (!this.Tl) {
            com.baidu.tieba.recapp.report.c.bXA().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Ti == null || !(this.Ti instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.Ti).getParallelCharge();
    }
}
