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
    protected a.C0153a ayn;
    protected C0154a ayo;
    private String b;

    /* renamed from: com.baidu.helios.ids.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0154a {
        public Context applicationContext;
        public ExecutorService awv;
        public ExecutorService aww;
        public com.baidu.helios.common.c.a axc;
        public TrustSubjectManager.d ayr;
    }

    /* loaded from: classes10.dex */
    public static class b {
        public boolean ays = false;
    }

    /* loaded from: classes10.dex */
    public interface c<T> {
        void a(int i, Exception exc, Bundle bundle);

        void a(T t, Bundle bundle);
    }

    public a(String str) {
        this.b = str;
    }

    public static String ag(String str, String str2) {
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

    public abstract String AI();

    public byte[] AJ() {
        return null;
    }

    public final void a(C0154a c0154a) {
        this.ayo = c0154a;
        this.ayn = c0154a.axc.AD().fD("ids");
    }

    public abstract void a(b bVar);

    public void a(final c<String> cVar) {
        final String AI = AI();
        this.ayo.awv.submit(new Runnable() { // from class: com.baidu.helios.ids.a.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(AI, null);
            }
        });
    }

    public String getName() {
        return this.b;
    }
}
