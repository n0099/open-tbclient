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
import com.baidu.adp.widget.ListView.y;
import com.baidu.adp.widget.ListView.y.a;
/* loaded from: classes.dex */
public abstract class a<T, V extends y.a> {
    protected v Tt;
    protected w Tu;
    protected BdUniqueId Tv;
    private q<m> Tw;
    protected V Tx;
    private com.baidu.adp.widget.a.a Ty = new com.baidu.adp.widget.a.a();
    protected Context mContext;
    protected BdUniqueId mPageId;

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V b(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.Tv = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        this.mContext = context;
        this.Tv = bdUniqueId;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.y$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View getView(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (needCreateNewHolder(view)) {
            this.Tx = (V) b(viewGroup);
            view2 = this.Tx.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.Tx.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (y.a) view2.getTag());
    }

    private boolean needCreateNewHolder(View view) {
        return view == null || view.getTag() == null || this.Tx == null || !this.Tx.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.Tx.getClass());
    }

    public V a(ViewGroup viewGroup, T t) {
        return b(viewGroup);
    }

    public void a(int i, ViewGroup viewGroup, V v, T t) {
        a(i, v.getView(), viewGroup, t, v);
    }

    public void a(v vVar) {
        this.Tt = vVar;
    }

    public v oN() {
        return this.Tt;
    }

    public w oO() {
        return this.Tu;
    }

    public BdUniqueId getType() {
        return this.Tv;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q<m> qVar) {
        this.Tw = qVar;
    }

    public void notifyDataSetChanged() {
        if (this.Tw != null) {
            this.Tw.notifyDataSetChanged();
        }
    }

    public m getItem(int i) {
        if (this.Tw != null) {
            return this.Tw.getItem(i);
        }
        return null;
    }

    public int getPositionByType(int i) {
        if (this.Tw == null || this.Tv == null) {
            return -1;
        }
        return this.Tw.getPositionByType(i, this.Tv.getId());
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

    public boolean h(int i, int i2, int i3) {
        return this.Ty.h(i, i2, i3);
    }

    public boolean at(int i) {
        return this.Ty.at(i);
    }
}
