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
import c.a.d.f.p.l;
import c.a.d.g.a.a;
import c.a.d.g.a.d;
import c.a.d.g.a.e;
import c.a.d.g.a.h;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes8.dex */
public abstract class BDImageView extends ImageView implements ViewTreeObserver.OnPreDrawListener, h {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BORDER_COLOR = 201326592;
    public static final int DEFAULT_BORDER_WIDTH = 1;
    public static final int DEFAULT_RADIUS = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView.ScaleType f31695e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView.ScaleType f31696f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31697g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31698h;

    /* renamed from: i  reason: collision with root package name */
    public int f31699i;

    /* renamed from: j  reason: collision with root package name */
    public int f31700j;

    /* renamed from: k  reason: collision with root package name */
    public d f31701k;
    public Drawable l;
    public Drawable m;
    public boolean mAdjustViewBounds;
    public DrawerArgs mArgs;
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
        this.f31695e = ImageView.ScaleType.CENTER_INSIDE;
        this.f31696f = null;
        this.mArgs = new DrawerArgs();
        this.f31697g = true;
        this.mNeedRecomputeMatrix = true;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.f31701k = new d();
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
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            ImageView.ScaleType scaleType = getScaleType();
            this.f31701k.a = (BitmapDrawable) getDrawable();
            this.f31701k.f2757b = getBdImage();
            if (this.f31701k.e()) {
                this.f31701k.f2757b = null;
                a();
                this.f31701k.f2758c = false;
                this.n = this.m;
            } else if (this.f31701k.d()) {
                this.f31701k.a = null;
                a();
                this.f31701k.f2758c = false;
                this.n = this.m;
            } else {
                d dVar = this.f31701k;
                dVar.a = null;
                dVar.f2757b = getDefaultBdImage();
                this.f31701k.f2758c = true;
                if (this.f31701k.d()) {
                    scaleType = this.f31695e;
                }
                this.n = this.l;
            }
            if (this.f31696f != scaleType) {
                this.f31696f = scaleType;
                this.mNeedRecomputeMatrix = true;
            }
        }
    }

    public static float[] parseCornerRadii(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65542, null, f2)) == null) {
            float[] fArr = new float[8];
            Arrays.fill(fArr, f2);
            return fArr;
        }
        return (float[]) invokeF.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f31701k.f2758c) {
            this.mNeedRecomputeMatrix = true;
            if (!this.mAdjustViewBounds && this.f31699i == 1073741824 && this.f31700j == 1073741824) {
                return;
            }
            requestLayout();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f31698h && this.f31697g && this.mNeedRecomputeMatrix) {
            this.mDrawer.c(this.f31701k, this, this.f31696f);
            this.mNeedRecomputeMatrix = false;
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (!this.f31701k.c()) {
                if (this.mArgs.o) {
                    this.mDrawer.q();
                    this.mDrawer.a(this.f31701k, this);
                    this.mDrawer.f(canvas, this);
                    return;
                }
                return;
            }
            b();
            this.mDrawer.g(canvas, this.f31701k, this);
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
            this.f31697g = true;
        } else {
            this.f31697g = false;
        }
        this.mNeedRecomputeMatrix = true;
    }

    public abstract c.a.d.m.d.a getBdImage();

    public abstract c.a.d.m.d.a getDefaultBdImage();

    public boolean getDrawBorder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mArgs.f31703c : invokeV.booleanValue;
    }

    public int getImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            getDisplayBdImage();
            int a = this.f31701k.a();
            this.f31701k.f();
            return a;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!this.f31697g) {
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
            int b2 = this.f31701k.b();
            this.f31701k.f();
            return b2;
        }
        return invokeV.intValue;
    }

    public void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, attributeSet) == null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
                this.mArgs.a = parseCornerRadii(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, l.d(getContext(), 4.0f)));
                this.mArgs.f31702b = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
                this.mArgs.f31703c = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
                this.mArgs.f31704d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, l.d(getContext(), 1.0f));
                this.mArgs.f31705e = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, DEFAULT_BORDER_COLOR);
                this.mArgs.f31707g = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
                this.mArgs.f31709i = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
                this.mArgs.m = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
                this.mDrawerType = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
                this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, Integer.MAX_VALUE);
                this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, Integer.MAX_VALUE);
                this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
                obtainStyledAttributes.recycle();
            } else {
                this.mArgs.a = parseCornerRadii(l.d(getContext(), 4.0f));
                this.mArgs.f31704d = l.d(getContext(), 1.0f);
                this.mArgs.f31705e = DEFAULT_BORDER_COLOR;
            }
            a a = e.b().a(this.mDrawerType);
            this.mDrawer = a;
            a.p(this.mArgs);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, canvas) == null) {
            if (!this.f31697g) {
                super.onDraw(canvas);
                drawContentTag(canvas, this);
                return;
            }
            getDisplayBdImage();
            this.mDrawer.d(canvas, this, this.n);
            c(canvas);
            drawContentTag(canvas, this);
            this.mDrawer.i(canvas, this);
            this.f31701k.f();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            this.f31699i = View.MeasureSpec.getMode(i2);
            this.f31700j = View.MeasureSpec.getMode(i3);
            View.MeasureSpec.getSize(i2);
            View.MeasureSpec.getSize(i3);
            getDisplayBdImage();
            int b2 = this.f31701k.b();
            int a = this.f31701k.a();
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int max = Math.max(b2 + paddingLeft, getSuggestedMinimumWidth());
            int max2 = Math.max(a + paddingTop, getSuggestedMinimumHeight());
            if (max <= paddingLeft || max2 <= paddingTop || this.f31701k.f2758c || !this.mAdjustViewBounds) {
                max = f(max, this.mMaxWidth, i2);
                max2 = f(max2, this.mMaxHeight, i3);
            }
            this.f31701k.f();
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048591, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.mNeedRecomputeMatrix = true;
        }
    }

    @Override // c.a.d.g.a.h
    public abstract /* synthetic */ void refresh();

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || z == this.mAdjustViewBounds) {
            return;
        }
        this.mAdjustViewBounds = z;
        requestLayout();
    }

    public void setAlphaValue(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048594, this, f2) == null) || Math.abs(this.mArgs.f31711k - f2) <= 1.0E-4f) {
            return;
        }
        this.mArgs.f31711k = f2;
        invalidate();
    }

    public void setBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, drawable) == null) {
            this.m = drawable;
        }
    }

    public void setBorderColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.f31705e != i2) {
                drawerArgs.f31705e = i2;
                invalidate();
            }
        }
    }

    public void setBorderSurroundContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.f31707g != z) {
                drawerArgs.f31707g = z;
                this.mNeedRecomputeMatrix = true;
                invalidate();
            }
        }
    }

    public void setBorderWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.f31704d != i2) {
                drawerArgs.f31704d = i2;
                invalidate();
            }
        }
    }

    public void setDefaultBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, drawable) == null) {
            this.l = drawable;
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, scaleType) == null) || this.f31695e == scaleType) {
            return;
        }
        this.f31695e = scaleType;
        this.mNeedRecomputeMatrix = true;
        invalidate();
    }

    public void setDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.f31703c != z) {
                drawerArgs.f31703c = z;
                this.mNeedRecomputeMatrix = true;
                invalidate();
            }
        }
    }

    public void setDrawerType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || this.mDrawerType == i2) {
            return;
        }
        this.mDrawerType = i2;
        a a = e.b().a(this.mDrawerType);
        this.mDrawer = a;
        a.p(this.mArgs);
        this.mNeedRecomputeMatrix = true;
        invalidate();
    }

    public void setExtraMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, matrix) == null) {
            this.mArgs.l = matrix;
            invalidate();
        }
    }

    public void setForegroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.m != i2) {
                drawerArgs.m = i2;
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048605, this, i2, i3, i4, i5)) == null) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            this.f31698h = true;
            return frame;
        }
        return invokeIIII.booleanValue;
    }

    public void setGifIconSupport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.f31709i != z) {
                drawerArgs.f31709i = z;
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, drawable) == null) {
            super.setImageDrawable(drawable);
            g();
        }
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, matrix) == null) {
            if (!this.f31697g) {
                super.setImageMatrix(matrix);
            } else if (matrix == null || this.f31696f != ImageView.ScaleType.MATRIX) {
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
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            super.setImageResource(i2);
            g();
        }
    }

    public void setIsPreDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.o != z) {
                drawerArgs.o = z;
                invalidate();
            }
        }
    }

    public void setIsRound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.f31702b != z) {
                drawerArgs.f31702b = z;
                invalidate();
            }
        }
    }

    public void setLongIconSupport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.f31708h != z) {
                drawerArgs.f31708h = z;
                invalidate();
            }
        }
    }

    public void setRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            float[] parseCornerRadii = parseCornerRadii(i2);
            if (Arrays.equals(this.mArgs.a, parseCornerRadii)) {
                return;
            }
            this.mArgs.a = parseCornerRadii;
            invalidate();
        }
    }

    public void setRadiusById(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            float[] e2 = e(i2);
            if (Arrays.equals(this.mArgs.a, e2)) {
                return;
            }
            this.mArgs.a = e2;
            invalidate();
        }
    }

    public void setSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            DrawerArgs.SkinType skinType = drawerArgs.f31706f;
            if (i2 == 1) {
                drawerArgs.f31706f = DrawerArgs.SkinType.NIGHT;
            } else if (i2 != 4) {
                drawerArgs.f31706f = DrawerArgs.SkinType.DAY;
            } else {
                drawerArgs.f31706f = DrawerArgs.SkinType.DARK;
            }
            if (skinType != this.mArgs.f31706f) {
                invalidate();
            }
        }
    }

    public void setTLIconType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.f31710j != i2) {
                drawerArgs.f31710j = i2;
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
        this.f31695e = ImageView.ScaleType.CENTER_INSIDE;
        this.f31696f = null;
        this.mArgs = new DrawerArgs();
        this.f31697g = true;
        this.mNeedRecomputeMatrix = true;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.f31701k = new d();
        init(attributeSet);
    }
}
