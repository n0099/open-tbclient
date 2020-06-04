package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo WX;
    public g WY;
    public boolean WZ;
    private AdvertAppInfo Xb;
    private e adModel;
    private boolean Xa = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.WY = gVar;
        return dVar;
    }

    public ICardInfo pt() {
        return this.WX;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return pt() != null ? b.WQ : b.WP;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (pt() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) pt()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (pt() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) pt()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.WX = eVar != null ? eVar.Xe : null;
        if (this.WX instanceof h) {
            ((h) this.WX).setAdFacadeData(this);
        }
        this.Xa = true;
    }

    public AdvertAppInfo pu() {
        if (this.Xb == null) {
            this.Xb = new AdvertAppInfo();
            if (this.WY != null) {
                Map<String, String> ps = this.WY.ps();
                this.Xb.adPosition = String.valueOf(this.WY.pr());
                this.Xb.tid = ps != null ? ps.get("thread_id") : "";
                this.Xb.setFid(ps != null ? Long.valueOf(ps.get("forum_id")).longValue() : 0L);
            }
            this.Xb.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Xb.page = "VIDEO_LIST";
        }
        return this.Xb;
    }

    public int getPageNum() {
        if (this.WY != null) {
            return this.WY.pq();
        }
        return 0;
    }

    public e pv() {
        return this.adModel;
    }

    public void pw() {
        if (!this.Xa) {
            com.baidu.tieba.recapp.report.d.cVA().a(com.baidu.tieba.recapp.report.g.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.WX == null || !(this.WX instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.WX).getParallelCharge();
    }
}
