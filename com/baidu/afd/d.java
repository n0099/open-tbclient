package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo Rl;
    public g Rm;
    public boolean Rn;
    private AdvertAppInfo Rp;
    private e adModel;
    private boolean Ro = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.Rm = gVar;
        return dVar;
    }

    public ICardInfo pg() {
        return this.Rl;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return pg() != null ? b.Re : b.Rd;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (pg() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) pg()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (pg() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) pg()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.Rl = eVar != null ? eVar.Rr : null;
        if (this.Rl instanceof h) {
            ((h) this.Rl).setAdFacadeData(this);
        }
        this.Ro = true;
    }

    public AdvertAppInfo ph() {
        if (this.Rp == null) {
            this.Rp = new AdvertAppInfo();
            if (this.Rm != null) {
                Map<String, String> pf = this.Rm.pf();
                this.Rp.adPosition = String.valueOf(this.Rm.pe());
                this.Rp.tid = pf != null ? pf.get("thread_id") : "";
                this.Rp.setFid(pf != null ? Long.valueOf(pf.get("forum_id")).longValue() : 0L);
            }
            this.Rp.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Rp.page = "VIDEO_LIST";
        }
        return this.Rp;
    }

    public int getPageNum() {
        if (this.Rm != null) {
            return this.Rm.pd();
        }
        return 0;
    }

    public e pi() {
        return this.adModel;
    }

    public void pj() {
        if (!this.Ro) {
            com.baidu.tieba.recapp.report.c.ciy().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Rl == null || !(this.Rl instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.Rl).getParallelCharge();
    }
}
