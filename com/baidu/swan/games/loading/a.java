package com.baidu.swan.games.loading;

import android.annotation.SuppressLint;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.s;
import kotlin.reflect.j;
@SuppressLint({"SwanCommentErr"})
/* loaded from: classes9.dex */
public final class a {
    static final /* synthetic */ j[] clD = {s.a(new PropertyReference1Impl(s.M(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final c clE = d.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int clF;

    private final String[] ame() {
        c cVar = this.clE;
        j jVar = clD[0];
        return (String[]) cVar.getValue();
    }

    public final String amf() {
        String[] ame = ame();
        if (ame != null) {
            if (!(ame.length == 0)) {
                String str = ame[this.clF % ame.length];
                this.clF++;
                return str;
            }
        }
        return "";
    }
}
