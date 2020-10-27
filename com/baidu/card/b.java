package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes21.dex */
public abstract class b<T extends AbsThreadDataSupport> implements p<T>, q {
    protected ak afD;
    private Boolean afE = false;
    private com.baidu.tieba.card.ab<T> afF;
    public a afG;
    protected Context mContext;

    /* loaded from: classes21.dex */
    public interface a {
        void a(AbsThreadDataSupport absThreadDataSupport);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View getView();

    public b(Context context) {
        this.mContext = context;
    }

    public void a(ak akVar) {
        this.afD = akVar;
    }

    public void bo(int i) {
    }

    public void bp(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tA() {
    }

    public com.baidu.tieba.card.ab<T> tB() {
        return this.afF;
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<T> abVar) {
        this.afF = abVar;
    }

    public void a(int i, a.b bVar) {
        this.afD.a(i, bVar);
    }

    public void bq(int i) {
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

    public Boolean tC() {
        return this.afE;
    }

    public void b(Boolean bool) {
        this.afE = bool;
    }
}
