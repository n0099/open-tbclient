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
    private com.baidu.tieba.card.aa<T> ahP;
    private ak<T> ahQ;
    private ar ahR;
    private u ahS;
    private aj ahT;
    private ad ahU;
    private j ahV;
    private g ahW;
    private BdUniqueId mId;
    private ab mNegFeedBackItem;

    public am(ak<T> akVar) {
        super(akVar.getView());
        this.ahQ = akVar;
    }

    @Override // com.baidu.adp.widget.ListView.af.a
    public View getView() {
        return this.ahQ.getView();
    }

    public ak<T> tW() {
        return this.ahQ;
    }

    private TbPageContext getTbPageContext() {
        return ((TbPageContextSupport) this.ahQ.getView().getContext()).getPageContext();
    }

    private void c(d dVar) {
        if (dVar != null && dVar.tG() != null) {
            this.ahQ.a(dVar);
        }
    }

    public void a(boolean z, Align align, NEGFeedBackView.a aVar) {
        if (!z) {
            c(this.mNegFeedBackItem);
            return;
        }
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), align);
            this.mNegFeedBackItem.agN.setUniqueId(this.mId);
            this.mNegFeedBackItem.a(aVar);
        }
        this.mNegFeedBackItem.a(align);
        this.ahQ.b(this.mNegFeedBackItem);
    }

    public ab aL(boolean z) {
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), z);
            this.mNegFeedBackItem.agN.setUniqueId(this.mId);
        }
        this.ahQ.b(this.mNegFeedBackItem);
        return this.mNegFeedBackItem;
    }

    public void a(boolean z, Align align) {
        if (!z) {
            c(this.ahR);
            return;
        }
        if (this.ahR == null) {
            this.ahR = new ar(getTbPageContext(), align);
        }
        this.ahR.a(align);
        this.ahQ.b(this.ahR);
    }

    public void a(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            c(this.ahV);
            return;
        }
        if (this.ahV == null) {
            this.ahV = new j(getTbPageContext(), com.baidu.tbadk.a.d.bdB());
            this.ahV.setOnClickEvent(aVar);
        }
        this.ahV.setPageUniqueId(this.mId);
        this.ahQ.b(this.ahV);
    }

    public u tX() {
        return aM(true);
    }

    public u aM(boolean z) {
        if (this.ahS == null) {
            this.ahS = new u(this.ahQ.getContext());
        }
        this.ahS.h(this.mId);
        this.ahS.aI(z);
        this.ahQ.b(this.ahS);
        return this.ahS;
    }

    public aj tY() {
        if (this.ahT == null) {
            this.ahT = new aj(getTbPageContext());
            this.ahT.setPageId(this.mId);
        }
        this.ahQ.b(this.ahT);
        return this.ahT;
    }

    public ad bC(int i) {
        if (this.ahU == null) {
            this.ahU = new ad(this.ahQ.getView().getContext(), i);
            this.ahU.setPageId(this.mId);
        }
        this.ahQ.b(this.ahU);
        return this.ahU;
    }

    public g tZ() {
        if (this.ahW == null) {
            this.ahW = new g(getTbPageContext());
        }
        this.ahQ.b(this.ahW);
        return this.ahW;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.ahQ.getView().setVisibility(8);
            return;
        }
        if (t.bfG() != null) {
            t.bfG().getTid();
        }
        if (t.bfG() != null && t.bfG().bih() != null) {
            t.bfG().bih().getName_show();
        }
        this.ahQ.getView().setVisibility(0);
        if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.agN != null) {
            if (!t.isSelf() && t.bfI() != null) {
                this.mNegFeedBackItem.g(t);
                this.mNegFeedBackItem.H(t.bfI());
                this.mNegFeedBackItem.agN.setVisibility(0);
                z = true;
            } else if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.agN != null) {
                this.mNegFeedBackItem.agN.setVisibility(8);
            }
        }
        if (this.ahR != null) {
            if (c(t.bfG())) {
                c(this.ahR);
            } else {
                this.ahR.g(t);
                this.ahR.H(t.bfG());
            }
        }
        if (this.ahT != null) {
            this.ahT.aK(z);
            this.ahT.H(t.bfG());
        }
        if (this.ahS != null) {
            this.ahS.H(t.bfG());
        }
        if (this.ahU != null) {
            this.ahU.g(t);
            this.ahU.H(t.bfG());
        }
        if (this.ahV != null) {
            this.ahV.a(t, z);
            this.ahV.H(t.bfG());
        }
        if (this.ahW != null) {
            if (c(t.bfG())) {
                this.ahW.H(t.bfG());
            } else {
                c(this.ahW);
            }
        }
        this.ahQ.h(t);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.aa<T> aaVar) {
        this.ahP = aaVar;
        this.ahQ.a(aaVar);
    }

    private boolean c(bw bwVar) {
        return (bwVar == null || bwVar.bih() == null || !bwVar.esA || !com.baidu.tbadk.a.d.bdK() || bwVar.bih().hadConcerned() || ay.x(bwVar)) ? false : true;
    }
}
