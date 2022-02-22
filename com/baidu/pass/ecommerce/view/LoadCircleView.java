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
import c.a.f0.a.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public class LoadCircleView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_ALPHA_VALUE = 255;
    public static final int MSG_REFRESH_ANIMATION = 4097;
    public static final String TAG = "LoadCircleView";
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes11.dex */
    public static class MainThreadHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<LoadCircleView> mWeakLoadCircleView;

        public MainThreadHandler(LoadCircleView loadCircleView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadCircleView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mWeakLoadCircleView = new WeakReference<>(loadCircleView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LoadCircleView loadCircleView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 4097 && (loadCircleView = this.mWeakLoadCircleView.get()) != null) {
                loadCircleView.invalidate();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadCircleView(Context context, float f2, int i2) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Float.valueOf(f2), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEndRadius = f2;
        this.mMaskColor = i2;
        initialize();
    }

    private void initialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
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
    }

    private void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mCurrentRadius = 0.0f;
            this.mDegree = 0.0f;
            this.mAlphaRatio = 0.0f;
        }
    }

    public void begin() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.mIsBegin) {
            return;
        }
        this.mIsBegin = true;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.baidu.pass.ecommerce.view.LoadCircleView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LoadCircleView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    this.this$0.mCurrentRadius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.this$0.mPrimaryPaint.setShader(new LinearGradient((this.this$0.mWidth / 2) - this.this$0.mCurrentRadius, 0.0f, (this.this$0.mWidth / 2) + this.this$0.mCurrentRadius, 0.0f, this.this$0.getResources().getColor(b.sapi_sdk_mms_voice_primary_start), this.this$0.getResources().getColor(b.sapi_sdk_mms_voice_primary_end), Shader.TileMode.MIRROR));
                    this.this$0.mSecondaryPaint.setShader(new LinearGradient((this.this$0.mWidth / 2) - this.this$0.mCurrentRadius, 0.0f, (this.this$0.mWidth / 2) + this.this$0.mCurrentRadius, 0.0f, this.this$0.getResources().getColor(b.sapi_sdk_mms_voice_secondary_start), this.this$0.getResources().getColor(b.sapi_sdk_mms_voice_secondary_end), Shader.TileMode.MIRROR));
                }
            }
        };
        float f2 = this.mEndRadius;
        float f3 = f2 / 3.0f;
        float f4 = (f2 * 23.0f) / 21.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f3, f4);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(this.mSizeIncreaseTime);
        ofFloat.addUpdateListener(animatorUpdateListener);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f4, this.mEndRadius);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.setDuration(this.mSizeDecreaseTime);
        ofFloat2.addUpdateListener(animatorUpdateListener);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat3.setInterpolator(new DecelerateInterpolator());
        ofFloat3.setDuration(this.mAlphaAnimatorTime);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.baidu.pass.ecommerce.view.LoadCircleView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LoadCircleView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    this.this$0.mAlphaRatio = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.this$0.mPrimaryPaint.setAlpha((int) (this.this$0.mAlphaRatio * 255.0f));
                    this.this$0.mSecondaryPaint.setAlpha((int) (this.this$0.mSecondaryAlphaRatio * 255.0f * this.this$0.mAlphaRatio));
                    this.this$0.invalidate();
                }
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
        this.mAnimatorSet.addListener(new AnimatorListenerAdapter(this) { // from class: com.baidu.pass.ecommerce.view.LoadCircleView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LoadCircleView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) || this.this$0.mTimer == null) {
                    return;
                }
                this.this$0.mTimer.schedule(new TimerTask(this) { // from class: com.baidu.pass.ecommerce.view.LoadCircleView.3.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass3 this$1;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable3.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                            this.this$1.this$0.mMainHandler.sendEmptyMessage(4097);
                        }
                    }
                }, 0L, 16L);
            }
        });
    }

    public void finish() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.mIsBegin) {
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
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
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
            float f2 = this.mDegree + 6.0f;
            this.mDegree = f2;
            if (f2 >= 360.0f) {
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

    public void setMaskColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.mMaskColor = i2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadCircleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
}
