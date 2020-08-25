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
    private int ahk;
    private int ahl;
    private ThreadCommentAndPraiseInfoLayout ahm;
    private AbsThreadDataSupport ahn;
    private a.C0095a aho;
    private Runnable ahp;

    public am(Context context) {
        super(context);
        this.ahk = 11;
        this.ahl = this.ahk;
        this.aho = new a.C0095a(5);
        this.ahp = new Runnable() { // from class: com.baidu.card.am.1
            @Override // java.lang.Runnable
            public void run() {
                am.this.aho.setExtraData(Integer.valueOf(am.this.ahm.getCommentContainer().getRight() + am.this.aeR.tP().aha));
                am.this.aeR.b(am.this.aho);
            }
        };
        this.ahm = new ThreadCardBottomOpSegmentLayout(context);
        this.ahm.setReplyTimeVisible(false);
        this.ahm.setShowPraiseNum(true);
        this.ahm.setNeedAddPraiseIcon(true);
        this.ahm.setNeedAddReplyIcon(true);
        this.ahm.setShareVisible(true);
        this.ahm.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.am.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (am.this.tw() != null) {
                    am.this.tw().a(view, am.this.ahn);
                }
            }
        });
    }

    public void setOnCommentClickCallback(ThreadCommentAndPraiseInfoLayout.a aVar) {
        if (this.ahm != null) {
            this.ahm.setOnCommentClickCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        this.aeR.a(4, new a.b() { // from class: com.baidu.card.am.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (c0095a.tX() instanceof Boolean) {
                    if (((Boolean) c0095a.tX()).booleanValue()) {
                        am.this.ahk = am.this.ahl;
                    } else {
                        am.this.ahk &= -5;
                        am.this.ahk |= 64;
                    }
                    am.this.ahm.setShowFlag(am.this.ahk);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bk(int i) {
        this.ahk |= i;
        this.ahm.setShowFlag(this.ahk);
        this.ahl = this.ahk;
    }

    @Override // com.baidu.card.b
    public void bl(int i) {
        this.ahk &= i ^ (-1);
        this.ahm.setShowFlag(this.ahk);
        this.ahl = this.ahk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.ahn = absThreadDataSupport;
        this.ahm.setData(absThreadDataSupport.bce());
        if ((this.ahk & 4) > 0 || (this.ahk & 64) > 0) {
            this.ahm.post(this.ahp);
        }
        tU();
    }

    private void tU() {
        boolean z;
        setMarginsTop(this.ahm, 0);
        b tK = this.aeR.tK();
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
                List<h> tM = this.aeR.tM();
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
        this.ahm.onChangeSkinType();
    }

    public void setFromForPb(int i) {
        this.ahm.etW = i;
    }

    public void setFrom(int i) {
        this.ahm.setFrom(i);
    }

    public void setStType(String str) {
        this.ahm.setStType(str);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        this.ahm.setAgreeStatisticData(cVar);
    }

    public void setShareReportFrom(int i) {
        this.ahm.setShareReportFrom(i);
    }

    public void setGameId(int i) {
        this.ahm.setGameId(i);
    }

    public void setTabName(String str) {
        this.ahm.setTabName(str);
    }
}
