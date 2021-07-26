package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class LrcView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static int A = 12;
    public static int B;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6227a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6228b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6229c;

    /* renamed from: d  reason: collision with root package name */
    public int f6230d;

    /* renamed from: e  reason: collision with root package name */
    public int f6231e;

    /* renamed from: f  reason: collision with root package name */
    public int f6232f;

    /* renamed from: g  reason: collision with root package name */
    public int f6233g;

    /* renamed from: h  reason: collision with root package name */
    public int f6234h;

    /* renamed from: i  reason: collision with root package name */
    public int f6235i;
    public int j;
    public int k;
    public int l;
    public Runnable m;
    public int n;
    public int o;
    public List<String> p;
    public int q;
    public a r;
    public Paint s;
    public Paint t;
    public Paint u;
    public float[] v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(390965478, "Lcom/baidu/fsg/face/liveness/view/LrcView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(390965478, "Lcom/baidu/fsg/face/liveness/view/LrcView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LrcView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6227a = false;
        this.f6228b = false;
        this.f6229c = false;
        this.f6230d = 255;
        this.f6231e = 127;
        this.y = 72;
        this.z = 54;
        this.m = new Runnable(this) { // from class: com.baidu.fsg.face.liveness.view.LrcView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LrcView f6236a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f6236a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f6236a.q >= this.f6236a.p.size() - 1) {
                        if (this.f6236a.r != null) {
                            this.f6236a.r.a();
                            return;
                        }
                        return;
                    }
                    LrcView lrcView = this.f6236a;
                    lrcView.f6228b = false;
                    LrcView.d(lrcView);
                    this.f6236a.toInvalidate();
                    this.f6236a.f6227a = false;
                }
            }
        };
        a();
    }

    public static /* synthetic */ int d(LrcView lrcView) {
        int i2 = lrcView.q;
        lrcView.q = i2 + 1;
        return i2;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.drawCircle(this.n / 2, (this.o / 2) + getScrollY(), this.n / 2, this.t);
            List<String> list = this.p;
            if (list == null || list.size() == 0) {
                return;
            }
            a(canvas, this.p);
            if (this.f6229c) {
                return;
            }
            if (this.f6228b && !this.f6227a) {
                this.f6227a = true;
                int i2 = this.q;
                if (i2 == 0) {
                    getHandler().postDelayed(this.m, 200L);
                    return;
                }
                List<String> list2 = this.p;
                if (list2 != null && i2 >= 0 && i2 <= list2.size()) {
                    getHandler().postDelayed(this.m, (long) (this.p.get(this.q).length() * 0.25d * 1000.0d));
                    return;
                } else {
                    getHandler().postDelayed(this.m, 2000L);
                    return;
                }
            }
            postInvalidateDelayed(10L);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.n = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.o = measuredHeight;
            float[] fArr = this.v;
            int i4 = this.n;
            int i5 = this.x;
            int i6 = this.w;
            fArr[0] = ((i4 / 2) - i5) - (i6 * 2);
            fArr[1] = measuredHeight / 2;
            fArr[2] = i4 / 2;
            fArr[3] = measuredHeight / 2;
            fArr[4] = (i4 / 2) + i5 + (i6 * 2);
            fArr[5] = measuredHeight / 2;
        }
    }

    public void setLrcFinishInterface(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.r = aVar;
        }
    }

    public void setLrcList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.p = list;
        }
    }

    public void stopLrc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f6229c = true;
            this.r = null;
        }
    }

    public void toInvalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f6232f = 0;
            this.f6233g = 0;
            this.l = 0;
            setBackgroundColor(Color.argb(0, 0, 0, 0));
            invalidate();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.y = getResources().getDimensionPixelSize(R.dimen.rim_text_size_24);
            this.z = getResources().getDimensionPixelSize(R.dimen.rim_text_size_18);
            Paint paint = new Paint();
            this.s = paint;
            paint.setColor(Color.rgb(255, 255, 255));
            this.s.setTextSize(this.y);
            this.s.setTextAlign(Paint.Align.CENTER);
            this.s.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.t = paint2;
            paint2.setColor(Color.argb(150, 0, 0, 0));
            this.t.setAntiAlias(true);
            this.v = new float[6];
            Paint paint3 = new Paint();
            this.u = paint3;
            paint3.setStyle(Paint.Style.FILL);
            this.w = getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrcview_circle_point_radius);
            this.x = getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrcview_circle_point_gap);
            A = this.y - this.z;
            B = getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_text_gap);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LrcView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f6227a = false;
        this.f6228b = false;
        this.f6229c = false;
        this.f6230d = 255;
        this.f6231e = 127;
        this.y = 72;
        this.z = 54;
        this.m = new Runnable(this) { // from class: com.baidu.fsg.face.liveness.view.LrcView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LrcView f6236a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f6236a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f6236a.q >= this.f6236a.p.size() - 1) {
                        if (this.f6236a.r != null) {
                            this.f6236a.r.a();
                            return;
                        }
                        return;
                    }
                    LrcView lrcView = this.f6236a;
                    lrcView.f6228b = false;
                    LrcView.d(lrcView);
                    this.f6236a.toInvalidate();
                    this.f6236a.f6227a = false;
                }
            }
        };
        a();
    }

    private void a(Canvas canvas, List<String> list) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, canvas, list) == null) {
            for (int i8 = 0; i8 < list.size(); i8++) {
                int i9 = this.q;
                if (i9 == 0) {
                    if (i8 == 0) {
                        int i10 = this.f6232f;
                        if (i10 < 108) {
                            this.f6232f = i10 + 2;
                        } else if (i10 >= 108 && i10 <= 144) {
                            this.f6232f = i10 + 2;
                        } else {
                            this.f6228b = true;
                        }
                        this.u.setColor(Color.argb(111, 255, 255, 255));
                        float[] fArr = this.v;
                        canvas.drawCircle(fArr[0], fArr[1], this.w, this.u);
                        float[] fArr2 = this.v;
                        canvas.drawCircle(fArr2[2], fArr2[3], this.w, this.u);
                        float[] fArr3 = this.v;
                        canvas.drawCircle(fArr3[4], fArr3[5], this.w, this.u);
                        int i11 = this.f6232f;
                        if (i11 >= 144) {
                            this.u.setColor(Color.argb(255, 255, 255, 255));
                            float[] fArr4 = this.v;
                            canvas.drawCircle(fArr4[0], fArr4[1], this.w, this.u);
                            float[] fArr5 = this.v;
                            canvas.drawCircle(fArr5[2], fArr5[3], this.w, this.u);
                            float[] fArr6 = this.v;
                            canvas.drawCircle(fArr6[4], fArr6[5], this.w, this.u);
                        } else if (i11 >= 108) {
                            this.u.setColor(Color.argb(255, 255, 255, 255));
                            float[] fArr7 = this.v;
                            canvas.drawCircle(fArr7[0], fArr7[1], this.w, this.u);
                            float[] fArr8 = this.v;
                            canvas.drawCircle(fArr8[2], fArr8[3], this.w, this.u);
                            this.u.setAlpha(((int) (((this.f6232f - 108) / 36.0f) * 144.0f)) + 111);
                            float[] fArr9 = this.v;
                            canvas.drawCircle(fArr9[4], fArr9[5], this.w, this.u);
                        } else if (i11 >= 72) {
                            this.u.setColor(Color.argb(255, 255, 255, 255));
                            float[] fArr10 = this.v;
                            canvas.drawCircle(fArr10[0], fArr10[1], this.w, this.u);
                            this.u.setAlpha(((int) (((this.f6232f - 72) / 36.0f) * 144.0f)) + 111);
                            float[] fArr11 = this.v;
                            canvas.drawCircle(fArr11[2], fArr11[3], this.w, this.u);
                        } else if (i11 >= 36) {
                            this.u.setAlpha(((int) (((i11 - 36) / 36.0f) * 144.0f)) + 111);
                            this.u.setColor(Color.argb(255, 255, 255, 255));
                            float[] fArr12 = this.v;
                            canvas.drawCircle(fArr12[0], fArr12[1], this.w, this.u);
                        }
                    } else if (i8 == 1) {
                        if (this.f6234h <= A) {
                            this.s.setTextSize(this.z);
                            this.s.setAlpha(this.f6231e);
                            int i12 = B;
                            int i13 = A;
                            canvas.drawText(list.get(1), this.n / 2, (this.o / 2) + i12 + ((i12 * (i13 - this.f6234h)) / i13), this.s);
                            this.f6234h++;
                        } else {
                            this.s.setTextSize(this.z);
                            this.s.setAlpha(this.f6231e);
                            canvas.drawText(list.get(1), this.n / 2, (this.o / 2) + B, this.s);
                        }
                    } else if (i8 == 2) {
                        if (this.f6235i <= A) {
                            this.s.setTextSize(this.z);
                            this.s.setAlpha(this.f6231e);
                            int i14 = A;
                            canvas.drawText(list.get(2), this.n / 2, (this.o / 2) + 300 + ((B * (i14 - this.f6235i)) / i14), this.s);
                            this.f6235i++;
                        } else {
                            this.s.setTextSize(this.z);
                            this.s.setAlpha(this.f6231e);
                            canvas.drawText(list.get(2), this.n / 2, (this.o / 2) + (B * 2), this.s);
                        }
                    }
                } else if (i9 == 1) {
                    if (i8 == 1) {
                        if (this.j < A) {
                            this.s.setTextSize(this.z + i6);
                            this.s.setAlpha(this.f6231e + ((int) (((this.f6230d - i7) * this.j) / A)));
                            int i15 = A;
                            canvas.drawText(list.get(i8), this.n / 2, (this.o / 2) + ((int) ((B * (i15 - this.j)) / i15)), this.s);
                            this.j++;
                        } else {
                            this.f6228b = true;
                            this.s.setTextSize(this.y);
                            this.s.setAlpha(this.f6230d);
                            canvas.drawText(list.get(i8), this.n / 2, this.o / 2, this.s);
                        }
                    } else if (i8 == 2) {
                        int i16 = this.k;
                        if (i16 < A) {
                            this.k = i16 + 1;
                        } else {
                            this.f6228b = true;
                        }
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.f6231e);
                        int i17 = B;
                        int i18 = A;
                        canvas.drawText(list.get(i8), this.n / 2, (this.o / 2) + i17 + ((int) ((i17 * (i18 - this.k)) / i18)), this.s);
                    }
                } else if (i8 == i9) {
                    if (this.f6232f < A) {
                        this.s.setTextSize(this.z + i4);
                        this.s.setAlpha(this.f6231e + ((int) (((this.f6230d - i5) * this.f6232f) / A)));
                        int i19 = A;
                        canvas.drawText(list.get(i8), this.n / 2, (this.o / 2) + ((int) ((B * (i19 - this.f6232f)) / i19)), this.s);
                        this.f6232f++;
                    } else {
                        this.f6228b = true;
                        this.s.setTextSize(this.y);
                        this.s.setAlpha(this.f6230d);
                        canvas.drawText(list.get(i8), this.n / 2, this.o / 2, this.s);
                    }
                } else if (i8 == i9 - 1) {
                    if (this.f6233g < A) {
                        this.s.setTextSize(this.y - i2);
                        this.s.setAlpha(this.f6230d - ((int) (((i3 - this.f6231e) * this.f6233g) / A)));
                        canvas.drawText(list.get(i8), this.n / 2, (this.o / 2) - ((int) (((B * this.f6233g) * 1.0d) / A)), this.s);
                        this.f6233g++;
                    } else {
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.f6231e);
                        canvas.drawText(list.get(i8), this.n / 2, (this.o / 2) - B, this.s);
                    }
                } else if (i8 == i9 + 1) {
                    if (this.l < A) {
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.f6231e);
                        int i20 = B;
                        canvas.drawText(list.get(i8), this.n / 2, ((this.o / 2) + (i20 * 2)) - ((int) (((i20 * this.l) * 1.0d) / A)), this.s);
                        this.l++;
                    } else {
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.f6231e);
                        canvas.drawText(list.get(i8), this.n / 2, (this.o / 2) + B, this.s);
                    }
                }
            }
        }
    }
}
