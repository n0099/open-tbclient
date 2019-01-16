package com.baidu.afd.a;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.lego.card.view.e;
/* loaded from: classes.dex */
public class a<T extends e> extends q.a {
    protected T Sm;

    public a(T t) {
        super((View) t);
        this.Sm = t;
    }

    public T pC() {
        return this.Sm;
    }
}
