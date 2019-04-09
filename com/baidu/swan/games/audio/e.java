package com.baidu.swan.games.audio;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.f.g;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static com.baidu.swan.apps.media.audio.b a(f fVar) {
        com.baidu.swan.apps.media.audio.b bVar = new com.baidu.swan.apps.media.audio.b();
        bVar.azw = fVar.azw;
        bVar.azG = fVar.autoplay;
        bVar.mLoop = fVar.loop;
        bVar.mUrl = fVar.src;
        bVar.azB = fVar.startTime;
        bVar.azH = fVar.obeyMuteSwitch;
        bVar.azI = fVar.volume;
        bVar.azD = Nk().toString();
        return bVar;
    }

    public static JSONObject Nk() {
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

    public static boolean ag(float f) {
        return f <= 1.0f && f >= 0.0f;
    }

    public static String hW(String str) throws MalformedURLException {
        return "/" + com.baidu.swan.apps.ae.b.Jg() + new URL(str).getPath();
    }

    public static String Nl() {
        String Nm = Nm();
        if (!Nn() || TextUtils.isEmpty(Nm)) {
            return AppRuntime.getAppContext().getCacheDir().getAbsolutePath();
        }
        return Nm;
    }

    private static String Nm() {
        String str = g.getBasePath() + "/usr";
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            Log.e("AudioDataUtils", "create targetFile dir error, path is " + file.getAbsolutePath(), new Throwable());
            return "";
        }
        return str;
    }

    private static boolean Nn() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
