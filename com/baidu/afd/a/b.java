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
    private com.baidu.tieba.frs.aggregation.a DA;
    private com.baidu.tieba.frs.videomiddlepage.c DC;
    private j DD;
    private List<j> DE;
    private f DG;
    private ICardInfo Dy;
    private TbPageContext Dz;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.DE = new ArrayList();
        this.Dz = tbPageContext;
        this.DA = aVar;
        this.DC = cVar;
        this.DG = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c */
    public a b(ViewGroup viewGroup) {
        e a;
        if (this.Dy == null || (a = com.baidu.tieba.lego.card.b.cbK().a(this.Dz, this.Dy, 2)) == null) {
            return null;
        }
        if (a instanceof j) {
            this.DE.add((j) a);
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
        if (dVar == null || dVar.kJ() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.Dy = dVar.kJ();
        return b(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo kK = dVar.kK();
            int i2 = 2;
            if (kK != null && kK.legoCard != null && kK.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(kK, i2, i);
            c.If(str2);
            com.baidu.tieba.recapp.report.c.cDq().a(c);
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
        if (aVar.kO() instanceof h) {
            h hVar = (h) aVar.kO();
            hVar.setAutoPlayCallBack(this.DA);
            hVar.setOnVideoContainerForegroundClickListener(this.DC);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.kM();
        if (aVar.kO() != null) {
            aVar.kO().setPosition(i);
            aVar.kO().ax(dVar.kJ());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Dy = dVar.kJ();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void kP() {
        if (this.DD != null) {
            this.DD.pausePlay();
        }
    }

    public void kQ() {
        if (this.DD != null) {
            this.DD.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        this.DD = jVar;
        if (this.DG != null) {
            this.DG.a(this.DD);
        }
    }

    public boolean kR() {
        if (this.DD != null) {
            return this.DD.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (j jVar : this.DE) {
            if (jVar != null) {
                jVar.onDestroy();
            }
        }
    }
}
