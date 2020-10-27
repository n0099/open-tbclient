package com.baidu.live.gift.container;

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
    private AnimatorSet aWA;
    private ObjectAnimator aWB;
    private long aWC;
    private boolean aWD;
    private a aWE;
    private AlaRoundProgress aWF;
    private RelativeLayout aWs;
    private View aWt;
    private Animation aWu;
    private ScaleAnimation aWv;
    private LottieAnimationView aWw;
    private View aWx;
    private ObjectAnimator aWy;
    private ImageView aWz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void Hq();
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
        LayoutInflater.from(this.mContext).inflate(a.h.ala_combo_btn_anim_view, this);
        this.aWx = findViewById(a.g.combo_container);
        this.aWF = (AlaRoundProgress) findViewById(a.g.ala_round_progress);
        this.aWs = (RelativeLayout) findViewById(a.g.combo_btn);
        this.aWs.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aWz = (ImageView) findViewById(a.g.combo_text_icon);
        this.aWt = findViewById(a.g.combo_bg);
        this.aWu = AnimationUtils.loadAnimation(this.mContext, a.C0195a.ala_gift_rotate_anim);
        this.aWu.setInterpolator(new LinearInterpolator());
        this.aWv = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0195a.ala_gift_scale_anim);
        this.aWw = (LottieAnimationView) findViewById(a.g.lottie_balloon);
        this.aWw.setAnimation("ala_gift_combo_balloon.json");
        this.aWw.loop(false);
        this.aWF.setMax(100);
        this.aWF.setProgress(0);
        this.aWy = ObjectAnimator.ofInt(this.aWF, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.aWy.setInterpolator(new LinearInterpolator());
        this.aWy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aWy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aWx.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.aWE != null) {
                    AlaComboBtnAnimView.this.aWE.Hq();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aWs, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aWB = ObjectAnimator.ofFloat(this.aWs, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aWB.setRepeatCount(0);
        this.aWB.setDuration(1000L);
        this.aWA = new AnimatorSet();
        this.aWA.play(ofFloat).with(this.aWB);
        this.aWB.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aWD) {
                    AlaComboBtnAnimView.this.aWs.startAnimation(AlaComboBtnAnimView.this.aWv);
                }
            }
        });
    }

    public void Hm() {
        this.aWD = System.currentTimeMillis() - this.aWC < 1010;
        this.aWC = System.currentTimeMillis();
        this.aWv.cancel();
        if (this.aWA.isRunning()) {
            this.aWA.cancel();
        }
        this.aWA.start();
        this.aWw.playAnimation();
        this.aWy.start();
    }

    public void Hn() {
        this.aWx.setVisibility(0);
        this.aWt.startAnimation(this.aWu);
        this.aWs.startAnimation(this.aWv);
        this.aWy.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aWs != null) {
            this.aWs.setOnClickListener(onClickListener);
        }
    }

    public void Ho() {
        this.aWu.cancel();
        this.aWv.cancel();
        if (this.aWy.isRunning()) {
            this.aWy.cancel();
        }
        if (this.aWA.isRunning()) {
            this.aWA.cancel();
        }
        if (this.aWw.isAnimating()) {
            this.aWw.cancelAnimation();
        }
        this.aWx.setVisibility(8);
        if (this.aWE != null) {
            this.aWE.Hq();
        }
    }

    public void setComboListener(a aVar) {
        this.aWE = aVar;
    }

    public boolean Hp() {
        return this.aWx == null || this.aWx.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            Ho();
        } catch (Exception e) {
        }
    }
}
