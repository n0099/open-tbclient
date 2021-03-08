package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.a.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements com.baidu.tieba.lego.card.a.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo abK;
    public h abL;
    public boolean abM;
    private AdvertAppInfo abO;
    private e adModel;
    private boolean abN = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(h hVar) {
        d dVar = new d();
        dVar.abL = hVar;
        return dVar;
    }

    public ICardInfo qR() {
        return this.abK;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return qR() != null ? b.abF : b.abE;
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
        this.abK = eVar != null ? eVar.abQ : null;
        if (this.abK instanceof i) {
            ((i) this.abK).setAdFacadeData(this);
        }
        this.abN = true;
    }

    public AdvertAppInfo qS() {
        if (this.abO == null) {
            this.abO = new AdvertAppInfo();
            if (this.abL != null) {
                Map<String, String> qQ = this.abL.qQ();
                this.abO.adPosition = String.valueOf(this.abL.qP());
                this.abO.tid = qQ != null ? qQ.get("thread_id") : "";
                this.abO.setFid(qQ != null ? Long.valueOf(qQ.get("forum_id")).longValue() : 0L);
            }
            this.abO.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.abO.page = "VIDEO_LIST";
        }
        return this.abO;
    }

    public int getPageNum() {
        if (this.abL != null) {
            return this.abL.qO();
        }
        return 0;
    }

    public e qT() {
        return this.adModel;
    }

    public void qU() {
        if (!this.abN) {
            com.baidu.tieba.recapp.report.e.dEC().a(com.baidu.tieba.recapp.report.h.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.d.a(this);
    }

    @Override // com.baidu.tieba.lego.card.a.b
    public b.a getParallelCharge() {
        if (this.abK == null || !(this.abK instanceof com.baidu.tieba.lego.card.a.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.a.b) this.abK).getParallelCharge();
    }
}
