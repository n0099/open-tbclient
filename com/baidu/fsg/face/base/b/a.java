package com.baidu.fsg.face.base.b;

import android.content.Context;
import android.os.Bundle;
import com.baidu.android.common.logging.Log;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.face.base.b.b;
import com.baidu.fsg.face.base.d.g;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f5713a;

    /* renamed from: b  reason: collision with root package name */
    public C0079a f5714b;

    /* renamed from: com.baidu.fsg.face.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0079a {

        /* renamed from: b  reason: collision with root package name */
        public static final String f5715b = "load_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f5716c = "load_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f5717d = "load_default_so";

        /* renamed from: e  reason: collision with root package name */
        public static final String f5718e = "load_so_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f5719f = "load_download_so_suc";

        /* renamed from: g  reason: collision with root package name */
        public static final String f5720g = "load_so_exception_info";

        /* renamed from: h  reason: collision with root package name */
        public static final String f5721h = "load_so_execption_zip_version";

        /* renamed from: i  reason: collision with root package name */
        public String f5723i;
        public String j;
        public boolean k;
        public boolean l;
        public boolean m;
        public String n;
        public String o;

        public C0079a() {
            this.l = false;
            this.m = true;
        }

        private Map<String, String> a() {
            HashMap hashMap = new HashMap();
            hashMap.put(f5715b, this.f5723i);
            hashMap.put(f5716c, this.j);
            hashMap.put(f5717d, this.l ? "1" : "-1");
            hashMap.put(f5718e, this.k ? "1" : "-1");
            hashMap.put(f5719f, this.m ? "1" : "-1");
            hashMap.put(f5720g, this.n);
            hashMap.put(f5721h, this.o);
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            for (Map.Entry<String, String> entry : a().entrySet()) {
                RimStatisticsUtil.onEventWithValue(entry.getKey(), entry.getValue());
            }
            RimStatisticsUtil.getInstance().triggerSending();
        }
    }

    public boolean a(Context context, int i2, Bundle bundle) {
        this.f5713a = context;
        this.f5714b = new C0079a();
        b.a a2 = b.a(i2);
        c a3 = b.a(context).a(context.getApplicationContext(), a2.f5733a);
        this.f5714b.j = a2.f5733a;
        try {
            if (a3.q && a3.r) {
                if (a3.p) {
                    if (a2.f5734b.compareTo(a3.n) > 0) {
                        this.f5714b.f5723i = a2.f5734b;
                        a(a2.f5736d, a2);
                    } else {
                        a(a2, a3, a2.f5736d);
                    }
                } else {
                    a(a2, a3, a2.f5736d);
                }
                this.f5714b.k = true;
                return true;
            }
            this.f5714b.f5723i = a2.f5734b;
            this.f5714b.k = true;
            a(a2.f5736d, a2);
            return true;
        } catch (Throwable th) {
            try {
                this.f5714b.n = Log.getStackTraceString(th);
                this.f5714b.o = this.f5714b.f5723i;
                this.f5714b.k = false;
                return false;
            } finally {
                this.f5714b.b();
            }
        }
    }

    private void a(String[] strArr, b.a aVar) {
        for (String str : strArr) {
            String str2 = b.b(this.f5713a, aVar) + "/lib" + str + ".so";
            if (g.a(str2)) {
                g.b(str2);
            }
            System.loadLibrary(str);
        }
        this.f5714b.l = true;
    }

    private void a(b.a aVar, c cVar, String[] strArr) {
        boolean z = false;
        try {
            for (String str : strArr) {
                System.load(b.b(this.f5713a, aVar) + "/lib" + str + ".so");
            }
            this.f5714b.f5723i = cVar.n;
            z = true;
        } catch (Throwable th) {
            this.f5714b.m = false;
            this.f5714b.f5723i = aVar.f5734b;
            this.f5714b.n = Log.getStackTraceString(th);
            this.f5714b.o = cVar.n;
        }
        if (z) {
            return;
        }
        a(strArr, aVar);
    }
}
