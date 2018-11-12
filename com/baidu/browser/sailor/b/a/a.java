package com.baidu.browser.sailor.b.a;

import android.text.TextUtils;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    public static int a = 12323;
    public static int b = 12324;
    private JSONObject WG;
    public JSONObject d;
    public boolean e = false;

    public final void a() {
        if (this.WG != null) {
            SessionMonitorEngine.getInstance().recordImmediately("t7_init", this.WG.toString());
            this.WG = null;
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
            if (this.WG == null) {
                this.WG = new JSONObject();
                this.WG.put("type", b);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.WG.put(str, str2);
        } catch (Exception e) {
            Log.e("mWebkitDownloadStatics JSON error");
        }
    }
}
