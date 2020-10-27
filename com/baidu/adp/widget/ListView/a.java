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
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.af.a;
/* loaded from: classes.dex */
public abstract class a<T, V extends af.a> {
    protected ab Vu;
    protected ac Vv;
    protected BdUniqueId Vw;
    private u<q> Vx;
    protected V Vy;
    private com.baidu.adp.widget.a.a Vz = new com.baidu.adp.widget.a.a();
    protected Context mContext;
    protected BdUniqueId mPageId;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract V c(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.Vw = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        this.mContext = context;
        this.Vw = bdUniqueId;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.af$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View getView(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (needCreateNewHolder(view)) {
            this.Vy = (V) c(viewGroup);
            view2 = this.Vy.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.Vy.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (af.a) view2.getTag());
    }

    private boolean needCreateNewHolder(View view) {
        return view == null || view.getTag() == null || this.Vy == null || !this.Vy.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.Vy.getClass());
    }

    public V a(ViewGroup viewGroup, T t) {
        return c(viewGroup);
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

    public V g(ViewGroup viewGroup) {
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

    public BdUniqueId qJ() {
        return null;
    }

    public BdUniqueId qK() {
        return null;
    }

    public BdUniqueId qL() {
        return null;
    }

    public BdUniqueId qM() {
        return null;
    }

    public void a(ab abVar) {
        this.Vu = abVar;
    }

    public ab qN() {
        return this.Vu;
    }

    public void a(ac acVar) {
        this.Vv = acVar;
    }

    public ac qO() {
        return this.Vv;
    }

    public BdUniqueId getType() {
        return this.Vw;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(u<q> uVar) {
        this.Vx = uVar;
    }

    public void notifyDataSetChanged() {
        if (this.Vx != null) {
            this.Vx.notifyDataSetChanged();
        }
    }

    public q getItem(int i) {
        if (this.Vx != null) {
            return this.Vx.getItem(i);
        }
        return null;
    }

    public int getPositionByType(int i) {
        if (this.Vx == null || this.Vw == null) {
            return -1;
        }
        return this.Vx.getPositionByType(i, this.Vw.getId());
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
        return this.Vz.h(i, i2, i3);
    }

    public boolean aI(int i) {
        return this.Vz.aI(i);
    }
}
