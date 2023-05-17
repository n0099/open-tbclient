package com.baidu.cyberplayer.sdk.downloader;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.c;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.downloader.a;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class SilentDownloaderManager implements a.InterfaceC0092a {
    public static volatile SilentDownloaderManager a;
    public static volatile boolean d;
    public Context c;
    public String e;
    public String f;
    public String g;
    public int b = 0;
    public a h = null;
    public boolean i = true;
    public HashMap<String, String> k = new HashMap<>();
    public Map<String, String> j = new HashMap();

    /* loaded from: classes3.dex */
    public enum a {
        CORE,
        LIBS_INFO_DEF_PRO,
        LIB
    }

    public SilentDownloaderManager() {
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.e = c.a().a((String) null);
        this.g = o.b();
        this.f = this.g + File.separator + "libs";
        this.c = CyberPlayerManager.getApplicationContext();
        String d2 = o.d();
        if (d2.equals(d("silent_download_success_time", null))) {
            return;
        }
        c("silent_download_success_count", Integer.toString(0));
        c("silent_download_success_time", d2);
    }

    private synchronized int a(String str, int i) {
        String string = e().getString(str, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                i = Integer.parseInt(string);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    private void a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) || !TextUtils.isEmpty(entry.getValue())) {
                c(b(entry.getKey(), entry.getValue()));
                if (!this.i) {
                    return;
                }
            }
        }
    }

    private boolean a(String str, String str2) {
        try {
            return new File(this.f + File.separator + o.o() + File.separator + str + "_" + str2 + File.separator + "lib" + str + ".so").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private String b(String str, String str2) {
        if ("cyber-media-dex".equals(str)) {
            return o.o() + "_cyber-media-dex_" + str2 + ".zip";
        } else if ("cyber-sdl".equals(str)) {
            return o.o() + "_cyber-player_" + str2 + ".zip";
        } else {
            return o.o() + "_" + str + "_" + str2 + ".zip";
        }
    }

    private Map<String, String> b(String str) {
        String str2 = this.f + File.separator + "libsinfodef_" + str + ".pro";
        Map<String, String> a2 = com.baidu.cyberplayer.sdk.config.b.a(str2);
        HashMap hashMap = new HashMap();
        if (a2 != null && a2.size() != 0) {
            for (Map.Entry<String, String> entry : a2.entrySet()) {
                String prefStr = CyberCfgManager.getInstance().getPrefStr(entry.getKey(), "");
                if (!TextUtils.isEmpty(prefStr) && !prefStr.equals(entry.getValue()) && !a(entry.getKey(), entry.getValue())) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        CyberLog.i("SilentDownloaderManager", "libsInfoDefProPath=" + str2 + " downloadMap=" + hashMap);
        return hashMap;
    }

    private void b() {
        e("silentdownload", "1");
        com.baidu.cyberplayer.sdk.statistics.b.a(this.c, (int) DpStatConstants.ACTION_LIB_LOAD_RESULT, this.k);
    }

    private void c() {
        HashMap<String, String> hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
        Map<String, String> map = this.j;
        if (map != null) {
            map.clear();
        }
    }

    private void c(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.cyberplayer.sdk.downloader.a aVar = new com.baidu.cyberplayer.sdk.downloader.a();
        if (str.startsWith("model_")) {
            str2 = this.e;
            str3 = this.g;
        } else {
            str2 = this.e;
            str3 = this.f;
        }
        aVar.a(str2, str, str3, this);
    }

    private synchronized void c(String str, String str2) {
        SharedPreferences.Editor edit = e().edit();
        edit.putString(str, str2);
        edit.apply();
    }

    private synchronized String d(String str, String str2) {
        return e().getString(str, str2);
    }

    private boolean d() {
        if (o.m()) {
            if (!c.a().h()) {
                CyberLog.d("SilentDownloaderManager", "cancel download isSFSwitchEnabled");
                return false;
            } else if (!CyberCfgManager.getInstance().getCfgBoolValue("enable_silent_download", false)) {
                CyberLog.i("SilentDownloaderManager", "silent download disable");
                return false;
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                return false;
            } else {
                int a2 = a("silent_download_success_count", 0);
                this.b = a2;
                if (a2 >= 36) {
                    CyberLog.w("SilentDownloaderManager", "Achieve max success download time:36");
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private boolean d(String str) {
        try {
            return new File(this.f + File.separator + "cyber-media-dex_" + str + ".jar").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private SharedPreferences e() {
        return this.c.getSharedPreferences("dp_silent_download_cfg_", 0);
    }

    private String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(str.lastIndexOf(File.separator) + 1, str.lastIndexOf("."));
        } catch (Exception unused) {
            return "";
        }
    }

    private void e(String str, String str2) {
        HashMap<String, String> hashMap = this.k;
        if (hashMap != null) {
            hashMap.put(str, str2);
        }
    }

    @Keep
    public static SilentDownloaderManager getInstance() {
        if (a == null) {
            synchronized (SilentDownloaderManager.class) {
                if (a == null) {
                    a = new SilentDownloaderManager();
                }
            }
        }
        return a;
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0092a
    public void a(String str, long j) {
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0092a
    public void a(String str, long j, int i, String str2) {
        CyberLog.i("SilentDownloaderManager", "onDownloadFail srcUrl:" + str + " detail:" + str2);
        this.i = false;
        if (i != -1) {
            int i2 = this.b + 1;
            this.b = i2;
            c("silent_download_success_count", Integer.toString(i2));
        }
        e("errorCode", String.valueOf(i));
        e("detail", str2);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0092a
    public void a(String str, long j, long j2) {
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.a.InterfaceC0092a
    public void a(String str, long j, ArrayList<String> arrayList) {
        CyberLog.i("SilentDownloaderManager", "onDownloadSuccess:" + arrayList);
        int i = this.b + 1;
        this.b = i;
        c("silent_download_success_count", Integer.toString(i));
        e(e(str), "1");
    }

    public boolean a() {
        Map<String, String> map;
        Map<String, String> map2;
        if (!d() || (map = this.j) == null || map.size() == 0 || this.h == null) {
            return false;
        }
        synchronized (SilentDownloaderManager.class) {
            if (d) {
                return false;
            }
            d = true;
            CyberLog.i("SilentDownloaderManager", "downloadOnce mDownloadMap=" + this.j);
            a aVar = this.h;
            if (aVar == a.CORE) {
                c(b("cyber-media-dex", this.j.get("cyber-media-dex")));
                if (this.i) {
                    map2 = b(this.j.get("cyber-media-dex"));
                    a(map2);
                }
                b();
                c();
                return this.i;
            }
            if (aVar == a.LIBS_INFO_DEF_PRO || aVar == a.LIB) {
                map2 = this.j;
                a(map2);
            }
            b();
            c();
            return this.i;
        }
    }

    public boolean a(String str) {
        String str2;
        if (!SDKVersion.VERSION.equals(str) && d()) {
            if (!CyberCfgManager.getInstance().getCfgBoolValue("update_core_enable_downgrade", false)) {
                CyberLog.i("SilentDownloaderManager", "core force update");
                return false;
            }
            if (d(str)) {
                Map<String, String> b = b(str);
                if (b == null || b.size() == 0) {
                    return false;
                }
                this.h = a.LIBS_INFO_DEF_PRO;
                this.j.putAll(b);
                str2 = "libsinfodef.pro has so need to download, mDownloadMap=" + this.j;
            } else {
                this.h = a.CORE;
                this.j.put("cyber-media-dex", str);
                str2 = "core not exist";
            }
            CyberLog.i("SilentDownloaderManager", str2);
            return true;
        }
        return false;
    }

    @Keep
    public boolean checkLibs(String str, String str2) {
        if (!d() || a(str, str2) || "cybermedia-ext-rtc".equals(str)) {
            return false;
        }
        this.h = a.LIB;
        this.j.put(str, str2);
        CyberLog.i("SilentDownloaderManager", "so not exist, mDownloadMap=" + this.j);
        return true;
    }
}
