package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo CL;
    public g CM;
    public boolean CN;
    private AdvertAppInfo CP;
    private e adModel;
    private boolean CO = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.CM = gVar;
        return dVar;
    }

    public ICardInfo kt() {
        return this.CL;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kt() != null ? b.CE : b.CD;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (kt() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) kt()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (kt() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) kt()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.CL = eVar != null ? eVar.CT : null;
        if (this.CL instanceof h) {
            ((h) this.CL).setAdFacadeData(this);
        }
        this.CO = true;
    }

    public AdvertAppInfo ku() {
        if (this.CP == null) {
            this.CP = new AdvertAppInfo();
            if (this.CM != null) {
                Map<String, String> ks = this.CM.ks();
                this.CP.adPosition = String.valueOf(this.CM.kr());
                this.CP.tid = ks != null ? ks.get("thread_id") : "";
                this.CP.setFid(ks != null ? Long.valueOf(ks.get("forum_id")).longValue() : 0L);
            }
            this.CP.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.CP.page = "VIDEO_LIST";
        }
        return this.CP;
    }

    public int getPageNum() {
        if (this.CM != null) {
            return this.CM.kq();
        }
        return 0;
    }

    public e kv() {
        return this.adModel;
    }

    public void kw() {
        if (!this.CO) {
            com.baidu.tieba.recapp.report.c.cAJ().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.CL == null || !(this.CL instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.CL).getParallelCharge();
    }
}
