package com.baidu.helios.ids;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.common.c.a;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes25.dex */
public abstract class a {
    protected a.C0149a axE;
    protected C0150a axF;
    private String b;

    /* renamed from: com.baidu.helios.ids.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0150a {
        public Context applicationContext;
        public ExecutorService avM;
        public ExecutorService avN;
        public com.baidu.helios.common.c.a awt;
        public TrustSubjectManager.d axI;
    }

    /* loaded from: classes25.dex */
    public static class b {
        public boolean axJ = false;
    }

    /* loaded from: classes25.dex */
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

    public abstract String AA();

    public byte[] AB() {
        return null;
    }

    public final void a(C0150a c0150a) {
        this.axF = c0150a;
        this.axE = c0150a.awt.Av().fy("ids");
    }

    public abstract void a(b bVar);

    public void a(final c<String> cVar) {
        final String AA = AA();
        this.axF.avM.submit(new Runnable() { // from class: com.baidu.helios.ids.a.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(AA, null);
            }
        });
    }

    public String getName() {
        return this.b;
    }
}
