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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.c {
    protected LinearLayout bRD;
    protected ImageView bRE;
    private c bRF;
    private b bRG;
    private d bRH;
    private a bRI;
    protected AnimationDrawable bRJ;
    protected ContinuousAnimationView bRK;
    private boolean bRL;
    private boolean bRM;
    private SmartBubbleAnimatedView bRN;
    private f bRO;
    private e bRP;
    private boolean bRQ;
    private boolean bRR;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void aeT();
    }

    /* loaded from: classes.dex */
    public interface b {
        void f(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void dR(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void dS(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void ig(int i);

        void onAnimationEnd();
    }

    public h(Context context) {
        super(context);
        this.mHeaderView = null;
        this.bRD = null;
        this.bRE = null;
        this.bRF = null;
        this.bRG = null;
        this.bRH = null;
        this.bRI = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.bRL = false;
        this.bRM = false;
        this.bRQ = true;
        this.bRR = true;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oM() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.bRD = (LinearLayout) this.mHeaderView.findViewById(d.g.pull_root);
        this.bRK = (ContinuousAnimationView) this.mHeaderView.findViewById(d.g.continuous_loading_view);
        this.bRE = (ImageView) this.mHeaderView.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!add()) {
            this.bRJ = af.acV().hj(skinType);
        }
        this.bRE.setBackgroundDrawable(this.bRJ);
        aeN();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!add() && this.bRJ != null && this.bRE != null) {
            this.bRJ.stop();
            this.bRE.setBackgroundDrawable(this.bRJ.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        if (this.bRH != null) {
            this.bRH.dS(z);
        }
        aeN();
        this.bRL = true;
        if (!add() && this.bRJ != null && this.bRE != null) {
            this.bRJ.stop();
            this.bRE.setBackgroundDrawable(this.bRJ.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f2, float f3) {
        super.n(f2, f3);
        if (add()) {
            this.bRK.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        aeN();
        if (add()) {
            this.bRK.cu();
        } else if (this.bRJ != null && this.bRE != null) {
            this.bRJ.stop();
            this.bRE.setBackgroundDrawable(this.bRJ);
            this.bRE.post(new Runnable() { // from class: com.baidu.tbadk.core.view.h.1
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.bRJ != null) {
                        h.this.bRJ.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        this.bRL = false;
        if (add()) {
            this.bRK.cw();
        } else if (this.bRJ != null) {
            this.bRJ.stop();
        }
        aeO();
        if (this.bRG != null) {
            this.bRG.f(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ay(boolean z) {
        if (this.bRF != null && this.bRR) {
            this.bRF.dR(z);
        }
        this.bRR = true;
    }

    public void aeM() {
        this.bRR = false;
    }

    public void a(e eVar) {
        this.bRP = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oN() {
        if (this.bRI != null) {
            this.bRI.aeT();
        }
        aeQ();
    }

    public void setListPullRefreshListener(c cVar) {
        this.bRF = cVar;
    }

    public void a(b bVar) {
        this.bRG = bVar;
    }

    public void a(d dVar) {
        this.bRH = dVar;
    }

    public void a(a aVar) {
        this.bRI = aVar;
    }

    public void ic(int i) {
        if (add()) {
            al.f(this.mHeaderView, d.C0236d.cp_bg_line_f, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean add() {
        return af.acV().add();
    }

    private void aeN() {
        if (this.bRN != null && this.bRN.getParent() != null) {
            this.bRD.removeView(this.bRN);
        }
        if (add()) {
            if (this.bRE != null && this.bRK != null) {
                if (this.bRE.getVisibility() != 8) {
                    this.bRE.setVisibility(8);
                }
                if (this.bRK.getVisibility() != 0) {
                    this.bRK.setVisibility(0);
                }
                if (this.bRK.isAnimating()) {
                    this.bRK.cancelAnimation();
                }
            }
        } else if (this.bRE != null && this.bRK != null) {
            if (this.bRE.getVisibility() != 0) {
                this.bRE.setVisibility(0);
            }
            if (this.bRK.getVisibility() != 8) {
                this.bRK.setVisibility(8);
            }
        }
    }

    private void aeO() {
        if (add() && this.bRJ != null) {
            this.bRJ.stop();
            this.bRJ = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }

    public boolean aeP() {
        return this.bRM;
    }

    public void a(f fVar) {
        this.bRO = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.bRQ = z;
    }

    public void aeQ() {
        if (aeP() && this.bRQ && this.bRP != null && this.bRD != null) {
            this.bRE.setVisibility(8);
            this.bRK.setVisibility(8);
            if (this.bRN == null) {
                this.bRN = new SmartBubbleAnimatedView(getContext());
                this.bRN.setExtrusionRemind(true);
            }
            this.bRN.bRT = this.bRP.getTipText();
            this.bRN.fdf = this.bRP.aeU();
            if (this.bRN.getParent() != null) {
                this.bRD.removeView(this.bRN);
            }
            this.bRD.addView(this.bRN);
            this.bRN.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.h.2
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void aeS() {
                    if (h.this.bRO != null) {
                        h.this.bRO.onAnimationEnd();
                    }
                }
            });
            if (this.bRO != null) {
                this.bRO.ig(this.bRN.getTipViewHeight());
            }
            this.bRN.bey();
        }
    }

    public void aeR() {
        if (this.bRD != null && this.bRN != null && this.bRN.getParent() != null) {
            this.bRD.removeView(this.bRN);
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        private String bRT;
        private int bRU;

        public e(String str, int i) {
            this.bRT = str;
            this.bRU = i;
        }

        public String getTipText() {
            return this.bRT;
        }

        public int aeU() {
            return this.bRU;
        }
    }
}
