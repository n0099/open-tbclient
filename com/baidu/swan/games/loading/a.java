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
/* loaded from: classes9.dex */
public final class a {
    static final /* synthetic */ j[] $$delegatedProperties = {s.a(new PropertyReference1Impl(s.G(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final c eiI = d.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int eiJ;

    private final String[] aXv() {
        c cVar = this.eiI;
        j jVar = $$delegatedProperties[0];
        return (String[]) cVar.getValue();
    }

    public final String aXw() {
        String[] aXv = aXv();
        if (aXv != null) {
            if (!(aXv.length == 0)) {
                String str = aXv[this.eiJ % aXv.length];
                this.eiJ++;
                return str;
            }
        }
        return "";
    }
}
