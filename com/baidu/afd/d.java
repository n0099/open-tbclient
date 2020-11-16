package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo YQ;
    public h YR;
    public boolean YS;
    private AdvertAppInfo YU;
    private e adModel;
    private boolean YT = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(h hVar) {
        d dVar = new d();
        dVar.YR = hVar;
        return dVar;
    }

    public ICardInfo rp() {
        return this.YQ;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return rp() != null ? b.YL : b.YK;
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
        this.YQ = eVar != null ? eVar.YW : null;
        if (this.YQ instanceof i) {
            ((i) this.YQ).setAdFacadeData(this);
        }
        this.YT = true;
    }

    public AdvertAppInfo rq() {
        if (this.YU == null) {
            this.YU = new AdvertAppInfo();
            if (this.YR != null) {
                Map<String, String> ro = this.YR.ro();
                this.YU.adPosition = String.valueOf(this.YR.rn());
                this.YU.tid = ro != null ? ro.get("thread_id") : "";
                this.YU.setFid(ro != null ? Long.valueOf(ro.get("forum_id")).longValue() : 0L);
            }
            this.YU.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.YU.page = "VIDEO_LIST";
        }
        return this.YU;
    }

    public int getPageNum() {
        if (this.YR != null) {
            return this.YR.rm();
        }
        return 0;
    }

    public e rr() {
        return this.adModel;
    }

    public void rs() {
        if (!this.YT) {
            com.baidu.tieba.recapp.report.d.dAT().a(com.baidu.tieba.recapp.report.g.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.YQ == null || !(this.YQ instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.YQ).getParallelCharge();
    }
}
