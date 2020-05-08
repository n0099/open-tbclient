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
    private c dHh;
    private b dHi;
    private d dHj;
    private a dHk;
    protected ContinuousAnimationView dHl;
    private boolean dHm;
    private SmartBubbleAnimatedView dHn;
    private f dHo;
    private e dHp;
    private boolean dHq;
    private boolean dHr;
    private boolean dHs;
    private View.OnClickListener dHt;
    private final Animator.AnimatorListener dHu;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void aQv();
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
        this.dHh = null;
        this.dHi = null;
        this.dHj = null;
        this.dHk = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.dHm = false;
        this.dHq = true;
        this.dHr = true;
        this.dHs = false;
        this.dHt = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.dHt != null) {
                    g.this.dHt.onClick(view);
                }
            }
        };
        this.dHu = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.g.3
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
                if (!g.this.dHs) {
                    g.this.dHs = true;
                    g.this.dHl.setSpeed(1.0f);
                    g.this.dHl.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.dHl = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        am.a(this.dHl, R.raw.lottie_common_pull_refresh);
        this.dHl.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!aOF()) {
            this.mAnimImage = af.aOE().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!aOF() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        if (this.dHj != null) {
            this.dHj.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!aOF() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f2, float f3) {
        super.onPullPercentChange(f2, f3);
        if (aOF()) {
            this.dHl.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (aOF()) {
            if (!oP()) {
                aQo();
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

    private void aQo() {
        if (this.dHl != null) {
            if (this.dHl.isAnimating()) {
                this.dHl.cancelAnimation();
            }
            this.dHs = false;
            this.dHl.loop(true);
            this.dHl.setMinAndMaxProgress(0.0f, 0.738f);
            this.dHl.setSpeed(1.5f);
            this.dHl.setRepeatMode(1);
            this.dHl.removeAllAnimatorListeners();
            this.dHl.addAnimatorListener(this.dHu);
            this.dHl.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.dHr = true;
        if (aOF() && this.dHl.isAnimating()) {
            this.dHl.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        aQq();
        if (this.dHi != null) {
            this.dHi.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!oP()) {
            if (this.dHh != null && this.dHr) {
                this.dHh.onListPullRefresh(z);
            }
            this.dHr = true;
        }
    }

    public void a(e eVar) {
        this.dHp = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!oP()) {
            if (this.dHk != null) {
                this.dHk.aQv();
            }
            if (!aQs()) {
                aQp();
            } else if (this.dHl != null && this.dHl.isAnimating()) {
                this.dHl.cancelAnimation();
            }
        }
    }

    private void aQp() {
        if (aOF() && this.dHl != null) {
            if (this.dHl.isAnimating()) {
                this.dHl.cancelAnimation();
            }
            this.dHl.loop(false);
            this.dHl.setSpeed(1.0f);
            this.dHl.setMinAndMaxProgress(0.738f, 1.0f);
            this.dHl.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.dHh = cVar;
    }

    public void a(b bVar) {
        this.dHi = bVar;
    }

    public void a(d dVar) {
        this.dHj = dVar;
    }

    public void a(a aVar) {
        this.dHk = aVar;
    }

    public void changeSkin(int i) {
        if (aOF()) {
            am.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.dHl != null && !this.dHl.isAnimating()) {
                this.mSkinType = i;
                am.a(this.dHl, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.dHn != null) {
            this.dHn.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aOF() {
        return af.aOE().aOF();
    }

    private void initPullView() {
        if (this.dHn != null && this.dHn.getParent() != null) {
            this.mPullRoot.removeView(this.dHn);
        }
        if (aOF()) {
            if (this.mPullImage != null && this.dHl != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.dHl.getVisibility() != 0) {
                    this.dHl.setVisibility(0);
                }
                if (this.dHl.isAnimating()) {
                    this.dHl.cancelAnimation();
                }
                this.dHl.setMinAndMaxProgress(0.0f, 1.0f);
                this.dHl.setFrame(0);
            }
        } else if (this.mPullImage != null && this.dHl != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.dHl.getVisibility() != 8) {
                this.dHl.setVisibility(8);
            }
        }
    }

    private void aQq() {
        if (aOF() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean aQr() {
        return this.dHm;
    }

    public void a(f fVar) {
        this.dHo = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.dHq = z;
    }

    public boolean aQs() {
        if (aQr() && this.dHq && this.dHp != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.dHl.setVisibility(8);
            if (this.dHn == null) {
                this.dHn = new SmartBubbleAnimatedView(getContext());
                this.dHn.setExtrusionRemind(true);
            }
            this.dHn.dHw = this.dHp.getTipText();
            this.dHn.hcC = this.dHp.aQw();
            if (this.dHn.getParent() != null) {
                this.mPullRoot.removeView(this.dHn);
            }
            this.mPullRoot.addView(this.dHn);
            this.dHn.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.g.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void aQu() {
                    if (g.this.dHo != null) {
                        g.this.dHo.onAnimationEnd();
                    }
                }
            });
            if (this.dHo != null) {
                this.dHo.ly(this.dHn.getTipViewHeight());
            }
            this.dHn.bQC();
            return true;
        }
        return false;
    }

    public void aQt() {
        if (this.mPullRoot != null && this.dHn != null && this.dHn.getParent() != null) {
            this.mPullRoot.removeView(this.dHn);
        }
    }

    public void lx(int i) {
        if (this.dHl != null) {
            am.a(this.dHl, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dHt = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String dHw;
        private int dHx;

        public e(String str, int i) {
            this.dHw = str;
            this.dHx = i;
        }

        public String getTipText() {
            return this.dHw;
        }

        public int aQw() {
            return this.dHx;
        }
    }
}
