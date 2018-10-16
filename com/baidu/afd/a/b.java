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
    private ICardInfo Sc;
    private TbPageContext Sd;
    private com.baidu.tieba.frs.aggregation.a Se;
    private com.baidu.tieba.frs.videomiddlepage.b Sf;
    private i Sg;
    private List<i> Sh;
    private f Si;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.b bVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Sh = new ArrayList();
        this.Sd = tbPageContext;
        this.Se = aVar;
        this.Sf = bVar;
        this.Si = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        e a;
        if (this.Sc == null || (a = com.baidu.tieba.lego.card.b.aWA().a(this.Sd, this.Sc, 2)) == null) {
            return null;
        }
        if (a instanceof i) {
            this.Sh.add((i) a);
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
        if (dVar == null || dVar.pw() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.Sc = dVar.pw();
        return onCreateViewHolder(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo px = dVar.px();
            int i2 = 2;
            if (px != null && px.legoCard != null && px.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(px, i2, i);
            c.uk(str2);
            com.baidu.tieba.recapp.report.c.buf().a(c);
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
        if (aVar.pB() instanceof g) {
            g gVar = (g) aVar.pB();
            gVar.setAutoPlayCallBack(this.Se);
            gVar.setOnVideoContainerForegroundClickListener(this.Sf);
            gVar.setCurrentPlayCallBack(this);
        }
        dVar.pz();
        if (aVar.pB() != null) {
            aVar.pB().setPosition(i);
            aVar.pB().aa(dVar.pw());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Sc = dVar.pw();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void pC() {
        if (this.Sg != null) {
            this.Sg.pausePlay();
        }
    }

    public void pD() {
        if (this.Sg != null) {
            this.Sg.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(i iVar) {
        this.Sg = iVar;
        if (this.Si != null) {
            this.Si.a(this.Sg);
        }
    }

    public boolean pE() {
        if (this.Sg != null) {
            return this.Sg.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (i iVar : this.Sh) {
            if (iVar != null) {
                iVar.onDestroy();
            }
        }
    }
}
