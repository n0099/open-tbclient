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
    static final /* synthetic */ j[] cpV = {t.a(new PropertyReference1Impl(t.M(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final d cpW = e.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int cpX;

    private final String[] aoM() {
        d dVar = this.cpW;
        j jVar = cpV[0];
        return (String[]) dVar.getValue();
    }

    public final String aoN() {
        String[] aoM = aoM();
        if (aoM != null) {
            if (!(aoM.length == 0)) {
                String str = aoM[this.cpX % aoM.length];
                this.cpX++;
                return str;
            }
        }
        return "";
    }
}
