package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes15.dex */
public abstract class b<T extends AbsThreadDataSupport> implements o<T>, p {
    protected aj aeT;
    private Boolean aeU = false;
    private com.baidu.tieba.card.aa<T> aeV;
    public a aeW;
    protected Context mContext;

    /* loaded from: classes15.dex */
    public interface a {
        void a(AbsThreadDataSupport absThreadDataSupport);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View getView();

    public b(Context context) {
        this.mContext = context;
    }

    public void a(aj ajVar) {
        this.aeT = ajVar;
    }

    public void bk(int i) {
    }

    public void bl(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tv() {
    }

    public com.baidu.tieba.card.aa<T> tw() {
        return this.aeV;
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<T> aaVar) {
        this.aeV = aaVar;
    }

    public void a(int i, a.b bVar) {
        this.aeT.a(i, bVar);
    }

    public void bm(int i) {
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMarginsTop(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public Boolean tx() {
        return this.aeU;
    }

    public void b(Boolean bool) {
        this.aeU = bool;
    }
}
