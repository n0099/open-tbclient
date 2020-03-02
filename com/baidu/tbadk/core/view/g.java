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
    private c dgI;
    private b dgJ;
    private d dgK;
    private a dgL;
    protected ContinuousAnimationView dgM;
    private boolean dgN;
    private SmartBubbleAnimatedView dgO;
    private f dgP;
    private e dgQ;
    private boolean dgR;
    private boolean dgS;
    private boolean dgT;
    private View.OnClickListener dgU;
    private final Animator.AnimatorListener dgV;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void aHX();
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
        this.dgI = null;
        this.dgJ = null;
        this.dgK = null;
        this.dgL = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.dgN = false;
        this.dgR = true;
        this.dgS = true;
        this.dgT = false;
        this.dgU = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.dgU != null) {
                    g.this.dgU.onClick(view);
                }
            }
        };
        this.dgV = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.g.3
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
                if (!g.this.dgT) {
                    g.this.dgT = true;
                    g.this.dgM.setSpeed(1.0f);
                    g.this.dgM.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.dgM = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        am.a(this.dgM, R.raw.lottie_common_pull_refresh);
        this.dgM.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!aGp()) {
            this.mAnimImage = af.aGo().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!aGp() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        if (this.dgK != null) {
            this.dgK.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!aGp() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f2, float f3) {
        super.onPullPercentChange(f2, f3);
        if (aGp()) {
            this.dgM.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (aGp()) {
            if (!kl()) {
                aHP();
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

    private void aHP() {
        if (this.dgM != null) {
            if (this.dgM.isAnimating()) {
                this.dgM.cancelAnimation();
            }
            this.dgT = false;
            this.dgM.loop(true);
            this.dgM.setMinAndMaxProgress(0.0f, 0.738f);
            this.dgM.setSpeed(1.5f);
            this.dgM.setRepeatMode(1);
            this.dgM.removeAllAnimatorListeners();
            this.dgM.addAnimatorListener(this.dgV);
            this.dgM.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.dgS = true;
        if (aGp() && this.dgM.isAnimating()) {
            this.dgM.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        aHS();
        if (this.dgJ != null) {
            this.dgJ.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!kl()) {
            if (this.dgI != null && this.dgS) {
                this.dgI.onListPullRefresh(z);
            }
            this.dgS = true;
        }
    }

    public void aHQ() {
        this.dgS = false;
    }

    public void a(e eVar) {
        this.dgQ = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!kl()) {
            if (this.dgL != null) {
                this.dgL.aHX();
            }
            if (!aHU()) {
                aHR();
            } else if (this.dgM != null && this.dgM.isAnimating()) {
                this.dgM.cancelAnimation();
            }
        }
    }

    private void aHR() {
        if (aGp() && this.dgM != null) {
            if (this.dgM.isAnimating()) {
                this.dgM.cancelAnimation();
            }
            this.dgM.loop(false);
            this.dgM.setSpeed(1.0f);
            this.dgM.setMinAndMaxProgress(0.738f, 1.0f);
            this.dgM.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.dgI = cVar;
    }

    public void a(b bVar) {
        this.dgJ = bVar;
    }

    public void a(d dVar) {
        this.dgK = dVar;
    }

    public void a(a aVar) {
        this.dgL = aVar;
    }

    public void changeSkin(int i) {
        if (aGp()) {
            am.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.dgM != null && !this.dgM.isAnimating()) {
                this.mSkinType = i;
                am.a(this.dgM, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.dgO != null) {
            this.dgO.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aGp() {
        return af.aGo().aGp();
    }

    private void initPullView() {
        if (this.dgO != null && this.dgO.getParent() != null) {
            this.mPullRoot.removeView(this.dgO);
        }
        if (aGp()) {
            if (this.mPullImage != null && this.dgM != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.dgM.getVisibility() != 0) {
                    this.dgM.setVisibility(0);
                }
                if (this.dgM.isAnimating()) {
                    this.dgM.cancelAnimation();
                }
                this.dgM.setMinAndMaxProgress(0.0f, 1.0f);
                this.dgM.setFrame(0);
            }
        } else if (this.mPullImage != null && this.dgM != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.dgM.getVisibility() != 8) {
                this.dgM.setVisibility(8);
            }
        }
    }

    private void aHS() {
        if (aGp() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean aHT() {
        return this.dgN;
    }

    public void a(f fVar) {
        this.dgP = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.dgR = z;
    }

    public boolean aHU() {
        if (aHT() && this.dgR && this.dgQ != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.dgM.setVisibility(8);
            if (this.dgO == null) {
                this.dgO = new SmartBubbleAnimatedView(getContext());
                this.dgO.setExtrusionRemind(true);
            }
            this.dgO.dgX = this.dgQ.getTipText();
            this.dgO.gsu = this.dgQ.aHY();
            if (this.dgO.getParent() != null) {
                this.mPullRoot.removeView(this.dgO);
            }
            this.mPullRoot.addView(this.dgO);
            this.dgO.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.g.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void aHW() {
                    if (g.this.dgP != null) {
                        g.this.dgP.onAnimationEnd();
                    }
                }
            });
            if (this.dgP != null) {
                this.dgP.lm(this.dgO.getTipViewHeight());
            }
            this.dgO.bFQ();
            return true;
        }
        return false;
    }

    public void aHV() {
        if (this.mPullRoot != null && this.dgO != null && this.dgO.getParent() != null) {
            this.mPullRoot.removeView(this.dgO);
        }
    }

    public void ll(int i) {
        if (this.dgM != null) {
            am.a(this.dgM, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dgU = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String dgX;
        private int dgY;

        public e(String str, int i) {
            this.dgX = str;
            this.dgY = i;
        }

        public String getTipText() {
            return this.dgX;
        }

        public int aHY() {
            return this.dgY;
        }
    }
}
