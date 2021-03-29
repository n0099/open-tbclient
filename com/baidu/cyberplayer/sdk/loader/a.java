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
/* loaded from: classes.dex */
public class a implements a.InterfaceC0071a {
    public static ClassLoader l;
    public static a m;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f4984h;

    /* renamed from: a  reason: collision with root package name */
    public long f4977a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f4978b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Context f4979c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f4980d = SDKVersion.VERSION;

    /* renamed from: e  reason: collision with root package name */
    public String f4981e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f4982f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f4983g = null;
    public Map<String, String> i = null;
    public ArrayList<String> j = null;
    public CyberPlayerManager.InstallListener k = null;

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
        if (m == null) {
            synchronized (a.class) {
                if (m == null) {
                    m = new a();
                }
            }
        }
        return m;
    }

    private void a(int i) {
        CyberPlayerManager.InstallListener installListener = this.k;
        if (installListener != null) {
            installListener.onInstallProgress(this.f4984h, i);
        }
    }

    private void a(int i, String str) {
        CyberPlayerManager.InstallListener installListener = this.k;
        if (installListener != null) {
            installListener.onInstallError(this.f4984h, i, str);
        }
    }

    private void a(String str) {
        String str2;
        String str3;
        if (e() && !TextUtils.isEmpty(str)) {
            com.baidu.cyberplayer.sdk.a.a aVar = new com.baidu.cyberplayer.sdk.a.a();
            if (str.startsWith("model_")) {
                str2 = this.f4983g;
                str3 = this.f4982f;
            } else {
                str2 = this.f4983g;
                str3 = this.f4981e;
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
        String a2 = com.baidu.cyberplayer.sdk.a.a.a(cfgValue, this.f4982f);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        this.f4980d = a2;
    }

    private void c() {
        StringBuilder sb;
        ClassLoader classLoader;
        CyberLog.d("CyberCoreLoader", "tryLoadCore:" + this.f4984h);
        if (d.a(this.f4984h)) {
            return;
        }
        if (!d.g()) {
            this.f4980d = CyberCfgManager.getInstance().getCfgValue("update_core_ver", SDKVersion.VERSION);
            b();
            File file = new File(this.f4981e, "cyber-media-dex_" + this.f4980d + ".jar");
            if (file.exists()) {
                CyberLog.d("CyberCoreLoader", "try load from extend:" + file.getAbsolutePath());
                classLoader = new CyberClassLoader(file.getAbsolutePath(), new File(this.f4981e), null, this.f4979c.getClassLoader());
            } else if (!this.f4980d.equals(SDKVersion.VERSION)) {
                sb = new StringBuilder();
                sb.append(n.o());
                sb.append("_cyber-media-dex_");
                sb.append(this.f4980d);
                sb.append(".zip");
                a(sb.toString());
                return;
            } else {
                classLoader = this.f4979c.getClassLoader();
            }
            l = classLoader;
            try {
                d.a(this.f4979c, l, this.f4982f);
                Dlna.init(l);
            } catch (Exception unused) {
                l = null;
                sb = new StringBuilder();
            }
        }
        try {
            if (d.a(this.f4984h, this.i)) {
                g();
                CyberLog.d("CyberCoreLoader", "load success curVer:" + d.a() + " installType:" + this.f4984h);
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
        return this.f4979c.getSharedPreferences("video_cfg", 0);
    }

    private boolean e() {
        if (!c.a().f()) {
            CyberLog.d("CyberCoreLoader", "cancel download isSFSwitchEnabled");
            a(-4, "cancel download isSFSwitchEnabled");
            return false;
        }
        int a2 = a("success-download-core-count", 0);
        this.f4978b = a2;
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
            installListener.onInstallSuccess(this.f4984h, d.a());
        }
    }

    public synchronized void a(String str, int i, Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        this.f4984h = i;
        this.i = map;
        if (!f()) {
            if (installListener != null) {
                a(-5, "cpu not support:" + n.g());
            }
            return;
        }
        CyberLog.d("CyberCoreLoader", "InstallTask:" + i + " start");
        CyberCfgManager.getInstance().init();
        this.f4983g = c.a().a(str);
        this.k = installListener;
        this.f4979c = CyberPlayerManager.getApplicationContext();
        String d2 = n.d();
        if (!d2.equals(b("success-download-core-time", null))) {
            a("success-download-core-count", Integer.toString(0));
            a("success-download-core-time", d2);
        }
        this.f4982f = n.b();
        this.f4981e = this.f4982f + File.separator + "libs";
        c();
        CyberLog.d("CyberCoreLoader", "InstallTask:" + i + " end");
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0071a
    public void a(String str, long j) {
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0071a
    public void a(String str, long j, int i, String str2) {
        CyberLog.d("CyberCoreLoader", "srcUrl:" + str + " detail:" + str2);
        if (i != -1) {
            int i2 = this.f4978b + 1;
            this.f4978b = i2;
            a("success-download-core-count", Integer.toString(i2));
        }
        a(i, str2);
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0071a
    public void a(String str, long j, long j2) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (valueOf.longValue() - this.f4977a > 500) {
            int i = (int) ((((float) j) / ((float) j2)) * 99.0f);
            a(i);
            this.f4977a = valueOf.longValue();
            CyberLog.d("CyberCoreLoader", "onDownloading:" + i + "%");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.a.a.InterfaceC0071a
    public void a(String str, long j, ArrayList<String> arrayList) {
        this.j = arrayList;
        int i = this.f4978b + 1;
        this.f4978b = i;
        a("success-download-core-count", Integer.toString(i));
        CyberLog.d("CyberCoreLoader", "onDownloadSuccess:" + this.j);
        c();
    }
}
