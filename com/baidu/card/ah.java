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
public class ah extends b<AbsThreadDataSupport> {
    private int afB;
    private int afC;
    private ThreadCommentAndPraiseInfoLayout afD;
    private AbsThreadDataSupport afE;
    private a.C0097a afF;
    private Runnable afG;

    public ah(Context context) {
        super(context);
        this.afB = 11;
        this.afC = this.afB;
        this.afF = new a.C0097a(5);
        this.afG = new Runnable() { // from class: com.baidu.card.ah.1
            @Override // java.lang.Runnable
            public void run() {
                ah.this.afF.setExtraData(Integer.valueOf(ah.this.afD.getCommentContainer().getRight() + ah.this.adr.rK().afq));
                ah.this.adr.b(ah.this.afF);
            }
        };
        this.afD = new ThreadCardBottomOpSegmentLayout(context);
        this.afD.setReplyTimeVisible(false);
        this.afD.setShowPraiseNum(true);
        this.afD.setNeedAddPraiseIcon(true);
        this.afD.setNeedAddReplyIcon(true);
        this.afD.setShareVisible(true);
        this.afD.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.ah.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ah.this.rs() != null) {
                    ah.this.rs().a(view, ah.this.afE);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.afD != null) {
            this.afD.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rr() {
        this.adr.a(4, new a.b() { // from class: com.baidu.card.ah.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (c0097a.rS() instanceof Boolean) {
                    if (((Boolean) c0097a.rS()).booleanValue()) {
                        ah.this.afB = ah.this.afC;
                    } else {
                        ah.this.afB &= -5;
                        ah.this.afB |= 64;
                    }
                    ah.this.afD.setShowFlag(ah.this.afB);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void aX(int i) {
        this.afB |= i;
        this.afD.setShowFlag(this.afB);
        this.afC = this.afB;
    }

    @Override // com.baidu.card.b
    public void aY(int i) {
        this.afB &= i ^ (-1);
        this.afD.setShowFlag(this.afB);
        this.afC = this.afB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.afE = absThreadDataSupport;
        this.afD.setData(absThreadDataSupport.aOi());
        if ((this.afB & 4) > 0 || (this.afB & 64) > 0) {
            this.afD.post(this.afG);
        }
        rP();
    }

    private void rP() {
        boolean z;
        setMarginsTop(this.afD, 0);
        b rF = this.adr.rF();
        if (rF != null) {
            ViewGroup viewGroup = (ViewGroup) rF.getView();
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
                List<h> rH = this.adr.rH();
                if (!com.baidu.tbadk.core.util.v.isEmpty(rH)) {
                    for (h hVar : rH) {
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
        this.afD.onChangeSkinType();
    }

    public void bm(int i) {
        this.afD.dWv = i;
    }

    public void setFrom(int i) {
        this.afD.setFrom(i);
    }

    public void setStType(String str) {
        this.afD.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        this.afD.setAgreeStatisticData(cVar);
    }

    public void setShareReportFrom(int i) {
        this.afD.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.afD.setGameId(i);
    }

    public void setTabName(String str) {
        this.afD.setTabName(str);
    }
}
