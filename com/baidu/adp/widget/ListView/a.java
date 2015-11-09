package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.x.a;
/* loaded from: classes.dex */
public abstract class a<T, V extends x.a> {
    protected v GJ;
    protected w GK;
    protected BdUniqueId GL;
    private x GM;
    private V GN;
    protected Context mContext;

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V a(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.GL = bdUniqueId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.x$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View a(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (e(view)) {
            this.GN = (V) a(viewGroup);
            view2 = this.GN.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.GN.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (x.a) view2.getTag());
    }

    private boolean e(View view) {
        return view == null || view.getTag() == null || this.GN == null || !this.GN.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.GN.getClass());
    }

    public void a(v vVar) {
        this.GJ = vVar;
    }

    public v ni() {
        return this.GJ;
    }

    public void a(w wVar) {
        this.GK = wVar;
    }

    public w nj() {
        return this.GK;
    }

    public BdUniqueId getType() {
        return this.GL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(x xVar) {
        this.GM = xVar;
    }

    public void notifyDataSetChanged() {
        if (this.GM != null) {
            this.GM.notifyDataSetChanged();
        }
    }

    public u aA(int i) {
        if (this.GM != null) {
            return this.GM.getItem(i);
        }
        return null;
    }
}
