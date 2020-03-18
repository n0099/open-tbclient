package com.baidu.swan.games.loading;

import android.annotation.SuppressLint;
import kotlin.d;
import kotlin.e;
import kotlin.h;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.t;
import kotlin.reflect.j;
@h
@SuppressLint({"SwanCommentErr"})
/* loaded from: classes11.dex */
public final class a {
    static final /* synthetic */ j[] cqg = {t.a(new PropertyReference1Impl(t.M(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final d cqh = e.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int cqi;

    private final String[] aoP() {
        d dVar = this.cqh;
        j jVar = cqg[0];
        return (String[]) dVar.getValue();
    }

    public final String aoQ() {
        String[] aoP = aoP();
        if (aoP != null) {
            if (!(aoP.length == 0)) {
                String str = aoP[this.cqi % aoP.length];
                this.cqi++;
                return str;
            }
        }
        return "";
    }
}
