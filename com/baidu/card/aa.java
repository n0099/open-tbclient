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
    private int WU;
    private int WV;
    private NewThreadCommentAndPraiseInfoLayout WW;
    private com.baidu.tbadk.core.data.a WX;
    private a.C0038a WY;
    private Runnable WZ;

    public aa(Context context) {
        super(context);
        this.WU = 11;
        this.WV = this.WU;
        this.WY = new a.C0038a(5);
        this.WZ = new Runnable() { // from class: com.baidu.card.aa.1
            @Override // java.lang.Runnable
            public void run() {
                aa.this.WY.setExtraData(Integer.valueOf(aa.this.WW.getCommentContainer().getRight() + aa.this.Vi.qq().WM));
                aa.this.Vi.b(aa.this.WY);
            }
        };
        this.WW = new NewThreadCommentAndPraiseInfoLayout(context);
        this.WW.setReplyTimeVisible(false);
        this.WW.setShowPraiseNum(true);
        this.WW.setNeedAddPraiseIcon(true);
        this.WW.setNeedAddReplyIcon(true);
        this.WW.setShareVisible(true);
        this.WW.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.aa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aa.this.qf() != null) {
                    aa.this.qf().a(view, aa.this.WX);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void qe() {
        this.Vi.a(4, new a.b() { // from class: com.baidu.card.aa.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0038a c0038a) {
                if (c0038a.qy() instanceof Boolean) {
                    if (((Boolean) c0038a.qy()).booleanValue()) {
                        aa.this.WU = aa.this.WV;
                    } else {
                        aa.this.WU &= -5;
                    }
                    aa.this.WW.setShowFlag(aa.this.WU);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bm(int i) {
        this.WU |= i;
        this.WW.setShowFlag(this.WU);
        this.WV = this.WU;
    }

    @Override // com.baidu.card.b
    public void bn(int i) {
        this.WU &= i ^ (-1);
        this.WW.setShowFlag(this.WU);
        this.WV = this.WU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.WW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.WX = aVar;
        this.WW.setData(aVar.abv());
        if ((this.WU & 4) > 0) {
            this.WW.post(this.WZ);
        }
        qw();
    }

    private void qw() {
        boolean z;
        b ql = this.Vi.ql();
        if (ql == null) {
            setMarginsTop(this.WW, y.WF - TBDS6);
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
            List<f> qn = this.Vi.qn();
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
            setMarginsTop(this.WW, y.WF - TBDS6);
        } else {
            setMarginsTop(this.WW, y.WF);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.WW.onChangeSkinType();
    }

    public void bw(int i) {
        this.WW.caC = i;
    }

    public void setFrom(int i) {
        this.WW.setFrom(i);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.WW.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.WW.setShareReportFrom(i);
    }
}
