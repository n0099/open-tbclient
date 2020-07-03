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
/* loaded from: classes8.dex */
public class al extends b<AbsThreadDataSupport> {
    private int agl;
    private int agm;
    private ThreadCommentAndPraiseInfoLayout agn;
    private AbsThreadDataSupport ago;
    private a.C0098a agp;
    private Runnable agq;

    public al(Context context) {
        super(context);
        this.agl = 11;
        this.agm = this.agl;
        this.agp = new a.C0098a(5);
        this.agq = new Runnable() { // from class: com.baidu.card.al.1
            @Override // java.lang.Runnable
            public void run() {
                al.this.agp.setExtraData(Integer.valueOf(al.this.agn.getCommentContainer().getRight() + al.this.adV.sc().afZ));
                al.this.adV.b(al.this.agp);
            }
        };
        this.agn = new ThreadCardBottomOpSegmentLayout(context);
        this.agn.setReplyTimeVisible(false);
        this.agn.setShowPraiseNum(true);
        this.agn.setNeedAddPraiseIcon(true);
        this.agn.setNeedAddReplyIcon(true);
        this.agn.setShareVisible(true);
        this.agn.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.al.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (al.this.rJ() != null) {
                    al.this.rJ().a(view, al.this.ago);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.agn != null) {
            this.agn.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rI() {
        this.adV.a(4, new a.b() { // from class: com.baidu.card.al.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0098a c0098a) {
                if (c0098a.sk() instanceof Boolean) {
                    if (((Boolean) c0098a.sk()).booleanValue()) {
                        al.this.agl = al.this.agm;
                    } else {
                        al.this.agl &= -5;
                        al.this.agl |= 64;
                    }
                    al.this.agn.setShowFlag(al.this.agl);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bd(int i) {
        this.agl |= i;
        this.agn.setShowFlag(this.agl);
        this.agm = this.agl;
    }

    @Override // com.baidu.card.b
    public void be(int i) {
        this.agl &= i ^ (-1);
        this.agn.setShowFlag(this.agl);
        this.agm = this.agl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.ago = absThreadDataSupport;
        this.agn.setData(absThreadDataSupport.aPS());
        if ((this.agl & 4) > 0 || (this.agl & 64) > 0) {
            this.agn.post(this.agq);
        }
        sh();
    }

    private void sh() {
        boolean z;
        setMarginsTop(this.agn, 0);
        b rX = this.adV.rX();
        if (rX != null) {
            ViewGroup viewGroup = (ViewGroup) rX.getView();
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
                List<h> rZ = this.adV.rZ();
                if (!com.baidu.tbadk.core.util.w.isEmpty(rZ)) {
                    for (h hVar : rZ) {
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
        this.agn.onChangeSkinType();
    }

    public void setFromForPb(int i) {
        this.agn.edR = i;
    }

    public void setFrom(int i) {
        this.agn.setFrom(i);
    }

    public void setStType(String str) {
        this.agn.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        this.agn.setAgreeStatisticData(cVar);
    }

    public void setShareReportFrom(int i) {
        this.agn.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.agn.setGameId(i);
    }

    public void setTabName(String str) {
        this.agn.setTabName(str);
    }
}
