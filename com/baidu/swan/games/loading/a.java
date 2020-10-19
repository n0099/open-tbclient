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
/* loaded from: classes10.dex */
public final class a {
    static final /* synthetic */ j[] $$delegatedProperties = {t.a(new PropertyReference1Impl(t.M(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final d dIL = e.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int dIM;

    private final String[] aRR() {
        d dVar = this.dIL;
        j jVar = $$delegatedProperties[0];
        return (String[]) dVar.getValue();
    }

    public final String aRS() {
        String[] aRR = aRR();
        if (aRR != null) {
            if (!(aRR.length == 0)) {
                String str = aRR[this.dIM % aRR.length];
                this.dIM++;
                return str;
            }
        }
        return "";
    }
}
