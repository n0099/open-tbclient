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
import com.repackage.mi;
import com.repackage.ng;
import java.util.Random;
/* loaded from: classes.dex */
public class RecordingAnimView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Paint b;
    public Random c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public RectF[] j;
    public int[] k;
    public int l;
    public int m;
    public final Runnable n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordingAnimView a;

        public a(RecordingAnimView recordingAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordingAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordingAnimView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.c = new Random();
        this.d = 0;
        this.e = 8;
        this.f = false;
        this.g = true;
        this.k = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.l = mi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070224);
        this.n = new a(this);
        d();
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f) {
                invalidate();
            }
            ng.a().removeCallbacks(this.n);
            if (this.g) {
                return;
            }
            ng.a().postDelayed(this.n, 250L);
        }
    }

    public int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i == 0 ? R.color.white_alpha100 : R.color.white_alpha70 : invokeI.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.m = c(TbadkCoreApplication.getInst().getSkinType());
            Paint paint = new Paint();
            this.b = paint;
            paint.setDither(true);
            this.b.setAntiAlias(true);
            this.b.setStyle(Paint.Style.FILL);
            this.b.setColor(SkinManager.getColor(this.m));
        }
    }

    public final void e() {
        int nextInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RectF[] rectFArr = this.j;
            if (rectFArr == null || rectFArr.length != this.e) {
                this.j = new RectF[this.e];
            }
            for (int i = 0; i < this.e; i++) {
                int i2 = this.l * i * 2;
                if (this.g) {
                    nextInt = (int) ((1.0d - (this.k[i % 22] / 10.0d)) * this.i);
                } else {
                    int i3 = this.i;
                    nextInt = i3 > 0 ? this.c.nextInt(i3) : 0;
                }
                int i4 = this.l + i2;
                int i5 = this.i;
                RectF[] rectFArr2 = this.j;
                if (rectFArr2[i] == null) {
                    rectFArr2[i] = new RectF(i2, nextInt, i4, i5);
                } else {
                    rectFArr2[i].set(i2, nextInt, i4, i5);
                }
            }
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || i == this.a || this.b == null) {
            return;
        }
        int c = c(i);
        this.m = c;
        this.b.setColor(SkinManager.getColor(i, c));
        invalidate();
        this.a = i;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f = true;
            this.g = true;
            b();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f = true;
            this.g = false;
            b();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            ng.a().removeCallbacks(this.n);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f) {
                for (int i = 0; i < this.e; i++) {
                    e();
                    RectF[] rectFArr = this.j;
                    if (i < rectFArr.length) {
                        canvas.drawRoundRect(rectFArr[i], 10.0f, 10.0f, this.b);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            if (this.d > 0) {
                int mode = View.MeasureSpec.getMode(i);
                int i3 = this.l;
                int i4 = this.d;
                int i5 = i3 * ((i4 * 2) - 1);
                this.h = i5;
                this.e = i4;
                i = View.MeasureSpec.makeMeasureSpec(i5, mode);
            }
            super.onMeasure(i, i2);
            this.i = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            this.h = measuredWidth;
            if (this.d <= 0) {
                this.e = (measuredWidth / this.l) / 2;
            }
        }
    }

    public void setCertainColumnCount(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || i == 0) {
            return;
        }
        this.d = i;
    }

    public void setColumnColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            Paint paint = this.b;
            if (paint != null) {
                paint.setColor(SkinManager.getColor(i));
            }
            this.m = i;
        }
    }

    public void setColumnWidth(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || i <= 0) {
            return;
        }
        this.l = i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.c = new Random();
        this.d = 0;
        this.e = 8;
        this.f = false;
        this.g = true;
        this.k = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.l = mi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070224);
        this.n = new a(this);
        d();
        b();
    }
}
