package com.baidu.searchbox.ui.bubble;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ArrowView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALPHA = 204;
    public static final float ARC_SIZE = 2.0f;
    public static final int DOWN = 4;
    public static final int LEFT = 1;
    public static final int RIGHT = 3;
    public static final int UP = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public Path mArrowPath;
    public int mColor;
    public Paint mColorPaint;
    public boolean mD20Template;
    public int mDirection;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ArrowView(Context context) {
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

    private Path getArrowPath(Path path, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, path, i2)) == null) {
            if (path == null) {
                return new Path();
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            path.reset();
            if (i2 == 1) {
                float f2 = paddingTop;
                path.moveTo(paddingLeft, (((measuredHeight - paddingTop) - paddingBottom) / 2.0f) + f2);
                float f3 = measuredWidth - paddingRight;
                path.lineTo(f3, f2);
                path.lineTo(f3, measuredHeight - paddingBottom);
                path.close();
            } else if (i2 == 2) {
                float f4 = paddingLeft;
                float f5 = measuredHeight - paddingBottom;
                path.moveTo(f4, f5);
                path.lineTo(measuredWidth - paddingRight, f5);
                path.lineTo((((measuredWidth - paddingLeft) - paddingRight) / 2.0f) + f4, paddingTop);
                path.close();
            } else if (i2 == 3) {
                float f6 = paddingLeft;
                float f7 = paddingTop;
                path.moveTo(f6, f7);
                path.lineTo(measuredWidth - paddingRight, ((i3 - paddingTop) / 2.0f) + f7);
                path.lineTo(f6, measuredHeight - paddingBottom);
                path.close();
            } else if (i2 == 4) {
                float f8 = paddingLeft;
                float f9 = paddingTop;
                path.moveTo(f8, f9);
                path.lineTo(measuredWidth - paddingRight, f9);
                path.lineTo((((measuredWidth - paddingLeft) - paddingRight) / 2.0f) + f8, measuredHeight - paddingBottom);
                path.close();
            }
            return path;
        }
        return (Path) invokeLI.objValue;
    }

    private Path getNewArrowPath(Path path, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, path, i2)) == null) {
            if (path == null) {
                return new Path();
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f2 = ((measuredWidth - paddingLeft) - paddingRight) / 2.0f;
            float f3 = ((measuredHeight - paddingTop) - paddingBottom) / 2.0f;
            float dpToPixel = dpToPixel(2.0f);
            path.reset();
            if (i2 == 1) {
                float f4 = paddingLeft + dpToPixel;
                float f5 = paddingTop;
                float f6 = f3 + f5;
                path.moveTo(f4, f6 - dpToPixel);
                float f7 = measuredWidth - paddingRight;
                path.lineTo(f7, f5);
                path.lineTo(f7, measuredHeight - paddingBottom);
                path.lineTo(f4, f6 + dpToPixel);
                path.close();
                path.addCircle(f4 + (dpToPixel / 2.0f), f6, dpToPixel, Path.Direction.CW);
            } else if (i2 == 2) {
                float f8 = paddingLeft;
                float f9 = measuredHeight - paddingBottom;
                path.moveTo(f8, f9);
                path.lineTo(measuredWidth - paddingRight, f9);
                float f10 = f2 + f8;
                float f11 = paddingTop + dpToPixel;
                path.lineTo(f10 + dpToPixel, f11);
                path.lineTo(f10 - dpToPixel, f11);
                path.close();
                path.addCircle(f10, f11 + (dpToPixel / 2.0f), dpToPixel, Path.Direction.CCW);
            } else if (i2 == 3) {
                float f12 = paddingLeft;
                float f13 = paddingTop;
                path.moveTo(f12, f13);
                float f14 = (measuredWidth - paddingRight) - dpToPixel;
                float f15 = f3 + f13;
                path.lineTo(f14, f15 - dpToPixel);
                path.lineTo(f14, f15 + dpToPixel);
                path.lineTo(f12, measuredHeight - paddingBottom);
                path.close();
                path.addCircle(f14 - (dpToPixel / 2.0f), f15, dpToPixel, Path.Direction.CW);
            } else if (i2 == 4) {
                float f16 = paddingLeft;
                float f17 = paddingTop;
                path.moveTo(f16, f17);
                path.lineTo(measuredWidth - paddingRight, f17);
                float f18 = f2 + f16;
                float f19 = (measuredHeight - paddingBottom) - dpToPixel;
                path.lineTo(f18 + dpToPixel, f19);
                path.lineTo(f18 - dpToPixel, f19);
                path.close();
                path.addCircle(f18, f19 - (dpToPixel / 2.0f), dpToPixel, Path.Direction.CW);
            }
            return path;
        }
        return (Path) invokeLI.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.mColor = AppRuntime.getAppContext().getResources().getColor(R.color.UC29);
            this.mArrowPath = new Path();
            Paint paint = new Paint();
            this.mColorPaint = paint;
            paint.setAntiAlias(true);
            this.mColorPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.mColorPaint.setColor(this.mColor);
        }
    }

    public float dpToPixel(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? getResources().getDisplayMetrics().density * f2 : invokeF.floatValue;
    }

    public void enableNewTemplate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.mD20Template = z;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.mD20Template) {
                this.mArrowPath = getNewArrowPath(this.mArrowPath, this.mDirection);
            } else {
                this.mArrowPath = getArrowPath(this.mArrowPath, this.mDirection);
            }
            canvas.drawPath(this.mArrowPath, this.mColorPaint);
        }
    }

    public void setArrowViewColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.mColor = i2;
            this.mColorPaint.setColor(i2);
            invalidate();
        }
    }

    public void setDirection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mDirection = i2;
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ArrowView(Context context, @Nullable AttributeSet attributeSet) {
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
    public ArrowView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.mDirection = 4;
        this.mColor = Color.argb(204, 0, 0, 0);
        this.mD20Template = true;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public ArrowView(Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mDirection = 4;
        this.mColor = Color.argb(204, 0, 0, 0);
        this.mD20Template = true;
        init();
    }
}
