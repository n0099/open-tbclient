package com.baidu.afd;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.view.h {
    private ICardInfo IP;
    public g IQ;
    public boolean IR;
    private AdvertAppInfo IT;
    private e adModel;
    private boolean IS = false;
    private BdUniqueId tag = BdUniqueId.gen();

    public static d a(g gVar) {
        d dVar = new d();
        dVar.IQ = gVar;
        return dVar;
    }

    public ICardInfo lu() {
        return this.IP;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return lu() != null ? b.II : b.IH;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlay(boolean z) {
        if (lu() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) lu()).setAutoPlay(z);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setWaitConfirm(boolean z) {
        if (lu() instanceof com.baidu.tieba.lego.card.view.h) {
            ((com.baidu.tieba.lego.card.view.h) lu()).setWaitConfirm(z);
        }
    }

    public void a(e eVar) {
        this.adModel = eVar;
        this.IP = eVar != null ? eVar.IW : null;
        if (this.IP instanceof h) {
            ((h) this.IP).setAdFacadeData(this);
        }
        this.IS = true;
    }

    public AdvertAppInfo lv() {
        if (this.IT == null) {
            this.IT = new AdvertAppInfo();
            if (this.IQ != null) {
                Map<String, String> lt = this.IQ.lt();
                this.IT.adPosition = String.valueOf(this.IQ.ls());
                this.IT.tid = lt != null ? lt.get("thread_id") : "";
                this.IT.setFid(lt != null ? Long.valueOf(lt.get("forum_id")).longValue() : 0L);
            }
            this.IT.extensionInfo = this.adModel != null ? this.adModel.ext : "";
            this.IT.Vt = "VIDEO_LIST";
        }
        return this.IT;
    }

    public int getPageNum() {
        if (this.IQ != null) {
            return this.IQ.lr();
        }
        return 0;
    }

    public e lw() {
        return this.adModel;
    }

    public void lx() {
        if (!this.IS) {
            com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.a(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        com.baidu.tbadk.core.data.b.a(this);
    }
}
