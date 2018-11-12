package com.baidu.afd.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.lego.card.view.f;
import com.baidu.tieba.lego.card.view.g;
import com.baidu.tieba.lego.card.view.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.afd.d, a> implements f {
    private ICardInfo Se;
    private TbPageContext Sf;
    private com.baidu.tieba.frs.aggregation.a Sg;
    private com.baidu.tieba.frs.videomiddlepage.b Sh;
    private i Si;
    private List<i> Sj;
    private f Sk;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.b bVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Sj = new ArrayList();
        this.Sf = tbPageContext;
        this.Sg = aVar;
        this.Sh = bVar;
        this.Sk = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        e a;
        if (this.Se == null || (a = com.baidu.tieba.lego.card.b.aVX().a(this.Sf, this.Se, 2)) == null) {
            return null;
        }
        if (a instanceof i) {
            this.Sj.add((i) a);
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
        if (dVar == null || dVar.pu() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.Se = dVar.pu();
        return onCreateViewHolder(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo pv = dVar.pv();
            int i2 = 2;
            if (pv != null && pv.legoCard != null && pv.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(pv, i2, i);
            c.uo(str2);
            com.baidu.tieba.recapp.report.c.btB().a(c);
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
        if (aVar.pz() instanceof g) {
            g gVar = (g) aVar.pz();
            gVar.setAutoPlayCallBack(this.Sg);
            gVar.setOnVideoContainerForegroundClickListener(this.Sh);
            gVar.setCurrentPlayCallBack(this);
        }
        dVar.px();
        if (aVar.pz() != null) {
            aVar.pz().setPosition(i);
            aVar.pz().Z(dVar.pu());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Se = dVar.pu();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void pA() {
        if (this.Si != null) {
            this.Si.pausePlay();
        }
    }

    public void pB() {
        if (this.Si != null) {
            this.Si.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(i iVar) {
        this.Si = iVar;
        if (this.Sk != null) {
            this.Sk.a(this.Si);
        }
    }

    public boolean pC() {
        if (this.Si != null) {
            return this.Si.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (i iVar : this.Sj) {
            if (iVar != null) {
                iVar.onDestroy();
            }
        }
    }
}
