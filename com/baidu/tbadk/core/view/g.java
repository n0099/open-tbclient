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
    private c dhi;
    private b dhj;
    private d dhk;
    private a dhl;
    protected ContinuousAnimationView dhm;
    private boolean dhn;
    private SmartBubbleAnimatedView dho;
    private f dhp;
    private e dhq;
    private boolean dhr;
    private boolean dhs;
    private boolean dht;
    private View.OnClickListener dhu;
    private final Animator.AnimatorListener dhv;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void aIc();
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
        this.dhi = null;
        this.dhj = null;
        this.dhk = null;
        this.dhl = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.dhn = false;
        this.dhr = true;
        this.dhs = true;
        this.dht = false;
        this.dhu = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.dhu != null) {
                    g.this.dhu.onClick(view);
                }
            }
        };
        this.dhv = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.g.3
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
                if (!g.this.dht) {
                    g.this.dht = true;
                    g.this.dhm.setSpeed(1.0f);
                    g.this.dhm.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.dhm = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        am.a(this.dhm, R.raw.lottie_common_pull_refresh);
        this.dhm.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!aGt()) {
            this.mAnimImage = af.aGs().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!aGt() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        if (this.dhk != null) {
            this.dhk.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!aGt() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f2, float f3) {
        super.onPullPercentChange(f2, f3);
        if (aGt()) {
            this.dhm.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (aGt()) {
            if (!kl()) {
                aHU();
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

    private void aHU() {
        if (this.dhm != null) {
            if (this.dhm.isAnimating()) {
                this.dhm.cancelAnimation();
            }
            this.dht = false;
            this.dhm.loop(true);
            this.dhm.setMinAndMaxProgress(0.0f, 0.738f);
            this.dhm.setSpeed(1.5f);
            this.dhm.setRepeatMode(1);
            this.dhm.removeAllAnimatorListeners();
            this.dhm.addAnimatorListener(this.dhv);
            this.dhm.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.dhs = true;
        if (aGt() && this.dhm.isAnimating()) {
            this.dhm.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        aHX();
        if (this.dhj != null) {
            this.dhj.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!kl()) {
            if (this.dhi != null && this.dhs) {
                this.dhi.onListPullRefresh(z);
            }
            this.dhs = true;
        }
    }

    public void aHV() {
        this.dhs = false;
    }

    public void a(e eVar) {
        this.dhq = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!kl()) {
            if (this.dhl != null) {
                this.dhl.aIc();
            }
            if (!aHZ()) {
                aHW();
            } else if (this.dhm != null && this.dhm.isAnimating()) {
                this.dhm.cancelAnimation();
            }
        }
    }

    private void aHW() {
        if (aGt() && this.dhm != null) {
            if (this.dhm.isAnimating()) {
                this.dhm.cancelAnimation();
            }
            this.dhm.loop(false);
            this.dhm.setSpeed(1.0f);
            this.dhm.setMinAndMaxProgress(0.738f, 1.0f);
            this.dhm.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.dhi = cVar;
    }

    public void a(b bVar) {
        this.dhj = bVar;
    }

    public void a(d dVar) {
        this.dhk = dVar;
    }

    public void a(a aVar) {
        this.dhl = aVar;
    }

    public void changeSkin(int i) {
        if (aGt()) {
            am.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.dhm != null && !this.dhm.isAnimating()) {
                this.mSkinType = i;
                am.a(this.dhm, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.dho != null) {
            this.dho.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aGt() {
        return af.aGs().aGt();
    }

    private void initPullView() {
        if (this.dho != null && this.dho.getParent() != null) {
            this.mPullRoot.removeView(this.dho);
        }
        if (aGt()) {
            if (this.mPullImage != null && this.dhm != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.dhm.getVisibility() != 0) {
                    this.dhm.setVisibility(0);
                }
                if (this.dhm.isAnimating()) {
                    this.dhm.cancelAnimation();
                }
                this.dhm.setMinAndMaxProgress(0.0f, 1.0f);
                this.dhm.setFrame(0);
            }
        } else if (this.mPullImage != null && this.dhm != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.dhm.getVisibility() != 8) {
                this.dhm.setVisibility(8);
            }
        }
    }

    private void aHX() {
        if (aGt() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean aHY() {
        return this.dhn;
    }

    public void a(f fVar) {
        this.dhp = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.dhr = z;
    }

    public boolean aHZ() {
        if (aHY() && this.dhr && this.dhq != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.dhm.setVisibility(8);
            if (this.dho == null) {
                this.dho = new SmartBubbleAnimatedView(getContext());
                this.dho.setExtrusionRemind(true);
            }
            this.dho.dhx = this.dhq.getTipText();
            this.dho.gtl = this.dhq.aId();
            if (this.dho.getParent() != null) {
                this.mPullRoot.removeView(this.dho);
            }
            this.mPullRoot.addView(this.dho);
            this.dho.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.g.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void aIb() {
                    if (g.this.dhp != null) {
                        g.this.dhp.onAnimationEnd();
                    }
                }
            });
            if (this.dhp != null) {
                this.dhp.lm(this.dho.getTipViewHeight());
            }
            this.dho.bGc();
            return true;
        }
        return false;
    }

    public void aIa() {
        if (this.mPullRoot != null && this.dho != null && this.dho.getParent() != null) {
            this.mPullRoot.removeView(this.dho);
        }
    }

    public void ll(int i) {
        if (this.dhm != null) {
            am.a(this.dhm, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dhu = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String dhx;
        private int dhy;

        public e(String str, int i) {
            this.dhx = str;
            this.dhy = i;
        }

        public String getTipText() {
            return this.dhx;
        }

        public int aId() {
            return this.dhy;
        }
    }
}
