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
    protected aj GP;
    protected ak GQ;
    protected BdUniqueId GR;
    private al GS;
    private V GT;
    protected Context mContext;

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V a(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.GR = bdUniqueId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.am> */
    /* JADX WARN: Multi-variable type inference failed */
    public View a(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (d(view)) {
            this.GT = (V) a(viewGroup);
            view2 = this.GT.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.GT.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (am) view2.getTag());
    }

    private boolean d(View view) {
        return view == null || view.getTag() == null || this.GT == null || !this.GT.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.GT.getClass());
    }

    public void a(aj ajVar) {
        this.GP = ajVar;
    }

    public aj mG() {
        return this.GP;
    }

    public void a(ak akVar) {
        this.GQ = akVar;
    }

    public ak mH() {
        return this.GQ;
    }

    public BdUniqueId getType() {
        return this.GR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(al alVar) {
        this.GS = alVar;
    }

    public void notifyDataSetChanged() {
        if (this.GS != null) {
            this.GS.notifyDataSetChanged();
        }
    }

    public ai aA(int i) {
        if (this.GS != null) {
            return this.GS.getItem(i);
        }
        return null;
    }
}
