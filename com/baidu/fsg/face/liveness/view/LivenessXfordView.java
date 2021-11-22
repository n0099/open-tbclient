package com.baidu.fsg.face.liveness.view;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class LivenessXfordView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROGRESS_PROPERTY = "progress";

    /* renamed from: a  reason: collision with root package name */
    public static final int f39187a = 12;
    public transient /* synthetic */ FieldHolder $fh;
    public AnimatorSet A;
    public float B;
    public float C;

    /* renamed from: b  reason: collision with root package name */
    public float f39188b;

    /* renamed from: c  reason: collision with root package name */
    public Xfermode f39189c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f39190d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f39191e;

    /* renamed from: f  reason: collision with root package name */
    public int f39192f;

    /* renamed from: g  reason: collision with root package name */
    public int f39193g;

    /* renamed from: h  reason: collision with root package name */
    public float f39194h;

    /* renamed from: i  reason: collision with root package name */
    public float f39195i;
    public Handler j;
    public Runnable k;
    public float l;
    public boolean m;
    public Rect n;
    public Rect o;
    public Rect p;
    public float progress;
    public Paint q;
    public Paint r;
    public Paint s;
    public Paint t;
    public Paint u;
    public Paint v;
    public Paint w;
    public Paint x;
    public boolean y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivenessXfordView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39188b = -90.0f;
        this.m = true;
        this.z = true;
        a();
    }

    public void debugDraw(Rect rect, Rect rect2, Rect rect3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, rect, rect2, rect3) == null) {
            this.o = rect;
            this.p = rect2;
            this.n = rect3;
            invalidate();
        }
    }

    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.progress * 360.0f : invokeV.floatValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.onDraw(canvas);
            RectF rectF = this.f39190d;
            if (rectF == null || rectF.width() == 0.0f) {
                return;
            }
            if (this.z) {
                RectF rectF2 = this.f39191e;
                float f2 = rectF2.left;
                float f3 = this.l;
                canvas.drawRect(f2, f3, rectF2.right, f3 + rectF2.height(), this.u);
                RectF rectF3 = this.f39191e;
                float f4 = rectF3.left;
                float height = this.l + rectF3.height();
                RectF rectF4 = this.f39191e;
                canvas.drawLine(f4, height, rectF4.right, this.l + rectF4.height(), this.v);
            }
            if (this.y) {
                canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.t);
            }
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.q);
            canvas.drawCircle(this.f39194h, this.f39195i, this.f39192f, this.w);
            canvas.restoreToCount(saveLayer);
            canvas.drawCircle(this.f39194h, this.f39195i, this.f39193g, this.s);
            canvas.drawArc(this.f39191e, this.f39188b, this.progress, false, this.r);
            if (this.n != null) {
                this.x.setColor(-16776961);
                canvas.drawRect(this.n, this.x);
            }
            if (this.o != null) {
                this.x.setColor(SupportMenu.CATEGORY_MASK);
                canvas.drawRect(this.o, this.x);
            }
            if (this.p != null) {
                this.x.setColor(-256);
                canvas.drawRect(this.p, this.x);
            }
        }
    }

    public void release() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (handler = this.j) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.j = null;
    }

    public void setFocusViewRect(Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, rect, rect2) == null) || rect == null || rect2 == null) {
            return;
        }
        this.f39190d = new RectF(rect);
        RectF rectF = new RectF(rect2);
        this.f39191e = rectF;
        this.B = rectF.top - rectF.height();
        RectF rectF2 = this.f39191e;
        this.C = rectF2.bottom - rectF2.height();
        this.l = this.B;
        RectF rectF3 = this.f39190d;
        this.f39194h = (rectF3.left + rectF3.right) / 2.0f;
        this.f39195i = (rectF3.top + rectF3.bottom) / 2.0f;
        this.f39192f = rect.width() / 2;
        this.f39193g = (rect.width() / 2) + ((rect2.width() - rect.width()) / 2);
        invalidate();
    }

    public void setLineVisiable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.z = z;
            if (z) {
                this.l = this.B;
                startAnimForCircleProgress();
            } else {
                this.j.removeCallbacksAndMessages(null);
            }
            invalidate();
        }
    }

    public void setMaskVisiable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.y = z;
            invalidate();
        }
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.progress = f2 * 360.0f;
            invalidate();
        }
    }

    public void startAnimForCircleProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.j.removeCallbacksAndMessages(null);
            this.j.post(this.k);
        }
    }

    public void stopXfordViewProgress() {
        AnimatorSet animatorSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (animatorSet = this.A) == null) {
            return;
        }
        animatorSet.cancel();
    }

    public void updateXfordViewProgress(float f2, float f3, long j, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j), animatorListenerAdapter}) == null) {
            this.A = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "progress", f2, f3);
            ofFloat.setDuration(j);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            if (animatorListenerAdapter != null) {
                this.A.addListener(animatorListenerAdapter);
            }
            this.A.play(ofFloat);
            this.A.start();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            Paint paint = new Paint();
            this.q = paint;
            paint.setColor(-1);
            this.q.setStyle(Paint.Style.FILL);
            this.q.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.r = paint2;
            paint2.setColor(Color.parseColor("#2EC5FA"));
            this.r.setStyle(Paint.Style.STROKE);
            this.r.setStrokeWidth(12.0f);
            this.r.setAntiAlias(true);
            this.r.setStrokeCap(Paint.Cap.ROUND);
            Paint paint3 = new Paint();
            this.s = paint3;
            paint3.setColor(Color.parseColor("#E9EBF2"));
            this.s.setStyle(Paint.Style.STROKE);
            this.s.setStrokeWidth(12.0f);
            this.s.setAntiAlias(true);
            this.s.setStrokeCap(Paint.Cap.ROUND);
            Paint paint4 = new Paint();
            this.t = paint4;
            paint4.setStyle(Paint.Style.FILL);
            this.t.setColor(Color.parseColor("#99000000"));
            this.t.setAntiAlias(true);
            Paint paint5 = new Paint();
            this.u = paint5;
            paint5.setStyle(Paint.Style.FILL);
            this.u.setColor(Color.parseColor("#4DFFFFFF"));
            this.u.setAntiAlias(true);
            Paint paint6 = new Paint();
            this.v = paint6;
            paint6.setStrokeWidth(2.0f);
            this.v.setStyle(Paint.Style.STROKE);
            this.v.setColor(Color.parseColor("#FFFFFF"));
            this.v.setAntiAlias(true);
            Paint paint7 = new Paint();
            this.x = paint7;
            paint7.setStrokeWidth(4.0f);
            this.x.setStyle(Paint.Style.STROKE);
            this.x.setAntiAlias(true);
            Paint paint8 = new Paint();
            this.w = paint8;
            paint8.setColor(0);
            this.r.setAntiAlias(true);
            PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
            this.f39189c = porterDuffXfermode;
            this.w.setXfermode(porterDuffXfermode);
            this.j = new Handler(Looper.getMainLooper());
            this.k = new Runnable(this) { // from class: com.baidu.fsg.face.liveness.view.LivenessXfordView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessXfordView f39196a;

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
                    this.f39196a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f39196a.f39190d == null) {
                            this.f39196a.j.postDelayed(this.f39196a.k, 6L);
                            return;
                        }
                        LivenessXfordView livenessXfordView = this.f39196a;
                        livenessXfordView.l = livenessXfordView.m ? this.f39196a.l + 3.0f : this.f39196a.l - 3.0f;
                        if (this.f39196a.l <= this.f39196a.B) {
                            LivenessXfordView livenessXfordView2 = this.f39196a;
                            livenessXfordView2.l = livenessXfordView2.B;
                            this.f39196a.m = true;
                        }
                        if (this.f39196a.l >= this.f39196a.C) {
                            LivenessXfordView livenessXfordView3 = this.f39196a;
                            livenessXfordView3.l = livenessXfordView3.C;
                            this.f39196a.m = false;
                        }
                        this.f39196a.j.postDelayed(this.f39196a.k, 6L);
                        this.f39196a.invalidate();
                    }
                }
            };
            startAnimForCircleProgress();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivenessXfordView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39188b = -90.0f;
        this.m = true;
        this.z = true;
        a();
    }
}
