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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.c {
    protected ImageView bZA;
    private c bZB;
    private b bZC;
    private d bZD;
    private a bZE;
    protected AnimationDrawable bZF;
    protected ContinuousAnimationView bZG;
    private boolean bZH;
    private boolean bZI;
    private SmartBubbleAnimatedView bZJ;
    private f bZK;
    private e bZL;
    private boolean bZM;
    private boolean bZN;
    protected LinearLayout bZz;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void ajP();
    }

    /* loaded from: classes.dex */
    public interface b {
        void f(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void en(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void eo(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void iT(int i);

        void onAnimationEnd();
    }

    public h(Context context) {
        super(context);
        this.mHeaderView = null;
        this.bZz = null;
        this.bZA = null;
        this.bZB = null;
        this.bZC = null;
        this.bZD = null;
        this.bZE = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.bZH = false;
        this.bZI = false;
        this.bZM = true;
        this.bZN = true;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nG() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.bZz = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.bZG = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        this.bZA = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!ahY()) {
            this.bZF = af.ahQ().hW(skinType);
        }
        this.bZA.setBackgroundDrawable(this.bZF);
        ajJ();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!ahY() && this.bZF != null && this.bZA != null) {
            this.bZF.stop();
            this.bZA.setBackgroundDrawable(this.bZF.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ao(boolean z) {
        if (this.bZD != null) {
            this.bZD.eo(z);
        }
        ajJ();
        this.bZH = true;
        if (!ahY() && this.bZF != null && this.bZA != null) {
            this.bZF.stop();
            this.bZA.setBackgroundDrawable(this.bZF.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f2, float f3) {
        super.n(f2, f3);
        if (ahY()) {
            this.bZG.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        ajJ();
        if (ahY()) {
            this.bZG.bo();
        } else if (this.bZF != null && this.bZA != null) {
            this.bZF.stop();
            this.bZA.setBackgroundDrawable(this.bZF);
            this.bZA.post(new Runnable() { // from class: com.baidu.tbadk.core.view.h.1
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.bZF != null) {
                        h.this.bZF.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ap(boolean z) {
        this.bZH = false;
        this.bZN = true;
        if (ahY()) {
            this.bZG.bq();
        } else if (this.bZF != null) {
            this.bZF.stop();
        }
        ajK();
        if (this.bZC != null) {
            this.bZC.f(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aq(boolean z) {
        if (this.bZB != null && this.bZN) {
            this.bZB.en(z);
        }
        this.bZN = true;
    }

    public void ajI() {
        this.bZN = false;
    }

    public void a(e eVar) {
        this.bZL = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nH() {
        if (this.bZE != null) {
            this.bZE.ajP();
        }
        ajM();
    }

    public void setListPullRefreshListener(c cVar) {
        this.bZB = cVar;
    }

    public void a(b bVar) {
        this.bZC = bVar;
    }

    public void a(d dVar) {
        this.bZD = dVar;
    }

    public void a(a aVar) {
        this.bZE = aVar;
    }

    public void iP(int i) {
        if (ahY()) {
            al.h(this.mHeaderView, R.color.cp_bg_line_f, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ahY() {
        return af.ahQ().ahY();
    }

    private void ajJ() {
        if (this.bZJ != null && this.bZJ.getParent() != null) {
            this.bZz.removeView(this.bZJ);
        }
        if (ahY()) {
            if (this.bZA != null && this.bZG != null) {
                if (this.bZA.getVisibility() != 8) {
                    this.bZA.setVisibility(8);
                }
                if (this.bZG.getVisibility() != 0) {
                    this.bZG.setVisibility(0);
                }
                if (this.bZG.isAnimating()) {
                    this.bZG.cancelAnimation();
                }
            }
        } else if (this.bZA != null && this.bZG != null) {
            if (this.bZA.getVisibility() != 0) {
                this.bZA.setVisibility(0);
            }
            if (this.bZG.getVisibility() != 8) {
                this.bZG.setVisibility(8);
            }
        }
    }

    private void ajK() {
        if (ahY() && this.bZF != null) {
            this.bZF.stop();
            this.bZF = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }

    public boolean ajL() {
        return this.bZI;
    }

    public void a(f fVar) {
        this.bZK = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.bZM = z;
    }

    public void ajM() {
        if (ajL() && this.bZM && this.bZL != null && this.bZz != null) {
            this.bZA.setVisibility(8);
            this.bZG.setVisibility(8);
            if (this.bZJ == null) {
                this.bZJ = new SmartBubbleAnimatedView(getContext());
                this.bZJ.setExtrusionRemind(true);
            }
            this.bZJ.bZP = this.bZL.getTipText();
            this.bZJ.ftg = this.bZL.ajQ();
            if (this.bZJ.getParent() != null) {
                this.bZz.removeView(this.bZJ);
            }
            this.bZz.addView(this.bZJ);
            this.bZJ.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.h.2
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void ajO() {
                    if (h.this.bZK != null) {
                        h.this.bZK.onAnimationEnd();
                    }
                }
            });
            if (this.bZK != null) {
                this.bZK.iT(this.bZJ.getTipViewHeight());
            }
            this.bZJ.blQ();
        }
    }

    public void ajN() {
        if (this.bZz != null && this.bZJ != null && this.bZJ.getParent() != null) {
            this.bZz.removeView(this.bZJ);
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        private String bZP;
        private int bZQ;

        public e(String str, int i) {
            this.bZP = str;
            this.bZQ = i;
        }

        public String getTipText() {
            return this.bZP;
        }

        public int ajQ() {
            return this.bZQ;
        }
    }
}
