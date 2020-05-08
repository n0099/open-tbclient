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
    static final /* synthetic */ j[] cPh = {t.a(new PropertyReference1Impl(t.M(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final d cPi = e.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int cPj;

    private final String[] axc() {
        d dVar = this.cPi;
        j jVar = cPh[0];
        return (String[]) dVar.getValue();
    }

    public final String axd() {
        String[] axc = axc();
        if (axc != null) {
            if (!(axc.length == 0)) {
                String str = axc[this.cPj % axc.length];
                this.cPj++;
                return str;
            }
        }
        return "";
    }
}
