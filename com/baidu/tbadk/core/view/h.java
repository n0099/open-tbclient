package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.c {
    protected LinearLayout caB;
    protected ImageView caC;
    private c caD;
    private b caE;
    private d caF;
    private a caG;
    protected AnimationDrawable caH;
    protected ContinuousAnimationView caI;
    private boolean caJ;
    private boolean caK;
    private SmartBubbleAnimatedView caL;
    private f caM;
    private e caN;
    private boolean caO;
    private boolean caP;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void akU();
    }

    /* loaded from: classes.dex */
    public interface b {
        void f(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void er(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void es(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void iZ(int i);

        void onAnimationEnd();
    }

    public h(Context context) {
        super(context);
        this.mHeaderView = null;
        this.caB = null;
        this.caC = null;
        this.caD = null;
        this.caE = null;
        this.caF = null;
        this.caG = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.caJ = false;
        this.caK = false;
        this.caO = true;
        this.caP = true;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nZ() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.caB = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.caI = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        this.caC = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!aja()) {
            this.caH = af.aiS().ic(skinType);
        }
        this.caC.setBackgroundDrawable(this.caH);
        akO();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!aja() && this.caH != null && this.caC != null) {
            this.caH.stop();
            this.caC.setBackgroundDrawable(this.caH.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ar(boolean z) {
        if (this.caF != null) {
            this.caF.es(z);
        }
        akO();
        this.caJ = true;
        if (!aja() && this.caH != null && this.caC != null) {
            this.caH.stop();
            this.caC.setBackgroundDrawable(this.caH.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f2, float f3) {
        super.n(f2, f3);
        if (aja()) {
            this.caI.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        akO();
        if (aja()) {
            this.caI.br();
        } else if (this.caH != null && this.caC != null) {
            this.caH.stop();
            this.caC.setBackgroundDrawable(this.caH);
            this.caC.post(new Runnable() { // from class: com.baidu.tbadk.core.view.h.1
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.caH != null) {
                        h.this.caH.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void as(boolean z) {
        this.caJ = false;
        this.caP = true;
        if (aja()) {
            this.caI.bt();
        } else if (this.caH != null) {
            this.caH.stop();
        }
        akP();
        if (this.caE != null) {
            this.caE.f(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void at(boolean z) {
        if (this.caD != null && this.caP) {
            this.caD.er(z);
        }
        this.caP = true;
    }

    public void akN() {
        this.caP = false;
    }

    public void a(e eVar) {
        this.caN = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oa() {
        if (this.caG != null) {
            this.caG.akU();
        }
        akR();
    }

    public void setListPullRefreshListener(c cVar) {
        this.caD = cVar;
    }

    public void a(b bVar) {
        this.caE = bVar;
    }

    public void a(d dVar) {
        this.caF = dVar;
    }

    public void a(a aVar) {
        this.caG = aVar;
    }

    public void iV(int i) {
        if (aja()) {
            am.h(this.mHeaderView, R.color.cp_bg_line_f, i);
        }
        if (this.caL != null) {
            this.caL.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aja() {
        return af.aiS().aja();
    }

    private void akO() {
        if (this.caL != null && this.caL.getParent() != null) {
            this.caB.removeView(this.caL);
        }
        if (aja()) {
            if (this.caC != null && this.caI != null) {
                if (this.caC.getVisibility() != 8) {
                    this.caC.setVisibility(8);
                }
                if (this.caI.getVisibility() != 0) {
                    this.caI.setVisibility(0);
                }
                if (this.caI.isAnimating()) {
                    this.caI.cancelAnimation();
                }
            }
        } else if (this.caC != null && this.caI != null) {
            if (this.caC.getVisibility() != 0) {
                this.caC.setVisibility(0);
            }
            if (this.caI.getVisibility() != 8) {
                this.caI.setVisibility(8);
            }
        }
    }

    private void akP() {
        if (aja() && this.caH != null) {
            this.caH.stop();
            this.caH = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }

    public boolean akQ() {
        return this.caK;
    }

    public void a(f fVar) {
        this.caM = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.caO = z;
    }

    public void akR() {
        if (akQ() && this.caO && this.caN != null && this.caB != null) {
            this.caC.setVisibility(8);
            this.caI.setVisibility(8);
            if (this.caL == null) {
                this.caL = new SmartBubbleAnimatedView(getContext());
                this.caL.setExtrusionRemind(true);
            }
            this.caL.caR = this.caN.getTipText();
            this.caL.fyc = this.caN.akV();
            if (this.caL.getParent() != null) {
                this.caB.removeView(this.caL);
            }
            this.caB.addView(this.caL);
            this.caL.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.h.2
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void akT() {
                    if (h.this.caM != null) {
                        h.this.caM.onAnimationEnd();
                    }
                }
            });
            if (this.caM != null) {
                this.caM.iZ(this.caL.getTipViewHeight());
            }
            this.caL.bnR();
        }
    }

    public void akS() {
        if (this.caB != null && this.caL != null && this.caL.getParent() != null) {
            this.caB.removeView(this.caL);
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        private String caR;
        private int caS;

        public e(String str, int i) {
            this.caR = str;
            this.caS = i;
        }

        public String getTipText() {
            return this.caR;
        }

        public int akV() {
            return this.caS;
        }
    }
}
