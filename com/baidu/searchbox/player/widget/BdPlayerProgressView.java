package com.baidu.searchbox.player.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.videoplayer.framework.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class BdPlayerProgressView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CENTER = 0;
    public static final int DEFAULT_GRAVITY = 1;
    public static final String DEFAULT_PROGRESS_TIME_TEXT = "00:00:00";
    public static final float DEFAULT_TEXT_SIZE = 15.0f;
    public static final String DEFAULT_TIME_TEXT = "00:00";
    public static final int LEFT = 1;
    public static final int PROGRESS_MODE = 1;
    public static final int RIGHT = 2;
    public static final String TAG = "BdPlayerProgressView";
    public static final int TIME_MODE = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int DEFAULT_HEIGHT;
    public int DEFAULT_WIDTH;
    public final int mGravity;
    public final Paint mPaint;
    public String mPositionText;
    public final int mProgressMode;
    public int mTextColor;
    public float mTextSize;
    public String mTimeText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdPlayerProgressView(Context context) {
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

    private int calculateLeftOffest(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, this, i2, i3)) == null) {
            int i4 = this.mGravity;
            if (i4 != 0) {
                if (i4 == 1 || i4 != 2) {
                    return 0;
                }
                return getMeasuredWidth() - i3;
            }
            return (getMeasuredWidth() - i3) / 2;
        }
        return invokeII.intValue;
    }

    private void drawProgressText(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, canvas) == null) {
            Paint.FontMetricsInt fontMetricsInt = this.mPaint.getFontMetricsInt();
            int i2 = fontMetricsInt.top;
            int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i2) / 2) - i2;
            canvas.drawText(this.mPositionText, calculateLeftOffest(this.mGravity, (int) this.mPaint.measureText(this.mPositionText)), measuredHeight, this.mPaint);
        }
    }

    private void drawTimeText(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, canvas) == null) {
            Paint.FontMetricsInt fontMetricsInt = this.mPaint.getFontMetricsInt();
            int i2 = fontMetricsInt.top;
            int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i2) / 2) - i2;
            canvas.drawText(this.mTimeText, calculateLeftOffest(this.mGravity, (int) this.mPaint.measureText(this.mTimeText)), measuredHeight, this.mPaint);
        }
    }

    private int setMeasuredHeight(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i2)) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824) {
                return this.DEFAULT_HEIGHT;
            }
            if (mode == Integer.MIN_VALUE) {
                return Math.min(this.DEFAULT_HEIGHT, size);
            }
            return this.DEFAULT_HEIGHT;
        }
        return invokeI.intValue;
    }

    private int setMeasuredWidth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) {
            int measureText = (int) this.mPaint.measureText(this.mProgressMode == 1 ? DEFAULT_PROGRESS_TIME_TEXT : DEFAULT_TIME_TEXT);
            int mode = View.MeasureSpec.getMode(i2);
            return mode == 1073741824 ? View.MeasureSpec.getSize(i2) : mode == Integer.MIN_VALUE ? measureText : this.DEFAULT_WIDTH;
        }
        return invokeI.intValue;
    }

    public String getPositionText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPositionText : (String) invokeV.objValue;
    }

    public int getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTextColor : invokeV.intValue;
    }

    public float getTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mTextSize : invokeV.floatValue;
    }

    public String getTimeText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTimeText : (String) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            int i2 = this.mProgressMode;
            if (i2 == 1) {
                drawProgressText(canvas);
            } else if (i2 == 2) {
                drawTimeText(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            setMeasuredDimension(setMeasuredWidth(i2), setMeasuredHeight(i3));
        }
    }

    public void setPositionText(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && this.mProgressMode == 1) {
            this.mPositionText = str;
            postInvalidate();
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mTextColor = i2;
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.mTextSize = f2;
            this.mPaint.setTextSize(f2);
            invalidate();
        }
    }

    public void setTimeText(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && this.mProgressMode == 2) {
            this.mTimeText = str;
            postInvalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdPlayerProgressView(Context context, AttributeSet attributeSet) {
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
    @SuppressLint({"CustomViewStyleable"})
    public BdPlayerProgressView(Context context, AttributeSet attributeSet, int i2) {
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
        this.mPositionText = DEFAULT_PROGRESS_TIME_TEXT;
        this.DEFAULT_WIDTH = 0;
        this.DEFAULT_HEIGHT = 0;
        this.DEFAULT_WIDTH = BdPlayerUtils.dp2px(this, 120.0f);
        this.DEFAULT_HEIGHT = BdPlayerUtils.dp2px(this, 15.0f);
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.bdvideoplayer_bdPlayerProgressView);
            this.mTextSize = typedArray.getDimension(R.styleable.bdvideoplayer_bdPlayerProgressView_bdvideoplayer_progressTextSize, 15.0f);
            this.mTextColor = typedArray.getColor(R.styleable.bdvideoplayer_bdPlayerProgressView_bdvideoplayer_progressTextColor, -1);
            this.mGravity = typedArray.getInt(R.styleable.bdvideoplayer_bdPlayerProgressView_bdvideoplayer_progressGravity, 1);
            this.mProgressMode = typedArray.getInt(R.styleable.bdvideoplayer_bdPlayerProgressView_bdvideoplayer_progressTextMode, 1);
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(this.mTextColor);
            this.mPaint.setTextSize(this.mTextSize);
            if (this.mProgressMode == 2) {
                this.mPaint.setFakeBoldText(true);
            }
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }
}
