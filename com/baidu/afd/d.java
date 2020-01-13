package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo CQ;
    public g CT;
    public boolean CU;
    private AdvertAppInfo CW;
    private e adModel;
    private boolean CV = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.CT = gVar;
        return dVar;
    }

    public ICardInfo ku() {
        return this.CQ;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ku() != null ? b.CJ : b.CI;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (ku() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) ku()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (ku() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) ku()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.CQ = eVar != null ? eVar.CY : null;
        if (this.CQ instanceof h) {
            ((h) this.CQ).setAdFacadeData(this);
        }
        this.CV = true;
    }

    public AdvertAppInfo kv() {
        if (this.CW == null) {
            this.CW = new AdvertAppInfo();
            if (this.CT != null) {
                Map<String, String> kt = this.CT.kt();
                this.CW.adPosition = String.valueOf(this.CT.ks());
                this.CW.tid = kt != null ? kt.get("thread_id") : "";
                this.CW.setFid(kt != null ? Long.valueOf(kt.get("forum_id")).longValue() : 0L);
            }
            this.CW.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.CW.page = "VIDEO_LIST";
        }
        return this.CW;
    }

    public int getPageNum() {
        if (this.CT != null) {
            return this.CT.kr();
        }
        return 0;
    }

    public e kw() {
        return this.adModel;
    }

    public void kx() {
        if (!this.CV) {
            com.baidu.tieba.recapp.report.c.cBP().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.CQ == null || !(this.CQ instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.CQ).getParallelCharge();
    }
}
