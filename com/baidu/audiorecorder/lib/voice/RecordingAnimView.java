package com.baidu.audiorecorder.lib.voice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.e;
import d.a.c.e.p.l;
import java.util.Random;
/* loaded from: classes.dex */
public class RecordingAnimView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f4253e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f4254f;

    /* renamed from: g  reason: collision with root package name */
    public Random f4255g;

    /* renamed from: h  reason: collision with root package name */
    public int f4256h;

    /* renamed from: i  reason: collision with root package name */
    public int f4257i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public RectF[] n;
    public int[] o;
    public int p;
    public int q;
    public final Runnable r;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecordingAnimView f4258e;

        public a(RecordingAnimView recordingAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordingAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4258e = recordingAnimView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4258e.b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordingAnimView(Context context) {
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
        this.f4253e = 3;
        this.f4255g = new Random();
        this.f4256h = 0;
        this.f4257i = 8;
        this.j = false;
        this.k = true;
        this.o = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.p = l.g(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.r = new a(this);
        d();
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.j) {
                invalidate();
            }
            e.a().removeCallbacks(this.r);
            if (this.k) {
                return;
            }
            e.a().postDelayed(this.r, 250L);
        }
    }

    public int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 == 0) {
                return R.color.white_alpha100;
            }
            return R.color.white_alpha70;
        }
        return invokeI.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q = c(TbadkCoreApplication.getInst().getSkinType());
            Paint paint = new Paint();
            this.f4254f = paint;
            paint.setDither(true);
            this.f4254f.setAntiAlias(true);
            this.f4254f.setStyle(Paint.Style.FILL);
            this.f4254f.setColor(SkinManager.getColor(this.q));
        }
    }

    public final void e() {
        int nextInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RectF[] rectFArr = this.n;
            if (rectFArr == null || rectFArr.length != this.f4257i) {
                this.n = new RectF[this.f4257i];
            }
            for (int i2 = 0; i2 < this.f4257i; i2++) {
                int i3 = this.p * i2 * 2;
                if (this.k) {
                    nextInt = (int) ((1.0d - (this.o[i2 % 22] / 10.0d)) * this.m);
                } else {
                    int i4 = this.m;
                    nextInt = i4 > 0 ? this.f4255g.nextInt(i4) : 0;
                }
                int i5 = this.p + i3;
                int i6 = this.m;
                RectF[] rectFArr2 = this.n;
                if (rectFArr2[i2] == null) {
                    rectFArr2[i2] = new RectF(i3, nextInt, i5, i6);
                } else {
                    rectFArr2[i2].set(i3, nextInt, i5, i6);
                }
            }
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || i2 == this.f4253e || this.f4254f == null) {
            return;
        }
        int c2 = c(i2);
        this.q = c2;
        this.f4254f.setColor(SkinManager.getColor(i2, c2));
        invalidate();
        this.f4253e = i2;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.j = true;
            this.k = true;
            b();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j = true;
            this.k = false;
            b();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            e.a().removeCallbacks(this.r);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.j) {
                for (int i2 = 0; i2 < this.f4257i; i2++) {
                    e();
                    RectF[] rectFArr = this.n;
                    if (i2 < rectFArr.length) {
                        canvas.drawRoundRect(rectFArr[i2], 10.0f, 10.0f, this.f4254f);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            if (this.f4256h > 0) {
                int mode = View.MeasureSpec.getMode(i2);
                int i4 = this.p;
                int i5 = this.f4256h;
                int i6 = i4 * ((i5 * 2) - 1);
                this.l = i6;
                this.f4257i = i5;
                i2 = View.MeasureSpec.makeMeasureSpec(i6, mode);
            }
            super.onMeasure(i2, i3);
            this.m = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            this.l = measuredWidth;
            if (this.f4256h <= 0) {
                this.f4257i = (measuredWidth / this.p) / 2;
            }
        }
    }

    public void setCertainColumnCount(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 == 0) {
            return;
        }
        this.f4256h = i2;
    }

    public void setColumnColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            Paint paint = this.f4254f;
            if (paint != null) {
                paint.setColor(SkinManager.getColor(i2));
            }
            this.q = i2;
        }
    }

    public void setColumnWidth(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.p = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordingAnimView(Context context, AttributeSet attributeSet) {
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
        this.f4253e = 3;
        this.f4255g = new Random();
        this.f4256h = 0;
        this.f4257i = 8;
        this.j = false;
        this.k = true;
        this.o = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.p = l.g(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.r = new a(this);
        d();
        b();
    }
}
