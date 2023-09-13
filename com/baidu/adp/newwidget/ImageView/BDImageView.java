package com.baidu.adp.newwidget.ImageView;

import android.annotation.SuppressLint;
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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.ek;
import com.baidu.tieba.hk;
import com.baidu.tieba.ik;
import com.baidu.tieba.lk;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public abstract class BDImageView extends ImageView implements ViewTreeObserver.OnPreDrawListener, lk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BORDER_COLOR = 201326592;
    public static final int DEFAULT_BORDER_WIDTH = 1;
    public static final int DEFAULT_RADIUS = 4;
    public static final int SKIN_TYPE_DARK = 4;
    public static final int SKIN_TYPE_NIGHT = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAdjustViewBounds;
    public DrawerArgs mArgs;
    public Drawable mBg;
    public Drawable mCurBg;
    public ImageView.ScaleType mCurrentScaleType;
    public Drawable mDefaultBg;
    public ImageView.ScaleType mDefaultScaleType;
    public ek mDrawer;
    public int mDrawerType;
    public int mHeightMeasureMode;
    public hk mImage;
    public boolean mIsBitmap;
    public boolean mIsHasFrame;
    public int mMaxHeight;
    public int mMaxWidth;
    public boolean mNeedRecomputeMatrix;
    public int mWidthMeasureMode;

    public void drawContentTag(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, imageView) == null) {
        }
    }

    public abstract BdImage getBdImage();

    public abstract BdImage getDefaultBdImage();

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
        this.mDrawerType = 0;
        this.mDefaultScaleType = ImageView.ScaleType.CENTER_INSIDE;
        this.mCurrentScaleType = null;
        this.mArgs = new DrawerArgs();
        this.mIsBitmap = true;
        this.mNeedRecomputeMatrix = true;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mImage = new hk();
        init(null);
    }

    public static float getRoundDimenByName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (app == null) {
                return 0.0f;
            }
            if (str.endsWith(IEruptionStrategyGroup.STRATEGY_MODIFIER_H)) {
                return Float.parseFloat(str.substring(0, str.length() - 1));
            }
            Resources resources = app.getResources();
            Resources resources2 = app.getResources();
            return resources.getDimensionPixelSize(resources2.getIdentifier("tbds" + str, EMABTest.TYPE_DIMEN, app.getPackageName()));
        }
        return invokeL.floatValue;
    }

    public static float[] getRoundDimensById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (app == null) {
                return parseCornerRadii(0.0f);
            }
            String[] split = app.getString(i).split(",");
            int min = Math.min(split.length, 4);
            float[] fArr = new float[8];
            for (int i2 = 0; i2 < min; i2++) {
                float roundDimenByName = getRoundDimenByName(split[i2]);
                int i3 = i2 * 2;
                fArr[i3] = roundDimenByName;
                fArr[i3 + 1] = roundDimenByName;
            }
            return fArr;
        }
        return (float[]) invokeI.objValue;
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
        this.mDrawerType = 0;
        this.mDefaultScaleType = ImageView.ScaleType.CENTER_INSIDE;
        this.mCurrentScaleType = null;
        this.mArgs = new DrawerArgs();
        this.mIsBitmap = true;
        this.mNeedRecomputeMatrix = true;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mImage = new hk();
        init(attributeSet);
    }

    private void checkReLayout() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.mImage.c) {
            this.mNeedRecomputeMatrix = true;
            if (this.mAdjustViewBounds || this.mWidthMeasureMode != 1073741824 || this.mHeightMeasureMode != 1073741824) {
                requestLayout();
            }
        }
    }

    private void computeBounds() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.mIsHasFrame && this.mIsBitmap && this.mNeedRecomputeMatrix) {
            this.mDrawer.c(this.mImage, this, this.mCurrentScaleType);
            this.mNeedRecomputeMatrix = false;
        }
    }

    private void updateFlag() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65547, this) != null) || (drawable = getDrawable()) == null) {
            return;
        }
        if (drawable instanceof BitmapDrawable) {
            this.mIsBitmap = true;
        } else {
            this.mIsBitmap = false;
        }
        this.mNeedRecomputeMatrix = true;
    }

    public boolean getDrawBorder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mArgs.c;
        }
        return invokeV.booleanValue;
    }

    public int getImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            getDisplayBdImage();
            int a = this.mImage.a();
            this.mImage.f();
            return a;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.mIsBitmap) {
                return super.getImageMatrix();
            }
            return this.mDrawer.k();
        }
        return (Matrix) invokeV.objValue;
    }

    public int getImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            getDisplayBdImage();
            int b = this.mImage.b();
            this.mImage.f();
            return b;
        }
        return invokeV.intValue;
    }

    private void drawContent(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, canvas) == null) {
            if (!this.mImage.c()) {
                if (this.mArgs.o) {
                    this.mDrawer.s();
                    this.mDrawer.a(this.mImage, this);
                    this.mDrawer.f(canvas, this);
                    return;
                }
                return;
            }
            computeBounds();
            this.mDrawer.g(canvas, this.mImage, this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            if (!this.mIsBitmap) {
                super.onDraw(canvas);
                drawContentTag(canvas, this);
                return;
            }
            getDisplayBdImage();
            this.mDrawer.d(canvas, this, this.mCurBg);
            drawContent(canvas);
            drawContentTag(canvas, this);
            this.mDrawer.i(canvas, this);
            this.mImage.f();
        }
    }

    private void getDisplayBdImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            ImageView.ScaleType scaleType = getScaleType();
            if (getDrawable() instanceof BitmapDrawable) {
                this.mImage.a = (BitmapDrawable) getDrawable();
            }
            this.mImage.b = getBdImage();
            if (this.mImage.e()) {
                this.mImage.b = null;
                checkReLayout();
                this.mImage.c = false;
                this.mCurBg = this.mBg;
            } else if (this.mImage.d()) {
                this.mImage.a = null;
                checkReLayout();
                this.mImage.c = false;
                this.mCurBg = this.mBg;
            } else {
                hk hkVar = this.mImage;
                hkVar.a = null;
                hkVar.b = getDefaultBdImage();
                this.mImage.c = true;
                if (this.mImage.d()) {
                    scaleType = this.mDefaultScaleType;
                }
                this.mCurBg = this.mDefaultBg;
            }
            if (this.mCurrentScaleType != scaleType) {
                this.mCurrentScaleType = scaleType;
                this.mNeedRecomputeMatrix = true;
            }
        }
    }

    public static float[] parseCornerRadii(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65545, null, f)) == null) {
            float[] fArr = new float[8];
            Arrays.fill(fArr, f);
            return fArr;
        }
        return (float[]) invokeF.objValue;
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && z != this.mAdjustViewBounds) {
            this.mAdjustViewBounds = z;
            requestLayout();
        }
    }

    public void setBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, drawable) == null) {
            this.mBg = drawable;
        }
    }

    public void setBorderColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.e != i) {
                drawerArgs.e = i;
                invalidate();
            }
        }
    }

    public void setBorderSurroundContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.g != z) {
                drawerArgs.g = z;
                this.mNeedRecomputeMatrix = true;
                invalidate();
            }
        }
    }

    public void setBorderWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.d != i) {
                drawerArgs.d = i;
                invalidate();
            }
        }
    }

    public void setDefaultBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, drawable) == null) {
            this.mDefaultBg = drawable;
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, scaleType) == null) && this.mDefaultScaleType != scaleType) {
            this.mDefaultScaleType = scaleType;
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.c != z) {
                drawerArgs.c = z;
                this.mNeedRecomputeMatrix = true;
                invalidate();
            }
        }
    }

    public void setDrawerType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i) == null) && this.mDrawerType != i) {
            this.mDrawerType = i;
            ek a = ik.b().a(this.mDrawerType);
            this.mDrawer = a;
            a.r(this.mArgs);
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, matrix) == null) {
            this.mArgs.l = matrix;
            invalidate();
        }
    }

    public void setForegroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.m != i) {
                drawerArgs.m = i;
                invalidate();
            }
        }
    }

    public void setGifIconSupport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.i != z) {
                drawerArgs.i = z;
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, drawable) == null) {
            super.setImageDrawable(drawable);
            updateFlag();
        }
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, matrix) == null) {
            if (!this.mIsBitmap) {
                super.setImageMatrix(matrix);
            } else if (matrix != null && this.mCurrentScaleType == ImageView.ScaleType.MATRIX) {
                this.mDrawer.o(matrix);
                this.mNeedRecomputeMatrix = true;
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            super.setImageResource(i);
            updateFlag();
        }
    }

    public void setIsPreDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.o != z) {
                drawerArgs.o = z;
                invalidate();
            }
        }
    }

    public void setIsRound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.b != z) {
                drawerArgs.b = z;
                invalidate();
            }
        }
    }

    public void setLongIconSupport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.h != z) {
                drawerArgs.h = z;
                invalidate();
            }
        }
    }

    public void setRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            float[] parseCornerRadii = parseCornerRadii(i);
            if (!Arrays.equals(this.mArgs.a, parseCornerRadii)) {
                this.mArgs.a = parseCornerRadii;
                invalidate();
            }
        }
    }

    public void setRadiusById(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            float[] roundDimensById = getRoundDimensById(i);
            if (!Arrays.equals(this.mArgs.a, roundDimensById)) {
                this.mArgs.a = roundDimensById;
                invalidate();
            }
        }
    }

    public void setSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            DrawerArgs.SkinType skinType = drawerArgs.f;
            if (i != 1) {
                if (i != 4) {
                    drawerArgs.f = DrawerArgs.SkinType.DAY;
                } else {
                    drawerArgs.f = DrawerArgs.SkinType.DARK;
                }
            } else {
                drawerArgs.f = DrawerArgs.SkinType.NIGHT;
            }
            if (skinType != this.mArgs.f) {
                invalidate();
            }
        }
    }

    public void setTLIconType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs.j != i) {
                drawerArgs.j = i;
                invalidate();
            }
        }
    }

    private int resolveAdjustedSize(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65546, this, i, i2, i3)) == null) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 0) {
                    if (mode == 1073741824) {
                        return size;
                    }
                    return i;
                }
                return Math.min(i, i2);
            }
            return Math.min(Math.min(i, size), i2);
        }
        return invokeIII.intValue;
    }

    public void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, attributeSet) == null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
                this.mArgs.a = parseCornerRadii(obtainStyledAttributes.getDimensionPixelSize(11, BdUtilHelper.dip2px(getContext(), 4.0f)));
                this.mArgs.b = obtainStyledAttributes.getBoolean(8, false);
                this.mArgs.c = obtainStyledAttributes.getBoolean(7, false);
                this.mArgs.d = obtainStyledAttributes.getDimensionPixelSize(3, BdUtilHelper.dip2px(getContext(), 1.0f));
                this.mArgs.e = obtainStyledAttributes.getColor(1, DEFAULT_BORDER_COLOR);
                this.mArgs.g = obtainStyledAttributes.getBoolean(2, false);
                this.mArgs.i = obtainStyledAttributes.getBoolean(16, true);
                this.mArgs.m = obtainStyledAttributes.getColor(5, 0);
                this.mDrawerType = obtainStyledAttributes.getInt(4, 0);
                this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
                this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
                this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(0, false);
                obtainStyledAttributes.recycle();
            } else {
                this.mArgs.a = parseCornerRadii(BdUtilHelper.dip2px(getContext(), 4.0f));
                this.mArgs.d = BdUtilHelper.dip2px(getContext(), 1.0f);
                this.mArgs.e = DEFAULT_BORDER_COLOR;
            }
            ek a = ik.b().a(this.mDrawerType);
            this.mDrawer = a;
            a.r(this.mArgs);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            this.mWidthMeasureMode = View.MeasureSpec.getMode(i);
            this.mHeightMeasureMode = View.MeasureSpec.getMode(i2);
            View.MeasureSpec.getSize(i);
            View.MeasureSpec.getSize(i2);
            getDisplayBdImage();
            int b = this.mImage.b();
            int a = this.mImage.a();
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int max = Math.max(b + paddingLeft, getSuggestedMinimumWidth());
            int max2 = Math.max(a + paddingTop, getSuggestedMinimumHeight());
            if (max <= paddingLeft || max2 <= paddingTop || this.mImage.c || !this.mAdjustViewBounds) {
                max = resolveAdjustedSize(max, this.mMaxWidth, i);
                max2 = resolveAdjustedSize(max2, this.mMaxHeight, i2);
            }
            this.mImage.f();
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048586, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.mNeedRecomputeMatrix = true;
        }
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048598, this, i, i2, i3, i4)) == null) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            this.mIsHasFrame = true;
            return frame;
        }
        return invokeIIII.booleanValue;
    }
}
