package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo Rk;
    public g Rl;
    public boolean Rm;
    private AdvertAppInfo Ro;
    private e adModel;
    private boolean Rn = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.Rl = gVar;
        return dVar;
    }

    public ICardInfo ph() {
        return this.Rk;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ph() != null ? b.Rd : b.Rc;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (ph() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) ph()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (ph() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) ph()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.Rk = eVar != null ? eVar.Rq : null;
        if (this.Rk instanceof h) {
            ((h) this.Rk).setAdFacadeData(this);
        }
        this.Rn = true;
    }

    public AdvertAppInfo pi() {
        if (this.Ro == null) {
            this.Ro = new AdvertAppInfo();
            if (this.Rl != null) {
                Map<String, String> pg = this.Rl.pg();
                this.Ro.adPosition = String.valueOf(this.Rl.pf());
                this.Ro.tid = pg != null ? pg.get("thread_id") : "";
                this.Ro.setFid(pg != null ? Long.valueOf(pg.get("forum_id")).longValue() : 0L);
            }
            this.Ro.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Ro.page = "VIDEO_LIST";
        }
        return this.Ro;
    }

    public int getPageNum() {
        if (this.Rl != null) {
            return this.Rl.pe();
        }
        return 0;
    }

    public e pj() {
        return this.adModel;
    }

    public void pk() {
        if (!this.Rn) {
            com.baidu.tieba.recapp.report.c.cjE().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Rk == null || !(this.Rk instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.Rk).getParallelCharge();
    }
}
