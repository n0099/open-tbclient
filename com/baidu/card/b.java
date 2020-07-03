package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes8.dex */
public abstract class b<T extends AbsThreadDataSupport> implements n<T>, o {
    protected ai adV;
    private Boolean adW = false;
    private com.baidu.tieba.card.aa<T> adX;
    public a adY;
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

    public void a(ai aiVar) {
        this.adV = aiVar;
    }

    public void bd(int i) {
    }

    public void be(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rI() {
    }

    public com.baidu.tieba.card.aa<T> rJ() {
        return this.adX;
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<T> aaVar) {
        this.adX = aaVar;
    }

    public void a(int i, a.b bVar) {
        this.adV.a(i, bVar);
    }

    public void bf(int i) {
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

    public Boolean rK() {
        return this.adW;
    }

    public void b(Boolean bool) {
        this.adW = bool;
    }
}
