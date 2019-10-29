package com.baidu.afd.a;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.lego.card.view.e;
/* loaded from: classes.dex */
public class a<T extends e> extends v.a {
    protected T AV;

    public a(T t) {
        super((View) t);
        this.AV = t;
    }

    public T kh() {
        return this.AV;
    }
}
