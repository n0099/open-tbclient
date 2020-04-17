package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo WG;
    public g WH;
    public boolean WI;
    private AdvertAppInfo WK;
    private e adModel;
    private boolean WJ = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.WH = gVar;
        return dVar;
    }

    public ICardInfo pn() {
        return this.WG;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return pn() != null ? b.Wz : b.Wy;
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
        this.WG = eVar != null ? eVar.WM : null;
        if (this.WG instanceof h) {
            ((h) this.WG).setAdFacadeData(this);
        }
        this.WJ = true;
    }

    public AdvertAppInfo po() {
        if (this.WK == null) {
            this.WK = new AdvertAppInfo();
            if (this.WH != null) {
                Map<String, String> pm = this.WH.pm();
                this.WK.adPosition = String.valueOf(this.WH.pl());
                this.WK.tid = pm != null ? pm.get("thread_id") : "";
                this.WK.setFid(pm != null ? Long.valueOf(pm.get("forum_id")).longValue() : 0L);
            }
            this.WK.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.WK.page = "VIDEO_LIST";
        }
        return this.WK;
    }

    public int getPageNum() {
        if (this.WH != null) {
            return this.WH.pk();
        }
        return 0;
    }

    public e pp() {
        return this.adModel;
    }

    public void pq() {
        if (!this.WJ) {
            com.baidu.tieba.recapp.report.d.cOl().a(com.baidu.tieba.recapp.report.g.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.WG == null || !(this.WG instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.WG).getParallelCharge();
    }
}
