package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class OrientationHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_SIZE = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mLastTotalSpace;
    public final RecyclerView.LayoutManager mLayoutManager;
    public final Rect mTmpRect;

    public static OrientationHelper createHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, layoutManager)) == null) ? new OrientationHelper(layoutManager) { // from class: androidx.recyclerview.widget.OrientationHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(layoutManager);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {layoutManager};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((RecyclerView.LayoutManager) objArr2[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedEnd(View view) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, view)) == null) ? this.mLayoutManager.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin : invokeL2.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedMeasurement(View view) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    return this.mLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                return invokeL2.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedMeasurementInOther(View view) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    return this.mLayoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                }
                return invokeL2.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedStart(View view) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, view)) == null) ? this.mLayoutManager.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin : invokeL2.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getEnd() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) ? this.mLayoutManager.getWidth() : invokeV.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getEndAfterPadding() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) ? this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingRight() : invokeV.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getEndPadding() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) ? this.mLayoutManager.getPaddingRight() : invokeV.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getMode() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048583, this)) == null) ? this.mLayoutManager.getWidthMode() : invokeV.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getModeInOther() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mLayoutManager.getHeightMode() : invokeV.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getStartAfterPadding() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) ? this.mLayoutManager.getPaddingLeft() : invokeV.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getTotalSpace() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048586, this)) == null) ? (this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft()) - this.mLayoutManager.getPaddingRight() : invokeV.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getTransformedEndWithDecoration(View view) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, view)) == null) {
                    this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                    return this.mTmpRect.right;
                }
                return invokeL2.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getTransformedStartWithDecoration(View view) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, view)) == null) {
                    this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                    return this.mTmpRect.left;
                }
                return invokeL2.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public void offsetChild(View view, int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048589, this, view, i) == null) {
                    view.offsetLeftAndRight(i);
                }
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public void offsetChildren(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048590, this, i) == null) {
                    this.mLayoutManager.offsetChildrenHorizontal(i);
                }
            }
        } : (OrientationHelper) invokeL.objValue;
    }

    public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager layoutManager, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, layoutManager, i)) == null) {
            if (i != 0) {
                if (i == 1) {
                    return createVerticalHelper(layoutManager);
                }
                throw new IllegalArgumentException("invalid orientation");
            }
            return createHorizontalHelper(layoutManager);
        }
        return (OrientationHelper) invokeLI.objValue;
    }

    public static OrientationHelper createVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, layoutManager)) == null) ? new OrientationHelper(layoutManager) { // from class: androidx.recyclerview.widget.OrientationHelper.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(layoutManager);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {layoutManager};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((RecyclerView.LayoutManager) objArr2[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedEnd(View view) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, view)) == null) ? this.mLayoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin : invokeL2.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedMeasurement(View view) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    return this.mLayoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                }
                return invokeL2.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedMeasurementInOther(View view) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    return this.mLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                return invokeL2.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedStart(View view) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, view)) == null) ? this.mLayoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin : invokeL2.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getEnd() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) ? this.mLayoutManager.getHeight() : invokeV.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getEndAfterPadding() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) ? this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom() : invokeV.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getEndPadding() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) ? this.mLayoutManager.getPaddingBottom() : invokeV.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getMode() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048583, this)) == null) ? this.mLayoutManager.getHeightMode() : invokeV.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getModeInOther() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mLayoutManager.getWidthMode() : invokeV.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getStartAfterPadding() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) ? this.mLayoutManager.getPaddingTop() : invokeV.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getTotalSpace() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048586, this)) == null) ? (this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop()) - this.mLayoutManager.getPaddingBottom() : invokeV.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getTransformedEndWithDecoration(View view) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, view)) == null) {
                    this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                    return this.mTmpRect.bottom;
                }
                return invokeL2.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getTransformedStartWithDecoration(View view) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, view)) == null) {
                    this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                    return this.mTmpRect.top;
                }
                return invokeL2.intValue;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public void offsetChild(View view, int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048589, this, view, i) == null) {
                    view.offsetTopAndBottom(i);
                }
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public void offsetChildren(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048590, this, i) == null) {
                    this.mLayoutManager.offsetChildrenVertical(i);
                }
            }
        } : (OrientationHelper) invokeL.objValue;
    }

    public abstract int getDecoratedEnd(View view);

    public abstract int getDecoratedMeasurement(View view);

    public abstract int getDecoratedMeasurementInOther(View view);

    public abstract int getDecoratedStart(View view);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public RecyclerView.LayoutManager getLayoutManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mLayoutManager : (RecyclerView.LayoutManager) invokeV.objValue;
    }

    public abstract int getMode();

    public abstract int getModeInOther();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public int getTotalSpaceChange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (Integer.MIN_VALUE == this.mLastTotalSpace) {
                return 0;
            }
            return getTotalSpace() - this.mLastTotalSpace;
        }
        return invokeV.intValue;
    }

    public abstract int getTransformedEndWithDecoration(View view);

    public abstract int getTransformedStartWithDecoration(View view);

    public abstract void offsetChild(View view, int i);

    public abstract void offsetChildren(int i);

    public void onLayoutComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mLastTotalSpace = getTotalSpace();
        }
    }

    public OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {layoutManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLastTotalSpace = Integer.MIN_VALUE;
        this.mTmpRect = new Rect();
        this.mLayoutManager = layoutManager;
    }
}
