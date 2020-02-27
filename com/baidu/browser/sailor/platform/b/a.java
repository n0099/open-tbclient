package com.baidu.browser.sailor.platform.b;

import android.text.TextUtils;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    public static int a = 12323;
    public static int b = 12324;
    public b Jx;
    private JSONObject Jy;
    public JSONObject d;
    public boolean e = false;

    public final void a() {
        if (this.Jy != null) {
            SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.Jy.toString());
            this.Jy = null;
        }
    }

    public final void a(String str, String str2) {
        try {
            if (this.d == null) {
                this.d = new JSONObject();
                this.d.put("type", a);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.d.put(str, str2);
        } catch (Exception e) {
            Log.e("staticWebkitInit JSON error");
        }
    }

    public final void b(String str, String str2) {
        try {
            if (this.Jy == null) {
                this.Jy = new JSONObject();
                this.Jy.put("type", b);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.Jy.put(str, str2);
        } catch (Exception e) {
            Log.e("mWebkitDownloadStatics JSON error");
        }
    }
}
