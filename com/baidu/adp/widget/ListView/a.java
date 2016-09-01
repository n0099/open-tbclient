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
    protected w AT;
    protected x AU;
    protected BdUniqueId AV;
    private y AW;
    protected V AX;
    protected Context mContext;

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V a(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.AV = bdUniqueId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.y$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View a(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (q(view)) {
            this.AX = (V) a(viewGroup);
            view2 = this.AX.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.AX.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (y.a) view2.getTag());
    }

    private boolean q(View view) {
        return view == null || view.getTag() == null || this.AX == null || !this.AX.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.AX.getClass());
    }

    public void a(w wVar) {
        this.AT = wVar;
    }

    public w kd() {
        return this.AT;
    }

    public void a(x xVar) {
        this.AU = xVar;
    }

    public x ke() {
        return this.AU;
    }

    public BdUniqueId getType() {
        return this.AV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(y yVar) {
        this.AW = yVar;
    }

    public void notifyDataSetChanged() {
        if (this.AW != null) {
            this.AW.notifyDataSetChanged();
        }
    }

    public v aJ(int i) {
        if (this.AW != null) {
            return this.AW.getItem(i);
        }
        return null;
    }
}
