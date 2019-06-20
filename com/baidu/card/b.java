package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public abstract class b<T extends com.baidu.tbadk.core.data.a> implements i<T>, j {
    protected x Vh;
    private com.baidu.tieba.card.ab<T> Vi;
    protected Context mContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View getView();

    public b(Context context) {
        this.mContext = context;
    }

    public void a(x xVar) {
        this.Vh = xVar;
    }

    public void bm(int i) {
    }

    public void bn(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qe() {
    }

    public com.baidu.tieba.card.ab<T> qf() {
        return this.Vi;
    }

    public void b(com.baidu.tieba.card.ab<T> abVar) {
        this.Vi = abVar;
    }

    public void a(int i, a.b bVar) {
        this.Vh.a(i, bVar);
    }

    public void bo(int i) {
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
}
