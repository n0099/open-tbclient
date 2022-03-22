package com.baidu.audiorecorder.lib.voice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes3.dex */
public class RecordingAnimView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f24853b;

    /* renamed from: c  reason: collision with root package name */
    public Random f24854c;

    /* renamed from: d  reason: collision with root package name */
    public int f24855d;

    /* renamed from: e  reason: collision with root package name */
    public int f24856e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24857f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24858g;

    /* renamed from: h  reason: collision with root package name */
    public int f24859h;
    public int i;
    public RectF[] j;
    public int[] k;
    public int l;
    public int m;
    public final Runnable n;

    /* loaded from: classes3.dex */
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
        this.f24854c = new Random();
        this.f24855d = 0;
        this.f24856e = 8;
        this.f24857f = false;
        this.f24858g = true;
        this.k = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.l = n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070224);
        this.n = new a(this);
        d();
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f24857f) {
                invalidate();
            }
            e.a().removeCallbacks(this.n);
            if (this.f24858g) {
                return;
            }
            e.a().postDelayed(this.n, 250L);
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
            this.f24853b = paint;
            paint.setDither(true);
            this.f24853b.setAntiAlias(true);
            this.f24853b.setStyle(Paint.Style.FILL);
            this.f24853b.setColor(SkinManager.getColor(this.m));
        }
    }

    public final void e() {
        int nextInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RectF[] rectFArr = this.j;
            if (rectFArr == null || rectFArr.length != this.f24856e) {
                this.j = new RectF[this.f24856e];
            }
            for (int i = 0; i < this.f24856e; i++) {
                int i2 = this.l * i * 2;
                if (this.f24858g) {
                    nextInt = (int) ((1.0d - (this.k[i % 22] / 10.0d)) * this.i);
                } else {
                    int i3 = this.i;
                    nextInt = i3 > 0 ? this.f24854c.nextInt(i3) : 0;
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
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || i == this.a || this.f24853b == null) {
            return;
        }
        int c2 = c(i);
        this.m = c2;
        this.f24853b.setColor(SkinManager.getColor(i, c2));
        invalidate();
        this.a = i;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f24857f = true;
            this.f24858g = true;
            b();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f24857f = true;
            this.f24858g = false;
            b();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            e.a().removeCallbacks(this.n);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f24857f) {
                for (int i = 0; i < this.f24856e; i++) {
                    e();
                    RectF[] rectFArr = this.j;
                    if (i < rectFArr.length) {
                        canvas.drawRoundRect(rectFArr[i], 10.0f, 10.0f, this.f24853b);
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
            if (this.f24855d > 0) {
                int mode = View.MeasureSpec.getMode(i);
                int i3 = this.l;
                int i4 = this.f24855d;
                int i5 = i3 * ((i4 * 2) - 1);
                this.f24859h = i5;
                this.f24856e = i4;
                i = View.MeasureSpec.makeMeasureSpec(i5, mode);
            }
            super.onMeasure(i, i2);
            this.i = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            this.f24859h = measuredWidth;
            if (this.f24855d <= 0) {
                this.f24856e = (measuredWidth / this.l) / 2;
            }
        }
    }

    public void setCertainColumnCount(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || i == 0) {
            return;
        }
        this.f24855d = i;
    }

    public void setColumnColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            Paint paint = this.f24853b;
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
        this.f24854c = new Random();
        this.f24855d = 0;
        this.f24856e = 8;
        this.f24857f = false;
        this.f24858g = true;
        this.k = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.l = n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070224);
        this.n = new a(this);
        d();
        b();
    }
}
