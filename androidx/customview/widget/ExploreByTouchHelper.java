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
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.mobads.container.util.AdIconUtil;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = exploreByTouchHelper;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? AccessibilityNodeInfoCompat.obtain(this.this$0.obtainAccessibilityNodeInfo(i2)) : (AccessibilityNodeInfoCompat) invokeI.objValue;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                int i3 = i2 == 2 ? this.this$0.mAccessibilityFocusedVirtualViewId : this.this$0.mKeyboardFocusedVirtualViewId;
                if (i3 == Integer.MIN_VALUE) {
                    return null;
                }
                return createAccessibilityNodeInfo(i3);
            }
            return (AccessibilityNodeInfoCompat) invokeI.objValue;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i2, int i3, Bundle bundle) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, bundle)) == null) ? this.this$0.performAction(i2, i3, bundle) : invokeIIL.booleanValue;
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
            public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, sparseArrayCompat, i2)) == null) ? sparseArrayCompat.valueAt(i2) : (AccessibilityNodeInfoCompat) invokeLI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
            public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, sparseArrayCompat)) == null) ? sparseArrayCompat.size() : invokeL.intValue;
            }
        };
    }

    public ExploreByTouchHelper(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            if (this.mAccessibilityFocusedVirtualViewId == i2) {
                this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
                this.mHost.invalidate();
                sendEventForVirtualView(i2, 65536);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int i2 = this.mKeyboardFocusedVirtualViewId;
            return i2 != Integer.MIN_VALUE && onPerformActionForVirtualView(i2, 16, null);
        }
        return invokeV.booleanValue;
    }

    private AccessibilityEvent createEvent(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65540, this, i2, i3)) == null) {
            if (i2 != -1) {
                return createEventForChild(i2, i3);
            }
            return createEventForHost(i3);
        }
        return (AccessibilityEvent) invokeII.objValue;
    }

    private AccessibilityEvent createEventForChild(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, this, i2, i3)) == null) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
            AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i2);
            obtain.getText().add(obtainAccessibilityNodeInfo.getText());
            obtain.setContentDescription(obtainAccessibilityNodeInfo.getContentDescription());
            obtain.setScrollable(obtainAccessibilityNodeInfo.isScrollable());
            obtain.setPassword(obtainAccessibilityNodeInfo.isPassword());
            obtain.setEnabled(obtainAccessibilityNodeInfo.isEnabled());
            obtain.setChecked(obtainAccessibilityNodeInfo.isChecked());
            onPopulateEventForVirtualView(i2, obtain);
            if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            obtain.setClassName(obtainAccessibilityNodeInfo.getClassName());
            AccessibilityRecordCompat.setSource(obtain, this.mHost, i2);
            obtain.setPackageName(this.mHost.getContext().getPackageName());
            return obtain;
        }
        return (AccessibilityEvent) invokeII.objValue;
    }

    private AccessibilityEvent createEventForHost(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2)) == null) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
            this.mHost.onInitializeAccessibilityEvent(obtain);
            return obtain;
        }
        return (AccessibilityEvent) invokeI.objValue;
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForChild(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
            obtain.setEnabled(true);
            obtain.setFocusable(true);
            obtain.setClassName("android.view.View");
            obtain.setBoundsInParent(INVALID_PARENT_BOUNDS);
            obtain.setBoundsInScreen(INVALID_PARENT_BOUNDS);
            obtain.setParent(this.mHost);
            onPopulateNodeForVirtualView(i2, obtain);
            if (obtain.getText() == null && obtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
            }
            obtain.getBoundsInParent(this.mTempParentRect);
            if (!this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
                int actions = obtain.getActions();
                if ((actions & 64) == 0) {
                    if ((actions & 128) == 0) {
                        obtain.setPackageName(this.mHost.getContext().getPackageName());
                        obtain.setSource(this.mHost, i2);
                        if (this.mAccessibilityFocusedVirtualViewId == i2) {
                            obtain.setAccessibilityFocused(true);
                            obtain.addAction(128);
                        } else {
                            obtain.setAccessibilityFocused(false);
                            obtain.addAction(64);
                        }
                        boolean z = this.mKeyboardFocusedVirtualViewId == i2;
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
                                for (int i3 = obtain.mParentVirtualDescendantId; i3 != -1; i3 = obtain2.mParentVirtualDescendantId) {
                                    obtain2.setParent(this.mHost, -1);
                                    obtain2.setBoundsInParent(INVALID_PARENT_BOUNDS);
                                    onPopulateNodeForVirtualView(i3, obtain2);
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
            for (int i2 = 0; i2 < size; i2++) {
                obtain.addChild(this.mHost, ((Integer) arrayList.get(i2)).intValue());
            }
            return obtain;
        }
        return (AccessibilityNodeInfoCompat) invokeV.objValue;
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            ArrayList arrayList = new ArrayList();
            getVisibleVirtualViews(arrayList);
            SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sparseArrayCompat.put(arrayList.get(i2).intValue(), createNodeForChild(arrayList.get(i2).intValue()));
            }
            return sparseArrayCompat;
        }
        return (SparseArrayCompat) invokeV.objValue;
    }

    private void getBoundsInParent(int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65546, this, i2, rect) == null) {
            obtainAccessibilityNodeInfo(i2).getBoundsInParent(rect);
        }
    }

    public static Rect guessPreviouslyFocusedRect(@NonNull View view, int i2, @NonNull Rect rect) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65547, null, view, i2, rect)) == null) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (i2 == 17) {
                rect.set(width, 0, width, height);
            } else if (i2 == 33) {
                rect.set(0, height, width, height);
            } else if (i2 == 66) {
                rect.set(-1, 0, -1, height);
            } else if (i2 == 130) {
                rect.set(0, -1, width, -1);
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
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
                View view = (View) parent;
                if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                    return false;
                }
                parent = view.getParent();
            }
            return parent != null;
        }
        return invokeL.booleanValue;
    }

    public static int keyToDirection(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i2)) == null) {
            if (i2 != 19) {
                if (i2 != 21) {
                    if (i2 != 22) {
                        return IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER;
                    }
                    return 66;
                }
                return 17;
            }
            return 33;
        }
        return invokeI.intValue;
    }

    private boolean moveFocus(int i2, @Nullable Rect rect) {
        InterceptResult invokeIL;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65550, this, i2, rect)) == null) {
            SparseArrayCompat<AccessibilityNodeInfoCompat> allNodes = getAllNodes();
            int i3 = this.mKeyboardFocusedVirtualViewId;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = i3 == Integer.MIN_VALUE ? null : allNodes.get(i3);
            if (i2 == 1 || i2 == 2) {
                accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInRelativeDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat2, i2, ViewCompat.getLayoutDirection(this.mHost) == 1, false);
            } else if (i2 != 17 && i2 != 33 && i2 != 66 && i2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            } else {
                Rect rect2 = new Rect();
                int i4 = this.mKeyboardFocusedVirtualViewId;
                if (i4 != Integer.MIN_VALUE) {
                    getBoundsInParent(i4, rect2);
                } else if (rect != null) {
                    rect2.set(rect);
                } else {
                    guessPreviouslyFocusedRect(this.mHost, i2, rect2);
                }
                accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInAbsoluteDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat2, rect2, i2);
            }
            return requestKeyboardFocusForVirtualView(accessibilityNodeInfoCompat != null ? allNodes.keyAt(allNodes.indexOfValue(accessibilityNodeInfoCompat)) : Integer.MIN_VALUE);
        }
        return invokeIL.booleanValue;
    }

    private boolean performActionForChild(int i2, int i3, Bundle bundle) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65551, this, i2, i3, bundle)) == null) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 64) {
                        if (i3 != 128) {
                            return onPerformActionForVirtualView(i2, i3, bundle);
                        }
                        return clearAccessibilityFocus(i2);
                    }
                    return requestAccessibilityFocus(i2);
                }
                return clearKeyboardFocusForVirtualView(i2);
            }
            return requestKeyboardFocusForVirtualView(i2);
        }
        return invokeIIL.booleanValue;
    }

    private boolean performActionForHost(int i2, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65552, this, i2, bundle)) == null) ? ViewCompat.performAccessibilityAction(this.mHost, i2, bundle) : invokeIL.booleanValue;
    }

    private boolean requestAccessibilityFocus(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65553, this, i2)) == null) {
            if (this.mManager.isEnabled() && this.mManager.isTouchExplorationEnabled() && (i3 = this.mAccessibilityFocusedVirtualViewId) != i2) {
                if (i3 != Integer.MIN_VALUE) {
                    clearAccessibilityFocus(i3);
                }
                this.mAccessibilityFocusedVirtualViewId = i2;
                this.mHost.invalidate();
                sendEventForVirtualView(i2, 32768);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    private void updateHoveredVirtualView(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65554, this, i2) == null) || (i3 = this.mHoveredVirtualViewId) == i2) {
            return;
        }
        this.mHoveredVirtualViewId = i2;
        sendEventForVirtualView(i2, 128);
        sendEventForVirtualView(i3, 256);
    }

    public final boolean clearKeyboardFocusForVirtualView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.mKeyboardFocusedVirtualViewId != i2) {
                return false;
            }
            this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
            onVirtualViewKeyboardFocusChanged(i2, false);
            sendEventForVirtualView(i2, 8);
            return true;
        }
        return invokeI.booleanValue;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (this.mManager.isEnabled() && this.mManager.isTouchExplorationEnabled()) {
                int action = motionEvent.getAction();
                if (action != 7 && action != 9) {
                    if (action == 10 && this.mHoveredVirtualViewId != Integer.MIN_VALUE) {
                        updateHoveredVirtualView(Integer.MIN_VALUE);
                        return true;
                    }
                    return false;
                }
                int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
                updateHoveredVirtualView(virtualViewAt);
                return virtualViewAt != Integer.MIN_VALUE;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, keyEvent)) == null) {
            int i2 = 0;
            if (keyEvent.getAction() != 1) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 61) {
                    if (keyCode != 66) {
                        switch (keyCode) {
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                                if (keyEvent.hasNoModifiers()) {
                                    int keyToDirection = keyToDirection(keyCode);
                                    int repeatCount = keyEvent.getRepeatCount() + 1;
                                    boolean z = false;
                                    while (i2 < repeatCount && moveFocus(keyToDirection, null)) {
                                        i2++;
                                        z = true;
                                    }
                                    return z;
                                }
                                return false;
                            case 23:
                                break;
                            default:
                                return false;
                        }
                    }
                    if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                        clickKeyboardFocusedVirtualView();
                        return true;
                    }
                    return false;
                } else if (keyEvent.hasNoModifiers()) {
                    return moveFocus(2, null);
                } else {
                    if (keyEvent.hasModifiers(1)) {
                        return moveFocus(1, null);
                    }
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAccessibilityFocusedVirtualViewId : invokeV.intValue;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            if (this.mNodeProvider == null) {
                this.mNodeProvider = new MyNodeProvider(this);
            }
            return this.mNodeProvider;
        }
        return (AccessibilityNodeProviderCompat) invokeL.objValue;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getAccessibilityFocusedVirtualViewId() : invokeV.intValue;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mKeyboardFocusedVirtualViewId : invokeV.intValue;
    }

    public abstract int getVirtualViewAt(float f2, float f3);

    public abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateRoot() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            invalidateVirtualView(-1, 1);
        }
    }

    public final void invalidateVirtualView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            invalidateVirtualView(i2, 0);
        }
    }

    @NonNull
    public AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            if (i2 == -1) {
                return createNodeForHost();
            }
            return createNodeForChild(i2);
        }
        return (AccessibilityNodeInfoCompat) invokeI.objValue;
    }

    public final void onFocusChanged(boolean z, int i2, @Nullable Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), rect}) == null) {
            int i3 = this.mKeyboardFocusedVirtualViewId;
            if (i3 != Integer.MIN_VALUE) {
                clearKeyboardFocusForVirtualView(i3);
            }
            if (z) {
                moveFocus(i2, rect);
            }
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, view, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            onPopulateEventForHost(accessibilityEvent);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view, accessibilityNodeInfoCompat) == null) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            onPopulateNodeForHost(accessibilityNodeInfoCompat);
        }
    }

    public abstract boolean onPerformActionForVirtualView(int i2, int i3, @Nullable Bundle bundle);

    public void onPopulateEventForHost(@NonNull AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, accessibilityEvent) == null) {
        }
    }

    public void onPopulateEventForVirtualView(int i2, @NonNull AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, accessibilityEvent) == null) {
        }
    }

    public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, accessibilityNodeInfoCompat) == null) {
        }
    }

    public abstract void onPopulateNodeForVirtualView(int i2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public void onVirtualViewKeyboardFocusChanged(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
        }
    }

    public boolean performAction(int i2, int i3, Bundle bundle) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048598, this, i2, i3, bundle)) == null) {
            if (i2 != -1) {
                return performActionForChild(i2, i3, bundle);
            }
            return performActionForHost(i3, bundle);
        }
        return invokeIIL.booleanValue;
    }

    public final boolean requestKeyboardFocusForVirtualView(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            if ((this.mHost.isFocused() || this.mHost.requestFocus()) && (i3 = this.mKeyboardFocusedVirtualViewId) != i2) {
                if (i3 != Integer.MIN_VALUE) {
                    clearKeyboardFocusForVirtualView(i3);
                }
                if (i2 == Integer.MIN_VALUE) {
                    return false;
                }
                this.mKeyboardFocusedVirtualViewId = i2;
                onVirtualViewKeyboardFocusChanged(i2, true);
                sendEventForVirtualView(i2, 8);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final boolean sendEventForVirtualView(int i2, int i3) {
        InterceptResult invokeII;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048600, this, i2, i3)) == null) {
            if (i2 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
                return false;
            }
            return parent.requestSendAccessibilityEvent(this.mHost, createEvent(i2, i3));
        }
        return invokeII.booleanValue;
    }

    public final void invalidateVirtualView(int i2, int i3) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) || i2 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return;
        }
        AccessibilityEvent createEvent = createEvent(i2, 2048);
        AccessibilityEventCompat.setContentChangeTypes(createEvent, i3);
        parent.requestSendAccessibilityEvent(this.mHost, createEvent);
    }
}
