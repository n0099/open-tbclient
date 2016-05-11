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
    protected w yb;
    protected x yc;
    protected BdUniqueId yd;
    private y ye;
    private V yf;

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V b(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.yd = bdUniqueId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.y$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View a(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (q(view)) {
            this.yf = (V) b(viewGroup);
            view2 = this.yf.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.yf.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (y.a) view2.getTag());
    }

    private boolean q(View view) {
        return view == null || view.getTag() == null || this.yf == null || !this.yf.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.yf.getClass());
    }

    public void a(w wVar) {
        this.yb = wVar;
    }

    public w jg() {
        return this.yb;
    }

    public void a(x xVar) {
        this.yc = xVar;
    }

    public x jh() {
        return this.yc;
    }

    public BdUniqueId getType() {
        return this.yd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(y yVar) {
        this.ye = yVar;
    }

    public void notifyDataSetChanged() {
        if (this.ye != null) {
            this.ye.notifyDataSetChanged();
        }
    }

    public v at(int i) {
        if (this.ye != null) {
            return this.ye.getItem(i);
        }
        return null;
    }
}
