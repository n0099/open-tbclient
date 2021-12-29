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
/* loaded from: classes11.dex */
public class FragmentTabSwellingView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BG_Style = 0;
    public static final int SWELLING_BG_Style = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f41705e;

    /* renamed from: f  reason: collision with root package name */
    public Path f41706f;

    /* renamed from: g  reason: collision with root package name */
    public Path f41707g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f41708h;

    /* renamed from: i  reason: collision with root package name */
    public int f41709i;

    /* renamed from: j  reason: collision with root package name */
    public int f41710j;

    /* renamed from: k  reason: collision with root package name */
    public int f41711k;
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
            this.f41705e = paint;
            paint.setColor(SkinManager.getColor(R.color.CAM_X0205));
            this.f41705e.setAntiAlias(true);
            this.f41705e.setStrokeWidth(1.0f);
            this.f41705e.setDither(true);
            this.f41705e.setStyle(Paint.Style.FILL);
            Paint paint2 = new Paint();
            this.f41708h = paint2;
            paint2.setAntiAlias(true);
            this.f41708h.setDither(true);
            this.f41708h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f41706f = new Path();
            this.f41707g = new Path();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f41709i = n.f(getContext().getApplicationContext(), R.dimen.tbds137);
            this.f41710j = n.f(getContext().getApplicationContext(), R.dimen.tbds204);
            this.f41711k = n.f(getContext().getApplicationContext(), R.dimen.tbds23);
            this.l = n.f(getContext().getApplicationContext(), R.dimen.tbds51);
            this.m = n.f(getContext().getApplicationContext(), R.dimen.tbds16);
            this.n = n.f(getContext().getApplicationContext(), R.dimen.tbds52);
            this.o = n.f(getContext().getApplicationContext(), R.dimen.tbds2);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 != 1 && i2 != 4) {
                this.f41705e.setColor(SkinManager.getColor(R.color.CAM_X0205));
                this.f41708h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
            } else {
                this.f41705e.setColor(SkinManager.getColor(R.color.CAM_X0206_1));
                this.f41708h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
            }
            invalidate();
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
            this.f41707g.reset();
            this.f41706f.reset();
            this.f41706f.moveTo(0.0f, getHeight() - this.f41709i);
            this.f41706f.lineTo((getWidth() / 2) - (this.f41710j / 2), getHeight() - this.f41709i);
            this.f41706f.quadTo(((getWidth() / 2) - (this.f41710j / 2)) + this.f41711k, getHeight() - this.f41709i, ((getWidth() / 2) - (this.f41710j / 2)) + this.l, (getHeight() - this.f41709i) - this.m);
            this.f41706f.quadTo(getWidth() / 2, (getHeight() - this.f41709i) - this.n, ((getWidth() / 2) + (this.f41710j / 2)) - this.l, (getHeight() - this.f41709i) - this.m);
            this.f41706f.quadTo(((getWidth() / 2) + (this.f41710j / 2)) - this.f41711k, getHeight() - this.f41709i, (getWidth() / 2) + (this.f41710j / 2), getHeight() - this.f41709i);
            this.f41706f.lineTo(getWidth(), getHeight() - this.f41709i);
            this.f41706f.lineTo(getWidth(), getHeight());
            this.f41706f.lineTo(0.0f, getHeight());
            this.f41706f.close();
            this.f41707g.moveTo(0.0f, (getHeight() - this.f41709i) + this.o);
            this.f41707g.lineTo((getWidth() / 2) - (this.f41710j / 2), (getHeight() - this.f41709i) + this.o);
            this.f41707g.quadTo(((getWidth() / 2) - (this.f41710j / 2)) + this.f41711k, (getHeight() - this.f41709i) + this.o, ((getWidth() / 2) - (this.f41710j / 2)) + this.l, ((getHeight() - this.f41709i) - this.m) + this.o);
            this.f41707g.quadTo(getWidth() / 2, ((getHeight() - this.f41709i) - this.n) + this.o, ((getWidth() / 2) + (this.f41710j / 2)) - this.l, ((getHeight() - this.f41709i) - this.m) + this.o);
            this.f41707g.quadTo(((getWidth() / 2) + (this.f41710j / 2)) - this.f41711k, (getHeight() - this.f41709i) + this.o, (getWidth() / 2) + (this.f41710j / 2), (getHeight() - this.f41709i) + this.o);
            this.f41707g.lineTo(getWidth(), (getHeight() - this.f41709i) + this.o);
            this.f41707g.lineTo(getWidth(), getHeight());
            this.f41707g.lineTo(0.0f, getHeight());
            this.f41707g.close();
            canvas.drawPath(this.f41707g, this.f41708h);
            canvas.drawPath(this.f41706f, this.f41705e);
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
