package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo Xu;
    public g Xv;
    public boolean Xw;
    private AdvertAppInfo Xy;
    private e adModel;
    private boolean Xx = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.Xv = gVar;
        return dVar;
    }

    public ICardInfo pL() {
        return this.Xu;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return pL() != null ? b.Xp : b.Xo;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (pL() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) pL()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (pL() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) pL()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.Xu = eVar != null ? eVar.XA : null;
        if (this.Xu instanceof h) {
            ((h) this.Xu).setAdFacadeData(this);
        }
        this.Xx = true;
    }

    public AdvertAppInfo pM() {
        if (this.Xy == null) {
            this.Xy = new AdvertAppInfo();
            if (this.Xv != null) {
                Map<String, String> pK = this.Xv.pK();
                this.Xy.adPosition = String.valueOf(this.Xv.pJ());
                this.Xy.tid = pK != null ? pK.get("thread_id") : "";
                this.Xy.setFid(pK != null ? Long.valueOf(pK.get("forum_id")).longValue() : 0L);
            }
            this.Xy.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Xy.page = "VIDEO_LIST";
        }
        return this.Xy;
    }

    public int getPageNum() {
        if (this.Xv != null) {
            return this.Xv.pI();
        }
        return 0;
    }

    public e pN() {
        return this.adModel;
    }

    public void pO() {
        if (!this.Xx) {
            com.baidu.tieba.recapp.report.d.dcY().a(com.baidu.tieba.recapp.report.g.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Xu == null || !(this.Xu instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.Xu).getParallelCharge();
    }
}
