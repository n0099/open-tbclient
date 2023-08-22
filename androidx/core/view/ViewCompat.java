package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
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
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
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
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tieba.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class ViewCompat {
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
    public static Field sAccessibilityDelegateField;
    public static Method sChildrenDrawingOrderMethod;
    public static Method sDispatchFinishTemporaryDetach;
    public static Method sDispatchStartTemporaryDetach;
    public static Field sMinHeightField;
    public static boolean sMinHeightFieldFetched;
    public static Field sMinWidthField;
    public static boolean sMinWidthFieldFetched;
    public static boolean sTempDetachBound;
    public static ThreadLocal<Rect> sThreadLocalRect;
    public static WeakHashMap<View, String> sTransitionNameMap;
    public static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    public static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap = null;
    public static boolean sAccessibilityDelegateCheckFailed = false;
    public static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = {R.id.obfuscated_res_0x7f090042, R.id.obfuscated_res_0x7f090043, R.id.obfuscated_res_0x7f09004e, R.id.obfuscated_res_0x7f090059, R.id.obfuscated_res_0x7f09005c, R.id.obfuscated_res_0x7f09005d, R.id.obfuscated_res_0x7f09005e, R.id.obfuscated_res_0x7f09005f, R.id.obfuscated_res_0x7f090060, R.id.obfuscated_res_0x7f090061, R.id.obfuscated_res_0x7f090044, R.id.obfuscated_res_0x7f090045, R.id.obfuscated_res_0x7f090046, R.id.obfuscated_res_0x7f090047, R.id.obfuscated_res_0x7f090048, R.id.obfuscated_res_0x7f090049, R.id.obfuscated_res_0x7f09004a, R.id.obfuscated_res_0x7f09004b, R.id.obfuscated_res_0x7f09004c, R.id.obfuscated_res_0x7f09004d, R.id.obfuscated_res_0x7f09004f, R.id.obfuscated_res_0x7f090050, R.id.obfuscated_res_0x7f090051, R.id.obfuscated_res_0x7f090052, R.id.obfuscated_res_0x7f090053, R.id.obfuscated_res_0x7f090054, R.id.obfuscated_res_0x7f090055, R.id.obfuscated_res_0x7f090056, R.id.obfuscated_res_0x7f090057, R.id.obfuscated_res_0x7f090058, R.id.obfuscated_res_0x7f09005a, R.id.obfuscated_res_0x7f09005b};
    public static final OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new OnReceiveContentViewBehavior() { // from class: androidx.core.view.ViewCompat.1
        @Override // androidx.core.view.OnReceiveContentViewBehavior
        public ContentInfoCompat onReceiveContent(@NonNull ContentInfoCompat contentInfoCompat) {
            return contentInfoCompat;
        }
    };
    public static AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();

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
        public WeakHashMap<View, Boolean> mPanesToVisible = new WeakHashMap<>();

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(19)
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.mPanesToVisible.entrySet()) {
                    checkPaneVisibility(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @RequiresApi(19)
        private void checkPaneVisibility(View view2, boolean z) {
            boolean z2;
            int i;
            if (view2.getVisibility() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z != z2) {
                if (z2) {
                    i = 16;
                } else {
                    i = 32;
                }
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view2, i);
                this.mPanesToVisible.put(view2, Boolean.valueOf(z2));
            }
        }

        @RequiresApi(19)
        private void registerForLayoutCallback(View view2) {
            view2.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @RequiresApi(19)
        private void unregisterForLayoutCallback(View view2) {
            view2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @RequiresApi(19)
        public void addAccessibilityPane(View view2) {
            boolean z;
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

        @Override // android.view.View.OnAttachStateChangeListener
        @RequiresApi(19)
        public void onViewAttachedToWindow(View view2) {
            registerForLayoutCallback(view2);
        }

        @RequiresApi(19)
        public void removeAccessibilityPane(View view2) {
            this.mPanesToVisible.remove(view2);
            view2.removeOnAttachStateChangeListener(this);
            unregisterForLayoutCallback(view2);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AccessibilityViewProperty<T> {
        public final int mContentChangeType;
        public final int mFrameworkMinimumSdk;
        public final int mTagKey;
        public final Class<T> mType;

        public abstract T frameworkGet(View view2);

        public abstract void frameworkSet(View view2, T t);

        public AccessibilityViewProperty(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        public AccessibilityViewProperty(int i, Class<T> cls, int i2, int i3) {
            this.mTagKey = i;
            this.mType = cls;
            this.mContentChangeType = i2;
            this.mFrameworkMinimumSdk = i3;
        }

        private boolean extrasAvailable() {
            if (Build.VERSION.SDK_INT >= 19) {
                return true;
            }
            return false;
        }

        private boolean frameworkAvailable() {
            if (Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk) {
                return true;
            }
            return false;
        }

        public boolean booleanNullToFalseEquals(Boolean bool, Boolean bool2) {
            boolean booleanValue;
            boolean booleanValue2;
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

        public void set(View view2, T t) {
            if (frameworkAvailable()) {
                frameworkSet(view2, t);
            } else if (extrasAvailable() && shouldUpdate(get(view2), t)) {
                ViewCompat.getOrCreateAccessibilityDelegateCompat(view2);
                view2.setTag(this.mTagKey, t);
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view2, this.mContentChangeType);
            }
        }

        public boolean shouldUpdate(T t, T t2) {
            return !t2.equals(t);
        }

        public T get(View view2) {
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
    }

    /* loaded from: classes.dex */
    public static class UnhandledKeyEventManager {
        public static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList<>();
        @Nullable
        public WeakHashMap<View, Boolean> mViewsContainingListeners = null;
        public SparseArray<WeakReference<View>> mCapturedKeys = null;
        public WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            if (this.mCapturedKeys == null) {
                this.mCapturedKeys = new SparseArray<>();
            }
            return this.mCapturedKeys;
        }

        public static UnhandledKeyEventManager at(View view2) {
            UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view2.getTag(R.id.obfuscated_res_0x7f092408);
            if (unhandledKeyEventManager == null) {
                UnhandledKeyEventManager unhandledKeyEventManager2 = new UnhandledKeyEventManager();
                view2.setTag(R.id.obfuscated_res_0x7f092408, unhandledKeyEventManager2);
                return unhandledKeyEventManager2;
            }
            return unhandledKeyEventManager;
        }

        public static void registerListeningView(View view2) {
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

        public static void unregisterListeningView(View view2) {
            synchronized (sViewsWithListeners) {
                for (int i = 0; i < sViewsWithListeners.size(); i++) {
                    if (sViewsWithListeners.get(i).get() == view2) {
                        sViewsWithListeners.remove(i);
                        return;
                    }
                }
            }
        }

        @Nullable
        private View dispatchInOrder(View view2, KeyEvent keyEvent) {
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

        private boolean onUnhandledKeyEvent(@NonNull View view2, @NonNull KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view2.getTag(R.id.obfuscated_res_0x7f092409);
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

        public boolean dispatch(View view2, KeyEvent keyEvent) {
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

        private void recalcViewsWithUnhandled() {
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

        public boolean preDispatch(KeyEvent keyEvent) {
            int indexOfKey;
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
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class Api21Impl {
        public static void callCompatInsetAnimationCallback(@NonNull WindowInsets windowInsets, @NonNull View view2) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view2.getTag(R.id.obfuscated_res_0x7f092416);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view2, windowInsets);
            }
        }

        public static void setOnApplyWindowInsetsListener(@NonNull final View view2, @Nullable final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view2.setTag(R.id.obfuscated_res_0x7f0923da, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view2.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view2.getTag(R.id.obfuscated_res_0x7f092416));
            } else {
                view2.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.view.ViewCompat.Api21Impl.1
                    public WindowInsetsCompat mLastInsets = null;

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view3, WindowInsets windowInsets) {
                        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view3);
                        if (Build.VERSION.SDK_INT < 30) {
                            Api21Impl.callCompatInsetAnimationCallback(windowInsets, view2);
                            if (windowInsetsCompat.equals(this.mLastInsets)) {
                                return onApplyWindowInsetsListener.onApplyWindowInsets(view3, windowInsetsCompat).toWindowInsets();
                            }
                        }
                        this.mLastInsets = windowInsetsCompat;
                        WindowInsetsCompat onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view3, windowInsetsCompat);
                        if (Build.VERSION.SDK_INT >= 30) {
                            return onApplyWindowInsets.toWindowInsets();
                        }
                        ViewCompat.requestApplyInsets(view3);
                        return onApplyWindowInsets.toWindowInsets();
                    }
                });
            }
        }

        public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view2, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                return WindowInsetsCompat.toWindowInsetsCompat(view2.computeSystemWindowInsets(windowInsets, rect), view2);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View view2) {
            return WindowInsetsCompat.Api21ReflectionHolder.getRootWindowInsets(view2);
        }
    }

    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static class Api23Impl {
        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View view2) {
            WindowInsets rootWindowInsets = view2.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets);
            windowInsetsCompat.setRootWindowInsets(windowInsetsCompat);
            windowInsetsCompat.copyRootViewBounds(view2.getRootView());
            return windowInsetsCompat;
        }
    }

    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static class Api29Impl {
        public static void saveAttributeDataForStyleable(@NonNull View view2, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i, int i2) {
            view2.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class Api30Impl {
        @Nullable
        public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View view2) {
            WindowInsetsController windowInsetsController = view2.getWindowInsetsController();
            if (windowInsetsController != null) {
                return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(windowInsetsController);
            }
            return null;
        }
    }

    @RequiresApi(28)
    /* loaded from: classes.dex */
    public static class CompatImplApi28 {
        public static void addOnUnhandledKeyEventListener(@NonNull View view2, @NonNull final OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view2.getTag(R.id.obfuscated_res_0x7f092409);
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap();
                view2.setTag(R.id.obfuscated_res_0x7f092409, simpleArrayMap);
            }
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: androidx.core.view.ViewCompat.CompatImplApi28.1
                @Override // android.view.View.OnUnhandledKeyEventListener
                public boolean onUnhandledKeyEvent(View view3, KeyEvent keyEvent) {
                    return OnUnhandledKeyEventListenerCompat.this.onUnhandledKeyEvent(view3, keyEvent);
                }
            };
            simpleArrayMap.put(onUnhandledKeyEventListenerCompat, onUnhandledKeyEventListener);
            view2.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static void removeOnUnhandledKeyEventListener(@NonNull View view2, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view2.getTag(R.id.obfuscated_res_0x7f092409);
            if (simpleArrayMap != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) != null) {
                view2.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }
    }

    public static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        return new AccessibilityViewProperty<Boolean>(R.id.obfuscated_res_0x7f0923a0, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public Boolean frameworkGet(View view2) {
                return Boolean.valueOf(view2.isAccessibilityHeading());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public void frameworkSet(View view2, Boolean bool) {
                view2.setAccessibilityHeading(bool.booleanValue());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(Boolean bool, Boolean bool2) {
                return !booleanNullToFalseEquals(bool, bool2);
            }
        };
    }

    public static void bindTempDetach() {
        try {
            sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
            sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "Couldn't find method", e);
        }
        sTempDetachBound = true;
    }

    public static int generateViewId() {
        int i;
        int i2;
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

    public static Rect getEmptyTempRect() {
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

    public static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        return new AccessibilityViewProperty<CharSequence>(R.id.obfuscated_res_0x7f0923a1, CharSequence.class, 8, 28) { // from class: androidx.core.view.ViewCompat.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public CharSequence frameworkGet(View view2) {
                return view2.getAccessibilityPaneTitle();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public void frameworkSet(View view2, CharSequence charSequence) {
                view2.setAccessibilityPaneTitle(charSequence);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        return new AccessibilityViewProperty<Boolean>(R.id.obfuscated_res_0x7f0923f6, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public Boolean frameworkGet(View view2) {
                return Boolean.valueOf(view2.isScreenReaderFocusable());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public void frameworkSet(View view2, Boolean bool) {
                view2.setScreenReaderFocusable(bool.booleanValue());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(Boolean bool, Boolean bool2) {
                return !booleanNullToFalseEquals(bool, bool2);
            }
        };
    }

    public static AccessibilityViewProperty<CharSequence> stateDescriptionProperty() {
        return new AccessibilityViewProperty<CharSequence>(R.id.obfuscated_res_0x7f0923ff, CharSequence.class, 64, 30) { // from class: androidx.core.view.ViewCompat.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(30)
            public CharSequence frameworkGet(View view2) {
                return view2.getStateDescription();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(30)
            public void frameworkSet(View view2, CharSequence charSequence) {
                view2.setStateDescription(charSequence);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static int addAccessibilityAction(@NonNull View view2, @NonNull CharSequence charSequence, @NonNull AccessibilityViewCommand accessibilityViewCommand) {
        int availableActionIdFromResources = getAvailableActionIdFromResources(view2, charSequence);
        if (availableActionIdFromResources != -1) {
            addAccessibilityAction(view2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(availableActionIdFromResources, charSequence, accessibilityViewCommand));
        }
        return availableActionIdFromResources;
    }

    public static void addKeyboardNavigationClusters(@NonNull View view2, @NonNull Collection<View> collection, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view2.addKeyboardNavigationClusters(collection, i);
        }
    }

    @NonNull
    public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view2, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.computeSystemWindowInsets(view2, windowInsetsCompat, rect);
        }
        return windowInsetsCompat;
    }

    public static boolean dispatchNestedPreFling(@NonNull View view2, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view2.dispatchNestedPreFling(f, f2);
        }
        if (view2 instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view2).dispatchNestedPreFling(f, f2);
        }
        return false;
    }

    public static View keyboardNavigationClusterSearch(@NonNull View view2, View view3, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view2.keyboardNavigationClusterSearch(view3, i);
        }
        return null;
    }

    public static boolean performAccessibilityAction(@NonNull View view2, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view2.performAccessibilityAction(i, bundle);
        }
        return false;
    }

    public static void postOnAnimationDelayed(@NonNull View view2, Runnable runnable, long j) {
        if (Build.VERSION.SDK_INT >= 16) {
            view2.postOnAnimationDelayed(runnable, j);
        } else {
            view2.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    @Deprecated
    public static int resolveSizeAndState(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    @Deprecated
    public static void setLayerType(View view2, int i, Paint paint) {
        view2.setLayerType(i, paint);
    }

    public static void setScrollIndicators(@NonNull View view2, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view2.setScrollIndicators(i, i2);
        }
    }

    public static boolean startNestedScroll(@NonNull View view2, int i, int i2) {
        if (view2 instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view2).startNestedScroll(i, i2);
        }
        if (i2 == 0) {
            return startNestedScroll(view2, i);
        }
        return false;
    }

    public static void addAccessibilityAction(@NonNull View view2, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        if (Build.VERSION.SDK_INT >= 21) {
            getOrCreateAccessibilityDelegateCompat(view2);
            removeActionWithId(accessibilityActionCompat.getId(), view2);
            getActionList(view2).add(accessibilityActionCompat);
            notifyViewAccessibilityStateChangedIfNeeded(view2, 0);
        }
    }

    public static void addOnUnhandledKeyEventListener(@NonNull View view2, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            CompatImplApi28.addOnUnhandledKeyEventListener(view2, onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList arrayList = (ArrayList) view2.getTag(R.id.obfuscated_res_0x7f092409);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view2.setTag(R.id.obfuscated_res_0x7f092409, arrayList);
        }
        arrayList.add(onUnhandledKeyEventListenerCompat);
        if (arrayList.size() == 1) {
            UnhandledKeyEventManager.registerListeningView(view2);
        }
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view2, int i) {
        return view2.canScrollHorizontally(i);
    }

    @Deprecated
    public static boolean canScrollVertically(View view2, int i) {
        return view2.canScrollVertically(i);
    }

    @Deprecated
    public static int combineMeasuredStates(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    public static void compatOffsetLeftAndRight(View view2, int i) {
        view2.offsetLeftAndRight(i);
        if (view2.getVisibility() == 0) {
            tickleInvalidationFlag(view2);
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    public static void compatOffsetTopAndBottom(View view2, int i) {
        view2.offsetTopAndBottom(i);
        if (view2.getVisibility() == 0) {
            tickleInvalidationFlag(view2);
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    @NonNull
    public static WindowInsetsCompat dispatchApplyWindowInsets(@NonNull View view2, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsets = windowInsetsCompat.toWindowInsets()) != null) {
            WindowInsets dispatchApplyWindowInsets = view2.dispatchApplyWindowInsets(windowInsets);
            if (!dispatchApplyWindowInsets.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(dispatchApplyWindowInsets, view2);
            }
        }
        return windowInsetsCompat;
    }

    @UiThread
    public static boolean dispatchUnhandledKeyEventBeforeCallback(View view2, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.at(view2).dispatch(view2, keyEvent);
    }

    @UiThread
    public static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view2, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.at(view2).preDispatch(keyEvent);
    }

    public static boolean hasNestedScrollingParent(@NonNull View view2, int i) {
        if (view2 instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view2).hasNestedScrollingParent(i);
            return false;
        } else if (i == 0) {
            return hasNestedScrollingParent(view2);
        } else {
            return false;
        }
    }

    @NonNull
    public static WindowInsetsCompat onApplyWindowInsets(@NonNull View view2, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsets = windowInsetsCompat.toWindowInsets()) != null) {
            WindowInsets onApplyWindowInsets = view2.onApplyWindowInsets(windowInsets);
            if (!onApplyWindowInsets.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(onApplyWindowInsets, view2);
            }
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        view2.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(@NonNull View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view2.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        view2.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    public static void postOnAnimation(@NonNull View view2, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view2.postOnAnimation(runnable);
        } else {
            view2.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void removeAccessibilityAction(@NonNull View view2, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            removeActionWithId(i, view2);
            notifyViewAccessibilityStateChangedIfNeeded(view2, 0);
        }
    }

    public static void removeActionWithId(int i, View view2) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view2);
        for (int i2 = 0; i2 < actionList.size(); i2++) {
            if (actionList.get(i2).getId() == i) {
                actionList.remove(i2);
                return;
            }
        }
    }

    public static void removeOnUnhandledKeyEventListener(@NonNull View view2, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            CompatImplApi28.removeOnUnhandledKeyEventListener(view2, onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList arrayList = (ArrayList) view2.getTag(R.id.obfuscated_res_0x7f092409);
        if (arrayList != null) {
            arrayList.remove(onUnhandledKeyEventListenerCompat);
            if (arrayList.size() == 0) {
                UnhandledKeyEventManager.unregisterListeningView(view2);
            }
        }
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull View view2, @IdRes int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) view2.requireViewById(i);
        }
        T t = (T) view2.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    public static void setAccessibilityDelegate(@NonNull View view2, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        View.AccessibilityDelegate bridge;
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

    @UiThread
    public static void setAccessibilityHeading(View view2, boolean z) {
        accessibilityHeadingProperty().set(view2, Boolean.valueOf(z));
    }

    public static void setAccessibilityLiveRegion(@NonNull View view2, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            view2.setAccessibilityLiveRegion(i);
        }
    }

    @UiThread
    public static void setAccessibilityPaneTitle(View view2, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
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
        view2.setActivated(z);
    }

    @Deprecated
    public static void setAlpha(View view2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        view2.setAlpha(f);
    }

    public static void setAutofillHints(@NonNull View view2, @Nullable String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            view2.setAutofillHints(strArr);
        }
    }

    public static void setBackground(@NonNull View view2, @Nullable Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view2.setBackground(drawable);
        } else {
            view2.setBackgroundDrawable(drawable);
        }
    }

    public static void setClipBounds(@NonNull View view2, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view2.setClipBounds(rect);
        }
    }

    public static void setElevation(@NonNull View view2, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view2.setElevation(f);
        }
    }

    @Deprecated
    public static void setFitsSystemWindows(View view2, boolean z) {
        view2.setFitsSystemWindows(z);
    }

    public static void setFocusedByDefault(@NonNull View view2, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            view2.setFocusedByDefault(z);
        }
    }

    public static void setHasTransientState(@NonNull View view2, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view2.setHasTransientState(z);
        }
    }

    public static void setImportantForAccessibility(@NonNull View view2, int i) {
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

    public static void setImportantForAutofill(@NonNull View view2, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view2.setImportantForAutofill(i);
        }
    }

    public static void setKeyboardNavigationCluster(@NonNull View view2, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            view2.setKeyboardNavigationCluster(z);
        }
    }

    public static void setLabelFor(@NonNull View view2, @IdRes int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            view2.setLabelFor(i);
        }
    }

    public static void setLayerPaint(@NonNull View view2, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view2.setLayerPaint(paint);
            return;
        }
        view2.setLayerType(view2.getLayerType(), paint);
        view2.invalidate();
    }

    public static void setLayoutDirection(@NonNull View view2, int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            view2.setLayoutDirection(i);
        }
    }

    public static void setNestedScrollingEnabled(@NonNull View view2, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            view2.setNestedScrollingEnabled(z);
        } else if (view2 instanceof NestedScrollingChild) {
            ((NestedScrollingChild) view2).setNestedScrollingEnabled(z);
        }
    }

    public static void setNextClusterForwardId(@NonNull View view2, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view2.setNextClusterForwardId(i);
        }
    }

    public static void setOnApplyWindowInsetsListener(@NonNull View view2, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.setOnApplyWindowInsetsListener(view2, onApplyWindowInsetsListener);
        }
    }

    @Deprecated
    public static void setOverScrollMode(View view2, int i) {
        view2.setOverScrollMode(i);
    }

    @Deprecated
    public static void setPivotX(View view2, float f) {
        view2.setPivotX(f);
    }

    @Deprecated
    public static void setPivotY(View view2, float f) {
        view2.setPivotY(f);
    }

    public static void setPointerIcon(@NonNull View view2, PointerIconCompat pointerIconCompat) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 24) {
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
        view2.setRotation(f);
    }

    @Deprecated
    public static void setRotationX(View view2, float f) {
        view2.setRotationX(f);
    }

    @Deprecated
    public static void setRotationY(View view2, float f) {
        view2.setRotationY(f);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view2, boolean z) {
        view2.setSaveFromParentEnabled(z);
    }

    @Deprecated
    public static void setScaleX(View view2, float f) {
        view2.setScaleX(f);
    }

    @Deprecated
    public static void setScaleY(View view2, float f) {
        view2.setScaleY(f);
    }

    @UiThread
    public static void setScreenReaderFocusable(View view2, boolean z) {
        screenReaderFocusableProperty().set(view2, Boolean.valueOf(z));
    }

    public static void setScrollIndicators(@NonNull View view2, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            view2.setScrollIndicators(i);
        }
    }

    @UiThread
    public static void setStateDescription(@NonNull View view2, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            stateDescriptionProperty().set(view2, charSequence);
        }
    }

    public static void setSystemGestureExclusionRects(@NonNull View view2, @NonNull List<Rect> list) {
        if (Build.VERSION.SDK_INT >= 29) {
            view2.setSystemGestureExclusionRects(list);
        }
    }

    public static void setTooltipText(@NonNull View view2, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view2.setTooltipText(charSequence);
        }
    }

    public static void setTransitionName(@NonNull View view2, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view2.setTransitionName(str);
            return;
        }
        if (sTransitionNameMap == null) {
            sTransitionNameMap = new WeakHashMap<>();
        }
        sTransitionNameMap.put(view2, str);
    }

    @Deprecated
    public static void setTranslationX(View view2, float f) {
        view2.setTranslationX(f);
    }

    @Deprecated
    public static void setTranslationY(View view2, float f) {
        view2.setTranslationY(f);
    }

    public static void setTranslationZ(@NonNull View view2, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view2.setTranslationZ(f);
        }
    }

    public static void setWindowInsetsAnimationCallback(@NonNull View view2, @Nullable WindowInsetsAnimationCompat.Callback callback) {
        WindowInsetsAnimationCompat.setCallback(view2, callback);
    }

    @Deprecated
    public static void setX(View view2, float f) {
        view2.setX(f);
    }

    @Deprecated
    public static void setY(View view2, float f) {
        view2.setY(f);
    }

    public static void setZ(@NonNull View view2, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view2.setZ(f);
        }
    }

    public static boolean startNestedScroll(@NonNull View view2, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view2.startNestedScroll(i);
        }
        if (view2 instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view2).startNestedScroll(i);
        }
        return false;
    }

    public static void stopNestedScroll(@NonNull View view2, int i) {
        if (view2 instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view2).stopNestedScroll(i);
        } else if (i == 0) {
            stopNestedScroll(view2);
        }
    }

    public static void updateDragShadow(@NonNull View view2, View.DragShadowBuilder dragShadowBuilder) {
        if (Build.VERSION.SDK_INT >= 24) {
            view2.updateDragShadow(dragShadowBuilder);
        }
    }

    @NonNull
    public static ViewPropertyAnimatorCompat animate(@NonNull View view2) {
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

    public static void cancelDragAndDrop(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 24) {
            view2.cancelDragAndDrop();
        }
    }

    public static void dispatchFinishTemporaryDetach(@NonNull View view2) {
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

    public static void dispatchStartTemporaryDetach(@NonNull View view2) {
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

    public static void enableAccessibleClickableSpanSupport(View view2) {
        if (Build.VERSION.SDK_INT >= 19) {
            getOrCreateAccessibilityDelegateCompat(view2);
        }
    }

    @Nullable
    public static AccessibilityDelegateCompat getAccessibilityDelegate(@NonNull View view2) {
        View.AccessibilityDelegate accessibilityDelegateInternal = getAccessibilityDelegateInternal(view2);
        if (accessibilityDelegateInternal == null) {
            return null;
        }
        if (accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
            return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat;
        }
        return new AccessibilityDelegateCompat(accessibilityDelegateInternal);
    }

    @Nullable
    public static View.AccessibilityDelegate getAccessibilityDelegateInternal(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view2.getAccessibilityDelegate();
        }
        return getAccessibilityDelegateThroughReflection(view2);
    }

    @Nullable
    public static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(@NonNull View view2) {
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

    public static int getAccessibilityLiveRegion(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view2.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View view2) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT >= 16 && (accessibilityNodeProvider = view2.getAccessibilityNodeProvider()) != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    @UiThread
    public static CharSequence getAccessibilityPaneTitle(View view2) {
        return paneTitleProperty().get(view2);
    }

    public static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view2) {
        ArrayList arrayList = (ArrayList) view2.getTag(R.id.obfuscated_res_0x7f09239e);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view2.setTag(R.id.obfuscated_res_0x7f09239e, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    @Deprecated
    public static float getAlpha(View view2) {
        return view2.getAlpha();
    }

    public static ColorStateList getBackgroundTintList(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view2.getBackgroundTintList();
        }
        if (view2 instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view2).getSupportBackgroundTintList();
        }
        return null;
    }

    public static PorterDuff.Mode getBackgroundTintMode(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view2.getBackgroundTintMode();
        }
        if (view2 instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view2).getSupportBackgroundTintMode();
        }
        return null;
    }

    @Nullable
    public static Rect getClipBounds(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view2.getClipBounds();
        }
        return null;
    }

    @Nullable
    public static Display getDisplay(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view2.getDisplay();
        }
        if (isAttachedToWindow(view2)) {
            return ((WindowManager) view2.getContext().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay();
        }
        return null;
    }

    public static float getElevation(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view2.getElevation();
        }
        return 0.0f;
    }

    public static OnReceiveContentViewBehavior getFallback(@NonNull View view2) {
        if (view2 instanceof OnReceiveContentViewBehavior) {
            return (OnReceiveContentViewBehavior) view2;
        }
        return NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    public static boolean getFitsSystemWindows(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view2.getFitsSystemWindows();
        }
        return false;
    }

    public static int getImportantForAccessibility(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view2.getImportantForAccessibility();
        }
        return 0;
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view2.getImportantForAutofill();
        }
        return 0;
    }

    public static int getLabelFor(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view2.getLabelFor();
        }
        return 0;
    }

    @Deprecated
    public static int getLayerType(View view2) {
        return view2.getLayerType();
    }

    public static int getLayoutDirection(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view2.getLayoutDirection();
        }
        return 0;
    }

    @Nullable
    @Deprecated
    public static Matrix getMatrix(View view2) {
        return view2.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view2) {
        return view2.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View view2) {
        return view2.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view2) {
        return view2.getMeasuredWidthAndState();
    }

    public static int getMinimumHeight(@NonNull View view2) {
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

    public static int getMinimumWidth(@NonNull View view2) {
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

    public static int getNextClusterForwardId(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view2.getNextClusterForwardId();
        }
        return -1;
    }

    @Nullable
    public static String[] getOnReceiveContentMimeTypes(@NonNull View view2) {
        return (String[]) view2.getTag(R.id.obfuscated_res_0x7f0923dc);
    }

    public static AccessibilityDelegateCompat getOrCreateAccessibilityDelegateCompat(@NonNull View view2) {
        AccessibilityDelegateCompat accessibilityDelegate = getAccessibilityDelegate(view2);
        if (accessibilityDelegate == null) {
            accessibilityDelegate = new AccessibilityDelegateCompat();
        }
        setAccessibilityDelegate(view2, accessibilityDelegate);
        return accessibilityDelegate;
    }

    @Deprecated
    public static int getOverScrollMode(View view2) {
        return view2.getOverScrollMode();
    }

    @Px
    public static int getPaddingEnd(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view2.getPaddingEnd();
        }
        return view2.getPaddingRight();
    }

    @Px
    public static int getPaddingStart(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view2.getPaddingStart();
        }
        return view2.getPaddingLeft();
    }

    public static ViewParent getParentForAccessibility(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view2.getParentForAccessibility();
        }
        return view2.getParent();
    }

    @Deprecated
    public static float getPivotX(View view2) {
        return view2.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View view2) {
        return view2.getPivotY();
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View view2) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return Api23Impl.getRootWindowInsets(view2);
        }
        if (i >= 21) {
            return Api21Impl.getRootWindowInsets(view2);
        }
        return null;
    }

    @Deprecated
    public static float getRotation(View view2) {
        return view2.getRotation();
    }

    @Deprecated
    public static float getRotationX(View view2) {
        return view2.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View view2) {
        return view2.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View view2) {
        return view2.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View view2) {
        return view2.getScaleY();
    }

    public static int getScrollIndicators(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view2.getScrollIndicators();
        }
        return 0;
    }

    @Nullable
    @UiThread
    public static final CharSequence getStateDescription(@NonNull View view2) {
        return stateDescriptionProperty().get(view2);
    }

    @NonNull
    public static List<Rect> getSystemGestureExclusionRects(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view2.getSystemGestureExclusionRects();
        }
        return Collections.emptyList();
    }

    @Nullable
    public static String getTransitionName(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view2.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = sTransitionNameMap;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view2);
    }

    @Deprecated
    public static float getTranslationX(View view2) {
        return view2.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View view2) {
        return view2.getTranslationY();
    }

    public static float getTranslationZ(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view2.getTranslationZ();
        }
        return 0.0f;
    }

    @Nullable
    public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getWindowInsetsController(view2);
        }
        for (Context context = view2.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window == null) {
                    return null;
                }
                return WindowCompat.getInsetsController(window, view2);
            }
        }
        return null;
    }

    public static int getWindowSystemUiVisibility(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view2.getWindowSystemUiVisibility();
        }
        return 0;
    }

    @Deprecated
    public static float getX(View view2) {
        return view2.getX();
    }

    @Deprecated
    public static float getY(View view2) {
        return view2.getY();
    }

    public static float getZ(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view2.getZ();
        }
        return 0.0f;
    }

    public static boolean hasAccessibilityDelegate(@NonNull View view2) {
        if (getAccessibilityDelegateInternal(view2) != null) {
            return true;
        }
        return false;
    }

    public static boolean hasExplicitFocusable(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view2.hasExplicitFocusable();
        }
        return view2.hasFocusable();
    }

    public static boolean hasNestedScrollingParent(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view2.hasNestedScrollingParent();
        }
        if (view2 instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view2).hasNestedScrollingParent();
        }
        return false;
    }

    public static boolean hasOnClickListeners(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view2.hasOnClickListeners();
        }
        return false;
    }

    public static boolean hasOverlappingRendering(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view2.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean hasTransientState(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view2.hasTransientState();
        }
        return false;
    }

    @UiThread
    public static boolean isAccessibilityHeading(View view2) {
        Boolean bool = accessibilityHeadingProperty().get(view2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean isAttachedToWindow(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view2.isAttachedToWindow();
        }
        if (view2.getWindowToken() != null) {
            return true;
        }
        return false;
    }

    public static boolean isFocusedByDefault(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view2.isFocusedByDefault();
        }
        return false;
    }

    public static boolean isImportantForAccessibility(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view2.isImportantForAccessibility();
        }
        return true;
    }

    public static boolean isImportantForAutofill(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view2.isImportantForAutofill();
        }
        return true;
    }

    public static boolean isInLayout(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view2.isInLayout();
        }
        return false;
    }

    public static boolean isKeyboardNavigationCluster(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view2.isKeyboardNavigationCluster();
        }
        return false;
    }

    public static boolean isLaidOut(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view2.isLaidOut();
        }
        if (view2.getWidth() > 0 && view2.getHeight() > 0) {
            return true;
        }
        return false;
    }

    public static boolean isLayoutDirectionResolved(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view2.isLayoutDirectionResolved();
        }
        return false;
    }

    public static boolean isNestedScrollingEnabled(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view2.isNestedScrollingEnabled();
        }
        if (view2 instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view2).isNestedScrollingEnabled();
        }
        return false;
    }

    @Deprecated
    public static boolean isOpaque(View view2) {
        return view2.isOpaque();
    }

    public static boolean isPaddingRelative(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view2.isPaddingRelative();
        }
        return false;
    }

    @UiThread
    public static boolean isScreenReaderFocusable(View view2) {
        Boolean bool = screenReaderFocusableProperty().get(view2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view2) {
        view2.jumpDrawablesToCurrentState();
    }

    public static void postInvalidateOnAnimation(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view2.postInvalidateOnAnimation();
        } else {
            view2.postInvalidate();
        }
    }

    public static void requestApplyInsets(@NonNull View view2) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            view2.requestApplyInsets();
        } else if (i >= 16) {
            view2.requestFitSystemWindows();
        }
    }

    public static boolean restoreDefaultFocus(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view2.restoreDefaultFocus();
        }
        return view2.requestFocus();
    }

    public static void setViewImportanceForAccessibilityIfNeeded(View view2) {
        if (getImportantForAccessibility(view2) == 0) {
            setImportantForAccessibility(view2, 1);
        }
        for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (getImportantForAccessibility((View) parent) == 4) {
                setImportantForAccessibility(view2, 2);
                return;
            }
        }
    }

    public static void stopNestedScroll(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view2.stopNestedScroll();
        } else if (view2 instanceof NestedScrollingChild) {
            ((NestedScrollingChild) view2).stopNestedScroll();
        }
    }

    public static void tickleInvalidationFlag(View view2) {
        float translationY = view2.getTranslationY();
        view2.setTranslationY(1.0f + translationY);
        view2.setTranslationY(translationY);
    }

    public static boolean dispatchNestedFling(@NonNull View view2, float f, float f2, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view2.dispatchNestedFling(f, f2, z);
        }
        if (view2 instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view2).dispatchNestedFling(f, f2, z);
        }
        return false;
    }

    public static void replaceAccessibilityAction(@NonNull View view2, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, @Nullable CharSequence charSequence, @Nullable AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            removeAccessibilityAction(view2, accessibilityActionCompat.getId());
        } else {
            addAccessibilityAction(view2, accessibilityActionCompat.createReplacementAction(charSequence, accessibilityViewCommand));
        }
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view2, int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view2.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }
        if (view2 instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view2).dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }
        return false;
    }

    public static void postInvalidateOnAnimation(@NonNull View view2, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 16) {
            view2.postInvalidateOnAnimation(i, i2, i3, i4);
        } else {
            view2.postInvalidate(i, i2, i3, i4);
        }
    }

    public static void setPaddingRelative(@NonNull View view2, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            view2.setPaddingRelative(i, i2, i3, i4);
        } else {
            view2.setPadding(i, i2, i3, i4);
        }
    }

    public static boolean startDragAndDrop(@NonNull View view2, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return view2.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
        }
        return view2.startDrag(clipData, dragShadowBuilder, obj, i);
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view2, int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2, int i3) {
        if (view2 instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view2).dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        }
        if (i3 == 0) {
            return dispatchNestedPreScroll(view2, i, i2, iArr, iArr2);
        }
        return false;
    }

    public static boolean dispatchNestedScroll(@NonNull View view2, int i, int i2, int i3, int i4, @Nullable int[] iArr) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view2.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }
        if (view2 instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view2).dispatchNestedScroll(i, i2, i3, i4, iArr);
        }
        return false;
    }

    public static void dispatchNestedScroll(@NonNull View view2, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, @NonNull int[] iArr2) {
        if (view2 instanceof NestedScrollingChild3) {
            ((NestedScrollingChild3) view2).dispatchNestedScroll(i, i2, i3, i4, iArr, i5, iArr2);
        } else {
            dispatchNestedScroll(view2, i, i2, i3, i4, iArr, i5);
        }
    }

    public static boolean dispatchNestedScroll(@NonNull View view2, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5) {
        if (view2 instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view2).dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }
        if (i5 == 0) {
            return dispatchNestedScroll(view2, i, i2, i3, i4, iArr);
        }
        return false;
    }

    public static void saveAttributeDataForStyleable(@NonNull View view2, @NonNull @SuppressLint({"ContextFirst"}) Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.saveAttributeDataForStyleable(view2, context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    public static int getAvailableActionIdFromResources(View view2, @NonNull CharSequence charSequence) {
        boolean z;
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view2);
        for (int i = 0; i < actionList.size(); i++) {
            if (TextUtils.equals(charSequence, actionList.get(i).getLabel())) {
                return actionList.get(i).getId();
            }
        }
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int[] iArr = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
            if (i2 >= iArr.length || i3 != -1) {
                break;
            }
            int i4 = iArr[i2];
            boolean z2 = true;
            for (int i5 = 0; i5 < actionList.size(); i5++) {
                if (actionList.get(i5).getId() != i4) {
                    z = true;
                } else {
                    z = false;
                }
                z2 &= z;
            }
            if (z2) {
                i3 = i4;
            }
            i2++;
        }
        return i3;
    }

    @Nullable
    public static ContentInfoCompat performReceiveContent(@NonNull View view2, @NonNull ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "performReceiveContent: " + contentInfoCompat + ", view=" + view2.getClass().getSimpleName() + PreferencesUtil.LEFT_MOUNT + view2.getId() + PreferencesUtil.RIGHT_MOUNT);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view2.getTag(R.id.obfuscated_res_0x7f0923db);
        if (onReceiveContentListener != null) {
            ContentInfoCompat onReceiveContent = onReceiveContentListener.onReceiveContent(view2, contentInfoCompat);
            if (onReceiveContent == null) {
                return null;
            }
            return getFallback(view2).onReceiveContent(onReceiveContent);
        }
        return getFallback(view2).onReceiveContent(contentInfoCompat);
    }

    @RequiresApi(19)
    public static void notifyViewAccessibilityStateChangedIfNeeded(View view2, int i) {
        boolean z;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view2.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        if (getAccessibilityPaneTitle(view2) != null && view2.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        int i2 = 32;
        if (getAccessibilityLiveRegion(view2) == 0 && !z) {
            if (i == 32) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                view2.onInitializeAccessibilityEvent(obtain);
                obtain.setEventType(32);
                obtain.setContentChangeTypes(i);
                obtain.setSource(view2);
                view2.onPopulateAccessibilityEvent(obtain);
                obtain.getText().add(getAccessibilityPaneTitle(view2));
                accessibilityManager.sendAccessibilityEvent(obtain);
                return;
            } else if (view2.getParent() != null) {
                try {
                    view2.getParent().notifySubtreeAccessibilityStateChanged(view2, view2, i);
                    return;
                } catch (AbstractMethodError e) {
                    Log.e(TAG, view2.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
                    return;
                }
            } else {
                return;
            }
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
        if (!z) {
            i2 = 2048;
        }
        obtain2.setEventType(i2);
        obtain2.setContentChangeTypes(i);
        if (z) {
            obtain2.getText().add(getAccessibilityPaneTitle(view2));
            setViewImportanceForAccessibilityIfNeeded(view2);
        }
        view2.sendAccessibilityEventUnchecked(obtain2);
    }

    public static void offsetLeftAndRight(@NonNull View view2, int i) {
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

    public static void offsetTopAndBottom(@NonNull View view2, int i) {
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

    public static void setBackgroundTintList(@NonNull View view2, ColorStateList colorStateList) {
        boolean z;
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

    public static void setBackgroundTintMode(@NonNull View view2, PorterDuff.Mode mode) {
        boolean z;
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

    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
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

    public static void setOnReceiveContentListener(@NonNull View view2, @Nullable String[] strArr, @Nullable OnReceiveContentListener onReceiveContentListener) {
        boolean z;
        strArr = (strArr == null || strArr.length == 0) ? null : null;
        boolean z2 = false;
        if (onReceiveContentListener != null) {
            if (strArr != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "When the listener is set, MIME types must also be set");
        }
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (strArr[i].startsWith("*")) {
                    z2 = true;
                    break;
                } else {
                    i++;
                }
            }
            Preconditions.checkArgument(!z2, "A MIME type set here must not start with *: " + Arrays.toString(strArr));
        }
        view2.setTag(R.id.obfuscated_res_0x7f0923dc, strArr);
        view2.setTag(R.id.obfuscated_res_0x7f0923db, onReceiveContentListener);
    }
}
