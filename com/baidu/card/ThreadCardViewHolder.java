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
    private com.baidu.tieba.card.ab<T> aiE;
    private ak<T> aiF;
    private aq aiG;
    private u aiH;
    private aj aiI;
    private ad aiJ;
    private j aiK;
    private f aiL;
    private BdUniqueId mId;
    private ab mNegFeedBackItem;

    public ThreadCardViewHolder(ak<T> akVar) {
        super(akVar.getView());
        this.aiF = akVar;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View getView() {
        return this.aiF.getView();
    }

    public ak<T> tj() {
        return this.aiF;
    }

    private TbPageContext getTbPageContext() {
        return ((TbPageContextSupport) this.aiF.getView().getContext()).getPageContext();
    }

    private void c(c cVar) {
        if (cVar != null && cVar.sT() != null) {
            this.aiF.a(cVar);
        }
    }

    public void a(boolean z, Align align, NEGFeedBackView.a aVar) {
        if (!z) {
            c(this.mNegFeedBackItem);
            return;
        }
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), align);
            this.mNegFeedBackItem.ahy.setUniqueId(this.mId);
            this.mNegFeedBackItem.a(aVar);
        }
        this.mNegFeedBackItem.a(align);
        this.aiF.b(this.mNegFeedBackItem);
    }

    public ab aK(boolean z) {
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), z);
            this.mNegFeedBackItem.ahy.setUniqueId(this.mId);
        }
        this.aiF.b(this.mNegFeedBackItem);
        return this.mNegFeedBackItem;
    }

    public void a(boolean z, Align align) {
        if (!z) {
            c(this.aiG);
            return;
        }
        if (this.aiG == null) {
            this.aiG = new aq(getTbPageContext(), align);
        }
        this.aiG.a(align);
        this.aiF.b(this.aiG);
    }

    public void a(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            c(this.aiK);
            return;
        }
        if (this.aiK == null) {
            this.aiK = new j(getTbPageContext(), com.baidu.tbadk.a.d.biX());
            this.aiK.setOnClickEvent(aVar);
        }
        this.aiK.setPageUniqueId(this.mId);
        this.aiF.b(this.aiK);
    }

    public u tk() {
        return aL(true);
    }

    public u aL(boolean z) {
        if (this.aiH == null) {
            this.aiH = new u(this.aiF.getContext());
        }
        this.aiH.h(this.mId);
        this.aiH.aH(z);
        this.aiF.b(this.aiH);
        return this.aiH;
    }

    public void b(int i, al alVar) {
        if (this.aiH != null) {
            this.aiH.a(i, alVar);
        }
    }

    public aj tl() {
        if (this.aiI == null) {
            this.aiI = new aj(getTbPageContext());
            this.aiI.setPageId(this.mId);
        }
        this.aiF.b(this.aiI);
        return this.aiI;
    }

    public ad bC(int i) {
        if (this.aiJ == null) {
            this.aiJ = new ad(this.aiF.getView().getContext(), i);
            this.aiJ.setPageId(this.mId);
        }
        this.aiF.b(this.aiJ);
        return this.aiJ;
    }

    public f tm() {
        if (this.aiL == null) {
            this.aiL = new f(getTbPageContext());
        }
        this.aiF.b(this.aiL);
        return this.aiL;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.aiF.getView().setVisibility(8);
            return;
        }
        if (t.bln() != null) {
            t.bln().getTid();
        }
        if (t.bln() != null && t.bln().bnQ() != null) {
            t.bln().bnQ().getName_show();
        }
        this.aiF.getView().setVisibility(0);
        if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.ahy != null) {
            if (!t.isSelf() && t.blp() != null) {
                this.mNegFeedBackItem.g(t);
                this.mNegFeedBackItem.C(t.blp());
                this.mNegFeedBackItem.ahy.setVisibility(0);
                z = true;
            } else if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.ahy != null) {
                this.mNegFeedBackItem.ahy.setVisibility(8);
            }
        }
        if (this.aiG != null) {
            if (c(t.bln())) {
                c(this.aiG);
            } else {
                this.aiG.g(t);
                this.aiG.C(t.bln());
            }
        }
        if (this.aiI != null) {
            this.aiI.aJ(z);
            this.aiI.C(t.bln());
        }
        if (this.aiH != null) {
            this.aiH.C(t.bln());
        }
        if (this.aiJ != null) {
            this.aiJ.g(t);
            this.aiJ.C(t.bln());
        }
        if (this.aiK != null) {
            this.aiK.a(t, z);
            this.aiK.C(t.bln());
        }
        if (this.aiL != null) {
            if (c(t.bln())) {
                this.aiL.C(t.bln());
            } else {
                c(this.aiL);
            }
        }
        this.aiF.h(t);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.ab<T> abVar) {
        this.aiE = abVar;
        this.aiF.a(abVar);
    }

    private boolean c(cb cbVar) {
        return (cbVar == null || cbVar.bnQ() == null || !cbVar.eTF || !com.baidu.tbadk.a.d.bjg() || cbVar.bnQ().hadConcerned() || az.x(cbVar)) ? false : true;
    }
}
