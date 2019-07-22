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
    private int Xo;
    private int Xp;
    private NewThreadCommentAndPraiseInfoLayout Xq;
    private com.baidu.tbadk.core.data.a Xr;
    private a.C0038a Xs;
    private Runnable Xt;

    public aa(Context context) {
        super(context);
        this.Xo = 11;
        this.Xp = this.Xo;
        this.Xs = new a.C0038a(5);
        this.Xt = new Runnable() { // from class: com.baidu.card.aa.1
            @Override // java.lang.Runnable
            public void run() {
                aa.this.Xs.setExtraData(Integer.valueOf(aa.this.Xq.getCommentContainer().getRight() + aa.this.VB.qN().Xg));
                aa.this.VB.b(aa.this.Xs);
            }
        };
        this.Xq = new NewThreadCommentAndPraiseInfoLayout(context);
        this.Xq.setReplyTimeVisible(false);
        this.Xq.setShowPraiseNum(true);
        this.Xq.setNeedAddPraiseIcon(true);
        this.Xq.setNeedAddReplyIcon(true);
        this.Xq.setShareVisible(true);
        this.Xq.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.aa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aa.this.qB() != null) {
                    aa.this.qB().a(view, aa.this.Xr);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void qA() {
        this.VB.a(4, new a.b() { // from class: com.baidu.card.aa.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0038a c0038a) {
                if (c0038a.qV() instanceof Boolean) {
                    if (((Boolean) c0038a.qV()).booleanValue()) {
                        aa.this.Xo = aa.this.Xp;
                    } else {
                        aa.this.Xo &= -5;
                    }
                    aa.this.Xq.setShowFlag(aa.this.Xo);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bm(int i) {
        this.Xo |= i;
        this.Xq.setShowFlag(this.Xo);
        this.Xp = this.Xo;
    }

    @Override // com.baidu.card.b
    public void bn(int i) {
        this.Xo &= i ^ (-1);
        this.Xq.setShowFlag(this.Xo);
        this.Xp = this.Xo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Xq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xr = aVar;
        this.Xq.setData(aVar.acx());
        if ((this.Xo & 4) > 0) {
            this.Xq.post(this.Xt);
        }
        qT();
    }

    private void qT() {
        boolean z;
        b qI = this.VB.qI();
        if (qI == null) {
            setMarginsTop(this.Xq, y.WZ - TBDS6);
            return;
        }
        boolean z2 = true;
        ViewGroup viewGroup = (ViewGroup) qI.getView();
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
            List<f> qK = this.VB.qK();
            if (!com.baidu.tbadk.core.util.v.aa(qK)) {
                for (f fVar : qK) {
                    if (fVar != null && fVar.getView() != null && fVar.getView().getVisibility() == 0) {
                        z = false;
                        break;
                    }
                }
            }
        }
        z = z2;
        if (z) {
            setMarginsTop(this.Xq, y.WZ - TBDS6);
        } else {
            setMarginsTop(this.Xq, y.WZ);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Xq.onChangeSkinType();
    }

    public void bw(int i) {
        this.Xq.cbF = i;
    }

    public void setFrom(int i) {
        this.Xq.setFrom(i);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.Xq.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.Xq.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.Xq.setGameId(i);
    }
}
