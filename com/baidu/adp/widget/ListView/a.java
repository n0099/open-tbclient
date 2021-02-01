package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
/* loaded from: classes.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> {
    protected w Wk;
    protected x Wl;
    protected BdUniqueId Wm;
    private r<n> Wn;
    protected V Wo;
    private com.baidu.adp.widget.a.a Wp = new com.baidu.adp.widget.a.a();
    protected Context mContext;
    protected BdUniqueId mPageId;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract V e(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.Wm = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        this.mContext = context;
        this.Wm = bdUniqueId;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public View getView(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (needCreateNewHolder(view)) {
            this.Wo = (V) a(viewGroup, t);
            view2 = this.Wo.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.Wo.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (TypeAdapter.ViewHolder) view2.getTag());
    }

    private boolean needCreateNewHolder(View view) {
        return view == null || view.getTag() == null || this.Wo == null || !this.Wo.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.Wo.getClass());
    }

    public V a(ViewGroup viewGroup, T t) {
        return e(viewGroup);
    }

    public V b(ViewGroup viewGroup, T t) {
        return null;
    }

    public V c(ViewGroup viewGroup, T t) {
        return null;
    }

    public V d(ViewGroup viewGroup, T t) {
        return null;
    }

    public V e(ViewGroup viewGroup, T t) {
        return null;
    }

    public View b(int i, View view, ViewGroup viewGroup, T t, V v) {
        return a(i, view, viewGroup, t, v);
    }

    public View c(int i, View view, ViewGroup viewGroup, T t, V v) {
        return a(i, view, viewGroup, t, v);
    }

    public View d(int i, View view, ViewGroup viewGroup, T t, V v) {
        return a(i, view, viewGroup, t, v);
    }

    public View e(int i, View view, ViewGroup viewGroup, T t, V v) {
        return a(i, view, viewGroup, t, v);
    }

    public void a(int i, ViewGroup viewGroup, V v, T t) {
        a(i, v.getView(), viewGroup, t, v);
    }

    public BdUniqueId ql() {
        return null;
    }

    public BdUniqueId qm() {
        return null;
    }

    public BdUniqueId qn() {
        return null;
    }

    public BdUniqueId qo() {
        return null;
    }

    public void a(w wVar) {
        this.Wk = wVar;
    }

    public w qp() {
        return this.Wk;
    }

    public void a(x xVar) {
        this.Wl = xVar;
    }

    public x qq() {
        return this.Wl;
    }

    public BdUniqueId getType() {
        return this.Wm;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(r<n> rVar) {
        this.Wn = rVar;
    }

    public void notifyDataSetChanged() {
        if (this.Wn != null) {
            this.Wn.notifyDataSetChanged();
        }
    }

    public n getItem(int i) {
        if (this.Wn != null) {
            return this.Wn.getItem(i);
        }
        return null;
    }

    public int getPositionByType(int i) {
        if (this.Wn == null || this.Wm == null) {
            return -1;
        }
        return this.Wn.getPositionByType(i, this.Wm.getId());
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
        return this.Wp.h(i, i2, i3);
    }

    public boolean aO(int i) {
        return this.Wp.aO(i);
    }
}
