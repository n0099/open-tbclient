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
    protected LinearLayout cbA;
    protected ImageView cbB;
    private c cbC;
    private b cbD;
    private d cbE;
    private a cbF;
    protected AnimationDrawable cbG;
    protected ContinuousAnimationView cbH;
    private boolean cbI;
    private boolean cbJ;
    private SmartBubbleAnimatedView cbK;
    private f cbL;
    private e cbM;
    private boolean cbN;
    private boolean cbO;
    private View.OnClickListener cbP;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void ali();
    }

    /* loaded from: classes.dex */
    public interface b {
        void f(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void eu(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void ev(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void jd(int i);

        void onAnimationEnd();
    }

    public h(Context context) {
        super(context);
        this.mHeaderView = null;
        this.cbA = null;
        this.cbB = null;
        this.cbC = null;
        this.cbD = null;
        this.cbE = null;
        this.cbF = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.cbI = false;
        this.cbJ = false;
        this.cbN = true;
        this.cbO = true;
        this.cbP = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.cbP != null) {
                    h.this.cbP.onClick(view);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nZ() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.cbA = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.cbH = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        this.cbH.setOnClickListener(this.mClickListener);
        this.cbB = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.cbB.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!ajg()) {
            this.cbG = af.aiY().ic(skinType);
        }
        this.cbB.setBackgroundDrawable(this.cbG);
        alc();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!ajg() && this.cbG != null && this.cbB != null) {
            this.cbG.stop();
            this.cbB.setBackgroundDrawable(this.cbG.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ar(boolean z) {
        if (this.cbE != null) {
            this.cbE.ev(z);
        }
        alc();
        this.cbI = true;
        if (!ajg() && this.cbG != null && this.cbB != null) {
            this.cbG.stop();
            this.cbB.setBackgroundDrawable(this.cbG.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f2, float f3) {
        super.n(f2, f3);
        if (ajg()) {
            this.cbH.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        alc();
        if (ajg()) {
            if (!ob()) {
                this.cbH.br();
            }
        } else if (this.cbG != null && this.cbB != null) {
            this.cbG.stop();
            this.cbB.setBackgroundDrawable(this.cbG);
            this.cbB.post(new Runnable() { // from class: com.baidu.tbadk.core.view.h.2
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.cbG != null) {
                        h.this.cbG.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void as(boolean z) {
        this.cbI = false;
        this.cbO = true;
        if (ajg()) {
            this.cbH.bt();
        } else if (this.cbG != null) {
            this.cbG.stop();
        }
        ald();
        if (this.cbD != null) {
            this.cbD.f(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void at(boolean z) {
        if (!ob()) {
            if (this.cbC != null && this.cbO) {
                this.cbC.eu(z);
            }
            this.cbO = true;
        }
    }

    public void alb() {
        this.cbO = false;
    }

    public void a(e eVar) {
        this.cbM = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oa() {
        if (!ob()) {
            if (this.cbF != null) {
                this.cbF.ali();
            }
            alf();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.cbC = cVar;
    }

    public void a(b bVar) {
        this.cbD = bVar;
    }

    public void a(d dVar) {
        this.cbE = dVar;
    }

    public void a(a aVar) {
        this.cbF = aVar;
    }

    public void iY(int i) {
        if (ajg()) {
            am.h(this.mHeaderView, R.color.cp_bg_line_d, i);
        }
        if (this.cbK != null) {
            this.cbK.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ajg() {
        return af.aiY().ajg();
    }

    private void alc() {
        if (this.cbK != null && this.cbK.getParent() != null) {
            this.cbA.removeView(this.cbK);
        }
        if (ajg()) {
            if (this.cbB != null && this.cbH != null) {
                if (this.cbB.getVisibility() != 8) {
                    this.cbB.setVisibility(8);
                }
                if (this.cbH.getVisibility() != 0) {
                    this.cbH.setVisibility(0);
                }
                if (this.cbH.isAnimating()) {
                    this.cbH.cancelAnimation();
                }
            }
        } else if (this.cbB != null && this.cbH != null) {
            if (this.cbB.getVisibility() != 0) {
                this.cbB.setVisibility(0);
            }
            if (this.cbH.getVisibility() != 8) {
                this.cbH.setVisibility(8);
            }
        }
    }

    private void ald() {
        if (ajg() && this.cbG != null) {
            this.cbG.stop();
            this.cbG = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }

    public boolean ale() {
        return this.cbJ;
    }

    public void a(f fVar) {
        this.cbL = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.cbN = z;
    }

    public void alf() {
        if (ale() && this.cbN && this.cbM != null && this.cbA != null) {
            this.cbB.setVisibility(8);
            this.cbH.setVisibility(8);
            if (this.cbK == null) {
                this.cbK = new SmartBubbleAnimatedView(getContext());
                this.cbK.setExtrusionRemind(true);
            }
            this.cbK.cbR = this.cbM.getTipText();
            this.cbK.fAo = this.cbM.alj();
            if (this.cbK.getParent() != null) {
                this.cbA.removeView(this.cbK);
            }
            this.cbA.addView(this.cbK);
            this.cbK.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.h.3
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void alh() {
                    if (h.this.cbL != null) {
                        h.this.cbL.onAnimationEnd();
                    }
                }
            });
            if (this.cbL != null) {
                this.cbL.jd(this.cbK.getTipViewHeight());
            }
            this.cbK.boM();
        }
    }

    public void alg() {
        if (this.cbA != null && this.cbK != null && this.cbK.getParent() != null) {
            this.cbA.removeView(this.cbK);
        }
    }

    public void jc(int i) {
        this.cbH.setAnimation(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cbP = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String cbR;
        private int cbS;

        public e(String str, int i) {
            this.cbR = str;
            this.cbS = i;
        }

        public String getTipText() {
            return this.cbR;
        }

        public int alj() {
            return this.cbS;
        }
    }
}
