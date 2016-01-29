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
    protected v HD;
    protected w HE;
    protected BdUniqueId HF;
    private x HG;
    private V HH;
    protected Context mContext;

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V b(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.HF = bdUniqueId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.x$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View a(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (q(view)) {
            this.HH = (V) b(viewGroup);
            view2 = this.HH.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.HH.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (x.a) view2.getTag());
    }

    private boolean q(View view) {
        return view == null || view.getTag() == null || this.HH == null || !this.HH.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.HH.getClass());
    }

    public void a(v vVar) {
        this.HD = vVar;
    }

    public v na() {
        return this.HD;
    }

    public void a(w wVar) {
        this.HE = wVar;
    }

    public w nb() {
        return this.HE;
    }

    public BdUniqueId getType() {
        return this.HF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(x xVar) {
        this.HG = xVar;
    }

    public void notifyDataSetChanged() {
        if (this.HG != null) {
            this.HG.notifyDataSetChanged();
        }
    }

    public u aG(int i) {
        if (this.HG != null) {
            return this.HG.getItem(i);
        }
        return null;
    }
}
