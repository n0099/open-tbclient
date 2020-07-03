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
    static final /* synthetic */ j[] deO = {t.a(new PropertyReference1Impl(t.M(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final d deP = e.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int deQ;

    private final String[] aBZ() {
        d dVar = this.deP;
        j jVar = deO[0];
        return (String[]) dVar.getValue();
    }

    public final String aCa() {
        String[] aBZ = aBZ();
        if (aBZ != null) {
            if (!(aBZ.length == 0)) {
                String str = aBZ[this.deQ % aBZ.length];
                this.deQ++;
                return str;
            }
        }
        return "";
    }
}
