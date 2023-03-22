package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.R;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.baidu.android.common.others.IStringUtil;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    public static final Class<?>[] CONSTRUCTOR_PARAMS;
    public static final int EVENT_NESTED_SCROLL = 1;
    public static final int EVENT_PRE_DRAW = 0;
    public static final int EVENT_VIEW_REMOVED = 2;
    public static final String TAG = "CoordinatorLayout";
    public static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    public static final int TYPE_ON_INTERCEPT = 0;
    public static final int TYPE_ON_TOUCH = 1;
    public static final String WIDGET_PACKAGE_NAME;
    public static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors;
    public static final Pools.Pool<Rect> sRectPool;
    public OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    public final int[] mBehaviorConsumed;
    public View mBehaviorTouchView;
    public final DirectedAcyclicGraph<View> mChildDag;
    public final List<View> mDependencySortedChildren;
    public boolean mDisallowInterceptReset;
    public boolean mDrawStatusBarBackground;
    public boolean mIsAttachedToWindow;
    public int[] mKeylines;
    public WindowInsetsCompat mLastInsets;
    public boolean mNeedsPreDrawListener;
    public final NestedScrollingParentHelper mNestedScrollingParentHelper;
    public View mNestedScrollingTarget;
    public final int[] mNestedScrollingV2ConsumedCompat;
    public ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    public OnPreDrawListener mOnPreDrawListener;
    public Paint mScrimPaint;
    public Drawable mStatusBarBackground;
    public final List<View> mTempDependenciesList;
    public final List<View> mTempList1;

    /* loaded from: classes.dex */
    public interface AttachedBehavior {
        @NonNull
        Behavior getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface DispatchChangeEvent {
    }

    public static int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static int resolveAnchoredChildGravity(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    public static int resolveGravity(int i) {
        if ((i & 7) == 0) {
            i |= GravityCompat.START;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    public static int resolveKeylineGravity(int i) {
        return i == 0 ? BadgeDrawable.TOP_END : i;
    }

    /* loaded from: classes.dex */
    public static abstract class Behavior<V extends View> {
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Rect rect) {
            return false;
        }

        @ColorInt
        public int getScrimColor(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            return -16777216;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getScrimOpacity(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            return 0.0f;
        }

        public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2) {
            return false;
        }

        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void onAttachedToLayoutParams(@NonNull LayoutParams layoutParams) {
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2) {
            return false;
        }

        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
            return false;
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, float f, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, float f, float f2) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i, int i2, @NonNull int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, @NonNull View view3, int i) {
        }

        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Parcelable parcelable) {
        }

        @Deprecated
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, @NonNull View view3, int i) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2) {
        }

        public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public static void setTag(@NonNull View view2, @Nullable Object obj) {
            ((LayoutParams) view2.getLayoutParams()).mBehaviorTag = obj;
        }

        public boolean blocksInteractionBelow(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            if (getScrimOpacity(coordinatorLayout, v) > 0.0f) {
                return true;
            }
            return false;
        }

        @Nullable
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Nullable
        public static Object getTag(@NonNull View view2) {
            return ((LayoutParams) view2.getLayoutParams()).mBehaviorTag;
        }

        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i, int i2, @NonNull int[] iArr, int i3) {
            if (i3 == 0) {
                onNestedPreScroll(coordinatorLayout, v, view2, i, i2, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                onNestedScroll(coordinatorLayout, v, view2, i, i2, i3, i4);
            }
        }

        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i, int i2, int i3, int i4, int i5, @NonNull int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            onNestedScroll(coordinatorLayout, v, view2, i, i2, i3, i4, i5);
        }

        public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, @NonNull View view3, int i, int i2) {
            if (i2 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v, view2, view3, i);
            }
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, @NonNull View view3, int i, int i2) {
            if (i2 == 0) {
                return onStartNestedScroll(coordinatorLayout, v, view2, view3, i);
            }
            return false;
        }

        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i) {
            if (i == 0) {
                onStopNestedScroll(coordinatorLayout, v, view2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        public HierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view2, view3);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view2, view3);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int anchorGravity;
        public int dodgeInsetEdges;
        public int gravity;
        public int insetEdge;
        public int keyline;
        public View mAnchorDirectChild;
        public int mAnchorId;
        public View mAnchorView;
        public Behavior mBehavior;
        public boolean mBehaviorResolved;
        public Object mBehaviorTag;
        public boolean mDidAcceptNestedScrollNonTouch;
        public boolean mDidAcceptNestedScrollTouch;
        public boolean mDidBlockInteraction;
        public boolean mDidChangeAfterNestedScroll;
        public int mInsetOffsetX;
        public int mInsetOffsetY;
        public final Rect mLastChildRect;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        private boolean shouldDodge(View view2, int i) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams) view2.getLayoutParams()).insetEdge, i);
            if (absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, i) & absoluteGravity) == absoluteGravity) {
                return true;
            }
            return false;
        }

        private boolean verifyAnchorView(View view2, CoordinatorLayout coordinatorLayout) {
            if (this.mAnchorView.getId() != this.mAnchorId) {
                return false;
            }
            View view3 = this.mAnchorView;
            for (ViewParent parent = view3.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent != null && parent != view2) {
                    if (parent instanceof View) {
                        view3 = (View) parent;
                    }
                } else {
                    this.mAnchorDirectChild = null;
                    this.mAnchorView = null;
                    return false;
                }
            }
            this.mAnchorDirectChild = view3;
            return true;
        }

        public View findAnchorView(CoordinatorLayout coordinatorLayout, View view2) {
            if (this.mAnchorId == -1) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return null;
            }
            if (this.mAnchorView == null || !verifyAnchorView(view2, coordinatorLayout)) {
                resolveAnchorView(view2, coordinatorLayout);
            }
            return this.mAnchorView;
        }

        public boolean isBlockingInteractionBelow(CoordinatorLayout coordinatorLayout, View view2) {
            boolean z;
            boolean z2 = this.mDidBlockInteraction;
            if (z2) {
                return true;
            }
            Behavior behavior = this.mBehavior;
            if (behavior != null) {
                z = behavior.blocksInteractionBelow(coordinatorLayout, view2);
            } else {
                z = false;
            }
            boolean z3 = z | z2;
            this.mDidBlockInteraction = z3;
            return z3;
        }

        public void setNestedScrollAccepted(int i, boolean z) {
            if (i != 0) {
                if (i == 1) {
                    this.mDidAcceptNestedScrollNonTouch = z;
                    return;
                }
                return;
            }
            this.mDidAcceptNestedScrollTouch = z;
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(0, 0);
            this.mAnchorId = obtainStyledAttributes.getResourceId(1, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(2, 0);
            this.keyline = obtainStyledAttributes.getInteger(6, -1);
            this.insetEdge = obtainStyledAttributes.getInt(5, 0);
            this.dodgeInsetEdges = obtainStyledAttributes.getInt(4, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(3);
            this.mBehaviorResolved = hasValue;
            if (hasValue) {
                this.mBehavior = CoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(3));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.mBehavior;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }

        private void resolveAnchorView(View view2, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.mAnchorId);
            this.mAnchorView = findViewById;
            if (findViewById != null) {
                if (findViewById == coordinatorLayout) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.mAnchorDirectChild = null;
                        this.mAnchorView = null;
                        return;
                    }
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view2) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.mAnchorDirectChild = null;
                            this.mAnchorView = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (parent instanceof View) {
                        findViewById = (View) parent;
                    }
                }
                this.mAnchorDirectChild = findViewById;
            } else if (coordinatorLayout.isInEditMode()) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.mAnchorId) + " to anchor view " + view2);
            }
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public boolean isNestedScrollAccepted(int i) {
            if (i != 0) {
                if (i != 1) {
                    return false;
                }
                return this.mDidAcceptNestedScrollNonTouch;
            }
            return this.mDidAcceptNestedScrollTouch;
        }

        public void resetNestedScroll(int i) {
            setNestedScrollAccepted(i, false);
        }

        public void setAnchorId(@IdRes int i) {
            invalidateAnchor();
            this.mAnchorId = i;
        }

        public void setBehavior(@Nullable Behavior behavior) {
            Behavior behavior2 = this.mBehavior;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.onDetachedFromLayoutParams();
                }
                this.mBehavior = behavior;
                this.mBehaviorTag = null;
                this.mBehaviorResolved = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        public void setChangedAfterNestedScroll(boolean z) {
            this.mDidChangeAfterNestedScroll = z;
        }

        public void setLastChildRect(Rect rect) {
            this.mLastChildRect.set(rect);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public boolean checkAnchorChanged() {
            if (this.mAnchorView == null && this.mAnchorId != -1) {
                return true;
            }
            return false;
        }

        public boolean didBlockInteraction() {
            if (this.mBehavior == null) {
                this.mDidBlockInteraction = false;
            }
            return this.mDidBlockInteraction;
        }

        @IdRes
        public int getAnchorId() {
            return this.mAnchorId;
        }

        @Nullable
        public Behavior getBehavior() {
            return this.mBehavior;
        }

        public boolean getChangedAfterNestedScroll() {
            return this.mDidChangeAfterNestedScroll;
        }

        public Rect getLastChildRect() {
            return this.mLastChildRect;
        }

        public void invalidateAnchor() {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
        }

        public void resetChangedAfterNestedScroll() {
            this.mDidChangeAfterNestedScroll = false;
        }

        public void resetTouchBehaviorTracking() {
            this.mDidBlockInteraction = false;
        }

        public boolean dependsOn(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            Behavior behavior;
            if (view3 != this.mAnchorDirectChild && !shouldDodge(view3, ViewCompat.getLayoutDirection(coordinatorLayout)) && ((behavior = this.mBehavior) == null || !behavior.layoutDependsOn(coordinatorLayout, view2, view3))) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        public OnPreDrawListener() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    static {
        String str;
        Package r0 = CoordinatorLayout.class.getPackage();
        if (r0 != null) {
            str = r0.getName();
        } else {
            str = null;
        }
        WIDGET_PACKAGE_NAME = str;
        if (Build.VERSION.SDK_INT >= 21) {
            TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
        } else {
            TOP_SORTED_CHILDREN_COMPARATOR = null;
        }
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal<>();
        sRectPool = new Pools.SynchronizedPool(12);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
            if (id != -1 && behavior != null && (onSaveInstanceState = behavior.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id, onSaveInstanceState);
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        };
        public SparseArray<Parcelable> behaviorStates;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.behaviorStates.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.behaviorStates;
            if (sparseArray != null) {
                i2 = sparseArray.size();
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            int[] iArr = new int[i2];
            Parcelable[] parcelableArr = new Parcelable[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                iArr[i3] = this.behaviorStates.keyAt(i3);
                parcelableArr[i3] = this.behaviorStates.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    /* loaded from: classes.dex */
    public static class ViewElevationComparator implements Comparator<View> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(View view2, View view3) {
            float z = ViewCompat.getZ(view2);
            float z2 = ViewCompat.getZ(view3);
            if (z > z2) {
                return -1;
            }
            if (z < z2) {
                return 1;
            }
            return 0;
        }
    }

    public CoordinatorLayout(@NonNull Context context) {
        this(context, null);
    }

    private void getTopSortedChildren(List<View> list) {
        int i;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            if (isChildrenDrawingOrderEnabled) {
                i = getChildDrawingOrder(childCount, i2);
            } else {
                i = i2;
            }
            list.add(getChildAt(i));
        }
        Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean hasDependencies(View view2) {
        return this.mChildDag.hasOutgoingEdges(view2);
    }

    public static void releaseTempRect(@NonNull Rect rect) {
        rect.setEmpty();
        sRectPool.release(rect);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    public void dispatchDependentViewsChanged(@NonNull View view2) {
        List incomingEdges = this.mChildDag.getIncomingEdges(view2);
        if (incomingEdges != null && !incomingEdges.isEmpty()) {
            for (int i = 0; i < incomingEdges.size(); i++) {
                View view3 = (View) incomingEdges.get(i);
                Behavior behavior = ((LayoutParams) view3.getLayoutParams()).getBehavior();
                if (behavior != null) {
                    behavior.onDependentViewChanged(this, view3, view2);
                }
            }
        }
    }

    @NonNull
    public List<View> getDependencies(@NonNull View view2) {
        List<View> outgoingEdges = this.mChildDag.getOutgoingEdges(view2);
        this.mTempDependenciesList.clear();
        if (outgoingEdges != null) {
            this.mTempDependenciesList.addAll(outgoingEdges);
        }
        return this.mTempDependenciesList;
    }

    @NonNull
    public List<View> getDependents(@NonNull View view2) {
        List incomingEdges = this.mChildDag.getIncomingEdges(view2);
        this.mTempDependenciesList.clear();
        if (incomingEdges != null) {
            this.mTempDependenciesList.addAll(incomingEdges);
        }
        return this.mTempDependenciesList;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
            if (windowInsetsCompat != null) {
                i = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i = 0;
            }
            if (i > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), i);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean performIntercept = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            resetTouchBehaviors(true);
        }
        return performIntercept;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view2) {
        onStopNestedScroll(view2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.mDisallowInterceptReset) {
            resetTouchBehaviors(false);
            this.mDisallowInterceptReset = true;
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setStatusBarBackgroundColor(@ColorInt int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(@DrawableRes int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = ContextCompat.getDrawable(getContext(), i);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        Drawable drawable = this.mStatusBarBackground;
        if (drawable != null && drawable.isVisible() != z) {
            this.mStatusBarBackground.setVisible(z, false);
        }
    }

    public final WindowInsetsCompat setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        boolean z;
        if (!ObjectsCompat.equals(this.mLastInsets, windowInsetsCompat)) {
            this.mLastInsets = windowInsetsCompat;
            boolean z2 = true;
            if (windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0) {
                z = true;
            } else {
                z = false;
            }
            this.mDrawStatusBarBackground = z;
            setWillNotDraw((z || getBackground() != null) ? false : false);
            WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors = dispatchApplyWindowInsetsToBehaviors(windowInsetsCompat);
            requestLayout();
            return dispatchApplyWindowInsetsToBehaviors;
        }
        return windowInsetsCompat;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.mStatusBarBackground) {
            return false;
        }
        return true;
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.baidu.tieba.R.attr.obfuscated_res_0x7f04019f);
    }

    private void setInsetOffsetX(View view2, int i) {
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        int i2 = layoutParams.mInsetOffsetX;
        if (i2 != i) {
            ViewCompat.offsetLeftAndRight(view2, i - i2);
            layoutParams.mInsetOffsetX = i;
        }
    }

    private void setInsetOffsetY(View view2, int i) {
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        int i2 = layoutParams.mInsetOffsetY;
        if (i2 != i) {
            ViewCompat.offsetTopAndBottom(view2, i - i2);
            layoutParams.mInsetOffsetY = i;
        }
    }

    public void getDescendantRect(View view2, Rect rect) {
        ViewGroupUtils.getDescendantRect(this, view2, rect);
    }

    public void getLastChildRect(View view2, Rect rect) {
        rect.set(((LayoutParams) view2.getLayoutParams()).getLastChildRect());
    }

    public void onLayoutChild(@NonNull View view2, int i) {
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if (!layoutParams.checkAnchorChanged()) {
            View view3 = layoutParams.mAnchorView;
            if (view3 != null) {
                layoutChildWithAnchor(view2, view3, i);
                return;
            }
            int i2 = layoutParams.keyline;
            if (i2 >= 0) {
                layoutChildWithKeyline(view2, i2, i);
                return;
            } else {
                layoutChild(view2, i);
                return;
            }
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    public void recordLastChildRect(View view2, Rect rect) {
        ((LayoutParams) view2.getLayoutParams()).setLastChildRect(rect);
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        if (i == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, com.baidu.tieba.R.style.obfuscated_res_0x7f1003a2);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i == 0) {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, obtainStyledAttributes, 0, com.baidu.tieba.R.style.obfuscated_res_0x7f1003a2);
            } else {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, obtainStyledAttributes, i, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr = this.mKeylines;
                iArr[i2] = (int) (iArr[i2] * f);
            }
        }
        this.mStatusBarBackground = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public static Behavior parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(WIDGET_PACKAGE_NAME)) {
            str = WIDGET_PACKAGE_NAME + IStringUtil.EXTENSION_SEPARATOR + str;
        }
        try {
            Map<String, Constructor<Behavior>> map = sConstructors.get();
            if (map == null) {
                map = new HashMap<>();
                sConstructors.set(map);
            }
            Constructor<Behavior> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    @NonNull
    public static Rect acquireTempRect() {
        Rect acquire = sRectPool.acquire();
        if (acquire == null) {
            return new Rect();
        }
        return acquire;
    }

    private void setupForInsets() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (ViewCompat.getFitsSystemWindows(this)) {
            if (this.mApplyWindowInsetsListener == null) {
                this.mApplyWindowInsetsListener = new OnApplyWindowInsetsListener() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.1
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                        return CoordinatorLayout.this.setWindowInsets(windowInsetsCompat);
                    }
                };
            }
            ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
    }

    public void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public void ensurePreDrawListener() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (hasDependencies(getChildAt(i))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z != this.mNeedsPreDrawListener) {
            if (z) {
                addPreDrawListener();
            } else {
                removePreDrawListener();
            }
        }
    }

    @VisibleForTesting
    public final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view2 = this.mNestedScrollingTarget;
        if (view2 != null) {
            onStopNestedScroll(view2);
        }
        this.mIsAttachedToWindow = false;
    }

    public void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    private void constrainChildRect(LayoutParams layoutParams, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view2, float f, float f2, boolean z) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0) && (behavior = layoutParams.getBehavior()) != null) {
                    z2 |= behavior.onNestedFling(this, childAt, view2, f, f2, z);
                }
            }
        }
        if (z2) {
            onChildViewsChanged(1);
        }
        return z2;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view2, View view3, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    boolean onStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view2, view3, i, i2);
                    z |= onStartNestedScroll;
                    layoutParams.setNestedScrollAccepted(i2, onStartNestedScroll);
                } else {
                    layoutParams.setNestedScrollAccepted(i2, false);
                }
            }
        }
        return z;
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat windowInsetsCompat) {
        Behavior behavior;
        if (windowInsetsCompat.isConsumed()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (ViewCompat.getFitsSystemWindows(childAt) && (behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior()) != null) {
                windowInsetsCompat = behavior.onApplyWindowInsets(this, childAt, windowInsetsCompat);
                if (windowInsetsCompat.isConsumed()) {
                    break;
                }
            }
        }
        return windowInsetsCompat;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.behaviorStates;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = getResolvedLayoutParams(childAt).getBehavior();
            if (id != -1 && behavior != null && (parcelable2 = sparseArray.get(id)) != null) {
                behavior.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        boolean z;
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.mStatusBarBackground = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
                Drawable drawable4 = this.mStatusBarBackground;
                if (getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                drawable4.setVisible(z, false);
                this.mStatusBarBackground.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view2, int i, Rect rect, Rect rect2, LayoutParams layoutParams, int i2, int i3) {
        int width;
        int height;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(layoutParams.gravity), i);
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(resolveGravity(layoutParams.anchorGravity), i);
        int i4 = absoluteGravity & 7;
        int i5 = absoluteGravity & 112;
        int i6 = absoluteGravity2 & 7;
        int i7 = absoluteGravity2 & 112;
        if (i6 != 1) {
            if (i6 != 5) {
                width = rect.left;
            } else {
                width = rect.right;
            }
        } else {
            width = rect.left + (rect.width() / 2);
        }
        if (i7 != 16) {
            if (i7 != 80) {
                height = rect.top;
            } else {
                height = rect.bottom;
            }
        } else {
            height = rect.top + (rect.height() / 2);
        }
        if (i4 != 1) {
            if (i4 != 5) {
                width -= i2;
            }
        } else {
            width -= i2 / 2;
        }
        if (i5 != 16) {
            if (i5 != 80) {
                height -= i3;
            }
        } else {
            height -= i3 / 2;
        }
        rect2.set(width, height, i2 + width, i3 + height);
    }

    private int getKeyline(int i) {
        int[] iArr = this.mKeylines;
        if (iArr == null) {
            Log.e(TAG, "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < iArr.length) {
            return iArr[i];
        } else {
            Log.e(TAG, "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    private void resetTouchBehaviors(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    behavior.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    behavior.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((LayoutParams) getChildAt(i2).getLayoutParams()).resetTouchBehaviorTracking();
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean onTouchEvent;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        if (this.mBehaviorTouchView == null) {
            z = performIntercept(motionEvent, 1);
        } else {
            z = false;
        }
        Behavior behavior = ((LayoutParams) this.mBehaviorTouchView.getLayoutParams()).getBehavior();
        if (behavior != null) {
            onTouchEvent = behavior.onTouchEvent(this, this.mBehaviorTouchView, motionEvent);
            motionEvent2 = null;
            if (this.mBehaviorTouchView != null) {
                onTouchEvent |= super.onTouchEvent(motionEvent);
            } else if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEvent2);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            if (actionMasked != 1 || actionMasked == 3) {
                resetTouchBehaviors(false);
            }
            return onTouchEvent;
        }
        onTouchEvent = false;
        motionEvent2 = null;
        if (this.mBehaviorTouchView != null) {
        }
        if (motionEvent2 != null) {
        }
        if (actionMasked != 1) {
        }
        resetTouchBehaviors(false);
        return onTouchEvent;
    }

    private void layoutChild(View view2, int i) {
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        Rect acquireTempRect = acquireTempRect();
        acquireTempRect.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        if (this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view2)) {
            acquireTempRect.left += this.mLastInsets.getSystemWindowInsetLeft();
            acquireTempRect.top += this.mLastInsets.getSystemWindowInsetTop();
            acquireTempRect.right -= this.mLastInsets.getSystemWindowInsetRight();
            acquireTempRect.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
        }
        Rect acquireTempRect2 = acquireTempRect();
        GravityCompat.apply(resolveGravity(layoutParams.gravity), view2.getMeasuredWidth(), view2.getMeasuredHeight(), acquireTempRect, acquireTempRect2, i);
        view2.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
    }

    private void layoutChildWithAnchor(View view2, View view3, int i) {
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view3, acquireTempRect);
            getDesiredAnchoredChildRect(view2, i, acquireTempRect, acquireTempRect2);
            view2.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    public void getChildRect(View view2, boolean z, Rect rect) {
        if (!view2.isLayoutRequested() && view2.getVisibility() != 8) {
            if (z) {
                getDescendantRect(view2, rect);
                return;
            } else {
                rect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                return;
            }
        }
        rect.setEmpty();
    }

    public boolean isPointInChildBounds(@NonNull View view2, int i, int i2) {
        Rect acquireTempRect = acquireTempRect();
        getDescendantRect(view2, acquireTempRect);
        try {
            return acquireTempRect.contains(i, i2);
        } finally {
            releaseTempRect(acquireTempRect);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view2, View view3, int i) {
        onNestedScrollAccepted(view2, view3, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view2, View view3, int i) {
        return onStartNestedScroll(view2, view3, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view2, Rect rect, boolean z) {
        Behavior behavior = ((LayoutParams) view2.getLayoutParams()).getBehavior();
        if (behavior != null && behavior.onRequestChildRectangleOnScreen(this, view2, rect, z)) {
            return true;
        }
        return super.requestChildRectangleOnScreen(view2, rect, z);
    }

    private void layoutChildWithKeyline(View view2, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(layoutParams.gravity), i2);
        int i3 = absoluteGravity & 7;
        int i4 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view2.getMeasuredWidth();
        int measuredHeight = view2.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int keyline = getKeyline(i) - measuredWidth;
        int i5 = 0;
        if (i3 != 1) {
            if (i3 == 5) {
                keyline += measuredWidth;
            }
        } else {
            keyline += measuredWidth / 2;
        }
        if (i4 != 16) {
            if (i4 == 80) {
                i5 = measuredHeight + 0;
            }
        } else {
            i5 = 0 + (measuredHeight / 2);
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
        view2.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view2, long j) {
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        Behavior behavior = layoutParams.mBehavior;
        if (behavior != null) {
            float scrimOpacity = behavior.getScrimOpacity(this, view2);
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(layoutParams.mBehavior.getScrimColor(this, view2));
                this.mScrimPaint.setAlpha(clamp(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view2.isOpaque()) {
                    canvas.clipRect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view2, j);
    }

    private void offsetChildByInset(View view2, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int i3;
        int i4;
        int height;
        int i5;
        int i6;
        int i7;
        if (ViewCompat.isLaidOut(view2) && view2.getWidth() > 0 && view2.getHeight() > 0) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            Behavior behavior = layoutParams.getBehavior();
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            acquireTempRect2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            if (behavior != null && behavior.getInsetDodgeRect(this, view2, acquireTempRect)) {
                if (!acquireTempRect2.contains(acquireTempRect)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + acquireTempRect.toShortString() + " | Bounds:" + acquireTempRect2.toShortString());
                }
            } else {
                acquireTempRect.set(acquireTempRect2);
            }
            releaseTempRect(acquireTempRect2);
            if (acquireTempRect.isEmpty()) {
                releaseTempRect(acquireTempRect);
                return;
            }
            int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.dodgeInsetEdges, i);
            boolean z3 = true;
            if ((absoluteGravity & 48) == 48 && (i6 = (acquireTempRect.top - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - layoutParams.mInsetOffsetY) < (i7 = rect.top)) {
                setInsetOffsetY(view2, i7 - i6);
                z = true;
            } else {
                z = false;
            }
            if ((absoluteGravity & 80) == 80 && (height = ((getHeight() - acquireTempRect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + layoutParams.mInsetOffsetY) < (i5 = rect.bottom)) {
                setInsetOffsetY(view2, height - i5);
                z = true;
            }
            if (!z) {
                setInsetOffsetY(view2, 0);
            }
            if ((absoluteGravity & 3) == 3 && (i3 = (acquireTempRect.left - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - layoutParams.mInsetOffsetX) < (i4 = rect.left)) {
                setInsetOffsetX(view2, i4 - i3);
                z2 = true;
            } else {
                z2 = false;
            }
            if ((absoluteGravity & 5) == 5 && (width = ((getWidth() - acquireTempRect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + layoutParams.mInsetOffsetX) < (i2 = rect.right)) {
                setInsetOffsetX(view2, width - i2);
            } else {
                z3 = z2;
            }
            if (!z3) {
                setInsetOffsetX(view2, 0);
            }
            releaseTempRect(acquireTempRect);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.mTempList1;
        getTopSortedChildren(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = list.get(i2);
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            Behavior behavior = layoutParams.getBehavior();
            if ((z || z2) && actionMasked != 0) {
                if (behavior != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i != 0) {
                        if (i == 1) {
                            behavior.onTouchEvent(this, view2, motionEvent2);
                        }
                    } else {
                        behavior.onInterceptTouchEvent(this, view2, motionEvent2);
                    }
                }
            } else {
                if (!z && behavior != null) {
                    if (i != 0) {
                        if (i == 1) {
                            z = behavior.onTouchEvent(this, view2, motionEvent);
                        }
                    } else {
                        z = behavior.onInterceptTouchEvent(this, view2, motionEvent);
                    }
                    if (z) {
                        this.mBehaviorTouchView = view2;
                    }
                }
                boolean didBlockInteraction = layoutParams.didBlockInteraction();
                boolean isBlockingInteractionBelow = layoutParams.isBlockingInteractionBelow(this, view2);
                if (isBlockingInteractionBelow && !didBlockInteraction) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (isBlockingInteractionBelow && !z2) {
                    break;
                }
            }
        }
        list.clear();
        return z;
    }

    public void offsetChildToAnchor(View view2, int i) {
        Behavior behavior;
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if (layoutParams.mAnchorView != null) {
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            Rect acquireTempRect3 = acquireTempRect();
            getDescendantRect(layoutParams.mAnchorView, acquireTempRect);
            boolean z = false;
            getChildRect(view2, false, acquireTempRect2);
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = view2.getMeasuredHeight();
            getDesiredAnchoredChildRectWithoutConstraints(view2, i, acquireTempRect, acquireTempRect3, layoutParams, measuredWidth, measuredHeight);
            z = (acquireTempRect3.left == acquireTempRect2.left && acquireTempRect3.top == acquireTempRect2.top) ? true : true;
            constrainChildRect(layoutParams, acquireTempRect3, measuredWidth, measuredHeight);
            int i2 = acquireTempRect3.left - acquireTempRect2.left;
            int i3 = acquireTempRect3.top - acquireTempRect2.top;
            if (i2 != 0) {
                ViewCompat.offsetLeftAndRight(view2, i2);
            }
            if (i3 != 0) {
                ViewCompat.offsetTopAndBottom(view2, i3);
            }
            if (z && (behavior = layoutParams.getBehavior()) != null) {
                behavior.onDependentViewChanged(this, view2, layoutParams.mAnchorView);
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
            releaseTempRect(acquireTempRect3);
        }
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams resolvedLayoutParams = getResolvedLayoutParams(childAt);
            resolvedLayoutParams.findAnchorView(this, childAt);
            this.mChildDag.addNode(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (resolvedLayoutParams.dependsOn(this, childAt, childAt2)) {
                        if (!this.mChildDag.contains(childAt2)) {
                            this.mChildDag.addNode(childAt2);
                        }
                        this.mChildDag.addEdge(childAt2, childAt);
                    }
                }
            }
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
        Collections.reverse(this.mDependencySortedChildren);
    }

    public boolean doViewsOverlap(@NonNull View view2, @NonNull View view3) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (view2.getVisibility() != 0 || view3.getVisibility() != 0) {
            return false;
        }
        Rect acquireTempRect = acquireTempRect();
        if (view2.getParent() != this) {
            z = true;
        } else {
            z = false;
        }
        getChildRect(view2, z, acquireTempRect);
        Rect acquireTempRect2 = acquireTempRect();
        if (view3.getParent() != this) {
            z2 = true;
        } else {
            z2 = false;
        }
        getChildRect(view3, z2, acquireTempRect2);
        try {
            if (acquireTempRect.left <= acquireTempRect2.right && acquireTempRect.top <= acquireTempRect2.bottom && acquireTempRect.right >= acquireTempRect2.left) {
                if (acquireTempRect.bottom >= acquireTempRect2.top) {
                    z3 = true;
                }
            }
            return z3;
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public void getDesiredAnchoredChildRect(View view2, int i, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        int measuredWidth = view2.getMeasuredWidth();
        int measuredHeight = view2.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(view2, i, rect, rect2, layoutParams, measuredWidth, measuredHeight);
        constrainChildRect(layoutParams, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view2, int i, int i2, int[] iArr) {
        onNestedPreScroll(view2, i, i2, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view2, View view3, int i, int i2) {
        Behavior behavior;
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view2, view3, i, i2);
        this.mNestedScrollingTarget = view3;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(i2) && (behavior = layoutParams.getBehavior()) != null) {
                behavior.onNestedScrollAccepted(this, childAt, view2, view3, i, i2);
            }
        }
    }

    public LayoutParams getResolvedLayoutParams(View view2) {
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if (!layoutParams.mBehaviorResolved) {
            if (view2 instanceof AttachedBehavior) {
                Behavior behavior = ((AttachedBehavior) view2).getBehavior();
                if (behavior == null) {
                    Log.e(TAG, "Attached behavior class is null");
                }
                layoutParams.setBehavior(behavior);
                layoutParams.mBehaviorResolved = true;
            } else {
                DefaultBehavior defaultBehavior = null;
                for (Class<?> cls = view2.getClass(); cls != null; cls = cls.getSuperclass()) {
                    defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                    if (defaultBehavior != null) {
                        break;
                    }
                }
                if (defaultBehavior != null) {
                    try {
                        layoutParams.setBehavior(defaultBehavior.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e) {
                        Log.e(TAG, "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                    }
                }
                layoutParams.mBehaviorResolved = true;
            }
        }
        return layoutParams;
    }

    public final void onChildViewsChanged(int i) {
        boolean z;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.mDependencySortedChildren.size();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        Rect acquireTempRect3 = acquireTempRect();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = this.mDependencySortedChildren.get(i2);
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (i != 0 || view2.getVisibility() != 8) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (layoutParams.mAnchorDirectChild == this.mDependencySortedChildren.get(i3)) {
                        offsetChildToAnchor(view2, layoutDirection);
                    }
                }
                getChildRect(view2, true, acquireTempRect2);
                if (layoutParams.insetEdge != 0 && !acquireTempRect2.isEmpty()) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.insetEdge, layoutDirection);
                    int i4 = absoluteGravity & 112;
                    if (i4 != 48) {
                        if (i4 == 80) {
                            acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                        }
                    } else {
                        acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                    }
                    int i5 = absoluteGravity & 7;
                    if (i5 != 3) {
                        if (i5 == 5) {
                            acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                        }
                    } else {
                        acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                    }
                }
                if (layoutParams.dodgeInsetEdges != 0 && view2.getVisibility() == 0) {
                    offsetChildByInset(view2, acquireTempRect, layoutDirection);
                }
                if (i != 2) {
                    getLastChildRect(view2, acquireTempRect3);
                    if (!acquireTempRect3.equals(acquireTempRect2)) {
                        recordLastChildRect(view2, acquireTempRect2);
                    }
                }
                for (int i6 = i2 + 1; i6 < size; i6++) {
                    View view3 = this.mDependencySortedChildren.get(i6);
                    LayoutParams layoutParams2 = (LayoutParams) view3.getLayoutParams();
                    Behavior behavior = layoutParams2.getBehavior();
                    if (behavior != null && behavior.layoutDependsOn(this, view3, view2)) {
                        if (i == 0 && layoutParams2.getChangedAfterNestedScroll()) {
                            layoutParams2.resetChangedAfterNestedScroll();
                        } else {
                            if (i != 2) {
                                z = behavior.onDependentViewChanged(this, view3, view2);
                            } else {
                                behavior.onDependentViewRemoved(this, view3, view2);
                                z = true;
                            }
                            if (i == 1) {
                                layoutParams2.setChangedAfterNestedScroll(z);
                            }
                        }
                    }
                }
            }
        }
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
        releaseTempRect(acquireTempRect3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Behavior behavior;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.mDependencySortedChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = this.mDependencySortedChildren.get(i5);
            if (view2.getVisibility() != 8 && ((behavior = ((LayoutParams) view2.getLayoutParams()).getBehavior()) == null || !behavior.onLayoutChild(this, view2, layoutDirection))) {
                onLayoutChild(view2, layoutDirection);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x011a, code lost:
        if (r0.onMeasureChild(r30, r20, r11, r21, r23, 0) == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        boolean z;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        Behavior behavior;
        LayoutParams layoutParams;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        prepareChildren();
        ensurePreDrawListener();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 1) {
            z = true;
        } else {
            z = false;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i13 = paddingLeft + paddingRight;
        int i14 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this)) {
            z2 = true;
        } else {
            z2 = false;
        }
        int size3 = this.mDependencySortedChildren.size();
        int i15 = suggestedMinimumWidth;
        int i16 = suggestedMinimumHeight;
        int i17 = 0;
        int i18 = 0;
        while (i18 < size3) {
            View view2 = this.mDependencySortedChildren.get(i18);
            if (view2.getVisibility() == 8) {
                i11 = i18;
                i8 = size3;
                i9 = paddingLeft;
            } else {
                LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                int i19 = layoutParams2.keyline;
                if (i19 >= 0 && mode != 0) {
                    int keyline = getKeyline(i19);
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(layoutParams2.gravity), layoutDirection) & 7;
                    i3 = i17;
                    if ((absoluteGravity == 3 && !z) || (absoluteGravity == 5 && z)) {
                        i4 = Math.max(0, (size - paddingRight) - keyline);
                    } else if ((absoluteGravity == 5 && !z) || (absoluteGravity == 3 && z)) {
                        i4 = Math.max(0, keyline - paddingLeft);
                    }
                    if (!z2 && !ViewCompat.getFitsSystemWindows(view2)) {
                        i5 = View.MeasureSpec.makeMeasureSpec(size - (this.mLastInsets.getSystemWindowInsetLeft() + this.mLastInsets.getSystemWindowInsetRight()), mode);
                        i6 = View.MeasureSpec.makeMeasureSpec(size2 - (this.mLastInsets.getSystemWindowInsetTop() + this.mLastInsets.getSystemWindowInsetBottom()), mode2);
                    } else {
                        i5 = i;
                        i6 = i2;
                    }
                    behavior = layoutParams2.getBehavior();
                    if (behavior == null) {
                        layoutParams = layoutParams2;
                        i10 = i3;
                        i11 = i18;
                        i7 = i16;
                        i9 = paddingLeft;
                        i12 = i15;
                        i8 = size3;
                    } else {
                        layoutParams = layoutParams2;
                        i7 = i16;
                        i8 = size3;
                        i9 = paddingLeft;
                        i10 = i3;
                        i11 = i18;
                        i12 = i15;
                    }
                    onMeasureChild(view2, i5, i4, i6, 0);
                    LayoutParams layoutParams3 = layoutParams;
                    int max = Math.max(i12, i13 + view2.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin);
                    int max2 = Math.max(i7, i14 + view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin);
                    i17 = View.combineMeasuredStates(i10, view2.getMeasuredState());
                    i15 = max;
                    i16 = max2;
                } else {
                    i3 = i17;
                }
                i4 = 0;
                if (!z2) {
                }
                i5 = i;
                i6 = i2;
                behavior = layoutParams2.getBehavior();
                if (behavior == null) {
                }
                onMeasureChild(view2, i5, i4, i6, 0);
                LayoutParams layoutParams32 = layoutParams;
                int max3 = Math.max(i12, i13 + view2.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams32).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams32).rightMargin);
                int max22 = Math.max(i7, i14 + view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams32).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams32).bottomMargin);
                i17 = View.combineMeasuredStates(i10, view2.getMeasuredState());
                i15 = max3;
                i16 = max22;
            }
            i18 = i11 + 1;
            paddingLeft = i9;
            size3 = i8;
        }
        int i20 = i17;
        setMeasuredDimension(View.resolveSizeAndState(i15, i, (-16777216) & i20), View.resolveSizeAndState(i16, i2, i20 << 16));
    }

    public void onMeasureChild(View view2, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view2, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view2, int i, int i2, int i3, int i4) {
        onNestedScroll(view2, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view2, float f, float f2) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0) && (behavior = layoutParams.getBehavior()) != null) {
                    z |= behavior.onNestedPreFling(this, childAt, view2, f, f2);
                }
            }
        }
        return z;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view2, int i, int i2, int[] iArr, int i3) {
        Behavior behavior;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(i3) && (behavior = layoutParams.getBehavior()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedPreScroll(this, childAt, view2, i, i2, iArr2, i3);
                    int[] iArr3 = this.mBehaviorConsumed;
                    if (i > 0) {
                        min = Math.max(i4, iArr3[0]);
                    } else {
                        min = Math.min(i4, iArr3[0]);
                    }
                    i4 = min;
                    int[] iArr4 = this.mBehaviorConsumed;
                    if (i2 > 0) {
                        min2 = Math.max(i5, iArr4[1]);
                    } else {
                        min2 = Math.min(i5, iArr4[1]);
                    }
                    i5 = min2;
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view2, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(view2, i, i2, i3, i4, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view2, int i, int i2, int i3, int i4, int i5, @NonNull int[] iArr) {
        Behavior behavior;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(i5) && (behavior = layoutParams.getBehavior()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedScroll(this, childAt, view2, i, i2, i3, i4, i5, iArr2);
                    int[] iArr3 = this.mBehaviorConsumed;
                    if (i3 > 0) {
                        min = Math.max(i6, iArr3[0]);
                    } else {
                        min = Math.min(i6, iArr3[0]);
                    }
                    i6 = min;
                    if (i4 > 0) {
                        min2 = Math.max(i7, this.mBehaviorConsumed[1]);
                    } else {
                        min2 = Math.min(i7, this.mBehaviorConsumed[1]);
                    }
                    i7 = min2;
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i7;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view2, int i) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view2, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(i)) {
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view2, i);
                }
                layoutParams.resetNestedScroll(i);
                layoutParams.resetChangedAfterNestedScroll();
            }
        }
        this.mNestedScrollingTarget = null;
    }
}
