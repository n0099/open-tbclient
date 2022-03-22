package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes3.dex */
public class ColumnLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f23896h;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<View> a;

    /* renamed from: b  reason: collision with root package name */
    public final List<View> f23897b;

    /* renamed from: c  reason: collision with root package name */
    public final List<View> f23898c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f23899d;

    /* renamed from: e  reason: collision with root package name */
    public int f23900e;

    /* renamed from: f  reason: collision with root package name */
    public int f23901f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f23902g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(823794336, "Lcom/baidu/adp/widget/ColumnLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(823794336, "Lcom/baidu/adp/widget/ColumnLayout;");
                return;
            }
        }
        f23896h = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ColumnLayout(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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

    public final void a(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i) == null) {
            if (i == 1) {
                if (this.a.contains(view)) {
                    return;
                }
                this.a.add(view);
            } else if (i != 2) {
                if (i == 3 && !this.f23898c.contains(view)) {
                    this.f23898c.add(view);
                }
            } else if (this.f23897b.contains(view)) {
            } else {
                this.f23897b.add(view);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i, layoutParams) == null) {
            super.addView(view, i, layoutParams);
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = generateDefaultLayoutParams();
            }
            a(view, layoutParams2.a);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new LayoutParams(-2, -2, 51, 1) : (LayoutParams) invokeV.objValue;
    }

    public final void c(int i, List<View> list, int i2, int i3, int i4) {
        int measuredHeight;
        int i5;
        int measuredWidth;
        int i6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), list, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || i < 1 || i > 3) {
            return;
        }
        int i7 = this.f23899d[i - 1];
        int measuredHeight2 = getMeasuredHeight();
        for (View view : list) {
            if (view.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                }
                int i8 = ((FrameLayout.LayoutParams) layoutParams).gravity;
                int i9 = i7 == 1 ? i8 & 7 : i8 & 112;
                if (i9 == 1) {
                    int i10 = i3 + ((FrameLayout.LayoutParams) layoutParams).topMargin;
                    measuredHeight = view.getMeasuredHeight() + i10;
                    view.layout(((((i4 - ((FrameLayout.LayoutParams) layoutParams).leftMargin) - ((FrameLayout.LayoutParams) layoutParams).rightMargin) - view.getMeasuredWidth()) + i2) >> 1, i10, ((((i4 - ((FrameLayout.LayoutParams) layoutParams).leftMargin) - ((FrameLayout.LayoutParams) layoutParams).rightMargin) + view.getMeasuredWidth()) + i2) >> 1, measuredHeight);
                    i5 = ((FrameLayout.LayoutParams) layoutParams).bottomMargin;
                } else if (i9 == 3) {
                    int i11 = ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                    int i12 = i2 + i11;
                    int i13 = i3 + ((FrameLayout.LayoutParams) layoutParams).topMargin;
                    int measuredWidth2 = i11 + i2 + view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight() + i13;
                    view.layout(i12, i13, measuredWidth2, measuredHeight);
                    i5 = ((FrameLayout.LayoutParams) layoutParams).bottomMargin;
                } else if (i9 != 5) {
                    if (i9 == 16) {
                        int i14 = i2 + ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                        measuredWidth = view.getMeasuredWidth() + i14;
                        view.layout(i14, ((((measuredHeight2 - ((FrameLayout.LayoutParams) layoutParams).topMargin) - ((FrameLayout.LayoutParams) layoutParams).bottomMargin) - view.getMeasuredHeight()) + i3) >> 1, measuredWidth, ((((measuredHeight2 - ((FrameLayout.LayoutParams) layoutParams).topMargin) - ((FrameLayout.LayoutParams) layoutParams).bottomMargin) + view.getMeasuredHeight()) + i3) >> 1);
                        i6 = ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                    } else if (i9 == 48) {
                        int i15 = i2 + ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                        measuredWidth = view.getMeasuredWidth() + i15;
                        view.layout(i15, ((FrameLayout.LayoutParams) layoutParams).topMargin + i3, measuredWidth, ((FrameLayout.LayoutParams) layoutParams).topMargin + i3 + view.getMeasuredHeight());
                        i6 = ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                    } else if (i9 == 80) {
                        int i16 = i2 + ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                        int i17 = i3 + measuredHeight2;
                        int measuredHeight3 = (i17 - ((FrameLayout.LayoutParams) layoutParams).bottomMargin) - view.getMeasuredHeight();
                        int measuredWidth3 = view.getMeasuredWidth() + i16;
                        view.layout(i16, measuredHeight3, measuredWidth3, i17 - ((FrameLayout.LayoutParams) layoutParams).bottomMargin);
                        i2 = measuredWidth3 + ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    i2 = measuredWidth + i6;
                } else {
                    int i18 = i2 + i4;
                    int measuredWidth4 = (i18 - ((FrameLayout.LayoutParams) layoutParams).rightMargin) - view.getMeasuredWidth();
                    int i19 = i3 + ((FrameLayout.LayoutParams) layoutParams).topMargin;
                    int i20 = i18 - ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                    measuredHeight = view.getMeasuredHeight() + i19;
                    view.layout(measuredWidth4, i19, i20, measuredHeight);
                    i5 = ((FrameLayout.LayoutParams) layoutParams).bottomMargin;
                }
                i3 = measuredHeight + i5;
            }
        }
    }

    public final int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? "vertical".equals(str) ? 1 : 0 : invokeL.intValue;
    }

    public final void e(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04016e, R.attr.obfuscated_res_0x7f040572, R.attr.obfuscated_res_0x7f040573});
            String string = obtainStyledAttributes.getString(0);
            if (string == null) {
                string = "vertical";
            }
            if (f23896h.matcher(string).matches()) {
                this.f23899d = new int[3];
                String[] split = string.split(WebChromeClient.PARAM_SEPARATOR);
                if (split.length == 1) {
                    int d2 = d(split[0]);
                    int i = 0;
                    while (true) {
                        int[] iArr = this.f23899d;
                        if (i >= iArr.length) {
                            break;
                        }
                        iArr[i] = d2;
                        i++;
                    }
                } else if (split.length > 1) {
                    if (this.f23899d.length != split.length) {
                        throw new RuntimeException("Column number doesn't equal orientation definition number.");
                    }
                    int i2 = 0;
                    while (true) {
                        int[] iArr2 = this.f23899d;
                        if (i2 >= iArr2.length) {
                            break;
                        }
                        iArr2[i2] = d(split[i2]);
                        i2++;
                    }
                }
            }
            this.f23900e = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.f23901f = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public final int f(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048582, this, i, i2, i3)) == null) {
            if (i3 == 1) {
                return i + i2;
            }
            if (i3 == 0) {
                return Math.max(i2, i);
            }
            return 0;
        }
        return invokeIII.intValue;
    }

    public final int g(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048583, this, i, i2, i3)) == null) {
            if (i3 == 1) {
                return Math.max(i2, i);
            }
            if (i3 == 0) {
                return i + i2;
            }
            return 0;
        }
        return invokeIII.intValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public final void h(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, view, i) == null) {
            if (i == 1) {
                this.a.remove(view);
            } else if (i == 2) {
                this.f23897b.remove(view);
            } else if (i != 3) {
            } else {
                this.f23898c.remove(view);
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onFinishInflate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int[] iArr = this.f23902g;
            if (iArr[0] == -1) {
                return;
            }
            c(1, this.a, paddingLeft, paddingTop, iArr[0]);
            int[] iArr2 = this.f23902g;
            int i5 = paddingLeft + iArr2[0] + this.f23900e;
            if (iArr2[1] == -1) {
                return;
            }
            c(2, this.f23897b, i5, paddingTop, iArr2[1]);
            int[] iArr3 = this.f23902g;
            int i6 = i5 + iArr3[1] + this.f23901f;
            if (iArr3[2] == -1) {
                return;
            }
            c(3, this.f23898c, i6, paddingTop, iArr3[2]);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x008b, code lost:
        setMeasuredDimension(r25.f23900e + r15, r5);
        r0 = r25.f23902g;
        r0[0] = r15;
        r0[1] = -1;
        r0[2] = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009b, code lost:
        return;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int i3;
        int min;
        int i4;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeII(1048590, this, i, i2) != null) {
            return;
        }
        int i5 = i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int i6 = i & (-1073741824);
        int i7 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int i8 = i2 & (-1073741824);
        int i9 = i5 + i6;
        int i10 = this.f23900e + this.f23901f;
        Iterator<View> it = this.a.iterator();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = 8;
            if (it.hasNext()) {
                View next = it.next();
                if (next.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) next.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = generateDefaultLayoutParams();
                    }
                    LayoutParams layoutParams2 = layoutParams;
                    measureChildWithMargins(next, i9, i12 + i10, i2, i11);
                    int measuredWidth = next.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams2).leftMargin + ((FrameLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredHeight = next.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams2).topMargin + ((FrameLayout.LayoutParams) layoutParams2).bottomMargin;
                    i12 = g(i12, measuredWidth, this.f23899d[0]);
                    i11 = f(i11, measuredHeight, this.f23899d[0]);
                    if ((i6 == 0 || i12 < i5) && (i8 == 0 || i11 < i7)) {
                    }
                }
            } else {
                int i14 = i11;
                this.f23902g[0] = i12;
                Iterator<View> it2 = this.f23898c.iterator();
                int i15 = 0;
                int i16 = 0;
                while (it2.hasNext()) {
                    View next2 = it2.next();
                    if (next2.getVisibility() != i13) {
                        LayoutParams layoutParams3 = (LayoutParams) next2.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = generateDefaultLayoutParams();
                        }
                        LayoutParams layoutParams4 = layoutParams3;
                        Iterator<View> it3 = it2;
                        int i17 = i15;
                        int i18 = i9;
                        measureChildWithMargins(next2, i9, i12 + i16 + i10, i2, i17);
                        int measuredWidth2 = next2.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams4).leftMargin + ((FrameLayout.LayoutParams) layoutParams4).rightMargin;
                        int measuredHeight2 = next2.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams4).topMargin + ((FrameLayout.LayoutParams) layoutParams4).bottomMargin;
                        i16 = g(i16, measuredWidth2, this.f23899d[2]);
                        i15 = f(i17, measuredHeight2, this.f23899d[2]);
                        if ((i6 != 0 && i16 > i5 - i12) || (i8 != 0 && i15 > i7)) {
                            setMeasuredDimension(i12 + i16 + this.f23900e + this.f23901f, Math.max(i14, i15));
                            int[] iArr = this.f23902g;
                            iArr[2] = i16;
                            iArr[1] = -1;
                            return;
                        }
                        it2 = it3;
                        i9 = i18;
                        i13 = 8;
                    }
                }
                int i19 = i15;
                int i20 = i9;
                int i21 = i16;
                this.f23902g[2] = i21;
                if (i6 != Integer.MIN_VALUE) {
                    if (i6 == 0) {
                        i4 = 0;
                        min = 0;
                        for (View view : this.f23897b) {
                            LayoutParams layoutParams5 = (LayoutParams) view.getLayoutParams();
                            if (layoutParams5 == null) {
                                layoutParams5 = generateDefaultLayoutParams();
                            }
                            measureChild(view, i5, i7);
                            int measuredWidth3 = view.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams5).leftMargin + ((FrameLayout.LayoutParams) layoutParams5).rightMargin;
                            int measuredHeight3 = view.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams5).topMargin + ((FrameLayout.LayoutParams) layoutParams5).bottomMargin;
                            min = g(min, measuredWidth3, this.f23899d[1]);
                            i4 = f(i4, measuredHeight3, this.f23899d[1]);
                        }
                    } else if (i6 != 1073741824) {
                        i3 = i7;
                        i4 = 0;
                        min = 0;
                    } else {
                        int paddingLeft = ((((i5 - i12) - i21) - i10) - getPaddingLeft()) - getPaddingRight();
                        Iterator<View> it4 = this.f23897b.iterator();
                        int i22 = 0;
                        while (it4.hasNext()) {
                            View next3 = it4.next();
                            if (next3.getVisibility() != 8) {
                                LayoutParams layoutParams6 = (LayoutParams) next3.getLayoutParams();
                                if (layoutParams6 == null) {
                                    layoutParams6 = generateDefaultLayoutParams();
                                }
                                LayoutParams layoutParams7 = layoutParams6;
                                measureChildWithMargins(next3, i20, i12 + i21 + i10, i2, 0);
                                i22 = f(i22, next3.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams7).topMargin + ((FrameLayout.LayoutParams) layoutParams7).bottomMargin, this.f23899d[1]);
                                it4 = it4;
                            }
                        }
                        i4 = i22;
                        min = paddingLeft;
                    }
                    i3 = i7;
                } else {
                    int i23 = (((i5 - i12) - i21) - this.f23900e) - this.f23901f;
                    int i24 = 0;
                    int i25 = 0;
                    for (View view2 : this.f23897b) {
                        if (view2.getVisibility() != 8) {
                            LayoutParams layoutParams8 = (LayoutParams) view2.getLayoutParams();
                            if (layoutParams8 == null) {
                                layoutParams8 = generateDefaultLayoutParams();
                            }
                            LayoutParams layoutParams9 = layoutParams8;
                            measureChildWithMargins(view2, i20, i25 + i12 + i21 + i10, i2, 0);
                            int measuredWidth4 = view2.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams9).leftMargin + ((FrameLayout.LayoutParams) layoutParams9).rightMargin;
                            int measuredHeight4 = view2.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams9).topMargin + ((FrameLayout.LayoutParams) layoutParams9).bottomMargin;
                            i25 = g(i25, measuredWidth4, this.f23899d[1]);
                            i24 = f(i24, measuredHeight4, this.f23899d[1]);
                            i7 = i7;
                            i10 = i10;
                        }
                    }
                    i3 = i7;
                    min = Math.min(i25, i23);
                    i4 = i24;
                }
                this.f23902g[1] = min;
                if (i8 == Integer.MIN_VALUE || i8 == 0) {
                    max = Math.max(Math.max(i14, i4), i19) + getPaddingTop() + getPaddingBottom();
                } else {
                    max = i8 != 1073741824 ? 0 : i3;
                }
                setMeasuredDimension(i12 + min + i21 + this.f23900e + this.f23901f + getPaddingLeft() + getPaddingRight(), max);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.removeAllViews();
            this.a.clear();
            this.f23897b.clear();
            this.f23898c.clear();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            super.removeView(view);
            h(view, ((LayoutParams) view.getLayoutParams()).a);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            throw new RuntimeException("removeView with index is not supposed in ColumnLayout");
        }
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i, i2) == null) {
            throw new RuntimeException("removeView in range is not supposed in ColumnLayout");
        }
    }

    public void setSpacingRight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.f23901f = i;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ColumnLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColumnLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f23897b = new ArrayList();
        this.f23898c = new ArrayList();
        this.f23899d = new int[]{0, 0, 0};
        this.f23902g = new int[3];
        e(context, attributeSet);
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
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
            this.a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04038b});
            this.a = obtainStyledAttributes.getInt(0, 1);
            obtainStyledAttributes.recycle();
            if (((FrameLayout.LayoutParams) this).gravity == -1) {
                ((FrameLayout.LayoutParams) this).gravity = 51;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2, int i3, int i4) {
            super(i, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 1;
            this.a = i4;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.a = 1;
        }
    }
}
