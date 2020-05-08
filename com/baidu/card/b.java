package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes8.dex */
public abstract class b<T extends com.baidu.tbadk.core.data.a> implements m<T>, n {
    protected ad acY;
    private Boolean acZ = false;
    private com.baidu.tieba.card.z<T> ada;
    public a adb;
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
        this.acY = adVar;
    }

    public void aW(int i) {
    }

    public void aX(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rk() {
    }

    public com.baidu.tieba.card.z<T> rl() {
        return this.ada;
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.z<T> zVar) {
        this.ada = zVar;
    }

    public void a(int i, a.b bVar) {
        this.acY.a(i, bVar);
    }

    public void aY(int i) {
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

    public Boolean rm() {
        return this.acZ;
    }

    public void b(Boolean bool) {
        this.acZ = bool;
    }
}
