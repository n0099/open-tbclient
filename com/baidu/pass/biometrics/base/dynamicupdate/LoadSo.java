package com.baidu.pass.biometrics.base.dynamicupdate;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class LoadSo {

    /* renamed from: a  reason: collision with root package name */
    static final String f2744a = "3.0.0";
    static final String[] b = {"bd_idl_pass_token", "idl_license", "FaceSDK"};
    private Context c;
    private StatService d;
    private Bundle e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class StatService {

        /* renamed from: a  reason: collision with root package name */
        private static final String f2745a = "sapi_bio_dynamic_load_so";
        private static final String b = "host_version";
        private static final String c = "zip_version";
        private static final String d = "modle_name";
        private static final String e = "load_default_so";
        private static final String f = "load_so_success";
        private static final String g = "load_download_so_suc";
        private static final String h = "exception_info";
        private static final String i = "execption_zip_version";
        private static final String j = "bio_processid";
        private static final String k = "liveness_subpro";
        private static final String l = "tpl";
        private static final String m = "bio_cuid";
        private static final String n = "device_model";
        private static final String o = "phone_sys";
        private String p;
        private String q;
        private boolean r;
        private boolean s;
        private boolean t;
        private String u;
        private String v;
        private String w;
        private String x;
        private String y;

        private StatService() {
            this.s = false;
            this.t = true;
        }

        private Map<String, String> a() {
            if (LoadSo.this.e != null) {
                this.w = LoadSo.this.e.getString("uuid");
                this.y = LoadSo.this.e.getString("tpl");
                this.x = LoadSo.this.e.getString("productId");
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host_version", this.p);
            hashMap.put("zip_version", this.q);
            hashMap.put(e, this.s ? "1" : "-1");
            hashMap.put(f, this.r ? "1" : "-1");
            hashMap.put(g, this.t ? "1" : "-1");
            hashMap.put(h, this.u);
            hashMap.put(i, this.v);
            hashMap.put(j, this.w);
            hashMap.put(k, this.x);
            hashMap.put("tpl", this.y);
            hashMap.put(m, PassBiometricUtil.getClientId(LoadSo.this.c));
            hashMap.put(n, PassBiometricUtil.getOSModel());
            hashMap.put(o, PassBiometricUtil.getOSVersion());
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            com.baidu.pass.biometrics.base.utils.StatService.onEvent(LoadSo.this.c, f2745a, a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Context context, Bundle bundle) {
        this.c = context;
        this.d = new StatService();
        this.d.p = "3.0.0";
        this.e = bundle;
        SdkConfigOptions bioOptions = LocalConfigOptions.getInstance(context).getBioOptions();
        try {
            if (bioOptions.globalEnable && bioOptions.enable && !a(context)) {
                if (bioOptions.updateFail) {
                    if ("3.0.0".compareTo(bioOptions.zipVersion) > 0) {
                        this.d.q = "3.0.0";
                        a();
                    } else {
                        a(bioOptions);
                    }
                } else {
                    a(bioOptions);
                }
                this.d.r = true;
                return true;
            }
            this.d.q = bioOptions.zipVersion;
            this.d.r = true;
            a();
            return true;
        } catch (Throwable th) {
            try {
                this.d.u = Log.getStackTraceString(th);
                this.d.v = this.d.q;
                this.d.r = false;
                return false;
            } finally {
                this.d.b();
            }
        }
    }

    private void a() {
        for (String str : b) {
            System.loadLibrary(str);
        }
        this.d.s = true;
    }

    private void a(SdkConfigOptions sdkConfigOptions) {
        String[] strArr;
        boolean z = true;
        try {
            int length = b.length;
            for (int i = 0; i < length; i++) {
                System.load(LocalConfigOptions.getLoadSoPath(this.c) + "/lib" + strArr[i] + PluginInstallerService.APK_LIB_SUFFIX);
            }
            this.d.q = sdkConfigOptions.zipVersion;
        } catch (Throwable th) {
            this.d.t = false;
            this.d.q = sdkConfigOptions.zipVersion;
            this.d.u = Log.getStackTraceString(th);
            this.d.v = sdkConfigOptions.zipVersion;
            z = false;
        }
        if (z) {
            return;
        }
        a();
    }

    static boolean a(Context context) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        arrayList.add("com.baidu.BaiduMap(.*)");
        for (String str : arrayList) {
            if (context.getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }
}
