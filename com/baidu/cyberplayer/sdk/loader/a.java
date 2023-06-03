package com.baidu.cyberplayer.sdk.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.downloader.a;
import com.baidu.cyberplayer.sdk.e;
import com.baidu.cyberplayer.sdk.f;
import com.baidu.cyberplayer.sdk.q;
import com.baidu.cyberplayer.sdk.task.UpgradeInfo;
import com.baidu.cyberplayer.sdk.task.UpgradeTask;
import com.baidu.cyberplayer.sdk.task.UpgradeTaskManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements a.InterfaceC0092a {
    public static ClassLoader m;
    public static volatile a n;
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
    public volatile boolean r = false;
    public String s = null;
    public int t = 0;

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0092a
    public void a(String str, long j) {
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

    private SharedPreferences h() {
        return this.c.getSharedPreferences("video_cfg", 0);
    }

    private boolean j() {
        String g = q.g();
        if (!g.contains("armv7-neon") && !g.contains("AArch64") && !g.contains("arm64")) {
            return false;
        }
        return true;
    }

    private void k() {
        CyberPlayerManager.InstallListener2 installListener2 = this.l;
        if (installListener2 != null) {
            installListener2.onInstallSuccess(this.i, f.a());
        }
        if (q.o()) {
            CyberCfgManager.getInstance().setPrefInt("install_error_count", 0);
        }
    }

    public boolean b() {
        return this.h;
    }

    public String c() {
        return this.s;
    }

    public boolean d() {
        return this.r;
    }

    public int e() {
        return this.t;
    }

    private synchronized int a(String str, int i) {
        String string = h().getString(str, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                i = Integer.parseInt(string);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    private synchronized String b(String str, String str2) {
        return h().getString(str, str2);
    }

    private void a(int i, String str) {
        if (l()) {
            g();
            return;
        }
        CyberPlayerManager.InstallListener2 installListener2 = this.l;
        if (installListener2 != null) {
            installListener2.onInstallError(this.i, i, str);
        }
        if (i != -4 && q.o()) {
            CyberCfgManager.getInstance().setPrefInt("install_error_count", 0);
        }
    }

    private void a(String str) {
        if (i() && !TextUtils.isEmpty(str)) {
            com.baidu.cyberplayer.sdk.downloader.a aVar = new com.baidu.cyberplayer.sdk.downloader.a();
            String str2 = this.g;
            this.t++;
            if (this.r) {
                CyberLog.d("CyberCoreLoader", "download zip from xCDN");
                str2 = "https://pms-zeus-xcdn.bdstatic.com/searchbox/androidvideo";
            } else {
                CyberLog.d("CyberCoreLoader", "download zip from CDN");
            }
            if (str.startsWith("model_")) {
                aVar.a(str2, str, this.f, this);
            } else {
                aVar.a(str2, str, this.e, this);
            }
        }
    }

    private synchronized void a(String str, String str2) {
        SharedPreferences.Editor edit = h().edit();
        edit.putString(str, str2);
        edit.apply();
    }

    private void b(int i) {
        CyberPlayerManager.InstallListener2 installListener2 = this.l;
        if (installListener2 != null) {
            installListener2.onInstallProgress(this.i, i);
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

    private String f() {
        UpgradeInfo parse = UpgradeInfo.parse("cyber-media-dex");
        if (parse == null || !TextUtils.equals(parse.mLocalVersion, SDKVersion.VERSION)) {
            return SDKVersion.VERSION;
        }
        String str = "cyber-media-dex_" + parse.mUpgradeVersion + ".jar";
        File file = new File(this.e, str);
        CyberLog.e("CyberCoreLoader", "mLibsFolder:" + this.e + str);
        if (!file.exists() && !parse.mForceUpgrade) {
            if (!q.o()) {
                return SDKVersion.VERSION;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(q.q());
            sb.append("_cyber-media-dex_");
            sb.append(parse.mUpgradeVersion);
            if (!TextUtils.isEmpty(parse.mExtInfo)) {
                sb.append(parse.mExtInfo);
            }
            sb.append(".zip");
            HashMap hashMap = new HashMap();
            hashMap.put("saveDirectory", this.e);
            UpgradeTaskManager.getInstance().submitTask(new UpgradeTask(sb.toString(), hashMap));
            return parse.mLocalVersion;
        }
        return parse.mUpgradeVersion;
    }

    private void g() {
        long currentTimeMillis = System.currentTimeMillis();
        CyberLog.d("CyberCoreLoader", "tryLoadCore:" + this.i);
        if (f.a(this.i)) {
            return;
        }
        if (!f.g()) {
            if (CyberCfgManager.getInstance().getCfgBoolValue("enable_silent_download", false)) {
                this.d = f();
            } else {
                this.d = CyberCoreLoaderManager.a().c();
            }
            m();
            File file = new File(this.e, "cyber-media-dex_" + this.d + ".jar");
            if (file.exists()) {
                CyberLog.d("CyberCoreLoader", "try load from extend:" + file.getAbsolutePath());
                m = CyberClassLoader.createClassLoader(file.getAbsolutePath(), new File(this.e), null, this.c.getClassLoader());
            } else if (this.d.equals(SDKVersion.VERSION)) {
                m = this.c.getClassLoader();
            } else {
                a(q.q() + "_cyber-media-dex_" + this.d + ".zip");
                return;
            }
            try {
                f.a(this.c, m, this.f, this.l);
                this.o = System.currentTimeMillis() - currentTimeMillis;
            } catch (Exception unused) {
                m = null;
                a(q.q() + "_cyber-media-dex_" + this.d + ".zip");
                return;
            }
        }
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (f.a(this.i, this.j)) {
                this.p = System.currentTimeMillis() - currentTimeMillis2;
                k();
                CyberLog.d("CyberCoreLoader", "load success curVer:" + f.a() + " installType:" + this.i);
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

    private boolean i() {
        if (!e.a().i()) {
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
        } else if (q.e() < DownloadManager.MIN_LEFT_SIZE) {
            a(-1, "storagespace not enough " + q.e());
            return false;
        } else {
            return true;
        }
    }

    private boolean l() {
        if (this.h) {
            return false;
        }
        if (!SDKVersion.VERSION.equals(this.d)) {
            if (this.d.equals(f.a()) || !CyberCfgManager.getInstance().getCfgBoolValue("update_core_enable_downgrade", true)) {
                return false;
            }
            this.d = SDKVersion.VERSION;
            this.h = true;
            return true;
        } else if (!f.l()) {
            return false;
        } else {
            this.h = true;
            return true;
        }
    }

    private void m() {
        if (q.o()) {
            CyberCfgManager.getInstance().setPrefInt("install_error_count", CyberCfgManager.getInstance().getPrefInt("install_error_count", 0) + 1);
            if (!SDKVersion.VERSION.equals(this.d)) {
                CyberCfgManager.getInstance().setPrefStr("update_type", "cyber-media-dex");
                CyberCfgManager.getInstance().setPrefStr("update_version", this.d);
            }
        }
    }

    public synchronized void a(String str, int i, Map<String, String> map, CyberPlayerManager.InstallListener2 installListener2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.i = i;
        this.j = map;
        if (!j()) {
            if (installListener2 != null) {
                a(-5, "cpu not support:" + q.g());
            }
            return;
        }
        CyberLog.d("CyberCoreLoader", "InstallTask:" + i + " start");
        CyberCfgManager.getInstance().init();
        this.q = System.currentTimeMillis() - currentTimeMillis;
        CyberLog.b(CyberCfgManager.getInstance().getCfgIntValue("yalog_level", 6));
        this.g = e.a().a(str);
        this.r = CyberCfgManager.getInstance().getCfgBoolValue("enable_download_zip_xcdn", true);
        this.l = installListener2;
        this.c = CyberPlayerManager.getApplicationContext();
        String d = q.d();
        if (!d.equals(b("success-download-core-time", null))) {
            a("success-download-core-count", Integer.toString(0));
            a("success-download-core-time", d);
        }
        this.f = q.b();
        this.e = this.f + File.separator + "libs";
        g();
        CyberLog.d("CyberCoreLoader", "InstallTask:" + i + " end");
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0092a
    public void a(String str, long j, int i, String str2) {
        CyberLog.d("CyberCoreLoader", "srcUrl:" + str + " detail:" + str2);
        if (i != -1) {
            int i2 = this.b + 1;
            this.b = i2;
            a("success-download-core-count", Integer.toString(i2));
        } else if (this.r) {
            this.r = false;
            CyberLog.w("CyberCoreLoader", "xCDN degrade to CDN");
            this.s = str2;
            try {
                String path = new URL(str).getPath();
                a(path.substring(path.lastIndexOf(47) + 1));
                return;
            } catch (Exception e) {
                CyberLog.e("CyberCoreLoader", e.toString());
            }
        }
        a(i, str2);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0092a
    public void a(String str, long j, long j2) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (valueOf.longValue() - this.a > 500) {
            int i = (int) ((((float) j) / ((float) j2)) * 99.0f);
            b(i);
            this.a = valueOf.longValue();
            CyberLog.d("CyberCoreLoader", "onDownloading:" + i + "%");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0092a
    public void a(String str, long j, ArrayList<String> arrayList) {
        this.k = arrayList;
        int i = this.b + 1;
        this.b = i;
        a("success-download-core-count", Integer.toString(i));
        CyberLog.d("CyberCoreLoader", "onDownloadSuccess:" + this.k);
        g();
    }
}
