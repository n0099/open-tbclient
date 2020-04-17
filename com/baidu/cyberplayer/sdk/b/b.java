package com.baidu.cyberplayer.sdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.a.a;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.d;
import com.baidu.cyberplayer.sdk.dlna.Dlna;
import com.baidu.cyberplayer.sdk.m;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class b implements a.InterfaceC0082a {
    private static ClassLoader l = null;
    private static b m = null;
    private volatile int h;
    private long a = 0;
    private int b = 0;
    private Context c = null;
    private String d = SDKVersion.VERSION;
    private String e = null;
    private String f = null;
    private String g = null;
    private Map<String, String> i = null;
    private ArrayList<String> j = null;
    private CyberPlayerManager.InstallListener k = null;

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
        if (m == null) {
            synchronized (b.class) {
                if (m == null) {
                    m = new b();
                }
            }
        }
        return m;
    }

    private void a(int i) {
        if (this.k != null) {
            this.k.onInstallProgress(this.h, i);
        }
    }

    private void a(int i, String str) {
        if (this.k != null) {
            this.k.onInstallError(this.h, i, str);
        }
    }

    private void a(String str) {
        if (e() && !TextUtils.isEmpty(str)) {
            com.baidu.cyberplayer.sdk.a.a aVar = new com.baidu.cyberplayer.sdk.a.a();
            if (str.startsWith("model_")) {
                aVar.a(this.g, str, this.f, this);
            } else {
                aVar.a(this.g, str, this.e, this);
            }
        }
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
        String cfgValue = CyberCfgManager.getInstance().getCfgValue("core_external_path", "");
        if (TextUtils.isEmpty(cfgValue) || !new File(cfgValue).exists()) {
            return;
        }
        String a = com.baidu.cyberplayer.sdk.a.a.a(cfgValue, this.f);
        if (TextUtils.isEmpty(a)) {
            return;
        }
        this.d = a;
    }

    private void c() {
        CyberLog.d("CyberCoreLoader", "tryLoadCore:" + this.h);
        if (d.a(this.h)) {
            return;
        }
        if (!d.e()) {
            this.d = CyberCfgManager.getInstance().getCfgValue("update_core_ver", SDKVersion.VERSION);
            b();
            File file = new File(this.e, "cyber-media-dex_" + this.d + ".jar");
            if (file.exists()) {
                CyberLog.d("CyberCoreLoader", "try load from extend:" + file.getAbsolutePath());
                l = new a(file.getAbsolutePath(), new File(this.e), null, this.c.getClassLoader());
            } else if (!this.d.equals(SDKVersion.VERSION)) {
                a(m.o() + "_cyber-media-dex_" + this.d + ".zip");
                return;
            } else {
                l = this.c.getClassLoader();
            }
            try {
                d.a(this.c, l, this.f);
                Dlna.init(l);
            } catch (Exception e) {
                l = null;
                a(m.o() + "_cyber-media-dex_" + this.d + ".zip");
                return;
            }
        }
        try {
            if (d.a(this.h, this.i)) {
                g();
                CyberLog.d("CyberCoreLoader", "load success curVer:" + d.a() + " installType:" + this.h);
            }
        } catch (FileNotFoundException e2) {
            CyberLog.d("CyberCoreLoader", "FileNotFoundException:" + e2.getMessage());
            a(e2.getMessage());
        } catch (Error e3) {
            CyberLog.w("CyberCoreLoader", "loadLibs Error:" + e3.getMessage());
        } catch (Exception e4) {
            CyberLog.w("CyberCoreLoader", "loadLibs Exception:" + e4.getMessage());
            a(-4, e4.getMessage());
        }
    }

    private SharedPreferences d() {
        return this.c.getSharedPreferences("video_cfg", 0);
    }

    private boolean e() {
        if (!com.baidu.cyberplayer.sdk.c.a().f()) {
            CyberLog.d("CyberCoreLoader", "cancel download isSFSwitchEnabled");
            a(-4, "cancel download isSFSwitchEnabled");
            return false;
        }
        this.b = a("success-download-core-count", 0);
        if (this.b >= 12) {
            CyberLog.w("CyberCoreLoader", "Achieve max success download time:12");
            a(-1, "Achieve max success download time");
            return false;
        } else if (m.e() < 20971520) {
            a(-1, "storagespace not enough " + m.e());
            return false;
        } else {
            return true;
        }
    }

    private boolean f() {
        String g = m.g();
        return g.contains("armv7-neon") || g.contains("AArch64") || g.contains("arm64");
    }

    private void g() {
        if (this.k != null) {
            this.k.onInstallSuccess(this.h, d.a());
        }
    }

    public synchronized void a(String str, int i, Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        this.h = i;
        this.i = map;
        if (f()) {
            CyberLog.d("CyberCoreLoader", "InstallTask:" + i + " start");
            CyberCfgManager.getInstance().init();
            this.g = com.baidu.cyberplayer.sdk.c.a().a(str);
            this.k = installListener;
            this.c = CyberPlayerManager.getApplicationContext();
            String d = m.d();
            if (!d.equals(b("success-download-core-time", null))) {
                a("success-download-core-count", Integer.toString(0));
                a("success-download-core-time", d);
            }
            this.f = m.b();
            this.e = this.f + File.separator + "libs";
            c();
            CyberLog.d("CyberCoreLoader", "InstallTask:" + i + " end");
        } else if (installListener != null) {
            a(-5, "cpu not support:" + m.g());
        }
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0082a
    public void a(String str, long j) {
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0082a
    public void a(String str, long j, int i, String str2) {
        CyberLog.d("CyberCoreLoader", "srcUrl:" + str + " detail:" + str2);
        if (i != -1) {
            this.b++;
            a("success-download-core-count", Integer.toString(this.b));
        }
        a(i, str2);
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0082a
    public void a(String str, long j, long j2) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (valueOf.longValue() - this.a > 500) {
            float f = (((float) j) / ((float) j2)) * 99.0f;
            a((int) f);
            this.a = valueOf.longValue();
            CyberLog.d("CyberCoreLoader", "onDownloading:" + ((int) f) + "%");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0082a
    public void a(String str, long j, ArrayList<String> arrayList) {
        this.j = arrayList;
        this.b++;
        a("success-download-core-count", Integer.toString(this.b));
        CyberLog.d("CyberCoreLoader", "onDownloadSuccess:" + this.j);
        c();
    }
}
