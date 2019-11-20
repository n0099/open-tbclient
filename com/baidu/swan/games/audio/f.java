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
        dVar.aUw = gVar.aUw;
        dVar.aUF = gVar.autoplay;
        dVar.aUG = gVar.loop;
        dVar.mUrl = gVar.src;
        dVar.bxs = gVar.startTime;
        dVar.aUH = gVar.obeyMuteSwitch;
        dVar.aUI = gVar.volume;
        dVar.aUC = VO().toString();
        return dVar;
    }

    public static JSONObject VO() {
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
        return "/" + com.baidu.swan.apps.ae.b.Rm() + "/" + String.valueOf(str.hashCode());
    }

    public static String VP() {
        String VQ = VQ();
        if (!VR() || TextUtils.isEmpty(VQ)) {
            return AppRuntime.getAppContext().getCacheDir().getAbsolutePath();
        }
        return VQ;
    }

    private static String VQ() {
        String str = com.baidu.swan.games.f.g.getBasePath() + "/usr";
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            Log.e("AudioDataUtils", "create targetFile dir error, path is " + file.getAbsolutePath(), new Throwable());
            return "";
        }
        return str;
    }

    private static boolean VR() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
