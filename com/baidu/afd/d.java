package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.a.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements com.baidu.tieba.lego.card.a.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo aaq;
    public h aar;
    public boolean aas;
    private AdvertAppInfo aau;
    private e adModel;
    private boolean aat = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(h hVar) {
        d dVar = new d();
        dVar.aar = hVar;
        return dVar;
    }

    public ICardInfo qR() {
        return this.aaq;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return qR() != null ? b.aal : b.aak;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (qR() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) qR()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (qR() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) qR()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.aaq = eVar != null ? eVar.aaw : null;
        if (this.aaq instanceof i) {
            ((i) this.aaq).setAdFacadeData(this);
        }
        this.aat = true;
    }

    public AdvertAppInfo qS() {
        if (this.aau == null) {
            this.aau = new AdvertAppInfo();
            if (this.aar != null) {
                Map<String, String> qQ = this.aar.qQ();
                this.aau.adPosition = String.valueOf(this.aar.qP());
                this.aau.tid = qQ != null ? qQ.get("thread_id") : "";
                this.aau.setFid(qQ != null ? Long.valueOf(qQ.get("forum_id")).longValue() : 0L);
            }
            this.aau.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.aau.page = "VIDEO_LIST";
        }
        return this.aau;
    }

    public int getPageNum() {
        if (this.aar != null) {
            return this.aar.qO();
        }
        return 0;
    }

    public e qT() {
        return this.adModel;
    }

    public void qU() {
        if (!this.aat) {
            com.baidu.tieba.recapp.report.e.dEm().a(com.baidu.tieba.recapp.report.h.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.d.a(this);
    }

    @Override // com.baidu.tieba.lego.card.a.b
    public b.a getParallelCharge() {
        if (this.aaq == null || !(this.aaq instanceof com.baidu.tieba.lego.card.a.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.a.b) this.aaq).getParallelCharge();
    }
}
