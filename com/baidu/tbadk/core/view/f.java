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
public class f extends com.baidu.adp.widget.ListView.c {
    private b fjA;
    private d fjB;
    private a fjC;
    protected ContinuousAnimationView fjD;
    private boolean fjE;
    private SmartBubbleAnimatedView fjF;
    private InterfaceC0564f fjG;
    private e fjH;
    private boolean fjI;
    private boolean fjJ;
    private View.OnClickListener fjK;
    private boolean fja;
    private c fjz;
    private boolean isManualTrigger;
    private final Animator.AnimatorListener loadViewAnimListener;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void buy();
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
    public interface InterfaceC0564f {
        void onAnimationEnd();

        void pH(int i);
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.fjz = null;
        this.fjA = null;
        this.fjB = null;
        this.fjC = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.fjE = false;
        this.fjI = true;
        this.fjJ = true;
        this.fja = false;
        this.fjK = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fjK != null) {
                    f.this.fjK.onClick(view);
                }
            }
        };
        this.loadViewAnimListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.f.3
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
                if (!f.this.fja) {
                    f.this.fja = true;
                    f.this.fjD.setSpeed(1.0f);
                    f.this.fjD.setMinAndMaxFrame(45, 105);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.fjD = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        ap.a(this.fjD, R.raw.lottie_common_pull_refresh);
        this.fjD.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!bsC()) {
            this.mAnimImage = ai.bsB().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!bsC() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        if (this.fjB != null) {
            this.fjB.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!bsC() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        super.onPullPercentChange(f, f2);
        if (bsC()) {
            this.fjD.setAlpha(f);
            this.fjD.setFrame((int) Math.min(27.0f, ((f * 27.0f) * 5.0f) / 3.0f));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (bsC()) {
            if (!qs()) {
                bur();
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

    private void bur() {
        if (this.fjD != null) {
            if (this.fjD.isAnimating()) {
                this.fjD.cancelAnimation();
            }
            this.fja = false;
            this.fjD.loop(true);
            this.fjD.setMinFrame(27);
            this.fjD.setRepeatMode(1);
            this.fjD.removeAllAnimatorListeners();
            this.fjD.addAnimatorListener(this.loadViewAnimListener);
            this.fjD.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.fjJ = true;
        if (bsC() && this.fjD.isAnimating()) {
            this.fjD.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        but();
        if (this.fjA != null) {
            this.fjA.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!qs()) {
            if (this.fjz != null && this.fjJ) {
                this.fjz.onListPullRefresh(z);
            }
            this.fjJ = true;
        }
    }

    public void a(e eVar) {
        this.fjH = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!qs()) {
            if (this.fjC != null) {
                this.fjC.buy();
            }
            if (!buv()) {
                bus();
            } else if (this.fjD != null && this.fjD.isAnimating()) {
                this.fjD.cancelAnimation();
            }
        }
    }

    private void bus() {
        if (bsC() && this.fjD != null) {
            this.fjD.loop(false);
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.fjz = cVar;
    }

    public void a(b bVar) {
        this.fjA = bVar;
    }

    public void a(d dVar) {
        this.fjB = dVar;
    }

    public void a(a aVar) {
        this.fjC = aVar;
    }

    public void changeSkin(int i) {
        if (bsC() && this.mSkinType != i && this.fjD != null && !this.fjD.isAnimating()) {
            this.mSkinType = i;
            ap.a(this.fjD, R.raw.lottie_common_pull_refresh);
        }
        if (this.fjF != null) {
            this.fjF.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bsC() {
        return ai.bsB().bsC();
    }

    private void initPullView() {
        if (this.fjF != null && this.fjF.getParent() != null) {
            this.mPullRoot.removeView(this.fjF);
        }
        if (bsC()) {
            if (this.mPullImage != null && this.fjD != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.fjD.getVisibility() != 0) {
                    this.fjD.setVisibility(0);
                }
                if (this.fjD.isAnimating()) {
                    this.fjD.cancelAnimation();
                }
                this.fjD.setMinAndMaxProgress(0.0f, 1.0f);
                this.fjD.setFrame(0);
                this.fjD.setSpeed(1.3f);
            }
        } else if (this.mPullImage != null && this.fjD != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.fjD.getVisibility() != 8) {
                this.fjD.setVisibility(8);
            }
        }
    }

    private void but() {
        if (bsC() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean buu() {
        return this.fjE;
    }

    public void a(InterfaceC0564f interfaceC0564f) {
        this.fjG = interfaceC0564f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.fjI = z;
    }

    public boolean buv() {
        if (buu() && this.fjI && this.fjH != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.fjD.setVisibility(8);
            if (this.fjF == null) {
                this.fjF = new SmartBubbleAnimatedView(getContext());
                this.fjF.setExtrusionRemind(true);
            }
            this.fjF.fjM = this.fjH.getTipText();
            this.fjF.jlw = this.fjH.buz();
            if (this.fjF.getParent() != null) {
                this.mPullRoot.removeView(this.fjF);
            }
            this.mPullRoot.addView(this.fjF);
            this.fjF.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void bux() {
                    if (f.this.fjG != null) {
                        f.this.fjG.onAnimationEnd();
                    }
                }
            });
            if (this.fjG != null) {
                this.fjG.pH(this.fjF.getTipViewHeight());
            }
            this.fjF.cEV();
            return true;
        }
        return false;
    }

    public void buw() {
        if (this.mPullRoot != null && this.fjF != null && this.fjF.getParent() != null) {
            this.mPullRoot.removeView(this.fjF);
        }
    }

    public void pG(int i) {
        if (this.fjD != null) {
            ap.a(this.fjD, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fjK = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String fjM;
        private int fjN;

        public e(String str, int i) {
            this.fjM = str;
            this.fjN = i;
        }

        public String getTipText() {
            return this.fjM;
        }

        public int buz() {
            return this.fjN;
        }
    }
}
