package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class aa extends b<com.baidu.tbadk.core.data.a> {
    private static final int TBDS6 = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds6);
    private int Zc;
    private int Zd;
    private NewThreadCommentAndPraiseInfoLayout Ze;
    private com.baidu.tbadk.core.data.a Zf;
    private a.C0039a Zg;
    private Runnable Zh;

    public aa(Context context) {
        super(context);
        this.Zc = 11;
        this.Zd = this.Zc;
        this.Zg = new a.C0039a(5);
        this.Zh = new Runnable() { // from class: com.baidu.card.aa.1
            @Override // java.lang.Runnable
            public void run() {
                aa.this.Zg.setExtraData(Integer.valueOf(aa.this.Ze.getCommentContainer().getRight() + aa.this.Xr.rv().YU));
                aa.this.Xr.b(aa.this.Zg);
            }
        };
        this.Ze = new NewThreadCommentAndPraiseInfoLayout(context);
        this.Ze.setReplyTimeVisible(false);
        this.Ze.setShowPraiseNum(true);
        this.Ze.setNeedAddPraiseIcon(true);
        this.Ze.setNeedAddReplyIcon(true);
        this.Ze.setShareVisible(true);
        this.Ze.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.aa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aa.this.rk() != null) {
                    aa.this.rk().a(view, aa.this.Zf);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rj() {
        this.Xr.a(4, new a.b() { // from class: com.baidu.card.aa.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0039a c0039a) {
                if (c0039a.rD() instanceof Boolean) {
                    if (((Boolean) c0039a.rD()).booleanValue()) {
                        aa.this.Zc = aa.this.Zd;
                    } else {
                        aa.this.Zc &= -5;
                    }
                    aa.this.Ze.setShowFlag(aa.this.Zc);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bt(int i) {
        this.Zc |= i;
        this.Ze.setShowFlag(this.Zc);
        this.Zd = this.Zc;
    }

    @Override // com.baidu.card.b
    public void bu(int i) {
        this.Zc &= i ^ (-1);
        this.Ze.setShowFlag(this.Zc);
        this.Zd = this.Zc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Ze;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Zf = aVar;
        this.Ze.setData(aVar.WO());
        if ((this.Zc & 4) > 0) {
            this.Ze.post(this.Zh);
        }
        rB();
    }

    private void rB() {
        boolean z;
        b rq = this.Xr.rq();
        if (rq == null) {
            setMarginsTop(this.Ze, y.YN - TBDS6);
            return;
        }
        boolean z2 = true;
        ViewGroup viewGroup = (ViewGroup) rq.getView();
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (!(viewGroup.getChildAt(i) instanceof TextView) && viewGroup.getChildAt(i).getVisibility() == 0) {
                z2 = false;
                break;
            }
            i++;
        }
        if (z2) {
            List<f> rs = this.Xr.rs();
            if (!com.baidu.tbadk.core.util.v.T(rs)) {
                for (f fVar : rs) {
                    if (fVar != null && fVar.getView() != null && fVar.getView().getVisibility() == 0) {
                        z = false;
                        break;
                    }
                }
            }
        }
        z = z2;
        if (z) {
            setMarginsTop(this.Ze, y.YN - TBDS6);
        } else {
            setMarginsTop(this.Ze, y.YN);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Ze.onChangeSkinType();
    }

    public void bz(int i) {
        this.Ze.bSK = i;
    }

    public void setFrom(int i) {
        this.Ze.setFrom(i);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.Ze.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.Ze.setShareReportFrom(i);
    }
}
