package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo XC;
    public g XD;
    public boolean XE;
    private AdvertAppInfo XG;
    private e adModel;
    private boolean XF = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.XD = gVar;
        return dVar;
    }

    public ICardInfo pK() {
        return this.XC;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return pK() != null ? b.Xw : b.Xv;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (pK() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) pK()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (pK() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) pK()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.XC = eVar != null ? eVar.XI : null;
        if (this.XC instanceof h) {
            ((h) this.XC).setAdFacadeData(this);
        }
        this.XF = true;
    }

    public AdvertAppInfo pL() {
        if (this.XG == null) {
            this.XG = new AdvertAppInfo();
            if (this.XD != null) {
                Map<String, String> pJ = this.XD.pJ();
                this.XG.adPosition = String.valueOf(this.XD.pI());
                this.XG.tid = pJ != null ? pJ.get("thread_id") : "";
                this.XG.setFid(pJ != null ? Long.valueOf(pJ.get("forum_id")).longValue() : 0L);
            }
            this.XG.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.XG.page = "VIDEO_LIST";
        }
        return this.XG;
    }

    public int getPageNum() {
        if (this.XD != null) {
            return this.XD.pH();
        }
        return 0;
    }

    public e pM() {
        return this.adModel;
    }

    public void pN() {
        if (!this.XF) {
            com.baidu.tieba.recapp.report.d.cZQ().a(com.baidu.tieba.recapp.report.g.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.XC == null || !(this.XC instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.XC).getParallelCharge();
    }
}
