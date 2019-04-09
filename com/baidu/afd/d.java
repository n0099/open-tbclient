package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.h {
    private ICardInfo Tj;
    public g Tk;
    public boolean Tl;
    private AdvertAppInfo Tn;
    private e adModel;
    private boolean Tm = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.Tk = gVar;
        return dVar;
    }

    public ICardInfo pQ() {
        return this.Tj;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return pQ() != null ? b.Td : b.Tc;
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
        this.Tj = eVar != null ? eVar.Tp : null;
        if (this.Tj instanceof h) {
            ((h) this.Tj).setAdFacadeData(this);
        }
        this.Tm = true;
    }

    public AdvertAppInfo pR() {
        if (this.Tn == null) {
            this.Tn = new AdvertAppInfo();
            if (this.Tk != null) {
                Map<String, String> pP = this.Tk.pP();
                this.Tn.adPosition = String.valueOf(this.Tk.pO());
                this.Tn.tid = pP != null ? pP.get("thread_id") : "";
                this.Tn.setFid(pP != null ? Long.valueOf(pP.get("forum_id")).longValue() : 0L);
            }
            this.Tn.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Tn.page = "VIDEO_LIST";
        }
        return this.Tn;
    }

    public int getPageNum() {
        if (this.Tk != null) {
            return this.Tk.pN();
        }
        return 0;
    }

    public e pS() {
        return this.adModel;
    }

    public void pT() {
        if (!this.Tm) {
            com.baidu.tieba.recapp.report.c.bXA().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Tj == null || !(this.Tj instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.Tj).getParallelCharge();
    }
}
