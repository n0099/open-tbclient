package com.baidu.adp.newwidget.ImageView;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.f.a.a;
import d.a.c.f.a.d;
import d.a.c.f.a.e;
import d.a.c.f.a.f;
import d.a.c.f.a.i;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class BDImageView extends ImageView implements ViewTreeObserver.OnPreDrawListener, i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f2198e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView.ScaleType f2199f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView.ScaleType f2200g;

    /* renamed from: h  reason: collision with root package name */
    public e f2201h;

    /* renamed from: i  reason: collision with root package name */
    public a f2202i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public d q;
    public boolean r;
    public Drawable s;
    public Drawable t;
    public Drawable u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDImageView(Context context) {
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
        this.f2198e = 0;
        this.f2199f = ImageView.ScaleType.CENTER_INSIDE;
        this.f2200g = null;
        this.f2201h = new e();
        this.j = true;
        this.l = true;
        this.o = Integer.MAX_VALUE;
        this.p = Integer.MAX_VALUE;
        this.q = new d();
        i(null);
    }

    public static float g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (app == null) {
                return 0.0f;
            }
            if (str.endsWith("H")) {
                return Float.parseFloat(str.substring(0, str.length() - 1));
            }
            Resources resources = app.getResources();
            Resources resources2 = app.getResources();
            return resources.getDimensionPixelSize(resources2.getIdentifier("tbds" + str, "dimen", app.getPackageName()));
        }
        return invokeL.floatValue;
    }

    private void getDisplayBdImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            ImageView.ScaleType scaleType = getScaleType();
            this.q.f44583a = (BitmapDrawable) getDrawable();
            this.q.f44584b = getBdImage();
            if (this.q.e()) {
                this.q.f44584b = null;
                c();
                this.q.f44585c = false;
                this.u = this.t;
            } else if (this.q.d()) {
                this.q.f44583a = null;
                c();
                this.q.f44585c = false;
                this.u = this.t;
            } else {
                d dVar = this.q;
                dVar.f44583a = null;
                dVar.f44584b = getDefaultBdImage();
                this.q.f44585c = true;
                if (this.q.d()) {
                    scaleType = this.f2199f;
                }
                this.u = this.s;
            }
            if (this.f2200g != scaleType) {
                this.f2200g = scaleType;
                this.l = true;
            }
        }
    }

    public static float[] h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (app == null) {
                return j(0.0f);
            }
            String[] split = app.getString(i2).split(",");
            int min = Math.min(split.length, 4);
            float[] fArr = new float[8];
            for (int i3 = 0; i3 < min; i3++) {
                float g2 = g(split[i3]);
                int i4 = i3 * 2;
                fArr[i4] = g2;
                fArr[i4 + 1] = g2;
            }
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }

    public static float[] j(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(AdIconUtil.BAIDU_LOGO_ID, null, f2)) == null) {
            float[] fArr = new float[8];
            Arrays.fill(fArr, f2);
            return fArr;
        }
        return (float[]) invokeF.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.q.f44585c) {
            this.l = true;
            if (!this.r && this.m == 1073741824 && this.n == 1073741824) {
                return;
            }
            requestLayout();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.k && this.j && this.l) {
            this.f2202i.c(this.q, this, this.f2200g);
            this.l = false;
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (!this.q.c()) {
                if (this.f2201h.o) {
                    this.f2202i.q();
                    this.f2202i.a(this.q, this);
                    this.f2202i.f(canvas, this);
                    return;
                }
                return;
            }
            d();
            this.f2202i.g(canvas, this.q, this);
        }
    }

    public void f(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, canvas, imageView) == null) {
        }
    }

    public abstract d.a.c.k.d.a getBdImage();

    public abstract d.a.c.k.d.a getDefaultBdImage();

    public boolean getDrawBorder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2201h.f44588c : invokeV.booleanValue;
    }

    public int getImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            getDisplayBdImage();
            int a2 = this.q.a();
            this.q.f();
            return a2;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!this.j) {
                return super.getImageMatrix();
            }
            return this.f2202i.k();
        }
        return (Matrix) invokeV.objValue;
    }

    public int getImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            getDisplayBdImage();
            int b2 = this.q.b();
            this.q.f();
            return b2;
        }
        return invokeV.intValue;
    }

    public void i(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, attributeSet) == null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
                this.f2201h.f44586a = j(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, l.e(getContext(), 4.0f)));
                this.f2201h.f44587b = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
                this.f2201h.f44588c = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
                this.f2201h.f44589d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, l.e(getContext(), 1.0f));
                this.f2201h.f44590e = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
                this.f2201h.f44592g = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
                this.f2201h.f44594i = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
                this.f2201h.m = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
                this.f2198e = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
                this.o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, Integer.MAX_VALUE);
                this.p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, Integer.MAX_VALUE);
                this.r = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
                obtainStyledAttributes.recycle();
            } else {
                this.f2201h.f44586a = j(l.e(getContext(), 4.0f));
                this.f2201h.f44589d = l.e(getContext(), 1.0f);
                this.f2201h.f44590e = 201326592;
            }
            a a2 = f.b().a(this.f2198e);
            this.f2202i = a2;
            a2.p(this.f2201h);
        }
    }

    public final int k(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048587, this, i2, i3, i4)) == null) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 0) {
                    return mode != 1073741824 ? i2 : size;
                }
                return Math.min(i2, i3);
            }
            return Math.min(Math.min(i2, size), i3);
        }
        return invokeIII.intValue;
    }

    public final void l() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (drawable = getDrawable()) == null) {
            return;
        }
        if (drawable instanceof BitmapDrawable) {
            this.j = true;
        } else {
            this.j = false;
        }
        this.l = true;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, canvas) == null) {
            if (!this.j) {
                super.onDraw(canvas);
                f(canvas, this);
                return;
            }
            getDisplayBdImage();
            this.f2202i.d(canvas, this, this.u);
            e(canvas);
            f(canvas, this);
            this.f2202i.i(canvas, this);
            this.q.f();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            this.m = View.MeasureSpec.getMode(i2);
            this.n = View.MeasureSpec.getMode(i3);
            View.MeasureSpec.getSize(i2);
            View.MeasureSpec.getSize(i3);
            getDisplayBdImage();
            int b2 = this.q.b();
            int a2 = this.q.a();
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int max = Math.max(b2 + paddingLeft, getSuggestedMinimumWidth());
            int max2 = Math.max(a2 + paddingTop, getSuggestedMinimumHeight());
            if (max <= paddingLeft || max2 <= paddingTop || this.q.f44585c || !this.r) {
                max = k(max, this.o, i2);
                max2 = k(max2, this.p, i3);
            }
            this.q.f();
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048591, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.l = true;
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || z == this.r) {
            return;
        }
        this.r = z;
        requestLayout();
    }

    public void setAlphaValue(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048593, this, f2) == null) || Math.abs(this.f2201h.k - f2) <= 1.0E-4f) {
            return;
        }
        this.f2201h.k = f2;
        invalidate();
    }

    public void setBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, drawable) == null) {
            this.t = drawable;
        }
    }

    public void setBorderColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            e eVar = this.f2201h;
            if (eVar.f44590e != i2) {
                eVar.f44590e = i2;
                invalidate();
            }
        }
    }

    public void setBorderSurroundContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            e eVar = this.f2201h;
            if (eVar.f44592g != z) {
                eVar.f44592g = z;
                this.l = true;
                invalidate();
            }
        }
    }

    public void setBorderWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            e eVar = this.f2201h;
            if (eVar.f44589d != i2) {
                eVar.f44589d = i2;
                invalidate();
            }
        }
    }

    public void setDefaultBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, drawable) == null) {
            this.s = drawable;
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, scaleType) == null) || this.f2199f == scaleType) {
            return;
        }
        this.f2199f = scaleType;
        this.l = true;
        invalidate();
    }

    public void setDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            e eVar = this.f2201h;
            if (eVar.f44588c != z) {
                eVar.f44588c = z;
                this.l = true;
                invalidate();
            }
        }
    }

    public void setDrawerType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || this.f2198e == i2) {
            return;
        }
        this.f2198e = i2;
        a a2 = f.b().a(this.f2198e);
        this.f2202i = a2;
        a2.p(this.f2201h);
        this.l = true;
        invalidate();
    }

    public void setExtraMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, matrix) == null) {
            this.f2201h.l = matrix;
            invalidate();
        }
    }

    public void setForegroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            e eVar = this.f2201h;
            if (eVar.m != i2) {
                eVar.m = i2;
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048604, this, i2, i3, i4, i5)) == null) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            this.k = true;
            return frame;
        }
        return invokeIIII.booleanValue;
    }

    public void setGifIconSupport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            e eVar = this.f2201h;
            if (eVar.f44594i != z) {
                eVar.f44594i = z;
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, drawable) == null) {
            super.setImageDrawable(drawable);
            l();
        }
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, matrix) == null) {
            if (!this.j) {
                super.setImageMatrix(matrix);
            } else if (matrix == null || this.f2200g != ImageView.ScaleType.MATRIX) {
            } else {
                this.f2202i.n(matrix);
                this.l = true;
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            super.setImageResource(i2);
            l();
        }
    }

    public void setIsNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            e eVar = this.f2201h;
            if (eVar.f44591f != z) {
                eVar.f44591f = z;
                invalidate();
            }
        }
    }

    public void setIsPreDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            e eVar = this.f2201h;
            if (eVar.o != z) {
                eVar.o = z;
                invalidate();
            }
        }
    }

    public void setIsRound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            e eVar = this.f2201h;
            if (eVar.f44587b != z) {
                eVar.f44587b = z;
                invalidate();
            }
        }
    }

    public void setLongIconSupport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            e eVar = this.f2201h;
            if (eVar.f44593h != z) {
                eVar.f44593h = z;
                invalidate();
            }
        }
    }

    public void setRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            float[] j = j(i2);
            if (Arrays.equals(this.f2201h.f44586a, j)) {
                return;
            }
            this.f2201h.f44586a = j;
            invalidate();
        }
    }

    public void setRadiusById(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            float[] h2 = h(i2);
            if (Arrays.equals(this.f2201h.f44586a, h2)) {
                return;
            }
            this.f2201h.f44586a = h2;
            invalidate();
        }
    }

    public void setTLIconType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            e eVar = this.f2201h;
            if (eVar.j != i2) {
                eVar.j = i2;
                invalidate();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BDImageView(Context context, AttributeSet attributeSet) {
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
    public BDImageView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f2198e = 0;
        this.f2199f = ImageView.ScaleType.CENTER_INSIDE;
        this.f2200g = null;
        this.f2201h = new e();
        this.j = true;
        this.l = true;
        this.o = Integer.MAX_VALUE;
        this.p = Integer.MAX_VALUE;
        this.q = new d();
        i(attributeSet);
    }
}
