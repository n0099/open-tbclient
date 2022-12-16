package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlertDialogLayout(@Nullable Context context) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlertDialogLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, this, i, i2) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() != 8) {
                    LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = childAt.getMeasuredHeight();
                        measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = i4;
                    }
                }
            }
        }
    }

    public static int resolveMinimumHeight(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            int minimumHeight = ViewCompat.getMinimumHeight(view2);
            if (minimumHeight > 0) {
                return minimumHeight;
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                if (viewGroup.getChildCount() == 1) {
                    return resolveMinimumHeight(viewGroup.getChildAt(0));
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    private void setChildFrame(View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            view2.layout(i, i2, i3 + i, i4 + i2);
        }
    }

    private boolean tryOnMeasure(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        int i4;
        int i5;
        int i6;
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, this, i, i2)) == null) {
            int childCount = getChildCount();
            View view2 = null;
            View view3 = null;
            View view4 = null;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    int id = childAt.getId();
                    if (id == R.id.obfuscated_res_0x7f092345) {
                        view2 = childAt;
                    } else if (id == R.id.obfuscated_res_0x7f090499) {
                        view3 = childAt;
                    } else if ((id != R.id.obfuscated_res_0x7f090714 && id != R.id.obfuscated_res_0x7f09077f) || view4 != null) {
                        return false;
                    } else {
                        view4 = childAt;
                    }
                }
            }
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (view2 != null) {
                view2.measure(i, 0);
                paddingTop += view2.getMeasuredHeight();
                i3 = View.combineMeasuredStates(0, view2.getMeasuredState());
            } else {
                i3 = 0;
            }
            if (view3 != null) {
                view3.measure(i, 0);
                i4 = resolveMinimumHeight(view3);
                i5 = view3.getMeasuredHeight() - i4;
                paddingTop += i4;
                i3 = View.combineMeasuredStates(i3, view3.getMeasuredState());
            } else {
                i4 = 0;
                i5 = 0;
            }
            if (view4 != null) {
                if (mode == 0) {
                    makeMeasureSpec = 0;
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode);
                }
                view4.measure(i, makeMeasureSpec);
                i6 = view4.getMeasuredHeight();
                paddingTop += i6;
                i3 = View.combineMeasuredStates(i3, view4.getMeasuredState());
            } else {
                i6 = 0;
            }
            int i8 = size - paddingTop;
            if (view3 != null) {
                int i9 = paddingTop - i4;
                int min = Math.min(i8, i5);
                if (min > 0) {
                    i8 -= min;
                    i4 += min;
                }
                view3.measure(i, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
                paddingTop = i9 + view3.getMeasuredHeight();
                i3 = View.combineMeasuredStates(i3, view3.getMeasuredState());
            }
            if (view4 != null && i8 > 0) {
                view4.measure(i, View.MeasureSpec.makeMeasureSpec(i6 + i8, mode));
                paddingTop = (paddingTop - i6) + view4.getMeasuredHeight();
                i3 = View.combineMeasuredStates(i3, view4.getMeasuredState());
            }
            int i10 = 0;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt2 = getChildAt(i11);
                if (childAt2.getVisibility() != 8) {
                    i10 = Math.max(i10, childAt2.getMeasuredWidth());
                }
            }
            setMeasuredDimension(View.resolveSizeAndState(i10 + getPaddingLeft() + getPaddingRight(), i, i3), View.resolveSizeAndState(paddingTop, i2, 0));
            if (mode2 != 1073741824) {
                forceUniformWidth(childCount, i2);
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop;
        int intrinsicHeight;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int paddingLeft = getPaddingLeft();
            int i8 = i3 - i;
            int paddingRight = i8 - getPaddingRight();
            int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
            int measuredHeight = getMeasuredHeight();
            int childCount = getChildCount();
            int gravity = getGravity();
            int i9 = gravity & 112;
            int i10 = gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            if (i9 != 16) {
                if (i9 != 80) {
                    paddingTop = getPaddingTop();
                } else {
                    paddingTop = ((getPaddingTop() + i4) - i2) - measuredHeight;
                }
            } else {
                paddingTop = getPaddingTop() + (((i4 - i2) - measuredHeight) / 2);
            }
            Drawable dividerDrawable = getDividerDrawable();
            if (dividerDrawable == null) {
                intrinsicHeight = 0;
            } else {
                intrinsicHeight = dividerDrawable.getIntrinsicHeight();
            }
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt != null && childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                    int i12 = layoutParams.gravity;
                    if (i12 < 0) {
                        i12 = i10;
                    }
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(i12, ViewCompat.getLayoutDirection(this)) & 7;
                    if (absoluteGravity != 1) {
                        if (absoluteGravity != 5) {
                            i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                            if (hasDividerBeforeChildAt(i11)) {
                                paddingTop += intrinsicHeight;
                            }
                            int i13 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            setChildFrame(childAt, i7, i13, measuredWidth, measuredHeight2);
                            paddingTop = i13 + measuredHeight2 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        } else {
                            i5 = paddingRight - measuredWidth;
                            i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        }
                    } else {
                        i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    }
                    i7 = i5 - i6;
                    if (hasDividerBeforeChildAt(i11)) {
                    }
                    int i132 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    setChildFrame(childAt, i7, i132, measuredWidth, measuredHeight2);
                    paddingTop = i132 + measuredHeight2 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && !tryOnMeasure(i, i2)) {
            super.onMeasure(i, i2);
        }
    }
}
