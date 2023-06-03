package com.baidu.searchbox.ui.stickylistheader;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class StickyAdapterWrapper extends BaseAdapter implements StickyListHeadersAdapter {
    public final Context mContext;
    public DataSetObserver mDataSetObserver;
    public StickyListHeadersAdapter mDelegate;
    public Drawable mDivider;
    public int mDividerHeight;
    public final List<View> mHeaderCache = new LinkedList();
    public OnHeaderClickListener mOnHeaderClickListener;

    /* loaded from: classes4.dex */
    public interface OnHeaderClickListener {
        void onHeaderClick(View view2, int i, long j);
    }

    public StickyAdapterWrapper(Context context, StickyListHeadersAdapter stickyListHeadersAdapter) {
        DataSetObserver dataSetObserver = new DataSetObserver() { // from class: com.baidu.searchbox.ui.stickylistheader.StickyAdapterWrapper.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                StickyAdapterWrapper.super.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                StickyAdapterWrapper.this.mHeaderCache.clear();
                StickyAdapterWrapper.super.notifyDataSetInvalidated();
            }
        };
        this.mDataSetObserver = dataSetObserver;
        this.mContext = context;
        this.mDelegate = stickyListHeadersAdapter;
        stickyListHeadersAdapter.registerDataSetObserver(dataSetObserver);
    }

    private View configureHeader(WrapperView wrapperView, final int i) {
        View view2 = wrapperView.mHeader;
        if (view2 == null) {
            view2 = popHeader();
        }
        View headerView = this.mDelegate.getHeaderView(i, view2, wrapperView);
        if (headerView == null) {
            return null;
        }
        headerView.setClickable(true);
        headerView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.stickylistheader.StickyAdapterWrapper.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (StickyAdapterWrapper.this.mOnHeaderClickListener != null) {
                    StickyAdapterWrapper.this.mOnHeaderClickListener.onHeaderClick(view3, i, StickyAdapterWrapper.this.mDelegate.getHeaderId(i));
                }
            }
        });
        return headerView;
    }

    public void setDivider(Drawable drawable, int i) {
        this.mDivider = drawable;
        this.mDividerHeight = i;
        notifyDataSetChanged();
    }

    private boolean previousPositionHasSameHeader(int i) {
        if (i != 0 && this.mDelegate.getHeaderId(i) == this.mDelegate.getHeaderId(i - 1)) {
            return true;
        }
        return false;
    }

    private void recycleHeaderIfExists(WrapperView wrapperView) {
        View view2 = wrapperView.mHeader;
        if (view2 != null) {
            view2.setVisibility(0);
            this.mHeaderCache.add(view2);
        }
    }

    public boolean equals(Object obj) {
        return this.mDelegate.equals(obj);
    }

    @Override // com.baidu.searchbox.ui.stickylistheader.StickyListHeadersAdapter
    public long getHeaderId(int i) {
        return this.mDelegate.getHeaderId(i);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mDelegate.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.mDelegate.getItemId(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.mDelegate.getItemViewType(i);
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        return this.mDelegate.getPositionForSection(i);
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        return this.mDelegate.getSectionForPosition(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return this.mDelegate.isEnabled(i);
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        this.mOnHeaderClickListener = onHeaderClickListener;
    }

    private View popHeader() {
        if (this.mHeaderCache.size() > 0) {
            return this.mHeaderCache.remove(0);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.mDelegate.areAllItemsEnabled();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDelegate.getCount();
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.mDelegate.getSections();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.mDelegate.getViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.mDelegate.hasStableIds();
    }

    public int hashCode() {
        return this.mDelegate.hashCode();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.mDelegate.isEmpty();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        ((BaseAdapter) this.mDelegate).notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        ((BaseAdapter) this.mDelegate).notifyDataSetInvalidated();
    }

    public String toString() {
        return this.mDelegate.toString();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view2, ViewGroup viewGroup) {
        return ((BaseAdapter) this.mDelegate).getDropDownView(i, view2, viewGroup);
    }

    @Override // com.baidu.searchbox.ui.stickylistheader.StickyListHeadersAdapter
    public View getHeaderView(int i, View view2, ViewGroup viewGroup) {
        return this.mDelegate.getHeaderView(i, view2, viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public WrapperView getView(int i, View view2, ViewGroup viewGroup) {
        WrapperView wrapperView;
        if (view2 == null) {
            wrapperView = new WrapperView(this.mContext);
        } else {
            wrapperView = (WrapperView) view2;
        }
        View view3 = this.mDelegate.getView(i, wrapperView.mItem, viewGroup);
        View view4 = null;
        if (previousPositionHasSameHeader(i)) {
            recycleHeaderIfExists(wrapperView);
        } else {
            view4 = configureHeader(wrapperView, i);
        }
        boolean z = view3 instanceof Checkable;
        if (z && !(wrapperView instanceof CheckableWrapperView)) {
            wrapperView = new CheckableWrapperView(this.mContext);
        } else if (!z && (wrapperView instanceof CheckableWrapperView)) {
            wrapperView = new WrapperView(this.mContext);
        }
        wrapperView.update(view3, view4, this.mDivider, this.mDividerHeight);
        return wrapperView;
    }
}
