package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes.dex */
public class ThreadCardViewHolder<T extends com.baidu.tbadk.core.data.a> extends TypeAdapter.ViewHolder {
    private com.baidu.tieba.card.ab<T> ajW;
    private ak<T> ajX;
    private aq ajY;
    private u ajZ;
    private aj aka;
    private ad akb;
    private j akc;
    private f akd;
    private BdUniqueId mId;
    private ab mNegFeedBackItem;

    public ThreadCardViewHolder(ak<T> akVar) {
        super(akVar.getView());
        this.ajX = akVar;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View getView() {
        return this.ajX.getView();
    }

    public ak<T> tj() {
        return this.ajX;
    }

    private TbPageContext getTbPageContext() {
        return ((TbPageContextSupport) this.ajX.getView().getContext()).getPageContext();
    }

    private void c(c cVar) {
        if (cVar != null && cVar.sT() != null) {
            this.ajX.a(cVar);
        }
    }

    public void a(boolean z, Align align, NEGFeedBackView.a aVar) {
        if (!z) {
            c(this.mNegFeedBackItem);
            return;
        }
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), align);
            this.mNegFeedBackItem.aiR.setUniqueId(this.mId);
            this.mNegFeedBackItem.a(aVar);
        }
        this.mNegFeedBackItem.a(align);
        this.ajX.b(this.mNegFeedBackItem);
    }

    public ab aK(boolean z) {
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), z);
            this.mNegFeedBackItem.aiR.setUniqueId(this.mId);
        }
        this.ajX.b(this.mNegFeedBackItem);
        return this.mNegFeedBackItem;
    }

    public void a(boolean z, Align align) {
        if (!z) {
            c(this.ajY);
            return;
        }
        if (this.ajY == null) {
            this.ajY = new aq(getTbPageContext(), align);
        }
        this.ajY.a(align);
        this.ajX.b(this.ajY);
    }

    public void a(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            c(this.akc);
            return;
        }
        if (this.akc == null) {
            this.akc = new j(getTbPageContext(), com.baidu.tbadk.a.d.biZ());
            this.akc.setOnClickEvent(aVar);
        }
        this.akc.setPageUniqueId(this.mId);
        this.ajX.b(this.akc);
    }

    public u tk() {
        return aL(true);
    }

    public u aL(boolean z) {
        if (this.ajZ == null) {
            this.ajZ = new u(this.ajX.getContext());
        }
        this.ajZ.h(this.mId);
        this.ajZ.aH(z);
        this.ajX.b(this.ajZ);
        return this.ajZ;
    }

    public void b(int i, al alVar) {
        if (this.ajZ != null) {
            this.ajZ.a(i, alVar);
        }
    }

    public aj tl() {
        if (this.aka == null) {
            this.aka = new aj(getTbPageContext());
            this.aka.setPageId(this.mId);
        }
        this.ajX.b(this.aka);
        return this.aka;
    }

    public ad bD(int i) {
        if (this.akb == null) {
            this.akb = new ad(this.ajX.getView().getContext(), i);
            this.akb.setPageId(this.mId);
        }
        this.ajX.b(this.akb);
        return this.akb;
    }

    public f tm() {
        if (this.akd == null) {
            this.akd = new f(getTbPageContext());
        }
        this.ajX.b(this.akd);
        return this.akd;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.ajX.getView().setVisibility(8);
            return;
        }
        if (t.blp() != null) {
            t.blp().getTid();
        }
        if (t.blp() != null && t.blp().bnS() != null) {
            t.blp().bnS().getName_show();
        }
        this.ajX.getView().setVisibility(0);
        if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.aiR != null) {
            if (!t.isSelf() && t.blr() != null) {
                this.mNegFeedBackItem.g(t);
                this.mNegFeedBackItem.E(t.blr());
                this.mNegFeedBackItem.aiR.setVisibility(0);
                z = true;
            } else if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.aiR != null) {
                this.mNegFeedBackItem.aiR.setVisibility(8);
            }
        }
        if (this.ajY != null) {
            if (c(t.blp())) {
                c(this.ajY);
            } else {
                this.ajY.g(t);
                this.ajY.E(t.blp());
            }
        }
        if (this.aka != null) {
            this.aka.aJ(z);
            this.aka.E(t.blp());
        }
        if (this.ajZ != null) {
            this.ajZ.E(t.blp());
        }
        if (this.akb != null) {
            this.akb.g(t);
            this.akb.E(t.blp());
        }
        if (this.akc != null) {
            this.akc.a(t, z);
            this.akc.E(t.blp());
        }
        if (this.akd != null) {
            if (c(t.blp())) {
                this.akd.E(t.blp());
            } else {
                c(this.akd);
            }
        }
        this.ajX.h(t);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.ab<T> abVar) {
        this.ajW = abVar;
        this.ajX.a(abVar);
    }

    private boolean c(cb cbVar) {
        return (cbVar == null || cbVar.bnS() == null || !cbVar.eVg || !com.baidu.tbadk.a.d.bji() || cbVar.bnS().hadConcerned() || az.x(cbVar)) ? false : true;
    }
}
