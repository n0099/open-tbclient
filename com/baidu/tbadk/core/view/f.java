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
    private c eUM;
    private b eUN;
    private d eUO;
    private a eUP;
    protected ContinuousAnimationView eUQ;
    private boolean eUR;
    private SmartBubbleAnimatedView eUS;
    private InterfaceC0580f eUT;
    private e eUU;
    private boolean eUV;
    private boolean eUW;
    private View.OnClickListener eUX;
    private boolean eUm;
    private final Animator.AnimatorListener eUu;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void bsc();
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
    public interface InterfaceC0580f {
        void onAnimationEnd();

        void qv(int i);
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.eUM = null;
        this.eUN = null;
        this.eUO = null;
        this.eUP = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.eUR = false;
        this.eUV = true;
        this.eUW = true;
        this.eUm = false;
        this.eUX = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eUX != null) {
                    f.this.eUX.onClick(view);
                }
            }
        };
        this.eUu = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.f.3
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
                if (!f.this.eUm) {
                    f.this.eUm = true;
                    f.this.eUQ.setSpeed(1.0f);
                    f.this.eUQ.setMinAndMaxFrame(45, 105);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.eUQ = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        ap.a(this.eUQ, R.raw.lottie_common_pull_refresh);
        this.eUQ.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!bqm()) {
            this.mAnimImage = ai.bql().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        if (!bqm() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        if (this.eUO != null) {
            this.eUO.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!bqm() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        super.onPullPercentChange(f, f2);
        if (bqm()) {
            this.eUQ.setAlpha(f);
            this.eUQ.setFrame((int) Math.min(27.0f, ((f * 27.0f) * 5.0f) / 3.0f));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        initPullView();
        if (bqm()) {
            if (!qQ()) {
                brV();
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

    private void brV() {
        if (this.eUQ != null) {
            if (this.eUQ.isAnimating()) {
                this.eUQ.cancelAnimation();
            }
            this.eUm = false;
            this.eUQ.loop(true);
            this.eUQ.setMinFrame(27);
            this.eUQ.setRepeatMode(1);
            this.eUQ.removeAllAnimatorListeners();
            this.eUQ.addAnimatorListener(this.eUu);
            this.eUQ.playAnimation();
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.eUW = true;
        if (bqm() && this.eUQ.isAnimating()) {
            this.eUQ.cancelAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        brX();
        if (this.eUN != null) {
            this.eUN.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (!qQ()) {
            if (this.eUM != null && this.eUW) {
                this.eUM.onListPullRefresh(z);
            }
            this.eUW = true;
        }
    }

    public void a(e eVar) {
        this.eUU = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        if (!qQ()) {
            if (this.eUP != null) {
                this.eUP.bsc();
            }
            if (!brZ()) {
                brW();
            } else if (this.eUQ != null && this.eUQ.isAnimating()) {
                this.eUQ.cancelAnimation();
            }
        }
    }

    private void brW() {
        if (bqm() && this.eUQ != null) {
            this.eUQ.loop(false);
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.eUM = cVar;
    }

    public void a(b bVar) {
        this.eUN = bVar;
    }

    public void a(d dVar) {
        this.eUO = dVar;
    }

    public void a(a aVar) {
        this.eUP = aVar;
    }

    public void changeSkin(int i) {
        if (bqm() && this.mSkinType != i && this.eUQ != null && !this.eUQ.isAnimating()) {
            this.mSkinType = i;
            ap.a(this.eUQ, R.raw.lottie_common_pull_refresh);
        }
        if (this.eUS != null) {
            this.eUS.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bqm() {
        return ai.bql().bqm();
    }

    private void initPullView() {
        if (this.eUS != null && this.eUS.getParent() != null) {
            this.mPullRoot.removeView(this.eUS);
        }
        if (bqm()) {
            if (this.mPullImage != null && this.eUQ != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.eUQ.getVisibility() != 0) {
                    this.eUQ.setVisibility(0);
                }
                if (this.eUQ.isAnimating()) {
                    this.eUQ.cancelAnimation();
                }
                this.eUQ.setMinAndMaxProgress(0.0f, 1.0f);
                this.eUQ.setFrame(0);
                this.eUQ.setSpeed(1.3f);
            }
        } else if (this.mPullImage != null && this.eUQ != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.eUQ.getVisibility() != 8) {
                this.eUQ.setVisibility(8);
            }
        }
    }

    private void brX() {
        if (bqm() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 600L;
    }

    public boolean brY() {
        return this.eUR;
    }

    public void a(InterfaceC0580f interfaceC0580f) {
        this.eUT = interfaceC0580f;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.eUV = z;
    }

    public boolean brZ() {
        if (brY() && this.eUV && this.eUU != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.eUQ.setVisibility(8);
            if (this.eUS == null) {
                this.eUS = new SmartBubbleAnimatedView(getContext());
                this.eUS.setExtrusionRemind(true);
            }
            this.eUS.eUZ = this.eUU.getTipText();
            this.eUS.iNc = this.eUU.bsd();
            if (this.eUS.getParent() != null) {
                this.mPullRoot.removeView(this.eUS);
            }
            this.mPullRoot.addView(this.eUS);
            this.eUS.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.f.4
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void bsb() {
                    if (f.this.eUT != null) {
                        f.this.eUT.onAnimationEnd();
                    }
                }
            });
            if (this.eUT != null) {
                this.eUT.qv(this.eUS.getTipViewHeight());
            }
            this.eUS.cAh();
            return true;
        }
        return false;
    }

    public void bsa() {
        if (this.mPullRoot != null && this.eUS != null && this.eUS.getParent() != null) {
            this.mPullRoot.removeView(this.eUS);
        }
    }

    public void qu(int i) {
        if (this.eUQ != null) {
            ap.a(this.eUQ, i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eUX = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String eUZ;
        private int eVa;

        public e(String str, int i) {
            this.eUZ = str;
            this.eVa = i;
        }

        public String getTipText() {
            return this.eUZ;
        }

        public int bsd() {
            return this.eVa;
        }
    }
}
