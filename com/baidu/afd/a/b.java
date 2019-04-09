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
    private i TA;
    private List<i> TB;
    private f TC;
    private ICardInfo Tw;
    private TbPageContext Tx;
    private com.baidu.tieba.frs.aggregation.a Ty;
    private com.baidu.tieba.frs.videomiddlepage.c Tz;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.TB = new ArrayList();
        this.Tx = tbPageContext;
        this.Ty = aVar;
        this.Tz = cVar;
        this.TC = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        e a;
        if (this.Tw == null || (a = com.baidu.tieba.lego.card.b.bzE().a(this.Tx, this.Tw, 2)) == null) {
            return null;
        }
        if (a instanceof i) {
            this.TB.add((i) a);
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
        if (dVar == null || dVar.pQ() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.Tw = dVar.pQ();
        return onCreateViewHolder(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo pR = dVar.pR();
            int i2 = 2;
            if (pR != null && pR.legoCard != null && pR.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(pR, i2, i);
            c.BM(str2);
            com.baidu.tieba.recapp.report.c.bXA().a(c);
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
        if (aVar.pV() instanceof g) {
            g gVar = (g) aVar.pV();
            gVar.setAutoPlayCallBack(this.Ty);
            gVar.setOnVideoContainerForegroundClickListener(this.Tz);
            gVar.setCurrentPlayCallBack(this);
        }
        dVar.pT();
        if (aVar.pV() != null) {
            aVar.pV().setPosition(i);
            aVar.pV().am(dVar.pQ());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Tw = dVar.pQ();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void pW() {
        if (this.TA != null) {
            this.TA.pausePlay();
        }
    }

    public void pX() {
        if (this.TA != null) {
            this.TA.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(i iVar) {
        this.TA = iVar;
        if (this.TC != null) {
            this.TC.a(this.TA);
        }
    }

    public boolean pY() {
        if (this.TA != null) {
            return this.TA.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (i iVar : this.TB) {
            if (iVar != null) {
                iVar.onDestroy();
            }
        }
    }
}
