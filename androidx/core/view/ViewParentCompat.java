package androidx.core.view;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class ViewParentCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ViewParentCompat";
    public static int[] sTempNestedScrollConsumed;
    public transient /* synthetic */ FieldHolder $fh;

    public ViewParentCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int[] getTempNestedScrollConsumed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            int[] iArr = sTempNestedScrollConsumed;
            if (iArr == null) {
                sTempNestedScrollConsumed = new int[2];
            } else {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return sTempNestedScrollConsumed;
        }
        return (int[]) invokeV.objValue;
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65538, null, viewParent, view, view2, i2) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i2);
    }

    public static boolean onNestedFling(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{viewParent, view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    return viewParent.onNestedFling(view, f2, f3, z);
                } catch (AbstractMethodError e2) {
                    Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e2);
                    return false;
                }
            } else if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onNestedFling(view, f2, f3, z);
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{viewParent, view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    return viewParent.onNestedPreFling(view, f2, f3);
                } catch (AbstractMethodError e2) {
                    Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e2);
                    return false;
                }
            } else if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onNestedPreFling(view, f2, f3);
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{viewParent, view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            onNestedPreScroll(viewParent, view, i2, i3, iArr, 0);
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{viewParent, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            onNestedScroll(viewParent, view, i2, i3, i4, i5, 0, getTempNestedScrollConsumed());
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65546, null, viewParent, view, view2, i2) == null) {
            onNestedScrollAccepted(viewParent, view, view2, i2, 0);
        }
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65548, null, viewParent, view, view2, i2)) == null) ? onStartNestedScroll(viewParent, view, view2, i2, 0) : invokeLLLI.booleanValue;
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, viewParent, view) == null) {
            onStopNestedScroll(viewParent, view, 0);
        }
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, viewParent, view, accessibilityEvent)) == null) ? viewParent.requestSendAccessibilityEvent(view, accessibilityEvent) : invokeLLL.booleanValue;
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i2, int i3, int[] iArr, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{viewParent, view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4)}) == null) {
            if (viewParent instanceof NestedScrollingParent2) {
                ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i2, i3, iArr, i4);
            } else if (i4 == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        viewParent.onNestedPreScroll(view, i2, i3, iArr);
                    } catch (AbstractMethodError e2) {
                        Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e2);
                    }
                } else if (viewParent instanceof NestedScrollingParent) {
                    ((NestedScrollingParent) viewParent).onNestedPreScroll(view, i2, i3, iArr);
                }
            }
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{viewParent, view, view2, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (viewParent instanceof NestedScrollingParent2) {
                ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i2, i3);
            } else if (i3 == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        viewParent.onNestedScrollAccepted(view, view2, i2);
                    } catch (AbstractMethodError e2) {
                        Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e2);
                    }
                } else if (viewParent instanceof NestedScrollingParent) {
                    ((NestedScrollingParent) viewParent).onNestedScrollAccepted(view, view2, i2);
                }
            }
        }
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{viewParent, view, view2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (viewParent instanceof NestedScrollingParent2) {
                return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i2, i3);
            }
            if (i3 == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        return viewParent.onStartNestedScroll(view, view2, i2);
                    } catch (AbstractMethodError e2) {
                        Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e2);
                        return false;
                    }
                } else if (viewParent instanceof NestedScrollingParent) {
                    return ((NestedScrollingParent) viewParent).onStartNestedScroll(view, view2, i2);
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65551, null, viewParent, view, i2) == null) {
            if (viewParent instanceof NestedScrollingParent2) {
                ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, i2);
            } else if (i2 == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        viewParent.onStopNestedScroll(view);
                    } catch (AbstractMethodError e2) {
                        Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e2);
                    }
                } else if (viewParent instanceof NestedScrollingParent) {
                    ((NestedScrollingParent) viewParent).onStopNestedScroll(view);
                }
            }
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{viewParent, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            onNestedScroll(viewParent, view, i2, i3, i4, i5, i6, getTempNestedScrollConsumed());
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{viewParent, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), iArr}) == null) {
            if (viewParent instanceof NestedScrollingParent3) {
                ((NestedScrollingParent3) viewParent).onNestedScroll(view, i2, i3, i4, i5, i6, iArr);
                return;
            }
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
            if (viewParent instanceof NestedScrollingParent2) {
                ((NestedScrollingParent2) viewParent).onNestedScroll(view, i2, i3, i4, i5, i6);
            } else if (i6 == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        viewParent.onNestedScroll(view, i2, i3, i4, i5);
                    } catch (AbstractMethodError e2) {
                        Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e2);
                    }
                } else if (viewParent instanceof NestedScrollingParent) {
                    ((NestedScrollingParent) viewParent).onNestedScroll(view, i2, i3, i4, i5);
                }
            }
        }
    }
}
