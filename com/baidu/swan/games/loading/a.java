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
/* loaded from: classes3.dex */
public final class a {
    static final /* synthetic */ j[] $$delegatedProperties = {t.a(new PropertyReference1Impl(t.M(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final d dwK = e.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int dwL;

    private final String[] aPi() {
        d dVar = this.dwK;
        j jVar = $$delegatedProperties[0];
        return (String[]) dVar.getValue();
    }

    public final String aPj() {
        String[] aPi = aPi();
        if (aPi != null) {
            if (!(aPi.length == 0)) {
                String str = aPi[this.dwL % aPi.length];
                this.dwL++;
                return str;
            }
        }
        return "";
    }
}
