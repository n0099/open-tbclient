package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo WJ;
    public g WK;
    public boolean WL;
    private AdvertAppInfo WN;
    private e adModel;
    private boolean WM = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.WK = gVar;
        return dVar;
    }

    public ICardInfo pn() {
        return this.WJ;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return pn() != null ? b.WC : b.WB;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (pn() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) pn()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (pn() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) pn()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.WJ = eVar != null ? eVar.WP : null;
        if (this.WJ instanceof h) {
            ((h) this.WJ).setAdFacadeData(this);
        }
        this.WM = true;
    }

    public AdvertAppInfo po() {
        if (this.WN == null) {
            this.WN = new AdvertAppInfo();
            if (this.WK != null) {
                Map<String, String> pm = this.WK.pm();
                this.WN.adPosition = String.valueOf(this.WK.pl());
                this.WN.tid = pm != null ? pm.get("thread_id") : "";
                this.WN.setFid(pm != null ? Long.valueOf(pm.get("forum_id")).longValue() : 0L);
            }
            this.WN.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.WN.page = "VIDEO_LIST";
        }
        return this.WN;
    }

    public int getPageNum() {
        if (this.WK != null) {
            return this.WK.pk();
        }
        return 0;
    }

    public e pp() {
        return this.adModel;
    }

    public void pq() {
        if (!this.WM) {
            com.baidu.tieba.recapp.report.d.cOi().a(com.baidu.tieba.recapp.report.g.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.WJ == null || !(this.WJ instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.WJ).getParallelCharge();
    }
}
