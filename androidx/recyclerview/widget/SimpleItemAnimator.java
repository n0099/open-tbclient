package androidx.recyclerview.widget;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "SimpleItemAnimator";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mSupportsChangeAnimations;

    public abstract boolean animateAdd(RecyclerView.ViewHolder viewHolder);

    public abstract boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4);

    public abstract boolean animateMove(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4);

    public abstract boolean animateRemove(RecyclerView.ViewHolder viewHolder);

    public void onAddFinished(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, viewHolder) == null) {
        }
    }

    public void onAddStarting(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, viewHolder) == null) {
        }
    }

    public void onChangeFinished(RecyclerView.ViewHolder viewHolder, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048596, this, viewHolder, z) == null) {
        }
    }

    public void onChangeStarting(RecyclerView.ViewHolder viewHolder, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, viewHolder, z) == null) {
        }
    }

    public void onMoveFinished(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, viewHolder) == null) {
        }
    }

    public void onMoveStarting(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, viewHolder) == null) {
        }
    }

    public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, viewHolder) == null) {
        }
    }

    public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, viewHolder) == null) {
        }
    }

    public SimpleItemAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSupportsChangeAnimations = true;
    }

    public boolean getSupportsChangeAnimations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mSupportsChangeAnimations;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateAppearance(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder, itemHolderInfo, itemHolderInfo2)) == null) {
            if (itemHolderInfo != null && (itemHolderInfo.left != itemHolderInfo2.left || itemHolderInfo.top != itemHolderInfo2.top)) {
                return animateMove(viewHolder, itemHolderInfo.left, itemHolderInfo.top, itemHolderInfo2.left, itemHolderInfo2.top);
            }
            return animateAdd(viewHolder);
        }
        return invokeLLL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        InterceptResult invokeLLLL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) == null) {
            int i3 = itemHolderInfo.left;
            int i4 = itemHolderInfo.top;
            if (viewHolder2.shouldIgnore()) {
                int i5 = itemHolderInfo.left;
                i2 = itemHolderInfo.top;
                i = i5;
            } else {
                i = itemHolderInfo2.left;
                i2 = itemHolderInfo2.top;
            }
            return animateChange(viewHolder, viewHolder2, i3, i4, i, i2);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateDisappearance(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        InterceptResult invokeLLL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, viewHolder, itemHolderInfo, itemHolderInfo2)) == null) {
            int i3 = itemHolderInfo.left;
            int i4 = itemHolderInfo.top;
            View view2 = viewHolder.itemView;
            if (itemHolderInfo2 == null) {
                i = view2.getLeft();
            } else {
                i = itemHolderInfo2.left;
            }
            int i5 = i;
            if (itemHolderInfo2 == null) {
                i2 = view2.getTop();
            } else {
                i2 = itemHolderInfo2.top;
            }
            int i6 = i2;
            if (!viewHolder.isRemoved() && (i3 != i5 || i4 != i6)) {
                view2.layout(i5, i6, view2.getWidth() + i5, view2.getHeight() + i6);
                return animateMove(viewHolder, i3, i4, i5, i6);
            }
            return animateRemove(viewHolder);
        }
        return invokeLLL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animatePersistence(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, viewHolder, itemHolderInfo, itemHolderInfo2)) == null) {
            if (itemHolderInfo.left == itemHolderInfo2.left && itemHolderInfo.top == itemHolderInfo2.top) {
                dispatchMoveFinished(viewHolder);
                return false;
            }
            return animateMove(viewHolder, itemHolderInfo.left, itemHolderInfo.top, itemHolderInfo2.left, itemHolderInfo2.top);
        }
        return invokeLLL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewHolder)) == null) {
            if (this.mSupportsChangeAnimations && !viewHolder.isInvalid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void dispatchAddFinished(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewHolder) == null) {
            onAddFinished(viewHolder);
            dispatchAnimationFinished(viewHolder);
        }
    }

    public final void dispatchAddStarting(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, viewHolder) == null) {
            onAddStarting(viewHolder);
        }
    }

    public final void dispatchMoveFinished(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, viewHolder) == null) {
            onMoveFinished(viewHolder);
            dispatchAnimationFinished(viewHolder);
        }
    }

    public final void dispatchMoveStarting(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, viewHolder) == null) {
            onMoveStarting(viewHolder);
        }
    }

    public final void dispatchRemoveFinished(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, viewHolder) == null) {
            onRemoveFinished(viewHolder);
            dispatchAnimationFinished(viewHolder);
        }
    }

    public final void dispatchRemoveStarting(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, viewHolder) == null) {
            onRemoveStarting(viewHolder);
        }
    }

    public void setSupportsChangeAnimations(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.mSupportsChangeAnimations = z;
        }
    }

    public final void dispatchChangeFinished(RecyclerView.ViewHolder viewHolder, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, viewHolder, z) == null) {
            onChangeFinished(viewHolder, z);
            dispatchAnimationFinished(viewHolder);
        }
    }

    public final void dispatchChangeStarting(RecyclerView.ViewHolder viewHolder, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, viewHolder, z) == null) {
            onChangeStarting(viewHolder, z);
        }
    }
}
