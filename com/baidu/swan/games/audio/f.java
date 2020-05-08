package com.baidu.swan.games.audio;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.h.l;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f {
    private static final HashMap<String, String> cJl = new HashMap<>();

    static {
        cJl.put("494433", ".mp3");
        cJl.put("524946", ".wav");
    }

    public static d a(g gVar) {
        d dVar = new d();
        dVar.bYY = gVar.bYY;
        dVar.bZg = gVar.autoplay;
        dVar.mLoop = gVar.loop;
        dVar.mUrl = gVar.src;
        dVar.cJi = gVar.startTime;
        dVar.bZh = gVar.obeyMuteSwitch;
        dVar.mVolume = gVar.volume;
        dVar.bZd = atL().toString();
        return dVar;
    }

    public static JSONObject atL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("onCanplay", "canplay");
            jSONObject.put("onPlay", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
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

    public static boolean K(float f) {
        return f <= 1.0f && f >= 0.0f;
    }

    public static String pz(String str) throws MalformedURLException {
        int lastIndexOf = str.lastIndexOf(46);
        String str2 = "";
        if (lastIndexOf != -1) {
            str2 = str.substring(lastIndexOf, str.length());
        }
        return "/" + com.baidu.swan.apps.runtime.e.akO() + "/" + String.valueOf(str.hashCode() + str2);
    }

    public static String atM() {
        String atO = atO();
        if (!isExternalStorageWritable() || TextUtils.isEmpty(atO)) {
            return AppRuntime.getAppContext().getCacheDir().getAbsolutePath();
        }
        return atO;
    }

    public static String atN() {
        return File.separator + "bdata" + File.separator;
    }

    private static String atO() {
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

    public static String D(byte[] bArr) {
        if (bArr == null || 3 > bArr.length) {
            return "";
        }
        byte[] bArr2 = new byte[3];
        for (int i = 0; i < 3; i++) {
            bArr2[i] = bArr[i];
        }
        return cJl.get(bytesToHexString(bArr2));
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
