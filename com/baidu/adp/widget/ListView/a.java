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
    protected v HJ;
    protected w HK;
    protected BdUniqueId HL;
    private x HM;
    private V HN;
    protected Context mContext;

    protected abstract View a(int i, View view, ViewGroup viewGroup, T t, V v);

    protected abstract V b(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.HL = bdUniqueId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.adp.widget.ListView.a<T, V extends com.baidu.adp.widget.ListView.x$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public View a(int i, View view, ViewGroup viewGroup, T t) {
        View view2;
        if (q(view)) {
            this.HN = (V) b(viewGroup);
            view2 = this.HN.getView();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.HN.getClass().getName());
            }
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, t, (x.a) view2.getTag());
    }

    private boolean q(View view) {
        return view == null || view.getTag() == null || this.HN == null || !this.HN.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.HN.getClass());
    }

    public void a(v vVar) {
        this.HJ = vVar;
    }

    public v mS() {
        return this.HJ;
    }

    public void a(w wVar) {
        this.HK = wVar;
    }

    public w mT() {
        return this.HK;
    }

    public BdUniqueId getType() {
        return this.HL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(x xVar) {
        this.HM = xVar;
    }

    public void notifyDataSetChanged() {
        if (this.HM != null) {
            this.HM.notifyDataSetChanged();
        }
    }

    public u aF(int i) {
        if (this.HM != null) {
            return this.HM.getItem(i);
        }
        return null;
    }
}
