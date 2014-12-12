package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class a<T> {
    protected Context mContext;
    protected an vO;
    protected ao vP;
    protected BdUniqueId vQ;
    private ap vR;

    protected abstract View a(ViewGroup viewGroup);

    protected abstract View b(int i, View view, ViewGroup viewGroup, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.vQ = bdUniqueId;
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
        this.vO = anVar;
    }

    public an jp() {
        return this.vO;
    }

    public void a(ao aoVar) {
        this.vP = aoVar;
    }

    public ao jq() {
        return this.vP;
    }

    public BdUniqueId jr() {
        return this.vQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ap apVar) {
        this.vR = apVar;
    }

    public void notifyDataSetChanged() {
        if (this.vR != null) {
            this.vR.notifyDataSetChanged();
        }
    }

    public am ay(int i) {
        if (this.vR != null) {
            return this.vR.getItem(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(View view) {
        return view == null || view.getTag() == null;
    }
}
