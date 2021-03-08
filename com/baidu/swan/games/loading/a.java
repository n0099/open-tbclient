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
    private final c ekj = d.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int ekk;

    private final String[] aXy() {
        c cVar = this.ekj;
        j jVar = $$delegatedProperties[0];
        return (String[]) cVar.getValue();
    }

    public final String aXz() {
        String[] aXy = aXy();
        if (aXy != null) {
            if (!(aXy.length == 0)) {
                String str = aXy[this.ekk % aXy.length];
                this.ekk++;
                return str;
            }
        }
        return "";
    }
}
