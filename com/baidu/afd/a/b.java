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
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.afd.d, a> implements f {
    private ICardInfo Yn;
    private TbPageContext Yo;
    private com.baidu.tieba.frs.aggregation.a Yp;
    private com.baidu.tieba.frs.videomiddlepage.c Yq;
    private j Yr;
    private List<j> Ys;
    private f Yt;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Ys = new ArrayList();
        this.Yo = tbPageContext;
        this.Yp = aVar;
        this.Yq = cVar;
        this.Yt = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public a b(ViewGroup viewGroup) {
        e a;
        if (this.Yn == null || (a = com.baidu.tieba.lego.card.b.cLT().a(this.Yo, this.Yn, 2)) == null) {
            return null;
        }
        if (a instanceof j) {
            this.Ys.add((j) a);
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
        this.Yn = dVar.rk();
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
            com.baidu.tieba.recapp.report.d.doi().a(c);
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
            hVar.setAutoPlayCallBack(this.Yp);
            hVar.setOnVideoContainerForegroundClickListener(this.Yq);
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
        this.Yn = dVar.rk();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void rq() {
        if (this.Yr != null) {
            this.Yr.aHX();
        }
    }

    public void rr() {
        if (this.Yr != null) {
            this.Yr.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        this.Yr = jVar;
        if (this.Yt != null) {
            this.Yt.a(this.Yr);
        }
    }

    public boolean rs() {
        if (this.Yr != null) {
            return this.Yr.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (j jVar : this.Ys) {
            if (jVar != null) {
                jVar.onDestroy();
            }
        }
    }
}
