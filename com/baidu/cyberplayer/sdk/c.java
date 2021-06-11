package com.baidu.cyberplayer.sdk;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static c f4782a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4783b = true;

    /* renamed from: c  reason: collision with root package name */
    public String f4784c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f4785d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4786e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4787f = true;

    /* renamed from: g  reason: collision with root package name */
    public String f4788g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4789h = false;

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f4782a == null) {
                f4782a = new c();
            }
            cVar = f4782a;
        }
        return cVar;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.f4788g)) {
                String cfgValue = CyberCfgManager.getInstance().getCfgValue("update_core_server", "");
                return !TextUtils.isEmpty(cfgValue) ? cfgValue : "https://b.bdstatic.com/searchbox/androidvideo";
            }
            return this.f4788g;
        }
        return str;
    }

    public void a(boolean z) {
        this.f4789h = z;
    }

    public boolean b() {
        if (!this.f4783b) {
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
        if (TextUtils.isEmpty(this.f4784c)) {
            String cfgValue = CyberCfgManager.getInstance().getCfgValue("upload_session_server", "");
            return TextUtils.isEmpty(cfgValue) ? WebSettingsGlobalBlink.SESSION_UPLOAD_URL : cfgValue;
        }
        return this.f4784c;
    }

    public String f() {
        if (TextUtils.isEmpty(this.f4785d)) {
            return CyberCfgManager.getInstance().a(CyberCfgManager.getInstance().getCfgValue("update_cloud_cfg_server", "https://browserkernel.baidu.com/video"));
        }
        return this.f4785d;
    }

    public boolean g() {
        if (i()) {
            return false;
        }
        return this.f4786e;
    }

    public boolean h() {
        return this.f4787f && !i();
    }

    public synchronized boolean i() {
        CyberLog.d("CyberGlobalSetting", "isSFSwitchEnabled:" + this.f4789h);
        return this.f4789h;
    }
}
