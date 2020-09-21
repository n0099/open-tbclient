package com.baidu.swan.videoplayer.media.video.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static void a(String str, String str2, String str3, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("VideoStatusEventHelper", "dispatchNetStatusEvent failed slaveId: " + str2 + " ,videoId: " + str);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("wvID", str2);
            jSONObject2.put("vtype", str3);
            jSONObject.putOpt("videoId", str);
            jSONObject2.put("data", jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        c.d("VideoStatusEventHelper", "Video dispatch Params : " + jSONObject2.toString());
        com.baidu.swan.apps.view.b.b.a.a(str2, str, "video", str3, jSONObject2);
    }

    public static void a(final String str, final String str2, final boolean z, VideoContainerManager videoContainerManager) {
        final SwanAppComponentContainerView aXO = videoContainerManager.aXO();
        aXO.post(new Runnable() { // from class: com.baidu.swan.videoplayer.media.video.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    int J = ah.J(SwanAppComponentContainerView.this.getWidth());
                    int J2 = ah.J(SwanAppComponentContainerView.this.getHeight());
                    jSONObject.putOpt("fullscreen", z ? "1" : "0");
                    jSONObject.putOpt("width", String.valueOf(J));
                    jSONObject.putOpt("height", String.valueOf(J2));
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
                a.a(str, str2, "fullscreenchange", jSONObject);
            }
        });
    }
}
