package com.baidu.mobads.sdk.internal.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes3.dex */
public final class AnimateLayoutChangeDetector {
    public static /* synthetic */ Interceptable $ic;
    public static final ViewGroup.MarginLayoutParams a;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayoutManager b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1976558489, "Lcom/baidu/mobads/sdk/internal/widget/AnimateLayoutChangeDetector;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1976558489, "Lcom/baidu/mobads/sdk/internal/widget/AnimateLayoutChangeDetector;");
                return;
            }
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        a = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int childCount = this.b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (a(this.b.getChildAt(i))) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if ((!b() || this.b.getChildCount() <= 1) && c()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public AnimateLayoutChangeDetector(@NonNull LinearLayoutManager linearLayoutManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {linearLayoutManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = linearLayoutManager;
    }

    public static boolean a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
                if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                    return true;
                }
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (a(viewGroup.getChildAt(i))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean b() {
        InterceptResult invokeV;
        boolean z;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int top;
        int i;
        int bottom;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int childCount = this.b.getChildCount();
            if (childCount == 0) {
                return true;
            }
            if (this.b.getOrientation() == 0) {
                z = true;
            } else {
                z = false;
            }
            int[][] iArr = (int[][]) Array.newInstance(int.class, childCount, 2);
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.b.getChildAt(i3);
                if (childAt != null) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        marginLayoutParams = a;
                    }
                    int[] iArr2 = iArr[i3];
                    if (z) {
                        top = childAt.getLeft();
                        i = marginLayoutParams.leftMargin;
                    } else {
                        top = childAt.getTop();
                        i = marginLayoutParams.topMargin;
                    }
                    iArr2[0] = top - i;
                    int[] iArr3 = iArr[i3];
                    if (z) {
                        bottom = childAt.getRight();
                        i2 = marginLayoutParams.rightMargin;
                    } else {
                        bottom = childAt.getBottom();
                        i2 = marginLayoutParams.bottomMargin;
                    }
                    iArr3[1] = bottom + i2;
                } else {
                    throw new IllegalStateException("null view contained in the view hierarchy");
                }
            }
            Arrays.sort(iArr, new Comparator<int[]>(this) { // from class: com.baidu.mobads.sdk.internal.widget.AnimateLayoutChangeDetector.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AnimateLayoutChangeDetector a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(int[] iArr4, int[] iArr5) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr4, iArr5)) == null) {
                        return iArr4[0] - iArr5[0];
                    }
                    return invokeLL.intValue;
                }
            });
            for (int i4 = 1; i4 < childCount; i4++) {
                if (iArr[i4 - 1][1] != iArr[i4][0]) {
                    return false;
                }
            }
            int i5 = iArr[0][1] - iArr[0][0];
            if (iArr[0][0] <= 0 && iArr[childCount - 1][1] >= i5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
