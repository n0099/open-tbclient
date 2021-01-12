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
public class f extends com.baidu.adp.widget.ListView.c {
    private boolean fgH;
    private c fhg;
    private b fhh;
    private d fhi;
    private a fhj;
    protected ContinuousAnimationView fhk;
    private boolean fhl;
    private SmartBubbleAnimatedView fhm;
    private InterfaceC0567f fhn;
    private e fho;
    private boolean fhp;
    private boolean fhq;
    private View.OnClickListener fhr;
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
        void bue();
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
    public interface InterfaceC0567f {
        void onAnimationEnd();

        void pC(int i);
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.fhg = null;
        this.fhh = null;
        this.fhi = null;
        this.fhj = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.fhl = false;
        this.fhp = true;
        this.fhq = true;
        this.fgH = false;
        this.fhr = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fhr != null) {
                    f.this.fhr.onClick(view);
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
                if (!f.this.fgH) {
                    f.this.fgH = true;
                    f.this.fhk.setSpeed(1.0f);
                    f.this.fhk.setMinAndMaxFrame(45, 105);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.fhk = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        ao.a(this.fhk, R.raw.lottie_common_pull_refresh);
        this.fhk.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!bsi()) {
            this.mAnimImage = ah.bsh().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!bsi() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        if (this.fhi != null) {
            this.fhi.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!bsi() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        super.onPullPercentChange(f, f2);
        if (bsi()) {
            this.fhk.setAlpha(f);
            this.fhk.setFrame((int) Math.min(27.0f, ((f * 27.0f) * 5.0f) / 3.0f));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (bsi()) {
            if (!qu()) {
                btX();
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

    private void btX() {
        if (this.fhk != null) {
            if (this.fhk.isAnimating()) {
                this.fhk.cancelAnimation();
            }
            this.fgH = false;
            this.fhk.loop(true);
            this.fhk.setMinFrame(27);
            this.fhk.setRepeatMode(1);
            this.fhk.removeAllAnimatorListeners();
            this.fhk.addAnimatorListener(this.loadViewAnimListener);
            this.fhk.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.fhq = true;
        if (bsi() && this.fhk.isAnimating()) {
            this.fhk.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        btZ();
        if (this.fhh != null) {
            this.fhh.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!qu()) {
            if (this.fhg != null && this.fhq) {
                this.fhg.onListPullRefresh(z);
            }
            this.fhq = true;
        }
    }

    public void a(e eVar) {
        this.fho = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!qu()) {
            if (this.fhj != null) {
                this.fhj.bue();
            }
            if (!bub()) {
                btY();
            } else if (this.fhk != null && this.fhk.isAnimating()) {
                this.fhk.cancelAnimation();
            }
        }
    }

    private void btY() {
        if (bsi() && this.fhk != null) {
            this.fhk.loop(false);
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.fhg = cVar;
    }

    public void a(b bVar) {
        this.fhh = bVar;
    }

    public void a(d dVar) {
        this.fhi = dVar;
    }

    public void a(a aVar) {
        this.fhj = aVar;
    }

    public void changeSkin(int i) {
        if (bsi() && this.mSkinType != i && this.fhk != null && !this.fhk.isAnimating()) {
            this.mSkinType = i;
            ao.a(this.fhk, R.raw.lottie_common_pull_refresh);
        }
        if (this.fhm != null) {
            this.fhm.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bsi() {
        return ah.bsh().bsi();
    }

    private void initPullView() {
        if (this.fhm != null && this.fhm.getParent() != null) {
            this.mPullRoot.removeView(this.fhm);
        }
        if (bsi()) {
            if (this.mPullImage != null && this.fhk != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.fhk.getVisibility() != 0) {
                    this.fhk.setVisibility(0);
                }
                if (this.fhk.isAnimating()) {
                    this.fhk.cancelAnimation();
                }
                this.fhk.setMinAndMaxProgress(0.0f, 1.0f);
                this.fhk.setFrame(0);
                this.fhk.setSpeed(1.3f);
            }
        } else if (this.mPullImage != null && this.fhk != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.fhk.getVisibility() != 8) {
                this.fhk.setVisibility(8);
            }
        }
    }

    private void btZ() {
        if (bsi() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean bua() {
        return this.fhl;
    }

    public void a(InterfaceC0567f interfaceC0567f) {
        this.fhn = interfaceC0567f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.fhp = z;
    }

    public boolean bub() {
        if (bua() && this.fhp && this.fho != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.fhk.setVisibility(8);
            if (this.fhm == null) {
                this.fhm = new SmartBubbleAnimatedView(getContext());
                this.fhm.setExtrusionRemind(true);
            }
            this.fhm.fht = this.fho.getTipText();
            this.fhm.jfB = this.fho.buf();
            if (this.fhm.getParent() != null) {
                this.mPullRoot.removeView(this.fhm);
            }
            this.mPullRoot.addView(this.fhm);
            this.fhm.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void bud() {
                    if (f.this.fhn != null) {
                        f.this.fhn.onAnimationEnd();
                    }
                }
            });
            if (this.fhn != null) {
                this.fhn.pC(this.fhm.getTipViewHeight());
            }
            this.fhm.cDC();
            return true;
        }
        return false;
    }

    public void buc() {
        if (this.mPullRoot != null && this.fhm != null && this.fhm.getParent() != null) {
            this.mPullRoot.removeView(this.fhm);
        }
    }

    public void pB(int i) {
        if (this.fhk != null) {
            ao.a(this.fhk, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fhr = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String fht;
        private int fhu;

        public e(String str, int i) {
            this.fht = str;
            this.fhu = i;
        }

        public String getTipText() {
            return this.fht;
        }

        public int buf() {
            return this.fhu;
        }
    }
}
