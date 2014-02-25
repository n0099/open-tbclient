package com.baidu.adp.framework.message;

import com.baidu.adp.framework.FrameHelper;
/* loaded from: classes.dex */
public class g extends e<byte[]> {
    private static String a = "toByteArray";
    private Object b;
    private String c;

    public byte[] a() {
        try {
            Object invoke = this.b.getClass().getMethod(this.c, new Class[0]).invoke(this.b, new Object[0]);
            if (invoke != null && (invoke instanceof byte[])) {
                return (byte[]) invoke;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("SocketMessage encode error");
        }
        return null;
    }

    @Override // com.baidu.adp.framework.message.e
    public boolean a(int i) {
        return FrameHelper.c(i);
    }
}
