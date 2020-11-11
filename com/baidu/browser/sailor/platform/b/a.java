package com.baidu.browser.sailor.platform.b;

import android.text.TextUtils;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f1281a = 12323;
    public static int b = 12324;
    public b afu;
    private JSONObject afv;
    public JSONObject d;
    public boolean e = false;

    public final void a() {
        if (this.afv != null) {
            SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.afv.toString());
            this.afv = null;
        }
    }

    public final void a(String str, String str2) {
        try {
            if (this.d == null) {
                this.d = new JSONObject();
                this.d.put("type", f1281a);
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
            if (this.afv == null) {
                this.afv = new JSONObject();
                this.afv.put("type", b);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.afv.put(str, str2);
        } catch (Exception e) {
            Log.e("mWebkitDownloadStatics JSON error");
        }
    }
}
