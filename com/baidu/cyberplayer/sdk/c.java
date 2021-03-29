package com.baidu.cyberplayer.sdk;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static c f4884a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4885b = true;

    /* renamed from: c  reason: collision with root package name */
    public String f4886c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f4887d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4888e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4889f = true;

    /* renamed from: g  reason: collision with root package name */
    public String f4890g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4891h = false;

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f4884a == null) {
                f4884a = new c();
            }
            cVar = f4884a;
        }
        return cVar;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.f4890g)) {
                String cfgValue = CyberCfgManager.getInstance().getCfgValue("update_core_server", "");
                return !TextUtils.isEmpty(cfgValue) ? cfgValue : "https://b.bdstatic.com/searchbox/androidvideo";
            }
            return this.f4890g;
        }
        return str;
    }

    public void a(boolean z) {
        this.f4891h = z;
    }

    public boolean b() {
        if (!this.f4885b) {
            CyberLog.i("CyberGlobalSetting", "isStatisticsUploadEnable closed");
            return false;
        } else if (g()) {
            return false;
        } else {
            return CyberCfgManager.getInstance().getCfgBoolValue("enable_upload_session_log", true);
        }
    }

    public String c() {
        if (TextUtils.isEmpty(this.f4886c)) {
            String cfgValue = CyberCfgManager.getInstance().getCfgValue("upload_session_server", "");
            return TextUtils.isEmpty(cfgValue) ? WebSettingsGlobalBlink.SESSION_UPLOAD_URL : cfgValue;
        }
        return this.f4886c;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f4887d)) {
            return CyberCfgManager.getInstance().a(CyberCfgManager.getInstance().getCfgValue("update_cloud_cfg_server", "https://browserkernel.baidu.com/video"));
        }
        return this.f4887d;
    }

    public boolean e() {
        if (g()) {
            return false;
        }
        return this.f4888e;
    }

    public boolean f() {
        return this.f4889f && !g();
    }

    public synchronized boolean g() {
        CyberLog.d("CyberGlobalSetting", "isSFSwitchEnabled:" + this.f4891h);
        return this.f4891h;
    }
}
