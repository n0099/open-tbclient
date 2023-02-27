package com.baidu.cyberplayer.sdk;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes2.dex */
public class c {
    public static c a;
    public boolean b = true;
    public String c = null;
    public String d = null;
    public boolean e = true;
    public boolean f = true;
    public String g = null;
    public boolean h = false;

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.g)) {
                String cfgValue = CyberCfgManager.getInstance().getCfgValue("update_core_server", "");
                return !TextUtils.isEmpty(cfgValue) ? cfgValue : "https://b.bdstatic.com/searchbox/androidvideo";
            }
            return this.g;
        }
        return str;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public boolean b() {
        if (!this.b) {
            CyberLog.i("CyberGlobalSetting", "isStatisticsUploadEnable closed");
            return false;
        } else if (i()) {
            return false;
        } else {
            return CyberCfgManager.getInstance().getCfgBoolValue("enable_upload_session_log", true);
        }
    }

    public boolean c() {
        return CyberCfgManager.getInstance().getCfgBoolValue("enable_live_upload_double", true);
    }

    public boolean d() {
        return CyberCfgManager.getInstance().getCfgBoolValue("enable_upload_ubc_log", true);
    }

    public String e() {
        if (TextUtils.isEmpty(this.c)) {
            String cfgValue = CyberCfgManager.getInstance().getCfgValue("upload_session_server", "");
            return TextUtils.isEmpty(cfgValue) ? WebSettingsGlobalBlink.SESSION_UPLOAD_URL : cfgValue;
        }
        return this.c;
    }

    public String f() {
        if (TextUtils.isEmpty(this.d)) {
            return CyberCfgManager.getInstance().a(CyberCfgManager.getInstance().getCfgValue("update_cloud_cfg_server", "https://browserkernel.baidu.com/video"));
        }
        return this.d;
    }

    public boolean g() {
        if (i()) {
            return false;
        }
        return this.e;
    }

    public boolean h() {
        return this.f && !i();
    }

    public synchronized boolean i() {
        CyberLog.d("CyberGlobalSetting", "isSFSwitchEnabled:" + this.h);
        return this.h;
    }
}
