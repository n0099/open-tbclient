package com.baidu.prologue.business.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompatJellybean;
import com.coremedia.iso.boxes.FreeSpaceBox;
import d.b.a0.a.c.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SplashStyleRecorder {

    /* loaded from: classes2.dex */
    public enum SplashElements {
        LOGO("logo"),
        SKIP(FreeSpaceBox.TYPE),
        LABEL(NotificationCompatJellybean.KEY_LABEL),
        VOICE("voice"),
        WIFI_TIP("wifi_tip");
        
        public String name;

        SplashElements(String str) {
            setName(str);
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    @Nullable
    public static JSONObject a() {
        String d2 = j.d("splash_style", "");
        if (TextUtils.isEmpty(d2)) {
            return null;
        }
        try {
            return new JSONObject(d2);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            String d2 = j.d("splash_style", "");
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.equals(d2, jSONObject2)) {
                return;
            }
            j.f("splash_style", jSONObject2);
        }
    }
}
