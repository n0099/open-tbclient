package com.baidu.searchbox.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class BdHeaderFooterGridView extends GridView {
    public static final boolean DEBUG = false;
    public static final String TAG = "BdHeaderFooterGridView";
    public ArrayList<FixedViewInfo> mFooterViewInfos;
    public ArrayList<FixedViewInfo> mHeaderViewInfos;
    public ItemClickHandler mItemClickHandler;
    public int mNumColumns;
    public AdapterView.OnItemClickListener mOnItemClickListener;
    public AdapterView.OnItemLongClickListener mOnItemLongClickListener;
    public ListAdapter mOriginalAdapter;
    public int mRowHeight;
    public View mViewForMeasureRowHeight;

    private void initGridView() {
    }

    @Override // android.view.ViewGroup
    public void setClipChildren(boolean z) {
    }

    /* loaded from: classes4.dex */
    public static class FixedViewInfo {
        public Object data;
        public boolean isSelectable;

        /* renamed from: view  reason: collision with root package name */
        public View f1068view;
        public ViewGroup viewContainer;

        public FixedViewInfo() {
        }
    }

    /* loaded from: classes4.dex */
    public class FullWidthFixedViewLayout extends FrameLayout {
        public FullWidthFixedViewLayout(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((BdHeaderFooterGridView.this.getMeasuredWidth() - BdHeaderFooterGridView.this.getPaddingLeft()) - BdHeaderFooterGridView.this.getPaddingRight(), View.MeasureSpec.getMode(i)), i2);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int paddingLeft = BdHeaderFooterGridView.this.getPaddingLeft() + getPaddingLeft();
            if (paddingLeft != i) {
                offsetLeftAndRight(paddingLeft - i);
            }
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    /* loaded from: classes4.dex */
    public static class HeaderViewGridAdapter implements WrapperListAdapter, Filterable {
        public static final ArrayList<FixedViewInfo> EMPTY_INFO_LIST = new ArrayList<>();
        public final ListAdapter mAdapter;
        public boolean mAreAllFixedViewsSelectable;
        public ArrayList<FixedViewInfo> mFooterViewInfos;
        public ArrayList<FixedViewInfo> mHeaderViewInfos;
        public final boolean mIsFilterable;
        public final DataSetObservable mDataSetObservable = new DataSetObservable();
        public int mNumColumns = 1;
        public int mRowHeight = -1;
        public boolean mCachePlaceHoldView = true;
        public boolean mCacheFirstHeaderView = false;

        private int getAdapterAndPlaceHolderCount() {
            return (int) (Math.ceil((this.mAdapter.getCount() * 1.0f) / this.mNumColumns) * this.mNumColumns);
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && (!this.mAreAllFixedViewsSelectable || !listAdapter.areAllItemsEnabled())) {
                return false;
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.mAdapter != null) {
                return ((getFootersCount() + getHeadersCount()) * this.mNumColumns) + getAdapterAndPlaceHolderCount();
            }
            return (getFootersCount() + getHeadersCount()) * this.mNumColumns;
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            if (this.mIsFilterable) {
                return ((Filterable) this.mAdapter).getFilter();
            }
            return null;
        }

        public int getFootersCount() {
            return this.mFooterViewInfos.size();
        }

        public int getHeadersCount() {
            return this.mHeaderViewInfos.size();
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            int viewTypeCount;
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter == null) {
                viewTypeCount = 1;
            } else {
                viewTypeCount = listAdapter.getViewTypeCount();
            }
            if (this.mCachePlaceHoldView) {
                int size = this.mHeaderViewInfos.size() + 1 + this.mFooterViewInfos.size();
                if (this.mCacheFirstHeaderView) {
                    size++;
                }
                return viewTypeCount + size;
            }
            return viewTypeCount;
        }

        @Override // android.widget.WrapperListAdapter
        public ListAdapter getWrappedAdapter() {
            return this.mAdapter;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && listAdapter.hasStableIds()) {
                return true;
            }
            return false;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && !listAdapter.isEmpty()) {
                return false;
            }
            return true;
        }

        public void notifyDataSetChanged() {
            this.mDataSetObservable.notifyChanged();
        }

        public HeaderViewGridAdapter(ArrayList<FixedViewInfo> arrayList, ArrayList<FixedViewInfo> arrayList2, ListAdapter listAdapter) {
            boolean z = true;
            this.mAdapter = listAdapter;
            this.mIsFilterable = listAdapter instanceof Filterable;
            if (arrayList == null) {
                this.mHeaderViewInfos = EMPTY_INFO_LIST;
            } else {
                this.mHeaderViewInfos = arrayList;
            }
            if (arrayList2 == null) {
                this.mFooterViewInfos = EMPTY_INFO_LIST;
            } else {
                this.mFooterViewInfos = arrayList2;
            }
            this.mAreAllFixedViewsSelectable = (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) ? false : false;
        }

        private boolean areAllListInfosSelectable(ArrayList<FixedViewInfo> arrayList) {
            if (arrayList != null) {
                Iterator<FixedViewInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!it.next().isSelectable) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            int i2;
            int headersCount = getHeadersCount() * this.mNumColumns;
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && i >= headersCount && (i2 = i - headersCount) < listAdapter.getCount()) {
                return this.mAdapter.getItemId(i2);
            }
            return -1L;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDataSetObservable.registerObserver(dataSetObserver);
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void setNumColumns(int i) {
            if (i >= 1 && this.mNumColumns != i) {
                this.mNumColumns = i;
                notifyDataSetChanged();
            }
        }

        public void setRowHeight(int i) {
            this.mRowHeight = i;
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDataSetObservable.unregisterObserver(dataSetObserver);
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int headersCount = getHeadersCount();
            int i2 = this.mNumColumns;
            int i3 = headersCount * i2;
            if (i < i3) {
                if (i % i2 != 0) {
                    return null;
                }
                return this.mHeaderViewInfos.get(i / i2).data;
            }
            int i4 = i - i3;
            int i5 = 0;
            if (this.mAdapter != null && i4 < (i5 = getAdapterAndPlaceHolderCount())) {
                if (i4 >= this.mAdapter.getCount()) {
                    return null;
                }
                return this.mAdapter.getItem(i4);
            }
            int i6 = i4 - i5;
            if (i6 % this.mNumColumns != 0) {
                return null;
            }
            return this.mFooterViewInfos.get(i6).data;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            int i2;
            int headersCount = getHeadersCount();
            int i3 = this.mNumColumns;
            int i4 = headersCount * i3;
            if (i < i4) {
                if (i % i3 == 0 && this.mHeaderViewInfos.get(i / i3).isSelectable) {
                    return true;
                }
                return false;
            }
            int i5 = i - i4;
            if (this.mAdapter != null) {
                i2 = getAdapterAndPlaceHolderCount();
                if (i5 < i2) {
                    if (i5 < this.mAdapter.getCount() && this.mAdapter.isEnabled(i5)) {
                        return true;
                    }
                    return false;
                }
            } else {
                i2 = 0;
            }
            int i6 = i5 - i2;
            int i7 = this.mNumColumns;
            if (i6 % i7 == 0 && this.mFooterViewInfos.get(i6 / i7).isSelectable) {
                return true;
            }
            return false;
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            int viewTypeCount;
            int i2;
            int headersCount = getHeadersCount() * this.mNumColumns;
            ListAdapter listAdapter = this.mAdapter;
            int i3 = 0;
            if (listAdapter == null) {
                viewTypeCount = 0;
            } else {
                viewTypeCount = listAdapter.getViewTypeCount() - 1;
            }
            int i4 = -2;
            if (this.mCachePlaceHoldView && i < headersCount) {
                if (i == 0 && this.mCacheFirstHeaderView) {
                    i4 = this.mHeaderViewInfos.size() + viewTypeCount + this.mFooterViewInfos.size() + 1 + 1;
                }
                int i5 = this.mNumColumns;
                if (i % i5 != 0) {
                    i4 = (i / i5) + 1 + viewTypeCount;
                }
            }
            int i6 = i - headersCount;
            if (this.mAdapter != null) {
                i3 = getAdapterAndPlaceHolderCount();
                if (i6 >= 0 && i6 < i3) {
                    if (i6 < this.mAdapter.getCount()) {
                        i4 = this.mAdapter.getItemViewType(i6);
                    } else if (this.mCachePlaceHoldView) {
                        i4 = this.mHeaderViewInfos.size() + viewTypeCount + 1;
                    }
                }
            }
            if (this.mCachePlaceHoldView && (i2 = i6 - i3) >= 0 && i2 < getCount() && i2 % this.mNumColumns != 0) {
                return viewTypeCount + this.mHeaderViewInfos.size() + 1 + (i2 / this.mNumColumns) + 1;
            }
            return i4;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            int headersCount = getHeadersCount();
            int i2 = this.mNumColumns;
            int i3 = headersCount * i2;
            if (i < i3) {
                ViewGroup viewGroup2 = this.mHeaderViewInfos.get(i / i2).viewContainer;
                if (i % this.mNumColumns == 0) {
                    return viewGroup2;
                }
                if (view2 == null) {
                    view2 = new View(viewGroup.getContext());
                }
                view2.setVisibility(4);
                view2.setMinimumHeight(viewGroup2.getHeight());
                return view2;
            }
            int i4 = i - i3;
            int i5 = 0;
            if (this.mAdapter != null && i4 < (i5 = getAdapterAndPlaceHolderCount())) {
                if (i4 < this.mAdapter.getCount()) {
                    return this.mAdapter.getView(i4, view2, viewGroup);
                }
                if (view2 == null) {
                    view2 = new View(viewGroup.getContext());
                }
                view2.setVisibility(4);
                view2.setMinimumHeight(this.mRowHeight);
                return view2;
            }
            int i6 = i4 - i5;
            if (i6 < getCount()) {
                ViewGroup viewGroup3 = this.mFooterViewInfos.get(i6 / this.mNumColumns).viewContainer;
                if (i % this.mNumColumns == 0) {
                    return viewGroup3;
                }
                if (view2 == null) {
                    view2 = new View(viewGroup.getContext());
                }
                view2.setVisibility(4);
                view2.setMinimumHeight(viewGroup3.getHeight());
            }
            return view2;
        }

        public boolean removeFooter(View view2) {
            boolean z = false;
            for (int i = 0; i < this.mFooterViewInfos.size(); i++) {
                if (this.mFooterViewInfos.get(i).f1068view == view2) {
                    this.mFooterViewInfos.remove(i);
                    if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                        z = true;
                    }
                    this.mAreAllFixedViewsSelectable = z;
                    this.mDataSetObservable.notifyChanged();
                    return true;
                }
            }
            return false;
        }

        public boolean removeHeader(View view2) {
            boolean z = false;
            for (int i = 0; i < this.mHeaderViewInfos.size(); i++) {
                if (this.mHeaderViewInfos.get(i).f1068view == view2) {
                    this.mHeaderViewInfos.remove(i);
                    if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                        z = true;
                    }
                    this.mAreAllFixedViewsSelectable = z;
                    this.mDataSetObservable.notifyChanged();
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class ItemClickHandler implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
        public ItemClickHandler() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            int headerViewCount;
            if (BdHeaderFooterGridView.this.mOnItemClickListener != null && (headerViewCount = i - (BdHeaderFooterGridView.this.getHeaderViewCount() * BdHeaderFooterGridView.this.getNumColumnsCompatible())) >= 0) {
                BdHeaderFooterGridView.this.mOnItemClickListener.onItemClick(adapterView, view2, headerViewCount, j);
            }
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
            int headerViewCount;
            if (BdHeaderFooterGridView.this.mOnItemLongClickListener != null && (headerViewCount = i - (BdHeaderFooterGridView.this.getHeaderViewCount() * BdHeaderFooterGridView.this.getNumColumnsCompatible())) >= 0) {
                BdHeaderFooterGridView.this.mOnItemLongClickListener.onItemLongClick(adapterView, view2, headerViewCount, j);
                return true;
            }
            return true;
        }
    }

    public BdHeaderFooterGridView(Context context) {
        super(context);
        this.mNumColumns = -1;
        this.mViewForMeasureRowHeight = null;
        this.mRowHeight = -1;
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        initGridView();
    }

    public void addFooterView(View view2) {
        addFooterView(view2, null, true);
    }

    public void addHeaderView(View view2) {
        addHeaderView(view2, null, true);
    }

    public int getHeaderHeight(int i) {
        if (i >= 0) {
            return this.mHeaderViewInfos.get(i).f1068view.getMeasuredHeight();
        }
        return 0;
    }

    public boolean removeFooterView(View view2) {
        boolean z = false;
        if (this.mFooterViewInfos.size() > 0) {
            ListAdapter adapter = getAdapter();
            if (adapter != null && ((HeaderViewGridAdapter) adapter).removeFooter(view2)) {
                z = true;
            }
            removeFixedViewInfo(view2, this.mFooterViewInfos);
        }
        return z;
    }

    public boolean removeHeaderView(View view2) {
        boolean z = false;
        if (this.mHeaderViewInfos.size() > 0) {
            ListAdapter adapter = getAdapter();
            if (adapter != null && ((HeaderViewGridAdapter) adapter).removeHeader(view2)) {
                z = true;
            }
            removeFixedViewInfo(view2, this.mHeaderViewInfos);
        }
        return z;
    }

    public void setClipChildrenSupper(boolean z) {
        super.setClipChildren(false);
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i) {
        super.setNumColumns(i);
        this.mNumColumns = i;
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof HeaderViewGridAdapter)) {
            ((HeaderViewGridAdapter) adapter).setNumColumns(i);
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        super.setOnItemClickListener(getItemClickHandler());
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
        super.setOnItemLongClickListener(getItemClickHandler());
    }

    public void tryToScrollToBottomSmoothly(int i) {
        smoothScrollToPositionFromTop(getAdapter().getCount() - 1, 0, i);
    }

    public BdHeaderFooterGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNumColumns = -1;
        this.mViewForMeasureRowHeight = null;
        this.mRowHeight = -1;
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        initGridView();
    }

    private void removeFixedViewInfo(View view2, ArrayList<FixedViewInfo> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).f1068view == view2) {
                arrayList.remove(i);
                return;
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof HeaderViewGridAdapter)) {
            HeaderViewGridAdapter headerViewGridAdapter = (HeaderViewGridAdapter) adapter;
            headerViewGridAdapter.setNumColumns(getNumColumnsCompatible());
            headerViewGridAdapter.setRowHeight(getRowHeight());
        }
    }

    public BdHeaderFooterGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNumColumns = -1;
        this.mViewForMeasureRowHeight = null;
        this.mRowHeight = -1;
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        initGridView();
    }

    @TargetApi(16)
    private int getColumnWidthCompatible() {
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getColumnWidth();
        }
        try {
            Field declaredField = GridView.class.getDeclaredField("mColumnWidth");
            declaredField.setAccessible(true);
            return declaredField.getInt(this);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "getColumnWidthCompatible error: " + e);
            return 0;
        } catch (NoSuchFieldException e2) {
            Log.e(TAG, "getColumnWidthCompatible error: " + e2);
            return 0;
        }
    }

    private ItemClickHandler getItemClickHandler() {
        if (this.mItemClickHandler == null) {
            this.mItemClickHandler = new ItemClickHandler();
        }
        return this.mItemClickHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNumColumnsCompatible() {
        return super.getNumColumns();
    }

    public int getFooterViewCount() {
        return this.mFooterViewInfos.size();
    }

    public int getHeaderViewCount() {
        return this.mHeaderViewInfos.size();
    }

    @Override // android.widget.GridView
    @TargetApi(16)
    public int getHorizontalSpacing() {
        int horizontalSpacing;
        try {
            if (Build.VERSION.SDK_INT < 16) {
                Field declaredField = GridView.class.getDeclaredField("mHorizontalSpacing");
                declaredField.setAccessible(true);
                horizontalSpacing = declaredField.getInt(this);
            } else {
                horizontalSpacing = super.getHorizontalSpacing();
            }
            return horizontalSpacing;
        } catch (Exception unused) {
            return 0;
        }
    }

    public ListAdapter getOriginalAdapter() {
        return this.mOriginalAdapter;
    }

    @Override // android.widget.GridView
    @TargetApi(16)
    public int getVerticalSpacing() {
        int verticalSpacing;
        try {
            if (Build.VERSION.SDK_INT < 16) {
                Field declaredField = GridView.class.getDeclaredField("mVerticalSpacing");
                declaredField.setAccessible(true);
                verticalSpacing = declaredField.getInt(this);
            } else {
                verticalSpacing = super.getVerticalSpacing();
            }
            return verticalSpacing;
        } catch (Exception unused) {
            return 0;
        }
    }

    public void invalidateRowHeight() {
        this.mRowHeight = -1;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mViewForMeasureRowHeight = null;
    }

    public void tryToScrollToBottomSmoothly() {
        smoothScrollToPositionFromTop(getAdapter().getCount() - 1, 0);
    }

    public void addFooterView(View view2, Object obj, boolean z) {
        ListAdapter adapter = getAdapter();
        if (adapter != null && !(adapter instanceof HeaderViewGridAdapter)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        FixedViewInfo fixedViewInfo = new FixedViewInfo();
        FullWidthFixedViewLayout fullWidthFixedViewLayout = new FullWidthFixedViewLayout(getContext());
        if (layoutParams != null) {
            view2.setLayoutParams(new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height));
            fullWidthFixedViewLayout.setLayoutParams(new AbsListView.LayoutParams(layoutParams.width, layoutParams.height));
        }
        fullWidthFixedViewLayout.addView(view2);
        fixedViewInfo.f1068view = view2;
        fixedViewInfo.viewContainer = fullWidthFixedViewLayout;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.mFooterViewInfos.add(fixedViewInfo);
        if (adapter != null) {
            ((HeaderViewGridAdapter) adapter).notifyDataSetChanged();
        }
    }

    public void addHeaderView(View view2, Object obj, boolean z) {
        ListAdapter adapter = getAdapter();
        if (adapter != null && !(adapter instanceof HeaderViewGridAdapter)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        FixedViewInfo fixedViewInfo = new FixedViewInfo();
        FullWidthFixedViewLayout fullWidthFixedViewLayout = new FullWidthFixedViewLayout(getContext());
        if (layoutParams != null) {
            view2.setLayoutParams(new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height));
            fullWidthFixedViewLayout.setLayoutParams(new AbsListView.LayoutParams(layoutParams.width, layoutParams.height));
        }
        fullWidthFixedViewLayout.addView(view2);
        fixedViewInfo.f1068view = view2;
        fixedViewInfo.viewContainer = fullWidthFixedViewLayout;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.mHeaderViewInfos.add(fixedViewInfo);
        if (adapter != null) {
            ((HeaderViewGridAdapter) adapter).notifyDataSetChanged();
        }
    }

    public int getRowHeight() {
        int i = this.mRowHeight;
        if (i > 0) {
            return i;
        }
        ListAdapter adapter = getAdapter();
        int numColumnsCompatible = getNumColumnsCompatible();
        if (adapter == null || adapter.getCount() <= (this.mHeaderViewInfos.size() + this.mFooterViewInfos.size()) * numColumnsCompatible) {
            return -1;
        }
        int columnWidthCompatible = getColumnWidthCompatible();
        View view2 = getAdapter().getView(numColumnsCompatible * this.mHeaderViewInfos.size(), this.mViewForMeasureRowHeight, this);
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2, 0);
            view2.setLayoutParams(layoutParams);
        }
        view2.measure(GridView.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(columnWidthCompatible, 1073741824), 0, layoutParams.width), GridView.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, layoutParams.height));
        this.mViewForMeasureRowHeight = view2;
        int measuredHeight = view2.getMeasuredHeight();
        this.mRowHeight = measuredHeight;
        return measuredHeight;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        this.mOriginalAdapter = listAdapter;
        if (this.mHeaderViewInfos.size() <= 0 && this.mFooterViewInfos.size() <= 0) {
            super.setAdapter(listAdapter);
            return;
        }
        HeaderViewGridAdapter headerViewGridAdapter = new HeaderViewGridAdapter(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
        int numColumnsCompatible = getNumColumnsCompatible();
        if (numColumnsCompatible > 1) {
            headerViewGridAdapter.setNumColumns(numColumnsCompatible);
        }
        headerViewGridAdapter.setRowHeight(getRowHeight());
        super.setAdapter((ListAdapter) headerViewGridAdapter);
    }
}
