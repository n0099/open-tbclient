package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.h {
    private ICardInfo OX;
    public g OY;
    public boolean OZ;
    private AdvertAppInfo Pb;
    private e adModel;
    private boolean Pa = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.OY = gVar;
        return dVar;
    }

    public ICardInfo oj() {
        return this.OX;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return oj() != null ? b.OQ : b.OP;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlay(boolean z) {
        if (oj() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) oj()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setWaitConfirm(boolean z) {
        if (oj() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) oj()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.OX = eVar != null ? eVar.Pd : null;
        if (this.OX instanceof h) {
            ((h) this.OX).setAdFacadeData(this);
        }
        this.Pa = true;
    }

    public AdvertAppInfo ok() {
        if (this.Pb == null) {
            this.Pb = new AdvertAppInfo();
            if (this.OY != null) {
                Map<String, String> oi = this.OY.oi();
                this.Pb.adPosition = String.valueOf(this.OY.oh());
                this.Pb.tid = oi != null ? oi.get("thread_id") : "";
                this.Pb.setFid(oi != null ? Long.valueOf(oi.get("forum_id")).longValue() : 0L);
            }
            this.Pb.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Pb.adp = "VIDEO_LIST";
        }
        return this.Pb;
    }

    public int getPageNum() {
        if (this.OY != null) {
            return this.OY.og();
        }
        return 0;
    }

    public e ol() {
        return this.adModel;
    }

    public void om() {
        if (!this.Pa) {
            com.baidu.tieba.recapp.report.b.bpc().a(com.baidu.tieba.recapp.report.e.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.OX == null || !(this.OX instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.OX).getParallelCharge();
    }
}
