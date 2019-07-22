package com.baidu.swan.apps.res.ui.wheelview;

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
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.wheelview.BdAdapterView;
/* loaded from: classes2.dex */
public abstract class BdAbsSpinner extends BdAdapterView<SpinnerAdapter> {
    Rect aMC;
    View aMD;
    a aME;
    SpinnerAdapter mAdapter;
    boolean mBlockLayoutRequests;
    private DataSetObserver mDataSetObserver;
    int mHeightMeasureSpec;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    private Rect mTouchFrame;
    int mWidthMeasureSpec;

    abstract void o(int i, boolean z);

    protected DataSetObserver getDataSetObserver() {
        return this.mDataSetObserver;
    }

    public BdAbsSpinner(Context context) {
        super(context);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.aMC = new Rect();
        this.aMD = null;
        this.aME = new a();
        KI();
    }

    public BdAbsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdAbsSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.aMC = new Rect();
        this.aMD = null;
        this.aME = new a();
        KI();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.AbsSpinner, i, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(a.j.AbsSpinner_entriesArray);
        if (textArray != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(17367049);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        obtainStyledAttributes.recycle();
    }

    private void KI() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
            resetList();
        }
        this.mAdapter = spinnerAdapter;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        if (this.mAdapter != null) {
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            checkFocus();
            this.mDataSetObserver = new BdAdapterView.b();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            int i = this.mItemCount > 0 ? 0 : -1;
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetList() {
        this.mDataChanged = false;
        this.mNeedSync = false;
        removeAllViewsInLayout();
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z = true;
        int i4 = 0;
        int mode = View.MeasureSpec.getMode(i);
        this.aMC.left = getPaddingLeft() > this.mSelectionLeftPadding ? getPaddingLeft() : this.mSelectionLeftPadding;
        this.aMC.top = getPaddingTop() > this.mSelectionTopPadding ? getPaddingTop() : this.mSelectionTopPadding;
        this.aMC.right = getPaddingRight() > this.mSelectionRightPadding ? getPaddingRight() : this.mSelectionRightPadding;
        this.aMC.bottom = getPaddingBottom() > this.mSelectionBottomPadding ? getPaddingBottom() : this.mSelectionBottomPadding;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition >= 0 && this.mAdapter != null) {
            View df = this.aME.df(selectedItemPosition);
            if (df == null) {
                df = this.mAdapter.getView(selectedItemPosition, null, this);
            }
            if (df != null) {
                this.aME.c(selectedItemPosition, df);
            }
            if (df != null) {
                if (df.getLayoutParams() == null) {
                    this.mBlockLayoutRequests = true;
                    df.setLayoutParams(generateDefaultLayoutParams());
                    this.mBlockLayoutRequests = false;
                }
                measureChild(df, i, i2);
                int ab = ab(df) + this.aMC.top + this.aMC.bottom;
                i3 = ac(df) + this.aMC.left + this.aMC.right;
                i4 = ab;
                z = false;
                if (z) {
                    i4 = this.aMC.top + this.aMC.bottom;
                    if (mode == 0) {
                        i3 = this.aMC.left + this.aMC.right;
                    }
                }
                setMeasuredDimension(resolveSize(Math.max(i3, getSuggestedMinimumWidth()), i), resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i2));
                this.mHeightMeasureSpec = i2;
                this.mWidthMeasureSpec = i;
            }
        }
        i3 = 0;
        if (z) {
        }
        setMeasuredDimension(resolveSize(Math.max(i3, getSuggestedMinimumWidth()), i), resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i2));
        this.mHeightMeasureSpec = i2;
        this.mWidthMeasureSpec = i;
    }

    int ab(View view) {
        return view.getMeasuredHeight();
    }

    int ac(View view) {
        return view.getMeasuredWidth();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void KJ() {
        int childCount = getChildCount();
        a aVar = this.aME;
        for (int i = 0; i < childCount; i++) {
            aVar.c(this.mFirstPosition + i, getChildAt(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void handleDataChanged() {
        super.handleDataChanged();
    }

    public void setSelection(int i, boolean z) {
        n(i, z && this.mFirstPosition <= i && i <= (this.mFirstPosition + getChildCount()) + (-1));
        checkSelectionChanged();
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void setSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
        checkSelectionChanged();
    }

    public void setNewSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }

    void n(int i, boolean z) {
        if (i != this.mOldSelectedPosition) {
            this.mBlockLayoutRequests = true;
            setNextSelectedPositionInt(i);
            o(i - this.mSelectedPosition, z);
            this.mBlockLayoutRequests = false;
        }
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public View getSelectedView() {
        if (this.mItemCount <= 0 || this.mSelectedPosition < 0) {
            return null;
        }
        return getChildAt(this.mSelectedPosition - this.mFirstPosition);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            super.requestLayout();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public SpinnerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public int getCount() {
        return this.mItemCount;
    }

    public int pointToPosition(int i, int i2) {
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            this.mTouchFrame = new Rect();
            rect = this.mTouchFrame;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return this.mFirstPosition + childCount;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.swan.apps.res.ui.wheelview.BdAbsSpinner.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: k */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dg */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        long aMH;
        int position;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aMH = parcel.readLong();
            this.position = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.aMH);
            parcel.writeInt(this.position);
        }

        public String toString() {
            return "BdAbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.aMH + " position=" + this.position + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aMH = getSelectedItemId();
        if (savedState.aMH >= 0) {
            savedState.position = getSelectedItemPosition();
        } else {
            savedState.position = -1;
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.aMH >= 0) {
            this.mDataChanged = true;
            this.mNeedSync = true;
            this.mSyncRowId = savedState.aMH;
            this.mSyncPosition = savedState.position;
            this.mSyncMode = 0;
            requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    class a {
        private SparseArray<View> aMF = new SparseArray<>();

        a() {
        }

        public void c(int i, View view) {
            this.aMF.put(i, view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View df(int i) {
            View view = this.aMF.get(i);
            if (view != null) {
                this.aMF.delete(i);
            }
            return view;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clear() {
            SparseArray<View> sparseArray = this.aMF;
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                View valueAt = sparseArray.valueAt(i);
                if (valueAt != null) {
                    BdAbsSpinner.this.removeDetachedView(valueAt, true);
                }
            }
            sparseArray.clear();
        }
    }
}
