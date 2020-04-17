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
    private int afb;
    private int afc;
    private ThreadCommentAndPraiseInfoLayout afd;
    private com.baidu.tbadk.core.data.a afe;
    private a.C0074a aff;
    private Runnable afg;

    public ag(Context context) {
        super(context);
        this.afb = 11;
        this.afc = this.afb;
        this.aff = new a.C0074a(5);
        this.afg = new Runnable() { // from class: com.baidu.card.ag.1
            @Override // java.lang.Runnable
            public void run() {
                ag.this.aff.setExtraData(Integer.valueOf(ag.this.afd.getCommentContainer().getRight() + ag.this.acV.rB().aeR));
                ag.this.acV.b(ag.this.aff);
            }
        };
        this.afd = new ThreadCommentAndPraiseInfoLayout(context);
        this.afd.setReplyTimeVisible(false);
        this.afd.setShowPraiseNum(true);
        this.afd.setNeedAddPraiseIcon(true);
        this.afd.setNeedAddReplyIcon(true);
        this.afd.setShareVisible(true);
        this.afd.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ag.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ag.this.rl() != null) {
                    ag.this.rl().a(view, ag.this.afe);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.afd != null) {
            this.afd.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rk() {
        this.acV.a(4, new a.b() { // from class: com.baidu.card.ag.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0074a c0074a) {
                if (c0074a.rJ() instanceof Boolean) {
                    if (((Boolean) c0074a.rJ()).booleanValue()) {
                        ag.this.afb = ag.this.afc;
                    } else {
                        ag.this.afb &= -5;
                        ag.this.afb |= 64;
                    }
                    ag.this.afd.setShowFlag(ag.this.afb);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void aW(int i) {
        this.afb |= i;
        this.afd.setShowFlag(this.afb);
        this.afc = this.afb;
    }

    @Override // com.baidu.card.b
    public void aX(int i) {
        this.afb &= i ^ (-1);
        this.afd.setShowFlag(this.afb);
        this.afc = this.afb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.afe = aVar;
        this.afd.setData(aVar.aIw());
        if ((this.afb & 4) > 0) {
            this.afd.post(this.afg);
        }
        rG();
    }

    private void rG() {
        boolean z;
        setMarginsTop(this.afd, 0);
        b rw = this.acV.rw();
        if (rw != null) {
            ViewGroup viewGroup = (ViewGroup) rw.getView();
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
                List<h> ry = this.acV.ry();
                if (!com.baidu.tbadk.core.util.v.isEmpty(ry)) {
                    for (h hVar : ry) {
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
        this.afd.onChangeSkinType();
    }

    public void bl(int i) {
        this.afd.dIc = i;
    }

    public void setFrom(int i) {
        this.afd.setFrom(i);
    }

    public void setStType(String str) {
        this.afd.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.afd.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.afd.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.afd.setGameId(i);
    }

    public void setTabName(String str) {
        this.afd.setTabName(str);
    }
}
