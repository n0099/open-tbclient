package com.baidu.afd.a;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.lego.card.view.e;
/* loaded from: classes.dex */
public class a<T extends e> extends q.a {
    protected T Pl;

    public a(T t) {
        super((View) t);
        this.Pl = t;
    }

    public T oo() {
        return this.Pl;
    }
}
