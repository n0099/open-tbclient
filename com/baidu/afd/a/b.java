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
    private ICardInfo Rh;
    private TbPageContext Ri;
    private com.baidu.tieba.frs.aggregation.a Rj;
    private com.baidu.tieba.frs.videomiddlepage.c Rk;
    private j Rl;
    private List<j> Rm;
    private f Rn;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Rm = new ArrayList();
        this.Ri = tbPageContext;
        this.Rj = aVar;
        this.Rk = cVar;
        this.Rn = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        e a;
        if (this.Rh == null || (a = com.baidu.tieba.lego.card.b.bHo().a(this.Ri, this.Rh, 2)) == null) {
            return null;
        }
        if (a instanceof j) {
            this.Rm.add((j) a);
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
        if (dVar == null || dVar.oL() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.Rh = dVar.oL();
        return onCreateViewHolder(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo oM = dVar.oM();
            int i2 = 2;
            if (oM != null && oM.legoCard != null && oM.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(oM, i2, i);
            c.Di(str2);
            com.baidu.tieba.recapp.report.c.cfE().a(c);
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
        if (aVar.oQ() instanceof h) {
            h hVar = (h) aVar.oQ();
            hVar.setAutoPlayCallBack(this.Rj);
            hVar.setOnVideoContainerForegroundClickListener(this.Rk);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.oO();
        if (aVar.oQ() != null) {
            aVar.oQ().setPosition(i);
            aVar.oQ().ao(dVar.oL());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Rh = dVar.oL();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void oR() {
        if (this.Rl != null) {
            this.Rl.pausePlay();
        }
    }

    public void oS() {
        if (this.Rl != null) {
            this.Rl.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        this.Rl = jVar;
        if (this.Rn != null) {
            this.Rn.a(this.Rl);
        }
    }

    public boolean oT() {
        if (this.Rl != null) {
            return this.Rl.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (j jVar : this.Rm) {
            if (jVar != null) {
                jVar.onDestroy();
            }
        }
    }
}
