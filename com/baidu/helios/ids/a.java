package com.baidu.helios.ids;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.common.c.a;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes18.dex */
public abstract class a {
    protected a.C0141a asd;
    protected C0142a ase;
    private String b;

    /* renamed from: com.baidu.helios.ids.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C0142a {
        public Context applicationContext;
        public com.baidu.helios.common.c.a aqS;
        public ExecutorService aql;
        public ExecutorService aqm;
        public TrustSubjectManager.d ash;
    }

    /* loaded from: classes18.dex */
    public static class b {
        public boolean asi = false;
    }

    /* loaded from: classes18.dex */
    public interface c<T> {
        void a(int i, Exception exc, Bundle bundle);

        void a(T t, Bundle bundle);
    }

    public a(String str) {
        this.b = str;
    }

    public static String Z(String str, String str2) {
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

    public final void a(C0142a c0142a) {
        this.ase = c0142a;
        this.asd = c0142a.aqS.uK().ec("ids");
    }

    public abstract void a(b bVar);

    public void a(final c<String> cVar) {
        final String uP = uP();
        this.ase.aql.submit(new Runnable() { // from class: com.baidu.helios.ids.a.1
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
