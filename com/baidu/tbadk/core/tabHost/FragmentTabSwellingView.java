package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import c.a.d.f.p.m;
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
    public Paint f41546e;

    /* renamed from: f  reason: collision with root package name */
    public Path f41547f;

    /* renamed from: g  reason: collision with root package name */
    public Path f41548g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f41549h;

    /* renamed from: i  reason: collision with root package name */
    public int f41550i;

    /* renamed from: j  reason: collision with root package name */
    public int f41551j;

    /* renamed from: k  reason: collision with root package name */
    public int f41552k;
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
            this.f41546e = paint;
            paint.setColor(SkinManager.getColor(R.color.CAM_X0205));
            this.f41546e.setAntiAlias(true);
            this.f41546e.setStrokeWidth(1.0f);
            this.f41546e.setDither(true);
            this.f41546e.setStyle(Paint.Style.FILL);
            Paint paint2 = new Paint();
            this.f41549h = paint2;
            paint2.setAntiAlias(true);
            this.f41549h.setDither(true);
            this.f41549h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f41547f = new Path();
            this.f41548g = new Path();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f41550i = m.f(getContext().getApplicationContext(), R.dimen.tbds137);
            this.f41551j = m.f(getContext().getApplicationContext(), R.dimen.tbds204);
            this.f41552k = m.f(getContext().getApplicationContext(), R.dimen.tbds23);
            this.l = m.f(getContext().getApplicationContext(), R.dimen.tbds51);
            this.m = m.f(getContext().getApplicationContext(), R.dimen.tbds16);
            this.n = m.f(getContext().getApplicationContext(), R.dimen.tbds52);
            this.o = m.f(getContext().getApplicationContext(), R.dimen.tbds2);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 != 1 && i2 != 4) {
                this.f41546e.setColor(SkinManager.getColor(R.color.CAM_X0205));
                this.f41549h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
            } else {
                this.f41546e.setColor(SkinManager.getColor(R.color.CAM_X0206_1));
                this.f41549h.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            if (getWidth() > m.k(getContext())) {
                return;
            }
            this.f41548g.reset();
            this.f41547f.reset();
            this.f41547f.moveTo(0.0f, getHeight() - this.f41550i);
            this.f41547f.lineTo((getWidth() / 2) - (this.f41551j / 2), getHeight() - this.f41550i);
            this.f41547f.quadTo(((getWidth() / 2) - (this.f41551j / 2)) + this.f41552k, getHeight() - this.f41550i, ((getWidth() / 2) - (this.f41551j / 2)) + this.l, (getHeight() - this.f41550i) - this.m);
            this.f41547f.quadTo(getWidth() / 2, (getHeight() - this.f41550i) - this.n, ((getWidth() / 2) + (this.f41551j / 2)) - this.l, (getHeight() - this.f41550i) - this.m);
            this.f41547f.quadTo(((getWidth() / 2) + (this.f41551j / 2)) - this.f41552k, getHeight() - this.f41550i, (getWidth() / 2) + (this.f41551j / 2), getHeight() - this.f41550i);
            this.f41547f.lineTo(getWidth(), getHeight() - this.f41550i);
            this.f41547f.lineTo(getWidth(), getHeight());
            this.f41547f.lineTo(0.0f, getHeight());
            this.f41547f.close();
            this.f41548g.moveTo(0.0f, (getHeight() - this.f41550i) + this.o);
            this.f41548g.lineTo((getWidth() / 2) - (this.f41551j / 2), (getHeight() - this.f41550i) + this.o);
            this.f41548g.quadTo(((getWidth() / 2) - (this.f41551j / 2)) + this.f41552k, (getHeight() - this.f41550i) + this.o, ((getWidth() / 2) - (this.f41551j / 2)) + this.l, ((getHeight() - this.f41550i) - this.m) + this.o);
            this.f41548g.quadTo(getWidth() / 2, ((getHeight() - this.f41550i) - this.n) + this.o, ((getWidth() / 2) + (this.f41551j / 2)) - this.l, ((getHeight() - this.f41550i) - this.m) + this.o);
            this.f41548g.quadTo(((getWidth() / 2) + (this.f41551j / 2)) - this.f41552k, (getHeight() - this.f41550i) + this.o, (getWidth() / 2) + (this.f41551j / 2), (getHeight() - this.f41550i) + this.o);
            this.f41548g.lineTo(getWidth(), (getHeight() - this.f41550i) + this.o);
            this.f41548g.lineTo(getWidth(), getHeight());
            this.f41548g.lineTo(0.0f, getHeight());
            this.f41548g.close();
            canvas.drawPath(this.f41548g, this.f41549h);
            canvas.drawPath(this.f41547f, this.f41546e);
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
