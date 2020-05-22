package com.baidu.helios.ids;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.common.c.a;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public abstract class a {
    protected a.C0141a aqP;
    protected C0142a aqQ;
    private String b;

    /* renamed from: com.baidu.helios.ids.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0142a {
        public ExecutorService aoW;
        public ExecutorService aoX;
        public com.baidu.helios.common.c.a apE;
        public Context applicationContext;
        public TrustSubjectManager.d aqT;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public boolean aqU = false;
    }

    /* loaded from: classes6.dex */
    public interface c<T> {
        void a(int i, Exception exc, Bundle bundle);

        void a(T t, Bundle bundle);
    }

    public a(String str) {
        this.b = str;
    }

    public static String aa(String str, String str2) {
        String format = String.format("%s-%s-", str, str2);
        String str3 = null;
        try {
            str3 = new com.baidu.helios.common.b.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(new com.baidu.helios.common.cc.b().v(format.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "AAAAAAAA";
        }
        return format + str3;
    }

    public final void a(C0142a c0142a) {
        this.aqQ = c0142a;
        this.aqP = c0142a.apE.us().eb("ids");
    }

    public abstract void a(b bVar);

    public void a(final c<String> cVar) {
        final String ux = ux();
        this.aqQ.aoW.submit(new Runnable() { // from class: com.baidu.helios.ids.a.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(ux, null);
            }
        });
    }

    public String getName() {
        return this.b;
    }

    public abstract String ux();

    public byte[] uy() {
        return null;
    }
}
