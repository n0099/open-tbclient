package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.h {
    private ICardInfo OZ;
    public g Pa;
    public boolean Pb;
    private AdvertAppInfo Pd;
    private e adModel;
    private boolean Pc = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.Pa = gVar;
        return dVar;
    }

    public ICardInfo oj() {
        return this.OZ;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return oj() != null ? b.OT : b.OR;
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
        this.OZ = eVar != null ? eVar.Pf : null;
        if (this.OZ instanceof h) {
            ((h) this.OZ).setAdFacadeData(this);
        }
        this.Pc = true;
    }

    public AdvertAppInfo ok() {
        if (this.Pd == null) {
            this.Pd = new AdvertAppInfo();
            if (this.Pa != null) {
                Map<String, String> oi = this.Pa.oi();
                this.Pd.adPosition = String.valueOf(this.Pa.oh());
                this.Pd.tid = oi != null ? oi.get("thread_id") : "";
                this.Pd.setFid(oi != null ? Long.valueOf(oi.get("forum_id")).longValue() : 0L);
            }
            this.Pd.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Pd.adE = "VIDEO_LIST";
        }
        return this.Pd;
    }

    public int getPageNum() {
        if (this.Pa != null) {
            return this.Pa.og();
        }
        return 0;
    }

    public e ol() {
        return this.adModel;
    }

    public void om() {
        if (!this.Pc) {
            com.baidu.tieba.recapp.report.b.bpD().a(com.baidu.tieba.recapp.report.e.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.OZ == null || !(this.OZ instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.OZ).getParallelCharge();
    }
}
