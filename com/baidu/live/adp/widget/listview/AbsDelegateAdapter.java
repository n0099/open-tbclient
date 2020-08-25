package com.baidu.live.adp.widget.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.adp.widget.listview.TypeAdapter.ViewHolder;
/* loaded from: classes7.dex */
public abstract class AbsDelegateAdapter<T, V extends TypeAdapter.ViewHolder> {
    private ITypeListAdapter<IAdapterData> mAdapter;
    protected OnAdapterItemClickListener mAdapterItemClickListener;
    protected OnAdapterItemLongClickListener mAdapterItemLongClickListener;
    protected Context mContext;
    protected BdUniqueId mPageId;
    protected BdUniqueId mType;
    protected V viewholder;

    protected abstract V onCreateViewHolder(ViewGroup viewGroup);

    protected abstract View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbsDelegateAdapter(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.mType = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbsDelegateAdapter(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        this.mContext = context;
        this.mType = bdUniqueId;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.live.adp.widget.listview.AbsDelegateAdapter<T, V extends com.baidu.live.adp.widget.listview.TypeAdapter$ViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public View getView(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (needCreateNewHolder(view)) {
            this.viewholder = (V) onCreateViewHolder(viewGroup);
            view2 = this.viewholder.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.viewholder.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return onFillViewHolder(i, view2, viewGroup, t, (TypeAdapter.ViewHolder) view2.getTag());
    }

    private boolean needCreateNewHolder(View view) {
        return view == null || view.getTag() == null || this.viewholder == null || !this.viewholder.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.viewholder.getClass());
    }

    public V onCreateViewHolder(ViewGroup viewGroup, T t) {
        return onCreateViewHolder(viewGroup);
    }

    public void onFillViewHolder(int i, ViewGroup viewGroup, V v, T t) {
        onFillViewHolder(i, v.getView(), viewGroup, t, v);
    }

    public void setOnAdapterItemClickListener(OnAdapterItemClickListener onAdapterItemClickListener) {
        this.mAdapterItemClickListener = onAdapterItemClickListener;
    }

    public OnAdapterItemClickListener getOnAdapterItemClickListener() {
        return this.mAdapterItemClickListener;
    }

    public void setOnAdapterItemLongClickListener(OnAdapterItemLongClickListener onAdapterItemLongClickListener) {
        this.mAdapterItemLongClickListener = onAdapterItemLongClickListener;
    }

    public OnAdapterItemLongClickListener getOnAdapterItemLongClickListener() {
        return this.mAdapterItemLongClickListener;
    }

    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAdapter(ITypeListAdapter<IAdapterData> iTypeListAdapter) {
        this.mAdapter = iTypeListAdapter;
    }

    public void notifyDataSetChanged() {
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public IAdapterData getItem(int i) {
        if (this.mAdapter != null) {
            return this.mAdapter.getItem(i);
        }
        return null;
    }

    public int getPositionByType(int i) {
        if (this.mAdapter == null || this.mType == null) {
            return -1;
        }
        return this.mAdapter.getPositionByType(i, this.mType.getId());
    }

    public int getCount() {
        if (this.mAdapter != null) {
            return this.mAdapter.getCount();
        }
        return 0;
    }

    public ViewGroup.LayoutParams generateLayoutParamsByParent(ViewGroup viewGroup) {
        if (viewGroup instanceof ListView) {
            return new AbsListView.LayoutParams(-1, -2);
        }
        return new ViewGroup.LayoutParams(-1, -2);
    }
}
