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
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.d {
    private c ecS;
    private b ecT;
    private d ecU;
    private a ecV;
    protected ContinuousAnimationView ecW;
    private boolean ecX;
    private SmartBubbleAnimatedView ecY;
    private InterfaceC0485f ecZ;
    private e eda;
    private boolean edb;
    private boolean edc;
    private boolean edd;
    private View.OnClickListener ede;
    private final Animator.AnimatorListener edf;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void aYs();
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
    public interface InterfaceC0485f {
        void mt(int i);

        void onAnimationEnd();
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.ecS = null;
        this.ecT = null;
        this.ecU = null;
        this.ecV = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.ecX = false;
        this.edb = true;
        this.edc = true;
        this.edd = false;
        this.ede = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ede != null) {
                    f.this.ede.onClick(view);
                }
            }
        };
        this.edf = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.f.3
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
                if (!f.this.edd) {
                    f.this.edd = true;
                    f.this.ecW.setSpeed(1.0f);
                    f.this.ecW.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.ecW = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        an.a(this.ecW, (int) R.raw.lottie_common_pull_refresh);
        this.ecW.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!aWD()) {
            this.mAnimImage = ag.aWC().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        if (!aWD() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        if (this.ecU != null) {
            this.ecU.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!aWD() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        super.onPullPercentChange(f, f2);
        if (aWD()) {
            this.ecW.setAlpha(f);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        initPullView();
        if (aWD()) {
            if (!pl()) {
                aYl();
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

    private void aYl() {
        if (this.ecW != null) {
            if (this.ecW.isAnimating()) {
                this.ecW.cancelAnimation();
            }
            this.edd = false;
            this.ecW.loop(true);
            this.ecW.setMinAndMaxProgress(0.0f, 0.738f);
            this.ecW.setSpeed(1.5f);
            this.ecW.setRepeatMode(1);
            this.ecW.removeAllAnimatorListeners();
            this.ecW.addAnimatorListener(this.edf);
            this.ecW.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.edc = true;
        if (aWD() && this.ecW.isAnimating()) {
            this.ecW.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        aYn();
        if (this.ecT != null) {
            this.ecT.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (!pl()) {
            if (this.ecS != null && this.edc) {
                this.ecS.onListPullRefresh(z);
            }
            this.edc = true;
        }
    }

    public void a(e eVar) {
        this.eda = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        if (!pl()) {
            if (this.ecV != null) {
                this.ecV.aYs();
            }
            if (!aYp()) {
                aYm();
            } else if (this.ecW != null && this.ecW.isAnimating()) {
                this.ecW.cancelAnimation();
            }
        }
    }

    private void aYm() {
        if (aWD() && this.ecW != null) {
            if (this.ecW.isAnimating()) {
                this.ecW.cancelAnimation();
            }
            this.ecW.loop(false);
            this.ecW.setSpeed(1.0f);
            this.ecW.setMinAndMaxProgress(0.738f, 1.0f);
            this.ecW.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.ecS = cVar;
    }

    public void a(b bVar) {
        this.ecT = bVar;
    }

    public void a(d dVar) {
        this.ecU = dVar;
    }

    public void a(a aVar) {
        this.ecV = aVar;
    }

    public void changeSkin(int i) {
        if (aWD()) {
            an.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.ecW != null && !this.ecW.isAnimating()) {
                this.mSkinType = i;
                an.a(this.ecW, (int) R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.ecY != null) {
            this.ecY.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aWD() {
        return ag.aWC().aWD();
    }

    private void initPullView() {
        if (this.ecY != null && this.ecY.getParent() != null) {
            this.mPullRoot.removeView(this.ecY);
        }
        if (aWD()) {
            if (this.mPullImage != null && this.ecW != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.ecW.getVisibility() != 0) {
                    this.ecW.setVisibility(0);
                }
                if (this.ecW.isAnimating()) {
                    this.ecW.cancelAnimation();
                }
                this.ecW.setMinAndMaxProgress(0.0f, 1.0f);
                this.ecW.setFrame(0);
            }
        } else if (this.mPullImage != null && this.ecW != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.ecW.getVisibility() != 8) {
                this.ecW.setVisibility(8);
            }
        }
    }

    private void aYn() {
        if (aWD() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean aYo() {
        return this.ecX;
    }

    public void a(InterfaceC0485f interfaceC0485f) {
        this.ecZ = interfaceC0485f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.edb = z;
    }

    public boolean aYp() {
        if (aYo() && this.edb && this.eda != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.ecW.setVisibility(8);
            if (this.ecY == null) {
                this.ecY = new SmartBubbleAnimatedView(getContext());
                this.ecY.setExtrusionRemind(true);
            }
            this.ecY.edh = this.eda.getTipText();
            this.ecY.hEs = this.eda.aYt();
            if (this.ecY.getParent() != null) {
                this.mPullRoot.removeView(this.ecY);
            }
            this.mPullRoot.addView(this.ecY);
            this.ecY.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void aYr() {
                    if (f.this.ecZ != null) {
                        f.this.ecZ.onAnimationEnd();
                    }
                }
            });
            if (this.ecZ != null) {
                this.ecZ.mt(this.ecY.getTipViewHeight());
            }
            this.ecY.can();
            return true;
        }
        return false;
    }

    public void aYq() {
        if (this.mPullRoot != null && this.ecY != null && this.ecY.getParent() != null) {
            this.mPullRoot.removeView(this.ecY);
        }
    }

    public void ms(int i) {
        if (this.ecW != null) {
            an.a(this.ecW, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ede = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String edh;
        private int edi;

        public e(String str, int i) {
            this.edh = str;
            this.edi = i;
        }

        public String getTipText() {
            return this.edh;
        }

        public int aYt() {
            return this.edi;
        }
    }
}
