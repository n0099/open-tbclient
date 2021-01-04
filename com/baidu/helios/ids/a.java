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
    protected a.C0141a axU;
    protected C0142a axV;

    /* renamed from: b  reason: collision with root package name */
    private String f2493b;

    /* renamed from: com.baidu.helios.ids.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0142a {
        public Context applicationContext;
        public com.baidu.helios.common.c.a awL;
        public ExecutorService awg;
        public ExecutorService awh;
        public TrustSubjectManager.d axY;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public boolean axZ = false;
    }

    /* loaded from: classes6.dex */
    public interface c<T> {
        void a(int i, Exception exc, Bundle bundle);

        void a(T t, Bundle bundle);
    }

    public a(String str) {
        this.f2493b = str;
    }

    public static String ad(String str, String str2) {
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
        this.axV = c0142a;
        this.axU = c0142a.awL.zf().fm("ids");
    }

    public abstract void a(b bVar);

    public void a(final c<String> cVar) {
        final String zk = zk();
        this.axV.awg.submit(new Runnable() { // from class: com.baidu.helios.ids.a.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(zk, null);
            }
        });
    }

    public String getName() {
        return this.f2493b;
    }

    public abstract String zk();

    public byte[] zl() {
        return null;
    }
}
