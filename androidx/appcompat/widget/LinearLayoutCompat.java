package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    public static final int INDEX_BOTTOM = 2;
    public static final int INDEX_CENTER_VERTICAL = 0;
    public static final int INDEX_FILL = 3;
    public static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    public static final int VERTICAL_GRAVITY_COUNT = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mBaselineAligned;
    public int mBaselineAlignedChildIndex;
    public int mBaselineChildTop;
    public Drawable mDivider;
    public int mDividerHeight;
    public int mDividerPadding;
    public int mDividerWidth;
    public int mGravity;
    public int[] mMaxAscent;
    public int[] mMaxDescent;
    public int mOrientation;
    public int mShowDividers;
    public int mTotalLength;
    public boolean mUseLargestChild;
    public float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface DividerMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface OrientationMode {
    }

    public int getChildrenSkipCount(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, view2, i)) == null) {
            return 0;
        }
        return invokeLI.intValue;
    }

    public int getLocationOffset(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, view2)) == null) {
            return 0;
        }
        return invokeL.intValue;
    }

    public int getNextLocationOffset(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, view2)) == null) {
            return 0;
        }
        return invokeL.intValue;
    }

    public int measureNullChild(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int gravity;
        public float weight;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.gravity = -1;
            this.weight = 0.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.gravity = -1;
            this.weight = f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(3, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(0, -1);
            obtainStyledAttributes.recycle();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.gravity = -1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.gravity = -1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65541, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65541, newInitContext);
                    return;
                }
            }
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinearLayoutCompat(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            if (i == 0) {
                if ((this.mShowDividers & 1) == 0) {
                    return false;
                }
                return true;
            } else if (i == getChildCount()) {
                if ((this.mShowDividers & 4) == 0) {
                    return false;
                }
                return true;
            } else if ((this.mShowDividers & 2) == 0) {
                return false;
            } else {
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    if (getChildAt(i2).getVisibility() != 8) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public void setBaselineAlignedChildIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            if (i >= 0 && i < getChildCount()) {
                this.mBaselineAlignedChildIndex = i;
                return;
            }
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048617, this, drawable) != null) || drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        boolean z = false;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        if (drawable == null) {
            z = true;
        }
        setWillNotDraw(z);
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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

    private void forceUniformHeight(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, this, i, i2) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
            for (int i3 = 0; i3 < i; i3++) {
                View virtualChildAt = getVirtualChildAt(i3);
                if (virtualChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = virtualChildAt.getMeasuredWidth();
                        measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = i4;
                    }
                }
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i, i2) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
            for (int i3 = 0; i3 < i; i3++) {
                View virtualChildAt = getVirtualChildAt(i3);
                if (virtualChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = virtualChildAt.getMeasuredHeight();
                        measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = i4;
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = BadgeDrawable.TOP_START;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.LinearLayoutCompat, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.LinearLayoutCompat, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        int i4 = obtainStyledAttributes.getInt(1, -1);
        if (i4 >= 0) {
            setOrientation(i4);
        }
        int i5 = obtainStyledAttributes.getInt(0, -1);
        if (i5 >= 0) {
            setGravity(i5);
        }
        boolean z = obtainStyledAttributes.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(4, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(3, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(7, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(5));
        this.mShowDividers = obtainStyledAttributes.getInt(8, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        obtainStyledAttributes.recycle();
    }

    private void setChildFrame(View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            view2.layout(i, i2, i3 + i, i4 + i2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, layoutParams)) == null) {
            return layoutParams instanceof LayoutParams;
        }
        return invokeL.booleanValue;
    }

    public View getVirtualChildAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            return getChildAt(i);
        }
        return (View) invokeI.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, canvas) != null) || this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
        }
    }

    public void setBaselineAligned(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.mBaselineAligned = z;
        }
    }

    public void setDividerPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.mDividerPadding = i;
        }
    }

    public void setGravity(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048619, this, i) == null) && this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            int i3 = this.mGravity;
            if ((8388615 & i3) != i2) {
                this.mGravity = i2 | ((-8388616) & i3);
                requestLayout();
            }
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.mUseLargestChild = z;
        }
    }

    public void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048622, this, i) == null) && this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            if (i != this.mShowDividers) {
                requestLayout();
            }
            this.mShowDividers = i;
        }
    }

    public void setVerticalGravity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            int i2 = i & 112;
            int i3 = this.mGravity;
            if ((i3 & 112) != i2) {
                this.mGravity = i2 | (i3 & OneKeyLoginResult.ONE_KEY_LOGIN_CODE_JSON_ERROR);
                requestLayout();
            }
        }
    }

    public void setWeightSum(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048625, this, f) == null) {
            this.mWeightSum = Math.max(0.0f, f);
        }
    }

    public void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i;
        int left2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            int virtualChildCount = getVirtualChildCount();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            for (int i2 = 0; i2 < virtualChildCount; i2++) {
                View virtualChildAt = getVirtualChildAt(i2);
                if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    if (isLayoutRtl) {
                        left2 = virtualChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    } else {
                        left2 = (virtualChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.mDividerWidth;
                    }
                    drawVerticalDivider(canvas, left2);
                }
            }
            if (hasDividerBeforeChildAt(virtualChildCount)) {
                View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
                if (virtualChildAt2 == null) {
                    if (isLayoutRtl) {
                        right = getPaddingLeft();
                    } else {
                        left = getWidth() - getPaddingRight();
                        i = this.mDividerWidth;
                        right = left - i;
                    }
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (isLayoutRtl) {
                        left = virtualChildAt2.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                        i = this.mDividerWidth;
                        right = left - i;
                    } else {
                        right = virtualChildAt2.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                    }
                }
                drawVerticalDivider(canvas, right);
            }
        }
    }

    public void drawDividersVertical(Canvas canvas) {
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            int virtualChildCount = getVirtualChildCount();
            for (int i = 0; i < virtualChildCount; i++) {
                View virtualChildAt = getVirtualChildAt(i);
                if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                    drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((ViewGroup.MarginLayoutParams) ((LayoutParams) virtualChildAt.getLayoutParams())).topMargin) - this.mDividerHeight);
                }
            }
            if (hasDividerBeforeChildAt(virtualChildCount)) {
                View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
                if (virtualChildAt2 == null) {
                    bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
                } else {
                    bottom = virtualChildAt2.getBottom() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) virtualChildAt2.getLayoutParams())).bottomMargin;
                }
                drawHorizontalDivider(canvas, bottom);
            }
        }
    }

    public void drawHorizontalDivider(Canvas canvas, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, canvas, i) == null) {
            this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
            this.mDivider.draw(canvas);
        }
    }

    public void drawVerticalDivider(Canvas canvas, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, canvas, i) == null) {
            this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
            this.mDivider.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048614, this, i, i2) == null) {
            if (this.mOrientation == 1) {
                measureVertical(i, i2);
            } else {
                measureHorizontal(i, i2);
            }
        }
    }

    public int getBaselineAlignedChildIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mBaselineAlignedChildIndex;
        }
        return invokeV.intValue;
    }

    public Drawable getDividerDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mDivider;
        }
        return (Drawable) invokeV.objValue;
    }

    public int getDividerPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mDividerPadding;
        }
        return invokeV.intValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mDividerWidth;
        }
        return invokeV.intValue;
    }

    public int getGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mGravity;
        }
        return invokeV.intValue;
    }

    public int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mOrientation;
        }
        return invokeV.intValue;
    }

    public int getShowDividers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mShowDividers;
        }
        return invokeV.intValue;
    }

    public int getVirtualChildCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return getChildCount();
        }
        return invokeV.intValue;
    }

    public float getWeightSum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mWeightSum;
        }
        return invokeV.floatValue;
    }

    public boolean isBaselineAligned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mBaselineAligned;
        }
        return invokeV.booleanValue;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mUseLargestChild;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.mOrientation;
            if (i == 0) {
                return new LayoutParams(-2, -2);
            }
            if (i == 1) {
                return new LayoutParams(-1, -2);
            }
            return null;
        }
        return (LayoutParams) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, attributeSet)) == null) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (LayoutParams) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, layoutParams)) == null) {
            return new LayoutParams(layoutParams);
        }
        return (LayoutParams) invokeL.objValue;
    }

    @Override // android.view.View
    public int getBaseline() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.mBaselineAlignedChildIndex < 0) {
                return super.getBaseline();
            }
            int childCount = getChildCount();
            int i2 = this.mBaselineAlignedChildIndex;
            if (childCount > i2) {
                View childAt = getChildAt(i2);
                int baseline = childAt.getBaseline();
                if (baseline == -1) {
                    if (this.mBaselineAlignedChildIndex == 0) {
                        return -1;
                    }
                    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
                }
                int i3 = this.mBaselineChildTop;
                if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
                    if (i != 16) {
                        if (i == 80) {
                            i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                        }
                    } else {
                        i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                    }
                }
                return i3 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutHorizontal(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048604, this, i, i2, i3, i4) == null) {
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            int paddingTop = getPaddingTop();
            int i14 = i4 - i2;
            int paddingBottom = i14 - getPaddingBottom();
            int paddingBottom2 = (i14 - paddingTop) - getPaddingBottom();
            int virtualChildCount = getVirtualChildCount();
            int i15 = this.mGravity;
            int i16 = i15 & 112;
            boolean z = this.mBaselineAligned;
            int[] iArr = this.mMaxAscent;
            int[] iArr2 = this.mMaxDescent;
            int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i15, ViewCompat.getLayoutDirection(this));
            if (absoluteGravity != 1) {
                if (absoluteGravity != 5) {
                    paddingLeft = getPaddingLeft();
                } else {
                    paddingLeft = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
                }
            } else {
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
            }
            if (isLayoutRtl) {
                i5 = virtualChildCount - 1;
                i6 = -1;
            } else {
                i5 = 0;
                i6 = 1;
            }
            int i17 = 0;
            while (i17 < virtualChildCount) {
                int i18 = i5 + (i6 * i17);
                View virtualChildAt = getVirtualChildAt(i18);
                if (virtualChildAt == null) {
                    paddingLeft += measureNullChild(i18);
                } else if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i19 = i17;
                    if (z) {
                        i7 = virtualChildCount;
                        if (((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                            i8 = virtualChildAt.getBaseline();
                            i9 = layoutParams.gravity;
                            if (i9 < 0) {
                                i9 = i16;
                            }
                            i10 = i9 & 112;
                            i11 = i16;
                            if (i10 == 16) {
                                if (i10 != 48) {
                                    if (i10 != 80) {
                                        i12 = paddingTop;
                                    } else {
                                        i12 = (paddingBottom - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                                        if (i8 != -1) {
                                            i12 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i8);
                                        }
                                    }
                                } else {
                                    i12 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                                    if (i8 != -1) {
                                        i12 += iArr[1] - i8;
                                    }
                                }
                            } else {
                                i12 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            }
                            if (hasDividerBeforeChildAt(i18)) {
                                paddingLeft += this.mDividerWidth;
                            }
                            int i20 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                            i13 = paddingTop;
                            setChildFrame(virtualChildAt, i20 + getLocationOffset(virtualChildAt), i12, measuredWidth, measuredHeight);
                            i17 = i19 + getChildrenSkipCount(virtualChildAt, i18);
                            paddingLeft = i20 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(virtualChildAt);
                            i17++;
                            virtualChildCount = i7;
                            i16 = i11;
                            paddingTop = i13;
                        }
                    } else {
                        i7 = virtualChildCount;
                    }
                    i8 = -1;
                    i9 = layoutParams.gravity;
                    if (i9 < 0) {
                    }
                    i10 = i9 & 112;
                    i11 = i16;
                    if (i10 == 16) {
                    }
                    if (hasDividerBeforeChildAt(i18)) {
                    }
                    int i202 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                    i13 = paddingTop;
                    setChildFrame(virtualChildAt, i202 + getLocationOffset(virtualChildAt), i12, measuredWidth, measuredHeight);
                    i17 = i19 + getChildrenSkipCount(virtualChildAt, i18);
                    paddingLeft = i202 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(virtualChildAt);
                    i17++;
                    virtualChildCount = i7;
                    i16 = i11;
                    paddingTop = i13;
                }
                i13 = paddingTop;
                i7 = virtualChildCount;
                i11 = i16;
                i17++;
                virtualChildCount = i7;
                i16 = i11;
                paddingTop = i13;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutVertical(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048605, this, i, i2, i3, i4) == null) {
            int paddingLeft = getPaddingLeft();
            int i8 = i3 - i;
            int paddingRight = i8 - getPaddingRight();
            int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
            int virtualChildCount = getVirtualChildCount();
            int i9 = this.mGravity;
            int i10 = i9 & 112;
            int i11 = i9 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            if (i10 != 16) {
                if (i10 != 80) {
                    paddingTop = getPaddingTop();
                } else {
                    paddingTop = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
                }
            } else {
                paddingTop = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
            }
            int i12 = 0;
            while (i12 < virtualChildCount) {
                View virtualChildAt = getVirtualChildAt(i12);
                if (virtualChildAt == null) {
                    paddingTop += measureNullChild(i12);
                } else if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i13 = layoutParams.gravity;
                    if (i13 < 0) {
                        i13 = i11;
                    }
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(i13, ViewCompat.getLayoutDirection(this)) & 7;
                    if (absoluteGravity != 1) {
                        if (absoluteGravity != 5) {
                            i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                            int i14 = i7;
                            if (hasDividerBeforeChildAt(i12)) {
                                paddingTop += this.mDividerHeight;
                            }
                            int i15 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            setChildFrame(virtualChildAt, i14, i15 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                            i12 += getChildrenSkipCount(virtualChildAt, i12);
                            paddingTop = i15 + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt);
                        } else {
                            i5 = paddingRight - measuredWidth;
                            i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        }
                    } else {
                        i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    }
                    i7 = i5 - i6;
                    int i142 = i7;
                    if (hasDividerBeforeChildAt(i12)) {
                    }
                    int i152 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    setChildFrame(virtualChildAt, i142, i152 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                    i12 += getChildrenSkipCount(virtualChildAt, i12);
                    paddingTop = i152 + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt);
                }
                i12++;
            }
        }
    }

    public void measureChildBeforeLayout(View view2, int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            measureChildWithMargins(view2, i2, i3, i4, i5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:199:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measureHorizontal(int i, int i2) {
        boolean z;
        int[] iArr;
        int i3;
        int max;
        int i4;
        int i5;
        int max2;
        int i6;
        int i7;
        int i8;
        int i9;
        float f;
        boolean z2;
        int i10;
        boolean z3;
        int baseline;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z4;
        boolean z5;
        View view2;
        int i17;
        boolean z6;
        int measuredHeight;
        int childrenSkipCount;
        int baseline2;
        int i18;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048607, this, i, i2) == null) {
            this.mTotalLength = 0;
            int virtualChildCount = getVirtualChildCount();
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (this.mMaxAscent == null || this.mMaxDescent == null) {
                this.mMaxAscent = new int[4];
                this.mMaxDescent = new int[4];
            }
            int[] iArr2 = this.mMaxAscent;
            int[] iArr3 = this.mMaxDescent;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr3[3] = -1;
            iArr3[2] = -1;
            iArr3[1] = -1;
            iArr3[0] = -1;
            boolean z7 = this.mBaselineAligned;
            boolean z8 = this.mUseLargestChild;
            int i19 = 1073741824;
            if (mode == 1073741824) {
                z = true;
            } else {
                z = false;
            }
            float f2 = 0.0f;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            boolean z9 = false;
            int i25 = 0;
            boolean z10 = true;
            boolean z11 = false;
            while (true) {
                iArr = iArr3;
                if (i20 >= virtualChildCount) {
                    break;
                }
                View virtualChildAt = getVirtualChildAt(i20);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i20);
                } else if (virtualChildAt.getVisibility() == 8) {
                    i20 += getChildrenSkipCount(virtualChildAt, i20);
                } else {
                    if (hasDividerBeforeChildAt(i20)) {
                        this.mTotalLength += this.mDividerWidth;
                    }
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    float f3 = layoutParams.weight;
                    float f4 = f2 + f3;
                    if (mode == i19 && ((ViewGroup.MarginLayoutParams) layoutParams).width == 0 && f3 > 0.0f) {
                        if (z) {
                            this.mTotalLength += ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        } else {
                            int i26 = this.mTotalLength;
                            this.mTotalLength = Math.max(i26, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + i26 + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                        }
                        if (z7) {
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                            i16 = i20;
                            z4 = z8;
                            z5 = z7;
                            view2 = virtualChildAt;
                        } else {
                            i16 = i20;
                            z4 = z8;
                            z5 = z7;
                            view2 = virtualChildAt;
                            i17 = 1073741824;
                            z9 = true;
                            if (mode2 == i17 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                                z6 = true;
                                z11 = true;
                            } else {
                                z6 = false;
                            }
                            int i27 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            measuredHeight = view2.getMeasuredHeight() + i27;
                            i25 = View.combineMeasuredStates(i25, view2.getMeasuredState());
                            if (z5 && (baseline2 = view2.getBaseline()) != -1) {
                                i18 = layoutParams.gravity;
                                if (i18 < 0) {
                                    i18 = this.mGravity;
                                }
                                int i28 = (((i18 & 112) >> 4) & (-2)) >> 1;
                                iArr2[i28] = Math.max(iArr2[i28], baseline2);
                                iArr[i28] = Math.max(iArr[i28], measuredHeight - baseline2);
                            }
                            i22 = Math.max(i22, measuredHeight);
                            if (!z10 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (layoutParams.weight <= 0.0f) {
                                if (!z6) {
                                    i27 = measuredHeight;
                                }
                                i24 = Math.max(i24, i27);
                            } else {
                                int i29 = i24;
                                if (!z6) {
                                    i27 = measuredHeight;
                                }
                                i23 = Math.max(i23, i27);
                                i24 = i29;
                            }
                            int i30 = i16;
                            childrenSkipCount = getChildrenSkipCount(view2, i30) + i30;
                            f2 = f4;
                            i20 = childrenSkipCount + 1;
                            iArr3 = iArr;
                            z8 = z4;
                            z7 = z5;
                            i19 = 1073741824;
                        }
                    } else {
                        if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0 && layoutParams.weight > 0.0f) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
                            i14 = 0;
                        } else {
                            i14 = Integer.MIN_VALUE;
                        }
                        if (f4 == 0.0f) {
                            i15 = this.mTotalLength;
                        } else {
                            i15 = 0;
                        }
                        i16 = i20;
                        int i31 = i14;
                        z4 = z8;
                        z5 = z7;
                        measureChildBeforeLayout(virtualChildAt, i16, i, i15, i2, 0);
                        if (i31 != Integer.MIN_VALUE) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).width = i31;
                        }
                        int measuredWidth = virtualChildAt.getMeasuredWidth();
                        if (z) {
                            view2 = virtualChildAt;
                            this.mTotalLength += ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(view2);
                        } else {
                            view2 = virtualChildAt;
                            int i32 = this.mTotalLength;
                            this.mTotalLength = Math.max(i32, i32 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(view2));
                        }
                        if (z4) {
                            i21 = Math.max(measuredWidth, i21);
                        }
                    }
                    i17 = 1073741824;
                    if (mode2 == i17) {
                    }
                    z6 = false;
                    int i272 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    measuredHeight = view2.getMeasuredHeight() + i272;
                    i25 = View.combineMeasuredStates(i25, view2.getMeasuredState());
                    if (z5) {
                        i18 = layoutParams.gravity;
                        if (i18 < 0) {
                        }
                        int i282 = (((i18 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i282] = Math.max(iArr2[i282], baseline2);
                        iArr[i282] = Math.max(iArr[i282], measuredHeight - baseline2);
                    }
                    i22 = Math.max(i22, measuredHeight);
                    if (!z10) {
                    }
                    z10 = false;
                    if (layoutParams.weight <= 0.0f) {
                    }
                    int i302 = i16;
                    childrenSkipCount = getChildrenSkipCount(view2, i302) + i302;
                    f2 = f4;
                    i20 = childrenSkipCount + 1;
                    iArr3 = iArr;
                    z8 = z4;
                    z7 = z5;
                    i19 = 1073741824;
                }
                childrenSkipCount = i20;
                z4 = z8;
                z5 = z7;
                i20 = childrenSkipCount + 1;
                iArr3 = iArr;
                z8 = z4;
                z7 = z5;
                i19 = 1073741824;
            }
            boolean z12 = z8;
            boolean z13 = z7;
            int i33 = i22;
            int i34 = i23;
            int i35 = i24;
            int i36 = i25;
            if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
                this.mTotalLength += this.mDividerWidth;
            }
            if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
                max = i33;
                i3 = i36;
            } else {
                i3 = i36;
                max = Math.max(i33, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            }
            if (z12 && (mode == Integer.MIN_VALUE || mode == 0)) {
                this.mTotalLength = 0;
                int i37 = 0;
                while (i37 < virtualChildCount) {
                    View virtualChildAt2 = getVirtualChildAt(i37);
                    if (virtualChildAt2 == null) {
                        this.mTotalLength += measureNullChild(i37);
                    } else if (virtualChildAt2.getVisibility() == 8) {
                        i37 += getChildrenSkipCount(virtualChildAt2, i37);
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                        if (z) {
                            this.mTotalLength += ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + i21 + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + getNextLocationOffset(virtualChildAt2);
                        } else {
                            int i38 = this.mTotalLength;
                            i13 = max;
                            this.mTotalLength = Math.max(i38, i38 + i21 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + getNextLocationOffset(virtualChildAt2));
                            i37++;
                            max = i13;
                        }
                    }
                    i13 = max;
                    i37++;
                    max = i13;
                }
            }
            int i39 = max;
            int paddingLeft = this.mTotalLength + getPaddingLeft() + getPaddingRight();
            this.mTotalLength = paddingLeft;
            int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0);
            int i40 = (16777215 & resolveSizeAndState) - this.mTotalLength;
            if (!z9 && (i40 == 0 || f2 <= 0.0f)) {
                i7 = Math.max(i34, i35);
                if (z12 && mode != 1073741824) {
                    for (int i41 = 0; i41 < virtualChildCount; i41++) {
                        View virtualChildAt3 = getVirtualChildAt(i41);
                        if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LayoutParams) virtualChildAt3.getLayoutParams()).weight > 0.0f) {
                            virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i21, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredHeight(), 1073741824));
                        }
                    }
                }
                i4 = i2;
                i5 = virtualChildCount;
                i6 = i39;
            } else {
                float f5 = this.mWeightSum;
                if (f5 > 0.0f) {
                    f2 = f5;
                }
                iArr2[3] = -1;
                iArr2[2] = -1;
                iArr2[1] = -1;
                iArr2[0] = -1;
                iArr[3] = -1;
                iArr[2] = -1;
                iArr[1] = -1;
                iArr[0] = -1;
                this.mTotalLength = 0;
                int i42 = i34;
                int i43 = i3;
                int i44 = -1;
                int i45 = 0;
                while (i45 < virtualChildCount) {
                    View virtualChildAt4 = getVirtualChildAt(i45);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8) {
                        LayoutParams layoutParams3 = (LayoutParams) virtualChildAt4.getLayoutParams();
                        float f6 = layoutParams3.weight;
                        if (f6 > 0.0f) {
                            int i46 = (int) ((i40 * f6) / f2);
                            float f7 = f2 - f6;
                            int i47 = i40 - i46;
                            i9 = virtualChildCount;
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams3).height);
                            if (((ViewGroup.MarginLayoutParams) layoutParams3).width == 0) {
                                i12 = 1073741824;
                                if (mode == 1073741824) {
                                    if (i46 <= 0) {
                                        i46 = 0;
                                    }
                                    virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i46, 1073741824), childMeasureSpec);
                                    i43 = View.combineMeasuredStates(i43, virtualChildAt4.getMeasuredState() & (-16777216));
                                    f2 = f7;
                                    i8 = i47;
                                }
                            } else {
                                i12 = 1073741824;
                            }
                            int measuredWidth2 = virtualChildAt4.getMeasuredWidth() + i46;
                            if (measuredWidth2 < 0) {
                                measuredWidth2 = 0;
                            }
                            virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i12), childMeasureSpec);
                            i43 = View.combineMeasuredStates(i43, virtualChildAt4.getMeasuredState() & (-16777216));
                            f2 = f7;
                            i8 = i47;
                        } else {
                            i8 = i40;
                            i9 = virtualChildCount;
                        }
                        if (z) {
                            this.mTotalLength += virtualChildAt4.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin + getNextLocationOffset(virtualChildAt4);
                            f = f2;
                        } else {
                            int i48 = this.mTotalLength;
                            f = f2;
                            this.mTotalLength = Math.max(i48, virtualChildAt4.getMeasuredWidth() + i48 + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin + getNextLocationOffset(virtualChildAt4));
                        }
                        if (mode2 != 1073741824 && ((ViewGroup.MarginLayoutParams) layoutParams3).height == -1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        int i49 = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                        int measuredHeight2 = virtualChildAt4.getMeasuredHeight() + i49;
                        i44 = Math.max(i44, measuredHeight2);
                        if (!z2) {
                            i49 = measuredHeight2;
                        }
                        int max3 = Math.max(i42, i49);
                        if (z10) {
                            i10 = -1;
                            if (((ViewGroup.MarginLayoutParams) layoutParams3).height == -1) {
                                z3 = true;
                                if (z13 && (baseline = virtualChildAt4.getBaseline()) != i10) {
                                    i11 = layoutParams3.gravity;
                                    if (i11 < 0) {
                                        i11 = this.mGravity;
                                    }
                                    int i50 = (((i11 & 112) >> 4) & (-2)) >> 1;
                                    iArr2[i50] = Math.max(iArr2[i50], baseline);
                                    iArr[i50] = Math.max(iArr[i50], measuredHeight2 - baseline);
                                }
                                z10 = z3;
                                i42 = max3;
                                f2 = f;
                            }
                        } else {
                            i10 = -1;
                        }
                        z3 = false;
                        if (z13) {
                            i11 = layoutParams3.gravity;
                            if (i11 < 0) {
                            }
                            int i502 = (((i11 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i502] = Math.max(iArr2[i502], baseline);
                            iArr[i502] = Math.max(iArr[i502], measuredHeight2 - baseline);
                        }
                        z10 = z3;
                        i42 = max3;
                        f2 = f;
                    } else {
                        i8 = i40;
                        i9 = virtualChildCount;
                    }
                    i45++;
                    i40 = i8;
                    virtualChildCount = i9;
                }
                i4 = i2;
                i5 = virtualChildCount;
                this.mTotalLength += getPaddingLeft() + getPaddingRight();
                if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
                    max2 = i44;
                } else {
                    max2 = Math.max(i44, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
                }
                i6 = max2;
                i7 = i42;
                i3 = i43;
            }
            if (z10 || mode2 == 1073741824) {
                i7 = i6;
            }
            setMeasuredDimension(resolveSizeAndState | (i3 & (-16777216)), View.resolveSizeAndState(Math.max(i7 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, i3 << 16));
            if (z11) {
                forceUniformHeight(i5, i);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x0329  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        boolean z2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        View view2;
        int i20;
        boolean z3;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048609, this, i, i2) == null) {
            this.mTotalLength = 0;
            int virtualChildCount = getVirtualChildCount();
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int i21 = this.mBaselineAlignedChildIndex;
            boolean z4 = this.mUseLargestChild;
            float f = 0.0f;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            boolean z5 = false;
            boolean z6 = true;
            boolean z7 = false;
            while (true) {
                int i28 = 8;
                int i29 = i25;
                if (i27 < virtualChildCount) {
                    View virtualChildAt = getVirtualChildAt(i27);
                    if (virtualChildAt == null) {
                        this.mTotalLength += measureNullChild(i27);
                        i15 = virtualChildCount;
                        i16 = mode2;
                        i25 = i29;
                    } else {
                        int i30 = i22;
                        if (virtualChildAt.getVisibility() == 8) {
                            i27 += getChildrenSkipCount(virtualChildAt, i27);
                            i15 = virtualChildCount;
                            i25 = i29;
                            i22 = i30;
                            i16 = mode2;
                        } else {
                            if (hasDividerBeforeChildAt(i27)) {
                                this.mTotalLength += this.mDividerHeight;
                            }
                            LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                            float f2 = layoutParams.weight;
                            float f3 = f + f2;
                            if (mode2 == 1073741824 && ((ViewGroup.MarginLayoutParams) layoutParams).height == 0 && f2 > 0.0f) {
                                int i31 = this.mTotalLength;
                                this.mTotalLength = Math.max(i31, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + i31 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                                i20 = i24;
                                view2 = virtualChildAt;
                                i18 = i26;
                                i13 = i30;
                                i14 = i23;
                                z5 = true;
                                i15 = virtualChildCount;
                                i16 = mode2;
                                i17 = i29;
                                i19 = i27;
                            } else {
                                int i32 = i23;
                                if (((ViewGroup.MarginLayoutParams) layoutParams).height == 0 && layoutParams.weight > 0.0f) {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
                                    i11 = 0;
                                } else {
                                    i11 = Integer.MIN_VALUE;
                                }
                                if (f3 == 0.0f) {
                                    i12 = this.mTotalLength;
                                } else {
                                    i12 = 0;
                                }
                                i13 = i30;
                                int i33 = i11;
                                i14 = i32;
                                int i34 = i24;
                                i15 = virtualChildCount;
                                i16 = mode2;
                                i17 = i29;
                                i18 = i26;
                                i19 = i27;
                                measureChildBeforeLayout(virtualChildAt, i27, i, 0, i2, i12);
                                if (i33 != Integer.MIN_VALUE) {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).height = i33;
                                }
                                int measuredHeight = virtualChildAt.getMeasuredHeight();
                                int i35 = this.mTotalLength;
                                view2 = virtualChildAt;
                                this.mTotalLength = Math.max(i35, i35 + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + getNextLocationOffset(view2));
                                if (z4) {
                                    i20 = Math.max(measuredHeight, i34);
                                } else {
                                    i20 = i34;
                                }
                            }
                            if (i21 >= 0 && i21 == i19 + 1) {
                                this.mBaselineChildTop = this.mTotalLength;
                            }
                            if (i19 < i21 && layoutParams.weight > 0.0f) {
                                throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                            }
                            if (mode != 1073741824 && ((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                                z3 = true;
                                z7 = true;
                            } else {
                                z3 = false;
                            }
                            int i36 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                            int measuredWidth = view2.getMeasuredWidth() + i36;
                            int max2 = Math.max(i14, measuredWidth);
                            int combineMeasuredStates = View.combineMeasuredStates(i13, view2.getMeasuredState());
                            if (z6 && ((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (layoutParams.weight > 0.0f) {
                                if (!z3) {
                                    i36 = measuredWidth;
                                }
                                i25 = Math.max(i17, i36);
                                max = i18;
                            } else {
                                if (!z3) {
                                    i36 = measuredWidth;
                                }
                                max = Math.max(i18, i36);
                                i25 = i17;
                            }
                            i24 = i20;
                            f = f3;
                            i26 = max;
                            i22 = combineMeasuredStates;
                            i27 = getChildrenSkipCount(view2, i19) + i19;
                            i23 = max2;
                        }
                    }
                    i27++;
                    mode2 = i16;
                    virtualChildCount = i15;
                } else {
                    int i37 = i22;
                    int i38 = i24;
                    int i39 = i26;
                    int i40 = virtualChildCount;
                    int i41 = mode2;
                    int i42 = i23;
                    if (this.mTotalLength > 0) {
                        i3 = i40;
                        if (hasDividerBeforeChildAt(i3)) {
                            this.mTotalLength += this.mDividerHeight;
                        }
                    } else {
                        i3 = i40;
                    }
                    if (z4 && (i41 == Integer.MIN_VALUE || i41 == 0)) {
                        this.mTotalLength = 0;
                        int i43 = 0;
                        while (i43 < i3) {
                            View virtualChildAt2 = getVirtualChildAt(i43);
                            if (virtualChildAt2 == null) {
                                this.mTotalLength += measureNullChild(i43);
                            } else if (virtualChildAt2.getVisibility() == i28) {
                                i43 += getChildrenSkipCount(virtualChildAt2, i43);
                            } else {
                                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                                int i44 = this.mTotalLength;
                                this.mTotalLength = Math.max(i44, i44 + i38 + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + getNextLocationOffset(virtualChildAt2));
                            }
                            i43++;
                            i28 = 8;
                        }
                    }
                    int paddingTop = this.mTotalLength + getPaddingTop() + getPaddingBottom();
                    this.mTotalLength = paddingTop;
                    int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0);
                    int i45 = (16777215 & resolveSizeAndState) - this.mTotalLength;
                    if (!z5 && (i45 == 0 || f <= 0.0f)) {
                        i6 = Math.max(i39, i29);
                        if (z4 && i41 != 1073741824) {
                            for (int i46 = 0; i46 < i3; i46++) {
                                View virtualChildAt3 = getVirtualChildAt(i46);
                                if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LayoutParams) virtualChildAt3.getLayoutParams()).weight > 0.0f) {
                                    virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i38, 1073741824));
                                }
                            }
                        }
                        i5 = i;
                        i4 = i37;
                    } else {
                        float f4 = this.mWeightSum;
                        if (f4 > 0.0f) {
                            f = f4;
                        }
                        this.mTotalLength = 0;
                        int i47 = i45;
                        int i48 = i39;
                        i4 = i37;
                        int i49 = 0;
                        while (i49 < i3) {
                            View virtualChildAt4 = getVirtualChildAt(i49);
                            if (virtualChildAt4.getVisibility() == 8) {
                                i7 = i47;
                            } else {
                                LayoutParams layoutParams3 = (LayoutParams) virtualChildAt4.getLayoutParams();
                                float f5 = layoutParams3.weight;
                                if (f5 > 0.0f) {
                                    int i50 = (int) ((i47 * f5) / f);
                                    float f6 = f - f5;
                                    i7 = i47 - i50;
                                    int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams3).width);
                                    if (((ViewGroup.MarginLayoutParams) layoutParams3).height == 0) {
                                        i10 = 1073741824;
                                        if (i41 == 1073741824) {
                                            if (i50 <= 0) {
                                                i50 = 0;
                                            }
                                            virtualChildAt4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i50, 1073741824));
                                            i4 = View.combineMeasuredStates(i4, virtualChildAt4.getMeasuredState() & (-256));
                                            f = f6;
                                        }
                                    } else {
                                        i10 = 1073741824;
                                    }
                                    int measuredHeight2 = virtualChildAt4.getMeasuredHeight() + i50;
                                    if (measuredHeight2 < 0) {
                                        measuredHeight2 = 0;
                                    }
                                    virtualChildAt4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i10));
                                    i4 = View.combineMeasuredStates(i4, virtualChildAt4.getMeasuredState() & (-256));
                                    f = f6;
                                } else {
                                    i7 = i47;
                                }
                                int i51 = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin;
                                int measuredWidth2 = virtualChildAt4.getMeasuredWidth() + i51;
                                i42 = Math.max(i42, measuredWidth2);
                                float f7 = f;
                                if (mode != 1073741824) {
                                    i8 = i4;
                                    i9 = -1;
                                    if (((ViewGroup.MarginLayoutParams) layoutParams3).width == -1) {
                                        z = true;
                                        if (!z) {
                                            i51 = measuredWidth2;
                                        }
                                        int max3 = Math.max(i48, i51);
                                        if (!z6 && ((ViewGroup.MarginLayoutParams) layoutParams3).width == i9) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        int i52 = this.mTotalLength;
                                        this.mTotalLength = Math.max(i52, virtualChildAt4.getMeasuredHeight() + i52 + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + getNextLocationOffset(virtualChildAt4));
                                        z6 = z2;
                                        i4 = i8;
                                        i48 = max3;
                                        f = f7;
                                    }
                                } else {
                                    i8 = i4;
                                    i9 = -1;
                                }
                                z = false;
                                if (!z) {
                                }
                                int max32 = Math.max(i48, i51);
                                if (!z6) {
                                }
                                z2 = false;
                                int i522 = this.mTotalLength;
                                this.mTotalLength = Math.max(i522, virtualChildAt4.getMeasuredHeight() + i522 + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + getNextLocationOffset(virtualChildAt4));
                                z6 = z2;
                                i4 = i8;
                                i48 = max32;
                                f = f7;
                            }
                            i49++;
                            i47 = i7;
                        }
                        i5 = i;
                        this.mTotalLength += getPaddingTop() + getPaddingBottom();
                        i6 = i48;
                    }
                    if (z6 || mode == 1073741824) {
                        i6 = i42;
                    }
                    setMeasuredDimension(View.resolveSizeAndState(Math.max(i6 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i5, i4), resolveSizeAndState);
                    if (z7) {
                        forceUniformWidth(i3, i2);
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (this.mOrientation == 1) {
                layoutVertical(i, i2, i3, i4);
            } else {
                layoutHorizontal(i, i2, i3, i4);
            }
        }
    }
}
