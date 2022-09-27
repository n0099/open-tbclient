package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PEEK_BUTTON_DP = 16;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAllowStacking;
    public int mLastWidthSize;
    public int mMinimumHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLastWidthSize = -1;
        this.mMinimumHeight = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ButtonBarLayout);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.ButtonBarLayout, attributeSet, obtainStyledAttributes, 0, 0);
        this.mAllowStacking = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    private int getNextVisibleChildIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            int childCount = getChildCount();
            while (i < childCount) {
                if (getChildAt(i).getVisibility() == 0) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    private boolean isStacked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? getOrientation() == 1 : invokeV.booleanValue;
    }

    private void setStacked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            setOrientation(z ? 1 : 0);
            setGravity(z ? 5 : 80);
            View findViewById = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091f22);
            if (findViewById != null) {
                findViewById.setVisibility(z ? 8 : 4);
            }
            for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                bringChildToFront(getChildAt(childCount));
            }
        }
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Math.max(this.mMinimumHeight, super.getMinimumHeight()) : invokeV.intValue;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            int size = View.MeasureSpec.getSize(i);
            int i4 = 0;
            if (this.mAllowStacking) {
                if (size > this.mLastWidthSize && isStacked()) {
                    setStacked(false);
                }
                this.mLastWidthSize = size;
            }
            if (isStacked() || View.MeasureSpec.getMode(i) != 1073741824) {
                i3 = i;
                z = false;
            } else {
                i3 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
                z = true;
            }
            super.onMeasure(i3, i2);
            if (this.mAllowStacking && !isStacked()) {
                if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                    setStacked(true);
                    z = true;
                }
            }
            if (z) {
                super.onMeasure(i, i2);
            }
            int nextVisibleChildIndex = getNextVisibleChildIndex(0);
            if (nextVisibleChildIndex >= 0) {
                View childAt = getChildAt(nextVisibleChildIndex);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
                if (isStacked()) {
                    int nextVisibleChildIndex2 = getNextVisibleChildIndex(nextVisibleChildIndex + 1);
                    if (nextVisibleChildIndex2 >= 0) {
                        paddingTop += getChildAt(nextVisibleChildIndex2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                    }
                    i4 = paddingTop;
                } else {
                    i4 = paddingTop + getPaddingBottom();
                }
            }
            if (ViewCompat.getMinimumHeight(this) != i4) {
                setMinimumHeight(i4);
            }
        }
    }

    public void setAllowStacking(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.mAllowStacking == z) {
            return;
        }
        this.mAllowStacking = z;
        if (!z && getOrientation() == 1) {
            setStacked(false);
        }
        requestLayout();
    }
}
