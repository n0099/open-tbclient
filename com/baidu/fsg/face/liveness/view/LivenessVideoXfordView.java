package com.baidu.fsg.face.liveness.view;

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
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class LivenessVideoXfordView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final float f38346a = 230.0f;

    /* renamed from: b  reason: collision with root package name */
    public static final float f38347b = 20.0f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public float f38348c;

    /* renamed from: d  reason: collision with root package name */
    public float f38349d;

    /* renamed from: e  reason: collision with root package name */
    public int f38350e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f38351f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f38352g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f38353h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f38354i;
    public Paint j;
    public Xfermode k;
    public RectF l;
    public RectF m;
    public VideoXfordViewState n;
    public int o;
    public int p;
    public Handler q;
    public Runnable r;
    public int s;
    public Handler t;
    public Runnable u;
    public int v;
    public a w;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class VideoXfordViewState {
        public static final /* synthetic */ VideoXfordViewState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final VideoXfordViewState FAILURE;
        public static final VideoXfordViewState SUCCESSED;
        public static final VideoXfordViewState SUCCESSING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2046371106, "Lcom/baidu/fsg/face/liveness/view/LivenessVideoXfordView$VideoXfordViewState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2046371106, "Lcom/baidu/fsg/face/liveness/view/LivenessVideoXfordView$VideoXfordViewState;");
                    return;
                }
            }
            FAILURE = new VideoXfordViewState("FAILURE", 0);
            SUCCESSING = new VideoXfordViewState("SUCCESSING", 1);
            VideoXfordViewState videoXfordViewState = new VideoXfordViewState("SUCCESSED", 2);
            SUCCESSED = videoXfordViewState;
            $VALUES = new VideoXfordViewState[]{FAILURE, SUCCESSING, videoXfordViewState};
        }

        public VideoXfordViewState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static VideoXfordViewState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (VideoXfordViewState) Enum.valueOf(VideoXfordViewState.class, str) : (VideoXfordViewState) invokeL.objValue;
        }

        public static VideoXfordViewState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (VideoXfordViewState[]) $VALUES.clone() : (VideoXfordViewState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivenessVideoXfordView(@NonNull Context context) {
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
        this.f38348c = 230.0f;
        this.f38349d = 20.0f;
        a();
    }

    public static /* synthetic */ int d(LivenessVideoXfordView livenessVideoXfordView) {
        int i2 = livenessVideoXfordView.s;
        livenessVideoXfordView.s = i2 + 1;
        return i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            RectF rectF = this.l;
            if (rectF == null || rectF.width() == 0.0f) {
                return;
            }
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f38351f);
            RectF rectF2 = this.l;
            canvas.drawCircle(getWidth() / 2, rectF2.top + (rectF2.height() / 2.0f), this.o, this.f38352g);
            canvas.restoreToCount(saveLayer);
            VideoXfordViewState videoXfordViewState = this.n;
            if (videoXfordViewState == VideoXfordViewState.FAILURE) {
                if (this.p >= 0) {
                    this.f38354i.setAlpha(255);
                    RectF rectF3 = this.l;
                    canvas.drawCircle(getWidth() / 2, rectF3.top + (rectF3.height() / 2.0f), this.m.width() / 2.0f, this.f38354i);
                    this.j.setAlpha(220 - (this.p * 11));
                    RectF rectF4 = this.l;
                    canvas.drawCircle(getWidth() / 2, rectF4.top + (rectF4.height() / 2.0f), (this.m.width() / 2.0f) + ((int) ((getHeight() - this.l.width()) * this.p * 0.025d)), this.j);
                }
            } else if (videoXfordViewState == VideoXfordViewState.SUCCESSING) {
                canvas.drawArc(this.m, this.f38348c, this.f38349d, false, this.f38353h);
                canvas.drawArc(this.m, (this.f38348c + 180.0f) % 360.0f, this.f38349d, false, this.f38353h);
            } else if (videoXfordViewState == VideoXfordViewState.SUCCESSED) {
                RectF rectF5 = this.l;
                canvas.drawCircle(getWidth() / 2, rectF5.top + (rectF5.height() / 2.0f), this.m.width() / 2.0f, this.f38353h);
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Handler handler = this.t;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.t = null;
            }
            Handler handler2 = this.q;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
                this.q = null;
            }
        }
    }

    public void setFocusViewRect(Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, rect) == null) || rect == null) {
            return;
        }
        this.l = new RectF(rect);
        int i2 = rect.left;
        int i3 = this.f38350e;
        this.m = new RectF(i2 - i3, rect.top - i3, rect.right + i3, rect.bottom + i3);
        this.o = rect.width() / 2;
        invalidate();
    }

    public void updateXfordViewState(VideoXfordViewState videoXfordViewState, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, videoXfordViewState, aVar) == null) || this.n == videoXfordViewState) {
            return;
        }
        this.n = videoXfordViewState;
        if (videoXfordViewState == VideoXfordViewState.FAILURE) {
            this.s = 0;
            this.t.removeCallbacksAndMessages(null);
            b();
        } else if (videoXfordViewState == VideoXfordViewState.SUCCESSING) {
            this.w = aVar;
            this.f38348c = 20.0f;
            this.f38349d = 20.0f;
            this.q.removeCallbacksAndMessages(null);
            c();
        } else if (videoXfordViewState == VideoXfordViewState.SUCCESSED) {
            this.q.removeCallbacksAndMessages(null);
            d();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            invalidate();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.t.removeCallbacksAndMessages(null);
            this.t.post(this.u);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f38350e = getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_xfordview_circle_gap);
            Paint paint = new Paint();
            this.f38351f = paint;
            paint.setColor(Color.rgb(255, 255, 255));
            this.f38351f.setStyle(Paint.Style.FILL);
            this.f38351f.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f38352g = paint2;
            paint2.setColor(Color.argb(0, 0, 0, 0));
            this.f38352g.setStyle(Paint.Style.FILL);
            this.f38352g.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.f38353h = paint3;
            paint3.setColor(Color.rgb(103, (int) com.baidu.apollon.a.f35825e, (int) GDiffPatcher.COPY_INT_UBYTE));
            this.f38353h.setStyle(Paint.Style.STROKE);
            this.f38353h.setStrokeWidth(12.0f);
            this.f38353h.setAntiAlias(true);
            Paint paint4 = new Paint();
            this.f38354i = paint4;
            paint4.setColor(Color.rgb((int) GDiffPatcher.COPY_USHORT_INT, 90, 92));
            this.f38354i.setStyle(Paint.Style.STROKE);
            this.f38354i.setStrokeWidth(12.0f);
            this.f38354i.setAntiAlias(true);
            Paint paint5 = new Paint();
            this.j = paint5;
            paint5.setColor(Color.rgb((int) GDiffPatcher.COPY_USHORT_INT, 90, 92));
            this.j.setStyle(Paint.Style.STROKE);
            this.j.setStrokeWidth(4.0f);
            this.j.setAntiAlias(true);
            PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
            this.k = porterDuffXfermode;
            this.f38352g.setXfermode(porterDuffXfermode);
            this.q = new Handler(Looper.getMainLooper());
            this.r = new Runnable(this) { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoXfordView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoXfordView f38355a;

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
                    this.f38355a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f38355a.s >= 20) {
                            this.f38355a.s = 0;
                            LivenessVideoXfordView livenessVideoXfordView = this.f38355a;
                            livenessVideoXfordView.p = livenessVideoXfordView.s;
                            this.f38355a.invalidate();
                            this.f38355a.q.postDelayed(this.f38355a.r, 120L);
                            return;
                        }
                        LivenessVideoXfordView livenessVideoXfordView2 = this.f38355a;
                        livenessVideoXfordView2.p = livenessVideoXfordView2.s;
                        LivenessVideoXfordView.d(this.f38355a);
                        this.f38355a.invalidate();
                        this.f38355a.q.postDelayed(this.f38355a.r, 120L);
                    }
                }
            };
            this.t = new Handler(Looper.getMainLooper());
            this.u = new Runnable(this) { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoXfordView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoXfordView f38356a;

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
                    this.f38356a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    LivenessVideoXfordView livenessVideoXfordView;
                    LivenessVideoXfordView livenessVideoXfordView2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f38356a.v >= 160) {
                            this.f38356a.v = 0;
                            if (this.f38356a.w != null) {
                                this.f38356a.w.a();
                                return;
                            }
                            return;
                        }
                        this.f38356a.v += 2;
                        this.f38356a.f38349d = livenessVideoXfordView.v + 20.0f;
                        this.f38356a.f38348c = ((livenessVideoXfordView2.v * 1) + 230.0f) % 360.0f;
                        this.f38356a.invalidate();
                        this.f38356a.t.postDelayed(this.f38356a.u, 3L);
                    }
                }
            };
            updateXfordViewState(VideoXfordViewState.FAILURE, null);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.q.removeCallbacksAndMessages(null);
            this.q.post(this.r);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivenessVideoXfordView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.f38348c = 230.0f;
        this.f38349d = 20.0f;
        a();
    }
}
