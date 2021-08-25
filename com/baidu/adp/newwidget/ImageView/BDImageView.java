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
import c.a.e.e.p.l;
import c.a.e.f.a.a;
import c.a.e.f.a.d;
import c.a.e.f.a.e;
import c.a.e.f.a.f;
import c.a.e.f.a.i;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public abstract class BDImageView extends ImageView implements ViewTreeObserver.OnPreDrawListener, i {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BORDER_COLOR = 201326592;
    public static final int DEFAULT_BORDER_WIDTH = 1;
    public static final int DEFAULT_RADIUS = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView.ScaleType f36183e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView.ScaleType f36184f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36185g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36186h;

    /* renamed from: i  reason: collision with root package name */
    public int f36187i;

    /* renamed from: j  reason: collision with root package name */
    public int f36188j;
    public d k;
    public Drawable l;
    public Drawable m;
    public boolean mAdjustViewBounds;
    public e mArgs;
    public a mDrawer;
    public int mDrawerType;
    public int mMaxHeight;
    public int mMaxWidth;
    public boolean mNeedRecomputeMatrix;
    public Drawable n;

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
        this.mDrawerType = 0;
        this.f36183e = ImageView.ScaleType.CENTER_INSIDE;
        this.f36184f = null;
        this.mArgs = new e();
        this.f36185g = true;
        this.mNeedRecomputeMatrix = true;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.k = new d();
        init(null);
    }

    public static float d(String str) {
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

    public static float[] e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (app == null) {
                return parseCornerRadii(0.0f);
            }
            String[] split = app.getString(i2).split(",");
            int min = Math.min(split.length, 4);
            float[] fArr = new float[8];
            for (int i3 = 0; i3 < min; i3++) {
                float d2 = d(split[i3]);
                int i4 = i3 * 2;
                fArr[i4] = d2;
                fArr[i4 + 1] = d2;
            }
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }

    private void getDisplayBdImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            ImageView.ScaleType scaleType = getScaleType();
            this.k.f2717a = (BitmapDrawable) getDrawable();
            this.k.f2718b = getBdImage();
            if (this.k.e()) {
                this.k.f2718b = null;
                a();
                this.k.f2719c = false;
                this.n = this.m;
            } else if (this.k.d()) {
                this.k.f2717a = null;
                a();
                this.k.f2719c = false;
                this.n = this.m;
            } else {
                d dVar = this.k;
                dVar.f2717a = null;
                dVar.f2718b = getDefaultBdImage();
                this.k.f2719c = true;
                if (this.k.d()) {
                    scaleType = this.f36183e;
                }
                this.n = this.l;
            }
            if (this.f36184f != scaleType) {
                this.f36184f = scaleType;
                this.mNeedRecomputeMatrix = true;
            }
        }
    }

    public static float[] parseCornerRadii(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(AdIconUtil.BAIDU_LOGO_ID, null, f2)) == null) {
            float[] fArr = new float[8];
            Arrays.fill(fArr, f2);
            return fArr;
        }
        return (float[]) invokeF.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.k.f2719c) {
            this.mNeedRecomputeMatrix = true;
            if (!this.mAdjustViewBounds && this.f36187i == 1073741824 && this.f36188j == 1073741824) {
                return;
            }
            requestLayout();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f36186h && this.f36185g && this.mNeedRecomputeMatrix) {
            this.mDrawer.c(this.k, this, this.f36184f);
            this.mNeedRecomputeMatrix = false;
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (!this.k.c()) {
                if (this.mArgs.o) {
                    this.mDrawer.q();
                    this.mDrawer.a(this.k, this);
                    this.mDrawer.f(canvas, this);
                    return;
                }
                return;
            }
            b();
            this.mDrawer.g(canvas, this.k, this);
        }
    }

    public void drawContentTag(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, canvas, imageView) == null) {
        }
    }

    public final int f(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048580, this, i2, i3, i4)) == null) {
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

    public final void g() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (drawable = getDrawable()) == null) {
            return;
        }
        if (drawable instanceof BitmapDrawable) {
            this.f36185g = true;
        } else {
            this.f36185g = false;
        }
        this.mNeedRecomputeMatrix = true;
    }

    public abstract c.a.e.l.d.a getBdImage();

    public abstract c.a.e.l.d.a getDefaultBdImage();

    public boolean getDrawBorder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mArgs.f2722c : invokeV.booleanValue;
    }

    public int getImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            getDisplayBdImage();
            int a2 = this.k.a();
            this.k.f();
            return a2;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!this.f36185g) {
                return super.getImageMatrix();
            }
            return this.mDrawer.k();
        }
        return (Matrix) invokeV.objValue;
    }

    public int getImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            getDisplayBdImage();
            int b2 = this.k.b();
            this.k.f();
            return b2;
        }
        return invokeV.intValue;
    }

    public void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, attributeSet) == null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
                this.mArgs.f2720a = parseCornerRadii(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, l.e(getContext(), 4.0f)));
                this.mArgs.f2721b = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
                this.mArgs.f2722c = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
                this.mArgs.f2723d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, l.e(getContext(), 1.0f));
                this.mArgs.f2724e = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, DEFAULT_BORDER_COLOR);
                this.mArgs.f2726g = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
                this.mArgs.f2728i = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
                this.mArgs.m = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
                this.mDrawerType = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
                this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, Integer.MAX_VALUE);
                this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, Integer.MAX_VALUE);
                this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
                obtainStyledAttributes.recycle();
            } else {
                this.mArgs.f2720a = parseCornerRadii(l.e(getContext(), 4.0f));
                this.mArgs.f2723d = l.e(getContext(), 1.0f);
                this.mArgs.f2724e = DEFAULT_BORDER_COLOR;
            }
            a a2 = f.b().a(this.mDrawerType);
            this.mDrawer = a2;
            a2.p(this.mArgs);
        }
    }

    public boolean isNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mArgs.f2725f : invokeV.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, canvas) == null) {
            if (!this.f36185g) {
                super.onDraw(canvas);
                drawContentTag(canvas, this);
                return;
            }
            getDisplayBdImage();
            this.mDrawer.d(canvas, this, this.n);
            c(canvas);
            drawContentTag(canvas, this);
            this.mDrawer.i(canvas, this);
            this.k.f();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            this.f36187i = View.MeasureSpec.getMode(i2);
            this.f36188j = View.MeasureSpec.getMode(i3);
            View.MeasureSpec.getSize(i2);
            View.MeasureSpec.getSize(i3);
            getDisplayBdImage();
            int b2 = this.k.b();
            int a2 = this.k.a();
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int max = Math.max(b2 + paddingLeft, getSuggestedMinimumWidth());
            int max2 = Math.max(a2 + paddingTop, getSuggestedMinimumHeight());
            if (max <= paddingLeft || max2 <= paddingTop || this.k.f2719c || !this.mAdjustViewBounds) {
                max = f(max, this.mMaxWidth, i2);
                max2 = f(max2, this.mMaxHeight, i3);
            }
            this.k.f();
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048592, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.mNeedRecomputeMatrix = true;
        }
    }

    @Override // c.a.e.f.a.i
    public abstract /* synthetic */ void refresh();

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || z == this.mAdjustViewBounds) {
            return;
        }
        this.mAdjustViewBounds = z;
        requestLayout();
    }

    public void setAlphaValue(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048595, this, f2) == null) || Math.abs(this.mArgs.k - f2) <= 1.0E-4f) {
            return;
        }
        this.mArgs.k = f2;
        invalidate();
    }

    public void setBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, drawable) == null) {
            this.m = drawable;
        }
    }

    public void setBorderColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            e eVar = this.mArgs;
            if (eVar.f2724e != i2) {
                eVar.f2724e = i2;
                invalidate();
            }
        }
    }

    public void setBorderSurroundContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            e eVar = this.mArgs;
            if (eVar.f2726g != z) {
                eVar.f2726g = z;
                this.mNeedRecomputeMatrix = true;
                invalidate();
            }
        }
    }

    public void setBorderWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            e eVar = this.mArgs;
            if (eVar.f2723d != i2) {
                eVar.f2723d = i2;
                invalidate();
            }
        }
    }

    public void setDefaultBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, drawable) == null) {
            this.l = drawable;
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, scaleType) == null) || this.f36183e == scaleType) {
            return;
        }
        this.f36183e = scaleType;
        this.mNeedRecomputeMatrix = true;
        invalidate();
    }

    public void setDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            e eVar = this.mArgs;
            if (eVar.f2722c != z) {
                eVar.f2722c = z;
                this.mNeedRecomputeMatrix = true;
                invalidate();
            }
        }
    }

    public void setDrawerType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || this.mDrawerType == i2) {
            return;
        }
        this.mDrawerType = i2;
        a a2 = f.b().a(this.mDrawerType);
        this.mDrawer = a2;
        a2.p(this.mArgs);
        this.mNeedRecomputeMatrix = true;
        invalidate();
    }

    public void setExtraMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, matrix) == null) {
            this.mArgs.l = matrix;
            invalidate();
        }
    }

    public void setForegroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            e eVar = this.mArgs;
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
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048606, this, i2, i3, i4, i5)) == null) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            this.f36186h = true;
            return frame;
        }
        return invokeIIII.booleanValue;
    }

    public void setGifIconSupport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            e eVar = this.mArgs;
            if (eVar.f2728i != z) {
                eVar.f2728i = z;
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, drawable) == null) {
            super.setImageDrawable(drawable);
            g();
        }
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, matrix) == null) {
            if (!this.f36185g) {
                super.setImageMatrix(matrix);
            } else if (matrix == null || this.f36184f != ImageView.ScaleType.MATRIX) {
            } else {
                this.mDrawer.n(matrix);
                this.mNeedRecomputeMatrix = true;
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            super.setImageResource(i2);
            g();
        }
    }

    public void setIsNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            e eVar = this.mArgs;
            if (eVar.f2725f != z) {
                eVar.f2725f = z;
                invalidate();
            }
        }
    }

    public void setIsPreDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            e eVar = this.mArgs;
            if (eVar.o != z) {
                eVar.o = z;
                invalidate();
            }
        }
    }

    public void setIsRound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            e eVar = this.mArgs;
            if (eVar.f2721b != z) {
                eVar.f2721b = z;
                invalidate();
            }
        }
    }

    public void setLongIconSupport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            e eVar = this.mArgs;
            if (eVar.f2727h != z) {
                eVar.f2727h = z;
                invalidate();
            }
        }
    }

    public void setRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            float[] parseCornerRadii = parseCornerRadii(i2);
            if (Arrays.equals(this.mArgs.f2720a, parseCornerRadii)) {
                return;
            }
            this.mArgs.f2720a = parseCornerRadii;
            invalidate();
        }
    }

    public void setRadiusById(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            float[] e2 = e(i2);
            if (Arrays.equals(this.mArgs.f2720a, e2)) {
                return;
            }
            this.mArgs.f2720a = e2;
            invalidate();
        }
    }

    public void setTLIconType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            e eVar = this.mArgs;
            if (eVar.f2729j != i2) {
                eVar.f2729j = i2;
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
        this.mDrawerType = 0;
        this.f36183e = ImageView.ScaleType.CENTER_INSIDE;
        this.f36184f = null;
        this.mArgs = new e();
        this.f36185g = true;
        this.mNeedRecomputeMatrix = true;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.k = new d();
        init(attributeSet);
    }
}
