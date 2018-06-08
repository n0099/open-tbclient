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
    private ICardInfo Pk;
    private TbPageContext Pl;
    private com.baidu.tieba.frs.aggregation.a Pm;
    private com.baidu.tieba.frs.videomiddlepage.b Pn;
    private i Po;
    private List<i> Pp;
    private f Pq;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.b bVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Pp = new ArrayList();
        this.Pl = tbPageContext;
        this.Pm = aVar;
        this.Pn = bVar;
        this.Pq = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: d */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        e a;
        if (this.Pk == null || (a = com.baidu.tieba.lego.card.b.aPu().a(this.Pl, this.Pk, 2)) == null) {
            return null;
        }
        if (a instanceof i) {
            this.Pp.add((i) a);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo ok = dVar.ok();
            int i2 = 2;
            if (ok != null && ok.legoCard != null && ok.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(ok, i2, i);
            c.tb(str2);
            com.baidu.tieba.recapp.report.b.bpc().a(c);
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
        if (aVar.oo() instanceof g) {
            g gVar = (g) aVar.oo();
            gVar.setAutoPlayCallBack(this.Pm);
            gVar.setOnVideoContainerForegroundClickListener(this.Pn);
            gVar.setCurrentPlayCallBack(this);
        }
        dVar.om();
        if (aVar.oo() != null) {
            aVar.oo().setPosition(i);
            aVar.oo().R(dVar.oj());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Pk = dVar.oj();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void op() {
        if (this.Po != null) {
            this.Po.pausePlay();
        }
    }

    public void oq() {
        if (this.Po != null) {
            this.Po.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(i iVar) {
        this.Po = iVar;
        if (this.Pq != null) {
            this.Pq.a(this.Po);
        }
    }

    public boolean or() {
        if (this.Po != null) {
            return this.Po.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (i iVar : this.Pp) {
            if (iVar != null) {
                iVar.onDestroy();
            }
        }
    }
}
