package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.y;
import com.baidu.adp.widget.ListView.y.a;
/* loaded from: classes.dex */
public abstract class a<T, V extends y.a> {
    private y mAdapter;
    protected w mAdapterItemClickListener;
    protected x mAdapterItemLongClickListener;
    protected Context mContext;
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

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.y$a> */
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
        return onFillViewHolder(i, view2, viewGroup, t, (y.a) view2.getTag());
    }

    private boolean needCreateNewHolder(View view) {
        return view == null || view.getTag() == null || this.viewholder == null || !this.viewholder.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.viewholder.getClass());
    }

    public void setOnAdapterItemClickListener(w wVar) {
        this.mAdapterItemClickListener = wVar;
    }

    public w getOnAdapterItemClickListener() {
        return this.mAdapterItemClickListener;
    }

    public void setOnAdapterItemLongClickListener(x xVar) {
        this.mAdapterItemLongClickListener = xVar;
    }

    public x getOnAdapterItemLongClickListener() {
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
    public void setAdapter(y yVar) {
        this.mAdapter = yVar;
    }

    public void notifyDataSetChanged() {
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public v getItem(int i) {
        if (this.mAdapter != null) {
            return this.mAdapter.getItem(i);
        }
        return null;
    }

    public int getPositionByType(int i) {
        if (this.mAdapter == null || this.mType == null) {
            return -1;
        }
        return this.mAdapter.t(i, this.mType.getId());
    }

    public int getCount() {
        if (this.mAdapter != null) {
            return this.mAdapter.getCount();
        }
        return 0;
    }
}
