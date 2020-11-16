package com.baidu.helios.ids;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.common.c.a;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes10.dex */
public abstract class a {
    protected a.C0151a awD;
    protected C0152a awE;
    private String b;

    /* renamed from: com.baidu.helios.ids.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0152a {
        public Context applicationContext;
        public ExecutorService auL;
        public ExecutorService auM;
        public com.baidu.helios.common.c.a avs;
        public TrustSubjectManager.d awH;
    }

    /* loaded from: classes10.dex */
    public static class b {
        public boolean awI = false;
    }

    /* loaded from: classes10.dex */
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

    public byte[] Aa() {
        return null;
    }

    public final void a(C0152a c0152a) {
        this.awE = c0152a;
        this.awD = c0152a.avs.zU().fx("ids");
    }

    public abstract void a(b bVar);

    public void a(final c<String> cVar) {
        final String zZ = zZ();
        this.awE.auL.submit(new Runnable() { // from class: com.baidu.helios.ids.a.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(zZ, null);
            }
        });
    }

    public String getName() {
        return this.b;
    }

    public abstract String zZ();
}
