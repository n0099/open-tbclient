package com.baidu.cyberplayer.sdk.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.a.a;
import com.baidu.cyberplayer.sdk.c;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.d;
import com.baidu.cyberplayer.sdk.dlna.Dlna;
import com.baidu.cyberplayer.sdk.n;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes2.dex */
public class a implements a.InterfaceC0070a {
    public static ClassLoader l;
    public static a m;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f5145h;

    /* renamed from: a  reason: collision with root package name */
    public long f5138a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f5139b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Context f5140c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f5141d = SDKVersion.VERSION;

    /* renamed from: e  reason: collision with root package name */
    public String f5142e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f5143f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f5144g = null;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f5146i = null;
    public ArrayList<String> j = null;
    public CyberPlayerManager.InstallListener k = null;

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
        if (m == null) {
            synchronized (a.class) {
                if (m == null) {
                    m = new a();
                }
            }
        }
        return m;
    }

    private void a(int i2) {
        CyberPlayerManager.InstallListener installListener = this.k;
        if (installListener != null) {
            installListener.onInstallProgress(this.f5145h, i2);
        }
    }

    private void a(int i2, String str) {
        CyberPlayerManager.InstallListener installListener = this.k;
        if (installListener != null) {
            installListener.onInstallError(this.f5145h, i2, str);
        }
    }

    private void a(String str) {
        String str2;
        String str3;
        if (e() && !TextUtils.isEmpty(str)) {
            com.baidu.cyberplayer.sdk.a.a aVar = new com.baidu.cyberplayer.sdk.a.a();
            if (str.startsWith("model_")) {
                str2 = this.f5144g;
                str3 = this.f5143f;
            } else {
                str2 = this.f5144g;
                str3 = this.f5142e;
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

    private void b() {
        String cfgValue = CyberCfgManager.getInstance().getCfgValue("core_external_path", "");
        if (TextUtils.isEmpty(cfgValue) || !new File(cfgValue).exists()) {
            return;
        }
        String a2 = com.baidu.cyberplayer.sdk.a.a.a(cfgValue, this.f5143f);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        this.f5141d = a2;
    }

    private void c() {
        StringBuilder sb;
        ClassLoader classLoader;
        CyberLog.d("CyberCoreLoader", "tryLoadCore:" + this.f5145h);
        if (d.a(this.f5145h)) {
            return;
        }
        if (!d.g()) {
            this.f5141d = CyberCfgManager.getInstance().getCfgValue("update_core_ver", SDKVersion.VERSION);
            b();
            File file = new File(this.f5142e, "cyber-media-dex_" + this.f5141d + ".jar");
            if (file.exists()) {
                CyberLog.d("CyberCoreLoader", "try load from extend:" + file.getAbsolutePath());
                classLoader = new CyberClassLoader(file.getAbsolutePath(), new File(this.f5142e), null, this.f5140c.getClassLoader());
            } else if (!this.f5141d.equals(SDKVersion.VERSION)) {
                sb = new StringBuilder();
                sb.append(n.o());
                sb.append("_cyber-media-dex_");
                sb.append(this.f5141d);
                sb.append(".zip");
                a(sb.toString());
                return;
            } else {
                classLoader = this.f5140c.getClassLoader();
            }
            l = classLoader;
            try {
                d.a(this.f5140c, l, this.f5143f);
                Dlna.init(l);
            } catch (Exception unused) {
                l = null;
                sb = new StringBuilder();
            }
        }
        try {
            if (d.a(this.f5145h, this.f5146i)) {
                g();
                CyberLog.d("CyberCoreLoader", "load success curVer:" + d.a() + " installType:" + this.f5145h);
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
        return this.f5140c.getSharedPreferences("video_cfg", 0);
    }

    private boolean e() {
        if (!c.a().f()) {
            CyberLog.d("CyberCoreLoader", "cancel download isSFSwitchEnabled");
            a(-4, "cancel download isSFSwitchEnabled");
            return false;
        }
        int a2 = a("success-download-core-count", 0);
        this.f5139b = a2;
        if (a2 >= 12) {
            CyberLog.w("CyberCoreLoader", "Achieve max success download time:12");
            a(-1, "Achieve max success download time");
            return false;
        } else if (n.e() < DownloadManager.MIN_LEFT_SIZE) {
            a(-1, "storagespace not enough " + n.e());
            return false;
        } else {
            return true;
        }
    }

    private boolean f() {
        String g2 = n.g();
        return g2.contains("armv7-neon") || g2.contains("AArch64") || g2.contains("arm64");
    }

    private void g() {
        CyberPlayerManager.InstallListener installListener = this.k;
        if (installListener != null) {
            installListener.onInstallSuccess(this.f5145h, d.a());
        }
    }

    public synchronized void a(String str, int i2, Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        this.f5145h = i2;
        this.f5146i = map;
        if (!f()) {
            if (installListener != null) {
                a(-5, "cpu not support:" + n.g());
            }
            return;
        }
        CyberLog.d("CyberCoreLoader", "InstallTask:" + i2 + " start");
        CyberCfgManager.getInstance().init();
        this.f5144g = c.a().a(str);
        this.k = installListener;
        this.f5140c = CyberPlayerManager.getApplicationContext();
        String d2 = n.d();
        if (!d2.equals(b("success-download-core-time", null))) {
            a("success-download-core-count", Integer.toString(0));
            a("success-download-core-time", d2);
        }
        this.f5143f = n.b();
        this.f5142e = this.f5143f + File.separator + "libs";
        c();
        CyberLog.d("CyberCoreLoader", "InstallTask:" + i2 + " end");
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0070a
    public void a(String str, long j) {
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0070a
    public void a(String str, long j, int i2, String str2) {
        CyberLog.d("CyberCoreLoader", "srcUrl:" + str + " detail:" + str2);
        if (i2 != -1) {
            int i3 = this.f5139b + 1;
            this.f5139b = i3;
            a("success-download-core-count", Integer.toString(i3));
        }
        a(i2, str2);
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0070a
    public void a(String str, long j, long j2) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (valueOf.longValue() - this.f5138a > 500) {
            int i2 = (int) ((((float) j) / ((float) j2)) * 99.0f);
            a(i2);
            this.f5138a = valueOf.longValue();
            CyberLog.d("CyberCoreLoader", "onDownloading:" + i2 + "%");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0070a
    public void a(String str, long j, ArrayList<String> arrayList) {
        this.j = arrayList;
        int i2 = this.f5139b + 1;
        this.f5139b = i2;
        a("success-download-core-count", Integer.toString(i2));
        CyberLog.d("CyberCoreLoader", "onDownloadSuccess:" + this.j);
        c();
    }
}
