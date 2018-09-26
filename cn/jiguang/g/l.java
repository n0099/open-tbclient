package cn.jiguang.g;

import java.util.Date;
/* loaded from: classes3.dex */
public final class l {
    private long a = System.currentTimeMillis();

    public final void a(String str) {
        new StringBuilder().append(str).append(" | cost time:").append(cn.jiguang.d.h.c.a("mm:ss:SSS").format(new Date(System.currentTimeMillis() - this.a)));
    }
}
