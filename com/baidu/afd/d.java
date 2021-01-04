package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.a.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements com.baidu.tieba.lego.card.a.b, com.baidu.tieba.lego.card.view.i {
    private AdvertAppInfo aaA;
    private ICardInfo aaw;
    public h aax;
    public boolean aay;
    private e adModel;
    private boolean aaz = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(h hVar) {
        d dVar = new d();
        dVar.aax = hVar;
        return dVar;
    }

    public ICardInfo qT() {
        return this.aaw;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return qT() != null ? b.aar : b.aaq;
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
        this.aaw = eVar != null ? eVar.aaC : null;
        if (this.aaw instanceof i) {
            ((i) this.aaw).setAdFacadeData(this);
        }
        this.aaz = true;
    }

    public AdvertAppInfo qU() {
        if (this.aaA == null) {
            this.aaA = new AdvertAppInfo();
            if (this.aax != null) {
                Map<String, String> qS = this.aax.qS();
                this.aaA.adPosition = String.valueOf(this.aax.qR());
                this.aaA.tid = qS != null ? qS.get("thread_id") : "";
                this.aaA.setFid(qS != null ? Long.valueOf(qS.get("forum_id")).longValue() : 0L);
            }
            this.aaA.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.aaA.page = "VIDEO_LIST";
        }
        return this.aaA;
    }

    public int getPageNum() {
        if (this.aax != null) {
            return this.aax.qQ();
        }
        return 0;
    }

    public e qV() {
        return this.adModel;
    }

    public void qW() {
        if (!this.aaz) {
            com.baidu.tieba.recapp.report.e.dFV().a(com.baidu.tieba.recapp.report.h.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.a.b
    public b.a getParallelCharge() {
        if (this.aaw == null || !(this.aaw instanceof com.baidu.tieba.lego.card.a.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.a.b) this.aaw).getParallelCharge();
    }
}
