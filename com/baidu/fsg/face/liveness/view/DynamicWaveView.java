package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.face.base.d.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class DynamicWaveView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 1715238655;

    /* renamed from: b  reason: collision with root package name */
    public static final float f34427b = 30.0f;

    /* renamed from: c  reason: collision with root package name */
    public static final int f34428c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f34429d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f34430e = 5;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public float f34431f;

    /* renamed from: g  reason: collision with root package name */
    public int f34432g;

    /* renamed from: h  reason: collision with root package name */
    public int f34433h;

    /* renamed from: i  reason: collision with root package name */
    public int f34434i;

    /* renamed from: j  reason: collision with root package name */
    public int f34435j;
    public int k;
    public float[] l;
    public float[] m;
    public float[] n;
    public int o;
    public int p;
    public int q;
    public int r;
    public Paint s;
    public DrawFilter t;
    public Thread u;
    public volatile boolean v;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DynamicWaveView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            float[] fArr = this.l;
            int length = fArr.length;
            int i2 = this.q;
            int i3 = length - i2;
            System.arraycopy(fArr, i2, this.m, 0, i3);
            System.arraycopy(this.l, 0, this.m, i3, this.q);
            float[] fArr2 = this.l;
            int length2 = fArr2.length;
            int i4 = this.r;
            int i5 = length2 - i4;
            System.arraycopy(fArr2, i4, this.n, 0, i5);
            System.arraycopy(this.l, 0, this.n, i5, this.r);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            canvas.setDrawFilter(this.t);
            b();
            int i2 = this.f34435j;
            int i3 = this.f34432g - i2;
            while (i2 < i3) {
                int i4 = (int) ((this.f34433h - this.m[i2]) - this.k);
                int i5 = this.f34434i;
                int sqrt = (int) (i5 + Math.sqrt(Math.pow(i5, 2.0d) - Math.pow(Math.abs(this.f34434i - i2), 2.0d)));
                if (sqrt >= i4) {
                    float f2 = i2;
                    canvas.drawLine(f2, i4, f2, sqrt, this.s);
                }
                int i6 = (int) ((this.f34433h - this.n[i2]) - this.k);
                if (sqrt >= i6) {
                    float f3 = i2;
                    canvas.drawLine(f3, i6, f3, sqrt, this.s);
                }
                i2++;
            }
            int i7 = this.q + this.o;
            this.q = i7;
            this.r += this.p;
            if (i7 >= this.f34432g) {
                this.q = 0;
            }
            if (this.r > this.f34432g) {
                this.r = 0;
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.f34432g = i2;
            this.f34433h = i3;
            this.f34434i = i2 / 2;
            this.l = new float[i2];
            this.m = new float[i2];
            this.n = new float[i2];
            this.f34431f = (float) (6.283185307179586d / i2);
            for (int i6 = 0; i6 < this.f34432g; i6++) {
                this.l[i6] = (float) ((Math.sin(this.f34431f * i6) * 30.0d) + 0.0d);
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 == 8) {
                stopAnim();
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.setVisibility(i2);
            if (i2 == 0) {
                this.v = true;
                a();
                return;
            }
            this.v = false;
        }
    }

    public void stopAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.v = false;
            Thread thread = this.u;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DynamicWaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
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

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            Thread thread = new Thread(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.view.DynamicWaveView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DynamicWaveView a;

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
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        while (this.a.v) {
                            try {
                                Thread.sleep(20L);
                                this.a.postInvalidate();
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            });
            this.u = thread;
            thread.start();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicWaveView(Context context, AttributeSet attributeSet, int i2) {
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
        this.v = true;
        this.o = h.a(context, 3.0f);
        this.p = h.a(context, 5.0f);
        Paint paint = new Paint();
        this.s = paint;
        paint.setAntiAlias(true);
        this.s.setStyle(Paint.Style.FILL);
        this.s.setColor(a);
        this.t = new PaintFlagsDrawFilter(0, 3);
        this.f34435j = h.a(context, 5.0f);
        this.k = h.a(context, 30.0f);
        a();
    }
}
