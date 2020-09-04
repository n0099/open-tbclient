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
    private com.baidu.tieba.card.aa<T> ahf;
    private aj<T> ahg;
    private aq ahh;
    private t ahi;
    private ai ahj;
    private ac ahk;
    private i ahl;
    private BdUniqueId mId;
    private aa mNegFeedBackItem;

    public al(aj<T> ajVar) {
        super(ajVar.getView());
        this.ahg = ajVar;
    }

    @Override // com.baidu.adp.widget.ListView.af.a
    public View getView() {
        return this.ahg.getView();
    }

    public aj<T> tR() {
        return this.ahg;
    }

    private TbPageContext getTbPageContext() {
        return ((TbPageContextSupport) this.ahg.getView().getContext()).getPageContext();
    }

    private void c(d dVar) {
        if (dVar != null && dVar.tB() != null) {
            this.ahg.a(dVar);
        }
    }

    public void a(boolean z, Align align, NEGFeedBackView.a aVar) {
        if (!z) {
            c(this.mNegFeedBackItem);
            return;
        }
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new aa(getTbPageContext(), align);
            this.mNegFeedBackItem.agc.setUniqueId(this.mId);
            this.mNegFeedBackItem.a(aVar);
        }
        this.mNegFeedBackItem.a(align);
        this.ahg.b(this.mNegFeedBackItem);
    }

    public aa aL(boolean z) {
        if (this.mNegFeedBackItem == null) {
            this.mNegFeedBackItem = new aa(getTbPageContext(), z);
            this.mNegFeedBackItem.agc.setUniqueId(this.mId);
        }
        this.ahg.b(this.mNegFeedBackItem);
        return this.mNegFeedBackItem;
    }

    public void a(boolean z, Align align) {
        if (!z) {
            c(this.ahh);
            return;
        }
        if (this.ahh == null) {
            this.ahh = new aq(getTbPageContext(), align);
        }
        this.ahh.a(align);
        this.ahg.b(this.ahh);
    }

    public void a(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            c(this.ahl);
            return;
        }
        if (this.ahl == null) {
            this.ahl = new i(getTbPageContext(), com.baidu.tbadk.a.d.bad());
            this.ahl.setOnClickEvent(aVar);
        }
        this.ahl.setPageUniqueId(this.mId);
        this.ahg.b(this.ahl);
    }

    public t tS() {
        return aM(true);
    }

    public t aM(boolean z) {
        if (this.ahi == null) {
            this.ahi = new t(this.ahg.getContext());
        }
        this.ahi.h(this.mId);
        this.ahi.aI(z);
        this.ahg.b(this.ahi);
        return this.ahi;
    }

    public ai tT() {
        if (this.ahj == null) {
            this.ahj = new ai(getTbPageContext());
            this.ahj.setPageId(this.mId);
        }
        this.ahg.b(this.ahj);
        return this.ahj;
    }

    public ac by(int i) {
        if (this.ahk == null) {
            this.ahk = new ac(this.ahg.getView().getContext(), i);
            this.ahk.setPageId(this.mId);
        }
        this.ahg.b(this.ahk);
        return this.ahk;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.ahg.getView().setVisibility(8);
            return;
        }
        if (t.bce() != null) {
            t.bce().getTid();
        }
        if (t.bce() != null && t.bce().beE() != null) {
            t.bce().beE().getName_show();
        }
        this.ahg.getView().setVisibility(0);
        if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.agc != null) {
            if (!t.isSelf() && t.bcg() != null) {
                this.mNegFeedBackItem.f(t);
                this.mNegFeedBackItem.F(t.bcg());
                this.mNegFeedBackItem.agc.setVisibility(0);
                z = true;
            } else if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.agc != null) {
                this.mNegFeedBackItem.agc.setVisibility(8);
            }
        }
        if (this.ahh != null) {
            this.ahh.f(t);
            this.ahh.F(t.bce());
        }
        if (this.ahj != null) {
            this.ahj.aK(z);
            this.ahj.F(t.bce());
        }
        if (this.ahi != null) {
            this.ahi.F(t.bce());
        }
        if (this.ahk != null) {
            this.ahk.f(t);
            this.ahk.F(t.bce());
        }
        if (this.ahl != null) {
            this.ahl.a(t, z);
            this.ahl.F(t.bce());
        }
        this.ahg.g(t);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.aa<T> aaVar) {
        this.ahf = aaVar;
        this.ahg.a(aaVar);
    }
}
