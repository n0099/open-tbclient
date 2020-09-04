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
import com.baidu.tieba.recapp.report.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.afd.d, a> implements f {
    private ICardInfo Yp;
    private TbPageContext Yq;
    private com.baidu.tieba.frs.aggregation.a Yr;
    private com.baidu.tieba.frs.videomiddlepage.c Ys;
    private j Yt;
    private List<j> Yu;
    private f Yv;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Yu = new ArrayList();
        this.Yq = tbPageContext;
        this.Yr = aVar;
        this.Ys = cVar;
        this.Yv = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public a b(ViewGroup viewGroup) {
        e a;
        if (this.Yp == null || (a = com.baidu.tieba.lego.card.b.cLU().a(this.Yq, this.Yp, 2)) == null) {
            return null;
        }
        if (a instanceof j) {
            this.Yu.add((j) a);
        }
        a.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.afd.a.b.1
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i, HashMap<String, Object> hashMap) {
                b.this.a(b.this.adFacadeData, false, b.this.adFacadeData.getPageNum(), "", (String) null);
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str, String str2, HashMap<String, Object> hashMap) {
                b.this.a(b.this.adFacadeData, false, b.this.adFacadeData.getPageNum(), "", (String) null);
            }
        });
        return new a(a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public a a(ViewGroup viewGroup, com.baidu.afd.d dVar) {
        if (dVar == null || dVar.rk() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.Yp = dVar.rk();
        return b(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo rl = dVar.rl();
            int i2 = 2;
            if (rl != null && rl.legoCard != null && rl.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.c c = g.c(rl, i2, i);
            c.PF(str2);
            com.baidu.tieba.recapp.report.d.dol().a(c);
            com.baidu.tieba.lego.card.b.c.a(dVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar, a aVar) {
        if (dVar == null || aVar == null) {
            return null;
        }
        if (aVar.rp() instanceof h) {
            h hVar = (h) aVar.rp();
            hVar.setAutoPlayCallBack(this.Yr);
            hVar.setOnVideoContainerForegroundClickListener(this.Ys);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.rn();
        if (aVar.rp() != null) {
            aVar.rp().setPosition(i);
            aVar.rp().aG(dVar.rk());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Yp = dVar.rk();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void rq() {
        if (this.Yt != null) {
            this.Yt.aHX();
        }
    }

    public void rr() {
        if (this.Yt != null) {
            this.Yt.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        this.Yt = jVar;
        if (this.Yv != null) {
            this.Yv.a(this.Yt);
        }
    }

    public boolean rs() {
        if (this.Yt != null) {
            return this.Yt.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (j jVar : this.Yu) {
            if (jVar != null) {
                jVar.onDestroy();
            }
        }
    }
}
