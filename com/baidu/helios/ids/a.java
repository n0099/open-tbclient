package com.baidu.helios.ids;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.common.c.a;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes3.dex */
public abstract class a {
    protected a.C0133a asY;
    protected C0134a asZ;

    /* renamed from: b  reason: collision with root package name */
    private String f2442b;

    /* renamed from: com.baidu.helios.ids.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0134a {
        public Context applicationContext;
        public com.baidu.helios.common.c.a arP;
        public ExecutorService ark;
        public ExecutorService arl;
        public TrustSubjectManager.d atc;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public boolean atd = false;
    }

    /* loaded from: classes3.dex */
    public interface c<T> {
        void a(int i, Exception exc, Bundle bundle);

        void a(T t, Bundle bundle);
    }

    public a(String str) {
        this.f2442b = str;
    }

    public static String aa(String str, String str2) {
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
        this.asZ = c0134a;
        this.asY = c0134a.arP.vh().ea("ids");
    }

    public abstract void a(b bVar);

    public void a(final c<String> cVar) {
        final String vm = vm();
        this.asZ.ark.submit(new Runnable() { // from class: com.baidu.helios.ids.a.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(vm, null);
            }
        });
    }

    public String getName() {
        return this.f2442b;
    }

    public abstract String vm();

    public byte[] vn() {
        return null;
    }
}
