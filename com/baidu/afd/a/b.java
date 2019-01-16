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
    private ICardInfo Sn;
    private TbPageContext So;
    private com.baidu.tieba.frs.aggregation.a Sp;
    private com.baidu.tieba.frs.videomiddlepage.b Sq;
    private i Sr;
    private List<i> Ss;
    private f St;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.b bVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Ss = new ArrayList();
        this.So = tbPageContext;
        this.Sp = aVar;
        this.Sq = bVar;
        this.St = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        e a;
        if (this.Sn == null || (a = com.baidu.tieba.lego.card.b.aZc().a(this.So, this.Sn, 2)) == null) {
            return null;
        }
        if (a instanceof i) {
            this.Ss.add((i) a);
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
        if (dVar == null || dVar.px() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.Sn = dVar.px();
        return onCreateViewHolder(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo py = dVar.py();
            int i2 = 2;
            if (py != null && py.legoCard != null && py.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(py, i2, i);
            c.vi(str2);
            com.baidu.tieba.recapp.report.c.bwO().a(c);
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
        if (aVar.pC() instanceof g) {
            g gVar = (g) aVar.pC();
            gVar.setAutoPlayCallBack(this.Sp);
            gVar.setOnVideoContainerForegroundClickListener(this.Sq);
            gVar.setCurrentPlayCallBack(this);
        }
        dVar.pA();
        if (aVar.pC() != null) {
            aVar.pC().setPosition(i);
            aVar.pC().Z(dVar.px());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Sn = dVar.px();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void pD() {
        if (this.Sr != null) {
            this.Sr.pausePlay();
        }
    }

    public void pE() {
        if (this.Sr != null) {
            this.Sr.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(i iVar) {
        this.Sr = iVar;
        if (this.St != null) {
            this.St.a(this.Sr);
        }
    }

    public boolean pF() {
        if (this.Sr != null) {
            return this.Sr.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (i iVar : this.Ss) {
            if (iVar != null) {
                iVar.onDestroy();
            }
        }
    }
}
