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
    private c fkY;
    private b fkZ;
    private boolean fkz;
    private d fla;
    private a flb;
    protected ContinuousAnimationView flc;
    private boolean fld;
    private SmartBubbleAnimatedView fle;
    private InterfaceC0570f flf;
    private e flg;
    private boolean flh;
    private boolean fli;
    private View.OnClickListener flj;
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
        void buB();
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
    public interface InterfaceC0570f {
        void onAnimationEnd();

        void pI(int i);
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.fkY = null;
        this.fkZ = null;
        this.fla = null;
        this.flb = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.fld = false;
        this.flh = true;
        this.fli = true;
        this.fkz = false;
        this.flj = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.flj != null) {
                    f.this.flj.onClick(view);
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
                if (!f.this.fkz) {
                    f.this.fkz = true;
                    f.this.flc.setSpeed(1.0f);
                    f.this.flc.setMinAndMaxFrame(45, 105);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.flc = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        ap.a(this.flc, R.raw.lottie_common_pull_refresh);
        this.flc.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!bsF()) {
            this.mAnimImage = ai.bsE().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!bsF() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        if (this.fla != null) {
            this.fla.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!bsF() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        super.onPullPercentChange(f, f2);
        if (bsF()) {
            this.flc.setAlpha(f);
            this.flc.setFrame((int) Math.min(27.0f, ((f * 27.0f) * 5.0f) / 3.0f));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (bsF()) {
            if (!qs()) {
                buu();
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

    private void buu() {
        if (this.flc != null) {
            if (this.flc.isAnimating()) {
                this.flc.cancelAnimation();
            }
            this.fkz = false;
            this.flc.loop(true);
            this.flc.setMinFrame(27);
            this.flc.setRepeatMode(1);
            this.flc.removeAllAnimatorListeners();
            this.flc.addAnimatorListener(this.loadViewAnimListener);
            this.flc.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.fli = true;
        if (bsF() && this.flc.isAnimating()) {
            this.flc.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        buw();
        if (this.fkZ != null) {
            this.fkZ.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!qs()) {
            if (this.fkY != null && this.fli) {
                this.fkY.onListPullRefresh(z);
            }
            this.fli = true;
        }
    }

    public void a(e eVar) {
        this.flg = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!qs()) {
            if (this.flb != null) {
                this.flb.buB();
            }
            if (!buy()) {
                buv();
            } else if (this.flc != null && this.flc.isAnimating()) {
                this.flc.cancelAnimation();
            }
        }
    }

    private void buv() {
        if (bsF() && this.flc != null) {
            this.flc.loop(false);
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.fkY = cVar;
    }

    public void a(b bVar) {
        this.fkZ = bVar;
    }

    public void a(d dVar) {
        this.fla = dVar;
    }

    public void a(a aVar) {
        this.flb = aVar;
    }

    public void changeSkin(int i) {
        if (bsF() && this.mSkinType != i && this.flc != null && !this.flc.isAnimating()) {
            this.mSkinType = i;
            ap.a(this.flc, R.raw.lottie_common_pull_refresh);
        }
        if (this.fle != null) {
            this.fle.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bsF() {
        return ai.bsE().bsF();
    }

    private void initPullView() {
        if (this.fle != null && this.fle.getParent() != null) {
            this.mPullRoot.removeView(this.fle);
        }
        if (bsF()) {
            if (this.mPullImage != null && this.flc != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.flc.getVisibility() != 0) {
                    this.flc.setVisibility(0);
                }
                if (this.flc.isAnimating()) {
                    this.flc.cancelAnimation();
                }
                this.flc.setMinAndMaxProgress(0.0f, 1.0f);
                this.flc.setFrame(0);
                this.flc.setSpeed(1.3f);
            }
        } else if (this.mPullImage != null && this.flc != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.flc.getVisibility() != 8) {
                this.flc.setVisibility(8);
            }
        }
    }

    private void buw() {
        if (bsF() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean bux() {
        return this.fld;
    }

    public void a(InterfaceC0570f interfaceC0570f) {
        this.flf = interfaceC0570f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.flh = z;
    }

    public boolean buy() {
        if (bux() && this.flh && this.flg != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.flc.setVisibility(8);
            if (this.fle == null) {
                this.fle = new SmartBubbleAnimatedView(getContext());
                this.fle.setExtrusionRemind(true);
            }
            this.fle.fll = this.flg.getTipText();
            this.fle.jng = this.flg.buC();
            if (this.fle.getParent() != null) {
                this.mPullRoot.removeView(this.fle);
            }
            this.mPullRoot.addView(this.fle);
            this.fle.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void buA() {
                    if (f.this.flf != null) {
                        f.this.flf.onAnimationEnd();
                    }
                }
            });
            if (this.flf != null) {
                this.flf.pI(this.fle.getTipViewHeight());
            }
            this.fle.cFb();
            return true;
        }
        return false;
    }

    public void buz() {
        if (this.mPullRoot != null && this.fle != null && this.fle.getParent() != null) {
            this.mPullRoot.removeView(this.fle);
        }
    }

    public void pH(int i) {
        if (this.flc != null) {
            ap.a(this.flc, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.flj = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String fll;
        private int flm;

        public e(String str, int i) {
            this.fll = str;
            this.flm = i;
        }

        public String getTipText() {
            return this.fll;
        }

        public int buC() {
            return this.flm;
        }
    }
}
