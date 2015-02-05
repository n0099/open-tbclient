package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class a<T> {
    protected Context mContext;
    protected an vR;
    protected ao vS;
    protected BdUniqueId vT;
    private ap vU;

    protected abstract View a(ViewGroup viewGroup);

    protected abstract View b(int i, View view, ViewGroup viewGroup, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.vT = bdUniqueId;
    }

    public View a(int i, View view, ViewGroup viewGroup, T t) {
        if (d(view)) {
            view = a(viewGroup);
            BdLog.i("convertView is creating");
        }
        if (view == null) {
            BdLog.e("convertView still is null");
            return null;
        }
        return b(i, view, viewGroup, t);
    }

    public void a(an anVar) {
        this.vR = anVar;
    }

    public an jj() {
        return this.vR;
    }

    public void a(ao aoVar) {
        this.vS = aoVar;
    }

    public ao jk() {
        return this.vS;
    }

    public BdUniqueId jl() {
        return this.vT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ap apVar) {
        this.vU = apVar;
    }

    public void notifyDataSetChanged() {
        if (this.vU != null) {
            this.vU.notifyDataSetChanged();
        }
    }

    public am aD(int i) {
        if (this.vU != null) {
            return this.vU.getItem(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(View view) {
        return view == null || view.getTag() == null;
    }
}
