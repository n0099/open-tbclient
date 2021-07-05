package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.enums.ShareDirectionType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes.dex */
public class FloatingLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f2281e;

    /* renamed from: f  reason: collision with root package name */
    public int f2282f;

    /* renamed from: g  reason: collision with root package name */
    public int f2283g;

    /* renamed from: h  reason: collision with root package name */
    public int f2284h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FloatingLayout(Context context) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new LayoutParams(-2, -2, 0) : (LayoutParams) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: c */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (LayoutParams) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = generateDefaultLayoutParams();
                    }
                    int measuredWidth2 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin + childAt.getMeasuredWidth();
                    int measuredHeight = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + childAt.getMeasuredHeight();
                    if (measuredWidth - paddingLeft < measuredWidth2 || (layoutParams.f2285a & 1) == 1) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += i2;
                        i2 = 0;
                    }
                    int i4 = ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                    childAt.layout(paddingLeft + i4, ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop, i4 + paddingLeft + childAt.getMeasuredWidth(), ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop + childAt.getMeasuredHeight());
                    paddingLeft += measuredWidth2;
                    if (measuredHeight > i2) {
                        i2 = measuredHeight;
                    }
                    if ((layoutParams.f2285a & 2) == 2) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += i2;
                        i2 = 0;
                    }
                }
            }
        }
    }

    public final void e() {
        LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int childCount = getChildCount();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && childAt.getVisibility() != 8 && (layoutParams = (LayoutParams) childAt.getLayoutParams()) != null) {
                    int measuredWidth = ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin + childAt.getMeasuredWidth();
                    int measuredHeight2 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + childAt.getMeasuredHeight();
                    if (measuredHeight - paddingTop < measuredHeight2 || (layoutParams.f2285a & 1) == 1) {
                        paddingLeft += i2;
                        paddingTop = getPaddingTop();
                        i2 = 0;
                    }
                    int i4 = ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                    childAt.layout(paddingLeft + i4, ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop, i4 + paddingLeft + childAt.getMeasuredWidth(), ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop + childAt.getMeasuredHeight());
                    paddingTop += measuredHeight2;
                    if (measuredWidth > i2) {
                        i2 = measuredWidth;
                    }
                    if ((layoutParams.f2285a & 2) == 2) {
                        paddingLeft += i2;
                        paddingTop = getPaddingTop();
                        i2 = 0;
                    }
                }
            }
        }
    }

    public final void f(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            this.f2282f = 0;
            int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt != null && childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = generateDefaultLayoutParams();
                    }
                    LayoutParams layoutParams2 = layoutParams;
                    if (i4 <= this.f2281e || (layoutParams2.f2285a & 1) == 1) {
                        this.f2281e = 0;
                    }
                    measureChildWithMargins(childAt, i2, this.f2281e, i3, this.f2282f);
                    int measuredWidth = childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                    if ((layoutParams2.f2285a & 1) == 1) {
                        this.f2282f += i5;
                        i5 = 0;
                    }
                    i5 = Math.max(measuredHeight, i5);
                    int i7 = this.f2281e + measuredWidth;
                    this.f2281e = i7;
                    this.f2283g = Math.max(this.f2283g, i7);
                    if ((layoutParams2.f2285a & 2) == 2) {
                        this.f2281e = 0;
                        this.f2282f += i5;
                        i5 = 0;
                    }
                }
            }
            int i8 = this.f2282f + i5;
            this.f2282f = i8;
            this.f2284h = i8;
        }
    }

    public final void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            int i4 = i3 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt != null && childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = generateDefaultLayoutParams();
                    }
                    LayoutParams layoutParams2 = layoutParams;
                    if (i4 <= this.f2282f || (layoutParams2.f2285a & 1) == 1) {
                        this.f2282f = 0;
                    }
                    measureChildWithMargins(childAt, i2, this.f2281e, i3, this.f2282f);
                    i5 = Math.max(childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin, i5);
                    this.f2281e = i5;
                    int measuredHeight = this.f2282f + childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                    this.f2282f = measuredHeight;
                    this.f2284h = Math.max(measuredHeight, this.f2284h);
                    if ((layoutParams2.f2285a & 2) != 2) {
                        if ((layoutParams2.f2285a & 1) == 1) {
                            this.f2281e += i5;
                        }
                    } else {
                        this.f2282f = 0;
                        this.f2281e += i5;
                    }
                    i5 = 0;
                }
            }
            this.f2283g = this.f2281e;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int orientation = getOrientation();
            if (orientation == 0) {
                d();
            } else if (orientation == 1) {
                e();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            this.f2281e = 0;
            this.f2282f = 0;
            if (getOrientation() == 1) {
                g(i2, i3);
            } else if (getOrientation() == 0) {
                f(i2, i3);
            }
            setMeasuredDimension(this.f2283g + getPaddingLeft() + getPaddingRight(), this.f2284h + getPaddingTop() + getPaddingBottom());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingLayout(Context context, AttributeSet attributeSet) {
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

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f2285a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f2285a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingLayout_Layout);
            String string = obtainStyledAttributes.getString(R.styleable.FloatingLayout_Layout_layout_clear);
            if (string != null) {
                if ("before".equals(string)) {
                    this.f2285a = 1;
                } else if ("after".equals(string)) {
                    this.f2285a = 2;
                } else if (ShareDirectionType.BOTH.equals(string)) {
                    this.f2285a = 3;
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2285a = 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3, int i4) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f2285a = 0;
            this.f2285a = i4;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.f2285a = 0;
        }
    }
}
