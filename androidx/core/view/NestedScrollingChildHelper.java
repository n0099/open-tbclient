package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class NestedScrollingChildHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsNestedScrollingEnabled;
    public ViewParent mNestedScrollingParentNonTouch;
    public ViewParent mNestedScrollingParentTouch;
    public int[] mTempNestedScrollConsumed;
    public final View mView;

    public NestedScrollingChildHelper(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mView = view2;
    }

    private boolean dispatchNestedScrollInternal(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, @Nullable int[] iArr2) {
        InterceptResult invokeCommon;
        ViewParent nestedScrollingParentForType;
        int i6;
        int i7;
        int[] iArr3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, Integer.valueOf(i5), iArr2})) == null) {
            if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i5)) == null) {
                return false;
            }
            if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
                if (iArr != null) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                }
                return false;
            }
            if (iArr != null) {
                this.mView.getLocationInWindow(iArr);
                i6 = iArr[0];
                i7 = iArr[1];
            } else {
                i6 = 0;
                i7 = 0;
            }
            if (iArr2 == null) {
                int[] tempNestedScrollConsumed = getTempNestedScrollConsumed();
                tempNestedScrollConsumed[0] = 0;
                tempNestedScrollConsumed[1] = 0;
                iArr3 = tempNestedScrollConsumed;
            } else {
                iArr3 = iArr2;
            }
            ViewParentCompat.onNestedScroll(nestedScrollingParentForType, this.mView, i, i2, i3, i4, i5, iArr3);
            if (iArr != null) {
                this.mView.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i7;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    private ViewParent getNestedScrollingParentForType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return this.mNestedScrollingParentNonTouch;
            }
            return this.mNestedScrollingParentTouch;
        }
        return (ViewParent) invokeI.objValue;
    }

    private int[] getTempNestedScrollConsumed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.mTempNestedScrollConsumed == null) {
                this.mTempNestedScrollConsumed = new int[2];
            }
            return this.mTempNestedScrollConsumed;
        }
        return (int[]) invokeV.objValue;
    }

    private void setNestedScrollingParentForType(int i, ViewParent viewParent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, viewParent) == null) {
            if (i == 0) {
                this.mNestedScrollingParentTouch = viewParent;
            } else if (i != 1) {
            } else {
                this.mNestedScrollingParentNonTouch = viewParent;
            }
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        ViewParent nestedScrollingParentForType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
                return false;
            }
            return ViewParentCompat.onNestedFling(nestedScrollingParentForType, this.mView, f, f2, z);
        }
        return invokeCommon.booleanValue;
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        InterceptResult invokeCommon;
        ViewParent nestedScrollingParentForType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
                return false;
            }
            return ViewParentCompat.onNestedPreFling(nestedScrollingParentForType, this.mView, f, f2);
        }
        return invokeCommon.booleanValue;
    }

    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2})) == null) ? dispatchNestedPreScroll(i, i2, iArr, iArr2, 0) : invokeCommon.booleanValue;
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) ? dispatchNestedScrollInternal(i, i2, i3, i4, iArr, 0, null) : invokeCommon.booleanValue;
    }

    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? hasNestedScrollingParent(0) : invokeV.booleanValue;
    }

    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mIsNestedScrollingEnabled : invokeV.booleanValue;
    }

    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ViewCompat.stopNestedScroll(this.mView);
        }
    }

    public void onStopNestedScroll(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            ViewCompat.stopNestedScroll(this.mView);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (this.mIsNestedScrollingEnabled) {
                ViewCompat.stopNestedScroll(this.mView);
            }
            this.mIsNestedScrollingEnabled = z;
        }
    }

    public boolean startNestedScroll(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) ? startNestedScroll(i, 0) : invokeI.booleanValue;
    }

    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            stopNestedScroll(0);
        }
    }

    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2, int i3) {
        InterceptResult invokeCommon;
        ViewParent nestedScrollingParentForType;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2, Integer.valueOf(i3)})) == null) {
            if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i3)) == null) {
                return false;
            }
            if (i == 0 && i2 == 0) {
                if (iArr2 != null) {
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    return false;
                }
                return false;
            }
            if (iArr2 != null) {
                this.mView.getLocationInWindow(iArr2);
                i4 = iArr2[0];
                i5 = iArr2[1];
            } else {
                i4 = 0;
                i5 = 0;
            }
            if (iArr == null) {
                iArr = getTempNestedScrollConsumed();
            }
            iArr[0] = 0;
            iArr[1] = 0;
            ViewParentCompat.onNestedPreScroll(nestedScrollingParentForType, this.mView, i, i2, iArr, i3);
            if (iArr2 != null) {
                this.mView.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i4;
                iArr2[1] = iArr2[1] - i5;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        }
        return invokeCommon.booleanValue;
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, Integer.valueOf(i5)})) == null) ? dispatchNestedScrollInternal(i, i2, i3, i4, iArr, i5, null) : invokeCommon.booleanValue;
    }

    public boolean hasNestedScrollingParent(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? getNestedScrollingParentForType(i) != null : invokeI.booleanValue;
    }

    public boolean startNestedScroll(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i, i2)) == null) {
            if (hasNestedScrollingParent(i2)) {
                return true;
            }
            if (isNestedScrollingEnabled()) {
                View view2 = this.mView;
                for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
                    if (ViewParentCompat.onStartNestedScroll(parent, view2, this.mView, i, i2)) {
                        setNestedScrollingParentForType(i2, parent);
                        ViewParentCompat.onNestedScrollAccepted(parent, view2, this.mView, i, i2);
                        return true;
                    }
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public void stopNestedScroll(int i) {
        ViewParent nestedScrollingParentForType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i) == null) || (nestedScrollingParentForType = getNestedScrollingParentForType(i)) == null) {
            return;
        }
        ViewParentCompat.onStopNestedScroll(nestedScrollingParentForType, this.mView, i);
        setNestedScrollingParentForType(i, null);
    }

    public void dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, @Nullable int[] iArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, Integer.valueOf(i5), iArr2}) == null) {
            dispatchNestedScrollInternal(i, i2, i3, i4, iArr, i5, iArr2);
        }
    }
}
