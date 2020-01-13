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
    private ICardInfo Df;
    private TbPageContext Dg;
    private com.baidu.tieba.frs.aggregation.a Dh;
    private com.baidu.tieba.frs.videomiddlepage.c Di;
    private j Dj;
    private List<j> Dk;
    private f Dl;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Dk = new ArrayList();
        this.Dg = tbPageContext;
        this.Dh = aVar;
        this.Di = cVar;
        this.Dl = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c */
    public a b(ViewGroup viewGroup) {
        e a;
        if (this.Df == null || (a = com.baidu.tieba.lego.card.b.cag().a(this.Dg, this.Df, 2)) == null) {
            return null;
        }
        if (a instanceof j) {
            this.Dk.add((j) a);
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
        if (dVar == null || dVar.ku() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.Df = dVar.ku();
        return b(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo kv = dVar.kv();
            int i2 = 2;
            if (kv != null && kv.legoCard != null && kv.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(kv, i2, i);
            c.HQ(str2);
            com.baidu.tieba.recapp.report.c.cBP().a(c);
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
        if (aVar.kz() instanceof h) {
            h hVar = (h) aVar.kz();
            hVar.setAutoPlayCallBack(this.Dh);
            hVar.setOnVideoContainerForegroundClickListener(this.Di);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.kx();
        if (aVar.kz() != null) {
            aVar.kz().setPosition(i);
            aVar.kz().av(dVar.ku());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Df = dVar.ku();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void kA() {
        if (this.Dj != null) {
            this.Dj.pausePlay();
        }
    }

    public void kB() {
        if (this.Dj != null) {
            this.Dj.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        this.Dj = jVar;
        if (this.Dl != null) {
            this.Dl.a(this.Dj);
        }
    }

    public boolean kC() {
        if (this.Dj != null) {
            return this.Dj.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (j jVar : this.Dk) {
            if (jVar != null) {
                jVar.onDestroy();
            }
        }
    }
}
