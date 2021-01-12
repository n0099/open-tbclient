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
    private int aiY;
    private int aiZ;
    private ThreadCommentAndPraiseInfoLayout aja;
    private com.baidu.tbadk.core.data.a ajb;

    public am(Context context) {
        super(context);
        this.aiY = 11;
        this.aiZ = this.aiY;
        this.aja = new ThreadCardBottomOpSegmentLayout(context);
        this.aja.setReplyTimeVisible(false);
        this.aja.setShowPraiseNum(true);
        this.aja.setNeedAddPraiseIcon(true);
        this.aja.setNeedAddReplyIcon(true);
        this.aja.setShareVisible(true);
        this.aja.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.am.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (am.this.sR() != null) {
                    am.this.sR().a(view, am.this.ajb);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.aja != null) {
            this.aja.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sQ() {
        this.agm.a(4, new a.b() { // from class: com.baidu.card.am.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (c0089a.tu() instanceof Boolean) {
                    if (!((Boolean) c0089a.tu()).booleanValue()) {
                        if ((am.this.aiY & 128) <= 0) {
                            am.this.aiY &= -5;
                            am.this.aiY |= 64;
                        }
                    } else {
                        am.this.aiY = am.this.aiZ;
                    }
                    am.this.aja.setShowFlag(am.this.aiY);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.a
    public void bq(int i) {
        this.aiY |= i;
        this.aja.setShowFlag(this.aiY);
        this.aiZ = this.aiY;
    }

    @Override // com.baidu.card.a
    public void br(int i) {
        this.aiY &= i ^ (-1);
        this.aja.setShowFlag(this.aiY);
        this.aiZ = this.aiY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.aja;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.ajb = aVar;
        this.aja.setData(aVar.bkV());
        tr();
    }

    private void tr() {
        boolean z;
        setMarginsTop(this.aja, 0);
        a tf = this.agm.tf();
        if (tf != null) {
            ViewGroup viewGroup = (ViewGroup) tf.getView();
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
                List<h> th = this.agm.th();
                if (!com.baidu.tbadk.core.util.x.isEmpty(th)) {
                    for (h hVar : th) {
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
        this.aja.onChangeSkinType();
    }

    public void setFromForPb(int i) {
        this.aja.fie = i;
    }

    public void setFrom(int i) {
        this.aja.setFrom(i);
    }

    public void setStType(String str) {
        this.aja.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.aja.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.aja.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.aja.setGameId(i);
    }

    public void setTabName(String str) {
        this.aja.setTabName(str);
    }
}
