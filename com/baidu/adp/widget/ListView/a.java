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
    protected v Hb;
    protected w Hc;
    protected BdUniqueId Hd;
    private x He;
    private V Hf;
    protected Context mContext;

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V a(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.Hd = bdUniqueId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.x$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View a(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (e(view)) {
            this.Hf = (V) a(viewGroup);
            view2 = this.Hf.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.Hf.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (x.a) view2.getTag());
    }

    private boolean e(View view) {
        return view == null || view.getTag() == null || this.Hf == null || !this.Hf.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.Hf.getClass());
    }

    public void a(v vVar) {
        this.Hb = vVar;
    }

    public v no() {
        return this.Hb;
    }

    public void a(w wVar) {
        this.Hc = wVar;
    }

    public w np() {
        return this.Hc;
    }

    public BdUniqueId getType() {
        return this.Hd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(x xVar) {
        this.He = xVar;
    }

    public void notifyDataSetChanged() {
        if (this.He != null) {
            this.He.notifyDataSetChanged();
        }
    }

    public u aB(int i) {
        if (this.He != null) {
            return this.He.getItem(i);
        }
        return null;
    }
}
