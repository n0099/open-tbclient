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
    protected w yE;
    protected x yF;
    protected BdUniqueId yG;
    private y yH;
    protected V yI;

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V a(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.yG = bdUniqueId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.y$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View a(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (q(view)) {
            this.yI = (V) a(viewGroup);
            view2 = this.yI.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.yI.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (y.a) view2.getTag());
    }

    private boolean q(View view) {
        return view == null || view.getTag() == null || this.yI == null || !this.yI.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.yI.getClass());
    }

    public void a(w wVar) {
        this.yE = wVar;
    }

    public w ji() {
        return this.yE;
    }

    public void a(x xVar) {
        this.yF = xVar;
    }

    public x jj() {
        return this.yF;
    }

    public BdUniqueId getType() {
        return this.yG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(y yVar) {
        this.yH = yVar;
    }

    public void notifyDataSetChanged() {
        if (this.yH != null) {
            this.yH.notifyDataSetChanged();
        }
    }

    public v aw(int i) {
        if (this.yH != null) {
            return this.yH.getItem(i);
        }
        return null;
    }
}
