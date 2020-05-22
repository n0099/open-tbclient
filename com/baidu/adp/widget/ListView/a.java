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
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.aa.a;
/* loaded from: classes.dex */
public abstract class a<T, V extends aa.a> {
    protected x TI;
    protected y TJ;
    protected BdUniqueId TK;
    private s<o> TL;
    protected V TM;
    private com.baidu.adp.widget.a.a TO = new com.baidu.adp.widget.a.a();
    protected Context mContext;
    protected BdUniqueId mPageId;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract V b(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.TK = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        this.mContext = context;
        this.TK = bdUniqueId;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.aa$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View getView(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (needCreateNewHolder(view)) {
            this.TM = (V) b(viewGroup);
            view2 = this.TM.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.TM.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (aa.a) view2.getTag());
    }

    private boolean needCreateNewHolder(View view) {
        return view == null || view.getTag() == null || this.TM == null || !this.TM.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.TM.getClass());
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

    public BdUniqueId oO() {
        return null;
    }

    public BdUniqueId oP() {
        return null;
    }

    public BdUniqueId oQ() {
        return null;
    }

    public BdUniqueId oR() {
        return null;
    }

    public void a(x xVar) {
        this.TI = xVar;
    }

    public x oS() {
        return this.TI;
    }

    public y oT() {
        return this.TJ;
    }

    public BdUniqueId getType() {
        return this.TK;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(s<o> sVar) {
        this.TL = sVar;
    }

    public void notifyDataSetChanged() {
        if (this.TL != null) {
            this.TL.notifyDataSetChanged();
        }
    }

    public o getItem(int i) {
        if (this.TL != null) {
            return this.TL.getItem(i);
        }
        return null;
    }

    public int getPositionByType(int i) {
        if (this.TL == null || this.TK == null) {
            return -1;
        }
        return this.TL.getPositionByType(i, this.TK.getId());
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
        return this.TO.h(i, i2, i3);
    }

    public boolean au(int i) {
        return this.TO.au(i);
    }
}
