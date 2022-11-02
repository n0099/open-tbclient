package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    public static final float MAX_SCROLL_FACTOR = 0.33333334f;
    public static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final AnchorInfo mAnchorInfo;
    public int mInitialPrefetchItemCount;
    public boolean mLastStackFromEnd;
    public final LayoutChunkResult mLayoutChunkResult;
    public LayoutState mLayoutState;
    public int mOrientation;
    public OrientationHelper mOrientationHelper;
    public SavedState mPendingSavedState;
    public int mPendingScrollPosition;
    public int mPendingScrollPositionOffset;
    public boolean mRecycleChildrenOnDetach;
    public int[] mReusableIntPair;
    public boolean mReverseLayout;
    public boolean mShouldReverseLayout;
    public boolean mSmoothScrollbarEnabled;
    public boolean mStackFromEnd;

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048615, this, recycler, state, anchorInfo, i) == null) {
        }
    }

    /* loaded from: classes.dex */
    public static class AnchorInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mCoordinate;
        public boolean mLayoutFromEnd;
        public OrientationHelper mOrientationHelper;
        public int mPosition;
        public boolean mValid;

        public AnchorInfo() {
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
            reset();
        }

        public void assignCoordinateFromPadding() {
            int startAfterPadding;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.mLayoutFromEnd) {
                    startAfterPadding = this.mOrientationHelper.getEndAfterPadding();
                } else {
                    startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                }
                this.mCoordinate = startAfterPadding;
            }
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.mPosition = -1;
                this.mCoordinate = Integer.MIN_VALUE;
                this.mLayoutFromEnd = false;
                this.mValid = false;
            }
        }

        public void assignFromView(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = this.mOrientationHelper.getDecoratedEnd(view2) + this.mOrientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = this.mOrientationHelper.getDecoratedStart(view2);
                }
                this.mPosition = i;
            }
        }

        public boolean isViewValidAsAnchor(View view2, RecyclerView.State state) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, state)) == null) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view2.getLayoutParams();
                if (!layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.getItemCount()) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public void assignFromViewAndKeepVisibleRect(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i) == null) {
                int totalSpaceChange = this.mOrientationHelper.getTotalSpaceChange();
                if (totalSpaceChange >= 0) {
                    assignFromView(view2, i);
                    return;
                }
                this.mPosition = i;
                if (this.mLayoutFromEnd) {
                    int endAfterPadding = (this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - this.mOrientationHelper.getDecoratedEnd(view2);
                    this.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - endAfterPadding;
                    if (endAfterPadding > 0) {
                        int decoratedMeasurement = this.mCoordinate - this.mOrientationHelper.getDecoratedMeasurement(view2);
                        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                        int min = decoratedMeasurement - (startAfterPadding + Math.min(this.mOrientationHelper.getDecoratedStart(view2) - startAfterPadding, 0));
                        if (min < 0) {
                            this.mCoordinate += Math.min(endAfterPadding, -min);
                            return;
                        }
                        return;
                    }
                    return;
                }
                int decoratedStart = this.mOrientationHelper.getDecoratedStart(view2);
                int startAfterPadding2 = decoratedStart - this.mOrientationHelper.getStartAfterPadding();
                this.mCoordinate = decoratedStart;
                if (startAfterPadding2 > 0) {
                    int endAfterPadding2 = (this.mOrientationHelper.getEndAfterPadding() - Math.min(0, (this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - this.mOrientationHelper.getDecoratedEnd(view2))) - (decoratedStart + this.mOrientationHelper.getDecoratedMeasurement(view2));
                    if (endAfterPadding2 < 0) {
                        this.mCoordinate -= Math.min(startAfterPadding2, -endAfterPadding2);
                    }
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutChunkResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        public LayoutChunkResult() {
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

        public void resetInternal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mConsumed = 0;
                this.mFinished = false;
                this.mIgnoreConsumed = false;
                this.mFocusable = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutState {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        public static final int ITEM_DIRECTION_HEAD = -1;
        public static final int ITEM_DIRECTION_TAIL = 1;
        public static final int LAYOUT_END = 1;
        public static final int LAYOUT_START = -1;
        public static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        public static final String TAG = "LLM#LayoutState";
        public transient /* synthetic */ FieldHolder $fh;
        public int mAvailable;
        public int mCurrentPosition;
        public int mExtraFillSpace;
        public boolean mInfinite;
        public boolean mIsPreLayout;
        public int mItemDirection;
        public int mLastScrollDelta;
        public int mLayoutDirection;
        public int mNoRecycleSpace;
        public int mOffset;
        public boolean mRecycle;
        public List<RecyclerView.ViewHolder> mScrapList;
        public int mScrollingOffset;

        public LayoutState() {
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
            this.mRecycle = true;
            this.mExtraFillSpace = 0;
            this.mNoRecycleSpace = 0;
            this.mIsPreLayout = false;
            this.mScrapList = null;
        }

        public void assignPositionFromScrapList() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                assignPositionFromScrapList(null);
            }
        }

        private View nextViewFromScrapList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                int size = this.mScrapList.size();
                for (int i = 0; i < size; i++) {
                    View view2 = this.mScrapList.get(i).itemView;
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view2.getLayoutParams();
                    if (!layoutParams.isItemRemoved() && this.mCurrentPosition == layoutParams.getViewLayoutPosition()) {
                        assignPositionFromScrapList(view2);
                        return view2;
                    }
                }
                return null;
            }
            return (View) invokeV.objValue;
        }

        public void assignPositionFromScrapList(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                View nextViewInLimitedList = nextViewInLimitedList(view2);
                if (nextViewInLimitedList == null) {
                    this.mCurrentPosition = -1;
                } else {
                    this.mCurrentPosition = ((RecyclerView.LayoutParams) nextViewInLimitedList.getLayoutParams()).getViewLayoutPosition();
                }
            }
        }

        public boolean hasMore(RecyclerView.State state) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, state)) == null) {
                int i = this.mCurrentPosition;
                if (i >= 0 && i < state.getItemCount()) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public View next(RecyclerView.Recycler recycler) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, recycler)) == null) {
                if (this.mScrapList != null) {
                    return nextViewFromScrapList();
                }
                View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
                this.mCurrentPosition += this.mItemDirection;
                return viewForPosition;
            }
            return (View) invokeL.objValue;
        }

        public void log() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                Log.d(TAG, "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
            }
        }

        public View nextViewInLimitedList(View view2) {
            InterceptResult invokeL;
            int viewLayoutPosition;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
                int size = this.mScrapList.size();
                View view3 = null;
                int i = Integer.MAX_VALUE;
                for (int i2 = 0; i2 < size; i2++) {
                    View view4 = this.mScrapList.get(i2).itemView;
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view4.getLayoutParams();
                    if (view4 != view2 && !layoutParams.isItemRemoved() && (viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection) >= 0 && viewLayoutPosition < i) {
                        view3 = view4;
                        if (viewLayoutPosition == 0) {
                            break;
                        }
                        i = viewLayoutPosition;
                    }
                }
                return view3;
            }
            return (View) invokeL.objValue;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mAnchorLayoutFromEnd;
        public int mAnchorOffset;
        public int mAnchorPosition;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-807573071, "Landroidx/recyclerview/widget/LinearLayoutManager$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-807573071, "Landroidx/recyclerview/widget/LinearLayoutManager$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.LinearLayoutManager.SavedState.1
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
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new SavedState(parcel);
                    }
                    return (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new SavedState[i];
                    }
                    return (SavedState[]) invokeI.objValue;
                }
            };
        }

        public SavedState() {
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

        public boolean hasValidAnchor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.mAnchorPosition >= 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void invalidateAnchor() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mAnchorPosition = -1;
            }
        }

        public SavedState(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {savedState};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
                parcel.writeInt(this.mAnchorPosition);
                parcel.writeInt(this.mAnchorOffset);
                parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinearLayoutManager(Context context) {
        this(context, 1, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            if (i != 0 && i != 1) {
                throw new IllegalArgumentException("invalid orientation:" + i);
            }
            assertNotInLayoutOrScroll(null);
            if (i != this.mOrientation || this.mOrientationHelper == null) {
                OrientationHelper createOrientationHelper = OrientationHelper.createOrientationHelper(this, i);
                this.mOrientationHelper = createOrientationHelper;
                this.mAnchorInfo.mOrientationHelper = createOrientationHelper;
                this.mOrientation = i;
                requestLayout();
            }
        }
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        setReverseLayout(z);
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        InterceptResult invokeLLL;
        View findReferenceChildClosestToStart;
        int startAfterPadding;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65561, this, recycler, state, anchorInfo)) == null) {
            boolean z = false;
            if (getChildCount() == 0) {
                return false;
            }
            View focusedChild = getFocusedChild();
            if (focusedChild != null && anchorInfo.isViewValidAsAnchor(focusedChild, state)) {
                anchorInfo.assignFromViewAndKeepVisibleRect(focusedChild, getPosition(focusedChild));
                return true;
            } else if (this.mLastStackFromEnd != this.mStackFromEnd) {
                return false;
            } else {
                if (anchorInfo.mLayoutFromEnd) {
                    findReferenceChildClosestToStart = findReferenceChildClosestToEnd(recycler, state);
                } else {
                    findReferenceChildClosestToStart = findReferenceChildClosestToStart(recycler, state);
                }
                if (findReferenceChildClosestToStart == null) {
                    return false;
                }
                anchorInfo.assignFromView(findReferenceChildClosestToStart, getPosition(findReferenceChildClosestToStart));
                if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                    if ((this.mOrientationHelper.getDecoratedStart(findReferenceChildClosestToStart) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(findReferenceChildClosestToStart) < this.mOrientationHelper.getStartAfterPadding()) ? true : true) {
                        if (anchorInfo.mLayoutFromEnd) {
                            startAfterPadding = this.mOrientationHelper.getEndAfterPadding();
                        } else {
                            startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                        }
                        anchorInfo.mCoordinate = startAfterPadding;
                    }
                }
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }

    public int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{recycler, layoutState, state, Boolean.valueOf(z)})) == null) {
            int i = layoutState.mAvailable;
            int i2 = layoutState.mScrollingOffset;
            if (i2 != Integer.MIN_VALUE) {
                if (i < 0) {
                    layoutState.mScrollingOffset = i2 + i;
                }
                recycleByLayoutState(recycler, layoutState);
            }
            int i3 = layoutState.mAvailable + layoutState.mExtraFillSpace;
            LayoutChunkResult layoutChunkResult = this.mLayoutChunkResult;
            while (true) {
                if ((!layoutState.mInfinite && i3 <= 0) || !layoutState.hasMore(state)) {
                    break;
                }
                layoutChunkResult.resetInternal();
                layoutChunk(recycler, state, layoutState, layoutChunkResult);
                if (!layoutChunkResult.mFinished) {
                    layoutState.mOffset += layoutChunkResult.mConsumed * layoutState.mLayoutDirection;
                    if (!layoutChunkResult.mIgnoreConsumed || layoutState.mScrapList != null || !state.isPreLayout()) {
                        int i4 = layoutState.mAvailable;
                        int i5 = layoutChunkResult.mConsumed;
                        layoutState.mAvailable = i4 - i5;
                        i3 -= i5;
                    }
                    int i6 = layoutState.mScrollingOffset;
                    if (i6 != Integer.MIN_VALUE) {
                        int i7 = i6 + layoutChunkResult.mConsumed;
                        layoutState.mScrollingOffset = i7;
                        int i8 = layoutState.mAvailable;
                        if (i8 < 0) {
                            layoutState.mScrollingOffset = i7 + i8;
                        }
                        recycleByLayoutState(recycler, layoutState);
                    }
                    if (z && layoutChunkResult.mFocusable) {
                        break;
                    }
                } else {
                    break;
                }
            }
            return i - layoutState.mAvailable;
        }
        return invokeCommon.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view2, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeLILL;
        int convertFocusDirectionToLayoutDirection;
        View findPartiallyOrCompletelyInvisibleChildClosestToEnd;
        View childClosestToEnd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048617, this, view2, i, recycler, state)) == null) {
            resolveShouldLayoutReverse();
            if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
                return null;
            }
            ensureLayoutState();
            updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.getTotalSpace() * 0.33333334f), false, state);
            LayoutState layoutState = this.mLayoutState;
            layoutState.mScrollingOffset = Integer.MIN_VALUE;
            layoutState.mRecycle = false;
            fill(recycler, layoutState, state, true);
            if (convertFocusDirectionToLayoutDirection == -1) {
                findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToStart();
            } else {
                findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
            }
            if (convertFocusDirectionToLayoutDirection == -1) {
                childClosestToEnd = getChildClosestToStart();
            } else {
                childClosestToEnd = getChildClosestToEnd();
            }
            if (childClosestToEnd.hasFocusable()) {
                if (findPartiallyOrCompletelyInvisibleChildClosestToEnd == null) {
                    return null;
                }
                return childClosestToEnd;
            }
            return findPartiallyOrCompletelyInvisibleChildClosestToEnd;
        }
        return (View) invokeLILL.objValue;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public void prepareForDrop(@NonNull View view2, @NonNull View view3, int i, int i2) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048623, this, view2, view3, i, i2) == null) {
            assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
            ensureLayoutState();
            resolveShouldLayoutReverse();
            int position = getPosition(view2);
            int position2 = getPosition(view3);
            if (position < position2) {
                c = 1;
            } else {
                c = 65535;
            }
            if (this.mShouldReverseLayout) {
                if (c == 1) {
                    scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(view3) + this.mOrientationHelper.getDecoratedMeasurement(view2)));
                } else {
                    scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view3));
                }
            } else if (c == 65535) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedStart(view3));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedEnd(view3) - this.mOrientationHelper.getDecoratedMeasurement(view2));
            }
        }
    }

    private int computeScrollExtent(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, state)) == null) {
            if (getChildCount() == 0) {
                return 0;
            }
            ensureLayoutState();
            return ScrollbarHelper.computeScrollExtent(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
        }
        return invokeL.intValue;
    }

    private int computeScrollOffset(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, state)) == null) {
            if (getChildCount() == 0) {
                return 0;
            }
            ensureLayoutState();
            return ScrollbarHelper.computeScrollOffset(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
        }
        return invokeL.intValue;
    }

    private int computeScrollRange(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, state)) == null) {
            if (getChildCount() == 0) {
                return 0;
            }
            ensureLayoutState();
            return ScrollbarHelper.computeScrollRange(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (getChildCount() == 0) {
                return null;
            }
            boolean z = false;
            int i2 = 1;
            if (i < getPosition(getChildAt(0))) {
                z = true;
            }
            if (z != this.mShouldReverseLayout) {
                i2 = -1;
            }
            if (this.mOrientation == 0) {
                return new PointF(i2, 0.0f);
            }
            return new PointF(0.0f, i2);
        }
        return (PointF) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            int childCount = getChildCount();
            if (childCount == 0) {
                return null;
            }
            int position = i - getPosition(getChildAt(0));
            if (position >= 0 && position < childCount) {
                View childAt = getChildAt(position);
                if (getPosition(childAt) == i) {
                    return childAt;
                }
            }
            return super.findViewByPosition(i);
        }
        return (View) invokeI.objValue;
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
        }
        return (View) invokeV.objValue;
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
        }
        return (View) invokeV.objValue;
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.mShouldReverseLayout) {
                return findFirstPartiallyOrCompletelyInvisibleChild();
            }
            return findLastPartiallyOrCompletelyInvisibleChild();
        }
        return (View) invokeV.objValue;
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.mShouldReverseLayout) {
                return findLastPartiallyOrCompletelyInvisibleChild();
            }
            return findFirstPartiallyOrCompletelyInvisibleChild();
        }
        return (View) invokeV.objValue;
    }

    private View getChildClosestToEnd() {
        InterceptResult invokeV;
        int childCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if (this.mShouldReverseLayout) {
                childCount = 0;
            } else {
                childCount = getChildCount() - 1;
            }
            return getChildAt(childCount);
        }
        return (View) invokeV.objValue;
    }

    private View getChildClosestToStart() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            if (this.mShouldReverseLayout) {
                i = getChildCount() - 1;
            } else {
                i = 0;
            }
            return getChildAt(i);
        }
        return (View) invokeV.objValue;
    }

    private void resolveShouldLayoutReverse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            if (this.mOrientation != 1 && isLayoutRTL()) {
                this.mShouldReverseLayout = !this.mReverseLayout;
            } else {
                this.mShouldReverseLayout = this.mReverseLayout;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mOrientation == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mOrientation == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public LayoutState createLayoutState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return new LayoutState();
        }
        return (LayoutState) invokeV.objValue;
    }

    public void ensureLayoutState() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int findFirstCompletelyVisibleItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
            if (findOneVisibleChild == null) {
                return -1;
            }
            return getPosition(findOneVisibleChild);
        }
        return invokeV.intValue;
    }

    public int findFirstVisibleItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
            if (findOneVisibleChild == null) {
                return -1;
            }
            return getPosition(findOneVisibleChild);
        }
        return invokeV.intValue;
    }

    public int findLastCompletelyVisibleItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
            if (findOneVisibleChild == null) {
                return -1;
            }
            return getPosition(findOneVisibleChild);
        }
        return invokeV.intValue;
    }

    public int findLastVisibleItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
            if (findOneVisibleChild == null) {
                return -1;
            }
            return getPosition(findOneVisibleChild);
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return new RecyclerView.LayoutParams(-2, -2);
        }
        return (RecyclerView.LayoutParams) invokeV.objValue;
    }

    public int getInitialPrefetchItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mInitialPrefetchItemCount;
        }
        return invokeV.intValue;
    }

    public int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mOrientation;
        }
        return invokeV.intValue;
    }

    public boolean getRecycleChildrenOnDetach() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mRecycleChildrenOnDetach;
        }
        return invokeV.booleanValue;
    }

    public boolean getReverseLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.mReverseLayout;
        }
        return invokeV.booleanValue;
    }

    public boolean getStackFromEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mStackFromEnd;
        }
        return invokeV.booleanValue;
    }

    public boolean isLayoutRTL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (getLayoutDirection() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSmoothScrollbarEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mSmoothScrollbarEnabled;
        }
        return invokeV.booleanValue;
    }

    public boolean resolveIsInfinite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean shouldMeasureTwice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (getHeightMode() != 1073741824 && getWidthMode() != 1073741824 && hasFlexibleChildInBothOrientations()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private View findFirstReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, recycler, state)) == null) {
            return findReferenceChild(recycler, state, 0, getChildCount(), state.getItemCount());
        }
        return (View) invokeLL.objValue;
    }

    private View findLastReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, recycler, state)) == null) {
            return findReferenceChild(recycler, state, getChildCount() - 1, -1, state.getItemCount());
        }
        return (View) invokeLL.objValue;
    }

    private View findReferenceChildClosestToEnd(RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, recycler, state)) == null) {
            if (this.mShouldReverseLayout) {
                return findFirstReferenceChild(recycler, state);
            }
            return findLastReferenceChild(recycler, state);
        }
        return (View) invokeLL.objValue;
    }

    private View findReferenceChildClosestToStart(RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, recycler, state)) == null) {
            if (this.mShouldReverseLayout) {
                return findLastReferenceChild(recycler, state);
            }
            return findFirstReferenceChild(recycler, state);
        }
        return (View) invokeLL.objValue;
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65556, this, recycler, layoutState) == null) && layoutState.mRecycle && !layoutState.mInfinite) {
            int i = layoutState.mScrollingOffset;
            int i2 = layoutState.mNoRecycleSpace;
            if (layoutState.mLayoutDirection == -1) {
                recycleViewsFromEnd(recycler, i, i2);
            } else {
                recycleViewsFromStart(recycler, i, i2);
            }
        }
    }

    public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, state, iArr) == null) {
            int extraLayoutSpace = getExtraLayoutSpace(state);
            if (this.mLayoutState.mLayoutDirection == -1) {
                i = 0;
            } else {
                i = extraLayoutSpace;
                extraLayoutSpace = 0;
            }
            iArr[0] = extraLayoutSpace;
            iArr[1] = i;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, recyclerView, recycler) == null) {
            super.onDetachedFromWindow(recyclerView, recycler);
            if (this.mRecycleChildrenOnDetach) {
                removeAndRecycleAllViews(recycler);
                recycler.clear();
            }
        }
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048628, this, i, i2) == null) {
            this.mPendingScrollPosition = i;
            this.mPendingScrollPositionOffset = i2;
            SavedState savedState = this.mPendingSavedState;
            if (savedState != null) {
                savedState.invalidateAnchor();
            }
            requestLayout();
        }
    }

    private int fixLayoutEndGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        InterceptResult invokeCommon;
        int endAfterPadding;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, this, new Object[]{Integer.valueOf(i), recycler, state, Boolean.valueOf(z)})) == null) {
            int endAfterPadding2 = this.mOrientationHelper.getEndAfterPadding() - i;
            if (endAfterPadding2 > 0) {
                int i2 = -scrollBy(-endAfterPadding2, recycler, state);
                int i3 = i + i2;
                if (z && (endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i3) > 0) {
                    this.mOrientationHelper.offsetChildren(endAfterPadding);
                    return endAfterPadding + i2;
                }
                return i2;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        InterceptResult invokeCommon;
        int startAfterPadding;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, this, new Object[]{Integer.valueOf(i), recycler, state, Boolean.valueOf(z)})) == null) {
            int startAfterPadding2 = i - this.mOrientationHelper.getStartAfterPadding();
            if (startAfterPadding2 > 0) {
                int i2 = -scrollBy(startAfterPadding2, recycler, state);
                int i3 = i + i2;
                if (z && (startAfterPadding = i3 - this.mOrientationHelper.getStartAfterPadding()) > 0) {
                    this.mOrientationHelper.offsetChildren(-startAfterPadding);
                    return i2 - startAfterPadding;
                }
                return i2;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), state, layoutPrefetchRegistry}) == null) {
            if (this.mOrientation != 0) {
                i = i2;
            }
            if (getChildCount() != 0 && i != 0) {
                ensureLayoutState();
                if (i > 0) {
                    i3 = 1;
                } else {
                    i3 = -1;
                }
                updateLayoutState(i3, Math.abs(i), true, state);
                collectPrefetchPositionsForLayoutState(state, this.mLayoutState, layoutPrefetchRegistry);
            }
        }
    }

    public View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            ensureLayoutState();
            int i4 = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
            if (z) {
                i3 = 24579;
            } else {
                i3 = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
            }
            if (!z2) {
                i4 = 0;
            }
            if (this.mOrientation == 0) {
                return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(i, i2, i3, i4);
            }
            return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(i, i2, i3, i4);
        }
        return (View) invokeCommon.objValue;
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLII(65554, this, recycler, state, i, i2) == null) && state.willRunPredictiveAnimations() && getChildCount() != 0 && !state.isPreLayout() && supportsPredictiveItemAnimations()) {
            List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
            int size = scrapList.size();
            int position = getPosition(getChildAt(0));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.ViewHolder viewHolder = scrapList.get(i5);
                if (!viewHolder.isRemoved()) {
                    char c = 1;
                    if (viewHolder.getLayoutPosition() < position) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z != this.mShouldReverseLayout) {
                        c = 65535;
                    }
                    if (c == 65535) {
                        i3 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                    } else {
                        i4 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                    }
                }
            }
            this.mLayoutState.mScrapList = scrapList;
            if (i3 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
                LayoutState layoutState = this.mLayoutState;
                layoutState.mExtraFillSpace = i3;
                layoutState.mAvailable = 0;
                layoutState.assignPositionFromScrapList();
                fill(recycler, this.mLayoutState, state, false);
            }
            if (i4 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
                LayoutState layoutState2 = this.mLayoutState;
                layoutState2.mExtraFillSpace = i4;
                layoutState2.mAvailable = 0;
                layoutState2.assignPositionFromScrapList();
                fill(recycler, this.mLayoutState, state, false);
            }
            this.mLayoutState.mScrapList = null;
        }
    }

    private void logChildren() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            Log.d(TAG, "internal representation of views on the screen");
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.getDecoratedStart(childAt));
            }
            Log.d(TAG, "==============");
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(65557, this, recycler, i, i2) != null) || i == i2) {
            return;
        }
        if (i2 > i) {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                removeAndRecycleViewAt(i3, recycler);
            }
            return;
        }
        while (i > i2) {
            removeAndRecycleViewAt(i, recycler);
            i--;
        }
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65563, this, recycler, state, anchorInfo) != null) || updateAnchorFromPendingData(state, anchorInfo) || updateAnchorFromChildren(recycler, state, anchorInfo)) {
            return;
        }
        anchorInfo.assignCoordinateFromPadding();
        if (this.mStackFromEnd) {
            i = state.getItemCount() - 1;
        } else {
            i = 0;
        }
        anchorInfo.mPosition = i;
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, state, layoutState, layoutPrefetchRegistry) == null) && (i = layoutState.mCurrentPosition) >= 0 && i < state.getItemCount()) {
            layoutPrefetchRegistry.addPosition(i, Math.max(0, layoutState.mScrollingOffset));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048626, this, i, recycler, state)) == null) {
            if (this.mOrientation == 1) {
                return 0;
            }
            return scrollBy(i, recycler, state);
        }
        return invokeILL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048629, this, i, recycler, state)) == null) {
            if (this.mOrientation == 0) {
                return 0;
            }
            return scrollBy(i, recycler, state);
        }
        return invokeILL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048637, this, recyclerView, state, i) == null) {
            LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
            linearSmoothScroller.setTargetPosition(i);
            startSmoothScroll(linearSmoothScroller);
        }
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler recycler, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65558, this, recycler, i, i2) == null) {
            int childCount = getChildCount();
            if (i < 0) {
                return;
            }
            int end = (this.mOrientationHelper.getEnd() - i) + i2;
            if (this.mShouldReverseLayout) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (this.mOrientationHelper.getDecoratedStart(childAt) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt) < end) {
                        recycleChildren(recycler, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = childCount - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View childAt2 = getChildAt(i5);
                if (this.mOrientationHelper.getDecoratedStart(childAt2) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt2) < end) {
                    recycleChildren(recycler, i4, i5);
                    return;
                }
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.Recycler recycler, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(65559, this, recycler, i, i2) != null) || i < 0) {
            return;
        }
        int i3 = i - i2;
        int childCount = getChildCount();
        if (this.mShouldReverseLayout) {
            int i4 = childCount - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View childAt = getChildAt(i5);
                if (this.mOrientationHelper.getDecoratedEnd(childAt) > i3 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt) > i3) {
                    recycleChildren(recycler, i4, i5);
                    return;
                }
            }
            return;
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = getChildAt(i6);
            if (this.mOrientationHelper.getDecoratedEnd(childAt2) > i3 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt2) > i3) {
                recycleChildren(recycler, 0, i6);
                return;
            }
        }
    }

    public int scrollBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeILL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048625, this, i, recycler, state)) == null) {
            if (getChildCount() == 0 || i == 0) {
                return 0;
            }
            ensureLayoutState();
            this.mLayoutState.mRecycle = true;
            if (i > 0) {
                i2 = 1;
            } else {
                i2 = -1;
            }
            int abs = Math.abs(i);
            updateLayoutState(i2, abs, true, state);
            LayoutState layoutState = this.mLayoutState;
            int fill = layoutState.mScrollingOffset + fill(recycler, layoutState, state, false);
            if (fill < 0) {
                return 0;
            }
            if (abs > fill) {
                i = i2 * fill;
            }
            this.mOrientationHelper.offsetChildren(-i);
            this.mLayoutState.mLastScrollDelta = i;
            return i;
        }
        return invokeILL.intValue;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        InterceptResult invokeLL;
        int i;
        boolean z;
        int decoratedStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, this, state, anchorInfo)) == null) {
            boolean z2 = false;
            if (!state.isPreLayout() && (i = this.mPendingScrollPosition) != -1) {
                if (i >= 0 && i < state.getItemCount()) {
                    anchorInfo.mPosition = this.mPendingScrollPosition;
                    SavedState savedState = this.mPendingSavedState;
                    if (savedState != null && savedState.hasValidAnchor()) {
                        boolean z3 = this.mPendingSavedState.mAnchorLayoutFromEnd;
                        anchorInfo.mLayoutFromEnd = z3;
                        if (z3) {
                            anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
                        } else {
                            anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                        }
                        return true;
                    } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                        View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                        if (findViewByPosition != null) {
                            if (this.mOrientationHelper.getDecoratedMeasurement(findViewByPosition) > this.mOrientationHelper.getTotalSpace()) {
                                anchorInfo.assignCoordinateFromPadding();
                                return true;
                            } else if (this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                                anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                                anchorInfo.mLayoutFromEnd = false;
                                return true;
                            } else if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition) < 0) {
                                anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                                anchorInfo.mLayoutFromEnd = true;
                                return true;
                            } else {
                                if (anchorInfo.mLayoutFromEnd) {
                                    decoratedStart = this.mOrientationHelper.getDecoratedEnd(findViewByPosition) + this.mOrientationHelper.getTotalSpaceChange();
                                } else {
                                    decoratedStart = this.mOrientationHelper.getDecoratedStart(findViewByPosition);
                                }
                                anchorInfo.mCoordinate = decoratedStart;
                            }
                        } else {
                            if (getChildCount() > 0) {
                                if (this.mPendingScrollPosition < getPosition(getChildAt(0))) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z == this.mShouldReverseLayout) {
                                    z2 = true;
                                }
                                anchorInfo.mLayoutFromEnd = z2;
                            }
                            anchorInfo.assignCoordinateFromPadding();
                        }
                        return true;
                    } else {
                        boolean z4 = this.mShouldReverseLayout;
                        anchorInfo.mLayoutFromEnd = z4;
                        if (z4) {
                            anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
                        } else {
                            anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                        }
                        return true;
                    }
                }
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void updateLayoutState(int i, int i2, boolean z, RecyclerView.State state) {
        int i3;
        int startAfterPadding;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), state}) == null) {
            this.mLayoutState.mInfinite = resolveIsInfinite();
            this.mLayoutState.mLayoutDirection = i;
            int[] iArr = this.mReusableIntPair;
            boolean z2 = false;
            iArr[0] = 0;
            int i4 = 1;
            iArr[1] = 0;
            calculateExtraLayoutSpace(state, iArr);
            int max = Math.max(0, this.mReusableIntPair[0]);
            int max2 = Math.max(0, this.mReusableIntPair[1]);
            if (i == 1) {
                z2 = true;
            }
            LayoutState layoutState = this.mLayoutState;
            if (z2) {
                i3 = max2;
            } else {
                i3 = max;
            }
            layoutState.mExtraFillSpace = i3;
            LayoutState layoutState2 = this.mLayoutState;
            if (!z2) {
                max = max2;
            }
            layoutState2.mNoRecycleSpace = max;
            if (z2) {
                this.mLayoutState.mExtraFillSpace += this.mOrientationHelper.getEndPadding();
                View childClosestToEnd = getChildClosestToEnd();
                LayoutState layoutState3 = this.mLayoutState;
                if (this.mShouldReverseLayout) {
                    i4 = -1;
                }
                layoutState3.mItemDirection = i4;
                LayoutState layoutState4 = this.mLayoutState;
                int position = getPosition(childClosestToEnd);
                LayoutState layoutState5 = this.mLayoutState;
                layoutState4.mCurrentPosition = position + layoutState5.mItemDirection;
                layoutState5.mOffset = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
                startAfterPadding = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd) - this.mOrientationHelper.getEndAfterPadding();
            } else {
                View childClosestToStart = getChildClosestToStart();
                this.mLayoutState.mExtraFillSpace += this.mOrientationHelper.getStartAfterPadding();
                LayoutState layoutState6 = this.mLayoutState;
                if (!this.mShouldReverseLayout) {
                    i4 = -1;
                }
                layoutState6.mItemDirection = i4;
                LayoutState layoutState7 = this.mLayoutState;
                int position2 = getPosition(childClosestToStart);
                LayoutState layoutState8 = this.mLayoutState;
                layoutState7.mCurrentPosition = position2 + layoutState8.mItemDirection;
                layoutState8.mOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart);
                startAfterPadding = (-this.mOrientationHelper.getDecoratedStart(childClosestToStart)) + this.mOrientationHelper.getStartAfterPadding();
            }
            LayoutState layoutState9 = this.mLayoutState;
            layoutState9.mAvailable = i2;
            if (z) {
                layoutState9.mAvailable = i2 - startAfterPadding;
            }
            this.mLayoutState.mScrollingOffset = startAfterPadding;
        }
    }

    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int decoratedMeasurementInOther;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048614, this, recycler, state, layoutState, layoutChunkResult) == null) {
            View next = layoutState.next(recycler);
            if (next == null) {
                layoutChunkResult.mFinished = true;
                return;
            }
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) next.getLayoutParams();
            if (layoutState.mScrapList == null) {
                boolean z3 = this.mShouldReverseLayout;
                if (layoutState.mLayoutDirection == -1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z3 == z2) {
                    addView(next);
                } else {
                    addView(next, 0);
                }
            } else {
                boolean z4 = this.mShouldReverseLayout;
                if (layoutState.mLayoutDirection == -1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z4 == z) {
                    addDisappearingView(next);
                } else {
                    addDisappearingView(next, 0);
                }
            }
            measureChildWithMargins(next, 0, 0);
            layoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(next);
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    decoratedMeasurementInOther = getWidth() - getPaddingRight();
                    i4 = decoratedMeasurementInOther - this.mOrientationHelper.getDecoratedMeasurementInOther(next);
                } else {
                    i4 = getPaddingLeft();
                    decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + i4;
                }
                if (layoutState.mLayoutDirection == -1) {
                    int i5 = layoutState.mOffset;
                    i3 = i5;
                    i2 = decoratedMeasurementInOther;
                    i = i5 - layoutChunkResult.mConsumed;
                } else {
                    int i6 = layoutState.mOffset;
                    i = i6;
                    i2 = decoratedMeasurementInOther;
                    i3 = layoutChunkResult.mConsumed + i6;
                }
            } else {
                int paddingTop = getPaddingTop();
                int decoratedMeasurementInOther2 = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + paddingTop;
                if (layoutState.mLayoutDirection == -1) {
                    int i7 = layoutState.mOffset;
                    i2 = i7;
                    i = paddingTop;
                    i3 = decoratedMeasurementInOther2;
                    i4 = i7 - layoutChunkResult.mConsumed;
                } else {
                    int i8 = layoutState.mOffset;
                    i = paddingTop;
                    i2 = layoutChunkResult.mConsumed + i8;
                    i3 = decoratedMeasurementInOther2;
                    i4 = i8;
                }
            }
            layoutDecoratedWithMargins(next, i4, i, i2, i3);
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                layoutChunkResult.mIgnoreConsumed = true;
            }
            layoutChunkResult.mFocusable = next.hasFocusable();
        }
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65565, this, i, i2) == null) {
            this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - i2;
            LayoutState layoutState = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i3 = -1;
            } else {
                i3 = 1;
            }
            layoutState.mItemDirection = i3;
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mCurrentPosition = i;
            layoutState2.mLayoutDirection = 1;
            layoutState2.mOffset = i2;
            layoutState2.mScrollingOffset = Integer.MIN_VALUE;
        }
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65567, this, i, i2) == null) {
            this.mLayoutState.mAvailable = i2 - this.mOrientationHelper.getStartAfterPadding();
            LayoutState layoutState = this.mLayoutState;
            layoutState.mCurrentPosition = i;
            if (this.mShouldReverseLayout) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            layoutState.mItemDirection = i3;
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mLayoutDirection = -1;
            layoutState2.mOffset = i2;
            layoutState2.mScrollingOffset = Integer.MIN_VALUE;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectInitialPrefetchPositions(int i, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, layoutPrefetchRegistry) == null) {
            SavedState savedState = this.mPendingSavedState;
            int i3 = -1;
            if (savedState != null && savedState.hasValidAnchor()) {
                SavedState savedState2 = this.mPendingSavedState;
                z = savedState2.mAnchorLayoutFromEnd;
                i2 = savedState2.mAnchorPosition;
            } else {
                resolveShouldLayoutReverse();
                z = this.mShouldReverseLayout;
                i2 = this.mPendingScrollPosition;
                if (i2 == -1) {
                    i2 = z ? i - 1 : 0;
                }
            }
            if (!z) {
                i3 = 1;
            }
            for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
                layoutPrefetchRegistry.addPosition(i2, 0);
                i2 += i3;
            }
        }
    }

    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.mShouldReverseLayout) {
                return findOneVisibleChild(0, getChildCount(), z, z2);
            }
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return (View) invokeCommon.objValue;
    }

    public View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.mShouldReverseLayout) {
                return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
            }
            return findOneVisibleChild(0, getChildCount(), z, z2);
        }
        return (View) invokeCommon.objValue;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, anchorInfo) == null) {
            updateLayoutStateToFillEnd(anchorInfo.mPosition, anchorInfo.mCoordinate);
        }
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, this, anchorInfo) == null) {
            updateLayoutStateToFillStart(anchorInfo.mPosition, anchorInfo.mCoordinate);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, state)) == null) {
            return computeScrollExtent(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, state)) == null) {
            return computeScrollOffset(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, state)) == null) {
            return computeScrollRange(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, state)) == null) {
            return computeScrollExtent(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, state)) == null) {
            return computeScrollOffset(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, state)) == null) {
            return computeScrollRange(state);
        }
        return invokeL.intValue;
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, state)) == null) {
            if (state.hasTargetScrollPosition()) {
                return this.mOrientationHelper.getTotalSpace();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            if (getChildCount() > 0) {
                accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
                accessibilityEvent.setToIndex(findLastVisibleItemPosition());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, state) == null) {
            super.onLayoutCompleted(state);
            this.mPendingSavedState = null;
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            this.mAnchorInfo.reset();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, parcelable) == null) && (parcelable instanceof SavedState)) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            this.mPendingScrollPosition = i;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            SavedState savedState = this.mPendingSavedState;
            if (savedState != null) {
                savedState.invalidateAnchor();
            }
            requestLayout();
        }
    }

    public void setInitialPrefetchItemCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            this.mInitialPrefetchItemCount = i;
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.mRecycleChildrenOnDetach = z;
        }
    }

    public void setReverseLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            assertNotInLayoutOrScroll(null);
            if (z == this.mReverseLayout) {
                return;
            }
            this.mReverseLayout = z;
            requestLayout();
        }
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.mSmoothScrollbarEnabled = z;
        }
    }

    public void setStackFromEnd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            assertNotInLayoutOrScroll(null);
            if (this.mStackFromEnd == z) {
                return;
            }
            this.mStackFromEnd = z;
            requestLayout();
        }
    }

    public int convertFocusDirectionToLayoutDirection(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 17) {
                        if (i != 33) {
                            if (i != 66) {
                                if (i == 130 && this.mOrientation == 1) {
                                    return 1;
                                }
                                return Integer.MIN_VALUE;
                            } else if (this.mOrientation == 0) {
                                return 1;
                            } else {
                                return Integer.MIN_VALUE;
                            }
                        } else if (this.mOrientation == 1) {
                            return -1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.mOrientation == 0) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.mOrientation != 1 && isLayoutRTL()) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (this.mOrientation == 1 || !isLayoutRTL()) {
                return -1;
            } else {
                return 1;
            }
        }
        return invokeI.intValue;
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        InterceptResult invokeII;
        char c;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048600, this, i, i2)) == null) {
            ensureLayoutState();
            if (i2 > i) {
                c = 1;
            } else if (i2 < i) {
                c = 65535;
            } else {
                c = 0;
            }
            if (c == 0) {
                return getChildAt(i);
            }
            if (this.mOrientationHelper.getDecoratedStart(getChildAt(i)) < this.mOrientationHelper.getStartAfterPadding()) {
                i3 = 16644;
                i4 = 16388;
            } else {
                i3 = 4161;
                i4 = 4097;
            }
            if (this.mOrientation == 0) {
                return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(i, i2, i3, i4);
            }
            return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(i, i2, i3, i4);
        }
        return (View) invokeII.objValue;
    }

    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{recycler, state, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            ensureLayoutState();
            int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
            int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
            if (i2 > i) {
                i4 = 1;
            } else {
                i4 = -1;
            }
            View view2 = null;
            View view3 = null;
            while (i != i2) {
                View childAt = getChildAt(i);
                int position = getPosition(childAt);
                if (position >= 0 && position < i3) {
                    if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                        if (view3 == null) {
                            view3 = childAt;
                        }
                    } else if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                        return childAt;
                    } else {
                        if (view2 == null) {
                            view2 = childAt;
                        }
                    }
                }
                i += i4;
            }
            if (view2 == null) {
                return view3;
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int fixLayoutEndGap;
        int i6;
        View findViewByPosition;
        int decoratedStart;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, recycler, state) == null) {
            int i8 = -1;
            if ((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && state.getItemCount() == 0) {
                removeAndRecycleAllViews(recycler);
                return;
            }
            SavedState savedState = this.mPendingSavedState;
            if (savedState != null && savedState.hasValidAnchor()) {
                this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
            }
            ensureLayoutState();
            this.mLayoutState.mRecycle = false;
            resolveShouldLayoutReverse();
            View focusedChild = getFocusedChild();
            if (this.mAnchorInfo.mValid && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null) {
                if (focusedChild != null && (this.mOrientationHelper.getDecoratedStart(focusedChild) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(focusedChild) <= this.mOrientationHelper.getStartAfterPadding())) {
                    this.mAnchorInfo.assignFromViewAndKeepVisibleRect(focusedChild, getPosition(focusedChild));
                }
            } else {
                this.mAnchorInfo.reset();
                AnchorInfo anchorInfo = this.mAnchorInfo;
                anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
                updateAnchorInfoForLayout(recycler, state, anchorInfo);
                this.mAnchorInfo.mValid = true;
            }
            LayoutState layoutState = this.mLayoutState;
            if (layoutState.mLastScrollDelta >= 0) {
                i = 1;
            } else {
                i = -1;
            }
            layoutState.mLayoutDirection = i;
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            calculateExtraLayoutSpace(state, iArr);
            int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.getStartAfterPadding();
            int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.getEndPadding();
            if (state.isPreLayout() && (i6 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i6)) != null) {
                if (this.mShouldReverseLayout) {
                    i7 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition);
                    decoratedStart = this.mPendingScrollPositionOffset;
                } else {
                    decoratedStart = this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding();
                    i7 = this.mPendingScrollPositionOffset;
                }
                int i9 = i7 - decoratedStart;
                if (i9 > 0) {
                    max += i9;
                } else {
                    max2 -= i9;
                }
            }
            if (!this.mAnchorInfo.mLayoutFromEnd ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
                i8 = 1;
            }
            onAnchorReady(recycler, state, this.mAnchorInfo, i8);
            detachAndScrapAttachedViews(recycler);
            this.mLayoutState.mInfinite = resolveIsInfinite();
            this.mLayoutState.mIsPreLayout = state.isPreLayout();
            this.mLayoutState.mNoRecycleSpace = 0;
            AnchorInfo anchorInfo2 = this.mAnchorInfo;
            if (anchorInfo2.mLayoutFromEnd) {
                updateLayoutStateToFillStart(anchorInfo2);
                LayoutState layoutState2 = this.mLayoutState;
                layoutState2.mExtraFillSpace = max;
                fill(recycler, layoutState2, state, false);
                LayoutState layoutState3 = this.mLayoutState;
                i3 = layoutState3.mOffset;
                int i10 = layoutState3.mCurrentPosition;
                int i11 = layoutState3.mAvailable;
                if (i11 > 0) {
                    max2 += i11;
                }
                updateLayoutStateToFillEnd(this.mAnchorInfo);
                LayoutState layoutState4 = this.mLayoutState;
                layoutState4.mExtraFillSpace = max2;
                layoutState4.mCurrentPosition += layoutState4.mItemDirection;
                fill(recycler, layoutState4, state, false);
                LayoutState layoutState5 = this.mLayoutState;
                i2 = layoutState5.mOffset;
                int i12 = layoutState5.mAvailable;
                if (i12 > 0) {
                    updateLayoutStateToFillStart(i10, i3);
                    LayoutState layoutState6 = this.mLayoutState;
                    layoutState6.mExtraFillSpace = i12;
                    fill(recycler, layoutState6, state, false);
                    i3 = this.mLayoutState.mOffset;
                }
            } else {
                updateLayoutStateToFillEnd(anchorInfo2);
                LayoutState layoutState7 = this.mLayoutState;
                layoutState7.mExtraFillSpace = max2;
                fill(recycler, layoutState7, state, false);
                LayoutState layoutState8 = this.mLayoutState;
                i2 = layoutState8.mOffset;
                int i13 = layoutState8.mCurrentPosition;
                int i14 = layoutState8.mAvailable;
                if (i14 > 0) {
                    max += i14;
                }
                updateLayoutStateToFillStart(this.mAnchorInfo);
                LayoutState layoutState9 = this.mLayoutState;
                layoutState9.mExtraFillSpace = max;
                layoutState9.mCurrentPosition += layoutState9.mItemDirection;
                fill(recycler, layoutState9, state, false);
                LayoutState layoutState10 = this.mLayoutState;
                i3 = layoutState10.mOffset;
                int i15 = layoutState10.mAvailable;
                if (i15 > 0) {
                    updateLayoutStateToFillEnd(i13, i2);
                    LayoutState layoutState11 = this.mLayoutState;
                    layoutState11.mExtraFillSpace = i15;
                    fill(recycler, layoutState11, state, false);
                    i2 = this.mLayoutState.mOffset;
                }
            }
            if (getChildCount() > 0) {
                if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                    int fixLayoutEndGap2 = fixLayoutEndGap(i2, recycler, state, true);
                    i4 = i3 + fixLayoutEndGap2;
                    i5 = i2 + fixLayoutEndGap2;
                    fixLayoutEndGap = fixLayoutStartGap(i4, recycler, state, false);
                } else {
                    int fixLayoutStartGap = fixLayoutStartGap(i3, recycler, state, true);
                    i4 = i3 + fixLayoutStartGap;
                    i5 = i2 + fixLayoutStartGap;
                    fixLayoutEndGap = fixLayoutEndGap(i5, recycler, state, false);
                }
                i3 = i4 + fixLayoutEndGap;
                i2 = i5 + fixLayoutEndGap;
            }
            layoutForPredictiveAnimations(recycler, state, i3, i2);
            if (!state.isPreLayout()) {
                this.mOrientationHelper.onLayoutComplete();
            } else {
                this.mAnchorInfo.reset();
            }
            this.mLastStackFromEnd = this.mStackFromEnd;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.mPendingSavedState != null) {
                return new SavedState(this.mPendingSavedState);
            }
            SavedState savedState = new SavedState();
            if (getChildCount() > 0) {
                ensureLayoutState();
                boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
                savedState.mAnchorLayoutFromEnd = z;
                if (z) {
                    View childClosestToEnd = getChildClosestToEnd();
                    savedState.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
                    savedState.mAnchorPosition = getPosition(childClosestToEnd);
                } else {
                    View childClosestToStart = getChildClosestToStart();
                    savedState.mAnchorPosition = getPosition(childClosestToStart);
                    savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
                }
            } else {
                savedState.invalidateAnchor();
            }
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void validateChildOrder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            Log.d(TAG, "validating child count " + getChildCount());
            boolean z = true;
            if (getChildCount() < 1) {
                return;
            }
            int position = getPosition(getChildAt(0));
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
            if (this.mShouldReverseLayout) {
                for (int i = 1; i < getChildCount(); i++) {
                    View childAt = getChildAt(i);
                    int position2 = getPosition(childAt);
                    int decoratedStart2 = this.mOrientationHelper.getDecoratedStart(childAt);
                    if (position2 < position) {
                        logChildren();
                        StringBuilder sb = new StringBuilder();
                        sb.append("detected invalid position. loc invalid? ");
                        if (decoratedStart2 >= decoratedStart) {
                            z = false;
                        }
                        sb.append(z);
                        throw new RuntimeException(sb.toString());
                    } else if (decoratedStart2 > decoratedStart) {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
                return;
            }
            for (int i2 = 1; i2 < getChildCount(); i2++) {
                View childAt2 = getChildAt(i2);
                int position3 = getPosition(childAt2);
                int decoratedStart3 = this.mOrientationHelper.getDecoratedStart(childAt2);
                if (position3 < position) {
                    logChildren();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("detected invalid position. loc invalid? ");
                    if (decoratedStart3 >= decoratedStart) {
                        z = false;
                    }
                    sb2.append(z);
                    throw new RuntimeException(sb2.toString());
                } else if (decoratedStart3 < decoratedStart) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }
}
