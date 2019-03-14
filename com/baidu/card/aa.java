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
    private int Zb;
    private int Zc;
    private NewThreadCommentAndPraiseInfoLayout Zd;
    private com.baidu.tbadk.core.data.a Ze;
    private a.C0039a Zf;
    private Runnable Zg;

    public aa(Context context) {
        super(context);
        this.Zb = 11;
        this.Zc = this.Zb;
        this.Zf = new a.C0039a(5);
        this.Zg = new Runnable() { // from class: com.baidu.card.aa.1
            @Override // java.lang.Runnable
            public void run() {
                aa.this.Zf.setExtraData(Integer.valueOf(aa.this.Zd.getCommentContainer().getRight() + aa.this.Xq.rv().YT));
                aa.this.Xq.b(aa.this.Zf);
            }
        };
        this.Zd = new NewThreadCommentAndPraiseInfoLayout(context);
        this.Zd.setReplyTimeVisible(false);
        this.Zd.setShowPraiseNum(true);
        this.Zd.setNeedAddPraiseIcon(true);
        this.Zd.setNeedAddReplyIcon(true);
        this.Zd.setShareVisible(true);
        this.Zd.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.aa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aa.this.rk() != null) {
                    aa.this.rk().a(view, aa.this.Ze);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rj() {
        this.Xq.a(4, new a.b() { // from class: com.baidu.card.aa.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0039a c0039a) {
                if (c0039a.rD() instanceof Boolean) {
                    if (((Boolean) c0039a.rD()).booleanValue()) {
                        aa.this.Zb = aa.this.Zc;
                    } else {
                        aa.this.Zb &= -5;
                    }
                    aa.this.Zd.setShowFlag(aa.this.Zb);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bu(int i) {
        this.Zb |= i;
        this.Zd.setShowFlag(this.Zb);
        this.Zc = this.Zb;
    }

    @Override // com.baidu.card.b
    public void bv(int i) {
        this.Zb &= i ^ (-1);
        this.Zd.setShowFlag(this.Zb);
        this.Zc = this.Zb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Zd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Ze = aVar;
        this.Zd.setData(aVar.WR());
        if ((this.Zb & 4) > 0) {
            this.Zd.post(this.Zg);
        }
        rB();
    }

    private void rB() {
        boolean z;
        b rq = this.Xq.rq();
        if (rq == null) {
            setMarginsTop(this.Zd, y.YM - TBDS6);
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
            List<f> rs = this.Xq.rs();
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
            setMarginsTop(this.Zd, y.YM - TBDS6);
        } else {
            setMarginsTop(this.Zd, y.YM);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Zd.onChangeSkinType();
    }

    public void bA(int i) {
        this.Zd.bSH = i;
    }

    public void setFrom(int i) {
        this.Zd.setFrom(i);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.Zd.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.Zd.setShareReportFrom(i);
    }
}
