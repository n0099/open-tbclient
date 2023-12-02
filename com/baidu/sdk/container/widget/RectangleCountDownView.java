package com.baidu.sdk.container.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.widget.AbsCountDownView;
import com.baidu.tieba.w11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"AppCompatCustomView", "DefaultLocale", "NewApi"})
/* loaded from: classes3.dex */
public class RectangleCountDownView extends AbsCountDownView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long d;
    public long e;
    public long f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RectangleCountDownView(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RectangleCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void e(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, attributeSet) == null) {
            setTextColor(Color.parseColor("#ffffff"));
            setWidth(w11.c.a(context, 72.0f));
            setHeight(w11.c.a(context, 30.0f));
            setGravity(17);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(w11.c.a(context, 15.0f));
            gradientDrawable.setColor(Color.parseColor("#33000000"));
            setBackground(gradientDrawable);
            setText(String.format("跳过 %02d", Long.valueOf(this.e / 1000)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RectangleCountDownView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = 0L;
        e(context, attributeSet);
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setTaskPeriod(250L);
            this.d = System.currentTimeMillis();
            setText(String.format("跳过 %02d", Long.valueOf(this.e / 1000)));
            super.b();
        }
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
        }
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long currentTimeMillis = this.e - (System.currentTimeMillis() - this.d);
            this.f = currentTimeMillis;
            if (currentTimeMillis > 0) {
                postInvalidate();
                return;
            }
            AbsCountDownView.b bVar = this.b;
            if (bVar != null) {
                bVar.a();
                c();
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            setText(String.format("跳过 %02d", Integer.valueOf(Math.round(((float) this.f) / 1000.0f))));
        }
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void setTimeMillis(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.e = j;
            this.f = j;
        }
    }
}
