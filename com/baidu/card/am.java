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
    private int ake;
    private int akf;
    private ThreadCommentAndPraiseInfoLayout akg;
    private com.baidu.tbadk.core.data.a akh;

    public am(Context context) {
        super(context);
        this.ake = 11;
        this.akf = this.ake;
        this.akg = new ThreadCardBottomOpSegmentLayout(context);
        this.akg.setReplyTimeVisible(false);
        this.akg.setShowPraiseNum(true);
        this.akg.setNeedAddPraiseIcon(true);
        this.akg.setNeedAddReplyIcon(true);
        this.akg.setShareVisible(true);
        this.akg.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.am.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (am.this.sO() != null) {
                    am.this.sO().a(view, am.this.akh);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.akg != null) {
            this.akg.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        this.ahw.a(4, new a.b() { // from class: com.baidu.card.am.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (c0095a.tr() instanceof Boolean) {
                    if (!((Boolean) c0095a.tr()).booleanValue()) {
                        if ((am.this.ake & 128) <= 0) {
                            am.this.ake &= -5;
                            am.this.ake |= 64;
                        }
                    } else {
                        am.this.ake = am.this.akf;
                    }
                    am.this.akg.setShowFlag(am.this.ake);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.a
    public void br(int i) {
        this.ake |= i;
        this.akg.setShowFlag(this.ake);
        this.akf = this.ake;
    }

    @Override // com.baidu.card.a
    public void bs(int i) {
        this.ake &= i ^ (-1);
        this.akg.setShowFlag(this.ake);
        this.akf = this.ake;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.akg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        this.akh = aVar;
        this.akg.setData(aVar.blp());
        tn();
    }

    private void tn() {
        boolean z;
        setMarginsTop(this.akg, 0);
        a tc = this.ahw.tc();
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
                List<h> te = this.ahw.te();
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
        this.akg.onChangeSkinType();
    }

    public void setFromForPb(int i) {
        this.akg.flV = i;
    }

    public void setFrom(int i) {
        this.akg.setFrom(i);
    }

    public void setStType(String str) {
        this.akg.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.e eVar) {
        this.akg.setAgreeStatisticData(eVar);
    }

    public void setShareReportFrom(int i) {
        this.akg.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.akg.setGameId(i);
    }

    public void setTabName(String str) {
        this.akg.setTabName(str);
    }
}
