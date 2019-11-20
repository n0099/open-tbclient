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
    private static final int GF = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
    private int GD;
    private int GE;
    private NewThreadCommentAndPraiseInfoLayout GG;
    private com.baidu.tbadk.core.data.a GH;
    private a.C0044a GI;
    private Runnable GJ;

    public aa(Context context) {
        super(context);
        this.GD = 11;
        this.GE = this.GD;
        this.GI = new a.C0044a(5);
        this.GJ = new Runnable() { // from class: com.baidu.card.aa.1
            @Override // java.lang.Runnable
            public void run() {
                aa.this.GI.setExtraData(Integer.valueOf(aa.this.GG.getCommentContainer().getRight() + aa.this.EO.lT().Gv));
                aa.this.EO.b(aa.this.GI);
            }
        };
        this.GG = new NewThreadCommentAndPraiseInfoLayout(context);
        this.GG.setReplyTimeVisible(false);
        this.GG.setShowPraiseNum(true);
        this.GG.setNeedAddPraiseIcon(true);
        this.GG.setNeedAddReplyIcon(true);
        this.GG.setShareVisible(true);
        this.GG.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.aa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aa.this.lH() != null) {
                    aa.this.lH().a(view, aa.this.GH);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void lG() {
        this.EO.a(4, new a.b() { // from class: com.baidu.card.aa.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0044a c0044a) {
                if (c0044a.mb() instanceof Boolean) {
                    if (((Boolean) c0044a.mb()).booleanValue()) {
                        aa.this.GD = aa.this.GE;
                    } else {
                        aa.this.GD &= -5;
                    }
                    aa.this.GG.setShowFlag(aa.this.GD);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void aB(int i) {
        this.GD |= i;
        this.GG.setShowFlag(this.GD);
        this.GE = this.GD;
    }

    @Override // com.baidu.card.b
    public void aC(int i) {
        this.GD &= i ^ (-1);
        this.GG.setShowFlag(this.GD);
        this.GE = this.GD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.GG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.GH = aVar;
        this.GG.setData(aVar.agG());
        if ((this.GD & 4) > 0) {
            this.GG.post(this.GJ);
        }
        lZ();
    }

    private void lZ() {
        boolean z;
        b lO = this.EO.lO();
        if (lO == null) {
            setMarginsTop(this.GG, y.Go - GF);
            return;
        }
        boolean z2 = true;
        ViewGroup viewGroup = (ViewGroup) lO.getView();
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
            List<f> lQ = this.EO.lQ();
            if (!com.baidu.tbadk.core.util.v.isEmpty(lQ)) {
                for (f fVar : lQ) {
                    if (fVar != null && fVar.getView() != null && fVar.getView().getVisibility() == 0) {
                        z = false;
                        break;
                    }
                }
            }
        }
        z = z2;
        if (z) {
            setMarginsTop(this.GG, y.Go - GF);
        } else {
            setMarginsTop(this.GG, y.Go);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.GG.onChangeSkinType();
    }

    public void aL(int i) {
        this.GG.cqc = i;
    }

    public void setFrom(int i) {
        this.GG.setFrom(i);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.GG.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.GG.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.GG.setGameId(i);
    }
}
