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
    private com.baidu.tieba.card.aa<T> ajH;
    private ak<T> ajI;
    private aq ajJ;
    private u ajK;
    private aj ajL;
    private ad ajM;
    private j ajN;
    private f ajO;
    private BdUniqueId mId;
    private ab mNegFeedBackItem;

    public ThreadCardViewHolder(ak<T> akVar) {
        super(akVar.getView());
        this.ajI = akVar;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View getView() {
        return this.ajI.getView();
    }

    public ak<T> ty() {
        return this.ajI;
    }

    private TbPageContext getTbPageContext() {
        return ((TbPageContextSupport) this.ajI.getView().getContext()).getPageContext();
    }

    private void c(c cVar) {
        if (cVar != null && cVar.th() != null) {
            this.ajI.a(cVar);
        }
    }

    public void a(boolean z, Align align, NEGFeedBackView.a aVar) {
        if (!z) {
            c(this.mNegFeedBackItem);
            return;
        }
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), align);
            this.mNegFeedBackItem.aiC.setUniqueId(this.mId);
            this.mNegFeedBackItem.a(aVar);
        }
        this.mNegFeedBackItem.a(align);
        this.ajI.b(this.mNegFeedBackItem);
    }

    public ab aK(boolean z) {
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new ab(getTbPageContext(), z);
            this.mNegFeedBackItem.aiC.setUniqueId(this.mId);
        }
        this.ajI.b(this.mNegFeedBackItem);
        return this.mNegFeedBackItem;
    }

    public void a(boolean z, Align align) {
        if (!z) {
            c(this.ajJ);
            return;
        }
        if (this.ajJ == null) {
            this.ajJ = new aq(getTbPageContext(), align);
        }
        this.ajJ.a(align);
        this.ajI.b(this.ajJ);
    }

    public void a(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            c(this.ajN);
            return;
        }
        if (this.ajN == null) {
            this.ajN = new j(getTbPageContext(), com.baidu.tbadk.a.d.bmF());
            this.ajN.setOnClickEvent(aVar);
        }
        this.ajN.setPageUniqueId(this.mId);
        this.ajI.b(this.ajN);
    }

    public u tz() {
        return aL(true);
    }

    public u aL(boolean z) {
        if (this.ajK == null) {
            this.ajK = new u(this.ajI.getContext());
        }
        this.ajK.h(this.mId);
        this.ajK.aH(z);
        this.ajI.b(this.ajK);
        return this.ajK;
    }

    public void b(int i, al alVar) {
        if (this.ajK != null) {
            this.ajK.a(i, alVar);
        }
    }

    public aj tA() {
        if (this.ajL == null) {
            this.ajL = new aj(getTbPageContext());
            this.ajL.setPageId(this.mId);
        }
        this.ajI.b(this.ajL);
        return this.ajL;
    }

    public ad bE(int i) {
        if (this.ajM == null) {
            this.ajM = new ad(this.ajI.getView().getContext(), i);
            this.ajM.setPageId(this.mId);
        }
        this.ajI.b(this.ajM);
        return this.ajM;
    }

    public f tB() {
        if (this.ajO == null) {
            this.ajO = new f(getTbPageContext());
        }
        this.ajI.b(this.ajO);
        return this.ajO;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.ajI.getView().setVisibility(8);
            return;
        }
        if (t.boP() != null) {
            t.boP().getTid();
        }
        if (t.boP() != null && t.boP().brr() != null) {
            t.boP().brr().getName_show();
        }
        this.ajI.getView().setVisibility(0);
        if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.aiC != null) {
            if (!t.isSelf() && t.boR() != null) {
                this.mNegFeedBackItem.g(t);
                this.mNegFeedBackItem.D(t.boR());
                this.mNegFeedBackItem.aiC.setVisibility(0);
                z = true;
            } else if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.aiC != null) {
                this.mNegFeedBackItem.aiC.setVisibility(8);
            }
        }
        if (this.ajJ != null) {
            if (c(t.boP())) {
                c(this.ajJ);
            } else {
                this.ajJ.g(t);
                this.ajJ.D(t.boP());
            }
        }
        if (this.ajL != null) {
            this.ajL.aJ(z);
            this.ajL.D(t.boP());
        }
        if (this.ajK != null) {
            this.ajK.D(t.boP());
        }
        if (this.ajM != null) {
            this.ajM.g(t);
            this.ajM.D(t.boP());
        }
        if (this.ajN != null) {
            this.ajN.a(t, z);
            this.ajN.D(t.boP());
        }
        if (this.ajO != null) {
            if (c(t.boP())) {
                this.ajO.D(t.boP());
            } else {
                c(this.ajO);
            }
        }
        this.ajI.h(t);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.aa<T> aaVar) {
        this.ajH = aaVar;
        this.ajI.a(aaVar);
    }

    private boolean c(bz bzVar) {
        return (bzVar == null || bzVar.brr() == null || !bzVar.eWe || !com.baidu.tbadk.a.d.bmO() || bzVar.brr().hadConcerned() || ay.x(bzVar)) ? false : true;
    }
}
