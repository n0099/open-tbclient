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
import com.baidu.tieba.lego.card.view.k;
import com.baidu.tieba.recapp.report.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.afd.d, a> implements f {
    private ICardInfo aaa;
    private TbPageContext aab;
    private com.baidu.tieba.frs.aggregation.a aac;
    private com.baidu.tieba.frs.videomiddlepage.c aad;
    private k aae;
    private List<k> aaf;
    private f aag;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aaf = new ArrayList();
        this.aab = tbPageContext;
        this.aac = aVar;
        this.aad = cVar;
        this.aag = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public a c(ViewGroup viewGroup) {
        e a2;
        if (this.aaa == null || (a2 = com.baidu.tieba.lego.card.b.ddz().a(this.aab, this.aaa, 2)) == null) {
            return null;
        }
        if (a2 instanceof k) {
            this.aaf.add((k) a2);
        }
        a2.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.afd.a.b.1
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i, HashMap<String, Object> hashMap) {
                b.this.a(b.this.adFacadeData, false, b.this.adFacadeData.getPageNum(), "", (String) null);
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str, String str2, HashMap<String, Object> hashMap) {
                b.this.a(b.this.adFacadeData, false, b.this.adFacadeData.getPageNum(), "", (String) null);
            }
        });
        return new a(a2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public a a(ViewGroup viewGroup, com.baidu.afd.d dVar) {
        if (dVar == null || dVar.rr() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.aaa = dVar.rr();
        return c(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo rs = dVar.rs();
            int i2 = 2;
            if (rs != null && rs.legoCard != null && rs.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.c c = g.c(rs, i2, i);
            c.Ss(str2);
            com.baidu.tieba.recapp.report.d.dGf().a(c);
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
        if (aVar.rw() instanceof h) {
            h hVar = (h) aVar.rw();
            hVar.setAutoPlayCallBack(this.aac);
            hVar.setOnVideoContainerForegroundClickListener(this.aad);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.ru();
        if (aVar.rw() != null) {
            aVar.rw().setPosition(i);
            aVar.rw().aN(dVar.rr());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.aaa = dVar.rr();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void rx() {
        if (this.aae != null) {
            this.aae.aSi();
        }
    }

    public void ry() {
        if (this.aae != null) {
            this.aae.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(k kVar) {
        this.aae = kVar;
        if (this.aag != null) {
            this.aag.a(this.aae);
        }
    }

    public boolean rz() {
        if (this.aae != null) {
            return this.aae.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (k kVar : this.aaf) {
            if (kVar != null) {
                kVar.onDestroy();
            }
        }
    }
}
