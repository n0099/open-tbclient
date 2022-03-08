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
import androidx.core.view.InputDeviceCompat;
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
import androidx.recyclerview.R$attr;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static final int[] NESTED_SCROLLING_ATTRS;
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
    public transient /* synthetic */ FieldHolder $fh;
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
    public static abstract class Adapter<VH extends ViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mHasStableIds;
        public final AdapterDataObservable mObservable;

        public Adapter() {
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
            this.mObservable = new AdapterDataObservable();
            this.mHasStableIds = false;
        }

        public final void bindViewHolder(@NonNull VH vh, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, vh, i2) == null) {
                vh.mPosition = i2;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(i2);
                }
                vh.setFlags(1, 519);
                TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
                onBindViewHolder(vh, i2, vh.getUnmodifiedPayloads());
                vh.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).mInsetsDirty = true;
                }
                TraceCompat.endSection();
            }
        }

        @NonNull
        public final VH createViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
                try {
                    TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);
                    VH onCreateViewHolder = onCreateViewHolder(viewGroup, i2);
                    if (onCreateViewHolder.itemView.getParent() == null) {
                        onCreateViewHolder.mItemViewType = i2;
                        return onCreateViewHolder;
                    }
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                } finally {
                    TraceCompat.endSection();
                }
            }
            return (VH) invokeLI.objValue;
        }

        public abstract int getItemCount();

        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                return -1L;
            }
            return invokeI.longValue;
        }

        public int getItemViewType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                return 0;
            }
            return invokeI.intValue;
        }

        public final boolean hasObservers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mObservable.hasObservers() : invokeV.booleanValue;
        }

        public final boolean hasStableIds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mHasStableIds : invokeV.booleanValue;
        }

        public final void notifyDataSetChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.mObservable.notifyChanged();
            }
        }

        public final void notifyItemChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                this.mObservable.notifyItemRangeChanged(i2, 1);
            }
        }

        public final void notifyItemInserted(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
                this.mObservable.notifyItemRangeInserted(i2, 1);
            }
        }

        public final void notifyItemMoved(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
                this.mObservable.notifyItemMoved(i2, i3);
            }
        }

        public final void notifyItemRangeChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
                this.mObservable.notifyItemRangeChanged(i2, i3);
            }
        }

        public final void notifyItemRangeInserted(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
                this.mObservable.notifyItemRangeInserted(i2, i3);
            }
        }

        public final void notifyItemRangeRemoved(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
                this.mObservable.notifyItemRangeRemoved(i2, i3);
            }
        }

        public final void notifyItemRemoved(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
                this.mObservable.notifyItemRangeRemoved(i2, 1);
            }
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, recyclerView) == null) {
            }
        }

        public abstract void onBindViewHolder(@NonNull VH vh, int i2);

        public void onBindViewHolder(@NonNull VH vh, int i2, @NonNull List<Object> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048595, this, vh, i2, list) == null) {
                onBindViewHolder(vh, i2);
            }
        }

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2);

        public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, recyclerView) == null) {
            }
        }

        public boolean onFailedToRecycleView(@NonNull VH vh) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, vh)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public void onViewAttachedToWindow(@NonNull VH vh) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, vh) == null) {
            }
        }

        public void onViewDetachedFromWindow(@NonNull VH vh) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, vh) == null) {
            }
        }

        public void onViewRecycled(@NonNull VH vh) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, vh) == null) {
            }
        }

        public void registerAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, adapterDataObserver) == null) {
                this.mObservable.registerObserver(adapterDataObserver);
            }
        }

        public void setHasStableIds(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
                if (!hasObservers()) {
                    this.mHasStableIds = z;
                    return;
                }
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
        }

        public void unregisterAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, adapterDataObserver) == null) {
                this.mObservable.unregisterObserver(adapterDataObserver);
            }
        }

        public final void notifyItemChanged(int i2, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048585, this, i2, obj) == null) {
                this.mObservable.notifyItemRangeChanged(i2, 1, obj);
            }
        }

        public final void notifyItemRangeChanged(int i2, int i3, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, obj) == null) {
                this.mObservable.notifyItemRangeChanged(i2, i3, obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AdapterDataObservable() {
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

        public boolean hasObservers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !((Observable) this).mObservers.isEmpty() : invokeV.booleanValue;
        }

        public void notifyChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                    ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onChanged();
                }
            }
        }

        public void notifyItemMoved(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                    ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i2, i3, 1);
                }
            }
        }

        public void notifyItemRangeChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
                notifyItemRangeChanged(i2, i3, null);
            }
        }

        public void notifyItemRangeInserted(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
                for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                    ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i2, i3);
                }
            }
        }

        public void notifyItemRangeRemoved(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
                for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                    ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i2, i3);
                }
            }
        }

        public void notifyItemRangeChanged(int i2, int i3, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, obj) == null) {
                for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                    ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i2, i3, obj);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AdapterDataObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AdapterDataObserver() {
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

        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public void onItemRangeChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            }
        }

        public void onItemRangeChanged(int i2, int i3, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj) == null) {
                onItemRangeChanged(i2, i3);
            }
        }

        public void onItemRangeInserted(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }

        public void onItemRangeMoved(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048580, this, i2, i3, i4) == null) {
            }
        }

        public void onItemRangeRemoved(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i2, int i3);
    }

    /* loaded from: classes.dex */
    public static class EdgeEffectFactory {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;
        public transient /* synthetic */ FieldHolder $fh;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface EdgeDirection {
        }

        public EdgeEffectFactory() {
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

        @NonNull
        public EdgeEffect createEdgeEffect(@NonNull RecyclerView recyclerView, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, recyclerView, i2)) == null) ? new EdgeEffect(recyclerView.getContext()) : (EdgeEffect) invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemAnimator {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        public transient /* synthetic */ FieldHolder $fh;
        public long mAddDuration;
        public long mChangeDuration;
        public ArrayList<ItemAnimatorFinishedListener> mFinishedListeners;
        public ItemAnimatorListener mListener;
        public long mMoveDuration;
        public long mRemoveDuration;

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

        /* loaded from: classes.dex */
        public static class ItemHolderInfo {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            public ItemHolderInfo() {
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

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewHolder)) == null) ? setFrom(viewHolder, 0) : (ItemHolderInfo) invokeL.objValue;
            }

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder, i2)) == null) {
                    View view = viewHolder.itemView;
                    this.left = view.getLeft();
                    this.top = view.getTop();
                    this.right = view.getRight();
                    this.bottom = view.getBottom();
                    return this;
                }
                return (ItemHolderInfo) invokeLI.objValue;
            }
        }

        public ItemAnimator() {
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
            this.mListener = null;
            this.mFinishedListeners = new ArrayList<>();
            this.mAddDuration = 120L;
            this.mRemoveDuration = 120L;
            this.mMoveDuration = 250L;
            this.mChangeDuration = 250L;
        }

        public static int buildAdapterChangeFlagsForAnimations(ViewHolder viewHolder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, viewHolder)) == null) {
                int i2 = viewHolder.mFlags & 14;
                if (viewHolder.isInvalid()) {
                    return 4;
                }
                if ((i2 & 4) == 0) {
                    int oldPosition = viewHolder.getOldPosition();
                    int adapterPosition = viewHolder.getAdapterPosition();
                    return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i2 : i2 | 2048;
                }
                return i2;
            }
            return invokeL.intValue;
        }

        public abstract boolean animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @Nullable ItemHolderInfo itemHolderInfo2);

        public abstract boolean animatePersistence(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewHolder)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder, @NonNull List<Object> list) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, viewHolder, list)) == null) ? canReuseUpdatedViewHolder(viewHolder) : invokeLL.booleanValue;
        }

        public final void dispatchAnimationFinished(@NonNull ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, viewHolder) == null) {
                onAnimationFinished(viewHolder);
                ItemAnimatorListener itemAnimatorListener = this.mListener;
                if (itemAnimatorListener != null) {
                    itemAnimatorListener.onAnimationFinished(viewHolder);
                }
            }
        }

        public final void dispatchAnimationStarted(@NonNull ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, viewHolder) == null) {
                onAnimationStarted(viewHolder);
            }
        }

        public final void dispatchAnimationsFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                int size = this.mFinishedListeners.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.mFinishedListeners.get(i2).onAnimationsFinished();
                }
                this.mFinishedListeners.clear();
            }
        }

        public abstract void endAnimation(@NonNull ViewHolder viewHolder);

        public abstract void endAnimations();

        public long getAddDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mAddDuration : invokeV.longValue;
        }

        public long getChangeDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mChangeDuration : invokeV.longValue;
        }

        public long getMoveDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mMoveDuration : invokeV.longValue;
        }

        public long getRemoveDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mRemoveDuration : invokeV.longValue;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(@Nullable ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, itemAnimatorFinishedListener)) == null) {
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
            return invokeL.booleanValue;
        }

        @NonNull
        public ItemHolderInfo obtainHolderInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new ItemHolderInfo() : (ItemHolderInfo) invokeV.objValue;
        }

        public void onAnimationFinished(@NonNull ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, viewHolder) == null) {
            }
        }

        public void onAnimationStarted(@NonNull ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, viewHolder) == null) {
            }
        }

        @NonNull
        public ItemHolderInfo recordPostLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, state, viewHolder)) == null) ? obtainHolderInfo().setFrom(viewHolder) : (ItemHolderInfo) invokeLL.objValue;
        }

        @NonNull
        public ItemHolderInfo recordPreLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder, int i2, @NonNull List<Object> list) {
            InterceptResult invokeLLIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048597, this, state, viewHolder, i2, list)) == null) ? obtainHolderInfo().setFrom(viewHolder) : (ItemHolderInfo) invokeLLIL.objValue;
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048599, this, j2) == null) {
                this.mAddDuration = j2;
            }
        }

        public void setChangeDuration(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048600, this, j2) == null) {
                this.mChangeDuration = j2;
            }
        }

        public void setListener(ItemAnimatorListener itemAnimatorListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, itemAnimatorListener) == null) {
                this.mListener = itemAnimatorListener;
            }
        }

        public void setMoveDuration(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048602, this, j2) == null) {
                this.mMoveDuration = j2;
            }
        }

        public void setRemoveDuration(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048603, this, j2) == null) {
                this.mRemoveDuration = j2;
            }
        }
    }

    /* loaded from: classes.dex */
    public class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecyclerView this$0;

        public ItemAnimatorRestoreListener(RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void onAnimationFinished(ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                viewHolder.setIsRecyclable(true);
                if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                    viewHolder.mShadowedHolder = null;
                }
                viewHolder.mShadowingHolder = null;
                if (viewHolder.shouldBeKeptAsChild() || this.this$0.removeAnimatingView(viewHolder.itemView) || !viewHolder.isTmpDetached()) {
                    return;
                }
                this.this$0.removeDetachedView(viewHolder.itemView, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ItemDecoration() {
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

        @Deprecated
        public void getItemOffsets(@NonNull Rect rect, int i2, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rect, i2, recyclerView) == null) {
                rect.set(0, 0, 0, 0);
            }
        }

        @Deprecated
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, canvas, recyclerView) == null) {
            }
        }

        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, canvas, recyclerView, state) == null) {
                onDraw(canvas, recyclerView);
            }
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, canvas, recyclerView) == null) {
            }
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, canvas, recyclerView, state) == null) {
                onDrawOver(canvas, recyclerView);
            }
        }

        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect, view, recyclerView, state) == null) {
                getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class LayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mAutoMeasure;
        public ChildHelper mChildHelper;
        public int mHeight;
        public int mHeightMode;
        public ViewBoundsCheck mHorizontalBoundCheck;
        public final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback;
        public boolean mIsAttachedToWindow;
        public boolean mItemPrefetchEnabled;
        public boolean mMeasurementCacheEnabled;
        public int mPrefetchMaxCountObserved;
        public boolean mPrefetchMaxObservedInInitialPrefetch;
        public RecyclerView mRecyclerView;
        public boolean mRequestedSimpleAnimations;
        @Nullable
        public SmoothScroller mSmoothScroller;
        public ViewBoundsCheck mVerticalBoundCheck;
        public final ViewBoundsCheck.Callback mVerticalBoundCheckCallback;
        public int mWidth;
        public int mWidthMode;

        /* loaded from: classes.dex */
        public interface LayoutPrefetchRegistry {
            void addPosition(int i2, int i3);
        }

        /* loaded from: classes.dex */
        public static class Properties {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;

            public Properties() {
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
        }

        public LayoutManager() {
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
            this.mHorizontalBoundCheckCallback = new ViewBoundsCheck.Callback(this) { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LayoutManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public View getChildAt(int i4) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i4)) == null) ? this.this$0.getChildAt(i4) : (View) invokeI.objValue;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getChildEnd(View view) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) ? this.this$0.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin : invokeL.intValue;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getChildStart(View view) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? this.this$0.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin : invokeL.intValue;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getParentEnd() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.this$0.getWidth() - this.this$0.getPaddingRight() : invokeV.intValue;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getParentStart() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) ? this.this$0.getPaddingLeft() : invokeV.intValue;
                }
            };
            this.mVerticalBoundCheckCallback = new ViewBoundsCheck.Callback(this) { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LayoutManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public View getChildAt(int i4) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i4)) == null) ? this.this$0.getChildAt(i4) : (View) invokeI.objValue;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getChildEnd(View view) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) ? this.this$0.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin : invokeL.intValue;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getChildStart(View view) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? this.this$0.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin : invokeL.intValue;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getParentEnd() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.this$0.getHeight() - this.this$0.getPaddingBottom() : invokeV.intValue;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getParentStart() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) ? this.this$0.getPaddingTop() : invokeV.intValue;
                }
            };
            this.mHorizontalBoundCheck = new ViewBoundsCheck(this.mHorizontalBoundCheckCallback);
            this.mVerticalBoundCheck = new ViewBoundsCheck(this.mVerticalBoundCheckCallback);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        private void addViewInt(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!z && !childViewHolderInt.isRemoved()) {
                    this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
                } else {
                    this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
                }
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (!childViewHolderInt.wasReturnedFromScrap() && !childViewHolderInt.isScrap()) {
                    if (view.getParent() == this.mRecyclerView) {
                        int indexOfChild = this.mChildHelper.indexOfChild(view);
                        if (i2 == -1) {
                            i2 = this.mChildHelper.getChildCount();
                        }
                        if (indexOfChild == -1) {
                            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                        } else if (indexOfChild != i2) {
                            this.mRecyclerView.mLayout.moveView(indexOfChild, i2);
                        }
                    } else {
                        this.mChildHelper.addView(view, i2, false);
                        layoutParams.mInsetsDirty = true;
                        SmoothScroller smoothScroller = this.mSmoothScroller;
                        if (smoothScroller != null && smoothScroller.isRunning()) {
                            this.mSmoothScroller.onChildAttachedToWindow(view);
                        }
                    }
                } else {
                    if (childViewHolderInt.isScrap()) {
                        childViewHolderInt.unScrap();
                    } else {
                        childViewHolderInt.clearReturnedFromScrapFlag();
                    }
                    this.mChildHelper.attachViewToParent(view, i2, view.getLayoutParams(), false);
                }
                if (layoutParams.mPendingInvalidate) {
                    childViewHolderInt.itemView.invalidate();
                    layoutParams.mPendingInvalidate = false;
                }
            }
        }

        public static int chooseSize(int i2, int i3, int i4) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i2, i3, i4)) == null) {
                int mode = View.MeasureSpec.getMode(i2);
                int size = View.MeasureSpec.getSize(i2);
                if (mode != Integer.MIN_VALUE) {
                    return mode != 1073741824 ? Math.max(i3, i4) : size;
                }
                return Math.min(size, Math.max(i3, i4));
            }
            return invokeIII.intValue;
        }

        private void detachViewInternal(int i2, @NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(65539, this, i2, view) == null) {
                this.mChildHelper.detachViewFromParent(i2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
            if (r6 >= 0) goto L10;
         */
        @Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int getChildMeasureSpec(int i2, int i3, int i4, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) {
                int i5 = i2 - i3;
                int i6 = 0;
                int max = Math.max(0, i5);
                if (!z) {
                    if (i4 < 0) {
                        if (i4 == -1) {
                            i6 = 1073741824;
                        } else {
                            i6 = i4 == -2 ? Integer.MIN_VALUE : Integer.MIN_VALUE;
                            i4 = 0;
                        }
                        i4 = max;
                    }
                    i6 = 1073741824;
                }
                return View.MeasureSpec.makeMeasureSpec(i4, i6);
            }
            return invokeCommon.intValue;
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, view, rect)) == null) {
                int[] iArr = new int[2];
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                int width = getWidth() - getPaddingRight();
                int height = getHeight() - getPaddingBottom();
                int left = (view.getLeft() + rect.left) - view.getScrollX();
                int top = (view.getTop() + rect.top) - view.getScrollY();
                int width2 = rect.width() + left;
                int height2 = rect.height() + top;
                int i2 = left - paddingLeft;
                int min = Math.min(0, i2);
                int i3 = top - paddingTop;
                int min2 = Math.min(0, i3);
                int i4 = width2 - width;
                int max = Math.max(0, i4);
                int max2 = Math.max(0, height2 - height);
                if (getLayoutDirection() != 1) {
                    if (min == 0) {
                        min = Math.min(i2, max);
                    }
                    max = min;
                } else if (max == 0) {
                    max = Math.max(min, i4);
                }
                if (min2 == 0) {
                    min2 = Math.min(i3, max2);
                }
                iArr[0] = max;
                iArr[1] = min2;
                return iArr;
            }
            return (int[]) invokeLL.objValue;
        }

        public static Properties getProperties(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
            InterceptResult invokeLLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65543, null, context, attributeSet, i2, i3)) == null) {
                Properties properties = new Properties();
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i2, i3);
                properties.orientation = obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 1);
                properties.spanCount = obtainStyledAttributes.getInt(R$styleable.RecyclerView_spanCount, 1);
                properties.reverseLayout = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_reverseLayout, false);
                properties.stackFromEnd = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_stackFromEnd, false);
                obtainStyledAttributes.recycle();
                return properties;
            }
            return (Properties) invokeLLII.objValue;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, this, recyclerView, i2, i3)) == null) {
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
                return rect.left - i2 < width && rect.right - i2 > paddingLeft && rect.top - i3 < height && rect.bottom - i3 > paddingTop;
            }
            return invokeLII.booleanValue;
        }

        public static boolean isMeasurementUpToDate(int i2, int i3, int i4) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIII = interceptable.invokeIII(65545, null, i2, i3, i4)) == null) {
                int mode = View.MeasureSpec.getMode(i3);
                int size = View.MeasureSpec.getSize(i3);
                if (i4 <= 0 || i2 == i4) {
                    if (mode == Integer.MIN_VALUE) {
                        return size >= i2;
                    } else if (mode != 0) {
                        return mode == 1073741824 && size == i2;
                    } else {
                        return true;
                    }
                }
                return false;
            }
            return invokeIII.booleanValue;
        }

        private void scrapOrRecycleView(Recycler recycler, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(65546, this, recycler, i2, view) == null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt.shouldIgnore()) {
                    return;
                }
                if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                    removeViewAt(i2);
                    recycler.recycleViewHolderInternal(childViewHolderInt);
                    return;
                }
                detachViewAt(i2);
                recycler.scrapView(view);
                this.mRecyclerView.mViewInfoStore.onViewDetached(childViewHolderInt);
            }
        }

        public void addDisappearingView(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                addDisappearingView(view, -1);
            }
        }

        public void addView(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                addView(view, -1);
            }
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (recyclerView = this.mRecyclerView) == null) {
                return;
            }
            recyclerView.assertInLayoutOrScroll(str);
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (recyclerView = this.mRecyclerView) == null) {
                return;
            }
            recyclerView.assertNotInLayoutOrScroll(str);
        }

        public void attachView(@NonNull View view, int i2, LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2, layoutParams) == null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt.isRemoved()) {
                    this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
                } else {
                    this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
                }
                this.mChildHelper.attachViewToParent(view, i2, layoutParams, childViewHolderInt.isRemoved());
            }
        }

        public void calculateItemDecorationsForChild(@NonNull View view, @NonNull Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, view, rect) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView == null) {
                    rect.set(0, 0, 0, 0);
                } else {
                    rect.set(recyclerView.getItemDecorInsetsForChild(view));
                }
            }
        }

        public boolean canScrollHorizontally() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean canScrollVertically() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, layoutParams)) == null) ? layoutParams != null : invokeL.booleanValue;
        }

        public void collectAdjacentPrefetchPositions(int i2, int i3, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), state, layoutPrefetchRegistry}) == null) {
            }
        }

        public void collectInitialPrefetchPositions(int i2, LayoutPrefetchRegistry layoutPrefetchRegistry) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048590, this, i2, layoutPrefetchRegistry) == null) {
            }
        }

        public int computeHorizontalScrollExtent(@NonNull State state) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, state)) == null) {
                return 0;
            }
            return invokeL.intValue;
        }

        public int computeHorizontalScrollOffset(@NonNull State state) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, state)) == null) {
                return 0;
            }
            return invokeL.intValue;
        }

        public int computeHorizontalScrollRange(@NonNull State state) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, state)) == null) {
                return 0;
            }
            return invokeL.intValue;
        }

        public int computeVerticalScrollExtent(@NonNull State state) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, state)) == null) {
                return 0;
            }
            return invokeL.intValue;
        }

        public int computeVerticalScrollOffset(@NonNull State state) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, state)) == null) {
                return 0;
            }
            return invokeL.intValue;
        }

        public int computeVerticalScrollRange(@NonNull State state) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, state)) == null) {
                return 0;
            }
            return invokeL.intValue;
        }

        public void detachAndScrapAttachedViews(@NonNull Recycler recycler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, recycler) == null) {
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    scrapOrRecycleView(recycler, childCount, getChildAt(childCount));
                }
            }
        }

        public void detachAndScrapView(@NonNull View view, @NonNull Recycler recycler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048598, this, view, recycler) == null) {
                scrapOrRecycleView(recycler, this.mChildHelper.indexOfChild(view), view);
            }
        }

        public void detachAndScrapViewAt(int i2, @NonNull Recycler recycler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048599, this, i2, recycler) == null) {
                scrapOrRecycleView(recycler, i2, getChildAt(i2));
            }
        }

        public void detachView(@NonNull View view) {
            int indexOfChild;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048600, this, view) == null) || (indexOfChild = this.mChildHelper.indexOfChild(view)) < 0) {
                return;
            }
            detachViewInternal(indexOfChild, view);
        }

        public void detachViewAt(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
                detachViewInternal(i2, getChildAt(i2));
            }
        }

        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, recyclerView) == null) {
                this.mIsAttachedToWindow = true;
                onAttachedToWindow(recyclerView);
            }
        }

        public void dispatchDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048603, this, recyclerView, recycler) == null) {
                this.mIsAttachedToWindow = false;
                onDetachedFromWindow(recyclerView, recycler);
            }
        }

        public void endAnimation(View view) {
            ItemAnimator itemAnimator;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048604, this, view) == null) || (itemAnimator = this.mRecyclerView.mItemAnimator) == null) {
                return;
            }
            itemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view));
        }

        @Nullable
        public View findContainingItemView(@NonNull View view) {
            InterceptResult invokeL;
            View findContainingItemView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, view)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.isHidden(findContainingItemView)) {
                    return null;
                }
                return findContainingItemView;
            }
            return (View) invokeL.objValue;
        }

        @Nullable
        public View findViewByPosition(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                    if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i2 && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.isPreLayout() || !childViewHolderInt.isRemoved())) {
                        return childAt;
                    }
                }
                return null;
            }
            return (View) invokeI.objValue;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, layoutParams)) == null) {
                if (layoutParams instanceof LayoutParams) {
                    return new LayoutParams((LayoutParams) layoutParams);
                }
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
                }
                return new LayoutParams(layoutParams);
            }
            return (LayoutParams) invokeL.objValue;
        }

        public int getBaseline() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
                return -1;
            }
            return invokeV.intValue;
        }

        public int getBottomDecorationHeight(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, view)) == null) ? ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom : invokeL.intValue;
        }

        @Nullable
        public View getChildAt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
                ChildHelper childHelper = this.mChildHelper;
                if (childHelper != null) {
                    return childHelper.getChildAt(i2);
                }
                return null;
            }
            return (View) invokeI.objValue;
        }

        public int getChildCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
                ChildHelper childHelper = this.mChildHelper;
                if (childHelper != null) {
                    return childHelper.getChildCount();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public boolean getClipToPadding() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                return recyclerView != null && recyclerView.mClipToPadding;
            }
            return invokeV.booleanValue;
        }

        public int getColumnCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048615, this, recycler, state)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                    return 1;
                }
                return this.mRecyclerView.mAdapter.getItemCount();
            }
            return invokeLL.intValue;
        }

        public int getDecoratedBottom(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, view)) == null) ? view.getBottom() + getBottomDecorationHeight(view) : invokeL.intValue;
        }

        public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048617, this, view, rect) == null) {
                RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
            }
        }

        public int getDecoratedLeft(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, view)) == null) ? view.getLeft() - getLeftDecorationWidth(view) : invokeL.intValue;
        }

        public int getDecoratedMeasuredHeight(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, view)) == null) {
                Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                return view.getMeasuredHeight() + rect.top + rect.bottom;
            }
            return invokeL.intValue;
        }

        public int getDecoratedMeasuredWidth(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, view)) == null) {
                Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                return view.getMeasuredWidth() + rect.left + rect.right;
            }
            return invokeL.intValue;
        }

        public int getDecoratedRight(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, view)) == null) ? view.getRight() + getRightDecorationWidth(view) : invokeL.intValue;
        }

        public int getDecoratedTop(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, view)) == null) ? view.getTop() - getTopDecorationHeight(view) : invokeL.intValue;
        }

        @Nullable
        public View getFocusedChild() {
            InterceptResult invokeV;
            View focusedChild;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.isHidden(focusedChild)) {
                    return null;
                }
                return focusedChild;
            }
            return (View) invokeV.objValue;
        }

        @Px
        public int getHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mHeight : invokeV.intValue;
        }

        public int getHeightMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mHeightMode : invokeV.intValue;
        }

        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
                if (adapter != null) {
                    return adapter.getItemCount();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public int getItemViewType(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, view)) == null) ? RecyclerView.getChildViewHolderInt(view).getItemViewType() : invokeL.intValue;
        }

        public int getLayoutDirection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? ViewCompat.getLayoutDirection(this.mRecyclerView) : invokeV.intValue;
        }

        public int getLeftDecorationWidth(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, view)) == null) ? ((LayoutParams) view.getLayoutParams()).mDecorInsets.left : invokeL.intValue;
        }

        @Px
        public int getMinimumHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? ViewCompat.getMinimumHeight(this.mRecyclerView) : invokeV.intValue;
        }

        @Px
        public int getMinimumWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? ViewCompat.getMinimumWidth(this.mRecyclerView) : invokeV.intValue;
        }

        @Px
        public int getPaddingBottom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    return recyclerView.getPaddingBottom();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Px
        public int getPaddingEnd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    return ViewCompat.getPaddingEnd(recyclerView);
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Px
        public int getPaddingLeft() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    return recyclerView.getPaddingLeft();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Px
        public int getPaddingRight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    return recyclerView.getPaddingRight();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Px
        public int getPaddingStart() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    return ViewCompat.getPaddingStart(recyclerView);
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Px
        public int getPaddingTop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    return recyclerView.getPaddingTop();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public int getPosition(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, view)) == null) ? ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition() : invokeL.intValue;
        }

        public int getRightDecorationWidth(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, view)) == null) ? ((LayoutParams) view.getLayoutParams()).mDecorInsets.right : invokeL.intValue;
        }

        public int getRowCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048640, this, recycler, state)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
                    return 1;
                }
                return this.mRecyclerView.mAdapter.getItemCount();
            }
            return invokeLL.intValue;
        }

        public int getSelectionModeForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048641, this, recycler, state)) == null) {
                return 0;
            }
            return invokeLL.intValue;
        }

        public int getTopDecorationHeight(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, view)) == null) ? ((LayoutParams) view.getLayoutParams()).mDecorInsets.top : invokeL.intValue;
        }

        public void getTransformedBoundingBox(@NonNull View view, boolean z, @NonNull Rect rect) {
            Matrix matrix;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{view, Boolean.valueOf(z), rect}) == null) {
                if (z) {
                    Rect rect2 = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                    rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
                } else {
                    rect.set(0, 0, view.getWidth(), view.getHeight());
                }
                if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                    RectF rectF = this.mRecyclerView.mTempRectF;
                    rectF.set(rect);
                    matrix.mapRect(rectF);
                    rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
                }
                rect.offset(view.getLeft(), view.getTop());
            }
        }

        @Px
        public int getWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.mWidth : invokeV.intValue;
        }

        public int getWidthMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.mWidthMode : invokeV.intValue;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    ViewGroup.LayoutParams layoutParams = getChildAt(i2).getLayoutParams();
                    if (layoutParams.width < 0 && layoutParams.height < 0) {
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean hasFocus() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                return recyclerView != null && recyclerView.hasFocus();
            }
            return invokeV.booleanValue;
        }

        public void ignoreView(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048648, this, view) == null) {
                ViewParent parent = view.getParent();
                RecyclerView recyclerView = this.mRecyclerView;
                if (parent == recyclerView && recyclerView.indexOfChild(view) != -1) {
                    ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                    childViewHolderInt.addFlags(128);
                    this.mRecyclerView.mViewInfoStore.removeViewHolder(childViewHolderInt);
                    return;
                }
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
        }

        public boolean isAttachedToWindow() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.mIsAttachedToWindow : invokeV.booleanValue;
        }

        public boolean isAutoMeasureEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.mAutoMeasure : invokeV.booleanValue;
        }

        public boolean isFocused() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                return recyclerView != null && recyclerView.isFocused();
            }
            return invokeV.booleanValue;
        }

        public final boolean isItemPrefetchEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.mItemPrefetchEnabled : invokeV.booleanValue;
        }

        public boolean isLayoutHierarchical(@NonNull Recycler recycler, @NonNull State state) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048653, this, recycler, state)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public boolean isMeasurementCacheEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.mMeasurementCacheEnabled : invokeV.booleanValue;
        }

        public boolean isSmoothScrolling() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
                SmoothScroller smoothScroller = this.mSmoothScroller;
                return smoothScroller != null && smoothScroller.isRunning();
            }
            return invokeV.booleanValue;
        }

        public boolean isViewPartiallyVisible(@NonNull View view, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048656, this, new Object[]{view, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                boolean z3 = this.mHorizontalBoundCheck.isViewWithinBoundFlags(view, 24579) && this.mVerticalBoundCheck.isViewWithinBoundFlags(view, 24579);
                return z ? z3 : !z3;
            }
            return invokeCommon.booleanValue;
        }

        public void layoutDecorated(@NonNull View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048657, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                view.layout(i2 + rect.left, i3 + rect.top, i4 - rect.right, i5 - rect.bottom);
            }
        }

        public void layoutDecoratedWithMargins(@NonNull View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048658, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                Rect rect = layoutParams.mDecorInsets;
                view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i3 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            }
        }

        public void measureChild(@NonNull View view, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048659, this, view, i2, i3) == null) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
                int i4 = i2 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
                int i5 = i3 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
                int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i4, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
                int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i5, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
                if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                    view.measure(childMeasureSpec, childMeasureSpec2);
                }
            }
        }

        public void measureChildWithMargins(@NonNull View view, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048660, this, view, i2, i3) == null) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
                int i4 = i2 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
                int i5 = i3 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
                int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i4, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
                int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
                if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                    view.measure(childMeasureSpec, childMeasureSpec2);
                }
            }
        }

        public void moveView(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048661, this, i2, i3) == null) {
                View childAt = getChildAt(i2);
                if (childAt != null) {
                    detachViewAt(i2);
                    attachView(childAt, i3);
                    return;
                }
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.mRecyclerView.toString());
            }
        }

        public void offsetChildrenHorizontal(@Px int i2) {
            RecyclerView recyclerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048662, this, i2) == null) || (recyclerView = this.mRecyclerView) == null) {
                return;
            }
            recyclerView.offsetChildrenHorizontal(i2);
        }

        public void offsetChildrenVertical(@Px int i2) {
            RecyclerView recyclerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048663, this, i2) == null) || (recyclerView = this.mRecyclerView) == null) {
                return;
            }
            recyclerView.offsetChildrenVertical(i2);
        }

        public void onAdapterChanged(@Nullable Adapter adapter, @Nullable Adapter adapter2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048664, this, adapter, adapter2) == null) {
            }
        }

        public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i2, int i3) {
            InterceptResult invokeLLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048665, this, recyclerView, arrayList, i2, i3)) == null) {
                return false;
            }
            return invokeLLII.booleanValue;
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048666, this, recyclerView) == null) {
            }
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048667, this, recyclerView) == null) {
            }
        }

        @CallSuper
        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048668, this, recyclerView, recycler) == null) {
                onDetachedFromWindow(recyclerView);
            }
        }

        @Nullable
        public View onFocusSearchFailed(@NonNull View view, int i2, @NonNull Recycler recycler, @NonNull State state) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048669, this, view, i2, recycler, state)) == null) {
                return null;
            }
            return (View) invokeLILL.objValue;
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048670, this, accessibilityEvent) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
            }
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048672, this, accessibilityNodeInfoCompat) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, accessibilityNodeInfoCompat);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048674, this, view, accessibilityNodeInfoCompat) == null) || (childViewHolderInt = RecyclerView.getChildViewHolderInt(view)) == null || childViewHolderInt.isRemoved() || this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, accessibilityNodeInfoCompat);
        }

        @Nullable
        public View onInterceptFocusSearch(@NonNull View view, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048676, this, view, i2)) == null) {
                return null;
            }
            return (View) invokeLI.objValue;
        }

        public void onItemsAdded(@NonNull RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048677, this, recyclerView, i2, i3) == null) {
            }
        }

        public void onItemsChanged(@NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048678, this, recyclerView) == null) {
            }
        }

        public void onItemsMoved(@NonNull RecyclerView recyclerView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048679, this, recyclerView, i2, i3, i4) == null) {
            }
        }

        public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048680, this, recyclerView, i2, i3) == null) {
            }
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048681, this, recyclerView, i2, i3) == null) {
            }
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i2, int i3, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048682, this, new Object[]{recyclerView, Integer.valueOf(i2), Integer.valueOf(i3), obj}) == null) {
                onItemsUpdated(recyclerView, i2, i3);
            }
        }

        public void onLayoutChildren(Recycler recycler, State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048683, this, recycler, state) == null) {
            }
        }

        public void onLayoutCompleted(State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048684, this, state) == null) {
            }
        }

        public void onMeasure(@NonNull Recycler recycler, @NonNull State state, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(1048685, this, recycler, state, i2, i3) == null) {
                this.mRecyclerView.defaultOnMeasure(i2, i3);
            }
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull View view, @Nullable View view2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048686, this, recyclerView, view, view2)) == null) ? isSmoothScrolling() || recyclerView.isComputingLayout() : invokeLLL.booleanValue;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048688, this, parcelable) == null) {
            }
        }

        @Nullable
        public Parcelable onSaveInstanceState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
                return null;
            }
            return (Parcelable) invokeV.objValue;
        }

        public void onScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048690, this, i2) == null) {
            }
        }

        public void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048691, this, smoothScroller) == null) && this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        public boolean performAccessibilityAction(int i2, @Nullable Bundle bundle) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048692, this, i2, bundle)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i2, bundle);
            }
            return invokeIL.booleanValue;
        }

        public boolean performAccessibilityActionForItem(@NonNull View view, int i2, @Nullable Bundle bundle) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048694, this, view, i2, bundle)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i2, bundle);
            }
            return invokeLIL.booleanValue;
        }

        public boolean performAccessibilityActionForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, int i2, @Nullable Bundle bundle) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048695, this, new Object[]{recycler, state, view, Integer.valueOf(i2), bundle})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048696, this, runnable) == null) || (recyclerView = this.mRecyclerView) == null) {
                return;
            }
            ViewCompat.postOnAnimation(recyclerView, runnable);
        }

        public void removeAllViews() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048697, this) == null) {
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    this.mChildHelper.removeViewAt(childCount);
                }
            }
        }

        public void removeAndRecycleAllViews(@NonNull Recycler recycler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048698, this, recycler) == null) {
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                        removeAndRecycleViewAt(childCount, recycler);
                    }
                }
            }
        }

        public void removeAndRecycleScrapInt(Recycler recycler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048699, this, recycler) == null) {
                int scrapCount = recycler.getScrapCount();
                for (int i2 = scrapCount - 1; i2 >= 0; i2--) {
                    View scrapViewAt = recycler.getScrapViewAt(i2);
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
        }

        public void removeAndRecycleView(@NonNull View view, @NonNull Recycler recycler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048700, this, view, recycler) == null) {
                removeView(view);
                recycler.recycleView(view);
            }
        }

        public void removeAndRecycleViewAt(int i2, @NonNull Recycler recycler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048701, this, i2, recycler) == null) {
                View childAt = getChildAt(i2);
                removeViewAt(i2);
                recycler.recycleView(childAt);
            }
        }

        public boolean removeCallbacks(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048702, this, runnable)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    return recyclerView.removeCallbacks(runnable);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void removeDetachedView(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048703, this, view) == null) {
                this.mRecyclerView.removeDetachedView(view, false);
            }
        }

        public void removeView(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048704, this, view) == null) {
                this.mChildHelper.removeView(view);
            }
        }

        public void removeViewAt(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048705, this, i2) == null) || getChildAt(i2) == null) {
                return;
            }
            this.mChildHelper.removeViewAt(i2);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048706, this, new Object[]{recyclerView, view, rect, Boolean.valueOf(z)})) == null) ? requestChildRectangleOnScreen(recyclerView, view, rect, z, false) : invokeCommon.booleanValue;
        }

        public void requestLayout() {
            RecyclerView recyclerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048708, this) == null) || (recyclerView = this.mRecyclerView) == null) {
                return;
            }
            recyclerView.requestLayout();
        }

        public void requestSimpleAnimationsInNextLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
                this.mRequestedSimpleAnimations = true;
            }
        }

        public int scrollHorizontallyBy(int i2, Recycler recycler, State state) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048710, this, i2, recycler, state)) == null) {
                return 0;
            }
            return invokeILL.intValue;
        }

        public void scrollToPosition(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048711, this, i2) == null) {
            }
        }

        public int scrollVerticallyBy(int i2, Recycler recycler, State state) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048712, this, i2, recycler, state)) == null) {
                return 0;
            }
            return invokeILL.intValue;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048713, this, z) == null) {
                this.mAutoMeasure = z;
            }
        }

        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048714, this, recyclerView) == null) {
                setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
            }
        }

        public final void setItemPrefetchEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048715, this, z) == null) || z == this.mItemPrefetchEnabled) {
                return;
            }
            this.mItemPrefetchEnabled = z;
            this.mPrefetchMaxCountObserved = 0;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.mRecycler.updateViewCacheSize();
            }
        }

        public void setMeasureSpecs(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048716, this, i2, i3) == null) {
                this.mWidth = View.MeasureSpec.getSize(i2);
                int mode = View.MeasureSpec.getMode(i2);
                this.mWidthMode = mode;
                if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                    this.mWidth = 0;
                }
                this.mHeight = View.MeasureSpec.getSize(i3);
                int mode2 = View.MeasureSpec.getMode(i3);
                this.mHeightMode = mode2;
                if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                    return;
                }
                this.mHeight = 0;
            }
        }

        public void setMeasuredDimension(Rect rect, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048718, this, rect, i2, i3) == null) {
                setMeasuredDimension(chooseSize(i2, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i3, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
            }
        }

        public void setMeasuredDimensionFromChildren(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048719, this, i2, i3) == null) {
                int childCount = getChildCount();
                if (childCount == 0) {
                    this.mRecyclerView.defaultOnMeasure(i2, i3);
                    return;
                }
                int i4 = Integer.MIN_VALUE;
                int i5 = Integer.MIN_VALUE;
                int i6 = Integer.MAX_VALUE;
                int i7 = Integer.MAX_VALUE;
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt = getChildAt(i8);
                    Rect rect = this.mRecyclerView.mTempRect;
                    getDecoratedBoundsWithMargins(childAt, rect);
                    int i9 = rect.left;
                    if (i9 < i6) {
                        i6 = i9;
                    }
                    int i10 = rect.right;
                    if (i10 > i4) {
                        i4 = i10;
                    }
                    int i11 = rect.top;
                    if (i11 < i7) {
                        i7 = i11;
                    }
                    int i12 = rect.bottom;
                    if (i12 > i5) {
                        i5 = i12;
                    }
                }
                this.mRecyclerView.mTempRect.set(i6, i7, i4, i5);
                setMeasuredDimension(this.mRecyclerView.mTempRect, i2, i3);
            }
        }

        public void setMeasurementCacheEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048720, this, z) == null) {
                this.mMeasurementCacheEnabled = z;
            }
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048721, this, recyclerView) == null) {
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
        }

        public boolean shouldMeasureChild(View view, int i2, int i3, LayoutParams layoutParams) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048722, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), layoutParams})) == null) ? (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true : invokeCommon.booleanValue;
        }

        public boolean shouldMeasureTwice() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean shouldReMeasureChild(View view, int i2, int i3, LayoutParams layoutParams) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048724, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), layoutParams})) == null) ? (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getMeasuredHeight(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true : invokeCommon.booleanValue;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048725, this, recyclerView, state, i2) == null) {
            }
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048726, this, smoothScroller) == null) {
                SmoothScroller smoothScroller2 = this.mSmoothScroller;
                if (smoothScroller2 != null && smoothScroller != smoothScroller2 && smoothScroller2.isRunning()) {
                    this.mSmoothScroller.stop();
                }
                this.mSmoothScroller = smoothScroller;
                smoothScroller.start(this.mRecyclerView, this);
            }
        }

        public void stopIgnoringView(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048727, this, view) == null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                childViewHolderInt.stopIgnoring();
                childViewHolderInt.resetInternal();
                childViewHolderInt.addFlags(4);
            }
        }

        public void stopSmoothScroller() {
            SmoothScroller smoothScroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048728, this) == null) || (smoothScroller = this.mSmoothScroller) == null) {
                return;
            }
            smoothScroller.stop();
        }

        public boolean supportsPredictiveItemAnimations() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public void addDisappearingView(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
                addViewInt(view, i2, true);
            }
        }

        public void addView(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, view, i2) == null) {
                addViewInt(view, i2, false);
            }
        }

        public void onInitializeAccessibilityEvent(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048671, this, recycler, state, accessibilityEvent) == null) || (recyclerView = this.mRecyclerView) == null || accessibilityEvent == null) {
                return;
            }
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

        public void onInitializeAccessibilityNodeInfo(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048673, this, recycler, state, accessibilityNodeInfoCompat) == null) {
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
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull State state, @NonNull View view, @Nullable View view2) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048687, this, recyclerView, state, view, view2)) == null) ? onRequestChildFocus(recyclerView, view, view2) : invokeLLLL.booleanValue;
        }

        public boolean performAccessibilityAction(@NonNull Recycler recycler, @NonNull State state, int i2, @Nullable Bundle bundle) {
            InterceptResult invokeLLIL;
            int height;
            int width;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048693, this, recycler, state, i2, bundle)) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView == null) {
                    return false;
                }
                if (i2 == 4096) {
                    height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                    if (this.mRecyclerView.canScrollHorizontally(1)) {
                        width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                        i3 = height;
                        i4 = width;
                    }
                    i3 = height;
                    i4 = 0;
                } else if (i2 != 8192) {
                    i4 = 0;
                    i3 = 0;
                } else {
                    height = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                    if (this.mRecyclerView.canScrollHorizontally(-1)) {
                        width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                        i3 = height;
                        i4 = width;
                    }
                    i3 = height;
                    i4 = 0;
                }
                if (i3 == 0 && i4 == 0) {
                    return false;
                }
                this.mRecyclerView.smoothScrollBy(i4, i3, null, Integer.MIN_VALUE, true);
                return true;
            }
            return invokeLLIL.booleanValue;
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048707, this, new Object[]{recyclerView, view, rect, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
                int i2 = childRectangleOnScreenScrollAmount[0];
                int i3 = childRectangleOnScreenScrollAmount[1];
                if ((!z2 || isFocusedChildVisibleAfterScrolling(recyclerView, i2, i3)) && !(i2 == 0 && i3 == 0)) {
                    if (z) {
                        recyclerView.scrollBy(i2, i3);
                    } else {
                        recyclerView.smoothScrollBy(i2, i3);
                    }
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
            if (r5 == 1073741824) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int getChildMeasureSpec(int i2, int i3, int i4, int i5, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)})) == null) {
                int max = Math.max(0, i2 - i4);
                if (z) {
                    if (i5 < 0) {
                        if (i5 == -1) {
                            if (i3 != Integer.MIN_VALUE) {
                                if (i3 != 0) {
                                }
                            }
                            i5 = max;
                        }
                        i3 = 0;
                        i5 = 0;
                    }
                    i3 = 1073741824;
                } else {
                    if (i5 < 0) {
                        if (i5 != -1) {
                            if (i5 == -2) {
                                i3 = (i3 == Integer.MIN_VALUE || i3 == 1073741824) ? Integer.MIN_VALUE : 0;
                            }
                            i3 = 0;
                            i5 = 0;
                        }
                        i5 = max;
                    }
                    i3 = 1073741824;
                }
                return View.MeasureSpec.makeMeasureSpec(i5, i3);
            }
            return invokeCommon.intValue;
        }

        public void onInitializeAccessibilityNodeInfoForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048675, this, recycler, state, view, accessibilityNodeInfoCompat) == null) {
                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
            }
        }

        public void attachView(@NonNull View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, view, i2) == null) {
                attachView(view, i2, (LayoutParams) view.getLayoutParams());
            }
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, context, attributeSet)) == null) ? new LayoutParams(context, attributeSet) : (LayoutParams) invokeLL.objValue;
        }

        public void setMeasuredDimension(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048717, this, i2, i3) == null) {
                this.mRecyclerView.setMeasuredDimension(i2, i3);
            }
        }

        public void attachView(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
                attachView(view, -1);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(@NonNull View view);

        void onChildViewDetachedFromWindow(@NonNull View view);
    }

    /* loaded from: classes.dex */
    public static abstract class OnFlingListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public OnFlingListener() {
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

        public abstract boolean onFling(int i2, int i3);
    }

    /* loaded from: classes.dex */
    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public OnScrollListener() {
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

        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
            }
        }

        public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Orientation {
    }

    /* loaded from: classes.dex */
    public static class RecycledViewPool {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DEFAULT_MAX_SCRAP = 5;
        public transient /* synthetic */ FieldHolder $fh;
        public int mAttachCount;
        public SparseArray<ScrapData> mScrap;

        /* loaded from: classes.dex */
        public static class ScrapData {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long mBindRunningAverageNs;
            public long mCreateRunningAverageNs;
            public int mMaxScrap;
            public final ArrayList<ViewHolder> mScrapHeap;

            public ScrapData() {
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
                this.mScrapHeap = new ArrayList<>();
                this.mMaxScrap = 5;
                this.mCreateRunningAverageNs = 0L;
                this.mBindRunningAverageNs = 0L;
            }
        }

        public RecycledViewPool() {
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
            this.mScrap = new SparseArray<>();
            this.mAttachCount = 0;
        }

        private ScrapData getScrapDataForType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
                ScrapData scrapData = this.mScrap.get(i2);
                if (scrapData == null) {
                    ScrapData scrapData2 = new ScrapData();
                    this.mScrap.put(i2, scrapData2);
                    return scrapData2;
                }
                return scrapData;
            }
            return (ScrapData) invokeI.objValue;
        }

        public void attach() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mAttachCount++;
            }
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (int i2 = 0; i2 < this.mScrap.size(); i2++) {
                    this.mScrap.valueAt(i2).mScrapHeap.clear();
                }
            }
        }

        public void detach() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mAttachCount--;
            }
        }

        public void factorInBindTime(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                ScrapData scrapDataForType = getScrapDataForType(i2);
                scrapDataForType.mBindRunningAverageNs = runningAverage(scrapDataForType.mBindRunningAverageNs, j2);
            }
        }

        public void factorInCreateTime(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                ScrapData scrapDataForType = getScrapDataForType(i2);
                scrapDataForType.mCreateRunningAverageNs = runningAverage(scrapDataForType.mCreateRunningAverageNs, j2);
            }
        }

        @Nullable
        public ViewHolder getRecycledView(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                ScrapData scrapData = this.mScrap.get(i2);
                if (scrapData == null || scrapData.mScrapHeap.isEmpty()) {
                    return null;
                }
                ArrayList<ViewHolder> arrayList = scrapData.mScrapHeap;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                        return arrayList.remove(size);
                    }
                }
                return null;
            }
            return (ViewHolder) invokeI.objValue;
        }

        public int getRecycledViewCount(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? getScrapDataForType(i2).mScrapHeap.size() : invokeI.intValue;
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048583, this, adapter, adapter2, z) == null) {
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
        }

        public void putRecycledView(ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewHolder) == null) {
                int itemViewType = viewHolder.getItemViewType();
                ArrayList<ViewHolder> arrayList = getScrapDataForType(itemViewType).mScrapHeap;
                if (this.mScrap.get(itemViewType).mMaxScrap <= arrayList.size()) {
                    return;
                }
                viewHolder.resetInternal();
                arrayList.add(viewHolder);
            }
        }

        public long runningAverage(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? j2 == 0 ? j3 : ((j2 / 4) * 3) + (j3 / 4) : invokeCommon.longValue;
        }

        public void setMaxRecycledViews(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
                ScrapData scrapDataForType = getScrapDataForType(i2);
                scrapDataForType.mMaxScrap = i3;
                ArrayList<ViewHolder> arrayList = scrapDataForType.mScrapHeap;
                while (arrayList.size() > i3) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }

        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                int i2 = 0;
                for (int i3 = 0; i3 < this.mScrap.size(); i3++) {
                    ArrayList<ViewHolder> arrayList = this.mScrap.valueAt(i3).mScrapHeap;
                    if (arrayList != null) {
                        i2 += arrayList.size();
                    }
                }
                return i2;
            }
            return invokeV.intValue;
        }

        public boolean willBindInTime(int i2, long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                long j4 = getScrapDataForType(i2).mBindRunningAverageNs;
                return j4 == 0 || j2 + j4 < j3;
            }
            return invokeCommon.booleanValue;
        }

        public boolean willCreateInTime(int i2, long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                long j4 = getScrapDataForType(i2).mCreateRunningAverageNs;
                return j4 == 0 || j2 + j4 < j3;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public final class Recycler {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DEFAULT_CACHE_SIZE = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public final ArrayList<ViewHolder> mAttachedScrap;
        public final ArrayList<ViewHolder> mCachedViews;
        public ArrayList<ViewHolder> mChangedScrap;
        public RecycledViewPool mRecyclerPool;
        public int mRequestedCacheMax;
        public final List<ViewHolder> mUnmodifiableAttachedScrap;
        public ViewCacheExtension mViewCacheExtension;
        public int mViewCacheMax;
        public final /* synthetic */ RecyclerView this$0;

        public Recycler(RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = recyclerView;
            this.mAttachedScrap = new ArrayList<>();
            this.mChangedScrap = null;
            this.mCachedViews = new ArrayList<>();
            this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
            this.mRequestedCacheMax = 2;
            this.mViewCacheMax = 2;
        }

        private void attachAccessibilityDelegateOnBind(ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, this, viewHolder) == null) && this.this$0.isAccessibilityEnabled()) {
                View view = viewHolder.itemView;
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = this.this$0.mAccessibilityDelegate;
                if (recyclerViewAccessibilityDelegate == null) {
                    return;
                }
                AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).saveOriginalDelegate(view);
                }
                ViewCompat.setAccessibilityDelegate(view, itemDelegate);
            }
        }

        private void invalidateDisplayListInt(ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, viewHolder) == null) {
                View view = viewHolder.itemView;
                if (view instanceof ViewGroup) {
                    invalidateDisplayListInt((ViewGroup) view, false);
                }
            }
        }

        private boolean tryBindViewHolderByDeadline(@NonNull ViewHolder viewHolder, int i2, int i3, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{viewHolder, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
                viewHolder.mOwnerRecyclerView = this.this$0;
                int itemViewType = viewHolder.getItemViewType();
                long nanoTime = this.this$0.getNanoTime();
                if (j2 == Long.MAX_VALUE || this.mRecyclerPool.willBindInTime(itemViewType, nanoTime, j2)) {
                    this.this$0.mAdapter.bindViewHolder(viewHolder, i2);
                    this.mRecyclerPool.factorInBindTime(viewHolder.getItemViewType(), this.this$0.getNanoTime() - nanoTime);
                    attachAccessibilityDelegateOnBind(viewHolder);
                    if (this.this$0.mState.isPreLayout()) {
                        viewHolder.mPreLayoutPosition = i3;
                        return true;
                    }
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public void addViewHolderToRecycledViewPool(@NonNull ViewHolder viewHolder, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, viewHolder, z) == null) {
                RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
                View view = viewHolder.itemView;
                RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = this.this$0.mAccessibilityDelegate;
                if (recyclerViewAccessibilityDelegate != null) {
                    AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                    ViewCompat.setAccessibilityDelegate(view, itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate ? ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).getAndRemoveOriginalDelegateForItem(view) : null);
                }
                if (z) {
                    dispatchViewRecycled(viewHolder);
                }
                viewHolder.mOwnerRecyclerView = null;
                getRecycledViewPool().putRecycledView(viewHolder);
            }
        }

        public void bindViewToPosition(@NonNull View view, int i2) {
            LayoutParams layoutParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    int findPositionOffset = this.this$0.mAdapterHelper.findPositionOffset(i2);
                    if (findPositionOffset >= 0 && findPositionOffset < this.this$0.mAdapter.getItemCount()) {
                        tryBindViewHolderByDeadline(childViewHolderInt, findPositionOffset, i2, Long.MAX_VALUE);
                        ViewGroup.LayoutParams layoutParams2 = childViewHolderInt.itemView.getLayoutParams();
                        if (layoutParams2 == null) {
                            layoutParams = (LayoutParams) this.this$0.generateDefaultLayoutParams();
                            childViewHolderInt.itemView.setLayoutParams(layoutParams);
                        } else if (!this.this$0.checkLayoutParams(layoutParams2)) {
                            layoutParams = (LayoutParams) this.this$0.generateLayoutParams(layoutParams2);
                            childViewHolderInt.itemView.setLayoutParams(layoutParams);
                        } else {
                            layoutParams = (LayoutParams) layoutParams2;
                        }
                        layoutParams.mInsetsDirty = true;
                        layoutParams.mViewHolder = childViewHolderInt;
                        layoutParams.mPendingInvalidate = childViewHolderInt.itemView.getParent() == null;
                        return;
                    }
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i2 + "(offset:" + findPositionOffset + ").state:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
                }
                throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + this.this$0.exceptionLabel());
            }
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mAttachedScrap.clear();
                recycleAndClearCachedViews();
            }
        }

        public void clearOldPositions() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                int size = this.mCachedViews.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.mCachedViews.get(i2).clearOldPosition();
                }
                int size2 = this.mAttachedScrap.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    this.mAttachedScrap.get(i3).clearOldPosition();
                }
                ArrayList<ViewHolder> arrayList = this.mChangedScrap;
                if (arrayList != null) {
                    int size3 = arrayList.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        this.mChangedScrap.get(i4).clearOldPosition();
                    }
                }
            }
        }

        public void clearScrap() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.mAttachedScrap.clear();
                ArrayList<ViewHolder> arrayList = this.mChangedScrap;
                if (arrayList != null) {
                    arrayList.clear();
                }
            }
        }

        public int convertPreLayoutPositionToPostLayout(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                if (i2 >= 0 && i2 < this.this$0.mState.getItemCount()) {
                    return !this.this$0.mState.isPreLayout() ? i2 : this.this$0.mAdapterHelper.findPositionOffset(i2);
                }
                throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
            }
            return invokeI.intValue;
        }

        public void dispatchViewRecycled(@NonNull ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, viewHolder) == null) {
                RecyclerListener recyclerListener = this.this$0.mRecyclerListener;
                if (recyclerListener != null) {
                    recyclerListener.onViewRecycled(viewHolder);
                }
                Adapter adapter = this.this$0.mAdapter;
                if (adapter != null) {
                    adapter.onViewRecycled(viewHolder);
                }
                RecyclerView recyclerView = this.this$0;
                if (recyclerView.mState != null) {
                    recyclerView.mViewInfoStore.removeViewHolder(viewHolder);
                }
            }
        }

        public ViewHolder getChangedScrapViewForPosition(int i2) {
            InterceptResult invokeI;
            int size;
            int findPositionOffset;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                ArrayList<ViewHolder> arrayList = this.mChangedScrap;
                if (arrayList != null && (size = arrayList.size()) != 0) {
                    for (int i3 = 0; i3 < size; i3++) {
                        ViewHolder viewHolder = this.mChangedScrap.get(i3);
                        if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i2) {
                            viewHolder.addFlags(32);
                            return viewHolder;
                        }
                    }
                    if (this.this$0.mAdapter.hasStableIds() && (findPositionOffset = this.this$0.mAdapterHelper.findPositionOffset(i2)) > 0 && findPositionOffset < this.this$0.mAdapter.getItemCount()) {
                        long itemId = this.this$0.mAdapter.getItemId(findPositionOffset);
                        for (int i4 = 0; i4 < size; i4++) {
                            ViewHolder viewHolder2 = this.mChangedScrap.get(i4);
                            if (!viewHolder2.wasReturnedFromScrap() && viewHolder2.getItemId() == itemId) {
                                viewHolder2.addFlags(32);
                                return viewHolder2;
                            }
                        }
                    }
                }
                return null;
            }
            return (ViewHolder) invokeI.objValue;
        }

        public RecycledViewPool getRecycledViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.mRecyclerPool == null) {
                    this.mRecyclerPool = new RecycledViewPool();
                }
                return this.mRecyclerPool;
            }
            return (RecycledViewPool) invokeV.objValue;
        }

        public int getScrapCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mAttachedScrap.size() : invokeV.intValue;
        }

        @NonNull
        public List<ViewHolder> getScrapList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mUnmodifiableAttachedScrap : (List) invokeV.objValue;
        }

        public ViewHolder getScrapOrCachedViewForId(long j2, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Boolean.valueOf(z)})) != null) {
                return (ViewHolder) invokeCommon.objValue;
            }
            for (int size = this.mAttachedScrap.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mAttachedScrap.get(size);
                if (viewHolder.getItemId() == j2 && !viewHolder.wasReturnedFromScrap()) {
                    if (i2 == viewHolder.getItemViewType()) {
                        viewHolder.addFlags(32);
                        if (viewHolder.isRemoved() && !this.this$0.mState.isPreLayout()) {
                            viewHolder.setFlags(2, 14);
                        }
                        return viewHolder;
                    } else if (!z) {
                        this.mAttachedScrap.remove(size);
                        this.this$0.removeDetachedView(viewHolder.itemView, false);
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
                if (viewHolder2.getItemId() == j2 && !viewHolder2.isAttachedToTransitionOverlay()) {
                    if (i2 == viewHolder2.getItemViewType()) {
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

        public ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int i2, boolean z) {
            InterceptResult invokeCommon;
            View findHiddenNonRemovedView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                int size = this.mAttachedScrap.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ViewHolder viewHolder = this.mAttachedScrap.get(i3);
                    if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i2 && !viewHolder.isInvalid() && (this.this$0.mState.mInPreLayout || !viewHolder.isRemoved())) {
                        viewHolder.addFlags(32);
                        return viewHolder;
                    }
                }
                if (!z && (findHiddenNonRemovedView = this.this$0.mChildHelper.findHiddenNonRemovedView(i2)) != null) {
                    ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(findHiddenNonRemovedView);
                    this.this$0.mChildHelper.unhide(findHiddenNonRemovedView);
                    int indexOfChild = this.this$0.mChildHelper.indexOfChild(findHiddenNonRemovedView);
                    if (indexOfChild != -1) {
                        this.this$0.mChildHelper.detachViewFromParent(indexOfChild);
                        scrapView(findHiddenNonRemovedView);
                        childViewHolderInt.addFlags(8224);
                        return childViewHolderInt;
                    }
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + this.this$0.exceptionLabel());
                }
                int size2 = this.mCachedViews.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    ViewHolder viewHolder2 = this.mCachedViews.get(i4);
                    if (!viewHolder2.isInvalid() && viewHolder2.getLayoutPosition() == i2 && !viewHolder2.isAttachedToTransitionOverlay()) {
                        if (!z) {
                            this.mCachedViews.remove(i4);
                        }
                        return viewHolder2;
                    }
                }
                return null;
            }
            return (ViewHolder) invokeCommon.objValue;
        }

        public View getScrapViewAt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? this.mAttachedScrap.get(i2).itemView : (View) invokeI.objValue;
        }

        @NonNull
        public View getViewForPosition(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? getViewForPosition(i2, false) : (View) invokeI.objValue;
        }

        public void markItemDecorInsetsDirty() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                int size = this.mCachedViews.size();
                for (int i2 = 0; i2 < size; i2++) {
                    LayoutParams layoutParams = (LayoutParams) this.mCachedViews.get(i2).itemView.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.mInsetsDirty = true;
                    }
                }
            }
        }

        public void markKnownViewsInvalid() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
                int size = this.mCachedViews.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ViewHolder viewHolder = this.mCachedViews.get(i2);
                    if (viewHolder != null) {
                        viewHolder.addFlags(6);
                        viewHolder.addChangePayload(null);
                    }
                }
                Adapter adapter = this.this$0.mAdapter;
                if (adapter == null || !adapter.hasStableIds()) {
                    recycleAndClearCachedViews();
                }
            }
        }

        public void offsetPositionRecordsForInsert(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048594, this, i2, i3) == null) {
                int size = this.mCachedViews.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ViewHolder viewHolder = this.mCachedViews.get(i4);
                    if (viewHolder != null && viewHolder.mPosition >= i2) {
                        viewHolder.offsetPosition(i3, true);
                    }
                }
            }
        }

        public void offsetPositionRecordsForMove(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048595, this, i2, i3) == null) {
                if (i2 < i3) {
                    i4 = -1;
                    i6 = i2;
                    i5 = i3;
                } else {
                    i4 = 1;
                    i5 = i2;
                    i6 = i3;
                }
                int size = this.mCachedViews.size();
                for (int i8 = 0; i8 < size; i8++) {
                    ViewHolder viewHolder = this.mCachedViews.get(i8);
                    if (viewHolder != null && (i7 = viewHolder.mPosition) >= i6 && i7 <= i5) {
                        if (i7 == i2) {
                            viewHolder.offsetPosition(i3 - i2, false);
                        } else {
                            viewHolder.offsetPosition(i4, false);
                        }
                    }
                }
            }
        }

        public void offsetPositionRecordsForRemove(int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
                int i4 = i2 + i3;
                for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                    ViewHolder viewHolder = this.mCachedViews.get(size);
                    if (viewHolder != null) {
                        int i5 = viewHolder.mPosition;
                        if (i5 >= i4) {
                            viewHolder.offsetPosition(-i3, z);
                        } else if (i5 >= i2) {
                            viewHolder.addFlags(8);
                            recycleCachedViewAt(size);
                        }
                    }
                }
            }
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048597, this, adapter, adapter2, z) == null) {
                clear();
                getRecycledViewPool().onAdapterChanged(adapter, adapter2, z);
            }
        }

        public void quickRecycleScrapView(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, view) == null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                childViewHolderInt.mScrapContainer = null;
                childViewHolderInt.mInChangeScrap = false;
                childViewHolderInt.clearReturnedFromScrapFlag();
                recycleViewHolderInternal(childViewHolderInt);
            }
        }

        public void recycleAndClearCachedViews() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
                for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                    recycleCachedViewAt(size);
                }
                this.mCachedViews.clear();
                if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                    this.this$0.mPrefetchRegistry.clearPrefetchPositions();
                }
            }
        }

        public void recycleCachedViewAt(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
                addViewHolderToRecycledViewPool(this.mCachedViews.get(i2), true);
                this.mCachedViews.remove(i2);
            }
        }

        public void recycleView(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt.isTmpDetached()) {
                    this.this$0.removeDetachedView(view, false);
                }
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else if (childViewHolderInt.wasReturnedFromScrap()) {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                recycleViewHolderInternal(childViewHolderInt);
                if (this.this$0.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                    return;
                }
                this.this$0.mItemAnimator.endAnimation(childViewHolderInt);
            }
        }

        public void recycleViewHolderInternal(ViewHolder viewHolder) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, viewHolder) == null) {
                boolean z2 = true;
                if (!viewHolder.isScrap() && viewHolder.itemView.getParent() == null) {
                    if (!viewHolder.isTmpDetached()) {
                        if (!viewHolder.shouldIgnore()) {
                            boolean doesTransientStatePreventRecycling = viewHolder.doesTransientStatePreventRecycling();
                            Adapter adapter = this.this$0.mAdapter;
                            if ((adapter != null && doesTransientStatePreventRecycling && adapter.onFailedToRecycleView(viewHolder)) || viewHolder.isRecyclable()) {
                                if (this.mViewCacheMax <= 0 || viewHolder.hasAnyOfTheFlags(PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_GET_CARD_LIST)) {
                                    z = false;
                                } else {
                                    int size = this.mCachedViews.size();
                                    if (size >= this.mViewCacheMax && size > 0) {
                                        recycleCachedViewAt(0);
                                        size--;
                                    }
                                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(viewHolder.mPosition)) {
                                        int i2 = size - 1;
                                        while (i2 >= 0) {
                                            if (!this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(i2).mPosition)) {
                                                break;
                                            }
                                            i2--;
                                        }
                                        size = i2 + 1;
                                    }
                                    this.mCachedViews.add(size, viewHolder);
                                    z = true;
                                }
                                if (!z) {
                                    addViewHolderToRecycledViewPool(viewHolder, true);
                                    r1 = z;
                                    this.this$0.mViewInfoStore.removeViewHolder(viewHolder);
                                    if (r1 && !z2 && doesTransientStatePreventRecycling) {
                                        viewHolder.mOwnerRecyclerView = null;
                                        return;
                                    }
                                    return;
                                }
                                r1 = z;
                            }
                            z2 = false;
                            this.this$0.mViewInfoStore.removeViewHolder(viewHolder);
                            if (r1) {
                                return;
                            }
                            return;
                        }
                        throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.this$0.exceptionLabel());
                    }
                    throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + this.this$0.exceptionLabel());
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(viewHolder.isScrap());
                sb.append(" isAttached:");
                sb.append(viewHolder.itemView.getParent() != null);
                sb.append(this.this$0.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
        }

        public void scrapView(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048603, this, view) == null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !this.this$0.canReuseUpdatedViewHolder(childViewHolderInt)) {
                    if (this.mChangedScrap == null) {
                        this.mChangedScrap = new ArrayList<>();
                    }
                    childViewHolderInt.setScrapContainer(this, true);
                    this.mChangedScrap.add(childViewHolderInt);
                } else if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.this$0.mAdapter.hasStableIds()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.this$0.exceptionLabel());
                } else {
                    childViewHolderInt.setScrapContainer(this, false);
                    this.mAttachedScrap.add(childViewHolderInt);
                }
            }
        }

        public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, recycledViewPool) == null) {
                RecycledViewPool recycledViewPool2 = this.mRecyclerPool;
                if (recycledViewPool2 != null) {
                    recycledViewPool2.detach();
                }
                this.mRecyclerPool = recycledViewPool;
                if (recycledViewPool == null || this.this$0.getAdapter() == null) {
                    return;
                }
                this.mRecyclerPool.attach();
            }
        }

        public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048605, this, viewCacheExtension) == null) {
                this.mViewCacheExtension = viewCacheExtension;
            }
        }

        public void setViewCacheSize(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
                this.mRequestedCacheMax = i2;
                updateViewCacheSize();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x0202  */
        /* JADX WARN: Removed duplicated region for block: B:102:0x0210  */
        /* JADX WARN: Removed duplicated region for block: B:108:0x022c A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0189  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01a6  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01c9  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01d8  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ViewHolder tryGetViewHolderForPositionByDeadline(int i2, boolean z, long j2) {
            InterceptResult invokeCommon;
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j2)})) == null) {
                if (i2 >= 0 && i2 < this.this$0.mState.getItemCount()) {
                    boolean z4 = true;
                    if (this.this$0.mState.isPreLayout()) {
                        viewHolder = getChangedScrapViewForPosition(i2);
                        if (viewHolder != null) {
                            z2 = true;
                            if (viewHolder == null && (viewHolder = getScrapOrHiddenOrCachedHolderForPosition(i2, z)) != null) {
                                if (validateViewHolderForOffsetPosition(viewHolder)) {
                                    if (!z) {
                                        viewHolder.addFlags(4);
                                        if (viewHolder.isScrap()) {
                                            this.this$0.removeDetachedView(viewHolder.itemView, false);
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
                                int findPositionOffset = this.this$0.mAdapterHelper.findPositionOffset(i2);
                                if (findPositionOffset >= 0 && findPositionOffset < this.this$0.mAdapter.getItemCount()) {
                                    int itemViewType = this.this$0.mAdapter.getItemViewType(findPositionOffset);
                                    if (this.this$0.mAdapter.hasStableIds() && (viewHolder = getScrapOrCachedViewForId(this.this$0.mAdapter.getItemId(findPositionOffset), itemViewType, z)) != null) {
                                        viewHolder.mPosition = findPositionOffset;
                                        z2 = true;
                                    }
                                    if (viewHolder == null && (viewCacheExtension = this.mViewCacheExtension) != null && (viewForPositionAndType = viewCacheExtension.getViewForPositionAndType(this, i2, itemViewType)) != null) {
                                        viewHolder = this.this$0.getChildViewHolder(viewForPositionAndType);
                                        if (viewHolder != null) {
                                            if (viewHolder.shouldIgnore()) {
                                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + this.this$0.exceptionLabel());
                                            }
                                        } else {
                                            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + this.this$0.exceptionLabel());
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
                                        long nanoTime = this.this$0.getNanoTime();
                                        if (j2 == Long.MAX_VALUE || this.mRecyclerPool.willCreateInTime(itemViewType, nanoTime, j2)) {
                                            RecyclerView recyclerView = this.this$0;
                                            ViewHolder createViewHolder = recyclerView.mAdapter.createViewHolder(recyclerView, itemViewType);
                                            if (RecyclerView.ALLOW_THREAD_GAP_WORK && (findNestedRecyclerView = RecyclerView.findNestedRecyclerView(createViewHolder.itemView)) != null) {
                                                createViewHolder.mNestedRecyclerView = new WeakReference<>(findNestedRecyclerView);
                                            }
                                            this.mRecyclerPool.factorInCreateTime(itemViewType, this.this$0.getNanoTime() - nanoTime);
                                            viewHolder2 = createViewHolder;
                                            z3 = z2;
                                            if (z3 && !this.this$0.mState.isPreLayout() && viewHolder2.hasAnyOfTheFlags(8192)) {
                                                viewHolder2.setFlags(0, 8192);
                                                if (this.this$0.mState.mRunSimpleAnimations) {
                                                    RecyclerView recyclerView2 = this.this$0;
                                                    this.this$0.recordAnimationInfoIfBouncedHiddenView(viewHolder2, recyclerView2.mItemAnimator.recordPreLayoutInformation(recyclerView2.mState, viewHolder2, ItemAnimator.buildAdapterChangeFlagsForAnimations(viewHolder2) | 4096, viewHolder2.getUnmodifiedPayloads()));
                                                }
                                            }
                                            if (!this.this$0.mState.isPreLayout() && viewHolder2.isBound()) {
                                                viewHolder2.mPreLayoutPosition = i2;
                                            } else if (viewHolder2.isBound() || viewHolder2.needsUpdate() || viewHolder2.isInvalid()) {
                                                tryBindViewHolderByDeadline = tryBindViewHolderByDeadline(viewHolder2, this.this$0.mAdapterHelper.findPositionOffset(i2), i2, j2);
                                                layoutParams = viewHolder2.itemView.getLayoutParams();
                                                if (layoutParams != null) {
                                                    layoutParams2 = (LayoutParams) this.this$0.generateDefaultLayoutParams();
                                                    viewHolder2.itemView.setLayoutParams(layoutParams2);
                                                } else if (!this.this$0.checkLayoutParams(layoutParams)) {
                                                    layoutParams2 = (LayoutParams) this.this$0.generateLayoutParams(layoutParams);
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
                                        return null;
                                    }
                                } else {
                                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i2 + "(offset:" + findPositionOffset + ").state:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
                                }
                            }
                            viewHolder2 = viewHolder;
                            z3 = z2;
                            if (z3) {
                                viewHolder2.setFlags(0, 8192);
                                if (this.this$0.mState.mRunSimpleAnimations) {
                                }
                            }
                            if (!this.this$0.mState.isPreLayout()) {
                            }
                            if (viewHolder2.isBound()) {
                            }
                            tryBindViewHolderByDeadline = tryBindViewHolderByDeadline(viewHolder2, this.this$0.mAdapterHelper.findPositionOffset(i2), i2, j2);
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
                    if (!this.this$0.mState.isPreLayout()) {
                    }
                    if (viewHolder2.isBound()) {
                    }
                    tryBindViewHolderByDeadline = tryBindViewHolderByDeadline(viewHolder2, this.this$0.mAdapterHelper.findPositionOffset(i2), i2, j2);
                    layoutParams = viewHolder2.itemView.getLayoutParams();
                    if (layoutParams != null) {
                    }
                    layoutParams2.mViewHolder = viewHolder2;
                    layoutParams2.mPendingInvalidate = (z3 || !tryBindViewHolderByDeadline) ? false : false;
                    return viewHolder2;
                }
                throw new IndexOutOfBoundsException("Invalid item position " + i2 + "(" + i2 + "). Item count:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
            }
            return (ViewHolder) invokeCommon.objValue;
        }

        public void unscrapView(ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048608, this, viewHolder) == null) {
                if (viewHolder.mInChangeScrap) {
                    this.mChangedScrap.remove(viewHolder);
                } else {
                    this.mAttachedScrap.remove(viewHolder);
                }
                viewHolder.mScrapContainer = null;
                viewHolder.mInChangeScrap = false;
                viewHolder.clearReturnedFromScrapFlag();
            }
        }

        public void updateViewCacheSize() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
                LayoutManager layoutManager = this.this$0.mLayout;
                this.mViewCacheMax = this.mRequestedCacheMax + (layoutManager != null ? layoutManager.mPrefetchMaxCountObserved : 0);
                for (int size = this.mCachedViews.size() - 1; size >= 0 && this.mCachedViews.size() > this.mViewCacheMax; size--) {
                    recycleCachedViewAt(size);
                }
            }
        }

        public boolean validateViewHolderForOffsetPosition(ViewHolder viewHolder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, viewHolder)) == null) {
                if (viewHolder.isRemoved()) {
                    return this.this$0.mState.isPreLayout();
                }
                int i2 = viewHolder.mPosition;
                if (i2 >= 0 && i2 < this.this$0.mAdapter.getItemCount()) {
                    if (this.this$0.mState.isPreLayout() || this.this$0.mAdapter.getItemViewType(viewHolder.mPosition) == viewHolder.getItemViewType()) {
                        return !this.this$0.mAdapter.hasStableIds() || viewHolder.getItemId() == this.this$0.mAdapter.getItemId(viewHolder.mPosition);
                    }
                    return false;
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder + this.this$0.exceptionLabel());
            }
            return invokeL.booleanValue;
        }

        public void viewRangeUpdate(int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048611, this, i2, i3) == null) {
                int i5 = i3 + i2;
                for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                    ViewHolder viewHolder = this.mCachedViews.get(size);
                    if (viewHolder != null && (i4 = viewHolder.mPosition) >= i2 && i4 < i5) {
                        viewHolder.addFlags(2);
                        recycleCachedViewAt(size);
                    }
                }
            }
        }

        public View getViewForPosition(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? tryGetViewHolderForPositionByDeadline(i2, z, Long.MAX_VALUE).itemView : (View) invokeCommon.objValue;
        }

        private void invalidateDisplayListInt(ViewGroup viewGroup, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65538, this, viewGroup, z) == null) {
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    if (childAt instanceof ViewGroup) {
                        invalidateDisplayListInt((ViewGroup) childAt, true);
                    }
                }
                if (z) {
                    if (viewGroup.getVisibility() == 4) {
                        viewGroup.setVisibility(0);
                        viewGroup.setVisibility(4);
                        return;
                    }
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface RecyclerListener {
        void onViewRecycled(@NonNull ViewHolder viewHolder);
    }

    /* loaded from: classes.dex */
    public class RecyclerViewDataObserver extends AdapterDataObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecyclerView this$0;

        public RecyclerViewDataObserver(RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.assertNotInLayoutOrScroll(null);
                RecyclerView recyclerView = this.this$0;
                recyclerView.mState.mStructureChanged = true;
                recyclerView.processDataSetCompletelyChanged(true);
                if (this.this$0.mAdapterHelper.hasPendingUpdates()) {
                    return;
                }
                this.this$0.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj) == null) {
                this.this$0.assertNotInLayoutOrScroll(null);
                if (this.this$0.mAdapterHelper.onItemRangeChanged(i2, i3, obj)) {
                    triggerUpdateProcessor();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                this.this$0.assertNotInLayoutOrScroll(null);
                if (this.this$0.mAdapterHelper.onItemRangeInserted(i2, i3)) {
                    triggerUpdateProcessor();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048579, this, i2, i3, i4) == null) {
                this.this$0.assertNotInLayoutOrScroll(null);
                if (this.this$0.mAdapterHelper.onItemRangeMoved(i2, i3, i4)) {
                    triggerUpdateProcessor();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
                this.this$0.assertNotInLayoutOrScroll(null);
                if (this.this$0.mAdapterHelper.onItemRangeRemoved(i2, i3)) {
                    triggerUpdateProcessor();
                }
            }
        }

        public void triggerUpdateProcessor() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                    RecyclerView recyclerView = this.this$0;
                    if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                        ViewCompat.postOnAnimation(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                        return;
                    }
                }
                RecyclerView recyclerView2 = this.this$0;
                recyclerView2.mAdapterUpdateDuringMeasure = true;
                recyclerView2.requestLayout();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SimpleOnItemTouchListener() {
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

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, recyclerView, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, recyclerView, motionEvent) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SmoothScroller {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LayoutManager mLayoutManager;
        public boolean mPendingInitialRun;
        public RecyclerView mRecyclerView;
        public final Action mRecyclingAction;
        public boolean mRunning;
        public boolean mStarted;
        public int mTargetPosition;
        public View mTargetView;

        /* loaded from: classes.dex */
        public static class Action {
            public static /* synthetic */ Interceptable $ic = null;
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean mChanged;
            public int mConsecutiveUpdates;
            public int mDuration;
            public int mDx;
            public int mDy;
            public Interpolator mInterpolator;
            public int mJumpToPosition;

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Action(@Px int i2, @Px int i3) {
                this(i2, i3, Integer.MIN_VALUE, null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (Interpolator) objArr2[3]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            private void validate() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                    if (this.mInterpolator != null && this.mDuration < 1) {
                        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                    }
                    if (this.mDuration < 1) {
                        throw new IllegalStateException("Scroll duration must be a positive number");
                    }
                }
            }

            public int getDuration() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDuration : invokeV.intValue;
            }

            @Px
            public int getDx() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDx : invokeV.intValue;
            }

            @Px
            public int getDy() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDy : invokeV.intValue;
            }

            @Nullable
            public Interpolator getInterpolator() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mInterpolator : (Interpolator) invokeV.objValue;
            }

            public boolean hasJumpTarget() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mJumpToPosition >= 0 : invokeV.booleanValue;
            }

            public void jumpTo(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                    this.mJumpToPosition = i2;
                }
            }

            public void runIfNecessary(RecyclerView recyclerView) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048582, this, recyclerView) == null) {
                    int i2 = this.mJumpToPosition;
                    if (i2 >= 0) {
                        this.mJumpToPosition = -1;
                        recyclerView.jumpToPositionForSmoothScroller(i2);
                        this.mChanged = false;
                    } else if (this.mChanged) {
                        validate();
                        recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                        this.mConsecutiveUpdates++;
                        this.mChanged = false;
                    } else {
                        this.mConsecutiveUpdates = 0;
                    }
                }
            }

            public void setDuration(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                    this.mChanged = true;
                    this.mDuration = i2;
                }
            }

            public void setDx(@Px int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                    this.mChanged = true;
                    this.mDx = i2;
                }
            }

            public void setDy(@Px int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
                    this.mChanged = true;
                    this.mDy = i2;
                }
            }

            public void setInterpolator(@Nullable Interpolator interpolator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048586, this, interpolator) == null) {
                    this.mChanged = true;
                    this.mInterpolator = interpolator;
                }
            }

            public void update(@Px int i2, @Px int i3, int i4, @Nullable Interpolator interpolator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), interpolator}) == null) {
                    this.mDx = i2;
                    this.mDy = i3;
                    this.mDuration = i4;
                    this.mInterpolator = interpolator;
                    this.mChanged = true;
                }
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Action(@Px int i2, @Px int i3, int i4) {
                this(i2, i3, i4, null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (Interpolator) objArr2[3]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
            }

            public Action(@Px int i2, @Px int i3, int i4, @Nullable Interpolator interpolator) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), interpolator};
                    interceptable.invokeUnInit(65538, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65538, newInitContext);
                        return;
                    }
                }
                this.mJumpToPosition = -1;
                this.mChanged = false;
                this.mConsecutiveUpdates = 0;
                this.mDx = i2;
                this.mDy = i3;
                this.mDuration = i4;
                this.mInterpolator = interpolator;
            }
        }

        /* loaded from: classes.dex */
        public interface ScrollVectorProvider {
            @Nullable
            PointF computeScrollVectorForPosition(int i2);
        }

        public SmoothScroller() {
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
            this.mTargetPosition = -1;
            this.mRecyclingAction = new Action(0, 0);
        }

        @Nullable
        public PointF computeScrollVectorForPosition(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                LayoutManager layoutManager = getLayoutManager();
                if (layoutManager instanceof ScrollVectorProvider) {
                    return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i2);
                }
                String str = "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName();
                return null;
            }
            return (PointF) invokeI.objValue;
        }

        public View findViewByPosition(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.mRecyclerView.mLayout.findViewByPosition(i2) : (View) invokeI.objValue;
        }

        public int getChildCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRecyclerView.mLayout.getChildCount() : invokeV.intValue;
        }

        public int getChildPosition(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) ? this.mRecyclerView.getChildLayoutPosition(view) : invokeL.intValue;
        }

        @Nullable
        public LayoutManager getLayoutManager() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mLayoutManager : (LayoutManager) invokeV.objValue;
        }

        public int getTargetPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTargetPosition : invokeV.intValue;
        }

        @Deprecated
        public void instantScrollToPosition(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.mRecyclerView.scrollToPosition(i2);
            }
        }

        public boolean isPendingInitialRun() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPendingInitialRun : invokeV.booleanValue;
        }

        public boolean isRunning() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mRunning : invokeV.booleanValue;
        }

        public void normalize(@NonNull PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, pointF) == null) {
                float f2 = pointF.x;
                float f3 = pointF.y;
                float sqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
                pointF.x /= sqrt;
                pointF.y /= sqrt;
            }
        }

        public void onAnimation(int i2, int i3) {
            PointF computeScrollVectorForPosition;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (this.mTargetPosition == -1 || recyclerView == null) {
                    stop();
                }
                if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null && (computeScrollVectorForPosition.x != 0.0f || computeScrollVectorForPosition.y != 0.0f)) {
                    recyclerView.scrollStep((int) Math.signum(computeScrollVectorForPosition.x), (int) Math.signum(computeScrollVectorForPosition.y), null);
                }
                this.mPendingInitialRun = false;
                View view = this.mTargetView;
                if (view != null) {
                    if (getChildPosition(view) == this.mTargetPosition) {
                        onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                        this.mRecyclingAction.runIfNecessary(recyclerView);
                        stop();
                    } else {
                        this.mTargetView = null;
                    }
                }
                if (this.mRunning) {
                    onSeekTargetStep(i2, i3, recyclerView.mState, this.mRecyclingAction);
                    boolean hasJumpTarget = this.mRecyclingAction.hasJumpTarget();
                    this.mRecyclingAction.runIfNecessary(recyclerView);
                    if (hasJumpTarget && this.mRunning) {
                        this.mPendingInitialRun = true;
                        recyclerView.mViewFlinger.postOnAnimation();
                    }
                }
            }
        }

        public void onChildAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        public abstract void onSeekTargetStep(@Px int i2, @Px int i3, @NonNull State state, @NonNull Action action);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(@NonNull View view, @NonNull State state, @NonNull Action action);

        public void setTargetPosition(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
                this.mTargetPosition = i2;
            }
        }

        public void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, recyclerView, layoutManager) == null) {
                recyclerView.mViewFlinger.stop();
                if (this.mStarted) {
                    String str = "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.";
                }
                this.mRecyclerView = recyclerView;
                this.mLayoutManager = layoutManager;
                int i2 = this.mTargetPosition;
                if (i2 != -1) {
                    recyclerView.mState.mTargetPosition = i2;
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

        public final void stop() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.mRunning) {
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
        }
    }

    /* loaded from: classes.dex */
    public static class State {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int STEP_ANIMATIONS = 4;
        public static final int STEP_LAYOUT = 2;
        public static final int STEP_START = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<Object> mData;
        public int mDeletedInvisibleItemCountSincePreviousLayout;
        public long mFocusedItemId;
        public int mFocusedItemPosition;
        public int mFocusedSubChildId;
        public boolean mInPreLayout;
        public boolean mIsMeasuring;
        public int mItemCount;
        public int mLayoutStep;
        public int mPreviousLayoutItemCount;
        public int mRemainingScrollHorizontal;
        public int mRemainingScrollVertical;
        public boolean mRunPredictiveAnimations;
        public boolean mRunSimpleAnimations;
        public boolean mStructureChanged;
        public int mTargetPosition;
        public boolean mTrackOldChangeHolders;

        public State() {
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
            this.mTargetPosition = -1;
            this.mPreviousLayoutItemCount = 0;
            this.mDeletedInvisibleItemCountSincePreviousLayout = 0;
            this.mLayoutStep = 1;
            this.mItemCount = 0;
            this.mStructureChanged = false;
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
            this.mRunSimpleAnimations = false;
            this.mRunPredictiveAnimations = false;
        }

        public void assertLayoutStep(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && (this.mLayoutStep & i2) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
            }
        }

        public boolean didStructureChange() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mStructureChanged : invokeV.booleanValue;
        }

        public <T> T get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                SparseArray<Object> sparseArray = this.mData;
                if (sparseArray == null) {
                    return null;
                }
                return (T) sparseArray.get(i2);
            }
            return (T) invokeI.objValue;
        }

        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mInPreLayout ? this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout : this.mItemCount : invokeV.intValue;
        }

        public int getRemainingScrollHorizontal() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRemainingScrollHorizontal : invokeV.intValue;
        }

        public int getRemainingScrollVertical() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRemainingScrollVertical : invokeV.intValue;
        }

        public int getTargetScrollPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mTargetPosition : invokeV.intValue;
        }

        public boolean hasTargetScrollPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mTargetPosition != -1 : invokeV.booleanValue;
        }

        public boolean isMeasuring() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mIsMeasuring : invokeV.booleanValue;
        }

        public boolean isPreLayout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mInPreLayout : invokeV.booleanValue;
        }

        public void prepareForNestedPrefetch(Adapter adapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, adapter) == null) {
                this.mLayoutStep = 1;
                this.mItemCount = adapter.getItemCount();
                this.mInPreLayout = false;
                this.mTrackOldChangeHolders = false;
                this.mIsMeasuring = false;
            }
        }

        public void put(int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048587, this, i2, obj) == null) {
                if (this.mData == null) {
                    this.mData = new SparseArray<>();
                }
                this.mData.put(i2, obj);
            }
        }

        public void remove(int i2) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (sparseArray = this.mData) == null) {
                return;
            }
            sparseArray.remove(i2);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mIsMeasuring=" + this.mIsMeasuring + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public boolean willRunPredictiveAnimations() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mRunPredictiveAnimations : invokeV.booleanValue;
        }

        public boolean willRunSimpleAnimations() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mRunSimpleAnimations : invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewCacheExtension {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ViewCacheExtension() {
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

        @Nullable
        public abstract View getViewForPositionAndType(@NonNull Recycler recycler, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public class ViewFlinger implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mEatRunOnAnimationRequest;
        public Interpolator mInterpolator;
        public int mLastFlingX;
        public int mLastFlingY;
        public OverScroller mOverScroller;
        public boolean mReSchedulePostAnimationCallback;
        public final /* synthetic */ RecyclerView this$0;

        public ViewFlinger(RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = recyclerView;
            this.mInterpolator = RecyclerView.sQuinticInterpolator;
            this.mEatRunOnAnimationRequest = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mOverScroller = new OverScroller(recyclerView.getContext(), RecyclerView.sQuinticInterpolator);
        }

        private int computeScrollDuration(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            int i6;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65537, this, i2, i3, i4, i5)) == null) {
                int abs = Math.abs(i2);
                int abs2 = Math.abs(i3);
                boolean z = abs > abs2;
                int sqrt = (int) Math.sqrt((i4 * i4) + (i5 * i5));
                int sqrt2 = (int) Math.sqrt((i2 * i2) + (i3 * i3));
                RecyclerView recyclerView = this.this$0;
                int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
                int i7 = width / 2;
                float f2 = width;
                float f3 = i7;
                float distanceInfluenceForSnapDuration = f3 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (sqrt2 * 1.0f) / f2)) * f3);
                if (sqrt > 0) {
                    i6 = Math.round(Math.abs(distanceInfluenceForSnapDuration / sqrt) * 1000.0f) * 4;
                } else {
                    if (!z) {
                        abs = abs2;
                    }
                    i6 = (int) (((abs / f2) + 1.0f) * 300.0f);
                }
                return Math.min(i6, 2000);
            }
            return invokeIIII.intValue;
        }

        private float distanceInfluenceForSnapDuration(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(65538, this, f2)) == null) ? (float) Math.sin((f2 - 0.5f) * 0.47123894f) : invokeF.floatValue;
        }

        private void internalPostOnAnimation() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                this.this$0.removeCallbacks(this);
                ViewCompat.postOnAnimation(this.this$0, this);
            }
        }

        public void fling(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.this$0.setScrollState(2);
                this.mLastFlingY = 0;
                this.mLastFlingX = 0;
                Interpolator interpolator = this.mInterpolator;
                Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
                if (interpolator != interpolator2) {
                    this.mInterpolator = interpolator2;
                    this.mOverScroller = new OverScroller(this.this$0.getContext(), RecyclerView.sQuinticInterpolator);
                }
                this.mOverScroller.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                postOnAnimation();
            }
        }

        public void postOnAnimation() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.mEatRunOnAnimationRequest) {
                    this.mReSchedulePostAnimationCallback = true;
                } else {
                    internalPostOnAnimation();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                RecyclerView recyclerView = this.this$0;
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
                    RecyclerView recyclerView2 = this.this$0;
                    int[] iArr = recyclerView2.mReusableIntPair;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    if (recyclerView2.dispatchNestedPreScroll(i4, i5, iArr, null, 1)) {
                        int[] iArr2 = this.this$0.mReusableIntPair;
                        i4 -= iArr2[0];
                        i5 -= iArr2[1];
                    }
                    if (this.this$0.getOverScrollMode() != 2) {
                        this.this$0.considerReleasingGlowsOnScroll(i4, i5);
                    }
                    RecyclerView recyclerView3 = this.this$0;
                    if (recyclerView3.mAdapter != null) {
                        int[] iArr3 = recyclerView3.mReusableIntPair;
                        iArr3[0] = 0;
                        iArr3[1] = 0;
                        recyclerView3.scrollStep(i4, i5, iArr3);
                        RecyclerView recyclerView4 = this.this$0;
                        int[] iArr4 = recyclerView4.mReusableIntPair;
                        i3 = iArr4[0];
                        i2 = iArr4[1];
                        i4 -= i3;
                        i5 -= i2;
                        SmoothScroller smoothScroller = recyclerView4.mLayout.mSmoothScroller;
                        if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                            int itemCount = this.this$0.mState.getItemCount();
                            if (itemCount == 0) {
                                smoothScroller.stop();
                            } else if (smoothScroller.getTargetPosition() >= itemCount) {
                                smoothScroller.setTargetPosition(itemCount - 1);
                                smoothScroller.onAnimation(i3, i2);
                            } else {
                                smoothScroller.onAnimation(i3, i2);
                            }
                        }
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    if (!this.this$0.mItemDecorations.isEmpty()) {
                        this.this$0.invalidate();
                    }
                    RecyclerView recyclerView5 = this.this$0;
                    int[] iArr5 = recyclerView5.mReusableIntPair;
                    iArr5[0] = 0;
                    iArr5[1] = 0;
                    recyclerView5.dispatchNestedScroll(i3, i2, i4, i5, null, 1, iArr5);
                    int[] iArr6 = this.this$0.mReusableIntPair;
                    int i6 = i4 - iArr6[0];
                    int i7 = i5 - iArr6[1];
                    if (i3 != 0 || i2 != 0) {
                        this.this$0.dispatchOnScrolled(i3, i2);
                    }
                    if (!this.this$0.awakenScrollBars()) {
                        this.this$0.invalidate();
                    }
                    boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i6 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i7 != 0));
                    SmoothScroller smoothScroller2 = this.this$0.mLayout.mSmoothScroller;
                    if (!(smoothScroller2 != null && smoothScroller2.isPendingInitialRun()) && z) {
                        if (this.this$0.getOverScrollMode() != 2) {
                            int currVelocity = (int) overScroller.getCurrVelocity();
                            int i8 = i6 < 0 ? -currVelocity : i6 > 0 ? currVelocity : 0;
                            if (i7 < 0) {
                                currVelocity = -currVelocity;
                            } else if (i7 <= 0) {
                                currVelocity = 0;
                            }
                            this.this$0.absorbGlows(i8, currVelocity);
                        }
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                            this.this$0.mPrefetchRegistry.clearPrefetchPositions();
                        }
                    } else {
                        postOnAnimation();
                        RecyclerView recyclerView6 = this.this$0;
                        GapWorker gapWorker = recyclerView6.mGapWorker;
                        if (gapWorker != null) {
                            gapWorker.postFromTraversal(recyclerView6, i3, i2);
                        }
                    }
                }
                SmoothScroller smoothScroller3 = this.this$0.mLayout.mSmoothScroller;
                if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
                    smoothScroller3.onAnimation(0, 0);
                }
                this.mEatRunOnAnimationRequest = false;
                if (this.mReSchedulePostAnimationCallback) {
                    internalPostOnAnimation();
                    return;
                }
                this.this$0.setScrollState(0);
                this.this$0.stopNestedScroll(1);
            }
        }

        public void smoothScrollBy(int i2, int i3, int i4, @Nullable Interpolator interpolator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), interpolator}) == null) {
                if (i4 == Integer.MIN_VALUE) {
                    i4 = computeScrollDuration(i2, i3, 0, 0);
                }
                int i5 = i4;
                if (interpolator == null) {
                    interpolator = RecyclerView.sQuinticInterpolator;
                }
                if (this.mInterpolator != interpolator) {
                    this.mInterpolator = interpolator;
                    this.mOverScroller = new OverScroller(this.this$0.getContext(), interpolator);
                }
                this.mLastFlingY = 0;
                this.mLastFlingX = 0;
                this.this$0.setScrollState(2);
                this.mOverScroller.startScroll(0, 0, i2, i3, i5);
                if (Build.VERSION.SDK_INT < 23) {
                    this.mOverScroller.computeScrollOffset();
                }
                postOnAnimation();
            }
        }

        public void stop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.this$0.removeCallbacks(this);
                this.mOverScroller.abortAnimation();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewHolder {
        public static /* synthetic */ Interceptable $ic = null;
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
        public static final List<Object> FULLUPDATE_PAYLOADS;
        public static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final View itemView;
        public int mFlags;
        public boolean mInChangeScrap;
        public int mIsRecyclableCount;
        public long mItemId;
        public int mItemViewType;
        public WeakReference<RecyclerView> mNestedRecyclerView;
        public int mOldPosition;
        public RecyclerView mOwnerRecyclerView;
        public List<Object> mPayloads;
        @VisibleForTesting
        public int mPendingAccessibilityState;
        public int mPosition;
        public int mPreLayoutPosition;
        public Recycler mScrapContainer;
        public ViewHolder mShadowedHolder;
        public ViewHolder mShadowingHolder;
        public List<Object> mUnmodifiedPayloads;
        public int mWasImportantForAccessibilityBeforeHidden;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(622155492, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(622155492, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;");
                    return;
                }
            }
            FULLUPDATE_PAYLOADS = Collections.emptyList();
        }

        public ViewHolder(@NonNull View view) {
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
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mItemViewType = -1;
            this.mPreLayoutPosition = -1;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            this.mPayloads = null;
            this.mUnmodifiedPayloads = null;
            this.mIsRecyclableCount = 0;
            this.mScrapContainer = null;
            this.mInChangeScrap = false;
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        public void addChangePayload(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj == null) {
                    addFlags(1024);
                } else if ((1024 & this.mFlags) == 0) {
                    createPayloadsIfNeeded();
                    this.mPayloads.add(obj);
                }
            }
        }

        public void addFlags(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.mFlags = i2 | this.mFlags;
            }
        }

        public void clearOldPosition() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mOldPosition = -1;
                this.mPreLayoutPosition = -1;
            }
        }

        public void clearPayload() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                List<Object> list = this.mPayloads;
                if (list != null) {
                    list.clear();
                }
                this.mFlags &= -1025;
            }
        }

        public void clearReturnedFromScrapFlag() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.mFlags &= -33;
            }
        }

        public void clearTmpDetachFlag() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.mFlags &= -257;
            }
        }

        public boolean doesTransientStatePreventRecycling() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.mFlags & 16) == 0 && ViewCompat.hasTransientState(this.itemView) : invokeV.booleanValue;
        }

        public void flagRemovedAndOffsetPosition(int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
                addFlags(8);
                offsetPosition(i3, z);
                this.mPosition = i2;
            }
        }

        public final int getAdapterPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                RecyclerView recyclerView = this.mOwnerRecyclerView;
                if (recyclerView == null) {
                    return -1;
                }
                return recyclerView.getAdapterPositionFor(this);
            }
            return invokeV.intValue;
        }

        public final long getItemId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mItemId : invokeV.longValue;
        }

        public final int getItemViewType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mItemViewType : invokeV.intValue;
        }

        public final int getLayoutPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                int i2 = this.mPreLayoutPosition;
                return i2 == -1 ? this.mPosition : i2;
            }
            return invokeV.intValue;
        }

        public final int getOldPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mOldPosition : invokeV.intValue;
        }

        @Deprecated
        public final int getPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                int i2 = this.mPreLayoutPosition;
                return i2 == -1 ? this.mPosition : i2;
            }
            return invokeV.intValue;
        }

        public List<Object> getUnmodifiedPayloads() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if ((this.mFlags & 1024) == 0) {
                    List<Object> list = this.mPayloads;
                    if (list != null && list.size() != 0) {
                        return this.mUnmodifiedPayloads;
                    }
                    return FULLUPDATE_PAYLOADS;
                }
                return FULLUPDATE_PAYLOADS;
            }
            return (List) invokeV.objValue;
        }

        public boolean hasAnyOfTheFlags(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? (i2 & this.mFlags) != 0 : invokeI.booleanValue;
        }

        public boolean isAdapterPositionUnknown() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.mFlags & 512) != 0 || isInvalid() : invokeV.booleanValue;
        }

        public boolean isAttachedToTransitionOverlay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true : invokeV.booleanValue;
        }

        public boolean isBound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.mFlags & 1) != 0 : invokeV.booleanValue;
        }

        public boolean isInvalid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.mFlags & 4) != 0 : invokeV.booleanValue;
        }

        public final boolean isRecyclable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.mFlags & 16) == 0 && !ViewCompat.hasTransientState(this.itemView) : invokeV.booleanValue;
        }

        public boolean isRemoved() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.mFlags & 8) != 0 : invokeV.booleanValue;
        }

        public boolean isScrap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mScrapContainer != null : invokeV.booleanValue;
        }

        public boolean isTmpDetached() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.mFlags & 256) != 0 : invokeV.booleanValue;
        }

        public boolean isUpdated() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? (this.mFlags & 2) != 0 : invokeV.booleanValue;
        }

        public boolean needsUpdate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.mFlags & 2) != 0 : invokeV.booleanValue;
        }

        public void offsetPosition(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (this.mOldPosition == -1) {
                    this.mOldPosition = this.mPosition;
                }
                if (this.mPreLayoutPosition == -1) {
                    this.mPreLayoutPosition = this.mPosition;
                }
                if (z) {
                    this.mPreLayoutPosition += i2;
                }
                this.mPosition += i2;
                if (this.itemView.getLayoutParams() != null) {
                    ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
                }
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048603, this, recyclerView) == null) {
                int i2 = this.mPendingAccessibilityState;
                if (i2 != -1) {
                    this.mWasImportantForAccessibilityBeforeHidden = i2;
                } else {
                    this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
                }
                recyclerView.setChildImportantForAccessibilityInternal(this, 4);
            }
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, recyclerView) == null) {
                recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
                this.mWasImportantForAccessibilityBeforeHidden = 0;
            }
        }

        public void resetInternal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
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
        }

        public void saveOldPosition() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public void setFlags(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048607, this, i2, i3) == null) {
                this.mFlags = (i2 & i3) | (this.mFlags & (~i3));
            }
        }

        public final void setIsRecyclable(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
                int i2 = this.mIsRecyclableCount;
                int i3 = z ? i2 - 1 : i2 + 1;
                this.mIsRecyclableCount = i3;
                if (i3 < 0) {
                    this.mIsRecyclableCount = 0;
                    String str = "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this;
                } else if (!z && i3 == 1) {
                    this.mFlags |= 16;
                } else if (z && this.mIsRecyclableCount == 0) {
                    this.mFlags &= -17;
                }
            }
        }

        public void setScrapContainer(Recycler recycler, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048609, this, recycler, z) == null) {
                this.mScrapContainer = recycler;
                this.mInChangeScrap = z;
            }
        }

        public boolean shouldBeKeptAsChild() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? (this.mFlags & 16) != 0 : invokeV.booleanValue;
        }

        public boolean shouldIgnore() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? (this.mFlags & 128) != 0 : invokeV.booleanValue;
        }

        public void stopIgnoring() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
                this.mFlags &= -129;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
                String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
                StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
                if (isScrap()) {
                    sb.append(" scrap ");
                    sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
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
            return (String) invokeV.objValue;
        }

        public void unScrap() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
                this.mScrapContainer.unscrapView(this);
            }
        }

        public boolean wasReturnedFromScrap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? (this.mFlags & 32) != 0 : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1088820989, "Landroidx/recyclerview/widget/RecyclerView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1088820989, "Landroidx/recyclerview/widget/RecyclerView;");
                return;
            }
        }
        NESTED_SCROLLING_ATTRS = new int[]{16843830};
        int i2 = Build.VERSION.SDK_INT;
        FORCE_INVALIDATE_DISPLAY_LIST = i2 == 18 || i2 == 19 || i2 == 20;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = Build.VERSION.SDK_INT >= 23;
        POST_UPDATES_ON_ANIMATION = Build.VERSION.SDK_INT >= 16;
        ALLOW_THREAD_GAP_WORK = Build.VERSION.SDK_INT >= 21;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = Build.VERSION.SDK_INT <= 15;
        IGNORE_DETACHED_FOCUSED_CHILD = Build.VERSION.SDK_INT <= 15;
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.RecyclerView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                InterceptResult invokeF;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeF = interceptable2.invokeF(1048576, this, f2)) == null) {
                    float f3 = f2 - 1.0f;
                    return (f3 * f3 * f3 * f3 * f3) + 1.0f;
                }
                return invokeF.floatValue;
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecyclerView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, viewHolder) == null) {
            View view = viewHolder.itemView;
            boolean z = view.getParent() == this;
            this.mRecycler.unscrapView(getChildViewHolder(view));
            if (viewHolder.isTmpDetached()) {
                this.mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
            } else if (!z) {
                this.mChildHelper.addView(view, true);
            } else {
                this.mChildHelper.hide(view);
            }
        }
    }

    private void animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
    }

    private void cancelScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            resetScroll();
            setScrollState(0);
        }
    }

    public static void clearNestedRecyclerViewIfNotNested(@NonNull ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, viewHolder) == null) || (weakReference = viewHolder.mNestedRecyclerView) == null) {
            return;
        }
        RecyclerView recyclerView = weakReference.get();
        while (recyclerView != null) {
            if (recyclerView == viewHolder.itemView) {
                return;
            }
            ViewParent parent = recyclerView.getParent();
            recyclerView = parent instanceof View ? (View) parent : null;
        }
        viewHolder.mNestedRecyclerView = null;
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor constructor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{context, str, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || str == null) {
            return;
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            return;
        }
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
                objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            } catch (NoSuchMethodException e2) {
                try {
                    constructor = asSubclass.getConstructor(new Class[0]);
                } catch (NoSuchMethodException e3) {
                    e3.initCause(e2);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e3);
                }
            }
            constructor.setAccessible(true);
            setLayoutManager((LayoutManager) constructor.newInstance(objArr));
        } catch (ClassCastException e4) {
            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e4);
        } catch (ClassNotFoundException e5) {
            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e5);
        } catch (IllegalAccessException e6) {
            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e6);
        } catch (InstantiationException e7) {
            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
        } catch (InvocationTargetException e8) {
            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e8);
        }
    }

    private boolean didChildRangeChange(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65549, this, i2, i3)) == null) {
            findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
            int[] iArr = this.mMinMaxLayoutPositions;
            return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
        }
        return invokeII.booleanValue;
    }

    private void dispatchContentChangedIfNecessary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            int i2 = this.mEatenAccessibilityChangeFlags;
            this.mEatenAccessibilityChangeFlags = 0;
            if (i2 == 0 || !isAccessibilityEnabled()) {
                return;
            }
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.setContentChangeTypes(obtain, i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void dispatchLayoutStep1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
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
                for (int i2 = 0; i2 < childCount; i2++) {
                    ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i2));
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
                for (int i3 = 0; i3 < this.mChildHelper.getChildCount(); i3++) {
                    ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
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
    }

    private void dispatchLayoutStep2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
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
            state2.mRunSimpleAnimations = state2.mRunSimpleAnimations && this.mItemAnimator != null;
            this.mState.mLayoutStep = 4;
            onExitLayoutOrScroll();
            stopInterceptRequestLayout(false);
        }
    }

    private void dispatchLayoutStep3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
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
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, motionEvent)) == null) {
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
        return invokeL.booleanValue;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            int size = this.mOnItemTouchListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i2);
                if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                    this.mInterceptingOnItemTouchListener = onItemTouchListener;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, iArr) == null) {
            int childCount = this.mChildHelper.getChildCount();
            if (childCount == 0) {
                iArr[0] = -1;
                iArr[1] = -1;
                return;
            }
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            for (int i4 = 0; i4 < childCount; i4++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i4));
                if (!childViewHolderInt.shouldIgnore()) {
                    int layoutPosition = childViewHolderInt.getLayoutPosition();
                    if (layoutPosition < i2) {
                        i2 = layoutPosition;
                    }
                    if (layoutPosition > i3) {
                        i3 = layoutPosition;
                    }
                }
            }
            iArr[0] = i2;
            iArr[1] = i3;
        }
    }

    @Nullable
    public static RecyclerView findNestedRecyclerView(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, view)) == null) {
            if (view instanceof ViewGroup) {
                if (view instanceof RecyclerView) {
                    return (RecyclerView) view;
                }
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i2));
                    if (findNestedRecyclerView != null) {
                        return findNestedRecyclerView;
                    }
                }
                return null;
            }
            return null;
        }
        return (RecyclerView) invokeL.objValue;
    }

    @Nullable
    private View findNextViewToFocus() {
        InterceptResult invokeV;
        ViewHolder findViewHolderForAdapterPosition;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65558, this)) != null) {
            return (View) invokeV.objValue;
        }
        int i2 = this.mState.mFocusedItemPosition;
        if (i2 == -1) {
            i2 = 0;
        }
        int itemCount = this.mState.getItemCount();
        for (int i3 = i2; i3 < itemCount; i3++) {
            ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(itemCount, i2);
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

    public static ViewHolder getChildViewHolderInt(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, view)) == null) {
            if (view == null) {
                return null;
            }
            return ((LayoutParams) view.getLayoutParams()).mViewHolder;
        }
        return (ViewHolder) invokeL.objValue;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, view, rect) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect2 = layoutParams.mDecorInsets;
            rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }
    }

    private int getDeepestFocusedViewWithId(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, this, view)) == null) {
            int id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    id = view.getId();
                }
            }
            return id;
        }
        return invokeL.intValue;
    }

    private String getFullClassName(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, this, context, str)) == null) {
            if (str.charAt(0) == '.') {
                return context.getPackageName() + str;
            } else if (str.contains(".")) {
                return str;
            } else {
                return RecyclerView.class.getPackage().getName() + '.' + str;
            }
        }
        return (String) invokeLL.objValue;
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            if (this.mScrollingChildHelper == null) {
                this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
            }
            return this.mScrollingChildHelper;
        }
        return (NestedScrollingChildHelper) invokeV.objValue;
    }

    private void handleMissingPreInfoForChangeError(long j2, ViewHolder viewHolder, ViewHolder viewHolder2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, this, new Object[]{Long.valueOf(j2), viewHolder, viewHolder2}) == null) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i2));
                if (childViewHolderInt != viewHolder && getChangedHolderKey(childViewHolderInt) == j2) {
                    Adapter adapter = this.mAdapter;
                    if (adapter != null && adapter.hasStableIds()) {
                        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
                    }
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
                }
            }
            String str = "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + exceptionLabel();
        }
    }

    private boolean hasUpdatedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i2));
                if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65566, this) == null) && ViewCompat.getImportantForAutofill(this) == 0) {
            ViewCompat.setImportantForAutofill(this, 8);
        }
    }

    private void initChildrenHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            this.mChildHelper = new ChildHelper(new ChildHelper.Callback(this) { // from class: androidx.recyclerview.widget.RecyclerView.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RecyclerView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.recyclerview.widget.ChildHelper.Callback
                public void addView(View view, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) {
                        this.this$0.addView(view, i2);
                        this.this$0.dispatchChildAttached(view);
                    }
                }

                @Override // androidx.recyclerview.widget.ChildHelper.Callback
                public void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2, layoutParams) == null) {
                        ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                        if (childViewHolderInt != null) {
                            if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                                throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + this.this$0.exceptionLabel());
                            }
                            childViewHolderInt.clearTmpDetachFlag();
                        }
                        this.this$0.attachViewToParent(view, i2, layoutParams);
                    }
                }

                @Override // androidx.recyclerview.widget.ChildHelper.Callback
                public void detachViewFromParent(int i2) {
                    ViewHolder childViewHolderInt;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                        View childAt = getChildAt(i2);
                        if (childAt != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) != null) {
                            if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                                throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + this.this$0.exceptionLabel());
                            }
                            childViewHolderInt.addFlags(256);
                        }
                        this.this$0.detachViewFromParent(i2);
                    }
                }

                @Override // androidx.recyclerview.widget.ChildHelper.Callback
                public View getChildAt(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048579, this, i2)) == null) ? this.this$0.getChildAt(i2) : (View) invokeI.objValue;
                }

                @Override // androidx.recyclerview.widget.ChildHelper.Callback
                public int getChildCount() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) ? this.this$0.getChildCount() : invokeV.intValue;
                }

                @Override // androidx.recyclerview.widget.ChildHelper.Callback
                public ViewHolder getChildViewHolder(View view) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048581, this, view)) == null) ? RecyclerView.getChildViewHolderInt(view) : (ViewHolder) invokeL.objValue;
                }

                @Override // androidx.recyclerview.widget.ChildHelper.Callback
                public int indexOfChild(View view) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048582, this, view)) == null) ? this.this$0.indexOfChild(view) : invokeL.intValue;
                }

                @Override // androidx.recyclerview.widget.ChildHelper.Callback
                public void onEnteredHiddenState(View view) {
                    ViewHolder childViewHolderInt;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048583, this, view) == null) || (childViewHolderInt = RecyclerView.getChildViewHolderInt(view)) == null) {
                        return;
                    }
                    childViewHolderInt.onEnteredHiddenState(this.this$0);
                }

                @Override // androidx.recyclerview.widget.ChildHelper.Callback
                public void onLeftHiddenState(View view) {
                    ViewHolder childViewHolderInt;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || (childViewHolderInt = RecyclerView.getChildViewHolderInt(view)) == null) {
                        return;
                    }
                    childViewHolderInt.onLeftHiddenState(this.this$0);
                }

                @Override // androidx.recyclerview.widget.ChildHelper.Callback
                public void removeAllViews() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                        int childCount = getChildCount();
                        for (int i2 = 0; i2 < childCount; i2++) {
                            View childAt = getChildAt(i2);
                            this.this$0.dispatchChildDetached(childAt);
                            childAt.clearAnimation();
                        }
                        this.this$0.removeAllViews();
                    }
                }

                @Override // androidx.recyclerview.widget.ChildHelper.Callback
                public void removeViewAt(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048586, this, i2) == null) {
                        View childAt = this.this$0.getChildAt(i2);
                        if (childAt != null) {
                            this.this$0.dispatchChildDetached(childAt);
                            childAt.clearAnimation();
                        }
                        this.this$0.removeViewAt(i2);
                    }
                }
            });
        }
    }

    private boolean isPreferredNextFocus(View view, View view2, int i2) {
        InterceptResult invokeLLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65568, this, view, view2, i2)) == null) {
            if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
                return false;
            }
            if (view == null || findContainingItemView(view) == null) {
                return true;
            }
            this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
            this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
            offsetDescendantRectToMyCoords(view, this.mTempRect);
            offsetDescendantRectToMyCoords(view2, this.mTempRect2);
            char c2 = 65535;
            int i4 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
            Rect rect = this.mTempRect;
            int i5 = rect.left;
            int i6 = this.mTempRect2.left;
            if ((i5 < i6 || rect.right <= i6) && this.mTempRect.right < this.mTempRect2.right) {
                i3 = 1;
            } else {
                Rect rect2 = this.mTempRect;
                int i7 = rect2.right;
                int i8 = this.mTempRect2.right;
                i3 = ((i7 > i8 || rect2.left >= i8) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
            }
            Rect rect3 = this.mTempRect;
            int i9 = rect3.top;
            int i10 = this.mTempRect2.top;
            if ((i9 < i10 || rect3.bottom <= i10) && this.mTempRect.bottom < this.mTempRect2.bottom) {
                c2 = 1;
            } else {
                Rect rect4 = this.mTempRect;
                int i11 = rect4.bottom;
                int i12 = this.mTempRect2.bottom;
                if ((i11 <= i12 && rect4.top < i12) || this.mTempRect.top <= this.mTempRect2.top) {
                    c2 = 0;
                }
            }
            if (i2 == 1) {
                return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
            } else if (i2 == 2) {
                return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
            } else if (i2 == 17) {
                return i3 < 0;
            } else if (i2 == 33) {
                return c2 < 0;
            } else if (i2 == 66) {
                return i3 > 0;
            } else if (i2 == 130) {
                return c2 > 0;
            } else {
                throw new IllegalArgumentException("Invalid direction: " + i2 + exceptionLabel());
            }
        }
        return invokeLLI.booleanValue;
    }

    private void onPointerUp(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, motionEvent) == null) {
            int actionIndex = motionEvent.getActionIndex();
            if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
                int i2 = actionIndex == 0 ? 1 : 0;
                this.mScrollPointerId = motionEvent.getPointerId(i2);
                int x = (int) (motionEvent.getX(i2) + 0.5f);
                this.mLastTouchX = x;
                this.mInitialTouchX = x;
                int y = (int) (motionEvent.getY(i2) + 0.5f);
                this.mLastTouchY = y;
                this.mInitialTouchY = y;
            }
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, this)) == null) ? this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations() : invokeV.booleanValue;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
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
            boolean z = false;
            boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
            this.mState.mRunSimpleAnimations = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
            State state = this.mState;
            if (state.mRunSimpleAnimations && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
                z = true;
            }
            state.mRunPredictiveAnimations = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pullGlows(float f2, float f3, float f4, float f5) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65572, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            boolean z2 = true;
            if (f3 < 0.0f) {
                ensureLeftGlow();
                EdgeEffectCompat.onPull(this.mLeftGlow, (-f3) / getWidth(), 1.0f - (f4 / getHeight()));
            } else if (f3 <= 0.0f) {
                z = false;
                if (f5 >= 0.0f) {
                    ensureTopGlow();
                    EdgeEffectCompat.onPull(this.mTopGlow, (-f5) / getHeight(), f2 / getWidth());
                } else if (f5 > 0.0f) {
                    ensureBottomGlow();
                    EdgeEffectCompat.onPull(this.mBottomGlow, f5 / getHeight(), 1.0f - (f2 / getWidth()));
                } else {
                    z2 = z;
                }
                if (z2 && f3 == 0.0f && f5 == 0.0f) {
                    return;
                }
                ViewCompat.postInvalidateOnAnimation(this);
            } else {
                ensureRightGlow();
                EdgeEffectCompat.onPull(this.mRightGlow, f3 / getWidth(), f4 / getHeight());
            }
            z = true;
            if (f5 >= 0.0f) {
            }
            if (z2) {
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void recoverFocusFromState() {
        View findViewById;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65573, this) == null) && this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() == 131072 && isFocused()) {
                return;
            }
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
            View view = null;
            ViewHolder findViewHolderForItemId = (this.mState.mFocusedItemId == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.mFocusedItemId);
            if (findViewHolderForItemId != null && !this.mChildHelper.isHidden(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
                view = findViewHolderForItemId.itemView;
            } else if (this.mChildHelper.getChildCount() > 0) {
                view = findNextViewToFocus();
            }
            if (view != null) {
                int i2 = this.mState.mFocusedSubChildId;
                if (i2 != -1 && (findViewById = view.findViewById(i2)) != null && findViewById.isFocusable()) {
                    view = findViewById;
                }
                view.requestFocus();
            }
        }
    }

    private void releaseGlows() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
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
    }

    private void requestChildOnScreen(@NonNull View view, @Nullable View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65575, this, view, view2) == null) {
            View view3 = view2 != null ? view2 : view;
            this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
            ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
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
            if (view2 != null) {
                offsetDescendantRectToMyCoords(view2, this.mTempRect);
                offsetRectIntoDescendantCoords(view, this.mTempRect);
            }
            this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
        }
    }

    private void resetFocusInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            State state = this.mState;
            state.mFocusedItemId = -1L;
            state.mFocusedItemPosition = -1;
            state.mFocusedSubChildId = -1;
        }
    }

    private void resetScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
            stopNestedScroll(0);
            releaseGlows();
        }
    }

    private void saveFocusInfo() {
        int adapterPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
            ViewHolder findContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
            if (findContainingViewHolder == null) {
                resetFocusInfo();
                return;
            }
            this.mState.mFocusedItemId = this.mAdapter.hasStableIds() ? findContainingViewHolder.getItemId() : -1L;
            State state = this.mState;
            if (this.mDataSetHasChangedAfterLayout) {
                adapterPosition = -1;
            } else {
                adapterPosition = findContainingViewHolder.isRemoved() ? findContainingViewHolder.mOldPosition : findContainingViewHolder.getAdapterPosition();
            }
            state.mFocusedItemPosition = adapterPosition;
            this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(findContainingViewHolder.itemView);
        }
    }

    private void setAdapterInternal(@Nullable Adapter adapter, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65579, this, new Object[]{adapter, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
    }

    private void stopScrollersInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            this.mViewFlinger.stop();
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.stopSmoothScroller();
            }
        }
    }

    public void absorbGlows(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            if (i2 < 0) {
                ensureLeftGlow();
                if (this.mLeftGlow.isFinished()) {
                    this.mLeftGlow.onAbsorb(-i2);
                }
            } else if (i2 > 0) {
                ensureRightGlow();
                if (this.mRightGlow.isFinished()) {
                    this.mRightGlow.onAbsorb(i2);
                }
            }
            if (i3 < 0) {
                ensureTopGlow();
                if (this.mTopGlow.isFinished()) {
                    this.mTopGlow.onAbsorb(-i3);
                }
            } else if (i3 > 0) {
                ensureBottomGlow();
                if (this.mBottomGlow.isFinished()) {
                    this.mBottomGlow.onAbsorb(i3);
                }
            }
            if (i2 == 0 && i3 == 0) {
                return;
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, i2, i3) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i2, i3)) {
                super.addFocusables(arrayList, i2, i3);
            }
        }
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, itemDecoration, i2) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
            }
            if (this.mItemDecorations.isEmpty()) {
                setWillNotDraw(false);
            }
            if (i2 < 0) {
                this.mItemDecorations.add(itemDecoration);
            } else {
                this.mItemDecorations.add(i2, itemDecoration);
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onChildAttachStateChangeListener) == null) {
            if (this.mOnChildAttachStateListeners == null) {
                this.mOnChildAttachStateListeners = new ArrayList();
            }
            this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
        }
    }

    public void addOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onItemTouchListener) == null) {
            this.mOnItemTouchListeners.add(onItemTouchListener);
        }
    }

    public void addOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onScrollListener) == null) {
            if (this.mScrollListeners == null) {
                this.mScrollListeners = new ArrayList();
            }
            this.mScrollListeners.add(onScrollListener);
        }
    }

    public void animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, viewHolder, itemHolderInfo, itemHolderInfo2) == null) {
            viewHolder.setIsRecyclable(false);
            if (this.mItemAnimator.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                postAnimationRunner();
            }
        }
    }

    public void animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewHolder, itemHolderInfo, itemHolderInfo2) == null) {
            addAnimatingView(viewHolder);
            viewHolder.setIsRecyclable(false);
            if (this.mItemAnimator.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                postAnimationRunner();
            }
        }
    }

    public void assertInLayoutOrScroll(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    public void assertNotInLayoutOrScroll(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (isComputingLayout()) {
                if (str == null) {
                    throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
                }
                throw new IllegalStateException(str);
            } else if (this.mDispatchScrollCounter > 0) {
                new IllegalStateException("" + exceptionLabel());
            }
        }
    }

    public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewHolder)) == null) {
            ItemAnimator itemAnimator = this.mItemAnimator;
            return itemAnimator == null || itemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.getUnmodifiedPayloads());
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, layoutParams)) == null) ? (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams) : invokeL.booleanValue;
    }

    public void clearOldPositions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.clearOldPosition();
                }
            }
            this.mRecycler.clearOldPositions();
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (list = this.mOnChildAttachStateListeners) == null) {
            return;
        }
        list.clear();
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (list = this.mScrollListeners) == null) {
            return;
        }
        list.clear();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null && layoutManager.canScrollHorizontally()) {
                return this.mLayout.computeHorizontalScrollExtent(this.mState);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null && layoutManager.canScrollHorizontally()) {
                return this.mLayout.computeHorizontalScrollOffset(this.mState);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null && layoutManager.canScrollHorizontally()) {
                return this.mLayout.computeHorizontalScrollRange(this.mState);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null && layoutManager.canScrollVertically()) {
                return this.mLayout.computeVerticalScrollExtent(this.mState);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null && layoutManager.canScrollVertically()) {
                return this.mLayout.computeVerticalScrollOffset(this.mState);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null && layoutManager.canScrollVertically()) {
                return this.mLayout.computeVerticalScrollRange(this.mState);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void considerReleasingGlowsOnScroll(int i2, int i3) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) {
            EdgeEffect edgeEffect = this.mLeftGlow;
            if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
                z = false;
            } else {
                this.mLeftGlow.onRelease();
                z = this.mLeftGlow.isFinished();
            }
            EdgeEffect edgeEffect2 = this.mRightGlow;
            if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
                this.mRightGlow.onRelease();
                z |= this.mRightGlow.isFinished();
            }
            EdgeEffect edgeEffect3 = this.mTopGlow;
            if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
                this.mTopGlow.onRelease();
                z |= this.mTopGlow.isFinished();
            }
            EdgeEffect edgeEffect4 = this.mBottomGlow;
            if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
                this.mBottomGlow.onRelease();
                z |= this.mBottomGlow.isFinished();
            }
            if (z) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    public void consumePendingUpdateOperations() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout) {
                if (this.mAdapterHelper.hasPendingUpdates()) {
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
                return;
            }
            TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            TraceCompat.endSection();
        }
    }

    public void defaultOnMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) {
            setMeasuredDimension(LayoutManager.chooseSize(i2, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(i3, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
        }
    }

    public void dispatchChildAttached(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            onChildAttachedToWindow(view);
            Adapter adapter = this.mAdapter;
            if (adapter != null && childViewHolderInt != null) {
                adapter.onViewAttachedToWindow(childViewHolderInt);
            }
            List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
                }
            }
        }
    }

    public void dispatchChildDetached(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view) == null) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            onChildDetachedFromWindow(view);
            Adapter adapter = this.mAdapter;
            if (adapter != null && childViewHolderInt != null) {
                adapter.onViewDetachedFromWindow(childViewHolderInt);
            }
            List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
                }
            }
        }
    }

    public void dispatchLayout() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.mAdapter == null || this.mLayout == null) {
            return;
        }
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

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? getScrollingChildHelper().dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? getScrollingChildHelper().dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? getScrollingChildHelper().dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? getScrollingChildHelper().dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    public void dispatchOnScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.onScrollStateChanged(i2);
            }
            onScrollStateChanged(i2);
            OnScrollListener onScrollListener = this.mScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(this, i2);
            }
            List<OnScrollListener> list = this.mScrollListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mScrollListeners.get(size).onScrollStateChanged(this, i2);
                }
            }
        }
    }

    public void dispatchOnScrolled(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048612, this, i2, i3) == null) {
            this.mDispatchScrollCounter++;
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
            onScrolled(i2, i3);
            OnScrollListener onScrollListener = this.mScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrolled(this, i2, i3);
            }
            List<OnScrollListener> list = this.mScrollListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mScrollListeners.get(size).onScrolled(this, i2, i3);
                }
            }
            this.mDispatchScrollCounter--;
        }
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(size);
                if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (i2 = viewHolder.mPendingAccessibilityState) != -1) {
                    ViewCompat.setImportantForAccessibility(viewHolder.itemView, i2);
                    viewHolder.mPendingAccessibilityState = -1;
                }
            }
            this.mPendingAccessibilityImportanceChange.clear();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, accessibilityEvent)) == null) {
            onPopulateAccessibilityEvent(accessibilityEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, sparseArray) == null) {
            dispatchThawSelfOnly(sparseArray);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, sparseArray) == null) {
            dispatchFreezeSelfOnly(sparseArray);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, canvas) == null) {
            super.draw(canvas);
            int size = this.mItemDecorations.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                this.mItemDecorations.get(i2).onDrawOver(canvas, this, this.mState);
            }
            EdgeEffect edgeEffect = this.mLeftGlow;
            boolean z3 = true;
            if (edgeEffect == null || edgeEffect.isFinished()) {
                z = false;
            } else {
                int save = canvas.save();
                int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
                canvas.rotate(270.0f);
                canvas.translate((-getHeight()) + paddingBottom, 0.0f);
                EdgeEffect edgeEffect2 = this.mLeftGlow;
                z = edgeEffect2 != null && edgeEffect2.draw(canvas);
                canvas.restoreToCount(save);
            }
            EdgeEffect edgeEffect3 = this.mTopGlow;
            if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
                int save2 = canvas.save();
                if (this.mClipToPadding) {
                    canvas.translate(getPaddingLeft(), getPaddingTop());
                }
                EdgeEffect edgeEffect4 = this.mTopGlow;
                z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
                canvas.restoreToCount(save2);
            }
            EdgeEffect edgeEffect5 = this.mRightGlow;
            if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
                int save3 = canvas.save();
                int width = getWidth();
                int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
                canvas.rotate(90.0f);
                canvas.translate(-paddingTop, -width);
                EdgeEffect edgeEffect6 = this.mRightGlow;
                z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
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
                    z2 = true;
                }
                z |= z2;
                canvas.restoreToCount(save4);
            }
            if (z || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) {
                z3 = z;
            }
            if (z3) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{canvas, view, Long.valueOf(j2)})) == null) ? super.drawChild(canvas, view, j2) : invokeCommon.booleanValue;
    }

    public void ensureBottomGlow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && this.mBottomGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
            this.mBottomGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void ensureLeftGlow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && this.mLeftGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
            this.mLeftGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void ensureRightGlow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && this.mRightGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
            this.mRightGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void ensureTopGlow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && this.mTopGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
            this.mTopGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public String exceptionLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
        }
        return (String) invokeV.objValue;
    }

    public final void fillRemainingScrollValues(State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, state) == null) {
            if (getScrollState() == 2) {
                OverScroller overScroller = this.mViewFlinger.mOverScroller;
                state.mRemainingScrollHorizontal = overScroller.getFinalX() - overScroller.getCurrX();
                state.mRemainingScrollVertical = overScroller.getFinalY() - overScroller.getCurrY();
                return;
            }
            state.mRemainingScrollHorizontal = 0;
            state.mRemainingScrollVertical = 0;
        }
    }

    @Nullable
    public View findChildViewUnder(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048625, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.mChildHelper.getChildAt(childCount);
                float translationX = childAt.getTranslationX();
                float translationY = childAt.getTranslationY();
                if (f2 >= childAt.getLeft() + translationX && f2 <= childAt.getRight() + translationX && f3 >= childAt.getTop() + translationY && f3 <= childAt.getBottom() + translationY) {
                    return childAt;
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
        return r5;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View findContainingItemView(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, view)) == null) {
            ViewParent parent = view.getParent();
            while (parent != null && parent != this && (parent instanceof View)) {
                view = (View) parent;
                parent = view.getParent();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Nullable
    public ViewHolder findContainingViewHolder(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, view)) == null) {
            View findContainingItemView = findContainingItemView(view);
            if (findContainingItemView == null) {
                return null;
            }
            return getChildViewHolder(findContainingItemView);
        }
        return (ViewHolder) invokeL.objValue;
    }

    @Nullable
    public ViewHolder findViewHolderForAdapterPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) {
            ViewHolder viewHolder = null;
            if (this.mDataSetHasChangedAfterLayout) {
                return null;
            }
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i3));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i2) {
                    if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    viewHolder = childViewHolderInt;
                }
            }
            return viewHolder;
        }
        return (ViewHolder) invokeI.objValue;
    }

    public ViewHolder findViewHolderForItemId(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048629, this, j2)) == null) {
            Adapter adapter = this.mAdapter;
            ViewHolder viewHolder = null;
            if (adapter != null && adapter.hasStableIds()) {
                int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
                for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
                    ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
                    if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j2) {
                        if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                            return childViewHolderInt;
                        }
                        viewHolder = childViewHolderInt;
                    }
                }
            }
            return viewHolder;
        }
        return (ViewHolder) invokeJ.objValue;
    }

    @Nullable
    public ViewHolder findViewHolderForLayoutPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i2)) == null) ? findViewHolderForPosition(i2, false) : (ViewHolder) invokeI.objValue;
    }

    @Nullable
    @Deprecated
    public ViewHolder findViewHolderForPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) ? findViewHolderForPosition(i2, false) : (ViewHolder) invokeI.objValue;
    }

    public boolean fling(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048633, this, i2, i3)) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null || this.mLayoutSuppressed) {
                return false;
            }
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            i2 = (!canScrollHorizontally || Math.abs(i2) < this.mMinFlingVelocity) ? 0 : 0;
            i3 = (!canScrollVertically || Math.abs(i3) < this.mMinFlingVelocity) ? 0 : 0;
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            float f2 = i2;
            float f3 = i3;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z = canScrollHorizontally || canScrollVertically;
                dispatchNestedFling(f2, f3, z);
                OnFlingListener onFlingListener = this.mOnFlingListener;
                if (onFlingListener != null && onFlingListener.onFling(i2, i3)) {
                    return true;
                }
                if (z) {
                    int i4 = canScrollHorizontally ? 1 : 0;
                    if (canScrollVertically) {
                        i4 |= 2;
                    }
                    startNestedScroll(i4, 1);
                    int i5 = this.mMaxFlingVelocity;
                    int max = Math.max(-i5, Math.min(i2, i5));
                    int i6 = this.mMaxFlingVelocity;
                    this.mViewFlinger.fling(max, Math.max(-i6, Math.min(i3, i6)));
                    return true;
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        InterceptResult invokeLI;
        View view2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048634, this, view, i2)) == null) {
            View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i2);
            if (onInterceptFocusSearch != null) {
                return onInterceptFocusSearch;
            }
            boolean z2 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
            FocusFinder focusFinder = FocusFinder.getInstance();
            if (z2 && (i2 == 2 || i2 == 1)) {
                if (this.mLayout.canScrollVertically()) {
                    int i3 = i2 == 2 ? 130 : 33;
                    z = focusFinder.findNextFocus(this, view, i3) == null;
                    if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                        i2 = i3;
                    }
                } else {
                    z = false;
                }
                if (!z && this.mLayout.canScrollHorizontally()) {
                    int i4 = (this.mLayout.getLayoutDirection() == 1) ^ (i2 == 2) ? 66 : 17;
                    boolean z3 = focusFinder.findNextFocus(this, view, i4) == null;
                    if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                        i2 = i4;
                    }
                    z = z3;
                }
                if (z) {
                    consumePendingUpdateOperations();
                    if (findContainingItemView(view) == null) {
                        return null;
                    }
                    startInterceptRequestLayout();
                    this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                    stopInterceptRequestLayout(false);
                }
                view2 = focusFinder.findNextFocus(this, view, i2);
            } else {
                View findNextFocus = focusFinder.findNextFocus(this, view, i2);
                if (findNextFocus == null && z2) {
                    consumePendingUpdateOperations();
                    if (findContainingItemView(view) == null) {
                        return null;
                    }
                    startInterceptRequestLayout();
                    view2 = this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                    stopInterceptRequestLayout(false);
                } else {
                    view2 = findNextFocus;
                }
            }
            if (view2 == null || view2.hasFocusable()) {
                return isPreferredNextFocus(view, view2, i2) ? view2 : super.focusSearch(view, i2);
            } else if (getFocusedChild() == null) {
                return super.focusSearch(view, i2);
            } else {
                requestChildOnScreen(view2, null);
                return view;
            }
        }
        return (View) invokeLI.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                return layoutManager.generateDefaultLayoutParams();
            }
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, attributeSet)) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                return layoutManager.generateLayoutParams(getContext(), attributeSet);
            }
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? "androidx.recyclerview.widget.RecyclerView" : (CharSequence) invokeV.objValue;
    }

    @Nullable
    public Adapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.mAdapter : (Adapter) invokeV.objValue;
    }

    public int getAdapterPositionFor(ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, viewHolder)) == null) {
            if (viewHolder.hasAnyOfTheFlags(PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD) || !viewHolder.isBound()) {
                return -1;
            }
            return this.mAdapterHelper.applyPendingUpdatesToPosition(viewHolder.mPosition);
        }
        return invokeL.intValue;
    }

    @Override // android.view.View
    public int getBaseline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                return layoutManager.getBaseline();
            }
            return super.getBaseline();
        }
        return invokeV.intValue;
    }

    public long getChangedHolderKey(ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, viewHolder)) == null) ? this.mAdapter.hasStableIds() ? viewHolder.getItemId() : viewHolder.mPosition : invokeL.longValue;
    }

    public int getChildAdapterPosition(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, view)) == null) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                return childViewHolderInt.getAdapterPosition();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048644, this, i2, i3)) == null) {
            ChildDrawingOrderCallback childDrawingOrderCallback = this.mChildDrawingOrderCallback;
            if (childDrawingOrderCallback == null) {
                return super.getChildDrawingOrder(i2, i3);
            }
            return childDrawingOrderCallback.onGetChildDrawingOrder(i2, i3);
        }
        return invokeII.intValue;
    }

    public long getChildItemId(@NonNull View view) {
        InterceptResult invokeL;
        ViewHolder childViewHolderInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, view)) == null) {
            Adapter adapter = this.mAdapter;
            if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
                return -1L;
            }
            return childViewHolderInt.getItemId();
        }
        return invokeL.longValue;
    }

    public int getChildLayoutPosition(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, view)) == null) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                return childViewHolderInt.getLayoutPosition();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Deprecated
    public int getChildPosition(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, view)) == null) ? getChildAdapterPosition(view) : invokeL.intValue;
    }

    public ViewHolder getChildViewHolder(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, view)) == null) {
            ViewParent parent = view.getParent();
            if (parent != null && parent != this) {
                throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
            }
            return getChildViewHolderInt(view);
        }
        return (ViewHolder) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.mClipToPadding : invokeV.booleanValue;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.mAccessibilityDelegate : (RecyclerViewAccessibilityDelegate) invokeV.objValue;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048651, this, view, rect) == null) {
            getDecoratedBoundsWithMarginsInt(view, rect);
        }
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.mEdgeEffectFactory : (EdgeEffectFactory) invokeV.objValue;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.mItemAnimator : (ItemAnimator) invokeV.objValue;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, view)) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (!layoutParams.mInsetsDirty) {
                return layoutParams.mDecorInsets;
            }
            if (this.mState.isPreLayout() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
                return layoutParams.mDecorInsets;
            }
            Rect rect = layoutParams.mDecorInsets;
            rect.set(0, 0, 0, 0);
            int size = this.mItemDecorations.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mTempRect.set(0, 0, 0, 0);
                this.mItemDecorations.get(i2).getItemOffsets(this.mTempRect, view, this, this.mState);
                int i3 = rect.left;
                Rect rect2 = this.mTempRect;
                rect.left = i3 + rect2.left;
                rect.top += rect2.top;
                rect.right += rect2.right;
                rect.bottom += rect2.bottom;
            }
            layoutParams.mInsetsDirty = false;
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    @NonNull
    public ItemDecoration getItemDecorationAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048655, this, i2)) == null) {
            int itemDecorationCount = getItemDecorationCount();
            if (i2 >= 0 && i2 < itemDecorationCount) {
                return this.mItemDecorations.get(i2);
            }
            throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
        }
        return (ItemDecoration) invokeI.objValue;
    }

    public int getItemDecorationCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.mItemDecorations.size() : invokeV.intValue;
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.mLayout : (LayoutManager) invokeV.objValue;
    }

    public int getMaxFlingVelocity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.mMaxFlingVelocity : invokeV.intValue;
    }

    public int getMinFlingVelocity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.mMinFlingVelocity : invokeV.intValue;
    }

    public long getNanoTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            if (ALLOW_THREAD_GAP_WORK) {
                return System.nanoTime();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.mOnFlingListener : (OnFlingListener) invokeV.objValue;
    }

    public boolean getPreserveFocusAfterLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.mPreserveFocusAfterLayout : invokeV.booleanValue;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.mRecycler.getRecycledViewPool() : (RecycledViewPool) invokeV.objValue;
    }

    public int getScrollState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.mScrollState : invokeV.intValue;
    }

    public boolean hasFixedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.mHasFixedSize : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? getScrollingChildHelper().hasNestedScrollingParent() : invokeV.booleanValue;
    }

    public boolean hasPendingAdapterUpdates() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.hasPendingUpdates() : invokeV.booleanValue;
    }

    public void initAdapterManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback(this) { // from class: androidx.recyclerview.widget.RecyclerView.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RecyclerView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                public void dispatchUpdate(AdapterHelper.UpdateOp updateOp) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, updateOp) == null) {
                        int i2 = updateOp.cmd;
                        if (i2 == 1) {
                            RecyclerView recyclerView = this.this$0;
                            recyclerView.mLayout.onItemsAdded(recyclerView, updateOp.positionStart, updateOp.itemCount);
                        } else if (i2 == 2) {
                            RecyclerView recyclerView2 = this.this$0;
                            recyclerView2.mLayout.onItemsRemoved(recyclerView2, updateOp.positionStart, updateOp.itemCount);
                        } else if (i2 == 4) {
                            RecyclerView recyclerView3 = this.this$0;
                            recyclerView3.mLayout.onItemsUpdated(recyclerView3, updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                        } else if (i2 != 8) {
                        } else {
                            RecyclerView recyclerView4 = this.this$0;
                            recyclerView4.mLayout.onItemsMoved(recyclerView4, updateOp.positionStart, updateOp.itemCount, 1);
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.AdapterHelper.Callback
                public ViewHolder findViewHolder(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                        ViewHolder findViewHolderForPosition = this.this$0.findViewHolderForPosition(i2, true);
                        if (findViewHolderForPosition == null || this.this$0.mChildHelper.isHidden(findViewHolderForPosition.itemView)) {
                            return null;
                        }
                        return findViewHolderForPosition;
                    }
                    return (ViewHolder) invokeI.objValue;
                }

                @Override // androidx.recyclerview.widget.AdapterHelper.Callback
                public void markViewHoldersUpdated(int i2, int i3, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj) == null) {
                        this.this$0.viewRangeUpdate(i2, i3, obj);
                        this.this$0.mItemsChanged = true;
                    }
                }

                @Override // androidx.recyclerview.widget.AdapterHelper.Callback
                public void offsetPositionsForAdd(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048579, this, i2, i3) == null) {
                        this.this$0.offsetPositionRecordsForInsert(i2, i3);
                        this.this$0.mItemsAddedOrRemoved = true;
                    }
                }

                @Override // androidx.recyclerview.widget.AdapterHelper.Callback
                public void offsetPositionsForMove(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048580, this, i2, i3) == null) {
                        this.this$0.offsetPositionRecordsForMove(i2, i3);
                        this.this$0.mItemsAddedOrRemoved = true;
                    }
                }

                @Override // androidx.recyclerview.widget.AdapterHelper.Callback
                public void offsetPositionsForRemovingInvisible(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048581, this, i2, i3) == null) {
                        this.this$0.offsetPositionRecordsForRemove(i2, i3, true);
                        RecyclerView recyclerView = this.this$0;
                        recyclerView.mItemsAddedOrRemoved = true;
                        recyclerView.mState.mDeletedInvisibleItemCountSincePreviousLayout += i3;
                    }
                }

                @Override // androidx.recyclerview.widget.AdapterHelper.Callback
                public void offsetPositionsForRemovingLaidOutOrNewView(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048582, this, i2, i3) == null) {
                        this.this$0.offsetPositionRecordsForRemove(i2, i3, false);
                        this.this$0.mItemsAddedOrRemoved = true;
                    }
                }

                @Override // androidx.recyclerview.widget.AdapterHelper.Callback
                public void onDispatchFirstPass(AdapterHelper.UpdateOp updateOp) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048583, this, updateOp) == null) {
                        dispatchUpdate(updateOp);
                    }
                }

                @Override // androidx.recyclerview.widget.AdapterHelper.Callback
                public void onDispatchSecondPass(AdapterHelper.UpdateOp updateOp) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, updateOp) == null) {
                        dispatchUpdate(updateOp);
                    }
                }
            });
        }
    }

    @VisibleForTesting
    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048670, this, stateListDrawable, drawable, stateListDrawable2, drawable2) == null) {
            if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
                Resources resources = getContext().getResources();
                new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R$dimen.fastscroll_margin));
                return;
            }
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
    }

    public void invalidateGlows() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            this.mBottomGlow = null;
            this.mTopGlow = null;
            this.mRightGlow = null;
            this.mLeftGlow = null;
        }
    }

    public void invalidateItemDecorations() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048672, this) == null) || this.mItemDecorations.size() == 0) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            AccessibilityManager accessibilityManager = this.mAccessibilityManager;
            return accessibilityManager != null && accessibilityManager.isEnabled();
        }
        return invokeV.booleanValue;
    }

    public boolean isAnimating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            ItemAnimator itemAnimator = this.mItemAnimator;
            return itemAnimator != null && itemAnimator.isRunning();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.mIsAttached : invokeV.booleanValue;
    }

    public boolean isComputingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.mLayoutOrScrollCounter > 0 : invokeV.booleanValue;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? isLayoutSuppressed() : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.mLayoutSuppressed : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? getScrollingChildHelper().isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    public void jumpToPositionForSmoothScroller(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048680, this, i2) == null) || this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i2);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
                ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(i2).getLayoutParams()).mInsetsDirty = true;
            }
            this.mRecycler.markItemDecorInsetsDirty();
        }
    }

    public void markKnownViewsInvalid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
                if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.addFlags(6);
                }
            }
            markItemDecorInsetsDirty();
            this.mRecycler.markKnownViewsInvalid();
        }
    }

    public void offsetChildrenHorizontal(@Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048683, this, i2) == null) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                this.mChildHelper.getChildAt(i3).offsetLeftAndRight(i2);
            }
        }
    }

    public void offsetChildrenVertical(@Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i2) == null) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                this.mChildHelper.getChildAt(i3).offsetTopAndBottom(i2);
            }
        }
    }

    public void offsetPositionRecordsForInsert(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048685, this, i2, i3) == null) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i4 = 0; i4 < unfilteredChildCount; i4++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i4));
                if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2) {
                    childViewHolderInt.offsetPosition(i3, false);
                    this.mState.mStructureChanged = true;
                }
            }
            this.mRecycler.offsetPositionRecordsForInsert(i2, i3);
            requestLayout();
        }
    }

    public void offsetPositionRecordsForMove(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048686, this, i2, i3) == null) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            if (i2 < i3) {
                i6 = -1;
                i5 = i2;
                i4 = i3;
            } else {
                i4 = i2;
                i5 = i3;
                i6 = 1;
            }
            for (int i8 = 0; i8 < unfilteredChildCount; i8++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i8));
                if (childViewHolderInt != null && (i7 = childViewHolderInt.mPosition) >= i5 && i7 <= i4) {
                    if (i7 == i2) {
                        childViewHolderInt.offsetPosition(i3 - i2, false);
                    } else {
                        childViewHolderInt.offsetPosition(i6, false);
                    }
                    this.mState.mStructureChanged = true;
                }
            }
            this.mRecycler.offsetPositionRecordsForMove(i2, i3);
            requestLayout();
        }
    }

    public void offsetPositionRecordsForRemove(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048687, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            int i4 = i2 + i3;
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i5 = 0; i5 < unfilteredChildCount; i5++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i5));
                if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                    int i6 = childViewHolderInt.mPosition;
                    if (i6 >= i4) {
                        childViewHolderInt.offsetPosition(-i3, z);
                        this.mState.mStructureChanged = true;
                    } else if (i6 >= i2) {
                        childViewHolderInt.flagRemovedAndOffsetPosition(i2 - 1, -i3, z);
                        this.mState.mStructureChanged = true;
                    }
                }
            }
            this.mRecycler.offsetPositionRecordsForRemove(i2, i3, z);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
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
                    float f2 = 60.0f;
                    if (!isInEditMode() && display != null) {
                        float refreshRate = display.getRefreshRate();
                        if (refreshRate >= 30.0f) {
                            f2 = refreshRate;
                        }
                    }
                    GapWorker gapWorker2 = this.mGapWorker;
                    gapWorker2.mFrameIntervalNs = 1.0E9f / f2;
                    GapWorker.sGapWorker.set(gapWorker2);
                }
                this.mGapWorker.add(this);
            }
        }
    }

    public void onChildAttachedToWindow(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, view) == null) {
        }
    }

    public void onChildDetachedFromWindow(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, view) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        GapWorker gapWorker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048691, this) == null) {
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
            if (!ALLOW_THREAD_GAP_WORK || (gapWorker = this.mGapWorker) == null) {
                return;
            }
            gapWorker.remove(this);
            this.mGapWorker = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, canvas) == null) {
            super.onDraw(canvas);
            int size = this.mItemDecorations.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mItemDecorations.get(i2).onDraw(canvas, this, this.mState);
            }
        }
    }

    public void onEnterLayoutOrScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            this.mLayoutOrScrollCounter++;
        }
    }

    public void onExitLayoutOrScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            onExitLayoutOrScroll(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048696, this, motionEvent)) == null) {
            if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
                if ((motionEvent.getSource() & 2) != 0) {
                    f2 = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                    if (this.mLayout.canScrollHorizontally()) {
                        f3 = motionEvent.getAxisValue(10);
                        if (f2 == 0.0f || f3 != 0.0f) {
                            scrollByInternal((int) (f3 * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                        }
                    }
                    f3 = 0.0f;
                    if (f2 == 0.0f) {
                    }
                    scrollByInternal((int) (f3 * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                } else {
                    if ((motionEvent.getSource() & 4194304) != 0) {
                        float axisValue = motionEvent.getAxisValue(26);
                        if (!this.mLayout.canScrollVertically()) {
                            if (this.mLayout.canScrollHorizontally()) {
                                f3 = axisValue;
                                f2 = 0.0f;
                                if (f2 == 0.0f) {
                                }
                                scrollByInternal((int) (f3 * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                            }
                        } else {
                            f2 = -axisValue;
                            f3 = 0.0f;
                            if (f2 == 0.0f) {
                            }
                            scrollByInternal((int) (f3 * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                        }
                    }
                    f2 = 0.0f;
                    f3 = 0.0f;
                    if (f2 == 0.0f) {
                    }
                    scrollByInternal((int) (f3 * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048697, this, motionEvent)) == null) {
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
            if (actionMasked == 0) {
                if (this.mIgnoreMotionEventTillDown) {
                    this.mIgnoreMotionEventTillDown = false;
                }
                this.mScrollPointerId = motionEvent.getPointerId(0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.mLastTouchX = x;
                this.mInitialTouchX = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.mLastTouchY = y;
                this.mInitialTouchY = y;
                if (this.mScrollState == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    stopNestedScroll(1);
                }
                int[] iArr = this.mNestedOffsets;
                iArr[1] = 0;
                iArr[0] = 0;
                int i2 = canScrollHorizontally ? 1 : 0;
                if (canScrollVertically) {
                    i2 |= 2;
                }
                startNestedScroll(i2, 0);
            } else if (actionMasked == 1) {
                this.mVelocityTracker.clear();
                stopNestedScroll(0);
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                if (findPointerIndex < 0) {
                    String str = "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?";
                    return false;
                }
                int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                if (this.mScrollState != 1) {
                    int i3 = x2 - this.mInitialTouchX;
                    int i4 = y2 - this.mInitialTouchY;
                    if (!canScrollHorizontally || Math.abs(i3) <= this.mTouchSlop) {
                        z = false;
                    } else {
                        this.mLastTouchX = x2;
                        z = true;
                    }
                    if (canScrollVertically && Math.abs(i4) > this.mTouchSlop) {
                        this.mLastTouchY = y2;
                        z = true;
                    }
                    if (z) {
                        setScrollState(1);
                    }
                }
            } else if (actionMasked == 3) {
                cancelScroll();
            } else if (actionMasked == 5) {
                this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.mLastTouchX = x3;
                this.mInitialTouchX = x3;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.mLastTouchY = y3;
                this.mInitialTouchY = y3;
            } else if (actionMasked == 6) {
                onPointerUp(motionEvent);
            }
            return this.mScrollState == 1;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048698, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
            dispatchLayout();
            TraceCompat.endSection();
            this.mFirstLayoutComplete = true;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048699, this, i2, i3) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null) {
                defaultOnMeasure(i2, i3);
                return;
            }
            boolean z = false;
            if (layoutManager.isAutoMeasureEnabled()) {
                int mode = View.MeasureSpec.getMode(i2);
                int mode2 = View.MeasureSpec.getMode(i3);
                this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    z = true;
                }
                if (z || this.mAdapter == null) {
                    return;
                }
                if (this.mState.mLayoutStep == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(i2, i3);
                this.mState.mIsMeasuring = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.mIsMeasuring = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
                }
            } else if (this.mHasFixedSize) {
                this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
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
                this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
                stopInterceptRequestLayout(false);
                this.mState.mInPreLayout = false;
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048700, this, i2, rect)) == null) {
            if (isComputingLayout()) {
                return false;
            }
            return super.onRequestFocusInDescendants(i2, rect);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            super.onRestoreInstanceState(savedState.getSuperState());
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null || (parcelable2 = this.mPendingSavedState.mLayoutState) == null) {
                return;
            }
            layoutManager.onRestoreInstanceState(parcelable2);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
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
        return (Parcelable) invokeV.objValue;
    }

    public void onScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048703, this, i2) == null) {
        }
    }

    public void onScrolled(@Px int i2, @Px int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048704, this, i2, i3) == null) {
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048705, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (i2 == i4 && i3 == i5) {
                return;
            }
            invalidateGlows();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f6  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048706, this, motionEvent)) == null) {
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
            if (actionMasked == 0) {
                this.mScrollPointerId = motionEvent.getPointerId(0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.mLastTouchX = x;
                this.mInitialTouchX = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.mLastTouchY = y;
                this.mInitialTouchY = y;
                int i2 = canScrollHorizontally ? 1 : 0;
                if (canScrollVertically) {
                    i2 |= 2;
                }
                startNestedScroll(i2, 0);
            } else if (actionMasked == 1) {
                this.mVelocityTracker.addMovement(obtain);
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
                float f2 = canScrollHorizontally ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
                float f3 = canScrollVertically ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
                if ((f2 == 0.0f && f3 == 0.0f) || !fling((int) f2, (int) f3)) {
                    setScrollState(0);
                }
                resetScroll();
                z2 = true;
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                if (findPointerIndex < 0) {
                    String str = "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?";
                    return false;
                }
                int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                int i3 = this.mLastTouchX - x2;
                int i4 = this.mLastTouchY - y2;
                if (this.mScrollState != 1) {
                    if (canScrollHorizontally) {
                        if (i3 > 0) {
                            i3 = Math.max(0, i3 - this.mTouchSlop);
                        } else {
                            i3 = Math.min(0, i3 + this.mTouchSlop);
                        }
                        if (i3 != 0) {
                            z = true;
                            if (canScrollVertically) {
                                if (i4 > 0) {
                                    i4 = Math.max(0, i4 - this.mTouchSlop);
                                } else {
                                    i4 = Math.min(0, i4 + this.mTouchSlop);
                                }
                                if (i4 != 0) {
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
                int i5 = i3;
                int i6 = i4;
                if (this.mScrollState == 1) {
                    int[] iArr3 = this.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    if (dispatchNestedPreScroll(canScrollHorizontally ? i5 : 0, canScrollVertically ? i6 : 0, this.mReusableIntPair, this.mScrollOffset, 0)) {
                        int[] iArr4 = this.mReusableIntPair;
                        i5 -= iArr4[0];
                        i6 -= iArr4[1];
                        int[] iArr5 = this.mNestedOffsets;
                        int i7 = iArr5[0];
                        int[] iArr6 = this.mScrollOffset;
                        iArr5[0] = i7 + iArr6[0];
                        iArr5[1] = iArr5[1] + iArr6[1];
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    int i8 = i6;
                    int[] iArr7 = this.mScrollOffset;
                    this.mLastTouchX = x2 - iArr7[0];
                    this.mLastTouchY = y2 - iArr7[1];
                    if (scrollByInternal(canScrollHorizontally ? i5 : 0, canScrollVertically ? i8 : 0, motionEvent)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    if (this.mGapWorker != null && (i5 != 0 || i8 != 0)) {
                        this.mGapWorker.postFromTraversal(this, i5, i8);
                    }
                }
            } else if (actionMasked == 3) {
                cancelScroll();
            } else if (actionMasked == 5) {
                this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.mLastTouchX = x3;
                this.mInitialTouchX = x3;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.mLastTouchY = y3;
                this.mInitialTouchY = y3;
            } else if (actionMasked == 6) {
                onPointerUp(motionEvent);
            }
            if (!z2) {
                this.mVelocityTracker.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void postAnimationRunner() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048707, this) == null) && !this.mPostedAnimatorRunner && this.mIsAttached) {
            ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    public void processDataSetCompletelyChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048708, this, z) == null) {
            this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
            this.mDataSetHasChangedAfterLayout = true;
            markKnownViewsInvalid();
        }
    }

    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048709, this, viewHolder, itemHolderInfo) == null) {
            viewHolder.setFlags(0, 8192);
            if (this.mState.mTrackOldChangeHolders && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
                this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(viewHolder), viewHolder);
            }
            this.mViewInfoStore.addToPreLayout(viewHolder, itemHolderInfo);
        }
    }

    public void removeAndRecycleViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
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
    }

    public boolean removeAnimatingView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048711, this, view)) == null) {
            startInterceptRequestLayout();
            boolean removeViewIfHidden = this.mChildHelper.removeViewIfHidden(view);
            if (removeViewIfHidden) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(view);
                this.mRecycler.unscrapView(childViewHolderInt);
                this.mRecycler.recycleViewHolderInternal(childViewHolderInt);
            }
            stopInterceptRequestLayout(!removeViewIfHidden);
            return removeViewIfHidden;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048712, this, view, z) == null) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (childViewHolderInt.isTmpDetached()) {
                    childViewHolderInt.clearTmpDetachFlag();
                } else if (!childViewHolderInt.shouldIgnore()) {
                    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
                }
            }
            view.clearAnimation();
            dispatchChildDetached(view);
            super.removeDetachedView(view, z);
        }
    }

    public void removeItemDecoration(@NonNull ItemDecoration itemDecoration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, itemDecoration) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
            }
            this.mItemDecorations.remove(itemDecoration);
            if (this.mItemDecorations.isEmpty()) {
                setWillNotDraw(getOverScrollMode() == 2);
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public void removeItemDecorationAt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048714, this, i2) == null) {
            int itemDecorationCount = getItemDecorationCount();
            if (i2 >= 0 && i2 < itemDecorationCount) {
                removeItemDecoration(getItemDecorationAt(i2));
                return;
            }
            throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
        }
    }

    public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048715, this, onChildAttachStateChangeListener) == null) || (list = this.mOnChildAttachStateListeners) == null) {
            return;
        }
        list.remove(onChildAttachStateChangeListener);
    }

    public void removeOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, onItemTouchListener) == null) {
            this.mOnItemTouchListeners.remove(onItemTouchListener);
            if (this.mInterceptingOnItemTouchListener == onItemTouchListener) {
                this.mInterceptingOnItemTouchListener = null;
            }
        }
    }

    public void removeOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        List<OnScrollListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048717, this, onScrollListener) == null) || (list = this.mScrollListeners) == null) {
            return;
        }
        list.remove(onScrollListener);
    }

    public void repositionShadowingViews() {
        ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.mChildHelper.getChildAt(i2);
                ViewHolder childViewHolder = getChildViewHolder(childAt);
                if (childViewHolder != null && (viewHolder = childViewHolder.mShadowingHolder) != null) {
                    View view = viewHolder.itemView;
                    int left = childAt.getLeft();
                    int top = childAt.getTop();
                    if (left != view.getLeft() || top != view.getTop()) {
                        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048719, this, view, view2) == null) {
            if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
                requestChildOnScreen(view, view2);
            }
            super.requestChildFocus(view, view2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048720, this, view, rect, z)) == null) ? this.mLayout.requestChildRectangleOnScreen(this, view, rect, z) : invokeLLZ.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048721, this, z) == null) {
            int size = this.mOnItemTouchListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mOnItemTouchListeners.get(i2).onRequestDisallowInterceptTouchEvent(z);
            }
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutSuppressed) {
                super.requestLayout();
            } else {
                this.mLayoutWasDefered = true;
            }
        }
    }

    public void saveOldPositions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.saveOldPosition();
                }
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        LayoutManager layoutManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048724, this, i2, i3) == null) || (layoutManager = this.mLayout) == null || this.mLayoutSuppressed) {
            return;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (canScrollHorizontally || canScrollVertically) {
            if (!canScrollHorizontally) {
                i2 = 0;
            }
            if (!canScrollVertically) {
                i3 = 0;
            }
            scrollByInternal(i2, i3, null);
        }
    }

    public boolean scrollByInternal(int i2, int i3, MotionEvent motionEvent) {
        InterceptResult invokeIIL;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048725, this, i2, i3, motionEvent)) == null) {
            consumePendingUpdateOperations();
            if (this.mAdapter != null) {
                int[] iArr = this.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                scrollStep(i2, i3, iArr);
                int[] iArr2 = this.mReusableIntPair;
                int i8 = iArr2[0];
                int i9 = iArr2[1];
                i4 = i9;
                i5 = i8;
                i6 = i2 - i8;
                i7 = i3 - i9;
            } else {
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
            }
            if (!this.mItemDecorations.isEmpty()) {
                invalidate();
            }
            int[] iArr3 = this.mReusableIntPair;
            iArr3[0] = 0;
            iArr3[1] = 0;
            dispatchNestedScroll(i5, i4, i6, i7, this.mScrollOffset, 0, iArr3);
            int[] iArr4 = this.mReusableIntPair;
            int i10 = i6 - iArr4[0];
            int i11 = i7 - iArr4[1];
            boolean z = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
            int i12 = this.mLastTouchX;
            int[] iArr5 = this.mScrollOffset;
            this.mLastTouchX = i12 - iArr5[0];
            this.mLastTouchY -= iArr5[1];
            int[] iArr6 = this.mNestedOffsets;
            iArr6[0] = iArr6[0] + iArr5[0];
            iArr6[1] = iArr6[1] + iArr5[1];
            if (getOverScrollMode() != 2) {
                if (motionEvent != null && !MotionEventCompat.isFromSource(motionEvent, 8194)) {
                    pullGlows(motionEvent.getX(), i10, motionEvent.getY(), i11);
                }
                considerReleasingGlowsOnScroll(i2, i3);
            }
            if (i5 != 0 || i4 != 0) {
                dispatchOnScrolled(i5, i4);
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            return (!z && i5 == 0 && i4 == 0) ? false : true;
        }
        return invokeIIL.booleanValue;
    }

    public void scrollStep(int i2, int i3, @Nullable int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048726, this, i2, i3, iArr) == null) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            TraceCompat.beginSection(TRACE_SCROLL_TAG);
            fillRemainingScrollValues(this.mState);
            int scrollHorizontallyBy = i2 != 0 ? this.mLayout.scrollHorizontallyBy(i2, this.mRecycler, this.mState) : 0;
            int scrollVerticallyBy = i3 != 0 ? this.mLayout.scrollVerticallyBy(i3, this.mRecycler, this.mState) : 0;
            TraceCompat.endSection();
            repositionShadowingViews();
            onExitLayoutOrScroll();
            stopInterceptRequestLayout(false);
            if (iArr != null) {
                iArr[0] = scrollHorizontallyBy;
                iArr[1] = scrollVerticallyBy;
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048727, this, i2, i3) == null) {
        }
    }

    public void scrollToPosition(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048728, this, i2) == null) || this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return;
        }
        layoutManager.scrollToPosition(i2);
        awakenScrollBars();
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048729, this, accessibilityEvent) == null) || shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, recyclerViewAccessibilityDelegate) == null) {
            this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
            ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
        }
    }

    public void setAdapter(@Nullable Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, adapter) == null) {
            setLayoutFrozen(false);
            setAdapterInternal(adapter, false, true);
            processDataSetCompletelyChanged(false);
            requestLayout();
        }
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback childDrawingOrderCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048732, this, childDrawingOrderCallback) == null) || childDrawingOrderCallback == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = childDrawingOrderCallback;
        setChildrenDrawingOrderEnabled(childDrawingOrderCallback != null);
    }

    @VisibleForTesting
    public boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048733, this, viewHolder, i2)) == null) {
            if (isComputingLayout()) {
                viewHolder.mPendingAccessibilityState = i2;
                this.mPendingAccessibilityImportanceChange.add(viewHolder);
                return false;
            }
            ViewCompat.setImportantForAccessibility(viewHolder.itemView, i2);
            return true;
        }
        return invokeLI.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048734, this, z) == null) {
            if (z != this.mClipToPadding) {
                invalidateGlows();
            }
            this.mClipToPadding = z;
            super.setClipToPadding(z);
            if (this.mFirstLayoutComplete) {
                requestLayout();
            }
        }
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory edgeEffectFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, edgeEffectFactory) == null) {
            Preconditions.checkNotNull(edgeEffectFactory);
            this.mEdgeEffectFactory = edgeEffectFactory;
            invalidateGlows();
        }
    }

    public void setHasFixedSize(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z) == null) {
            this.mHasFixedSize = z;
        }
    }

    public void setItemAnimator(@Nullable ItemAnimator itemAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, itemAnimator) == null) {
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
    }

    public void setItemViewCacheSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048738, this, i2) == null) {
            this.mRecycler.setViewCacheSize(i2);
        }
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048739, this, z) == null) {
            suppressLayout(z);
        }
    }

    public void setLayoutManager(@Nullable LayoutManager layoutManager) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048740, this, layoutManager) == null) || layoutManager == this.mLayout) {
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

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, layoutTransition) == null) {
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
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048742, this, z) == null) {
            getScrollingChildHelper().setNestedScrollingEnabled(z);
        }
    }

    public void setOnFlingListener(@Nullable OnFlingListener onFlingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, onFlingListener) == null) {
            this.mOnFlingListener = onFlingListener;
        }
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, onScrollListener) == null) {
            this.mScrollListener = onScrollListener;
        }
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048745, this, z) == null) {
            this.mPreserveFocusAfterLayout = z;
        }
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool recycledViewPool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048746, this, recycledViewPool) == null) {
            this.mRecycler.setRecycledViewPool(recycledViewPool);
        }
    }

    public void setRecyclerListener(@Nullable RecyclerListener recyclerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, recyclerListener) == null) {
            this.mRecyclerListener = recyclerListener;
        }
    }

    public void setScrollState(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048748, this, i2) == null) || i2 == this.mScrollState) {
            return;
        }
        this.mScrollState = i2;
        if (i2 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048749, this, i2) == null) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            if (i2 != 0) {
                if (i2 != 1) {
                    String str = "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value";
                } else {
                    this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                    return;
                }
            }
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        }
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension viewCacheExtension) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, viewCacheExtension) == null) {
            this.mRecycler.setViewCacheExtension(viewCacheExtension);
        }
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048751, this, accessibilityEvent)) == null) {
            if (isComputingLayout()) {
                int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : 0;
                this.mEatenAccessibilityChangeFlags |= contentChangeTypes != 0 ? contentChangeTypes : 0;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void smoothScrollBy(@Px int i2, @Px int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048752, this, i2, i3) == null) {
            smoothScrollBy(i2, i3, null);
        }
    }

    public void smoothScrollToPosition(int i2) {
        LayoutManager layoutManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048756, this, i2) == null) || this.mLayoutSuppressed || (layoutManager = this.mLayout) == null) {
            return;
        }
        layoutManager.smoothScrollToPosition(this, this.mState, i2);
    }

    public void startInterceptRequestLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            int i2 = this.mInterceptRequestLayoutDepth + 1;
            this.mInterceptRequestLayoutDepth = i2;
            if (i2 != 1 || this.mLayoutSuppressed) {
                return;
            }
            this.mLayoutWasDefered = false;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048758, this, i2)) == null) ? getScrollingChildHelper().startNestedScroll(i2) : invokeI.booleanValue;
    }

    public void stopInterceptRequestLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048760, this, z) == null) {
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
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048761, this) == null) {
            getScrollingChildHelper().stopNestedScroll();
        }
    }

    public void stopScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048763, this) == null) {
            setScrollState(0);
            stopScrollersInternal();
        }
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048764, this, z) == null) || z == this.mLayoutSuppressed) {
            return;
        }
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

    public void swapAdapter(@Nullable Adapter adapter, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048765, this, adapter, z) == null) {
            setLayoutFrozen(false);
            setAdapterInternal(adapter, true, z);
            processDataSetCompletelyChanged(true);
            requestLayout();
        }
    }

    public void viewRangeUpdate(int i2, int i3, Object obj) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048766, this, i2, i3, obj) == null) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            int i5 = i2 + i3;
            for (int i6 = 0; i6 < unfilteredChildCount; i6++) {
                View unfilteredChildAt = this.mChildHelper.getUnfilteredChildAt(i6);
                ViewHolder childViewHolderInt = getChildViewHolderInt(unfilteredChildAt);
                if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i4 = childViewHolderInt.mPosition) >= i2 && i4 < i5) {
                    childViewHolderInt.addFlags(2);
                    childViewHolderInt.addChangePayload(obj);
                    ((LayoutParams) unfilteredChildAt.getLayoutParams()).mInsetsDirty = true;
                }
            }
            this.mRecycler.viewRangeUpdate(i2, i3);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.recyclerViewStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2, Integer.valueOf(i4)})) == null) ? getScrollingChildHelper().dispatchNestedPreScroll(i2, i3, iArr, iArr2, i4) : invokeCommon.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, Integer.valueOf(i6)})) == null) ? getScrollingChildHelper().dispatchNestedScroll(i2, i3, i4, i5, iArr, i6) : invokeCommon.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003a A[SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ViewHolder findViewHolderForPosition(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048632, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            ViewHolder viewHolder = null;
            for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i3));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                    if (z) {
                        if (childViewHolderInt.mPosition != i2) {
                            continue;
                        }
                        if (this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                            return childViewHolderInt;
                        }
                        viewHolder = childViewHolderInt;
                    } else {
                        if (childViewHolderInt.getLayoutPosition() != i2) {
                            continue;
                        }
                        if (this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                        }
                    }
                }
            }
            return viewHolder;
        }
        return (ViewHolder) invokeCommon.objValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048667, this, i2)) == null) ? getScrollingChildHelper().hasNestedScrollingParent(i2) : invokeI.booleanValue;
    }

    public void onExitLayoutOrScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048695, this, z) == null) {
            int i2 = this.mLayoutOrScrollCounter - 1;
            this.mLayoutOrScrollCounter = i2;
            if (i2 < 1) {
                this.mLayoutOrScrollCounter = 0;
                if (z) {
                    dispatchContentChangedIfNecessary();
                    dispatchPendingImportantForAccessibilityChanges();
                }
            }
        }
    }

    public void smoothScrollBy(@Px int i2, @Px int i3, @Nullable Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048753, this, i2, i3, interpolator) == null) {
            smoothScrollBy(i2, i3, interpolator, Integer.MIN_VALUE);
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048759, this, i2, i3)) == null) ? getScrollingChildHelper().startNestedScroll(i2, i3) : invokeII.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048762, this, i2) == null) {
            getScrollingChildHelper().stopNestedScroll(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mObserver = new RecyclerViewDataObserver(this);
        this.mRecycler = new Recycler(this);
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new Runnable(this) { // from class: androidx.recyclerview.widget.RecyclerView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RecyclerView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    RecyclerView recyclerView = this.this$0;
                    if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
                        return;
                    }
                    RecyclerView recyclerView2 = this.this$0;
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
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger(this);
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener(this);
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable(this) { // from class: androidx.recyclerview.widget.RecyclerView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RecyclerView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ItemAnimator itemAnimator = this.this$0.mItemAnimator;
                    if (itemAnimator != null) {
                        itemAnimator.runPendingAnimations();
                    }
                    this.this$0.mPostedAnimatorRunner = false;
                }
            }
        };
        this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback(this) { // from class: androidx.recyclerview.widget.RecyclerView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RecyclerView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processAppeared(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, viewHolder, itemHolderInfo, itemHolderInfo2) == null) {
                    this.this$0.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
                }
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processDisappeared(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder, itemHolderInfo, itemHolderInfo2) == null) {
                    this.this$0.mRecycler.unscrapView(viewHolder);
                    this.this$0.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
                }
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processPersistent(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewHolder, itemHolderInfo, itemHolderInfo2) == null) {
                    viewHolder.setIsRecyclable(false);
                    RecyclerView recyclerView = this.this$0;
                    if (recyclerView.mDataSetHasChangedAfterLayout) {
                        if (recyclerView.mItemAnimator.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                            this.this$0.postAnimationRunner();
                        }
                    } else if (recyclerView.mItemAnimator.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        this.this$0.postAnimationRunner();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void unused(ViewHolder viewHolder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, viewHolder) == null) {
                    RecyclerView recyclerView = this.this$0;
                    recyclerView.mLayout.removeAndRecycleView(viewHolder.itemView, recyclerView.mRecycler);
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
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R$styleable.RecyclerView, attributeSet, obtainStyledAttributes, i2, 0);
        }
        String string = obtainStyledAttributes.getString(R$styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_android_clipToPadding, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z2;
        if (z2) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i2, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i2, 0);
            if (Build.VERSION.SDK_INT >= 29) {
                saveAttributeDataForStyleable(context, NESTED_SCROLLING_ATTRS, attributeSet, obtainStyledAttributes2, i2, 0);
            }
            z = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6, @NonNull int[] iArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, Integer.valueOf(i6), iArr2}) == null) {
            getScrollingChildHelper().dispatchNestedScroll(i2, i3, i4, i5, iArr, i6, iArr2);
        }
    }

    public void smoothScrollBy(@Px int i2, @Px int i3, @Nullable Interpolator interpolator, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048754, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), interpolator, Integer.valueOf(i4)}) == null) {
            smoothScrollBy(i2, i3, interpolator, i4, false);
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Rect mDecorInsets;
        public boolean mInsetsDirty;
        public boolean mPendingInvalidate;
        public ViewHolder mViewHolder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public int getViewAdapterPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mViewHolder.getAdapterPosition() : invokeV.intValue;
        }

        public int getViewLayoutPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mViewHolder.getLayoutPosition() : invokeV.intValue;
        }

        @Deprecated
        public int getViewPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mViewHolder.getPosition() : invokeV.intValue;
        }

        public boolean isItemChanged() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mViewHolder.isUpdated() : invokeV.booleanValue;
        }

        public boolean isItemRemoved() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mViewHolder.isRemoved() : invokeV.booleanValue;
        }

        public boolean isViewInvalid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mViewHolder.isInvalid() : invokeV.booleanValue;
        }

        public boolean viewNeedsUpdate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mViewHolder.needsUpdate() : invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public Parcelable mLayoutState;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-391623573, "Landroidx/recyclerview/widget/RecyclerView$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-391623573, "Landroidx/recyclerview/widget/RecyclerView$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.recyclerview.widget.RecyclerView.SavedState.1
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
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) ? new SavedState(parcel, classLoader) : (SavedState) invokeLL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mLayoutState = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        public void copyFrom(SavedState savedState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, savedState) == null) {
                this.mLayoutState = savedState.mLayoutState;
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeParcelable(this.mLayoutState, 0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, layoutParams)) == null) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                return layoutManager.generateLayoutParams(layoutParams);
            }
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public void smoothScrollBy(@Px int i2, @Px int i3, @Nullable Interpolator interpolator, int i4, boolean z) {
        LayoutManager layoutManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048755, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), interpolator, Integer.valueOf(i4), Boolean.valueOf(z)}) == null) || (layoutManager = this.mLayout) == null || this.mLayoutSuppressed) {
            return;
        }
        if (!layoutManager.canScrollHorizontally()) {
            i2 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (i4 == Integer.MIN_VALUE || i4 > 0) {
            if (z) {
                int i5 = i2 != 0 ? 1 : 0;
                if (i3 != 0) {
                    i5 |= 2;
                }
                startNestedScroll(i5, 1);
            }
            this.mViewFlinger.smoothScrollBy(i2, i3, i4, interpolator);
            return;
        }
        scrollBy(i2, i3);
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, itemDecoration) == null) {
            addItemDecoration(itemDecoration, -1);
        }
    }
}
