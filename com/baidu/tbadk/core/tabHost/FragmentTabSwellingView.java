package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FragmentTabSwellingView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public Path f29929b;

    /* renamed from: c  reason: collision with root package name */
    public Path f29930c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f29931d;

    /* renamed from: e  reason: collision with root package name */
    public int f29932e;

    /* renamed from: f  reason: collision with root package name */
    public int f29933f;

    /* renamed from: g  reason: collision with root package name */
    public int f29934g;

    /* renamed from: h  reason: collision with root package name */
    public int f29935h;
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
            c();
            d();
            setLayerType(1, null);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i != 1 && i != 4) {
                this.a.setColor(SkinManager.getColor(R.color.CAM_X0205));
                this.f29931d.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
            } else {
                this.a.setColor(SkinManager.getColor(R.color.CAM_X0206_1));
                this.f29931d.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
            }
            invalidate();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Paint paint = new Paint();
            this.a = paint;
            paint.setColor(SkinManager.getColor(R.color.CAM_X0205));
            this.a.setAntiAlias(true);
            this.a.setStrokeWidth(1.0f);
            this.a.setDither(true);
            this.a.setStyle(Paint.Style.FILL);
            Paint paint2 = new Paint();
            this.f29931d = paint2;
            paint2.setAntiAlias(true);
            this.f29931d.setDither(true);
            this.f29931d.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f29929b = new Path();
            this.f29930c = new Path();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f29932e = n.f(getContext().getApplicationContext(), R.dimen.tbds137);
            this.f29933f = n.f(getContext().getApplicationContext(), R.dimen.tbds204);
            this.f29934g = n.f(getContext().getApplicationContext(), R.dimen.tbds23);
            this.f29935h = n.f(getContext().getApplicationContext(), R.dimen.tbds51);
            this.i = n.f(getContext().getApplicationContext(), R.dimen.tbds16);
            this.j = n.f(getContext().getApplicationContext(), R.dimen.tbds52);
            this.k = n.f(getContext().getApplicationContext(), R.dimen.tbds2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            if (getWidth() > n.k(getContext())) {
                return;
            }
            this.f29930c.reset();
            this.f29929b.reset();
            this.f29929b.moveTo(0.0f, getHeight() - this.f29932e);
            this.f29929b.lineTo((getWidth() / 2) - (this.f29933f / 2), getHeight() - this.f29932e);
            this.f29929b.quadTo(((getWidth() / 2) - (this.f29933f / 2)) + this.f29934g, getHeight() - this.f29932e, ((getWidth() / 2) - (this.f29933f / 2)) + this.f29935h, (getHeight() - this.f29932e) - this.i);
            this.f29929b.quadTo(getWidth() / 2, (getHeight() - this.f29932e) - this.j, ((getWidth() / 2) + (this.f29933f / 2)) - this.f29935h, (getHeight() - this.f29932e) - this.i);
            this.f29929b.quadTo(((getWidth() / 2) + (this.f29933f / 2)) - this.f29934g, getHeight() - this.f29932e, (getWidth() / 2) + (this.f29933f / 2), getHeight() - this.f29932e);
            this.f29929b.lineTo(getWidth(), getHeight() - this.f29932e);
            this.f29929b.lineTo(getWidth(), getHeight());
            this.f29929b.lineTo(0.0f, getHeight());
            this.f29929b.close();
            this.f29930c.moveTo(0.0f, (getHeight() - this.f29932e) + this.k);
            this.f29930c.lineTo((getWidth() / 2) - (this.f29933f / 2), (getHeight() - this.f29932e) + this.k);
            this.f29930c.quadTo(((getWidth() / 2) - (this.f29933f / 2)) + this.f29934g, (getHeight() - this.f29932e) + this.k, ((getWidth() / 2) - (this.f29933f / 2)) + this.f29935h, ((getHeight() - this.f29932e) - this.i) + this.k);
            this.f29930c.quadTo(getWidth() / 2, ((getHeight() - this.f29932e) - this.j) + this.k, ((getWidth() / 2) + (this.f29933f / 2)) - this.f29935h, ((getHeight() - this.f29932e) - this.i) + this.k);
            this.f29930c.quadTo(((getWidth() / 2) + (this.f29933f / 2)) - this.f29934g, (getHeight() - this.f29932e) + this.k, (getWidth() / 2) + (this.f29933f / 2), (getHeight() - this.f29932e) + this.k);
            this.f29930c.lineTo(getWidth(), (getHeight() - this.f29932e) + this.k);
            this.f29930c.lineTo(getWidth(), getHeight());
            this.f29930c.lineTo(0.0f, getHeight());
            this.f29930c.close();
            canvas.drawPath(this.f29930c, this.f29931d);
            canvas.drawPath(this.f29929b, this.a);
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
}
