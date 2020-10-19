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
/* loaded from: classes21.dex */
public class an extends b<AbsThreadDataSupport> {
    private int ahX;
    private int ahY;
    private ThreadCommentAndPraiseInfoLayout ahZ;
    private AbsThreadDataSupport aia;
    private a.C0097a aib;
    private Runnable aic;

    public an(Context context) {
        super(context);
        this.ahX = 11;
        this.ahY = this.ahX;
        this.aib = new a.C0097a(5);
        this.aic = new Runnable() { // from class: com.baidu.card.an.1
            @Override // java.lang.Runnable
            public void run() {
                an.this.aib.setExtraData(Integer.valueOf(an.this.ahZ.getCommentContainer().getRight() + an.this.afC.tU().ahM));
                an.this.afC.b(an.this.aib);
            }
        };
        this.ahZ = new ThreadCardBottomOpSegmentLayout(context);
        this.ahZ.setReplyTimeVisible(false);
        this.ahZ.setShowPraiseNum(true);
        this.ahZ.setNeedAddPraiseIcon(true);
        this.ahZ.setNeedAddReplyIcon(true);
        this.ahZ.setShareVisible(true);
        this.ahZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.an.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (an.this.tB() != null) {
                    an.this.tB().a(view, an.this.aia);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.ahZ != null) {
            this.ahZ.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        this.afC.a(4, new a.b() { // from class: com.baidu.card.an.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (c0097a.ud() instanceof Boolean) {
                    if (((Boolean) c0097a.ud()).booleanValue()) {
                        an.this.ahX = an.this.ahY;
                    } else {
                        an.this.ahX &= -5;
                        an.this.ahX |= 64;
                    }
                    an.this.ahZ.setShowFlag(an.this.ahX);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bo(int i) {
        this.ahX |= i;
        this.ahZ.setShowFlag(this.ahX);
        this.ahY = this.ahX;
    }

    @Override // com.baidu.card.b
    public void bp(int i) {
        this.ahX &= i ^ (-1);
        this.ahZ.setShowFlag(this.ahX);
        this.ahY = this.ahX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.aia = absThreadDataSupport;
        this.ahZ.setData(absThreadDataSupport.bfG());
        if ((this.ahX & 4) > 0 || (this.ahX & 64) > 0) {
            this.ahZ.post(this.aic);
        }
        ua();
    }

    private void ua() {
        boolean z;
        setMarginsTop(this.ahZ, 0);
        b tP = this.afC.tP();
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
                List<i> tR = this.afC.tR();
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
        this.ahZ.onChangeSkinType();
    }

    public void setFromForPb(int i) {
        this.ahZ.eIo = i;
    }

    public void setFrom(int i) {
        this.ahZ.setFrom(i);
    }

    public void setStType(String str) {
        this.ahZ.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        this.ahZ.setAgreeStatisticData(cVar);
    }

    public void setShareReportFrom(int i) {
        this.ahZ.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.ahZ.setGameId(i);
    }

    public void setTabName(String str) {
        this.ahZ.setTabName(str);
    }
}
