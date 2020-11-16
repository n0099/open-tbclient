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
    private RelativeLayout aVZ;
    private View aWa;
    private Animation aWb;
    private ScaleAnimation aWc;
    private LottieAnimationView aWd;
    private View aWe;
    private ObjectAnimator aWf;
    private ImageView aWg;
    private AnimatorSet aWh;
    private ObjectAnimator aWi;
    private long aWj;
    private boolean aWk;
    private a bOh;
    private AlaRoundProgress bOi;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void Hi();
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
        this.aWe = findViewById(a.f.combo_container);
        this.bOi = (AlaRoundProgress) findViewById(a.f.ala_round_progress);
        this.aVZ = (RelativeLayout) findViewById(a.f.combo_btn);
        this.aVZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aWg = (ImageView) findViewById(a.f.combo_text_icon);
        this.aWa = findViewById(a.f.combo_bg);
        this.aWb = AnimationUtils.loadAnimation(this.mContext, a.C0195a.ala_gift_rotate_anim);
        this.aWb.setInterpolator(new LinearInterpolator());
        this.aWc = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0195a.ala_gift_scale_anim);
        this.aWd = (LottieAnimationView) findViewById(a.f.lottie_balloon);
        this.aWd.setAnimation("yuyin_ala_gift_combo_balloon.json");
        this.aWd.loop(false);
        this.bOi.setMax(100);
        this.bOi.setProgress(0);
        this.aWf = ObjectAnimator.ofInt(this.bOi, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.aWf.setInterpolator(new LinearInterpolator());
        this.aWf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aWf.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aWe.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.bOh != null) {
                    AlaComboBtnAnimView.this.bOh.Hi();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aVZ, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aWi = ObjectAnimator.ofFloat(this.aVZ, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aWi.setRepeatCount(0);
        this.aWi.setDuration(1000L);
        this.aWh = new AnimatorSet();
        this.aWh.play(ofFloat).with(this.aWi);
        this.aWi.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aWk) {
                    AlaComboBtnAnimView.this.aVZ.startAnimation(AlaComboBtnAnimView.this.aWc);
                }
            }
        });
    }

    public void He() {
        this.aWk = System.currentTimeMillis() - this.aWj < 1010;
        this.aWj = System.currentTimeMillis();
        this.aWc.cancel();
        if (this.aWh.isRunning()) {
            this.aWh.cancel();
        }
        this.aWh.start();
        this.aWd.playAnimation();
        this.aWf.start();
    }

    public void Hf() {
        this.aWe.setVisibility(0);
        this.aWa.startAnimation(this.aWb);
        this.aVZ.startAnimation(this.aWc);
        this.aWf.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aVZ != null) {
            this.aVZ.setOnClickListener(onClickListener);
        }
    }

    public void Hg() {
        this.aWb.cancel();
        this.aWc.cancel();
        if (this.aWf.isRunning()) {
            this.aWf.cancel();
        }
        if (this.aWh.isRunning()) {
            this.aWh.cancel();
        }
        if (this.aWd.isAnimating()) {
            this.aWd.cancelAnimation();
        }
        this.aWe.setVisibility(8);
        if (this.bOh != null) {
            this.bOh.Hi();
        }
    }

    public void setComboListener(a aVar) {
        this.bOh = aVar;
    }

    public boolean Hh() {
        return this.aWe == null || this.aWe.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            Hg();
        } catch (Exception e) {
        }
    }
}
