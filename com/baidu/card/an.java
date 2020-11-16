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
/* loaded from: classes20.dex */
public class an extends b<com.baidu.tbadk.core.data.a> {
    private int aie;
    private int aif;
    private ThreadCommentAndPraiseInfoLayout aig;
    private com.baidu.tbadk.core.data.a aih;

    public an(Context context) {
        super(context);
        this.aie = 11;
        this.aif = this.aie;
        this.aig = new ThreadCardBottomOpSegmentLayout(context);
        this.aig.setReplyTimeVisible(false);
        this.aig.setShowPraiseNum(true);
        this.aig.setNeedAddPraiseIcon(true);
        this.aig.setNeedAddReplyIcon(true);
        this.aig.setShareVisible(true);
        this.aig.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.an.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (an.this.tB() != null) {
                    an.this.tB().a(view, an.this.aih);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.aig != null) {
            this.aig.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        this.afI.a(4, new a.b() { // from class: com.baidu.card.an.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (c0096a.ud() instanceof Boolean) {
                    if (((Boolean) c0096a.ud()).booleanValue()) {
                        an.this.aie = an.this.aif;
                    } else {
                        an.this.aie &= -5;
                        an.this.aie |= 64;
                    }
                    an.this.aig.setShowFlag(an.this.aie);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bo(int i) {
        this.aie |= i;
        this.aig.setShowFlag(this.aie);
        this.aif = this.aie;
    }

    @Override // com.baidu.card.b
    public void bp(int i) {
        this.aie &= i ^ (-1);
        this.aig.setShowFlag(this.aie);
        this.aif = this.aie;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.aih = aVar;
        this.aig.setData(aVar.bjd());
        ua();
    }

    private void ua() {
        boolean z;
        setMarginsTop(this.aig, 0);
        b tP = this.afI.tP();
        if (tP != null) {
            ViewGroup viewGroup = (ViewGroup) tP.getView();
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
                List<i> tR = this.afI.tR();
                if (!com.baidu.tbadk.core.util.y.isEmpty(tR)) {
                    for (i iVar : tR) {
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
        this.aig.onChangeSkinType();
    }

    public void setFromForPb(int i) {
        this.aig.eVJ = i;
    }

    public void setFrom(int i) {
        this.aig.setFrom(i);
    }

    public void setStType(String str) {
        this.aig.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.aig.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.aig.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.aig.setGameId(i);
    }

    public void setTabName(String str) {
        this.aig.setTabName(str);
    }
}
