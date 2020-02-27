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
    private c dgH;
    private b dgI;
    private d dgJ;
    private a dgK;
    protected ContinuousAnimationView dgL;
    private boolean dgM;
    private SmartBubbleAnimatedView dgN;
    private f dgO;
    private e dgP;
    private boolean dgQ;
    private boolean dgR;
    private boolean dgS;
    private View.OnClickListener dgT;
    private final Animator.AnimatorListener dgU;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void aHV();
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
        void lm(int i);

        void onAnimationEnd();
    }

    public g(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.dgH = null;
        this.dgI = null;
        this.dgJ = null;
        this.dgK = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.dgM = false;
        this.dgQ = true;
        this.dgR = true;
        this.dgS = false;
        this.dgT = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.dgT != null) {
                    g.this.dgT.onClick(view);
                }
            }
        };
        this.dgU = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.g.3
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
                if (!g.this.dgS) {
                    g.this.dgS = true;
                    g.this.dgL.setSpeed(1.0f);
                    g.this.dgL.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.dgL = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        am.a(this.dgL, R.raw.lottie_common_pull_refresh);
        this.dgL.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!aGn()) {
            this.mAnimImage = af.aGm().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!aGn() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        if (this.dgJ != null) {
            this.dgJ.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!aGn() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f2, float f3) {
        super.onPullPercentChange(f2, f3);
        if (aGn()) {
            this.dgL.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (aGn()) {
            if (!kl()) {
                aHN();
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

    private void aHN() {
        if (this.dgL != null) {
            if (this.dgL.isAnimating()) {
                this.dgL.cancelAnimation();
            }
            this.dgS = false;
            this.dgL.loop(true);
            this.dgL.setMinAndMaxProgress(0.0f, 0.738f);
            this.dgL.setSpeed(1.5f);
            this.dgL.setRepeatMode(1);
            this.dgL.removeAllAnimatorListeners();
            this.dgL.addAnimatorListener(this.dgU);
            this.dgL.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.dgR = true;
        if (aGn() && this.dgL.isAnimating()) {
            this.dgL.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        aHQ();
        if (this.dgI != null) {
            this.dgI.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!kl()) {
            if (this.dgH != null && this.dgR) {
                this.dgH.onListPullRefresh(z);
            }
            this.dgR = true;
        }
    }

    public void aHO() {
        this.dgR = false;
    }

    public void a(e eVar) {
        this.dgP = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!kl()) {
            if (this.dgK != null) {
                this.dgK.aHV();
            }
            if (!aHS()) {
                aHP();
            } else if (this.dgL != null && this.dgL.isAnimating()) {
                this.dgL.cancelAnimation();
            }
        }
    }

    private void aHP() {
        if (aGn() && this.dgL != null) {
            if (this.dgL.isAnimating()) {
                this.dgL.cancelAnimation();
            }
            this.dgL.loop(false);
            this.dgL.setSpeed(1.0f);
            this.dgL.setMinAndMaxProgress(0.738f, 1.0f);
            this.dgL.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.dgH = cVar;
    }

    public void a(b bVar) {
        this.dgI = bVar;
    }

    public void a(d dVar) {
        this.dgJ = dVar;
    }

    public void a(a aVar) {
        this.dgK = aVar;
    }

    public void changeSkin(int i) {
        if (aGn()) {
            am.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.dgL != null && !this.dgL.isAnimating()) {
                this.mSkinType = i;
                am.a(this.dgL, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.dgN != null) {
            this.dgN.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aGn() {
        return af.aGm().aGn();
    }

    private void initPullView() {
        if (this.dgN != null && this.dgN.getParent() != null) {
            this.mPullRoot.removeView(this.dgN);
        }
        if (aGn()) {
            if (this.mPullImage != null && this.dgL != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.dgL.getVisibility() != 0) {
                    this.dgL.setVisibility(0);
                }
                if (this.dgL.isAnimating()) {
                    this.dgL.cancelAnimation();
                }
                this.dgL.setMinAndMaxProgress(0.0f, 1.0f);
                this.dgL.setFrame(0);
            }
        } else if (this.mPullImage != null && this.dgL != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.dgL.getVisibility() != 8) {
                this.dgL.setVisibility(8);
            }
        }
    }

    private void aHQ() {
        if (aGn() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean aHR() {
        return this.dgM;
    }

    public void a(f fVar) {
        this.dgO = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.dgQ = z;
    }

    public boolean aHS() {
        if (aHR() && this.dgQ && this.dgP != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.dgL.setVisibility(8);
            if (this.dgN == null) {
                this.dgN = new SmartBubbleAnimatedView(getContext());
                this.dgN.setExtrusionRemind(true);
            }
            this.dgN.dgW = this.dgP.getTipText();
            this.dgN.gss = this.dgP.aHW();
            if (this.dgN.getParent() != null) {
                this.mPullRoot.removeView(this.dgN);
            }
            this.mPullRoot.addView(this.dgN);
            this.dgN.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.g.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void aHU() {
                    if (g.this.dgO != null) {
                        g.this.dgO.onAnimationEnd();
                    }
                }
            });
            if (this.dgO != null) {
                this.dgO.lm(this.dgN.getTipViewHeight());
            }
            this.dgN.bFO();
            return true;
        }
        return false;
    }

    public void aHT() {
        if (this.mPullRoot != null && this.dgN != null && this.dgN.getParent() != null) {
            this.mPullRoot.removeView(this.dgN);
        }
    }

    public void ll(int i) {
        if (this.dgL != null) {
            am.a(this.dgL, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dgT = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String dgW;
        private int dgX;

        public e(String str, int i) {
            this.dgW = str;
            this.dgX = i;
        }

        public String getTipText() {
            return this.dgW;
        }

        public int aHW() {
            return this.dgX;
        }
    }
}
