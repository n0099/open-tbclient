package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import java.util.List;
/* loaded from: classes8.dex */
public class ag extends b<com.baidu.tbadk.core.data.a> {
    private int Mm;
    private int Mn;
    private ThreadCommentAndPraiseInfoLayout Mo;
    private com.baidu.tbadk.core.data.a Mp;
    private a.C0052a Mq;
    private Runnable Mr;

    public ag(Context context) {
        super(context);
        this.Mm = 11;
        this.Mn = this.Mm;
        this.Mq = new a.C0052a(5);
        this.Mr = new Runnable() { // from class: com.baidu.card.ag.1
            @Override // java.lang.Runnable
            public void run() {
                ag.this.Mq.setExtraData(Integer.valueOf(ag.this.Mo.getCommentContainer().getRight() + ag.this.JX.ni().Mb));
                ag.this.JX.b(ag.this.Mq);
            }
        };
        this.Mo = new ThreadCommentAndPraiseInfoLayout(context);
        this.Mo.setReplyTimeVisible(false);
        this.Mo.setShowPraiseNum(true);
        this.Mo.setNeedAddPraiseIcon(true);
        this.Mo.setNeedAddReplyIcon(true);
        this.Mo.setShareVisible(true);
        this.Mo.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ag.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ag.this.mT() != null) {
                    ag.this.mT().a(view, ag.this.Mp);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.Mo != null) {
            this.Mo.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mS() {
        this.JX.a(4, new a.b() { // from class: com.baidu.card.ag.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0052a c0052a) {
                if (c0052a.nq() instanceof Boolean) {
                    if (((Boolean) c0052a.nq()).booleanValue()) {
                        ag.this.Mm = ag.this.Mn;
                    } else {
                        ag.this.Mm &= -5;
                        ag.this.Mm |= 64;
                    }
                    ag.this.Mo.setShowFlag(ag.this.Mm);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void aK(int i) {
        this.Mm |= i;
        this.Mo.setShowFlag(this.Mm);
        this.Mn = this.Mm;
    }

    @Override // com.baidu.card.b
    public void aL(int i) {
        this.Mm &= i ^ (-1);
        this.Mo.setShowFlag(this.Mm);
        this.Mn = this.Mm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Mo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Mp = aVar;
        this.Mo.setData(aVar.aAe());
        if ((this.Mm & 4) > 0) {
            this.Mo.post(this.Mr);
        }
        nn();
    }

    private void nn() {
        boolean z;
        setMarginsTop(this.Mo, 0);
        b nd = this.JX.nd();
        if (nd != null) {
            ViewGroup viewGroup = (ViewGroup) nd.getView();
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
                List<h> nf = this.JX.nf();
                if (!com.baidu.tbadk.core.util.v.isEmpty(nf)) {
                    for (h hVar : nf) {
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
        this.Mo.onChangeSkinType();
    }

    public void aZ(int i) {
        this.Mo.dhF = i;
    }

    public void setFrom(int i) {
        this.Mo.setFrom(i);
    }

    public void setStType(String str) {
        this.Mo.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.Mo.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.Mo.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.Mo.setGameId(i);
    }
}
