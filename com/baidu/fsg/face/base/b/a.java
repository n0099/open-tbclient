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
/* loaded from: classes11.dex */
public class a {
    private Context a;
    private C0122a b;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [66=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Context context, int i, Bundle bundle) {
        this.a = context;
        this.b = new C0122a();
        b.a a = b.a(i);
        c a2 = b.a(context).a(context.getApplicationContext(), a.a);
        this.b.j = a.a;
        try {
            if (!a2.q || !a2.r) {
                this.b.i = a.b;
                this.b.k = true;
                a(a.d, a);
                return true;
            }
            if (!a2.p) {
                a(a, a2, a.d);
            } else if (a.b.compareTo(a2.n) > 0) {
                this.b.i = a.b;
                a(a.d, a);
            } else {
                a(a, a2, a.d);
            }
            this.b.k = true;
            return true;
        } catch (Throwable th) {
            try {
                this.b.n = Log.getStackTraceString(th);
                this.b.o = this.b.i;
                this.b.k = false;
                return false;
            } finally {
                this.b.b();
            }
        }
    }

    private void a(String[] strArr, b.a aVar) {
        for (String str : strArr) {
            String str2 = b.b(this.a, aVar) + "/lib" + str + PluginInstallerService.APK_LIB_SUFFIX;
            if (g.a(str2)) {
                g.b(str2);
            }
            System.loadLibrary(str);
        }
        this.b.l = true;
    }

    private void a(b.a aVar, c cVar, String[] strArr) {
        boolean z = true;
        try {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                System.load(b.b(this.a, aVar) + "/lib" + strArr[i] + PluginInstallerService.APK_LIB_SUFFIX);
            }
            this.b.i = cVar.n;
        } catch (Throwable th) {
            this.b.m = false;
            this.b.i = aVar.b;
            this.b.n = Log.getStackTraceString(th);
            this.b.o = cVar.n;
            z = false;
        }
        if (!z) {
            a(strArr, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.fsg.face.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0122a {
        private static final String b = "load_so_zip_version";
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

        private C0122a() {
            this.l = false;
            this.m = true;
        }

        private Map<String, String> a() {
            HashMap hashMap = new HashMap();
            hashMap.put(b, this.i);
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
