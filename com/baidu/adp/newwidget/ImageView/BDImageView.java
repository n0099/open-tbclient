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
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fo;
import com.repackage.oi;
import com.repackage.pk;
import com.repackage.sk;
import com.repackage.tk;
import com.repackage.wk;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class BDImageView extends ImageView implements ViewTreeObserver.OnPreDrawListener, wk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public ImageView.ScaleType b;
    public ImageView.ScaleType c;
    public DrawerArgs d;
    public pk e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public int l;
    public sk m;
    public boolean n;
    public Drawable o;
    public Drawable p;
    public Drawable q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = ImageView.ScaleType.CENTER_INSIDE;
        this.c = null;
        this.d = new DrawerArgs();
        this.f = true;
        this.h = true;
        this.k = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.m = new sk();
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
            return resources.getDimensionPixelSize(resources2.getIdentifier("tbds" + str, EMABTest.TYPE_DIMEN, app.getPackageName()));
        }
        return invokeL.floatValue;
    }

    private void getDisplayBdImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            ImageView.ScaleType scaleType = getScaleType();
            this.m.a = (BitmapDrawable) getDrawable();
            this.m.b = getBdImage();
            if (this.m.e()) {
                this.m.b = null;
                c();
                this.m.c = false;
                this.q = this.p;
            } else if (this.m.d()) {
                this.m.a = null;
                c();
                this.m.c = false;
                this.q = this.p;
            } else {
                sk skVar = this.m;
                skVar.a = null;
                skVar.b = getDefaultBdImage();
                this.m.c = true;
                if (this.m.d()) {
                    scaleType = this.b;
                }
                this.q = this.o;
            }
            if (this.c != scaleType) {
                this.c = scaleType;
                this.h = true;
            }
        }
    }

    public static float[] h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (app == null) {
                return j(0.0f);
            }
            String[] split = app.getString(i).split(",");
            int min = Math.min(split.length, 4);
            float[] fArr = new float[8];
            for (int i2 = 0; i2 < min; i2++) {
                float g = g(split[i2]);
                int i3 = i2 * 2;
                fArr[i3] = g;
                fArr[i3 + 1] = g;
            }
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }

    public static float[] j(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65542, null, f)) == null) {
            float[] fArr = new float[8];
            Arrays.fill(fArr, f);
            return fArr;
        }
        return (float[]) invokeF.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.m.c) {
            this.h = true;
            if (!this.n && this.i == 1073741824 && this.j == 1073741824) {
                return;
            }
            requestLayout();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.g && this.f && this.h) {
            this.e.c(this.m, this, this.c);
            this.h = false;
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (!this.m.c()) {
                if (this.d.o) {
                    this.e.q();
                    this.e.a(this.m, this);
                    this.e.f(canvas, this);
                    return;
                }
                return;
            }
            d();
            this.e.g(canvas, this.m, this);
        }
    }

    public void f(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, canvas, imageView) == null) {
        }
    }

    public abstract fo getBdImage();

    public abstract fo getDefaultBdImage();

    public boolean getDrawBorder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d.c : invokeV.booleanValue;
    }

    public int getImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            getDisplayBdImage();
            int a = this.m.a();
            this.m.f();
            return a;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!this.f) {
                return super.getImageMatrix();
            }
            return this.e.k();
        }
        return (Matrix) invokeV.objValue;
    }

    public int getImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            getDisplayBdImage();
            int b = this.m.b();
            this.m.f();
            return b;
        }
        return invokeV.intValue;
    }

    public void i(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, attributeSet) == null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04007b, R.attr.obfuscated_res_0x7f0400dc, R.attr.obfuscated_res_0x7f0400df, R.attr.obfuscated_res_0x7f0400e0, R.attr.obfuscated_res_0x7f040206, R.attr.obfuscated_res_0x7f0402a0, R.attr.obfuscated_res_0x7f0402a5, R.attr.obfuscated_res_0x7f0402b7, R.attr.obfuscated_res_0x7f04030a, R.attr.obfuscated_res_0x7f04045b, R.attr.obfuscated_res_0x7f040462, R.attr.obfuscated_res_0x7f04051c, R.attr.obfuscated_res_0x7f04051d, R.attr.obfuscated_res_0x7f04051e, R.attr.obfuscated_res_0x7f04051f, R.attr.obfuscated_res_0x7f040520, R.attr.obfuscated_res_0x7f040592});
                this.d.a = j(obtainStyledAttributes.getDimensionPixelSize(11, oi.d(getContext(), 4.0f)));
                this.d.b = obtainStyledAttributes.getBoolean(8, false);
                this.d.c = obtainStyledAttributes.getBoolean(7, false);
                this.d.d = obtainStyledAttributes.getDimensionPixelSize(3, oi.d(getContext(), 1.0f));
                this.d.e = obtainStyledAttributes.getColor(1, 201326592);
                this.d.g = obtainStyledAttributes.getBoolean(2, false);
                this.d.i = obtainStyledAttributes.getBoolean(16, true);
                this.d.m = obtainStyledAttributes.getColor(5, 0);
                this.a = obtainStyledAttributes.getInt(4, 0);
                this.k = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
                this.l = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
                this.n = obtainStyledAttributes.getBoolean(0, false);
                obtainStyledAttributes.recycle();
            } else {
                this.d.a = j(oi.d(getContext(), 4.0f));
                this.d.d = oi.d(getContext(), 1.0f);
                this.d.e = 201326592;
            }
            pk a = tk.b().a(this.a);
            this.e = a;
            a.p(this.d);
        }
    }

    public final int k(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048587, this, i, i2, i3)) == null) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 0) {
                    return mode != 1073741824 ? i : size;
                }
                return Math.min(i, i2);
            }
            return Math.min(Math.min(i, size), i2);
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
            this.f = true;
        } else {
            this.f = false;
        }
        this.h = true;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, canvas) == null) {
            if (!this.f) {
                super.onDraw(canvas);
                f(canvas, this);
                return;
            }
            getDisplayBdImage();
            this.e.d(canvas, this, this.q);
            e(canvas);
            f(canvas, this);
            this.e.i(canvas, this);
            this.m.f();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) {
            this.i = View.MeasureSpec.getMode(i);
            this.j = View.MeasureSpec.getMode(i2);
            View.MeasureSpec.getSize(i);
            View.MeasureSpec.getSize(i2);
            getDisplayBdImage();
            int b = this.m.b();
            int a = this.m.a();
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int max = Math.max(b + paddingLeft, getSuggestedMinimumWidth());
            int max2 = Math.max(a + paddingTop, getSuggestedMinimumHeight());
            if (max <= paddingLeft || max2 <= paddingTop || this.m.c || !this.n) {
                max = k(max, this.k, i);
                max2 = k(max2, this.l, i2);
            }
            this.m.f();
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048591, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.h = true;
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || z == this.n) {
            return;
        }
        this.n = z;
        requestLayout();
    }

    public void setAlphaValue(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048593, this, f) == null) || Math.abs(this.d.k - f) <= 1.0E-4f) {
            return;
        }
        this.d.k = f;
        invalidate();
    }

    public void setBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, drawable) == null) {
            this.p = drawable;
        }
    }

    public void setBorderColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            DrawerArgs drawerArgs = this.d;
            if (drawerArgs.e != i) {
                drawerArgs.e = i;
                invalidate();
            }
        }
    }

    public void setBorderSurroundContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            DrawerArgs drawerArgs = this.d;
            if (drawerArgs.g != z) {
                drawerArgs.g = z;
                this.h = true;
                invalidate();
            }
        }
    }

    public void setBorderWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            DrawerArgs drawerArgs = this.d;
            if (drawerArgs.d != i) {
                drawerArgs.d = i;
                invalidate();
            }
        }
    }

    public void setDefaultBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, drawable) == null) {
            this.o = drawable;
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, scaleType) == null) || this.b == scaleType) {
            return;
        }
        this.b = scaleType;
        this.h = true;
        invalidate();
    }

    public void setDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            DrawerArgs drawerArgs = this.d;
            if (drawerArgs.c != z) {
                drawerArgs.c = z;
                this.h = true;
                invalidate();
            }
        }
    }

    public void setDrawerType(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i) == null) || this.a == i) {
            return;
        }
        this.a = i;
        pk a = tk.b().a(this.a);
        this.e = a;
        a.p(this.d);
        this.h = true;
        invalidate();
    }

    public void setExtraMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, matrix) == null) {
            this.d.l = matrix;
            invalidate();
        }
    }

    public void setForegroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            DrawerArgs drawerArgs = this.d;
            if (drawerArgs.m != i) {
                drawerArgs.m = i;
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048604, this, i, i2, i3, i4)) == null) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            this.g = true;
            return frame;
        }
        return invokeIIII.booleanValue;
    }

    public void setGifIconSupport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            DrawerArgs drawerArgs = this.d;
            if (drawerArgs.i != z) {
                drawerArgs.i = z;
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
            if (!this.f) {
                super.setImageMatrix(matrix);
            } else if (matrix == null || this.c != ImageView.ScaleType.MATRIX) {
            } else {
                this.e.n(matrix);
                this.h = true;
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            super.setImageResource(i);
            l();
        }
    }

    public void setIsPreDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            DrawerArgs drawerArgs = this.d;
            if (drawerArgs.o != z) {
                drawerArgs.o = z;
                invalidate();
            }
        }
    }

    public void setIsRound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            DrawerArgs drawerArgs = this.d;
            if (drawerArgs.b != z) {
                drawerArgs.b = z;
                invalidate();
            }
        }
    }

    public void setLongIconSupport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            DrawerArgs drawerArgs = this.d;
            if (drawerArgs.h != z) {
                drawerArgs.h = z;
                invalidate();
            }
        }
    }

    public void setRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            float[] j = j(i);
            if (Arrays.equals(this.d.a, j)) {
                return;
            }
            this.d.a = j;
            invalidate();
        }
    }

    public void setRadiusById(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            float[] h = h(i);
            if (Arrays.equals(this.d.a, h)) {
                return;
            }
            this.d.a = h;
            invalidate();
        }
    }

    public void setSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            DrawerArgs drawerArgs = this.d;
            DrawerArgs.SkinType skinType = drawerArgs.f;
            if (i == 1) {
                drawerArgs.f = DrawerArgs.SkinType.NIGHT;
            } else if (i != 4) {
                drawerArgs.f = DrawerArgs.SkinType.DAY;
            } else {
                drawerArgs.f = DrawerArgs.SkinType.DARK;
            }
            if (skinType != this.d.f) {
                invalidate();
            }
        }
    }

    public void setTLIconType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            DrawerArgs drawerArgs = this.d;
            if (drawerArgs.j != i) {
                drawerArgs.j = i;
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
    public BDImageView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 0;
        this.b = ImageView.ScaleType.CENTER_INSIDE;
        this.c = null;
        this.d = new DrawerArgs();
        this.f = true;
        this.h = true;
        this.k = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.m = new sk();
        i(attributeSet);
    }
}
