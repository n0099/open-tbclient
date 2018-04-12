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
    private ICardInfo Jd;
    private TbPageContext Je;
    private com.baidu.tieba.frs.aggregation.a Jf;
    private com.baidu.tieba.frs.videomiddlepage.b Jg;
    private i Jh;
    private List<i> Ji;
    private f Jj;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.b bVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Ji = new ArrayList();
        this.Je = tbPageContext;
        this.Jf = aVar;
        this.Jg = bVar;
        this.Jj = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: d */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        e a;
        if (this.Jd == null || (a = com.baidu.tieba.lego.card.b.aKA().a(this.Je, this.Jd, 2)) == null) {
            return null;
        }
        if (a instanceof i) {
            this.Ji.add((i) a);
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
            AdvertAppInfo lv = dVar.lv();
            int i2 = 2;
            if (lv != null && lv.legoCard != null && lv.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lv, i2, i);
            c.sg(str2);
            com.baidu.tieba.recapp.report.b.bke().a(c);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.afd.d dVar, a aVar) {
        if (dVar == null || aVar == null) {
            return null;
        }
        if (aVar.lz() instanceof g) {
            g gVar = (g) aVar.lz();
            gVar.setAutoPlayCallBack(this.Jf);
            gVar.setOnVideoContainerForegroundClickListener(this.Jg);
            gVar.setCurrentPlayCallBack(this);
        }
        dVar.lx();
        if (aVar.lz() != null) {
            aVar.lz().setPosition(i);
            aVar.lz().O(dVar.lu());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view2, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Jd = dVar.lu();
        return super.getView(i, view2, viewGroup, dVar);
    }

    public void lA() {
        if (this.Jh != null) {
            this.Jh.pausePlay();
        }
    }

    public void lB() {
        if (this.Jh != null) {
            this.Jh.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(i iVar) {
        this.Jh = iVar;
        if (this.Jj != null) {
            this.Jj.a(this.Jh);
        }
    }

    public boolean lC() {
        if (this.Jh != null) {
            return this.Jh.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (i iVar : this.Ji) {
            if (iVar != null) {
                iVar.onDestroy();
            }
        }
    }
}
