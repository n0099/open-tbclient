package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class a<T> {
    protected Context mContext;
    protected am tF;
    protected an tG;
    protected BdUniqueId tH;
    private ao tI;

    protected abstract View a(ViewGroup viewGroup);

    protected abstract View b(int i, View view, ViewGroup viewGroup, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.tH = bdUniqueId;
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

    public void a(am amVar) {
        this.tF = amVar;
    }

    public am hs() {
        return this.tF;
    }

    public void a(an anVar) {
        this.tG = anVar;
    }

    public an ht() {
        return this.tG;
    }

    public BdUniqueId hu() {
        return this.tH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ao aoVar) {
        this.tI = aoVar;
    }

    public void notifyDataSetChanged() {
        if (this.tI != null) {
            this.tI.notifyDataSetChanged();
        }
    }

    public al ai(int i) {
        if (this.tI != null) {
            return this.tI.getItem(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(View view) {
        return view == null || view.getTag() == null;
    }
}
