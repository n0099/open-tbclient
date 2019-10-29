package com.baidu.swan.games.audio;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.net.MalformedURLException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static d a(g gVar) {
        d dVar = new d();
        dVar.aUO = gVar.aUO;
        dVar.aUX = gVar.autoplay;
        dVar.aUY = gVar.loop;
        dVar.mUrl = gVar.src;
        dVar.byj = gVar.startTime;
        dVar.aUZ = gVar.obeyMuteSwitch;
        dVar.aVa = gVar.volume;
        dVar.aUU = VQ().toString();
        return dVar;
    }

    public static JSONObject VQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("onCanplay", "canplay");
            jSONObject.put("onPlay", "play");
            jSONObject.put("onEnded", "ended");
            jSONObject.put("onPause", "pause");
            jSONObject.put("onSeeking", "seeking");
            jSONObject.put("onSeeked", "seeked");
            jSONObject.put("onStop", "stop");
            jSONObject.put("onError", BdStatsConstant.StatsType.ERROR);
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

    public static boolean X(float f) {
        return f <= 1.0f && f >= 0.0f;
    }

    public static String jt(String str) throws MalformedURLException {
        return "/" + com.baidu.swan.apps.ae.b.Rk() + "/" + String.valueOf(str.hashCode());
    }

    public static String VR() {
        String VS = VS();
        if (!VT() || TextUtils.isEmpty(VS)) {
            return AppRuntime.getAppContext().getCacheDir().getAbsolutePath();
        }
        return VS;
    }

    private static String VS() {
        String str = com.baidu.swan.games.f.g.getBasePath() + "/usr";
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            Log.e("AudioDataUtils", "create targetFile dir error, path is " + file.getAbsolutePath(), new Throwable());
            return "";
        }
        return str;
    }

    private static boolean VT() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
