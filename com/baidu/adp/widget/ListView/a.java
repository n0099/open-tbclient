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
    protected Context mContext;
    protected w yd;
    protected x ye;
    protected BdUniqueId yf;
    private y yg;
    protected V yh;

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V a(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.yf = bdUniqueId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.y$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View a(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (q(view)) {
            this.yh = (V) a(viewGroup);
            view2 = this.yh.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.yh.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (y.a) view2.getTag());
    }

    private boolean q(View view) {
        return view == null || view.getTag() == null || this.yh == null || !this.yh.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.yh.getClass());
    }

    public void a(w wVar) {
        this.yd = wVar;
    }

    public w jj() {
        return this.yd;
    }

    public void a(x xVar) {
        this.ye = xVar;
    }

    public x jk() {
        return this.ye;
    }

    public BdUniqueId getType() {
        return this.yf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(y yVar) {
        this.yg = yVar;
    }

    public void notifyDataSetChanged() {
        if (this.yg != null) {
            this.yg.notifyDataSetChanged();
        }
    }

    public v at(int i) {
        if (this.yg != null) {
            return this.yg.getItem(i);
        }
        return null;
    }
}
