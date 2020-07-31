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
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.d {
    private c ejc;
    private b ejd;
    private d eje;
    private a ejf;
    protected ContinuousAnimationView ejg;
    private boolean ejh;
    private SmartBubbleAnimatedView eji;
    private InterfaceC0498f ejj;
    private e ejk;
    private boolean ejl;
    private boolean ejm;
    private boolean ejn;
    private View.OnClickListener ejo;
    private final Animator.AnimatorListener ejp;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void bcr();
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
    public interface InterfaceC0498f {
        void mM(int i);

        void onAnimationEnd();
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.ejc = null;
        this.ejd = null;
        this.eje = null;
        this.ejf = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.ejh = false;
        this.ejl = true;
        this.ejm = true;
        this.ejn = false;
        this.ejo = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ejo != null) {
                    f.this.ejo.onClick(view);
                }
            }
        };
        this.ejp = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.f.3
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
                if (!f.this.ejn) {
                    f.this.ejn = true;
                    f.this.ejg.setSpeed(1.0f);
                    f.this.ejg.setMinProgress(0.346f);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.ejg = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        ao.a(this.ejg, R.raw.lottie_common_pull_refresh);
        this.ejg.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!baE()) {
            this.mAnimImage = ah.baD().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        if (!baE() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        if (this.eje != null) {
            this.eje.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!baE() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        super.onPullPercentChange(f, f2);
        if (baE()) {
            this.ejg.setAlpha(f);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        initPullView();
        if (baE()) {
            if (!pm()) {
                bck();
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

    private void bck() {
        if (this.ejg != null) {
            if (this.ejg.isAnimating()) {
                this.ejg.cancelAnimation();
            }
            this.ejn = false;
            this.ejg.loop(true);
            this.ejg.setMinAndMaxProgress(0.0f, 0.738f);
            this.ejg.setSpeed(1.5f);
            this.ejg.setRepeatMode(1);
            this.ejg.removeAllAnimatorListeners();
            this.ejg.addAnimatorListener(this.ejp);
            this.ejg.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.ejm = true;
        if (baE() && this.ejg.isAnimating()) {
            this.ejg.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        bcm();
        if (this.ejd != null) {
            this.ejd.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (!pm()) {
            if (this.ejc != null && this.ejm) {
                this.ejc.onListPullRefresh(z);
            }
            this.ejm = true;
        }
    }

    public void a(e eVar) {
        this.ejk = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        if (!pm()) {
            if (this.ejf != null) {
                this.ejf.bcr();
            }
            if (!bco()) {
                bcl();
            } else if (this.ejg != null && this.ejg.isAnimating()) {
                this.ejg.cancelAnimation();
            }
        }
    }

    private void bcl() {
        if (baE() && this.ejg != null) {
            if (this.ejg.isAnimating()) {
                this.ejg.cancelAnimation();
            }
            this.ejg.loop(false);
            this.ejg.setSpeed(1.0f);
            this.ejg.setMinAndMaxProgress(0.738f, 1.0f);
            this.ejg.playAnimation();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.ejc = cVar;
    }

    public void a(b bVar) {
        this.ejd = bVar;
    }

    public void a(d dVar) {
        this.eje = dVar;
    }

    public void a(a aVar) {
        this.ejf = aVar;
    }

    public void changeSkin(int i) {
        if (baE()) {
            ao.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
            if (this.mSkinType != i && this.ejg != null && !this.ejg.isAnimating()) {
                this.mSkinType = i;
                ao.a(this.ejg, R.raw.lottie_common_pull_refresh);
            }
        }
        if (this.eji != null) {
            this.eji.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean baE() {
        return ah.baD().baE();
    }

    private void initPullView() {
        if (this.eji != null && this.eji.getParent() != null) {
            this.mPullRoot.removeView(this.eji);
        }
        if (baE()) {
            if (this.mPullImage != null && this.ejg != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.ejg.getVisibility() != 0) {
                    this.ejg.setVisibility(0);
                }
                if (this.ejg.isAnimating()) {
                    this.ejg.cancelAnimation();
                }
                this.ejg.setMinAndMaxProgress(0.0f, 1.0f);
                this.ejg.setFrame(0);
            }
        } else if (this.mPullImage != null && this.ejg != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.ejg.getVisibility() != 8) {
                this.ejg.setVisibility(8);
            }
        }
    }

    private void bcm() {
        if (baE() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean bcn() {
        return this.ejh;
    }

    public void a(InterfaceC0498f interfaceC0498f) {
        this.ejj = interfaceC0498f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.ejl = z;
    }

    public boolean bco() {
        if (bcn() && this.ejl && this.ejk != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.ejg.setVisibility(8);
            if (this.eji == null) {
                this.eji = new SmartBubbleAnimatedView(getContext());
                this.eji.setExtrusionRemind(true);
            }
            this.eji.ejr = this.ejk.getTipText();
            this.eji.hKq = this.ejk.bcs();
            if (this.eji.getParent() != null) {
                this.mPullRoot.removeView(this.eji);
            }
            this.mPullRoot.addView(this.eji);
            this.eji.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void bcq() {
                    if (f.this.ejj != null) {
                        f.this.ejj.onAnimationEnd();
                    }
                }
            });
            if (this.ejj != null) {
                this.ejj.mM(this.eji.getTipViewHeight());
            }
            this.eji.cdL();
            return true;
        }
        return false;
    }

    public void bcp() {
        if (this.mPullRoot != null && this.eji != null && this.eji.getParent() != null) {
            this.mPullRoot.removeView(this.eji);
        }
    }

    public void mL(int i) {
        if (this.ejg != null) {
            ao.a(this.ejg, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ejo = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String ejr;
        private int ejs;

        public e(String str, int i) {
            this.ejr = str;
            this.ejs = i;
        }

        public String getTipText() {
            return this.ejr;
        }

        public int bcs() {
            return this.ejs;
        }
    }
}
