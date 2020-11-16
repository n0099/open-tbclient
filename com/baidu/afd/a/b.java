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
import com.baidu.tieba.lego.card.view.k;
import com.baidu.tieba.recapp.report.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.afd.d, a> implements f {
    private ICardInfo Ze;
    private TbPageContext Zf;
    private com.baidu.tieba.frs.aggregation.a Zg;
    private com.baidu.tieba.frs.videomiddlepage.c Zh;
    private k Zi;
    private List<k> Zj;
    private f Zk;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Zj = new ArrayList();
        this.Zf = tbPageContext;
        this.Zg = aVar;
        this.Zh = cVar;
        this.Zk = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public a c(ViewGroup viewGroup) {
        e a2;
        if (this.Ze == null || (a2 = com.baidu.tieba.lego.card.b.cYo().a(this.Zf, this.Ze, 2)) == null) {
            return null;
        }
        if (a2 instanceof k) {
            this.Zj.add((k) a2);
        }
        a2.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.afd.a.b.1
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i, HashMap<String, Object> hashMap) {
                b.this.a(b.this.adFacadeData, false, b.this.adFacadeData.getPageNum(), "", (String) null);
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str, String str2, HashMap<String, Object> hashMap) {
                b.this.a(b.this.adFacadeData, false, b.this.adFacadeData.getPageNum(), "", (String) null);
            }
        });
        return new a(a2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public a a(ViewGroup viewGroup, com.baidu.afd.d dVar) {
        if (dVar == null || dVar.rp() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.Ze = dVar.rp();
        return c(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo rq = dVar.rq();
            int i2 = 2;
            if (rq != null && rq.legoCard != null && rq.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.c c = g.c(rq, i2, i);
            c.Rg(str2);
            com.baidu.tieba.recapp.report.d.dAT().a(c);
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
        if (aVar.ru() instanceof h) {
            h hVar = (h) aVar.ru();
            hVar.setAutoPlayCallBack(this.Zg);
            hVar.setOnVideoContainerForegroundClickListener(this.Zh);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.rs();
        if (aVar.ru() != null) {
            aVar.ru().setPosition(i);
            aVar.ru().aN(dVar.rp());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Ze = dVar.rp();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void rv() {
        if (this.Zi != null) {
            this.Zi.aPd();
        }
    }

    public void rw() {
        if (this.Zi != null) {
            this.Zi.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(k kVar) {
        this.Zi = kVar;
        if (this.Zk != null) {
            this.Zk.a(this.Zi);
        }
    }

    public boolean rx() {
        if (this.Zi != null) {
            return this.Zi.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (k kVar : this.Zj) {
            if (kVar != null) {
                kVar.onDestroy();
            }
        }
    }
}
