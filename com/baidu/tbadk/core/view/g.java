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
    private c dHd;
    private b dHe;
    private d dHf;
    private a dHg;
    protected ContinuousAnimationView dHh;
    private boolean dHi;
    private SmartBubbleAnimatedView dHj;
    private f dHk;
    private e dHl;
    private boolean dHm;
    private boolean dHn;
    private boolean dHo;
    private View.OnClickListener dHp;
    private final Animator.AnimatorListener dHq;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void aQy();
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
        void ly(int i);

        void onAnimationEnd();
    }

    public g(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.dHd = null;
        this.dHe = null;
        this.dHf = null;
        this.dHg = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.dHi = false;
        this.dHm = true;
        this.dHn = true;
        this.dHo = false;
        this.dHp = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.dHp != null) {
                    g.this.dHp.onClick(view);
                }
            }
        };
        this.dHq = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.g.3
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
                if (!g.this.dHo) {
                    g.this.dHo = true;
                    g.this.dHh.setSpeed(1.0f);
                    g.this.dHh.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.dHh = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        am.a(this.dHh, R.raw.lottie_common_pull_refresh);
        this.dHh.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!aOH()) {
            this.mAnimImage = af.aOG().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!aOH() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        if (this.dHf != null) {
            this.dHf.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!aOH() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f2, float f3) {
        super.onPullPercentChange(f2, f3);
        if (aOH()) {
            this.dHh.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (aOH()) {
            if (!oP()) {
                aQr();
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

    private void aQr() {
        if (this.dHh != null) {
            if (this.dHh.isAnimating()) {
                this.dHh.cancelAnimation();
            }
            this.dHo = false;
            this.dHh.loop(true);
            this.dHh.setMinAndMaxProgress(0.0f, 0.738f);
            this.dHh.setSpeed(1.5f);
            this.dHh.setRepeatMode(1);
            this.dHh.removeAllAnimatorListeners();
            this.dHh.addAnimatorListener(this.dHq);
            this.dHh.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.dHn = true;
        if (aOH() && this.dHh.isAnimating()) {
            this.dHh.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        aQt();
        if (this.dHe != null) {
            this.dHe.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!oP()) {
            if (this.dHd != null && this.dHn) {
                this.dHd.onListPullRefresh(z);
            }
            this.dHn = true;
        }
    }

    public void a(e eVar) {
        this.dHl = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!oP()) {
            if (this.dHg != null) {
                this.dHg.aQy();
            }
            if (!aQv()) {
                aQs();
            } else if (this.dHh != null && this.dHh.isAnimating()) {
                this.dHh.cancelAnimation();
            }
        }
    }

    private void aQs() {
        if (aOH() && this.dHh != null) {
            if (this.dHh.isAnimating()) {
                this.dHh.cancelAnimation();
            }
            this.dHh.loop(false);
            this.dHh.setSpeed(1.0f);
            this.dHh.setMinAndMaxProgress(0.738f, 1.0f);
            this.dHh.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.dHd = cVar;
    }

    public void a(b bVar) {
        this.dHe = bVar;
    }

    public void a(d dVar) {
        this.dHf = dVar;
    }

    public void a(a aVar) {
        this.dHg = aVar;
    }

    public void changeSkin(int i) {
        if (aOH()) {
            am.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.dHh != null && !this.dHh.isAnimating()) {
                this.mSkinType = i;
                am.a(this.dHh, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.dHj != null) {
            this.dHj.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aOH() {
        return af.aOG().aOH();
    }

    private void initPullView() {
        if (this.dHj != null && this.dHj.getParent() != null) {
            this.mPullRoot.removeView(this.dHj);
        }
        if (aOH()) {
            if (this.mPullImage != null && this.dHh != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.dHh.getVisibility() != 0) {
                    this.dHh.setVisibility(0);
                }
                if (this.dHh.isAnimating()) {
                    this.dHh.cancelAnimation();
                }
                this.dHh.setMinAndMaxProgress(0.0f, 1.0f);
                this.dHh.setFrame(0);
            }
        } else if (this.mPullImage != null && this.dHh != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.dHh.getVisibility() != 8) {
                this.dHh.setVisibility(8);
            }
        }
    }

    private void aQt() {
        if (aOH() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean aQu() {
        return this.dHi;
    }

    public void a(f fVar) {
        this.dHk = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.dHm = z;
    }

    public boolean aQv() {
        if (aQu() && this.dHm && this.dHl != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.dHh.setVisibility(8);
            if (this.dHj == null) {
                this.dHj = new SmartBubbleAnimatedView(getContext());
                this.dHj.setExtrusionRemind(true);
            }
            this.dHj.dHs = this.dHl.getTipText();
            this.dHj.hcw = this.dHl.aQz();
            if (this.dHj.getParent() != null) {
                this.mPullRoot.removeView(this.dHj);
            }
            this.mPullRoot.addView(this.dHj);
            this.dHj.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.g.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void aQx() {
                    if (g.this.dHk != null) {
                        g.this.dHk.onAnimationEnd();
                    }
                }
            });
            if (this.dHk != null) {
                this.dHk.ly(this.dHj.getTipViewHeight());
            }
            this.dHj.bQE();
            return true;
        }
        return false;
    }

    public void aQw() {
        if (this.mPullRoot != null && this.dHj != null && this.dHj.getParent() != null) {
            this.mPullRoot.removeView(this.dHj);
        }
    }

    public void lx(int i) {
        if (this.dHh != null) {
            am.a(this.dHh, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dHp = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String dHs;
        private int dHt;

        public e(String str, int i) {
            this.dHs = str;
            this.dHt = i;
        }

        public String getTipText() {
            return this.dHs;
        }

        public int aQz() {
            return this.dHt;
        }
    }
}
