package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ViewCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;
    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;
    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    @Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;
    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;
    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;
    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    public static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    public static boolean sAccessibilityDelegateCheckFailed;
    public static Field sAccessibilityDelegateField;
    public static AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager;
    public static Method sChildrenDrawingOrderMethod;
    public static Method sDispatchFinishTemporaryDetach;
    public static Method sDispatchStartTemporaryDetach;
    public static Field sMinHeightField;
    public static boolean sMinHeightFieldFetched;
    public static Field sMinWidthField;
    public static boolean sMinWidthFieldFetched;
    public static final AtomicInteger sNextGeneratedId;
    public static boolean sTempDetachBound;
    public static ThreadLocal<Rect> sThreadLocalRect;
    public static WeakHashMap<View, String> sTransitionNameMap;
    public static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap;
    public transient /* synthetic */ FieldHolder $fh;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface NestedScrollType {
    }

    /* loaded from: classes.dex */
    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ScrollIndicators {
    }

    /* loaded from: classes.dex */
    public static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakHashMap<View, Boolean> mPanesToVisible;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            }
        }

        public AccessibilityPaneVisibilityManager() {
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
            this.mPanesToVisible = new WeakHashMap<>();
        }

        @RequiresApi(19)
        private void checkPaneVisibility(View view2, boolean z) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65537, this, view2, z) == null) {
                if (view2.getVisibility() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z != z2) {
                    if (z2) {
                        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view2, 16);
                    }
                    this.mPanesToVisible.put(view2, Boolean.valueOf(z2));
                }
            }
        }

        @RequiresApi(19)
        private void registerForLayoutCallback(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, view2) == null) {
                view2.getViewTreeObserver().addOnGlobalLayoutListener(this);
            }
        }

        @RequiresApi(19)
        private void unregisterForLayoutCallback(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, view2) == null) {
                view2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }

        @RequiresApi(19)
        public void addAccessibilityPane(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                WeakHashMap<View, Boolean> weakHashMap = this.mPanesToVisible;
                if (view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                weakHashMap.put(view2, Boolean.valueOf(z));
                view2.addOnAttachStateChangeListener(this);
                if (view2.isAttachedToWindow()) {
                    registerForLayoutCallback(view2);
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        @RequiresApi(19)
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
                registerForLayoutCallback(view2);
            }
        }

        @RequiresApi(19)
        public void removeAccessibilityPane(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
                this.mPanesToVisible.remove(view2);
                view2.removeOnAttachStateChangeListener(this);
                unregisterForLayoutCallback(view2);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(19)
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (Map.Entry<View, Boolean> entry : this.mPanesToVisible.entrySet()) {
                    checkPaneVisibility(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AccessibilityViewProperty<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mFrameworkMinimumSdk;
        public final int mTagKey;
        public final Class<T> mType;

        public abstract T frameworkGet(View view2);

        public abstract void frameworkSet(View view2, T t);

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AccessibilityViewProperty(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), cls, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), (Class) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public AccessibilityViewProperty(int i, Class<T> cls, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), cls, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mTagKey = i;
            this.mType = cls;
            this.mFrameworkMinimumSdk = i3;
        }

        private boolean extrasAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        private boolean frameworkAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                if (Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean booleanNullToFalseEquals(Boolean bool, Boolean bool2) {
            InterceptResult invokeLL;
            boolean booleanValue;
            boolean booleanValue2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bool, bool2)) == null) {
                if (bool == null) {
                    booleanValue = false;
                } else {
                    booleanValue = bool.booleanValue();
                }
                if (bool2 == null) {
                    booleanValue2 = false;
                } else {
                    booleanValue2 = bool2.booleanValue();
                }
                if (booleanValue != booleanValue2) {
                    return false;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        public boolean shouldUpdate(T t, T t2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, t, t2)) == null) {
                return !t2.equals(t);
            }
            return invokeLL.booleanValue;
        }

        public T get(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
                if (frameworkAvailable()) {
                    return frameworkGet(view2);
                }
                if (extrasAvailable()) {
                    T t = (T) view2.getTag(this.mTagKey);
                    if (this.mType.isInstance(t)) {
                        return t;
                    }
                    return null;
                }
                return null;
            }
            return (T) invokeL.objValue;
        }

        public void set(View view2, T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, view2, t) == null) {
                if (frameworkAvailable()) {
                    frameworkSet(view2, t);
                } else if (extrasAvailable() && shouldUpdate(get(view2), t)) {
                    ViewCompat.getOrCreateAccessibilityDelegateCompat(view2);
                    view2.setTag(this.mTagKey, t);
                    ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view2, 0);
                }
            }
        }
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class Api21Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api21Impl() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view2, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, view2, windowInsetsCompat, rect)) == null) {
                WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
                if (windowInsets != null) {
                    return WindowInsetsCompat.toWindowInsetsCompat(view2.computeSystemWindowInsets(windowInsets, rect));
                }
                rect.setEmpty();
                return windowInsetsCompat;
            }
            return (WindowInsetsCompat) invokeLLL.objValue;
        }
    }

    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static class Api23Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api23Impl() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static WindowInsets getRootWindowInsets(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                return view2.getRootWindowInsets();
            }
            return (WindowInsets) invokeL.objValue;
        }
    }

    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static class Api29Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api29Impl() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static void saveAttributeDataForStyleable(@NonNull View view2, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{view2, context, iArr, attributeSet, typedArray, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
                view2.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class UnhandledKeyEventManager {
        public static /* synthetic */ Interceptable $ic;
        public static final ArrayList<WeakReference<View>> sViewsWithListeners;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<WeakReference<View>> mCapturedKeys;
        public WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent;
        @Nullable
        public WeakHashMap<View, Boolean> mViewsContainingListeners;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1085867875, "Landroidx/core/view/ViewCompat$UnhandledKeyEventManager;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1085867875, "Landroidx/core/view/ViewCompat$UnhandledKeyEventManager;");
                    return;
                }
            }
            sViewsWithListeners = new ArrayList<>();
        }

        public UnhandledKeyEventManager() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mViewsContainingListeners = null;
            this.mCapturedKeys = null;
            this.mLastDispatchedPreViewKeyEvent = null;
        }

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                if (this.mCapturedKeys == null) {
                    this.mCapturedKeys = new SparseArray<>();
                }
                return this.mCapturedKeys;
            }
            return (SparseArray) invokeV.objValue;
        }

        public static UnhandledKeyEventManager at(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
                UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view2.getTag(R.id.obfuscated_res_0x7f0920e8);
                if (unhandledKeyEventManager == null) {
                    UnhandledKeyEventManager unhandledKeyEventManager2 = new UnhandledKeyEventManager();
                    view2.setTag(R.id.obfuscated_res_0x7f0920e8, unhandledKeyEventManager2);
                    return unhandledKeyEventManager2;
                }
                return unhandledKeyEventManager;
            }
            return (UnhandledKeyEventManager) invokeL.objValue;
        }

        @Nullable
        private View dispatchInOrder(View view2, KeyEvent keyEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, view2, keyEvent)) == null) {
                WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
                if (weakHashMap != null && weakHashMap.containsKey(view2)) {
                    if (view2 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view2;
                        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                            View dispatchInOrder = dispatchInOrder(viewGroup.getChildAt(childCount), keyEvent);
                            if (dispatchInOrder != null) {
                                return dispatchInOrder;
                            }
                        }
                    }
                    if (onUnhandledKeyEvent(view2, keyEvent)) {
                        return view2;
                    }
                }
                return null;
            }
            return (View) invokeLL.objValue;
        }

        private boolean onUnhandledKeyEvent(@NonNull View view2, @NonNull KeyEvent keyEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, view2, keyEvent)) == null) {
                ArrayList arrayList = (ArrayList) view2.getTag(R.id.obfuscated_res_0x7f0920e9);
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view2, keyEvent)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public boolean dispatch(View view2, KeyEvent keyEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, keyEvent)) == null) {
                if (keyEvent.getAction() == 0) {
                    recalcViewsWithUnhandled();
                }
                View dispatchInOrder = dispatchInOrder(view2, keyEvent);
                if (keyEvent.getAction() == 0) {
                    int keyCode = keyEvent.getKeyCode();
                    if (dispatchInOrder != null && !KeyEvent.isModifierKey(keyCode)) {
                        getCapturedKeys().put(keyCode, new WeakReference<>(dispatchInOrder));
                    }
                }
                if (dispatchInOrder != null) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        private void recalcViewsWithUnhandled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65542, this) == null) {
                WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
                if (weakHashMap != null) {
                    weakHashMap.clear();
                }
                if (sViewsWithListeners.isEmpty()) {
                    return;
                }
                synchronized (sViewsWithListeners) {
                    if (this.mViewsContainingListeners == null) {
                        this.mViewsContainingListeners = new WeakHashMap<>();
                    }
                    for (int size = sViewsWithListeners.size() - 1; size >= 0; size--) {
                        View view2 = sViewsWithListeners.get(size).get();
                        if (view2 == null) {
                            sViewsWithListeners.remove(size);
                        } else {
                            this.mViewsContainingListeners.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.mViewsContainingListeners.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        public static void registerListeningView(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65543, null, view2) == null) {
                synchronized (sViewsWithListeners) {
                    Iterator<WeakReference<View>> it = sViewsWithListeners.iterator();
                    while (it.hasNext()) {
                        if (it.next().get() == view2) {
                            return;
                        }
                    }
                    sViewsWithListeners.add(new WeakReference<>(view2));
                }
            }
        }

        public static void unregisterListeningView(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65544, null, view2) == null) {
                synchronized (sViewsWithListeners) {
                    for (int i = 0; i < sViewsWithListeners.size(); i++) {
                        if (sViewsWithListeners.get(i).get() == view2) {
                            sViewsWithListeners.remove(i);
                            return;
                        }
                    }
                }
            }
        }

        public boolean preDispatch(KeyEvent keyEvent) {
            InterceptResult invokeL;
            int indexOfKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) {
                WeakReference<KeyEvent> weakReference = this.mLastDispatchedPreViewKeyEvent;
                if (weakReference != null && weakReference.get() == keyEvent) {
                    return false;
                }
                this.mLastDispatchedPreViewKeyEvent = new WeakReference<>(keyEvent);
                WeakReference<View> weakReference2 = null;
                SparseArray<WeakReference<View>> capturedKeys = getCapturedKeys();
                if (keyEvent.getAction() == 1 && (indexOfKey = capturedKeys.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference2 = capturedKeys.valueAt(indexOfKey);
                    capturedKeys.removeAt(indexOfKey);
                }
                if (weakReference2 == null) {
                    weakReference2 = capturedKeys.get(keyEvent.getKeyCode());
                }
                if (weakReference2 == null) {
                    return false;
                }
                View view2 = weakReference2.get();
                if (view2 != null && ViewCompat.isAttachedToWindow(view2)) {
                    onUnhandledKeyEvent(view2, keyEvent);
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-742349792, "Landroidx/core/view/ViewCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-742349792, "Landroidx/core/view/ViewCompat;");
                return;
            }
        }
        sNextGeneratedId = new AtomicInteger(1);
        sViewPropertyAnimatorMap = null;
        sAccessibilityDelegateCheckFailed = false;
        ACCESSIBILITY_ACTIONS_RESOURCE_IDS = new int[]{R.id.obfuscated_res_0x7f090031, R.id.obfuscated_res_0x7f090032, R.id.obfuscated_res_0x7f09003d, R.id.obfuscated_res_0x7f090048, R.id.obfuscated_res_0x7f09004b, R.id.obfuscated_res_0x7f09004c, R.id.obfuscated_res_0x7f09004d, R.id.obfuscated_res_0x7f09004e, R.id.obfuscated_res_0x7f09004f, R.id.obfuscated_res_0x7f090050, R.id.obfuscated_res_0x7f090033, R.id.obfuscated_res_0x7f090034, R.id.obfuscated_res_0x7f090035, R.id.obfuscated_res_0x7f090036, R.id.obfuscated_res_0x7f090037, R.id.obfuscated_res_0x7f090038, R.id.obfuscated_res_0x7f090039, R.id.obfuscated_res_0x7f09003a, R.id.obfuscated_res_0x7f09003b, R.id.obfuscated_res_0x7f09003c, R.id.obfuscated_res_0x7f09003e, R.id.obfuscated_res_0x7f09003f, R.id.obfuscated_res_0x7f090040, R.id.obfuscated_res_0x7f090041, R.id.obfuscated_res_0x7f090042, R.id.obfuscated_res_0x7f090043, R.id.obfuscated_res_0x7f090044, R.id.obfuscated_res_0x7f090045, R.id.obfuscated_res_0x7f090046, R.id.obfuscated_res_0x7f090047, R.id.obfuscated_res_0x7f090049, R.id.obfuscated_res_0x7f09004a};
        sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    }

    public ViewCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new AccessibilityViewProperty<Boolean>(R.id.obfuscated_res_0x7f09208e, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, r11);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(r9), r10, Integer.valueOf(r11)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Integer) objArr2[0]).intValue(), (Class) objArr2[1], ((Integer) objArr2[2]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
                @RequiresApi(28)
                public Boolean frameworkGet(View view2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) {
                        return Boolean.valueOf(view2.isAccessibilityHeading());
                    }
                    return (Boolean) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
                @RequiresApi(28)
                public void frameworkSet(View view2, Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, bool) == null) {
                        view2.setAccessibilityHeading(bool.booleanValue());
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
                public boolean shouldUpdate(Boolean bool, Boolean bool2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048580, this, bool, bool2)) == null) {
                        return !booleanNullToFalseEquals(bool, bool2);
                    }
                    return invokeLL.booleanValue;
                }
            };
        }
        return (AccessibilityViewProperty) invokeV.objValue;
    }

    public static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65646, null)) == null) {
            return new AccessibilityViewProperty<CharSequence>(R.id.obfuscated_res_0x7f09208f, CharSequence.class, 8, 28) { // from class: androidx.core.view.ViewCompat.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r10, r11, r12, r13);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(r10), r11, Integer.valueOf(r12), Integer.valueOf(r13)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Integer) objArr2[0]).intValue(), (Class) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
                @RequiresApi(28)
                public CharSequence frameworkGet(View view2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) {
                        return view2.getAccessibilityPaneTitle();
                    }
                    return (CharSequence) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
                @RequiresApi(28)
                public void frameworkSet(View view2, CharSequence charSequence) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, charSequence) == null) {
                        view2.setAccessibilityPaneTitle(charSequence);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
                public boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048580, this, charSequence, charSequence2)) == null) {
                        return !TextUtils.equals(charSequence, charSequence2);
                    }
                    return invokeLL.booleanValue;
                }
            };
        }
        return (AccessibilityViewProperty) invokeV.objValue;
    }

    public static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65661, null)) == null) {
            return new AccessibilityViewProperty<Boolean>(R.id.obfuscated_res_0x7f0920d8, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, r11);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(r9), r10, Integer.valueOf(r11)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Integer) objArr2[0]).intValue(), (Class) objArr2[1], ((Integer) objArr2[2]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
                @RequiresApi(28)
                public Boolean frameworkGet(View view2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) {
                        return Boolean.valueOf(view2.isScreenReaderFocusable());
                    }
                    return (Boolean) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
                @RequiresApi(28)
                public void frameworkSet(View view2, Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, bool) == null) {
                        view2.setScreenReaderFocusable(bool.booleanValue());
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
                public boolean shouldUpdate(Boolean bool, Boolean bool2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048580, this, bool, bool2)) == null) {
                        return !booleanNullToFalseEquals(bool, bool2);
                    }
                    return invokeLL.booleanValue;
                }
            };
        }
        return (AccessibilityViewProperty) invokeV.objValue;
    }

    public static int addAccessibilityAction(@NonNull View view2, @NonNull CharSequence charSequence, @NonNull AccessibilityViewCommand accessibilityViewCommand) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, view2, charSequence, accessibilityViewCommand)) == null) {
            int availableActionIdFromResources = getAvailableActionIdFromResources(view2);
            if (availableActionIdFromResources != -1) {
                addAccessibilityAction(view2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(availableActionIdFromResources, charSequence, accessibilityViewCommand));
            }
            return availableActionIdFromResources;
        }
        return invokeLLL.intValue;
    }

    public static void addKeyboardNavigationClusters(@NonNull View view2, @NonNull Collection<View> collection, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65541, null, view2, collection, i) == null) && Build.VERSION.SDK_INT >= 26) {
            view2.addKeyboardNavigationClusters(collection, i);
        }
    }

    @NonNull
    public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view2, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, view2, windowInsetsCompat, rect)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return Api21Impl.computeSystemWindowInsets(view2, windowInsetsCompat, rect);
            }
            return windowInsetsCompat;
        }
        return (WindowInsetsCompat) invokeLLL.objValue;
    }

    public static View keyboardNavigationClusterSearch(@NonNull View view2, View view3, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65638, null, view2, view3, i)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view2.keyboardNavigationClusterSearch(view3, i);
            }
            return null;
        }
        return (View) invokeLLI.objValue;
    }

    public static boolean performAccessibilityAction(@NonNull View view2, int i, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65647, null, view2, i, bundle)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view2.performAccessibilityAction(i, bundle);
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    @Deprecated
    public static int resolveSizeAndState(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65658, null, i, i2, i3)) == null) {
            return View.resolveSizeAndState(i, i2, i3);
        }
        return invokeIII.intValue;
    }

    @Deprecated
    public static void setLayerType(View view2, int i, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65683, null, view2, i, paint) == null) {
            view2.setLayerType(i, paint);
        }
    }

    public static void setScrollIndicators(@NonNull View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65701, null, view2, i, i2) == null) && Build.VERSION.SDK_INT >= 23) {
            view2.setScrollIndicators(i, i2);
        }
    }

    public static boolean startNestedScroll(@NonNull View view2, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65713, null, view2, i, i2)) == null) {
            if (view2 instanceof NestedScrollingChild2) {
                return ((NestedScrollingChild2) view2).startNestedScroll(i, i2);
            }
            if (i2 == 0) {
                return startNestedScroll(view2, i);
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    public static void addAccessibilityAction(@NonNull View view2, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2, accessibilityActionCompat) == null) && Build.VERSION.SDK_INT >= 21) {
            getOrCreateAccessibilityDelegateCompat(view2);
            removeActionWithId(accessibilityActionCompat.getId(), view2);
            getActionList(view2).add(accessibilityActionCompat);
            notifyViewAccessibilityStateChangedIfNeeded(view2, 0);
        }
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, view2, i)) == null) {
            return view2.canScrollHorizontally(i);
        }
        return invokeLI.booleanValue;
    }

    @Deprecated
    public static boolean canScrollVertically(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, view2, i)) == null) {
            return view2.canScrollVertically(i);
        }
        return invokeLI.booleanValue;
    }

    @Deprecated
    public static int combineMeasuredStates(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65548, null, i, i2)) == null) {
            return View.combineMeasuredStates(i, i2);
        }
        return invokeII.intValue;
    }

    public static void compatOffsetLeftAndRight(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, view2, i) == null) {
            view2.offsetLeftAndRight(i);
            if (view2.getVisibility() == 0) {
                tickleInvalidationFlag(view2);
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    tickleInvalidationFlag((View) parent);
                }
            }
        }
    }

    public static void compatOffsetTopAndBottom(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, view2, i) == null) {
            view2.offsetTopAndBottom(i);
            if (view2.getVisibility() == 0) {
                tickleInvalidationFlag(view2);
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    tickleInvalidationFlag((View) parent);
                }
            }
        }
    }

    @NonNull
    public static WindowInsetsCompat dispatchApplyWindowInsets(@NonNull View view2, @NonNull WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeLL;
        WindowInsets windowInsets;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, view2, windowInsetsCompat)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && (windowInsets = windowInsetsCompat.toWindowInsets()) != null && !view2.dispatchApplyWindowInsets(windowInsets).equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
            }
            return windowInsetsCompat;
        }
        return (WindowInsetsCompat) invokeLL.objValue;
    }

    @UiThread
    public static boolean dispatchUnhandledKeyEventBeforeCallback(View view2, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, view2, keyEvent)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return false;
            }
            return UnhandledKeyEventManager.at(view2).dispatch(view2, keyEvent);
        }
        return invokeLL.booleanValue;
    }

    @UiThread
    public static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view2, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, view2, keyEvent)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return false;
            }
            return UnhandledKeyEventManager.at(view2).preDispatch(keyEvent);
        }
        return invokeLL.booleanValue;
    }

    public static boolean hasNestedScrollingParent(@NonNull View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65620, null, view2, i)) == null) {
            if (view2 instanceof NestedScrollingChild2) {
                ((NestedScrollingChild2) view2).hasNestedScrollingParent(i);
                return false;
            } else if (i == 0) {
                return hasNestedScrollingParent(view2);
            } else {
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    @NonNull
    public static WindowInsetsCompat onApplyWindowInsets(@NonNull View view2, @NonNull WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeLL;
        WindowInsets windowInsets;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65642, null, view2, windowInsetsCompat)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && (windowInsets = windowInsetsCompat.toWindowInsets()) != null) {
                WindowInsets onApplyWindowInsets = view2.onApplyWindowInsets(windowInsets);
                if (!onApplyWindowInsets.equals(windowInsets)) {
                    return WindowInsetsCompat.toWindowInsetsCompat(onApplyWindowInsets);
                }
            }
            return windowInsetsCompat;
        }
        return (WindowInsetsCompat) invokeLL.objValue;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65643, null, view2, accessibilityEvent) == null) {
            view2.onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    public static void onInitializeAccessibilityNodeInfo(@NonNull View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65644, null, view2, accessibilityNodeInfoCompat) == null) {
            view2.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
        }
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65645, null, view2, accessibilityEvent) == null) {
            view2.onPopulateAccessibilityEvent(accessibilityEvent);
        }
    }

    public static void postOnAnimation(@NonNull View view2, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65650, null, view2, runnable) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view2.postOnAnimation(runnable);
            } else {
                view2.postDelayed(runnable, ValueAnimator.getFrameDelay());
            }
        }
    }

    public static void removeAccessibilityAction(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65652, null, view2, i) == null) && Build.VERSION.SDK_INT >= 21) {
            removeActionWithId(i, view2);
            notifyViewAccessibilityStateChangedIfNeeded(view2, 0);
        }
    }

    public static void removeActionWithId(int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65653, null, i, view2) == null) {
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view2);
            for (int i2 = 0; i2 < actionList.size(); i2++) {
                if (actionList.get(i2).getId() == i) {
                    actionList.remove(i2);
                    return;
                }
            }
        }
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull View view2, @IdRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65657, null, view2, i)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return (T) view2.requireViewById(i);
            }
            T t = (T) view2.findViewById(i);
            if (t != null) {
                return t;
            }
            throw new IllegalArgumentException("ID does not reference a View inside this View");
        }
        return (T) invokeLI.objValue;
    }

    public static void setAccessibilityDelegate(@NonNull View view2, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        View.AccessibilityDelegate bridge;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65662, null, view2, accessibilityDelegateCompat) == null) {
            if (accessibilityDelegateCompat == null && (getAccessibilityDelegateInternal(view2) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
                accessibilityDelegateCompat = new AccessibilityDelegateCompat();
            }
            if (accessibilityDelegateCompat == null) {
                bridge = null;
            } else {
                bridge = accessibilityDelegateCompat.getBridge();
            }
            view2.setAccessibilityDelegate(bridge);
        }
    }

    @UiThread
    public static void setAccessibilityHeading(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65663, null, view2, z) == null) {
            accessibilityHeadingProperty().set(view2, Boolean.valueOf(z));
        }
    }

    public static void setAccessibilityLiveRegion(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65664, null, view2, i) == null) && Build.VERSION.SDK_INT >= 19) {
            view2.setAccessibilityLiveRegion(i);
        }
    }

    @UiThread
    public static void setAccessibilityPaneTitle(View view2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65665, null, view2, charSequence) == null) && Build.VERSION.SDK_INT >= 19) {
            paneTitleProperty().set(view2, charSequence);
            if (charSequence != null) {
                sAccessibilityPaneVisibilityManager.addAccessibilityPane(view2);
            } else {
                sAccessibilityPaneVisibilityManager.removeAccessibilityPane(view2);
            }
        }
    }

    @Deprecated
    public static void setActivated(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65666, null, view2, z) == null) {
            view2.setActivated(z);
        }
    }

    @Deprecated
    public static void setAlpha(View view2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65667, null, view2, f) == null) {
            view2.setAlpha(f);
        }
    }

    public static void setAutofillHints(@NonNull View view2, @Nullable String... strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65668, null, view2, strArr) == null) && Build.VERSION.SDK_INT >= 26) {
            view2.setAutofillHints(strArr);
        }
    }

    public static void setBackground(@NonNull View view2, @Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65669, null, view2, drawable) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view2.setBackground(drawable);
            } else {
                view2.setBackgroundDrawable(drawable);
            }
        }
    }

    public static void setClipBounds(@NonNull View view2, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65673, null, view2, rect) == null) && Build.VERSION.SDK_INT >= 18) {
            view2.setClipBounds(rect);
        }
    }

    public static void setElevation(@NonNull View view2, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(65674, null, view2, f) == null) && Build.VERSION.SDK_INT >= 21) {
            view2.setElevation(f);
        }
    }

    @Deprecated
    public static void setFitsSystemWindows(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65675, null, view2, z) == null) {
            view2.setFitsSystemWindows(z);
        }
    }

    public static void setFocusedByDefault(@NonNull View view2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65676, null, view2, z) == null) && Build.VERSION.SDK_INT >= 26) {
            view2.setFocusedByDefault(z);
        }
    }

    public static void setHasTransientState(@NonNull View view2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65677, null, view2, z) == null) && Build.VERSION.SDK_INT >= 16) {
            view2.setHasTransientState(z);
        }
    }

    public static void setImportantForAccessibility(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65678, null, view2, i) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 19) {
                view2.setImportantForAccessibility(i);
            } else if (i2 >= 16) {
                if (i == 4) {
                    i = 2;
                }
                view2.setImportantForAccessibility(i);
            }
        }
    }

    public static void setImportantForAutofill(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65679, null, view2, i) == null) && Build.VERSION.SDK_INT >= 26) {
            view2.setImportantForAutofill(i);
        }
    }

    public static void setKeyboardNavigationCluster(@NonNull View view2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65680, null, view2, z) == null) && Build.VERSION.SDK_INT >= 26) {
            view2.setKeyboardNavigationCluster(z);
        }
    }

    public static void setLabelFor(@NonNull View view2, @IdRes int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65681, null, view2, i) == null) && Build.VERSION.SDK_INT >= 17) {
            view2.setLabelFor(i);
        }
    }

    public static void setLayerPaint(@NonNull View view2, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65682, null, view2, paint) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                view2.setLayerPaint(paint);
                return;
            }
            view2.setLayerType(view2.getLayerType(), paint);
            view2.invalidate();
        }
    }

    public static void setLayoutDirection(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65684, null, view2, i) == null) && Build.VERSION.SDK_INT >= 17) {
            view2.setLayoutDirection(i);
        }
    }

    public static void setNestedScrollingEnabled(@NonNull View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65685, null, view2, z) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                view2.setNestedScrollingEnabled(z);
            } else if (view2 instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view2).setNestedScrollingEnabled(z);
            }
        }
    }

    public static void setNextClusterForwardId(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65686, null, view2, i) == null) && Build.VERSION.SDK_INT >= 26) {
            view2.setNextClusterForwardId(i);
        }
    }

    public static void setOnApplyWindowInsetsListener(@NonNull View view2, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65687, null, view2, onApplyWindowInsetsListener) == null) && Build.VERSION.SDK_INT >= 21) {
            if (onApplyWindowInsetsListener == null) {
                view2.setOnApplyWindowInsetsListener(null);
            } else {
                view2.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(onApplyWindowInsetsListener) { // from class: androidx.core.view.ViewCompat.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OnApplyWindowInsetsListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {onApplyWindowInsetsListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$listener = onApplyWindowInsetsListener;
                    }

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view3, WindowInsets windowInsets) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, windowInsets)) == null) {
                            return this.val$listener.onApplyWindowInsets(view3, WindowInsetsCompat.toWindowInsetsCompat(windowInsets)).toWindowInsets();
                        }
                        return (WindowInsets) invokeLL.objValue;
                    }
                });
            }
        }
    }

    @Deprecated
    public static void setOverScrollMode(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65688, null, view2, i) == null) {
            view2.setOverScrollMode(i);
        }
    }

    @Deprecated
    public static void setPivotX(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65690, null, view2, f) == null) {
            view2.setPivotX(f);
        }
    }

    @Deprecated
    public static void setPivotY(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65691, null, view2, f) == null) {
            view2.setPivotY(f);
        }
    }

    public static void setPointerIcon(@NonNull View view2, PointerIconCompat pointerIconCompat) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65692, null, view2, pointerIconCompat) == null) && Build.VERSION.SDK_INT >= 24) {
            if (pointerIconCompat != null) {
                obj = pointerIconCompat.getPointerIcon();
            } else {
                obj = null;
            }
            view2.setPointerIcon((PointerIcon) obj);
        }
    }

    @Deprecated
    public static void setRotation(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65693, null, view2, f) == null) {
            view2.setRotation(f);
        }
    }

    @Deprecated
    public static void setRotationX(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65694, null, view2, f) == null) {
            view2.setRotationX(f);
        }
    }

    @Deprecated
    public static void setRotationY(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65695, null, view2, f) == null) {
            view2.setRotationY(f);
        }
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65696, null, view2, z) == null) {
            view2.setSaveFromParentEnabled(z);
        }
    }

    @Deprecated
    public static void setScaleX(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65697, null, view2, f) == null) {
            view2.setScaleX(f);
        }
    }

    @Deprecated
    public static void setScaleY(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65698, null, view2, f) == null) {
            view2.setScaleY(f);
        }
    }

    @UiThread
    public static void setScreenReaderFocusable(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65699, null, view2, z) == null) {
            screenReaderFocusableProperty().set(view2, Boolean.valueOf(z));
        }
    }

    public static void setScrollIndicators(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65700, null, view2, i) == null) && Build.VERSION.SDK_INT >= 23) {
            view2.setScrollIndicators(i);
        }
    }

    public static void setSystemGestureExclusionRects(@NonNull View view2, @NonNull List<Rect> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65702, null, view2, list) == null) && Build.VERSION.SDK_INT >= 29) {
            view2.setSystemGestureExclusionRects(list);
        }
    }

    public static void setTooltipText(@NonNull View view2, @Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65703, null, view2, charSequence) == null) && Build.VERSION.SDK_INT >= 26) {
            view2.setTooltipText(charSequence);
        }
    }

    public static void setTransitionName(@NonNull View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65704, null, view2, str) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                view2.setTransitionName(str);
                return;
            }
            if (sTransitionNameMap == null) {
                sTransitionNameMap = new WeakHashMap<>();
            }
            sTransitionNameMap.put(view2, str);
        }
    }

    @Deprecated
    public static void setTranslationX(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65705, null, view2, f) == null) {
            view2.setTranslationX(f);
        }
    }

    @Deprecated
    public static void setTranslationY(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65706, null, view2, f) == null) {
            view2.setTranslationY(f);
        }
    }

    public static void setTranslationZ(@NonNull View view2, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(65707, null, view2, f) == null) && Build.VERSION.SDK_INT >= 21) {
            view2.setTranslationZ(f);
        }
    }

    @Deprecated
    public static void setX(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65708, null, view2, f) == null) {
            view2.setX(f);
        }
    }

    @Deprecated
    public static void setY(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65709, null, view2, f) == null) {
            view2.setY(f);
        }
    }

    public static void setZ(@NonNull View view2, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(65710, null, view2, f) == null) && Build.VERSION.SDK_INT >= 21) {
            view2.setZ(f);
        }
    }

    public static boolean startNestedScroll(@NonNull View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65712, null, view2, i)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.startNestedScroll(i);
            }
            if (view2 instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view2).startNestedScroll(i);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void stopNestedScroll(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65715, null, view2, i) == null) {
            if (view2 instanceof NestedScrollingChild2) {
                ((NestedScrollingChild2) view2).stopNestedScroll(i);
            } else if (i == 0) {
                stopNestedScroll(view2);
            }
        }
    }

    public static void updateDragShadow(@NonNull View view2, View.DragShadowBuilder dragShadowBuilder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65717, null, view2, dragShadowBuilder) == null) && Build.VERSION.SDK_INT >= 24) {
            view2.updateDragShadow(dragShadowBuilder);
        }
    }

    public static void addOnUnhandledKeyEventListener(@NonNull View view2, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, view2, onUnhandledKeyEventListenerCompat) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view2.getTag(R.id.obfuscated_res_0x7f0920e9);
                if (simpleArrayMap == null) {
                    simpleArrayMap = new SimpleArrayMap();
                    view2.setTag(R.id.obfuscated_res_0x7f0920e9, simpleArrayMap);
                }
                View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener(onUnhandledKeyEventListenerCompat) { // from class: androidx.core.view.ViewCompat.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OnUnhandledKeyEventListenerCompat val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {onUnhandledKeyEventListenerCompat};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$listener = onUnhandledKeyEventListenerCompat;
                    }

                    @Override // android.view.View.OnUnhandledKeyEventListener
                    public boolean onUnhandledKeyEvent(View view3, KeyEvent keyEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, keyEvent)) == null) {
                            return this.val$listener.onUnhandledKeyEvent(view3, keyEvent);
                        }
                        return invokeLL.booleanValue;
                    }
                };
                simpleArrayMap.put(onUnhandledKeyEventListenerCompat, onUnhandledKeyEventListener);
                view2.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
                return;
            }
            ArrayList arrayList = (ArrayList) view2.getTag(R.id.obfuscated_res_0x7f0920e9);
            if (arrayList == null) {
                arrayList = new ArrayList();
                view2.setTag(R.id.obfuscated_res_0x7f0920e9, arrayList);
            }
            arrayList.add(onUnhandledKeyEventListenerCompat);
            if (arrayList.size() == 1) {
                UnhandledKeyEventManager.registerListeningView(view2);
            }
        }
    }

    public static void setBackgroundTintList(@NonNull View view2, ColorStateList colorStateList) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65670, null, view2, colorStateList) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                view2.setBackgroundTintList(colorStateList);
                if (Build.VERSION.SDK_INT == 21) {
                    Drawable background = view2.getBackground();
                    if (view2.getBackgroundTintList() == null && view2.getBackgroundTintMode() == null) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (background != null && z) {
                        if (background.isStateful()) {
                            background.setState(view2.getDrawableState());
                        }
                        view2.setBackground(background);
                    }
                }
            } else if (view2 instanceof TintableBackgroundView) {
                ((TintableBackgroundView) view2).setSupportBackgroundTintList(colorStateList);
            }
        }
    }

    public static void setBackgroundTintMode(@NonNull View view2, PorterDuff.Mode mode) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65671, null, view2, mode) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                view2.setBackgroundTintMode(mode);
                if (Build.VERSION.SDK_INT == 21) {
                    Drawable background = view2.getBackground();
                    if (view2.getBackgroundTintList() == null && view2.getBackgroundTintMode() == null) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (background != null && z) {
                        if (background.isStateful()) {
                            background.setState(view2.getDrawableState());
                        }
                        view2.setBackground(background);
                    }
                }
            } else if (view2 instanceof TintableBackgroundView) {
                ((TintableBackgroundView) view2).setSupportBackgroundTintMode(mode);
            }
        }
    }

    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65672, null, viewGroup, z) == null) {
            if (sChildrenDrawingOrderMethod == null) {
                try {
                    sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e) {
                    Log.e(TAG, "Unable to find childrenDrawingOrderEnabled", e);
                }
                sChildrenDrawingOrderMethod.setAccessible(true);
            }
            try {
                sChildrenDrawingOrderMethod.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e2) {
                Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e2);
            } catch (IllegalArgumentException e3) {
                Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e3);
            } catch (InvocationTargetException e4) {
                Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e4);
            }
        }
    }

    @NonNull
    public static ViewPropertyAnimatorCompat animate(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view2)) == null) {
            if (sViewPropertyAnimatorMap == null) {
                sViewPropertyAnimatorMap = new WeakHashMap<>();
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = sViewPropertyAnimatorMap.get(view2);
            if (viewPropertyAnimatorCompat == null) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view2);
                sViewPropertyAnimatorMap.put(view2, viewPropertyAnimatorCompat2);
                return viewPropertyAnimatorCompat2;
            }
            return viewPropertyAnimatorCompat;
        }
        return (ViewPropertyAnimatorCompat) invokeL.objValue;
    }

    public static void dispatchFinishTemporaryDetach(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, view2) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                view2.dispatchFinishTemporaryDetach();
                return;
            }
            if (!sTempDetachBound) {
                bindTempDetach();
            }
            Method method = sDispatchFinishTemporaryDetach;
            if (method != null) {
                try {
                    method.invoke(view2, new Object[0]);
                    return;
                } catch (Exception e) {
                    Log.d(TAG, "Error calling dispatchFinishTemporaryDetach", e);
                    return;
                }
            }
            view2.onFinishTemporaryDetach();
        }
    }

    public static void dispatchStartTemporaryDetach(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, view2) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                view2.dispatchStartTemporaryDetach();
                return;
            }
            if (!sTempDetachBound) {
                bindTempDetach();
            }
            Method method = sDispatchStartTemporaryDetach;
            if (method != null) {
                try {
                    method.invoke(view2, new Object[0]);
                    return;
                } catch (Exception e) {
                    Log.d(TAG, "Error calling dispatchStartTemporaryDetach", e);
                    return;
                }
            }
            view2.onStartTemporaryDetach();
        }
    }

    @Nullable
    public static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, view2)) == null) {
            if (sAccessibilityDelegateCheckFailed) {
                return null;
            }
            if (sAccessibilityDelegateField == null) {
                try {
                    Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                    sAccessibilityDelegateField = declaredField;
                    declaredField.setAccessible(true);
                } catch (Throwable unused) {
                    sAccessibilityDelegateCheckFailed = true;
                    return null;
                }
            }
            try {
                Object obj = sAccessibilityDelegateField.get(view2);
                if (!(obj instanceof View.AccessibilityDelegate)) {
                    return null;
                }
                return (View.AccessibilityDelegate) obj;
            } catch (Throwable unused2) {
                sAccessibilityDelegateCheckFailed = true;
                return null;
            }
        }
        return (View.AccessibilityDelegate) invokeL.objValue;
    }

    @Nullable
    public static Display getDisplay(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return view2.getDisplay();
            }
            if (isAttachedToWindow(view2)) {
                return ((WindowManager) view2.getContext().getSystemService("window")).getDefaultDisplay();
            }
            return null;
        }
        return (Display) invokeL.objValue;
    }

    public static int getMinimumHeight(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view2.getMinimumHeight();
            }
            if (!sMinHeightFieldFetched) {
                try {
                    Field declaredField = View.class.getDeclaredField("mMinHeight");
                    sMinHeightField = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                sMinHeightFieldFetched = true;
            }
            Field field = sMinHeightField;
            if (field != null) {
                try {
                    return ((Integer) field.get(view2)).intValue();
                } catch (Exception unused2) {
                    return 0;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getMinimumWidth(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view2.getMinimumWidth();
            }
            if (!sMinWidthFieldFetched) {
                try {
                    Field declaredField = View.class.getDeclaredField("mMinWidth");
                    sMinWidthField = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                sMinWidthFieldFetched = true;
            }
            Field field = sMinWidthField;
            if (field != null) {
                try {
                    return ((Integer) field.get(view2)).intValue();
                } catch (Exception unused2) {
                    return 0;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void bindTempDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            try {
                sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
                sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
            } catch (NoSuchMethodException e) {
                Log.e(TAG, "Couldn't find method", e);
            }
            sTempDetachBound = true;
        }
    }

    public static int generateViewId() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return View.generateViewId();
            }
            do {
                i = sNextGeneratedId.get();
                i2 = i + 1;
                if (i2 > 16777215) {
                    i2 = 1;
                }
            } while (!sNextGeneratedId.compareAndSet(i, i2));
            return i;
        }
        return invokeV.intValue;
    }

    public static Rect getEmptyTempRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            if (sThreadLocalRect == null) {
                sThreadLocalRect = new ThreadLocal<>();
            }
            Rect rect = sThreadLocalRect.get();
            if (rect == null) {
                rect = new Rect();
                sThreadLocalRect.set(rect);
            }
            rect.setEmpty();
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public static void cancelDragAndDrop(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, view2) == null) && Build.VERSION.SDK_INT >= 24) {
            view2.cancelDragAndDrop();
        }
    }

    public static void enableAccessibleClickableSpanSupport(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, null, view2) == null) && Build.VERSION.SDK_INT >= 19) {
            getOrCreateAccessibilityDelegateCompat(view2);
        }
    }

    @Nullable
    public static AccessibilityDelegateCompat getAccessibilityDelegate(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, view2)) == null) {
            View.AccessibilityDelegate accessibilityDelegateInternal = getAccessibilityDelegateInternal(view2);
            if (accessibilityDelegateInternal == null) {
                return null;
            }
            if (accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
                return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat;
            }
            return new AccessibilityDelegateCompat(accessibilityDelegateInternal);
        }
        return (AccessibilityDelegateCompat) invokeL.objValue;
    }

    @Nullable
    public static View.AccessibilityDelegate getAccessibilityDelegateInternal(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return view2.getAccessibilityDelegate();
            }
            return getAccessibilityDelegateThroughReflection(view2);
        }
        return (View.AccessibilityDelegate) invokeL.objValue;
    }

    public static int getAccessibilityLiveRegion(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return view2.getAccessibilityLiveRegion();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View view2) {
        InterceptResult invokeL;
        AccessibilityNodeProvider accessibilityNodeProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 16 && (accessibilityNodeProvider = view2.getAccessibilityNodeProvider()) != null) {
                return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
            }
            return null;
        }
        return (AccessibilityNodeProviderCompat) invokeL.objValue;
    }

    @UiThread
    public static CharSequence getAccessibilityPaneTitle(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, view2)) == null) {
            return paneTitleProperty().get(view2);
        }
        return (CharSequence) invokeL.objValue;
    }

    public static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, view2)) == null) {
            ArrayList arrayList = (ArrayList) view2.getTag(R.id.obfuscated_res_0x7f09208c);
            if (arrayList == null) {
                ArrayList arrayList2 = new ArrayList();
                view2.setTag(R.id.obfuscated_res_0x7f09208c, arrayList2);
                return arrayList2;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Deprecated
    public static float getAlpha(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, view2)) == null) {
            return view2.getAlpha();
        }
        return invokeL.floatValue;
    }

    public static ColorStateList getBackgroundTintList(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.getBackgroundTintList();
            }
            if (view2 instanceof TintableBackgroundView) {
                return ((TintableBackgroundView) view2).getSupportBackgroundTintList();
            }
            return null;
        }
        return (ColorStateList) invokeL.objValue;
    }

    public static PorterDuff.Mode getBackgroundTintMode(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.getBackgroundTintMode();
            }
            if (view2 instanceof TintableBackgroundView) {
                return ((TintableBackgroundView) view2).getSupportBackgroundTintMode();
            }
            return null;
        }
        return (PorterDuff.Mode) invokeL.objValue;
    }

    @Nullable
    public static Rect getClipBounds(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return view2.getClipBounds();
            }
            return null;
        }
        return (Rect) invokeL.objValue;
    }

    public static float getElevation(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.getElevation();
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static boolean getFitsSystemWindows(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view2.getFitsSystemWindows();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int getImportantForAccessibility(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view2.getImportantForAccessibility();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view2.getImportantForAutofill();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getLabelFor(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return view2.getLabelFor();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static int getLayerType(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, view2)) == null) {
            return view2.getLayerType();
        }
        return invokeL.intValue;
    }

    public static int getLayoutDirection(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return view2.getLayoutDirection();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Nullable
    @Deprecated
    public static Matrix getMatrix(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, view2)) == null) {
            return view2.getMatrix();
        }
        return (Matrix) invokeL.objValue;
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, view2)) == null) {
            return view2.getMeasuredHeightAndState();
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static int getMeasuredState(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, view2)) == null) {
            return view2.getMeasuredState();
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, view2)) == null) {
            return view2.getMeasuredWidthAndState();
        }
        return invokeL.intValue;
    }

    public static int getNextClusterForwardId(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view2.getNextClusterForwardId();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static AccessibilityDelegateCompat getOrCreateAccessibilityDelegateCompat(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, view2)) == null) {
            AccessibilityDelegateCompat accessibilityDelegate = getAccessibilityDelegate(view2);
            if (accessibilityDelegate == null) {
                accessibilityDelegate = new AccessibilityDelegateCompat();
            }
            setAccessibilityDelegate(view2, accessibilityDelegate);
            return accessibilityDelegate;
        }
        return (AccessibilityDelegateCompat) invokeL.objValue;
    }

    @Deprecated
    public static int getOverScrollMode(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, view2)) == null) {
            return view2.getOverScrollMode();
        }
        return invokeL.intValue;
    }

    @Px
    public static int getPaddingEnd(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return view2.getPaddingEnd();
            }
            return view2.getPaddingRight();
        }
        return invokeL.intValue;
    }

    @Px
    public static int getPaddingStart(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return view2.getPaddingStart();
            }
            return view2.getPaddingLeft();
        }
        return invokeL.intValue;
    }

    public static ViewParent getParentForAccessibility(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65598, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view2.getParentForAccessibility();
            }
            return view2.getParent();
        }
        return (ViewParent) invokeL.objValue;
    }

    @Deprecated
    public static float getPivotX(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65599, null, view2)) == null) {
            return view2.getPivotX();
        }
        return invokeL.floatValue;
    }

    @Deprecated
    public static float getPivotY(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, view2)) == null) {
            return view2.getPivotY();
        }
        return invokeL.floatValue;
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65601, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return WindowInsetsCompat.toWindowInsetsCompat(Api23Impl.getRootWindowInsets(view2));
            }
            return null;
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    @Deprecated
    public static float getRotation(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65602, null, view2)) == null) {
            return view2.getRotation();
        }
        return invokeL.floatValue;
    }

    @Deprecated
    public static float getRotationX(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65603, null, view2)) == null) {
            return view2.getRotationX();
        }
        return invokeL.floatValue;
    }

    @Deprecated
    public static float getRotationY(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65604, null, view2)) == null) {
            return view2.getRotationY();
        }
        return invokeL.floatValue;
    }

    @Deprecated
    public static float getScaleX(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65605, null, view2)) == null) {
            return view2.getScaleX();
        }
        return invokeL.floatValue;
    }

    @Deprecated
    public static float getScaleY(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65606, null, view2)) == null) {
            return view2.getScaleY();
        }
        return invokeL.floatValue;
    }

    public static int getScrollIndicators(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65607, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return view2.getScrollIndicators();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @NonNull
    public static List<Rect> getSystemGestureExclusionRects(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65608, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return view2.getSystemGestureExclusionRects();
            }
            return Collections.emptyList();
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public static String getTransitionName(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65609, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.getTransitionName();
            }
            WeakHashMap<View, String> weakHashMap = sTransitionNameMap;
            if (weakHashMap == null) {
                return null;
            }
            return weakHashMap.get(view2);
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static float getTranslationX(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65610, null, view2)) == null) {
            return view2.getTranslationX();
        }
        return invokeL.floatValue;
    }

    @Deprecated
    public static float getTranslationY(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65611, null, view2)) == null) {
            return view2.getTranslationY();
        }
        return invokeL.floatValue;
    }

    public static float getTranslationZ(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65612, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.getTranslationZ();
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static int getWindowSystemUiVisibility(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65613, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view2.getWindowSystemUiVisibility();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static float getX(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65614, null, view2)) == null) {
            return view2.getX();
        }
        return invokeL.floatValue;
    }

    @Deprecated
    public static float getY(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65615, null, view2)) == null) {
            return view2.getY();
        }
        return invokeL.floatValue;
    }

    public static float getZ(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65616, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.getZ();
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static boolean hasAccessibilityDelegate(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65617, null, view2)) == null) {
            if (getAccessibilityDelegateInternal(view2) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasExplicitFocusable(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65618, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view2.hasExplicitFocusable();
            }
            return view2.hasFocusable();
        }
        return invokeL.booleanValue;
    }

    public static boolean hasNestedScrollingParent(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65619, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.hasNestedScrollingParent();
            }
            if (view2 instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view2).hasNestedScrollingParent();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasOnClickListeners(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65621, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 15) {
                return view2.hasOnClickListeners();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasOverlappingRendering(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65622, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view2.hasOverlappingRendering();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasTransientState(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65623, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view2.hasTransientState();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public static boolean isAccessibilityHeading(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65624, null, view2)) == null) {
            Boolean bool = accessibilityHeadingProperty().get(view2);
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static boolean isAttachedToWindow(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65625, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return view2.isAttachedToWindow();
            }
            if (view2.getWindowToken() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isFocusedByDefault(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65626, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view2.isFocusedByDefault();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isImportantForAccessibility(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65627, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.isImportantForAccessibility();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isImportantForAutofill(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65628, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view2.isImportantForAutofill();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isInLayout(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65629, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return view2.isInLayout();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isKeyboardNavigationCluster(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65630, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view2.isKeyboardNavigationCluster();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isLaidOut(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65631, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return view2.isLaidOut();
            }
            if (view2.getWidth() > 0 && view2.getHeight() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isLayoutDirectionResolved(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65632, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return view2.isLayoutDirectionResolved();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNestedScrollingEnabled(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65633, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.isNestedScrollingEnabled();
            }
            if (view2 instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view2).isNestedScrollingEnabled();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isOpaque(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65634, null, view2)) == null) {
            return view2.isOpaque();
        }
        return invokeL.booleanValue;
    }

    public static boolean isPaddingRelative(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65635, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return view2.isPaddingRelative();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public static boolean isScreenReaderFocusable(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65636, null, view2)) == null) {
            Boolean bool = screenReaderFocusableProperty().get(view2);
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65637, null, view2) == null) {
            view2.jumpDrawablesToCurrentState();
        }
    }

    public static void postInvalidateOnAnimation(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65648, null, view2) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view2.postInvalidateOnAnimation();
            } else {
                view2.postInvalidate();
            }
        }
    }

    public static void requestApplyInsets(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65656, null, view2) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 20) {
                view2.requestApplyInsets();
            } else if (i >= 16) {
                view2.requestFitSystemWindows();
            }
        }
    }

    public static boolean restoreDefaultFocus(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65659, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view2.restoreDefaultFocus();
            }
            return view2.requestFocus();
        }
        return invokeL.booleanValue;
    }

    public static void stopNestedScroll(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65714, null, view2) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                view2.stopNestedScroll();
            } else if (view2 instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view2).stopNestedScroll();
            }
        }
    }

    public static void tickleInvalidationFlag(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65716, null, view2) == null) {
            float translationY = view2.getTranslationY();
            view2.setTranslationY(1.0f + translationY);
            view2.setTranslationY(translationY);
        }
    }

    public static boolean dispatchNestedFling(@NonNull View view2, float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.dispatchNestedFling(f, f2, z);
            }
            if (view2 instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view2).dispatchNestedFling(f, f2, z);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean dispatchNestedPreFling(@NonNull View view2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.dispatchNestedPreFling(f, f2);
            }
            if (view2 instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view2).dispatchNestedPreFling(f, f2);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static void postOnAnimationDelayed(@NonNull View view2, Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65651, null, new Object[]{view2, runnable, Long.valueOf(j)}) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view2.postOnAnimationDelayed(runnable, j);
            } else {
                view2.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
            }
        }
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view2, int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2})) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.dispatchNestedPreScroll(i, i2, iArr, iArr2);
            }
            if (view2 instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view2).dispatchNestedPreScroll(i, i2, iArr, iArr2);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view2, int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2, Integer.valueOf(i3)})) == null) {
            if (view2 instanceof NestedScrollingChild2) {
                return ((NestedScrollingChild2) view2).dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
            }
            if (i3 == 0) {
                return dispatchNestedPreScroll(view2, i, i2, iArr, iArr2);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean dispatchNestedScroll(@NonNull View view2, int i, int i2, int i3, int i4, @Nullable int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.dispatchNestedScroll(i, i2, i3, i4, iArr);
            }
            if (view2 instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view2).dispatchNestedScroll(i, i2, i3, i4, iArr);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static void dispatchNestedScroll(@NonNull View view2, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, @NonNull int[] iArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, Integer.valueOf(i5), iArr2}) == null) {
            if (view2 instanceof NestedScrollingChild3) {
                ((NestedScrollingChild3) view2).dispatchNestedScroll(i, i2, i3, i4, iArr, i5, iArr2);
            } else {
                dispatchNestedScroll(view2, i, i2, i3, i4, iArr, i5);
            }
        }
    }

    public static boolean dispatchNestedScroll(@NonNull View view2, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, Integer.valueOf(i5)})) == null) {
            if (view2 instanceof NestedScrollingChild2) {
                return ((NestedScrollingChild2) view2).dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
            }
            if (i5 == 0) {
                return dispatchNestedScroll(view2, i, i2, i3, i4, iArr);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static int getAvailableActionIdFromResources(View view2) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, view2)) == null) {
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view2);
            int i = 0;
            int i2 = -1;
            while (true) {
                int[] iArr = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
                if (i >= iArr.length || i2 != -1) {
                    break;
                }
                int i3 = iArr[i];
                boolean z2 = true;
                for (int i4 = 0; i4 < actionList.size(); i4++) {
                    if (actionList.get(i4).getId() != i3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 &= z;
                }
                if (z2) {
                    i2 = i3;
                }
                i++;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    @RequiresApi(19)
    public static void notifyViewAccessibilityStateChangedIfNeeded(View view2, int i) {
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65639, null, view2, i) != null) || !((AccessibilityManager) view2.getContext().getSystemService("accessibility")).isEnabled()) {
            return;
        }
        if (getAccessibilityPaneTitle(view2) != null) {
            z = true;
        } else {
            z = false;
        }
        if (getAccessibilityLiveRegion(view2) == 0 && (!z || view2.getVisibility() != 0)) {
            if (view2.getParent() != null) {
                try {
                    view2.getParent().notifySubtreeAccessibilityStateChanged(view2, view2, i);
                    return;
                } catch (AbstractMethodError e) {
                    Log.e(TAG, view2.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
                    return;
                }
            }
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        if (z) {
            i2 = 32;
        } else {
            i2 = 2048;
        }
        obtain.setEventType(i2);
        obtain.setContentChangeTypes(i);
        view2.sendAccessibilityEventUnchecked(obtain);
    }

    public static void offsetLeftAndRight(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65640, null, view2, i) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                view2.offsetLeftAndRight(i);
            } else if (i2 >= 21) {
                Rect emptyTempRect = getEmptyTempRect();
                boolean z = false;
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    View view3 = (View) parent;
                    emptyTempRect.set(view3.getLeft(), view3.getTop(), view3.getRight(), view3.getBottom());
                    z = !emptyTempRect.intersects(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                }
                compatOffsetLeftAndRight(view2, i);
                if (z && emptyTempRect.intersect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom())) {
                    ((View) parent).invalidate(emptyTempRect);
                }
            } else {
                compatOffsetLeftAndRight(view2, i);
            }
        }
    }

    public static void offsetTopAndBottom(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65641, null, view2, i) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                view2.offsetTopAndBottom(i);
            } else if (i2 >= 21) {
                Rect emptyTempRect = getEmptyTempRect();
                boolean z = false;
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    View view3 = (View) parent;
                    emptyTempRect.set(view3.getLeft(), view3.getTop(), view3.getRight(), view3.getBottom());
                    z = !emptyTempRect.intersects(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                }
                compatOffsetTopAndBottom(view2, i);
                if (z && emptyTempRect.intersect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom())) {
                    ((View) parent).invalidate(emptyTempRect);
                }
            } else {
                compatOffsetTopAndBottom(view2, i);
            }
        }
    }

    public static void postInvalidateOnAnimation(@NonNull View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65649, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view2.postInvalidateOnAnimation(i, i2, i3, i4);
            } else {
                view2.postInvalidate(i, i2, i3, i4);
            }
        }
    }

    public static void setPaddingRelative(@NonNull View view2, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65689, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                view2.setPaddingRelative(i, i2, i3, i4);
            } else {
                view2.setPadding(i, i2, i3, i4);
            }
        }
    }

    public static boolean startDragAndDrop(@NonNull View view2, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65711, null, new Object[]{view2, clipData, dragShadowBuilder, obj, Integer.valueOf(i)})) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return view2.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
            }
            return view2.startDrag(clipData, dragShadowBuilder, obj, i);
        }
        return invokeCommon.booleanValue;
    }

    public static void removeOnUnhandledKeyEventListener(@NonNull View view2, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65654, null, view2, onUnhandledKeyEventListenerCompat) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view2.getTag(R.id.obfuscated_res_0x7f0920e9);
                if (simpleArrayMap != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) != null) {
                    view2.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
                    return;
                }
                return;
            }
            ArrayList arrayList = (ArrayList) view2.getTag(R.id.obfuscated_res_0x7f0920e9);
            if (arrayList != null) {
                arrayList.remove(onUnhandledKeyEventListenerCompat);
                if (arrayList.size() == 0) {
                    UnhandledKeyEventManager.unregisterListeningView(view2);
                }
            }
        }
    }

    public static void replaceAccessibilityAction(@NonNull View view2, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, @Nullable CharSequence charSequence, @Nullable AccessibilityViewCommand accessibilityViewCommand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65655, null, view2, accessibilityActionCompat, charSequence, accessibilityViewCommand) == null) {
            if (accessibilityViewCommand == null && charSequence == null) {
                removeAccessibilityAction(view2, accessibilityActionCompat.getId());
            } else {
                addAccessibilityAction(view2, accessibilityActionCompat.createReplacementAction(charSequence, accessibilityViewCommand));
            }
        }
    }

    public static void saveAttributeDataForStyleable(@NonNull View view2, @NonNull @SuppressLint({"ContextFirst"}) Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65660, null, new Object[]{view2, context, iArr, attributeSet, typedArray, Integer.valueOf(i), Integer.valueOf(i2)}) == null) && Build.VERSION.SDK_INT >= 29) {
            Api29Impl.saveAttributeDataForStyleable(view2, context, iArr, attributeSet, typedArray, i, i2);
        }
    }
}
