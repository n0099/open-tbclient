package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import java.util.List;
/* loaded from: classes6.dex */
public class ag extends b<com.baidu.tbadk.core.data.a> {
    private int LM;
    private int LN;
    private ThreadCommentAndPraiseInfoLayout LO;
    private com.baidu.tbadk.core.data.a LQ;
    private a.C0050a LR;
    private Runnable LS;

    public ag(Context context) {
        super(context);
        this.LM = 11;
        this.LN = this.LM;
        this.LR = new a.C0050a(5);
        this.LS = new Runnable() { // from class: com.baidu.card.ag.1
            @Override // java.lang.Runnable
            public void run() {
                ag.this.LR.setExtraData(Integer.valueOf(ag.this.LO.getCommentContainer().getRight() + ag.this.JC.mS().Lz));
                ag.this.JC.b(ag.this.LR);
            }
        };
        this.LO = new ThreadCommentAndPraiseInfoLayout(context);
        this.LO.setReplyTimeVisible(false);
        this.LO.setShowPraiseNum(true);
        this.LO.setNeedAddPraiseIcon(true);
        this.LO.setNeedAddReplyIcon(true);
        this.LO.setShareVisible(true);
        this.LO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ag.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ag.this.mE() != null) {
                    ag.this.mE().a(view, ag.this.LQ);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.LO != null) {
            this.LO.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mD() {
        this.JC.a(4, new a.b() { // from class: com.baidu.card.ag.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0050a c0050a) {
                if (c0050a.mZ() instanceof Boolean) {
                    if (((Boolean) c0050a.mZ()).booleanValue()) {
                        ag.this.LM = ag.this.LN;
                    } else {
                        ag.this.LM &= -5;
                        ag.this.LM |= 64;
                    }
                    ag.this.LO.setShowFlag(ag.this.LM);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void aH(int i) {
        this.LM |= i;
        this.LO.setShowFlag(this.LM);
        this.LN = this.LM;
    }

    @Override // com.baidu.card.b
    public void aI(int i) {
        this.LM &= i ^ (-1);
        this.LO.setShowFlag(this.LM);
        this.LN = this.LM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.LO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.LQ = aVar;
        this.LO.setData(aVar.axQ());
        if ((this.LM & 4) > 0) {
            this.LO.post(this.LS);
        }
        mX();
    }

    private void mX() {
        boolean z;
        setMarginsTop(this.LO, 0);
        b mN = this.JC.mN();
        if (mN != null) {
            ViewGroup viewGroup = (ViewGroup) mN.getView();
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    z = true;
                    break;
                } else if (!(viewGroup.getChildAt(i) instanceof TextView) && viewGroup.getChildAt(i).getVisibility() == 0) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                List<h> mP = this.JC.mP();
                if (!com.baidu.tbadk.core.util.v.isEmpty(mP)) {
                    for (h hVar : mP) {
                        if (hVar != null && hVar.getView() != null && hVar.getView().getVisibility() == 0) {
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.LO.onChangeSkinType();
    }

    public void aV(int i) {
        this.LO.ddB = i;
    }

    public void setFrom(int i) {
        this.LO.setFrom(i);
    }

    public void setStType(String str) {
        this.LO.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.LO.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.LO.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.LO.setGameId(i);
    }
}
