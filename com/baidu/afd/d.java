package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.h {
    private ICardInfo Sa;
    public g Sb;
    public boolean Sc;
    private AdvertAppInfo Se;
    private e adModel;
    private boolean Sd = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.Sb = gVar;
        return dVar;
    }

    public ICardInfo px() {
        return this.Sa;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return px() != null ? b.RU : b.RT;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlay(boolean z) {
        if (px() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) px()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setWaitConfirm(boolean z) {
        if (px() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) px()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.Sa = eVar != null ? eVar.Sg : null;
        if (this.Sa instanceof h) {
            ((h) this.Sa).setAdFacadeData(this);
        }
        this.Sd = true;
    }

    public AdvertAppInfo py() {
        if (this.Se == null) {
            this.Se = new AdvertAppInfo();
            if (this.Sb != null) {
                Map<String, String> pw = this.Sb.pw();
                this.Se.adPosition = String.valueOf(this.Sb.pv());
                this.Se.tid = pw != null ? pw.get("thread_id") : "";
                this.Se.setFid(pw != null ? Long.valueOf(pw.get("forum_id")).longValue() : 0L);
            }
            this.Se.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Se.page = "VIDEO_LIST";
        }
        return this.Se;
    }

    public int getPageNum() {
        if (this.Sb != null) {
            return this.Sb.pu();
        }
        return 0;
    }

    public e pz() {
        return this.adModel;
    }

    public void pA() {
        if (!this.Sd) {
            com.baidu.tieba.recapp.report.c.bwO().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Sa == null || !(this.Sa instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.Sa).getParallelCharge();
    }
}
