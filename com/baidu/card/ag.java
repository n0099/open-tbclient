package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class ag extends b<com.baidu.tbadk.core.data.a> {
    private int LE;
    private int LH;
    private ThreadCommentAndPraiseInfoLayout LI;
    private com.baidu.tbadk.core.data.a LJ;
    private a.C0050a LK;
    private Runnable LM;

    public ag(Context context) {
        super(context);
        this.LE = 11;
        this.LH = this.LE;
        this.LK = new a.C0050a(5);
        this.LM = new Runnable() { // from class: com.baidu.card.ag.1
            @Override // java.lang.Runnable
            public void run() {
                ag.this.LK.setExtraData(Integer.valueOf(ag.this.LI.getCommentContainer().getRight() + ag.this.Jw.mR().Lu));
                ag.this.Jw.b(ag.this.LK);
            }
        };
        this.LI = new ThreadCommentAndPraiseInfoLayout(context);
        this.LI.setReplyTimeVisible(false);
        this.LI.setShowPraiseNum(true);
        this.LI.setNeedAddPraiseIcon(true);
        this.LI.setNeedAddReplyIcon(true);
        this.LI.setShareVisible(true);
        this.LI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ag.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ag.this.mE() != null) {
                    ag.this.mE().a(view, ag.this.LJ);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.LI != null) {
            this.LI.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mD() {
        this.Jw.a(4, new a.b() { // from class: com.baidu.card.ag.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0050a c0050a) {
                if (c0050a.mY() instanceof Boolean) {
                    if (((Boolean) c0050a.mY()).booleanValue()) {
                        ag.this.LE = ag.this.LH;
                    } else {
                        ag.this.LE &= -5;
                        ag.this.LE |= 64;
                    }
                    ag.this.LI.setShowFlag(ag.this.LE);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void aH(int i) {
        this.LE |= i;
        this.LI.setShowFlag(this.LE);
        this.LH = this.LE;
    }

    @Override // com.baidu.card.b
    public void aI(int i) {
        this.LE &= i ^ (-1);
        this.LI.setShowFlag(this.LE);
        this.LH = this.LE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.LI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.LJ = aVar;
        this.LI.setData(aVar.axx());
        if ((this.LE & 4) > 0) {
            this.LI.post(this.LM);
        }
        mW();
    }

    private void mW() {
        boolean z;
        setMarginsTop(this.LI, 0);
        b mM = this.Jw.mM();
        if (mM != null) {
            ViewGroup viewGroup = (ViewGroup) mM.getView();
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
                List<h> mO = this.Jw.mO();
                if (!com.baidu.tbadk.core.util.v.isEmpty(mO)) {
                    for (h hVar : mO) {
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
        this.LI.onChangeSkinType();
    }

    public void aV(int i) {
        this.LI.ddq = i;
    }

    public void setFrom(int i) {
        this.LI.setFrom(i);
    }

    public void setStType(String str) {
        this.LI.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.LI.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.LI.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.LI.setGameId(i);
    }
}
