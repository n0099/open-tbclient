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
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class VoiceSinWaveView extends View implements VoiceWaveInterface {
    public static final int CHANGE_PHASE = 4097;
    public static final int MAX_ALPHA_VALUE = 255;
    public static final String TAG = "VoiceSinWaveView";
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
        public WeakReference<VoiceSinWaveView> mWeakVoiceSinWaveView;

        public MainThreadHandler(VoiceSinWaveView voiceSinWaveView) {
            this.mWeakVoiceSinWaveView = new WeakReference<>(voiceSinWaveView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VoiceSinWaveView voiceSinWaveView;
            if (message.what == 4097 && (voiceSinWaveView = this.mWeakVoiceSinWaveView.get()) != null) {
                voiceSinWaveView.drawFrame();
                voiceSinWaveView.invalidate();
                voiceSinWaveView.changePhase();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class TimerThread extends Thread {
        public boolean isCancel = false;
        public WeakReference<VoiceSinWaveView> mWeakVoiceSinWaveView;

        public TimerThread(VoiceSinWaveView voiceSinWaveView) {
            this.mWeakVoiceSinWaveView = new WeakReference<>(voiceSinWaveView);
        }

        public synchronized void setCancel(boolean z) {
            this.isCancel = z;
        }

        public synchronized boolean getCancel() {
            return this.isCancel;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
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

    public VoiceSinWaveView(Context context) {
        this(context, null, 0);
    }

    public void setCallBack(VoiceWaveCallBack voiceWaveCallBack) {
        this.mVoiceWaveCallBack = voiceWaveCallBack;
    }

    @Override // com.baidu.pass.ecommerce.view.VoiceWaveInterface
    public void showInParentView(ViewGroup viewGroup) {
        Log.d(TAG, "showInParentView.");
        if (viewGroup == null || this.mParent != null) {
            return;
        }
        this.mIsNeedGetSize = true;
        viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        this.mParent = viewGroup;
    }

    public VoiceSinWaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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

    public VoiceSinWaveView(Context context, VoiceWaveCallBack voiceWaveCallBack) {
        this(context, null, 0);
        this.mVoiceWaveCallBack = voiceWaveCallBack;
    }

    private void cancel() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void changePhase() {
        float f = this.mPrimaryPhase + this.mPrimaryPhaseShift;
        this.mPrimaryPhase = f;
        this.mSecondaryPhase += this.mSecondaryPhaseShift;
        if (f < -3.4028235E38f) {
            this.mPrimaryPhase = 0.0f;
            this.mSecondaryPhase = 3.5f;
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
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

    @Override // com.baidu.pass.ecommerce.view.VoiceWaveInterface
    public void removeFromParent() {
        Log.d(TAG, "removeFromParent.");
        ViewGroup viewGroup = this.mParent;
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeView(this);
        this.mParent = null;
        cancel();
    }

    @Override // com.baidu.pass.ecommerce.view.VoiceWaveInterface
    public void reset() {
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

    @Override // com.baidu.pass.ecommerce.view.VoiceWaveInterface
    public void start() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void drawFrame() {
        int i;
        if (this.mIsNeedGetSize) {
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
        return ((1.0f - ((float) Math.pow(((i * 2) / f) - 1.0f, 2.0d))) * f3 * f4 * ((float) Math.sin(((i / f) * 6.283185307179586d * f5) + f6))) + (f2 * 0.5f);
    }

    private void initialize() {
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

    private void setPaintShader() {
        Log.d(TAG, "setPaintShader.");
        int i = this.mHeight;
        if (i > 0 && this.mWidth > 0) {
            this.mMaxAmplitude = (i - 4.0f) * 0.5f;
            this.mPrimaryPaint.setShader(new LinearGradient(0.0f, 0.0f, this.mWidth, 0.0f, getResources().getColor(R.color.obfuscated_res_0x7f0608cd), getResources().getColor(R.color.obfuscated_res_0x7f0608cc), Shader.TileMode.MIRROR));
            this.mSecondaryPaint.setShader(new LinearGradient(0.0f, 0.0f, this.mWidth, 0.0f, getResources().getColor(R.color.obfuscated_res_0x7f0608cf), getResources().getColor(R.color.obfuscated_res_0x7f0608ce), Shader.TileMode.MIRROR));
            int color = getResources().getColor(R.color.obfuscated_res_0x7f0608cb);
            int color2 = getResources().getColor(R.color.obfuscated_res_0x7f0608ca);
            float f = this.mHeight / 2;
            float f2 = this.mMaxAmplitude;
            this.mFillPaint.setShader(new LinearGradient(0.0f, f - f2, 0.0f, f + f2, color, color2, Shader.TileMode.MIRROR));
        }
    }

    @Override // com.baidu.pass.ecommerce.view.VoiceWaveInterface
    public void stop() {
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
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.pass.ecommerce.view.VoiceSinWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    VoiceSinWaveView.this.mVolume = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                }
            });
            this.mValueAnimator.start();
        }
        final int[] iArr = {0, -16777216, -16777216, -16777216, 0};
        final float[] fArr = {0.0f, 0.2f, 0.5f, 0.8f, 1.0f};
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.mWidth / 2);
        this.mFadeAnimator = ofInt;
        ofInt.setDuration(this.mFadeAnimatorTime);
        this.mFadeAnimator.setInterpolator(new AccelerateInterpolator());
        this.mFadeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.pass.ecommerce.view.VoiceSinWaveView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                VoiceSinWaveView.this.mFadeX = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (!VoiceSinWaveView.this.mHasSendFadeToQuarter && VoiceSinWaveView.this.mFadeX > (VoiceSinWaveView.this.mWidth * 5) / 14) {
                    if (VoiceSinWaveView.this.mVoiceWaveCallBack != null) {
                        VoiceSinWaveView.this.mVoiceWaveCallBack.fadeToQuarter();
                    }
                    VoiceSinWaveView.this.mHasSendFadeToQuarter = true;
                }
                VoiceSinWaveView.this.mMaskPaint.setShader(new LinearGradient(VoiceSinWaveView.this.mFadeX, 0.0f, VoiceSinWaveView.this.mWidth - VoiceSinWaveView.this.mFadeX, 0.0f, iArr, fArr, Shader.TileMode.MIRROR));
            }
        });
        this.mFadeAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.pass.ecommerce.view.VoiceSinWaveView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (VoiceSinWaveView.this.mVoiceWaveCallBack != null) {
                    VoiceSinWaveView.this.mVoiceWaveCallBack.fadeOut();
                }
            }
        });
        this.mFadeAnimator.start();
    }

    @Override // com.baidu.pass.ecommerce.view.VoiceWaveInterface
    public void changeVolume(float f) {
        if (this.mIsPermitReceiveVolume && f >= 0.0f && f <= 100.0f) {
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
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.pass.ecommerce.view.VoiceSinWaveView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    VoiceSinWaveView.this.mVolume = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    VoiceSinWaveView voiceSinWaveView = VoiceSinWaveView.this;
                    voiceSinWaveView.mLastVolume = voiceSinWaveView.mVolume;
                }
            });
            this.mValueAnimator.start();
            this.mLastVolumeTimeMillis = currentTimeMillis;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
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
