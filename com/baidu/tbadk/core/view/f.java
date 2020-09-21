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
    private c evf;
    private b evg;
    private d evh;
    private a evi;
    protected ContinuousAnimationView evj;
    private boolean evk;
    private SmartBubbleAnimatedView evl;
    private InterfaceC0538f evm;
    private e evn;
    private boolean evo;
    private boolean evp;
    private boolean evq;
    private View.OnClickListener evr;
    private final Animator.AnimatorListener evs;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void blJ();
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
    public interface InterfaceC0538f {
        void onAnimationEnd();

        void pd(int i);
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.evf = null;
        this.evg = null;
        this.evh = null;
        this.evi = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.evk = false;
        this.evo = true;
        this.evp = true;
        this.evq = false;
        this.evr = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.evr != null) {
                    f.this.evr.onClick(view);
                }
            }
        };
        this.evs = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.f.3
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
                if (!f.this.evq) {
                    f.this.evq = true;
                    f.this.evj.setSpeed(1.0f);
                    f.this.evj.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.evj = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        ap.a(this.evj, R.raw.lottie_common_pull_refresh);
        this.evj.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!bjX()) {
            this.mAnimImage = ai.bjW().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        if (!bjX() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        if (this.evh != null) {
            this.evh.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!bjX() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        super.onPullPercentChange(f, f2);
        if (bjX()) {
            this.evj.setAlpha(f);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        initPullView();
        if (bjX()) {
            if (!qQ()) {
                blC();
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

    private void blC() {
        if (this.evj != null) {
            if (this.evj.isAnimating()) {
                this.evj.cancelAnimation();
            }
            this.evq = false;
            this.evj.loop(true);
            this.evj.setMinAndMaxProgress(0.0f, 0.738f);
            this.evj.setSpeed(1.5f);
            this.evj.setRepeatMode(1);
            this.evj.removeAllAnimatorListeners();
            this.evj.addAnimatorListener(this.evs);
            this.evj.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.evp = true;
        if (bjX() && this.evj.isAnimating()) {
            this.evj.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        blE();
        if (this.evg != null) {
            this.evg.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (!qQ()) {
            if (this.evf != null && this.evp) {
                this.evf.onListPullRefresh(z);
            }
            this.evp = true;
        }
    }

    public void a(e eVar) {
        this.evn = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        if (!qQ()) {
            if (this.evi != null) {
                this.evi.blJ();
            }
            if (!blG()) {
                blD();
            } else if (this.evj != null && this.evj.isAnimating()) {
                this.evj.cancelAnimation();
            }
        }
    }

    private void blD() {
        if (bjX() && this.evj != null) {
            if (this.evj.isAnimating()) {
                this.evj.cancelAnimation();
            }
            this.evj.loop(false);
            this.evj.setSpeed(1.0f);
            this.evj.setMinAndMaxProgress(0.738f, 1.0f);
            this.evj.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.evf = cVar;
    }

    public void a(b bVar) {
        this.evg = bVar;
    }

    public void a(d dVar) {
        this.evh = dVar;
    }

    public void a(a aVar) {
        this.evi = aVar;
    }

    public void changeSkin(int i) {
        if (bjX()) {
            ap.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.evj != null && !this.evj.isAnimating()) {
                this.mSkinType = i;
                ap.a(this.evj, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.evl != null) {
            this.evl.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bjX() {
        return ai.bjW().bjX();
    }

    private void initPullView() {
        if (this.evl != null && this.evl.getParent() != null) {
            this.mPullRoot.removeView(this.evl);
        }
        if (bjX()) {
            if (this.mPullImage != null && this.evj != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.evj.getVisibility() != 0) {
                    this.evj.setVisibility(0);
                }
                if (this.evj.isAnimating()) {
                    this.evj.cancelAnimation();
                }
                this.evj.setMinAndMaxProgress(0.0f, 1.0f);
                this.evj.setFrame(0);
            }
        } else if (this.mPullImage != null && this.evj != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.evj.getVisibility() != 8) {
                this.evj.setVisibility(8);
            }
        }
    }

    private void blE() {
        if (bjX() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean blF() {
        return this.evk;
    }

    public void a(InterfaceC0538f interfaceC0538f) {
        this.evm = interfaceC0538f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.evo = z;
    }

    public boolean blG() {
        if (blF() && this.evo && this.evn != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.evj.setVisibility(8);
            if (this.evl == null) {
                this.evl = new SmartBubbleAnimatedView(getContext());
                this.evl.setExtrusionRemind(true);
            }
            this.evl.evu = this.evn.getTipText();
            this.evl.ieZ = this.evn.blK();
            if (this.evl.getParent() != null) {
                this.mPullRoot.removeView(this.evl);
            }
            this.mPullRoot.addView(this.evl);
            this.evl.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void blI() {
                    if (f.this.evm != null) {
                        f.this.evm.onAnimationEnd();
                    }
                }
            });
            if (this.evm != null) {
                this.evm.pd(this.evl.getTipViewHeight());
            }
            this.evl.cry();
            return true;
        }
        return false;
    }

    public void blH() {
        if (this.mPullRoot != null && this.evl != null && this.evl.getParent() != null) {
            this.mPullRoot.removeView(this.evl);
        }
    }

    public void pc(int i) {
        if (this.evj != null) {
            ap.a(this.evj, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.evr = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String evu;
        private int evv;

        public e(String str, int i) {
            this.evu = str;
            this.evv = i;
        }

        public String getTipText() {
            return this.evu;
        }

        public int blK() {
            return this.evv;
        }
    }
}
