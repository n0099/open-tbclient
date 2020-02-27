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
    static final /* synthetic */ j[] cpT = {t.a(new PropertyReference1Impl(t.M(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final d cpU = e.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int cpV;

    private final String[] aoK() {
        d dVar = this.cpU;
        j jVar = cpT[0];
        return (String[]) dVar.getValue();
    }

    public final String aoL() {
        String[] aoK = aoK();
        if (aoK != null) {
            if (!(aoK.length == 0)) {
                String str = aoK[this.cpV % aoK.length];
                this.cpV++;
                return str;
            }
        }
        return "";
    }
}
