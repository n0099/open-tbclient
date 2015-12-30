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
    protected v Hr;
    protected w Hs;
    protected BdUniqueId Ht;
    private x Hu;
    private V Hv;
    protected Context mContext;

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V a(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.Ht = bdUniqueId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.x$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View a(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (e(view)) {
            this.Hv = (V) a(viewGroup);
            view2 = this.Hv.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.Hv.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (x.a) view2.getTag());
    }

    private boolean e(View view) {
        return view == null || view.getTag() == null || this.Hv == null || !this.Hv.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.Hv.getClass());
    }

    public void a(v vVar) {
        this.Hr = vVar;
    }

    public v mM() {
        return this.Hr;
    }

    public void a(w wVar) {
        this.Hs = wVar;
    }

    public w mN() {
        return this.Hs;
    }

    public BdUniqueId getType() {
        return this.Ht;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(x xVar) {
        this.Hu = xVar;
    }

    public void notifyDataSetChanged() {
        if (this.Hu != null) {
            this.Hu.notifyDataSetChanged();
        }
    }

    public u au(int i) {
        if (this.Hu != null) {
            return this.Hu.getItem(i);
        }
        return null;
    }
}
