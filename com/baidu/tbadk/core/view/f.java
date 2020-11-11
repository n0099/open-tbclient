package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.d {
    private c eVA;
    private b eVB;
    private d eVC;
    private a eVD;
    protected ContinuousAnimationView eVE;
    private boolean eVF;
    private SmartBubbleAnimatedView eVG;
    private InterfaceC0581f eVH;
    private e eVI;
    private boolean eVJ;
    private boolean eVK;
    private boolean eVL;
    private View.OnClickListener eVM;
    private final Animator.AnimatorListener eVN;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void bsM();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onListPullRefreshFinished(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void onListPullToRefresh(boolean z);
    }

    /* renamed from: com.baidu.tbadk.core.view.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0581f {
        void onAnimationEnd();

        void pX(int i);
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.eVA = null;
        this.eVB = null;
        this.eVC = null;
        this.eVD = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.eVF = false;
        this.eVJ = true;
        this.eVK = true;
        this.eVL = false;
        this.eVM = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eVM != null) {
                    f.this.eVM.onClick(view);
                }
            }
        };
        this.eVN = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.f.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (!f.this.eVL) {
                    f.this.eVL = true;
                    f.this.eVE.setSpeed(1.0f);
                    f.this.eVE.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.eVE = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        ap.a(this.eVE, R.raw.lottie_common_pull_refresh);
        this.eVE.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!bqZ()) {
            this.mAnimImage = ai.bqY().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        if (!bqZ() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        if (this.eVC != null) {
            this.eVC.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!bqZ() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        super.onPullPercentChange(f, f2);
        if (bqZ()) {
            this.eVE.setAlpha(f);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        initPullView();
        if (bqZ()) {
            if (!qQ()) {
                bsF();
            }
        } else if (this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage);
            this.mPullImage.post(new Runnable() { // from class: com.baidu.tbadk.core.view.f.2
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mAnimImage != null) {
                        f.this.mAnimImage.start();
                    }
                }
            });
        }
    }

    private void bsF() {
        if (this.eVE != null) {
            if (this.eVE.isAnimating()) {
                this.eVE.cancelAnimation();
            }
            this.eVL = false;
            this.eVE.loop(true);
            this.eVE.setMinAndMaxProgress(0.0f, 0.738f);
            this.eVE.setSpeed(1.5f);
            this.eVE.setRepeatMode(1);
            this.eVE.removeAllAnimatorListeners();
            this.eVE.addAnimatorListener(this.eVN);
            this.eVE.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.eVK = true;
        if (bqZ() && this.eVE.isAnimating()) {
            this.eVE.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        bsH();
        if (this.eVB != null) {
            this.eVB.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (!qQ()) {
            if (this.eVA != null && this.eVK) {
                this.eVA.onListPullRefresh(z);
            }
            this.eVK = true;
        }
    }

    public void a(e eVar) {
        this.eVI = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        if (!qQ()) {
            if (this.eVD != null) {
                this.eVD.bsM();
            }
            if (!bsJ()) {
                bsG();
            } else if (this.eVE != null && this.eVE.isAnimating()) {
                this.eVE.cancelAnimation();
            }
        }
    }

    private void bsG() {
        if (bqZ() && this.eVE != null) {
            if (this.eVE.isAnimating()) {
                this.eVE.cancelAnimation();
            }
            this.eVE.loop(false);
            this.eVE.setSpeed(1.0f);
            this.eVE.setMinAndMaxProgress(0.738f, 1.0f);
            this.eVE.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.eVA = cVar;
    }

    public void a(b bVar) {
        this.eVB = bVar;
    }

    public void a(d dVar) {
        this.eVC = dVar;
    }

    public void a(a aVar) {
        this.eVD = aVar;
    }

    public void changeSkin(int i) {
        if (bqZ()) {
            ap.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.eVE != null && !this.eVE.isAnimating()) {
                this.mSkinType = i;
                ap.a(this.eVE, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.eVG != null) {
            this.eVG.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bqZ() {
        return ai.bqY().bqZ();
    }

    private void initPullView() {
        if (this.eVG != null && this.eVG.getParent() != null) {
            this.mPullRoot.removeView(this.eVG);
        }
        if (bqZ()) {
            if (this.mPullImage != null && this.eVE != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.eVE.getVisibility() != 0) {
                    this.eVE.setVisibility(0);
                }
                if (this.eVE.isAnimating()) {
                    this.eVE.cancelAnimation();
                }
                this.eVE.setMinAndMaxProgress(0.0f, 1.0f);
                this.eVE.setFrame(0);
            }
        } else if (this.mPullImage != null && this.eVE != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.eVE.getVisibility() != 8) {
                this.eVE.setVisibility(8);
            }
        }
    }

    private void bsH() {
        if (bqZ() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean bsI() {
        return this.eVF;
    }

    public void a(InterfaceC0581f interfaceC0581f) {
        this.eVH = interfaceC0581f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.eVJ = z;
    }

    public boolean bsJ() {
        if (bsI() && this.eVJ && this.eVI != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.eVE.setVisibility(8);
            if (this.eVG == null) {
                this.eVG = new SmartBubbleAnimatedView(getContext());
                this.eVG.setExtrusionRemind(true);
            }
            this.eVG.eVP = this.eVI.getTipText();
            this.eVG.iMp = this.eVI.bsN();
            if (this.eVG.getParent() != null) {
                this.mPullRoot.removeView(this.eVG);
            }
            this.mPullRoot.addView(this.eVG);
            this.eVG.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void bsL() {
                    if (f.this.eVH != null) {
                        f.this.eVH.onAnimationEnd();
                    }
                }
            });
            if (this.eVH != null) {
                this.eVH.pX(this.eVG.getTipViewHeight());
            }
            this.eVG.cAE();
            return true;
        }
        return false;
    }

    public void bsK() {
        if (this.mPullRoot != null && this.eVG != null && this.eVG.getParent() != null) {
            this.mPullRoot.removeView(this.eVG);
        }
    }

    public void pW(int i) {
        if (this.eVE != null) {
            ap.a(this.eVE, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eVM = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String eVP;
        private int eVQ;

        public e(String str, int i) {
            this.eVP = str;
            this.eVQ = i;
        }

        public String getTipText() {
            return this.eVP;
        }

        public int bsN() {
            return this.eVQ;
        }
    }
}
