package com.baidu.swan.apps.d;

import android.content.Context;
import android.util.Log;
import android.webkit.DownloadListener;
import com.baidu.swan.apps.an.y;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.view.c {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;

    public c(Context context) {
        super(context);
        this.anZ.setDownloadListener(new a());
    }

    @Override // com.baidu.swan.apps.core.h.d, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public String wd() {
        return "ai_apps_ad_landing";
    }

    /* loaded from: classes2.dex */
    class a implements DownloadListener {
        a() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (c.DEBUG) {
                Log.d("SwanAppAdLandingWVWidget", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
                jSONObject.put("userAgent", str2);
                jSONObject.put("contentDisposition", y.hJ(str3));
                jSONObject.put("mimeType", str4);
                jSONObject.put("contentLength", j);
            } catch (JSONException e) {
                if (c.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.u.a.CI().g(c.this.mContext, jSONObject);
        }
    }
}
