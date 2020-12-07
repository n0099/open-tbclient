package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import java.util.List;
/* loaded from: classes21.dex */
public class an extends b<com.baidu.tbadk.core.data.a> {
    private int ajd;
    private int aje;
    private ThreadCommentAndPraiseInfoLayout ajf;
    private com.baidu.tbadk.core.data.a ajg;

    public an(Context context) {
        super(context);
        this.ajd = 11;
        this.aje = this.ajd;
        this.ajf = new ThreadCardBottomOpSegmentLayout(context);
        this.ajf.setReplyTimeVisible(false);
        this.ajf.setShowPraiseNum(true);
        this.ajf.setNeedAddPraiseIcon(true);
        this.ajf.setNeedAddReplyIcon(true);
        this.ajf.setShareVisible(true);
        this.ajf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.an.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (an.this.tE() != null) {
                    an.this.tE().a(view, an.this.ajg);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.ajf != null) {
            this.ajf.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tD() {
        this.agE.a(4, new a.b() { // from class: com.baidu.card.an.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (c0097a.ug() instanceof Boolean) {
                    if (((Boolean) c0097a.ug()).booleanValue()) {
                        an.this.ajd = an.this.aje;
                    } else {
                        an.this.ajd &= -5;
                        an.this.ajd |= 64;
                    }
                    an.this.ajf.setShowFlag(an.this.ajd);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bs(int i) {
        this.ajd |= i;
        this.ajf.setShowFlag(this.ajd);
        this.aje = this.ajd;
    }

    @Override // com.baidu.card.b
    public void bt(int i) {
        this.ajd &= i ^ (-1);
        this.ajf.setShowFlag(this.ajd);
        this.aje = this.ajd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ajf;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.ajg = aVar;
        this.ajf.setData(aVar.bmn());
        ud();
    }

    private void ud() {
        boolean z;
        setMarginsTop(this.ajf, 0);
        b tS = this.agE.tS();
        if (tS != null) {
            ViewGroup viewGroup = (ViewGroup) tS.getView();
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
                List<i> tU = this.agE.tU();
                if (!com.baidu.tbadk.core.util.y.isEmpty(tU)) {
                    for (i iVar : tU) {
                        if (iVar != null && iVar.getView() != null && iVar.getView().getVisibility() == 0) {
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajf.onChangeSkinType();
    }

    public void setFromForPb(int i) {
        this.ajf.fdg = i;
    }

    public void setFrom(int i) {
        this.ajf.setFrom(i);
    }

    public void setStType(String str) {
        this.ajf.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.ajf.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.ajf.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.ajf.setGameId(i);
    }

    public void setTabName(String str) {
        this.ajf.setTabName(str);
    }
}
