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
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.ad.a;
/* loaded from: classes.dex */
public abstract class a<T, V extends ad.a> {
    protected z Uf;
    protected aa Ug;
    protected BdUniqueId Uh;
    private u<q> Ui;
    protected V Uj;
    private com.baidu.adp.widget.a.a Uk = new com.baidu.adp.widget.a.a();
    protected Context mContext;
    protected BdUniqueId mPageId;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract V b(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.Uh = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        this.mContext = context;
        this.Uh = bdUniqueId;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.ad$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View getView(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (needCreateNewHolder(view)) {
            this.Uj = (V) b(viewGroup);
            view2 = this.Uj.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.Uj.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (ad.a) view2.getTag());
    }

    private boolean needCreateNewHolder(View view) {
        return view == null || view.getTag() == null || this.Uj == null || !this.Uj.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.Uj.getClass());
    }

    public V a(ViewGroup viewGroup, T t) {
        return b(viewGroup);
    }

    public V c(ViewGroup viewGroup) {
        return null;
    }

    public V d(ViewGroup viewGroup) {
        return null;
    }

    public V e(ViewGroup viewGroup) {
        return null;
    }

    public V f(ViewGroup viewGroup) {
        return null;
    }

    public View b(int i, View view, ViewGroup viewGroup, T t, V v) {
        return null;
    }

    public View c(int i, View view, ViewGroup viewGroup, T t, V v) {
        return null;
    }

    public View d(int i, View view, ViewGroup viewGroup, T t, V v) {
        return null;
    }

    public View e(int i, View view, ViewGroup viewGroup, T t, V v) {
        return null;
    }

    public void a(int i, ViewGroup viewGroup, V v, T t) {
        a(i, v.getView(), viewGroup, t, v);
    }

    public BdUniqueId pf() {
        return null;
    }

    public BdUniqueId pg() {
        return null;
    }

    public BdUniqueId ph() {
        return null;
    }

    public BdUniqueId pi() {
        return null;
    }

    public void a(z zVar) {
        this.Uf = zVar;
    }

    public z pj() {
        return this.Uf;
    }

    public void a(aa aaVar) {
        this.Ug = aaVar;
    }

    public aa pk() {
        return this.Ug;
    }

    public BdUniqueId getType() {
        return this.Uh;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(u<q> uVar) {
        this.Ui = uVar;
    }

    public void notifyDataSetChanged() {
        if (this.Ui != null) {
            this.Ui.notifyDataSetChanged();
        }
    }

    public q getItem(int i) {
        if (this.Ui != null) {
            return this.Ui.getItem(i);
        }
        return null;
    }

    public int getPositionByType(int i) {
        if (this.Ui == null || this.Uh == null) {
            return -1;
        }
        return this.Ui.getPositionByType(i, this.Uh.getId());
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
        return this.Uk.h(i, i2, i3);
    }

    public boolean aC(int i) {
        return this.Uk.aC(i);
    }
}
