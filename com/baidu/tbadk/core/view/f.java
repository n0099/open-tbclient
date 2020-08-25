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
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.d {
    private c esW;
    private b esX;
    private d esY;
    private a esZ;
    protected ContinuousAnimationView eta;
    private boolean etb;
    private SmartBubbleAnimatedView etd;
    private InterfaceC0543f ete;
    private e etf;
    private boolean etg;
    private boolean eth;
    private boolean eti;
    private View.OnClickListener etj;
    private final Animator.AnimatorListener etk;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void bkO();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onListPullRefreshFinished(View view, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onListPullToRefresh(boolean z);
    }

    /* renamed from: com.baidu.tbadk.core.view.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0543f {
        void oR(int i);

        void onAnimationEnd();
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.esW = null;
        this.esX = null;
        this.esY = null;
        this.esZ = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.etb = false;
        this.etg = true;
        this.eth = true;
        this.eti = false;
        this.etj = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.etj != null) {
                    f.this.etj.onClick(view);
                }
            }
        };
        this.etk = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.f.3
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
                if (!f.this.eti) {
                    f.this.eti = true;
                    f.this.eta.setSpeed(1.0f);
                    f.this.eta.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.eta = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        ap.a(this.eta, R.raw.lottie_common_pull_refresh);
        this.eta.setOnClickListener(this.mClickListener);
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
        if (this.esY != null) {
            this.esY.onListPullToRefresh(z);
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
            this.eta.setAlpha(f);
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
        if (this.eta != null) {
            if (this.eta.isAnimating()) {
                this.eta.cancelAnimation();
            }
            this.eti = false;
            this.eta.loop(true);
            this.eta.setMinAndMaxProgress(0.0f, 0.738f);
            this.eta.setSpeed(1.5f);
            this.eta.setRepeatMode(1);
            this.eta.removeAllAnimatorListeners();
            this.eta.addAnimatorListener(this.etk);
            this.eta.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.eth = true;
        if (bjc() && this.eta.isAnimating()) {
            this.eta.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        bkJ();
        if (this.esX != null) {
            this.esX.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (!qL()) {
            if (this.esW != null && this.eth) {
                this.esW.onListPullRefresh(z);
            }
            this.eth = true;
        }
    }

    public void a(e eVar) {
        this.etf = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        if (!qL()) {
            if (this.esZ != null) {
                this.esZ.bkO();
            }
            if (!bkL()) {
                bkI();
            } else if (this.eta != null && this.eta.isAnimating()) {
                this.eta.cancelAnimation();
            }
        }
    }

    private void bkI() {
        if (bjc() && this.eta != null) {
            if (this.eta.isAnimating()) {
                this.eta.cancelAnimation();
            }
            this.eta.loop(false);
            this.eta.setSpeed(1.0f);
            this.eta.setMinAndMaxProgress(0.738f, 1.0f);
            this.eta.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.esW = cVar;
    }

    public void a(b bVar) {
        this.esX = bVar;
    }

    public void a(d dVar) {
        this.esY = dVar;
    }

    public void a(a aVar) {
        this.esZ = aVar;
    }

    public void changeSkin(int i) {
        if (bjc()) {
            ap.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.eta != null && !this.eta.isAnimating()) {
                this.mSkinType = i;
                ap.a(this.eta, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.etd != null) {
            this.etd.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bjc() {
        return ai.bjb().bjc();
    }

    private void initPullView() {
        if (this.etd != null && this.etd.getParent() != null) {
            this.mPullRoot.removeView(this.etd);
        }
        if (bjc()) {
            if (this.mPullImage != null && this.eta != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.eta.getVisibility() != 0) {
                    this.eta.setVisibility(0);
                }
                if (this.eta.isAnimating()) {
                    this.eta.cancelAnimation();
                }
                this.eta.setMinAndMaxProgress(0.0f, 1.0f);
                this.eta.setFrame(0);
            }
        } else if (this.mPullImage != null && this.eta != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.eta.getVisibility() != 8) {
                this.eta.setVisibility(8);
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
        return this.etb;
    }

    public void a(InterfaceC0543f interfaceC0543f) {
        this.ete = interfaceC0543f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.etg = z;
    }

    public boolean bkL() {
        if (bkK() && this.etg && this.etf != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.eta.setVisibility(8);
            if (this.etd == null) {
                this.etd = new SmartBubbleAnimatedView(getContext());
                this.etd.setExtrusionRemind(true);
            }
            this.etd.etm = this.etf.getTipText();
            this.etd.hXP = this.etf.bkP();
            if (this.etd.getParent() != null) {
                this.mPullRoot.removeView(this.etd);
            }
            this.mPullRoot.addView(this.etd);
            this.etd.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void bkN() {
                    if (f.this.ete != null) {
                        f.this.ete.onAnimationEnd();
                    }
                }
            });
            if (this.ete != null) {
                this.ete.oR(this.etd.getTipViewHeight());
            }
            this.etd.cok();
            return true;
        }
        return false;
    }

    public void bkM() {
        if (this.mPullRoot != null && this.etd != null && this.etd.getParent() != null) {
            this.mPullRoot.removeView(this.etd);
        }
    }

    public void oQ(int i) {
        if (this.eta != null) {
            ap.a(this.eta, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.etj = onClickListener;
    }

    /* loaded from: classes2.dex */
    public static class e {
        private String etm;
        private int etn;

        public e(String str, int i) {
            this.etm = str;
            this.etn = i;
        }

        public String getTipText() {
            return this.etm;
        }

        public int bkP() {
            return this.etn;
        }
    }
}
