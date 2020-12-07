package com.baidu.live.yuyingift.container;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.sdk.a;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class AlaComboBtnAnimView extends FrameLayout {
    private boolean aZA;
    private RelativeLayout aZp;
    private View aZq;
    private Animation aZr;
    private ScaleAnimation aZs;
    private LottieAnimationView aZt;
    private View aZu;
    private ObjectAnimator aZv;
    private ImageView aZw;
    private AnimatorSet aZx;
    private ObjectAnimator aZy;
    private long aZz;
    private a bTo;
    private AlaRoundProgress bTp;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void IY();
    }

    public AlaComboBtnAnimView(Context context) {
        this(context, null);
    }

    public AlaComboBtnAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaComboBtnAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_combo_btn_anim_view, this);
        this.aZu = findViewById(a.f.combo_container);
        this.bTp = (AlaRoundProgress) findViewById(a.f.ala_round_progress);
        this.aZp = (RelativeLayout) findViewById(a.f.combo_btn);
        this.aZp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aZw = (ImageView) findViewById(a.f.combo_text_icon);
        this.aZq = findViewById(a.f.combo_bg);
        this.aZr = AnimationUtils.loadAnimation(this.mContext, a.C0205a.ala_gift_rotate_anim);
        this.aZr.setInterpolator(new LinearInterpolator());
        this.aZs = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0205a.ala_gift_scale_anim);
        this.aZt = (LottieAnimationView) findViewById(a.f.lottie_balloon);
        this.aZt.setAnimation("yuyin_ala_gift_combo_balloon.json");
        this.aZt.loop(false);
        this.bTp.setMax(100);
        this.bTp.setProgress(0);
        this.aZv = ObjectAnimator.ofInt(this.bTp, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.aZv.setInterpolator(new LinearInterpolator());
        this.aZv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aZv.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aZu.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.bTo != null) {
                    AlaComboBtnAnimView.this.bTo.IY();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aZp, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aZy = ObjectAnimator.ofFloat(this.aZp, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aZy.setRepeatCount(0);
        this.aZy.setDuration(1000L);
        this.aZx = new AnimatorSet();
        this.aZx.play(ofFloat).with(this.aZy);
        this.aZy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aZA) {
                    AlaComboBtnAnimView.this.aZp.startAnimation(AlaComboBtnAnimView.this.aZs);
                }
            }
        });
    }

    public void IU() {
        this.aZA = System.currentTimeMillis() - this.aZz < 1010;
        this.aZz = System.currentTimeMillis();
        this.aZs.cancel();
        if (this.aZx.isRunning()) {
            this.aZx.cancel();
        }
        this.aZx.start();
        this.aZt.playAnimation();
        this.aZv.start();
    }

    public void IV() {
        this.aZu.setVisibility(0);
        this.aZq.startAnimation(this.aZr);
        this.aZp.startAnimation(this.aZs);
        this.aZv.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aZp != null) {
            this.aZp.setOnClickListener(onClickListener);
        }
    }

    public void IW() {
        this.aZr.cancel();
        this.aZs.cancel();
        if (this.aZv.isRunning()) {
            this.aZv.cancel();
        }
        if (this.aZx.isRunning()) {
            this.aZx.cancel();
        }
        if (this.aZt.isAnimating()) {
            this.aZt.cancelAnimation();
        }
        this.aZu.setVisibility(8);
        if (this.bTo != null) {
            this.bTo.IY();
        }
    }

    public void setComboListener(a aVar) {
        this.bTo = aVar;
    }

    public boolean IX() {
        return this.aZu == null || this.aZu.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            IW();
        } catch (Exception e) {
        }
    }
}
