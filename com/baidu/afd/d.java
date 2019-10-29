package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo AH;
    public g AI;
    public boolean AJ;
    private AdvertAppInfo AM;
    private e adModel;
    private boolean AK = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.AI = gVar;
        return dVar;
    }

    public ICardInfo kc() {
        return this.AH;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kc() != null ? b.AA : b.Az;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        if (kc() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) kc()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        if (kc() instanceof com.baidu.tieba.lego.card.view.i) {
            ((com.baidu.tieba.lego.card.view.i) kc()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.AH = eVar != null ? eVar.AO : null;
        if (this.AH instanceof h) {
            ((h) this.AH).setAdFacadeData(this);
        }
        this.AK = true;
    }

    public AdvertAppInfo kd() {
        if (this.AM == null) {
            this.AM = new AdvertAppInfo();
            if (this.AI != null) {
                Map<String, String> kb = this.AI.kb();
                this.AM.adPosition = String.valueOf(this.AI.ka());
                this.AM.tid = kb != null ? kb.get("thread_id") : "";
                this.AM.setFid(kb != null ? Long.valueOf(kb.get("forum_id")).longValue() : 0L);
            }
            this.AM.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.AM.page = "VIDEO_LIST";
        }
        return this.AM;
    }

    public int getPageNum() {
        if (this.AI != null) {
            return this.AI.jZ();
        }
        return 0;
    }

    public e ke() {
        return this.adModel;
    }

    public void kf() {
        if (!this.AK) {
            com.baidu.tieba.recapp.report.c.cgI().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.AH == null || !(this.AH instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.AH).getParallelCharge();
    }
}
