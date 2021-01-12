package com.baidu.swan.games.loading;

import android.annotation.SuppressLint;
import kotlin.c;
import kotlin.d;
import kotlin.e;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.s;
import kotlin.reflect.j;
@SuppressLint({"SwanCommentErr"})
@e
/* loaded from: classes8.dex */
public final class a {
    static final /* synthetic */ j[] $$delegatedProperties = {s.a(new PropertyReference1Impl(s.G(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final c egB = d.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int egC;

    private final String[] aXj() {
        c cVar = this.egB;
        j jVar = $$delegatedProperties[0];
        return (String[]) cVar.getValue();
    }

    public final String aXk() {
        String[] aXj = aXj();
        if (aXj != null) {
            if (!(aXj.length == 0)) {
                String str = aXj[this.egC % aXj.length];
                this.egC++;
                return str;
            }
        }
        return "";
    }
}
