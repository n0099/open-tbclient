package com.baidu.adp.framework.message;

import com.baidu.adp.framework.FrameHelper;
/* loaded from: classes.dex */
public class g extends d<byte[]> {
    private static String a = "toByteArray";
    private Object b;
    private String c;
    private long d;
    private int e;

    public g(int i) {
        super(i);
        this.b = null;
        this.c = null;
        this.d = 0L;
        this.e = 0;
        this.c = a;
    }

    public Object a() {
        return this.b;
    }

    public final byte[] b() {
        Object a2 = a();
        if (a2 instanceof byte[]) {
            return (byte[]) a2;
        }
        try {
            Object invoke = a2.getClass().getMethod(this.c, new Class[0]).invoke(a2, new Object[0]);
            if (invoke != null && (invoke instanceof byte[])) {
                return (byte[]) invoke;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("SocketMessage encode error");
        }
        return null;
    }

    @Override // com.baidu.adp.framework.message.d
    public final boolean a(int i) {
        return FrameHelper.c(i) || FrameHelper.b(i);
    }

    public final long c() {
        return this.d;
    }

    public final void a(long j) {
        this.d = j;
    }

    public final int d() {
        return this.e;
    }

    public final void c(int i) {
        this.e = i;
    }
}
