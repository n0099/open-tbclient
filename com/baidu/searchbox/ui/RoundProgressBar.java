package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
/* loaded from: classes7.dex */
public class RoundProgressBar extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILL = 1;
    public static final int MAX = 100;
    public static final float MAX_ANGLE = 360.0f;
    public static final int MAX_PROGRESS_DEFAULT_VALUE = 100;
    public static final int ROUND_WIDTH_DEFAULT_VALUE = 5;
    public static final float START_ANGLE = 270.0f;
    public static final int STROKE = 0;
    public static final int TEXT_SIZE_DEFAULT_VALUE = 15;
    public transient /* synthetic */ FieldHolder $fh;
    public int mMax;
    public RectF mOval;
    public Paint mPaint;
    public boolean mPaintCapRound;
    public int mProgress;
    public boolean mReverse;
    public int mRoundColor;
    public int mRoundProgressColor;
    public float mRoundWidth;
    public int mStyle;
    public int mTextColor;
    public boolean mTextIsDisplayable;
    public float mTextSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundProgressBar(Context context) {
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

    public int getCircleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRoundColor : invokeV.intValue;
    }

    public int getCircleProgressColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRoundProgressColor : invokeV.intValue;
    }

    public synchronized int getMax() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                i2 = this.mMax;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized int getProgress() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                i2 = this.mProgress;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public float getRoundWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRoundWidth : invokeV.floatValue;
    }

    public int getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTextColor : invokeV.intValue;
    }

    public float getTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mTextSize : invokeV.floatValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            int width = getWidth() / 2;
            float f2 = width;
            int i2 = (int) (f2 - (this.mRoundWidth / 2.0f));
            this.mPaint.setColor(this.mRoundColor);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mRoundWidth);
            this.mPaint.setAntiAlias(true);
            if (this.mPaintCapRound) {
                this.mPaint.setStrokeCap(Paint.Cap.ROUND);
            }
            canvas.drawCircle(f2, f2, i2, this.mPaint);
            this.mPaint.setStrokeWidth(0.0f);
            this.mPaint.setColor(this.mTextColor);
            this.mPaint.setTextSize(this.mTextSize);
            this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
            int max = (int) ((this.mProgress / getMax()) * 100.0f);
            float measureText = this.mPaint.measureText(max + "%");
            if (this.mTextIsDisplayable && max >= 0 && this.mStyle == 0) {
                canvas.drawText(max + "%", f2 - (measureText / 2.0f), f2 + (this.mTextSize / 2.0f), this.mPaint);
            }
            this.mPaint.setStrokeWidth(this.mRoundWidth);
            this.mPaint.setColor(this.mRoundProgressColor);
            float f3 = width - i2;
            float f4 = width + i2;
            this.mOval.set(f3, f3, f4, f4);
            int i3 = this.mStyle;
            if (i3 == 0) {
                this.mPaint.setStyle(Paint.Style.STROKE);
                if (this.mReverse) {
                    canvas.drawArc(this.mOval, 270.0f, (this.mProgress * (-360.0f)) / getMax(), false, this.mPaint);
                } else {
                    canvas.drawArc(this.mOval, 270.0f, (this.mProgress * 360.0f) / getMax(), false, this.mPaint);
                }
            } else if (i3 != 1) {
            } else {
                this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                int i4 = this.mProgress;
                if (i4 != 0) {
                    canvas.drawArc(this.mOval, 0.0f, (i4 * 360.0f) / getMax(), true, this.mPaint);
                }
            }
        }
    }

    public void setCircleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mRoundColor = i2;
            postInvalidate();
        }
    }

    public void setCircleProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mRoundProgressColor = i2;
            postInvalidate();
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public synchronized void setMax(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            synchronized (this) {
                if (i2 >= 0) {
                    this.mMax = i2;
                } else {
                    throw new IllegalArgumentException("max not less than 0");
                }
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public synchronized void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            synchronized (this) {
                if (i2 >= 0) {
                    if (i2 > this.mMax) {
                        i2 = this.mMax;
                    }
                    this.mProgress = i2;
                    postInvalidate();
                } else {
                    throw new IllegalArgumentException("progress not less than 0");
                }
            }
        }
    }

    public void setRoundWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f2) == null) {
            this.mRoundWidth = f2;
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mTextColor = i2;
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            this.mTextSize = f2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundProgressBar(Context context, AttributeSet attributeSet) {
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
    public RoundProgressBar(Context context, AttributeSet attributeSet, int i2) {
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
        this.mPaint = new Paint();
        this.mOval = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.loading.R.styleable.RoundProgressBar);
        this.mRoundColor = obtainStyledAttributes.getColor(com.baidu.android.common.loading.R.styleable.RoundProgressBar_roundColor, -65536);
        this.mRoundProgressColor = obtainStyledAttributes.getColor(com.baidu.android.common.loading.R.styleable.RoundProgressBar_roundProgressColor, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
        this.mTextColor = obtainStyledAttributes.getColor(com.baidu.android.common.loading.R.styleable.RoundProgressBar_textColor, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
        this.mTextSize = obtainStyledAttributes.getDimension(com.baidu.android.common.loading.R.styleable.RoundProgressBar_textSize, 15.0f);
        this.mRoundWidth = obtainStyledAttributes.getDimension(com.baidu.android.common.loading.R.styleable.RoundProgressBar_roundWidth, 5.0f);
        this.mMax = obtainStyledAttributes.getInteger(com.baidu.android.common.loading.R.styleable.RoundProgressBar_max, 100);
        this.mTextIsDisplayable = obtainStyledAttributes.getBoolean(com.baidu.android.common.loading.R.styleable.RoundProgressBar_textIsDisplayable, true);
        this.mStyle = obtainStyledAttributes.getInt(com.baidu.android.common.loading.R.styleable.RoundProgressBar_style, 0);
        this.mReverse = obtainStyledAttributes.getBoolean(com.baidu.android.common.loading.R.styleable.RoundProgressBar_reverse, false);
        this.mPaintCapRound = obtainStyledAttributes.getBoolean(com.baidu.android.common.loading.R.styleable.RoundProgressBar_roundPaintCapRound, false);
        obtainStyledAttributes.recycle();
    }
}
