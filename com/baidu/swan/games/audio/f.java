package com.baidu.swan.games.audio;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.h.l;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f {
    private static final HashMap<String, String> cfG = new HashMap<>();

    static {
        cfG.put("494433", ".mp3");
        cfG.put("524946", ".wav");
    }

    public static d a(g gVar) {
        d dVar = new d();
        dVar.bvC = gVar.bvC;
        dVar.bvK = gVar.autoplay;
        dVar.bvL = gVar.loop;
        dVar.mUrl = gVar.src;
        dVar.cfD = gVar.startTime;
        dVar.bvM = gVar.obeyMuteSwitch;
        dVar.mVolume = gVar.volume;
        dVar.bvH = aiL().toString();
        return dVar;
    }

    public static JSONObject aiL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("onCanplay", "canplay");
            jSONObject.put("onPlay", "play");
            jSONObject.put("onEnded", "ended");
            jSONObject.put(MissionEvent.MESSAGE_PAUSE, "pause");
            jSONObject.put("onSeeking", "seeking");
            jSONObject.put("onSeeked", "seeked");
            jSONObject.put(MissionEvent.MESSAGE_STOP, "stop");
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

    public static boolean ac(float f) {
        return f <= 1.0f && f >= 0.0f;
    }

    public static String nT(String str) throws MalformedURLException {
        int lastIndexOf = str.lastIndexOf(46);
        String str2 = "";
        if (lastIndexOf != -1) {
            str2 = str.substring(lastIndexOf, str.length());
        }
        return "/" + com.baidu.swan.apps.runtime.e.ZU() + "/" + String.valueOf(str.hashCode() + str2);
    }

    public static String aiM() {
        String aiO = aiO();
        if (!isExternalStorageWritable() || TextUtils.isEmpty(aiO)) {
            return AppRuntime.getAppContext().getCacheDir().getAbsolutePath();
        }
        return aiO;
    }

    public static String aiN() {
        return File.separator + "bdata" + File.separator;
    }

    private static String aiO() {
        String str = l.getBasePath() + "/usr";
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            Log.e("AudioDataUtils", "create targetFile dir error, path is " + file.getAbsolutePath(), new Throwable());
            return "";
        }
        return str;
    }

    private static boolean isExternalStorageWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static String x(byte[] bArr) {
        if (bArr == null || 3 > bArr.length) {
            return "";
        }
        byte[] bArr2 = new byte[3];
        for (int i = 0; i < 3; i++) {
            bArr2[i] = bArr[i];
        }
        return cfG.get(bytesToHexString(bArr2));
    }

    private static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String upperCase = Integer.toHexString(b & 255).toUpperCase();
            if (upperCase.length() < 2) {
                sb.append(0);
            }
            sb.append(upperCase);
        }
        String sb2 = sb.toString();
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.e("AudioDataUtils", "audio buffer header: " + sb2);
            return sb2;
        }
        return sb2;
    }
}
