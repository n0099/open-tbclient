package com.baidu.searchbox.ui.swipe;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.baidu.searchbox.ui.swipe.SwipeMenuListView;
import com.baidu.searchbox.ui.swipe.SwipeMenuView;
/* loaded from: classes4.dex */
public class SwipeMenuAdapter implements WrapperListAdapter, SwipeMenuView.OnSwipeItemClickListener {
    public static final boolean DEBUG = false;
    public static final String TAG = "SwipeMenuAdapter";
    public SwipeMenuContentAdapte mAdapter;
    public Context mContext;
    public SwipeMenuListView.OnMenuItemClickListener onMenuItemClickListener;

    public void createMenu(SwipeMenu swipeMenu) {
    }

    public SwipeMenuAdapter(Context context, ListAdapter listAdapter) {
        if (listAdapter instanceof SwipeMenuContentAdapte) {
            this.mAdapter = (SwipeMenuContentAdapte) listAdapter;
        }
        this.mContext = context;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.areAllItemsEnabled();
        }
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.getCount();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte == null) {
            return 1;
        }
        return swipeMenuContentAdapte.getViewTypeCount() + 1;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.mAdapter;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.isEmpty();
        }
        if (getCount() == 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.getItem(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.getItemId(i);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            if (!swipeMenuContentAdapte.isCanDelete(i)) {
                return this.mAdapter.getViewTypeCount();
            }
            return this.mAdapter.getItemViewType(i);
        }
        return 0;
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.isEnabled(i);
        }
        return true;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            swipeMenuContentAdapte.registerDataSetObserver(dataSetObserver);
        }
    }

    public void setOnMenuItemClickListener(SwipeMenuListView.OnMenuItemClickListener onMenuItemClickListener) {
        this.onMenuItemClickListener = onMenuItemClickListener;
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            swipeMenuContentAdapte.unregisterDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        if (view2 == null) {
            View view3 = this.mAdapter.getView(i, null, viewGroup);
            if (getItemViewType(i) == this.mAdapter.getViewTypeCount()) {
                return view3;
            }
            SwipeMenu swipeMenu = new SwipeMenu(this.mContext);
            swipeMenu.setViewType(this.mAdapter.getItemViewType(i));
            createMenu(swipeMenu);
            SwipeMenuListView swipeMenuListView = (SwipeMenuListView) viewGroup;
            SwipeMenuView swipeMenuView = new SwipeMenuView(swipeMenu, swipeMenuListView);
            swipeMenuView.setOnSwipeItemClickListener(this);
            SwipeMenuLayout swipeMenuLayout = new SwipeMenuLayout(view3, swipeMenuView, swipeMenuListView.getCloseInterpolator(), swipeMenuListView.getOpenInterpolator());
            swipeMenuLayout.setPosition(i);
            return swipeMenuLayout;
        } else if (getItemViewType(i) == this.mAdapter.getViewTypeCount()) {
            return this.mAdapter.getView(i, view2, viewGroup);
        } else {
            SwipeMenuLayout swipeMenuLayout2 = (SwipeMenuLayout) view2;
            swipeMenuLayout2.closeMenu();
            swipeMenuLayout2.setPosition(i);
            this.mAdapter.getView(i, swipeMenuLayout2.getContentView(), viewGroup);
            return swipeMenuLayout2;
        }
    }

    @Override // com.baidu.searchbox.ui.swipe.SwipeMenuView.OnSwipeItemClickListener
    public void onItemClick(SwipeMenuView swipeMenuView, SwipeMenu swipeMenu, int i) {
        SwipeMenuListView.OnMenuItemClickListener onMenuItemClickListener = this.onMenuItemClickListener;
        if (onMenuItemClickListener != null) {
            onMenuItemClickListener.onMenuItemClick(swipeMenuView.getPosition(), swipeMenu, i);
        }
    }
}
