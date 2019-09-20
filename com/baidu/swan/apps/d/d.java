package com.baidu.swan.apps.d;

import android.content.Context;
import android.util.Log;
import android.webkit.DownloadListener;
import com.baidu.swan.apps.an.aa;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends com.baidu.swan.apps.view.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public d(Context context) {
        super(context);
        this.apt.setDownloadListener(new a());
    }

    @Override // com.baidu.swan.apps.core.i.d, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public String xy() {
        return "ai_apps_ad_landing";
    }

    /* loaded from: classes2.dex */
    class a implements DownloadListener {
        a() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (d.DEBUG) {
                Log.d("SwanAppAdLandingWVWidget", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
                jSONObject.put("userAgent", str2);
                jSONObject.put("contentDisposition", aa.iw(str3));
                jSONObject.put("mimeType", str4);
                jSONObject.put("contentLength", j);
            } catch (JSONException e) {
                if (d.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.u.a.Ey().e(d.this.mContext, jSONObject);
        }
    }
}
