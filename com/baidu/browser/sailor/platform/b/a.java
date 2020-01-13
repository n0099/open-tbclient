package com.baidu.browser.sailor.platform.b;

import android.text.TextUtils;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static int a = 12323;
    public static int b = 12324;
    public b Jb;
    private JSONObject Jc;
    public JSONObject d;
    public boolean e = false;

    public final void a() {
        if (this.Jc != null) {
            SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.Jc.toString());
            this.Jc = null;
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
            if (this.Jc == null) {
                this.Jc = new JSONObject();
                this.Jc.put("type", b);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.Jc.put(str, str2);
        } catch (Exception e) {
            Log.e("mWebkitDownloadStatics JSON error");
        }
    }
}
