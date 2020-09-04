package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo Yb;
    public g Yc;
    public boolean Ye;
    private AdvertAppInfo Yg;
    private e adModel;
    private boolean Yf = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.Yc = gVar;
        return dVar;
    }

    public ICardInfo rk() {
        return this.Yb;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return rk() != null ? b.XW : b.XV;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (rk() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) rk()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (rk() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) rk()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.Yb = eVar != null ? eVar.Yi : null;
        if (this.Yb instanceof h) {
            ((h) this.Yb).setAdFacadeData(this);
        }
        this.Yf = true;
    }

    public AdvertAppInfo rl() {
        if (this.Yg == null) {
            this.Yg = new AdvertAppInfo();
            if (this.Yc != null) {
                Map<String, String> rj = this.Yc.rj();
                this.Yg.adPosition = String.valueOf(this.Yc.ri());
                this.Yg.tid = rj != null ? rj.get("thread_id") : "";
                this.Yg.setFid(rj != null ? Long.valueOf(rj.get("forum_id")).longValue() : 0L);
            }
            this.Yg.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Yg.page = "VIDEO_LIST";
        }
        return this.Yg;
    }

    public int getPageNum() {
        if (this.Yc != null) {
            return this.Yc.rh();
        }
        return 0;
    }

    public e rm() {
        return this.adModel;
    }

    public void rn() {
        if (!this.Yf) {
            com.baidu.tieba.recapp.report.d.dol().a(com.baidu.tieba.recapp.report.g.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Yb == null || !(this.Yb instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.Yb).getParallelCharge();
    }
}
