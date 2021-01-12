package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes.dex */
public class ThreadCardViewHolder<T extends com.baidu.tbadk.core.data.a> extends TypeAdapter.ViewHolder {
    private com.baidu.tieba.card.aa<T> aiQ;
    private ak<T> aiR;
    private aq aiS;
    private u aiT;
    private aj aiU;
    private ad aiV;
    private j aiW;
    private f aiX;
    private BdUniqueId mId;
    private ab mNegFeedBackItem;

    public ThreadCardViewHolder(ak<T> akVar) {
        super(akVar.getView());
        this.aiR = akVar;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View getView() {
        return this.aiR.getView();
    }

    public ak<T> tm() {
        return this.aiR;
    }

    private TbPageContext getTbPageContext() {
        return ((TbPageContextSupport) this.aiR.getView().getContext()).getPageContext();
    }

    private void c(c cVar) {
        if (cVar != null && cVar.sW() != null) {
            this.aiR.a(cVar);
        }
    }

    public void a(boolean z, Align align, NEGFeedBackView.a aVar) {
        if (!z) {
            c(this.mNegFeedBackItem);
            return;
        }
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), align);
            this.mNegFeedBackItem.ahK.setUniqueId(this.mId);
            this.mNegFeedBackItem.a(aVar);
        }
        this.mNegFeedBackItem.a(align);
        this.aiR.b(this.mNegFeedBackItem);
    }

    public ab aK(boolean z) {
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), z);
            this.mNegFeedBackItem.ahK.setUniqueId(this.mId);
        }
        this.aiR.b(this.mNegFeedBackItem);
        return this.mNegFeedBackItem;
    }

    public void a(boolean z, Align align) {
        if (!z) {
            c(this.aiS);
            return;
        }
        if (this.aiS == null) {
            this.aiS = new aq(getTbPageContext(), align);
        }
        this.aiS.a(align);
        this.aiR.b(this.aiS);
    }

    public void a(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            c(this.aiW);
            return;
        }
        if (this.aiW == null) {
            this.aiW = new j(getTbPageContext(), com.baidu.tbadk.a.d.biL());
            this.aiW.setOnClickEvent(aVar);
        }
        this.aiW.setPageUniqueId(this.mId);
        this.aiR.b(this.aiW);
    }

    public u tn() {
        return aL(true);
    }

    public u aL(boolean z) {
        if (this.aiT == null) {
            this.aiT = new u(this.aiR.getContext());
        }
        this.aiT.h(this.mId);
        this.aiT.aH(z);
        this.aiR.b(this.aiT);
        return this.aiT;
    }

    public void b(int i, al alVar) {
        if (this.aiT != null) {
            this.aiT.a(i, alVar);
        }
    }

    public aj tp() {
        if (this.aiU == null) {
            this.aiU = new aj(getTbPageContext());
            this.aiU.setPageId(this.mId);
        }
        this.aiR.b(this.aiU);
        return this.aiU;
    }

    public ad bC(int i) {
        if (this.aiV == null) {
            this.aiV = new ad(this.aiR.getView().getContext(), i);
            this.aiV.setPageId(this.mId);
        }
        this.aiR.b(this.aiV);
        return this.aiV;
    }

    public f tq() {
        if (this.aiX == null) {
            this.aiX = new f(getTbPageContext());
        }
        this.aiR.b(this.aiX);
        return this.aiX;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.aiR.getView().setVisibility(8);
            return;
        }
        if (t.bkV() != null) {
            t.bkV().getTid();
        }
        if (t.bkV() != null && t.bkV().bnx() != null) {
            t.bkV().bnx().getName_show();
        }
        this.aiR.getView().setVisibility(0);
        if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.ahK != null) {
            if (!t.isSelf() && t.bkX() != null) {
                this.mNegFeedBackItem.g(t);
                this.mNegFeedBackItem.C(t.bkX());
                this.mNegFeedBackItem.ahK.setVisibility(0);
                z = true;
            } else if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.ahK != null) {
                this.mNegFeedBackItem.ahK.setVisibility(8);
            }
        }
        if (this.aiS != null) {
            if (c(t.bkV())) {
                c(this.aiS);
            } else {
                this.aiS.g(t);
                this.aiS.C(t.bkV());
            }
        }
        if (this.aiU != null) {
            this.aiU.aJ(z);
            this.aiU.C(t.bkV());
        }
        if (this.aiT != null) {
            this.aiT.C(t.bkV());
        }
        if (this.aiV != null) {
            this.aiV.g(t);
            this.aiV.C(t.bkV());
        }
        if (this.aiW != null) {
            this.aiW.a(t, z);
            this.aiW.C(t.bkV());
        }
        if (this.aiX != null) {
            if (c(t.bkV())) {
                this.aiX.C(t.bkV());
            } else {
                c(this.aiX);
            }
        }
        this.aiR.h(t);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.aa<T> aaVar) {
        this.aiQ = aaVar;
        this.aiR.a(aaVar);
    }

    private boolean c(bz bzVar) {
        return (bzVar == null || bzVar.bnx() == null || !bzVar.eRt || !com.baidu.tbadk.a.d.biU() || bzVar.bnx().hadConcerned() || ay.x(bzVar)) ? false : true;
    }
}
