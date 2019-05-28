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
    private c bZA;
    private b bZB;
    private d bZC;
    private a bZD;
    protected AnimationDrawable bZE;
    protected ContinuousAnimationView bZF;
    private boolean bZG;
    private boolean bZH;
    private SmartBubbleAnimatedView bZI;
    private f bZJ;
    private e bZK;
    private boolean bZL;
    private boolean bZM;
    protected LinearLayout bZy;
    protected ImageView bZz;
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
        this.bZy = null;
        this.bZz = null;
        this.bZA = null;
        this.bZB = null;
        this.bZC = null;
        this.bZD = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.bZG = false;
        this.bZH = false;
        this.bZL = true;
        this.bZM = true;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nG() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.bZy = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.bZF = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        this.bZz = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!ahY()) {
            this.bZE = af.ahQ().hW(skinType);
        }
        this.bZz.setBackgroundDrawable(this.bZE);
        ajJ();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!ahY() && this.bZE != null && this.bZz != null) {
            this.bZE.stop();
            this.bZz.setBackgroundDrawable(this.bZE.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ao(boolean z) {
        if (this.bZC != null) {
            this.bZC.eo(z);
        }
        ajJ();
        this.bZG = true;
        if (!ahY() && this.bZE != null && this.bZz != null) {
            this.bZE.stop();
            this.bZz.setBackgroundDrawable(this.bZE.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f2, float f3) {
        super.n(f2, f3);
        if (ahY()) {
            this.bZF.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        ajJ();
        if (ahY()) {
            this.bZF.bo();
        } else if (this.bZE != null && this.bZz != null) {
            this.bZE.stop();
            this.bZz.setBackgroundDrawable(this.bZE);
            this.bZz.post(new Runnable() { // from class: com.baidu.tbadk.core.view.h.1
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.bZE != null) {
                        h.this.bZE.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ap(boolean z) {
        this.bZG = false;
        this.bZM = true;
        if (ahY()) {
            this.bZF.bq();
        } else if (this.bZE != null) {
            this.bZE.stop();
        }
        ajK();
        if (this.bZB != null) {
            this.bZB.f(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aq(boolean z) {
        if (this.bZA != null && this.bZM) {
            this.bZA.en(z);
        }
        this.bZM = true;
    }

    public void ajI() {
        this.bZM = false;
    }

    public void a(e eVar) {
        this.bZK = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nH() {
        if (this.bZD != null) {
            this.bZD.ajP();
        }
        ajM();
    }

    public void setListPullRefreshListener(c cVar) {
        this.bZA = cVar;
    }

    public void a(b bVar) {
        this.bZB = bVar;
    }

    public void a(d dVar) {
        this.bZC = dVar;
    }

    public void a(a aVar) {
        this.bZD = aVar;
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
        if (this.bZI != null && this.bZI.getParent() != null) {
            this.bZy.removeView(this.bZI);
        }
        if (ahY()) {
            if (this.bZz != null && this.bZF != null) {
                if (this.bZz.getVisibility() != 8) {
                    this.bZz.setVisibility(8);
                }
                if (this.bZF.getVisibility() != 0) {
                    this.bZF.setVisibility(0);
                }
                if (this.bZF.isAnimating()) {
                    this.bZF.cancelAnimation();
                }
            }
        } else if (this.bZz != null && this.bZF != null) {
            if (this.bZz.getVisibility() != 0) {
                this.bZz.setVisibility(0);
            }
            if (this.bZF.getVisibility() != 8) {
                this.bZF.setVisibility(8);
            }
        }
    }

    private void ajK() {
        if (ahY() && this.bZE != null) {
            this.bZE.stop();
            this.bZE = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }

    public boolean ajL() {
        return this.bZH;
    }

    public void a(f fVar) {
        this.bZJ = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.bZL = z;
    }

    public void ajM() {
        if (ajL() && this.bZL && this.bZK != null && this.bZy != null) {
            this.bZz.setVisibility(8);
            this.bZF.setVisibility(8);
            if (this.bZI == null) {
                this.bZI = new SmartBubbleAnimatedView(getContext());
                this.bZI.setExtrusionRemind(true);
            }
            this.bZI.bZO = this.bZK.getTipText();
            this.bZI.ftg = this.bZK.ajQ();
            if (this.bZI.getParent() != null) {
                this.bZy.removeView(this.bZI);
            }
            this.bZy.addView(this.bZI);
            this.bZI.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.h.2
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void ajO() {
                    if (h.this.bZJ != null) {
                        h.this.bZJ.onAnimationEnd();
                    }
                }
            });
            if (this.bZJ != null) {
                this.bZJ.iT(this.bZI.getTipViewHeight());
            }
            this.bZI.blQ();
        }
    }

    public void ajN() {
        if (this.bZy != null && this.bZI != null && this.bZI.getParent() != null) {
            this.bZy.removeView(this.bZI);
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        private String bZO;
        private int bZP;

        public e(String str, int i) {
            this.bZO = str;
            this.bZP = i;
        }

        public String getTipText() {
            return this.bZO;
        }

        public int ajQ() {
            return this.bZP;
        }
    }
}
