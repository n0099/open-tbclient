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
    protected w AR;
    protected x AS;
    protected BdUniqueId AT;
    private y AU;
    protected V AV;
    protected Context mContext;

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V a(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.AT = bdUniqueId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.y$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View a(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (q(view)) {
            this.AV = (V) a(viewGroup);
            view2 = this.AV.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.AV.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (y.a) view2.getTag());
    }

    private boolean q(View view) {
        return view == null || view.getTag() == null || this.AV == null || !this.AV.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.AV.getClass());
    }

    public void a(w wVar) {
        this.AR = wVar;
    }

    public w kd() {
        return this.AR;
    }

    public void a(x xVar) {
        this.AS = xVar;
    }

    public x ke() {
        return this.AS;
    }

    public BdUniqueId getType() {
        return this.AT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(y yVar) {
        this.AU = yVar;
    }

    public v aK(int i) {
        if (this.AU != null) {
            return this.AU.getItem(i);
        }
        return null;
    }
}
