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
    private ICardInfo WW;
    private TbPageContext WX;
    private com.baidu.tieba.frs.aggregation.a WY;
    private com.baidu.tieba.frs.videomiddlepage.c WZ;
    private j Xa;
    private List<j> Xb;
    private f Xc;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Xb = new ArrayList();
        this.WX = tbPageContext;
        this.WY = aVar;
        this.WZ = cVar;
        this.Xc = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: d */
    public a b(ViewGroup viewGroup) {
        e a;
        if (this.WW == null || (a = com.baidu.tieba.lego.card.b.cmC().a(this.WX, this.WW, 2)) == null) {
            return null;
        }
        if (a instanceof j) {
            this.Xb.add((j) a);
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
        if (dVar == null || dVar.pn() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.WW = dVar.pn();
        return b(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo po = dVar.po();
            int i2 = 2;
            if (po != null && po.legoCard != null && po.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.c c = g.c(po, i2, i);
            c.JM(str2);
            com.baidu.tieba.recapp.report.d.cOj().a(c);
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
        if (aVar.ps() instanceof h) {
            h hVar = (h) aVar.ps();
            hVar.setAutoPlayCallBack(this.WY);
            hVar.setOnVideoContainerForegroundClickListener(this.WZ);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.pq();
        if (aVar.ps() != null) {
            aVar.ps().setPosition(i);
            aVar.ps().aA(dVar.pn());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.WW = dVar.pn();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void pt() {
        if (this.Xa != null) {
            this.Xa.asl();
        }
    }

    public void pu() {
        if (this.Xa != null) {
            this.Xa.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        this.Xa = jVar;
        if (this.Xc != null) {
            this.Xc.a(this.Xa);
        }
    }

    public boolean pv() {
        if (this.Xa != null) {
            return this.Xa.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (j jVar : this.Xb) {
            if (jVar != null) {
                jVar.onDestroy();
            }
        }
    }
}
