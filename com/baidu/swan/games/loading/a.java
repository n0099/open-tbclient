package com.baidu.swan.games.loading;

import android.annotation.SuppressLint;
import kotlin.d;
import kotlin.e;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.t;
import kotlin.reflect.j;
@SuppressLint({"SwanCommentErr"})
/* loaded from: classes10.dex */
public final class a {
    static final /* synthetic */ j[] clQ = {t.a(new PropertyReference1Impl(t.N(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final d clR = e.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int clS;

    private final String[] amx() {
        d dVar = this.clR;
        j jVar = clQ[0];
        return (String[]) dVar.getValue();
    }

    public final String amy() {
        String[] amx = amx();
        if (amx != null) {
            if (!(amx.length == 0)) {
                String str = amx[this.clS % amx.length];
                this.clS++;
                return str;
            }
        }
        return "";
    }
}
