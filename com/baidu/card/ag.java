package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes8.dex */
public class ag<T extends AbsThreadDataSupport> extends aa.a {
    private i afA;
    private com.baidu.tieba.card.aa<T> aft;
    private ae<T> afu;
    private x afv;
    private ak afw;
    private r afx;
    private ad afy;
    private z afz;
    private BdUniqueId mId;

    public ag(ae<T> aeVar) {
        super(aeVar.getView());
        this.afu = aeVar;
    }

    @Override // com.baidu.adp.widget.ListView.aa.a
    public View getView() {
        return this.afu.getView();
    }

    public ae<T> rM() {
        return this.afu;
    }

    private TbPageContext getTbPageContext() {
        return ((TbPageContextSupport) this.afu.getView().getContext()).getPageContext();
    }

    private void c(d dVar) {
        if (dVar != null && dVar.rx() != null) {
            this.afu.a(dVar);
        }
    }

    public void a(boolean z, Align align, NEGFeedBackView.a aVar) {
        if (!z) {
            c(this.afv);
            return;
        }
        if (this.afv == null) {
            this.afv = new x(getTbPageContext(), align);
            this.afv.aeu.setUniqueId(this.mId);
            this.afv.a(aVar);
        }
        this.afv.a(align);
        this.afu.b(this.afv);
    }

    public x aH(boolean z) {
        if (this.afv == null) {
            this.afv = new x(getTbPageContext(), z);
            this.afv.aeu.setUniqueId(this.mId);
        }
        this.afu.b(this.afv);
        return this.afv;
    }

    public void a(boolean z, Align align) {
        if (!z) {
            c(this.afw);
            return;
        }
        if (this.afw == null) {
            this.afw = new ak(getTbPageContext(), align);
        }
        this.afw.a(align);
        this.afu.b(this.afw);
    }

    public void a(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            c(this.afA);
            return;
        }
        if (this.afA == null) {
            this.afA = new i(getTbPageContext());
            this.afA.setOnClickEvent(aVar);
            this.afA.setPageUniqueId(this.mId);
        }
        this.afu.b(this.afA);
    }

    public r rN() {
        return aI(true);
    }

    public r aI(boolean z) {
        if (this.afx == null) {
            this.afx = new r(this.afu.getContext());
        }
        this.afx.h(this.mId);
        this.afx.aE(z);
        this.afu.b(this.afx);
        return this.afx;
    }

    public ad rO() {
        if (this.afy == null) {
            this.afy = new ad(getTbPageContext());
            this.afy.setPageId(this.mId);
        }
        this.afu.b(this.afy);
        return this.afy;
    }

    public z bl(int i) {
        if (this.afz == null) {
            this.afz = new z(this.afu.getView().getContext(), i);
            this.afz.setPageId(this.mId);
        }
        this.afu.b(this.afz);
        return this.afz;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.afu.getView().setVisibility(8);
            return;
        }
        if (t.aOi() != null) {
            t.aOi().getTid();
        }
        if (t.aOi() != null && t.aOi().aQx() != null) {
            t.aOi().aQx().getName_show();
        }
        this.afu.getView().setVisibility(0);
        if (this.afv != null && this.afv.aeu != null) {
            if (!t.isSelf() && t.aOk() != null) {
                this.afv.e(t);
                this.afv.D(t.aOk());
                this.afv.aeu.setVisibility(0);
                z = true;
            } else if (this.afv != null && this.afv.aeu != null) {
                this.afv.aeu.setVisibility(8);
            }
        }
        if (this.afw != null) {
            this.afw.e(t);
            this.afw.D(t.aOi());
        }
        if (this.afy != null) {
            this.afy.aG(z);
            this.afy.D(t.aOi());
        }
        if (this.afx != null) {
            this.afx.D(t.aOi());
        }
        if (this.afz != null) {
            this.afz.e(t);
            this.afz.D(t.aOi());
        }
        if (this.afA != null) {
            this.afA.a(t, z);
            this.afA.D(t.aOi());
        }
        this.afu.f(t);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.aa<T> aaVar) {
        this.aft = aaVar;
        this.afu.a(aaVar);
    }
}
