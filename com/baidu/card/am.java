package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes20.dex */
public class am<T extends AbsThreadDataSupport> extends af.a {
    private ar ahA;
    private u ahB;
    private aj ahC;
    private ad ahD;
    private j ahE;
    private g ahF;
    private com.baidu.tieba.card.aa<T> ahy;
    private ak<T> ahz;
    private BdUniqueId mId;
    private ab mNegFeedBackItem;

    public am(ak<T> akVar) {
        super(akVar.getView());
        this.ahz = akVar;
    }

    @Override // com.baidu.adp.widget.ListView.af.a
    public View getView() {
        return this.ahz.getView();
    }

    public ak<T> tW() {
        return this.ahz;
    }

    private TbPageContext getTbPageContext() {
        return ((TbPageContextSupport) this.ahz.getView().getContext()).getPageContext();
    }

    private void c(d dVar) {
        if (dVar != null && dVar.tG() != null) {
            this.ahz.a(dVar);
        }
    }

    public void a(boolean z, Align align, NEGFeedBackView.a aVar) {
        if (!z) {
            c(this.mNegFeedBackItem);
            return;
        }
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), align);
            this.mNegFeedBackItem.agw.setUniqueId(this.mId);
            this.mNegFeedBackItem.a(aVar);
        }
        this.mNegFeedBackItem.a(align);
        this.ahz.b(this.mNegFeedBackItem);
    }

    public ab aL(boolean z) {
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), z);
            this.mNegFeedBackItem.agw.setUniqueId(this.mId);
        }
        this.ahz.b(this.mNegFeedBackItem);
        return this.mNegFeedBackItem;
    }

    public void a(boolean z, Align align) {
        if (!z) {
            c(this.ahA);
            return;
        }
        if (this.ahA == null) {
            this.ahA = new ar(getTbPageContext(), align);
        }
        this.ahA.a(align);
        this.ahz.b(this.ahA);
    }

    public void a(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            c(this.ahE);
            return;
        }
        if (this.ahE == null) {
            this.ahE = new j(getTbPageContext(), com.baidu.tbadk.a.d.baT());
            this.ahE.setOnClickEvent(aVar);
        }
        this.ahE.setPageUniqueId(this.mId);
        this.ahz.b(this.ahE);
    }

    public u tX() {
        return aM(true);
    }

    public u aM(boolean z) {
        if (this.ahB == null) {
            this.ahB = new u(this.ahz.getContext());
        }
        this.ahB.h(this.mId);
        this.ahB.aI(z);
        this.ahz.b(this.ahB);
        return this.ahB;
    }

    public aj tY() {
        if (this.ahC == null) {
            this.ahC = new aj(getTbPageContext());
            this.ahC.setPageId(this.mId);
        }
        this.ahz.b(this.ahC);
        return this.ahC;
    }

    public ad bC(int i) {
        if (this.ahD == null) {
            this.ahD = new ad(this.ahz.getView().getContext(), i);
            this.ahD.setPageId(this.mId);
        }
        this.ahz.b(this.ahD);
        return this.ahD;
    }

    public g tZ() {
        if (this.ahF == null) {
            this.ahF = new g(getTbPageContext());
        }
        this.ahz.b(this.ahF);
        return this.ahF;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.ahz.getView().setVisibility(8);
            return;
        }
        if (t.bcY() != null) {
            t.bcY().getTid();
        }
        if (t.bcY() != null && t.bcY().bfy() != null) {
            t.bcY().bfy().getName_show();
        }
        this.ahz.getView().setVisibility(0);
        if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.agw != null) {
            if (!t.isSelf() && t.bda() != null) {
                this.mNegFeedBackItem.g(t);
                this.mNegFeedBackItem.G(t.bda());
                this.mNegFeedBackItem.agw.setVisibility(0);
                z = true;
            } else if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.agw != null) {
                this.mNegFeedBackItem.agw.setVisibility(8);
            }
        }
        if (this.ahA != null) {
            if (c(t.bcY())) {
                c(this.ahA);
            } else {
                this.ahA.g(t);
                this.ahA.G(t.bcY());
            }
        }
        if (this.ahC != null) {
            this.ahC.aK(z);
            this.ahC.G(t.bcY());
        }
        if (this.ahB != null) {
            this.ahB.G(t.bcY());
        }
        if (this.ahD != null) {
            this.ahD.g(t);
            this.ahD.G(t.bcY());
        }
        if (this.ahE != null) {
            this.ahE.a(t, z);
            this.ahE.G(t.bcY());
        }
        if (this.ahF != null) {
            if (c(t.bcY())) {
                this.ahF.G(t.bcY());
            } else {
                c(this.ahF);
            }
        }
        this.ahz.h(t);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.aa<T> aaVar) {
        this.ahy = aaVar;
        this.ahz.a(aaVar);
    }

    private boolean c(bw bwVar) {
        return (bwVar == null || bwVar.bfy() == null || !bwVar.egu || !com.baidu.tbadk.a.d.bbc() || bwVar.bfy().hadConcerned() || ay.x(bwVar)) ? false : true;
    }
}
