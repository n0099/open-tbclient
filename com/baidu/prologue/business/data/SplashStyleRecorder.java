package com.baidu.prologue.business.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompatJellybean;
import com.coremedia.iso.boxes.FreeSpaceBox;
import d.a.d0.a.c.j;
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
        String f2 = j.f("splash_style", "");
        if (TextUtils.isEmpty(f2)) {
            return null;
        }
        try {
            return new JSONObject(f2);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            String f2 = j.f("splash_style", "");
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.equals(f2, jSONObject2)) {
                return;
            }
            j.j("splash_style", jSONObject2);
        }
    }
}
