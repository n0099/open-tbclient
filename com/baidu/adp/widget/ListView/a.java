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
    protected aj GR;
    protected ak GS;
    protected BdUniqueId GT;
    private al GU;
    private V GV;
    protected Context mContext;

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V a(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.GT = bdUniqueId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.am> */
    /* JADX WARN: Multi-variable type inference failed */
    public View a(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (d(view)) {
            this.GV = (V) a(viewGroup);
            view2 = this.GV.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.GV.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (am) view2.getTag());
    }

    private boolean d(View view) {
        return view == null || view.getTag() == null || this.GV == null || !this.GV.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.GV.getClass());
    }

    public void a(aj ajVar) {
        this.GR = ajVar;
    }

    public aj mG() {
        return this.GR;
    }

    public void a(ak akVar) {
        this.GS = akVar;
    }

    public ak mH() {
        return this.GS;
    }

    public BdUniqueId getType() {
        return this.GT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(al alVar) {
        this.GU = alVar;
    }

    public void notifyDataSetChanged() {
        if (this.GU != null) {
            this.GU.notifyDataSetChanged();
        }
    }

    public ai aA(int i) {
        if (this.GU != null) {
            return this.GU.getItem(i);
        }
        return null;
    }
}
