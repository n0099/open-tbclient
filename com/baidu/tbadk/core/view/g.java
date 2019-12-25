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
    private e dcA;
    private boolean dcB;
    private boolean dcC;
    private boolean dcD;
    private View.OnClickListener dcE;
    private final Animator.AnimatorListener dcF;
    private c dcr;
    private b dcs;
    private d dct;
    private a dcv;
    protected ContinuousAnimationView dcw;
    private boolean dcx;
    private SmartBubbleAnimatedView dcy;
    private f dcz;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void aFn();
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
        void kV(int i);

        void onAnimationEnd();
    }

    public g(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.dcr = null;
        this.dcs = null;
        this.dct = null;
        this.dcv = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.dcx = false;
        this.dcB = true;
        this.dcC = true;
        this.dcD = false;
        this.dcE = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.dcE != null) {
                    g.this.dcE.onClick(view);
                }
            }
        };
        this.dcF = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.g.3
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
                if (!g.this.dcD) {
                    g.this.dcD = true;
                    g.this.dcw.setSpeed(1.0f);
                    g.this.dcw.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.dcw = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        am.a(this.dcw, R.raw.lottie_common_pull_refresh);
        this.dcw.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!aDK()) {
            this.mAnimImage = af.aDJ().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!aDK() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        if (this.dct != null) {
            this.dct.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!aDK() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f2, float f3) {
        super.onPullPercentChange(f2, f3);
        if (aDK()) {
            this.dcw.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (aDK()) {
            if (!jX()) {
                aFf();
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

    private void aFf() {
        if (this.dcw != null) {
            if (this.dcw.isAnimating()) {
                this.dcw.cancelAnimation();
            }
            this.dcD = false;
            this.dcw.loop(true);
            this.dcw.setMinAndMaxProgress(0.0f, 0.738f);
            this.dcw.setSpeed(1.5f);
            this.dcw.setRepeatMode(1);
            this.dcw.removeAllAnimatorListeners();
            this.dcw.addAnimatorListener(this.dcF);
            this.dcw.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.dcC = true;
        if (aDK() && this.dcw.isAnimating()) {
            this.dcw.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        aFi();
        if (this.dcs != null) {
            this.dcs.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!jX()) {
            if (this.dcr != null && this.dcC) {
                this.dcr.onListPullRefresh(z);
            }
            this.dcC = true;
        }
    }

    public void aFg() {
        this.dcC = false;
    }

    public void a(e eVar) {
        this.dcA = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!jX()) {
            if (this.dcv != null) {
                this.dcv.aFn();
            }
            if (!aFk()) {
                aFh();
            } else if (this.dcw != null && this.dcw.isAnimating()) {
                this.dcw.cancelAnimation();
            }
        }
    }

    private void aFh() {
        if (aDK() && this.dcw != null) {
            if (this.dcw.isAnimating()) {
                this.dcw.cancelAnimation();
            }
            this.dcw.loop(false);
            this.dcw.setSpeed(1.0f);
            this.dcw.setMinAndMaxProgress(0.738f, 1.0f);
            this.dcw.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.dcr = cVar;
    }

    public void a(b bVar) {
        this.dcs = bVar;
    }

    public void a(d dVar) {
        this.dct = dVar;
    }

    public void a(a aVar) {
        this.dcv = aVar;
    }

    public void changeSkin(int i) {
        if (aDK()) {
            am.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.dcw != null && !this.dcw.isAnimating()) {
                this.mSkinType = i;
                am.a(this.dcw, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.dcy != null) {
            this.dcy.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aDK() {
        return af.aDJ().aDK();
    }

    private void initPullView() {
        if (this.dcy != null && this.dcy.getParent() != null) {
            this.mPullRoot.removeView(this.dcy);
        }
        if (aDK()) {
            if (this.mPullImage != null && this.dcw != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.dcw.getVisibility() != 0) {
                    this.dcw.setVisibility(0);
                }
                if (this.dcw.isAnimating()) {
                    this.dcw.cancelAnimation();
                }
                this.dcw.setMinAndMaxProgress(0.0f, 1.0f);
                this.dcw.setFrame(0);
            }
        } else if (this.mPullImage != null && this.dcw != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.dcw.getVisibility() != 8) {
                this.dcw.setVisibility(8);
            }
        }
    }

    private void aFi() {
        if (aDK() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean aFj() {
        return this.dcx;
    }

    public void a(f fVar) {
        this.dcz = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.dcB = z;
    }

    public boolean aFk() {
        if (aFj() && this.dcB && this.dcA != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.dcw.setVisibility(8);
            if (this.dcy == null) {
                this.dcy = new SmartBubbleAnimatedView(getContext());
                this.dcy.setExtrusionRemind(true);
            }
            this.dcy.dcH = this.dcA.getTipText();
            this.dcy.gni = this.dcA.aFo();
            if (this.dcy.getParent() != null) {
                this.mPullRoot.removeView(this.dcy);
            }
            this.mPullRoot.addView(this.dcy);
            this.dcy.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.g.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void aFm() {
                    if (g.this.dcz != null) {
                        g.this.dcz.onAnimationEnd();
                    }
                }
            });
            if (this.dcz != null) {
                this.dcz.kV(this.dcy.getTipViewHeight());
            }
            this.dcy.bDk();
            return true;
        }
        return false;
    }

    public void aFl() {
        if (this.mPullRoot != null && this.dcy != null && this.dcy.getParent() != null) {
            this.mPullRoot.removeView(this.dcy);
        }
    }

    public void kU(int i) {
        if (this.dcw != null) {
            am.a(this.dcw, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dcE = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String dcH;
        private int dcI;

        public e(String str, int i) {
            this.dcH = str;
            this.dcI = i;
        }

        public String getTipText() {
            return this.dcH;
        }

        public int aFo() {
            return this.dcI;
        }
    }
}
