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
    private final d dRi = e.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int dRj;

    private final String[] aTL() {
        d dVar = this.dRi;
        j jVar = $$delegatedProperties[0];
        return (String[]) dVar.getValue();
    }

    public final String aTM() {
        String[] aTL = aTL();
        if (aTL != null) {
            if (!(aTL.length == 0)) {
                String str = aTL[this.dRj % aTL.length];
                this.dRj++;
                return str;
            }
        }
        return "";
    }
}
