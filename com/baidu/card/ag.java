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
    private int afe;
    private int aff;
    private ThreadCommentAndPraiseInfoLayout afg;
    private com.baidu.tbadk.core.data.a afh;
    private a.C0095a afi;
    private Runnable afj;

    public ag(Context context) {
        super(context);
        this.afe = 11;
        this.aff = this.afe;
        this.afi = new a.C0095a(5);
        this.afj = new Runnable() { // from class: com.baidu.card.ag.1
            @Override // java.lang.Runnable
            public void run() {
                ag.this.afi.setExtraData(Integer.valueOf(ag.this.afg.getCommentContainer().getRight() + ag.this.acY.rB().aeU));
                ag.this.acY.b(ag.this.afi);
            }
        };
        this.afg = new ThreadCommentAndPraiseInfoLayout(context);
        this.afg.setReplyTimeVisible(false);
        this.afg.setShowPraiseNum(true);
        this.afg.setNeedAddPraiseIcon(true);
        this.afg.setNeedAddReplyIcon(true);
        this.afg.setShareVisible(true);
        this.afg.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ag.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ag.this.rl() != null) {
                    ag.this.rl().a(view, ag.this.afh);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.afg != null) {
            this.afg.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rk() {
        this.acY.a(4, new a.b() { // from class: com.baidu.card.ag.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (c0095a.rJ() instanceof Boolean) {
                    if (((Boolean) c0095a.rJ()).booleanValue()) {
                        ag.this.afe = ag.this.aff;
                    } else {
                        ag.this.afe &= -5;
                        ag.this.afe |= 64;
                    }
                    ag.this.afg.setShowFlag(ag.this.afe);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void aW(int i) {
        this.afe |= i;
        this.afg.setShowFlag(this.afe);
        this.aff = this.afe;
    }

    @Override // com.baidu.card.b
    public void aX(int i) {
        this.afe &= i ^ (-1);
        this.afg.setShowFlag(this.afe);
        this.aff = this.afe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        this.afh = aVar;
        this.afg.setData(aVar.aIu());
        if ((this.afe & 4) > 0) {
            this.afg.post(this.afj);
        }
        rG();
    }

    private void rG() {
        boolean z;
        setMarginsTop(this.afg, 0);
        b rw = this.acY.rw();
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
                List<h> ry = this.acY.ry();
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
        this.afg.onChangeSkinType();
    }

    public void bl(int i) {
        this.afg.dIg = i;
    }

    public void setFrom(int i) {
        this.afg.setFrom(i);
    }

    public void setStType(String str) {
        this.afg.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.afg.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.afg.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.afg.setGameId(i);
    }

    public void setTabName(String str) {
        this.afg.setTabName(str);
    }
}
