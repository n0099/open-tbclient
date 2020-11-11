package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo YL;
    public g YM;
    public boolean YN;
    private AdvertAppInfo YP;
    private e adModel;
    private boolean YO = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.YM = gVar;
        return dVar;
    }

    public ICardInfo rp() {
        return this.YL;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return rp() != null ? b.YG : b.YF;
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
        this.YL = eVar != null ? eVar.YR : null;
        if (this.YL instanceof h) {
            ((h) this.YL).setAdFacadeData(this);
        }
        this.YO = true;
    }

    public AdvertAppInfo rq() {
        if (this.YP == null) {
            this.YP = new AdvertAppInfo();
            if (this.YM != null) {
                Map<String, String> ro = this.YM.ro();
                this.YP.adPosition = String.valueOf(this.YM.rn());
                this.YP.tid = ro != null ? ro.get("thread_id") : "";
                this.YP.setFid(ro != null ? Long.valueOf(ro.get("forum_id")).longValue() : 0L);
            }
            this.YP.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.YP.page = "VIDEO_LIST";
        }
        return this.YP;
    }

    public int getPageNum() {
        if (this.YM != null) {
            return this.YM.rm();
        }
        return 0;
    }

    public e rr() {
        return this.adModel;
    }

    public void rs() {
        if (!this.YO) {
            com.baidu.tieba.recapp.report.d.dBp().a(com.baidu.tieba.recapp.report.g.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.YL == null || !(this.YL instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.YL).getParallelCharge();
    }
}
