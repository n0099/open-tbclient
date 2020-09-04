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
/* loaded from: classes15.dex */
public class am extends b<AbsThreadDataSupport> {
    private int ahm;
    private int ahn;
    private ThreadCommentAndPraiseInfoLayout aho;
    private AbsThreadDataSupport ahp;
    private a.C0095a ahq;
    private Runnable ahr;

    public am(Context context) {
        super(context);
        this.ahm = 11;
        this.ahn = this.ahm;
        this.ahq = new a.C0095a(5);
        this.ahr = new Runnable() { // from class: com.baidu.card.am.1
            @Override // java.lang.Runnable
            public void run() {
                am.this.ahq.setExtraData(Integer.valueOf(am.this.aho.getCommentContainer().getRight() + am.this.aeT.tP().ahc));
                am.this.aeT.b(am.this.ahq);
            }
        };
        this.aho = new ThreadCardBottomOpSegmentLayout(context);
        this.aho.setReplyTimeVisible(false);
        this.aho.setShowPraiseNum(true);
        this.aho.setNeedAddPraiseIcon(true);
        this.aho.setNeedAddReplyIcon(true);
        this.aho.setShareVisible(true);
        this.aho.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.am.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (am.this.tw() != null) {
                    am.this.tw().a(view, am.this.ahp);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.aho != null) {
            this.aho.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        this.aeT.a(4, new a.b() { // from class: com.baidu.card.am.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (c0095a.tX() instanceof Boolean) {
                    if (((Boolean) c0095a.tX()).booleanValue()) {
                        am.this.ahm = am.this.ahn;
                    } else {
                        am.this.ahm &= -5;
                        am.this.ahm |= 64;
                    }
                    am.this.aho.setShowFlag(am.this.ahm);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bk(int i) {
        this.ahm |= i;
        this.aho.setShowFlag(this.ahm);
        this.ahn = this.ahm;
    }

    @Override // com.baidu.card.b
    public void bl(int i) {
        this.ahm &= i ^ (-1);
        this.aho.setShowFlag(this.ahm);
        this.ahn = this.ahm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aho;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.ahp = absThreadDataSupport;
        this.aho.setData(absThreadDataSupport.bce());
        if ((this.ahm & 4) > 0 || (this.ahm & 64) > 0) {
            this.aho.post(this.ahr);
        }
        tU();
    }

    private void tU() {
        boolean z;
        setMarginsTop(this.aho, 0);
        b tK = this.aeT.tK();
        if (tK != null) {
            ViewGroup viewGroup = (ViewGroup) tK.getView();
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
                List<h> tM = this.aeT.tM();
                if (!com.baidu.tbadk.core.util.y.isEmpty(tM)) {
                    for (h hVar : tM) {
                        if (hVar != null && hVar.getView() != null && hVar.getView().getVisibility() == 0) {
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aho.onChangeSkinType();
    }

    public void setFromForPb(int i) {
        this.aho.eua = i;
    }

    public void setFrom(int i) {
        this.aho.setFrom(i);
    }

    public void setStType(String str) {
        this.aho.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        this.aho.setAgreeStatisticData(cVar);
    }

    public void setShareReportFrom(int i) {
        this.aho.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.aho.setGameId(i);
    }

    public void setTabName(String str) {
        this.aho.setTabName(str);
    }
}
