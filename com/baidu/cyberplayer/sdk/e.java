package com.baidu.cyberplayer.sdk;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes3.dex */
public class e {
    public boolean a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;
    public String f;
    public boolean g;

    /* loaded from: classes3.dex */
    public static class a {
        public static final e a = new e();
    }

    public e() {
        this.a = true;
        this.b = null;
        this.c = null;
        this.d = true;
        this.e = true;
        this.f = null;
        this.g = false;
    }

    public static e a() {
        return a.a;
    }

    public boolean b() {
        if (!this.a) {
            CyberLog.i("CyberGlobalSetting", "isStatisticsUploadEnable closed");
            return false;
        } else if (j()) {
            return false;
        } else {
            return CyberCfgManager.getInstance().getCfgBoolValue("enable_upload_session_log", false);
        }
    }

    public boolean c() {
        return CyberCfgManager.getInstance().getCfgBoolValue("enable_upload_kernel_init_log", true);
    }

    public boolean d() {
        return CyberCfgManager.getInstance().getCfgBoolValue("enable_live_upload_double", false);
    }

    public boolean e() {
        return CyberCfgManager.getInstance().getCfgBoolValue("enable_upload_ubc_log", true);
    }

    public String f() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        String cfgValue = CyberCfgManager.getInstance().getCfgValue("upload_session_server", "");
        if (TextUtils.isEmpty(cfgValue)) {
            return WebSettingsGlobalBlink.SESSION_UPLOAD_URL;
        }
        return cfgValue;
    }

    public String g() {
        if (!TextUtils.isEmpty(this.c)) {
            return this.c;
        }
        return CyberCfgManager.getInstance().a(CyberCfgManager.getInstance().getCfgValue("update_cloud_cfg_server", "https://browserkernel.baidu.com/video"));
    }

    public boolean h() {
        if (j()) {
            return false;
        }
        return this.d;
    }

    public boolean i() {
        if (!this.e || j()) {
            return false;
        }
        return true;
    }

    public synchronized boolean j() {
        CyberLog.d("CyberGlobalSetting", "isSFSwitchEnabled:" + this.g);
        return this.g;
    }

    public String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (!TextUtils.isEmpty(this.f)) {
            return this.f;
        }
        String cfgValue = CyberCfgManager.getInstance().getCfgValue("update_core_server", "");
        if (!TextUtils.isEmpty(cfgValue)) {
            return cfgValue;
        }
        return "https://b.bdstatic.com/searchbox/androidvideo";
    }

    public void a(boolean z) {
        this.g = z;
    }
}
