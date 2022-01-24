package com.baidu.nadcore.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import c.a.c0.k0.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Path f37266e;

    /* renamed from: f  reason: collision with root package name */
    public int f37267f;

    /* renamed from: g  reason: collision with root package name */
    public int f37268g;

    /* renamed from: h  reason: collision with root package name */
    public int f37269h;

    /* renamed from: i  reason: collision with root package name */
    public int f37270i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f37271j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundCornerFrameLayout(Context context) {
        this(context, null, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getWidth() == this.f37269h && getHeight() == this.f37270i && this.f37268g == this.f37267f) {
                return false;
            }
            this.f37269h = getWidth();
            this.f37270i = getHeight();
            this.f37268g = this.f37267f;
            if (this.f37266e == null) {
                Path path = new Path();
                this.f37266e = path;
                path.setFillType(Path.FillType.EVEN_ODD);
            }
            Path path2 = this.f37266e;
            RectF rectF = new RectF(0.0f, 0.0f, this.f37269h, this.f37270i);
            int i2 = this.f37267f;
            path2.addRoundRect(rectF, i2, i2, Path.Direction.CW);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void b(Context context, AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet, i2) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.RoundCornerRelativeLayout);
            int dimension = (int) obtainStyledAttributes.getDimension(q.RoundCornerRelativeLayout_round_edge_radius, 0.0f);
            if (dimension > 0) {
                setCornerRadius(dimension);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Path path = new Path();
            this.f37266e = path;
            path.setFillType(Path.FillType.EVEN_ODD);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            canvas.save();
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            if (this.f37271j) {
                a();
                canvas.clipPath(this.f37266e);
            }
            super.onDraw(canvas);
        }
    }

    public void setCornerRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (this.f37267f != i2) {
                this.f37267f = i2;
            }
            this.f37271j = this.f37267f > 0;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
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
    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f37271j = false;
        b(context, attributeSet, i2);
        c();
    }
}
