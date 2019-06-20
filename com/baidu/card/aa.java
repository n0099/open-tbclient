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
    private int WT;
    private int WU;
    private NewThreadCommentAndPraiseInfoLayout WV;
    private com.baidu.tbadk.core.data.a WW;
    private a.C0038a WX;
    private Runnable WY;

    public aa(Context context) {
        super(context);
        this.WT = 11;
        this.WU = this.WT;
        this.WX = new a.C0038a(5);
        this.WY = new Runnable() { // from class: com.baidu.card.aa.1
            @Override // java.lang.Runnable
            public void run() {
                aa.this.WX.setExtraData(Integer.valueOf(aa.this.WV.getCommentContainer().getRight() + aa.this.Vh.qq().WL));
                aa.this.Vh.b(aa.this.WX);
            }
        };
        this.WV = new NewThreadCommentAndPraiseInfoLayout(context);
        this.WV.setReplyTimeVisible(false);
        this.WV.setShowPraiseNum(true);
        this.WV.setNeedAddPraiseIcon(true);
        this.WV.setNeedAddReplyIcon(true);
        this.WV.setShareVisible(true);
        this.WV.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.aa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aa.this.qf() != null) {
                    aa.this.qf().a(view, aa.this.WW);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void qe() {
        this.Vh.a(4, new a.b() { // from class: com.baidu.card.aa.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0038a c0038a) {
                if (c0038a.qy() instanceof Boolean) {
                    if (((Boolean) c0038a.qy()).booleanValue()) {
                        aa.this.WT = aa.this.WU;
                    } else {
                        aa.this.WT &= -5;
                    }
                    aa.this.WV.setShowFlag(aa.this.WT);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bm(int i) {
        this.WT |= i;
        this.WV.setShowFlag(this.WT);
        this.WU = this.WT;
    }

    @Override // com.baidu.card.b
    public void bn(int i) {
        this.WT &= i ^ (-1);
        this.WV.setShowFlag(this.WT);
        this.WU = this.WT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.WV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.WW = aVar;
        this.WV.setData(aVar.abv());
        if ((this.WT & 4) > 0) {
            this.WV.post(this.WY);
        }
        qw();
    }

    private void qw() {
        boolean z;
        b ql = this.Vh.ql();
        if (ql == null) {
            setMarginsTop(this.WV, y.WE - TBDS6);
            return;
        }
        boolean z2 = true;
        ViewGroup viewGroup = (ViewGroup) ql.getView();
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
            List<f> qn = this.Vh.qn();
            if (!com.baidu.tbadk.core.util.v.aa(qn)) {
                for (f fVar : qn) {
                    if (fVar != null && fVar.getView() != null && fVar.getView().getVisibility() == 0) {
                        z = false;
                        break;
                    }
                }
            }
        }
        z = z2;
        if (z) {
            setMarginsTop(this.WV, y.WE - TBDS6);
        } else {
            setMarginsTop(this.WV, y.WE);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.WV.onChangeSkinType();
    }

    public void bw(int i) {
        this.WV.caD = i;
    }

    public void setFrom(int i) {
        this.WV.setFrom(i);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.WV.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.WV.setShareReportFrom(i);
    }
}
