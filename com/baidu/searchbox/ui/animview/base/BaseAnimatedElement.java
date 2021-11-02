package com.baidu.searchbox.ui.animview.base;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class BaseAnimatedElement implements IAnimatedElement {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEBUG_PAINT_COLOR = -16776961;
    public static final int DEBUG_PAINT_STROKE_WIDTH = 10;
    public static final Matrix.ScaleToFit[] sS2FArray;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint mDebugPaint;
    public boolean mDrawDebugRect;
    public Matrix mDrawMatrix;
    public Drawable.Callback mDrawableCallback;
    public int mHeight;
    public Interpolator mInterpolator;
    public int mLeft;
    public int mPivotX;
    public int mPivotY;
    public IResourceProvider mResourceProvider;
    public float mRotateAngle;
    public ScaleType mScaleType;
    public int mTop;
    public boolean mVisibility;
    public int mWidth;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class ScaleType {
        public static final /* synthetic */ ScaleType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ScaleType FIT_CENTER;
        public static final ScaleType FIT_END;
        public static final ScaleType FIT_START;
        public static final ScaleType FIT_XY;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeInt;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1756000697, "Lcom/baidu/searchbox/ui/animview/base/BaseAnimatedElement$ScaleType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1756000697, "Lcom/baidu/searchbox/ui/animview/base/BaseAnimatedElement$ScaleType;");
                    return;
                }
            }
            FIT_XY = new ScaleType("FIT_XY", 0, 1);
            FIT_START = new ScaleType("FIT_START", 1, 2);
            FIT_CENTER = new ScaleType("FIT_CENTER", 2, 3);
            ScaleType scaleType = new ScaleType("FIT_END", 3, 4);
            FIT_END = scaleType;
            $VALUES = new ScaleType[]{FIT_XY, FIT_START, FIT_CENTER, scaleType};
        }

        public ScaleType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.nativeInt = i3;
        }

        public static ScaleType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ScaleType) Enum.valueOf(ScaleType.class, str) : (ScaleType) invokeL.objValue;
        }

        public static ScaleType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ScaleType[]) $VALUES.clone() : (ScaleType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(222384921, "Lcom/baidu/searchbox/ui/animview/base/BaseAnimatedElement;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(222384921, "Lcom/baidu/searchbox/ui/animview/base/BaseAnimatedElement;");
                return;
            }
        }
        sS2FArray = new Matrix.ScaleToFit[]{Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    }

    public BaseAnimatedElement(Drawable.Callback callback, ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback, scaleType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDrawDebugRect = false;
        this.mVisibility = true;
        this.mRotateAngle = 0.0f;
        this.mDrawableCallback = callback;
        this.mScaleType = scaleType;
        setDrawableCallback(callback);
    }

    private void configureBounds(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, drawable) == null) {
            if (drawable != null && this.mScaleType != null) {
                int width = drawable.getBounds().width();
                int height = drawable.getBounds().height();
                int i2 = this.mWidth;
                int i3 = this.mHeight;
                boolean z = (width < 0 || i2 == width) && (height < 0 || i3 == height);
                if (width <= 0 || height <= 0) {
                    drawable.setBounds(0, 0, i2, i3);
                    this.mDrawMatrix = null;
                    return;
                } else if (z) {
                    this.mDrawMatrix = null;
                    return;
                } else {
                    this.mDrawMatrix = new Matrix();
                    RectF rectF = new RectF();
                    RectF rectF2 = new RectF();
                    rectF.set(0.0f, 0.0f, width, height);
                    rectF2.set(0.0f, 0.0f, i2, i3);
                    this.mDrawMatrix.setRectToRect(rectF, rectF2, scaleTypeToScaleToFit(this.mScaleType));
                    return;
                }
            }
            this.mDrawMatrix = null;
        }
    }

    private void initDebugPaint() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.mDebugPaint == null) {
            Paint paint = new Paint();
            this.mDebugPaint = paint;
            paint.setAntiAlias(true);
            this.mDebugPaint.setStyle(Paint.Style.STROKE);
            this.mDebugPaint.setStrokeWidth(10.0f);
            this.mDebugPaint.setColor(DEBUG_PAINT_COLOR);
        }
    }

    public static Matrix.ScaleToFit scaleTypeToScaleToFit(ScaleType scaleType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, scaleType)) == null) ? sS2FArray[scaleType.nativeInt - 1] : (Matrix.ScaleToFit) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public BaseAnimatedElement cloneInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (BaseAnimatedElement) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void copyAttribute(BaseAnimatedElement baseAnimatedElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseAnimatedElement) == null) {
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void dispatchAnimate(Canvas canvas, float f2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, Float.valueOf(f2), Long.valueOf(j)}) == null) {
            if (this.mDrawDebugRect) {
                canvas.save();
                canvas.translate(this.mLeft, this.mTop);
                canvas.rotate(this.mRotateAngle, this.mPivotX, this.mPivotY);
                canvas.drawRect(0.0f, 0.0f, this.mWidth, this.mHeight, this.mDebugPaint);
                canvas.restore();
            }
            canvas.save();
            canvas.translate(this.mLeft, this.mTop);
            canvas.rotate(this.mRotateAngle, this.mPivotX, this.mPivotY);
            if (this.mVisibility) {
                performCanvasDrawMatrix(canvas);
                if (this.mInterpolator == null) {
                    this.mInterpolator = new LinearInterpolator();
                }
                onDispatchAnimate(canvas, this.mInterpolator.getInterpolation(f2), j);
            }
            canvas.restore();
        }
    }

    public void enableDrawDebugBound(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.mDrawDebugRect = z;
            if (z) {
                initDebugPaint();
                this.mDebugPaint.setColor(i2);
            }
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mHeight : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public final int getLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLeft : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public final int getTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mTop : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mWidth : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public final void init(int i2, int i3, int i4, int i5, IResourceProvider iResourceProvider, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iResourceProvider, objArr}) == null) {
            this.mLeft = i2;
            this.mTop = i3;
            this.mWidth = i4;
            this.mHeight = i5;
            this.mResourceProvider = iResourceProvider;
            this.mDrawMatrix = null;
            onInit(objArr);
        }
    }

    public abstract void onDispatchAnimate(Canvas canvas, float f2, long j);

    public void onInit(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, objArr) == null) {
        }
    }

    public void performCanvasDrawMatrix(Canvas canvas) {
        Matrix matrix;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) || canvas == null || (matrix = this.mDrawMatrix) == null) {
            return;
        }
        canvas.concat(matrix);
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void setDrawableCallback(Drawable.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, callback) == null) {
            this.mDrawableCallback = callback;
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void setInterpolator(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, interpolator) == null) {
            this.mInterpolator = interpolator;
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void setRotate(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.mRotateAngle = f2;
            this.mPivotX = (int) (f3 * this.mWidth);
            this.mPivotY = (int) (f4 * this.mHeight);
        }
    }

    public void setScaleType(ScaleType scaleType, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, scaleType, drawable) == null) {
            this.mScaleType = scaleType;
            configureBounds(drawable);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void setVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mVisibility = z;
        }
    }

    public void setScaleType(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, drawable) == null) {
            setScaleType(this.mScaleType, drawable);
        }
    }
}
