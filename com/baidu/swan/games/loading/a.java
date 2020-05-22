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
    static final /* synthetic */ j[] cZZ = {t.a(new PropertyReference1Impl(t.M(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final d daa = e.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int dab;

    private final String[] aAT() {
        d dVar = this.daa;
        j jVar = cZZ[0];
        return (String[]) dVar.getValue();
    }

    public final String aAU() {
        String[] aAT = aAT();
        if (aAT != null) {
            if (!(aAT.length == 0)) {
                String str = aAT[this.dab % aAT.length];
                this.dab++;
                return str;
            }
        }
        return "";
    }
}
