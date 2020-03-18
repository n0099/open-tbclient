package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo Dl;
    public g Dm;
    public boolean Dn;
    private AdvertAppInfo Dp;
    private e adModel;
    private boolean Do = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.Dm = gVar;
        return dVar;
    }

    public ICardInfo kJ() {
        return this.Dl;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kJ() != null ? b.De : b.Dd;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (kJ() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) kJ()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (kJ() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) kJ()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.Dl = eVar != null ? eVar.Dr : null;
        if (this.Dl instanceof h) {
            ((h) this.Dl).setAdFacadeData(this);
        }
        this.Do = true;
    }

    public AdvertAppInfo kK() {
        if (this.Dp == null) {
            this.Dp = new AdvertAppInfo();
            if (this.Dm != null) {
                Map<String, String> kI = this.Dm.kI();
                this.Dp.adPosition = String.valueOf(this.Dm.kH());
                this.Dp.tid = kI != null ? kI.get("thread_id") : "";
                this.Dp.setFid(kI != null ? Long.valueOf(kI.get("forum_id")).longValue() : 0L);
            }
            this.Dp.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Dp.page = "VIDEO_LIST";
        }
        return this.Dp;
    }

    public int getPageNum() {
        if (this.Dm != null) {
            return this.Dm.kG();
        }
        return 0;
    }

    public e kL() {
        return this.adModel;
    }

    public void kM() {
        if (!this.Do) {
            com.baidu.tieba.recapp.report.c.cDK().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Dl == null || !(this.Dl instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.Dl).getParallelCharge();
    }
}
