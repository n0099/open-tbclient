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
    protected LinearLayout bRE;
    protected ImageView bRF;
    private c bRG;
    private b bRH;
    private d bRI;
    private a bRJ;
    protected AnimationDrawable bRK;
    protected ContinuousAnimationView bRL;
    private boolean bRM;
    private boolean bRN;
    private SmartBubbleAnimatedView bRO;
    private f bRP;
    private e bRQ;
    private boolean bRR;
    private boolean bRS;
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
        this.bRE = null;
        this.bRF = null;
        this.bRG = null;
        this.bRH = null;
        this.bRI = null;
        this.bRJ = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.bRM = false;
        this.bRN = false;
        this.bRR = true;
        this.bRS = true;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oM() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.bRE = (LinearLayout) this.mHeaderView.findViewById(d.g.pull_root);
        this.bRL = (ContinuousAnimationView) this.mHeaderView.findViewById(d.g.continuous_loading_view);
        this.bRF = (ImageView) this.mHeaderView.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!add()) {
            this.bRK = af.acV().hj(skinType);
        }
        this.bRF.setBackgroundDrawable(this.bRK);
        aeN();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!add() && this.bRK != null && this.bRF != null) {
            this.bRK.stop();
            this.bRF.setBackgroundDrawable(this.bRK.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        if (this.bRI != null) {
            this.bRI.dS(z);
        }
        aeN();
        this.bRM = true;
        if (!add() && this.bRK != null && this.bRF != null) {
            this.bRK.stop();
            this.bRF.setBackgroundDrawable(this.bRK.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f2, float f3) {
        super.n(f2, f3);
        if (add()) {
            this.bRL.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        aeN();
        if (add()) {
            this.bRL.cu();
        } else if (this.bRK != null && this.bRF != null) {
            this.bRK.stop();
            this.bRF.setBackgroundDrawable(this.bRK);
            this.bRF.post(new Runnable() { // from class: com.baidu.tbadk.core.view.h.1
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.bRK != null) {
                        h.this.bRK.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        this.bRM = false;
        if (add()) {
            this.bRL.cw();
        } else if (this.bRK != null) {
            this.bRK.stop();
        }
        aeO();
        if (this.bRH != null) {
            this.bRH.f(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ay(boolean z) {
        if (this.bRG != null && this.bRS) {
            this.bRG.dR(z);
        }
        this.bRS = true;
    }

    public void aeM() {
        this.bRS = false;
    }

    public void a(e eVar) {
        this.bRQ = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oN() {
        if (this.bRJ != null) {
            this.bRJ.aeT();
        }
        aeQ();
    }

    public void setListPullRefreshListener(c cVar) {
        this.bRG = cVar;
    }

    public void a(b bVar) {
        this.bRH = bVar;
    }

    public void a(d dVar) {
        this.bRI = dVar;
    }

    public void a(a aVar) {
        this.bRJ = aVar;
    }

    public void ic(int i) {
        if (add()) {
            al.f(this.mHeaderView, d.C0277d.cp_bg_line_f, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean add() {
        return af.acV().add();
    }

    private void aeN() {
        if (this.bRO != null && this.bRO.getParent() != null) {
            this.bRE.removeView(this.bRO);
        }
        if (add()) {
            if (this.bRF != null && this.bRL != null) {
                if (this.bRF.getVisibility() != 8) {
                    this.bRF.setVisibility(8);
                }
                if (this.bRL.getVisibility() != 0) {
                    this.bRL.setVisibility(0);
                }
                if (this.bRL.isAnimating()) {
                    this.bRL.cancelAnimation();
                }
            }
        } else if (this.bRF != null && this.bRL != null) {
            if (this.bRF.getVisibility() != 0) {
                this.bRF.setVisibility(0);
            }
            if (this.bRL.getVisibility() != 8) {
                this.bRL.setVisibility(8);
            }
        }
    }

    private void aeO() {
        if (add() && this.bRK != null) {
            this.bRK.stop();
            this.bRK = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }

    public boolean aeP() {
        return this.bRN;
    }

    public void a(f fVar) {
        this.bRP = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.bRR = z;
    }

    public void aeQ() {
        if (aeP() && this.bRR && this.bRQ != null && this.bRE != null) {
            this.bRF.setVisibility(8);
            this.bRL.setVisibility(8);
            if (this.bRO == null) {
                this.bRO = new SmartBubbleAnimatedView(getContext());
                this.bRO.setExtrusionRemind(true);
            }
            this.bRO.bRU = this.bRQ.getTipText();
            this.bRO.fde = this.bRQ.aeU();
            if (this.bRO.getParent() != null) {
                this.bRE.removeView(this.bRO);
            }
            this.bRE.addView(this.bRO);
            this.bRO.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.h.2
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void aeS() {
                    if (h.this.bRP != null) {
                        h.this.bRP.onAnimationEnd();
                    }
                }
            });
            if (this.bRP != null) {
                this.bRP.ig(this.bRO.getTipViewHeight());
            }
            this.bRO.bex();
        }
    }

    public void aeR() {
        if (this.bRE != null && this.bRO != null && this.bRO.getParent() != null) {
            this.bRE.removeView(this.bRO);
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        private String bRU;
        private int bRV;

        public e(String str, int i) {
            this.bRU = str;
            this.bRV = i;
        }

        public String getTipText() {
            return this.bRU;
        }

        public int aeU() {
            return this.bRV;
        }
    }
}
