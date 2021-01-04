package com.baidu.fsg.face.base.b;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.android.common.logging.Log;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.face.base.b.b;
import com.baidu.fsg.face.base.d.g;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f2105a;

    /* renamed from: b  reason: collision with root package name */
    private C0111a f2106b;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [66=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Context context, int i, Bundle bundle) {
        this.f2105a = context;
        this.f2106b = new C0111a();
        b.a a2 = b.a(i);
        c a3 = b.a(context).a(context.getApplicationContext(), a2.f2111a);
        this.f2106b.j = a2.f2111a;
        try {
            if (!a3.q || !a3.r) {
                this.f2106b.i = a2.f2112b;
                this.f2106b.k = true;
                a(a2.d, a2);
                return true;
            }
            if (!a3.p) {
                a(a2, a3, a2.d);
            } else if (a2.f2112b.compareTo(a3.n) > 0) {
                this.f2106b.i = a2.f2112b;
                a(a2.d, a2);
            } else {
                a(a2, a3, a2.d);
            }
            this.f2106b.k = true;
            return true;
        } catch (Throwable th) {
            try {
                this.f2106b.n = Log.getStackTraceString(th);
                this.f2106b.o = this.f2106b.i;
                this.f2106b.k = false;
                return false;
            } finally {
                this.f2106b.b();
            }
        }
    }

    private void a(String[] strArr, b.a aVar) {
        for (String str : strArr) {
            String str2 = b.b(this.f2105a, aVar) + "/lib" + str + PluginInstallerService.APK_LIB_SUFFIX;
            if (g.a(str2)) {
                g.b(str2);
            }
            System.loadLibrary(str);
        }
        this.f2106b.l = true;
    }

    private void a(b.a aVar, c cVar, String[] strArr) {
        boolean z = true;
        try {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                System.load(b.b(this.f2105a, aVar) + "/lib" + strArr[i] + PluginInstallerService.APK_LIB_SUFFIX);
            }
            this.f2106b.i = cVar.n;
        } catch (Throwable th) {
            this.f2106b.m = false;
            this.f2106b.i = aVar.f2112b;
            this.f2106b.n = Log.getStackTraceString(th);
            this.f2106b.o = cVar.n;
            z = false;
        }
        if (!z) {
            a(strArr, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.fsg.face.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0111a {

        /* renamed from: b  reason: collision with root package name */
        private static final String f2107b = "load_so_zip_version";
        private static final String c = "load_so_modle_name";
        private static final String d = "load_default_so";
        private static final String e = "load_so_success";
        private static final String f = "load_download_so_suc";
        private static final String g = "load_so_exception_info";
        private static final String h = "load_so_execption_zip_version";
        private String i;
        private String j;
        private boolean k;
        private boolean l;
        private boolean m;
        private String n;
        private String o;

        private C0111a() {
            this.l = false;
            this.m = true;
        }

        private Map<String, String> a() {
            HashMap hashMap = new HashMap();
            hashMap.put(f2107b, this.i);
            hashMap.put(c, this.j);
            hashMap.put(d, this.l ? "1" : "-1");
            hashMap.put(e, this.k ? "1" : "-1");
            hashMap.put(f, this.m ? "1" : "-1");
            hashMap.put(g, this.n);
            hashMap.put(h, this.o);
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
}
