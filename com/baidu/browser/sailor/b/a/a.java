package com.baidu.browser.sailor.b.a;

import android.text.TextUtils;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    public static int a = 12323;
    public static int b = 12324;
    private JSONObject WP;
    public JSONObject d;
    public boolean e = false;

    public final void a() {
        if (this.WP != null) {
            SessionMonitorEngine.getInstance().recordImmediately("t7_init", this.WP.toString());
            this.WP = null;
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
            if (this.WP == null) {
                this.WP = new JSONObject();
                this.WP.put("type", b);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.WP.put(str, str2);
        } catch (Exception e) {
            Log.e("mWebkitDownloadStatics JSON error");
        }
    }
}
