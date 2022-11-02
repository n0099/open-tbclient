package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    public static final Rect INVALID_PARENT_BOUNDS;
    public static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER;
    public static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAccessibilityFocusedVirtualViewId;
    public final View mHost;
    public int mHoveredVirtualViewId;
    public int mKeyboardFocusedVirtualViewId;
    public final AccessibilityManager mManager;
    public MyNodeProvider mNodeProvider;
    public final int[] mTempGlobalRect;
    public final Rect mTempParentRect;
    public final Rect mTempScreenRect;
    public final Rect mTempVisibleRect;

    public static int keyToDirection(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i)) == null) {
            if (i != 19) {
                if (i != 21) {
                    return i != 22 ? 130 : 66;
                }
                return 17;
            }
            return 33;
        }
        return invokeI.intValue;
    }

    public abstract int getVirtualViewAt(float f, float f2);

    public abstract void getVisibleVirtualViews(List<Integer> list);

    public abstract boolean onPerformActionForVirtualView(int i, int i2, @Nullable Bundle bundle);

    public void onPopulateEventForHost(@NonNull AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, accessibilityEvent) == null) {
        }
    }

    public void onPopulateEventForVirtualView(int i, @NonNull AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, accessibilityEvent) == null) {
        }
    }

    public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, accessibilityNodeInfoCompat) == null) {
        }
    }

    public abstract void onPopulateNodeForVirtualView(int i, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
        }
    }

    /* loaded from: classes.dex */
    public class MyNodeProvider extends AccessibilityNodeProviderCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExploreByTouchHelper this$0;

        public MyNodeProvider(ExploreByTouchHelper exploreByTouchHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {exploreByTouchHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = exploreByTouchHelper;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return AccessibilityNodeInfoCompat.obtain(this.this$0.obtainAccessibilityNodeInfo(i));
            }
            return (AccessibilityNodeInfoCompat) invokeI.objValue;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i) {
            InterceptResult invokeI;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                if (i == 2) {
                    i2 = this.this$0.mAccessibilityFocusedVirtualViewId;
                } else {
                    i2 = this.this$0.mKeyboardFocusedVirtualViewId;
                }
                if (i2 == Integer.MIN_VALUE) {
                    return null;
                }
                return createAccessibilityNodeInfo(i2);
            }
            return (AccessibilityNodeInfoCompat) invokeI.objValue;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i, int i2, Bundle bundle) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, bundle)) == null) {
                return this.this$0.performAction(i, i2, bundle);
            }
            return invokeIIL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-409569844, "Landroidx/customview/widget/ExploreByTouchHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-409569844, "Landroidx/customview/widget/ExploreByTouchHelper;");
                return;
            }
        }
        INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        NODE_ADAPTER = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.customview.widget.FocusStrategy.BoundsAdapter
            public void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, accessibilityNodeInfoCompat, rect) == null) {
                    accessibilityNodeInfoCompat.getBoundsInParent(rect);
                }
            }
        };
        SPARSE_VALUES_ADAPTER = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
            public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, sparseArrayCompat, i)) == null) {
                    return sparseArrayCompat.valueAt(i);
                }
                return (AccessibilityNodeInfoCompat) invokeLI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
            public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, sparseArrayCompat)) == null) {
                    return sparseArrayCompat.size();
                }
                return invokeL.intValue;
            }
        };
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            ArrayList arrayList = new ArrayList();
            getVisibleVirtualViews(arrayList);
            SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
            for (int i = 0; i < arrayList.size(); i++) {
                sparseArrayCompat.put(arrayList.get(i).intValue(), createNodeForChild(arrayList.get(i).intValue()));
            }
            return sparseArrayCompat;
        }
        return (SparseArrayCompat) invokeV.objValue;
    }

    public ExploreByTouchHelper(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTempScreenRect = new Rect();
        this.mTempParentRect = new Rect();
        this.mTempVisibleRect = new Rect();
        this.mTempGlobalRect = new int[2];
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHoveredVirtualViewId = Integer.MIN_VALUE;
        if (view2 != null) {
            this.mHost = view2;
            this.mManager = (AccessibilityManager) view2.getContext().getSystemService("accessibility");
            view2.setFocusable(true);
            if (ViewCompat.getImportantForAccessibility(view2) == 0) {
                ViewCompat.setImportantForAccessibility(view2, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    public final boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, keyEvent)) == null) {
            int i = 0;
            if (keyEvent.getAction() == 1) {
                return false;
            }
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (!keyEvent.hasNoModifiers()) {
                                return false;
                            }
                            int keyToDirection = keyToDirection(keyCode);
                            int repeatCount = keyEvent.getRepeatCount() + 1;
                            boolean z = false;
                            while (i < repeatCount && moveFocus(keyToDirection, null)) {
                                i++;
                                z = true;
                            }
                            return z;
                        case 23:
                            break;
                        default:
                            return false;
                    }
                }
                if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                    return false;
                }
                clickKeyboardFocusedVirtualView();
                return true;
            } else if (keyEvent.hasNoModifiers()) {
                return moveFocus(2, null);
            } else {
                if (!keyEvent.hasModifiers(1)) {
                    return false;
                }
                return moveFocus(1, null);
            }
        }
        return invokeL.booleanValue;
    }

    private boolean clearAccessibilityFocus(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            if (this.mAccessibilityFocusedVirtualViewId == i) {
                this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
                this.mHost.invalidate();
                sendEventForVirtualView(i, 65536);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    private AccessibilityEvent createEventForHost(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i)) == null) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
            this.mHost.onInitializeAccessibilityEvent(obtain);
            return obtain;
        }
        return (AccessibilityEvent) invokeI.objValue;
    }

    private void updateHoveredVirtualView(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65554, this, i) != null) || (i2 = this.mHoveredVirtualViewId) == i) {
            return;
        }
        this.mHoveredVirtualViewId = i;
        sendEventForVirtualView(i, 128);
        sendEventForVirtualView(i2, 256);
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (this.mKeyboardFocusedVirtualViewId != i) {
                return false;
            }
            this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
            onVirtualViewKeyboardFocusChanged(i, false);
            sendEventForVirtualView(i, 8);
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            if (this.mNodeProvider == null) {
                this.mNodeProvider = new MyNodeProvider(this);
            }
            return this.mNodeProvider;
        }
        return (AccessibilityNodeProviderCompat) invokeL.objValue;
    }

    public final void invalidateVirtualView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            invalidateVirtualView(i, 0);
        }
    }

    @NonNull
    public AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (i == -1) {
                return createNodeForHost();
            }
            return createNodeForChild(i);
        }
        return (AccessibilityNodeInfoCompat) invokeI.objValue;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int i = this.mKeyboardFocusedVirtualViewId;
            if (i != Integer.MIN_VALUE && onPerformActionForVirtualView(i, 16, null)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mAccessibilityFocusedVirtualViewId;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return getAccessibilityFocusedVirtualViewId();
        }
        return invokeV.intValue;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mKeyboardFocusedVirtualViewId;
        }
        return invokeV.intValue;
    }

    public final void invalidateRoot() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            invalidateVirtualView(-1, 1);
        }
    }

    private AccessibilityEvent createEvent(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i, i2)) == null) {
            if (i != -1) {
                return createEventForChild(i, i2);
            }
            return createEventForHost(i2);
        }
        return (AccessibilityEvent) invokeII.objValue;
    }

    private void getBoundsInParent(int i, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65546, this, i, rect) == null) {
            obtainAccessibilityNodeInfo(i).getBoundsInParent(rect);
        }
    }

    private boolean performActionForHost(int i, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65552, this, i, bundle)) == null) {
            return ViewCompat.performAccessibilityAction(this.mHost, i, bundle);
        }
        return invokeIL.booleanValue;
    }

    public final void invalidateVirtualView(int i, int i2) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) && i != Integer.MIN_VALUE && this.mManager.isEnabled() && (parent = this.mHost.getParent()) != null) {
            AccessibilityEvent createEvent = createEvent(i, 2048);
            AccessibilityEventCompat.setContentChangeTypes(createEvent, i2);
            parent.requestSendAccessibilityEvent(this.mHost, createEvent);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, view2, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(view2, accessibilityEvent);
            onPopulateEventForHost(accessibilityEvent);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view2, accessibilityNodeInfoCompat) == null) {
            super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
            onPopulateNodeForHost(accessibilityNodeInfoCompat);
        }
    }

    private AccessibilityEvent createEventForChild(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, this, i, i2)) == null) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
            AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
            obtain.getText().add(obtainAccessibilityNodeInfo.getText());
            obtain.setContentDescription(obtainAccessibilityNodeInfo.getContentDescription());
            obtain.setScrollable(obtainAccessibilityNodeInfo.isScrollable());
            obtain.setPassword(obtainAccessibilityNodeInfo.isPassword());
            obtain.setEnabled(obtainAccessibilityNodeInfo.isEnabled());
            obtain.setChecked(obtainAccessibilityNodeInfo.isChecked());
            onPopulateEventForVirtualView(i, obtain);
            if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            obtain.setClassName(obtainAccessibilityNodeInfo.getClassName());
            AccessibilityRecordCompat.setSource(obtain, this.mHost, i);
            obtain.setPackageName(this.mHost.getContext().getPackageName());
            return obtain;
        }
        return (AccessibilityEvent) invokeII.objValue;
    }

    private boolean moveFocus(int i, @Nullable Rect rect) {
        InterceptResult invokeIL;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        boolean z;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65550, this, i, rect)) == null) {
            SparseArrayCompat<AccessibilityNodeInfoCompat> allNodes = getAllNodes();
            int i2 = this.mKeyboardFocusedVirtualViewId;
            int i3 = Integer.MIN_VALUE;
            if (i2 == Integer.MIN_VALUE) {
                accessibilityNodeInfoCompat = null;
            } else {
                accessibilityNodeInfoCompat = allNodes.get(i2);
            }
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = accessibilityNodeInfoCompat;
            if (i != 1 && i != 2) {
                if (i != 17 && i != 33 && i != 66 && i != 130) {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                Rect rect2 = new Rect();
                int i4 = this.mKeyboardFocusedVirtualViewId;
                if (i4 != Integer.MIN_VALUE) {
                    getBoundsInParent(i4, rect2);
                } else if (rect != null) {
                    rect2.set(rect);
                } else {
                    guessPreviouslyFocusedRect(this.mHost, i, rect2);
                }
                accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInAbsoluteDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat3, rect2, i);
            } else {
                if (ViewCompat.getLayoutDirection(this.mHost) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInRelativeDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat3, i, z, false);
            }
            if (accessibilityNodeInfoCompat2 != null) {
                i3 = allNodes.keyAt(allNodes.indexOfValue(accessibilityNodeInfoCompat2));
            }
            return requestKeyboardFocusForVirtualView(i3);
        }
        return invokeIL.booleanValue;
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForChild(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
            obtain.setEnabled(true);
            obtain.setFocusable(true);
            obtain.setClassName("android.view.View");
            obtain.setBoundsInParent(INVALID_PARENT_BOUNDS);
            obtain.setBoundsInScreen(INVALID_PARENT_BOUNDS);
            obtain.setParent(this.mHost);
            onPopulateNodeForVirtualView(i, obtain);
            if (obtain.getText() == null && obtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
            }
            obtain.getBoundsInParent(this.mTempParentRect);
            if (!this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
                int actions = obtain.getActions();
                if ((actions & 64) == 0) {
                    if ((actions & 128) == 0) {
                        obtain.setPackageName(this.mHost.getContext().getPackageName());
                        obtain.setSource(this.mHost, i);
                        if (this.mAccessibilityFocusedVirtualViewId == i) {
                            obtain.setAccessibilityFocused(true);
                            obtain.addAction(128);
                        } else {
                            obtain.setAccessibilityFocused(false);
                            obtain.addAction(64);
                        }
                        if (this.mKeyboardFocusedVirtualViewId == i) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            obtain.addAction(2);
                        } else if (obtain.isFocusable()) {
                            obtain.addAction(1);
                        }
                        obtain.setFocused(z);
                        this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                        obtain.getBoundsInScreen(this.mTempScreenRect);
                        if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
                            obtain.getBoundsInParent(this.mTempScreenRect);
                            if (obtain.mParentVirtualDescendantId != -1) {
                                AccessibilityNodeInfoCompat obtain2 = AccessibilityNodeInfoCompat.obtain();
                                for (int i2 = obtain.mParentVirtualDescendantId; i2 != -1; i2 = obtain2.mParentVirtualDescendantId) {
                                    obtain2.setParent(this.mHost, -1);
                                    obtain2.setBoundsInParent(INVALID_PARENT_BOUNDS);
                                    onPopulateNodeForVirtualView(i2, obtain2);
                                    obtain2.getBoundsInParent(this.mTempParentRect);
                                    Rect rect = this.mTempScreenRect;
                                    Rect rect2 = this.mTempParentRect;
                                    rect.offset(rect2.left, rect2.top);
                                }
                                obtain2.recycle();
                            }
                            this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                        }
                        if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                            this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                            if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                                obtain.setBoundsInScreen(this.mTempScreenRect);
                                if (isVisibleToUser(this.mTempScreenRect)) {
                                    obtain.setVisibleToUser(true);
                                }
                            }
                        }
                        return obtain;
                    }
                    throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
                }
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        return (AccessibilityNodeInfoCompat) invokeI.objValue;
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.mHost);
            ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, obtain);
            ArrayList arrayList = new ArrayList();
            getVisibleVirtualViews(arrayList);
            if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
                throw new RuntimeException("Views cannot have both real and virtual children");
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                obtain.addChild(this.mHost, ((Integer) arrayList.get(i)).intValue());
            }
            return obtain;
        }
        return (AccessibilityNodeInfoCompat) invokeV.objValue;
    }

    public static Rect guessPreviouslyFocusedRect(@NonNull View view2, int i, @NonNull Rect rect) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65547, null, view2, i, rect)) == null) {
            int width = view2.getWidth();
            int height = view2.getHeight();
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i == 130) {
                            rect.set(0, -1, width, -1);
                        } else {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    } else {
                        rect.set(-1, 0, -1, height);
                    }
                } else {
                    rect.set(0, height, width, height);
                }
            } else {
                rect.set(width, 0, width, height);
            }
            return rect;
        }
        return (Rect) invokeLIL.objValue;
    }

    private boolean isVisibleToUser(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, rect)) == null) {
            if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
                return false;
            }
            ViewParent parent = this.mHost.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                if (view2.getAlpha() <= 0.0f || view2.getVisibility() != 0) {
                    return false;
                }
                parent = view2.getParent();
            }
            if (parent == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7 && action != 9) {
                if (action != 10 || this.mHoveredVirtualViewId == Integer.MIN_VALUE) {
                    return false;
                }
                updateHoveredVirtualView(Integer.MIN_VALUE);
                return true;
            }
            int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            updateHoveredVirtualView(virtualViewAt);
            if (virtualViewAt == Integer.MIN_VALUE) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean performActionForChild(int i, int i2, Bundle bundle) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65551, this, i, i2, bundle)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 64) {
                        if (i2 != 128) {
                            return onPerformActionForVirtualView(i, i2, bundle);
                        }
                        return clearAccessibilityFocus(i);
                    }
                    return requestAccessibilityFocus(i);
                }
                return clearKeyboardFocusForVirtualView(i);
            }
            return requestKeyboardFocusForVirtualView(i);
        }
        return invokeIIL.booleanValue;
    }

    public final void onFocusChanged(boolean z, int i, @Nullable Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), rect}) == null) {
            int i2 = this.mKeyboardFocusedVirtualViewId;
            if (i2 != Integer.MIN_VALUE) {
                clearKeyboardFocusForVirtualView(i2);
            }
            if (z) {
                moveFocus(i, rect);
            }
        }
    }

    private boolean requestAccessibilityFocus(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65553, this, i)) == null) {
            if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || (i2 = this.mAccessibilityFocusedVirtualViewId) == i) {
                return false;
            }
            if (i2 != Integer.MIN_VALUE) {
                clearAccessibilityFocus(i2);
            }
            this.mAccessibilityFocusedVirtualViewId = i;
            this.mHost.invalidate();
            sendEventForVirtualView(i, 32768);
            return true;
        }
        return invokeI.booleanValue;
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i2 = this.mKeyboardFocusedVirtualViewId) == i) {
                return false;
            }
            if (i2 != Integer.MIN_VALUE) {
                clearKeyboardFocusForVirtualView(i2);
            }
            if (i == Integer.MIN_VALUE) {
                return false;
            }
            this.mKeyboardFocusedVirtualViewId = i;
            onVirtualViewKeyboardFocusChanged(i, true);
            sendEventForVirtualView(i, 8);
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048598, this, i, i2, bundle)) == null) {
            if (i != -1) {
                return performActionForChild(i, i2, bundle);
            }
            return performActionForHost(i2, bundle);
        }
        return invokeIIL.booleanValue;
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        InterceptResult invokeII;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048600, this, i, i2)) == null) {
            if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
                return false;
            }
            return parent.requestSendAccessibilityEvent(this.mHost, createEvent(i, i2));
        }
        return invokeII.booleanValue;
    }
}
