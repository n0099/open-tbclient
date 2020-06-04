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
public class f extends com.baidu.adp.widget.ListView.c {
    private InterfaceC0479f dVA;
    private e dVB;
    private boolean dVC;
    private boolean dVD;
    private boolean dVE;
    private View.OnClickListener dVF;
    private final Animator.AnimatorListener dVG;
    private c dVt;
    private b dVu;
    private d dVv;
    private a dVw;
    protected ContinuousAnimationView dVx;
    private boolean dVy;
    private SmartBubbleAnimatedView dVz;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void aWA();
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
    public interface InterfaceC0479f {
        void mc(int i);

        void onAnimationEnd();
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.dVt = null;
        this.dVu = null;
        this.dVv = null;
        this.dVw = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.dVy = false;
        this.dVC = true;
        this.dVD = true;
        this.dVE = false;
        this.dVF = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dVF != null) {
                    f.this.dVF.onClick(view);
                }
            }
        };
        this.dVG = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.f.3
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
                if (!f.this.dVE) {
                    f.this.dVE = true;
                    f.this.dVx.setSpeed(1.0f);
                    f.this.dVx.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.dVx = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        am.a(this.dVx, (int) R.raw.lottie_common_pull_refresh);
        this.dVx.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!aUJ()) {
            this.mAnimImage = af.aUI().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!aUJ() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        if (this.dVv != null) {
            this.dVv.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!aUJ() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        super.onPullPercentChange(f, f2);
        if (aUJ()) {
            this.dVx.setAlpha(f);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (aUJ()) {
            if (!oU()) {
                aWt();
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

    private void aWt() {
        if (this.dVx != null) {
            if (this.dVx.isAnimating()) {
                this.dVx.cancelAnimation();
            }
            this.dVE = false;
            this.dVx.loop(true);
            this.dVx.setMinAndMaxProgress(0.0f, 0.738f);
            this.dVx.setSpeed(1.5f);
            this.dVx.setRepeatMode(1);
            this.dVx.removeAllAnimatorListeners();
            this.dVx.addAnimatorListener(this.dVG);
            this.dVx.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.dVD = true;
        if (aUJ() && this.dVx.isAnimating()) {
            this.dVx.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        aWv();
        if (this.dVu != null) {
            this.dVu.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!oU()) {
            if (this.dVt != null && this.dVD) {
                this.dVt.onListPullRefresh(z);
            }
            this.dVD = true;
        }
    }

    public void a(e eVar) {
        this.dVB = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!oU()) {
            if (this.dVw != null) {
                this.dVw.aWA();
            }
            if (!aWx()) {
                aWu();
            } else if (this.dVx != null && this.dVx.isAnimating()) {
                this.dVx.cancelAnimation();
            }
        }
    }

    private void aWu() {
        if (aUJ() && this.dVx != null) {
            if (this.dVx.isAnimating()) {
                this.dVx.cancelAnimation();
            }
            this.dVx.loop(false);
            this.dVx.setSpeed(1.0f);
            this.dVx.setMinAndMaxProgress(0.738f, 1.0f);
            this.dVx.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.dVt = cVar;
    }

    public void a(b bVar) {
        this.dVu = bVar;
    }

    public void a(d dVar) {
        this.dVv = dVar;
    }

    public void a(a aVar) {
        this.dVw = aVar;
    }

    public void changeSkin(int i) {
        if (aUJ()) {
            am.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.dVx != null && !this.dVx.isAnimating()) {
                this.mSkinType = i;
                am.a(this.dVx, (int) R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.dVz != null) {
            this.dVz.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aUJ() {
        return af.aUI().aUJ();
    }

    private void initPullView() {
        if (this.dVz != null && this.dVz.getParent() != null) {
            this.mPullRoot.removeView(this.dVz);
        }
        if (aUJ()) {
            if (this.mPullImage != null && this.dVx != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.dVx.getVisibility() != 0) {
                    this.dVx.setVisibility(0);
                }
                if (this.dVx.isAnimating()) {
                    this.dVx.cancelAnimation();
                }
                this.dVx.setMinAndMaxProgress(0.0f, 1.0f);
                this.dVx.setFrame(0);
            }
        } else if (this.mPullImage != null && this.dVx != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.dVx.getVisibility() != 8) {
                this.dVx.setVisibility(8);
            }
        }
    }

    private void aWv() {
        if (aUJ() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean aWw() {
        return this.dVy;
    }

    public void a(InterfaceC0479f interfaceC0479f) {
        this.dVA = interfaceC0479f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.dVC = z;
    }

    public boolean aWx() {
        if (aWw() && this.dVC && this.dVB != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.dVx.setVisibility(8);
            if (this.dVz == null) {
                this.dVz = new SmartBubbleAnimatedView(getContext());
                this.dVz.setExtrusionRemind(true);
            }
            this.dVz.dVI = this.dVB.getTipText();
            this.dVz.hrB = this.dVB.aWB();
            if (this.dVz.getParent() != null) {
                this.mPullRoot.removeView(this.dVz);
            }
            this.mPullRoot.addView(this.dVz);
            this.dVz.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void aWz() {
                    if (f.this.dVA != null) {
                        f.this.dVA.onAnimationEnd();
                    }
                }
            });
            if (this.dVA != null) {
                this.dVA.mc(this.dVz.getTipViewHeight());
            }
            this.dVz.bXb();
            return true;
        }
        return false;
    }

    public void aWy() {
        if (this.mPullRoot != null && this.dVz != null && this.dVz.getParent() != null) {
            this.mPullRoot.removeView(this.dVz);
        }
    }

    public void mb(int i) {
        if (this.dVx != null) {
            am.a(this.dVx, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dVF = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String dVI;
        private int dVJ;

        public e(String str, int i) {
            this.dVI = str;
            this.dVJ = i;
        }

        public String getTipText() {
            return this.dVI;
        }

        public int aWB() {
            return this.dVJ;
        }
    }
}
