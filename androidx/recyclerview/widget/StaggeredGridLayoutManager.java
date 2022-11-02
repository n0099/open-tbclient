package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    public static final float MAX_SCROLL_FACTOR = 0.33333334f;
    public static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final AnchorInfo mAnchorInfo;
    public final Runnable mCheckForGapsRunnable;
    public int mFullSizeSpec;
    public int mGapStrategy;
    public boolean mLaidOutInvalidFullSpan;
    public boolean mLastLayoutFromEnd;
    public boolean mLastLayoutRTL;
    @NonNull
    public final LayoutState mLayoutState;
    public LazySpanLookup mLazySpanLookup;
    public int mOrientation;
    public SavedState mPendingSavedState;
    public int mPendingScrollPosition;
    public int mPendingScrollPositionOffset;
    public int[] mPrefetchDistances;
    @NonNull
    public OrientationHelper mPrimaryOrientation;
    public BitSet mRemainingSpans;
    public boolean mReverseLayout;
    @NonNull
    public OrientationHelper mSecondaryOrientation;
    public boolean mShouldReverseLayout;
    public int mSizePerSpan;
    public boolean mSmoothScrollbarEnabled;
    public int mSpanCount;
    public Span[] mSpans;
    public final Rect mTmpRect;

    /* loaded from: classes.dex */
    public static class LazySpanLookup {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MIN_SIZE = 10;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] mData;
        public List<FullSpanItem> mFullSpanItems;

        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes.dex */
        public static class FullSpanItem implements Parcelable {
            public static /* synthetic */ Interceptable $ic;
            public static final Parcelable.Creator<FullSpanItem> CREATOR;
            public transient /* synthetic */ FieldHolder $fh;
            public int mGapDir;
            public int[] mGapPerSpan;
            public boolean mHasUnwantedGapAfter;
            public int mPosition;

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
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-742263012, "Landroidx/recyclerview/widget/StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-742263012, "Landroidx/recyclerview/widget/StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;");
                        return;
                    }
                }
                CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
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
                    public FullSpanItem createFromParcel(Parcel parcel) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                            return new FullSpanItem(parcel);
                        }
                        return (FullSpanItem) invokeL.objValue;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public FullSpanItem[] newArray(int i) {
                        InterceptResult invokeI;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                            return new FullSpanItem[i];
                        }
                        return (FullSpanItem[]) invokeI.objValue;
                    }
                };
            }

            public FullSpanItem() {
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

            public FullSpanItem(Parcel parcel) {
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
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                this.mHasUnwantedGapAfter = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.mGapPerSpan = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int getGapForSpan(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                    int[] iArr = this.mGapPerSpan;
                    if (iArr == null) {
                        return 0;
                    }
                    return iArr[i];
                }
                return invokeI.intValue;
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
                }
                return (String) invokeV.objValue;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
                    parcel.writeInt(this.mPosition);
                    parcel.writeInt(this.mGapDir);
                    parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                    int[] iArr = this.mGapPerSpan;
                    if (iArr != null && iArr.length > 0) {
                        parcel.writeInt(iArr.length);
                        parcel.writeIntArray(this.mGapPerSpan);
                        return;
                    }
                    parcel.writeInt(0);
                }
            }
        }

        public LazySpanLookup() {
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

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int[] iArr = this.mData;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                this.mFullSpanItems = null;
            }
        }

        private int invalidateFullSpansAfter(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
                if (this.mFullSpanItems == null) {
                    return -1;
                }
                FullSpanItem fullSpanItem = getFullSpanItem(i);
                if (fullSpanItem != null) {
                    this.mFullSpanItems.remove(fullSpanItem);
                }
                int size = this.mFullSpanItems.size();
                int i2 = 0;
                while (true) {
                    if (i2 < size) {
                        if (this.mFullSpanItems.get(i2).mPosition >= i) {
                            break;
                        }
                        i2++;
                    } else {
                        i2 = -1;
                        break;
                    }
                }
                if (i2 == -1) {
                    return -1;
                }
                this.mFullSpanItems.remove(i2);
                return this.mFullSpanItems.get(i2).mPosition;
            }
            return invokeI.intValue;
        }

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fullSpanItem) == null) {
                if (this.mFullSpanItems == null) {
                    this.mFullSpanItems = new ArrayList();
                }
                int size = this.mFullSpanItems.size();
                for (int i = 0; i < size; i++) {
                    FullSpanItem fullSpanItem2 = this.mFullSpanItems.get(i);
                    if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                        this.mFullSpanItems.remove(i);
                    }
                    if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                        this.mFullSpanItems.add(i, fullSpanItem);
                        return;
                    }
                }
                this.mFullSpanItems.add(fullSpanItem);
            }
        }

        private void offsetFullSpansForAddition(int i, int i2) {
            List<FullSpanItem> list;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeII(65538, this, i, i2) != null) || (list = this.mFullSpanItems) == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                int i3 = fullSpanItem.mPosition;
                if (i3 >= i) {
                    fullSpanItem.mPosition = i3 + i2;
                }
            }
        }

        public void offsetForAddition(int i, int i2) {
            int[] iArr;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) && (iArr = this.mData) != null && i < iArr.length) {
                int i3 = i + i2;
                ensureSize(i3);
                int[] iArr2 = this.mData;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.mData, i, i3, -1);
                offsetFullSpansForAddition(i, i2);
            }
        }

        public void offsetForRemoval(int i, int i2) {
            int[] iArr;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) && (iArr = this.mData) != null && i < iArr.length) {
                int i3 = i + i2;
                ensureSize(i3);
                int[] iArr2 = this.mData;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.mData;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                offsetFullSpansForRemoval(i, i2);
            }
        }

        public void setSpan(int i, Span span) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048586, this, i, span) == null) {
                ensureSize(i);
                this.mData[i] = span.mIndex;
            }
        }

        private void offsetFullSpansForRemoval(int i, int i2) {
            List<FullSpanItem> list;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeII(65539, this, i, i2) != null) || (list = this.mFullSpanItems) == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                int i4 = fullSpanItem.mPosition;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.mFullSpanItems.remove(size);
                    } else {
                        fullSpanItem.mPosition = i4 - i2;
                    }
                }
            }
        }

        public void ensureSize(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                int[] iArr = this.mData;
                if (iArr == null) {
                    int[] iArr2 = new int[Math.max(i, 10) + 1];
                    this.mData = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i >= iArr.length) {
                    int[] iArr3 = new int[sizeForPosition(i)];
                    this.mData = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    int[] iArr4 = this.mData;
                    Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
                }
            }
        }

        public int forceInvalidateAfter(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                List<FullSpanItem> list = this.mFullSpanItems;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        if (this.mFullSpanItems.get(size).mPosition >= i) {
                            this.mFullSpanItems.remove(size);
                        }
                    }
                }
                return invalidateAfter(i);
            }
            return invokeI.intValue;
        }

        public int invalidateAfter(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                int[] iArr = this.mData;
                if (iArr == null || i >= iArr.length) {
                    return -1;
                }
                int invalidateFullSpansAfter = invalidateFullSpansAfter(i);
                if (invalidateFullSpansAfter == -1) {
                    int[] iArr2 = this.mData;
                    Arrays.fill(iArr2, i, iArr2.length, -1);
                    return this.mData.length;
                }
                int i2 = invalidateFullSpansAfter + 1;
                Arrays.fill(this.mData, i, i2, -1);
                return i2;
            }
            return invokeI.intValue;
        }

        public FullSpanItem getFirstFullSpanItemInRange(int i, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                List<FullSpanItem> list = this.mFullSpanItems;
                if (list == null) {
                    return null;
                }
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    FullSpanItem fullSpanItem = this.mFullSpanItems.get(i4);
                    int i5 = fullSpanItem.mPosition;
                    if (i5 >= i2) {
                        return null;
                    }
                    if (i5 >= i && (i3 == 0 || fullSpanItem.mGapDir == i3 || (z && fullSpanItem.mHasUnwantedGapAfter))) {
                        return fullSpanItem;
                    }
                }
                return null;
            }
            return (FullSpanItem) invokeCommon.objValue;
        }

        public FullSpanItem getFullSpanItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                List<FullSpanItem> list = this.mFullSpanItems;
                if (list == null) {
                    return null;
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                    if (fullSpanItem.mPosition == i) {
                        return fullSpanItem;
                    }
                }
                return null;
            }
            return (FullSpanItem) invokeI.objValue;
        }

        public int getSpan(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                int[] iArr = this.mData;
                if (iArr != null && i < iArr.length) {
                    return iArr[i];
                }
                return -1;
            }
            return invokeI.intValue;
        }

        public int sizeForPosition(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                int length = this.mData.length;
                while (length <= i) {
                    length *= 2;
                }
                return length;
            }
            return invokeI.intValue;
        }
    }

    /* loaded from: classes.dex */
    public class AnchorInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mInvalidateOffsets;
        public boolean mLayoutFromEnd;
        public int mOffset;
        public int mPosition;
        public int[] mSpanReferenceLines;
        public boolean mValid;
        public final /* synthetic */ StaggeredGridLayoutManager this$0;

        public AnchorInfo(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {staggeredGridLayoutManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = staggeredGridLayoutManager;
            reset();
        }

        public void assignCoordinateFromPadding(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (this.mLayoutFromEnd) {
                    this.mOffset = this.this$0.mPrimaryOrientation.getEndAfterPadding() - i;
                } else {
                    this.mOffset = this.this$0.mPrimaryOrientation.getStartAfterPadding() + i;
                }
            }
        }

        public void assignCoordinateFromPadding() {
            int startAfterPadding;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.mLayoutFromEnd) {
                    startAfterPadding = this.this$0.mPrimaryOrientation.getEndAfterPadding();
                } else {
                    startAfterPadding = this.this$0.mPrimaryOrientation.getStartAfterPadding();
                }
                this.mOffset = startAfterPadding;
            }
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mPosition = -1;
                this.mOffset = Integer.MIN_VALUE;
                this.mLayoutFromEnd = false;
                this.mInvalidateOffsets = false;
                this.mValid = false;
                int[] iArr = this.mSpanReferenceLines;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
            }
        }

        public void saveSpanReferenceLines(Span[] spanArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, spanArr) == null) {
                int length = spanArr.length;
                int[] iArr = this.mSpanReferenceLines;
                if (iArr == null || iArr.length < length) {
                    this.mSpanReferenceLines = new int[this.this$0.mSpans.length];
                }
                for (int i = 0; i < length; i++) {
                    this.mSpanReferenceLines[i] = spanArr[i].getStartLine(Integer.MIN_VALUE);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int INVALID_SPAN_ID = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mFullSpan;
        public Span mSpan;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((RecyclerView.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
        }

        public final int getSpanIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Span span = this.mSpan;
                if (span == null) {
                    return -1;
                }
                return span.mIndex;
            }
            return invokeV.intValue;
        }

        public boolean isFullSpan() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mFullSpan;
            }
            return invokeV.booleanValue;
        }

        public void setFullSpan(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.mFullSpan = z;
            }
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
        public int mAnchorPosition;
        public List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        public boolean mLastLayoutRTL;
        public boolean mReverseLayout;
        public int[] mSpanLookup;
        public int mSpanLookupSize;
        public int[] mSpanOffsets;
        public int mSpanOffsetsSize;
        public int mVisibleAnchorPosition;

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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-382144584, "Landroidx/recyclerview/widget/StaggeredGridLayoutManager$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-382144584, "Landroidx/recyclerview/widget/StaggeredGridLayoutManager$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState.1
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

        public void invalidateAnchorPositionInfo() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mSpanOffsets = null;
                this.mSpanOffsetsSize = 0;
                this.mAnchorPosition = -1;
                this.mVisibleAnchorPosition = -1;
            }
        }

        public void invalidateSpanInfo() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mSpanOffsets = null;
                this.mSpanOffsetsSize = 0;
                this.mSpanLookupSize = 0;
                this.mSpanLookup = null;
                this.mFullSpanItems = null;
            }
        }

        public SavedState(Parcel parcel) {
            boolean z;
            boolean z2;
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
            this.mVisibleAnchorPosition = parcel.readInt();
            int readInt = parcel.readInt();
            this.mSpanOffsetsSize = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.mSpanOffsets = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.mSpanLookupSize = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.mSpanLookup = iArr2;
                parcel.readIntArray(iArr2);
            }
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.mReverseLayout = z;
            if (parcel.readInt() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mAnchorLayoutFromEnd = z2;
            this.mLastLayoutRTL = parcel.readInt() == 1;
            this.mFullSpanItems = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
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
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
                parcel.writeInt(this.mAnchorPosition);
                parcel.writeInt(this.mVisibleAnchorPosition);
                parcel.writeInt(this.mSpanOffsetsSize);
                if (this.mSpanOffsetsSize > 0) {
                    parcel.writeIntArray(this.mSpanOffsets);
                }
                parcel.writeInt(this.mSpanLookupSize);
                if (this.mSpanLookupSize > 0) {
                    parcel.writeIntArray(this.mSpanLookup);
                }
                parcel.writeInt(this.mReverseLayout ? 1 : 0);
                parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
                parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
                parcel.writeList(this.mFullSpanItems);
            }
        }
    }

    /* loaded from: classes.dex */
    public class Span {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int INVALID_LINE = Integer.MIN_VALUE;
        public transient /* synthetic */ FieldHolder $fh;
        public int mCachedEnd;
        public int mCachedStart;
        public int mDeletedSize;
        public final int mIndex;
        public ArrayList<View> mViews;
        public final /* synthetic */ StaggeredGridLayoutManager this$0;

        public Span(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {staggeredGridLayoutManager, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = staggeredGridLayoutManager;
            this.mViews = new ArrayList<>();
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
            this.mDeletedSize = 0;
            this.mIndex = i;
        }

        public void cacheReferenceLineAndClear(boolean z, int i) {
            int startLine;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                if (z) {
                    startLine = getEndLine(Integer.MIN_VALUE);
                } else {
                    startLine = getStartLine(Integer.MIN_VALUE);
                }
                clear();
                if (startLine == Integer.MIN_VALUE) {
                    return;
                }
                if (!z || startLine >= this.this$0.mPrimaryOrientation.getEndAfterPadding()) {
                    if (!z && startLine > this.this$0.mPrimaryOrientation.getStartAfterPadding()) {
                        return;
                    }
                    if (i != Integer.MIN_VALUE) {
                        startLine += i;
                    }
                    this.mCachedEnd = startLine;
                    this.mCachedStart = startLine;
                }
            }
        }

        public void appendToSpan(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                LayoutParams layoutParams = getLayoutParams(view2);
                layoutParams.mSpan = this;
                this.mViews.add(view2);
                this.mCachedEnd = Integer.MIN_VALUE;
                if (this.mViews.size() == 1) {
                    this.mCachedStart = Integer.MIN_VALUE;
                }
                if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                    this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(view2);
                }
            }
        }

        public void prependToSpan(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
                LayoutParams layoutParams = getLayoutParams(view2);
                layoutParams.mSpan = this;
                this.mViews.add(0, view2);
                this.mCachedStart = Integer.MIN_VALUE;
                if (this.mViews.size() == 1) {
                    this.mCachedEnd = Integer.MIN_VALUE;
                }
                if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                    this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(view2);
                }
            }
        }

        public void calculateCachedEnd() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ArrayList<View> arrayList = this.mViews;
                View view2 = arrayList.get(arrayList.size() - 1);
                LayoutParams layoutParams = getLayoutParams(view2);
                this.mCachedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd(view2);
                if (layoutParams.mFullSpan && (fullSpanItem = this.this$0.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == 1) {
                    this.mCachedEnd += fullSpanItem.getGapForSpan(this.mIndex);
                }
            }
        }

        public void calculateCachedStart() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                View view2 = this.mViews.get(0);
                LayoutParams layoutParams = getLayoutParams(view2);
                this.mCachedStart = this.this$0.mPrimaryOrientation.getDecoratedStart(view2);
                if (layoutParams.mFullSpan && (fullSpanItem = this.this$0.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == -1) {
                    this.mCachedStart -= fullSpanItem.getGapForSpan(this.mIndex);
                }
            }
        }

        public void popEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
                int size = this.mViews.size();
                View remove = this.mViews.remove(size - 1);
                LayoutParams layoutParams = getLayoutParams(remove);
                layoutParams.mSpan = null;
                if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                    this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(remove);
                }
                if (size == 1) {
                    this.mCachedStart = Integer.MIN_VALUE;
                }
                this.mCachedEnd = Integer.MIN_VALUE;
            }
        }

        public void popStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
                View remove = this.mViews.remove(0);
                LayoutParams layoutParams = getLayoutParams(remove);
                layoutParams.mSpan = null;
                if (this.mViews.size() == 0) {
                    this.mCachedEnd = Integer.MIN_VALUE;
                }
                if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                    this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(remove);
                }
                this.mCachedStart = Integer.MIN_VALUE;
            }
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.mViews.clear();
                invalidateCache();
                this.mDeletedSize = 0;
            }
        }

        public int findFirstCompletelyVisibleItemPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.this$0.mReverseLayout) {
                    return findOneVisibleChild(this.mViews.size() - 1, -1, true);
                }
                return findOneVisibleChild(0, this.mViews.size(), true);
            }
            return invokeV.intValue;
        }

        public int findFirstPartiallyVisibleItemPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.this$0.mReverseLayout) {
                    return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
                }
                return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
            }
            return invokeV.intValue;
        }

        public int findFirstVisibleItemPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.this$0.mReverseLayout) {
                    return findOneVisibleChild(this.mViews.size() - 1, -1, false);
                }
                return findOneVisibleChild(0, this.mViews.size(), false);
            }
            return invokeV.intValue;
        }

        public int findLastCompletelyVisibleItemPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.this$0.mReverseLayout) {
                    return findOneVisibleChild(0, this.mViews.size(), true);
                }
                return findOneVisibleChild(this.mViews.size() - 1, -1, true);
            }
            return invokeV.intValue;
        }

        public int findLastPartiallyVisibleItemPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                if (this.this$0.mReverseLayout) {
                    return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
                }
                return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
            }
            return invokeV.intValue;
        }

        public int findLastVisibleItemPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (this.this$0.mReverseLayout) {
                    return findOneVisibleChild(0, this.mViews.size(), false);
                }
                return findOneVisibleChild(this.mViews.size() - 1, -1, false);
            }
            return invokeV.intValue;
        }

        public int getDeletedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.mDeletedSize;
            }
            return invokeV.intValue;
        }

        public int getEndLine() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                int i = this.mCachedEnd;
                if (i != Integer.MIN_VALUE) {
                    return i;
                }
                calculateCachedEnd();
                return this.mCachedEnd;
            }
            return invokeV.intValue;
        }

        public int getStartLine() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                int i = this.mCachedStart;
                if (i != Integer.MIN_VALUE) {
                    return i;
                }
                calculateCachedStart();
                return this.mCachedStart;
            }
            return invokeV.intValue;
        }

        public void invalidateCache() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
                this.mCachedStart = Integer.MIN_VALUE;
                this.mCachedEnd = Integer.MIN_VALUE;
            }
        }

        public int findOnePartiallyOrCompletelyVisibleChild(int i, int i2, boolean z, boolean z2, boolean z3) {
            InterceptResult invokeCommon;
            int i3;
            boolean z4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
                int startAfterPadding = this.this$0.mPrimaryOrientation.getStartAfterPadding();
                int endAfterPadding = this.this$0.mPrimaryOrientation.getEndAfterPadding();
                if (i2 > i) {
                    i3 = 1;
                } else {
                    i3 = -1;
                }
                while (i != i2) {
                    View view2 = this.mViews.get(i);
                    int decoratedStart = this.this$0.mPrimaryOrientation.getDecoratedStart(view2);
                    int decoratedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd(view2);
                    boolean z5 = false;
                    if (!z3 ? decoratedStart < endAfterPadding : decoratedStart <= endAfterPadding) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z3 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                        z5 = true;
                    }
                    if (z4 && z5) {
                        if (z && z2) {
                            if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                                return this.this$0.getPosition(view2);
                            }
                        } else if (z2) {
                            return this.this$0.getPosition(view2);
                        } else {
                            if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                                return this.this$0.getPosition(view2);
                            }
                        }
                    }
                    i += i3;
                }
                return -1;
            }
            return invokeCommon.intValue;
        }

        public int findOnePartiallyVisibleChild(int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                return findOnePartiallyOrCompletelyVisibleChild(i, i2, false, false, z);
            }
            return invokeCommon.intValue;
        }

        public int findOneVisibleChild(int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                return findOnePartiallyOrCompletelyVisibleChild(i, i2, z, true, false);
            }
            return invokeCommon.intValue;
        }

        public int getEndLine(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
                int i2 = this.mCachedEnd;
                if (i2 != Integer.MIN_VALUE) {
                    return i2;
                }
                if (this.mViews.size() == 0) {
                    return i;
                }
                calculateCachedEnd();
                return this.mCachedEnd;
            }
            return invokeI.intValue;
        }

        public LayoutParams getLayoutParams(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, view2)) == null) {
                return (LayoutParams) view2.getLayoutParams();
            }
            return (LayoutParams) invokeL.objValue;
        }

        public int getStartLine(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
                int i2 = this.mCachedStart;
                if (i2 != Integer.MIN_VALUE) {
                    return i2;
                }
                if (this.mViews.size() == 0) {
                    return i;
                }
                calculateCachedStart();
                return this.mCachedStart;
            }
            return invokeI.intValue;
        }

        public void onOffset(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
                int i2 = this.mCachedStart;
                if (i2 != Integer.MIN_VALUE) {
                    this.mCachedStart = i2 + i;
                }
                int i3 = this.mCachedEnd;
                if (i3 != Integer.MIN_VALUE) {
                    this.mCachedEnd = i3 + i;
                }
            }
        }

        public void setLine(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
                this.mCachedStart = i;
                this.mCachedEnd = i;
            }
        }

        public View getFocusableViewAfter(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i, i2)) == null) {
                View view2 = null;
                if (i2 == -1) {
                    int size = this.mViews.size();
                    int i3 = 0;
                    while (i3 < size) {
                        View view3 = this.mViews.get(i3);
                        StaggeredGridLayoutManager staggeredGridLayoutManager = this.this$0;
                        if (staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view3) <= i) {
                            break;
                        }
                        StaggeredGridLayoutManager staggeredGridLayoutManager2 = this.this$0;
                        if ((!staggeredGridLayoutManager2.mReverseLayout && staggeredGridLayoutManager2.getPosition(view3) >= i) || !view3.hasFocusable()) {
                            break;
                        }
                        i3++;
                        view2 = view3;
                    }
                } else {
                    int size2 = this.mViews.size() - 1;
                    while (size2 >= 0) {
                        View view4 = this.mViews.get(size2);
                        StaggeredGridLayoutManager staggeredGridLayoutManager3 = this.this$0;
                        if (staggeredGridLayoutManager3.mReverseLayout && staggeredGridLayoutManager3.getPosition(view4) >= i) {
                            break;
                        }
                        StaggeredGridLayoutManager staggeredGridLayoutManager4 = this.this$0;
                        if ((!staggeredGridLayoutManager4.mReverseLayout && staggeredGridLayoutManager4.getPosition(view4) <= i) || !view4.hasFocusable()) {
                            break;
                        }
                        size2--;
                        view2 = view4;
                    }
                }
                return view2;
            }
            return (View) invokeII.objValue;
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSpanCount = -1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLazySpanLookup = new LazySpanLookup();
        this.mGapStrategy = 2;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo(this);
        this.mLaidOutInvalidFullSpan = false;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new Runnable(this) { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ StaggeredGridLayoutManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
                    this.this$0.checkForGaps();
                }
            }
        };
        this.mOrientation = i2;
        setSpanCount(i);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void recycle(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int min;
        int min2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65566, this, recycler, layoutState) == null) && layoutState.mRecycle && !layoutState.mInfinite) {
            if (layoutState.mAvailable == 0) {
                if (layoutState.mLayoutDirection == -1) {
                    recycleFromEnd(recycler, layoutState.mEndLine);
                } else {
                    recycleFromStart(recycler, layoutState.mStartLine);
                }
            } else if (layoutState.mLayoutDirection == -1) {
                int i = layoutState.mStartLine;
                int maxStart = i - getMaxStart(i);
                if (maxStart < 0) {
                    min2 = layoutState.mEndLine;
                } else {
                    min2 = layoutState.mEndLine - Math.min(maxStart, layoutState.mAvailable);
                }
                recycleFromEnd(recycler, min2);
            } else {
                int minEnd = getMinEnd(layoutState.mEndLine) - layoutState.mEndLine;
                if (minEnd < 0) {
                    min = layoutState.mStartLine;
                } else {
                    min = Math.min(minEnd, layoutState.mAvailable) + layoutState.mStartLine;
                }
                recycleFromStart(recycler, min);
            }
        }
    }

    private void recycleFromEnd(RecyclerView.Recycler recycler, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65567, this, recycler, i) == null) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (this.mPrimaryOrientation.getDecoratedStart(childAt) >= i && this.mPrimaryOrientation.getTransformedStartWithDecoration(childAt) >= i) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.mFullSpan) {
                        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                            if (this.mSpans[i2].mViews.size() == 1) {
                                return;
                            }
                        }
                        for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                            this.mSpans[i3].popEnd();
                        }
                    } else if (layoutParams.mSpan.mViews.size() == 1) {
                        return;
                    } else {
                        layoutParams.mSpan.popEnd();
                    }
                    removeAndRecycleView(childAt, recycler);
                } else {
                    return;
                }
            }
        }
    }

    private void recycleFromStart(RecyclerView.Recycler recycler, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65568, this, recycler, i) == null) {
            while (getChildCount() > 0) {
                View childAt = getChildAt(0);
                if (this.mPrimaryOrientation.getDecoratedEnd(childAt) <= i && this.mPrimaryOrientation.getTransformedEndWithDecoration(childAt) <= i) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.mFullSpan) {
                        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                            if (this.mSpans[i2].mViews.size() == 1) {
                                return;
                            }
                        }
                        for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                            this.mSpans[i3].popStart();
                        }
                    } else if (layoutParams.mSpan.mViews.size() == 1) {
                        return;
                    } else {
                        layoutParams.mSpan.popStart();
                    }
                    removeAndRecycleView(childAt, recycler);
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateLayoutState(int i, RecyclerView.State state) {
        int i2;
        int i3;
        int targetScrollPosition;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65574, this, i, state) == null) {
            LayoutState layoutState = this.mLayoutState;
            boolean z2 = false;
            layoutState.mAvailable = 0;
            layoutState.mCurrentPosition = i;
            if (isSmoothScrolling() && (targetScrollPosition = state.getTargetScrollPosition()) != -1) {
                boolean z3 = this.mShouldReverseLayout;
                if (targetScrollPosition < i) {
                    z = true;
                } else {
                    z = false;
                }
                if (z3 == z) {
                    i2 = this.mPrimaryOrientation.getTotalSpace();
                } else {
                    i3 = this.mPrimaryOrientation.getTotalSpace();
                    i2 = 0;
                    if (!getClipToPadding()) {
                        this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - i3;
                        this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + i2;
                    } else {
                        this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + i2;
                        this.mLayoutState.mStartLine = -i3;
                    }
                    LayoutState layoutState2 = this.mLayoutState;
                    layoutState2.mStopInFocusable = false;
                    layoutState2.mRecycle = true;
                    if (this.mPrimaryOrientation.getMode() == 0 && this.mPrimaryOrientation.getEnd() == 0) {
                        z2 = true;
                    }
                    layoutState2.mInfinite = z2;
                }
            } else {
                i2 = 0;
            }
            i3 = 0;
            if (!getClipToPadding()) {
            }
            LayoutState layoutState22 = this.mLayoutState;
            layoutState22.mStopInFocusable = false;
            layoutState22.mRecycle = true;
            if (this.mPrimaryOrientation.getMode() == 0) {
                z2 = true;
            }
            layoutState22.mInfinite = z2;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSpanCount = -1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLazySpanLookup = new LazySpanLookup();
        this.mGapStrategy = 2;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo(this);
        this.mLaidOutInvalidFullSpan = false;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new Runnable(this) { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ StaggeredGridLayoutManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr2 = {this};
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
                    this.this$0.checkForGaps();
                }
            }
        };
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void measureChildWithDecorationsAndMargin(View view2, int i, int i2, boolean z) {
        boolean shouldMeasureChild;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            calculateItemDecorationsForChild(view2, this.mTmpRect);
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            Rect rect = this.mTmpRect;
            int updateSpecWithExtra = updateSpecWithExtra(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
            int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            Rect rect2 = this.mTmpRect;
            int updateSpecWithExtra2 = updateSpecWithExtra(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
            if (z) {
                shouldMeasureChild = shouldReMeasureChild(view2, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
            } else {
                shouldMeasureChild = shouldMeasureChild(view2, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
            }
            if (shouldMeasureChild) {
                view2.measure(updateSpecWithExtra, updateSpecWithExtra2);
            }
        }
    }

    private void appendViewToAllSpans(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, view2) == null) {
            for (int i = this.mSpanCount - 1; i >= 0; i--) {
                this.mSpans[i].appendToSpan(view2);
            }
        }
    }

    private int calculateScrollDirectionForPosition(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i)) == null) {
            if (getChildCount() == 0) {
                if (!this.mShouldReverseLayout) {
                    return -1;
                }
                return 1;
            }
            if (i < getFirstChildPosition()) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.mShouldReverseLayout) {
                return -1;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    private int findFirstReferenceChildPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, this, i)) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                int position = getPosition(getChildAt(i2));
                if (position >= 0 && position < i) {
                    return position;
                }
            }
            return 0;
        }
        return invokeI.intValue;
    }

    private int findLastReferenceChildPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, this, i)) == null) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                int position = getPosition(getChildAt(childCount));
                if (position >= 0 && position < i) {
                    return position;
                }
            }
            return 0;
        }
        return invokeI.intValue;
    }

    private int getMaxEnd(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65555, this, i)) == null) {
            int endLine = this.mSpans[0].getEndLine(i);
            for (int i2 = 1; i2 < this.mSpanCount; i2++) {
                int endLine2 = this.mSpans[i2].getEndLine(i);
                if (endLine2 > endLine) {
                    endLine = endLine2;
                }
            }
            return endLine;
        }
        return invokeI.intValue;
    }

    private int getMaxStart(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, this, i)) == null) {
            int startLine = this.mSpans[0].getStartLine(i);
            for (int i2 = 1; i2 < this.mSpanCount; i2++) {
                int startLine2 = this.mSpans[i2].getStartLine(i);
                if (startLine2 > startLine) {
                    startLine = startLine2;
                }
            }
            return startLine;
        }
        return invokeI.intValue;
    }

    private int getMinEnd(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, this, i)) == null) {
            int endLine = this.mSpans[0].getEndLine(i);
            for (int i2 = 1; i2 < this.mSpanCount; i2++) {
                int endLine2 = this.mSpans[i2].getEndLine(i);
                if (endLine2 < endLine) {
                    endLine = endLine2;
                }
            }
            return endLine;
        }
        return invokeI.intValue;
    }

    private int getMinStart(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65558, this, i)) == null) {
            int startLine = this.mSpans[0].getStartLine(i);
            for (int i2 = 1; i2 < this.mSpanCount; i2++) {
                int startLine2 = this.mSpans[i2].getStartLine(i);
                if (startLine2 < startLine) {
                    startLine = startLine2;
                }
            }
            return startLine;
        }
        return invokeI.intValue;
    }

    private void prependViewToAllSpans(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, view2) == null) {
            for (int i = this.mSpanCount - 1; i >= 0; i--) {
                this.mSpans[i].prependToSpan(view2);
            }
        }
    }

    private void setLayoutStateDirection(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65571, this, i) == null) {
            LayoutState layoutState = this.mLayoutState;
            layoutState.mLayoutDirection = i;
            boolean z2 = this.mShouldReverseLayout;
            int i2 = 1;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z2 != z) {
                i2 = -1;
            }
            layoutState.mItemDirection = i2;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, layoutParams)) == null) {
            return layoutParams instanceof LayoutParams;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, state)) == null) {
            return computeScrollExtent(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, state)) == null) {
            return computeScrollOffset(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, state)) == null) {
            return computeScrollRange(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            int calculateScrollDirectionForPosition = calculateScrollDirectionForPosition(i);
            PointF pointF = new PointF();
            if (calculateScrollDirectionForPosition == 0) {
                return null;
            }
            if (this.mOrientation == 0) {
                pointF.x = calculateScrollDirectionForPosition;
                pointF.y = 0.0f;
            } else {
                pointF.x = 0.0f;
                pointF.y = calculateScrollDirectionForPosition;
            }
            return pointF;
        }
        return (PointF) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, state)) == null) {
            return computeScrollExtent(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, state)) == null) {
            return computeScrollOffset(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, state)) == null) {
            return computeScrollRange(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, layoutParams)) == null) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }
        return (RecyclerView.LayoutParams) invokeL.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            super.offsetChildrenHorizontal(i);
            for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                this.mSpans[i2].onOffset(i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            super.offsetChildrenVertical(i);
            for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                this.mSpans[i2].onOffset(i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, recyclerView) == null) {
            this.mLazySpanLookup.clear();
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, state) == null) {
            super.onLayoutCompleted(state);
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            this.mPendingSavedState = null;
            this.mAnchorInfo.reset();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, parcelable) == null) && (parcelable instanceof SavedState)) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048628, this, i) == null) && i == 0) {
            checkForGaps();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i) == null) {
            SavedState savedState = this.mPendingSavedState;
            if (savedState != null && savedState.mAnchorPosition != i) {
                savedState.invalidateAnchorPositionInfo();
            }
            this.mPendingScrollPosition = i;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            requestLayout();
        }
    }

    public void setGapStrategy(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            assertNotInLayoutOrScroll(null);
            if (i == this.mGapStrategy) {
                return;
            }
            if (i != 0 && i != 2) {
                throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
            }
            this.mGapStrategy = i;
            requestLayout();
        }
    }

    public void setReverseLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            assertNotInLayoutOrScroll(null);
            SavedState savedState = this.mPendingSavedState;
            if (savedState != null && savedState.mReverseLayout != z) {
                savedState.mReverseLayout = z;
            }
            this.mReverseLayout = z;
            requestLayout();
        }
    }

    public void updateMeasureSpecs(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            this.mSizePerSpan = i / this.mSpanCount;
            this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(i, this.mSecondaryOrientation.getMode());
        }
    }

    private void applyPendingSavedState(AnchorInfo anchorInfo) {
        int startAfterPadding;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, anchorInfo) == null) {
            SavedState savedState = this.mPendingSavedState;
            int i = savedState.mSpanOffsetsSize;
            if (i > 0) {
                if (i == this.mSpanCount) {
                    for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                        this.mSpans[i2].clear();
                        SavedState savedState2 = this.mPendingSavedState;
                        int i3 = savedState2.mSpanOffsets[i2];
                        if (i3 != Integer.MIN_VALUE) {
                            if (savedState2.mAnchorLayoutFromEnd) {
                                startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                            } else {
                                startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                            }
                            i3 += startAfterPadding;
                        }
                        this.mSpans[i2].setLine(i3);
                    }
                } else {
                    savedState.invalidateSpanInfo();
                    SavedState savedState3 = this.mPendingSavedState;
                    savedState3.mAnchorPosition = savedState3.mVisibleAnchorPosition;
                }
            }
            SavedState savedState4 = this.mPendingSavedState;
            this.mLastLayoutRTL = savedState4.mLastLayoutRTL;
            setReverseLayout(savedState4.mReverseLayout);
            resolveShouldLayoutReverse();
            SavedState savedState5 = this.mPendingSavedState;
            int i4 = savedState5.mAnchorPosition;
            if (i4 != -1) {
                this.mPendingScrollPosition = i4;
                anchorInfo.mLayoutFromEnd = savedState5.mAnchorLayoutFromEnd;
            } else {
                anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
            }
            SavedState savedState6 = this.mPendingSavedState;
            if (savedState6.mSpanLookupSize > 1) {
                LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
                lazySpanLookup.mData = savedState6.mSpanLookup;
                lazySpanLookup.mFullSpanItems = savedState6.mFullSpanItems;
            }
        }
    }

    private int convertFocusDirectionToLayoutDirection(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, this, i)) == null) {
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

    private void attachViewToSpans(View view2, LayoutParams layoutParams, LayoutState layoutState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, view2, layoutParams, layoutState) == null) {
            if (layoutState.mLayoutDirection == 1) {
                if (layoutParams.mFullSpan) {
                    appendViewToAllSpans(view2);
                } else {
                    layoutParams.mSpan.appendToSpan(view2);
                }
            } else if (layoutParams.mFullSpan) {
                prependViewToAllSpans(view2);
            } else {
                layoutParams.mSpan.prependToSpan(view2);
            }
        }
    }

    private void fixEndGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int maxEnd;
        int endAfterPadding;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65553, this, recycler, state, z) == null) && (maxEnd = getMaxEnd(Integer.MIN_VALUE)) != Integer.MIN_VALUE && (endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd) > 0) {
            int i = endAfterPadding - (-scrollBy(-endAfterPadding, recycler, state));
            if (z && i > 0) {
                this.mPrimaryOrientation.offsetChildren(i);
            }
        }
    }

    private void fixStartGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int minStart;
        int startAfterPadding;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65554, this, recycler, state, z) == null) && (minStart = getMinStart(Integer.MAX_VALUE)) != Integer.MAX_VALUE && (startAfterPadding = minStart - this.mPrimaryOrientation.getStartAfterPadding()) > 0) {
            int scrollBy = startAfterPadding - scrollBy(startAfterPadding, recycler, state);
            if (z && scrollBy > 0) {
                this.mPrimaryOrientation.offsetChildren(-scrollBy);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048619, this, recyclerView, i, i2) == null) {
            handleUpdate(i, i2, 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048622, this, recyclerView, i, i2) == null) {
            handleUpdate(i, i2, 2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048631, this, i, recycler, state)) == null) {
            return scrollBy(i, recycler, state);
        }
        return invokeILL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048634, this, i, recycler, state)) == null) {
            return scrollBy(i, recycler, state);
        }
        return invokeILL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048640, this, recyclerView, state, i) == null) {
            LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
            linearSmoothScroller.setTargetPosition(i);
            startSmoothScroll(linearSmoothScroller);
        }
    }

    private boolean checkSpanForGap(Span span) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, span)) == null) {
            if (this.mShouldReverseLayout) {
                if (span.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding()) {
                    ArrayList<View> arrayList = span.mViews;
                    return !span.getLayoutParams(arrayList.get(arrayList.size() - 1)).mFullSpan;
                }
            } else if (span.getStartLine() > this.mPrimaryOrientation.getStartAfterPadding()) {
                return !span.getLayoutParams(span.mViews.get(0)).mFullSpan;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private Span getNextSpan(LayoutState layoutState) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, this, layoutState)) == null) {
            int i3 = -1;
            if (preferLastSpan(layoutState.mLayoutDirection)) {
                i = this.mSpanCount - 1;
                i2 = -1;
            } else {
                i = 0;
                i3 = this.mSpanCount;
                i2 = 1;
            }
            Span span = null;
            if (layoutState.mLayoutDirection == 1) {
                int i4 = Integer.MAX_VALUE;
                int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                while (i != i3) {
                    Span span2 = this.mSpans[i];
                    int endLine = span2.getEndLine(startAfterPadding);
                    if (endLine < i4) {
                        span = span2;
                        i4 = endLine;
                    }
                    i += i2;
                }
                return span;
            }
            int i5 = Integer.MIN_VALUE;
            int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
            while (i != i3) {
                Span span3 = this.mSpans[i];
                int startLine = span3.getStartLine(endAfterPadding);
                if (startLine > i5) {
                    span = span3;
                    i5 = startLine;
                }
                i += i2;
            }
            return span;
        }
        return (Span) invokeL.objValue;
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, iArr)) == null) {
            if (iArr == null) {
                iArr = new int[this.mSpanCount];
            } else if (iArr.length < this.mSpanCount) {
                throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
            }
            for (int i = 0; i < this.mSpanCount; i++) {
                iArr[i] = this.mSpans[i].findFirstCompletelyVisibleItemPosition();
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public View findFirstVisibleItemClosestToEnd(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
            int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
            View view2 = null;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
                int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
                if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                    if (decoratedEnd > endAfterPadding && z) {
                        if (view2 == null) {
                            view2 = childAt;
                        }
                    } else {
                        return childAt;
                    }
                }
            }
            return view2;
        }
        return (View) invokeZ.objValue;
    }

    public View findFirstVisibleItemClosestToStart(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
            int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
            int childCount = getChildCount();
            View view2 = null;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
                if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                    if (decoratedStart < startAfterPadding && z) {
                        if (view2 == null) {
                            view2 = childAt;
                        }
                    } else {
                        return childAt;
                    }
                }
            }
            return view2;
        }
        return (View) invokeZ.objValue;
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, iArr)) == null) {
            if (iArr == null) {
                iArr = new int[this.mSpanCount];
            } else if (iArr.length < this.mSpanCount) {
                throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
            }
            for (int i = 0; i < this.mSpanCount; i++) {
                iArr[i] = this.mSpans[i].findFirstVisibleItemPosition();
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, iArr)) == null) {
            if (iArr == null) {
                iArr = new int[this.mSpanCount];
            } else if (iArr.length < this.mSpanCount) {
                throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
            }
            for (int i = 0; i < this.mSpanCount; i++) {
                iArr[i] = this.mSpans[i].findLastCompletelyVisibleItemPosition();
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, iArr)) == null) {
            if (iArr == null) {
                iArr = new int[this.mSpanCount];
            } else if (iArr.length < this.mSpanCount) {
                throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
            }
            for (int i = 0; i < this.mSpanCount; i++) {
                iArr[i] = this.mSpans[i].findLastVisibleItemPosition();
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    private int computeScrollExtent(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, state)) == null) {
            if (getChildCount() == 0) {
                return 0;
            }
            return ScrollbarHelper.computeScrollExtent(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
        }
        return invokeL.intValue;
    }

    private int computeScrollOffset(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, state)) == null) {
            if (getChildCount() == 0) {
                return 0;
            }
            return ScrollbarHelper.computeScrollOffset(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
        }
        return invokeL.intValue;
    }

    private int computeScrollRange(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, state)) == null) {
            if (getChildCount() == 0) {
                return 0;
            }
            return ScrollbarHelper.computeScrollRange(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
        }
        return invokeL.intValue;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i)) == null) {
            LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
            fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
            for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                fullSpanItem.mGapPerSpan[i2] = i - this.mSpans[i2].getEndLine(i);
            }
            return fullSpanItem;
        }
        return (LazySpanLookup.FullSpanItem) invokeI.objValue;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i)) == null) {
            LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
            fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
            for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                fullSpanItem.mGapPerSpan[i2] = this.mSpans[i2].getStartLine(i) - i;
            }
            return fullSpanItem;
        }
        return (LazySpanLookup.FullSpanItem) invokeI.objValue;
    }

    private boolean preferLastSpan(int i) {
        InterceptResult invokeI;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65564, this, i)) == null) {
            if (this.mOrientation == 0) {
                if (i == -1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 != this.mShouldReverseLayout) {
                    return true;
                }
                return false;
            }
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z == this.mShouldReverseLayout) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 == isLayoutRTL()) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            if (getChildCount() > 0) {
                View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false);
                View findFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false);
                if (findFirstVisibleItemClosestToStart != null && findFirstVisibleItemClosestToEnd != null) {
                    int position = getPosition(findFirstVisibleItemClosestToStart);
                    int position2 = getPosition(findFirstVisibleItemClosestToEnd);
                    if (position < position2) {
                        accessibilityEvent.setFromIndex(position);
                        accessibilityEvent.setToIndex(position2);
                        return;
                    }
                    accessibilityEvent.setFromIndex(position2);
                    accessibilityEvent.setToIndex(position);
                }
            }
        }
    }

    public void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i) == null) {
            if (i != 0 && i != 1) {
                throw new IllegalArgumentException("invalid orientation.");
            }
            assertNotInLayoutOrScroll(null);
            if (i == this.mOrientation) {
                return;
            }
            this.mOrientation = i;
            OrientationHelper orientationHelper = this.mPrimaryOrientation;
            this.mPrimaryOrientation = this.mSecondaryOrientation;
            this.mSecondaryOrientation = orientationHelper;
            requestLayout();
        }
    }

    public void setSpanCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            assertNotInLayoutOrScroll(null);
            if (i != this.mSpanCount) {
                invalidateSpanAssignments();
                this.mSpanCount = i;
                this.mRemainingSpans = new BitSet(this.mSpanCount);
                this.mSpans = new Span[this.mSpanCount];
                for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                    this.mSpans[i2] = new Span(this, i2);
                }
                requestLayout();
            }
        }
    }

    private void createOrientationHelpers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
            this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
        }
    }

    private void resolveShouldLayoutReverse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            if (this.mOrientation != 1 && isLayoutRTL()) {
                this.mShouldReverseLayout = !this.mReverseLayout;
            } else {
                this.mShouldReverseLayout = this.mReverseLayout;
            }
        }
    }

    public boolean areAllEndsEqual() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int endLine = this.mSpans[0].getEndLine(Integer.MIN_VALUE);
            for (int i = 1; i < this.mSpanCount; i++) {
                if (this.mSpans[i].getEndLine(Integer.MIN_VALUE) != endLine) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean areAllStartsEqual() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int startLine = this.mSpans[0].getStartLine(Integer.MIN_VALUE);
            for (int i = 1; i < this.mSpanCount; i++) {
                if (this.mSpans[i].getStartLine(Integer.MIN_VALUE) != startLine) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mOrientation == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int findFirstVisibleItemPositionInt() {
        InterceptResult invokeV;
        View findFirstVisibleItemClosestToStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.mShouldReverseLayout) {
                findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToEnd(true);
            } else {
                findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(true);
            }
            if (findFirstVisibleItemClosestToStart == null) {
                return -1;
            }
            return getPosition(findFirstVisibleItemClosestToStart);
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.mOrientation == 0) {
                return new LayoutParams(-2, -1);
            }
            return new LayoutParams(-1, -2);
        }
        return (RecyclerView.LayoutParams) invokeV.objValue;
    }

    public int getFirstChildPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (getChildCount() == 0) {
                return 0;
            }
            return getPosition(getChildAt(0));
        }
        return invokeV.intValue;
    }

    public int getGapStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mGapStrategy;
        }
        return invokeV.intValue;
    }

    public int getLastChildPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            int childCount = getChildCount();
            if (childCount == 0) {
                return 0;
            }
            return getPosition(getChildAt(childCount - 1));
        }
        return invokeV.intValue;
    }

    public int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.mOrientation;
        }
        return invokeV.intValue;
    }

    public boolean getReverseLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mReverseLayout;
        }
        return invokeV.booleanValue;
    }

    public int getSpanCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mSpanCount;
        }
        return invokeV.intValue;
    }

    public void invalidateSpanAssignments() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.mLazySpanLookup.clear();
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.mGapStrategy != 0) {
                return true;
            }
            return false;
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

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (this.mPendingSavedState == null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r16v0, resolved type: androidx.recyclerview.widget.StaggeredGridLayoutManager */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        InterceptResult invokeLLL;
        int i;
        int i2;
        int startAfterPadding;
        int maxEnd;
        boolean z;
        Span span;
        int startLine;
        int decoratedMeasurement;
        int i3;
        int startAfterPadding2;
        int i4;
        int decoratedMeasurement2;
        int endAfterPadding;
        boolean areAllStartsEqual;
        int endLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, this, recycler, layoutState, state)) == null) {
            ?? r9 = 0;
            this.mRemainingSpans.set(0, this.mSpanCount, true);
            if (this.mLayoutState.mInfinite) {
                if (layoutState.mLayoutDirection == 1) {
                    i2 = Integer.MAX_VALUE;
                } else {
                    i2 = Integer.MIN_VALUE;
                }
            } else {
                if (layoutState.mLayoutDirection == 1) {
                    i = layoutState.mEndLine + layoutState.mAvailable;
                } else {
                    i = layoutState.mStartLine - layoutState.mAvailable;
                }
                i2 = i;
            }
            updateAllRemainingSpans(layoutState.mLayoutDirection, i2);
            if (this.mShouldReverseLayout) {
                startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
            } else {
                startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
            }
            int i5 = startAfterPadding;
            boolean z2 = false;
            while (layoutState.hasMore(state) && (this.mLayoutState.mInfinite || !this.mRemainingSpans.isEmpty())) {
                View next = layoutState.next(recycler);
                LayoutParams layoutParams = (LayoutParams) next.getLayoutParams();
                int viewLayoutPosition = layoutParams.getViewLayoutPosition();
                int span2 = this.mLazySpanLookup.getSpan(viewLayoutPosition);
                if (span2 == -1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (layoutParams.mFullSpan) {
                        span = this.mSpans[r9];
                    } else {
                        span = getNextSpan(layoutState);
                    }
                    this.mLazySpanLookup.setSpan(viewLayoutPosition, span);
                } else {
                    span = this.mSpans[span2];
                }
                Span span3 = span;
                layoutParams.mSpan = span3;
                if (layoutState.mLayoutDirection == 1) {
                    addView(next);
                } else {
                    addView(next, r9);
                }
                measureChildWithDecorationsAndMargin(next, layoutParams, r9);
                if (layoutState.mLayoutDirection == 1) {
                    if (layoutParams.mFullSpan) {
                        endLine = getMaxEnd(i5);
                    } else {
                        endLine = span3.getEndLine(i5);
                    }
                    int decoratedMeasurement3 = this.mPrimaryOrientation.getDecoratedMeasurement(next) + endLine;
                    if (z && layoutParams.mFullSpan) {
                        LazySpanLookup.FullSpanItem createFullSpanItemFromEnd = createFullSpanItemFromEnd(endLine);
                        createFullSpanItemFromEnd.mGapDir = -1;
                        createFullSpanItemFromEnd.mPosition = viewLayoutPosition;
                        this.mLazySpanLookup.addFullSpanItem(createFullSpanItemFromEnd);
                    }
                    i3 = decoratedMeasurement3;
                    decoratedMeasurement = endLine;
                } else {
                    if (layoutParams.mFullSpan) {
                        startLine = getMinStart(i5);
                    } else {
                        startLine = span3.getStartLine(i5);
                    }
                    decoratedMeasurement = startLine - this.mPrimaryOrientation.getDecoratedMeasurement(next);
                    if (z && layoutParams.mFullSpan) {
                        LazySpanLookup.FullSpanItem createFullSpanItemFromStart = createFullSpanItemFromStart(startLine);
                        createFullSpanItemFromStart.mGapDir = 1;
                        createFullSpanItemFromStart.mPosition = viewLayoutPosition;
                        this.mLazySpanLookup.addFullSpanItem(createFullSpanItemFromStart);
                    }
                    i3 = startLine;
                }
                if (layoutParams.mFullSpan && layoutState.mItemDirection == -1) {
                    if (z) {
                        this.mLaidOutInvalidFullSpan = true;
                    } else {
                        if (layoutState.mLayoutDirection == 1) {
                            areAllStartsEqual = areAllEndsEqual();
                        } else {
                            areAllStartsEqual = areAllStartsEqual();
                        }
                        if (!areAllStartsEqual) {
                            LazySpanLookup.FullSpanItem fullSpanItem = this.mLazySpanLookup.getFullSpanItem(viewLayoutPosition);
                            if (fullSpanItem != null) {
                                fullSpanItem.mHasUnwantedGapAfter = true;
                            }
                            this.mLaidOutInvalidFullSpan = true;
                        }
                    }
                }
                attachViewToSpans(next, layoutParams, layoutState);
                if (isLayoutRTL() && this.mOrientation == 1) {
                    if (layoutParams.mFullSpan) {
                        endAfterPadding = this.mSecondaryOrientation.getEndAfterPadding();
                    } else {
                        endAfterPadding = this.mSecondaryOrientation.getEndAfterPadding() - (((this.mSpanCount - 1) - span3.mIndex) * this.mSizePerSpan);
                    }
                    decoratedMeasurement2 = endAfterPadding;
                    i4 = endAfterPadding - this.mSecondaryOrientation.getDecoratedMeasurement(next);
                } else {
                    if (layoutParams.mFullSpan) {
                        startAfterPadding2 = this.mSecondaryOrientation.getStartAfterPadding();
                    } else {
                        startAfterPadding2 = (span3.mIndex * this.mSizePerSpan) + this.mSecondaryOrientation.getStartAfterPadding();
                    }
                    i4 = startAfterPadding2;
                    decoratedMeasurement2 = this.mSecondaryOrientation.getDecoratedMeasurement(next) + startAfterPadding2;
                }
                if (this.mOrientation == 1) {
                    layoutDecoratedWithMargins(next, i4, decoratedMeasurement, decoratedMeasurement2, i3);
                } else {
                    layoutDecoratedWithMargins(next, decoratedMeasurement, i4, i3, decoratedMeasurement2);
                }
                if (layoutParams.mFullSpan) {
                    updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, i2);
                } else {
                    updateRemainingSpans(span3, this.mLayoutState.mLayoutDirection, i2);
                }
                recycle(recycler, this.mLayoutState);
                if (this.mLayoutState.mStopInFocusable && next.hasFocusable()) {
                    if (layoutParams.mFullSpan) {
                        this.mRemainingSpans.clear();
                    } else {
                        this.mRemainingSpans.set(span3.mIndex, false);
                        z2 = true;
                        r9 = 0;
                    }
                }
                z2 = true;
                r9 = 0;
            }
            if (!z2) {
                recycle(recycler, this.mLayoutState);
            }
            if (this.mLayoutState.mLayoutDirection == -1) {
                maxEnd = this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
            } else {
                maxEnd = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
            }
            if (maxEnd > 0) {
                return Math.min(layoutState.mAvailable, maxEnd);
            }
            return 0;
        }
        return invokeLLL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleUpdate(int i, int i2, int i3) {
        int firstChildPosition;
        int i4;
        int i5;
        int lastChildPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65560, this, i, i2, i3) == null) {
            if (this.mShouldReverseLayout) {
                firstChildPosition = getLastChildPosition();
            } else {
                firstChildPosition = getFirstChildPosition();
            }
            if (i3 == 8) {
                if (i < i2) {
                    i4 = i2 + 1;
                } else {
                    i4 = i + 1;
                    i5 = i2;
                    this.mLazySpanLookup.invalidateAfter(i5);
                    if (i3 == 1) {
                        if (i3 != 2) {
                            if (i3 == 8) {
                                this.mLazySpanLookup.offsetForRemoval(i, 1);
                                this.mLazySpanLookup.offsetForAddition(i2, 1);
                            }
                        } else {
                            this.mLazySpanLookup.offsetForRemoval(i, i2);
                        }
                    } else {
                        this.mLazySpanLookup.offsetForAddition(i, i2);
                    }
                    if (i4 > firstChildPosition) {
                        return;
                    }
                    if (this.mShouldReverseLayout) {
                        lastChildPosition = getFirstChildPosition();
                    } else {
                        lastChildPosition = getLastChildPosition();
                    }
                    if (i5 <= lastChildPosition) {
                        requestLayout();
                        return;
                    }
                    return;
                }
            } else {
                i4 = i + i2;
            }
            i5 = i;
            this.mLazySpanLookup.invalidateAfter(i5);
            if (i3 == 1) {
            }
            if (i4 > firstChildPosition) {
            }
        }
    }

    private void measureChildWithDecorationsAndMargin(View view2, LayoutParams layoutParams, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65562, this, view2, layoutParams, z) == null) {
            if (layoutParams.mFullSpan) {
                if (this.mOrientation == 1) {
                    measureChildWithDecorationsAndMargin(view2, this.mFullSizeSpec, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z);
                } else {
                    measureChildWithDecorationsAndMargin(view2, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.mFullSizeSpec, z);
                }
            } else if (this.mOrientation == 1) {
                measureChildWithDecorationsAndMargin(view2, RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z);
            } else {
                measureChildWithDecorationsAndMargin(view2, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), z);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x015b, code lost:
        if (checkForGaps() != false) goto L85;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        boolean z2;
        boolean z3;
        SavedState savedState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65563, this, recycler, state, z) == null) {
            AnchorInfo anchorInfo = this.mAnchorInfo;
            if ((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && state.getItemCount() == 0) {
                removeAndRecycleAllViews(recycler);
                anchorInfo.reset();
                return;
            }
            boolean z4 = true;
            if (anchorInfo.mValid && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                anchorInfo.reset();
                if (this.mPendingSavedState != null) {
                    applyPendingSavedState(anchorInfo);
                } else {
                    resolveShouldLayoutReverse();
                    anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
                }
                updateAnchorInfoForLayout(state, anchorInfo);
                anchorInfo.mValid = true;
            }
            if (this.mPendingSavedState == null && this.mPendingScrollPosition == -1 && (anchorInfo.mLayoutFromEnd != this.mLastLayoutFromEnd || isLayoutRTL() != this.mLastLayoutRTL)) {
                this.mLazySpanLookup.clear();
                anchorInfo.mInvalidateOffsets = true;
            }
            if (getChildCount() > 0 && ((savedState = this.mPendingSavedState) == null || savedState.mSpanOffsetsSize < 1)) {
                if (anchorInfo.mInvalidateOffsets) {
                    for (int i = 0; i < this.mSpanCount; i++) {
                        this.mSpans[i].clear();
                        int i2 = anchorInfo.mOffset;
                        if (i2 != Integer.MIN_VALUE) {
                            this.mSpans[i].setLine(i2);
                        }
                    }
                } else if (!z2 && this.mAnchorInfo.mSpanReferenceLines != null) {
                    for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                        Span span = this.mSpans[i3];
                        span.clear();
                        span.setLine(this.mAnchorInfo.mSpanReferenceLines[i3]);
                    }
                } else {
                    for (int i4 = 0; i4 < this.mSpanCount; i4++) {
                        this.mSpans[i4].cacheReferenceLineAndClear(this.mShouldReverseLayout, anchorInfo.mOffset);
                    }
                    this.mAnchorInfo.saveSpanReferenceLines(this.mSpans);
                }
            }
            detachAndScrapAttachedViews(recycler);
            this.mLayoutState.mRecycle = false;
            this.mLaidOutInvalidFullSpan = false;
            updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
            updateLayoutState(anchorInfo.mPosition, state);
            if (anchorInfo.mLayoutFromEnd) {
                setLayoutStateDirection(-1);
                fill(recycler, this.mLayoutState, state);
                setLayoutStateDirection(1);
                LayoutState layoutState = this.mLayoutState;
                layoutState.mCurrentPosition = anchorInfo.mPosition + layoutState.mItemDirection;
                fill(recycler, layoutState, state);
            } else {
                setLayoutStateDirection(1);
                fill(recycler, this.mLayoutState, state);
                setLayoutStateDirection(-1);
                LayoutState layoutState2 = this.mLayoutState;
                layoutState2.mCurrentPosition = anchorInfo.mPosition + layoutState2.mItemDirection;
                fill(recycler, layoutState2, state);
            }
            repositionToWrapContentIfNecessary();
            if (getChildCount() > 0) {
                if (this.mShouldReverseLayout) {
                    fixEndGap(recycler, state, true);
                    fixStartGap(recycler, state, false);
                } else {
                    fixStartGap(recycler, state, true);
                    fixEndGap(recycler, state, false);
                }
            }
            if (z && !state.isPreLayout()) {
                if (this.mGapStrategy != 0 && getChildCount() > 0 && (this.mLaidOutInvalidFullSpan || hasGapsToFix() != null)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    removeCallbacks(this.mCheckForGapsRunnable);
                }
            }
            z4 = false;
            if (state.isPreLayout()) {
                this.mAnchorInfo.reset();
            }
            this.mLastLayoutFromEnd = anchorInfo.mLayoutFromEnd;
            this.mLastLayoutRTL = isLayoutRTL();
            if (z4) {
                this.mAnchorInfo.reset();
                onLayoutChildren(recycler, state, false);
            }
        }
    }

    private void repositionToWrapContentIfNecessary() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65569, this) != null) || this.mSecondaryOrientation.getMode() == 1073741824) {
            return;
        }
        float f = 0.0f;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            float decoratedMeasurement = this.mSecondaryOrientation.getDecoratedMeasurement(childAt);
            if (decoratedMeasurement >= f) {
                if (((LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                    decoratedMeasurement = (decoratedMeasurement * 1.0f) / this.mSpanCount;
                }
                f = Math.max(f, decoratedMeasurement);
            }
        }
        int i2 = this.mSizePerSpan;
        int round = Math.round(f * this.mSpanCount);
        if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
            round = Math.min(round, this.mSecondaryOrientation.getTotalSpace());
        }
        updateMeasureSpecs(round);
        if (this.mSizePerSpan == i2) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (!layoutParams.mFullSpan) {
                if (isLayoutRTL() && this.mOrientation == 1) {
                    int i4 = this.mSpanCount;
                    int i5 = layoutParams.mSpan.mIndex;
                    childAt2.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.mSizePerSpan) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = layoutParams.mSpan.mIndex;
                    int i7 = this.mSizePerSpan * i6;
                    int i8 = i6 * i2;
                    if (this.mOrientation == 1) {
                        childAt2.offsetLeftAndRight(i7 - i8);
                    } else {
                        childAt2.offsetTopAndBottom(i7 - i8);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0078, code lost:
        if (r10 == r11) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
        if (r10 == r11) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008c, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008e, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View hasGapsToFix() {
        InterceptResult invokeV;
        char c;
        int i;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            int childCount = getChildCount() - 1;
            BitSet bitSet = new BitSet(this.mSpanCount);
            bitSet.set(0, this.mSpanCount, true);
            int i3 = -1;
            if (this.mOrientation == 1 && isLayoutRTL()) {
                c = 1;
            } else {
                c = 65535;
            }
            if (this.mShouldReverseLayout) {
                i = -1;
            } else {
                i = childCount + 1;
                childCount = 0;
            }
            if (childCount < i) {
                i3 = 1;
            }
            while (childCount != i) {
                View childAt = getChildAt(childCount);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (bitSet.get(layoutParams.mSpan.mIndex)) {
                    if (checkSpanForGap(layoutParams.mSpan)) {
                        return childAt;
                    }
                    bitSet.clear(layoutParams.mSpan.mIndex);
                }
                if (!layoutParams.mFullSpan && (i2 = childCount + i3) != i) {
                    View childAt2 = getChildAt(i2);
                    if (this.mShouldReverseLayout) {
                        int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
                        int decoratedEnd2 = this.mPrimaryOrientation.getDecoratedEnd(childAt2);
                        if (decoratedEnd < decoratedEnd2) {
                            return childAt;
                        }
                    } else {
                        int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
                        int decoratedStart2 = this.mPrimaryOrientation.getDecoratedStart(childAt2);
                        if (decoratedStart > decoratedStart2) {
                            return childAt;
                        }
                    }
                    if (z) {
                        if (layoutParams.mSpan.mIndex - ((LayoutParams) childAt2.getLayoutParams()).mSpan.mIndex < 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (c < 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z2 != z3) {
                            return childAt;
                        }
                    } else {
                        continue;
                    }
                }
                childCount += i3;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        int firstChildPosition;
        int startLine;
        int startAfterPadding;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (this.mPendingSavedState != null) {
                return new SavedState(this.mPendingSavedState);
            }
            SavedState savedState = new SavedState();
            savedState.mReverseLayout = this.mReverseLayout;
            savedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
            savedState.mLastLayoutRTL = this.mLastLayoutRTL;
            LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
            if (lazySpanLookup != null && (iArr = lazySpanLookup.mData) != null) {
                savedState.mSpanLookup = iArr;
                savedState.mSpanLookupSize = iArr.length;
                savedState.mFullSpanItems = lazySpanLookup.mFullSpanItems;
            } else {
                savedState.mSpanLookupSize = 0;
            }
            if (getChildCount() > 0) {
                if (this.mLastLayoutFromEnd) {
                    firstChildPosition = getLastChildPosition();
                } else {
                    firstChildPosition = getFirstChildPosition();
                }
                savedState.mAnchorPosition = firstChildPosition;
                savedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
                int i = this.mSpanCount;
                savedState.mSpanOffsetsSize = i;
                savedState.mSpanOffsets = new int[i];
                for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                    if (this.mLastLayoutFromEnd) {
                        startLine = this.mSpans[i2].getEndLine(Integer.MIN_VALUE);
                        if (startLine != Integer.MIN_VALUE) {
                            startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                            startLine -= startAfterPadding;
                            savedState.mSpanOffsets[i2] = startLine;
                        } else {
                            savedState.mSpanOffsets[i2] = startLine;
                        }
                    } else {
                        startLine = this.mSpans[i2].getStartLine(Integer.MIN_VALUE);
                        if (startLine != Integer.MIN_VALUE) {
                            startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                            startLine -= startAfterPadding;
                            savedState.mSpanOffsets[i2] = startLine;
                        } else {
                            savedState.mSpanOffsets[i2] = startLine;
                        }
                    }
                }
            } else {
                savedState.mAnchorPosition = -1;
                savedState.mVisibleAnchorPosition = -1;
                savedState.mSpanOffsetsSize = 0;
            }
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    private void updateAllRemainingSpans(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65572, this, i, i2) == null) {
            for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                if (!this.mSpans[i3].mViews.isEmpty()) {
                    updateRemainingSpans(this.mSpans[i3], i, i2);
                }
            }
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.State state, AnchorInfo anchorInfo) {
        InterceptResult invokeLL;
        int findFirstReferenceChildPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, this, state, anchorInfo)) == null) {
            if (this.mLastLayoutFromEnd) {
                findFirstReferenceChildPosition = findLastReferenceChildPosition(state.getItemCount());
            } else {
                findFirstReferenceChildPosition = findFirstReferenceChildPosition(state.getItemCount());
            }
            anchorInfo.mPosition = findFirstReferenceChildPosition;
            anchorInfo.mOffset = Integer.MIN_VALUE;
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, context, attributeSet)) == null) {
            return new LayoutParams(context, attributeSet);
        }
        return (RecyclerView.LayoutParams) invokeLL.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, recycler, state)) == null) {
            if (this.mOrientation == 1) {
                return this.mSpanCount;
            }
            return super.getColumnCountForAccessibility(recycler, state);
        }
        return invokeLL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, recycler, state)) == null) {
            if (this.mOrientation == 0) {
                return this.mSpanCount;
            }
            return super.getRowCountForAccessibility(recycler, state);
        }
        return invokeLL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, recyclerView, recycler) == null) {
            super.onDetachedFromWindow(recyclerView, recycler);
            removeCallbacks(this.mCheckForGapsRunnable);
            for (int i = 0; i < this.mSpanCount; i++) {
                this.mSpans[i].clear();
            }
            recyclerView.requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, recycler, state) == null) {
            onLayoutChildren(recycler, state, true);
        }
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048633, this, i, i2) == null) {
            SavedState savedState = this.mPendingSavedState;
            if (savedState != null) {
                savedState.invalidateAnchorPositionInfo();
            }
            this.mPendingScrollPosition = i;
            this.mPendingScrollPositionOffset = i2;
            requestLayout();
        }
    }

    public void updateAnchorInfoForLayout(RecyclerView.State state, AnchorInfo anchorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048643, this, state, anchorInfo) != null) || updateAnchorFromPendingData(state, anchorInfo) || updateAnchorFromChildren(state, anchorInfo)) {
            return;
        }
        anchorInfo.assignCoordinateFromPadding();
        anchorInfo.mPosition = 0;
    }

    private void updateRemainingSpans(Span span, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65575, this, span, i, i2) == null) {
            int deletedSize = span.getDeletedSize();
            if (i == -1) {
                if (span.getStartLine() + deletedSize <= i2) {
                    this.mRemainingSpans.set(span.mIndex, false);
                }
            } else if (span.getEndLine() - deletedSize >= i2) {
                this.mRemainingSpans.set(span.mIndex, false);
            }
        }
    }

    private int updateSpecWithExtra(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65576, this, i, i2, i3)) == null) {
            if (i2 == 0 && i3 == 0) {
                return i;
            }
            int mode = View.MeasureSpec.getMode(i);
            if (mode != Integer.MIN_VALUE && mode != 1073741824) {
                return i;
            }
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return invokeIII.intValue;
    }

    public int scrollBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048630, this, i, recycler, state)) == null) {
            if (getChildCount() == 0 || i == 0) {
                return 0;
            }
            prepareLayoutStateForDelta(i, state);
            int fill = fill(recycler, this.mLayoutState, state);
            if (this.mLayoutState.mAvailable >= fill) {
                if (i < 0) {
                    i = -fill;
                } else {
                    i = fill;
                }
            }
            this.mPrimaryOrientation.offsetChildren(-i);
            this.mLastLayoutFromEnd = this.mShouldReverseLayout;
            LayoutState layoutState = this.mLayoutState;
            layoutState.mAvailable = 0;
            recycle(recycler, layoutState);
            return i;
        }
        return invokeILL.intValue;
    }

    public boolean checkForGaps() {
        InterceptResult invokeV;
        int firstChildPosition;
        int lastChildPosition;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getChildCount() == 0 || this.mGapStrategy == 0 || !isAttachedToWindow()) {
                return false;
            }
            if (this.mShouldReverseLayout) {
                firstChildPosition = getLastChildPosition();
                lastChildPosition = getFirstChildPosition();
            } else {
                firstChildPosition = getFirstChildPosition();
                lastChildPosition = getLastChildPosition();
            }
            if (firstChildPosition == 0 && hasGapsToFix() != null) {
                this.mLazySpanLookup.clear();
                requestSimpleAnimationsInNextLayout();
                requestLayout();
                return true;
            } else if (!this.mLaidOutInvalidFullSpan) {
                return false;
            } else {
                if (this.mShouldReverseLayout) {
                    i = -1;
                } else {
                    i = 1;
                }
                int i2 = lastChildPosition + 1;
                LazySpanLookup.FullSpanItem firstFullSpanItemInRange = this.mLazySpanLookup.getFirstFullSpanItemInRange(firstChildPosition, i2, i, true);
                if (firstFullSpanItemInRange == null) {
                    this.mLaidOutInvalidFullSpan = false;
                    this.mLazySpanLookup.forceInvalidateAfter(i2);
                    return false;
                }
                LazySpanLookup.FullSpanItem firstFullSpanItemInRange2 = this.mLazySpanLookup.getFirstFullSpanItemInRange(firstChildPosition, firstFullSpanItemInRange.mPosition, i * (-1), true);
                if (firstFullSpanItemInRange2 == null) {
                    this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange.mPosition);
                } else {
                    this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange2.mPosition + 1);
                }
                requestSimpleAnimationsInNextLayout();
                requestLayout();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int endLine;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), state, layoutPrefetchRegistry}) == null) {
            if (this.mOrientation != 0) {
                i = i2;
            }
            if (getChildCount() != 0 && i != 0) {
                prepareLayoutStateForDelta(i, state);
                int[] iArr = this.mPrefetchDistances;
                if (iArr == null || iArr.length < this.mSpanCount) {
                    this.mPrefetchDistances = new int[this.mSpanCount];
                }
                int i4 = 0;
                for (int i5 = 0; i5 < this.mSpanCount; i5++) {
                    LayoutState layoutState = this.mLayoutState;
                    if (layoutState.mItemDirection == -1) {
                        endLine = layoutState.mStartLine;
                        i3 = this.mSpans[i5].getStartLine(endLine);
                    } else {
                        endLine = this.mSpans[i5].getEndLine(layoutState.mEndLine);
                        i3 = this.mLayoutState.mEndLine;
                    }
                    int i6 = endLine - i3;
                    if (i6 >= 0) {
                        this.mPrefetchDistances[i4] = i6;
                        i4++;
                    }
                }
                Arrays.sort(this.mPrefetchDistances, 0, i4);
                for (int i7 = 0; i7 < i4 && this.mLayoutState.hasMore(state); i7++) {
                    layoutPrefetchRegistry.addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[i7]);
                    LayoutState layoutState2 = this.mLayoutState;
                    layoutState2.mCurrentPosition += layoutState2.mItemDirection;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @Nullable
    public View onFocusSearchFailed(View view2, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeLILL;
        View findContainingItemView;
        int firstChildPosition;
        boolean z;
        boolean z2;
        int findLastPartiallyVisibleItemPosition;
        int findLastPartiallyVisibleItemPosition2;
        int findLastPartiallyVisibleItemPosition3;
        View focusableViewAfter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048616, this, view2, i, recycler, state)) == null) {
            if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view2)) == null) {
                return null;
            }
            resolveShouldLayoutReverse();
            int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i);
            if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
                return null;
            }
            LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
            boolean z3 = layoutParams.mFullSpan;
            Span span = layoutParams.mSpan;
            if (convertFocusDirectionToLayoutDirection == 1) {
                firstChildPosition = getLastChildPosition();
            } else {
                firstChildPosition = getFirstChildPosition();
            }
            updateLayoutState(firstChildPosition, state);
            setLayoutStateDirection(convertFocusDirectionToLayoutDirection);
            LayoutState layoutState = this.mLayoutState;
            layoutState.mCurrentPosition = layoutState.mItemDirection + firstChildPosition;
            layoutState.mAvailable = (int) (this.mPrimaryOrientation.getTotalSpace() * 0.33333334f);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mStopInFocusable = true;
            layoutState2.mRecycle = false;
            fill(recycler, layoutState2, state);
            this.mLastLayoutFromEnd = this.mShouldReverseLayout;
            if (!z3 && (focusableViewAfter = span.getFocusableViewAfter(firstChildPosition, convertFocusDirectionToLayoutDirection)) != null && focusableViewAfter != findContainingItemView) {
                return focusableViewAfter;
            }
            if (preferLastSpan(convertFocusDirectionToLayoutDirection)) {
                for (int i2 = this.mSpanCount - 1; i2 >= 0; i2--) {
                    View focusableViewAfter2 = this.mSpans[i2].getFocusableViewAfter(firstChildPosition, convertFocusDirectionToLayoutDirection);
                    if (focusableViewAfter2 != null && focusableViewAfter2 != findContainingItemView) {
                        return focusableViewAfter2;
                    }
                }
            } else {
                for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                    View focusableViewAfter3 = this.mSpans[i3].getFocusableViewAfter(firstChildPosition, convertFocusDirectionToLayoutDirection);
                    if (focusableViewAfter3 != null && focusableViewAfter3 != findContainingItemView) {
                        return focusableViewAfter3;
                    }
                }
            }
            boolean z4 = !this.mReverseLayout;
            if (convertFocusDirectionToLayoutDirection == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z4 == z) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z3) {
                if (z2) {
                    findLastPartiallyVisibleItemPosition3 = span.findFirstPartiallyVisibleItemPosition();
                } else {
                    findLastPartiallyVisibleItemPosition3 = span.findLastPartiallyVisibleItemPosition();
                }
                View findViewByPosition = findViewByPosition(findLastPartiallyVisibleItemPosition3);
                if (findViewByPosition != null && findViewByPosition != findContainingItemView) {
                    return findViewByPosition;
                }
            }
            if (preferLastSpan(convertFocusDirectionToLayoutDirection)) {
                for (int i4 = this.mSpanCount - 1; i4 >= 0; i4--) {
                    if (i4 != span.mIndex) {
                        if (z2) {
                            findLastPartiallyVisibleItemPosition2 = this.mSpans[i4].findFirstPartiallyVisibleItemPosition();
                        } else {
                            findLastPartiallyVisibleItemPosition2 = this.mSpans[i4].findLastPartiallyVisibleItemPosition();
                        }
                        View findViewByPosition2 = findViewByPosition(findLastPartiallyVisibleItemPosition2);
                        if (findViewByPosition2 != null && findViewByPosition2 != findContainingItemView) {
                            return findViewByPosition2;
                        }
                    }
                }
            } else {
                for (int i5 = 0; i5 < this.mSpanCount; i5++) {
                    if (z2) {
                        findLastPartiallyVisibleItemPosition = this.mSpans[i5].findFirstPartiallyVisibleItemPosition();
                    } else {
                        findLastPartiallyVisibleItemPosition = this.mSpans[i5].findLastPartiallyVisibleItemPosition();
                    }
                    View findViewByPosition3 = findViewByPosition(findLastPartiallyVisibleItemPosition);
                    if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                        return findViewByPosition3;
                    }
                }
            }
            return null;
        }
        return (View) invokeLILL.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048618, this, recycler, state, view2, accessibilityNodeInfoCompat) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (!(layoutParams instanceof LayoutParams)) {
                super.onInitializeAccessibilityNodeInfoForItem(view2, accessibilityNodeInfoCompat);
                return;
            }
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.mOrientation == 0) {
                int spanIndex = layoutParams2.getSpanIndex();
                if (layoutParams2.mFullSpan) {
                    i2 = this.mSpanCount;
                } else {
                    i2 = 1;
                }
                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanIndex, i2, -1, -1, false, false));
                return;
            }
            int spanIndex2 = layoutParams2.getSpanIndex();
            if (layoutParams2.mFullSpan) {
                i = this.mSpanCount;
            } else {
                i = 1;
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, spanIndex2, i, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048621, this, recyclerView, i, i2, i3) == null) {
            handleUpdate(i, i2, 8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{recyclerView, Integer.valueOf(i), Integer.valueOf(i2), obj}) == null) {
            handleUpdate(i, i2, 4);
        }
    }

    public void prepareLayoutStateForDelta(int i, RecyclerView.State state) {
        int firstChildPosition;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048629, this, i, state) == null) {
            if (i > 0) {
                firstChildPosition = getLastChildPosition();
                i2 = 1;
            } else {
                firstChildPosition = getFirstChildPosition();
                i2 = -1;
            }
            this.mLayoutState.mRecycle = true;
            updateLayoutState(firstChildPosition, state);
            setLayoutStateDirection(i2);
            LayoutState layoutState = this.mLayoutState;
            layoutState.mCurrentPosition = firstChildPosition + layoutState.mItemDirection;
            layoutState.mAvailable = Math.abs(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048636, this, rect, i, i2) == null) {
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.mOrientation == 1) {
                chooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
                chooseSize = RecyclerView.LayoutManager.chooseSize(i, (this.mSizePerSpan * this.mSpanCount) + paddingLeft, getMinimumWidth());
            } else {
                chooseSize = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
                chooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, (this.mSizePerSpan * this.mSpanCount) + paddingTop, getMinimumHeight());
            }
            setMeasuredDimension(chooseSize, chooseSize2);
        }
    }

    public boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        InterceptResult invokeLL;
        int i;
        int firstChildPosition;
        int startAfterPadding;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048642, this, state, anchorInfo)) == null) {
            boolean z = false;
            if (!state.isPreLayout() && (i = this.mPendingScrollPosition) != -1) {
                if (i >= 0 && i < state.getItemCount()) {
                    SavedState savedState = this.mPendingSavedState;
                    if (savedState != null && savedState.mAnchorPosition != -1 && savedState.mSpanOffsetsSize >= 1) {
                        anchorInfo.mOffset = Integer.MIN_VALUE;
                        anchorInfo.mPosition = this.mPendingScrollPosition;
                    } else {
                        View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                        if (findViewByPosition != null) {
                            if (this.mShouldReverseLayout) {
                                firstChildPosition = getLastChildPosition();
                            } else {
                                firstChildPosition = getFirstChildPosition();
                            }
                            anchorInfo.mPosition = firstChildPosition;
                            if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                                if (anchorInfo.mLayoutFromEnd) {
                                    anchorInfo.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                                } else {
                                    anchorInfo.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(findViewByPosition);
                                }
                                return true;
                            } else if (this.mPrimaryOrientation.getDecoratedMeasurement(findViewByPosition) > this.mPrimaryOrientation.getTotalSpace()) {
                                if (anchorInfo.mLayoutFromEnd) {
                                    startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                                } else {
                                    startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                                }
                                anchorInfo.mOffset = startAfterPadding;
                                return true;
                            } else {
                                int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(findViewByPosition) - this.mPrimaryOrientation.getStartAfterPadding();
                                if (decoratedStart < 0) {
                                    anchorInfo.mOffset = -decoratedStart;
                                    return true;
                                }
                                int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                                if (endAfterPadding < 0) {
                                    anchorInfo.mOffset = endAfterPadding;
                                    return true;
                                }
                                anchorInfo.mOffset = Integer.MIN_VALUE;
                            }
                        } else {
                            int i2 = this.mPendingScrollPosition;
                            anchorInfo.mPosition = i2;
                            int i3 = this.mPendingScrollPositionOffset;
                            if (i3 == Integer.MIN_VALUE) {
                                if (calculateScrollDirectionForPosition(i2) == 1) {
                                    z = true;
                                }
                                anchorInfo.mLayoutFromEnd = z;
                                anchorInfo.assignCoordinateFromPadding();
                            } else {
                                anchorInfo.assignCoordinateFromPadding(i3);
                            }
                            anchorInfo.mInvalidateOffsets = true;
                        }
                    }
                    return true;
                }
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
