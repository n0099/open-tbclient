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

    /* renamed from: e  reason: collision with root package name */
    public int f31497e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f31498f;

    /* renamed from: g  reason: collision with root package name */
    public Random f31499g;

    /* renamed from: h  reason: collision with root package name */
    public int f31500h;

    /* renamed from: i  reason: collision with root package name */
    public int f31501i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f31502j;
    public boolean k;
    public int l;
    public int m;
    public RectF[] n;
    public int[] o;
    public int p;
    public int q;
    public final Runnable r;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecordingAnimView f31503e;

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
            this.f31503e = recordingAnimView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31503e.b();
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
        this.f31497e = 3;
        this.f31499g = new Random();
        this.f31500h = 0;
        this.f31501i = 8;
        this.f31502j = false;
        this.k = true;
        this.o = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.p = n.f(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.r = new a(this);
        c();
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f31502j) {
                invalidate();
            }
            e.a().removeCallbacks(this.r);
            if (this.k) {
                return;
            }
            e.a().postDelayed(this.r, 250L);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q = getPaintColor(TbadkCoreApplication.getInst().getSkinType());
            Paint paint = new Paint();
            this.f31498f = paint;
            paint.setDither(true);
            this.f31498f.setAntiAlias(true);
            this.f31498f.setStyle(Paint.Style.FILL);
            this.f31498f.setColor(SkinManager.getColor(this.q));
        }
    }

    public final void d() {
        int nextInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RectF[] rectFArr = this.n;
            if (rectFArr == null || rectFArr.length != this.f31501i) {
                this.n = new RectF[this.f31501i];
            }
            for (int i2 = 0; i2 < this.f31501i; i2++) {
                int i3 = this.p * i2 * 2;
                if (this.k) {
                    nextInt = (int) ((1.0d - (this.o[i2 % 22] / 10.0d)) * this.m);
                } else {
                    int i4 = this.m;
                    nextInt = i4 > 0 ? this.f31499g.nextInt(i4) : 0;
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

    public int getPaintColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 == 0 ? R.color.white_alpha100 : R.color.white_alpha70 : invokeI.intValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || i2 == this.f31497e || this.f31498f == null) {
            return;
        }
        int paintColor = getPaintColor(i2);
        this.q = paintColor;
        this.f31498f.setColor(SkinManager.getColor(i2, paintColor));
        invalidate();
        this.f31497e = i2;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            e.a().removeCallbacks(this.r);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f31502j) {
                for (int i2 = 0; i2 < this.f31501i; i2++) {
                    d();
                    RectF[] rectFArr = this.n;
                    if (i2 < rectFArr.length) {
                        canvas.drawRoundRect(rectFArr[i2], 10.0f, 10.0f, this.f31498f);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            if (this.f31500h > 0) {
                int mode = View.MeasureSpec.getMode(i2);
                int i4 = this.p;
                int i5 = this.f31500h;
                int i6 = i4 * ((i5 * 2) - 1);
                this.l = i6;
                this.f31501i = i5;
                i2 = View.MeasureSpec.makeMeasureSpec(i6, mode);
            }
            super.onMeasure(i2, i3);
            this.m = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            this.l = measuredWidth;
            if (this.f31500h <= 0) {
                this.f31501i = (measuredWidth / this.p) / 2;
            }
        }
    }

    public void resetStartState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f31502j = true;
            this.k = true;
            b();
        }
    }

    public void setCertainColumnCount(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || i2 == 0) {
            return;
        }
        this.f31500h = i2;
    }

    public void setColumnColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            Paint paint = this.f31498f;
            if (paint != null) {
                paint.setColor(SkinManager.getColor(i2));
            }
            this.q = i2;
        }
    }

    public void setColumnWidth(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.p = i2;
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f31502j = true;
            this.k = false;
            b();
        }
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
        this.f31497e = 3;
        this.f31499g = new Random();
        this.f31500h = 0;
        this.f31501i = 8;
        this.f31502j = false;
        this.k = true;
        this.o = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.p = n.f(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.r = new a(this);
        c();
        b();
    }
}
