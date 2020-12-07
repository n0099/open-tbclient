package com.baidu.helios.ids;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.common.c.a;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes19.dex */
public abstract class a {
    protected a.C0149a axB;
    protected C0150a axC;
    private String b;

    /* renamed from: com.baidu.helios.ids.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C0150a {
        public Context applicationContext;
        public ExecutorService avJ;
        public ExecutorService avK;
        public com.baidu.helios.common.c.a awq;
        public TrustSubjectManager.d axF;
    }

    /* loaded from: classes19.dex */
    public static class b {
        public boolean axG = false;
    }

    /* loaded from: classes19.dex */
    public interface c<T> {
        void a(int i, Exception exc, Bundle bundle);

        void a(T t, Bundle bundle);
    }

    public a(String str) {
        this.b = str;
    }

    public static String af(String str, String str2) {
        String format = String.format("%s-%s-", str, str2);
        String str3 = null;
        try {
            str3 = new com.baidu.helios.common.b.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(new com.baidu.helios.common.cc.b().y(format.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "AAAAAAAA";
        }
        return format + str3;
    }

    public final void a(C0150a c0150a) {
        this.axC = c0150a;
        this.axB = c0150a.awq.zO().fB("ids");
    }

    public abstract void a(b bVar);

    public void a(final c<String> cVar) {
        final String zT = zT();
        this.axC.avJ.submit(new Runnable() { // from class: com.baidu.helios.ids.a.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(zT, null);
            }
        });
    }

    public String getName() {
        return this.b;
    }

    public abstract String zT();

    public byte[] zU() {
        return null;
    }
}
