package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes15.dex */
public class al<T extends AbsThreadDataSupport> extends af.a {
    private com.baidu.tieba.card.aa<T> ahd;
    private aj<T> ahe;
    private aq ahf;
    private t ahg;
    private ai ahh;
    private ac ahi;
    private i ahj;
    private BdUniqueId mId;
    private aa mNegFeedBackItem;

    public al(aj<T> ajVar) {
        super(ajVar.getView());
        this.ahe = ajVar;
    }

    @Override // com.baidu.adp.widget.ListView.af.a
    public View getView() {
        return this.ahe.getView();
    }

    public aj<T> tR() {
        return this.ahe;
    }

    private TbPageContext getTbPageContext() {
        return ((TbPageContextSupport) this.ahe.getView().getContext()).getPageContext();
    }

    private void c(d dVar) {
        if (dVar != null && dVar.tB() != null) {
            this.ahe.a(dVar);
        }
    }

    public void a(boolean z, Align align, NEGFeedBackView.a aVar) {
        if (!z) {
            c(this.mNegFeedBackItem);
            return;
        }
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new aa(getTbPageContext(), align);
            this.mNegFeedBackItem.aga.setUniqueId(this.mId);
            this.mNegFeedBackItem.a(aVar);
        }
        this.mNegFeedBackItem.a(align);
        this.ahe.b(this.mNegFeedBackItem);
    }

    public aa aL(boolean z) {
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new aa(getTbPageContext(), z);
            this.mNegFeedBackItem.aga.setUniqueId(this.mId);
        }
        this.ahe.b(this.mNegFeedBackItem);
        return this.mNegFeedBackItem;
    }

    public void a(boolean z, Align align) {
        if (!z) {
            c(this.ahf);
            return;
        }
        if (this.ahf == null) {
            this.ahf = new aq(getTbPageContext(), align);
        }
        this.ahf.a(align);
        this.ahe.b(this.ahf);
    }

    public void a(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            c(this.ahj);
            return;
        }
        if (this.ahj == null) {
            this.ahj = new i(getTbPageContext(), com.baidu.tbadk.a.d.bad());
            this.ahj.setOnClickEvent(aVar);
        }
        this.ahj.setPageUniqueId(this.mId);
        this.ahe.b(this.ahj);
    }

    public t tS() {
        return aM(true);
    }

    public t aM(boolean z) {
        if (this.ahg == null) {
            this.ahg = new t(this.ahe.getContext());
        }
        this.ahg.h(this.mId);
        this.ahg.aI(z);
        this.ahe.b(this.ahg);
        return this.ahg;
    }

    public ai tT() {
        if (this.ahh == null) {
            this.ahh = new ai(getTbPageContext());
            this.ahh.setPageId(this.mId);
        }
        this.ahe.b(this.ahh);
        return this.ahh;
    }

    public ac by(int i) {
        if (this.ahi == null) {
            this.ahi = new ac(this.ahe.getView().getContext(), i);
            this.ahi.setPageId(this.mId);
        }
        this.ahe.b(this.ahi);
        return this.ahi;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.ahe.getView().setVisibility(8);
            return;
        }
        if (t.bce() != null) {
            t.bce().getTid();
        }
        if (t.bce() != null && t.bce().beE() != null) {
            t.bce().beE().getName_show();
        }
        this.ahe.getView().setVisibility(0);
        if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.aga != null) {
            if (!t.isSelf() && t.bcg() != null) {
                this.mNegFeedBackItem.f(t);
                this.mNegFeedBackItem.F(t.bcg());
                this.mNegFeedBackItem.aga.setVisibility(0);
                z = true;
            } else if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.aga != null) {
                this.mNegFeedBackItem.aga.setVisibility(8);
            }
        }
        if (this.ahf != null) {
            this.ahf.f(t);
            this.ahf.F(t.bce());
        }
        if (this.ahh != null) {
            this.ahh.aK(z);
            this.ahh.F(t.bce());
        }
        if (this.ahg != null) {
            this.ahg.F(t.bce());
        }
        if (this.ahi != null) {
            this.ahi.f(t);
            this.ahi.F(t.bce());
        }
        if (this.ahj != null) {
            this.ahj.a(t, z);
            this.ahj.F(t.bce());
        }
        this.ahe.g(t);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.aa<T> aaVar) {
        this.ahd = aaVar;
        this.ahe.a(aaVar);
    }
}
