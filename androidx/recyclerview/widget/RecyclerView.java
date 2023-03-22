package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    public static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    public static final boolean ALLOW_THREAD_GAP_WORK;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_ORIENTATION = 1;
    public static final boolean DISPATCH_TEMP_DETACH = false;
    public static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    public static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    public static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    public static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    public static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    public static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    public static final int MAX_SCROLL_DURATION = 2000;
    public static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final boolean POST_UPDATES_ON_ANIMATION;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    public static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    public static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    public static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    public static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    public static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    public static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    public static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    public static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    public static final Interpolator sQuinticInterpolator;
    public RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    public final AccessibilityManager mAccessibilityManager;
    public Adapter mAdapter;
    public AdapterHelper mAdapterHelper;
    public boolean mAdapterUpdateDuringMeasure;
    public EdgeEffect mBottomGlow;
    public ChildDrawingOrderCallback mChildDrawingOrderCallback;
    public ChildHelper mChildHelper;
    public boolean mClipToPadding;
    public boolean mDataSetHasChangedAfterLayout;
    public boolean mDispatchItemsChangedEvent;
    public int mDispatchScrollCounter;
    public int mEatenAccessibilityChangeFlags;
    @NonNull
    public EdgeEffectFactory mEdgeEffectFactory;
    public boolean mEnableFastScroller;
    @VisibleForTesting
    public boolean mFirstLayoutComplete;
    public GapWorker mGapWorker;
    public boolean mHasFixedSize;
    public boolean mIgnoreMotionEventTillDown;
    public int mInitialTouchX;
    public int mInitialTouchY;
    public int mInterceptRequestLayoutDepth;
    public OnItemTouchListener mInterceptingOnItemTouchListener;
    public boolean mIsAttached;
    public ItemAnimator mItemAnimator;
    public ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    public Runnable mItemAnimatorRunner;
    public final ArrayList<ItemDecoration> mItemDecorations;
    public boolean mItemsAddedOrRemoved;
    public boolean mItemsChanged;
    public int mLastTouchX;
    public int mLastTouchY;
    @VisibleForTesting
    public LayoutManager mLayout;
    public int mLayoutOrScrollCounter;
    public boolean mLayoutSuppressed;
    public boolean mLayoutWasDefered;
    public EdgeEffect mLeftGlow;
    public final int mMaxFlingVelocity;
    public final int mMinFlingVelocity;
    public final int[] mMinMaxLayoutPositions;
    public final int[] mNestedOffsets;
    public final RecyclerViewDataObserver mObserver;
    public List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    public OnFlingListener mOnFlingListener;
    public final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    @VisibleForTesting
    public final List<ViewHolder> mPendingAccessibilityImportanceChange;
    public SavedState mPendingSavedState;
    public boolean mPostedAnimatorRunner;
    public GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    public boolean mPreserveFocusAfterLayout;
    public final Recycler mRecycler;
    public RecyclerListener mRecyclerListener;
    public final int[] mReusableIntPair;
    public EdgeEffect mRightGlow;
    public float mScaledHorizontalScrollFactor;
    public float mScaledVerticalScrollFactor;
    public OnScrollListener mScrollListener;
    public List<OnScrollListener> mScrollListeners;
    public final int[] mScrollOffset;
    public int mScrollPointerId;
    public int mScrollState;
    public NestedScrollingChildHelper mScrollingChildHelper;
    public final State mState;
    public final Rect mTempRect;
    public final Rect mTempRect2;
    public final RectF mTempRectF;
    public EdgeEffect mTopGlow;
    public int mTouchSlop;
    public final Runnable mUpdateChildViewsRunnable;
    public VelocityTracker mVelocityTracker;
    public final ViewFlinger mViewFlinger;
    public final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    public final ViewInfoStore mViewInfoStore;

    /* loaded from: classes.dex */
    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(@NonNull View view2);

        void onChildViewDetachedFromWindow(@NonNull View view2);
    }

    /* loaded from: classes.dex */
    public static abstract class OnFlingListener {
        public abstract boolean onFling(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class OnScrollListener {
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        }

        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Orientation {
    }

    /* loaded from: classes.dex */
    public interface RecyclerListener {
        void onViewRecycled(@NonNull ViewHolder viewHolder);
    }

    /* loaded from: classes.dex */
    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewCacheExtension {
        @Nullable
        public abstract View getViewForPositionAndType(@NonNull Recycler recycler, int i, int i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public void onChildAttachedToWindow(@NonNull View view2) {
    }

    public void onChildDetachedFromWindow(@NonNull View view2) {
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(@Px int i, @Px int i2) {
    }

    /* loaded from: classes.dex */
    public static abstract class SmoothScroller {
        public LayoutManager mLayoutManager;
        public boolean mPendingInitialRun;
        public RecyclerView mRecyclerView;
        public boolean mRunning;
        public boolean mStarted;
        public View mTargetView;
        public int mTargetPosition = -1;
        public final Action mRecyclingAction = new Action(0, 0);

        /* loaded from: classes.dex */
        public interface ScrollVectorProvider {
            @Nullable
            PointF computeScrollVectorForPosition(int i);
        }

        public abstract void onSeekTargetStep(@Px int i, @Px int i2, @NonNull State state, @NonNull Action action);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(@NonNull View view2, @NonNull State state, @NonNull Action action);

        /* loaded from: classes.dex */
        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            public boolean mChanged;
            public int mConsecutiveUpdates;
            public int mDuration;
            public int mDx;
            public int mDy;
            public Interpolator mInterpolator;
            public int mJumpToPosition;

            public Action(@Px int i, @Px int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public Action(@Px int i, @Px int i2, int i3) {
                this(i, i2, i3, null);
            }

            public Action(@Px int i, @Px int i2, int i3, @Nullable Interpolator interpolator) {
                this.mJumpToPosition = -1;
                this.mChanged = false;
                this.mConsecutiveUpdates = 0;
                this.mDx = i;
                this.mDy = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
            }

            public void update(@Px int i, @Px int i2, int i3, @Nullable Interpolator interpolator) {
                this.mDx = i;
                this.mDy = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
                this.mChanged = true;
            }

            private void validate() {
                if (this.mInterpolator != null && this.mDuration < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.mDuration >= 1) {
                    return;
                }
                throw new IllegalStateException("Scroll duration must be a positive number");
            }

            public int getDuration() {
                return this.mDuration;
            }

            @Px
            public int getDx() {
                return this.mDx;
            }

            @Px
            public int getDy() {
                return this.mDy;
            }

            @Nullable
            public Interpolator getInterpolator() {
                return this.mInterpolator;
            }

            public boolean hasJumpTarget() {
                if (this.mJumpToPosition >= 0) {
                    return true;
                }
                return false;
            }

            public void jumpTo(int i) {
                this.mJumpToPosition = i;
            }

            public void setDuration(int i) {
                this.mChanged = true;
                this.mDuration = i;
            }

            public void setDx(@Px int i) {
                this.mChanged = true;
                this.mDx = i;
            }

            public void setDy(@Px int i) {
                this.mChanged = true;
                this.mDy = i;
            }

            public void setInterpolator(@Nullable Interpolator interpolator) {
                this.mChanged = true;
                this.mInterpolator = interpolator;
            }

            public void runIfNecessary(RecyclerView recyclerView) {
                int i = this.mJumpToPosition;
                if (i >= 0) {
                    this.mJumpToPosition = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.mChanged = false;
                } else if (this.mChanged) {
                    validate();
                    recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                    int i2 = this.mConsecutiveUpdates + 1;
                    this.mConsecutiveUpdates = i2;
                    if (i2 > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.mChanged = false;
                } else {
                    this.mConsecutiveUpdates = 0;
                }
            }
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        @Nullable
        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public final void stop() {
            if (!this.mRunning) {
                return;
            }
            this.mRunning = false;
            onStop();
            this.mRecyclerView.mState.mTargetPosition = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }

        @Nullable
        public PointF computeScrollVectorForPosition(int i) {
            LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        public int getChildPosition(View view2) {
            return this.mRecyclerView.getChildLayoutPosition(view2);
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        public void normalize(@NonNull PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public void onChildAttachedToWindow(View view2) {
            if (getChildPosition(view2) == getTargetPosition()) {
                this.mTargetView = view2;
            }
        }

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        public void onAnimation(int i, int i2) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null && (computeScrollVectorForPosition.x != 0.0f || computeScrollVectorForPosition.y != 0.0f)) {
                recyclerView.scrollStep((int) Math.signum(computeScrollVectorForPosition.x), (int) Math.signum(computeScrollVectorForPosition.y), null);
            }
            this.mPendingInitialRun = false;
            View view2 = this.mTargetView;
            if (view2 != null) {
                if (getChildPosition(view2) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.runIfNecessary(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
                boolean hasJumpTarget = this.mRecyclingAction.hasJumpTarget();
                this.mRecyclingAction.runIfNecessary(recyclerView);
                if (hasJumpTarget && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.postOnAnimation();
                }
            }
        }

        public void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.mViewFlinger.stop();
            if (this.mStarted) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            int i = this.mTargetPosition;
            if (i != -1) {
                recyclerView.mState.mTargetPosition = i;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.mViewFlinger.postOnAnimation();
                this.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Adapter<VH extends ViewHolder> {
        public final AdapterDataObservable mObservable = new AdapterDataObservable();
        public boolean mHasStableIds = false;

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(@NonNull VH vh, int i);

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(@NonNull VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(@NonNull VH vh) {
        }

        public void onViewDetachedFromWindow(@NonNull VH vh) {
        }

        public void onViewRecycled(@NonNull VH vh) {
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void bindViewHolder(@NonNull VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).mInsetsDirty = true;
            }
            TraceCompat.endSection();
        }

        @NonNull
        public final VH createViewHolder(@NonNull ViewGroup viewGroup, int i) {
            try {
                TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                TraceCompat.endSection();
            }
        }

        public final void notifyItemChanged(int i, @Nullable Object obj) {
            this.mObservable.notifyItemRangeChanged(i, 1, obj);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.notifyItemMoved(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.notifyItemRangeChanged(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.notifyItemRangeInserted(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.notifyItemRangeRemoved(i, i2);
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.notifyItemRangeChanged(i, 1);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.notifyItemRangeInserted(i, 1);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.notifyItemRangeRemoved(i, 1);
        }

        public void registerAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }

        public final void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
            this.mObservable.notifyItemRangeChanged(i, i2, obj);
        }

        public void onBindViewHolder(@NonNull VH vh, int i, @NonNull List<Object> list) {
            onBindViewHolder(vh, i);
        }
    }

    /* loaded from: classes.dex */
    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        public boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void notifyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemMoved(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }

        public void notifyItemRangeChanged(int i, int i2) {
            notifyItemRangeChanged(i, i2, null);
        }

        public void notifyItemRangeInserted(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        public void notifyItemRangeRemoved(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }

        public void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        public ItemAnimatorListener mListener = null;
        public ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList<>();
        public long mAddDuration = 120;
        public long mRemoveDuration = 120;
        public long mMoveDuration = 250;
        public long mChangeDuration = 250;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface AdapterChanges {
        }

        /* loaded from: classes.dex */
        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        /* loaded from: classes.dex */
        public interface ItemAnimatorListener {
            void onAnimationFinished(@NonNull ViewHolder viewHolder);
        }

        public abstract boolean animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @Nullable ItemHolderInfo itemHolderInfo2);

        public abstract boolean animatePersistence(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder) {
            return true;
        }

        public abstract void endAnimation(@NonNull ViewHolder viewHolder);

        public abstract void endAnimations();

        public abstract boolean isRunning();

        public void onAnimationFinished(@NonNull ViewHolder viewHolder) {
        }

        public void onAnimationStarted(@NonNull ViewHolder viewHolder) {
        }

        public abstract void runPendingAnimations();

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i = 0; i < size; i++) {
                this.mFinishedListeners.get(i).onAnimationsFinished();
            }
            this.mFinishedListeners.clear();
        }

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        @NonNull
        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        /* loaded from: classes.dex */
        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder) {
                return setFrom(viewHolder, 0);
            }

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder, int i) {
                View view2 = viewHolder.itemView;
                this.left = view2.getLeft();
                this.top = view2.getTop();
                this.right = view2.getRight();
                this.bottom = view2.getBottom();
                return this;
            }
        }

        public static int buildAdapterChangeFlagsForAnimations(ViewHolder viewHolder) {
            int i = viewHolder.mFlags & 14;
            if (viewHolder.isInvalid()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int oldPosition = viewHolder.getOldPosition();
                int adapterPosition = viewHolder.getAdapterPosition();
                if (oldPosition != -1 && adapterPosition != -1 && oldPosition != adapterPosition) {
                    return i | 2048;
                }
                return i;
            }
            return i;
        }

        public final void dispatchAnimationFinished(@NonNull ViewHolder viewHolder) {
            onAnimationFinished(viewHolder);
            ItemAnimatorListener itemAnimatorListener = this.mListener;
            if (itemAnimatorListener != null) {
                itemAnimatorListener.onAnimationFinished(viewHolder);
            }
        }

        public final void dispatchAnimationStarted(@NonNull ViewHolder viewHolder) {
            onAnimationStarted(viewHolder);
        }

        public final boolean isRunning(@Nullable ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean isRunning = isRunning();
            if (itemAnimatorFinishedListener != null) {
                if (!isRunning) {
                    itemAnimatorFinishedListener.onAnimationsFinished();
                } else {
                    this.mFinishedListeners.add(itemAnimatorFinishedListener);
                }
            }
            return isRunning;
        }

        public void setAddDuration(long j) {
            this.mAddDuration = j;
        }

        public void setChangeDuration(long j) {
            this.mChangeDuration = j;
        }

        public void setListener(ItemAnimatorListener itemAnimatorListener) {
            this.mListener = itemAnimatorListener;
        }

        public void setMoveDuration(long j) {
            this.mMoveDuration = j;
        }

        public void setRemoveDuration(long j) {
            this.mRemoveDuration = j;
        }

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder, @NonNull List<Object> list) {
            return canReuseUpdatedViewHolder(viewHolder);
        }

        @NonNull
        public ItemHolderInfo recordPostLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        @NonNull
        public ItemHolderInfo recordPreLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            return obtainHolderInfo().setFrom(viewHolder);
        }
    }

    /* loaded from: classes.dex */
    public class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        public ItemAnimatorRestoreListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void onAnimationFinished(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                viewHolder.mShadowedHolder = null;
            }
            viewHolder.mShadowingHolder = null;
            if (!viewHolder.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(viewHolder.itemView) && viewHolder.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class LayoutManager {
        public ChildHelper mChildHelper;
        public int mHeight;
        public int mHeightMode;
        public int mPrefetchMaxCountObserved;
        public boolean mPrefetchMaxObservedInInitialPrefetch;
        public RecyclerView mRecyclerView;
        @Nullable
        public SmoothScroller mSmoothScroller;
        public int mWidth;
        public int mWidthMode;
        public final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.1
            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public View getChildAt(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getChildEnd(View view2) {
                return LayoutManager.this.getDecoratedRight(view2) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view2.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getChildStart(View view2) {
                return LayoutManager.this.getDecoratedLeft(view2) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view2.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getParentEnd() {
                return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getParentStart() {
                return LayoutManager.this.getPaddingLeft();
            }
        };
        public final ViewBoundsCheck.Callback mVerticalBoundCheckCallback = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.2
            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public View getChildAt(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getChildEnd(View view2) {
                return LayoutManager.this.getDecoratedBottom(view2) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view2.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getChildStart(View view2) {
                return LayoutManager.this.getDecoratedTop(view2) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view2.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getParentEnd() {
                return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getParentStart() {
                return LayoutManager.this.getPaddingTop();
            }
        };
        public ViewBoundsCheck mHorizontalBoundCheck = new ViewBoundsCheck(this.mHorizontalBoundCheckCallback);
        public ViewBoundsCheck mVerticalBoundCheck = new ViewBoundsCheck(this.mVerticalBoundCheckCallback);
        public boolean mRequestedSimpleAnimations = false;
        public boolean mIsAttachedToWindow = false;
        public boolean mAutoMeasure = false;
        public boolean mMeasurementCacheEnabled = true;
        public boolean mItemPrefetchEnabled = true;

        /* loaded from: classes.dex */
        public interface LayoutPrefetchRegistry {
            void addPosition(int i, int i2);
        }

        /* loaded from: classes.dex */
        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void collectInitialPrefetchPositions(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public int computeHorizontalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollRange(@NonNull State state) {
            return 0;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public int getBaseline() {
            return -1;
        }

        public int getSelectionModeForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            return 0;
        }

        public boolean isLayoutHierarchical(@NonNull Recycler recycler, @NonNull State state) {
            return false;
        }

        public void onAdapterChanged(@Nullable Adapter adapter, @Nullable Adapter adapter2) {
        }

        public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        @Nullable
        public View onFocusSearchFailed(@NonNull View view2, int i, @NonNull Recycler recycler, @NonNull State state) {
            return null;
        }

        @Nullable
        public View onInterceptFocusSearch(@NonNull View view2, int i) {
            return null;
        }

        public void onItemsAdded(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(@NonNull RecyclerView recyclerView) {
        }

        public void onItemsMoved(@NonNull RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        public void onLayoutCompleted(State state) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Nullable
        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public boolean performAccessibilityActionForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view2, int i, @Nullable Bundle bundle) {
            return false;
        }

        public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public int getChildCount() {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildCount();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && recyclerView.mClipToPadding) {
                return true;
            }
            return false;
        }

        @Nullable
        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.isHidden(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        @Px
        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            Adapter adapter;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                adapter = recyclerView.getAdapter();
            } else {
                adapter = null;
            }
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        @Px
        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        @Px
        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        @Px
        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        @Px
        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        @Px
        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        @Px
        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        @Px
        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingStart(recyclerView);
            }
            return 0;
        }

        @Px
        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        @Px
        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && recyclerView.hasFocus()) {
                return true;
            }
            return false;
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && recyclerView.isFocused()) {
                return true;
            }
            return false;
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller != null && smoothScroller.isRunning()) {
                return true;
            }
            return false;
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.removeViewAt(childCount);
            }
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public void stopSmoothScroller() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller != null) {
                smoothScroller.stop();
            }
        }

        private void addViewInt(View view2, int i, boolean z) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
            if (!z && !childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (!childViewHolderInt.wasReturnedFromScrap() && !childViewHolderInt.isScrap()) {
                if (view2.getParent() == this.mRecyclerView) {
                    int indexOfChild = this.mChildHelper.indexOfChild(view2);
                    if (i == -1) {
                        i = this.mChildHelper.getChildCount();
                    }
                    if (indexOfChild != -1) {
                        if (indexOfChild != i) {
                            this.mRecyclerView.mLayout.moveView(indexOfChild, i);
                        }
                    } else {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view2) + this.mRecyclerView.exceptionLabel());
                    }
                } else {
                    this.mChildHelper.addView(view2, i, false);
                    layoutParams.mInsetsDirty = true;
                    SmoothScroller smoothScroller = this.mSmoothScroller;
                    if (smoothScroller != null && smoothScroller.isRunning()) {
                        this.mSmoothScroller.onChildAttachedToWindow(view2);
                    }
                }
            } else {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.attachViewToParent(view2, i, view2.getLayoutParams(), false);
            }
            if (layoutParams.mPendingInvalidate) {
                childViewHolderInt.itemView.invalidate();
                layoutParams.mPendingInvalidate = false;
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 1073741824) {
                    return Math.max(i2, i3);
                }
                return size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    return true;
                }
                if (mode != 1073741824 || size != i) {
                    return false;
                }
                return true;
            } else if (size < i) {
                return false;
            } else {
                return true;
            }
        }

        public void attachView(@NonNull View view2, int i, LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            this.mChildHelper.attachViewToParent(view2, i, layoutParams, childViewHolderInt.isRemoved());
        }

        public boolean isViewPartiallyVisible(@NonNull View view2, boolean z, boolean z2) {
            boolean z3;
            if (this.mHorizontalBoundCheck.isViewWithinBoundFlags(view2, 24579) && this.mVerticalBoundCheck.isViewWithinBoundFlags(view2, 24579)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z) {
                return z3;
            }
            return !z3;
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull View view2, @Nullable View view3) {
            if (!isSmoothScrolling() && !recyclerView.isComputingLayout()) {
                return false;
            }
            return true;
        }

        public boolean performAccessibilityActionForItem(@NonNull View view2, int i, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view2, i, bundle);
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        private void detachViewInternal(int i, @NonNull View view2) {
            this.mChildHelper.detachViewFromParent(i);
        }

        public void addDisappearingView(View view2, int i) {
            addViewInt(view2, i, true);
        }

        public void addView(View view2, int i) {
            addViewInt(view2, i, false);
        }

        public void attachView(@NonNull View view2, int i) {
            attachView(view2, i, (LayoutParams) view2.getLayoutParams());
        }

        public void calculateItemDecorationsForChild(@NonNull View view2, @NonNull Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view2));
            }
        }

        public void detachAndScrapView(@NonNull View view2, @NonNull Recycler recycler) {
            scrapOrRecycleView(recycler, this.mChildHelper.indexOfChild(view2), view2);
        }

        public void detachAndScrapViewAt(int i, @NonNull Recycler recycler) {
            scrapOrRecycleView(recycler, i, getChildAt(i));
        }

        public void dispatchDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public int getColumnCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public void getDecoratedBoundsWithMargins(@NonNull View view2, @NonNull Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view2, rect);
        }

        public int getRowCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
        }

        @CallSuper
        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        public void onInitializeAccessibilityNodeInfoForItem(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                RecyclerView recyclerView = this.mRecyclerView;
                onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view2, accessibilityNodeInfoCompat);
            }
        }

        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public boolean performAccessibilityAction(int i, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i, bundle);
        }

        public void removeAndRecycleView(@NonNull View view2, @NonNull Recycler recycler) {
            removeView(view2);
            recycler.recycleView(view2);
        }

        public void removeAndRecycleViewAt(int i, @NonNull Recycler recycler) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            recycler.recycleView(childAt);
        }

        public void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mHeightMode = mode2;
            if (mode2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r5 == 1073741824) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int getChildMeasureSpec(int i, int i2, int i3, int i4, boolean z) {
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 != Integer.MIN_VALUE) {
                            if (i2 != 0) {
                            }
                        }
                        i4 = max;
                    }
                    i2 = 0;
                    i4 = 0;
                }
                i2 = 1073741824;
            } else {
                if (i4 < 0) {
                    if (i4 != -1) {
                        if (i4 == -2) {
                            if (i2 != Integer.MIN_VALUE && i2 != 1073741824) {
                                i2 = 0;
                            } else {
                                i2 = Integer.MIN_VALUE;
                            }
                        }
                        i2 = 0;
                        i4 = 0;
                    }
                    i4 = max;
                }
                i2 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
            if (r3 >= 0) goto L8;
         */
        @Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int getChildMeasureSpec(int i, int i2, int i3, boolean z) {
            int i4 = i - i2;
            int i5 = 0;
            int max = Math.max(0, i4);
            if (!z) {
                if (i3 < 0) {
                    if (i3 == -1) {
                        i5 = 1073741824;
                    } else {
                        i5 = i3 == -2 ? Integer.MIN_VALUE : Integer.MIN_VALUE;
                        i3 = 0;
                    }
                    i3 = max;
                }
                i5 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i3, i5);
        }

        public static Properties getProperties(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i, i2);
            properties.orientation = obtainStyledAttributes.getInt(0, 1);
            properties.spanCount = obtainStyledAttributes.getInt(10, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(9, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        public void onInitializeAccessibilityNodeInfoForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i;
            int i2;
            if (canScrollVertically()) {
                i = getPosition(view2);
            } else {
                i = 0;
            }
            if (canScrollHorizontally()) {
                i2 = getPosition(view2);
            } else {
                i2 = 0;
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, i2, 1, false, false));
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2, @Nullable Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onMeasure(@NonNull Recycler recycler, @NonNull State state, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull State state, @NonNull View view2, @Nullable View view3) {
            return onRequestChildFocus(recyclerView, view2, view3);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view2, @NonNull Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view2, rect, z, false);
        }

        public boolean shouldMeasureChild(View view2, int i, int i2, LayoutParams layoutParams) {
            if (!view2.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view2.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view2.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
                return false;
            }
            return true;
        }

        public boolean shouldReMeasureChild(View view2, int i, int i2, LayoutParams layoutParams) {
            if (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view2.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view2.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
                return false;
            }
            return true;
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view2, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view2.getLeft() + rect.left) - view2.getScrollX();
            int top = (view2.getTop() + rect.top) - view2.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i = left - paddingLeft;
            int min = Math.min(0, i);
            int i2 = top - paddingTop;
            int min2 = Math.min(0, i2);
            int i3 = width2 - width;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() == 1) {
                if (max == 0) {
                    max = Math.max(min, i3);
                }
            } else {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            if (rect.left - i >= width || rect.right - i <= paddingLeft || rect.top - i2 >= height || rect.bottom - i2 <= paddingTop) {
                return false;
            }
            return true;
        }

        private void scrapOrRecycleView(Recycler recycler, int i, View view2) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(i);
                recycler.recycleViewHolderInternal(childViewHolderInt);
                return;
            }
            detachViewAt(i);
            recycler.scrapView(view2);
            this.mRecyclerView.mViewInfoStore.onViewDetached(childViewHolderInt);
        }

        public void onInitializeAccessibilityEvent(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                Adapter adapter = this.mRecyclerView.mAdapter;
                if (adapter != null) {
                    accessibilityEvent.setItemCount(adapter.getItemCount());
                }
            }
        }

        public void addDisappearingView(View view2) {
            addDisappearingView(view2, -1);
        }

        public void addView(View view2) {
            addView(view2, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(@NonNull View view2) {
            attachView(view2, -1);
        }

        public void detachAndScrapAttachedViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachView(@NonNull View view2) {
            int indexOfChild = this.mChildHelper.indexOfChild(view2);
            if (indexOfChild >= 0) {
                detachViewInternal(indexOfChild, view2);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        public void endAnimation(View view2) {
            ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view2));
            }
        }

        @Nullable
        public View findContainingItemView(@NonNull View view2) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view2)) == null || this.mChildHelper.isHidden(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public int getBottomDecorationHeight(@NonNull View view2) {
            return ((LayoutParams) view2.getLayoutParams()).mDecorInsets.bottom;
        }

        @Nullable
        public View getChildAt(int i) {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildAt(i);
            }
            return null;
        }

        public int getDecoratedBottom(@NonNull View view2) {
            return view2.getBottom() + getBottomDecorationHeight(view2);
        }

        public int getDecoratedLeft(@NonNull View view2) {
            return view2.getLeft() - getLeftDecorationWidth(view2);
        }

        public int getDecoratedMeasuredHeight(@NonNull View view2) {
            Rect rect = ((LayoutParams) view2.getLayoutParams()).mDecorInsets;
            return view2.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(@NonNull View view2) {
            Rect rect = ((LayoutParams) view2.getLayoutParams()).mDecorInsets;
            return view2.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(@NonNull View view2) {
            return view2.getRight() + getRightDecorationWidth(view2);
        }

        public int getDecoratedTop(@NonNull View view2) {
            return view2.getTop() - getTopDecorationHeight(view2);
        }

        public int getItemViewType(@NonNull View view2) {
            return RecyclerView.getChildViewHolderInt(view2).getItemViewType();
        }

        public int getLeftDecorationWidth(@NonNull View view2) {
            return ((LayoutParams) view2.getLayoutParams()).mDecorInsets.left;
        }

        public int getPosition(@NonNull View view2) {
            return ((LayoutParams) view2.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(@NonNull View view2) {
            return ((LayoutParams) view2.getLayoutParams()).mDecorInsets.right;
        }

        public int getTopDecorationHeight(@NonNull View view2) {
            return ((LayoutParams) view2.getLayoutParams()).mDecorInsets.top;
        }

        public void offsetChildrenHorizontal(@Px int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(@Px int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, accessibilityNodeInfoCompat);
        }

        public void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                ViewCompat.postOnAnimation(recyclerView, runnable);
            }
        }

        public void removeAndRecycleAllViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(@NonNull View view2) {
            this.mRecyclerView.removeDetachedView(view2, false);
        }

        public void removeView(View view2) {
            this.mChildHelper.removeView(view2);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.removeViewAt(i);
            }
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.mSmoothScroller;
            if (smoothScroller2 != null && smoothScroller != smoothScroller2 && smoothScroller2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = smoothScroller;
            smoothScroller.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(@NonNull View view2) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        @Nullable
        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.isPreLayout() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public void ignoreView(@NonNull View view2) {
            ViewParent parent = view2.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent == recyclerView && recyclerView.indexOfChild(view2) != -1) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
                childViewHolderInt.addFlags(128);
                this.mRecyclerView.mViewInfoStore.removeViewHolder(childViewHolderInt);
                return;
            }
            throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
        }

        public void removeAndRecycleScrapInt(Recycler recycler) {
            int scrapCount = recycler.getScrapCount();
            for (int i = scrapCount - 1; i >= 0; i--) {
                View scrapViewAt = recycler.getScrapViewAt(i);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(scrapViewAt);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(scrapViewAt, false);
                    }
                    ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimation(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    recycler.quickRecycleScrapView(scrapViewAt);
                }
            }
            recycler.clearScrap();
            if (scrapCount > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void getTransformedBoundingBox(@NonNull View view2, boolean z, @NonNull Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view2.getLayoutParams()).mDecorInsets;
                rect.set(-rect2.left, -rect2.top, view2.getWidth() + rect2.right, view2.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view2.getWidth(), view2.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view2.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view2.getLeft(), view2.getTop());
        }

        public void measureChildWithMargins(@NonNull View view2, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view2);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view2, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view2.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void layoutDecorated(@NonNull View view2, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view2.getLayoutParams()).mDecorInsets;
            view2.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(@NonNull View view2, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            Rect rect = layoutParams.mDecorInsets;
            view2.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view2, @NonNull Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view2, rect);
            int i = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        public void measureChild(@NonNull View view2, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view2);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view2, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view2.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public boolean performAccessibilityAction(@NonNull Recycler recycler, @NonNull State state, int i, @Nullable Bundle bundle) {
            int i2;
            int width;
            int i3;
            int i4;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            if (i != 4096) {
                if (i != 8192) {
                    i4 = 0;
                    i3 = 0;
                } else {
                    if (recyclerView.canScrollVertically(-1)) {
                        i2 = -((getHeight() - getPaddingTop()) - getPaddingBottom());
                    } else {
                        i2 = 0;
                    }
                    if (this.mRecyclerView.canScrollHorizontally(-1)) {
                        width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                        i3 = i2;
                        i4 = width;
                    }
                    i3 = i2;
                    i4 = 0;
                }
            } else {
                if (recyclerView.canScrollVertically(1)) {
                    i2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                } else {
                    i2 = 0;
                }
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    i3 = i2;
                    i4 = width;
                }
                i3 = i2;
                i4 = 0;
            }
            if (i3 == 0 && i4 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(i4, i3, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i8 = rect.left;
                if (i8 < i5) {
                    i5 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i4) {
                    i4 = i11;
                }
            }
            this.mRecyclerView.mTempRect.set(i5, i6, i3, i4);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public final Rect mDecorInsets;
        public boolean mInsetsDirty;
        public boolean mPendingInvalidate;
        public ViewHolder mViewHolder;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public int getViewAdapterPosition() {
            return this.mViewHolder.getAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        @Deprecated
        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
        }
    }

    /* loaded from: classes.dex */
    public static class RecycledViewPool {
        public static final int DEFAULT_MAX_SCRAP = 5;
        public SparseArray<ScrapData> mScrap = new SparseArray<>();
        public int mAttachCount = 0;

        /* loaded from: classes.dex */
        public static class ScrapData {
            public final ArrayList<ViewHolder> mScrapHeap = new ArrayList<>();
            public int mMaxScrap = 5;
            public long mCreateRunningAverageNs = 0;
            public long mBindRunningAverageNs = 0;
        }

        public void attach() {
            this.mAttachCount++;
        }

        public void clear() {
            for (int i = 0; i < this.mScrap.size(); i++) {
                this.mScrap.valueAt(i).mScrapHeap.clear();
            }
        }

        public void detach() {
            this.mAttachCount--;
        }

        public int size() {
            int i = 0;
            for (int i2 = 0; i2 < this.mScrap.size(); i2++) {
                ArrayList<ViewHolder> arrayList = this.mScrap.valueAt(i2).mScrapHeap;
                if (arrayList != null) {
                    i += arrayList.size();
                }
            }
            return i;
        }

        private ScrapData getScrapDataForType(int i) {
            ScrapData scrapData = this.mScrap.get(i);
            if (scrapData == null) {
                ScrapData scrapData2 = new ScrapData();
                this.mScrap.put(i, scrapData2);
                return scrapData2;
            }
            return scrapData;
        }

        public int getRecycledViewCount(int i) {
            return getScrapDataForType(i).mScrapHeap.size();
        }

        public void putRecycledView(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> arrayList = getScrapDataForType(itemViewType).mScrapHeap;
            if (this.mScrap.get(itemViewType).mMaxScrap <= arrayList.size()) {
                return;
            }
            viewHolder.resetInternal();
            arrayList.add(viewHolder);
        }

        public void factorInBindTime(int i, long j) {
            ScrapData scrapDataForType = getScrapDataForType(i);
            scrapDataForType.mBindRunningAverageNs = runningAverage(scrapDataForType.mBindRunningAverageNs, j);
        }

        public void factorInCreateTime(int i, long j) {
            ScrapData scrapDataForType = getScrapDataForType(i);
            scrapDataForType.mCreateRunningAverageNs = runningAverage(scrapDataForType.mCreateRunningAverageNs, j);
        }

        public long runningAverage(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return ((j / 4) * 3) + (j2 / 4);
        }

        public void setMaxRecycledViews(int i, int i2) {
            ScrapData scrapDataForType = getScrapDataForType(i);
            scrapDataForType.mMaxScrap = i2;
            ArrayList<ViewHolder> arrayList = scrapDataForType.mScrapHeap;
            while (arrayList.size() > i2) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        @Nullable
        public ViewHolder getRecycledView(int i) {
            ScrapData scrapData = this.mScrap.get(i);
            if (scrapData != null && !scrapData.mScrapHeap.isEmpty()) {
                ArrayList<ViewHolder> arrayList = scrapData.mScrapHeap;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                        return arrayList.remove(size);
                    }
                }
                return null;
            }
            return null;
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2, boolean z) {
            if (adapter != null) {
                detach();
            }
            if (!z && this.mAttachCount == 0) {
                clear();
            }
            if (adapter2 != null) {
                attach();
            }
        }

        public boolean willBindInTime(int i, long j, long j2) {
            long j3 = getScrapDataForType(i).mBindRunningAverageNs;
            if (j3 != 0 && j + j3 >= j2) {
                return false;
            }
            return true;
        }

        public boolean willCreateInTime(int i, long j, long j2) {
            long j3 = getScrapDataForType(i).mCreateRunningAverageNs;
            if (j3 != 0 && j + j3 >= j2) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public final class Recycler {
        public static final int DEFAULT_CACHE_SIZE = 2;
        public RecycledViewPool mRecyclerPool;
        public ViewCacheExtension mViewCacheExtension;
        public final ArrayList<ViewHolder> mAttachedScrap = new ArrayList<>();
        public ArrayList<ViewHolder> mChangedScrap = null;
        public final ArrayList<ViewHolder> mCachedViews = new ArrayList<>();
        public final List<ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
        public int mRequestedCacheMax = 2;
        public int mViewCacheMax = 2;

        public Recycler() {
        }

        private void attachAccessibilityDelegateOnBind(ViewHolder viewHolder) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view2 = viewHolder.itemView;
                if (ViewCompat.getImportantForAccessibility(view2) == 0) {
                    ViewCompat.setImportantForAccessibility(view2, 1);
                }
                RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.mAccessibilityDelegate;
                if (recyclerViewAccessibilityDelegate == null) {
                    return;
                }
                AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).saveOriginalDelegate(view2);
                }
                ViewCompat.setAccessibilityDelegate(view2, itemDelegate);
            }
        }

        private void invalidateDisplayListInt(ViewHolder viewHolder) {
            View view2 = viewHolder.itemView;
            if (view2 instanceof ViewGroup) {
                invalidateDisplayListInt((ViewGroup) view2, false);
            }
        }

        public void dispatchViewRecycled(@NonNull ViewHolder viewHolder) {
            RecyclerListener recyclerListener = RecyclerView.this.mRecyclerListener;
            if (recyclerListener != null) {
                recyclerListener.onViewRecycled(viewHolder);
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter != null) {
                adapter.onViewRecycled(viewHolder);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.removeViewHolder(viewHolder);
            }
        }

        public View getScrapViewAt(int i) {
            return this.mAttachedScrap.get(i).itemView;
        }

        @NonNull
        public View getViewForPosition(int i) {
            return getViewForPosition(i, false);
        }

        public void quickRecycleScrapView(View view2) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            recycleViewHolderInternal(childViewHolderInt);
        }

        public void recycleCachedViewAt(int i) {
            addViewHolderToRecycledViewPool(this.mCachedViews.get(i), true);
            this.mCachedViews.remove(i);
        }

        public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
            RecycledViewPool recycledViewPool2 = this.mRecyclerPool;
            if (recycledViewPool2 != null) {
                recycledViewPool2.detach();
            }
            this.mRecyclerPool = recycledViewPool;
            if (recycledViewPool != null && RecyclerView.this.getAdapter() != null) {
                this.mRecyclerPool.attach();
            }
        }

        public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
            this.mViewCacheExtension = viewCacheExtension;
        }

        public void setViewCacheSize(int i) {
            this.mRequestedCacheMax = i;
            updateViewCacheSize();
        }

        public void unscrapView(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.mChangedScrap.remove(viewHolder);
            } else {
                this.mAttachedScrap.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        private void invalidateDisplayListInt(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    invalidateDisplayListInt((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        public void offsetPositionRecordsForMove(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.mCachedViews.size();
            for (int i7 = 0; i7 < size; i7++) {
                ViewHolder viewHolder = this.mCachedViews.get(i7);
                if (viewHolder != null && (i6 = viewHolder.mPosition) >= i5 && i6 <= i4) {
                    if (i6 == i) {
                        viewHolder.offsetPosition(i2 - i, false);
                    } else {
                        viewHolder.offsetPosition(i3, false);
                    }
                }
            }
        }

        private boolean tryBindViewHolderByDeadline(@NonNull ViewHolder viewHolder, int i, int i2, long j) {
            viewHolder.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.mRecyclerPool.willBindInTime(itemViewType, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.mAdapter.bindViewHolder(viewHolder, i);
            this.mRecyclerPool.factorInBindTime(viewHolder.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            attachAccessibilityDelegateOnBind(viewHolder);
            if (RecyclerView.this.mState.isPreLayout()) {
                viewHolder.mPreLayoutPosition = i2;
                return true;
            }
            return true;
        }

        public void addViewHolderToRecycledViewPool(@NonNull ViewHolder viewHolder, boolean z) {
            AccessibilityDelegateCompat accessibilityDelegateCompat;
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            View view2 = viewHolder.itemView;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.mAccessibilityDelegate;
            if (recyclerViewAccessibilityDelegate != null) {
                AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    accessibilityDelegateCompat = ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).getAndRemoveOriginalDelegateForItem(view2);
                } else {
                    accessibilityDelegateCompat = null;
                }
                ViewCompat.setAccessibilityDelegate(view2, accessibilityDelegateCompat);
            }
            if (z) {
                dispatchViewRecycled(viewHolder);
            }
            viewHolder.mOwnerRecyclerView = null;
            getRecycledViewPool().putRecycledView(viewHolder);
        }

        public View getViewForPosition(int i, boolean z) {
            return tryGetViewHolderForPositionByDeadline(i, z, Long.MAX_VALUE).itemView;
        }

        public void offsetPositionRecordsForInsert(int i, int i2) {
            int size = this.mCachedViews.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = this.mCachedViews.get(i3);
                if (viewHolder != null && viewHolder.mPosition >= i) {
                    viewHolder.offsetPosition(i2, true);
                }
            }
        }

        public void viewRangeUpdate(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mCachedViews.get(size);
                if (viewHolder != null && (i3 = viewHolder.mPosition) >= i && i3 < i4) {
                    viewHolder.addFlags(2);
                    recycleCachedViewAt(size);
                }
            }
        }

        public void bindViewToPosition(@NonNull View view2, int i) {
            LayoutParams layoutParams;
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
            if (childViewHolderInt != null) {
                int findPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i);
                if (findPositionOffset >= 0 && findPositionOffset < RecyclerView.this.mAdapter.getItemCount()) {
                    tryBindViewHolderByDeadline(childViewHolderInt, findPositionOffset, i, Long.MAX_VALUE);
                    ViewGroup.LayoutParams layoutParams2 = childViewHolderInt.itemView.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                        childViewHolderInt.itemView.setLayoutParams(layoutParams);
                    } else if (!RecyclerView.this.checkLayoutParams(layoutParams2)) {
                        layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                        childViewHolderInt.itemView.setLayoutParams(layoutParams);
                    } else {
                        layoutParams = (LayoutParams) layoutParams2;
                    }
                    boolean z = true;
                    layoutParams.mInsetsDirty = true;
                    layoutParams.mViewHolder = childViewHolderInt;
                    if (childViewHolderInt.itemView.getParent() != null) {
                        z = false;
                    }
                    layoutParams.mPendingInvalidate = z;
                    return;
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + findPositionOffset + ").state:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
            }
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + RecyclerView.this.exceptionLabel());
        }

        public ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int i, boolean z) {
            View findHiddenNonRemovedView;
            int size = this.mAttachedScrap.size();
            for (int i2 = 0; i2 < size; i2++) {
                ViewHolder viewHolder = this.mAttachedScrap.get(i2);
                if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i && !viewHolder.isInvalid() && (RecyclerView.this.mState.mInPreLayout || !viewHolder.isRemoved())) {
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            if (!z && (findHiddenNonRemovedView = RecyclerView.this.mChildHelper.findHiddenNonRemovedView(i)) != null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(findHiddenNonRemovedView);
                RecyclerView.this.mChildHelper.unhide(findHiddenNonRemovedView);
                int indexOfChild = RecyclerView.this.mChildHelper.indexOfChild(findHiddenNonRemovedView);
                if (indexOfChild != -1) {
                    RecyclerView.this.mChildHelper.detachViewFromParent(indexOfChild);
                    scrapView(findHiddenNonRemovedView);
                    childViewHolderInt.addFlags(8224);
                    return childViewHolderInt;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
            }
            int size2 = this.mCachedViews.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ViewHolder viewHolder2 = this.mCachedViews.get(i3);
                if (!viewHolder2.isInvalid() && viewHolder2.getLayoutPosition() == i && !viewHolder2.isAttachedToTransitionOverlay()) {
                    if (!z) {
                        this.mCachedViews.remove(i3);
                    }
                    return viewHolder2;
                }
            }
            return null;
        }

        public void clear() {
            this.mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        public void clearScrap() {
            this.mAttachedScrap.clear();
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool == null) {
                this.mRecyclerPool = new RecycledViewPool();
            }
            return this.mRecyclerPool;
        }

        public int getScrapCount() {
            return this.mAttachedScrap.size();
        }

        @NonNull
        public List<ViewHolder> getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        public void markItemDecorInsetsDirty() {
            int size = this.mCachedViews.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.mCachedViews.get(i).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.mInsetsDirty = true;
                }
            }
        }

        public void markKnownViewsInvalid() {
            int size = this.mCachedViews.size();
            for (int i = 0; i < size; i++) {
                ViewHolder viewHolder = this.mCachedViews.get(i);
                if (viewHolder != null) {
                    viewHolder.addFlags(6);
                    viewHolder.addChangePayload(null);
                }
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter == null || !adapter.hasStableIds()) {
                recycleAndClearCachedViews();
            }
        }

        public void recycleAndClearCachedViews() {
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                recycleCachedViewAt(size);
            }
            this.mCachedViews.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
            }
        }

        public void updateViewCacheSize() {
            int i;
            LayoutManager layoutManager = RecyclerView.this.mLayout;
            if (layoutManager != null) {
                i = layoutManager.mPrefetchMaxCountObserved;
            } else {
                i = 0;
            }
            this.mViewCacheMax = this.mRequestedCacheMax + i;
            for (int size = this.mCachedViews.size() - 1; size >= 0 && this.mCachedViews.size() > this.mViewCacheMax; size--) {
                recycleCachedViewAt(size);
            }
        }

        public void clearOldPositions() {
            int size = this.mCachedViews.size();
            for (int i = 0; i < size; i++) {
                this.mCachedViews.get(i).clearOldPosition();
            }
            int size2 = this.mAttachedScrap.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.mAttachedScrap.get(i2).clearOldPosition();
            }
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.mChangedScrap.get(i3).clearOldPosition();
                }
            }
        }

        public int convertPreLayoutPositionToPostLayout(int i) {
            if (i >= 0 && i < RecyclerView.this.mState.getItemCount()) {
                if (!RecyclerView.this.mState.isPreLayout()) {
                    return i;
                }
                return RecyclerView.this.mAdapterHelper.findPositionOffset(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
        }

        public ViewHolder getChangedScrapViewForPosition(int i) {
            int size;
            int findPositionOffset;
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    ViewHolder viewHolder = this.mChangedScrap.get(i2);
                    if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i) {
                        viewHolder.addFlags(32);
                        return viewHolder;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (findPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i)) > 0 && findPositionOffset < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(findPositionOffset);
                    for (int i3 = 0; i3 < size; i3++) {
                        ViewHolder viewHolder2 = this.mChangedScrap.get(i3);
                        if (!viewHolder2.wasReturnedFromScrap() && viewHolder2.getItemId() == itemId) {
                            viewHolder2.addFlags(32);
                            return viewHolder2;
                        }
                    }
                }
            }
            return null;
        }

        public void scrapView(View view2) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.mChangedScrap == null) {
                    this.mChangedScrap = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.mChangedScrap.add(childViewHolderInt);
            } else if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !RecyclerView.this.mAdapter.hasStableIds()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            } else {
                childViewHolderInt.setScrapContainer(this, false);
                this.mAttachedScrap.add(childViewHolderInt);
            }
        }

        public boolean validateViewHolderForOffsetPosition(ViewHolder viewHolder) {
            if (viewHolder.isRemoved()) {
                return RecyclerView.this.mState.isPreLayout();
            }
            int i = viewHolder.mPosition;
            if (i >= 0 && i < RecyclerView.this.mAdapter.getItemCount()) {
                if (!RecyclerView.this.mState.isPreLayout() && RecyclerView.this.mAdapter.getItemViewType(viewHolder.mPosition) != viewHolder.getItemViewType()) {
                    return false;
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && viewHolder.getItemId() != RecyclerView.this.mAdapter.getItemId(viewHolder.mPosition)) {
                    return false;
                }
                return true;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder + RecyclerView.this.exceptionLabel());
        }

        public ViewHolder getScrapOrCachedViewForId(long j, int i, boolean z) {
            for (int size = this.mAttachedScrap.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mAttachedScrap.get(size);
                if (viewHolder.getItemId() == j && !viewHolder.wasReturnedFromScrap()) {
                    if (i == viewHolder.getItemViewType()) {
                        viewHolder.addFlags(32);
                        if (viewHolder.isRemoved() && !RecyclerView.this.mState.isPreLayout()) {
                            viewHolder.setFlags(2, 14);
                        }
                        return viewHolder;
                    } else if (!z) {
                        this.mAttachedScrap.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        quickRecycleScrapView(viewHolder.itemView);
                    }
                }
            }
            int size2 = this.mCachedViews.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ViewHolder viewHolder2 = this.mCachedViews.get(size2);
                if (viewHolder2.getItemId() == j && !viewHolder2.isAttachedToTransitionOverlay()) {
                    if (i == viewHolder2.getItemViewType()) {
                        if (!z) {
                            this.mCachedViews.remove(size2);
                        }
                        return viewHolder2;
                    } else if (!z) {
                        recycleCachedViewAt(size2);
                        return null;
                    }
                }
            }
        }

        public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mCachedViews.get(size);
                if (viewHolder != null) {
                    int i4 = viewHolder.mPosition;
                    if (i4 >= i3) {
                        viewHolder.offsetPosition(-i2, z);
                    } else if (i4 >= i) {
                        viewHolder.addFlags(8);
                        recycleCachedViewAt(size);
                    }
                }
            }
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2, boolean z) {
            clear();
            getRecycledViewPool().onAdapterChanged(adapter, adapter2, z);
        }

        public void recycleView(@NonNull View view2) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view2, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            recycleViewHolderInternal(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                RecyclerView.this.mItemAnimator.endAnimation(childViewHolderInt);
            }
        }

        public void recycleViewHolderInternal(ViewHolder viewHolder) {
            boolean z;
            boolean z2;
            boolean z3 = false;
            boolean z4 = true;
            if (!viewHolder.isScrap() && viewHolder.itemView.getParent() == null) {
                if (!viewHolder.isTmpDetached()) {
                    if (!viewHolder.shouldIgnore()) {
                        boolean doesTransientStatePreventRecycling = viewHolder.doesTransientStatePreventRecycling();
                        Adapter adapter = RecyclerView.this.mAdapter;
                        if (adapter != null && doesTransientStatePreventRecycling && adapter.onFailedToRecycleView(viewHolder)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z || viewHolder.isRecyclable()) {
                            if (this.mViewCacheMax > 0 && !viewHolder.hasAnyOfTheFlags(526)) {
                                int size = this.mCachedViews.size();
                                if (size >= this.mViewCacheMax && size > 0) {
                                    recycleCachedViewAt(0);
                                    size--;
                                }
                                if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(viewHolder.mPosition)) {
                                    int i = size - 1;
                                    while (i >= 0) {
                                        if (!RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(i).mPosition)) {
                                            break;
                                        }
                                        i--;
                                    }
                                    size = i + 1;
                                }
                                this.mCachedViews.add(size, viewHolder);
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                addViewHolderToRecycledViewPool(viewHolder, true);
                                z3 = z2;
                                RecyclerView.this.mViewInfoStore.removeViewHolder(viewHolder);
                                if (z3 && !z4 && doesTransientStatePreventRecycling) {
                                    viewHolder.mOwnerRecyclerView = null;
                                    return;
                                }
                                return;
                            }
                            z3 = z2;
                        }
                        z4 = false;
                        RecyclerView.this.mViewInfoStore.removeViewHolder(viewHolder);
                        if (z3) {
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + RecyclerView.this.exceptionLabel());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(viewHolder.isScrap());
            sb.append(" isAttached:");
            if (viewHolder.itemView.getParent() != null) {
                z3 = true;
            }
            sb.append(z3);
            sb.append(RecyclerView.this.exceptionLabel());
            throw new IllegalArgumentException(sb.toString());
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0228 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0185  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01a2  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01c5  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x01d4  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01fe  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ViewHolder tryGetViewHolderForPositionByDeadline(int i, boolean z, long j) {
            ViewHolder viewHolder;
            boolean z2;
            ViewHolder viewHolder2;
            boolean z3;
            boolean tryBindViewHolderByDeadline;
            ViewGroup.LayoutParams layoutParams;
            LayoutParams layoutParams2;
            RecyclerView findNestedRecyclerView;
            ViewCacheExtension viewCacheExtension;
            View viewForPositionAndType;
            if (i >= 0 && i < RecyclerView.this.mState.getItemCount()) {
                boolean z4 = true;
                if (RecyclerView.this.mState.isPreLayout()) {
                    viewHolder = getChangedScrapViewForPosition(i);
                    if (viewHolder != null) {
                        z2 = true;
                        if (viewHolder == null && (viewHolder = getScrapOrHiddenOrCachedHolderForPosition(i, z)) != null) {
                            if (validateViewHolderForOffsetPosition(viewHolder)) {
                                if (!z) {
                                    viewHolder.addFlags(4);
                                    if (viewHolder.isScrap()) {
                                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                                        viewHolder.unScrap();
                                    } else if (viewHolder.wasReturnedFromScrap()) {
                                        viewHolder.clearReturnedFromScrapFlag();
                                    }
                                    recycleViewHolderInternal(viewHolder);
                                }
                                viewHolder = null;
                            } else {
                                z2 = true;
                            }
                        }
                        if (viewHolder == null) {
                            int findPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i);
                            if (findPositionOffset >= 0 && findPositionOffset < RecyclerView.this.mAdapter.getItemCount()) {
                                int itemViewType = RecyclerView.this.mAdapter.getItemViewType(findPositionOffset);
                                if (RecyclerView.this.mAdapter.hasStableIds() && (viewHolder = getScrapOrCachedViewForId(RecyclerView.this.mAdapter.getItemId(findPositionOffset), itemViewType, z)) != null) {
                                    viewHolder.mPosition = findPositionOffset;
                                    z2 = true;
                                }
                                if (viewHolder == null && (viewCacheExtension = this.mViewCacheExtension) != null && (viewForPositionAndType = viewCacheExtension.getViewForPositionAndType(this, i, itemViewType)) != null) {
                                    viewHolder = RecyclerView.this.getChildViewHolder(viewForPositionAndType);
                                    if (viewHolder != null) {
                                        if (viewHolder.shouldIgnore()) {
                                            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.exceptionLabel());
                                        }
                                    } else {
                                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.exceptionLabel());
                                    }
                                }
                                if (viewHolder == null) {
                                    ViewHolder recycledView = getRecycledViewPool().getRecycledView(itemViewType);
                                    if (recycledView != null) {
                                        recycledView.resetInternal();
                                        if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                            invalidateDisplayListInt(recycledView);
                                        }
                                    }
                                    viewHolder = recycledView;
                                }
                                if (viewHolder == null) {
                                    long nanoTime = RecyclerView.this.getNanoTime();
                                    if (j != Long.MAX_VALUE && !this.mRecyclerPool.willCreateInTime(itemViewType, nanoTime, j)) {
                                        return null;
                                    }
                                    RecyclerView recyclerView = RecyclerView.this;
                                    ViewHolder createViewHolder = recyclerView.mAdapter.createViewHolder(recyclerView, itemViewType);
                                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && (findNestedRecyclerView = RecyclerView.findNestedRecyclerView(createViewHolder.itemView)) != null) {
                                        createViewHolder.mNestedRecyclerView = new WeakReference<>(findNestedRecyclerView);
                                    }
                                    this.mRecyclerPool.factorInCreateTime(itemViewType, RecyclerView.this.getNanoTime() - nanoTime);
                                    viewHolder2 = createViewHolder;
                                    z3 = z2;
                                    if (z3 && !RecyclerView.this.mState.isPreLayout() && viewHolder2.hasAnyOfTheFlags(8192)) {
                                        viewHolder2.setFlags(0, 8192);
                                        if (RecyclerView.this.mState.mRunSimpleAnimations) {
                                            RecyclerView recyclerView2 = RecyclerView.this;
                                            RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(viewHolder2, recyclerView2.mItemAnimator.recordPreLayoutInformation(recyclerView2.mState, viewHolder2, ItemAnimator.buildAdapterChangeFlagsForAnimations(viewHolder2) | 4096, viewHolder2.getUnmodifiedPayloads()));
                                        }
                                    }
                                    if (!RecyclerView.this.mState.isPreLayout() && viewHolder2.isBound()) {
                                        viewHolder2.mPreLayoutPosition = i;
                                    } else if (viewHolder2.isBound() || viewHolder2.needsUpdate() || viewHolder2.isInvalid()) {
                                        tryBindViewHolderByDeadline = tryBindViewHolderByDeadline(viewHolder2, RecyclerView.this.mAdapterHelper.findPositionOffset(i), i, j);
                                        layoutParams = viewHolder2.itemView.getLayoutParams();
                                        if (layoutParams != null) {
                                            layoutParams2 = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                                            viewHolder2.itemView.setLayoutParams(layoutParams2);
                                        } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                                            layoutParams2 = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams);
                                            viewHolder2.itemView.setLayoutParams(layoutParams2);
                                        } else {
                                            layoutParams2 = (LayoutParams) layoutParams;
                                        }
                                        layoutParams2.mViewHolder = viewHolder2;
                                        layoutParams2.mPendingInvalidate = (z3 || !tryBindViewHolderByDeadline) ? false : false;
                                        return viewHolder2;
                                    }
                                    tryBindViewHolderByDeadline = false;
                                    layoutParams = viewHolder2.itemView.getLayoutParams();
                                    if (layoutParams != null) {
                                    }
                                    layoutParams2.mViewHolder = viewHolder2;
                                    layoutParams2.mPendingInvalidate = (z3 || !tryBindViewHolderByDeadline) ? false : false;
                                    return viewHolder2;
                                }
                            } else {
                                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + findPositionOffset + ").state:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
                            }
                        }
                        viewHolder2 = viewHolder;
                        z3 = z2;
                        if (z3) {
                            viewHolder2.setFlags(0, 8192);
                            if (RecyclerView.this.mState.mRunSimpleAnimations) {
                            }
                        }
                        if (!RecyclerView.this.mState.isPreLayout()) {
                        }
                        if (viewHolder2.isBound()) {
                        }
                        tryBindViewHolderByDeadline = tryBindViewHolderByDeadline(viewHolder2, RecyclerView.this.mAdapterHelper.findPositionOffset(i), i, j);
                        layoutParams = viewHolder2.itemView.getLayoutParams();
                        if (layoutParams != null) {
                        }
                        layoutParams2.mViewHolder = viewHolder2;
                        layoutParams2.mPendingInvalidate = (z3 || !tryBindViewHolderByDeadline) ? false : false;
                        return viewHolder2;
                    }
                } else {
                    viewHolder = null;
                }
                z2 = false;
                if (viewHolder == null) {
                    if (validateViewHolderForOffsetPosition(viewHolder)) {
                    }
                }
                if (viewHolder == null) {
                }
                viewHolder2 = viewHolder;
                z3 = z2;
                if (z3) {
                }
                if (!RecyclerView.this.mState.isPreLayout()) {
                }
                if (viewHolder2.isBound()) {
                }
                tryBindViewHolderByDeadline = tryBindViewHolderByDeadline(viewHolder2, RecyclerView.this.mAdapterHelper.findPositionOffset(i), i, j);
                layoutParams = viewHolder2.itemView.getLayoutParams();
                if (layoutParams != null) {
                }
                layoutParams2.mViewHolder = viewHolder2;
                layoutParams2.mPendingInvalidate = (z3 || !tryBindViewHolderByDeadline) ? false : false;
                return viewHolder2;
            }
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
        }
    }

    /* loaded from: classes.dex */
    public class RecyclerViewDataObserver extends AdapterDataObserver {
        public RecyclerViewDataObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.mStructureChanged = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.hasPendingUpdates()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void triggerUpdateProcessor() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    ViewCompat.postOnAnimation(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeChanged(i, i2, obj)) {
                triggerUpdateProcessor();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeMoved(i, i2, i3)) {
                triggerUpdateProcessor();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeInserted(i, i2)) {
                triggerUpdateProcessor();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeRemoved(i, i2)) {
                triggerUpdateProcessor();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class State {
        public static final int STEP_ANIMATIONS = 4;
        public static final int STEP_LAYOUT = 2;
        public static final int STEP_START = 1;
        public SparseArray<Object> mData;
        public long mFocusedItemId;
        public int mFocusedItemPosition;
        public int mFocusedSubChildId;
        public int mRemainingScrollHorizontal;
        public int mRemainingScrollVertical;
        public int mTargetPosition = -1;
        public int mPreviousLayoutItemCount = 0;
        public int mDeletedInvisibleItemCountSincePreviousLayout = 0;
        public int mLayoutStep = 1;
        public int mItemCount = 0;
        public boolean mStructureChanged = false;
        public boolean mInPreLayout = false;
        public boolean mTrackOldChangeHolders = false;
        public boolean mIsMeasuring = false;
        public boolean mRunSimpleAnimations = false;
        public boolean mRunPredictiveAnimations = false;

        public boolean didStructureChange() {
            return this.mStructureChanged;
        }

        public int getItemCount() {
            if (this.mInPreLayout) {
                return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
            }
            return this.mItemCount;
        }

        public int getRemainingScrollHorizontal() {
            return this.mRemainingScrollHorizontal;
        }

        public int getRemainingScrollVertical() {
            return this.mRemainingScrollVertical;
        }

        public int getTargetScrollPosition() {
            return this.mTargetPosition;
        }

        public boolean hasTargetScrollPosition() {
            if (this.mTargetPosition != -1) {
                return true;
            }
            return false;
        }

        public boolean isMeasuring() {
            return this.mIsMeasuring;
        }

        public boolean isPreLayout() {
            return this.mInPreLayout;
        }

        public boolean willRunPredictiveAnimations() {
            return this.mRunPredictiveAnimations;
        }

        public boolean willRunSimpleAnimations() {
            return this.mRunSimpleAnimations;
        }

        public void assertLayoutStep(int i) {
            if ((this.mLayoutStep & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
        }

        public <T> T get(int i) {
            SparseArray<Object> sparseArray = this.mData;
            if (sparseArray == null) {
                return null;
            }
            return (T) sparseArray.get(i);
        }

        public void prepareForNestedPrefetch(Adapter adapter) {
            this.mLayoutStep = 1;
            this.mItemCount = adapter.getItemCount();
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
        }

        public void remove(int i) {
            SparseArray<Object> sparseArray = this.mData;
            if (sparseArray == null) {
                return;
            }
            sparseArray.remove(i);
        }

        public void put(int i, Object obj) {
            if (this.mData == null) {
                this.mData = new SparseArray<>();
            }
            this.mData.put(i, obj);
        }

        public String toString() {
            return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mIsMeasuring=" + this.mIsMeasuring + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
        }
    }

    /* loaded from: classes.dex */
    public class ViewFlinger implements Runnable {
        public int mLastFlingX;
        public int mLastFlingY;
        public OverScroller mOverScroller;
        public Interpolator mInterpolator = RecyclerView.sQuinticInterpolator;
        public boolean mEatRunOnAnimationRequest = false;
        public boolean mReSchedulePostAnimationCallback = false;

        public ViewFlinger() {
            this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        private float distanceInfluenceForSnapDuration(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int computeScrollDuration(int i, int i2, int i3, int i4) {
            boolean z;
            int height;
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            if (abs > abs2) {
                z = true;
            } else {
                z = false;
            }
            int sqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int sqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            if (z) {
                height = recyclerView.getWidth();
            } else {
                height = recyclerView.getHeight();
            }
            int i6 = height / 2;
            float f = height;
            float f2 = i6;
            float distanceInfluenceForSnapDuration = f2 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (sqrt2 * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(distanceInfluenceForSnapDuration / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((abs / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        private void internalPostOnAnimation() {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        public void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                internalPostOnAnimation();
            }
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
        }

        public void fling(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            Interpolator interpolator = this.mInterpolator;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.mInterpolator = interpolator2;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
            }
            this.mOverScroller.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            int i3;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                stop();
                return;
            }
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i4 = currX - this.mLastFlingX;
                int i5 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i4, i5, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    i4 -= iArr2[0];
                    i5 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i4, i5);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(i4, i5, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i2 = iArr4[0];
                    i = iArr4[1];
                    i4 -= i2;
                    i5 -= i;
                    SmoothScroller smoothScroller = recyclerView4.mLayout.mSmoothScroller;
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int itemCount = RecyclerView.this.mState.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.getTargetPosition() >= itemCount) {
                            smoothScroller.setTargetPosition(itemCount - 1);
                            smoothScroller.onAnimation(i2, i);
                        } else {
                            smoothScroller.onAnimation(i2, i);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i2, i, i4, i5, null, 1, iArr5);
                int[] iArr6 = RecyclerView.this.mReusableIntPair;
                int i6 = i4 - iArr6[0];
                int i7 = i5 - iArr6[1];
                if (i2 != 0 || i != 0) {
                    RecyclerView.this.dispatchOnScrolled(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                if (overScroller.getCurrX() == overScroller.getFinalX()) {
                    z = true;
                } else {
                    z = false;
                }
                if (overScroller.getCurrY() == overScroller.getFinalY()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!overScroller.isFinished() && ((!z && i6 == 0) || (!z2 && i7 == 0))) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                SmoothScroller smoothScroller2 = RecyclerView.this.mLayout.mSmoothScroller;
                if (smoothScroller2 != null && smoothScroller2.isPendingInitialRun()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z4 && z3) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i6 < 0) {
                            i3 = -currVelocity;
                        } else if (i6 > 0) {
                            i3 = currVelocity;
                        } else {
                            i3 = 0;
                        }
                        if (i7 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i7 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i3, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
                    }
                } else {
                    postOnAnimation();
                    RecyclerView recyclerView6 = RecyclerView.this;
                    GapWorker gapWorker = recyclerView6.mGapWorker;
                    if (gapWorker != null) {
                        gapWorker.postFromTraversal(recyclerView6, i2, i);
                    }
                }
            }
            SmoothScroller smoothScroller3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
                smoothScroller3.onAnimation(0, 0);
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                internalPostOnAnimation();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }

        public void smoothScrollBy(int i, int i2, int i3, @Nullable Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = computeScrollDuration(i, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            RecyclerView.this.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.mOverScroller.computeScrollOffset();
            }
            postOnAnimation();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewHolder {
        public static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        public static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        public static final int FLAG_BOUND = 1;
        public static final int FLAG_IGNORE = 128;
        public static final int FLAG_INVALID = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_NOT_RECYCLABLE = 16;
        public static final int FLAG_REMOVED = 8;
        public static final int FLAG_RETURNED_FROM_SCRAP = 32;
        public static final int FLAG_TMP_DETACHED = 256;
        public static final int FLAG_UPDATE = 2;
        public static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        public static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        @NonNull
        public final View itemView;
        public int mFlags;
        public WeakReference<RecyclerView> mNestedRecyclerView;
        public RecyclerView mOwnerRecyclerView;
        public int mPosition = -1;
        public int mOldPosition = -1;
        public long mItemId = -1;
        public int mItemViewType = -1;
        public int mPreLayoutPosition = -1;
        public ViewHolder mShadowedHolder = null;
        public ViewHolder mShadowingHolder = null;
        public List<Object> mPayloads = null;
        public List<Object> mUnmodifiedPayloads = null;
        public int mIsRecyclableCount = 0;
        public Recycler mScrapContainer = null;
        public boolean mInChangeScrap = false;
        public int mWasImportantForAccessibilityBeforeHidden = 0;
        @VisibleForTesting
        public int mPendingAccessibilityState = -1;

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) == 0 && ViewCompat.hasTransientState(this.itemView)) {
                return true;
            }
            return false;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            if (i == -1) {
                return this.mPosition;
            }
            return i;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            if (i == -1) {
                return this.mPosition;
            }
            return i;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) == 0) {
                List<Object> list = this.mPayloads;
                if (list != null && list.size() != 0) {
                    return this.mUnmodifiedPayloads;
                }
                return FULLUPDATE_PAYLOADS;
            }
            return FULLUPDATE_PAYLOADS;
        }

        public boolean isAdapterPositionUnknown() {
            if ((this.mFlags & 512) == 0 && !isInvalid()) {
                return false;
            }
            return true;
        }

        public boolean isAttachedToTransitionOverlay() {
            if (this.itemView.getParent() != null && this.itemView.getParent() != this.mOwnerRecyclerView) {
                return true;
            }
            return false;
        }

        public boolean isBound() {
            if ((this.mFlags & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean isInvalid() {
            if ((this.mFlags & 4) != 0) {
                return true;
            }
            return false;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) == 0 && !ViewCompat.hasTransientState(this.itemView)) {
                return true;
            }
            return false;
        }

        public boolean isRemoved() {
            if ((this.mFlags & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean isScrap() {
            if (this.mScrapContainer != null) {
                return true;
            }
            return false;
        }

        public boolean isTmpDetached() {
            if ((this.mFlags & 256) != 0) {
                return true;
            }
            return false;
        }

        public boolean isUpdated() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean needsUpdate() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public boolean shouldBeKeptAsChild() {
            if ((this.mFlags & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean shouldIgnore() {
            if ((this.mFlags & 128) != 0) {
                return true;
            }
            return false;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        public boolean wasReturnedFromScrap() {
            if ((this.mFlags & 32) != 0) {
                return true;
            }
            return false;
        }

        public ViewHolder(@NonNull View view2) {
            if (view2 != null) {
                this.itemView = view2;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        public boolean hasAnyOfTheFlags(int i) {
            if ((i & this.mFlags) != 0) {
                return true;
            }
            return false;
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (~i2));
        }

        public void setScrapContainer(Recycler recycler, boolean z) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = z;
        }

        public final void setIsRecyclable(boolean z) {
            int i;
            int i2 = this.mIsRecyclableCount;
            if (z) {
                i = i2 - 1;
            } else {
                i = i2 + 1;
            }
            this.mIsRecyclableCount = i;
            if (i < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public String toString() {
            String simpleName;
            String str;
            if (getClass().isAnonymousClass()) {
                simpleName = "ViewHolder";
            } else {
                simpleName = getClass().getSimpleName();
            }
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                if (this.mInChangeScrap) {
                    str = "[changeScrap]";
                } else {
                    str = "[attachedScrap]";
                }
                sb.append(str);
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + SmallTailInfo.EMOTION_SUFFIX);
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    static {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i = Build.VERSION.SDK_INT;
        if (i != 18 && i != 19 && i != 20) {
            z = false;
        } else {
            z = true;
        }
        FORCE_INVALIDATE_DISPLAY_LIST = z;
        if (Build.VERSION.SDK_INT >= 23) {
            z2 = true;
        } else {
            z2 = false;
        }
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = z2;
        if (Build.VERSION.SDK_INT >= 16) {
            z3 = true;
        } else {
            z3 = false;
        }
        POST_UPDATES_ON_ANIMATION = z3;
        if (Build.VERSION.SDK_INT >= 21) {
            z4 = true;
        } else {
            z4 = false;
        }
        ALLOW_THREAD_GAP_WORK = z4;
        if (Build.VERSION.SDK_INT <= 15) {
            z5 = true;
        } else {
            z5 = false;
        }
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = z5;
        if (Build.VERSION.SDK_INT <= 15) {
            z6 = true;
        } else {
            z6 = false;
        }
        IGNORE_DETACHED_FOCUSED_CHILD = z6;
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z;
        boolean z2;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.reset();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.preProcess();
        } else {
            this.mAdapterHelper.consumeUpdatesInOnePass();
        }
        boolean z3 = false;
        if (!this.mItemsAddedOrRemoved && !this.mItemsChanged) {
            z = false;
        } else {
            z = true;
        }
        State state = this.mState;
        if (this.mFirstLayoutComplete && this.mItemAnimator != null && ((this.mDataSetHasChangedAfterLayout || z || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds()))) {
            z2 = true;
        } else {
            z2 = false;
        }
        state.mRunSimpleAnimations = z2;
        State state2 = this.mState;
        if (state2.mRunSimpleAnimations && z && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z3 = true;
        }
        state2.mRunPredictiveAnimations = z3;
    }

    public void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout) {
            if (!this.mAdapterHelper.hasPendingUpdates()) {
                return;
            }
            if (this.mAdapterHelper.hasAnyUpdateTypes(4) && !this.mAdapterHelper.hasAnyUpdateTypes(11)) {
                TraceCompat.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.preProcess();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.consumePostponedUpdates();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                TraceCompat.endSection();
                return;
            } else if (this.mAdapterHelper.hasPendingUpdates()) {
                TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                TraceCompat.endSection();
                return;
            } else {
                return;
            }
        }
        TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
    }

    /* loaded from: classes.dex */
    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            onItemRangeChanged(i, i2);
        }
    }

    /* loaded from: classes.dex */
    public static class EdgeEffectFactory {
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface EdgeDirection {
        }

        @NonNull
        public EdgeEffect createEdgeEffect(@NonNull RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemDecoration {
        @Deprecated
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        @Deprecated
        public void getItemOffsets(@NonNull Rect rect, int i, @NonNull RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDrawOver(canvas, recyclerView);
        }

        public void getItemOffsets(@NonNull Rect rect, @NonNull View view2, @NonNull RecyclerView recyclerView, @NonNull State state) {
            getItemOffsets(rect, ((LayoutParams) view2.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.recyclerview.widget.RecyclerView.SavedState.1
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
        public Parcelable mLayoutState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mLayoutState = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.mLayoutState, 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void copyFrom(SavedState savedState) {
            this.mLayoutState = savedState.mLayoutState;
        }
    }

    public RecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public static void clearNestedRecyclerViewIfNotNested(@NonNull ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == viewHolder.itemView) {
                    return;
                }
                ViewParent parent = recyclerView.getParent();
                if (parent instanceof View) {
                    recyclerView = (View) parent;
                } else {
                    recyclerView = null;
                }
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        OnItemTouchListener onItemTouchListener = this.mInterceptingOnItemTouchListener;
        if (onItemTouchListener == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        onItemTouchListener.onTouchEvent(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i);
            if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static RecyclerView findNestedRecyclerView(@NonNull View view2) {
        if (!(view2 instanceof ViewGroup)) {
            return null;
        }
        if (view2 instanceof RecyclerView) {
            return (RecyclerView) view2;
        }
        ViewGroup viewGroup = (ViewGroup) view2;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    public static ViewHolder getChildViewHolderInt(View view2) {
        if (view2 == null) {
            return null;
        }
        return ((LayoutParams) view2.getLayoutParams()).mViewHolder;
    }

    private int getDeepestFocusedViewWithId(View view2) {
        int id = view2.getId();
        while (!view2.isFocused() && (view2 instanceof ViewGroup) && view2.hasFocus()) {
            view2 = ((ViewGroup) view2).getFocusedChild();
            if (view2.getId() != -1) {
                id = view2.getId();
            }
        }
        return id;
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int i;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void addOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null && !itemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.getUnmodifiedPayloads())) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams)) {
            return true;
        }
        return false;
    }

    public void dispatchChildAttached(View view2) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view2);
        onChildAttachedToWindow(view2);
        Adapter adapter = this.mAdapter;
        if (adapter != null && childViewHolderInt != null) {
            adapter.onViewAttachedToWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view2);
            }
        }
    }

    public void dispatchChildDetached(View view2) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view2);
        onChildDetachedFromWindow(view2);
        Adapter adapter = this.mAdapter;
        if (adapter != null && childViewHolderInt != null) {
            adapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view2);
            }
        }
    }

    public void dispatchOnScrollStateChanged(int i) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public final void fillRemainingScrollValues(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.mOverScroller;
            state.mRemainingScrollHorizontal = overScroller.getFinalX() - overScroller.getCurrX();
            state.mRemainingScrollVertical = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        state.mRemainingScrollHorizontal = 0;
        state.mRemainingScrollVertical = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r3;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View findContainingItemView(@NonNull View view2) {
        ViewParent parent = view2.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view2 = (View) parent;
            parent = view2.getParent();
        }
        return null;
    }

    @Nullable
    public ViewHolder findContainingViewHolder(@NonNull View view2) {
        View findContainingItemView = findContainingItemView(view2);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    @Nullable
    public ViewHolder findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    @Nullable
    @Deprecated
    public ViewHolder findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public int getAdapterPositionFor(ViewHolder viewHolder) {
        if (!viewHolder.hasAnyOfTheFlags(524) && viewHolder.isBound()) {
            return this.mAdapterHelper.applyPendingUpdatesToPosition(viewHolder.mPosition);
        }
        return -1;
    }

    public long getChangedHolderKey(ViewHolder viewHolder) {
        if (this.mAdapter.hasStableIds()) {
            return viewHolder.getItemId();
        }
        return viewHolder.mPosition;
    }

    public int getChildAdapterPosition(@NonNull View view2) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view2);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    public long getChildItemId(@NonNull View view2) {
        ViewHolder childViewHolderInt;
        Adapter adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view2)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(@NonNull View view2) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view2);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(@NonNull View view2) {
        return getChildAdapterPosition(view2);
    }

    public ViewHolder getChildViewHolder(@NonNull View view2) {
        ViewParent parent = view2.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view2 + " is not a direct child of " + this);
        }
        return getChildViewHolderInt(view2);
    }

    @NonNull
    public ItemDecoration getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return this.mItemDecorations.get(i);
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().hasNestedScrollingParent(i);
    }

    public void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i);
        awakenScrollBars();
    }

    public void offsetChildrenHorizontal(@Px int i) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.mChildHelper.getChildAt(i2).offsetLeftAndRight(i);
        }
    }

    public void offsetChildrenVertical(@Px int i) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.mChildHelper.getChildAt(i2).offsetTopAndBottom(i);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDraw(canvas, this, this.mState);
        }
    }

    public void onExitLayoutOrScroll(boolean z) {
        int i = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i;
        if (i < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && (parcelable2 = this.mPendingSavedState.mLayoutState) != null) {
            layoutManager.onRestoreInstanceState(parcelable2);
        }
    }

    public void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public boolean removeAnimatingView(View view2) {
        startInterceptRequestLayout();
        boolean removeViewIfHidden = this.mChildHelper.removeViewIfHidden(view2);
        if (removeViewIfHidden) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view2);
            this.mRecycler.unscrapView(childViewHolderInt);
            this.mRecycler.recycleViewHolderInternal(childViewHolderInt);
        }
        stopInterceptRequestLayout(!removeViewIfHidden);
        return removeViewIfHidden;
    }

    public void removeItemDecoration(@NonNull ItemDecoration itemDecoration) {
        boolean z;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty()) {
            if (getOverScrollMode() == 2) {
                z = true;
            } else {
                z = false;
            }
            setWillNotDraw(z);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i));
            return;
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(onChildAttachStateChangeListener);
    }

    public void removeOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mInterceptingOnItemTouchListener == onItemTouchListener) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void scrollToPosition(int i) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        layoutManager.scrollToPosition(i);
        awakenScrollBars();
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(@Nullable Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback childDrawingOrderCallback) {
        boolean z;
        if (childDrawingOrderCallback == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = childDrawingOrderCallback;
        if (childDrawingOrderCallback != null) {
            z = true;
        } else {
            z = false;
        }
        setChildrenDrawingOrderEnabled(z);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory edgeEffectFactory) {
        Preconditions.checkNotNull(edgeEffectFactory);
        this.mEdgeEffectFactory = edgeEffectFactory;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public void setItemAnimator(@Nullable ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.mItemAnimator;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.mItemAnimator.setListener(null);
        }
        this.mItemAnimator = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.setListener(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.mRecycler.setViewCacheSize(i);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    public void setOnFlingListener(@Nullable OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool recycledViewPool) {
        this.mRecycler.setRecycledViewPool(recycledViewPool);
    }

    public void setRecyclerListener(@Nullable RecyclerListener recyclerListener) {
        this.mRecyclerListener = recyclerListener;
    }

    public void setScrollState(int i) {
        if (i == this.mScrollState) {
            return;
        }
        this.mScrollState = i;
        if (i != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i);
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension viewCacheExtension) {
        this.mRecycler.setViewCacheExtension(viewCacheExtension);
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i;
        int i2 = 0;
        if (!isComputingLayout()) {
            return false;
        }
        if (accessibilityEvent != null) {
            i = AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent);
        } else {
            i = 0;
        }
        if (i != 0) {
            i2 = i;
        }
        this.mEatenAccessibilityChangeFlags |= i2;
        return true;
    }

    public void smoothScrollToPosition(int i) {
        if (this.mLayoutSuppressed) {
            return;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.smoothScrollToPosition(this, this.mState, i);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i) {
        getScrollingChildHelper().stopNestedScroll(i);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405bb);
    }

    private boolean didChildRangeChange(int i, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        if (iArr[0] == i && iArr[1] == i2) {
            return false;
        }
        return true;
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration, int i) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(itemDecoration);
        } else {
            this.mItemDecorations.add(i, itemDecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(LayoutManager.chooseSize(i, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.mChildDrawingOrderCallback;
        if (childDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return childDrawingOrderCallback.onGetChildDrawingOrder(i, i2);
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view2, @NonNull Rect rect) {
        getDecoratedBoundsWithMarginsInt(view2, rect);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, 8192);
        if (this.mState.mTrackOldChangeHolders && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(viewHolder), viewHolder);
        }
        this.mViewInfoStore.addToPreLayout(viewHolder, itemHolderInfo);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view2, View view3) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view2, view3) && view3 != null) {
            requestChildOnScreen(view2, view3);
        }
        super.requestChildFocus(view2, view3);
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.mLayoutSuppressed) {
        } else {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i = 0;
                }
                if (!canScrollVertically) {
                    i2 = 0;
                }
                scrollByInternal(i, i2, null);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @VisibleForTesting
    public boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int i) {
        if (isComputingLayout()) {
            viewHolder.mPendingAccessibilityState = i;
            this.mPendingAccessibilityImportanceChange.add(viewHolder);
            return false;
        }
        ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
        return true;
    }

    public void smoothScrollBy(@Px int i, @Px int i2) {
        smoothScrollBy(i, i2, null);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().startNestedScroll(i, i2);
    }

    public void swapAdapter(@Nullable Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        GapWorker.LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl;
        boolean z;
        this.mObserver = new RecyclerViewDataObserver();
        this.mRecycler = new Recycler();
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    if (!recyclerView2.mIsAttached) {
                        recyclerView2.requestLayout();
                    } else if (recyclerView2.mLayoutSuppressed) {
                        recyclerView2.mLayoutWasDefered = true;
                    } else {
                        recyclerView2.consumePendingUpdateOperations();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new EdgeEffectFactory();
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z2 = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger();
        if (ALLOW_THREAD_GAP_WORK) {
            layoutPrefetchRegistryImpl = new GapWorker.LayoutPrefetchRegistryImpl();
        } else {
            layoutPrefetchRegistryImpl = null;
        }
        this.mPrefetchRegistry = layoutPrefetchRegistryImpl;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                ItemAnimator itemAnimator = RecyclerView.this.mItemAnimator;
                if (itemAnimator != null) {
                    itemAnimator.runPendingAnimations();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback() { // from class: androidx.recyclerview.widget.RecyclerView.4
            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void unused(ViewHolder viewHolder) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.removeAndRecycleView(viewHolder.itemView, recyclerView.mRecycler);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processAppeared(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processDisappeared(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.mRecycler.unscrapView(viewHolder);
                RecyclerView.this.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processPersistent(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mDataSetHasChangedAfterLayout) {
                    if (recyclerView.mItemAnimator.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if (recyclerView.mItemAnimator.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        if (getOverScrollMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R.styleable.RecyclerView, attributeSet, obtainStyledAttributes, i, 0);
        }
        String string = obtainStyledAttributes.getString(8);
        if (obtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(1, true);
        boolean z3 = obtainStyledAttributes.getBoolean(3, false);
        this.mEnableFastScroller = z3;
        if (z3) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(6), obtainStyledAttributes.getDrawable(7), (StateListDrawable) obtainStyledAttributes.getDrawable(4), obtainStyledAttributes.getDrawable(5));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i, 0);
            if (Build.VERSION.SDK_INT >= 29) {
                saveAttributeDataForStyleable(context, NESTED_SCROLLING_ATTRS, attributeSet, obtainStyledAttributes2, i, 0);
            }
            z2 = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            invalidateGlows();
        }
    }

    public void smoothScrollBy(@Px int i, @Px int i2, @Nullable Interpolator interpolator, int i3) {
        smoothScrollBy(i, i2, interpolator, i3, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    public void animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view2, long j) {
        return super.drawChild(canvas, view2, j);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view2, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view2, rect, z);
    }

    public void smoothScrollBy(@Px int i, @Px int i2, @Nullable Interpolator interpolator) {
        smoothScrollBy(i, i2, interpolator, Integer.MIN_VALUE);
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        boolean z;
        View view2 = viewHolder.itemView;
        if (view2.getParent() == this) {
            z = true;
        } else {
            z = false;
        }
        this.mRecycler.unscrapView(getChildViewHolder(view2));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.attachViewToParent(view2, -1, view2.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.addView(view2, true);
        } else {
            this.mChildHelper.hide(view2);
        }
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    public void assertInLayoutOrScroll(String str) {
        if (!isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str + exceptionLabel());
        }
    }

    @Nullable
    public ViewHolder findViewHolderForAdapterPosition(int i) {
        ViewHolder viewHolder = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i) {
                if (this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                    viewHolder = childViewHolderInt;
                } else {
                    return childViewHolderInt;
                }
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j) {
        Adapter adapter = this.mAdapter;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i = 0; i < unfilteredChildCount; i++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j) {
                    if (this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                        viewHolder = childViewHolderInt;
                    } else {
                        return childViewHolderInt;
                    }
                }
            }
        }
        return viewHolder;
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.mLayoutSuppressed = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    private void animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z, boolean z2) {
        viewHolder.setIsRecyclable(false);
        if (z) {
            addAnimatingView(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z2) {
                addAnimatingView(viewHolder2);
            }
            viewHolder.mShadowedHolder = viewHolder2;
            addAnimatingView(viewHolder);
            this.mRecycler.unscrapView(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (this.mItemAnimator.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.setContentChangeTypes(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    private boolean hasUpdatedView() {
        int childCount = this.mChildHelper.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill(this) == 0) {
            ViewCompat.setImportantForAutofill(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new ChildHelper.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.5
            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public View getChildAt(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public ViewHolder getChildViewHolder(View view2) {
                return RecyclerView.getChildViewHolderInt(view2);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public int indexOfChild(View view2) {
                return RecyclerView.this.indexOfChild(view2);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void onEnteredHiddenState(View view2) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void onLeftHiddenState(View view2) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void removeViewAt(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void addView(View view2, int i) {
                RecyclerView.this.addView(view2, i);
                RecyclerView.this.dispatchChildAttached(view2);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void attachViewToParent(View view2, int i, ViewGroup.LayoutParams layoutParams) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                    childViewHolderInt.clearTmpDetachFlag();
                }
                RecyclerView.this.attachViewToParent(view2, i, layoutParams);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void detachViewFromParent(int i) {
                ViewHolder childViewHolderInt;
                View childAt = getChildAt(i);
                if (childAt != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) != null) {
                    if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                    childViewHolderInt.addFlags(256);
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void removeAllViews() {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }
        });
    }

    private boolean predictiveItemAnimationsEnabled() {
        if (this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations()) {
            return true;
        }
        return false;
    }

    private void resetFocusInfo() {
        State state = this.mState;
        state.mFocusedItemId = -1L;
        state.mFocusedItemPosition = -1;
        state.mFocusedSubChildId = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.stopSmoothScroller();
        }
    }

    public void clearOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.clearOldPositions();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.mLayout.computeHorizontalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.mLayout.computeHorizontalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.mLayout.computeHorizontalScrollRange(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.mLayout.computeVerticalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.mLayout.computeVerticalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.mLayout.computeVerticalScrollRange(this.mState);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Nullable
    public Adapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout && !this.mAdapterHelper.hasPendingUpdates()) {
            return false;
        }
        return true;
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.6
            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public ViewHolder findViewHolder(int i) {
                ViewHolder findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
                if (findViewHolderForPosition == null || RecyclerView.this.mChildHelper.isHidden(findViewHolderForPosition.itemView)) {
                    return null;
                }
                return findViewHolderForPosition;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void onDispatchFirstPass(AdapterHelper.UpdateOp updateOp) {
                dispatchUpdate(updateOp);
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void onDispatchSecondPass(AdapterHelper.UpdateOp updateOp) {
                dispatchUpdate(updateOp);
            }

            public void dispatchUpdate(AdapterHelper.UpdateOp updateOp) {
                int i = updateOp.cmd;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 4) {
                            if (i == 8) {
                                RecyclerView recyclerView = RecyclerView.this;
                                recyclerView.mLayout.onItemsMoved(recyclerView, updateOp.positionStart, updateOp.itemCount, 1);
                                return;
                            }
                            return;
                        }
                        RecyclerView recyclerView2 = RecyclerView.this;
                        recyclerView2.mLayout.onItemsUpdated(recyclerView2, updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                        return;
                    }
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.mLayout.onItemsRemoved(recyclerView3, updateOp.positionStart, updateOp.itemCount);
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.mLayout.onItemsAdded(recyclerView4, updateOp.positionStart, updateOp.itemCount);
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void markViewHoldersUpdated(int i, int i2, Object obj) {
                RecyclerView.this.viewRangeUpdate(i, i2, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForAdd(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForInsert(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForMove(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForMove(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForRemovingInvisible(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.mDeletedInvisibleItemCountSincePreviousLayout += i2;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        });
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            return true;
        }
        return false;
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null && itemAnimator.isRunning()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        if (this.mLayoutOrScrollCounter > 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    public void markItemDecorInsetsDirty() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(i).getLayoutParams()).mInsetsDirty = true;
        }
        this.mRecycler.markItemDecorInsetsDirty();
    }

    public void markKnownViewsInvalid() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.markKnownViewsInvalid();
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.copyFrom(savedState2);
        } else {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                savedState.mLayoutState = layoutManager.onSaveInstanceState();
            } else {
                savedState.mLayoutState = null;
            }
        }
        return savedState;
    }

    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    public void removeAndRecycleViews() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.clear();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutSuppressed) {
            super.requestLayout();
        } else {
            this.mLayoutWasDefered = true;
        }
    }

    public void saveOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    public void startInterceptRequestLayout() {
        int i = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i;
        if (i == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(LayoutManager.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                    } catch (NoSuchMethodException e) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                        } catch (NoSuchMethodException e2) {
                            e2.initCause(e);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e2);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (ClassCastException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e4);
                } catch (IllegalAccessException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e6);
                } catch (InvocationTargetException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
                }
            }
        }
    }

    private void dispatchLayoutStep1() {
        boolean z = true;
        this.mState.assertLayoutStep(1);
        fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State state = this.mState;
        state.mTrackOldChangeHolders = (state.mRunSimpleAnimations && this.mItemsChanged) ? false : false;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        State state2 = this.mState;
        state2.mInPreLayout = state2.mRunPredictiveAnimations;
        state2.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.addToPreLayout(childViewHolderInt, this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt, ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.mTrackOldChangeHolders && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.mRunPredictiveAnimations) {
            saveOldPositions();
            State state3 = this.mState;
            boolean z2 = state3.mStructureChanged;
            state3.mStructureChanged = false;
            this.mLayout.onLayoutChildren(this.mRecycler, state3);
            this.mState.mStructureChanged = z2;
            for (int i2 = 0; i2 < this.mChildHelper.getChildCount(); i2++) {
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.getChildAt(i2));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.isInPreLayout(childViewHolderInt2)) {
                    int buildAdapterChangeFlagsForAnimations = ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        buildAdapterChangeFlagsForAnimations |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo recordPreLayoutInformation = this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt2, buildAdapterChangeFlagsForAnimations, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, recordPreLayoutInformation);
                    } else {
                        this.mViewInfoStore.addToAppearedInPreLayoutHolders(childViewHolderInt2, recordPreLayoutInformation);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
    }

    private void dispatchLayoutStep3() {
        this.mState.assertLayoutStep(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        State state = this.mState;
        state.mLayoutStep = 1;
        if (state.mRunSimpleAnimations) {
            for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(childCount));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    ItemAnimator.ItemHolderInfo recordPostLayoutInformation = this.mItemAnimator.recordPostLayoutInformation(this.mState, childViewHolderInt);
                    ViewHolder fromOldChangeHolders = this.mViewInfoStore.getFromOldChangeHolders(changedHolderKey);
                    if (fromOldChangeHolders != null && !fromOldChangeHolders.shouldIgnore()) {
                        boolean isDisappearing = this.mViewInfoStore.isDisappearing(fromOldChangeHolders);
                        boolean isDisappearing2 = this.mViewInfoStore.isDisappearing(childViewHolderInt);
                        if (isDisappearing && fromOldChangeHolders == childViewHolderInt) {
                            this.mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                        } else {
                            ItemAnimator.ItemHolderInfo popFromPreLayout = this.mViewInfoStore.popFromPreLayout(fromOldChangeHolders);
                            this.mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                            ItemAnimator.ItemHolderInfo popFromPostLayout = this.mViewInfoStore.popFromPostLayout(childViewHolderInt);
                            if (popFromPreLayout == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, fromOldChangeHolders);
                            } else {
                                animateChange(fromOldChangeHolders, childViewHolderInt, popFromPreLayout, popFromPostLayout, isDisappearing, isDisappearing2);
                            }
                        }
                    } else {
                        this.mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                    }
                }
            }
            this.mViewInfoStore.process(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State state2 = this.mState;
        state2.mPreviousLayoutItemCount = state2.mItemCount;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        state2.mRunSimpleAnimations = false;
        state2.mRunPredictiveAnimations = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<ViewHolder> arrayList = this.mRecycler.mChangedScrap;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager.mPrefetchMaxObservedInInitialPrefetch) {
            layoutManager.mPrefetchMaxCountObserved = 0;
            layoutManager.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.updateViewCacheSize();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.clear();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void dispatchLayoutStep2() {
        boolean z;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        State state = this.mState;
        state.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        state.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, state);
        State state2 = this.mState;
        state2.mStructureChanged = false;
        this.mPendingSavedState = null;
        if (state2.mRunSimpleAnimations && this.mItemAnimator != null) {
            z = true;
        } else {
            z = false;
        }
        state2.mRunSimpleAnimations = z;
        this.mState.mLayoutStep = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void saveFocusInfo() {
        View view2;
        long j;
        int adapterPosition;
        ViewHolder viewHolder = null;
        if (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) {
            view2 = getFocusedChild();
        } else {
            view2 = null;
        }
        if (view2 != null) {
            viewHolder = findContainingViewHolder(view2);
        }
        if (viewHolder == null) {
            resetFocusInfo();
            return;
        }
        State state = this.mState;
        if (this.mAdapter.hasStableIds()) {
            j = viewHolder.getItemId();
        } else {
            j = -1;
        }
        state.mFocusedItemId = j;
        State state2 = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            adapterPosition = -1;
        } else if (viewHolder.isRemoved()) {
            adapterPosition = viewHolder.mOldPosition;
        } else {
            adapterPosition = viewHolder.getAdapterPosition();
        }
        state2.mFocusedItemPosition = adapterPosition;
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(viewHolder.itemView);
    }

    public void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            State state = this.mState;
            state.mIsMeasuring = false;
            if (state.mLayoutStep == 1) {
                dispatchLayoutStep1();
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else if (!this.mAdapterHelper.hasUpdates() && this.mLayout.getWidth() == getWidth() && this.mLayout.getHeight() == getHeight()) {
                this.mLayout.setExactMeasureSpecsFrom(this);
            } else {
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            }
            dispatchLayoutStep3();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean z = true;
        this.mIsAttached = true;
        this.mFirstLayoutComplete = (!this.mFirstLayoutComplete || isLayoutRequested()) ? false : false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            GapWorker gapWorker = GapWorker.sGapWorker.get();
            this.mGapWorker = gapWorker;
            if (gapWorker == null) {
                this.mGapWorker = new GapWorker();
                Display display = ViewCompat.getDisplay(this);
                float f = 60.0f;
                if (!isInEditMode() && display != null) {
                    float refreshRate = display.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f = refreshRate;
                    }
                }
                GapWorker gapWorker2 = this.mGapWorker;
                gapWorker2.mFrameIntervalNs = 1.0E9f / f;
                GapWorker.sGapWorker.set(gapWorker2);
            }
            this.mGapWorker.add(this);
        }
    }

    @Nullable
    private View findNextViewToFocus() {
        ViewHolder findViewHolderForAdapterPosition;
        int i = this.mState.mFocusedItemPosition;
        if (i == -1) {
            i = 0;
        }
        int itemCount = this.mState.getItemCount();
        for (int i2 = i; i2 < itemCount; i2++) {
            ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(itemCount, i);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    private void releaseGlows() {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (i = viewHolder.mPendingAccessibilityState) != -1) {
                ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
                viewHolder.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
        this.mBottomGlow = createEdgeEffect;
        if (this.mClipToPadding) {
            createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
        this.mLeftGlow = createEdgeEffect;
        if (this.mClipToPadding) {
            createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
        this.mRightGlow = createEdgeEffect;
        if (this.mClipToPadding) {
            createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
        this.mTopGlow = createEdgeEffect;
        if (this.mClipToPadding) {
            createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        stopScroll();
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.onDetach();
        if (ALLOW_THREAD_GAP_WORK && (gapWorker = this.mGapWorker) != null) {
            gapWorker.remove(this);
            this.mGapWorker = null;
        }
    }

    public void repositionShadowingViews() {
        ViewHolder viewHolder;
        int childCount = this.mChildHelper.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mChildHelper.getChildAt(i);
            ViewHolder childViewHolder = getChildViewHolder(childAt);
            if (childViewHolder != null && (viewHolder = childViewHolder.mShadowingHolder) != null) {
                View view2 = viewHolder.itemView;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view2.getLeft() || top != view2.getTop()) {
                    view2.layout(left, top, view2.getWidth() + left, view2.getHeight() + top);
                }
            }
        }
    }

    public static void getDecoratedBoundsWithMarginsInt(View view2, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        Rect rect2 = layoutParams.mDecorInsets;
        rect.set((view2.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view2.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view2.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view2.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + IStringUtil.EXTENSION_SEPARATOR + str;
        }
    }

    public void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        onScrolled(i, i2);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i, i2);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    @Nullable
    public View findChildViewUnder(float f, float f2) {
        for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mChildHelper.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f >= childAt.getLeft() + translationX && f <= childAt.getRight() + translationX && f2 >= childAt.getTop() + translationY && f2 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ViewHolder findViewHolderForPosition(int i, boolean z) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        ViewHolder viewHolder = null;
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z) {
                    if (childViewHolderInt.mPosition != i) {
                        continue;
                    }
                    if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                        viewHolder = childViewHolderInt;
                    } else {
                        return childViewHolderInt;
                    }
                } else {
                    if (childViewHolderInt.getLayoutPosition() != i) {
                        continue;
                    }
                    if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                    }
                }
            }
        }
        return viewHolder;
    }

    public void offsetPositionRecordsForInsert(int i, int i2) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                childViewHolderInt.offsetPosition(i2, false);
                this.mState.mStructureChanged = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForInsert(i, i2);
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        if (i < i2) {
            i5 = -1;
            i4 = i;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i7 = 0; i7 < unfilteredChildCount; i7++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i7));
            if (childViewHolderInt != null && (i6 = childViewHolderInt.mPosition) >= i4 && i6 <= i3) {
                if (i6 == i) {
                    childViewHolderInt.offsetPosition(i2 - i, false);
                } else {
                    childViewHolderInt.offsetPosition(i5, false);
                }
                this.mState.mStructureChanged = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForMove(i, i2);
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view2, boolean z) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view2);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view2.clearAnimation();
        dispatchChildDetached(view2);
        super.removeDetachedView(view2, z);
    }

    private void handleMissingPreInfoForChangeError(long j, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
            if (childViewHolderInt != viewHolder && getChangedHolderKey(childViewHolderInt) == j) {
                Adapter adapter = this.mAdapter;
                if (adapter != null && adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + exceptionLabel());
    }

    public boolean scrollByInternal(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i, i2, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i7 = iArr2[0];
            int i8 = iArr2[1];
            i3 = i8;
            i4 = i7;
            i5 = i - i7;
            i6 = i2 - i8;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i4, i3, i5, i6, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i9 = i5 - iArr4[0];
        int i10 = i6 - iArr4[1];
        if (iArr4[0] == 0 && iArr4[1] == 0) {
            z = false;
        } else {
            z = true;
        }
        int i11 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i11 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.isFromSource(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i9, motionEvent.getY(), i10);
            }
            considerReleasingGlowsOnScroll(i, i2);
        }
        if (i4 != 0 || i3 != 0) {
            dispatchOnScrolled(i4, i3);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (z || i4 != 0 || i3 != 0) {
            return true;
        }
        return false;
    }

    private boolean isPreferredNextFocus(View view2, View view3, int i) {
        int i2;
        int i3;
        if (view3 == null || view3 == this || findContainingItemView(view3) == null) {
            return false;
        }
        if (view2 == null || findContainingItemView(view2) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view2.getWidth(), view2.getHeight());
        this.mTempRect2.set(0, 0, view3.getWidth(), view3.getHeight());
        offsetDescendantRectToMyCoords(view2, this.mTempRect);
        offsetDescendantRectToMyCoords(view3, this.mTempRect2);
        char c = 65535;
        if (this.mLayout.getLayoutDirection() == 1) {
            i2 = -1;
        } else {
            i2 = 1;
        }
        Rect rect = this.mTempRect;
        int i4 = rect.left;
        int i5 = this.mTempRect2.left;
        if ((i4 < i5 || rect.right <= i5) && this.mTempRect.right < this.mTempRect2.right) {
            i3 = 1;
        } else {
            Rect rect2 = this.mTempRect;
            int i6 = rect2.right;
            int i7 = this.mTempRect2.right;
            if ((i6 > i7 || rect2.left >= i7) && this.mTempRect.left > this.mTempRect2.left) {
                i3 = -1;
            } else {
                i3 = 0;
            }
        }
        Rect rect3 = this.mTempRect;
        int i8 = rect3.top;
        int i9 = this.mTempRect2.top;
        if ((i8 < i9 || rect3.bottom <= i9) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            c = 1;
        } else {
            Rect rect4 = this.mTempRect;
            int i10 = rect4.bottom;
            int i11 = this.mTempRect2.bottom;
            if ((i10 <= i11 && rect4.top < i11) || this.mTempRect.top <= this.mTempRect2.top) {
                c = 0;
            }
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i == 130) {
                                if (c <= 0) {
                                    return false;
                                }
                                return true;
                            }
                            throw new IllegalArgumentException("Invalid direction: " + i + exceptionLabel());
                        } else if (i3 <= 0) {
                            return false;
                        } else {
                            return true;
                        }
                    } else if (c >= 0) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (i3 >= 0) {
                    return false;
                } else {
                    return true;
                }
            } else if (c <= 0 && (c != 0 || i3 * i2 < 0)) {
                return false;
            } else {
                return true;
            }
        } else if (c >= 0 && (c != 0 || i3 * i2 > 0)) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pullGlows(float f, float f2, float f3, float f4) {
        boolean z;
        boolean z2 = true;
        if (f2 < 0.0f) {
            ensureLeftGlow();
            EdgeEffectCompat.onPull(this.mLeftGlow, (-f2) / getWidth(), 1.0f - (f3 / getHeight()));
        } else if (f2 > 0.0f) {
            ensureRightGlow();
            EdgeEffectCompat.onPull(this.mRightGlow, f2 / getWidth(), f3 / getHeight());
        } else {
            z = false;
            if (f4 >= 0.0f) {
                ensureTopGlow();
                EdgeEffectCompat.onPull(this.mTopGlow, (-f4) / getHeight(), f / getWidth());
            } else if (f4 > 0.0f) {
                ensureBottomGlow();
                EdgeEffectCompat.onPull(this.mBottomGlow, f4 / getHeight(), 1.0f - (f / getWidth()));
            } else {
                z2 = z;
            }
            if (!z2 || f2 != 0.0f || f4 != 0.0f) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            return;
        }
        z = true;
        if (f4 >= 0.0f) {
        }
        if (!z2) {
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private void recoverFocusFromState() {
        ViewHolder viewHolder;
        View findViewById;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (IGNORE_DETACHED_FOCUSED_CHILD && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                        if (this.mChildHelper.getChildCount() == 0) {
                            requestFocus();
                            return;
                        }
                    } else if (!this.mChildHelper.isHidden(focusedChild)) {
                        return;
                    }
                }
                View view2 = null;
                if (this.mState.mFocusedItemId != -1 && this.mAdapter.hasStableIds()) {
                    viewHolder = findViewHolderForItemId(this.mState.mFocusedItemId);
                } else {
                    viewHolder = null;
                }
                if (viewHolder != null && !this.mChildHelper.isHidden(viewHolder.itemView) && viewHolder.itemView.hasFocusable()) {
                    view2 = viewHolder.itemView;
                } else if (this.mChildHelper.getChildCount() > 0) {
                    view2 = findNextViewToFocus();
                }
                if (view2 != null) {
                    int i = this.mState.mFocusedSubChildId;
                    if (i != -1 && (findViewById = view2.findViewById(i)) != null && findViewById.isFocusable()) {
                        view2 = findViewById;
                    }
                    view2.requestFocus();
                }
            }
        }
    }

    private void requestChildOnScreen(@NonNull View view2, @Nullable View view3) {
        View view4;
        boolean z;
        if (view3 != null) {
            view4 = view3;
        } else {
            view4 = view2;
        }
        this.mTempRect.set(0, 0, view4.getWidth(), view4.getHeight());
        ViewGroup.LayoutParams layoutParams = view4.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.mInsetsDirty) {
                Rect rect = layoutParams2.mDecorInsets;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view3 != null) {
            offsetDescendantRectToMyCoords(view3, this.mTempRect);
            offsetRectIntoDescendantCoords(view2, this.mTempRect);
        }
        LayoutManager layoutManager = this.mLayout;
        Rect rect3 = this.mTempRect;
        boolean z2 = !this.mFirstLayoutComplete;
        if (view3 == null) {
            z = true;
        } else {
            z = false;
        }
        layoutManager.requestChildRectangleOnScreen(this, view2, rect3, z2, z);
    }

    public void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i);
            }
        } else if (i > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i);
            }
        }
        if (i2 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i2);
            }
        }
        if (i != 0 || i2 != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void setAdapterInternal(@Nullable Adapter adapter, boolean z, boolean z2) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.reset();
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.mAdapter);
        }
        this.mRecycler.onAdapterChanged(adapter3, this.mAdapter, z);
        this.mState.mStructureChanged = true;
    }

    public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i4 = 0; i4 < unfilteredChildCount; i4++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i5 = childViewHolderInt.mPosition;
                if (i5 >= i3) {
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.mStructureChanged = true;
                } else if (i5 >= i) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.mState.mStructureChanged = true;
                }
            }
        }
        this.mRecycler.offsetPositionRecordsForRemove(i, i2, z);
        requestLayout();
    }

    public void scrollStep(int i, int i2, @Nullable int[] iArr) {
        int i3;
        int i4;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (i != 0) {
            i3 = this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState);
        } else {
            i3 = 0;
        }
        if (i2 != 0) {
            i4 = this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState);
        } else {
            i4 = 0;
        }
        TraceCompat.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = i3;
            iArr[1] = i4;
        }
    }

    public void viewRangeUpdate(int i, int i2, Object obj) {
        int i3;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        int i4 = i + i2;
        for (int i5 = 0; i5 < unfilteredChildCount; i5++) {
            View unfilteredChildAt = this.mChildHelper.getUnfilteredChildAt(i5);
            ViewHolder childViewHolderInt = getChildViewHolderInt(unfilteredChildAt);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i3 = childViewHolderInt.mPosition) >= i && i3 < i4) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) unfilteredChildAt.getLayoutParams()).mInsetsDirty = true;
            }
        }
        this.mRecycler.viewRangeUpdate(i, i2);
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    public void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null && !edgeEffect.isFinished() && i > 0) {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean fling(int i, int i2) {
        boolean z;
        LayoutManager layoutManager = this.mLayout;
        int i3 = 0;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.mLayoutSuppressed) {
            return false;
        } else {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            i = (!canScrollHorizontally || Math.abs(i) < this.mMinFlingVelocity) ? 0 : 0;
            i2 = (!canScrollVertically || Math.abs(i2) < this.mMinFlingVelocity) ? 0 : 0;
            if (i == 0 && i2 == 0) {
                return false;
            }
            float f = i;
            float f2 = i2;
            if (!dispatchNestedPreFling(f, f2)) {
                if (!canScrollHorizontally && !canScrollVertically) {
                    z = false;
                } else {
                    z = true;
                }
                dispatchNestedFling(f, f2, z);
                OnFlingListener onFlingListener = this.mOnFlingListener;
                if (onFlingListener != null && onFlingListener.onFling(i, i2)) {
                    return true;
                }
                if (z) {
                    if (canScrollHorizontally) {
                        i3 = 1;
                    }
                    if (canScrollVertically) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3, 1);
                    int i4 = this.mMaxFlingVelocity;
                    int max = Math.max(-i4, Math.min(i, i4));
                    int i5 = this.mMaxFlingVelocity;
                    this.mViewFlinger.fling(max, Math.max(-i5, Math.min(i2, i5)));
                    return true;
                }
            }
            return false;
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, @NonNull int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr, i5, iArr2);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        int i2;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z4 = false;
        for (int i3 = 0; i3 < size; i3++) {
            this.mItemDecorations.get(i3).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z5 = true;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int save = canvas.save();
            if (this.mClipToPadding) {
                i2 = getPaddingBottom();
            } else {
                i2 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + i2, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            if (edgeEffect2 != null && edgeEffect2.draw(canvas)) {
                z = true;
            } else {
                z = false;
            }
            canvas.restoreToCount(save);
        } else {
            z = false;
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            if (edgeEffect4 != null && edgeEffect4.draw(canvas)) {
                z3 = true;
            } else {
                z3 = false;
            }
            z |= z3;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.mClipToPadding) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate(-i, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            if (edgeEffect6 != null && edgeEffect6.draw(canvas)) {
                z2 = true;
            } else {
                z2 = false;
            }
            z |= z2;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z |= z4;
            canvas.restoreToCount(save4);
        }
        if (z || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) {
            z5 = z;
        }
        if (z5) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view2, int i) {
        boolean z;
        View view3;
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        int i3;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view2, i);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z5 = true;
        if (this.mAdapter != null && this.mLayout != null && !isComputingLayout() && !this.mLayoutSuppressed) {
            z = true;
        } else {
            z = false;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z && (i == 2 || i == 1)) {
            if (this.mLayout.canScrollVertically()) {
                if (i == 2) {
                    i3 = 130;
                } else {
                    i3 = 33;
                }
                if (focusFinder.findNextFocus(this, view2, i3) == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.mLayout.canScrollHorizontally()) {
                if (this.mLayout.getLayoutDirection() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (i == 2) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z3 ^ z4) {
                    i2 = 66;
                } else {
                    i2 = 17;
                }
                if (focusFinder.findNextFocus(this, view2, i2) != null) {
                    z5 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i2;
                }
                z2 = z5;
            }
            if (z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view2) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view2, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view3 = focusFinder.findNextFocus(this, view2, i);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view2, i);
            if (findNextFocus == null && z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view2) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view3 = this.mLayout.onFocusSearchFailed(view2, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                view3 = findNextFocus;
            }
        }
        if (view3 != null && !view3.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view2, i);
            }
            requestChildOnScreen(view3, null);
            return view2;
        } else if (!isPreferredNextFocus(view2, view3, i)) {
            return super.focusSearch(view2, i);
        } else {
            return view3;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        boolean z = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (!z && this.mAdapter != null) {
                if (this.mState.mLayoutStep == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(i, i2);
                this.mState.mIsMeasuring = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.mIsMeasuring = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                }
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                State state = this.mState;
                if (state.mRunPredictiveAnimations) {
                    state.mInPreLayout = true;
                } else {
                    this.mAdapterHelper.consumeUpdatesInOnePass();
                    this.mState.mInPreLayout = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.mRunPredictiveAnimations) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.mAdapter;
            if (adapter != null) {
                this.mState.mItemCount = adapter.getItemCount();
            } else {
                this.mState.mItemCount = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            stopInterceptRequestLayout(false);
            this.mState.mInPreLayout = false;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public Rect getItemDecorInsetsForChild(View view2) {
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if (!layoutParams.mInsetsDirty) {
            return layoutParams.mDecorInsets;
        }
        if (this.mState.isPreLayout() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
            return layoutParams.mDecorInsets;
        }
        Rect rect = layoutParams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i).getItemOffsets(this.mTempRect, view2, this, this.mState);
            int i2 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.mInsetsDirty = false;
        return rect;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                if (this.mLayout.canScrollVertically()) {
                    f = -motionEvent.getAxisValue(9);
                } else {
                    f = 0.0f;
                }
                if (this.mLayout.canScrollHorizontally()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (f == 0.0f || f2 != 0.0f) {
                        scrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f2 = 0.0f;
                if (f == 0.0f) {
                }
                scrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f * this.mScaledVerticalScrollFactor), motionEvent);
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.mLayout.canScrollVertically()) {
                        f = -axisValue;
                        f2 = 0.0f;
                        if (f == 0.0f) {
                        }
                        scrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f * this.mScaledVerticalScrollFactor), motionEvent);
                    } else if (this.mLayout.canScrollHorizontally()) {
                        f2 = axisValue;
                        f = 0.0f;
                        if (f == 0.0f) {
                        }
                        scrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f = 0.0f;
                f2 = 0.0f;
                if (f == 0.0f) {
                }
                scrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f * this.mScaledVerticalScrollFactor), motionEvent);
            }
        }
        return false;
    }

    public void setLayoutManager(@Nullable LayoutManager layoutManager) {
        if (layoutManager == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            ItemAnimator itemAnimator = this.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.endAnimations();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.clear();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            this.mRecycler.clear();
        }
        this.mChildHelper.removeAllViewsUnfiltered();
        this.mLayout = layoutManager;
        if (layoutManager != null) {
            if (layoutManager.mRecyclerView == null) {
                layoutManager.setRecyclerView(this);
                if (this.mIsAttached) {
                    this.mLayout.dispatchAttachedToWindow(this);
                }
            } else {
                throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.mRecyclerView.exceptionLabel());
            }
        }
        this.mRecycler.updateViewCacheSize();
        requestLayout();
    }

    @VisibleForTesting
    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070328), resources.getDimensionPixelSize(com.baidu.tieba.R.dimen.obfuscated_res_0x7f07032a), resources.getDimensionPixelOffset(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070329));
            return;
        }
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i;
        boolean z;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                onPointerUp(motionEvent);
                            }
                        } else {
                            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                            int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
                            this.mLastTouchX = x;
                            this.mInitialTouchX = x;
                            int y = (int) (motionEvent.getY(actionIndex) + 0.5f);
                            this.mLastTouchY = y;
                            this.mInitialTouchY = y;
                        }
                    } else {
                        cancelScroll();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (findPointerIndex < 0) {
                        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    if (this.mScrollState != 1) {
                        int i2 = x2 - this.mInitialTouchX;
                        int i3 = y2 - this.mInitialTouchY;
                        if (canScrollHorizontally && Math.abs(i2) > this.mTouchSlop) {
                            this.mLastTouchX = x2;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (canScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                            this.mLastTouchY = y2;
                            z = true;
                        }
                        if (z) {
                            setScrollState(1);
                        }
                    }
                }
            } else {
                this.mVelocityTracker.clear();
                stopNestedScroll(0);
            }
        } else {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x3 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            if (canScrollHorizontally) {
                i = 1;
            } else {
                i = 0;
            }
            if (canScrollVertically) {
                i |= 2;
            }
            startNestedScroll(i, 0);
        }
        if (this.mScrollState != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        float f;
        float f2;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        boolean z2 = false;
        if (this.mLayoutSuppressed || this.mIgnoreMotionEventTillDown) {
            return false;
        }
        if (dispatchToOnItemTouchListeners(motionEvent)) {
            cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.mNestedOffsets;
        obtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                onPointerUp(motionEvent);
                            }
                        } else {
                            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                            int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
                            this.mLastTouchX = x;
                            this.mInitialTouchX = x;
                            int y = (int) (motionEvent.getY(actionIndex) + 0.5f);
                            this.mLastTouchY = y;
                            this.mInitialTouchY = y;
                        }
                    } else {
                        cancelScroll();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (findPointerIndex < 0) {
                        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    int i6 = this.mLastTouchX - x2;
                    int i7 = this.mLastTouchY - y2;
                    if (this.mScrollState != 1) {
                        if (canScrollHorizontally) {
                            if (i6 > 0) {
                                i6 = Math.max(0, i6 - this.mTouchSlop);
                            } else {
                                i6 = Math.min(0, i6 + this.mTouchSlop);
                            }
                            if (i6 != 0) {
                                z = true;
                                if (canScrollVertically) {
                                    if (i7 > 0) {
                                        i7 = Math.max(0, i7 - this.mTouchSlop);
                                    } else {
                                        i7 = Math.min(0, i7 + this.mTouchSlop);
                                    }
                                    if (i7 != 0) {
                                        z = true;
                                    }
                                }
                                if (z) {
                                    setScrollState(1);
                                }
                            }
                        }
                        z = false;
                        if (canScrollVertically) {
                        }
                        if (z) {
                        }
                    }
                    int i8 = i6;
                    int i9 = i7;
                    if (this.mScrollState == 1) {
                        int[] iArr3 = this.mReusableIntPair;
                        iArr3[0] = 0;
                        iArr3[1] = 0;
                        if (canScrollHorizontally) {
                            i2 = i8;
                        } else {
                            i2 = 0;
                        }
                        if (canScrollVertically) {
                            i3 = i9;
                        } else {
                            i3 = 0;
                        }
                        if (dispatchNestedPreScroll(i2, i3, this.mReusableIntPair, this.mScrollOffset, 0)) {
                            int[] iArr4 = this.mReusableIntPair;
                            i8 -= iArr4[0];
                            i9 -= iArr4[1];
                            int[] iArr5 = this.mNestedOffsets;
                            int i10 = iArr5[0];
                            int[] iArr6 = this.mScrollOffset;
                            iArr5[0] = i10 + iArr6[0];
                            iArr5[1] = iArr5[1] + iArr6[1];
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        int i11 = i9;
                        int[] iArr7 = this.mScrollOffset;
                        this.mLastTouchX = x2 - iArr7[0];
                        this.mLastTouchY = y2 - iArr7[1];
                        if (canScrollHorizontally) {
                            i4 = i8;
                        } else {
                            i4 = 0;
                        }
                        if (canScrollVertically) {
                            i5 = i11;
                        } else {
                            i5 = 0;
                        }
                        if (scrollByInternal(i4, i5, motionEvent)) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        if (this.mGapWorker != null && (i8 != 0 || i11 != 0)) {
                            this.mGapWorker.postFromTraversal(this, i8, i11);
                        }
                    }
                }
            } else {
                this.mVelocityTracker.addMovement(obtain);
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
                if (canScrollHorizontally) {
                    f = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
                } else {
                    f = 0.0f;
                }
                if (canScrollVertically) {
                    f2 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
                } else {
                    f2 = 0.0f;
                }
                if ((f == 0.0f && f2 == 0.0f) || !fling((int) f, (int) f2)) {
                    setScrollState(0);
                }
                resetScroll();
                z2 = true;
            }
        } else {
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x3 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
            if (canScrollHorizontally) {
                i = 1;
            } else {
                i = 0;
            }
            if (canScrollVertically) {
                i |= 2;
            }
            startNestedScroll(i, 0);
        }
        if (!z2) {
            this.mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void smoothScrollBy(@Px int i, @Px int i2, @Nullable Interpolator interpolator, int i3, boolean z) {
        boolean z2;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.mLayoutSuppressed) {
        } else {
            int i4 = 0;
            if (!layoutManager.canScrollHorizontally()) {
                i = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i2 = 0;
            }
            if (i != 0 || i2 != 0) {
                if (i3 != Integer.MIN_VALUE && i3 <= 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    if (z) {
                        if (i != 0) {
                            i4 = 1;
                        }
                        if (i2 != 0) {
                            i4 |= 2;
                        }
                        startNestedScroll(i4, 1);
                    }
                    this.mViewFlinger.smoothScrollBy(i, i2, i3, interpolator);
                    return;
                }
                scrollBy(i, i2);
            }
        }
    }
}
