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
    static final /* synthetic */ j[] $$delegatedProperties = {t.a(new PropertyReference1Impl(t.M(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final d dVs = e.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int dVt;

    private final String[] aVD() {
        d dVar = this.dVs;
        j jVar = $$delegatedProperties[0];
        return (String[]) dVar.getValue();
    }

    public final String aVE() {
        String[] aVD = aVD();
        if (aVD != null) {
            if (!(aVD.length == 0)) {
                String str = aVD[this.dVt % aVD.length];
                this.dVt++;
                return str;
            }
        }
        return "";
    }
}
