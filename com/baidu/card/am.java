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
/* loaded from: classes21.dex */
public class am<T extends AbsThreadDataSupport> extends af.a {
    private com.baidu.tieba.card.ab<T> ahQ;
    private ak<T> ahR;
    private ar ahS;
    private u ahT;
    private aj ahU;
    private ad ahV;
    private j ahW;
    private g ahX;
    private BdUniqueId mId;
    private ab mNegFeedBackItem;

    public am(ak<T> akVar) {
        super(akVar.getView());
        this.ahR = akVar;
    }

    @Override // com.baidu.adp.widget.ListView.af.a
    public View getView() {
        return this.ahR.getView();
    }

    public ak<T> tW() {
        return this.ahR;
    }

    private TbPageContext getTbPageContext() {
        return ((TbPageContextSupport) this.ahR.getView().getContext()).getPageContext();
    }

    private void c(d dVar) {
        if (dVar != null && dVar.tG() != null) {
            this.ahR.a(dVar);
        }
    }

    public void a(boolean z, Align align, NEGFeedBackView.a aVar) {
        if (!z) {
            c(this.mNegFeedBackItem);
            return;
        }
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), align);
            this.mNegFeedBackItem.agO.setUniqueId(this.mId);
            this.mNegFeedBackItem.a(aVar);
        }
        this.mNegFeedBackItem.a(align);
        this.ahR.b(this.mNegFeedBackItem);
    }

    public ab aL(boolean z) {
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), z);
            this.mNegFeedBackItem.agO.setUniqueId(this.mId);
        }
        this.ahR.b(this.mNegFeedBackItem);
        return this.mNegFeedBackItem;
    }

    public void a(boolean z, Align align) {
        if (!z) {
            c(this.ahS);
            return;
        }
        if (this.ahS == null) {
            this.ahS = new ar(getTbPageContext(), align);
        }
        this.ahS.a(align);
        this.ahR.b(this.ahS);
    }

    public void a(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            c(this.ahW);
            return;
        }
        if (this.ahW == null) {
            this.ahW = new j(getTbPageContext(), com.baidu.tbadk.a.d.bhU());
            this.ahW.setOnClickEvent(aVar);
        }
        this.ahW.setPageUniqueId(this.mId);
        this.ahR.b(this.ahW);
    }

    public u tX() {
        return aM(true);
    }

    public u aM(boolean z) {
        if (this.ahT == null) {
            this.ahT = new u(this.ahR.getContext());
        }
        this.ahT.h(this.mId);
        this.ahT.aI(z);
        this.ahR.b(this.ahT);
        return this.ahT;
    }

    public aj tY() {
        if (this.ahU == null) {
            this.ahU = new aj(getTbPageContext());
            this.ahU.setPageId(this.mId);
        }
        this.ahR.b(this.ahU);
        return this.ahU;
    }

    public ad bC(int i) {
        if (this.ahV == null) {
            this.ahV = new ad(this.ahR.getView().getContext(), i);
            this.ahV.setPageId(this.mId);
        }
        this.ahR.b(this.ahV);
        return this.ahV;
    }

    public g tZ() {
        if (this.ahX == null) {
            this.ahX = new g(getTbPageContext());
        }
        this.ahR.b(this.ahX);
        return this.ahX;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.ahR.getView().setVisibility(8);
            return;
        }
        if (t.bjZ() != null) {
            t.bjZ().getTid();
        }
        if (t.bjZ() != null && t.bjZ().bmA() != null) {
            t.bjZ().bmA().getName_show();
        }
        this.ahR.getView().setVisibility(0);
        if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.agO != null) {
            if (!t.isSelf() && t.bkb() != null) {
                this.mNegFeedBackItem.g(t);
                this.mNegFeedBackItem.H(t.bkb());
                this.mNegFeedBackItem.agO.setVisibility(0);
                z = true;
            } else if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.agO != null) {
                this.mNegFeedBackItem.agO.setVisibility(8);
            }
        }
        if (this.ahS != null) {
            if (c(t.bjZ())) {
                c(this.ahS);
            } else {
                this.ahS.g(t);
                this.ahS.H(t.bjZ());
            }
        }
        if (this.ahU != null) {
            this.ahU.aK(z);
            this.ahU.H(t.bjZ());
        }
        if (this.ahT != null) {
            this.ahT.H(t.bjZ());
        }
        if (this.ahV != null) {
            this.ahV.g(t);
            this.ahV.H(t.bjZ());
        }
        if (this.ahW != null) {
            this.ahW.a(t, z);
            this.ahW.H(t.bjZ());
        }
        if (this.ahX != null) {
            if (c(t.bjZ())) {
                this.ahX.H(t.bjZ());
            } else {
                c(this.ahX);
            }
        }
        this.ahR.h(t);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.ab<T> abVar) {
        this.ahQ = abVar;
        this.ahR.a(abVar);
    }

    private boolean c(bw bwVar) {
        return (bwVar == null || bwVar.bmA() == null || !bwVar.eGP || !com.baidu.tbadk.a.d.bid() || bwVar.bmA().hadConcerned() || ay.x(bwVar)) ? false : true;
    }
}
