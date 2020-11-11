package com.baidu.cyberplayer.sdk;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
/* loaded from: classes12.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f1371a;
    private boolean b = true;
    private String c = null;
    private String d = null;
    private boolean e = true;
    private boolean f = true;
    private String g = null;
    private boolean h = false;

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f1371a == null) {
                f1371a = new c();
            }
            cVar = f1371a;
        }
        return cVar;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.g)) {
                String cfgValue = CyberCfgManager.getInstance().getCfgValue("update_core_server", "");
                return TextUtils.isEmpty(cfgValue) ? "https://b.bdstatic.com/searchbox/androidvideo" : cfgValue;
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
        } else if (g()) {
            return false;
        } else {
            return CyberCfgManager.getInstance().getCfgBoolValue("enable_upload_session_log", true);
        }
    }

    public String c() {
        if (TextUtils.isEmpty(this.c)) {
            String cfgValue = CyberCfgManager.getInstance().getCfgValue("upload_session_server", "");
            return TextUtils.isEmpty(cfgValue) ? "https://browserkernel.baidu.com/kw?r_en=true&type=" : cfgValue;
        }
        return this.c;
    }

    public String d() {
        if (TextUtils.isEmpty(this.d)) {
            return CyberCfgManager.getInstance().a(CyberCfgManager.getInstance().getCfgValue("update_cloud_cfg_server", "https://browserkernel.baidu.com/video"));
        }
        return this.d;
    }

    public boolean e() {
        if (g()) {
            return false;
        }
        return this.e;
    }

    public boolean f() {
        return this.f && !g();
    }

    public synchronized boolean g() {
        CyberLog.d("CyberGlobalSetting", "isSFSwitchEnabled:" + this.h);
        return this.h;
    }
}
