package com.baidu.helios.ids;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.common.c.a;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes14.dex */
public abstract class a {
    protected a.C0133a ati;
    protected C0134a atj;

    /* renamed from: b  reason: collision with root package name */
    private String f2444b;

    /* renamed from: com.baidu.helios.ids.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0134a {
        public Context applicationContext;
        public com.baidu.helios.common.c.a arZ;
        public ExecutorService aru;
        public ExecutorService arv;
        public TrustSubjectManager.d atm;
    }

    /* loaded from: classes14.dex */
    public static class b {
        public boolean atn = false;
    }

    /* loaded from: classes14.dex */
    public interface c<T> {
        void a(int i, Exception exc, Bundle bundle);

        void a(T t, Bundle bundle);
    }

    public a(String str) {
        this.f2444b = str;
    }

    public static String ac(String str, String str2) {
        String format = String.format("%s-%s-", str, str2);
        String str3 = null;
        try {
            str3 = new com.baidu.helios.common.b.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(new com.baidu.helios.common.cc.b().u(format.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "AAAAAAAA";
        }
        return format + str3;
    }

    public final void a(C0134a c0134a) {
        this.atj = c0134a;
        this.ati = c0134a.arZ.vk().ea("ids");
    }

    public abstract void a(b bVar);

    public void a(final c<String> cVar) {
        final String vp = vp();
        this.atj.aru.submit(new Runnable() { // from class: com.baidu.helios.ids.a.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(vp, null);
            }
        });
    }

    public String getName() {
        return this.f2444b;
    }

    public abstract String vp();

    public byte[] vq() {
        return null;
    }
}
