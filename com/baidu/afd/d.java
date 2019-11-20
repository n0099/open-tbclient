package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.b.b, com.baidu.tieba.lego.card.view.i {
    private ICardInfo Ah;
    public g Ai;
    public boolean Aj;
    private AdvertAppInfo Al;
    private e adModel;
    private boolean Ak = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.Ai = gVar;
        return dVar;
    }

    public ICardInfo kc() {
        return this.Ah;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kc() != null ? b.zZ : b.zY;
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
        this.Ah = eVar != null ? eVar.An : null;
        if (this.Ah instanceof h) {
            ((h) this.Ah).setAdFacadeData(this);
        }
        this.Ak = true;
    }

    public AdvertAppInfo kd() {
        if (this.Al == null) {
            this.Al = new AdvertAppInfo();
            if (this.Ai != null) {
                Map<String, String> kb = this.Ai.kb();
                this.Al.adPosition = String.valueOf(this.Ai.ka());
                this.Al.tid = kb != null ? kb.get("thread_id") : "";
                this.Al.setFid(kb != null ? Long.valueOf(kb.get("forum_id")).longValue() : 0L);
            }
            this.Al.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.Al.page = "VIDEO_LIST";
        }
        return this.Al;
    }

    public int getPageNum() {
        if (this.Ai != null) {
            return this.Ai.jZ();
        }
        return 0;
    }

    public e ke() {
        return this.adModel;
    }

    public void kf() {
        if (!this.Ak) {
            com.baidu.tieba.recapp.report.c.cgG().a(com.baidu.tieba.recapp.report.f.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.c.a(this);
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Ah == null || !(this.Ah instanceof com.baidu.tieba.lego.card.b.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.card.b.b) this.Ah).getParallelCharge();
    }
}
