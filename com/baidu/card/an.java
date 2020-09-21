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
/* loaded from: classes20.dex */
public class an extends b<AbsThreadDataSupport> {
    private int ahG;
    private int ahH;
    private ThreadCommentAndPraiseInfoLayout ahI;
    private AbsThreadDataSupport ahJ;
    private a.C0096a ahK;
    private Runnable ahL;

    public an(Context context) {
        super(context);
        this.ahG = 11;
        this.ahH = this.ahG;
        this.ahK = new a.C0096a(5);
        this.ahL = new Runnable() { // from class: com.baidu.card.an.1
            @Override // java.lang.Runnable
            public void run() {
                an.this.ahK.setExtraData(Integer.valueOf(an.this.ahI.getCommentContainer().getRight() + an.this.afl.tU().ahv));
                an.this.afl.b(an.this.ahK);
            }
        };
        this.ahI = new ThreadCardBottomOpSegmentLayout(context);
        this.ahI.setReplyTimeVisible(false);
        this.ahI.setShowPraiseNum(true);
        this.ahI.setNeedAddPraiseIcon(true);
        this.ahI.setNeedAddReplyIcon(true);
        this.ahI.setShareVisible(true);
        this.ahI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.an.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (an.this.tB() != null) {
                    an.this.tB().a(view, an.this.ahJ);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.ahI != null) {
            this.ahI.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        this.afl.a(4, new a.b() { // from class: com.baidu.card.an.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (c0096a.ud() instanceof Boolean) {
                    if (((Boolean) c0096a.ud()).booleanValue()) {
                        an.this.ahG = an.this.ahH;
                    } else {
                        an.this.ahG &= -5;
                        an.this.ahG |= 64;
                    }
                    an.this.ahI.setShowFlag(an.this.ahG);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bo(int i) {
        this.ahG |= i;
        this.ahI.setShowFlag(this.ahG);
        this.ahH = this.ahG;
    }

    @Override // com.baidu.card.b
    public void bp(int i) {
        this.ahG &= i ^ (-1);
        this.ahI.setShowFlag(this.ahG);
        this.ahH = this.ahG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.ahJ = absThreadDataSupport;
        this.ahI.setData(absThreadDataSupport.bcY());
        if ((this.ahG & 4) > 0 || (this.ahG & 64) > 0) {
            this.ahI.post(this.ahL);
        }
        ua();
    }

    private void ua() {
        boolean z;
        setMarginsTop(this.ahI, 0);
        b tP = this.afl.tP();
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
                List<i> tR = this.afl.tR();
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
        this.ahI.onChangeSkinType();
    }

    public void setFromForPb(int i) {
        this.ahI.ewe = i;
    }

    public void setFrom(int i) {
        this.ahI.setFrom(i);
    }

    public void setStType(String str) {
        this.ahI.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        this.ahI.setAgreeStatisticData(cVar);
    }

    public void setShareReportFrom(int i) {
        this.ahI.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.ahI.setGameId(i);
    }

    public void setTabName(String str) {
        this.ahI.setTabName(str);
    }
}
