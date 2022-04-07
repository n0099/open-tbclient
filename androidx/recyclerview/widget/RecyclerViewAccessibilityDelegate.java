package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ItemDelegate mItemDelegate;
    public final RecyclerView mRecyclerView;

    /* loaded from: classes.dex */
    public static class ItemDelegate extends AccessibilityDelegateCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<View, AccessibilityDelegateCompat> mOriginalItemDelegates;
        public final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;

        public ItemDelegate(@NonNull RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recyclerViewAccessibilityDelegate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mOriginalItemDelegates = new WeakHashMap();
            this.mRecyclerViewDelegate = recyclerViewAccessibilityDelegate;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(@NonNull View view2, @NonNull AccessibilityEvent accessibilityEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, accessibilityEvent)) == null) {
                AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view2);
                if (accessibilityDelegateCompat != null) {
                    return accessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(view2, accessibilityEvent);
                }
                return super.dispatchPopulateAccessibilityEvent(view2, accessibilityEvent);
            }
            return invokeLL.booleanValue;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        @Nullable
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
                AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view2);
                if (accessibilityDelegateCompat != null) {
                    return accessibilityDelegateCompat.getAccessibilityNodeProvider(view2);
                }
                return super.getAccessibilityNodeProvider(view2);
            }
            return (AccessibilityNodeProviderCompat) invokeL.objValue;
        }

        public AccessibilityDelegateCompat getAndRemoveOriginalDelegateForItem(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) ? this.mOriginalItemDelegates.remove(view2) : (AccessibilityDelegateCompat) invokeL.objValue;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(@NonNull View view2, @NonNull AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, view2, accessibilityEvent) == null) {
                AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view2);
                if (accessibilityDelegateCompat != null) {
                    accessibilityDelegateCompat.onInitializeAccessibilityEvent(view2, accessibilityEvent);
                } else {
                    super.onInitializeAccessibilityEvent(view2, accessibilityEvent);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, view2, accessibilityNodeInfoCompat) == null) {
                if (!this.mRecyclerViewDelegate.shouldIgnore() && this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() != null) {
                    this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view2, accessibilityNodeInfoCompat);
                    AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view2);
                    if (accessibilityDelegateCompat != null) {
                        accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                        return;
                    } else {
                        super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                        return;
                    }
                }
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(@NonNull View view2, @NonNull AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, view2, accessibilityEvent) == null) {
                AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view2);
                if (accessibilityDelegateCompat != null) {
                    accessibilityDelegateCompat.onPopulateAccessibilityEvent(view2, accessibilityEvent);
                } else {
                    super.onPopulateAccessibilityEvent(view2, accessibilityEvent);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup viewGroup, @NonNull View view2, @NonNull AccessibilityEvent accessibilityEvent) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, viewGroup, view2, accessibilityEvent)) == null) {
                AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(viewGroup);
                if (accessibilityDelegateCompat != null) {
                    return accessibilityDelegateCompat.onRequestSendAccessibilityEvent(viewGroup, view2, accessibilityEvent);
                }
                return super.onRequestSendAccessibilityEvent(viewGroup, view2, accessibilityEvent);
            }
            return invokeLLL.booleanValue;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, view2, i, bundle)) == null) {
                if (!this.mRecyclerViewDelegate.shouldIgnore() && this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() != null) {
                    AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view2);
                    if (accessibilityDelegateCompat != null) {
                        if (accessibilityDelegateCompat.performAccessibilityAction(view2, i, bundle)) {
                            return true;
                        }
                    } else if (super.performAccessibilityAction(view2, i, bundle)) {
                        return true;
                    }
                    return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view2, i, bundle);
                }
                return super.performAccessibilityAction(view2, i, bundle);
            }
            return invokeLIL.booleanValue;
        }

        public void saveOriginalDelegate(View view2) {
            AccessibilityDelegateCompat accessibilityDelegate;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) || (accessibilityDelegate = ViewCompat.getAccessibilityDelegate(view2)) == null || accessibilityDelegate == this) {
                return;
            }
            this.mOriginalItemDelegates.put(view2, accessibilityDelegate);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void sendAccessibilityEvent(@NonNull View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048585, this, view2, i) == null) {
                AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view2);
                if (accessibilityDelegateCompat != null) {
                    accessibilityDelegateCompat.sendAccessibilityEvent(view2, i);
                } else {
                    super.sendAccessibilityEvent(view2, i);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void sendAccessibilityEventUnchecked(@NonNull View view2, @NonNull AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, view2, accessibilityEvent) == null) {
                AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view2);
                if (accessibilityDelegateCompat != null) {
                    accessibilityDelegateCompat.sendAccessibilityEventUnchecked(view2, accessibilityEvent);
                } else {
                    super.sendAccessibilityEventUnchecked(view2, accessibilityEvent);
                }
            }
        }
    }

    public RecyclerViewAccessibilityDelegate(@NonNull RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRecyclerView = recyclerView;
        AccessibilityDelegateCompat itemDelegate = getItemDelegate();
        if (itemDelegate != null && (itemDelegate instanceof ItemDelegate)) {
            this.mItemDelegate = (ItemDelegate) itemDelegate;
        } else {
            this.mItemDelegate = new ItemDelegate(this);
        }
    }

    @NonNull
    public AccessibilityDelegateCompat getItemDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mItemDelegate : (AccessibilityDelegateCompat) invokeV.objValue;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(view2, accessibilityEvent);
            if (!(view2 instanceof RecyclerView) || shouldIgnore()) {
                return;
            }
            RecyclerView recyclerView = (RecyclerView) view2;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, accessibilityNodeInfoCompat) == null) {
            super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
            if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
                return;
            }
            this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, view2, i, bundle)) == null) {
            if (super.performAccessibilityAction(view2, i, bundle)) {
                return true;
            }
            if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
                return false;
            }
            return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i, bundle);
        }
        return invokeLIL.booleanValue;
    }

    public boolean shouldIgnore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRecyclerView.hasPendingAdapterUpdates() : invokeV.booleanValue;
    }
}
