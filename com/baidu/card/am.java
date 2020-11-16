package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes20.dex */
public class am<T extends com.baidu.tbadk.core.data.a> extends af.a {
    private com.baidu.tieba.card.ab<T> ahV;
    private ak<T> ahW;
    private ar ahX;
    private u ahY;
    private aj ahZ;
    private ad aia;
    private j aib;
    private g aic;
    private BdUniqueId mId;
    private ab mNegFeedBackItem;

    public am(ak<T> akVar) {
        super(akVar.getView());
        this.ahW = akVar;
    }

    @Override // com.baidu.adp.widget.ListView.af.a
    public View getView() {
        return this.ahW.getView();
    }

    public ak<T> tW() {
        return this.ahW;
    }

    private TbPageContext getTbPageContext() {
        return ((TbPageContextSupport) this.ahW.getView().getContext()).getPageContext();
    }

    private void c(d dVar) {
        if (dVar != null && dVar.tG() != null) {
            this.ahW.a(dVar);
        }
    }

    public void a(boolean z, Align align, NEGFeedBackView.a aVar) {
        if (!z) {
            c(this.mNegFeedBackItem);
            return;
        }
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), align);
            this.mNegFeedBackItem.agQ.setUniqueId(this.mId);
            this.mNegFeedBackItem.a(aVar);
        }
        this.mNegFeedBackItem.a(align);
        this.ahW.b(this.mNegFeedBackItem);
    }

    public ab aN(boolean z) {
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), z);
            this.mNegFeedBackItem.agQ.setUniqueId(this.mId);
        }
        this.ahW.b(this.mNegFeedBackItem);
        return this.mNegFeedBackItem;
    }

    public void a(boolean z, Align align) {
        if (!z) {
            c(this.ahX);
            return;
        }
        if (this.ahX == null) {
            this.ahX = new ar(getTbPageContext(), align);
        }
        this.ahX.a(align);
        this.ahW.b(this.ahX);
    }

    public void a(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            c(this.aib);
            return;
        }
        if (this.aib == null) {
            this.aib = new j(getTbPageContext(), com.baidu.tbadk.a.d.bhm());
            this.aib.setOnClickEvent(aVar);
        }
        this.aib.setPageUniqueId(this.mId);
        this.ahW.b(this.aib);
    }

    public u tX() {
        return aO(true);
    }

    public u aO(boolean z) {
        if (this.ahY == null) {
            this.ahY = new u(this.ahW.getContext());
        }
        this.ahY.h(this.mId);
        this.ahY.aJ(z);
        this.ahW.b(this.ahY);
        return this.ahY;
    }

    public void b(int i, al alVar) {
        if (this.ahY != null) {
            this.ahY.a(i, alVar);
        }
    }

    public aj tY() {
        if (this.ahZ == null) {
            this.ahZ = new aj(getTbPageContext());
            this.ahZ.setPageId(this.mId);
        }
        this.ahW.b(this.ahZ);
        return this.ahZ;
    }

    public ad bA(int i) {
        if (this.aia == null) {
            this.aia = new ad(this.ahW.getView().getContext(), i);
            this.aia.setPageId(this.mId);
        }
        this.ahW.b(this.aia);
        return this.aia;
    }

    public g tZ() {
        if (this.aic == null) {
            this.aic = new g(getTbPageContext());
        }
        this.ahW.b(this.aic);
        return this.aic;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.ahW.getView().setVisibility(8);
            return;
        }
        if (t.bjd() != null) {
            t.bjd().getTid();
        }
        if (t.bjd() != null && t.bjd().blC() != null) {
            t.bjd().blC().getName_show();
        }
        this.ahW.getView().setVisibility(0);
        if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.agQ != null) {
            if (!t.isSelf() && t.bjf() != null) {
                this.mNegFeedBackItem.g(t);
                this.mNegFeedBackItem.H(t.bjf());
                this.mNegFeedBackItem.agQ.setVisibility(0);
                z = true;
            } else if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.agQ != null) {
                this.mNegFeedBackItem.agQ.setVisibility(8);
            }
        }
        if (this.ahX != null) {
            if (c(t.bjd())) {
                c(this.ahX);
            } else {
                this.ahX.g(t);
                this.ahX.H(t.bjd());
            }
        }
        if (this.ahZ != null) {
            this.ahZ.aL(z);
            this.ahZ.H(t.bjd());
        }
        if (this.ahY != null) {
            this.ahY.H(t.bjd());
        }
        if (this.aia != null) {
            this.aia.g(t);
            this.aia.H(t.bjd());
        }
        if (this.aib != null) {
            this.aib.a(t, z);
            this.aib.H(t.bjd());
        }
        if (this.aic != null) {
            if (c(t.bjd())) {
                this.aic.H(t.bjd());
            } else {
                c(this.aic);
            }
        }
        this.ahW.h((ak<T>) t);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.ab<T> abVar) {
        this.ahV = abVar;
        this.ahW.a(abVar);
    }

    private boolean c(bx bxVar) {
        return (bxVar == null || bxVar.blC() == null || !bxVar.eFh || !com.baidu.tbadk.a.d.bhv() || bxVar.blC().hadConcerned() || az.x(bxVar)) ? false : true;
    }
}
