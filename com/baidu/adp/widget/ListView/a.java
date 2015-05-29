package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.am;
/* loaded from: classes.dex */
public abstract class a<T, V extends am> {
    protected aj GG;
    protected ak GH;
    protected BdUniqueId GI;
    private al GJ;
    private V GK;
    protected Context mContext;

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V a(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.GI = bdUniqueId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.am> */
    /* JADX WARN: Multi-variable type inference failed */
    public View a(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (d(view)) {
            this.GK = (V) a(viewGroup);
            view2 = this.GK.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.GK.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (am) view2.getTag());
    }

    private boolean d(View view) {
        return view == null || view.getTag() == null || this.GK == null || !this.GK.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.GK.getClass());
    }

    public void a(aj ajVar) {
        this.GG = ajVar;
    }

    public aj mZ() {
        return this.GG;
    }

    public void a(ak akVar) {
        this.GH = akVar;
    }

    public ak na() {
        return this.GH;
    }

    public BdUniqueId getType() {
        return this.GI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(al alVar) {
        this.GJ = alVar;
    }

    public void notifyDataSetChanged() {
        if (this.GJ != null) {
            this.GJ.notifyDataSetChanged();
        }
    }

    public ai ay(int i) {
        if (this.GJ != null) {
            return this.GJ.getItem(i);
        }
        return null;
    }
}
