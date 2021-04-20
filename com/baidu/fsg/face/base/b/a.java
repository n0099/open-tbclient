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
    public Context f5564a;

    /* renamed from: b  reason: collision with root package name */
    public C0079a f5565b;

    /* renamed from: com.baidu.fsg.face.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0079a {

        /* renamed from: b  reason: collision with root package name */
        public static final String f5566b = "load_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f5567c = "load_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f5568d = "load_default_so";

        /* renamed from: e  reason: collision with root package name */
        public static final String f5569e = "load_so_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f5570f = "load_download_so_suc";

        /* renamed from: g  reason: collision with root package name */
        public static final String f5571g = "load_so_exception_info";

        /* renamed from: h  reason: collision with root package name */
        public static final String f5572h = "load_so_execption_zip_version";
        public String i;
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
            hashMap.put(f5566b, this.i);
            hashMap.put(f5567c, this.j);
            hashMap.put(f5568d, this.l ? "1" : "-1");
            hashMap.put(f5569e, this.k ? "1" : "-1");
            hashMap.put(f5570f, this.m ? "1" : "-1");
            hashMap.put(f5571g, this.n);
            hashMap.put(f5572h, this.o);
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

    public boolean a(Context context, int i, Bundle bundle) {
        this.f5564a = context;
        this.f5565b = new C0079a();
        b.a a2 = b.a(i);
        c a3 = b.a(context).a(context.getApplicationContext(), a2.f5582a);
        this.f5565b.j = a2.f5582a;
        try {
            if (a3.q && a3.r) {
                if (a3.p) {
                    if (a2.f5583b.compareTo(a3.n) > 0) {
                        this.f5565b.i = a2.f5583b;
                        a(a2.f5585d, a2);
                    } else {
                        a(a2, a3, a2.f5585d);
                    }
                } else {
                    a(a2, a3, a2.f5585d);
                }
                this.f5565b.k = true;
                return true;
            }
            this.f5565b.i = a2.f5583b;
            this.f5565b.k = true;
            a(a2.f5585d, a2);
            return true;
        } catch (Throwable th) {
            try {
                this.f5565b.n = Log.getStackTraceString(th);
                this.f5565b.o = this.f5565b.i;
                this.f5565b.k = false;
                return false;
            } finally {
                this.f5565b.b();
            }
        }
    }

    private void a(String[] strArr, b.a aVar) {
        for (String str : strArr) {
            String str2 = b.b(this.f5564a, aVar) + "/lib" + str + ".so";
            if (g.a(str2)) {
                g.b(str2);
            }
            System.loadLibrary(str);
        }
        this.f5565b.l = true;
    }

    private void a(b.a aVar, c cVar, String[] strArr) {
        boolean z = false;
        try {
            for (String str : strArr) {
                System.load(b.b(this.f5564a, aVar) + "/lib" + str + ".so");
            }
            this.f5565b.i = cVar.n;
            z = true;
        } catch (Throwable th) {
            this.f5565b.m = false;
            this.f5565b.i = aVar.f5583b;
            this.f5565b.n = Log.getStackTraceString(th);
            this.f5565b.o = cVar.n;
        }
        if (z) {
            return;
        }
        a(strArr, aVar);
    }
}
