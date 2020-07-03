package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes8.dex */
public class ak<T extends AbsThreadDataSupport> extends ad.a {
    private com.baidu.tieba.card.aa<T> agc;
    private ai<T> agd;
    private z agf;
    private ap agg;
    private s agh;
    private ah agi;
    private ab agj;
    private i agk;
    private BdUniqueId mId;

    public ak(ai<T> aiVar) {
        super(aiVar.getView());
        this.agd = aiVar;
    }

    @Override // com.baidu.adp.widget.ListView.ad.a
    public View getView() {
        return this.agd.getView();
    }

    public ai<T> se() {
        return this.agd;
    }

    private TbPageContext getTbPageContext() {
        return ((TbPageContextSupport) this.agd.getView().getContext()).getPageContext();
    }

    private void c(d dVar) {
        if (dVar != null && dVar.rO() != null) {
            this.agd.a(dVar);
        }
    }

    public void a(boolean z, Align align, NEGFeedBackView.a aVar) {
        if (!z) {
            c(this.agf);
            return;
        }
        if (this.agf == null) {
            this.agf = new z(getTbPageContext(), align);
            this.agf.afb.setUniqueId(this.mId);
            this.agf.a(aVar);
        }
        this.agf.a(align);
        this.agd.b(this.agf);
    }

    public z aI(boolean z) {
        if (this.agf == null) {
            this.agf = new z(getTbPageContext(), z);
            this.agf.afb.setUniqueId(this.mId);
        }
        this.agd.b(this.agf);
        return this.agf;
    }

    public void a(boolean z, Align align) {
        if (!z) {
            c(this.agg);
            return;
        }
        if (this.agg == null) {
            this.agg = new ap(getTbPageContext(), align);
        }
        this.agg.a(align);
        this.agd.b(this.agg);
    }

    public void a(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            c(this.agk);
            return;
        }
        if (this.agk == null) {
            this.agk = new i(getTbPageContext());
            this.agk.setOnClickEvent(aVar);
            this.agk.setPageUniqueId(this.mId);
        }
        this.agd.b(this.agk);
    }

    public s sf() {
        return aJ(true);
    }

    public s aJ(boolean z) {
        if (this.agh == null) {
            this.agh = new s(this.agd.getContext());
        }
        this.agh.h(this.mId);
        this.agh.aF(z);
        this.agd.b(this.agh);
        return this.agh;
    }

    public ah sg() {
        if (this.agi == null) {
            this.agi = new ah(getTbPageContext());
            this.agi.setPageId(this.mId);
        }
        this.agd.b(this.agi);
        return this.agi;
    }

    public ab br(int i) {
        if (this.agj == null) {
            this.agj = new ab(this.agd.getView().getContext(), i);
            this.agj.setPageId(this.mId);
        }
        this.agd.b(this.agj);
        return this.agj;
    }

    public void b(T t) {
        boolean z = false;
        if (t == null) {
            this.agd.getView().setVisibility(8);
            return;
        }
        if (t.aPS() != null) {
            t.aPS().getTid();
        }
        if (t.aPS() != null && t.aPS().aSp() != null) {
            t.aPS().aSp().getName_show();
        }
        this.agd.getView().setVisibility(0);
        if (this.agf != null && this.agf.afb != null) {
            if (!t.isSelf() && t.aPU() != null) {
                this.agf.f(t);
                this.agf.D(t.aPU());
                this.agf.afb.setVisibility(0);
                z = true;
            } else if (this.agf != null && this.agf.afb != null) {
                this.agf.afb.setVisibility(8);
            }
        }
        if (this.agg != null) {
            this.agg.f(t);
            this.agg.D(t.aPS());
        }
        if (this.agi != null) {
            this.agi.aH(z);
            this.agi.D(t.aPS());
        }
        if (this.agh != null) {
            this.agh.D(t.aPS());
        }
        if (this.agj != null) {
            this.agj.f(t);
            this.agj.D(t.aPS());
        }
        if (this.agk != null) {
            this.agk.a(t, z);
            this.agk.D(t.aPS());
        }
        this.agd.g(t);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void b(com.baidu.tieba.card.aa<T> aaVar) {
        this.agc = aaVar;
        this.agd.a(aaVar);
    }
}
