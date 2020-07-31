package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes15.dex */
public abstract class b<T extends AbsThreadDataSupport> implements n<T>, o {
    protected ai adL;
    private Boolean adM = false;
    private com.baidu.tieba.card.aa<T> adN;
    public a adO;
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

    public void a(ai aiVar) {
        this.adL = aiVar;
    }

    public void bf(int i) {
    }

    public void bg(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rK() {
    }

    public com.baidu.tieba.card.aa<T> rL() {
        return this.adN;
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<T> aaVar) {
        this.adN = aaVar;
    }

    public void a(int i, a.b bVar) {
        this.adL.a(i, bVar);
    }

    public void bh(int i) {
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

    public Boolean rM() {
        return this.adM;
    }

    public void b(Boolean bool) {
        this.adM = bool;
    }
}
