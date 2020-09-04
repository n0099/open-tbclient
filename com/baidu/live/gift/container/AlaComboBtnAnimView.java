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
/* loaded from: classes7.dex */
public class AlaComboBtnAnimView extends FrameLayout {
    private RelativeLayout aPK;
    private View aPL;
    private Animation aPM;
    private ScaleAnimation aPN;
    private LottieAnimationView aPO;
    private View aPP;
    private ObjectAnimator aPQ;
    private ImageView aPR;
    private AnimatorSet aPS;
    private ObjectAnimator aPT;
    private long aPU;
    private boolean aPV;
    private a aPW;
    private AlaRoundProgress aPX;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a {
        void Fy();
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
        this.aPP = findViewById(a.g.combo_container);
        this.aPX = (AlaRoundProgress) findViewById(a.g.ala_round_progress);
        this.aPK = (RelativeLayout) findViewById(a.g.combo_btn);
        this.aPK.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aPR = (ImageView) findViewById(a.g.combo_text_icon);
        this.aPL = findViewById(a.g.combo_bg);
        this.aPM = AnimationUtils.loadAnimation(this.mContext, a.C0185a.ala_gift_rotate_anim);
        this.aPM.setInterpolator(new LinearInterpolator());
        this.aPN = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0185a.ala_gift_scale_anim);
        this.aPO = (LottieAnimationView) findViewById(a.g.lottie_balloon);
        this.aPO.setAnimation("ala_gift_combo_balloon.json");
        this.aPO.loop(false);
        this.aPX.setMax(100);
        this.aPX.setProgress(0);
        this.aPQ = ObjectAnimator.ofInt(this.aPX, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.aPQ.setInterpolator(new LinearInterpolator());
        this.aPQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aPQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aPP.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.aPW != null) {
                    AlaComboBtnAnimView.this.aPW.Fy();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aPK, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aPT = ObjectAnimator.ofFloat(this.aPK, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aPT.setRepeatCount(0);
        this.aPT.setDuration(1000L);
        this.aPS = new AnimatorSet();
        this.aPS.play(ofFloat).with(this.aPT);
        this.aPT.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aPV) {
                    AlaComboBtnAnimView.this.aPK.startAnimation(AlaComboBtnAnimView.this.aPN);
                }
            }
        });
    }

    public void Fu() {
        this.aPV = System.currentTimeMillis() - this.aPU < 1010;
        this.aPU = System.currentTimeMillis();
        this.aPN.cancel();
        if (this.aPS.isRunning()) {
            this.aPS.cancel();
        }
        this.aPS.start();
        this.aPO.playAnimation();
        this.aPQ.start();
    }

    public void Fv() {
        this.aPP.setVisibility(0);
        this.aPL.startAnimation(this.aPM);
        this.aPK.startAnimation(this.aPN);
        this.aPQ.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aPK != null) {
            this.aPK.setOnClickListener(onClickListener);
        }
    }

    public void Fw() {
        this.aPM.cancel();
        this.aPN.cancel();
        if (this.aPQ.isRunning()) {
            this.aPQ.cancel();
        }
        if (this.aPS.isRunning()) {
            this.aPS.cancel();
        }
        if (this.aPO.isAnimating()) {
            this.aPO.cancelAnimation();
        }
        this.aPP.setVisibility(8);
        if (this.aPW != null) {
            this.aPW.Fy();
        }
    }

    public void setComboListener(a aVar) {
        this.aPW = aVar;
    }

    public boolean Fx() {
        return this.aPP == null || this.aPP.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            Fw();
        } catch (Exception e) {
        }
    }
}
