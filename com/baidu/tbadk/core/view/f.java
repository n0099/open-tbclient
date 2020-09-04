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
    private c eta;
    private b etb;
    private d etd;
    private a ete;
    protected ContinuousAnimationView etf;
    private boolean etg;
    private SmartBubbleAnimatedView eth;
    private InterfaceC0543f eti;
    private e etj;
    private boolean etk;
    private boolean etl;
    private boolean etm;
    private View.OnClickListener etn;
    private final Animator.AnimatorListener eto;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void bkO();
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
    public interface InterfaceC0543f {
        void oR(int i);

        void onAnimationEnd();
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.eta = null;
        this.etb = null;
        this.etd = null;
        this.ete = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.etg = false;
        this.etk = true;
        this.etl = true;
        this.etm = false;
        this.etn = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.etn != null) {
                    f.this.etn.onClick(view);
                }
            }
        };
        this.eto = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.f.3
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
                if (!f.this.etm) {
                    f.this.etm = true;
                    f.this.etf.setSpeed(1.0f);
                    f.this.etf.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.etf = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        ap.a(this.etf, R.raw.lottie_common_pull_refresh);
        this.etf.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!bjc()) {
            this.mAnimImage = ai.bjb().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        if (!bjc() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        if (this.etd != null) {
            this.etd.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!bjc() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        super.onPullPercentChange(f, f2);
        if (bjc()) {
            this.etf.setAlpha(f);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        initPullView();
        if (bjc()) {
            if (!qL()) {
                bkH();
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

    private void bkH() {
        if (this.etf != null) {
            if (this.etf.isAnimating()) {
                this.etf.cancelAnimation();
            }
            this.etm = false;
            this.etf.loop(true);
            this.etf.setMinAndMaxProgress(0.0f, 0.738f);
            this.etf.setSpeed(1.5f);
            this.etf.setRepeatMode(1);
            this.etf.removeAllAnimatorListeners();
            this.etf.addAnimatorListener(this.eto);
            this.etf.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.etl = true;
        if (bjc() && this.etf.isAnimating()) {
            this.etf.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        bkJ();
        if (this.etb != null) {
            this.etb.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (!qL()) {
            if (this.eta != null && this.etl) {
                this.eta.onListPullRefresh(z);
            }
            this.etl = true;
        }
    }

    public void a(e eVar) {
        this.etj = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        if (!qL()) {
            if (this.ete != null) {
                this.ete.bkO();
            }
            if (!bkL()) {
                bkI();
            } else if (this.etf != null && this.etf.isAnimating()) {
                this.etf.cancelAnimation();
            }
        }
    }

    private void bkI() {
        if (bjc() && this.etf != null) {
            if (this.etf.isAnimating()) {
                this.etf.cancelAnimation();
            }
            this.etf.loop(false);
            this.etf.setSpeed(1.0f);
            this.etf.setMinAndMaxProgress(0.738f, 1.0f);
            this.etf.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.eta = cVar;
    }

    public void a(b bVar) {
        this.etb = bVar;
    }

    public void a(d dVar) {
        this.etd = dVar;
    }

    public void a(a aVar) {
        this.ete = aVar;
    }

    public void changeSkin(int i) {
        if (bjc()) {
            ap.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.etf != null && !this.etf.isAnimating()) {
                this.mSkinType = i;
                ap.a(this.etf, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.eth != null) {
            this.eth.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bjc() {
        return ai.bjb().bjc();
    }

    private void initPullView() {
        if (this.eth != null && this.eth.getParent() != null) {
            this.mPullRoot.removeView(this.eth);
        }
        if (bjc()) {
            if (this.mPullImage != null && this.etf != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.etf.getVisibility() != 0) {
                    this.etf.setVisibility(0);
                }
                if (this.etf.isAnimating()) {
                    this.etf.cancelAnimation();
                }
                this.etf.setMinAndMaxProgress(0.0f, 1.0f);
                this.etf.setFrame(0);
            }
        } else if (this.mPullImage != null && this.etf != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.etf.getVisibility() != 8) {
                this.etf.setVisibility(8);
            }
        }
    }

    private void bkJ() {
        if (bjc() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean bkK() {
        return this.etg;
    }

    public void a(InterfaceC0543f interfaceC0543f) {
        this.eti = interfaceC0543f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.etk = z;
    }

    public boolean bkL() {
        if (bkK() && this.etk && this.etj != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.etf.setVisibility(8);
            if (this.eth == null) {
                this.eth = new SmartBubbleAnimatedView(getContext());
                this.eth.setExtrusionRemind(true);
            }
            this.eth.etq = this.etj.getTipText();
            this.eth.hXV = this.etj.bkP();
            if (this.eth.getParent() != null) {
                this.mPullRoot.removeView(this.eth);
            }
            this.mPullRoot.addView(this.eth);
            this.eth.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void bkN() {
                    if (f.this.eti != null) {
                        f.this.eti.onAnimationEnd();
                    }
                }
            });
            if (this.eti != null) {
                this.eti.oR(this.eth.getTipViewHeight());
            }
            this.eth.col();
            return true;
        }
        return false;
    }

    public void bkM() {
        if (this.mPullRoot != null && this.eth != null && this.eth.getParent() != null) {
            this.mPullRoot.removeView(this.eth);
        }
    }

    public void oQ(int i) {
        if (this.etf != null) {
            ap.a(this.etf, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.etn = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String etq;
        private int etr;

        public e(String str, int i) {
            this.etq = str;
            this.etr = i;
        }

        public String getTipText() {
            return this.etq;
        }

        public int bkP() {
            return this.etr;
        }
    }
}
