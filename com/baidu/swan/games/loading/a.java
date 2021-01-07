package com.baidu.swan.games.loading;

import android.annotation.SuppressLint;
import kotlin.c;
import kotlin.d;
import kotlin.e;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.s;
import kotlin.reflect.j;
@SuppressLint({"SwanCommentErr"})
@e
/* loaded from: classes9.dex */
public final class a {
    static final /* synthetic */ j[] $$delegatedProperties = {s.a(new PropertyReference1Impl(s.G(a.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};
    private final c eln = d.b(SwanLoadingTips$loadingTips$2.INSTANCE);
    private int elo;

    private final String[] bbd() {
        c cVar = this.eln;
        j jVar = $$delegatedProperties[0];
        return (String[]) cVar.getValue();
    }

    public final String bbe() {
        String[] bbd = bbd();
        if (bbd != null) {
            if (!(bbd.length == 0)) {
                String str = bbd[this.elo % bbd.length];
                this.elo++;
                return str;
            }
        }
        return "";
    }
}
