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
    private int aiM;
    private int aiN;
    private ThreadCommentAndPraiseInfoLayout aiO;
    private com.baidu.tbadk.core.data.a aiP;

    public am(Context context) {
        super(context);
        this.aiM = 11;
        this.aiN = this.aiM;
        this.aiO = new ThreadCardBottomOpSegmentLayout(context);
        this.aiO.setReplyTimeVisible(false);
        this.aiO.setShowPraiseNum(true);
        this.aiO.setNeedAddPraiseIcon(true);
        this.aiO.setNeedAddReplyIcon(true);
        this.aiO.setShareVisible(true);
        this.aiO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.am.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (am.this.sO() != null) {
                    am.this.sO().a(view, am.this.aiP);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.aiO != null) {
            this.aiO.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        this.agd.a(4, new a.b() { // from class: com.baidu.card.am.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (c0089a.tr() instanceof Boolean) {
                    if (!((Boolean) c0089a.tr()).booleanValue()) {
                        if ((am.this.aiM & 128) <= 0) {
                            am.this.aiM &= -5;
                            am.this.aiM |= 64;
                        }
                    } else {
                        am.this.aiM = am.this.aiN;
                    }
                    am.this.aiO.setShowFlag(am.this.aiM);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.a
    public void bq(int i) {
        this.aiM |= i;
        this.aiO.setShowFlag(this.aiM);
        this.aiN = this.aiM;
    }

    @Override // com.baidu.card.a
    public void br(int i) {
        this.aiM &= i ^ (-1);
        this.aiO.setShowFlag(this.aiM);
        this.aiN = this.aiM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.aiO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.aiP = aVar;
        this.aiO.setData(aVar.bln());
        tn();
    }

    private void tn() {
        boolean z;
        setMarginsTop(this.aiO, 0);
        a tc = this.agd.tc();
        if (tc != null) {
            ViewGroup viewGroup = (ViewGroup) tc.getView();
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
                List<h> te = this.agd.te();
                if (!com.baidu.tbadk.core.util.y.isEmpty(te)) {
                    for (h hVar : te) {
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
        this.aiO.onChangeSkinType();
    }

    public void setFromForPb(int i) {
        this.aiO.fkw = i;
    }

    public void setFrom(int i) {
        this.aiO.setFrom(i);
    }

    public void setStType(String str) {
        this.aiO.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.e eVar) {
        this.aiO.setAgreeStatisticData(eVar);
    }

    public void setShareReportFrom(int i) {
        this.aiO.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.aiO.setGameId(i);
    }

    public void setTabName(String str) {
        this.aiO.setTabName(str);
    }
}
