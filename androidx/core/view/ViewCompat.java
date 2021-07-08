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
import androidx.core.R;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* loaded from: classes.dex */
    public static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakHashMap<View, Boolean> mPanesToVisible;

        public AccessibilityPaneVisibilityManager() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPanesToVisible = new WeakHashMap<>();
        }

        @RequiresApi(19)
        private void checkPaneVisibility(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65537, this, view, z) == null) {
                boolean z2 = view.getVisibility() == 0;
                if (z != z2) {
                    if (z2) {
                        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, 16);
                    }
                    this.mPanesToVisible.put(view, Boolean.valueOf(z2));
                }
            }
        }

        @RequiresApi(19)
        private void registerForLayoutCallback(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, view) == null) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
            }
        }

        @RequiresApi(19)
        private void unregisterForLayoutCallback(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, view) == null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }

        @RequiresApi(19)
        public void addAccessibilityPane(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.mPanesToVisible.put(view, Boolean.valueOf(view.getVisibility() == 0));
                view.addOnAttachStateChangeListener(this);
                if (view.isAttachedToWindow()) {
                    registerForLayoutCallback(view);
                }
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

        @Override // android.view.View.OnAttachStateChangeListener
        @RequiresApi(19)
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                registerForLayoutCallback(view);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            }
        }

        @RequiresApi(19)
        public void removeAccessibilityPane(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
                this.mPanesToVisible.remove(view);
                view.removeOnAttachStateChangeListener(this);
                unregisterForLayoutCallback(view);
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

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AccessibilityViewProperty(int i2, Class<T> cls, int i3) {
            this(i2, cls, 0, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), cls, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), (Class) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        private boolean extrasAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? Build.VERSION.SDK_INT >= 19 : invokeV.booleanValue;
        }

        private boolean frameworkAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk : invokeV.booleanValue;
        }

        public boolean booleanNullToFalseEquals(Boolean bool, Boolean bool2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bool, bool2)) == null) {
                return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
            }
            return invokeLL.booleanValue;
        }

        public abstract T frameworkGet(View view);

        public abstract void frameworkSet(View view, T t);

        public T get(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
                if (frameworkAvailable()) {
                    return frameworkGet(view);
                }
                if (extrasAvailable()) {
                    T t = (T) view.getTag(this.mTagKey);
                    if (this.mType.isInstance(t)) {
                        return t;
                    }
                    return null;
                }
                return null;
            }
            return (T) invokeL.objValue;
        }

        public void set(View view, T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, view, t) == null) {
                if (frameworkAvailable()) {
                    frameworkSet(view, t);
                } else if (extrasAvailable() && shouldUpdate(get(view), t)) {
                    ViewCompat.getOrCreateAccessibilityDelegateCompat(view);
                    view.setTag(this.mTagKey, t);
                    ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, 0);
                }
            }
        }

        public boolean shouldUpdate(T t, T t2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, t, t2)) == null) ? !t2.equals(t) : invokeLL.booleanValue;
        }

        public AccessibilityViewProperty(int i2, Class<T> cls, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), cls, Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mTagKey = i2;
            this.mType = cls;
            this.mFrameworkMinimumSdk = i4;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, view, windowInsetsCompat, rect)) == null) {
                WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
                if (windowInsets != null) {
                    return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static WindowInsets getRootWindowInsets(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) ? view.getRootWindowInsets() : (WindowInsets) invokeL.objValue;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static void saveAttributeDataForStyleable(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{view, context, iArr, attributeSet, typedArray, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
            }
        }
    }

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
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mViewsContainingListeners = null;
            this.mCapturedKeys = null;
            this.mLastDispatchedPreViewKeyEvent = null;
        }

        public static UnhandledKeyEventManager at(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
                UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(R.id.tag_unhandled_key_event_manager);
                if (unhandledKeyEventManager == null) {
                    UnhandledKeyEventManager unhandledKeyEventManager2 = new UnhandledKeyEventManager();
                    view.setTag(R.id.tag_unhandled_key_event_manager, unhandledKeyEventManager2);
                    return unhandledKeyEventManager2;
                }
                return unhandledKeyEventManager;
            }
            return (UnhandledKeyEventManager) invokeL.objValue;
        }

        @Nullable
        private View dispatchInOrder(View view, KeyEvent keyEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, view, keyEvent)) == null) {
                WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
                if (weakHashMap != null && weakHashMap.containsKey(view)) {
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                            View dispatchInOrder = dispatchInOrder(viewGroup.getChildAt(childCount), keyEvent);
                            if (dispatchInOrder != null) {
                                return dispatchInOrder;
                            }
                        }
                    }
                    if (onUnhandledKeyEvent(view, keyEvent)) {
                        return view;
                    }
                }
                return null;
            }
            return (View) invokeLL.objValue;
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

        private boolean onUnhandledKeyEvent(@NonNull View view, @NonNull KeyEvent keyEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, view, keyEvent)) == null) {
                ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        private void recalcViewsWithUnhandled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
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
                        View view = sViewsWithListeners.get(size).get();
                        if (view == null) {
                            sViewsWithListeners.remove(size);
                        } else {
                            this.mViewsContainingListeners.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.mViewsContainingListeners.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        public static void registerListeningView(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65543, null, view) == null) {
                synchronized (sViewsWithListeners) {
                    Iterator<WeakReference<View>> it = sViewsWithListeners.iterator();
                    while (it.hasNext()) {
                        if (it.next().get() == view) {
                            return;
                        }
                    }
                    sViewsWithListeners.add(new WeakReference<>(view));
                }
            }
        }

        public static void unregisterListeningView(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65544, null, view) == null) {
                synchronized (sViewsWithListeners) {
                    for (int i2 = 0; i2 < sViewsWithListeners.size(); i2++) {
                        if (sViewsWithListeners.get(i2).get() == view) {
                            sViewsWithListeners.remove(i2);
                            return;
                        }
                    }
                }
            }
        }

        public boolean dispatch(View view, KeyEvent keyEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, keyEvent)) == null) {
                if (keyEvent.getAction() == 0) {
                    recalcViewsWithUnhandled();
                }
                View dispatchInOrder = dispatchInOrder(view, keyEvent);
                if (keyEvent.getAction() == 0) {
                    int keyCode = keyEvent.getKeyCode();
                    if (dispatchInOrder != null && !KeyEvent.isModifierKey(keyCode)) {
                        getCapturedKeys().put(keyCode, new WeakReference<>(dispatchInOrder));
                    }
                }
                return dispatchInOrder != null;
            }
            return invokeLL.booleanValue;
        }

        public boolean preDispatch(KeyEvent keyEvent) {
            InterceptResult invokeL;
            int indexOfKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) {
                WeakReference<KeyEvent> weakReference = this.mLastDispatchedPreViewKeyEvent;
                if (weakReference == null || weakReference.get() != keyEvent) {
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
                    if (weakReference2 != null) {
                        View view = weakReference2.get();
                        if (view != null && ViewCompat.isAttachedToWindow(view)) {
                            onUnhandledKeyEvent(view, keyEvent);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
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
        ACCESSIBILITY_ACTIONS_RESOURCE_IDS = new int[]{R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    }

    public ViewCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new AccessibilityViewProperty<Boolean>(R.id.tag_accessibility_heading, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.5
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
            public Boolean frameworkGet(View view) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view)) == null) ? Boolean.valueOf(view.isAccessibilityHeading()) : (Boolean) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public void frameworkSet(View view, Boolean bool) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, bool) == null) {
                    view.setAccessibilityHeading(bool.booleanValue());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(Boolean bool, Boolean bool2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048580, this, bool, bool2)) == null) ? !booleanNullToFalseEquals(bool, bool2) : invokeLL.booleanValue;
            }
        } : (AccessibilityViewProperty) invokeV.objValue;
    }

    public static int addAccessibilityAction(@NonNull View view, @NonNull CharSequence charSequence, @NonNull AccessibilityViewCommand accessibilityViewCommand) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, view, charSequence, accessibilityViewCommand)) == null) {
            int availableActionIdFromResources = getAvailableActionIdFromResources(view);
            if (availableActionIdFromResources != -1) {
                addAccessibilityAction(view, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(availableActionIdFromResources, charSequence, accessibilityViewCommand));
            }
            return availableActionIdFromResources;
        }
        return invokeLLL.intValue;
    }

    public static void addKeyboardNavigationClusters(@NonNull View view, @NonNull Collection<View> collection, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(AdIconUtil.AD_TEXT_ID, null, view, collection, i2) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        view.addKeyboardNavigationClusters(collection, i2);
    }

    public static void addOnUnhandledKeyEventListener(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, view, onUnhandledKeyEventListenerCompat) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.tag_unhandled_key_listeners);
                if (simpleArrayMap == null) {
                    simpleArrayMap = new SimpleArrayMap();
                    view.setTag(R.id.tag_unhandled_key_listeners, simpleArrayMap);
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$listener = onUnhandledKeyEventListenerCompat;
                    }

                    @Override // android.view.View.OnUnhandledKeyEventListener
                    public boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, keyEvent)) == null) ? this.val$listener.onUnhandledKeyEvent(view2, keyEvent) : invokeLL.booleanValue;
                    }
                };
                simpleArrayMap.put(onUnhandledKeyEventListenerCompat, onUnhandledKeyEventListener);
                view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
                return;
            }
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                arrayList = new ArrayList();
                view.setTag(R.id.tag_unhandled_key_listeners, arrayList);
            }
            arrayList.add(onUnhandledKeyEventListenerCompat);
            if (arrayList.size() == 1) {
                UnhandledKeyEventManager.registerListeningView(view);
            }
        }
    }

    @NonNull
    public static ViewPropertyAnimatorCompat animate(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view)) == null) {
            if (sViewPropertyAnimatorMap == null) {
                sViewPropertyAnimatorMap = new WeakHashMap<>();
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = sViewPropertyAnimatorMap.get(view);
            if (viewPropertyAnimatorCompat == null) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
                sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat2);
                return viewPropertyAnimatorCompat2;
            }
            return viewPropertyAnimatorCompat;
        }
        return (ViewPropertyAnimatorCompat) invokeL.objValue;
    }

    public static void bindTempDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            try {
                sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
                sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
            } catch (NoSuchMethodException e2) {
                Log.e(TAG, "Couldn't find method", e2);
            }
            sTempDetachBound = true;
        }
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, view, i2)) == null) ? view.canScrollHorizontally(i2) : invokeLI.booleanValue;
    }

    @Deprecated
    public static boolean canScrollVertically(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, view, i2)) == null) ? view.canScrollVertically(i2) : invokeLI.booleanValue;
    }

    public static void cancelDragAndDrop(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, view) == null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
        view.cancelDragAndDrop();
    }

    @Deprecated
    public static int combineMeasuredStates(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65548, null, i2, i3)) == null) ? View.combineMeasuredStates(i2, i3) : invokeII.intValue;
    }

    public static void compatOffsetLeftAndRight(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, view, i2) == null) {
            view.offsetLeftAndRight(i2);
            if (view.getVisibility() == 0) {
                tickleInvalidationFlag(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    tickleInvalidationFlag((View) parent);
                }
            }
        }
    }

    public static void compatOffsetTopAndBottom(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, view, i2) == null) {
            view.offsetTopAndBottom(i2);
            if (view.getVisibility() == 0) {
                tickleInvalidationFlag(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    tickleInvalidationFlag((View) parent);
                }
            }
        }
    }

    @NonNull
    public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, view, windowInsetsCompat, rect)) == null) ? Build.VERSION.SDK_INT >= 21 ? Api21Impl.computeSystemWindowInsets(view, windowInsetsCompat, rect) : windowInsetsCompat : (WindowInsetsCompat) invokeLLL.objValue;
    }

    @NonNull
    public static WindowInsetsCompat dispatchApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeLL;
        WindowInsets windowInsets;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, view, windowInsetsCompat)) == null) ? (Build.VERSION.SDK_INT < 21 || (windowInsets = windowInsetsCompat.toWindowInsets()) == null || view.dispatchApplyWindowInsets(windowInsets).equals(windowInsets)) ? windowInsetsCompat : WindowInsetsCompat.toWindowInsetsCompat(windowInsets) : (WindowInsetsCompat) invokeLL.objValue;
    }

    public static void dispatchFinishTemporaryDetach(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, view) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                view.dispatchFinishTemporaryDetach();
                return;
            }
            if (!sTempDetachBound) {
                bindTempDetach();
            }
            Method method = sDispatchFinishTemporaryDetach;
            if (method != null) {
                try {
                    method.invoke(view, new Object[0]);
                    return;
                } catch (Exception e2) {
                    Log.d(TAG, "Error calling dispatchFinishTemporaryDetach", e2);
                    return;
                }
            }
            view.onFinishTemporaryDetach();
        }
    }

    public static boolean dispatchNestedFling(@NonNull View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.dispatchNestedFling(f2, f3, z);
            }
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedFling(f2, f3, z);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean dispatchNestedPreFling(@NonNull View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.dispatchNestedPreFling(f2, f3);
            }
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedPreFling(f2, f3);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view, int i2, int i3, @Nullable int[] iArr, @Nullable int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
            }
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedPreScroll(i2, i3, iArr, iArr2);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean dispatchNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5, @Nullable int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.dispatchNestedScroll(i2, i3, i4, i5, iArr);
            }
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedScroll(i2, i3, i4, i5, iArr);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static void dispatchStartTemporaryDetach(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, view) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                view.dispatchStartTemporaryDetach();
                return;
            }
            if (!sTempDetachBound) {
                bindTempDetach();
            }
            Method method = sDispatchStartTemporaryDetach;
            if (method != null) {
                try {
                    method.invoke(view, new Object[0]);
                    return;
                } catch (Exception e2) {
                    Log.d(TAG, "Error calling dispatchStartTemporaryDetach", e2);
                    return;
                }
            }
            view.onStartTemporaryDetach();
        }
    }

    @UiThread
    public static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, view, keyEvent)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return false;
            }
            return UnhandledKeyEventManager.at(view).dispatch(view, keyEvent);
        }
        return invokeLL.booleanValue;
    }

    @UiThread
    public static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, view, keyEvent)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return false;
            }
            return UnhandledKeyEventManager.at(view).preDispatch(keyEvent);
        }
        return invokeLL.booleanValue;
    }

    public static void enableAccessibleClickableSpanSupport(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65564, null, view) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        getOrCreateAccessibilityDelegateCompat(view);
    }

    public static int generateViewId() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return View.generateViewId();
            }
            do {
                i2 = sNextGeneratedId.get();
                i3 = i2 + 1;
                if (i3 > 16777215) {
                    i3 = 1;
                }
            } while (!sNextGeneratedId.compareAndSet(i2, i3));
            return i2;
        }
        return invokeV.intValue;
    }

    @Nullable
    public static AccessibilityDelegateCompat getAccessibilityDelegate(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, view)) == null) {
            View.AccessibilityDelegate accessibilityDelegateInternal = getAccessibilityDelegateInternal(view);
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
    public static View.AccessibilityDelegate getAccessibilityDelegateInternal(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return view.getAccessibilityDelegate();
            }
            return getAccessibilityDelegateThroughReflection(view);
        }
        return (View.AccessibilityDelegate) invokeL.objValue;
    }

    @Nullable
    public static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, view)) == null) {
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
                Object obj = sAccessibilityDelegateField.get(view);
                if (obj instanceof View.AccessibilityDelegate) {
                    return (View.AccessibilityDelegate) obj;
                }
                return null;
            } catch (Throwable unused2) {
                sAccessibilityDelegateCheckFailed = true;
                return null;
            }
        }
        return (View.AccessibilityDelegate) invokeL.objValue;
    }

    public static int getAccessibilityLiveRegion(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return view.getAccessibilityLiveRegion();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View view) {
        InterceptResult invokeL;
        AccessibilityNodeProvider accessibilityNodeProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, view)) == null) {
            if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = view.getAccessibilityNodeProvider()) == null) {
                return null;
            }
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return (AccessibilityNodeProviderCompat) invokeL.objValue;
    }

    @UiThread
    public static CharSequence getAccessibilityPaneTitle(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, view)) == null) ? paneTitleProperty().get(view) : (CharSequence) invokeL.objValue;
    }

    public static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, view)) == null) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
            if (arrayList == null) {
                ArrayList arrayList2 = new ArrayList();
                view.setTag(R.id.tag_accessibility_actions, arrayList2);
                return arrayList2;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Deprecated
    public static float getAlpha(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, view)) == null) ? view.getAlpha() : invokeL.floatValue;
    }

    public static int getAvailableActionIdFromResources(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, view)) == null) {
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
            int i2 = 0;
            int i3 = -1;
            while (true) {
                int[] iArr = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
                if (i2 >= iArr.length || i3 != -1) {
                    break;
                }
                int i4 = iArr[i2];
                boolean z = true;
                for (int i5 = 0; i5 < actionList.size(); i5++) {
                    z &= actionList.get(i5).getId() != i4;
                }
                if (z) {
                    i3 = i4;
                }
                i2++;
            }
            return i3;
        }
        return invokeL.intValue;
    }

    public static ColorStateList getBackgroundTintList(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.getBackgroundTintList();
            }
            if (view instanceof TintableBackgroundView) {
                return ((TintableBackgroundView) view).getSupportBackgroundTintList();
            }
            return null;
        }
        return (ColorStateList) invokeL.objValue;
    }

    public static PorterDuff.Mode getBackgroundTintMode(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.getBackgroundTintMode();
            }
            if (view instanceof TintableBackgroundView) {
                return ((TintableBackgroundView) view).getSupportBackgroundTintMode();
            }
            return null;
        }
        return (PorterDuff.Mode) invokeL.objValue;
    }

    @Nullable
    public static Rect getClipBounds(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return view.getClipBounds();
            }
            return null;
        }
        return (Rect) invokeL.objValue;
    }

    @Nullable
    public static Display getDisplay(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return view.getDisplay();
            }
            if (isAttachedToWindow(view)) {
                return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
            }
            return null;
        }
        return (Display) invokeL.objValue;
    }

    public static float getElevation(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.getElevation();
            }
            return 0.0f;
        }
        return invokeL.floatValue;
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

    public static boolean getFitsSystemWindows(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view.getFitsSystemWindows();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int getImportantForAccessibility(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view.getImportantForAccessibility();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view.getImportantForAutofill();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getLabelFor(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return view.getLabelFor();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static int getLayerType(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65585, null, view)) == null) ? view.getLayerType() : invokeL.intValue;
    }

    public static int getLayoutDirection(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return view.getLayoutDirection();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Nullable
    @Deprecated
    public static Matrix getMatrix(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65587, null, view)) == null) ? view.getMatrix() : (Matrix) invokeL.objValue;
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65588, null, view)) == null) ? view.getMeasuredHeightAndState() : invokeL.intValue;
    }

    @Deprecated
    public static int getMeasuredState(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65589, null, view)) == null) ? view.getMeasuredState() : invokeL.intValue;
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65590, null, view)) == null) ? view.getMeasuredWidthAndState() : invokeL.intValue;
    }

    public static int getMinimumHeight(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view.getMinimumHeight();
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
                    return ((Integer) field.get(view)).intValue();
                } catch (Exception unused2) {
                    return 0;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getMinimumWidth(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view.getMinimumWidth();
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
                    return ((Integer) field.get(view)).intValue();
                } catch (Exception unused2) {
                    return 0;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getNextClusterForwardId(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view.getNextClusterForwardId();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static AccessibilityDelegateCompat getOrCreateAccessibilityDelegateCompat(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, view)) == null) {
            AccessibilityDelegateCompat accessibilityDelegate = getAccessibilityDelegate(view);
            if (accessibilityDelegate == null) {
                accessibilityDelegate = new AccessibilityDelegateCompat();
            }
            setAccessibilityDelegate(view, accessibilityDelegate);
            return accessibilityDelegate;
        }
        return (AccessibilityDelegateCompat) invokeL.objValue;
    }

    @Deprecated
    public static int getOverScrollMode(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65595, null, view)) == null) ? view.getOverScrollMode() : invokeL.intValue;
    }

    @Px
    public static int getPaddingEnd(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return view.getPaddingEnd();
            }
            return view.getPaddingRight();
        }
        return invokeL.intValue;
    }

    @Px
    public static int getPaddingStart(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return view.getPaddingStart();
            }
            return view.getPaddingLeft();
        }
        return invokeL.intValue;
    }

    public static ViewParent getParentForAccessibility(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65598, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view.getParentForAccessibility();
            }
            return view.getParent();
        }
        return (ViewParent) invokeL.objValue;
    }

    @Deprecated
    public static float getPivotX(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65599, null, view)) == null) ? view.getPivotX() : invokeL.floatValue;
    }

    @Deprecated
    public static float getPivotY(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65600, null, view)) == null) ? view.getPivotY() : invokeL.floatValue;
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65601, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return WindowInsetsCompat.toWindowInsetsCompat(Api23Impl.getRootWindowInsets(view));
            }
            return null;
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    @Deprecated
    public static float getRotation(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65602, null, view)) == null) ? view.getRotation() : invokeL.floatValue;
    }

    @Deprecated
    public static float getRotationX(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65603, null, view)) == null) ? view.getRotationX() : invokeL.floatValue;
    }

    @Deprecated
    public static float getRotationY(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65604, null, view)) == null) ? view.getRotationY() : invokeL.floatValue;
    }

    @Deprecated
    public static float getScaleX(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65605, null, view)) == null) ? view.getScaleX() : invokeL.floatValue;
    }

    @Deprecated
    public static float getScaleY(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65606, null, view)) == null) ? view.getScaleY() : invokeL.floatValue;
    }

    public static int getScrollIndicators(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65607, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return view.getScrollIndicators();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @NonNull
    public static List<Rect> getSystemGestureExclusionRects(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65608, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return view.getSystemGestureExclusionRects();
            }
            return Collections.emptyList();
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public static String getTransitionName(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65609, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.getTransitionName();
            }
            WeakHashMap<View, String> weakHashMap = sTransitionNameMap;
            if (weakHashMap == null) {
                return null;
            }
            return weakHashMap.get(view);
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static float getTranslationX(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65610, null, view)) == null) ? view.getTranslationX() : invokeL.floatValue;
    }

    @Deprecated
    public static float getTranslationY(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65611, null, view)) == null) ? view.getTranslationY() : invokeL.floatValue;
    }

    public static float getTranslationZ(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65612, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.getTranslationZ();
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static int getWindowSystemUiVisibility(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65613, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view.getWindowSystemUiVisibility();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static float getX(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65614, null, view)) == null) ? view.getX() : invokeL.floatValue;
    }

    @Deprecated
    public static float getY(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65615, null, view)) == null) ? view.getY() : invokeL.floatValue;
    }

    public static float getZ(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65616, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.getZ();
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static boolean hasAccessibilityDelegate(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65617, null, view)) == null) ? getAccessibilityDelegateInternal(view) != null : invokeL.booleanValue;
    }

    public static boolean hasExplicitFocusable(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65618, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view.hasExplicitFocusable();
            }
            return view.hasFocusable();
        }
        return invokeL.booleanValue;
    }

    public static boolean hasNestedScrollingParent(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65619, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.hasNestedScrollingParent();
            }
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).hasNestedScrollingParent();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasOnClickListeners(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65621, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 15) {
                return view.hasOnClickListeners();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasOverlappingRendering(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65622, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view.hasOverlappingRendering();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasTransientState(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65623, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view.hasTransientState();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public static boolean isAccessibilityHeading(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65624, null, view)) == null) {
            Boolean bool = accessibilityHeadingProperty().get(view);
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static boolean isAttachedToWindow(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65625, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return view.isAttachedToWindow();
            }
            return view.getWindowToken() != null;
        }
        return invokeL.booleanValue;
    }

    public static boolean isFocusedByDefault(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65626, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view.isFocusedByDefault();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isImportantForAccessibility(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65627, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.isImportantForAccessibility();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isImportantForAutofill(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65628, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view.isImportantForAutofill();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isInLayout(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65629, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return view.isInLayout();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isKeyboardNavigationCluster(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65630, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view.isKeyboardNavigationCluster();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isLaidOut(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65631, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return view.isLaidOut();
            }
            return view.getWidth() > 0 && view.getHeight() > 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean isLayoutDirectionResolved(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65632, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return view.isLayoutDirectionResolved();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNestedScrollingEnabled(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65633, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.isNestedScrollingEnabled();
            }
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).isNestedScrollingEnabled();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isOpaque(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65634, null, view)) == null) ? view.isOpaque() : invokeL.booleanValue;
    }

    public static boolean isPaddingRelative(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65635, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return view.isPaddingRelative();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public static boolean isScreenReaderFocusable(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65636, null, view)) == null) {
            Boolean bool = screenReaderFocusableProperty().get(view);
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65637, null, view) == null) {
            view.jumpDrawablesToCurrentState();
        }
    }

    public static View keyboardNavigationClusterSearch(@NonNull View view, View view2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65638, null, view, view2, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view.keyboardNavigationClusterSearch(view2, i2);
            }
            return null;
        }
        return (View) invokeLLI.objValue;
    }

    @RequiresApi(19)
    public static void notifyViewAccessibilityStateChangedIfNeeded(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65639, null, view, i2) == null) && ((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = getAccessibilityPaneTitle(view) != null;
            if (getAccessibilityLiveRegion(view) == 0 && (!z || view.getVisibility() != 0)) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                        return;
                    } catch (AbstractMethodError e2) {
                        Log.e(TAG, view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(z ? 32 : 2048);
            obtain.setContentChangeTypes(i2);
            view.sendAccessibilityEventUnchecked(obtain);
        }
    }

    public static void offsetLeftAndRight(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65640, null, view, i2) == null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 23) {
                view.offsetLeftAndRight(i2);
            } else if (i3 >= 21) {
                Rect emptyTempRect = getEmptyTempRect();
                boolean z = false;
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    View view2 = (View) parent;
                    emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                    z = !emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                }
                compatOffsetLeftAndRight(view, i2);
                if (z && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                    ((View) parent).invalidate(emptyTempRect);
                }
            } else {
                compatOffsetLeftAndRight(view, i2);
            }
        }
    }

    public static void offsetTopAndBottom(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65641, null, view, i2) == null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 23) {
                view.offsetTopAndBottom(i2);
            } else if (i3 >= 21) {
                Rect emptyTempRect = getEmptyTempRect();
                boolean z = false;
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    View view2 = (View) parent;
                    emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                    z = !emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                }
                compatOffsetTopAndBottom(view, i2);
                if (z && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                    ((View) parent).invalidate(emptyTempRect);
                }
            } else {
                compatOffsetTopAndBottom(view, i2);
            }
        }
    }

    @NonNull
    public static WindowInsetsCompat onApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeLL;
        WindowInsets windowInsets;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65642, null, view, windowInsetsCompat)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && (windowInsets = windowInsetsCompat.toWindowInsets()) != null) {
                WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
                if (!onApplyWindowInsets.equals(windowInsets)) {
                    return WindowInsetsCompat.toWindowInsetsCompat(onApplyWindowInsets);
                }
            }
            return windowInsetsCompat;
        }
        return (WindowInsetsCompat) invokeLL.objValue;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65643, null, view, accessibilityEvent) == null) {
            view.onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    public static void onInitializeAccessibilityNodeInfo(@NonNull View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65644, null, view, accessibilityNodeInfoCompat) == null) {
            view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
        }
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65645, null, view, accessibilityEvent) == null) {
            view.onPopulateAccessibilityEvent(accessibilityEvent);
        }
    }

    public static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65646, null)) == null) ? new AccessibilityViewProperty<CharSequence>(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28) { // from class: androidx.core.view.ViewCompat.4
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
            public CharSequence frameworkGet(View view) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view)) == null) ? view.getAccessibilityPaneTitle() : (CharSequence) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public void frameworkSet(View view, CharSequence charSequence) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, charSequence) == null) {
                    view.setAccessibilityPaneTitle(charSequence);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048580, this, charSequence, charSequence2)) == null) ? !TextUtils.equals(charSequence, charSequence2) : invokeLL.booleanValue;
            }
        } : (AccessibilityViewProperty) invokeV.objValue;
    }

    public static boolean performAccessibilityAction(@NonNull View view, int i2, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65647, null, view, i2, bundle)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return view.performAccessibilityAction(i2, bundle);
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static void postInvalidateOnAnimation(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65648, null, view) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.postInvalidateOnAnimation();
            } else {
                view.postInvalidate();
            }
        }
    }

    public static void postOnAnimation(@NonNull View view, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65650, null, view, runnable) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.postOnAnimation(runnable);
            } else {
                view.postDelayed(runnable, ValueAnimator.getFrameDelay());
            }
        }
    }

    public static void postOnAnimationDelayed(@NonNull View view, Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65651, null, new Object[]{view, runnable, Long.valueOf(j)}) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.postOnAnimationDelayed(runnable, j);
            } else {
                view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
            }
        }
    }

    public static void removeAccessibilityAction(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65652, null, view, i2) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        removeActionWithId(i2, view);
        notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    public static void removeActionWithId(int i2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65653, null, i2, view) == null) {
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
            for (int i3 = 0; i3 < actionList.size(); i3++) {
                if (actionList.get(i3).getId() == i2) {
                    actionList.remove(i3);
                    return;
                }
            }
        }
    }

    public static void removeOnUnhandledKeyEventListener(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65654, null, view, onUnhandledKeyEventListenerCompat) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.tag_unhandled_key_listeners);
                if (simpleArrayMap == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) == null) {
                    return;
                }
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
                return;
            }
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList != null) {
                arrayList.remove(onUnhandledKeyEventListenerCompat);
                if (arrayList.size() == 0) {
                    UnhandledKeyEventManager.unregisterListeningView(view);
                }
            }
        }
    }

    public static void replaceAccessibilityAction(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, @Nullable CharSequence charSequence, @Nullable AccessibilityViewCommand accessibilityViewCommand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65655, null, view, accessibilityActionCompat, charSequence, accessibilityViewCommand) == null) {
            if (accessibilityViewCommand == null && charSequence == null) {
                removeAccessibilityAction(view, accessibilityActionCompat.getId());
            } else {
                addAccessibilityAction(view, accessibilityActionCompat.createReplacementAction(charSequence, accessibilityViewCommand));
            }
        }
    }

    public static void requestApplyInsets(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65656, null, view) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 20) {
                view.requestApplyInsets();
            } else if (i2 >= 16) {
                view.requestFitSystemWindows();
            }
        }
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull View view, @IdRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65657, null, view, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return (T) view.requireViewById(i2);
            }
            T t = (T) view.findViewById(i2);
            if (t != null) {
                return t;
            }
            throw new IllegalArgumentException("ID does not reference a View inside this View");
        }
        return (T) invokeLI.objValue;
    }

    @Deprecated
    public static int resolveSizeAndState(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65658, null, i2, i3, i4)) == null) ? View.resolveSizeAndState(i2, i3, i4) : invokeIII.intValue;
    }

    public static boolean restoreDefaultFocus(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65659, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return view.restoreDefaultFocus();
            }
            return view.requestFocus();
        }
        return invokeL.booleanValue;
    }

    public static void saveAttributeDataForStyleable(@NonNull View view, @NonNull @SuppressLint({"ContextFirst"}) Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65660, null, new Object[]{view, context, iArr, attributeSet, typedArray, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Api29Impl.saveAttributeDataForStyleable(view, context, iArr, attributeSet, typedArray, i2, i3);
    }

    public static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65661, null)) == null) ? new AccessibilityViewProperty<Boolean>(R.id.tag_screen_reader_focusable, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.3
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
            public Boolean frameworkGet(View view) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view)) == null) ? Boolean.valueOf(view.isScreenReaderFocusable()) : (Boolean) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public void frameworkSet(View view, Boolean bool) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, bool) == null) {
                    view.setScreenReaderFocusable(bool.booleanValue());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(Boolean bool, Boolean bool2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048580, this, bool, bool2)) == null) ? !booleanNullToFalseEquals(bool, bool2) : invokeLL.booleanValue;
            }
        } : (AccessibilityViewProperty) invokeV.objValue;
    }

    public static void setAccessibilityDelegate(@NonNull View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65662, null, view, accessibilityDelegateCompat) == null) {
            if (accessibilityDelegateCompat == null && (getAccessibilityDelegateInternal(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
                accessibilityDelegateCompat = new AccessibilityDelegateCompat();
            }
            view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge());
        }
    }

    @UiThread
    public static void setAccessibilityHeading(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65663, null, view, z) == null) {
            accessibilityHeadingProperty().set(view, Boolean.valueOf(z));
        }
    }

    public static void setAccessibilityLiveRegion(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65664, null, view, i2) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        view.setAccessibilityLiveRegion(i2);
    }

    @UiThread
    public static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65665, null, view, charSequence) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        paneTitleProperty().set(view, charSequence);
        if (charSequence != null) {
            sAccessibilityPaneVisibilityManager.addAccessibilityPane(view);
        } else {
            sAccessibilityPaneVisibilityManager.removeAccessibilityPane(view);
        }
    }

    @Deprecated
    public static void setActivated(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65666, null, view, z) == null) {
            view.setActivated(z);
        }
    }

    @Deprecated
    public static void setAlpha(View view, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65667, null, view, f2) == null) {
            view.setAlpha(f2);
        }
    }

    public static void setAutofillHints(@NonNull View view, @Nullable String... strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65668, null, view, strArr) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        view.setAutofillHints(strArr);
    }

    public static void setBackground(@NonNull View view, @Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65669, null, view, drawable) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground(drawable);
            } else {
                view.setBackgroundDrawable(drawable);
            }
        }
    }

    public static void setBackgroundTintList(@NonNull View view, ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65670, null, view, colorStateList) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setBackgroundTintList(colorStateList);
                if (Build.VERSION.SDK_INT == 21) {
                    Drawable background = view.getBackground();
                    boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                    if (background == null || !z) {
                        return;
                    }
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            } else if (view instanceof TintableBackgroundView) {
                ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
            }
        }
    }

    public static void setBackgroundTintMode(@NonNull View view, PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65671, null, view, mode) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setBackgroundTintMode(mode);
                if (Build.VERSION.SDK_INT == 21) {
                    Drawable background = view.getBackground();
                    boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                    if (background == null || !z) {
                        return;
                    }
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            } else if (view instanceof TintableBackgroundView) {
                ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
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
                } catch (NoSuchMethodException e2) {
                    Log.e(TAG, "Unable to find childrenDrawingOrderEnabled", e2);
                }
                sChildrenDrawingOrderMethod.setAccessible(true);
            }
            try {
                sChildrenDrawingOrderMethod.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e3) {
                Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e3);
            } catch (IllegalArgumentException e4) {
                Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e4);
            } catch (InvocationTargetException e5) {
                Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e5);
            }
        }
    }

    public static void setClipBounds(@NonNull View view, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65673, null, view, rect) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        view.setClipBounds(rect);
    }

    public static void setElevation(@NonNull View view, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(65674, null, view, f2) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        view.setElevation(f2);
    }

    @Deprecated
    public static void setFitsSystemWindows(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65675, null, view, z) == null) {
            view.setFitsSystemWindows(z);
        }
    }

    public static void setFocusedByDefault(@NonNull View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65676, null, view, z) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        view.setFocusedByDefault(z);
    }

    public static void setHasTransientState(@NonNull View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65677, null, view, z) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        view.setHasTransientState(z);
    }

    public static void setImportantForAccessibility(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65678, null, view, i2) == null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 19) {
                view.setImportantForAccessibility(i2);
            } else if (i3 >= 16) {
                if (i2 == 4) {
                    i2 = 2;
                }
                view.setImportantForAccessibility(i2);
            }
        }
    }

    public static void setImportantForAutofill(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65679, null, view, i2) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        view.setImportantForAutofill(i2);
    }

    public static void setKeyboardNavigationCluster(@NonNull View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65680, null, view, z) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        view.setKeyboardNavigationCluster(z);
    }

    public static void setLabelFor(@NonNull View view, @IdRes int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65681, null, view, i2) == null) || Build.VERSION.SDK_INT < 17) {
            return;
        }
        view.setLabelFor(i2);
    }

    public static void setLayerPaint(@NonNull View view, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65682, null, view, paint) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                view.setLayerPaint(paint);
                return;
            }
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }
    }

    @Deprecated
    public static void setLayerType(View view, int i2, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65683, null, view, i2, paint) == null) {
            view.setLayerType(i2, paint);
        }
    }

    public static void setLayoutDirection(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65684, null, view, i2) == null) || Build.VERSION.SDK_INT < 17) {
            return;
        }
        view.setLayoutDirection(i2);
    }

    public static void setNestedScrollingEnabled(@NonNull View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65685, null, view, z) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setNestedScrollingEnabled(z);
            } else if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).setNestedScrollingEnabled(z);
            }
        }
    }

    public static void setNextClusterForwardId(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65686, null, view, i2) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        view.setNextClusterForwardId(i2);
    }

    public static void setOnApplyWindowInsetsListener(@NonNull View view, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65687, null, view, onApplyWindowInsetsListener) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (onApplyWindowInsetsListener == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(onApplyWindowInsetsListener) { // from class: androidx.core.view.ViewCompat.1
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listener = onApplyWindowInsetsListener;
                }

                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, windowInsets)) == null) ? this.val$listener.onApplyWindowInsets(view2, WindowInsetsCompat.toWindowInsetsCompat(windowInsets)).toWindowInsets() : (WindowInsets) invokeLL.objValue;
                }
            });
        }
    }

    @Deprecated
    public static void setOverScrollMode(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65688, null, view, i2) == null) {
            view.setOverScrollMode(i2);
        }
    }

    public static void setPaddingRelative(@NonNull View view, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65689, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                view.setPaddingRelative(i2, i3, i4, i5);
            } else {
                view.setPadding(i2, i3, i4, i5);
            }
        }
    }

    @Deprecated
    public static void setPivotX(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65690, null, view, f2) == null) {
            view.setPivotX(f2);
        }
    }

    @Deprecated
    public static void setPivotY(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65691, null, view, f2) == null) {
            view.setPivotY(f2);
        }
    }

    public static void setPointerIcon(@NonNull View view, PointerIconCompat pointerIconCompat) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65692, null, view, pointerIconCompat) == null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
        view.setPointerIcon((PointerIcon) (pointerIconCompat != null ? pointerIconCompat.getPointerIcon() : null));
    }

    @Deprecated
    public static void setRotation(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65693, null, view, f2) == null) {
            view.setRotation(f2);
        }
    }

    @Deprecated
    public static void setRotationX(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65694, null, view, f2) == null) {
            view.setRotationX(f2);
        }
    }

    @Deprecated
    public static void setRotationY(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65695, null, view, f2) == null) {
            view.setRotationY(f2);
        }
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65696, null, view, z) == null) {
            view.setSaveFromParentEnabled(z);
        }
    }

    @Deprecated
    public static void setScaleX(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65697, null, view, f2) == null) {
            view.setScaleX(f2);
        }
    }

    @Deprecated
    public static void setScaleY(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65698, null, view, f2) == null) {
            view.setScaleY(f2);
        }
    }

    @UiThread
    public static void setScreenReaderFocusable(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65699, null, view, z) == null) {
            screenReaderFocusableProperty().set(view, Boolean.valueOf(z));
        }
    }

    public static void setScrollIndicators(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65700, null, view, i2) == null) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        view.setScrollIndicators(i2);
    }

    public static void setSystemGestureExclusionRects(@NonNull View view, @NonNull List<Rect> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65702, null, view, list) == null) || Build.VERSION.SDK_INT < 29) {
            return;
        }
        view.setSystemGestureExclusionRects(list);
    }

    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65703, null, view, charSequence) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        view.setTooltipText(charSequence);
    }

    public static void setTransitionName(@NonNull View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65704, null, view, str) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTransitionName(str);
                return;
            }
            if (sTransitionNameMap == null) {
                sTransitionNameMap = new WeakHashMap<>();
            }
            sTransitionNameMap.put(view, str);
        }
    }

    @Deprecated
    public static void setTranslationX(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65705, null, view, f2) == null) {
            view.setTranslationX(f2);
        }
    }

    @Deprecated
    public static void setTranslationY(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65706, null, view, f2) == null) {
            view.setTranslationY(f2);
        }
    }

    public static void setTranslationZ(@NonNull View view, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(65707, null, view, f2) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        view.setTranslationZ(f2);
    }

    @Deprecated
    public static void setX(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65708, null, view, f2) == null) {
            view.setX(f2);
        }
    }

    @Deprecated
    public static void setY(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65709, null, view, f2) == null) {
            view.setY(f2);
        }
    }

    public static void setZ(@NonNull View view, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(65710, null, view, f2) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        view.setZ(f2);
    }

    public static boolean startDragAndDrop(@NonNull View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65711, null, new Object[]{view, clipData, dragShadowBuilder, obj, Integer.valueOf(i2)})) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i2);
            }
            return view.startDrag(clipData, dragShadowBuilder, obj, i2);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean startNestedScroll(@NonNull View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65712, null, view, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.startNestedScroll(i2);
            }
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).startNestedScroll(i2);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void stopNestedScroll(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65714, null, view) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.stopNestedScroll();
            } else if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).stopNestedScroll();
            }
        }
    }

    public static void tickleInvalidationFlag(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65716, null, view) == null) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
        }
    }

    public static void updateDragShadow(@NonNull View view, View.DragShadowBuilder dragShadowBuilder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65717, null, view, dragShadowBuilder) == null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
        view.updateDragShadow(dragShadowBuilder);
    }

    public static void setScrollIndicators(@NonNull View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65701, null, view, i2, i3) == null) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        view.setScrollIndicators(i2, i3);
    }

    public static void addAccessibilityAction(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, view, accessibilityActionCompat) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        getOrCreateAccessibilityDelegateCompat(view);
        removeActionWithId(accessibilityActionCompat.getId(), view);
        getActionList(view).add(accessibilityActionCompat);
        notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    public static void postInvalidateOnAnimation(@NonNull View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65649, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.postInvalidateOnAnimation(i2, i3, i4, i5);
            } else {
                view.postInvalidate(i2, i3, i4, i5);
            }
        }
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view, int i2, int i3, @Nullable int[] iArr, @Nullable int[] iArr2, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2, Integer.valueOf(i4)})) == null) {
            if (view instanceof NestedScrollingChild2) {
                return ((NestedScrollingChild2) view).dispatchNestedPreScroll(i2, i3, iArr, iArr2, i4);
            }
            if (i4 == 0) {
                return dispatchNestedPreScroll(view, i2, i3, iArr, iArr2);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static void dispatchNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5, @Nullable int[] iArr, int i6, @NonNull int[] iArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, Integer.valueOf(i6), iArr2}) == null) {
            if (view instanceof NestedScrollingChild3) {
                ((NestedScrollingChild3) view).dispatchNestedScroll(i2, i3, i4, i5, iArr, i6, iArr2);
            } else {
                dispatchNestedScroll(view, i2, i3, i4, i5, iArr, i6);
            }
        }
    }

    public static boolean hasNestedScrollingParent(@NonNull View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65620, null, view, i2)) == null) {
            if (view instanceof NestedScrollingChild2) {
                ((NestedScrollingChild2) view).hasNestedScrollingParent(i2);
                return false;
            } else if (i2 == 0) {
                return hasNestedScrollingParent(view);
            } else {
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public static boolean startNestedScroll(@NonNull View view, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65713, null, view, i2, i3)) == null) {
            if (view instanceof NestedScrollingChild2) {
                return ((NestedScrollingChild2) view).startNestedScroll(i2, i3);
            }
            if (i3 == 0) {
                return startNestedScroll(view, i2);
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    public static void stopNestedScroll(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65715, null, view, i2) == null) {
            if (view instanceof NestedScrollingChild2) {
                ((NestedScrollingChild2) view).stopNestedScroll(i2);
            } else if (i2 == 0) {
                stopNestedScroll(view);
            }
        }
    }

    public static boolean dispatchNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5, @Nullable int[] iArr, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, Integer.valueOf(i6)})) == null) {
            if (view instanceof NestedScrollingChild2) {
                return ((NestedScrollingChild2) view).dispatchNestedScroll(i2, i3, i4, i5, iArr, i6);
            }
            if (i6 == 0) {
                return dispatchNestedScroll(view, i2, i3, i4, i5, iArr);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
