package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo ZN;
    public h ZO;
    public boolean ZP;
    private AdvertAppInfo ZR;
    private e adModel;
    private boolean ZQ = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(h hVar) {
        d dVar = new d();
        dVar.ZO = hVar;
        return dVar;
    }

    public ICardInfo rr() {
        return this.ZN;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return rr() != null ? b.ZI : b.ZH;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (rr() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) rr()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (rr() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) rr()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.ZN = eVar != null ? eVar.ZT : null;
        if (this.ZN instanceof i) {
            ((i) this.ZN).setAdFacadeData(this);
        }
        this.ZQ = true;
    }

    public AdvertAppInfo rs() {
        if (this.ZR == null) {
            this.ZR = new AdvertAppInfo();
            if (this.ZO != null) {
                Map<String, String> rq = this.ZO.rq();
                this.ZR.adPosition = String.valueOf(this.ZO.rp());
                this.ZR.tid = rq != null ? rq.get("thread_id") : "";
                this.ZR.setFid(rq != null ? Long.valueOf(rq.get("forum_id")).longValue() : 0L);
            }
            this.ZR.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.ZR.page = "VIDEO_LIST";
        }
        return this.ZR;
    }

    public int getPageNum() {
        if (this.ZO != null) {
            return this.ZO.ro();
        }
        return 0;
    }

    public e rt() {
        return this.adModel;
    }

    public void ru() {
        if (!this.ZQ) {
            com.baidu.tieba.recapp.report.d.dGg().a(com.baidu.tieba.recapp.report.g.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.ZN == null || !(this.ZN instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.ZN).getParallelCharge();
    }
}
