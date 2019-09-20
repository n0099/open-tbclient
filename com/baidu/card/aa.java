package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class aa extends b<com.baidu.tbadk.core.data.a> {
    private static final int TBDS6 = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
    private int Xn;
    private int Xo;
    private NewThreadCommentAndPraiseInfoLayout Xp;
    private com.baidu.tbadk.core.data.a Xq;
    private a.C0038a Xr;
    private Runnable Xs;

    public aa(Context context) {
        super(context);
        this.Xn = 11;
        this.Xo = this.Xn;
        this.Xr = new a.C0038a(5);
        this.Xs = new Runnable() { // from class: com.baidu.card.aa.1
            @Override // java.lang.Runnable
            public void run() {
                aa.this.Xr.setExtraData(Integer.valueOf(aa.this.Xp.getCommentContainer().getRight() + aa.this.VA.qO().Xf));
                aa.this.VA.b(aa.this.Xr);
            }
        };
        this.Xp = new NewThreadCommentAndPraiseInfoLayout(context);
        this.Xp.setReplyTimeVisible(false);
        this.Xp.setShowPraiseNum(true);
        this.Xp.setNeedAddPraiseIcon(true);
        this.Xp.setNeedAddReplyIcon(true);
        this.Xp.setShareVisible(true);
        this.Xp.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.aa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aa.this.qC() != null) {
                    aa.this.qC().a(view, aa.this.Xq);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void qB() {
        this.VA.a(4, new a.b() { // from class: com.baidu.card.aa.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0038a c0038a) {
                if (c0038a.qW() instanceof Boolean) {
                    if (((Boolean) c0038a.qW()).booleanValue()) {
                        aa.this.Xn = aa.this.Xo;
                    } else {
                        aa.this.Xn &= -5;
                    }
                    aa.this.Xp.setShowFlag(aa.this.Xn);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bm(int i) {
        this.Xn |= i;
        this.Xp.setShowFlag(this.Xn);
        this.Xo = this.Xn;
    }

    @Override // com.baidu.card.b
    public void bn(int i) {
        this.Xn &= i ^ (-1);
        this.Xp.setShowFlag(this.Xn);
        this.Xo = this.Xn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Xp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xq = aVar;
        this.Xp.setData(aVar.acC());
        if ((this.Xn & 4) > 0) {
            this.Xp.post(this.Xs);
        }
        qU();
    }

    private void qU() {
        boolean z;
        b qJ = this.VA.qJ();
        if (qJ == null) {
            setMarginsTop(this.Xp, y.WY - TBDS6);
            return;
        }
        boolean z2 = true;
        ViewGroup viewGroup = (ViewGroup) qJ.getView();
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
            List<f> qL = this.VA.qL();
            if (!com.baidu.tbadk.core.util.v.aa(qL)) {
                for (f fVar : qL) {
                    if (fVar != null && fVar.getView() != null && fVar.getView().getVisibility() == 0) {
                        z = false;
                        break;
                    }
                }
            }
        }
        z = z2;
        if (z) {
            setMarginsTop(this.Xp, y.WY - TBDS6);
        } else {
            setMarginsTop(this.Xp, y.WY);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Xp.onChangeSkinType();
    }

    public void bw(int i) {
        this.Xp.ccG = i;
    }

    public void setFrom(int i) {
        this.Xp.setFrom(i);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.Xp.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.Xp.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.Xp.setGameId(i);
    }
}
