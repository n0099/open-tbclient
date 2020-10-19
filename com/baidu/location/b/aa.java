package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private b f1864a;
    private long b = 0;
    private long c = 0;

    /* loaded from: classes7.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static aa f1865a = new aa();
    }

    /* loaded from: classes7.dex */
    class b extends com.baidu.location.e.f {
        private boolean d = false;
        private String e = null;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1866a = false;
        public long b = 0;

        public b() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            String b = com.baidu.location.e.b.a().b();
            if (b != null) {
                b = b + "&gnsst=" + this.b;
            }
            String a2 = m.a().a(b);
            String replaceAll = !TextUtils.isEmpty(a2) ? a2.trim().replaceAll("\r|\n", "") : "null";
            String a3 = m.a().a(this.e);
            String replaceAll2 = !TextUtils.isEmpty(a3) ? a3.trim().replaceAll("\r|\n", "") : "null";
            try {
                this.k.put("info", URLEncoder.encode(replaceAll, "utf-8"));
                this.k.put("enl", URLEncoder.encode(replaceAll2, "utf-8"));
            } catch (Exception e) {
            }
        }

        public void a(String str, long j) {
            if (this.d) {
                return;
            }
            this.d = true;
            this.e = str;
            this.b = j;
            ExecutorService c = z.a().c();
            if (c != null) {
                a(c, "https://ofloc.map.baidu.com/locnu");
            } else {
                b("https://ofloc.map.baidu.com/locnu");
            }
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z) {
            if (z && this.j != null) {
                try {
                    new JSONObject(this.j);
                    this.f1866a = true;
                } catch (Throwable th) {
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.d = false;
        }

        public boolean b() {
            return this.d;
        }
    }

    public static aa a() {
        return a.f1865a;
    }

    @TargetApi(24)
    public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
        q.a().a(gnssNavigationMessage, j);
        this.b = System.currentTimeMillis();
        this.c = j;
    }

    public void b() {
        ArrayList<String> b2;
        if (this.b == 0 || Math.abs(System.currentTimeMillis() - this.b) >= 20000) {
            return;
        }
        if (this.f1864a == null) {
            this.f1864a = new b();
        }
        if (this.f1864a == null || this.f1864a.b() || (b2 = q.a().b()) == null || b2.size() <= 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        Iterator<String> it = b2.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                this.f1864a.a(stringBuffer.toString(), this.c);
                return;
            }
            stringBuffer.append(it.next());
            i = i2 + 1;
            if (i != b2.size()) {
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            }
        }
    }
}
