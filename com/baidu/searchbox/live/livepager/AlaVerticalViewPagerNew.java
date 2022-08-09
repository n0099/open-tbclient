package com.baidu.searchbox.live.livepager;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.data.constant.MixTagConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes2.dex */
public class AlaVerticalViewPagerNew extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CLOSE_ENOUGH = 2;
    public static final Comparator<ItemInfo> COMPARATOR;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_GUTTER_SIZE = 16;
    public static final int DEFAULT_OFFSCREEN_PAGES = 1;
    public static final float DETERMINE_Y_RATIO = 0.5f;
    public static final int DRAW_ORDER_DEFAULT = 0;
    public static final int DRAW_ORDER_FORWARD = 1;
    public static final int DRAW_ORDER_REVERSE = 2;
    public static final Interpolator INTERPOLATOR;
    public static final int INVALID_POINTER = -1;
    public static final int[] LAYOUT_ATTRS;
    public static final int MAX_SETTLE_DURATION = 2000;
    public static final int MIN_DISTANCE_FOR_FLING = 25;
    public static final int MIN_FLING_VELOCITY = 400;
    public static final ViewPositionComparator POSITION_COMPARATOR;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final String TAG = "ViewPager";
    public static final boolean USE_CACHE = false;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean disallowIntercept;
    public boolean isPointerCountValid;
    public int mActivePointerId;
    public PagerAdapter mAdapter;
    public OnAdapterChangeListener mAdapterChangeListener;
    public EdgeEffectCompat mBottomEdge;
    public Callback mCallback;
    public boolean mCalledSuper;
    public int mChildHeightMeasureSpec;
    public int mChildWidthMeasureSpec;
    public int mCloseEnough;
    public int mCurItem;
    public int mDecorChildCount;
    public int mDefaultGutterSize;
    public float mDetermineYRatio;
    public int mDrawingOrder;
    public ArrayList<View> mDrawingOrderedChildren;
    public final Runnable mEndScrollRunnable;
    public int mExpectedAdapterCount;
    public long mFakeDragBeginTime;
    public boolean mFakeDragging;
    public boolean mFirstLayout;
    public float mFirstOffset;
    public int mFlingDistance;
    public int mGutterSize;
    public boolean mIgnoreGutter;
    public boolean mInLayout;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public ViewPager.OnPageChangeListener mInternalPageChangeListener;
    public boolean mIsBeingDragged;
    public boolean mIsScrollable;
    public boolean mIsUnableToDrag;
    public final ArrayList<ItemInfo> mItems;
    public float mLastMotionX;
    public float mLastMotionY;
    public float mLastOffset;
    public int mLeftPageBounds;
    public Drawable mMarginDrawable;
    public int mMaximumVelocity;
    public int mMinimumVelocity;
    public boolean mNeedCalculatePageOffsets;
    public PagerObserver mObserver;
    public int mOffscreenPageLimit;
    public ViewPager.OnPageChangeListener mOnPageChangeListener;
    public int mPageMargin;
    public ViewPager.PageTransformer mPageTransformer;
    public boolean mPopulatePending;
    public Parcelable mRestoredAdapterState;
    public ClassLoader mRestoredClassLoader;
    public int mRestoredCurItem;
    public int mRightPageBounds;
    public int mScrollState;
    public Scroller mScroller;
    public boolean mScrollingCacheEnabled;
    public Method mSetChildrenDrawingOrderEnabled;
    public final ItemInfo mTempItem;
    public final Rect mTempRect;
    public EdgeEffectCompat mTopEdge;
    public int mTouchSlop;
    public VelocityTracker mVelocityTracker;

    /* loaded from: classes2.dex */
    public interface Callback {
        void onScrollNearlyComplete();
    }

    /* loaded from: classes2.dex */
    public interface Decor {
    }

    /* loaded from: classes2.dex */
    public static class ItemInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float heightFactor;
        public Object object;
        public float offset;
        public int position;
        public boolean scrolling;

        public ItemInfo() {
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
    }

    /* loaded from: classes2.dex */
    public class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaVerticalViewPagerNew this$0;

        public MyAccessibilityDelegate(AlaVerticalViewPagerNew alaVerticalViewPagerNew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVerticalViewPagerNew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = alaVerticalViewPagerNew;
        }

        private boolean canScroll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.this$0.mAdapter != null && this.this$0.mAdapter.getCount() > 1 : invokeV.booleanValue;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, accessibilityEvent) == null) {
                super.onInitializeAccessibilityEvent(view2, accessibilityEvent);
                accessibilityEvent.setClassName(ViewPager.class.getName());
                AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
                obtain.setScrollable(canScroll());
                if (accessibilityEvent.getEventType() != 4096 || this.this$0.mAdapter == null) {
                    return;
                }
                obtain.setItemCount(this.this$0.mAdapter.getCount());
                obtain.setFromIndex(this.this$0.mCurItem);
                obtain.setToIndex(this.this$0.mCurItem);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, accessibilityNodeInfoCompat) == null) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
                accessibilityNodeInfoCompat.setScrollable(canScroll());
                if (this.this$0.internalCanScrollVertically(1)) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
                if (this.this$0.internalCanScrollVertically(-1)) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view2, i, bundle)) == null) {
                if (super.performAccessibilityAction(view2, i, bundle)) {
                    return true;
                }
                if (i != 4096) {
                    if (i == 8192 && this.this$0.internalCanScrollVertically(-1)) {
                        AlaVerticalViewPagerNew alaVerticalViewPagerNew = this.this$0;
                        alaVerticalViewPagerNew.setCurrentItem(alaVerticalViewPagerNew.mCurItem - 1);
                        return true;
                    }
                    return false;
                } else if (this.this$0.internalCanScrollVertically(1)) {
                    AlaVerticalViewPagerNew alaVerticalViewPagerNew2 = this.this$0;
                    alaVerticalViewPagerNew2.setCurrentItem(alaVerticalViewPagerNew2.mCurItem + 1);
                    return true;
                } else {
                    return false;
                }
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface OnAdapterChangeListener {
        void onAdapterChanged(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes2.dex */
    public class PagerObserver extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaVerticalViewPagerNew this$0;

        public PagerObserver(AlaVerticalViewPagerNew alaVerticalViewPagerNew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVerticalViewPagerNew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = alaVerticalViewPagerNew;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.dataSetChanged();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.dataSetChanged();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public Parcelable adapterState;
        public ClassLoader loader;
        public int position;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-364864998, "Lcom/baidu/searchbox/live/livepager/AlaVerticalViewPagerNew$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-364864998, "Lcom/baidu/searchbox/live/livepager/AlaVerticalViewPagerNew$SavedState;");
                    return;
                }
            }
            CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew.SavedState.1
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
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, parcel, classLoader)) == null) ? new SavedState(parcel, classLoader) : (SavedState) invokeLL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
                public SavedState[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? new SavedState[i] : (SavedState[]) invokeI.objValue;
                }
            });
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
            }
            return (String) invokeV.objValue;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.position);
                parcel.writeParcelable(this.adapterState, i);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            classLoader = classLoader == null ? SavedState.class.getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    /* loaded from: classes2.dex */
    public static class ViewPositionComparator implements Comparator<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ViewPositionComparator() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(View view2, View view3) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, view3)) == null) {
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                LayoutParams layoutParams2 = (LayoutParams) view3.getLayoutParams();
                boolean z = layoutParams.isDecor;
                if (z != layoutParams2.isDecor) {
                    return z ? 1 : -1;
                }
                return layoutParams.position - layoutParams2.position;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-627736402, "Lcom/baidu/searchbox/live/livepager/AlaVerticalViewPagerNew;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-627736402, "Lcom/baidu/searchbox/live/livepager/AlaVerticalViewPagerNew;");
                return;
            }
        }
        LAYOUT_ATTRS = new int[]{16842931};
        COMPARATOR = new Comparator<ItemInfo>() { // from class: com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew.1
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
            @Override // java.util.Comparator
            public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, itemInfo, itemInfo2)) == null) ? itemInfo.position - itemInfo2.position : invokeLL.intValue;
            }
        };
        INTERPOLATOR = new Interpolator() { // from class: com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew.2
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

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                InterceptResult invokeF;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeF = interceptable2.invokeF(1048576, this, f)) == null) {
                    float f2 = f - 1.0f;
                    return (f2 * f2 * f2 * f2 * f2) + 1.0f;
                }
                return invokeF.floatValue;
            }
        };
        POSITION_COMPARATOR = new ViewPositionComparator();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaVerticalViewPagerNew(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsScrollable = true;
        this.isPointerCountValid = false;
        this.disallowIntercept = false;
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable(this) { // from class: com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AlaVerticalViewPagerNew this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                    this.this$0.setScrollState(0);
                    this.this$0.populate();
                }
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
        int i2;
        int i3;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65543, this, itemInfo, i, itemInfo2) == null) {
            int count = this.mAdapter.getCount();
            int clientHeight = getClientHeight();
            float f = clientHeight > 0 ? this.mPageMargin / clientHeight : 0.0f;
            if (itemInfo2 != null) {
                int i4 = itemInfo2.position;
                int i5 = itemInfo.position;
                if (i4 < i5) {
                    float f2 = itemInfo2.offset + itemInfo2.heightFactor + f;
                    int i6 = i4 + 1;
                    int i7 = 0;
                    while (i6 <= itemInfo.position && i7 < this.mItems.size()) {
                        ItemInfo itemInfo5 = this.mItems.get(i7);
                        while (true) {
                            itemInfo4 = itemInfo5;
                            if (i6 <= itemInfo4.position || i7 >= this.mItems.size() - 1) {
                                break;
                            }
                            i7++;
                            itemInfo5 = this.mItems.get(i7);
                        }
                        while (i6 < itemInfo4.position) {
                            f2 += this.mAdapter.getPageWidth(i6) + f;
                            i6++;
                        }
                        itemInfo4.offset = f2;
                        f2 += itemInfo4.heightFactor + f;
                        i6++;
                    }
                } else if (i4 > i5) {
                    int size = this.mItems.size() - 1;
                    float f3 = itemInfo2.offset;
                    while (true) {
                        i4--;
                        if (i4 < itemInfo.position || size < 0) {
                            break;
                        }
                        ItemInfo itemInfo6 = this.mItems.get(size);
                        while (true) {
                            itemInfo3 = itemInfo6;
                            if (i4 >= itemInfo3.position || size <= 0) {
                                break;
                            }
                            size--;
                            itemInfo6 = this.mItems.get(size);
                        }
                        while (i4 > itemInfo3.position) {
                            f3 -= this.mAdapter.getPageWidth(i4) + f;
                            i4--;
                        }
                        f3 -= itemInfo3.heightFactor + f;
                        itemInfo3.offset = f3;
                    }
                }
            }
            int size2 = this.mItems.size();
            float f4 = itemInfo.offset;
            int i8 = itemInfo.position;
            int i9 = i8 - 1;
            this.mFirstOffset = i8 == 0 ? f4 : -3.4028235E38f;
            int i10 = count - 1;
            this.mLastOffset = itemInfo.position == i10 ? (itemInfo.offset + itemInfo.heightFactor) - 1.0f : Float.MAX_VALUE;
            int i11 = i - 1;
            while (i11 >= 0) {
                ItemInfo itemInfo7 = this.mItems.get(i11);
                while (true) {
                    i3 = itemInfo7.position;
                    if (i9 <= i3) {
                        break;
                    }
                    f4 -= this.mAdapter.getPageWidth(i9) + f;
                    i9--;
                }
                f4 -= itemInfo7.heightFactor + f;
                itemInfo7.offset = f4;
                if (i3 == 0) {
                    this.mFirstOffset = f4;
                }
                i11--;
                i9--;
            }
            float f5 = itemInfo.offset + itemInfo.heightFactor + f;
            int i12 = itemInfo.position + 1;
            int i13 = i + 1;
            while (i13 < size2) {
                ItemInfo itemInfo8 = this.mItems.get(i13);
                while (true) {
                    i2 = itemInfo8.position;
                    if (i12 >= i2) {
                        break;
                    }
                    f5 += this.mAdapter.getPageWidth(i12) + f;
                    i12++;
                }
                if (i2 == i10) {
                    this.mLastOffset = (itemInfo8.heightFactor + f5) - 1.0f;
                }
                itemInfo8.offset = f5;
                f5 += itemInfo8.heightFactor + f;
                i13++;
                i12++;
            }
            this.mNeedCalculatePageOffsets = false;
        }
    }

    private void completeScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, this, z) == null) {
            boolean z2 = this.mScrollState == 2;
            if (z2) {
                setScrollingCacheEnabled(false);
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                }
            }
            this.mPopulatePending = false;
            for (int i = 0; i < this.mItems.size(); i++) {
                ItemInfo itemInfo = this.mItems.get(i);
                if (itemInfo.scrolling) {
                    itemInfo.scrolling = false;
                    z2 = true;
                }
            }
            if (z2) {
                if (z) {
                    ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
                } else {
                    this.mEndScrollRunnable.run();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        if (r7 > 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int determineTargetPage(int i, float f, int i2, int i3) {
        InterceptResult invokeCommon;
        ArrayList<ItemInfo> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3)})) != null) {
            return invokeCommon.intValue;
        }
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            if (Math.abs(i3) > getClientHeight() * 0.17f) {
                if (i3 > 0) {
                    i--;
                }
                i++;
            } else {
                i = (int) (i + f + (i >= this.mCurItem ? 0.4f : 0.6f));
            }
            if (this.mItems.size() > 0) {
                return Math.max(this.mItems.get(0).position, Math.min(i, this.mItems.get(arrayList.size() - 1).position));
            }
            return i;
        }
    }

    private void enableLayers(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewCompat.setLayerType(getChildAt(i), z ? 2 : 0, null);
            }
        }
    }

    private void endDrag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.mIsBeingDragged = false;
            this.mIsUnableToDrag = false;
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, rect, view2)) == null) {
            if (rect == null) {
                rect = new Rect();
            }
            if (view2 == null) {
                rect.set(0, 0, 0, 0);
                return rect;
            }
            rect.left = view2.getLeft();
            rect.right = view2.getRight();
            rect.top = view2.getTop();
            rect.bottom = view2.getBottom();
            ViewParent parent = view2.getParent();
            while ((parent instanceof ViewGroup) && parent != this) {
                ViewGroup viewGroup = (ViewGroup) parent;
                rect.left += viewGroup.getLeft();
                rect.right += viewGroup.getRight();
                rect.top += viewGroup.getTop();
                rect.bottom += viewGroup.getBottom();
                parent = viewGroup.getParent();
            }
            return rect;
        }
        return (Rect) invokeLL.objValue;
    }

    private int getClientHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom() : invokeV.intValue;
    }

    private ItemInfo infoForCurrentScrollPosition() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            int clientHeight = getClientHeight();
            float f = 0.0f;
            float scrollY = clientHeight > 0 ? getScrollY() / clientHeight : 0.0f;
            float f2 = clientHeight > 0 ? this.mPageMargin / clientHeight : 0.0f;
            ItemInfo itemInfo = null;
            float f3 = 0.0f;
            int i2 = -1;
            int i3 = 0;
            boolean z = true;
            while (i3 < this.mItems.size()) {
                ItemInfo itemInfo2 = this.mItems.get(i3);
                if (!z && itemInfo2.position != (i = i2 + 1)) {
                    itemInfo2 = this.mTempItem;
                    itemInfo2.offset = f + f3 + f2;
                    itemInfo2.position = i;
                    itemInfo2.heightFactor = this.mAdapter.getPageWidth(i);
                    i3--;
                }
                f = itemInfo2.offset;
                float f4 = itemInfo2.heightFactor + f + f2;
                if (!z && scrollY < f) {
                    return itemInfo;
                }
                if (scrollY < f4 || i3 == this.mItems.size() - 1) {
                    return itemInfo2;
                }
                i2 = itemInfo2.position;
                f3 = itemInfo2.heightFactor;
                i3++;
                itemInfo = itemInfo2;
                z = false;
            }
            return itemInfo;
        }
        return (ItemInfo) invokeV.objValue;
    }

    private void initViewPager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            setWillNotDraw(false);
            setDescendantFocusability(262144);
            setFocusable(true);
            Context context = getContext();
            this.mScroller = new Scroller(context, INTERPOLATOR);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            float f = context.getResources().getDisplayMetrics().density;
            this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
            this.mMinimumVelocity = (int) (400.0f * f);
            this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
            this.mTopEdge = new EdgeEffectCompat(context);
            this.mBottomEdge = new EdgeEffectCompat(context);
            this.mFlingDistance = (int) (25.0f * f);
            this.mCloseEnough = (int) (2.0f * f);
            this.mDefaultGutterSize = (int) (f * 16.0f);
            ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate(this));
            if (ViewCompat.getImportantForAccessibility(this) == 0) {
                ViewCompat.setImportantForAccessibility(this, 1);
            }
            this.mDetermineYRatio = 0.5f;
        }
    }

    private boolean isGutterDrag(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) ? (f < ((float) this.mGutterSize) && f2 > 0.0f) || (f > ((float) (getHeight() - this.mGutterSize)) && f2 < 0.0f) : invokeCommon.booleanValue;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
                int i = actionIndex == 0 ? 1 : 0;
                this.mLastMotionY = MotionEventCompat.getY(motionEvent, i);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
        }
    }

    private boolean performDrag(float f) {
        InterceptResult invokeF;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65554, this, f)) == null) {
            float f2 = this.mLastMotionY - f;
            this.mLastMotionY = f;
            float scrollY = getScrollY() + f2;
            float clientHeight = getClientHeight();
            float f3 = this.mFirstOffset * clientHeight;
            float f4 = this.mLastOffset * clientHeight;
            ItemInfo itemInfo = this.mItems.get(0);
            ArrayList<ItemInfo> arrayList = this.mItems;
            boolean z2 = true;
            ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
            if (itemInfo.position != 0) {
                f3 = itemInfo.offset * clientHeight;
                z = false;
            } else {
                z = true;
            }
            if (itemInfo2.position != this.mAdapter.getCount() - 1) {
                f4 = itemInfo2.offset * clientHeight;
                z2 = false;
            }
            if (scrollY < f3) {
                r4 = z ? this.mTopEdge.onPull(Math.abs(f3 - scrollY) / clientHeight) : false;
                scrollY = f3;
            } else if (scrollY > f4) {
                r4 = z2 ? this.mBottomEdge.onPull(Math.abs(scrollY - f4) / clientHeight) : false;
                scrollY = f4;
            }
            int i = (int) scrollY;
            this.mLastMotionX += scrollY - i;
            scrollTo(getScrollX(), i);
            pageScrolled(i);
            return r4;
        }
        return invokeF.booleanValue;
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65555, this, i, i2, i3, i4) == null) {
            if (i2 > 0 && !this.mItems.isEmpty()) {
                int scrollY = (int) ((getScrollY() / (((i2 - getPaddingTop()) - getPaddingBottom()) + i4)) * (((i - getPaddingTop()) - getPaddingBottom()) + i3));
                scrollTo(getScrollX(), scrollY);
                if (this.mScroller.isFinished()) {
                    return;
                }
                this.mScroller.startScroll(0, scrollY, 0, (int) (infoForPosition(this.mCurItem).offset * i), this.mScroller.getDuration() - this.mScroller.timePassed());
                Log.e(MixTagConstants.MIX_PAGER, "recomputeScrollPosition " + i + " " + i2 + " " + i3 + " " + i4);
                return;
            }
            ItemInfo infoForPosition = infoForPosition(this.mCurItem);
            int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.offset, this.mLastOffset) : 0.0f) * ((i - getPaddingTop()) - getPaddingBottom()));
            if (min != getScrollY()) {
                completeScroll(false);
                scrollTo(getScrollX(), min);
            }
        }
    }

    private void removeNonDecorViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            int i = 0;
            while (i < getChildCount()) {
                if (!((LayoutParams) getChildAt(i).getLayoutParams()).isDecor) {
                    removeViewAt(i);
                    i--;
                }
                i++;
            }
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65557, this, z) == null) || (parent = getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(z);
    }

    private void resetTouch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            this.mIsBeingDragged = false;
            this.mIsUnableToDrag = false;
            this.mActivePointerId = -1;
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        }
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        ViewPager.OnPageChangeListener onPageChangeListener3;
        ViewPager.OnPageChangeListener onPageChangeListener4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            ItemInfo infoForPosition = infoForPosition(i);
            int clientHeight = infoForPosition != null ? (int) (getClientHeight() * Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset))) : 0;
            if (z) {
                smoothScrollTo(0, clientHeight, i2);
                if (z2 && (onPageChangeListener4 = this.mOnPageChangeListener) != null) {
                    onPageChangeListener4.onPageSelected(i);
                }
                if (!z2 || (onPageChangeListener3 = this.mInternalPageChangeListener) == null) {
                    return;
                }
                onPageChangeListener3.onPageSelected(i);
                return;
            }
            if (z2 && (onPageChangeListener2 = this.mOnPageChangeListener) != null) {
                onPageChangeListener2.onPageSelected(i);
            }
            if (z2 && (onPageChangeListener = this.mInternalPageChangeListener) != null) {
                onPageChangeListener.onPageSelected(i);
            }
            completeScroll(false);
            scrollTo(0, clientHeight);
            pageScrolled(clientHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65560, this, i) == null) || this.mScrollState == i) {
            return;
        }
        this.mScrollState = i;
        if (this.mPageTransformer != null) {
            enableLayers(i != 0);
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65561, this, z) == null) || this.mScrollingCacheEnabled == z) {
            return;
        }
        this.mScrollingCacheEnabled = z;
    }

    private void sortChildDrawingOrder() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || this.mDrawingOrder == 0) {
            return;
        }
        ArrayList<View> arrayList = this.mDrawingOrderedChildren;
        if (arrayList == null) {
            this.mDrawingOrderedChildren = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.mDrawingOrderedChildren.add(getChildAt(i));
        }
        Collections.sort(this.mDrawingOrderedChildren, POSITION_COMPARATOR);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ItemInfo infoForChild;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, arrayList, i, i2) == null) {
            int size = arrayList.size();
            int descendantFocusability = getDescendantFocusability();
            if (descendantFocusability != 393216) {
                for (int i3 = 0; i3 < getChildCount(); i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
            if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
                if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                    return;
                }
                arrayList.add(this);
            }
        }
    }

    public ItemInfo addNewItem(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            ItemInfo itemInfo = new ItemInfo();
            itemInfo.position = i;
            itemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i);
            itemInfo.heightFactor = this.mAdapter.getPageWidth(i);
            if (i2 >= 0 && i2 < this.mItems.size()) {
                this.mItems.add(i2, itemInfo);
            } else {
                this.mItems.add(itemInfo);
            }
            return itemInfo;
        }
        return (ItemInfo) invokeII.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo infoForChild;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, view2, i, layoutParams) == null) {
            if (!checkLayoutParams(layoutParams)) {
                layoutParams = generateLayoutParams(layoutParams);
            }
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            boolean z = layoutParams2.isDecor | (view2 instanceof Decor);
            layoutParams2.isDecor = z;
            if (!this.mInLayout) {
                super.addView(view2, i, layoutParams);
            } else if (!z) {
                layoutParams2.needsMeasure = true;
                addViewInLayout(view2, i, layoutParams);
            } else {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean arrowScroll(int i) {
        InterceptResult invokeI;
        boolean z;
        View findNextFocus;
        boolean requestFocus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            View findFocus = findFocus();
            boolean z2 = false;
            if (findFocus != this) {
                if (findFocus != null) {
                    ViewParent parent = findFocus.getParent();
                    while (true) {
                        if (!(parent instanceof ViewGroup)) {
                            z = false;
                            break;
                        } else if (parent == this) {
                            z = true;
                            break;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                    if (!z) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(findFocus.getClass().getSimpleName());
                        for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                            sb.append(" => ");
                            sb.append(parent2.getClass().getSimpleName());
                        }
                        Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                    }
                }
                findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
                if (findNextFocus == null && findNextFocus != findFocus) {
                    if (i == 33) {
                        int i2 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).top;
                        int i3 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).top;
                        if (findFocus != null && i2 >= i3) {
                            requestFocus = pageUp();
                        } else {
                            requestFocus = findNextFocus.requestFocus();
                        }
                    } else if (i == 130) {
                        int i4 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).bottom;
                        int i5 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).bottom;
                        if (findFocus != null && i4 <= i5) {
                            requestFocus = pageDown();
                        } else {
                            requestFocus = findNextFocus.requestFocus();
                        }
                    }
                    z2 = requestFocus;
                } else if (i != 33 || i == 1) {
                    z2 = pageUp();
                } else if (i == 130 || i == 2) {
                    z2 = pageDown();
                }
                if (z2) {
                    playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
                }
                return z2;
            }
            findFocus = null;
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
            if (findNextFocus == null) {
            }
            if (i != 33) {
            }
            z2 = pageUp();
            if (z2) {
            }
            return z2;
        }
        return invokeI.booleanValue;
    }

    public boolean beginFakeDrag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mIsBeingDragged) {
                return false;
            }
            this.mFakeDragging = true;
            setScrollState(1);
            this.mLastMotionY = 0.0f;
            this.mInitialMotionY = 0.0f;
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
            this.mFakeDragBeginTime = uptimeMillis;
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean canScroll(View view2, boolean z, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int scrollX = view2.getScrollX();
                int scrollY = view2.getScrollY();
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    int i5 = i3 + scrollY;
                    if (i5 >= childAt.getTop() && i5 < childAt.getBottom() && (i4 = i2 + scrollX) >= childAt.getLeft() && i4 < childAt.getRight() && canScroll(childAt, true, i, i4 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
            return z && ViewCompat.canScrollVertically(view2, -i);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, layoutParams)) == null) ? (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams) : invokeL.booleanValue;
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (this.mCallback != null && this.mScroller.getFinalY() - currY == 0) {
                    this.mCallback.onScrollNearlyComplete();
                }
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (!pageScrolled(currY)) {
                        this.mScroller.abortAnimation();
                        scrollTo(currX, 0);
                    }
                }
                ViewCompat.postInvalidateOnAnimation(this);
                return;
            }
            completeScroll(true);
        }
    }

    public void dataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int count = this.mAdapter.getCount();
            this.mExpectedAdapterCount = count;
            boolean z = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
            int i = this.mCurItem;
            int i2 = 0;
            boolean z2 = false;
            while (i2 < this.mItems.size()) {
                ItemInfo itemInfo = this.mItems.get(i2);
                int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
                if (itemPosition != -1) {
                    if (itemPosition == -2) {
                        this.mItems.remove(i2);
                        i2--;
                        if (!z2) {
                            this.mAdapter.startUpdate((ViewGroup) this);
                            z2 = true;
                        }
                        this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                        int i3 = this.mCurItem;
                        if (i3 == itemInfo.position) {
                            i = Math.max(0, Math.min(i3, count - 1));
                        }
                    } else {
                        int i4 = itemInfo.position;
                        if (i4 != itemPosition) {
                            if (i4 == this.mCurItem) {
                                i = itemPosition;
                            }
                            itemInfo.position = itemPosition;
                        }
                    }
                    z = true;
                }
                i2++;
            }
            if (z2) {
                this.mAdapter.finishUpdate((ViewGroup) this);
            }
            Collections.sort(this.mItems, COMPARATOR);
            if (z) {
                int childCount = getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                    if (!layoutParams.isDecor) {
                        layoutParams.heightFactor = 0.0f;
                    }
                }
                setCurrentItemInternal(i, false, true);
                requestLayout();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, keyEvent)) == null) ? super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        ItemInfo infoForChild;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, accessibilityEvent)) == null) {
            if (accessibilityEvent.getEventType() == 4096) {
                return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if ((action == 1 || action == 3) && this.disallowIntercept) {
                    resetTouch();
                }
            } else {
                this.disallowIntercept = false;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public float distanceInfluenceForSnapDuration(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048589, this, f)) == null) ? (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d)) : invokeF.floatValue;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, canvas) == null) {
            super.draw(canvas);
            int overScrollMode = ViewCompat.getOverScrollMode(this);
            boolean z = false;
            if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.mAdapter) == null || pagerAdapter.getCount() <= 1)) {
                this.mTopEdge.finish();
                this.mBottomEdge.finish();
            } else {
                if (!this.mTopEdge.isFinished()) {
                    int save = canvas.save();
                    int height = getHeight();
                    int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    canvas.translate(getPaddingLeft(), this.mFirstOffset * height);
                    this.mTopEdge.setSize(width, height);
                    z = false | this.mTopEdge.draw(canvas);
                    canvas.restoreToCount(save);
                }
                if (!this.mBottomEdge.isFinished()) {
                    int save2 = canvas.save();
                    int height2 = getHeight();
                    int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    canvas.rotate(180.0f);
                    canvas.translate((-width2) - getPaddingLeft(), (-(this.mLastOffset + 1.0f)) * height2);
                    this.mBottomEdge.setSize(width2, height2);
                    z |= this.mBottomEdge.draw(canvas);
                    canvas.restoreToCount(save2);
                }
            }
            if (z) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.mMarginDrawable;
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.mFakeDragging) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int yVelocity = (int) (this.isPointerCountValid ? VelocityTrackerCompat.getYVelocity(velocityTracker, this.mActivePointerId) : VelocityTracker.obtain().getYVelocity());
                this.mPopulatePending = true;
                int clientHeight = getClientHeight();
                int scrollY = getScrollY();
                ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((scrollY / clientHeight) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.heightFactor, yVelocity, (int) (this.mLastMotionY - this.mInitialMotionY)), true, true, yVelocity);
                endDrag();
                this.mFakeDragging = false;
                return;
            }
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, keyEvent)) == null) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 21) {
                    return arrowScroll(17);
                }
                if (keyCode != 22) {
                    if (keyCode == 61 && Build.VERSION.SDK_INT >= 11) {
                        if (keyEvent.hasNoModifiers()) {
                            return arrowScroll(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return arrowScroll(1);
                        }
                    }
                } else {
                    return arrowScroll(66);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void fakeDragBy(float f) {
        ArrayList<ItemInfo> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f) == null) {
            if (this.mFakeDragging) {
                this.mLastMotionY += f;
                float scrollY = getScrollY() - f;
                float clientHeight = getClientHeight();
                float f2 = this.mFirstOffset * clientHeight;
                float f3 = this.mLastOffset * clientHeight;
                ItemInfo itemInfo = this.mItems.get(0);
                ItemInfo itemInfo2 = this.mItems.get(arrayList.size() - 1);
                if (itemInfo.position != 0) {
                    f2 = itemInfo.offset * clientHeight;
                }
                if (itemInfo2.position != this.mAdapter.getCount() - 1) {
                    f3 = itemInfo2.offset * clientHeight;
                }
                if (scrollY < f2) {
                    scrollY = f2;
                } else if (scrollY > f3) {
                    scrollY = f3;
                }
                int i = (int) scrollY;
                this.mLastMotionY += scrollY - i;
                scrollTo(getScrollX(), i);
                pageScrolled(i);
                MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, 0.0f, this.mLastMotionY, 0);
                this.mVelocityTracker.addMovement(obtain);
                obtain.recycle();
                return;
            }
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? new LayoutParams() : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, layoutParams)) == null) ? generateDefaultLayoutParams() : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public PagerAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mAdapter : (PagerAdapter) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048599, this, i, i2)) == null) {
            if (this.mDrawingOrder == 2) {
                i2 = (i - 1) - i2;
            }
            return ((LayoutParams) this.mDrawingOrderedChildren.get(i2).getLayoutParams()).childIndex;
        }
        return invokeII.intValue;
    }

    public int getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mCurItem : invokeV.intValue;
    }

    public int getOffscreenPageLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mOffscreenPageLimit : invokeV.intValue;
    }

    public int getPageMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mPageMargin : invokeV.intValue;
    }

    public ItemInfo infoForAnyChild(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048603, this, view2)) != null) {
            return (ItemInfo) invokeL.objValue;
        }
        while (true) {
            ViewParent parent = view2.getParent();
            if (parent != this) {
                if (!(parent instanceof View)) {
                    return null;
                }
                view2 = (View) parent;
            } else {
                return infoForChild(view2);
            }
        }
    }

    public ItemInfo infoForChild(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, view2)) == null) {
            for (int i = 0; i < this.mItems.size(); i++) {
                ItemInfo itemInfo = this.mItems.get(i);
                if (this.mAdapter.isViewFromObject(view2, itemInfo.object)) {
                    return itemInfo;
                }
            }
            return null;
        }
        return (ItemInfo) invokeL.objValue;
    }

    public ItemInfo infoForPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            for (int i2 = 0; i2 < this.mItems.size(); i2++) {
                ItemInfo itemInfo = this.mItems.get(i2);
                if (itemInfo.position == i) {
                    return itemInfo;
                }
            }
            return null;
        }
        return (ItemInfo) invokeI.objValue;
    }

    public boolean internalCanScrollVertically(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            if (this.mAdapter == null) {
                return false;
            }
            int clientHeight = getClientHeight();
            int scrollY = getScrollY();
            return i < 0 ? scrollY > ((int) (((float) clientHeight) * this.mFirstOffset)) : i > 0 && scrollY < ((int) (((float) clientHeight) * this.mLastOffset));
        }
        return invokeI.booleanValue;
    }

    public boolean isFakeDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mFakeDragging : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onAttachedToWindow();
            this.mFirstLayout = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            removeCallbacks(this.mEndScrollRunnable);
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int height;
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.mPageMargin <= 0 || this.mMarginDrawable == null || this.mItems.size() <= 0 || this.mAdapter == null) {
                return;
            }
            int scrollY = getScrollY();
            float height2 = getHeight();
            float f3 = this.mPageMargin / height2;
            int i = 0;
            ItemInfo itemInfo = this.mItems.get(0);
            float f4 = itemInfo.offset;
            int size = this.mItems.size();
            int i2 = itemInfo.position;
            int i3 = this.mItems.get(size - 1).position;
            while (i2 < i3) {
                while (i2 > itemInfo.position && i < size) {
                    i++;
                    itemInfo = this.mItems.get(i);
                }
                if (i2 == itemInfo.position) {
                    float f5 = itemInfo.offset;
                    float f6 = itemInfo.heightFactor;
                    f = (f5 + f6) * height2;
                    f4 = f5 + f6 + f3;
                } else {
                    float pageWidth = this.mAdapter.getPageWidth(i2);
                    f = (f4 + pageWidth) * height2;
                    f4 += pageWidth + f3;
                }
                int i4 = this.mPageMargin;
                if (i4 + f > scrollY) {
                    f2 = f3;
                    this.mMarginDrawable.setBounds(this.mLeftPageBounds, (int) f, this.mRightPageBounds, (int) (i4 + f + 0.5f));
                    this.mMarginDrawable.draw(canvas);
                } else {
                    f2 = f3;
                }
                if (f > scrollY + height) {
                    return;
                }
                i2++;
                f3 = f2;
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, motionEvent)) == null) {
            if (!this.mIsScrollable) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 3 && action != 1) {
                if (action != 0) {
                    if (this.mIsBeingDragged) {
                        return true;
                    }
                    if (this.mIsUnableToDrag) {
                        return false;
                    }
                }
                if (action == 0) {
                    float x = motionEvent.getX();
                    this.mInitialMotionX = x;
                    this.mLastMotionX = x;
                    float y = motionEvent.getY();
                    this.mInitialMotionY = y;
                    this.mLastMotionY = y;
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                    this.mIsUnableToDrag = false;
                    this.mScroller.computeScrollOffset();
                    if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalY() - this.mScroller.getCurrY()) > this.mCloseEnough) {
                        this.mScroller.abortAnimation();
                        this.mPopulatePending = false;
                        populate();
                        this.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    } else {
                        completeScroll(false);
                        this.mIsBeingDragged = false;
                    }
                } else if (action == 2) {
                    try {
                        int i = this.mActivePointerId;
                        if (i != -1) {
                            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                            float y2 = this.isPointerCountValid ? MotionEventCompat.getY(motionEvent, findPointerIndex) : motionEvent.getY();
                            float f = y2 - this.mLastMotionY;
                            float abs = Math.abs(f);
                            float x2 = this.isPointerCountValid ? MotionEventCompat.getX(motionEvent, findPointerIndex) : motionEvent.getX();
                            float abs2 = Math.abs(x2 - this.mInitialMotionX);
                            int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                            if (i2 != 0 && !isGutterDrag(this.mLastMotionY, f) && canScroll(this, false, (int) f, (int) x2, (int) y2)) {
                                this.mLastMotionX = x2;
                                this.mLastMotionY = y2;
                                this.mIsUnableToDrag = true;
                                return false;
                            }
                            if (abs > this.mTouchSlop && abs * this.mDetermineYRatio > abs2) {
                                this.mIsBeingDragged = true;
                                requestParentDisallowInterceptTouchEvent(true);
                                setScrollState(1);
                                this.mLastMotionY = i2 > 0 ? this.mInitialMotionY + this.mTouchSlop : this.mInitialMotionY - this.mTouchSlop;
                                this.mLastMotionX = x2;
                                setScrollingCacheEnabled(true);
                            } else if (abs2 > this.mTouchSlop) {
                                this.mIsUnableToDrag = true;
                            }
                            if (this.mIsBeingDragged && performDrag(y2)) {
                                ViewCompat.postInvalidateOnAnimation(this);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                }
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                return this.mIsBeingDragged;
            }
            resetTouch();
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        ItemInfo infoForChild;
        int max;
        int i5;
        int max2;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            int i7 = i3 - i;
            int i8 = i4 - i2;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int scrollY = getScrollY();
            int i9 = 0;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.isDecor) {
                        int i11 = layoutParams.gravity;
                        int i12 = i11 & 7;
                        int i13 = i11 & 112;
                        if (i12 == 1) {
                            max = Math.max((i7 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                        } else {
                            if (i12 == 3) {
                                i5 = childAt.getMeasuredWidth() + paddingLeft;
                            } else if (i12 != 5) {
                                i5 = paddingLeft;
                            } else {
                                max = (i7 - paddingRight) - childAt.getMeasuredWidth();
                                paddingRight += childAt.getMeasuredWidth();
                            }
                            if (i13 != 16) {
                                max2 = Math.max((i8 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            } else {
                                if (i13 == 48) {
                                    i6 = childAt.getMeasuredHeight() + paddingTop;
                                } else if (i13 != 80) {
                                    i6 = paddingTop;
                                } else {
                                    max2 = (i8 - paddingBottom) - childAt.getMeasuredHeight();
                                    paddingBottom += childAt.getMeasuredHeight();
                                }
                                int i14 = paddingTop + scrollY;
                                childAt.layout(paddingLeft, i14, childAt.getMeasuredWidth() + paddingLeft, i14 + childAt.getMeasuredHeight());
                                i9++;
                                paddingTop = i6;
                                paddingLeft = i5;
                            }
                            int i15 = max2;
                            i6 = paddingTop;
                            paddingTop = i15;
                            int i142 = paddingTop + scrollY;
                            childAt.layout(paddingLeft, i142, childAt.getMeasuredWidth() + paddingLeft, i142 + childAt.getMeasuredHeight());
                            i9++;
                            paddingTop = i6;
                            paddingLeft = i5;
                        }
                        int i16 = max;
                        i5 = paddingLeft;
                        paddingLeft = i16;
                        if (i13 != 16) {
                        }
                        int i152 = max2;
                        i6 = paddingTop;
                        paddingTop = i152;
                        int i1422 = paddingTop + scrollY;
                        childAt.layout(paddingLeft, i1422, childAt.getMeasuredWidth() + paddingLeft, i1422 + childAt.getMeasuredHeight());
                        i9++;
                        paddingTop = i6;
                        paddingLeft = i5;
                    }
                }
            }
            int i17 = (i8 - paddingTop) - paddingBottom;
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt2 = getChildAt(i18);
                if (childAt2.getVisibility() != 8) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams2.isDecor && (infoForChild = infoForChild(childAt2)) != null) {
                        float f = i17;
                        int i19 = ((int) (infoForChild.offset * f)) + paddingTop;
                        if (layoutParams2.needsMeasure) {
                            layoutParams2.needsMeasure = false;
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec((i7 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f * layoutParams2.heightFactor), 1073741824));
                        }
                        childAt2.layout(paddingLeft, i19, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i19);
                    }
                }
            }
            this.mLeftPageBounds = paddingLeft;
            this.mRightPageBounds = i7 - paddingRight;
            this.mDecorChildCount = i9;
            if (this.mFirstLayout) {
                z2 = false;
                scrollToItem(this.mCurItem, false, 0, false);
            } else {
                z2 = false;
            }
            this.mFirstLayout = z2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ac  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048613, this, i, i2) == null) {
            setMeasuredDimension(ViewGroup.getDefaultSize(0, i), ViewGroup.getDefaultSize(0, i2));
            int measuredHeight = getMeasuredHeight();
            this.mGutterSize = Math.min(measuredHeight / 10, this.mDefaultGutterSize);
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int i6 = 0;
            while (true) {
                boolean z = true;
                int i7 = 1073741824;
                if (i6 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.isDecor) {
                    int i8 = layoutParams2.gravity;
                    int i9 = i8 & 7;
                    int i10 = i8 & 112;
                    boolean z2 = i10 == 48 || i10 == 80;
                    if (i9 != 3 && i9 != 5) {
                        z = false;
                    }
                    int i11 = Integer.MIN_VALUE;
                    if (z2) {
                        i11 = 1073741824;
                    } else if (z) {
                        i3 = 1073741824;
                        i4 = ((ViewGroup.LayoutParams) layoutParams2).width;
                        if (i4 == -2) {
                            if (i4 == -1) {
                                i4 = measuredWidth;
                            }
                            i11 = 1073741824;
                        } else {
                            i4 = measuredWidth;
                        }
                        i5 = ((ViewGroup.LayoutParams) layoutParams2).height;
                        if (i5 != -2) {
                            i5 = paddingTop;
                            i7 = i3;
                        } else if (i5 == -1) {
                            i5 = paddingTop;
                        }
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i11), View.MeasureSpec.makeMeasureSpec(i5, i7));
                        if (!z2) {
                            paddingTop -= childAt.getMeasuredHeight();
                        } else if (z) {
                            measuredWidth -= childAt.getMeasuredWidth();
                        }
                    }
                    i3 = Integer.MIN_VALUE;
                    i4 = ((ViewGroup.LayoutParams) layoutParams2).width;
                    if (i4 == -2) {
                    }
                    i5 = ((ViewGroup.LayoutParams) layoutParams2).height;
                    if (i5 != -2) {
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i11), View.MeasureSpec.makeMeasureSpec(i5, i7));
                    if (!z2) {
                    }
                }
                i6++;
            }
            this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
            this.mInLayout = true;
            populate();
            this.mInLayout = false;
            int childCount2 = getChildCount();
            for (int i12 = 0; i12 < childCount2; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getVisibility() != 8 && (layoutParams = (LayoutParams) childAt2.getLayoutParams()) != null && !layoutParams.isDecor) {
                    childAt2.measure(this.mChildWidthMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) (paddingTop * layoutParams.heightFactor), 1073741824));
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPageScrolled(int i, float f, int i2) {
        int max;
        int i3;
        int top;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            if (this.mDecorChildCount > 0) {
                int scrollY = getScrollY();
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int childCount = getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.isDecor) {
                        int i5 = layoutParams.gravity & 112;
                        if (i5 == 16) {
                            max = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                        } else {
                            if (i5 == 48) {
                                i3 = childAt.getHeight() + paddingTop;
                            } else if (i5 != 80) {
                                i3 = paddingTop;
                            } else {
                                max = (height - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            top = (paddingTop + scrollY) - childAt.getTop();
                            if (top != 0) {
                                childAt.offsetTopAndBottom(top);
                            }
                            paddingTop = i3;
                        }
                        int i6 = max;
                        i3 = paddingTop;
                        paddingTop = i6;
                        top = (paddingTop + scrollY) - childAt.getTop();
                        if (top != 0) {
                        }
                        paddingTop = i3;
                    }
                }
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f, i2);
            }
            ViewPager.OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
            if (onPageChangeListener2 != null) {
                onPageChangeListener2.onPageScrolled(i, f, i2);
            }
            if (this.mPageTransformer != null) {
                int scrollY2 = getScrollY();
                int childCount2 = getChildCount();
                for (int i7 = 0; i7 < childCount2; i7++) {
                    View childAt2 = getChildAt(i7);
                    if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                        this.mPageTransformer.transformPage(childAt2, (childAt2.getTop() - scrollY2) / getClientHeight());
                    }
                }
            }
            this.mCalledSuper = true;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        InterceptResult invokeIL;
        int i2;
        int i3;
        ItemInfo infoForChild;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048615, this, i, rect)) == null) {
            int childCount = getChildCount();
            int i4 = -1;
            if ((i & 2) != 0) {
                i4 = childCount;
                i2 = 0;
                i3 = 1;
            } else {
                i2 = childCount - 1;
                i3 = -1;
            }
            while (i2 != i4) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i, rect)) {
                    return true;
                }
                i2 += i3;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            PagerAdapter pagerAdapter = this.mAdapter;
            if (pagerAdapter != null) {
                pagerAdapter.restoreState(savedState.adapterState, savedState.loader);
                setCurrentItemInternal(savedState.position, false, true);
                return;
            }
            this.mRestoredCurItem = savedState.position;
            this.mRestoredAdapterState = savedState.adapterState;
            this.mRestoredClassLoader = savedState.loader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.position = this.mCurItem;
            PagerAdapter pagerAdapter = this.mAdapter;
            if (pagerAdapter != null) {
                savedState.adapterState = pagerAdapter.saveState();
            }
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048618, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i2 != i4) {
                int i5 = this.mPageMargin;
                recomputeScrollPosition(i2, i4, i5, i5);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0085, code lost:
        if (r8.mBottomEdge.onRelease() == false) goto L37;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        PagerAdapter pagerAdapter;
        float yVelocity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, motionEvent)) == null) {
            if (!this.mIsScrollable) {
                return super.onTouchEvent(motionEvent);
            }
            if (this.mFakeDragging) {
                return true;
            }
            boolean z = false;
            if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.mAdapter) == null || pagerAdapter.getCount() == 0) {
                return false;
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int action = motionEvent.getAction() & 255;
            try {
                if (action == 0) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    populate();
                    float x = motionEvent.getX();
                    this.mInitialMotionX = x;
                    this.mLastMotionX = x;
                    float y = motionEvent.getY();
                    this.mInitialMotionY = y;
                    this.mLastMotionY = y;
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                } else if (action != 1) {
                    if (action == 2) {
                        if (!this.mIsBeingDragged) {
                            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                            float y2 = this.isPointerCountValid ? MotionEventCompat.getY(motionEvent, findPointerIndex) : motionEvent.getY();
                            float abs = Math.abs(y2 - this.mLastMotionY);
                            float x2 = this.isPointerCountValid ? MotionEventCompat.getX(motionEvent, findPointerIndex) : motionEvent.getX();
                            float abs2 = Math.abs(x2 - this.mLastMotionX);
                            if (abs > this.mTouchSlop && abs > abs2) {
                                this.mIsBeingDragged = true;
                                requestParentDisallowInterceptTouchEvent(true);
                                this.mLastMotionY = y2 - this.mInitialMotionY > 0.0f ? this.mInitialMotionY + this.mTouchSlop : this.mInitialMotionY - this.mTouchSlop;
                                this.mLastMotionX = x2;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                        if (this.mIsBeingDragged) {
                            z = false | performDrag(this.isPointerCountValid ? MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId)) : motionEvent.getY());
                        }
                    } else if (action != 3) {
                        if (action == 5) {
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            MotionEventCompat.getY(motionEvent, actionIndex);
                            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        } else if (action == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                    } else if (this.mIsBeingDragged) {
                        scrollToItem(this.mCurItem, true, 0, false);
                        this.mActivePointerId = -1;
                        endDrag();
                        if (!this.mTopEdge.onRelease()) {
                        }
                        z = true;
                    }
                } else if (this.mIsBeingDragged) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    if (this.isPointerCountValid) {
                        yVelocity = VelocityTrackerCompat.getYVelocity(velocityTracker, this.mActivePointerId);
                    } else {
                        yVelocity = VelocityTracker.obtain().getYVelocity();
                    }
                    int i = (int) yVelocity;
                    this.mPopulatePending = true;
                    int clientHeight = getClientHeight();
                    int scrollY = getScrollY();
                    ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                    setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((scrollY / clientHeight) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.heightFactor, i, (int) ((this.isPointerCountValid ? MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId)) : motionEvent.getY()) - this.mInitialMotionY)), true, true, i);
                    this.mActivePointerId = -1;
                    endDrag();
                    if (!this.mTopEdge.onRelease()) {
                        if (this.mBottomEdge.onRelease()) {
                        }
                    }
                    z = true;
                }
                if (z) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean pageDown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            PagerAdapter pagerAdapter = this.mAdapter;
            if (pagerAdapter == null || this.mCurItem >= pagerAdapter.getCount() - 1) {
                return false;
            }
            setCurrentItem(this.mCurItem + 1, false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean pageScrolled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i)) == null) {
            if (this.mItems.size() == 0) {
                this.mCalledSuper = false;
                onPageScrolled(0, 0.0f, 0);
                if (this.mCalledSuper) {
                    return false;
                }
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientHeight = getClientHeight();
            int i2 = this.mPageMargin;
            int i3 = clientHeight + i2;
            float f = clientHeight;
            int i4 = infoForCurrentScrollPosition.position;
            float f2 = ((i / f) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.heightFactor + (i2 / f));
            this.mCalledSuper = false;
            onPageScrolled(i4, f2, (int) (i3 * f2));
            if (this.mCalledSuper) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        return invokeI.booleanValue;
    }

    public boolean pageUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            int i = this.mCurItem;
            if (i > 0) {
                setCurrentItem(i - 1, false);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void populate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            populate(this.mCurItem);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, view2) == null) {
            if (this.mInLayout) {
                removeViewInLayout(view2);
            } else {
                super.removeView(view2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.disallowIntercept = z;
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, pagerAdapter) == null) {
            PagerAdapter pagerAdapter2 = this.mAdapter;
            if (pagerAdapter2 != null) {
                pagerAdapter2.unregisterDataSetObserver(this.mObserver);
                this.mAdapter.startUpdate((ViewGroup) this);
                for (int i = 0; i < this.mItems.size(); i++) {
                    ItemInfo itemInfo = this.mItems.get(i);
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                }
                this.mAdapter.finishUpdate((ViewGroup) this);
                this.mItems.clear();
                removeNonDecorViews();
                this.mCurItem = 0;
                scrollTo(0, 0);
            }
            PagerAdapter pagerAdapter3 = this.mAdapter;
            this.mAdapter = pagerAdapter;
            this.mExpectedAdapterCount = 0;
            if (pagerAdapter != null) {
                if (this.mObserver == null) {
                    this.mObserver = new PagerObserver();
                }
                this.mAdapter.registerDataSetObserver(this.mObserver);
                this.mPopulatePending = false;
                boolean z = this.mFirstLayout;
                this.mFirstLayout = true;
                this.mExpectedAdapterCount = this.mAdapter.getCount();
                if (this.mRestoredCurItem >= 0) {
                    this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                    setCurrentItemInternal(this.mRestoredCurItem, false, true);
                    this.mRestoredCurItem = -1;
                    this.mRestoredAdapterState = null;
                    this.mRestoredClassLoader = null;
                } else if (!z) {
                    populate();
                } else {
                    requestLayout();
                }
            }
            OnAdapterChangeListener onAdapterChangeListener = this.mAdapterChangeListener;
            if (onAdapterChangeListener == null || pagerAdapter3 == pagerAdapter) {
                return;
            }
            onAdapterChangeListener.onAdapterChanged(pagerAdapter3, pagerAdapter);
        }
    }

    public void setCallback(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, callback) == null) {
            this.mCallback = callback;
        }
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048629, this, z) == null) || Build.VERSION.SDK_INT < 7) {
            return;
        }
        if (this.mSetChildrenDrawingOrderEnabled == null) {
            try {
                this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e) {
                Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
            }
        }
        try {
            if (this.mSetChildrenDrawingOrderEnabled != null) {
                this.mSetChildrenDrawingOrderEnabled.invoke(this, Boolean.valueOf(z));
            }
        } catch (Exception e2) {
            Log.e("ViewPager", "Error changing children drawing order", e2);
        }
    }

    public void setCurrentItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            this.mPopulatePending = false;
            setCurrentItemInternal(i, !this.mFirstLayout, false);
        }
    }

    public void setCurrentItemInternal(int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            setCurrentItemInternal(i, z, z2, 0);
        }
    }

    public void setDetermineYRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048634, this, f) == null) {
            this.mDetermineYRatio = f;
        }
    }

    public ViewPager.OnPageChangeListener setInternalPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, onPageChangeListener)) == null) {
            ViewPager.OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
            this.mInternalPageChangeListener = onPageChangeListener;
            return onPageChangeListener2;
        }
        return (ViewPager.OnPageChangeListener) invokeL.objValue;
    }

    public void setIsScrollable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.mIsScrollable = z;
        }
    }

    public void setOffscreenPageLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i) == null) {
            if (i < 1) {
                Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
                i = 1;
            }
            if (i != this.mOffscreenPageLimit) {
                this.mOffscreenPageLimit = i;
                populate();
            }
        }
    }

    public void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, onAdapterChangeListener) == null) {
            this.mAdapterChangeListener = onAdapterChangeListener;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onPageChangeListener) == null) {
            this.mOnPageChangeListener = onPageChangeListener;
        }
    }

    public void setPageMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i) == null) {
            int i2 = this.mPageMargin;
            this.mPageMargin = i;
            int height = getHeight();
            recomputeScrollPosition(height, height, i, i2);
            requestLayout();
        }
    }

    public void setPageMarginDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, drawable) == null) {
            this.mMarginDrawable = drawable;
            if (drawable != null) {
                refreshDrawableState();
            }
            setWillNotDraw(drawable == null);
            invalidate();
        }
    }

    public void setPageTransformer(boolean z, ViewPager.PageTransformer pageTransformer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048643, this, z, pageTransformer) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        boolean z2 = pageTransformer != null;
        boolean z3 = z2 != (this.mPageTransformer != null);
        this.mPageTransformer = pageTransformer;
        setChildrenDrawingOrderEnabledCompat(z2);
        if (z2) {
            this.mDrawingOrder = z ? 2 : 1;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z3) {
            populate();
        }
    }

    public void smoothScrollTo(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048644, this, i, i2) == null) {
            smoothScrollTo(i, i2, 0);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, drawable)) == null) ? super.verifyDrawable(drawable) || drawable == this.mMarginDrawable : invokeL.booleanValue;
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int childIndex;
        public int gravity;
        public float heightFactor;
        public boolean isDecor;
        public boolean needsMeasure;
        public int position;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams() {
            super(-1, -1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.heightFactor = 0.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.heightFactor = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AlaVerticalViewPagerNew.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
        if (r10 == r11) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void populate(int i) {
        int i2;
        ItemInfo itemInfo;
        String hexString;
        ItemInfo itemInfo2;
        ItemInfo infoForChild;
        ItemInfo itemInfo3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            int i3 = this.mCurItem;
            if (i3 != i) {
                i2 = i3 < i ? 130 : 33;
                itemInfo = infoForPosition(this.mCurItem);
                this.mCurItem = i;
            } else {
                i2 = 2;
                itemInfo = null;
            }
            if (this.mAdapter == null) {
                sortChildDrawingOrder();
            } else if (this.mPopulatePending) {
                sortChildDrawingOrder();
            } else if (getWindowToken() != null) {
                this.mAdapter.startUpdate((ViewGroup) this);
                int i4 = this.mOffscreenPageLimit;
                int max = Math.max(0, this.mCurItem - i4);
                int count = this.mAdapter.getCount();
                int min = Math.min(count - 1, this.mCurItem + i4);
                if (count == this.mExpectedAdapterCount) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= this.mItems.size()) {
                            break;
                        }
                        itemInfo2 = this.mItems.get(i5);
                        int i6 = itemInfo2.position;
                        int i7 = this.mCurItem;
                        if (i6 < i7) {
                            i5++;
                        }
                    }
                    itemInfo2 = null;
                    if (itemInfo2 == null && count > 0) {
                        itemInfo2 = addNewItem(this.mCurItem, i5);
                    }
                    if (itemInfo2 != null) {
                        int i8 = i5 - 1;
                        ItemInfo itemInfo4 = i8 >= 0 ? this.mItems.get(i8) : null;
                        int clientHeight = getClientHeight();
                        float paddingLeft = clientHeight <= 0 ? 0.0f : (2.0f - itemInfo2.heightFactor) + (getPaddingLeft() / clientHeight);
                        float f = 0.0f;
                        for (int i9 = this.mCurItem - 1; i9 >= 0; i9--) {
                            if (f < paddingLeft || i9 >= max) {
                                if (itemInfo4 != null && i9 == itemInfo4.position) {
                                    f += itemInfo4.heightFactor;
                                    i8--;
                                    if (i8 >= 0) {
                                        itemInfo3 = this.mItems.get(i8);
                                        itemInfo4 = itemInfo3;
                                    }
                                    itemInfo3 = null;
                                    itemInfo4 = itemInfo3;
                                } else {
                                    f += addNewItem(i9, i8 + 1).heightFactor;
                                    i5++;
                                    if (i8 >= 0) {
                                        itemInfo3 = this.mItems.get(i8);
                                        itemInfo4 = itemInfo3;
                                    }
                                    itemInfo3 = null;
                                    itemInfo4 = itemInfo3;
                                }
                            } else if (itemInfo4 == null) {
                                break;
                            } else {
                                if (i9 == itemInfo4.position && !itemInfo4.scrolling) {
                                    this.mItems.remove(i8);
                                    this.mAdapter.destroyItem((ViewGroup) this, i9, itemInfo4.object);
                                    i8--;
                                    i5--;
                                    if (i8 >= 0) {
                                        itemInfo3 = this.mItems.get(i8);
                                        itemInfo4 = itemInfo3;
                                    }
                                    itemInfo3 = null;
                                    itemInfo4 = itemInfo3;
                                }
                            }
                        }
                        float f2 = itemInfo2.heightFactor;
                        int i10 = i5 + 1;
                        if (f2 < 2.0f) {
                            ItemInfo itemInfo5 = i10 < this.mItems.size() ? this.mItems.get(i10) : null;
                            float paddingRight = clientHeight <= 0 ? 0.0f : (getPaddingRight() / clientHeight) + 2.0f;
                            int i11 = this.mCurItem;
                            while (true) {
                                i11++;
                                if (i11 >= count) {
                                    break;
                                } else if (f2 < paddingRight || i11 <= min) {
                                    if (itemInfo5 != null && i11 == itemInfo5.position) {
                                        f2 += itemInfo5.heightFactor;
                                        i10++;
                                        if (i10 < this.mItems.size()) {
                                            itemInfo5 = this.mItems.get(i10);
                                        }
                                    } else {
                                        ItemInfo addNewItem = addNewItem(i11, i10);
                                        i10++;
                                        f2 += addNewItem.heightFactor;
                                        itemInfo5 = i10 < this.mItems.size() ? this.mItems.get(i10) : null;
                                    }
                                } else if (itemInfo5 == null) {
                                    break;
                                } else if (i11 == itemInfo5.position && !itemInfo5.scrolling) {
                                    this.mItems.remove(i10);
                                    this.mAdapter.destroyItem((ViewGroup) this, i11, itemInfo5.object);
                                    if (i10 < this.mItems.size()) {
                                        itemInfo5 = this.mItems.get(i10);
                                    }
                                }
                            }
                        }
                        calculatePageOffsets(itemInfo2, i5, itemInfo);
                    }
                    this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, itemInfo2 != null ? itemInfo2.object : null);
                    this.mAdapter.finishUpdate((ViewGroup) this);
                    int childCount = getChildCount();
                    for (int i12 = 0; i12 < childCount; i12++) {
                        View childAt = getChildAt(i12);
                        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                        layoutParams.childIndex = i12;
                        if (!layoutParams.isDecor && layoutParams.heightFactor == 0.0f && (infoForChild = infoForChild(childAt)) != null) {
                            layoutParams.heightFactor = infoForChild.heightFactor;
                            layoutParams.position = infoForChild.position;
                        }
                    }
                    sortChildDrawingOrder();
                    if (hasFocus()) {
                        View findFocus = findFocus();
                        ItemInfo infoForAnyChild = findFocus != null ? infoForAnyChild(findFocus) : null;
                        if (infoForAnyChild == null || infoForAnyChild.position != this.mCurItem) {
                            for (int i13 = 0; i13 < getChildCount(); i13++) {
                                View childAt2 = getChildAt(i13);
                                ItemInfo infoForChild2 = infoForChild(childAt2);
                                if (infoForChild2 != null && infoForChild2.position == this.mCurItem && childAt2.requestFocus(i2)) {
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                try {
                    hexString = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException unused) {
                    hexString = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + count + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
            }
        }
    }

    public void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            PagerAdapter pagerAdapter = this.mAdapter;
            if (pagerAdapter != null && pagerAdapter.getCount() > 0) {
                if (!z2 && this.mCurItem == i && this.mItems.size() != 0) {
                    setScrollingCacheEnabled(false);
                    return;
                }
                if (i < 0) {
                    i = 0;
                } else if (i >= this.mAdapter.getCount()) {
                    i = this.mAdapter.getCount() - 1;
                }
                int i3 = this.mOffscreenPageLimit;
                int i4 = this.mCurItem;
                if (i > i4 + i3 || i < i4 - i3) {
                    for (int i5 = 0; i5 < this.mItems.size(); i5++) {
                        this.mItems.get(i5).scrolling = true;
                    }
                }
                boolean z3 = this.mCurItem != i;
                if (this.mFirstLayout) {
                    this.mCurItem = i;
                    if (z3 && (onPageChangeListener2 = this.mOnPageChangeListener) != null) {
                        onPageChangeListener2.onPageSelected(i);
                    }
                    if (z3 && (onPageChangeListener = this.mInternalPageChangeListener) != null) {
                        onPageChangeListener.onPageSelected(i);
                    }
                    requestLayout();
                    return;
                }
                populate(i);
                scrollToItem(i, z, i2, z3);
                return;
            }
            setScrollingCacheEnabled(false);
        }
    }

    public void smoothScrollTo(int i, int i2, int i3) {
        int abs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048645, this, i, i2, i3) == null) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int i4 = i - scrollX;
            int i5 = i2 - scrollY;
            if (i4 == 0 && i5 == 0) {
                completeScroll(false);
                populate();
                setScrollState(0);
                return;
            }
            setScrollingCacheEnabled(true);
            setScrollState(2);
            int clientHeight = getClientHeight();
            int i6 = clientHeight / 2;
            float f = clientHeight;
            float f2 = i6;
            float distanceInfluenceForSnapDuration = f2 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i4) * 1.0f) / f)) * f2);
            int abs2 = Math.abs(i3);
            if (abs2 > 0) {
                abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs2) * 1000.0f) * 4;
                Log.e(MixTagConstants.MIX_PAGER, "smoothScrollTo1 " + scrollX + " " + scrollY + " " + i4 + " " + i5 + " " + abs + " " + abs2);
            } else {
                abs = (int) (((Math.abs(i4) / ((f * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 500.0f);
                Log.e(MixTagConstants.MIX_PAGER, "smoothScrollTo2 " + scrollX + " " + scrollY + " " + i4 + " " + i5 + " " + abs);
            }
            this.mScroller.startScroll(scrollX, scrollY, i4, i5, Math.min(abs, 2000));
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.mPopulatePending = false;
            setCurrentItemInternal(i, z, false);
        }
    }

    public void setPageMarginDrawable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i) == null) {
            setPageMarginDrawable(getContext().getResources().getDrawable(i));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaVerticalViewPagerNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mIsScrollable = true;
        this.isPointerCountValid = false;
        this.disallowIntercept = false;
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable(this) { // from class: com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AlaVerticalViewPagerNew this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                    this.this$0.setScrollState(0);
                    this.this$0.populate();
                }
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }
}
