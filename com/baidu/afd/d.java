package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo QU;
    public g QV;
    public boolean QW;
    private AdvertAppInfo QY;
    private e adModel;
    private boolean QX = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.QV = gVar;
        return dVar;
    }

    public ICardInfo oL() {
        return this.QU;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return oL() != null ? b.QM : b.QL;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (oL() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) oL()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (oL() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) oL()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.QU = eVar != null ? eVar.Ra : null;
        if (this.QU instanceof h) {
            ((h) this.QU).setAdFacadeData(this);
        }
        this.QX = true;
    }

    public AdvertAppInfo oM() {
        if (this.QY == null) {
            this.QY = new AdvertAppInfo();
            if (this.QV != null) {
                Map<String, String> oK = this.QV.oK();
                this.QY.adPosition = String.valueOf(this.QV.oJ());
                this.QY.tid = oK != null ? oK.get("thread_id") : "";
                this.QY.setFid(oK != null ? Long.valueOf(oK.get("forum_id")).longValue() : 0L);
            }
            this.QY.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.QY.page = "VIDEO_LIST";
        }
        return this.QY;
    }

    public int getPageNum() {
        if (this.QV != null) {
            return this.QV.oI();
        }
        return 0;
    }

    public e oN() {
        return this.adModel;
    }

    public void oO() {
        if (!this.QX) {
            com.baidu.tieba.recapp.report.c.cfE().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.QU == null || !(this.QU instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.QU).getParallelCharge();
    }
}
