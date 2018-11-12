package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.h {
    private ICardInfo RQ;
    public g RR;
    public boolean RT;
    private AdvertAppInfo RV;
    private e adModel;
    private boolean RU = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.RR = gVar;
        return dVar;
    }

    public ICardInfo pu() {
        return this.RQ;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return pu() != null ? b.RI : b.RH;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlay(boolean z) {
        if (pu() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) pu()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setWaitConfirm(boolean z) {
        if (pu() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) pu()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.RQ = eVar != null ? eVar.RX : null;
        if (this.RQ instanceof h) {
            ((h) this.RQ).setAdFacadeData(this);
        }
        this.RU = true;
    }

    public AdvertAppInfo pv() {
        if (this.RV == null) {
            this.RV = new AdvertAppInfo();
            if (this.RR != null) {
                Map<String, String> pt = this.RR.pt();
                this.RV.adPosition = String.valueOf(this.RR.ps());
                this.RV.tid = pt != null ? pt.get("thread_id") : "";
                this.RV.setFid(pt != null ? Long.valueOf(pt.get("forum_id")).longValue() : 0L);
            }
            this.RV.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.RV.page = "VIDEO_LIST";
        }
        return this.RV;
    }

    public int getPageNum() {
        if (this.RR != null) {
            return this.RR.pr();
        }
        return 0;
    }

    public e pw() {
        return this.adModel;
    }

    public void px() {
        if (!this.RU) {
            com.baidu.tieba.recapp.report.c.btB().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.RQ == null || !(this.RQ instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.RQ).getParallelCharge();
    }
}
