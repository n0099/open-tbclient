package com.baidu.cyberplayer.sdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.a.a;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class b implements a.InterfaceC0054a {
    private static ClassLoader k = null;
    private static b l = null;
    private volatile int g;
    private long a = 0;
    private int b = 0;
    private Context c = null;
    private String d = SDKVersion.VERSION;
    private String e = null;
    private String f = "https://b.bdstatic.com/searchbox/androidvideo";
    private Map<String, String> h = null;
    private ArrayList<String> i = null;
    private CyberPlayerManager.InstallListener j = null;

    private b() {
    }

    private synchronized int a(String str, int i) {
        String string = d().getString(str, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                i = Integer.parseInt(string);
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public static b a() {
        if (l == null) {
            synchronized (b.class) {
                if (l == null) {
                    l = new b();
                }
            }
        }
        return l;
    }

    private void a(int i) {
        if (this.j != null) {
            this.j.onInstallProgress(this.g, i);
        }
    }

    private void a(int i, String str) {
        if (this.j != null) {
            this.j.onInstallError(this.g, i, str);
        }
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new com.baidu.cyberplayer.sdk.a.a().a(this.f, str + ".zip", this.e, this);
    }

    private synchronized void a(String str, String str2) {
        SharedPreferences.Editor edit = d().edit();
        edit.putString(str, str2);
        edit.apply();
    }

    private synchronized String b(String str, String str2) {
        return d().getString(str, str2);
    }

    private void b() {
        this.e = Utils.a() + File.separator + "cybermedia" + File.separator + "libs";
        File file = new File(this.e);
        if (!file.exists()) {
            try {
                file.mkdirs();
                return;
            } catch (Exception e) {
                return;
            }
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].getName().split("\\.").length == 4) {
                    Utils.b(listFiles[i]);
                }
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0107 -> B:31:0x0024). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0109 -> B:31:0x0024). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0187 -> B:31:0x0024). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0189 -> B:31:0x0024). Please submit an issue!!! */
    private void c() {
        CyberLog.d("CyberCoreLoader", "tryLoadCore:" + this.g);
        if (com.baidu.cyberplayer.sdk.c.a(this.g)) {
            return;
        }
        if (!com.baidu.cyberplayer.sdk.c.e()) {
            this.d = CyberCfgManager.getInstance().getCfgValue("update_core_ver", SDKVersion.VERSION);
            String str = this.e + File.separator + "cyber-media-dex" + File.separator + this.d;
            File file = new File(str, "cyber-media-dex.jar");
            if (file.exists()) {
                CyberLog.d("CyberCoreLoader", "try load from extend:" + file.getAbsolutePath());
                k = new a(file.getAbsolutePath(), new File(str), null, this.c.getClassLoader());
            } else if (!this.d.equals(SDKVersion.VERSION)) {
                if (e()) {
                    a("cyber-media-all-" + this.d);
                    return;
                }
                return;
            } else {
                k = this.c.getClassLoader();
            }
        }
        try {
            if (com.baidu.cyberplayer.sdk.c.a(this.c, k, this.g, this.h)) {
                g();
                CyberLog.d("CyberCoreLoader", "load success curVer:" + com.baidu.cyberplayer.sdk.c.b() + " installType:" + this.g);
            } else {
                a(-4, com.baidu.cyberplayer.sdk.c.a());
            }
        } catch (FileNotFoundException e) {
            CyberLog.d("CyberCoreLoader", "FileNotFoundException:" + e.getMessage());
            if (e()) {
                a(e.getMessage());
            }
        } catch (ClassNotFoundException e2) {
            CyberLog.d("CyberCoreLoader", "ClassNotFoundException:" + e2.getMessage());
            if (e()) {
                a("cyber-media-all-" + this.d);
            }
        }
    }

    private SharedPreferences d() {
        return this.c.getSharedPreferences("video_cfg", 0);
    }

    private boolean e() {
        if (CyberCfgManager.getInstance().a()) {
            CyberLog.d("CyberCoreLoader", "cancel download isSFSwitchEnabled");
            a(-4, "cancel download isSFSwitchEnabled");
            return false;
        }
        this.b = a("success-download-core-count", 0);
        if (this.b >= 8) {
            CyberLog.w("CyberCoreLoader", "Achieve max success download time:8");
            a(-1, "Achieve max success download time");
            return false;
        } else if (Utils.d() < 20971520) {
            a(-1, "storagespace not enough " + Utils.d());
            return false;
        } else {
            return true;
        }
    }

    private boolean f() {
        String f = Utils.f();
        return f.contains("armv7-neon") || f.contains("AArch64");
    }

    private void g() {
        if (this.j != null) {
            this.j.onInstallSuccess(this.g, com.baidu.cyberplayer.sdk.c.b());
        }
    }

    public synchronized void a(String str, int i, Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        this.g = i;
        this.h = map;
        if (f()) {
            CyberLog.d("CyberCoreLoader", "InstallTask:" + i + " start");
            CyberCfgManager.getInstance().init();
            if (!TextUtils.isEmpty(str)) {
                this.f = str;
            }
            String cfgValue = CyberCfgManager.getInstance().getCfgValue("update_core_server", "");
            if (!TextUtils.isEmpty(cfgValue)) {
                this.f = cfgValue;
            }
            this.j = installListener;
            this.c = CyberPlayerManager.getApplicationContext();
            String c = Utils.c();
            if (!c.equals(b("success-download-core-time", null))) {
                a("success-download-core-count", Integer.toString(0));
                a("success-download-core-time", c);
            }
            b();
            c();
            CyberLog.d("CyberCoreLoader", "InstallTask:" + i + " end");
        } else if (installListener != null) {
            a(-5, "cpu not support:" + Utils.f());
        }
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0054a
    public void a(String str, long j) {
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0054a
    public void a(String str, long j, int i, String str2) {
        CyberLog.d("CyberCoreLoader", "srcUrl:" + str + " detail:" + str2);
        if (i != -1) {
            this.b++;
            a("success-download-core-count", Integer.toString(this.b));
        }
        a(i, str2);
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0054a
    public void a(String str, long j, long j2) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (valueOf.longValue() - this.a > 500) {
            float f = (((float) j) / ((float) j2)) * 99.0f;
            a((int) f);
            this.a = valueOf.longValue();
            CyberLog.d("CyberCoreLoader", "onDownloading:" + ((int) f) + "%");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0054a
    public void a(String str, long j, ArrayList<String> arrayList) {
        this.i = arrayList;
        this.b++;
        a("success-download-core-count", Integer.toString(this.b));
        CyberLog.d("CyberCoreLoader", "onDownloadSuccess:" + this.i);
        c();
    }
}
