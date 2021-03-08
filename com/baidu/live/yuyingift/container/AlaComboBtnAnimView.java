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
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.gift.g;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class AlaComboBtnAnimView extends FrameLayout {
    private a bZO;
    private AlaRoundProgress bZP;
    private final int bZQ;
    private g bZR;
    private RelativeLayout baP;
    private View baQ;
    private Animation baR;
    private LottieAnimationView baT;
    private View baU;
    private ObjectAnimator baV;
    private AnimatorSet baX;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface a {
        void j(g gVar);
    }

    public AlaComboBtnAnimView(Context context) {
        this(context, null);
    }

    public AlaComboBtnAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaComboBtnAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bZQ = 3000;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_combo_btn_anim_view, this);
        this.baU = findViewById(a.f.combo_container);
        this.bZP = (AlaRoundProgress) findViewById(a.f.ala_round_progress);
        this.baP = (RelativeLayout) findViewById(a.f.combo_btn);
        this.baP.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.baQ = findViewById(a.f.combo_bg);
        this.baR = AnimationUtils.loadAnimation(this.mContext, a.C0201a.yuyin_ala_gift_rotate_anim);
        this.baR.setInterpolator(new LinearInterpolator());
        this.baT = (LottieAnimationView) findViewById(a.f.lottie_balloon);
        this.baT.setAnimation("yuyin_ala_gift_combo_balloon.json");
        this.baT.loop(false);
        this.bZP.setMax(100);
        this.bZP.setProgress(0);
        this.baV = ObjectAnimator.ofInt(this.bZP, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.baV.setInterpolator(new LinearInterpolator());
        this.baV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.baV.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.baU.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.bZO != null) {
                    AlaComboBtnAnimView.this.bZO.j(AlaComboBtnAnimView.this.bZR);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.baP, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(IMConnection.RETRY_DELAY_TIMES);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.baP, "scaleY", 1.0f, 0.8f, 1.0f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.baX = new AnimatorSet();
        this.baX.play(ofFloat).with(ofFloat2);
    }

    public void h(g gVar) {
        this.bZR = gVar;
        if (this.baX.isRunning()) {
            this.baX.cancel();
        }
        this.baX.start();
        this.baT.playAnimation();
        this.baV.start();
    }

    public void i(g gVar) {
        this.bZR = gVar;
        this.baU.setVisibility(0);
        this.baQ.startAnimation(this.baR);
        this.baX.start();
        this.baV.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.baP != null) {
            this.baP.setOnClickListener(onClickListener);
        }
    }

    public void FV() {
        this.baR.cancel();
        if (this.baV.isRunning()) {
            this.baV.cancel();
        }
        if (this.baX.isRunning()) {
            this.baX.cancel();
        }
        if (this.baT.isAnimating()) {
            this.baT.cancelAnimation();
        }
        this.baU.setVisibility(8);
        if (this.bZO != null) {
            this.bZO.j(this.bZR);
        }
    }

    public void setComboListener(a aVar) {
        this.bZO = aVar;
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
