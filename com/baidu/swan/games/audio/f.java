package com.baidu.swan.games.audio;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.File;
import java.net.MalformedURLException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static d a(g gVar) {
        d dVar = new d();
        dVar.aBc = gVar.aBc;
        dVar.aBl = gVar.autoplay;
        dVar.mLoop = gVar.loop;
        dVar.mUrl = gVar.src;
        dVar.beR = gVar.startTime;
        dVar.aBm = gVar.obeyMuteSwitch;
        dVar.aBn = gVar.volume;
        dVar.aBi = QW().toString();
        return dVar;
    }

    public static JSONObject QW() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("onCanplay", "canplay");
            jSONObject.put("onPlay", "play");
            jSONObject.put("onEnded", "ended");
            jSONObject.put("onPause", "pause");
            jSONObject.put("onSeeking", "seeking");
            jSONObject.put("onSeeked", "seeked");
            jSONObject.put("onStop", IntentConfig.STOP);
            jSONObject.put("onError", "error");
            jSONObject.put("onTimeUpdate", "timeupdate");
            jSONObject.put("onBufferingUpdate", "buffered");
            jSONObject.put("onWaiting", "waiting");
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static boolean ai(float f) {
        return f <= 1.0f && f >= 0.0f;
    }

    public static String iO(String str) throws MalformedURLException {
        return "/" + com.baidu.swan.apps.ae.b.Mo() + "/" + String.valueOf(str.hashCode());
    }

    public static String QX() {
        String QY = QY();
        if (!QZ() || TextUtils.isEmpty(QY)) {
            return AppRuntime.getAppContext().getCacheDir().getAbsolutePath();
        }
        return QY;
    }

    private static String QY() {
        String str = com.baidu.swan.games.f.g.getBasePath() + "/usr";
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            Log.e("AudioDataUtils", "create targetFile dir error, path is " + file.getAbsolutePath(), new Throwable());
            return "";
        }
        return str;
    }

    private static boolean QZ() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
