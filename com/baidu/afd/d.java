package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.h {
    private ICardInfo RO;
    public g RP;
    public boolean RQ;
    private AdvertAppInfo RT;
    private e adModel;
    private boolean RR = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.RP = gVar;
        return dVar;
    }

    public ICardInfo pw() {
        return this.RO;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return pw() != null ? b.RG : b.RF;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlay(boolean z) {
        if (pw() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) pw()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setWaitConfirm(boolean z) {
        if (pw() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) pw()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.RO = eVar != null ? eVar.RV : null;
        if (this.RO instanceof h) {
            ((h) this.RO).setAdFacadeData(this);
        }
        this.RR = true;
    }

    public AdvertAppInfo px() {
        if (this.RT == null) {
            this.RT = new AdvertAppInfo();
            if (this.RP != null) {
                Map<String, String> pv = this.RP.pv();
                this.RT.adPosition = String.valueOf(this.RP.pu());
                this.RT.tid = pv != null ? pv.get("thread_id") : "";
                this.RT.setFid(pv != null ? Long.valueOf(pv.get("forum_id")).longValue() : 0L);
            }
            this.RT.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.RT.page = "VIDEO_LIST";
        }
        return this.RT;
    }

    public int getPageNum() {
        if (this.RP != null) {
            return this.RP.pt();
        }
        return 0;
    }

    public e py() {
        return this.adModel;
    }

    public void pz() {
        if (!this.RR) {
            com.baidu.tieba.recapp.report.c.buf().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.RO == null || !(this.RO instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.RO).getParallelCharge();
    }
}
