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
    protected LinearLayout bRG;
    protected ImageView bRH;
    private c bRI;
    private b bRJ;
    private d bRK;
    private a bRL;
    protected AnimationDrawable bRM;
    protected ContinuousAnimationView bRN;
    private boolean bRO;
    private boolean bRP;
    private SmartBubbleAnimatedView bRQ;
    private f bRR;
    private e bRS;
    private boolean bRT;
    private boolean bRU;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void aeQ();
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
        /* renamed from: if  reason: not valid java name */
        void mo19if(int i);

        void onAnimationEnd();
    }

    public h(Context context) {
        super(context);
        this.mHeaderView = null;
        this.bRG = null;
        this.bRH = null;
        this.bRI = null;
        this.bRJ = null;
        this.bRK = null;
        this.bRL = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.bRO = false;
        this.bRP = false;
        this.bRT = true;
        this.bRU = true;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oM() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.bRG = (LinearLayout) this.mHeaderView.findViewById(d.g.pull_root);
        this.bRN = (ContinuousAnimationView) this.mHeaderView.findViewById(d.g.continuous_loading_view);
        this.bRH = (ImageView) this.mHeaderView.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!ada()) {
            this.bRM = af.acS().hi(skinType);
        }
        this.bRH.setBackgroundDrawable(this.bRM);
        aeK();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!ada() && this.bRM != null && this.bRH != null) {
            this.bRM.stop();
            this.bRH.setBackgroundDrawable(this.bRM.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        if (this.bRK != null) {
            this.bRK.dS(z);
        }
        aeK();
        this.bRO = true;
        if (!ada() && this.bRM != null && this.bRH != null) {
            this.bRM.stop();
            this.bRH.setBackgroundDrawable(this.bRM.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f2, float f3) {
        super.n(f2, f3);
        if (ada()) {
            this.bRN.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        aeK();
        if (ada()) {
            this.bRN.cu();
        } else if (this.bRM != null && this.bRH != null) {
            this.bRM.stop();
            this.bRH.setBackgroundDrawable(this.bRM);
            this.bRH.post(new Runnable() { // from class: com.baidu.tbadk.core.view.h.1
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.bRM != null) {
                        h.this.bRM.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        this.bRO = false;
        if (ada()) {
            this.bRN.cw();
        } else if (this.bRM != null) {
            this.bRM.stop();
        }
        aeL();
        if (this.bRJ != null) {
            this.bRJ.f(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ay(boolean z) {
        if (this.bRI != null && this.bRU) {
            this.bRI.dR(z);
        }
        this.bRU = true;
    }

    public void aeJ() {
        this.bRU = false;
    }

    public void a(e eVar) {
        this.bRS = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oN() {
        if (this.bRL != null) {
            this.bRL.aeQ();
        }
        aeN();
    }

    public void setListPullRefreshListener(c cVar) {
        this.bRI = cVar;
    }

    public void a(b bVar) {
        this.bRJ = bVar;
    }

    public void a(d dVar) {
        this.bRK = dVar;
    }

    public void a(a aVar) {
        this.bRL = aVar;
    }

    public void ib(int i) {
        if (ada()) {
            al.f(this.mHeaderView, d.C0277d.cp_bg_line_f, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ada() {
        return af.acS().ada();
    }

    private void aeK() {
        if (this.bRQ != null && this.bRQ.getParent() != null) {
            this.bRG.removeView(this.bRQ);
        }
        if (ada()) {
            if (this.bRH != null && this.bRN != null) {
                if (this.bRH.getVisibility() != 8) {
                    this.bRH.setVisibility(8);
                }
                if (this.bRN.getVisibility() != 0) {
                    this.bRN.setVisibility(0);
                }
                if (this.bRN.isAnimating()) {
                    this.bRN.cancelAnimation();
                }
            }
        } else if (this.bRH != null && this.bRN != null) {
            if (this.bRH.getVisibility() != 0) {
                this.bRH.setVisibility(0);
            }
            if (this.bRN.getVisibility() != 8) {
                this.bRN.setVisibility(8);
            }
        }
    }

    private void aeL() {
        if (ada() && this.bRM != null) {
            this.bRM.stop();
            this.bRM = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }

    public boolean aeM() {
        return this.bRP;
    }

    public void a(f fVar) {
        this.bRR = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.bRT = z;
    }

    public void aeN() {
        if (aeM() && this.bRT && this.bRS != null && this.bRG != null) {
            this.bRH.setVisibility(8);
            this.bRN.setVisibility(8);
            if (this.bRQ == null) {
                this.bRQ = new SmartBubbleAnimatedView(getContext());
                this.bRQ.setExtrusionRemind(true);
            }
            this.bRQ.bRW = this.bRS.getTipText();
            this.bRQ.fcR = this.bRS.aeR();
            if (this.bRQ.getParent() != null) {
                this.bRG.removeView(this.bRQ);
            }
            this.bRG.addView(this.bRQ);
            this.bRQ.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.h.2
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void aeP() {
                    if (h.this.bRR != null) {
                        h.this.bRR.onAnimationEnd();
                    }
                }
            });
            if (this.bRR != null) {
                this.bRR.mo19if(this.bRQ.getTipViewHeight());
            }
            this.bRQ.bev();
        }
    }

    public void aeO() {
        if (this.bRG != null && this.bRQ != null && this.bRQ.getParent() != null) {
            this.bRG.removeView(this.bRQ);
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        private String bRW;
        private int bRX;

        public e(String str, int i) {
            this.bRW = str;
            this.bRX = i;
        }

        public String getTipText() {
            return this.bRW;
        }

        public int aeR() {
            return this.bRX;
        }
    }
}
