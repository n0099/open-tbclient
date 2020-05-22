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
    private ICardInfo Xl;
    private TbPageContext Xm;
    private com.baidu.tieba.frs.aggregation.a Xn;
    private com.baidu.tieba.frs.videomiddlepage.c Xo;
    private j Xp;
    private List<j> Xq;
    private f Xr;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Xq = new ArrayList();
        this.Xm = tbPageContext;
        this.Xn = aVar;
        this.Xo = cVar;
        this.Xr = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: h */
    public a b(ViewGroup viewGroup) {
        e a;
        if (this.Xl == null || (a = com.baidu.tieba.lego.card.b.cte().a(this.Xm, this.Xl, 2)) == null) {
            return null;
        }
        if (a instanceof j) {
            this.Xq.add((j) a);
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
        if (dVar == null || dVar.pt() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.Xl = dVar.pt();
        return b(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo pu = dVar.pu();
            int i2 = 2;
            if (pu != null && pu.legoCard != null && pu.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.c c = g.c(pu, i2, i);
            c.Ly(str2);
            com.baidu.tieba.recapp.report.d.cVk().a(c);
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
        if (aVar.py() instanceof h) {
            h hVar = (h) aVar.py();
            hVar.setAutoPlayCallBack(this.Xn);
            hVar.setOnVideoContainerForegroundClickListener(this.Xo);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.pw();
        if (aVar.py() != null) {
            aVar.py().setPosition(i);
            aVar.py().aD(dVar.pt());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Xl = dVar.pt();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void pz() {
        if (this.Xp != null) {
            this.Xp.avT();
        }
    }

    public void pA() {
        if (this.Xp != null) {
            this.Xp.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        this.Xp = jVar;
        if (this.Xr != null) {
            this.Xr.a(this.Xp);
        }
    }

    public boolean pB() {
        if (this.Xp != null) {
            return this.Xp.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (j jVar : this.Xq) {
            if (jVar != null) {
                jVar.onDestroy();
            }
        }
    }
}
