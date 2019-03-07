package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.h {
    private ICardInfo Th;
    public g Ti;
    public boolean Tj;
    private AdvertAppInfo Tl;
    private e adModel;
    private boolean Tk = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.Ti = gVar;
        return dVar;
    }

    public ICardInfo pQ() {
        return this.Th;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return pQ() != null ? b.Tb : b.Ta;
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
        this.Th = eVar != null ? eVar.Tn : null;
        if (this.Th instanceof h) {
            ((h) this.Th).setAdFacadeData(this);
        }
        this.Tk = true;
    }

    public AdvertAppInfo pR() {
        if (this.Tl == null) {
            this.Tl = new AdvertAppInfo();
            if (this.Ti != null) {
                Map<String, String> pP = this.Ti.pP();
                this.Tl.adPosition = String.valueOf(this.Ti.pO());
                this.Tl.tid = pP != null ? pP.get("thread_id") : "";
                this.Tl.setFid(pP != null ? Long.valueOf(pP.get("forum_id")).longValue() : 0L);
            }
            this.Tl.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Tl.page = "VIDEO_LIST";
        }
        return this.Tl;
    }

    public int getPageNum() {
        if (this.Ti != null) {
            return this.Ti.pN();
        }
        return 0;
    }

    public e pS() {
        return this.adModel;
    }

    public void pT() {
        if (!this.Tk) {
            com.baidu.tieba.recapp.report.c.bXB().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Th == null || !(this.Th instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.Th).getParallelCharge();
    }
}
