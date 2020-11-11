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
    private int ahY;
    private int ahZ;
    private ThreadCommentAndPraiseInfoLayout aia;
    private AbsThreadDataSupport aib;
    private a.C0097a aic;
    private Runnable aie;

    public an(Context context) {
        super(context);
        this.ahY = 11;
        this.ahZ = this.ahY;
        this.aic = new a.C0097a(5);
        this.aie = new Runnable() { // from class: com.baidu.card.an.1
            @Override // java.lang.Runnable
            public void run() {
                an.this.aic.setExtraData(Integer.valueOf(an.this.aia.getCommentContainer().getRight() + an.this.afD.tU().ahN));
                an.this.afD.b(an.this.aic);
            }
        };
        this.aia = new ThreadCardBottomOpSegmentLayout(context);
        this.aia.setReplyTimeVisible(false);
        this.aia.setShowPraiseNum(true);
        this.aia.setNeedAddPraiseIcon(true);
        this.aia.setNeedAddReplyIcon(true);
        this.aia.setShareVisible(true);
        this.aia.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.an.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (an.this.tB() != null) {
                    an.this.tB().a(view, an.this.aib);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.aia != null) {
            this.aia.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        this.afD.a(4, new a.b() { // from class: com.baidu.card.an.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (c0097a.ud() instanceof Boolean) {
                    if (((Boolean) c0097a.ud()).booleanValue()) {
                        an.this.ahY = an.this.ahZ;
                    } else {
                        an.this.ahY &= -5;
                        an.this.ahY |= 64;
                    }
                    an.this.aia.setShowFlag(an.this.ahY);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bo(int i) {
        this.ahY |= i;
        this.aia.setShowFlag(this.ahY);
        this.ahZ = this.ahY;
    }

    @Override // com.baidu.card.b
    public void bp(int i) {
        this.ahY &= i ^ (-1);
        this.aia.setShowFlag(this.ahY);
        this.ahZ = this.ahY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aia;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.aib = absThreadDataSupport;
        this.aia.setData(absThreadDataSupport.bjZ());
        if ((this.ahY & 4) > 0 || (this.ahY & 64) > 0) {
            this.aia.post(this.aie);
        }
        ua();
    }

    private void ua() {
        boolean z;
        setMarginsTop(this.aia, 0);
        b tP = this.afD.tP();
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
                List<i> tR = this.afD.tR();
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
        this.aia.onChangeSkinType();
    }

    public void setFromForPb(int i) {
        this.aia.eWz = i;
    }

    public void setFrom(int i) {
        this.aia.setFrom(i);
    }

    public void setStType(String str) {
        this.aia.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        this.aia.setAgreeStatisticData(cVar);
    }

    public void setShareReportFrom(int i) {
        this.aia.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.aia.setGameId(i);
    }

    public void setTabName(String str) {
        this.aia.setTabName(str);
    }
}
