package com.baidu.cyberplayer.sdk;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static c f5040a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5041b = true;

    /* renamed from: c  reason: collision with root package name */
    public String f5042c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f5043d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5044e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5045f = true;

    /* renamed from: g  reason: collision with root package name */
    public String f5046g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5047h = false;

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f5040a == null) {
                f5040a = new c();
            }
            cVar = f5040a;
        }
        return cVar;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.f5046g)) {
                String cfgValue = CyberCfgManager.getInstance().getCfgValue("update_core_server", "");
                return !TextUtils.isEmpty(cfgValue) ? cfgValue : "https://b.bdstatic.com/searchbox/androidvideo";
            }
            return this.f5046g;
        }
        return str;
    }

    public void a(boolean z) {
        this.f5047h = z;
    }

    public boolean b() {
        if (!this.f5041b) {
            CyberLog.i("CyberGlobalSetting", "isStatisticsUploadEnable closed");
            return false;
        } else if (g()) {
            return false;
        } else {
            return CyberCfgManager.getInstance().getCfgBoolValue("enable_upload_session_log", true);
        }
    }

    public String c() {
        if (TextUtils.isEmpty(this.f5042c)) {
            String cfgValue = CyberCfgManager.getInstance().getCfgValue("upload_session_server", "");
            return TextUtils.isEmpty(cfgValue) ? WebSettingsGlobalBlink.SESSION_UPLOAD_URL : cfgValue;
        }
        return this.f5042c;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f5043d)) {
            return CyberCfgManager.getInstance().a(CyberCfgManager.getInstance().getCfgValue("update_cloud_cfg_server", "https://browserkernel.baidu.com/video"));
        }
        return this.f5043d;
    }

    public boolean e() {
        if (g()) {
            return false;
        }
        return this.f5044e;
    }

    public boolean f() {
        return this.f5045f && !g();
    }

    public synchronized boolean g() {
        CyberLog.d("CyberGlobalSetting", "isSFSwitchEnabled:" + this.f5047h);
        return this.f5047h;
    }
}
