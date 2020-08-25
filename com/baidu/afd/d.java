package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo XZ;
    public g Ya;
    public boolean Yb;
    private AdvertAppInfo Ye;
    private e adModel;
    private boolean Yc = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.Ya = gVar;
        return dVar;
    }

    public ICardInfo rk() {
        return this.XZ;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return rk() != null ? b.XU : b.XT;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (rk() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) rk()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (rk() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) rk()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.XZ = eVar != null ? eVar.Yg : null;
        if (this.XZ instanceof h) {
            ((h) this.XZ).setAdFacadeData(this);
        }
        this.Yc = true;
    }

    public AdvertAppInfo rl() {
        if (this.Ye == null) {
            this.Ye = new AdvertAppInfo();
            if (this.Ya != null) {
                Map<String, String> rj = this.Ya.rj();
                this.Ye.adPosition = String.valueOf(this.Ya.ri());
                this.Ye.tid = rj != null ? rj.get("thread_id") : "";
                this.Ye.setFid(rj != null ? Long.valueOf(rj.get("forum_id")).longValue() : 0L);
            }
            this.Ye.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Ye.page = "VIDEO_LIST";
        }
        return this.Ye;
    }

    public int getPageNum() {
        if (this.Ya != null) {
            return this.Ya.rh();
        }
        return 0;
    }

    public e rm() {
        return this.adModel;
    }

    public void rn() {
        if (!this.Yc) {
            com.baidu.tieba.recapp.report.d.doi().a(com.baidu.tieba.recapp.report.g.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.XZ == null || !(this.XZ instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.XZ).getParallelCharge();
    }
}
