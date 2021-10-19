package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class FragmentTabSwellingView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BG_Style = 0;
    public static final int SWELLING_BG_Style = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f47596e;

    /* renamed from: f  reason: collision with root package name */
    public Path f47597f;

    /* renamed from: g  reason: collision with root package name */
    public Path f47598g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f47599h;

    /* renamed from: i  reason: collision with root package name */
    public int f47600i;

    /* renamed from: j  reason: collision with root package name */
    public int f47601j;
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
            d();
            b();
            c();
            setLayerType(1, null);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Paint paint = new Paint();
            this.f47596e = paint;
            paint.setColor(SkinManager.getColor(R.color.CAM_X0205));
            this.f47596e.setAntiAlias(true);
            this.f47596e.setStrokeWidth(1.0f);
            this.f47596e.setDither(true);
            this.f47596e.setStyle(Paint.Style.FILL);
            Paint paint2 = new Paint();
            this.f47599h = paint2;
            paint2.setAntiAlias(true);
            this.f47599h.setDither(true);
            this.f47599h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f47597f = new Path();
            this.f47598g = new Path();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f47600i = l.g(getContext().getApplicationContext(), R.dimen.tbds137);
            this.f47601j = l.g(getContext().getApplicationContext(), R.dimen.tbds204);
            this.k = l.g(getContext().getApplicationContext(), R.dimen.tbds23);
            this.l = l.g(getContext().getApplicationContext(), R.dimen.tbds51);
            this.m = l.g(getContext().getApplicationContext(), R.dimen.tbds16);
            this.n = l.g(getContext().getApplicationContext(), R.dimen.tbds52);
            this.o = l.g(getContext().getApplicationContext(), R.dimen.tbds2);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 != 1 && i2 != 4) {
                this.f47596e.setColor(SkinManager.getColor(R.color.CAM_X0205));
                this.f47599h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
            } else {
                this.f47596e.setColor(SkinManager.getColor(R.color.CAM_X0206_1));
                this.f47599h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
            }
            invalidate();
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
            this.f47598g.reset();
            this.f47597f.reset();
            this.f47597f.moveTo(0.0f, getHeight() - this.f47600i);
            this.f47597f.lineTo((getWidth() / 2) - (this.f47601j / 2), getHeight() - this.f47600i);
            this.f47597f.quadTo(((getWidth() / 2) - (this.f47601j / 2)) + this.k, getHeight() - this.f47600i, ((getWidth() / 2) - (this.f47601j / 2)) + this.l, (getHeight() - this.f47600i) - this.m);
            this.f47597f.quadTo(getWidth() / 2, (getHeight() - this.f47600i) - this.n, ((getWidth() / 2) + (this.f47601j / 2)) - this.l, (getHeight() - this.f47600i) - this.m);
            this.f47597f.quadTo(((getWidth() / 2) + (this.f47601j / 2)) - this.k, getHeight() - this.f47600i, (getWidth() / 2) + (this.f47601j / 2), getHeight() - this.f47600i);
            this.f47597f.lineTo(getWidth(), getHeight() - this.f47600i);
            this.f47597f.lineTo(getWidth(), getHeight());
            this.f47597f.lineTo(0.0f, getHeight());
            this.f47597f.close();
            this.f47598g.moveTo(0.0f, (getHeight() - this.f47600i) + this.o);
            this.f47598g.lineTo((getWidth() / 2) - (this.f47601j / 2), (getHeight() - this.f47600i) + this.o);
            this.f47598g.quadTo(((getWidth() / 2) - (this.f47601j / 2)) + this.k, (getHeight() - this.f47600i) + this.o, ((getWidth() / 2) - (this.f47601j / 2)) + this.l, ((getHeight() - this.f47600i) - this.m) + this.o);
            this.f47598g.quadTo(getWidth() / 2, ((getHeight() - this.f47600i) - this.n) + this.o, ((getWidth() / 2) + (this.f47601j / 2)) - this.l, ((getHeight() - this.f47600i) - this.m) + this.o);
            this.f47598g.quadTo(((getWidth() / 2) + (this.f47601j / 2)) - this.k, (getHeight() - this.f47600i) + this.o, (getWidth() / 2) + (this.f47601j / 2), (getHeight() - this.f47600i) + this.o);
            this.f47598g.lineTo(getWidth(), (getHeight() - this.f47600i) + this.o);
            this.f47598g.lineTo(getWidth(), getHeight());
            this.f47598g.lineTo(0.0f, getHeight());
            this.f47598g.close();
            canvas.drawPath(this.f47598g, this.f47599h);
            canvas.drawPath(this.f47597f, this.f47596e);
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
