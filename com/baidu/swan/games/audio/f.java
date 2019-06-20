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
        dVar.aAu = gVar.aAu;
        dVar.aAD = gVar.autoplay;
        dVar.mLoop = gVar.loop;
        dVar.mUrl = gVar.src;
        dVar.bed = gVar.startTime;
        dVar.aAE = gVar.obeyMuteSwitch;
        dVar.aAF = gVar.volume;
        dVar.aAA = Qe().toString();
        return dVar;
    }

    public static JSONObject Qe() {
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

    public static String iH(String str) throws MalformedURLException {
        return "/" + com.baidu.swan.apps.ae.b.LB() + "/" + String.valueOf(str.hashCode());
    }

    public static String Qf() {
        String Qg = Qg();
        if (!Qh() || TextUtils.isEmpty(Qg)) {
            return AppRuntime.getAppContext().getCacheDir().getAbsolutePath();
        }
        return Qg;
    }

    private static String Qg() {
        String str = com.baidu.swan.games.f.g.getBasePath() + "/usr";
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            Log.e("AudioDataUtils", "create targetFile dir error, path is " + file.getAbsolutePath(), new Throwable());
            return "";
        }
        return str;
    }

    private static boolean Qh() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
