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
    private boolean fbJ;
    private c fci;
    private b fcj;
    private d fck;
    private a fcl;
    protected ContinuousAnimationView fcm;
    private boolean fcn;
    private SmartBubbleAnimatedView fco;
    private InterfaceC0593f fcq;
    private e fcr;
    private boolean fcs;
    private boolean fct;
    private View.OnClickListener fcu;
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
        void bvC();
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
    public interface InterfaceC0593f {
        void onAnimationEnd();

        void qW(int i);
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.fci = null;
        this.fcj = null;
        this.fck = null;
        this.fcl = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.fcn = false;
        this.fcs = true;
        this.fct = true;
        this.fbJ = false;
        this.fcu = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fcu != null) {
                    f.this.fcu.onClick(view);
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
                if (!f.this.fbJ) {
                    f.this.fbJ = true;
                    f.this.fcm.setSpeed(1.0f);
                    f.this.fcm.setMinAndMaxFrame(45, 105);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.fcm = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        ap.a(this.fcm, R.raw.lottie_common_pull_refresh);
        this.fcm.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!btH()) {
            this.mAnimImage = ai.btG().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        if (!btH() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        if (this.fck != null) {
            this.fck.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!btH() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        super.onPullPercentChange(f, f2);
        if (btH()) {
            this.fcm.setAlpha(f);
            this.fcm.setFrame((int) Math.min(27.0f, ((f * 27.0f) * 5.0f) / 3.0f));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        initPullView();
        if (btH()) {
            if (!qS()) {
                bvv();
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

    private void bvv() {
        if (this.fcm != null) {
            if (this.fcm.isAnimating()) {
                this.fcm.cancelAnimation();
            }
            this.fbJ = false;
            this.fcm.loop(true);
            this.fcm.setMinFrame(27);
            this.fcm.setRepeatMode(1);
            this.fcm.removeAllAnimatorListeners();
            this.fcm.addAnimatorListener(this.loadViewAnimListener);
            this.fcm.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.fct = true;
        if (btH() && this.fcm.isAnimating()) {
            this.fcm.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        bvx();
        if (this.fcj != null) {
            this.fcj.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (!qS()) {
            if (this.fci != null && this.fct) {
                this.fci.onListPullRefresh(z);
            }
            this.fct = true;
        }
    }

    public void a(e eVar) {
        this.fcr = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        if (!qS()) {
            if (this.fcl != null) {
                this.fcl.bvC();
            }
            if (!bvz()) {
                bvw();
            } else if (this.fcm != null && this.fcm.isAnimating()) {
                this.fcm.cancelAnimation();
            }
        }
    }

    private void bvw() {
        if (btH() && this.fcm != null) {
            this.fcm.loop(false);
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.fci = cVar;
    }

    public void a(b bVar) {
        this.fcj = bVar;
    }

    public void a(d dVar) {
        this.fck = dVar;
    }

    public void a(a aVar) {
        this.fcl = aVar;
    }

    public void changeSkin(int i) {
        if (btH() && this.mSkinType != i && this.fcm != null && !this.fcm.isAnimating()) {
            this.mSkinType = i;
            ap.a(this.fcm, R.raw.lottie_common_pull_refresh);
        }
        if (this.fco != null) {
            this.fco.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean btH() {
        return ai.btG().btH();
    }

    private void initPullView() {
        if (this.fco != null && this.fco.getParent() != null) {
            this.mPullRoot.removeView(this.fco);
        }
        if (btH()) {
            if (this.mPullImage != null && this.fcm != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.fcm.getVisibility() != 0) {
                    this.fcm.setVisibility(0);
                }
                if (this.fcm.isAnimating()) {
                    this.fcm.cancelAnimation();
                }
                this.fcm.setMinAndMaxProgress(0.0f, 1.0f);
                this.fcm.setFrame(0);
                this.fcm.setSpeed(1.3f);
            }
        } else if (this.mPullImage != null && this.fcm != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.fcm.getVisibility() != 8) {
                this.fcm.setVisibility(8);
            }
        }
    }

    private void bvx() {
        if (btH() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean bvy() {
        return this.fcn;
    }

    public void a(InterfaceC0593f interfaceC0593f) {
        this.fcq = interfaceC0593f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.fcs = z;
    }

    public boolean bvz() {
        if (bvy() && this.fcs && this.fcr != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.fcm.setVisibility(8);
            if (this.fco == null) {
                this.fco = new SmartBubbleAnimatedView(getContext());
                this.fco.setExtrusionRemind(true);
            }
            this.fco.fcw = this.fcr.getTipText();
            this.fco.iXT = this.fcr.bvD();
            if (this.fco.getParent() != null) {
                this.mPullRoot.removeView(this.fco);
            }
            this.mPullRoot.addView(this.fco);
            this.fco.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void bvB() {
                    if (f.this.fcq != null) {
                        f.this.fcq.onAnimationEnd();
                    }
                }
            });
            if (this.fcq != null) {
                this.fcq.qW(this.fco.getTipViewHeight());
            }
            this.fco.cEx();
            return true;
        }
        return false;
    }

    public void bvA() {
        if (this.mPullRoot != null && this.fco != null && this.fco.getParent() != null) {
            this.mPullRoot.removeView(this.fco);
        }
    }

    public void qV(int i) {
        if (this.fcm != null) {
            ap.a(this.fcm, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fcu = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String fcw;
        private int fcx;

        public e(String str, int i) {
            this.fcw = str;
            this.fcx = i;
        }

        public String getTipText() {
            return this.fcw;
        }

        public int bvD() {
            return this.fcx;
        }
    }
}
