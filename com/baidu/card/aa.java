package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class aa extends b<com.baidu.tbadk.core.data.a> {
    private static final int TBDS6 = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds6);
    private int Za;
    private int Zb;
    private NewThreadCommentAndPraiseInfoLayout Zc;
    private com.baidu.tbadk.core.data.a Zd;
    private a.C0037a Ze;
    private Runnable Zf;

    public aa(Context context) {
        super(context);
        this.Za = 11;
        this.Zb = this.Za;
        this.Ze = new a.C0037a(5);
        this.Zf = new Runnable() { // from class: com.baidu.card.aa.1
            @Override // java.lang.Runnable
            public void run() {
                aa.this.Ze.setExtraData(Integer.valueOf(aa.this.Zc.getCommentContainer().getRight() + aa.this.Xp.rv().YS));
                aa.this.Xp.b(aa.this.Ze);
            }
        };
        this.Zc = new NewThreadCommentAndPraiseInfoLayout(context);
        this.Zc.setReplyTimeVisible(false);
        this.Zc.setShowPraiseNum(true);
        this.Zc.setNeedAddPraiseIcon(true);
        this.Zc.setNeedAddReplyIcon(true);
        this.Zc.setShareVisible(true);
        this.Zc.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.aa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aa.this.rk() != null) {
                    aa.this.rk().a(view, aa.this.Zd);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rj() {
        this.Xp.a(4, new a.b() { // from class: com.baidu.card.aa.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0037a c0037a) {
                if (c0037a.rD() instanceof Boolean) {
                    if (((Boolean) c0037a.rD()).booleanValue()) {
                        aa.this.Za = aa.this.Zb;
                    } else {
                        aa.this.Za &= -5;
                    }
                    aa.this.Zc.setShowFlag(aa.this.Za);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void bu(int i) {
        this.Za |= i;
        this.Zc.setShowFlag(this.Za);
        this.Zb = this.Za;
    }

    @Override // com.baidu.card.b
    public void bv(int i) {
        this.Za &= i ^ (-1);
        this.Zc.setShowFlag(this.Za);
        this.Zb = this.Za;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Zc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Zd = aVar;
        this.Zc.setData(aVar.WR());
        if ((this.Za & 4) > 0) {
            this.Zc.post(this.Zf);
        }
        rB();
    }

    private void rB() {
        boolean z;
        b rq = this.Xp.rq();
        if (rq == null) {
            setMarginsTop(this.Zc, y.YL - TBDS6);
            return;
        }
        boolean z2 = true;
        ViewGroup viewGroup = (ViewGroup) rq.getView();
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (!(viewGroup.getChildAt(i) instanceof TextView) && viewGroup.getChildAt(i).getVisibility() == 0) {
                z2 = false;
                break;
            }
            i++;
        }
        if (z2) {
            List<f> rs = this.Xp.rs();
            if (!com.baidu.tbadk.core.util.v.T(rs)) {
                for (f fVar : rs) {
                    if (fVar != null && fVar.getView() != null && fVar.getView().getVisibility() == 0) {
                        z = false;
                        break;
                    }
                }
            }
        }
        z = z2;
        if (z) {
            setMarginsTop(this.Zc, y.YL - TBDS6);
        } else {
            setMarginsTop(this.Zc, y.YL);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Zc.onChangeSkinType();
    }

    public void bA(int i) {
        this.Zc.bSG = i;
    }

    public void setFrom(int i) {
        this.Zc.setFrom(i);
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.Zc.setAgreeStatisticData(dVar);
    }

    public void setShareReportFrom(int i) {
        this.Zc.setShareReportFrom(i);
    }
}
