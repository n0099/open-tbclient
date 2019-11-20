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
    protected Context mContext;
    protected BdUniqueId mPageId;
    protected s xj;
    protected t xk;
    protected BdUniqueId xl;
    private q<m> xm;
    protected V xn;
    private com.baidu.adp.widget.a.a xo = new com.baidu.adp.widget.a.a();

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V b(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.xl = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        this.mContext = context;
        this.xl = bdUniqueId;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.v$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View getView(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (needCreateNewHolder(view)) {
            this.xn = (V) b(viewGroup);
            view2 = this.xn.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.xn.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (v.a) view2.getTag());
    }

    private boolean needCreateNewHolder(View view) {
        return view == null || view.getTag() == null || this.xn == null || !this.xn.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.xn.getClass());
    }

    public V a(ViewGroup viewGroup, T t) {
        return b(viewGroup);
    }

    public void a(int i, ViewGroup viewGroup, V v, T t) {
        a(i, v.getView(), viewGroup, t, v);
    }

    public void a(s sVar) {
        this.xj = sVar;
    }

    public s jE() {
        return this.xj;
    }

    public t jF() {
        return this.xk;
    }

    public BdUniqueId getType() {
        return this.xl;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q<m> qVar) {
        this.xm = qVar;
    }

    public void notifyDataSetChanged() {
        if (this.xm != null) {
            this.xm.notifyDataSetChanged();
        }
    }

    public m getItem(int i) {
        if (this.xm != null) {
            return this.xm.getItem(i);
        }
        return null;
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

    public boolean g(int i, int i2, int i3) {
        return this.xo.g(i, i2, i3);
    }

    public boolean ab(int i) {
        return this.xo.ab(i);
    }
}
