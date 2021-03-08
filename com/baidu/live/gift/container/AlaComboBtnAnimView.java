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
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class AlaComboBtnAnimView extends FrameLayout {
    private RelativeLayout baP;
    private View baQ;
    private Animation baR;
    private ScaleAnimation baS;
    private LottieAnimationView baT;
    private View baU;
    private ObjectAnimator baV;
    private ImageView baW;
    private AnimatorSet baX;
    private ObjectAnimator baY;
    private long baZ;
    private boolean bba;
    private a bbb;
    private AlaRoundProgress bbc;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface a {
        void FX();
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
        LayoutInflater.from(this.mContext).inflate(a.g.ala_combo_btn_anim_view, this);
        this.baU = findViewById(a.f.combo_container);
        this.bbc = (AlaRoundProgress) findViewById(a.f.ala_round_progress);
        this.baP = (RelativeLayout) findViewById(a.f.combo_btn);
        this.baP.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.baW = (ImageView) findViewById(a.f.combo_text_icon);
        this.baQ = findViewById(a.f.combo_bg);
        this.baR = AnimationUtils.loadAnimation(this.mContext, a.C0201a.ala_gift_rotate_anim);
        this.baR.setInterpolator(new LinearInterpolator());
        this.baS = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0201a.ala_gift_scale_anim);
        this.baT = (LottieAnimationView) findViewById(a.f.lottie_balloon);
        this.baT.setAnimation("ala_gift_combo_balloon.json");
        this.baT.loop(false);
        this.bbc.setMax(100);
        this.bbc.setProgress(0);
        this.baV = ObjectAnimator.ofInt(this.bbc, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.baV.setInterpolator(new LinearInterpolator());
        this.baV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.baV.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.baU.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.bbb != null) {
                    AlaComboBtnAnimView.this.bbb.FX();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.baP, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.baY = ObjectAnimator.ofFloat(this.baP, "scaleY", 1.0f, 0.8f, 1.0f);
        this.baY.setRepeatCount(0);
        this.baY.setDuration(1000L);
        this.baX = new AnimatorSet();
        this.baX.play(ofFloat).with(this.baY);
        this.baY.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.bba) {
                    AlaComboBtnAnimView.this.baP.startAnimation(AlaComboBtnAnimView.this.baS);
                }
            }
        });
    }

    public void FT() {
        this.bba = System.currentTimeMillis() - this.baZ < 1010;
        this.baZ = System.currentTimeMillis();
        this.baS.cancel();
        if (this.baX.isRunning()) {
            this.baX.cancel();
        }
        this.baX.start();
        this.baT.playAnimation();
        this.baV.start();
    }

    public void FU() {
        this.baU.setVisibility(0);
        this.baQ.startAnimation(this.baR);
        this.baP.startAnimation(this.baS);
        this.baV.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.baP != null) {
            this.baP.setOnClickListener(onClickListener);
        }
    }

    public void FV() {
        if (this.baR != null) {
            this.baR.cancel();
        }
        if (this.baS != null) {
            this.baS.cancel();
        }
        if (this.baV != null && this.baV.isRunning()) {
            this.baV.cancel();
        }
        if (this.baX != null && this.baX.isRunning()) {
            this.baX.cancel();
        }
        if (this.baT != null && this.baT.isAnimating()) {
            this.baT.cancelAnimation();
        }
        if (this.baU != null) {
            this.baU.setVisibility(8);
        }
        if (this.bbb != null) {
            this.bbb.FX();
        }
    }

    public void setComboListener(a aVar) {
        this.bbb = aVar;
    }

    public boolean FW() {
        return this.baU == null || this.baU.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            FV();
        } catch (Exception e) {
        }
    }
}
