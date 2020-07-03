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
    protected a.C0143a ash;
    protected C0144a asi;
    private String b;

    /* renamed from: com.baidu.helios.ids.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0144a {
        public Context applicationContext;
        public com.baidu.helios.common.c.a aqW;
        public ExecutorService aqp;
        public ExecutorService aqq;
        public TrustSubjectManager.d asl;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public boolean asn = false;
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
            str3 = new com.baidu.helios.common.b.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(new com.baidu.helios.common.cc.b().x(format.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "AAAAAAAA";
        }
        return format + str3;
    }

    public final void a(C0144a c0144a) {
        this.asi = c0144a;
        this.ash = c0144a.aqW.uK().ed("ids");
    }

    public abstract void a(b bVar);

    public void a(final c<String> cVar) {
        final String uP = uP();
        this.asi.aqp.submit(new Runnable() { // from class: com.baidu.helios.ids.a.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(uP, null);
            }
        });
    }

    public String getName() {
        return this.b;
    }

    public abstract String uP();

    public byte[] uQ() {
        return null;
    }
}
