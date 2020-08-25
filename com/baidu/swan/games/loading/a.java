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
/* loaded from: classes8.dex */
public final class a {
    static final /* synthetic */ j[] $$delegatedProperties = {t.a(new PropertyReference1Impl(t.M(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final d duF = e.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int duG;

    private final String[] aOx() {
        d dVar = this.duF;
        j jVar = $$delegatedProperties[0];
        return (String[]) dVar.getValue();
    }

    public final String aOy() {
        String[] aOx = aOx();
        if (aOx != null) {
            if (!(aOx.length == 0)) {
                String str = aOx[this.duG % aOx.length];
                this.duG++;
                return str;
            }
        }
        return "";
    }
}
