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
    private static final int Hh = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
    private int Hf;
    private int Hg;
    private NewThreadCommentAndPraiseInfoLayout Hi;
    private com.baidu.tbadk.core.data.a Hj;
    private a.C0044a Hk;
    private Runnable Hl;

    public aa(Context context) {
        super(context);
        this.Hf = 11;
        this.Hg = this.Hf;
        this.Hk = new a.C0044a(5);
        this.Hl = new Runnable() { // from class: com.baidu.card.aa.1
            @Override // java.lang.Runnable
            public void run() {
                aa.this.Hk.setExtraData(Integer.valueOf(aa.this.Hi.getCommentContainer().getRight() + aa.this.Fp.lT().GX));
                aa.this.Fp.b(aa.this.Hk);
            }
        };
        this.Hi = new NewThreadCommentAndPraiseInfoLayout(context);
        this.Hi.setReplyTimeVisible(false);
        this.Hi.setShowPraiseNum(true);
        this.Hi.setNeedAddPraiseIcon(true);
        this.Hi.setNeedAddReplyIcon(true);
        this.Hi.setShareVisible(true);
        this.Hi.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.aa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aa.this.lH() != null) {
                    aa.this.lH().a(view, aa.this.Hj);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void lG() {
        this.Fp.a(4, new a.b() { // from class: com.baidu.card.aa.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0044a c0044a) {
                if (c0044a.mb() instanceof Boolean) {
                    if (((Boolean) c0044a.mb()).booleanValue()) {
                        aa.this.Hf = aa.this.Hg;
                    } else {
                        aa.this.Hf &= -5;
                    }
                    aa.this.Hi.setShowFlag(aa.this.Hf);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void aB(int i) {
        this.Hf |= i;
        this.Hi.setShowFlag(this.Hf);
        this.Hg = this.Hf;
    }

    @Override // com.baidu.card.b
    public void aC(int i) {
        this.Hf &= i ^ (-1);
        this.Hi.setShowFlag(this.Hf);
        this.Hg = this.Hf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Hi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.Hj = aVar;
        this.Hi.setData(aVar.agI());
        if ((this.Hf & 4) > 0) {
            this.Hi.post(this.Hl);
        }
        lZ();
    }

    private void lZ() {
        boolean z;
        b lO = this.Fp.lO();
        if (lO == null) {
            setMarginsTop(this.Hi, y.GO - Hh);
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
            List<f> lQ = this.Fp.lQ();
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
            setMarginsTop(this.Hi, y.GO - Hh);
        } else {
            setMarginsTop(this.Hi, y.GO);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Hi.onChangeSkinType();
    }

    public void aL(int i) {
        this.Hi.cqT = i;
    }

    public void setFrom(int i) {
        this.Hi.setFrom(i);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.Hi.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.Hi.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.Hi.setGameId(i);
    }
}
