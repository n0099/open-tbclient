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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class FragmentTabSwellingView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f12370e;

    /* renamed from: f  reason: collision with root package name */
    public Path f12371f;

    /* renamed from: g  reason: collision with root package name */
    public Path f12372g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f12373h;

    /* renamed from: i  reason: collision with root package name */
    public int f12374i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentTabSwellingView(Context context) {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
            c();
            d();
            setLayerType(1, null);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 != 1 && i2 != 4) {
                this.f12370e.setColor(SkinManager.getColor(R.color.CAM_X0205));
                this.f12373h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
            } else {
                this.f12370e.setColor(SkinManager.getColor(R.color.CAM_X0206_1));
                this.f12373h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
            }
            invalidate();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Paint paint = new Paint();
            this.f12370e = paint;
            paint.setColor(SkinManager.getColor(R.color.CAM_X0205));
            this.f12370e.setAntiAlias(true);
            this.f12370e.setStrokeWidth(1.0f);
            this.f12370e.setDither(true);
            this.f12370e.setStyle(Paint.Style.FILL);
            Paint paint2 = new Paint();
            this.f12373h = paint2;
            paint2.setAntiAlias(true);
            this.f12373h.setDither(true);
            this.f12373h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f12371f = new Path();
            this.f12372g = new Path();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f12374i = l.g(getContext().getApplicationContext(), R.dimen.tbds137);
            this.j = l.g(getContext().getApplicationContext(), R.dimen.tbds204);
            this.k = l.g(getContext().getApplicationContext(), R.dimen.tbds23);
            this.l = l.g(getContext().getApplicationContext(), R.dimen.tbds51);
            this.m = l.g(getContext().getApplicationContext(), R.dimen.tbds16);
            this.n = l.g(getContext().getApplicationContext(), R.dimen.tbds52);
            this.o = l.g(getContext().getApplicationContext(), R.dimen.tbds2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            if (getWidth() > l.k(getContext())) {
                return;
            }
            this.f12372g.reset();
            this.f12371f.reset();
            this.f12371f.moveTo(0.0f, getHeight() - this.f12374i);
            this.f12371f.lineTo((getWidth() / 2) - (this.j / 2), getHeight() - this.f12374i);
            this.f12371f.quadTo(((getWidth() / 2) - (this.j / 2)) + this.k, getHeight() - this.f12374i, ((getWidth() / 2) - (this.j / 2)) + this.l, (getHeight() - this.f12374i) - this.m);
            this.f12371f.quadTo(getWidth() / 2, (getHeight() - this.f12374i) - this.n, ((getWidth() / 2) + (this.j / 2)) - this.l, (getHeight() - this.f12374i) - this.m);
            this.f12371f.quadTo(((getWidth() / 2) + (this.j / 2)) - this.k, getHeight() - this.f12374i, (getWidth() / 2) + (this.j / 2), getHeight() - this.f12374i);
            this.f12371f.lineTo(getWidth(), getHeight() - this.f12374i);
            this.f12371f.lineTo(getWidth(), getHeight());
            this.f12371f.lineTo(0.0f, getHeight());
            this.f12371f.close();
            this.f12372g.moveTo(0.0f, (getHeight() - this.f12374i) + this.o);
            this.f12372g.lineTo((getWidth() / 2) - (this.j / 2), (getHeight() - this.f12374i) + this.o);
            this.f12372g.quadTo(((getWidth() / 2) - (this.j / 2)) + this.k, (getHeight() - this.f12374i) + this.o, ((getWidth() / 2) - (this.j / 2)) + this.l, ((getHeight() - this.f12374i) - this.m) + this.o);
            this.f12372g.quadTo(getWidth() / 2, ((getHeight() - this.f12374i) - this.n) + this.o, ((getWidth() / 2) + (this.j / 2)) - this.l, ((getHeight() - this.f12374i) - this.m) + this.o);
            this.f12372g.quadTo(((getWidth() / 2) + (this.j / 2)) - this.k, (getHeight() - this.f12374i) + this.o, (getWidth() / 2) + (this.j / 2), (getHeight() - this.f12374i) + this.o);
            this.f12372g.lineTo(getWidth(), (getHeight() - this.f12374i) + this.o);
            this.f12372g.lineTo(getWidth(), getHeight());
            this.f12372g.lineTo(0.0f, getHeight());
            this.f12372g.close();
            canvas.drawPath(this.f12372g, this.f12373h);
            canvas.drawPath(this.f12371f, this.f12370e);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        a();
    }
}
