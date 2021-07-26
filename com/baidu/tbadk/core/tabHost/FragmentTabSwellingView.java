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
import d.a.d.e.p.l;
/* loaded from: classes3.dex */
public class FragmentTabSwellingView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f12400e;

    /* renamed from: f  reason: collision with root package name */
    public Path f12401f;

    /* renamed from: g  reason: collision with root package name */
    public Path f12402g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f12403h;

    /* renamed from: i  reason: collision with root package name */
    public int f12404i;
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
                this.f12400e.setColor(SkinManager.getColor(R.color.CAM_X0205));
                this.f12403h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
            } else {
                this.f12400e.setColor(SkinManager.getColor(R.color.CAM_X0206_1));
                this.f12403h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
            }
            invalidate();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Paint paint = new Paint();
            this.f12400e = paint;
            paint.setColor(SkinManager.getColor(R.color.CAM_X0205));
            this.f12400e.setAntiAlias(true);
            this.f12400e.setStrokeWidth(1.0f);
            this.f12400e.setDither(true);
            this.f12400e.setStyle(Paint.Style.FILL);
            Paint paint2 = new Paint();
            this.f12403h = paint2;
            paint2.setAntiAlias(true);
            this.f12403h.setDither(true);
            this.f12403h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f12401f = new Path();
            this.f12402g = new Path();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f12404i = l.g(getContext().getApplicationContext(), R.dimen.tbds137);
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
            this.f12402g.reset();
            this.f12401f.reset();
            this.f12401f.moveTo(0.0f, getHeight() - this.f12404i);
            this.f12401f.lineTo((getWidth() / 2) - (this.j / 2), getHeight() - this.f12404i);
            this.f12401f.quadTo(((getWidth() / 2) - (this.j / 2)) + this.k, getHeight() - this.f12404i, ((getWidth() / 2) - (this.j / 2)) + this.l, (getHeight() - this.f12404i) - this.m);
            this.f12401f.quadTo(getWidth() / 2, (getHeight() - this.f12404i) - this.n, ((getWidth() / 2) + (this.j / 2)) - this.l, (getHeight() - this.f12404i) - this.m);
            this.f12401f.quadTo(((getWidth() / 2) + (this.j / 2)) - this.k, getHeight() - this.f12404i, (getWidth() / 2) + (this.j / 2), getHeight() - this.f12404i);
            this.f12401f.lineTo(getWidth(), getHeight() - this.f12404i);
            this.f12401f.lineTo(getWidth(), getHeight());
            this.f12401f.lineTo(0.0f, getHeight());
            this.f12401f.close();
            this.f12402g.moveTo(0.0f, (getHeight() - this.f12404i) + this.o);
            this.f12402g.lineTo((getWidth() / 2) - (this.j / 2), (getHeight() - this.f12404i) + this.o);
            this.f12402g.quadTo(((getWidth() / 2) - (this.j / 2)) + this.k, (getHeight() - this.f12404i) + this.o, ((getWidth() / 2) - (this.j / 2)) + this.l, ((getHeight() - this.f12404i) - this.m) + this.o);
            this.f12402g.quadTo(getWidth() / 2, ((getHeight() - this.f12404i) - this.n) + this.o, ((getWidth() / 2) + (this.j / 2)) - this.l, ((getHeight() - this.f12404i) - this.m) + this.o);
            this.f12402g.quadTo(((getWidth() / 2) + (this.j / 2)) - this.k, (getHeight() - this.f12404i) + this.o, (getWidth() / 2) + (this.j / 2), (getHeight() - this.f12404i) + this.o);
            this.f12402g.lineTo(getWidth(), (getHeight() - this.f12404i) + this.o);
            this.f12402g.lineTo(getWidth(), getHeight());
            this.f12402g.lineTo(0.0f, getHeight());
            this.f12402g.close();
            canvas.drawPath(this.f12402g, this.f12403h);
            canvas.drawPath(this.f12401f, this.f12400e);
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
