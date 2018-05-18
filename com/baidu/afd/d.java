package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.view.h {
    private ICardInfo IK;
    public g IL;
    public boolean IM;
    private AdvertAppInfo IP;
    private e adModel;
    private boolean IO = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.IL = gVar;
        return dVar;
    }

    public ICardInfo lt() {
        return this.IK;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return lt() != null ? b.IE : b.IC;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlay(boolean z) {
        if (lt() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) lt()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setWaitConfirm(boolean z) {
        if (lt() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) lt()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.IK = eVar != null ? eVar.IR : null;
        if (this.IK instanceof h) {
            ((h) this.IK).setAdFacadeData(this);
        }
        this.IO = true;
    }

    public AdvertAppInfo lu() {
        if (this.IP == null) {
            this.IP = new AdvertAppInfo();
            if (this.IL != null) {
                Map<String, String> ls = this.IL.ls();
                this.IP.adPosition = String.valueOf(this.IL.lr());
                this.IP.tid = ls != null ? ls.get("thread_id") : "";
                this.IP.setFid(ls != null ? Long.valueOf(ls.get("forum_id")).longValue() : 0L);
            }
            this.IP.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.IP.Vp = "VIDEO_LIST";
        }
        return this.IP;
    }

    public int getPageNum() {
        if (this.IL != null) {
            return this.IL.lq();
        }
        return 0;
    }

    public e lv() {
        return this.adModel;
    }

    public void lw() {
        if (!this.IO) {
            com.baidu.tieba.recapp.report.b.bkd().a(com.baidu.tieba.recapp.report.e.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }
}
