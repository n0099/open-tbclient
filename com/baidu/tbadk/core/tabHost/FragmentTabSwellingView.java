package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FragmentTabSwellingView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public Path b;
    public Path c;
    public Paint d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentTabSwellingView(Context context) {
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
    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d();
            b();
            c();
            setLayerType(1, null);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = new Path();
            this.c = new Path();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Paint paint = new Paint();
            this.a = paint;
            paint.setColor(SkinManager.getColor(R.color.CAM_X0205));
            this.a.setAntiAlias(true);
            this.a.setStrokeWidth(1.0f);
            this.a.setDither(true);
            this.a.setStyle(Paint.Style.FILL);
            Paint paint2 = new Paint();
            this.d = paint2;
            paint2.setAntiAlias(true);
            this.d.setDither(true);
            this.d.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e = xi.g(getContext().getApplicationContext(), R.dimen.tbds137);
            this.f = xi.g(getContext().getApplicationContext(), R.dimen.tbds204);
            this.g = xi.g(getContext().getApplicationContext(), R.dimen.tbds23);
            this.h = xi.g(getContext().getApplicationContext(), R.dimen.tbds51);
            this.i = xi.g(getContext().getApplicationContext(), R.dimen.tbds16);
            this.j = xi.g(getContext().getApplicationContext(), R.dimen.tbds52);
            this.k = xi.g(getContext().getApplicationContext(), R.dimen.tbds2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            if (getWidth() > xi.l(getContext())) {
                return;
            }
            this.c.reset();
            this.b.reset();
            this.b.moveTo(0.0f, getHeight() - this.e);
            this.b.lineTo((getWidth() / 2) - (this.f / 2), getHeight() - this.e);
            this.b.quadTo(((getWidth() / 2) - (this.f / 2)) + this.g, getHeight() - this.e, ((getWidth() / 2) - (this.f / 2)) + this.h, (getHeight() - this.e) - this.i);
            this.b.quadTo(getWidth() / 2, (getHeight() - this.e) - this.j, ((getWidth() / 2) + (this.f / 2)) - this.h, (getHeight() - this.e) - this.i);
            this.b.quadTo(((getWidth() / 2) + (this.f / 2)) - this.g, getHeight() - this.e, (getWidth() / 2) + (this.f / 2), getHeight() - this.e);
            this.b.lineTo(getWidth(), getHeight() - this.e);
            this.b.lineTo(getWidth(), getHeight());
            this.b.lineTo(0.0f, getHeight());
            this.b.close();
            this.c.moveTo(0.0f, (getHeight() - this.e) + this.k);
            this.c.lineTo((getWidth() / 2) - (this.f / 2), (getHeight() - this.e) + this.k);
            this.c.quadTo(((getWidth() / 2) - (this.f / 2)) + this.g, (getHeight() - this.e) + this.k, ((getWidth() / 2) - (this.f / 2)) + this.h, ((getHeight() - this.e) - this.i) + this.k);
            this.c.quadTo(getWidth() / 2, ((getHeight() - this.e) - this.j) + this.k, ((getWidth() / 2) + (this.f / 2)) - this.h, ((getHeight() - this.e) - this.i) + this.k);
            this.c.quadTo(((getWidth() / 2) + (this.f / 2)) - this.g, (getHeight() - this.e) + this.k, (getWidth() / 2) + (this.f / 2), (getHeight() - this.e) + this.k);
            this.c.lineTo(getWidth(), (getHeight() - this.e) + this.k);
            this.c.lineTo(getWidth(), getHeight());
            this.c.lineTo(0.0f, getHeight());
            this.c.close();
            canvas.drawPath(this.c, this.d);
            canvas.drawPath(this.b, this.a);
        }
    }
}
