package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void forceUniformWidth(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, this, i2, i3) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
            for (int i4 = 0; i4 < i2; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() != 8) {
                    LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                        int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = childAt.getMeasuredHeight();
                        measureChildWithMargins(childAt, makeMeasureSpec, 0, i3, 0);
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = i5;
                    }
                }
            }
        }
    }

    public static int resolveMinimumHeight(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view)) == null) {
            int minimumHeight = ViewCompat.getMinimumHeight(view);
            if (minimumHeight > 0) {
                return minimumHeight;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.getChildCount() == 1) {
                    return resolveMinimumHeight(viewGroup.getChildAt(0));
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    private void setChildFrame(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            view.layout(i2, i3, i4 + i2, i5 + i3);
        }
    }

    private boolean tryOnMeasure(int i2, int i3) {
        InterceptResult invokeII;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, this, i2, i3)) == null) {
            int childCount = getChildCount();
            View view = null;
            View view2 = null;
            View view3 = null;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    int id = childAt.getId();
                    if (id == R.id.topPanel) {
                        view = childAt;
                    } else if (id == R.id.buttonPanel) {
                        view2 = childAt;
                    } else if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                        return false;
                    } else {
                        view3 = childAt;
                    }
                }
            }
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (view != null) {
                view.measure(i2, 0);
                paddingTop += view.getMeasuredHeight();
                i4 = View.combineMeasuredStates(0, view.getMeasuredState());
            } else {
                i4 = 0;
            }
            if (view2 != null) {
                view2.measure(i2, 0);
                i5 = resolveMinimumHeight(view2);
                i6 = view2.getMeasuredHeight() - i5;
                paddingTop += i5;
                i4 = View.combineMeasuredStates(i4, view2.getMeasuredState());
            } else {
                i5 = 0;
                i6 = 0;
            }
            if (view3 != null) {
                view3.measure(i2, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
                i7 = view3.getMeasuredHeight();
                paddingTop += i7;
                i4 = View.combineMeasuredStates(i4, view3.getMeasuredState());
            } else {
                i7 = 0;
            }
            int i9 = size - paddingTop;
            if (view2 != null) {
                int i10 = paddingTop - i5;
                int min = Math.min(i9, i6);
                if (min > 0) {
                    i9 -= min;
                    i5 += min;
                }
                view2.measure(i2, View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
                paddingTop = i10 + view2.getMeasuredHeight();
                i4 = View.combineMeasuredStates(i4, view2.getMeasuredState());
            }
            if (view3 != null && i9 > 0) {
                view3.measure(i2, View.MeasureSpec.makeMeasureSpec(i7 + i9, mode));
                paddingTop = (paddingTop - i7) + view3.getMeasuredHeight();
                i4 = View.combineMeasuredStates(i4, view3.getMeasuredState());
            }
            int i11 = 0;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getVisibility() != 8) {
                    i11 = Math.max(i11, childAt2.getMeasuredWidth());
                }
            }
            setMeasuredDimension(View.resolveSizeAndState(i11 + getPaddingLeft() + getPaddingRight(), i2, i4), View.resolveSizeAndState(paddingTop, i3, 0));
            if (mode2 != 1073741824) {
                forceUniformWidth(childCount, i3);
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
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingTop;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int paddingLeft = getPaddingLeft();
            int i9 = i4 - i2;
            int paddingRight = i9 - getPaddingRight();
            int paddingRight2 = (i9 - paddingLeft) - getPaddingRight();
            int measuredHeight = getMeasuredHeight();
            int childCount = getChildCount();
            int gravity = getGravity();
            int i10 = gravity & 112;
            int i11 = gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            if (i10 == 16) {
                paddingTop = getPaddingTop() + (((i5 - i3) - measuredHeight) / 2);
            } else if (i10 != 80) {
                paddingTop = getPaddingTop();
            } else {
                paddingTop = ((getPaddingTop() + i5) - i3) - measuredHeight;
            }
            Drawable dividerDrawable = getDividerDrawable();
            int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt != null && childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                    int i13 = layoutParams.gravity;
                    if (i13 < 0) {
                        i13 = i11;
                    }
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(i13, ViewCompat.getLayoutDirection(this)) & 7;
                    if (absoluteGravity == 1) {
                        i6 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        i7 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    } else if (absoluteGravity != 5) {
                        i8 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                        if (hasDividerBeforeChildAt(i12)) {
                            paddingTop += intrinsicHeight;
                        }
                        int i14 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        setChildFrame(childAt, i8, i14, measuredWidth, measuredHeight2);
                        paddingTop = i14 + measuredHeight2 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    } else {
                        i6 = paddingRight - measuredWidth;
                        i7 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    }
                    i8 = i6 - i7;
                    if (hasDividerBeforeChildAt(i12)) {
                    }
                    int i142 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    setChildFrame(childAt, i8, i142, measuredWidth, measuredHeight2);
                    paddingTop = i142 + measuredHeight2 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || tryOnMeasure(i2, i3)) {
            return;
        }
        super.onMeasure(i2, i3);
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
    }
}
