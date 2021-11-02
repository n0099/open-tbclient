package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SlidingTabIndicator extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DRAG_VISCOSITY_PARAM = 2.3f;
    public transient /* synthetic */ FieldHolder $fh;
    public int mIndicatorColor;
    public int mIndicatorHeight;
    public int mIndicatorLeft;
    public int mIndicatorPadding;
    public int mIndicatorRight;
    public final Paint mSelectedIndicatorPaint;
    public int mSelectedPosition;
    public float mSelectionOffset;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlidingTabIndicator(Context context) {
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

    private void setIndicatorPosition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, this, i2, i3) == null) {
            if (i2 == this.mIndicatorLeft && i3 == this.mIndicatorRight) {
                return;
            }
            this.mIndicatorLeft = i2;
            this.mIndicatorRight = i3;
            invalidate();
        }
    }

    private void updateIndicatorPosition() {
        int childCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (childCount = getChildCount()) <= 0) {
            return;
        }
        if (this.mSelectedPosition >= childCount) {
            this.mSelectedPosition = childCount - 1;
        }
        View childAt = getChildAt(this.mSelectedPosition);
        int left = childAt.getLeft() + this.mIndicatorPadding;
        int right = childAt.getRight() - this.mIndicatorPadding;
        if (this.mSelectionOffset > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
            View childAt2 = getChildAt(this.mSelectedPosition + 1);
            int left2 = childAt2.getLeft() + this.mIndicatorPadding;
            float right2 = (childAt2.getRight() - this.mIndicatorPadding) - right;
            left += (int) (((float) Math.pow(this.mSelectionOffset, 2.299999952316284d)) * (left2 - left));
            right += (int) (right2 * (1.0f - ((float) Math.pow(1.0f - this.mSelectionOffset, 2.299999952316284d))));
        }
        setIndicatorPosition(left, right);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.onDraw(canvas);
            this.mSelectedIndicatorPaint.setColor(this.mIndicatorColor);
            int i2 = this.mIndicatorLeft;
            if (i2 < 0 || this.mIndicatorRight <= i2) {
                return;
            }
            canvas.drawRect(i2, getHeight() - this.mIndicatorHeight, this.mIndicatorRight, getHeight(), this.mSelectedIndicatorPaint);
        }
    }

    public void setIndicatorColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.mIndicatorColor == i2) {
            return;
        }
        this.mIndicatorColor = i2;
        invalidate();
    }

    public void setIndicatorHeight(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.mIndicatorHeight == i2) {
            return;
        }
        this.mIndicatorHeight = i2;
        invalidate();
    }

    public void setIndicatorPadding(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.mIndicatorPadding == i2) {
            return;
        }
        this.mIndicatorPadding = i2;
        invalidate();
    }

    public void setIndicatorPositionFromTabPosition(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.mSelectedPosition = i2;
            this.mSelectionOffset = f2;
            updateIndicatorPosition();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIndicatorColor = BaseAnimatedElement.DEBUG_PAINT_COLOR;
        this.mIndicatorLeft = -1;
        this.mIndicatorRight = -1;
        setWillNotDraw(false);
        float f2 = getResources().getDisplayMetrics().density;
        this.mSelectedIndicatorPaint = new Paint();
    }
}
