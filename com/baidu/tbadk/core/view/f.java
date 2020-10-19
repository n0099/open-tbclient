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
    private boolean eHA;
    private View.OnClickListener eHB;
    private final Animator.AnimatorListener eHC;
    private c eHp;
    private b eHq;
    private d eHr;
    private a eHs;
    protected ContinuousAnimationView eHt;
    private boolean eHu;
    private SmartBubbleAnimatedView eHv;
    private InterfaceC0555f eHw;
    private e eHx;
    private boolean eHy;
    private boolean eHz;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void bot();
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
    public interface InterfaceC0555f {
        void onAnimationEnd();

        void pC(int i);
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.eHp = null;
        this.eHq = null;
        this.eHr = null;
        this.eHs = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.eHu = false;
        this.eHy = true;
        this.eHz = true;
        this.eHA = false;
        this.eHB = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eHB != null) {
                    f.this.eHB.onClick(view);
                }
            }
        };
        this.eHC = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.f.3
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
                if (!f.this.eHA) {
                    f.this.eHA = true;
                    f.this.eHt.setSpeed(1.0f);
                    f.this.eHt.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.eHt = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        ap.a(this.eHt, R.raw.lottie_common_pull_refresh);
        this.eHt.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!bmG()) {
            this.mAnimImage = ai.bmF().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        if (!bmG() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        if (this.eHr != null) {
            this.eHr.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!bmG() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        super.onPullPercentChange(f, f2);
        if (bmG()) {
            this.eHt.setAlpha(f);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        initPullView();
        if (bmG()) {
            if (!qQ()) {
                bom();
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

    private void bom() {
        if (this.eHt != null) {
            if (this.eHt.isAnimating()) {
                this.eHt.cancelAnimation();
            }
            this.eHA = false;
            this.eHt.loop(true);
            this.eHt.setMinAndMaxProgress(0.0f, 0.738f);
            this.eHt.setSpeed(1.5f);
            this.eHt.setRepeatMode(1);
            this.eHt.removeAllAnimatorListeners();
            this.eHt.addAnimatorListener(this.eHC);
            this.eHt.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.eHz = true;
        if (bmG() && this.eHt.isAnimating()) {
            this.eHt.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        boo();
        if (this.eHq != null) {
            this.eHq.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (!qQ()) {
            if (this.eHp != null && this.eHz) {
                this.eHp.onListPullRefresh(z);
            }
            this.eHz = true;
        }
    }

    public void a(e eVar) {
        this.eHx = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        if (!qQ()) {
            if (this.eHs != null) {
                this.eHs.bot();
            }
            if (!boq()) {
                bon();
            } else if (this.eHt != null && this.eHt.isAnimating()) {
                this.eHt.cancelAnimation();
            }
        }
    }

    private void bon() {
        if (bmG() && this.eHt != null) {
            if (this.eHt.isAnimating()) {
                this.eHt.cancelAnimation();
            }
            this.eHt.loop(false);
            this.eHt.setSpeed(1.0f);
            this.eHt.setMinAndMaxProgress(0.738f, 1.0f);
            this.eHt.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.eHp = cVar;
    }

    public void a(b bVar) {
        this.eHq = bVar;
    }

    public void a(d dVar) {
        this.eHr = dVar;
    }

    public void a(a aVar) {
        this.eHs = aVar;
    }

    public void changeSkin(int i) {
        if (bmG()) {
            ap.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.eHt != null && !this.eHt.isAnimating()) {
                this.mSkinType = i;
                ap.a(this.eHt, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.eHv != null) {
            this.eHv.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bmG() {
        return ai.bmF().bmG();
    }

    private void initPullView() {
        if (this.eHv != null && this.eHv.getParent() != null) {
            this.mPullRoot.removeView(this.eHv);
        }
        if (bmG()) {
            if (this.mPullImage != null && this.eHt != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.eHt.getVisibility() != 0) {
                    this.eHt.setVisibility(0);
                }
                if (this.eHt.isAnimating()) {
                    this.eHt.cancelAnimation();
                }
                this.eHt.setMinAndMaxProgress(0.0f, 1.0f);
                this.eHt.setFrame(0);
            }
        } else if (this.mPullImage != null && this.eHt != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.eHt.getVisibility() != 8) {
                this.eHt.setVisibility(8);
            }
        }
    }

    private void boo() {
        if (bmG() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean bop() {
        return this.eHu;
    }

    public void a(InterfaceC0555f interfaceC0555f) {
        this.eHw = interfaceC0555f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.eHy = z;
    }

    public boolean boq() {
        if (bop() && this.eHy && this.eHx != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.eHt.setVisibility(8);
            if (this.eHv == null) {
                this.eHv = new SmartBubbleAnimatedView(getContext());
                this.eHv.setExtrusionRemind(true);
            }
            this.eHv.eHE = this.eHx.getTipText();
            this.eHv.itW = this.eHx.bou();
            if (this.eHv.getParent() != null) {
                this.mPullRoot.removeView(this.eHv);
            }
            this.mPullRoot.addView(this.eHv);
            this.eHv.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void bos() {
                    if (f.this.eHw != null) {
                        f.this.eHw.onAnimationEnd();
                    }
                }
            });
            if (this.eHw != null) {
                this.eHw.pC(this.eHv.getTipViewHeight());
            }
            this.eHv.cuW();
            return true;
        }
        return false;
    }

    public void bor() {
        if (this.mPullRoot != null && this.eHv != null && this.eHv.getParent() != null) {
            this.mPullRoot.removeView(this.eHv);
        }
    }

    public void pB(int i) {
        if (this.eHt != null) {
            ap.a(this.eHt, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eHB = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String eHE;
        private int eHF;

        public e(String str, int i) {
            this.eHE = str;
            this.eHF = i;
        }

        public String getTipText() {
            return this.eHE;
        }

        public int bou() {
            return this.eHF;
        }
    }
}
