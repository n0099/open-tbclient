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
    private c ePL;
    private b ePM;
    private d ePN;
    private a ePO;
    protected ContinuousAnimationView ePP;
    private boolean ePQ;
    private SmartBubbleAnimatedView ePR;
    private InterfaceC0569f ePS;
    private e ePT;
    private boolean ePU;
    private boolean ePV;
    private boolean ePW;
    private View.OnClickListener ePX;
    private final Animator.AnimatorListener ePY;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void bqm();
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
    public interface InterfaceC0569f {
        void onAnimationEnd();

        void pN(int i);
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.ePL = null;
        this.ePM = null;
        this.ePN = null;
        this.ePO = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.ePQ = false;
        this.ePU = true;
        this.ePV = true;
        this.ePW = false;
        this.ePX = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ePX != null) {
                    f.this.ePX.onClick(view);
                }
            }
        };
        this.ePY = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.f.3
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
                if (!f.this.ePW) {
                    f.this.ePW = true;
                    f.this.ePP.setSpeed(1.0f);
                    f.this.ePP.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.ePP = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        ap.a(this.ePP, R.raw.lottie_common_pull_refresh);
        this.ePP.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!boz()) {
            this.mAnimImage = ai.boy().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        if (!boz() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        if (this.ePN != null) {
            this.ePN.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!boz() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        super.onPullPercentChange(f, f2);
        if (boz()) {
            this.ePP.setAlpha(f);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        initPullView();
        if (boz()) {
            if (!qQ()) {
                bqf();
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

    private void bqf() {
        if (this.ePP != null) {
            if (this.ePP.isAnimating()) {
                this.ePP.cancelAnimation();
            }
            this.ePW = false;
            this.ePP.loop(true);
            this.ePP.setMinAndMaxProgress(0.0f, 0.738f);
            this.ePP.setSpeed(1.5f);
            this.ePP.setRepeatMode(1);
            this.ePP.removeAllAnimatorListeners();
            this.ePP.addAnimatorListener(this.ePY);
            this.ePP.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.ePV = true;
        if (boz() && this.ePP.isAnimating()) {
            this.ePP.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        bqh();
        if (this.ePM != null) {
            this.ePM.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (!qQ()) {
            if (this.ePL != null && this.ePV) {
                this.ePL.onListPullRefresh(z);
            }
            this.ePV = true;
        }
    }

    public void a(e eVar) {
        this.ePT = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        if (!qQ()) {
            if (this.ePO != null) {
                this.ePO.bqm();
            }
            if (!bqj()) {
                bqg();
            } else if (this.ePP != null && this.ePP.isAnimating()) {
                this.ePP.cancelAnimation();
            }
        }
    }

    private void bqg() {
        if (boz() && this.ePP != null) {
            if (this.ePP.isAnimating()) {
                this.ePP.cancelAnimation();
            }
            this.ePP.loop(false);
            this.ePP.setSpeed(1.0f);
            this.ePP.setMinAndMaxProgress(0.738f, 1.0f);
            this.ePP.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.ePL = cVar;
    }

    public void a(b bVar) {
        this.ePM = bVar;
    }

    public void a(d dVar) {
        this.ePN = dVar;
    }

    public void a(a aVar) {
        this.ePO = aVar;
    }

    public void changeSkin(int i) {
        if (boz()) {
            ap.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.ePP != null && !this.ePP.isAnimating()) {
                this.mSkinType = i;
                ap.a(this.ePP, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.ePR != null) {
            this.ePR.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean boz() {
        return ai.boy().boz();
    }

    private void initPullView() {
        if (this.ePR != null && this.ePR.getParent() != null) {
            this.mPullRoot.removeView(this.ePR);
        }
        if (boz()) {
            if (this.mPullImage != null && this.ePP != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.ePP.getVisibility() != 0) {
                    this.ePP.setVisibility(0);
                }
                if (this.ePP.isAnimating()) {
                    this.ePP.cancelAnimation();
                }
                this.ePP.setMinAndMaxProgress(0.0f, 1.0f);
                this.ePP.setFrame(0);
            }
        } else if (this.mPullImage != null && this.ePP != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.ePP.getVisibility() != 8) {
                this.ePP.setVisibility(8);
            }
        }
    }

    private void bqh() {
        if (boz() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean bqi() {
        return this.ePQ;
    }

    public void a(InterfaceC0569f interfaceC0569f) {
        this.ePS = interfaceC0569f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.ePU = z;
    }

    public boolean bqj() {
        if (bqi() && this.ePU && this.ePT != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.ePP.setVisibility(8);
            if (this.ePR == null) {
                this.ePR = new SmartBubbleAnimatedView(getContext());
                this.ePR.setExtrusionRemind(true);
            }
            this.ePR.eQa = this.ePT.getTipText();
            this.ePR.iGs = this.ePT.bqn();
            if (this.ePR.getParent() != null) {
                this.mPullRoot.removeView(this.ePR);
            }
            this.mPullRoot.addView(this.ePR);
            this.ePR.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void bql() {
                    if (f.this.ePS != null) {
                        f.this.ePS.onAnimationEnd();
                    }
                }
            });
            if (this.ePS != null) {
                this.ePS.pN(this.ePR.getTipViewHeight());
            }
            this.ePR.cyd();
            return true;
        }
        return false;
    }

    public void bqk() {
        if (this.mPullRoot != null && this.ePR != null && this.ePR.getParent() != null) {
            this.mPullRoot.removeView(this.ePR);
        }
    }

    public void pM(int i) {
        if (this.ePP != null) {
            ap.a(this.ePP, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ePX = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String eQa;
        private int eQb;

        public e(String str, int i) {
            this.eQa = str;
            this.eQb = i;
        }

        public String getTipText() {
            return this.eQa;
        }

        public int bqn() {
            return this.eQb;
        }
    }
}
