package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo QT;
    public g QU;
    public boolean QV;
    private AdvertAppInfo QX;
    private e adModel;
    private boolean QW = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.QU = gVar;
        return dVar;
    }

    public ICardInfo oL() {
        return this.QT;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return oL() != null ? b.QL : b.QK;
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
        this.QT = eVar != null ? eVar.QZ : null;
        if (this.QT instanceof h) {
            ((h) this.QT).setAdFacadeData(this);
        }
        this.QW = true;
    }

    public AdvertAppInfo oM() {
        if (this.QX == null) {
            this.QX = new AdvertAppInfo();
            if (this.QU != null) {
                Map<String, String> oK = this.QU.oK();
                this.QX.adPosition = String.valueOf(this.QU.oJ());
                this.QX.tid = oK != null ? oK.get("thread_id") : "";
                this.QX.setFid(oK != null ? Long.valueOf(oK.get("forum_id")).longValue() : 0L);
            }
            this.QX.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.QX.page = "VIDEO_LIST";
        }
        return this.QX;
    }

    public int getPageNum() {
        if (this.QU != null) {
            return this.QU.oI();
        }
        return 0;
    }

    public e oN() {
        return this.adModel;
    }

    public void oO() {
        if (!this.QW) {
            com.baidu.tieba.recapp.report.c.cfH().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.QT == null || !(this.QT instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.QT).getParallelCharge();
    }
}
