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
/* loaded from: classes25.dex */
public final class a {
    static final /* synthetic */ j[] $$delegatedProperties = {s.a(new PropertyReference1Impl(s.M(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final c ecq = d.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int ecr;

    private final String[] aYI() {
        c cVar = this.ecq;
        j jVar = $$delegatedProperties[0];
        return (String[]) cVar.getValue();
    }

    public final String aYJ() {
        String[] aYI = aYI();
        if (aYI != null) {
            if (!(aYI.length == 0)) {
                String str = aYI[this.ecr % aYI.length];
                this.ecr++;
                return str;
            }
        }
        return "";
    }
}
