package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes6.dex */
public abstract class b<T extends com.baidu.tbadk.core.data.a> implements m<T>, n {
    protected ad JC;
    private Boolean JD = false;
    private com.baidu.tieba.card.z<T> JE;
    public a JF;
    protected Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View getView();

    public b(Context context) {
        this.mContext = context;
    }

    public void a(ad adVar) {
        this.JC = adVar;
    }

    public void aH(int i) {
    }

    public void aI(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mD() {
    }

    public com.baidu.tieba.card.z<T> mE() {
        return this.JE;
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.z<T> zVar) {
        this.JE = zVar;
    }

    public void a(int i, a.b bVar) {
        this.JC.a(i, bVar);
    }

    public void aJ(int i) {
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

    public Boolean mF() {
        return this.JD;
    }

    public void b(Boolean bool) {
        this.JD = bool;
    }
}
