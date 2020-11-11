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
    private final d dXa = e.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int dXb;

    private final String[] aWl() {
        d dVar = this.dXa;
        j jVar = $$delegatedProperties[0];
        return (String[]) dVar.getValue();
    }

    public final String aWm() {
        String[] aWl = aWl();
        if (aWl != null) {
            if (!(aWl.length == 0)) {
                String str = aWl[this.dXb % aWl.length];
                this.dXb++;
                return str;
            }
        }
        return "";
    }
}
