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
    protected LinearLayout bRH;
    protected ImageView bRI;
    private c bRJ;
    private b bRK;
    private d bRL;
    private a bRM;
    protected AnimationDrawable bRN;
    protected ContinuousAnimationView bRO;
    private boolean bRP;
    private boolean bRQ;
    private SmartBubbleAnimatedView bRR;
    private f bRS;
    private e bRT;
    private boolean bRU;
    private boolean bRV;
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
        this.bRH = null;
        this.bRI = null;
        this.bRJ = null;
        this.bRK = null;
        this.bRL = null;
        this.bRM = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.bRP = false;
        this.bRQ = false;
        this.bRU = true;
        this.bRV = true;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oM() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.bRH = (LinearLayout) this.mHeaderView.findViewById(d.g.pull_root);
        this.bRO = (ContinuousAnimationView) this.mHeaderView.findViewById(d.g.continuous_loading_view);
        this.bRI = (ImageView) this.mHeaderView.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!ada()) {
            this.bRN = af.acS().hi(skinType);
        }
        this.bRI.setBackgroundDrawable(this.bRN);
        aeK();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!ada() && this.bRN != null && this.bRI != null) {
            this.bRN.stop();
            this.bRI.setBackgroundDrawable(this.bRN.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        if (this.bRL != null) {
            this.bRL.dS(z);
        }
        aeK();
        this.bRP = true;
        if (!ada() && this.bRN != null && this.bRI != null) {
            this.bRN.stop();
            this.bRI.setBackgroundDrawable(this.bRN.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f2, float f3) {
        super.n(f2, f3);
        if (ada()) {
            this.bRO.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        aeK();
        if (ada()) {
            this.bRO.cu();
        } else if (this.bRN != null && this.bRI != null) {
            this.bRN.stop();
            this.bRI.setBackgroundDrawable(this.bRN);
            this.bRI.post(new Runnable() { // from class: com.baidu.tbadk.core.view.h.1
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.bRN != null) {
                        h.this.bRN.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        this.bRP = false;
        if (ada()) {
            this.bRO.cw();
        } else if (this.bRN != null) {
            this.bRN.stop();
        }
        aeL();
        if (this.bRK != null) {
            this.bRK.f(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ay(boolean z) {
        if (this.bRJ != null && this.bRV) {
            this.bRJ.dR(z);
        }
        this.bRV = true;
    }

    public void aeJ() {
        this.bRV = false;
    }

    public void a(e eVar) {
        this.bRT = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oN() {
        if (this.bRM != null) {
            this.bRM.aeQ();
        }
        aeN();
    }

    public void setListPullRefreshListener(c cVar) {
        this.bRJ = cVar;
    }

    public void a(b bVar) {
        this.bRK = bVar;
    }

    public void a(d dVar) {
        this.bRL = dVar;
    }

    public void a(a aVar) {
        this.bRM = aVar;
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
        if (this.bRR != null && this.bRR.getParent() != null) {
            this.bRH.removeView(this.bRR);
        }
        if (ada()) {
            if (this.bRI != null && this.bRO != null) {
                if (this.bRI.getVisibility() != 8) {
                    this.bRI.setVisibility(8);
                }
                if (this.bRO.getVisibility() != 0) {
                    this.bRO.setVisibility(0);
                }
                if (this.bRO.isAnimating()) {
                    this.bRO.cancelAnimation();
                }
            }
        } else if (this.bRI != null && this.bRO != null) {
            if (this.bRI.getVisibility() != 0) {
                this.bRI.setVisibility(0);
            }
            if (this.bRO.getVisibility() != 8) {
                this.bRO.setVisibility(8);
            }
        }
    }

    private void aeL() {
        if (ada() && this.bRN != null) {
            this.bRN.stop();
            this.bRN = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }

    public boolean aeM() {
        return this.bRQ;
    }

    public void a(f fVar) {
        this.bRS = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.bRU = z;
    }

    public void aeN() {
        if (aeM() && this.bRU && this.bRT != null && this.bRH != null) {
            this.bRI.setVisibility(8);
            this.bRO.setVisibility(8);
            if (this.bRR == null) {
                this.bRR = new SmartBubbleAnimatedView(getContext());
                this.bRR.setExtrusionRemind(true);
            }
            this.bRR.bRX = this.bRT.getTipText();
            this.bRR.fcR = this.bRT.aeR();
            if (this.bRR.getParent() != null) {
                this.bRH.removeView(this.bRR);
            }
            this.bRH.addView(this.bRR);
            this.bRR.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.h.2
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void aeP() {
                    if (h.this.bRS != null) {
                        h.this.bRS.onAnimationEnd();
                    }
                }
            });
            if (this.bRS != null) {
                this.bRS.mo19if(this.bRR.getTipViewHeight());
            }
            this.bRR.bev();
        }
    }

    public void aeO() {
        if (this.bRH != null && this.bRR != null && this.bRR.getParent() != null) {
            this.bRH.removeView(this.bRR);
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        private String bRX;
        private int bRY;

        public e(String str, int i) {
            this.bRX = str;
            this.bRY = i;
        }

        public String getTipText() {
            return this.bRX;
        }

        public int aeR() {
            return this.bRY;
        }
    }
}
