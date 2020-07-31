package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import java.util.List;
/* loaded from: classes15.dex */
public class al extends b<AbsThreadDataSupport> {
    private int agb;
    private int agc;
    private ThreadCommentAndPraiseInfoLayout agd;
    private AbsThreadDataSupport agf;
    private a.C0096a agg;
    private Runnable agh;

    public al(Context context) {
        super(context);
        this.agb = 11;
        this.agc = this.agb;
        this.agg = new a.C0096a(5);
        this.agh = new Runnable() { // from class: com.baidu.card.al.1
            @Override // java.lang.Runnable
            public void run() {
                al.this.agg.setExtraData(Integer.valueOf(al.this.agd.getCommentContainer().getRight() + al.this.adL.se().afQ));
                al.this.adL.b(al.this.agg);
            }
        };
        this.agd = new ThreadCardBottomOpSegmentLayout(context);
        this.agd.setReplyTimeVisible(false);
        this.agd.setShowPraiseNum(true);
        this.agd.setNeedAddPraiseIcon(true);
        this.agd.setNeedAddReplyIcon(true);
        this.agd.setShareVisible(true);
        this.agd.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.al.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (al.this.rL() != null) {
                    al.this.rL().a(view, al.this.agf);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.agd != null) {
            this.agd.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rK() {
        this.adL.a(4, new a.b() { // from class: com.baidu.card.al.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (c0096a.sm() instanceof Boolean) {
                    if (((Boolean) c0096a.sm()).booleanValue()) {
                        al.this.agb = al.this.agc;
                    } else {
                        al.this.agb &= -5;
                        al.this.agb |= 64;
                    }
                    al.this.agd.setShowFlag(al.this.agb);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bf(int i) {
        this.agb |= i;
        this.agd.setShowFlag(this.agb);
        this.agc = this.agb;
    }

    @Override // com.baidu.card.b
    public void bg(int i) {
        this.agb &= i ^ (-1);
        this.agd.setShowFlag(this.agb);
        this.agc = this.agb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.agf = absThreadDataSupport;
        this.agd.setData(absThreadDataSupport.aTN());
        if ((this.agb & 4) > 0 || (this.agb & 64) > 0) {
            this.agd.post(this.agh);
        }
        sj();
    }

    private void sj() {
        boolean z;
        setMarginsTop(this.agd, 0);
        b rZ = this.adL.rZ();
        if (rZ != null) {
            ViewGroup viewGroup = (ViewGroup) rZ.getView();
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
                List<h> sb = this.adL.sb();
                if (!com.baidu.tbadk.core.util.x.isEmpty(sb)) {
                    for (h hVar : sb) {
                        if (hVar != null && hVar.getView() != null && hVar.getView().getVisibility() == 0) {
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agd.onChangeSkinType();
    }

    public void setFromForPb(int i) {
        this.agd.ekb = i;
    }

    public void setFrom(int i) {
        this.agd.setFrom(i);
    }

    public void setStType(String str) {
        this.agd.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        this.agd.setAgreeStatisticData(cVar);
    }

    public void setShareReportFrom(int i) {
        this.agd.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.agd.setGameId(i);
    }

    public void setTabName(String str) {
        this.agd.setTabName(str);
    }
}
