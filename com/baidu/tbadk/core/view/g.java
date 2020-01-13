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
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.c {
    private c dcC;
    private b dcD;
    private d dcE;
    private a dcF;
    protected ContinuousAnimationView dcG;
    private boolean dcH;
    private SmartBubbleAnimatedView dcI;
    private f dcJ;
    private e dcK;
    private boolean dcL;
    private boolean dcM;
    private boolean dcN;
    private View.OnClickListener dcO;
    private final Animator.AnimatorListener dcP;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void aFG();
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

    /* loaded from: classes.dex */
    public interface f {
        void kV(int i);

        void onAnimationEnd();
    }

    public g(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.dcC = null;
        this.dcD = null;
        this.dcE = null;
        this.dcF = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.dcH = false;
        this.dcL = true;
        this.dcM = true;
        this.dcN = false;
        this.dcO = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.dcO != null) {
                    g.this.dcO.onClick(view);
                }
            }
        };
        this.dcP = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.g.3
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
                if (!g.this.dcN) {
                    g.this.dcN = true;
                    g.this.dcG.setSpeed(1.0f);
                    g.this.dcG.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.dcG = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        am.a(this.dcG, R.raw.lottie_common_pull_refresh);
        this.dcG.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!aEd()) {
            this.mAnimImage = af.aEc().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!aEd() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        if (this.dcE != null) {
            this.dcE.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!aEd() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f2, float f3) {
        super.onPullPercentChange(f2, f3);
        if (aEd()) {
            this.dcG.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (aEd()) {
            if (!jW()) {
                aFy();
            }
        } else if (this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage);
            this.mPullImage.post(new Runnable() { // from class: com.baidu.tbadk.core.view.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.mAnimImage != null) {
                        g.this.mAnimImage.start();
                    }
                }
            });
        }
    }

    private void aFy() {
        if (this.dcG != null) {
            if (this.dcG.isAnimating()) {
                this.dcG.cancelAnimation();
            }
            this.dcN = false;
            this.dcG.loop(true);
            this.dcG.setMinAndMaxProgress(0.0f, 0.738f);
            this.dcG.setSpeed(1.5f);
            this.dcG.setRepeatMode(1);
            this.dcG.removeAllAnimatorListeners();
            this.dcG.addAnimatorListener(this.dcP);
            this.dcG.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.dcM = true;
        if (aEd() && this.dcG.isAnimating()) {
            this.dcG.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        aFB();
        if (this.dcD != null) {
            this.dcD.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!jW()) {
            if (this.dcC != null && this.dcM) {
                this.dcC.onListPullRefresh(z);
            }
            this.dcM = true;
        }
    }

    public void aFz() {
        this.dcM = false;
    }

    public void a(e eVar) {
        this.dcK = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!jW()) {
            if (this.dcF != null) {
                this.dcF.aFG();
            }
            if (!aFD()) {
                aFA();
            } else if (this.dcG != null && this.dcG.isAnimating()) {
                this.dcG.cancelAnimation();
            }
        }
    }

    private void aFA() {
        if (aEd() && this.dcG != null) {
            if (this.dcG.isAnimating()) {
                this.dcG.cancelAnimation();
            }
            this.dcG.loop(false);
            this.dcG.setSpeed(1.0f);
            this.dcG.setMinAndMaxProgress(0.738f, 1.0f);
            this.dcG.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.dcC = cVar;
    }

    public void a(b bVar) {
        this.dcD = bVar;
    }

    public void a(d dVar) {
        this.dcE = dVar;
    }

    public void a(a aVar) {
        this.dcF = aVar;
    }

    public void changeSkin(int i) {
        if (aEd()) {
            am.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.dcG != null && !this.dcG.isAnimating()) {
                this.mSkinType = i;
                am.a(this.dcG, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.dcI != null) {
            this.dcI.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aEd() {
        return af.aEc().aEd();
    }

    private void initPullView() {
        if (this.dcI != null && this.dcI.getParent() != null) {
            this.mPullRoot.removeView(this.dcI);
        }
        if (aEd()) {
            if (this.mPullImage != null && this.dcG != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.dcG.getVisibility() != 0) {
                    this.dcG.setVisibility(0);
                }
                if (this.dcG.isAnimating()) {
                    this.dcG.cancelAnimation();
                }
                this.dcG.setMinAndMaxProgress(0.0f, 1.0f);
                this.dcG.setFrame(0);
            }
        } else if (this.mPullImage != null && this.dcG != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.dcG.getVisibility() != 8) {
                this.dcG.setVisibility(8);
            }
        }
    }

    private void aFB() {
        if (aEd() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean aFC() {
        return this.dcH;
    }

    public void a(f fVar) {
        this.dcJ = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.dcL = z;
    }

    public boolean aFD() {
        if (aFC() && this.dcL && this.dcK != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.dcG.setVisibility(8);
            if (this.dcI == null) {
                this.dcI = new SmartBubbleAnimatedView(getContext());
                this.dcI.setExtrusionRemind(true);
            }
            this.dcI.dcR = this.dcK.getTipText();
            this.dcI.gqr = this.dcK.aFH();
            if (this.dcI.getParent() != null) {
                this.mPullRoot.removeView(this.dcI);
            }
            this.mPullRoot.addView(this.dcI);
            this.dcI.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.g.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void aFF() {
                    if (g.this.dcJ != null) {
                        g.this.dcJ.onAnimationEnd();
                    }
                }
            });
            if (this.dcJ != null) {
                this.dcJ.kV(this.dcI.getTipViewHeight());
            }
            this.dcI.bEm();
            return true;
        }
        return false;
    }

    public void aFE() {
        if (this.mPullRoot != null && this.dcI != null && this.dcI.getParent() != null) {
            this.mPullRoot.removeView(this.dcI);
        }
    }

    public void kU(int i) {
        if (this.dcG != null) {
            am.a(this.dcG, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dcO = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String dcR;
        private int dcS;

        public e(String str, int i) {
            this.dcR = str;
            this.dcS = i;
        }

        public String getTipText() {
            return this.dcR;
        }

        public int aFH() {
            return this.dcS;
        }
    }
}
