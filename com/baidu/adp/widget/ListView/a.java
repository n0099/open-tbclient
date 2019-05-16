package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.v.a;
/* loaded from: classes.dex */
public abstract class a<T, V extends v.a> {
    private q<m> mAdapter;
    protected s mAdapterItemClickListener;
    protected t mAdapterItemLongClickListener;
    protected Context mContext;
    private com.baidu.adp.widget.a.a mImagePreloadSizeData = new com.baidu.adp.widget.a.a();
    protected BdUniqueId mPageId;
    protected BdUniqueId mType;
    protected V viewholder;

    protected abstract V onCreateViewHolder(ViewGroup viewGroup);

    protected abstract View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.mType = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        this.mContext = context;
        this.mType = bdUniqueId;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.v$a> */
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
        return onFillViewHolder(i, view2, viewGroup, t, (v.a) view2.getTag());
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

    public void setOnAdapterItemClickListener(s sVar) {
        this.mAdapterItemClickListener = sVar;
    }

    public s getOnAdapterItemClickListener() {
        return this.mAdapterItemClickListener;
    }

    public void setOnAdapterItemLongClickListener(t tVar) {
        this.mAdapterItemLongClickListener = tVar;
    }

    public t getOnAdapterItemLongClickListener() {
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
    public void setAdapter(q<m> qVar) {
        this.mAdapter = qVar;
    }

    public void notifyDataSetChanged() {
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public m getItem(int i) {
        if (this.mAdapter != null) {
            return this.mAdapter.getItem(i);
        }
        return null;
    }

    public int getPositionByType(int i) {
        if (this.mAdapter == null || this.mType == null) {
            return -1;
        }
        return this.mAdapter.s(i, this.mType.getId());
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
        if (viewGroup instanceof RecyclerView) {
            return new RecyclerView.LayoutParams(-1, -2);
        }
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public boolean setPreloadSize(int i, int i2, int i3) {
        return this.mImagePreloadSizeData.setPreloadSize(i, i2, i3);
    }

    public com.baidu.adp.widget.a.c getPreloadSize(int i) {
        return this.mImagePreloadSizeData.getPreloadSize(i);
    }

    public boolean isPreloadSizeReady(int i) {
        return this.mImagePreloadSizeData.isPreloadSizeReady(i);
    }
}
