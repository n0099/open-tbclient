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
    private RelativeLayout aRM;
    private View aRN;
    private Animation aRO;
    private ScaleAnimation aRP;
    private LottieAnimationView aRQ;
    private View aRR;
    private ObjectAnimator aRS;
    private ImageView aRT;
    private AnimatorSet aRU;
    private ObjectAnimator aRV;
    private long aRW;
    private boolean aRX;
    private a aRY;
    private AlaRoundProgress aRZ;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void FY();
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
        this.aRR = findViewById(a.g.combo_container);
        this.aRZ = (AlaRoundProgress) findViewById(a.g.ala_round_progress);
        this.aRM = (RelativeLayout) findViewById(a.g.combo_btn);
        this.aRM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aRT = (ImageView) findViewById(a.g.combo_text_icon);
        this.aRN = findViewById(a.g.combo_bg);
        this.aRO = AnimationUtils.loadAnimation(this.mContext, a.C0186a.ala_gift_rotate_anim);
        this.aRO.setInterpolator(new LinearInterpolator());
        this.aRP = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0186a.ala_gift_scale_anim);
        this.aRQ = (LottieAnimationView) findViewById(a.g.lottie_balloon);
        this.aRQ.setAnimation("ala_gift_combo_balloon.json");
        this.aRQ.loop(false);
        this.aRZ.setMax(100);
        this.aRZ.setProgress(0);
        this.aRS = ObjectAnimator.ofInt(this.aRZ, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.aRS.setInterpolator(new LinearInterpolator());
        this.aRS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aRS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aRR.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.aRY != null) {
                    AlaComboBtnAnimView.this.aRY.FY();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aRM, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aRV = ObjectAnimator.ofFloat(this.aRM, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aRV.setRepeatCount(0);
        this.aRV.setDuration(1000L);
        this.aRU = new AnimatorSet();
        this.aRU.play(ofFloat).with(this.aRV);
        this.aRV.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aRX) {
                    AlaComboBtnAnimView.this.aRM.startAnimation(AlaComboBtnAnimView.this.aRP);
                }
            }
        });
    }

    public void FU() {
        this.aRX = System.currentTimeMillis() - this.aRW < 1010;
        this.aRW = System.currentTimeMillis();
        this.aRP.cancel();
        if (this.aRU.isRunning()) {
            this.aRU.cancel();
        }
        this.aRU.start();
        this.aRQ.playAnimation();
        this.aRS.start();
    }

    public void FV() {
        this.aRR.setVisibility(0);
        this.aRN.startAnimation(this.aRO);
        this.aRM.startAnimation(this.aRP);
        this.aRS.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aRM != null) {
            this.aRM.setOnClickListener(onClickListener);
        }
    }

    public void FW() {
        this.aRO.cancel();
        this.aRP.cancel();
        if (this.aRS.isRunning()) {
            this.aRS.cancel();
        }
        if (this.aRU.isRunning()) {
            this.aRU.cancel();
        }
        if (this.aRQ.isAnimating()) {
            this.aRQ.cancelAnimation();
        }
        this.aRR.setVisibility(8);
        if (this.aRY != null) {
            this.aRY.FY();
        }
    }

    public void setComboListener(a aVar) {
        this.aRY = aVar;
    }

    public boolean FX() {
        return this.aRR == null || this.aRR.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            FW();
        } catch (Exception e) {
        }
    }
}
