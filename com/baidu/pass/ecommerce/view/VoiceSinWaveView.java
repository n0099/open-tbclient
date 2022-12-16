package com.baidu.pass.ecommerce.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class VoiceSinWaveView extends View implements VoiceWaveInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHANGE_PHASE = 4097;
    public static final int MAX_ALPHA_VALUE = 255;
    public static final String TAG = "VoiceSinWaveView";
    public transient /* synthetic */ FieldHolder $fh;
    public int mDensity;
    public ValueAnimator mFadeAnimator;
    public long mFadeAnimatorTime;
    public int mFadeX;
    public Paint mFillPaint;
    public Path mFillPath;
    public boolean mHasSendFadeToQuarter;
    public int mHeight;
    public boolean mIsNeedGetSize;
    public boolean mIsPermitReceiveVolume;
    public float mLastVolume;
    public long mLastVolumeTimeMillis;
    public LinearInterpolator mLinearInterpolator;
    public MainThreadHandler mMainHandler;
    public Paint mMaskPaint;
    public float mMaxAmplitude;
    public float mNormedAmplitude;
    public ViewGroup mParent;
    public PorterDuffXfermode mPorterDuffXfermode;
    public float mPrimaryFrequency;
    public Paint mPrimaryPaint;
    public Path mPrimaryPath;
    public float mPrimaryPhase;
    public float mPrimaryPhaseShift;
    public int mPrimaryWidth;
    public float mSecondaryAlphaRatio;
    public float mSecondaryFrequency;
    public Paint mSecondaryPaint;
    public Path mSecondaryPath;
    public float mSecondaryPhase;
    public float mSecondaryPhaseShift;
    public int mSecondaryWidth;
    public Bitmap mSinWaveBitmap;
    public Canvas mSinWaveCanvas;
    public TimerThread mTimerThread;
    public ValueAnimator mValueAnimator;
    public VoiceWaveCallBack mVoiceWaveCallBack;
    public long mVoiceWaveDecreaseTime;
    public float mVolume;
    public int mWidth;

    /* loaded from: classes2.dex */
    public interface VoiceWaveCallBack {
        void fadeOut();

        void fadeToQuarter();
    }

    /* loaded from: classes2.dex */
    public static class MainThreadHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<VoiceSinWaveView> mWeakVoiceSinWaveView;

        public MainThreadHandler(VoiceSinWaveView voiceSinWaveView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceSinWaveView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mWeakVoiceSinWaveView = new WeakReference<>(voiceSinWaveView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VoiceSinWaveView voiceSinWaveView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, message) != null) || message.what != 4097 || (voiceSinWaveView = this.mWeakVoiceSinWaveView.get()) == null) {
                return;
            }
            voiceSinWaveView.drawFrame();
            voiceSinWaveView.invalidate();
            voiceSinWaveView.changePhase();
        }
    }

    /* loaded from: classes2.dex */
    public static class TimerThread extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isCancel;
        public WeakReference<VoiceSinWaveView> mWeakVoiceSinWaveView;

        public TimerThread(VoiceSinWaveView voiceSinWaveView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceSinWaveView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isCancel = false;
            this.mWeakVoiceSinWaveView = new WeakReference<>(voiceSinWaveView);
        }

        public synchronized boolean getCancel() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    z = this.isCancel;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                while (!getCancel()) {
                    VoiceSinWaveView voiceSinWaveView = this.mWeakVoiceSinWaveView.get();
                    if (voiceSinWaveView != null) {
                        voiceSinWaveView.mMainHandler.sendEmptyMessage(4097);
                        try {
                            Thread.sleep(16L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        public synchronized void setCancel(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                synchronized (this) {
                    this.isCancel = z;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoiceSinWaveView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceSinWaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLastVolume = 0.0f;
        this.mVolume = 0.0f;
        this.mLastVolumeTimeMillis = 0L;
        this.mPrimaryWidth = 2;
        this.mSecondaryWidth = 2;
        this.mMaxAmplitude = 0.0f;
        this.mNormedAmplitude = 0.0f;
        this.mSecondaryAlphaRatio = 0.5f;
        this.mDensity = 2;
        this.mPrimaryFrequency = 2.0f;
        this.mSecondaryFrequency = 1.6f;
        this.mPrimaryPhaseShift = -0.2f;
        this.mSecondaryPhaseShift = -0.1994f;
        this.mPrimaryPhase = 0.0f;
        this.mSecondaryPhase = 3.5f;
        this.mVoiceWaveDecreaseTime = 200L;
        this.mFadeAnimatorTime = 250L;
        this.mIsPermitReceiveVolume = false;
        this.mHasSendFadeToQuarter = false;
        this.mFadeX = 0;
        this.mIsNeedGetSize = true;
        this.mMainHandler = new MainThreadHandler(this);
        initialize();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoiceSinWaveView(Context context, VoiceWaveCallBack voiceWaveCallBack) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, voiceWaveCallBack};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mVoiceWaveCallBack = voiceWaveCallBack;
    }

    public void setCallBack(VoiceWaveCallBack voiceWaveCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, voiceWaveCallBack) == null) {
            this.mVoiceWaveCallBack = voiceWaveCallBack;
        }
    }

    private void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            Log.d(TAG, "cancel.");
            ValueAnimator valueAnimator = this.mValueAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.mValueAnimator = null;
            }
            ValueAnimator valueAnimator2 = this.mFadeAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.mFadeAnimator = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changePhase() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            float f = this.mPrimaryPhase + this.mPrimaryPhaseShift;
            this.mPrimaryPhase = f;
            this.mSecondaryPhase += this.mSecondaryPhaseShift;
            if (f < -3.4028235E38f) {
                this.mPrimaryPhase = 0.0f;
                this.mSecondaryPhase = 3.5f;
            }
        }
    }

    @Override // com.baidu.pass.ecommerce.view.VoiceWaveInterface
    public void removeFromParent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Log.d(TAG, "removeFromParent.");
            ViewGroup viewGroup = this.mParent;
            if (viewGroup == null) {
                return;
            }
            viewGroup.removeView(this);
            this.mParent = null;
            cancel();
        }
    }

    @Override // com.baidu.pass.ecommerce.view.VoiceWaveInterface
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Log.d(TAG, "start.");
            if (this.mIsPermitReceiveVolume) {
                return;
            }
            this.mIsPermitReceiveVolume = true;
            this.mHasSendFadeToQuarter = false;
            TimerThread timerThread = new TimerThread(this);
            this.mTimerThread = timerThread;
            timerThread.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawFrame() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65554, this) != null) || this.mIsNeedGetSize) {
            return;
        }
        float f = (this.mVolume / 100.0f) * 0.8f;
        this.mNormedAmplitude = f;
        this.mNormedAmplitude = Math.max(0.05f, f);
        this.mPrimaryPath.rewind();
        this.mSecondaryPath.rewind();
        this.mFillPath.rewind();
        this.mPrimaryPath.moveTo(0.0f, getY(0, this.mWidth, this.mHeight, this.mMaxAmplitude, this.mNormedAmplitude, this.mPrimaryFrequency, this.mPrimaryPhase));
        int i2 = 1;
        while (true) {
            i = this.mWidth;
            if (i2 > i) {
                break;
            }
            this.mPrimaryPath.lineTo(i2, getY(i2, i, this.mHeight, this.mMaxAmplitude, this.mNormedAmplitude, this.mPrimaryFrequency, this.mPrimaryPhase));
            i2 += SapiUtils.dip2px(getContext(), this.mDensity);
        }
        this.mPrimaryPath.lineTo(this.mWidth, getY(i, i, this.mHeight, this.mMaxAmplitude, this.mNormedAmplitude, this.mPrimaryFrequency, this.mPrimaryPhase));
        int i3 = this.mWidth;
        this.mSecondaryPath.moveTo(this.mWidth, getY(i3, i3, this.mHeight, this.mMaxAmplitude, this.mNormedAmplitude * 0.8f, this.mSecondaryFrequency, this.mSecondaryPhase));
        int i4 = this.mWidth - 1;
        while (i4 >= 0) {
            this.mSecondaryPath.lineTo(i4, getY(i4, this.mWidth, this.mHeight, this.mMaxAmplitude, this.mNormedAmplitude * 0.8f, this.mSecondaryFrequency, this.mSecondaryPhase));
            i4 -= SapiUtils.dip2px(getContext(), this.mDensity);
        }
        this.mSecondaryPath.lineTo(0.0f, getY(0, this.mWidth, this.mHeight, this.mMaxAmplitude, this.mNormedAmplitude * 0.8f, this.mSecondaryFrequency, this.mSecondaryPhase));
        this.mFillPath.addPath(this.mPrimaryPath);
        this.mFillPath.addPath(this.mSecondaryPath);
    }

    private float getY(int i, float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            return ((1.0f - ((float) Math.pow(((i * 2) / f) - 1.0f, 2.0d))) * f3 * f4 * ((float) Math.sin(((i / f) * 6.283185307179586d * f5) + f6))) + (f2 * 0.5f);
        }
        return invokeCommon.floatValue;
    }

    private void initialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            Log.d(TAG, "initialize.");
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
            this.mSecondaryPaint.setAlpha((int) (this.mSecondaryAlphaRatio * 255.0f));
            this.mFillPaint = new Paint();
            this.mMaskPaint = new Paint();
            this.mPrimaryPath = new Path();
            this.mSecondaryPath = new Path();
            this.mFillPath = new Path();
            this.mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
            this.mLinearInterpolator = new LinearInterpolator();
        }
    }

    private void setPaintShader() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            Log.d(TAG, "setPaintShader.");
            int i = this.mHeight;
            if (i > 0 && this.mWidth > 0) {
                this.mMaxAmplitude = (i - 4.0f) * 0.5f;
                this.mPrimaryPaint.setShader(new LinearGradient(0.0f, 0.0f, this.mWidth, 0.0f, getResources().getColor(R.color.obfuscated_res_0x7f060a24), getResources().getColor(R.color.obfuscated_res_0x7f060a23), Shader.TileMode.MIRROR));
                this.mSecondaryPaint.setShader(new LinearGradient(0.0f, 0.0f, this.mWidth, 0.0f, getResources().getColor(R.color.obfuscated_res_0x7f060a26), getResources().getColor(R.color.obfuscated_res_0x7f060a25), Shader.TileMode.MIRROR));
                int color = getResources().getColor(R.color.obfuscated_res_0x7f060a22);
                int color2 = getResources().getColor(R.color.obfuscated_res_0x7f060a21);
                float f = this.mHeight / 2;
                float f2 = this.mMaxAmplitude;
                this.mFillPaint.setShader(new LinearGradient(0.0f, f - f2, 0.0f, f + f2, color, color2, Shader.TileMode.MIRROR));
            }
        }
    }

    @Override // com.baidu.pass.ecommerce.view.VoiceWaveInterface
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Log.d(TAG, "stop.");
            if (!this.mIsPermitReceiveVolume) {
                return;
            }
            this.mIsPermitReceiveVolume = false;
            ValueAnimator valueAnimator = this.mValueAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.mValueAnimator = null;
            }
            float f = this.mVolume;
            if (f > 10.0f) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(f, 10.0f);
                this.mValueAnimator = ofFloat;
                ofFloat.setDuration(this.mVoiceWaveDecreaseTime);
                this.mValueAnimator.setInterpolator(this.mLinearInterpolator);
                this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.baidu.pass.ecommerce.view.VoiceSinWaveView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VoiceSinWaveView this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                            this.this$0.mVolume = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                        }
                    }
                });
                this.mValueAnimator.start();
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(0, this.mWidth / 2);
            this.mFadeAnimator = ofInt;
            ofInt.setDuration(this.mFadeAnimatorTime);
            this.mFadeAnimator.setInterpolator(new AccelerateInterpolator());
            this.mFadeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, new int[]{0, -16777216, -16777216, -16777216, 0}, new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f}) { // from class: com.baidu.pass.ecommerce.view.VoiceSinWaveView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VoiceSinWaveView this$0;
                public final /* synthetic */ int[] val$colors;
                public final /* synthetic */ float[] val$positions;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$colors = r7;
                    this.val$positions = r8;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                        this.this$0.mFadeX = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                        if (!this.this$0.mHasSendFadeToQuarter && this.this$0.mFadeX > (this.this$0.mWidth * 5) / 14) {
                            if (this.this$0.mVoiceWaveCallBack != null) {
                                this.this$0.mVoiceWaveCallBack.fadeToQuarter();
                            }
                            this.this$0.mHasSendFadeToQuarter = true;
                        }
                        this.this$0.mMaskPaint.setShader(new LinearGradient(this.this$0.mFadeX, 0.0f, this.this$0.mWidth - this.this$0.mFadeX, 0.0f, this.val$colors, this.val$positions, Shader.TileMode.MIRROR));
                    }
                }
            });
            this.mFadeAnimator.addListener(new AnimatorListenerAdapter(this) { // from class: com.baidu.pass.ecommerce.view.VoiceSinWaveView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VoiceSinWaveView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.this$0.mVoiceWaveCallBack != null) {
                            this.this$0.mVoiceWaveCallBack.fadeOut();
                        }
                    }
                }
            });
            this.mFadeAnimator.start();
        }
    }

    @Override // com.baidu.pass.ecommerce.view.VoiceWaveInterface
    public void changeVolume(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048576, this, f) == null) && this.mIsPermitReceiveVolume && f >= 0.0f && f <= 100.0f) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = 100;
            if (0 == this.mLastVolumeTimeMillis) {
                this.mLastVolumeTimeMillis = currentTimeMillis - 100;
            }
            long j2 = currentTimeMillis - this.mLastVolumeTimeMillis;
            if (j2 > 0) {
                j = j2;
            }
            ValueAnimator valueAnimator = this.mValueAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.mValueAnimator = null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.mLastVolume, f);
            this.mValueAnimator = ofFloat;
            ofFloat.setDuration(j);
            this.mValueAnimator.setInterpolator(this.mLinearInterpolator);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.baidu.pass.ecommerce.view.VoiceSinWaveView.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VoiceSinWaveView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                        this.this$0.mVolume = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                        VoiceSinWaveView voiceSinWaveView = this.this$0;
                        voiceSinWaveView.mLastVolume = voiceSinWaveView.mVolume;
                    }
                }
            });
            this.mValueAnimator.start();
            this.mLastVolumeTimeMillis = currentTimeMillis;
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Log.d(TAG, "onDetachedFromWindow.");
            super.onDetachedFromWindow();
            TimerThread timerThread = this.mTimerThread;
            if (timerThread != null) {
                timerThread.setCancel(true);
            }
            MainThreadHandler mainThreadHandler = this.mMainHandler;
            if (mainThreadHandler != null) {
                mainThreadHandler.removeMessages(4097);
                Log.d(TAG, "remove change phase message.");
            }
            reset();
        }
    }

    @Override // com.baidu.pass.ecommerce.view.VoiceWaveInterface
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Log.d(TAG, "reset.");
            this.mVolume = 0.0f;
            this.mLastVolume = 0.0f;
            this.mLastVolumeTimeMillis = 0L;
            this.mPrimaryPhase = 0.0f;
            this.mSecondaryPhase = 3.5f;
            this.mIsPermitReceiveVolume = false;
            this.mHasSendFadeToQuarter = false;
            this.mIsNeedGetSize = true;
            this.mFadeX = 0;
            Bitmap bitmap = this.mSinWaveBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.mSinWaveBitmap = null;
                this.mSinWaveCanvas = null;
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.mIsNeedGetSize) {
                ViewGroup viewGroup = this.mParent;
                if (viewGroup != null) {
                    this.mWidth = viewGroup.getWidth();
                    this.mHeight = this.mParent.getHeight();
                }
                int i2 = this.mWidth;
                if (i2 > 0 && (i = this.mHeight) > 0) {
                    if (this.mSinWaveBitmap == null) {
                        this.mSinWaveBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                        this.mSinWaveCanvas = new Canvas(this.mSinWaveBitmap);
                    }
                    setPaintShader();
                    this.mIsNeedGetSize = false;
                } else {
                    return;
                }
            }
            if (this.mIsPermitReceiveVolume) {
                canvas.drawColor(0);
                canvas.drawPath(this.mFillPath, this.mFillPaint);
                canvas.drawPath(this.mSecondaryPath, this.mSecondaryPaint);
                canvas.drawPath(this.mPrimaryPath, this.mPrimaryPaint);
                return;
            }
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, this.mWidth, this.mHeight, null, 31);
            int i3 = this.mFadeX;
            canvas.drawRect(i3, 0.0f, this.mWidth - i3, this.mHeight, this.mMaskPaint);
            this.mMaskPaint.setXfermode(this.mPorterDuffXfermode);
            if (this.mSinWaveBitmap != null) {
                this.mSinWaveCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                this.mSinWaveCanvas.drawPath(this.mFillPath, this.mFillPaint);
                this.mSinWaveCanvas.drawPath(this.mSecondaryPath, this.mSecondaryPaint);
                this.mSinWaveCanvas.drawPath(this.mPrimaryPath, this.mPrimaryPaint);
                canvas.drawBitmap(this.mSinWaveBitmap, 0.0f, 0.0f, this.mMaskPaint);
            }
            this.mMaskPaint.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        }
    }

    @Override // com.baidu.pass.ecommerce.view.VoiceWaveInterface
    public void showInParentView(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewGroup) == null) {
            Log.d(TAG, "showInParentView.");
            if (viewGroup == null || this.mParent != null) {
                return;
            }
            this.mIsNeedGetSize = true;
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
            this.mParent = viewGroup;
        }
    }
}
