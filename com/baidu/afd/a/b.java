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
    private ICardInfo AW;
    private TbPageContext AX;
    private com.baidu.tieba.frs.aggregation.a AY;
    private com.baidu.tieba.frs.videomiddlepage.c AZ;
    private j Ba;
    private List<j> Bb;
    private f Bc;
    private com.baidu.afd.d adFacadeData;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, com.baidu.tieba.frs.aggregation.a aVar, com.baidu.tieba.frs.videomiddlepage.c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Bb = new ArrayList();
        this.AX = tbPageContext;
        this.AY = aVar;
        this.AZ = cVar;
        this.Bc = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c */
    public a b(ViewGroup viewGroup) {
        e a;
        if (this.AW == null || (a = com.baidu.tieba.lego.card.b.bHK().a(this.AX, this.AW, 2)) == null) {
            return null;
        }
        if (a instanceof j) {
            this.Bb.add((j) a);
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
        if (dVar == null || dVar.kc() == null) {
            return null;
        }
        this.adFacadeData = dVar;
        this.AW = dVar.kc();
        return b(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.d dVar, boolean z, int i, String str, String str2) {
        if (dVar != null) {
            AdvertAppInfo kd = dVar.kd();
            int i2 = 2;
            if (kd != null && kd.legoCard != null && kd.legoCard.forFree()) {
                i2 = 102;
            }
            com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(kd, i2, i);
            c.CT(str2);
            com.baidu.tieba.recapp.report.c.cgI().a(c);
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
        if (aVar.kh() instanceof h) {
            h hVar = (h) aVar.kh();
            hVar.setAutoPlayCallBack(this.AY);
            hVar.setOnVideoContainerForegroundClickListener(this.AZ);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.kf();
        if (aVar.kh() != null) {
            aVar.kh().setPosition(i);
            aVar.kh().al(dVar.kc());
        }
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, com.baidu.afd.d dVar) {
        this.adFacadeData = dVar;
        this.AW = dVar.kc();
        return super.getView(i, view, viewGroup, dVar);
    }

    public void ki() {
        if (this.Ba != null) {
            this.Ba.pausePlay();
        }
    }

    public void kj() {
        if (this.Ba != null) {
            this.Ba.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        this.Ba = jVar;
        if (this.Bc != null) {
            this.Bc.a(this.Ba);
        }
    }

    public boolean kk() {
        if (this.Ba != null) {
            return this.Ba.isPlaying();
        }
        return false;
    }

    public void onDestory() {
        for (j jVar : this.Bb) {
            if (jVar != null) {
                jVar.onDestroy();
            }
        }
    }
}
