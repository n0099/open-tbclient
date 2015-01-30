package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class a<T> {
    protected Context mContext;
    protected an vU;
    protected ao vV;
    protected BdUniqueId vW;
    private ap vX;

    protected abstract View a(ViewGroup viewGroup);

    protected abstract View b(int i, View view, ViewGroup viewGroup, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.vW = bdUniqueId;
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
        this.vU = anVar;
    }

    public an jq() {
        return this.vU;
    }

    public void a(ao aoVar) {
        this.vV = aoVar;
    }

    public ao jr() {
        return this.vV;
    }

    public BdUniqueId js() {
        return this.vW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ap apVar) {
        this.vX = apVar;
    }

    public void notifyDataSetChanged() {
        if (this.vX != null) {
            this.vX.notifyDataSetChanged();
        }
    }

    public am aD(int i) {
        if (this.vX != null) {
            return this.vX.getItem(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(View view) {
        return view == null || view.getTag() == null;
    }
}
