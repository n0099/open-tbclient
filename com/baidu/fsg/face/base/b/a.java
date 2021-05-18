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
    public Context f5567a;

    /* renamed from: b  reason: collision with root package name */
    public C0078a f5568b;

    /* renamed from: com.baidu.fsg.face.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0078a {

        /* renamed from: b  reason: collision with root package name */
        public static final String f5569b = "load_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f5570c = "load_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f5571d = "load_default_so";

        /* renamed from: e  reason: collision with root package name */
        public static final String f5572e = "load_so_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f5573f = "load_download_so_suc";

        /* renamed from: g  reason: collision with root package name */
        public static final String f5574g = "load_so_exception_info";

        /* renamed from: h  reason: collision with root package name */
        public static final String f5575h = "load_so_execption_zip_version";

        /* renamed from: i  reason: collision with root package name */
        public String f5577i;
        public String j;
        public boolean k;
        public boolean l;
        public boolean m;
        public String n;
        public String o;

        public C0078a() {
            this.l = false;
            this.m = true;
        }

        private Map<String, String> a() {
            HashMap hashMap = new HashMap();
            hashMap.put(f5569b, this.f5577i);
            hashMap.put(f5570c, this.j);
            hashMap.put(f5571d, this.l ? "1" : "-1");
            hashMap.put(f5572e, this.k ? "1" : "-1");
            hashMap.put(f5573f, this.m ? "1" : "-1");
            hashMap.put(f5574g, this.n);
            hashMap.put(f5575h, this.o);
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
        this.f5567a = context;
        this.f5568b = new C0078a();
        b.a a2 = b.a(i2);
        c a3 = b.a(context).a(context.getApplicationContext(), a2.f5587a);
        this.f5568b.j = a2.f5587a;
        try {
            if (a3.q && a3.r) {
                if (a3.p) {
                    if (a2.f5588b.compareTo(a3.n) > 0) {
                        this.f5568b.f5577i = a2.f5588b;
                        a(a2.f5590d, a2);
                    } else {
                        a(a2, a3, a2.f5590d);
                    }
                } else {
                    a(a2, a3, a2.f5590d);
                }
                this.f5568b.k = true;
                return true;
            }
            this.f5568b.f5577i = a2.f5588b;
            this.f5568b.k = true;
            a(a2.f5590d, a2);
            return true;
        } catch (Throwable th) {
            try {
                this.f5568b.n = Log.getStackTraceString(th);
                this.f5568b.o = this.f5568b.f5577i;
                this.f5568b.k = false;
                return false;
            } finally {
                this.f5568b.b();
            }
        }
    }

    private void a(String[] strArr, b.a aVar) {
        for (String str : strArr) {
            String str2 = b.b(this.f5567a, aVar) + "/lib" + str + ".so";
            if (g.a(str2)) {
                g.b(str2);
            }
            System.loadLibrary(str);
        }
        this.f5568b.l = true;
    }

    private void a(b.a aVar, c cVar, String[] strArr) {
        boolean z = false;
        try {
            for (String str : strArr) {
                System.load(b.b(this.f5567a, aVar) + "/lib" + str + ".so");
            }
            this.f5568b.f5577i = cVar.n;
            z = true;
        } catch (Throwable th) {
            this.f5568b.m = false;
            this.f5568b.f5577i = aVar.f5588b;
            this.f5568b.n = Log.getStackTraceString(th);
            this.f5568b.o = cVar.n;
        }
        if (z) {
            return;
        }
        a(strArr, aVar);
    }
}
