package com.baidu.pass.ecommerce.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class LoadCircleView extends View {
    public static final int MAX_ALPHA_VALUE = 255;
    public static final int MSG_REFRESH_ANIMATION = 4097;
    public static final String TAG = "LoadCircleView";
    public long mAlphaAnimatorTime;
    public float mAlphaRatio;
    public AnimatorSet mAnimatorSet;
    public float mCurrentRadius;
    public float mDegree;
    public float mEndRadius;
    public int mHeight;
    public boolean mIsBegin;
    public MainThreadHandler mMainHandler;
    public int mMaskColor;
    public Paint mMaskPaint;
    public float mMaxInterval;
    public Paint mPrimaryPaint;
    public int mPrimaryWidth;
    public float mSecondaryAlphaRatio;
    public Paint mSecondaryPaint;
    public int mSecondaryWidth;
    public long mSizeDecreaseTime;
    public long mSizeIncreaseTime;
    public Timer mTimer;
    public int mWidth;

    /* loaded from: classes3.dex */
    public static class MainThreadHandler extends Handler {
        public WeakReference<LoadCircleView> mWeakLoadCircleView;

        public MainThreadHandler(LoadCircleView loadCircleView) {
            this.mWeakLoadCircleView = new WeakReference<>(loadCircleView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LoadCircleView loadCircleView;
            if (message.what == 4097 && (loadCircleView = this.mWeakLoadCircleView.get()) != null) {
                loadCircleView.invalidate();
            }
        }
    }

    public LoadCircleView(Context context, float f, int i) {
        this(context, null);
        this.mEndRadius = f;
        this.mMaskColor = i;
        initialize();
    }

    public LoadCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPrimaryWidth = 2;
        this.mSecondaryWidth = 2;
        this.mMaxInterval = 1.0f;
        this.mSecondaryAlphaRatio = 0.25f;
        this.mAlphaRatio = 0.0f;
        this.mDegree = 0.0f;
        this.mSizeIncreaseTime = 175L;
        this.mSizeDecreaseTime = 105L;
        this.mAlphaAnimatorTime = 280L;
        this.mIsBegin = false;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    private void initialize() {
        this.mMainHandler = new MainThreadHandler(this);
        if (getContext().getResources().getDisplayMetrics().density <= 2.0f) {
            this.mPrimaryWidth = 1;
            this.mSecondaryWidth = 1;
        }
        Paint paint = new Paint();
        this.mPrimaryPaint = paint;
        paint.setAntiAlias(true);
        this.mPrimaryPaint.setStyle(Paint.Style.STROKE);
        this.mPrimaryPaint.setStrokeWidth(this.mPrimaryWidth);
        Paint paint2 = new Paint();
        this.mSecondaryPaint = paint2;
        paint2.setAntiAlias(true);
        this.mSecondaryPaint.setStyle(Paint.Style.STROKE);
        this.mSecondaryPaint.setStrokeWidth(this.mSecondaryWidth);
        if (this.mMaskColor != -1) {
            Paint paint3 = new Paint();
            this.mMaskPaint = paint3;
            paint3.setAntiAlias(true);
            this.mMaskPaint.setStyle(Paint.Style.FILL);
            this.mMaskPaint.setColor(this.mMaskColor);
        }
    }

    private void reset() {
        this.mCurrentRadius = 0.0f;
        this.mDegree = 0.0f;
        this.mAlphaRatio = 0.0f;
    }

    public void finish() {
        if (!this.mIsBegin) {
            return;
        }
        this.mIsBegin = false;
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.mAnimatorSet = null;
        }
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        this.mMainHandler.removeMessages(4097);
        reset();
    }

    public void begin() {
        if (this.mIsBegin) {
            return;
        }
        this.mIsBegin = true;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.pass.ecommerce.view.LoadCircleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadCircleView.this.mCurrentRadius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LoadCircleView.this.mPrimaryPaint.setShader(new LinearGradient((LoadCircleView.this.mWidth / 2) - LoadCircleView.this.mCurrentRadius, 0.0f, (LoadCircleView.this.mWidth / 2) + LoadCircleView.this.mCurrentRadius, 0.0f, LoadCircleView.this.getResources().getColor(R.color.obfuscated_res_0x7f060a5e), LoadCircleView.this.getResources().getColor(R.color.obfuscated_res_0x7f060a5d), Shader.TileMode.MIRROR));
                LoadCircleView.this.mSecondaryPaint.setShader(new LinearGradient((LoadCircleView.this.mWidth / 2) - LoadCircleView.this.mCurrentRadius, 0.0f, (LoadCircleView.this.mWidth / 2) + LoadCircleView.this.mCurrentRadius, 0.0f, LoadCircleView.this.getResources().getColor(R.color.obfuscated_res_0x7f060a60), LoadCircleView.this.getResources().getColor(R.color.obfuscated_res_0x7f060a5f), Shader.TileMode.MIRROR));
            }
        };
        float f = this.mEndRadius;
        float f2 = f / 3.0f;
        float f3 = (f * 23.0f) / 21.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(this.mSizeIncreaseTime);
        ofFloat.addUpdateListener(animatorUpdateListener);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f3, this.mEndRadius);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.setDuration(this.mSizeDecreaseTime);
        ofFloat2.addUpdateListener(animatorUpdateListener);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat3.setInterpolator(new DecelerateInterpolator());
        ofFloat3.setDuration(this.mAlphaAnimatorTime);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.pass.ecommerce.view.LoadCircleView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadCircleView.this.mAlphaRatio = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LoadCircleView.this.mPrimaryPaint.setAlpha((int) (LoadCircleView.this.mAlphaRatio * 255.0f));
                LoadCircleView.this.mSecondaryPaint.setAlpha((int) (LoadCircleView.this.mSecondaryAlphaRatio * 255.0f * LoadCircleView.this.mAlphaRatio));
                LoadCircleView.this.invalidate();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.mAnimatorSet = animatorSet;
        animatorSet.play(ofFloat3).with(ofFloat);
        this.mAnimatorSet.play(ofFloat2).after(ofFloat);
        this.mAnimatorSet.start();
        if (this.mTimer == null) {
            try {
                this.mTimer = new Timer();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.mAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.pass.ecommerce.view.LoadCircleView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (LoadCircleView.this.mTimer != null) {
                    LoadCircleView.this.mTimer.schedule(new TimerTask() { // from class: com.baidu.pass.ecommerce.view.LoadCircleView.3.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            LoadCircleView.this.mMainHandler.sendEmptyMessage(4097);
                        }
                    }, 0L, 16L);
                }
            }
        });
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        if (this.mDegree == 0.0f) {
            this.mWidth = ((ViewGroup) getParent()).getWidth();
            int height = ((ViewGroup) getParent()).getHeight();
            this.mHeight = height;
            if (this.mEndRadius >= (Math.min(this.mWidth, height) / 2) * 0.8f) {
                this.mEndRadius = (Math.min(this.mWidth, this.mHeight) / 2) * 0.8f;
            }
        }
        float f = this.mDegree + 6.0f;
        this.mDegree = f;
        if (f >= 360.0f) {
            this.mDegree = 0.0f;
        }
        canvas.save();
        canvas.rotate(this.mDegree, this.mWidth / 2, (this.mHeight / 2) + (SapiUtils.dip2px(getContext(), this.mMaxInterval) - 1.0f));
        if (this.mMaskColor != -1) {
            canvas.drawCircle(this.mWidth / 2, this.mHeight / 2, this.mCurrentRadius + SapiUtils.dip2px(getContext(), this.mPrimaryWidth), this.mMaskPaint);
        }
        canvas.drawCircle(this.mWidth / 2, this.mHeight / 2, this.mCurrentRadius, this.mPrimaryPaint);
        canvas.restore();
        canvas.rotate(this.mDegree, this.mWidth / 2, (this.mHeight / 2) - (SapiUtils.dip2px(getContext(), this.mMaxInterval) - 1.0f));
        canvas.drawCircle(this.mWidth / 2, this.mHeight / 2, this.mCurrentRadius, this.mSecondaryPaint);
    }
}
