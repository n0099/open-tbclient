package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.h {
    private AdvertAppInfo RB;
    private ICardInfo Rx;
    public g Ry;
    public boolean Rz;
    private e adModel;
    private boolean RA = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.Ry = gVar;
        return dVar;
    }

    public ICardInfo po() {
        return this.Rx;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return po() != null ? b.Rr : b.Rq;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlay(boolean z) {
        if (po() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) po()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setWaitConfirm(boolean z) {
        if (po() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) po()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.Rx = eVar != null ? eVar.RD : null;
        if (this.Rx instanceof h) {
            ((h) this.Rx).setAdFacadeData(this);
        }
        this.RA = true;
    }

    public AdvertAppInfo pp() {
        if (this.RB == null) {
            this.RB = new AdvertAppInfo();
            if (this.Ry != null) {
                Map<String, String> pn = this.Ry.pn();
                this.RB.adPosition = String.valueOf(this.Ry.pm());
                this.RB.tid = pn != null ? pn.get("thread_id") : "";
                this.RB.setFid(pn != null ? Long.valueOf(pn.get("forum_id")).longValue() : 0L);
            }
            this.RB.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.RB.page = "VIDEO_LIST";
        }
        return this.RB;
    }

    public int getPageNum() {
        if (this.Ry != null) {
            return this.Ry.pl();
        }
        return 0;
    }

    public e pq() {
        return this.adModel;
    }

    public void pr() {
        if (!this.RA) {
            com.baidu.tieba.recapp.report.c.bqQ().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Rx == null || !(this.Rx instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.Rx).getParallelCharge();
    }
}
