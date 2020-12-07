package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes21.dex */
public class am<T extends com.baidu.tbadk.core.data.a> extends af.a {
    private com.baidu.tieba.card.ab<T> aiV;
    private ak<T> aiW;
    private ar aiX;
    private u aiY;
    private aj aiZ;
    private ad aja;
    private j ajb;
    private g ajc;
    private BdUniqueId mId;
    private ab mNegFeedBackItem;

    public am(ak<T> akVar) {
        super(akVar.getView());
        this.aiW = akVar;
    }

    @Override // com.baidu.adp.widget.ListView.af.a
    public View getView() {
        return this.aiW.getView();
    }

    public ak<T> tZ() {
        return this.aiW;
    }

    private TbPageContext getTbPageContext() {
        return ((TbPageContextSupport) this.aiW.getView().getContext()).getPageContext();
    }

    private void c(d dVar) {
        if (dVar != null && dVar.tJ() != null) {
            this.aiW.a(dVar);
        }
    }

    public void a(boolean z, Align align, NEGFeedBackView.a aVar) {
        if (!z) {
            c(this.mNegFeedBackItem);
            return;
        }
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), align);
            this.mNegFeedBackItem.ahP.setUniqueId(this.mId);
            this.mNegFeedBackItem.a(aVar);
        }
        this.mNegFeedBackItem.a(align);
        this.aiW.b(this.mNegFeedBackItem);
    }

    public ab aN(boolean z) {
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), z);
            this.mNegFeedBackItem.ahP.setUniqueId(this.mId);
        }
        this.aiW.b(this.mNegFeedBackItem);
        return this.mNegFeedBackItem;
    }

    public void a(boolean z, Align align) {
        if (!z) {
            c(this.aiX);
            return;
        }
        if (this.aiX == null) {
            this.aiX = new ar(getTbPageContext(), align);
        }
        this.aiX.a(align);
        this.aiW.b(this.aiX);
    }

    public void a(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            c(this.ajb);
            return;
        }
        if (this.ajb == null) {
            this.ajb = new j(getTbPageContext(), com.baidu.tbadk.a.d.bkq());
            this.ajb.setOnClickEvent(aVar);
        }
        this.ajb.setPageUniqueId(this.mId);
        this.aiW.b(this.ajb);
    }

    public u ua() {
        return aO(true);
    }

    public u aO(boolean z) {
        if (this.aiY == null) {
            this.aiY = new u(this.aiW.getContext());
        }
        this.aiY.h(this.mId);
        this.aiY.aI(z);
        this.aiW.b(this.aiY);
        return this.aiY;
    }

    public void b(int i, al alVar) {
        if (this.aiY != null) {
            this.aiY.a(i, alVar);
        }
    }

    public aj ub() {
        if (this.aiZ == null) {
            this.aiZ = new aj(getTbPageContext());
            this.aiZ.setPageId(this.mId);
        }
        this.aiW.b(this.aiZ);
        return this.aiZ;
    }

    public ad bE(int i) {
        if (this.aja == null) {
            this.aja = new ad(this.aiW.getView().getContext(), i);
            this.aja.setPageId(this.mId);
        }
        this.aiW.b(this.aja);
        return this.aja;
    }

    public g uc() {
        if (this.ajc == null) {
            this.ajc = new g(getTbPageContext());
        }
        this.aiW.b(this.ajc);
        return this.ajc;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.aiW.getView().setVisibility(8);
            return;
        }
        if (t.bmn() != null) {
            t.bmn().getTid();
        }
        if (t.bmn() != null && t.bmn().boP() != null) {
            t.bmn().boP().getName_show();
        }
        this.aiW.getView().setVisibility(0);
        if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.ahP != null) {
            if (!t.isSelf() && t.bmp() != null) {
                this.mNegFeedBackItem.g(t);
                this.mNegFeedBackItem.H(t.bmp());
                this.mNegFeedBackItem.ahP.setVisibility(0);
                z = true;
            } else if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.ahP != null) {
                this.mNegFeedBackItem.ahP.setVisibility(8);
            }
        }
        if (this.aiX != null) {
            if (c(t.bmn())) {
                c(this.aiX);
            } else {
                this.aiX.g(t);
                this.aiX.H(t.bmn());
            }
        }
        if (this.aiZ != null) {
            this.aiZ.aK(z);
            this.aiZ.H(t.bmn());
        }
        if (this.aiY != null) {
            this.aiY.H(t.bmn());
        }
        if (this.aja != null) {
            this.aja.g(t);
            this.aja.H(t.bmn());
        }
        if (this.ajb != null) {
            this.ajb.a(t, z);
            this.ajb.H(t.bmn());
        }
        if (this.ajc != null) {
            if (c(t.bmn())) {
                this.ajc.H(t.bmn());
            } else {
                c(this.ajc);
            }
        }
        this.aiW.h((ak<T>) t);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.ab<T> abVar) {
        this.aiV = abVar;
        this.aiW.a(abVar);
    }

    private boolean c(by byVar) {
        return (byVar == null || byVar.boP() == null || !byVar.eMj || !com.baidu.tbadk.a.d.bkz() || byVar.boP().hadConcerned() || az.x(byVar)) ? false : true;
    }
}
