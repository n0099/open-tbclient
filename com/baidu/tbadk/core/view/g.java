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
    private c dgV;
    private b dgW;
    private d dgX;
    private a dgY;
    protected ContinuousAnimationView dgZ;
    private boolean dha;
    private SmartBubbleAnimatedView dhb;
    private f dhc;
    private e dhd;
    private boolean dhe;
    private boolean dhf;
    private boolean dhg;
    private View.OnClickListener dhh;
    private final Animator.AnimatorListener dhi;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void aHY();
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
        this.dgV = null;
        this.dgW = null;
        this.dgX = null;
        this.dgY = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.dha = false;
        this.dhe = true;
        this.dhf = true;
        this.dhg = false;
        this.dhh = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.dhh != null) {
                    g.this.dhh.onClick(view);
                }
            }
        };
        this.dhi = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.g.3
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
                if (!g.this.dhg) {
                    g.this.dhg = true;
                    g.this.dgZ.setSpeed(1.0f);
                    g.this.dgZ.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.dgZ = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        am.a(this.dgZ, R.raw.lottie_common_pull_refresh);
        this.dgZ.setOnClickListener(this.mClickListener);
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
        if (this.dgX != null) {
            this.dgX.onListPullToRefresh(z);
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
            this.dgZ.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (aGp()) {
            if (!kl()) {
                aHQ();
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

    private void aHQ() {
        if (this.dgZ != null) {
            if (this.dgZ.isAnimating()) {
                this.dgZ.cancelAnimation();
            }
            this.dhg = false;
            this.dgZ.loop(true);
            this.dgZ.setMinAndMaxProgress(0.0f, 0.738f);
            this.dgZ.setSpeed(1.5f);
            this.dgZ.setRepeatMode(1);
            this.dgZ.removeAllAnimatorListeners();
            this.dgZ.addAnimatorListener(this.dhi);
            this.dgZ.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.dhf = true;
        if (aGp() && this.dgZ.isAnimating()) {
            this.dgZ.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        aHT();
        if (this.dgW != null) {
            this.dgW.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!kl()) {
            if (this.dgV != null && this.dhf) {
                this.dgV.onListPullRefresh(z);
            }
            this.dhf = true;
        }
    }

    public void aHR() {
        this.dhf = false;
    }

    public void a(e eVar) {
        this.dhd = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!kl()) {
            if (this.dgY != null) {
                this.dgY.aHY();
            }
            if (!aHV()) {
                aHS();
            } else if (this.dgZ != null && this.dgZ.isAnimating()) {
                this.dgZ.cancelAnimation();
            }
        }
    }

    private void aHS() {
        if (aGp() && this.dgZ != null) {
            if (this.dgZ.isAnimating()) {
                this.dgZ.cancelAnimation();
            }
            this.dgZ.loop(false);
            this.dgZ.setSpeed(1.0f);
            this.dgZ.setMinAndMaxProgress(0.738f, 1.0f);
            this.dgZ.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.dgV = cVar;
    }

    public void a(b bVar) {
        this.dgW = bVar;
    }

    public void a(d dVar) {
        this.dgX = dVar;
    }

    public void a(a aVar) {
        this.dgY = aVar;
    }

    public void changeSkin(int i) {
        if (aGp()) {
            am.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.dgZ != null && !this.dgZ.isAnimating()) {
                this.mSkinType = i;
                am.a(this.dgZ, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.dhb != null) {
            this.dhb.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aGp() {
        return af.aGo().aGp();
    }

    private void initPullView() {
        if (this.dhb != null && this.dhb.getParent() != null) {
            this.mPullRoot.removeView(this.dhb);
        }
        if (aGp()) {
            if (this.mPullImage != null && this.dgZ != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.dgZ.getVisibility() != 0) {
                    this.dgZ.setVisibility(0);
                }
                if (this.dgZ.isAnimating()) {
                    this.dgZ.cancelAnimation();
                }
                this.dgZ.setMinAndMaxProgress(0.0f, 1.0f);
                this.dgZ.setFrame(0);
            }
        } else if (this.mPullImage != null && this.dgZ != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.dgZ.getVisibility() != 8) {
                this.dgZ.setVisibility(8);
            }
        }
    }

    private void aHT() {
        if (aGp() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean aHU() {
        return this.dha;
    }

    public void a(f fVar) {
        this.dhc = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.dhe = z;
    }

    public boolean aHV() {
        if (aHU() && this.dhe && this.dhd != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.dgZ.setVisibility(8);
            if (this.dhb == null) {
                this.dhb = new SmartBubbleAnimatedView(getContext());
                this.dhb.setExtrusionRemind(true);
            }
            this.dhb.dhk = this.dhd.getTipText();
            this.dhb.gsH = this.dhd.aHZ();
            if (this.dhb.getParent() != null) {
                this.mPullRoot.removeView(this.dhb);
            }
            this.mPullRoot.addView(this.dhb);
            this.dhb.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.g.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void aHX() {
                    if (g.this.dhc != null) {
                        g.this.dhc.onAnimationEnd();
                    }
                }
            });
            if (this.dhc != null) {
                this.dhc.lm(this.dhb.getTipViewHeight());
            }
            this.dhb.bFR();
            return true;
        }
        return false;
    }

    public void aHW() {
        if (this.mPullRoot != null && this.dhb != null && this.dhb.getParent() != null) {
            this.mPullRoot.removeView(this.dhb);
        }
    }

    public void ll(int i) {
        if (this.dgZ != null) {
            am.a(this.dgZ, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dhh = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String dhk;
        private int dhl;

        public e(String str, int i) {
            this.dhk = str;
            this.dhl = i;
        }

        public String getTipText() {
            return this.dhk;
        }

        public int aHZ() {
            return this.dhl;
        }
    }
}
