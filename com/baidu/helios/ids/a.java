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
    protected a.C0148a axa;
    protected C0149a axb;
    private String b;

    /* renamed from: com.baidu.helios.ids.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0149a {
        public Context applicationContext;
        public com.baidu.helios.common.c.a avP;
        public ExecutorService avi;
        public ExecutorService avj;
        public TrustSubjectManager.d axe;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public boolean axf = false;
    }

    /* loaded from: classes6.dex */
    public interface c<T> {
        void a(int i, Exception exc, Bundle bundle);

        void a(T t, Bundle bundle);
    }

    public a(String str) {
        this.b = str;
    }

    public static String ad(String str, String str2) {
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

    public abstract String Am();

    public byte[] An() {
        return null;
    }

    public final void a(C0149a c0149a) {
        this.axb = c0149a;
        this.axa = c0149a.avP.Ah().fv("ids");
    }

    public abstract void a(b bVar);

    public void a(final c<String> cVar) {
        final String Am = Am();
        this.axb.avi.submit(new Runnable() { // from class: com.baidu.helios.ids.a.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(Am, null);
            }
        });
    }

    public String getName() {
        return this.b;
    }
}
