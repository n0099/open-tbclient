package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.h {
    private ICardInfo OW;
    public g OX;
    public boolean OY;
    private AdvertAppInfo Pa;
    private e adModel;
    private boolean OZ = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.OX = gVar;
        return dVar;
    }

    public ICardInfo oi() {
        return this.OW;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return oi() != null ? b.OP : b.OO;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlay(boolean z) {
        if (oi() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) oi()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setWaitConfirm(boolean z) {
        if (oi() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) oi()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.OW = eVar != null ? eVar.Pc : null;
        if (this.OW instanceof h) {
            ((h) this.OW).setAdFacadeData(this);
        }
        this.OZ = true;
    }

    public AdvertAppInfo oj() {
        if (this.Pa == null) {
            this.Pa = new AdvertAppInfo();
            if (this.OX != null) {
                Map<String, String> oh = this.OX.oh();
                this.Pa.adPosition = String.valueOf(this.OX.og());
                this.Pa.tid = oh != null ? oh.get("thread_id") : "";
                this.Pa.setFid(oh != null ? Long.valueOf(oh.get("forum_id")).longValue() : 0L);
            }
            this.Pa.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Pa.page = "VIDEO_LIST";
        }
        return this.Pa;
    }

    public int getPageNum() {
        if (this.OX != null) {
            return this.OX.of();
        }
        return 0;
    }

    public e ok() {
        return this.adModel;
    }

    public void ol() {
        if (!this.OZ) {
            com.baidu.tieba.recapp.report.c.boj().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.OW == null || !(this.OW instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.OW).getParallelCharge();
    }
}
