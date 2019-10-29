package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public abstract class b<T extends com.baidu.tbadk.core.data.a> implements i<T>, j {
    protected x Fp;
    private com.baidu.tieba.card.ab<T> Fq;
    protected Context mContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View getView();

    public b(Context context) {
        this.mContext = context;
    }

    public void a(x xVar) {
        this.Fp = xVar;
    }

    public void aB(int i) {
    }

    public void aC(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lG() {
    }

    public com.baidu.tieba.card.ab<T> lH() {
        return this.Fq;
    }

    public void a(com.baidu.tieba.card.ab<T> abVar) {
        this.Fq = abVar;
    }

    public void a(int i, a.b bVar) {
        this.Fp.a(i, bVar);
    }

    public void aD(int i) {
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
