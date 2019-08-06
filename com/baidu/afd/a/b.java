package com.baidu.afd.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.h;
import com.baidu.tieba.lego.card.view.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.afd.d, a> implements f {
    private com.baidu.tieba.frs.aggregation.a RA;
    private com.baidu.tieba.frs.videomiddlepage.c RB;
    private j RC;
    private List<j> RD;
    private f RE;
    private ICardInfo Ry;
    private TbPageContext Rz;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.RD = new ArrayList();
        this.Rz = tbPageContext;
        this.RA = aVar;
        this.RB = cVar;
        this.RE = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        e a;
        if (this.Ry == null || (a = com.baidu.tieba.lego.card.b.bKn().a(this.Rz, this.Ry, 2)) == null) {
            return null;
        }
        if (a instanceof j) {
            this.RD.add((j) a);
        }
        a.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.afd.a.b.1
            @Override // com.baidu.tieba.lego.card.a
            public void b(int i, HashMap<String, Object> hashMap) {
                b.this.a(b.this.adFacadeData, false, b.this.adFacadeData.getPageNum(), "", (String) null);
            }

            @Override // com.baidu.tieba.lego.card.a
            public void b(String str, String str2, HashMap<String, Object> hashMap) {
                b.this.a(b.this.adFacadeData, false, b.this.adFacadeData.getPageNum(), "", (String) null);
            }
        });
        return new a(a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public a onCreateViewHolder(ViewGroup viewGroup, com.baidu.afd.d dVar) {
        if (dVar == null || dVar.pg() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.Ry = dVar.pg();
        return onCreateViewHolder(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo ph = dVar.ph();
            int i2 = 2;
            if (ph != null && ph.legoCard != null && ph.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(ph, i2, i);
            c.DY(str2);
            com.baidu.tieba.recapp.report.c.ciQ().a(c);
            com.baidu.tieba.lego.card.b.c.a(dVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar, a aVar) {
        if (dVar == null || aVar == null) {
            return null;
        }
        if (aVar.pl() instanceof h) {
            h hVar = (h) aVar.pl();
            hVar.setAutoPlayCallBack(this.RA);
            hVar.setOnVideoContainerForegroundClickListener(this.RB);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.pj();
        if (aVar.pl() != null) {
            aVar.pl().setPosition(i);
            aVar.pl().ao(dVar.pg());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Ry = dVar.pg();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void pm() {
        if (this.RC != null) {
            this.RC.pausePlay();
        }
    }

    public void pn() {
        if (this.RC != null) {
            this.RC.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        this.RC = jVar;
        if (this.RE != null) {
            this.RE.a(this.RC);
        }
    }

    public boolean po() {
        if (this.RC != null) {
            return this.RC.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (j jVar : this.RD) {
            if (jVar != null) {
                jVar.onDestroy();
            }
        }
    }
}
