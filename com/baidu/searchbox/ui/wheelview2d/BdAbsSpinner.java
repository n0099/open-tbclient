package com.baidu.searchbox.ui.wheelview2d;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.wheelview2d.BdAdapterView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class BdAbsSpinner extends BdAdapterView<SpinnerAdapter> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SpinnerAdapter mAdapter;
    public boolean mBlockLayoutRequests;
    public DataSetObserver mDataSetObserver;
    public int mHeightMeasureSpec;
    public Interpolator mInterpolator;
    public RecycleBin mRecycler;
    public View mSelectedView;
    public int mSelectionBottomPadding;
    public int mSelectionLeftPadding;
    public int mSelectionRightPadding;
    public int mSelectionTopPadding;
    public Rect mSpinnerPadding;
    public Rect mTouchFrame;
    public int mWidthMeasureSpec;

    /* renamed from: com.baidu.searchbox.ui.wheelview2d.BdAbsSpinner$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class RecycleBin {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<View> mScrapHeap;
        public final /* synthetic */ BdAbsSpinner this$0;

        public RecycleBin(BdAbsSpinner bdAbsSpinner) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdAbsSpinner};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdAbsSpinner;
            this.mScrapHeap = new SparseArray<>();
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SparseArray<View> sparseArray = this.mScrapHeap;
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    View valueAt = sparseArray.valueAt(i2);
                    if (valueAt != null) {
                        this.this$0.removeDetachedView(valueAt, true);
                    }
                }
                sparseArray.clear();
            }
        }

        public View get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                View view = this.mScrapHeap.get(i2);
                if (view != null) {
                    this.mScrapHeap.delete(i2);
                }
                return view;
            }
            return (View) invokeI.objValue;
        }

        public View peek(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.mScrapHeap.get(i2) : (View) invokeI.objValue;
        }

        public void put(int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, view) == null) {
                this.mScrapHeap.put(i2, view);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int position;
        public long selectedId;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-917241580, "Lcom/baidu/searchbox/ui/wheelview2d/BdAbsSpinner$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-917241580, "Lcom/baidu/searchbox/ui/wheelview2d/BdAbsSpinner$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.searchbox.ui.wheelview2d.BdAbsSpinner.SavedState.1
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
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                }
            };
        }

        public /* synthetic */ SavedState(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "BdAbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
            }
            return (String) invokeV.objValue;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeLong(this.selectedId);
                parcel.writeInt(this.position);
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
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.selectedId = parcel.readLong();
            this.position = parcel.readInt();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdAbsSpinner(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mSelectedView = null;
        this.mRecycler = new RecycleBin(this);
        initAbsSpinner();
    }

    private void initAbsSpinner() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            setFocusable(true);
            setWillNotDraw(false);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ViewGroup.LayoutParams(-1, -2) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    public int getChildHeight(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) ? view.getMeasuredHeight() : invokeL.intValue;
    }

    public int getChildWidth(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) ? view.getMeasuredWidth() : invokeL.intValue;
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mItemCount : invokeV.intValue;
    }

    public DataSetObserver getDataSetObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mDataSetObserver : (DataSetObserver) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public View getSelectedView() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mItemCount <= 0 || (i2 = this.mSelectedPosition) < 0) {
                return null;
            }
            return getChildAt(i2 - this.mFirstPosition);
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void handleDataChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.handleDataChanged();
        }
    }

    public abstract void layout(int i2, boolean z);

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            Rect rect = this.mSpinnerPadding;
            int paddingLeft = getPaddingLeft();
            int i5 = this.mSelectionLeftPadding;
            if (paddingLeft > i5) {
                i5 = getPaddingLeft();
            }
            rect.left = i5;
            Rect rect2 = this.mSpinnerPadding;
            int paddingTop = getPaddingTop();
            int i6 = this.mSelectionTopPadding;
            if (paddingTop > i6) {
                i6 = getPaddingTop();
            }
            rect2.top = i6;
            Rect rect3 = this.mSpinnerPadding;
            int paddingRight = getPaddingRight();
            int i7 = this.mSelectionRightPadding;
            if (paddingRight > i7) {
                i7 = getPaddingRight();
            }
            rect3.right = i7;
            Rect rect4 = this.mSpinnerPadding;
            int paddingBottom = getPaddingBottom();
            int i8 = this.mSelectionBottomPadding;
            if (paddingBottom > i8) {
                i8 = getPaddingBottom();
            }
            rect4.bottom = i8;
            if (this.mDataChanged) {
                handleDataChanged();
            }
            int selectedItemPosition = getSelectedItemPosition();
            boolean z = true;
            int i9 = 0;
            if (selectedItemPosition >= 0 && this.mAdapter != null) {
                View view = this.mRecycler.get(selectedItemPosition);
                if (view == null) {
                    view = this.mAdapter.getView(selectedItemPosition, null, this);
                }
                if (view != null) {
                    this.mRecycler.put(selectedItemPosition, view);
                }
                if (view != null) {
                    if (view.getLayoutParams() == null) {
                        this.mBlockLayoutRequests = true;
                        view.setLayoutParams(generateDefaultLayoutParams());
                        this.mBlockLayoutRequests = false;
                    }
                    measureChild(view, i2, i3);
                    int childHeight = getChildHeight(view);
                    Rect rect5 = this.mSpinnerPadding;
                    int i10 = childHeight + rect5.top + rect5.bottom;
                    int childWidth = getChildWidth(view);
                    Rect rect6 = this.mSpinnerPadding;
                    i9 = i10;
                    i4 = childWidth + rect6.left + rect6.right;
                    z = false;
                    if (z) {
                        Rect rect7 = this.mSpinnerPadding;
                        i9 = rect7.top + rect7.bottom;
                        if (mode == 0) {
                            i4 = rect7.right + rect7.left;
                        }
                    }
                    int max = Math.max(i9, getSuggestedMinimumHeight());
                    int max2 = Math.max(i4, getSuggestedMinimumWidth());
                    setMeasuredDimension(ViewGroup.resolveSize(max2, i2), ViewGroup.resolveSize(max, i3));
                    this.mHeightMeasureSpec = i3;
                    this.mWidthMeasureSpec = i2;
                }
            }
            i4 = 0;
            if (z) {
            }
            int max3 = Math.max(i9, getSuggestedMinimumHeight());
            int max22 = Math.max(i4, getSuggestedMinimumWidth());
            setMeasuredDimension(ViewGroup.resolveSize(max22, i2), ViewGroup.resolveSize(max3, i3));
            this.mHeightMeasureSpec = i3;
            this.mWidthMeasureSpec = i2;
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            long j = savedState.selectedId;
            if (j >= 0) {
                this.mDataChanged = true;
                this.mNeedSync = true;
                this.mSyncRowId = j;
                this.mSyncPosition = savedState.position;
                this.mSyncMode = 0;
                requestLayout();
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            long selectedItemId = getSelectedItemId();
            savedState.selectedId = selectedItemId;
            if (selectedItemId >= 0) {
                savedState.position = getSelectedItemPosition();
            } else {
                savedState.position = -1;
            }
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public int pointToPosition(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i2, i3)) == null) {
            Rect rect = this.mTouchFrame;
            if (rect == null) {
                rect = new Rect();
                this.mTouchFrame = rect;
            }
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt.getVisibility() == 0) {
                    childAt.getHitRect(rect);
                    if (rect.contains(i2, i3)) {
                        return this.mFirstPosition + childCount;
                    }
                }
            }
            return -1;
        }
        return invokeII.intValue;
    }

    public void recycleAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            int childCount = getChildCount();
            RecycleBin recycleBin = this.mRecycler;
            for (int i2 = 0; i2 < childCount; i2++) {
                recycleBin.put(this.mFirstPosition + i2, getChildAt(i2));
            }
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.mBlockLayoutRequests) {
            return;
        }
        super.requestLayout();
    }

    public void resetList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.mDataChanged = false;
            this.mNeedSync = false;
            removeAllViewsInLayout();
            this.mOldSelectedPosition = -1;
            this.mOldSelectedRowId = Long.MIN_VALUE;
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            invalidate();
        }
    }

    public void setNewSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            setNextSelectedPositionInt(i2);
            requestLayout();
            invalidate();
        }
    }

    public void setSelection(int i2, boolean z) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            boolean z2 = true;
            setSelectionInt(i2, (!z || (i3 = this.mFirstPosition) > i2 || i2 > (i3 + getChildCount()) - 1) ? false : false);
            checkSelectionChanged();
        }
    }

    public void setSelectionInt(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || i2 == this.mOldSelectedPosition) {
            return;
        }
        this.mBlockLayoutRequests = true;
        setNextSelectedPositionInt(i2);
        layout(i2 - this.mSelectedPosition, z);
        this.mBlockLayoutRequests = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public SpinnerAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAdapter : (SpinnerAdapter) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, spinnerAdapter) == null) {
            SpinnerAdapter spinnerAdapter2 = this.mAdapter;
            if (spinnerAdapter2 != null) {
                spinnerAdapter2.unregisterDataSetObserver(this.mDataSetObserver);
                resetList();
            }
            this.mAdapter = spinnerAdapter;
            this.mOldSelectedPosition = -1;
            this.mOldSelectedRowId = Long.MIN_VALUE;
            if (spinnerAdapter != null) {
                this.mOldItemCount = this.mItemCount;
                this.mItemCount = spinnerAdapter.getCount();
                checkFocus();
                BdAdapterView.AdapterDataSetObserver adapterDataSetObserver = new BdAdapterView.AdapterDataSetObserver(this);
                this.mDataSetObserver = adapterDataSetObserver;
                this.mAdapter.registerDataSetObserver(adapterDataSetObserver);
                int i2 = this.mItemCount > 0 ? 0 : -1;
                setSelectedPositionInt(i2);
                setNextSelectedPositionInt(i2);
                if (this.mItemCount == 0) {
                    checkSelectionChanged();
                }
            } else {
                checkFocus();
                resetList();
                checkSelectionChanged();
            }
            requestLayout();
        }
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void setSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            setNextSelectedPositionInt(i2);
            requestLayout();
            invalidate();
            checkSelectionChanged();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdAbsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdAbsSpinner(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mSelectedView = null;
        this.mRecycler = new RecycleBin(this);
        initAbsSpinner();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AbsSpinner, i2, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(R.styleable.AbsSpinner_entriesArray);
        if (textArray != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(17367049);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        obtainStyledAttributes.recycle();
    }
}
