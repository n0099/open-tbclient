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
    private ICardInfo Da;
    private TbPageContext Db;
    private com.baidu.tieba.frs.aggregation.a Dc;
    private com.baidu.tieba.frs.videomiddlepage.c Dd;
    private j De;
    private List<j> Df;
    private f Dg;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Df = new ArrayList();
        this.Db = tbPageContext;
        this.Dc = aVar;
        this.Dd = cVar;
        this.Dg = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c */
    public a b(ViewGroup viewGroup) {
        e a;
        if (this.Da == null || (a = com.baidu.tieba.lego.card.b.bYX().a(this.Db, this.Da, 2)) == null) {
            return null;
        }
        if (a instanceof j) {
            this.Df.add((j) a);
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
    public a a(ViewGroup viewGroup, com.baidu.afd.d dVar) {
        if (dVar == null || dVar.kt() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.Da = dVar.kt();
        return b(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo ku = dVar.ku();
            int i2 = 2;
            if (ku != null && ku.legoCard != null && ku.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(ku, i2, i);
            c.HG(str2);
            com.baidu.tieba.recapp.report.c.cAJ().a(c);
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
        if (aVar.ky() instanceof h) {
            h hVar = (h) aVar.ky();
            hVar.setAutoPlayCallBack(this.Dc);
            hVar.setOnVideoContainerForegroundClickListener(this.Dd);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.kw();
        if (aVar.ky() != null) {
            aVar.ky().setPosition(i);
            aVar.ky().av(dVar.kt());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Da = dVar.kt();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void kz() {
        if (this.De != null) {
            this.De.pausePlay();
        }
    }

    public void kA() {
        if (this.De != null) {
            this.De.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        this.De = jVar;
        if (this.Dg != null) {
            this.Dg.a(this.De);
        }
    }

    public boolean kB() {
        if (this.De != null) {
            return this.De.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (j jVar : this.Df) {
            if (jVar != null) {
                jVar.onDestroy();
            }
        }
    }
}
