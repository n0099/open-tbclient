package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo YK;
    public g YL;
    public boolean YM;
    private AdvertAppInfo YO;
    private e adModel;
    private boolean YN = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.YL = gVar;
        return dVar;
    }

    public ICardInfo rp() {
        return this.YK;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return rp() != null ? b.YF : b.YE;
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
        this.YK = eVar != null ? eVar.YQ : null;
        if (this.YK instanceof h) {
            ((h) this.YK).setAdFacadeData(this);
        }
        this.YN = true;
    }

    public AdvertAppInfo rq() {
        if (this.YO == null) {
            this.YO = new AdvertAppInfo();
            if (this.YL != null) {
                Map<String, String> ro = this.YL.ro();
                this.YO.adPosition = String.valueOf(this.YL.rn());
                this.YO.tid = ro != null ? ro.get("thread_id") : "";
                this.YO.setFid(ro != null ? Long.valueOf(ro.get("forum_id")).longValue() : 0L);
            }
            this.YO.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.YO.page = "VIDEO_LIST";
        }
        return this.YO;
    }

    public int getPageNum() {
        if (this.YL != null) {
            return this.YL.rm();
        }
        return 0;
    }

    public e rr() {
        return this.adModel;
    }

    public void rs() {
        if (!this.YN) {
            com.baidu.tieba.recapp.report.d.dvG().a(com.baidu.tieba.recapp.report.g.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.YK == null || !(this.YK instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.YK).getParallelCharge();
    }
}
