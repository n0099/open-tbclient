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
    private RelativeLayout aXK;
    private View aXL;
    private Animation aXM;
    private ScaleAnimation aXN;
    private LottieAnimationView aXO;
    private View aXP;
    private ObjectAnimator aXQ;
    private ImageView aXR;
    private AnimatorSet aXS;
    private ObjectAnimator aXT;
    private long aXU;
    private boolean aXV;
    private a aXW;
    private AlaRoundProgress aXX;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void HR();
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
        this.aXP = findViewById(a.f.combo_container);
        this.aXX = (AlaRoundProgress) findViewById(a.f.ala_round_progress);
        this.aXK = (RelativeLayout) findViewById(a.f.combo_btn);
        this.aXK.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aXR = (ImageView) findViewById(a.f.combo_text_icon);
        this.aXL = findViewById(a.f.combo_bg);
        this.aXM = AnimationUtils.loadAnimation(this.mContext, a.C0197a.ala_gift_rotate_anim);
        this.aXM.setInterpolator(new LinearInterpolator());
        this.aXN = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0197a.ala_gift_scale_anim);
        this.aXO = (LottieAnimationView) findViewById(a.f.lottie_balloon);
        this.aXO.setAnimation("ala_gift_combo_balloon.json");
        this.aXO.loop(false);
        this.aXX.setMax(100);
        this.aXX.setProgress(0);
        this.aXQ = ObjectAnimator.ofInt(this.aXX, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.aXQ.setInterpolator(new LinearInterpolator());
        this.aXQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aXQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aXP.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.aXW != null) {
                    AlaComboBtnAnimView.this.aXW.HR();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aXK, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aXT = ObjectAnimator.ofFloat(this.aXK, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aXT.setRepeatCount(0);
        this.aXT.setDuration(1000L);
        this.aXS = new AnimatorSet();
        this.aXS.play(ofFloat).with(this.aXT);
        this.aXT.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aXV) {
                    AlaComboBtnAnimView.this.aXK.startAnimation(AlaComboBtnAnimView.this.aXN);
                }
            }
        });
    }

    public void HN() {
        this.aXV = System.currentTimeMillis() - this.aXU < 1010;
        this.aXU = System.currentTimeMillis();
        this.aXN.cancel();
        if (this.aXS.isRunning()) {
            this.aXS.cancel();
        }
        this.aXS.start();
        this.aXO.playAnimation();
        this.aXQ.start();
    }

    public void HO() {
        this.aXP.setVisibility(0);
        this.aXL.startAnimation(this.aXM);
        this.aXK.startAnimation(this.aXN);
        this.aXQ.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aXK != null) {
            this.aXK.setOnClickListener(onClickListener);
        }
    }

    public void HP() {
        this.aXM.cancel();
        this.aXN.cancel();
        if (this.aXQ.isRunning()) {
            this.aXQ.cancel();
        }
        if (this.aXS.isRunning()) {
            this.aXS.cancel();
        }
        if (this.aXO.isAnimating()) {
            this.aXO.cancelAnimation();
        }
        this.aXP.setVisibility(8);
        if (this.aXW != null) {
            this.aXW.HR();
        }
    }

    public void setComboListener(a aVar) {
        this.aXW = aVar;
    }

    public boolean HQ() {
        return this.aXP == null || this.aXP.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            HP();
        } catch (Exception e) {
        }
    }
}
