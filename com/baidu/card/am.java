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
/* loaded from: classes.dex */
public class am extends a<com.baidu.tbadk.core.data.a> {
    private int ajP;
    private int ajQ;
    private ThreadCommentAndPraiseInfoLayout ajR;
    private com.baidu.tbadk.core.data.a ajS;

    public am(Context context) {
        super(context);
        this.ajP = 11;
        this.ajQ = this.ajP;
        this.ajR = new ThreadCardBottomOpSegmentLayout(context);
        this.ajR.setReplyTimeVisible(false);
        this.ajR.setShowPraiseNum(true);
        this.ajR.setNeedAddPraiseIcon(true);
        this.ajR.setNeedAddReplyIcon(true);
        this.ajR.setShareVisible(true);
        this.ajR.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.am.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (am.this.tc() != null) {
                    am.this.tc().a(view, am.this.ajS);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.ajR != null) {
            this.ajR.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void tb() {
        this.ahd.a(4, new a.b() { // from class: com.baidu.card.am.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0090a c0090a) {
                if (c0090a.tF() instanceof Boolean) {
                    if (!((Boolean) c0090a.tF()).booleanValue()) {
                        if ((am.this.ajP & 128) <= 0) {
                            am.this.ajP &= -5;
                            am.this.ajP |= 64;
                        }
                    } else {
                        am.this.ajP = am.this.ajQ;
                    }
                    am.this.ajR.setShowFlag(am.this.ajP);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.a
    public void bs(int i) {
        this.ajP |= i;
        this.ajR.setShowFlag(this.ajP);
        this.ajQ = this.ajP;
    }

    @Override // com.baidu.card.a
    public void bt(int i) {
        this.ajP &= i ^ (-1);
        this.ajR.setShowFlag(this.ajP);
        this.ajQ = this.ajP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ajR;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ajS = aVar;
        this.ajR.setData(aVar.boO());
        tC();
    }

    private void tC() {
        boolean z;
        setMarginsTop(this.ajR, 0);
        a tr = this.ahd.tr();
        if (tr != null) {
            ViewGroup viewGroup = (ViewGroup) tr.getView();
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
                List<h> tt = this.ahd.tt();
                if (!com.baidu.tbadk.core.util.x.isEmpty(tt)) {
                    for (h hVar : tt) {
                        if (hVar != null && hVar.getView() != null && hVar.getView().getVisibility() == 0) {
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajR.onChangeSkinType();
    }

    public void setFromForPb(int i) {
        this.ajR.fmP = i;
    }

    public void setFrom(int i) {
        this.ajR.setFrom(i);
    }

    public void setStType(String str) {
        this.ajR.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.ajR.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.ajR.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.ajR.setGameId(i);
    }

    public void setTabName(String str) {
        this.ajR.setTabName(str);
    }
}
