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
/* loaded from: classes7.dex */
public final class a {
    static final /* synthetic */ j[] dkx = {t.a(new PropertyReference1Impl(t.M(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final d dky = e.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int dkz;

    private final String[] aFG() {
        d dVar = this.dky;
        j jVar = dkx[0];
        return (String[]) dVar.getValue();
    }

    public final String aFH() {
        String[] aFG = aFG();
        if (aFG != null) {
            if (!(aFG.length == 0)) {
                String str = aFG[this.dkz % aFG.length];
                this.dkz++;
                return str;
            }
        }
        return "";
    }
}
