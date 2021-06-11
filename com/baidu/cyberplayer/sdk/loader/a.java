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
public class a implements a.InterfaceC0072a {
    public static ClassLoader m;
    public static a n;

    /* renamed from: i  reason: collision with root package name */
    public volatile int f4926i;

    /* renamed from: a  reason: collision with root package name */
    public long f4918a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f4919b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Context f4920c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f4921d = SDKVersion.VERSION;

    /* renamed from: e  reason: collision with root package name */
    public String f4922e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f4923f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f4924g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4925h = false;
    public Map<String, String> j = null;
    public ArrayList<String> k = null;
    public CyberPlayerManager.InstallListener l = null;

    private synchronized int a(String str, int i2) {
        String string = d().getString(str, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                i2 = Integer.parseInt(string);
            } catch (NumberFormatException unused) {
            }
        }
        return i2;
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

    private void a(int i2) {
        CyberPlayerManager.InstallListener installListener = this.l;
        if (installListener != null) {
            installListener.onInstallProgress(this.f4926i, i2);
        }
    }

    private void a(int i2, String str) {
        if (h()) {
            c();
            return;
        }
        CyberPlayerManager.InstallListener installListener = this.l;
        if (installListener != null) {
            installListener.onInstallError(this.f4926i, i2, str);
        }
        if (i2 == -4 || !o.m()) {
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
                str2 = this.f4924g;
                str3 = this.f4923f;
            } else {
                str2 = this.f4924g;
                str3 = this.f4922e;
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

    private void c() {
        StringBuilder sb;
        ClassLoader classLoader;
        CyberLog.d("CyberCoreLoader", "tryLoadCore:" + this.f4926i);
        if (d.a(this.f4926i)) {
            return;
        }
        if (!d.g()) {
            this.f4921d = CyberCoreLoaderManager.a().b();
            i();
            File file = new File(this.f4922e, "cyber-media-dex_" + this.f4921d + ".jar");
            if (file.exists()) {
                CyberLog.d("CyberCoreLoader", "try load from extend:" + file.getAbsolutePath());
                classLoader = new CyberClassLoader(file.getAbsolutePath(), new File(this.f4922e), null, this.f4920c.getClassLoader());
            } else if (!this.f4921d.equals(SDKVersion.VERSION)) {
                sb = new StringBuilder();
                sb.append(o.o());
                sb.append("_cyber-media-dex_");
                sb.append(this.f4921d);
                sb.append(".zip");
                a(sb.toString());
                return;
            } else {
                classLoader = this.f4920c.getClassLoader();
            }
            m = classLoader;
            try {
                d.a(this.f4920c, m, this.f4923f);
            } catch (Exception unused) {
                m = null;
                sb = new StringBuilder();
            }
        }
        try {
            if (d.a(this.f4926i, this.j)) {
                g();
                CyberLog.d("CyberCoreLoader", "load success curVer:" + d.a() + " installType:" + this.f4926i);
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
        return this.f4920c.getSharedPreferences("video_cfg", 0);
    }

    private boolean e() {
        if (!c.a().h()) {
            CyberLog.d("CyberCoreLoader", "cancel download isSFSwitchEnabled");
            a(-4, "cancel download isSFSwitchEnabled");
            return false;
        }
        int a2 = a("success-download-core-count", 0);
        this.f4919b = a2;
        if (a2 >= 12) {
            CyberLog.w("CyberCoreLoader", "Achieve max success download time:12");
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
        String g2 = o.g();
        return g2.contains("armv7-neon") || g2.contains("AArch64") || g2.contains("arm64");
    }

    private void g() {
        CyberPlayerManager.InstallListener installListener = this.l;
        if (installListener != null) {
            installListener.onInstallSuccess(this.f4926i, d.a());
        }
        if (o.m()) {
            CyberCfgManager.getInstance().setPrefInt("install_error_count", 0);
        }
    }

    private boolean h() {
        if (this.f4925h) {
            return false;
        }
        if (SDKVersion.VERSION.equals(this.f4921d)) {
            if (d.k()) {
                this.f4925h = true;
                return true;
            }
            return false;
        } else if (!this.f4921d.equals(d.a()) && CyberCfgManager.getInstance().getCfgBoolValue("update_core_enable_downgrade", true)) {
            this.f4921d = SDKVersion.VERSION;
            this.f4925h = true;
            return true;
        } else {
            return false;
        }
    }

    private void i() {
        if (o.m()) {
            CyberCfgManager.getInstance().setPrefInt("install_error_count", CyberCfgManager.getInstance().getPrefInt("install_error_count", 0) + 1);
            if (SDKVersion.VERSION.equals(this.f4921d)) {
                return;
            }
            CyberCfgManager.getInstance().setPrefStr(CyberCfgManager.SP_KEY_UPDATE_TYPE, "cyber-media-dex");
            CyberCfgManager.getInstance().setPrefStr("update_version", this.f4921d);
        }
    }

    public synchronized void a(String str, int i2, Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        this.f4926i = i2;
        this.j = map;
        if (!f()) {
            if (installListener != null) {
                a(-5, "cpu not support:" + o.g());
            }
            return;
        }
        CyberLog.d("CyberCoreLoader", "InstallTask:" + i2 + " start");
        CyberCfgManager.getInstance().init();
        this.f4924g = c.a().a(str);
        this.l = installListener;
        this.f4920c = CyberPlayerManager.getApplicationContext();
        String d2 = o.d();
        if (!d2.equals(b("success-download-core-time", null))) {
            a("success-download-core-count", Integer.toString(0));
            a("success-download-core-time", d2);
        }
        this.f4923f = o.b();
        this.f4922e = this.f4923f + File.separator + "libs";
        c();
        CyberLog.d("CyberCoreLoader", "InstallTask:" + i2 + " end");
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0072a
    public void a(String str, long j) {
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0072a
    public void a(String str, long j, int i2, String str2) {
        CyberLog.d("CyberCoreLoader", "srcUrl:" + str + " detail:" + str2);
        if (i2 != -1) {
            int i3 = this.f4919b + 1;
            this.f4919b = i3;
            a("success-download-core-count", Integer.toString(i3));
        }
        a(i2, str2);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0072a
    public void a(String str, long j, long j2) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (valueOf.longValue() - this.f4918a > 500) {
            int i2 = (int) ((((float) j) / ((float) j2)) * 99.0f);
            a(i2);
            this.f4918a = valueOf.longValue();
            CyberLog.d("CyberCoreLoader", "onDownloading:" + i2 + "%");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0072a
    public void a(String str, long j, ArrayList<String> arrayList) {
        this.k = arrayList;
        int i2 = this.f4919b + 1;
        this.f4919b = i2;
        a("success-download-core-count", Integer.toString(i2));
        CyberLog.d("CyberCoreLoader", "onDownloadSuccess:" + this.k);
        c();
    }

    public boolean b() {
        return this.f4925h;
    }
}
