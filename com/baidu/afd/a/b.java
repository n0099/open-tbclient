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
    private com.baidu.tieba.frs.videomiddlepage.c RA;
    private j RB;
    private List<j> RC;
    private f RD;
    private ICardInfo Rx;
    private TbPageContext Ry;
    private com.baidu.tieba.frs.aggregation.a Rz;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.RC = new ArrayList();
        this.Ry = tbPageContext;
        this.Rz = aVar;
        this.RA = cVar;
        this.RD = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        e a;
        if (this.Rx == null || (a = com.baidu.tieba.lego.card.b.bLa().a(this.Ry, this.Rx, 2)) == null) {
            return null;
        }
        if (a instanceof j) {
            this.RC.add((j) a);
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
        if (dVar == null || dVar.ph() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.Rx = dVar.ph();
        return onCreateViewHolder(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo pi = dVar.pi();
            int i2 = 2;
            if (pi != null && pi.legoCard != null && pi.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(pi, i2, i);
            c.Ey(str2);
            com.baidu.tieba.recapp.report.c.cjE().a(c);
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
        if (aVar.pm() instanceof h) {
            h hVar = (h) aVar.pm();
            hVar.setAutoPlayCallBack(this.Rz);
            hVar.setOnVideoContainerForegroundClickListener(this.RA);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.pk();
        if (aVar.pm() != null) {
            aVar.pm().setPosition(i);
            aVar.pm().ao(dVar.ph());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.Rx = dVar.ph();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void pn() {
        if (this.RB != null) {
            this.RB.pausePlay();
        }
    }

    public void po() {
        if (this.RB != null) {
            this.RB.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        this.RB = jVar;
        if (this.RD != null) {
            this.RD.a(this.RB);
        }
    }

    public boolean pp() {
        if (this.RB != null) {
            return this.RB.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (j jVar : this.RC) {
            if (jVar != null) {
                jVar.onDestroy();
            }
        }
    }
}
