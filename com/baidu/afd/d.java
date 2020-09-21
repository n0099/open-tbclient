package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo Yu;
    public g Yv;
    public boolean Yw;
    private AdvertAppInfo Yy;
    private e adModel;
    private boolean Yx = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.Yv = gVar;
        return dVar;
    }

    public ICardInfo rp() {
        return this.Yu;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return rp() != null ? b.Yp : b.Yo;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (rp() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) rp()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (rp() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) rp()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.Yu = eVar != null ? eVar.YA : null;
        if (this.Yu instanceof h) {
            ((h) this.Yu).setAdFacadeData(this);
        }
        this.Yx = true;
    }

    public AdvertAppInfo rq() {
        if (this.Yy == null) {
            this.Yy = new AdvertAppInfo();
            if (this.Yv != null) {
                Map<String, String> ro = this.Yv.ro();
                this.Yy.adPosition = String.valueOf(this.Yv.rn());
                this.Yy.tid = ro != null ? ro.get("thread_id") : "";
                this.Yy.setFid(ro != null ? Long.valueOf(ro.get("forum_id")).longValue() : 0L);
            }
            this.Yy.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Yy.page = "VIDEO_LIST";
        }
        return this.Yy;
    }

    public int getPageNum() {
        if (this.Yv != null) {
            return this.Yv.rm();
        }
        return 0;
    }

    public e rr() {
        return this.adModel;
    }

    public void rs() {
        if (!this.Yx) {
            com.baidu.tieba.recapp.report.d.drV().a(com.baidu.tieba.recapp.report.g.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Yu == null || !(this.Yu instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.Yu).getParallelCharge();
    }
}
