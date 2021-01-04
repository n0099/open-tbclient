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
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.c {
    private c flR;
    private b flS;
    private d flT;
    private a flU;
    protected ContinuousAnimationView flV;
    private boolean flW;
    private SmartBubbleAnimatedView flX;
    private InterfaceC0584f flY;
    private e flZ;
    private boolean fls;
    private boolean fma;
    private boolean fmb;
    private View.OnClickListener fmc;
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
        void bxX();
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
    public interface InterfaceC0584f {
        void onAnimationEnd();

        void ri(int i);
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.flR = null;
        this.flS = null;
        this.flT = null;
        this.flU = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.flW = false;
        this.fma = true;
        this.fmb = true;
        this.fls = false;
        this.fmc = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fmc != null) {
                    f.this.fmc.onClick(view);
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
                if (!f.this.fls) {
                    f.this.fls = true;
                    f.this.flV.setSpeed(1.0f);
                    f.this.flV.setMinAndMaxFrame(45, 105);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.flV = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        ao.a(this.flV, R.raw.lottie_common_pull_refresh);
        this.flV.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!bwb()) {
            this.mAnimImage = ah.bwa().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!bwb() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        if (this.flT != null) {
            this.flT.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!bwb() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        super.onPullPercentChange(f, f2);
        if (bwb()) {
            this.flV.setAlpha(f);
            this.flV.setFrame((int) Math.min(27.0f, ((f * 27.0f) * 5.0f) / 3.0f));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (bwb()) {
            if (!qu()) {
                bxQ();
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

    private void bxQ() {
        if (this.flV != null) {
            if (this.flV.isAnimating()) {
                this.flV.cancelAnimation();
            }
            this.fls = false;
            this.flV.loop(true);
            this.flV.setMinFrame(27);
            this.flV.setRepeatMode(1);
            this.flV.removeAllAnimatorListeners();
            this.flV.addAnimatorListener(this.loadViewAnimListener);
            this.flV.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.fmb = true;
        if (bwb() && this.flV.isAnimating()) {
            this.flV.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        bxS();
        if (this.flS != null) {
            this.flS.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!qu()) {
            if (this.flR != null && this.fmb) {
                this.flR.onListPullRefresh(z);
            }
            this.fmb = true;
        }
    }

    public void a(e eVar) {
        this.flZ = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!qu()) {
            if (this.flU != null) {
                this.flU.bxX();
            }
            if (!bxU()) {
                bxR();
            } else if (this.flV != null && this.flV.isAnimating()) {
                this.flV.cancelAnimation();
            }
        }
    }

    private void bxR() {
        if (bwb() && this.flV != null) {
            this.flV.loop(false);
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.flR = cVar;
    }

    public void a(b bVar) {
        this.flS = bVar;
    }

    public void a(d dVar) {
        this.flT = dVar;
    }

    public void a(a aVar) {
        this.flU = aVar;
    }

    public void changeSkin(int i) {
        if (bwb() && this.mSkinType != i && this.flV != null && !this.flV.isAnimating()) {
            this.mSkinType = i;
            ao.a(this.flV, R.raw.lottie_common_pull_refresh);
        }
        if (this.flX != null) {
            this.flX.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bwb() {
        return ah.bwa().bwb();
    }

    private void initPullView() {
        if (this.flX != null && this.flX.getParent() != null) {
            this.mPullRoot.removeView(this.flX);
        }
        if (bwb()) {
            if (this.mPullImage != null && this.flV != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.flV.getVisibility() != 0) {
                    this.flV.setVisibility(0);
                }
                if (this.flV.isAnimating()) {
                    this.flV.cancelAnimation();
                }
                this.flV.setMinAndMaxProgress(0.0f, 1.0f);
                this.flV.setFrame(0);
                this.flV.setSpeed(1.3f);
            }
        } else if (this.mPullImage != null && this.flV != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.flV.getVisibility() != 8) {
                this.flV.setVisibility(8);
            }
        }
    }

    private void bxS() {
        if (bwb() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean bxT() {
        return this.flW;
    }

    public void a(InterfaceC0584f interfaceC0584f) {
        this.flY = interfaceC0584f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.fma = z;
    }

    public boolean bxU() {
        if (bxT() && this.fma && this.flZ != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.flV.setVisibility(8);
            if (this.flX == null) {
                this.flX = new SmartBubbleAnimatedView(getContext());
                this.flX.setExtrusionRemind(true);
            }
            this.flX.fme = this.flZ.getTipText();
            this.flX.jki = this.flZ.bxY();
            if (this.flX.getParent() != null) {
                this.mPullRoot.removeView(this.flX);
            }
            this.mPullRoot.addView(this.flX);
            this.flX.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void bxW() {
                    if (f.this.flY != null) {
                        f.this.flY.onAnimationEnd();
                    }
                }
            });
            if (this.flY != null) {
                this.flY.ri(this.flX.getTipViewHeight());
            }
            this.flX.cHt();
            return true;
        }
        return false;
    }

    public void bxV() {
        if (this.mPullRoot != null && this.flX != null && this.flX.getParent() != null) {
            this.mPullRoot.removeView(this.flX);
        }
    }

    public void rh(int i) {
        if (this.flV != null) {
            ao.a(this.flV, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fmc = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String fme;
        private int fmf;

        public e(String str, int i) {
            this.fme = str;
            this.fmf = i;
        }

        public String getTipText() {
            return this.fme;
        }

        public int bxY() {
            return this.fmf;
        }
    }
}
