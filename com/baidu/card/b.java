package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes8.dex */
public abstract class b<T extends com.baidu.tbadk.core.data.a> implements m<T>, n {
    protected ad JX;
    private Boolean JY = false;
    private com.baidu.tieba.card.z<T> JZ;
    public a Ka;
    protected Context mContext;

    /* loaded from: classes8.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View getView();

    public b(Context context) {
        this.mContext = context;
    }

    public void a(ad adVar) {
        this.JX = adVar;
    }

    public void aK(int i) {
    }

    public void aL(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mS() {
    }

    public com.baidu.tieba.card.z<T> mT() {
        return this.JZ;
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.z<T> zVar) {
        this.JZ = zVar;
    }

    public void a(int i, a.b bVar) {
        this.JX.a(i, bVar);
    }

    public void aM(int i) {
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

    public Boolean mU() {
        return this.JY;
    }

    public void b(Boolean bool) {
        this.JY = bool;
    }
}
