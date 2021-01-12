package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.a.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements com.baidu.tieba.lego.card.a.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo aau;
    public h aav;
    public boolean aaw;
    private AdvertAppInfo aay;
    private e adModel;
    private boolean aax = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(h hVar) {
        d dVar = new d();
        dVar.aav = hVar;
        return dVar;
    }

    public ICardInfo qT() {
        return this.aau;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return qT() != null ? b.aap : b.aao;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (qT() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) qT()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (qT() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) qT()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.aau = eVar != null ? eVar.aaA : null;
        if (this.aau instanceof i) {
            ((i) this.aau).setAdFacadeData(this);
        }
        this.aax = true;
    }

    public AdvertAppInfo qU() {
        if (this.aay == null) {
            this.aay = new AdvertAppInfo();
            if (this.aav != null) {
                Map<String, String> qS = this.aav.qS();
                this.aay.adPosition = String.valueOf(this.aav.qR());
                this.aay.tid = qS != null ? qS.get("thread_id") : "";
                this.aay.setFid(qS != null ? Long.valueOf(qS.get("forum_id")).longValue() : 0L);
            }
            this.aay.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.aay.page = "VIDEO_LIST";
        }
        return this.aay;
    }

    public int getPageNum() {
        if (this.aav != null) {
            return this.aav.qQ();
        }
        return 0;
    }

    public e qV() {
        return this.adModel;
    }

    public void qW() {
        if (!this.aax) {
            com.baidu.tieba.recapp.report.e.dCe().a(com.baidu.tieba.recapp.report.h.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.a.b
    public b.a getParallelCharge() {
        if (this.aau == null || !(this.aau instanceof com.baidu.tieba.lego.card.a.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.a.b) this.aau).getParallelCharge();
    }
}
