package com.baidu.afd.a;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.lego.card.view.e;
/* loaded from: classes.dex */
public class a<T extends e> extends v.a {
    protected T De;

    public a(T t) {
        super((View) t);
        this.De = t;
    }

    public T kz() {
        return this.De;
    }
}
