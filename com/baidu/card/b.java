package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes8.dex */
public abstract class b<T extends AbsThreadDataSupport> implements n<T>, o {
    protected ae adr;
    private Boolean ads = false;
    private com.baidu.tieba.card.aa<T> adt;
    public a adu;
    protected Context mContext;

    /* loaded from: classes8.dex */
    public interface a {
        void a(AbsThreadDataSupport absThreadDataSupport);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View getView();

    public b(Context context) {
        this.mContext = context;
    }

    public void a(ae aeVar) {
        this.adr = aeVar;
    }

    public void aX(int i) {
    }

    public void aY(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rr() {
    }

    public com.baidu.tieba.card.aa<T> rs() {
        return this.adt;
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<T> aaVar) {
        this.adt = aaVar;
    }

    public void a(int i, a.b bVar) {
        this.adr.a(i, bVar);
    }

    public void aZ(int i) {
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

    public Boolean rt() {
        return this.ads;
    }

    public void b(Boolean bool) {
        this.ads = bool;
    }
}
