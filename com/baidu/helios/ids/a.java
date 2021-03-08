package com.baidu.helios.ids;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.common.c.a;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes4.dex */
public abstract class a {
    protected a.C0139a auy;
    protected C0140a auz;
    private String b;

    /* renamed from: com.baidu.helios.ids.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0140a {
        public Context applicationContext;
        public ExecutorService asK;
        public ExecutorService asL;
        public com.baidu.helios.common.c.a atq;
        public TrustSubjectManager.d auC;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public boolean auD = false;
    }

    /* loaded from: classes4.dex */
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
            str3 = new com.baidu.helios.common.b.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(new com.baidu.helios.common.cc.b().w(format.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "AAAAAAAA";
        }
        return format + str3;
    }

    public final void a(C0140a c0140a) {
        this.auz = c0140a;
        this.auy = c0140a.atq.vk().eg("ids");
    }

    public abstract void a(b bVar);

    public void a(final c<String> cVar) {
        final String vp = vp();
        this.auz.asK.submit(new Runnable() { // from class: com.baidu.helios.ids.a.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(vp, null);
            }
        });
    }

    public String getName() {
        return this.b;
    }

    public abstract String vp();

    public byte[] vq() {
        return null;
    }
}
