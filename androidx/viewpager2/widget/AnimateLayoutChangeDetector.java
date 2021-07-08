package androidx.viewpager2.widget;

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
/* loaded from: classes.dex */
public final class AnimateLayoutChangeDetector {
    public static /* synthetic */ Interceptable $ic;
    public static final ViewGroup.MarginLayoutParams ZERO_MARGIN_LAYOUT_PARAMS;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayoutManager mLayoutManager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1117602108, "Landroidx/viewpager2/widget/AnimateLayoutChangeDetector;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1117602108, "Landroidx/viewpager2/widget/AnimateLayoutChangeDetector;");
                return;
            }
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        ZERO_MARGIN_LAYOUT_PARAMS = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public AnimateLayoutChangeDetector(@NonNull LinearLayoutManager linearLayoutManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {linearLayoutManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLayoutManager = linearLayoutManager;
    }

    private boolean arePagesLaidOutContiguously() {
        InterceptResult invokeV;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int top;
        int i2;
        int bottom;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int childCount = this.mLayoutManager.getChildCount();
            if (childCount == 0) {
                return true;
            }
            boolean z = this.mLayoutManager.getOrientation() == 0;
            int[][] iArr = (int[][]) Array.newInstance(int.class, childCount, 2);
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = this.mLayoutManager.getChildAt(i4);
                if (childAt != null) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        marginLayoutParams = ZERO_MARGIN_LAYOUT_PARAMS;
                    }
                    int[] iArr2 = iArr[i4];
                    if (z) {
                        top = childAt.getLeft();
                        i2 = marginLayoutParams.leftMargin;
                    } else {
                        top = childAt.getTop();
                        i2 = marginLayoutParams.topMargin;
                    }
                    iArr2[0] = top - i2;
                    int[] iArr3 = iArr[i4];
                    if (z) {
                        bottom = childAt.getRight();
                        i3 = marginLayoutParams.rightMargin;
                    } else {
                        bottom = childAt.getBottom();
                        i3 = marginLayoutParams.bottomMargin;
                    }
                    iArr3[1] = bottom + i3;
                } else {
                    throw new IllegalStateException("null view contained in the view hierarchy");
                }
            }
            Arrays.sort(iArr, new Comparator<int[]>(this) { // from class: androidx.viewpager2.widget.AnimateLayoutChangeDetector.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AnimateLayoutChangeDetector this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(int[] iArr4, int[] iArr5) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr4, iArr5)) == null) ? iArr4[0] - iArr5[0] : invokeLL.intValue;
                }
            });
            for (int i5 = 1; i5 < childCount; i5++) {
                if (iArr[i5 - 1][1] != iArr[i5][0]) {
                    return false;
                }
            }
            return iArr[0][0] <= 0 && iArr[childCount - 1][1] >= iArr[0][1] - iArr[0][0];
        }
        return invokeV.booleanValue;
    }

    private boolean hasRunningChangingLayoutTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int childCount = this.mLayoutManager.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (hasRunningChangingLayoutTransition(this.mLayoutManager.getChildAt(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean mayHaveInterferingAnimations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (!arePagesLaidOutContiguously() || this.mLayoutManager.getChildCount() <= 1) && hasRunningChangingLayoutTransition() : invokeV.booleanValue;
    }

    public static boolean hasRunningChangingLayoutTransition(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view)) == null) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
                if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                    return true;
                }
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (hasRunningChangingLayoutTransition(viewGroup.getChildAt(i2))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
