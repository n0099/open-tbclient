package com.baidu.cyberplayer.sdk;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static c f4919a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4920b = true;

    /* renamed from: c  reason: collision with root package name */
    public String f4921c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f4922d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4923e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4924f = true;

    /* renamed from: g  reason: collision with root package name */
    public String f4925g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4926h = false;

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f4919a == null) {
                f4919a = new c();
            }
            cVar = f4919a;
        }
        return cVar;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.f4925g)) {
                String cfgValue = CyberCfgManager.getInstance().getCfgValue("update_core_server", "");
                return !TextUtils.isEmpty(cfgValue) ? cfgValue : "https://b.bdstatic.com/searchbox/androidvideo";
            }
            return this.f4925g;
        }
        return str;
    }

    public void a(boolean z) {
        this.f4926h = z;
    }

    public boolean b() {
        if (!this.f4920b) {
            CyberLog.i("CyberGlobalSetting", "isStatisticsUploadEnable closed");
            return false;
        } else if (g()) {
            return false;
        } else {
            return CyberCfgManager.getInstance().getCfgBoolValue("enable_upload_session_log", true);
        }
    }

    public String c() {
        if (TextUtils.isEmpty(this.f4921c)) {
            String cfgValue = CyberCfgManager.getInstance().getCfgValue("upload_session_server", "");
            return TextUtils.isEmpty(cfgValue) ? WebSettingsGlobalBlink.SESSION_UPLOAD_URL : cfgValue;
        }
        return this.f4921c;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f4922d)) {
            return CyberCfgManager.getInstance().a(CyberCfgManager.getInstance().getCfgValue("update_cloud_cfg_server", "https://browserkernel.baidu.com/video"));
        }
        return this.f4922d;
    }

    public boolean e() {
        if (g()) {
            return false;
        }
        return this.f4923e;
    }

    public boolean f() {
        return this.f4924f && !g();
    }

    public synchronized boolean g() {
        CyberLog.d("CyberGlobalSetting", "isSFSwitchEnabled:" + this.f4926h);
        return this.f4926h;
    }
}
