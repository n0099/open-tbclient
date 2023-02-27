package com.baidu.cyberplayer.sdk.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.c;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.d;
import com.baidu.cyberplayer.sdk.downloader.a;
import com.baidu.cyberplayer.sdk.o;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes2.dex */
public class a implements a.InterfaceC0089a {
    public static ClassLoader m;
    public static a n;
    public volatile int i;
    public long a = 0;
    public int b = 0;
    public Context c = null;
    public String d = SDKVersion.VERSION;
    public String e = null;
    public String f = null;
    public String g = null;
    public boolean h = false;
    public Map<String, String> j = null;
    public ArrayList<String> k = null;
    public CyberPlayerManager.InstallListener2 l = null;
    public long o = -1;
    public long p = -1;
    public long q = -1;

    private synchronized int a(String str, int i) {
        String string = d().getString(str, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                i = Integer.parseInt(string);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public static a a() {
        if (n == null) {
            synchronized (a.class) {
                if (n == null) {
                    n = new a();
                }
            }
        }
        return n;
    }

    private void a(int i, String str) {
        if (h()) {
            c();
            return;
        }
        CyberPlayerManager.InstallListener2 installListener2 = this.l;
        if (installListener2 != null) {
            installListener2.onInstallError(this.i, i, str);
        }
        if (i == -4 || !o.m()) {
            return;
        }
        CyberCfgManager.getInstance().setPrefInt("install_error_count", 0);
    }

    private void a(String str) {
        String str2;
        String str3;
        if (e() && !TextUtils.isEmpty(str)) {
            com.baidu.cyberplayer.sdk.downloader.a aVar = new com.baidu.cyberplayer.sdk.downloader.a();
            if (str.startsWith("model_")) {
                str2 = this.g;
                str3 = this.f;
            } else {
                str2 = this.g;
                str3 = this.e;
            }
            aVar.a(str2, str, str3, this);
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

    private void b(int i) {
        CyberPlayerManager.InstallListener2 installListener2 = this.l;
        if (installListener2 != null) {
            installListener2.onInstallProgress(this.i, i);
        }
    }

    private void c() {
        StringBuilder sb;
        ClassLoader classLoader;
        long currentTimeMillis = System.currentTimeMillis();
        CyberLog.d("CyberCoreLoader", "tryLoadCore:" + this.i);
        if (d.a(this.i)) {
            return;
        }
        if (!d.g()) {
            this.d = CyberCoreLoaderManager.a().b();
            i();
            File file = new File(this.e, "cyber-media-dex_" + this.d + ".jar");
            if (file.exists()) {
                CyberLog.d("CyberCoreLoader", "try load from extend:" + file.getAbsolutePath());
                classLoader = new CyberClassLoader(file.getAbsolutePath(), new File(this.e), null, this.c.getClassLoader());
            } else if (!this.d.equals(SDKVersion.VERSION)) {
                sb = new StringBuilder();
                sb.append(o.o());
                sb.append("_cyber-media-dex_");
                sb.append(this.d);
                sb.append(".zip");
                a(sb.toString());
                return;
            } else {
                classLoader = this.c.getClassLoader();
            }
            m = classLoader;
            try {
                d.a(this.c, m, this.f, this.l);
                this.o = System.currentTimeMillis() - currentTimeMillis;
            } catch (Exception unused) {
                m = null;
                sb = new StringBuilder();
            }
        }
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (d.a(this.i, this.j)) {
                this.p = System.currentTimeMillis() - currentTimeMillis2;
                g();
                CyberLog.d("CyberCoreLoader", "load success curVer:" + d.a() + " installType:" + this.i);
            }
        } catch (FileNotFoundException e) {
            CyberLog.d("CyberCoreLoader", "FileNotFoundException:" + e.getMessage());
            a(e.getMessage());
        } catch (Error e2) {
            CyberLog.w("CyberCoreLoader", "loadLibs Error:" + e2.getMessage());
        } catch (Exception e3) {
            CyberLog.w("CyberCoreLoader", "loadLibs Exception:" + e3.getMessage());
            a(-4, e3.getMessage());
        }
    }

    private SharedPreferences d() {
        return this.c.getSharedPreferences("video_cfg", 0);
    }

    private boolean e() {
        if (!c.a().h()) {
            CyberLog.d("CyberCoreLoader", "cancel download isSFSwitchEnabled");
            a(-4, "cancel download isSFSwitchEnabled");
            return false;
        }
        int a = a("success-download-core-count", 0);
        this.b = a;
        if (a >= 36) {
            CyberLog.w("CyberCoreLoader", "Achieve max success download time:36");
            a(-1, "Achieve max success download time");
            return false;
        } else if (o.e() < DownloadManager.MIN_LEFT_SIZE) {
            a(-1, "storagespace not enough " + o.e());
            return false;
        } else {
            return true;
        }
    }

    private boolean f() {
        String g = o.g();
        return g.contains("armv7-neon") || g.contains("AArch64") || g.contains("arm64");
    }

    private void g() {
        CyberPlayerManager.InstallListener2 installListener2 = this.l;
        if (installListener2 != null) {
            installListener2.onInstallSuccess(this.i, d.a());
        }
        if (o.m()) {
            CyberCfgManager.getInstance().setPrefInt("install_error_count", 0);
        }
    }

    private boolean h() {
        if (this.h) {
            return false;
        }
        if (SDKVersion.VERSION.equals(this.d)) {
            if (d.k()) {
                this.h = true;
                return true;
            }
            return false;
        } else if (!this.d.equals(d.a()) && CyberCfgManager.getInstance().getCfgBoolValue("update_core_enable_downgrade", true)) {
            this.d = SDKVersion.VERSION;
            this.h = true;
            return true;
        } else {
            return false;
        }
    }

    private void i() {
        if (o.m()) {
            CyberCfgManager.getInstance().setPrefInt("install_error_count", CyberCfgManager.getInstance().getPrefInt("install_error_count", 0) + 1);
            if (SDKVersion.VERSION.equals(this.d)) {
                return;
            }
            CyberCfgManager.getInstance().setPrefStr("update_type", "cyber-media-dex");
            CyberCfgManager.getInstance().setPrefStr("update_version", this.d);
        }
    }

    public long a(int i) {
        if (i == 0) {
            return this.o;
        }
        if (i == 1) {
            return this.p;
        }
        if (i == 2) {
            return this.q;
        }
        return -1L;
    }

    public synchronized void a(String str, int i, Map<String, String> map, CyberPlayerManager.InstallListener2 installListener2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.i = i;
        this.j = map;
        if (!f()) {
            if (installListener2 != null) {
                a(-5, "cpu not support:" + o.g());
            }
            return;
        }
        CyberLog.d("CyberCoreLoader", "InstallTask:" + i + " start");
        CyberCfgManager.getInstance().init();
        this.q = System.currentTimeMillis() - currentTimeMillis;
        this.g = c.a().a(str);
        this.l = installListener2;
        this.c = CyberPlayerManager.getApplicationContext();
        String d = o.d();
        if (!d.equals(b("success-download-core-time", null))) {
            a("success-download-core-count", Integer.toString(0));
            a("success-download-core-time", d);
        }
        this.f = o.b();
        this.e = this.f + File.separator + "libs";
        c();
        CyberLog.d("CyberCoreLoader", "InstallTask:" + i + " end");
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0089a
    public void a(String str, long j) {
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0089a
    public void a(String str, long j, int i, String str2) {
        CyberLog.d("CyberCoreLoader", "srcUrl:" + str + " detail:" + str2);
        if (i != -1) {
            int i2 = this.b + 1;
            this.b = i2;
            a("success-download-core-count", Integer.toString(i2));
        }
        a(i, str2);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0089a
    public void a(String str, long j, long j2) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (valueOf.longValue() - this.a > 500) {
            int i = (int) ((((float) j) / ((float) j2)) * 99.0f);
            b(i);
            this.a = valueOf.longValue();
            CyberLog.d("CyberCoreLoader", "onDownloading:" + i + "%");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0089a
    public void a(String str, long j, ArrayList<String> arrayList) {
        this.k = arrayList;
        int i = this.b + 1;
        this.b = i;
        a("success-download-core-count", Integer.toString(i));
        CyberLog.d("CyberCoreLoader", "onDownloadSuccess:" + this.k);
        c();
    }

    public boolean b() {
        return this.h;
    }
}
