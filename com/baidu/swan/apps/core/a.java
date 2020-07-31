package com.baidu.swan.apps.core;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.swan.apps.aq.p;
import com.baidu.tbadk.TbConfig;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class a {
    public static void e(long j, String str) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", j);
            jSONObject.put(TbConfig.TMP_LOG_DIR_NAME, str);
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
        final File YU = YU();
        if (YU != null) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.d.d.saveFileCommon(jSONObject.toString().getBytes(), YU);
                }
            }, "saveLaunchTipsLog");
        }
    }

    public static Pair<Long, String> YT() {
        File logFile = getLogFile();
        if (logFile == null || !logFile.exists()) {
            return null;
        }
        String readFileData = com.baidu.swan.d.d.readFileData(logFile);
        if (TextUtils.isEmpty(readFileData)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(readFileData);
            return new Pair<>(Long.valueOf(jSONObject.optLong("time")), jSONObject.optString(TbConfig.TMP_LOG_DIR_NAME));
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    private static File getLogFile() {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw == null) {
            return null;
        }
        String appId = arw.getAppId();
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return new File(com.baidu.swan.apps.r.d.agZ().getPath() + File.separator + "launch_tips" + File.separator + appId);
    }

    private static File YU() {
        File file = null;
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw != null) {
            String appId = arw.getAppId();
            if (!TextUtils.isEmpty(appId)) {
                file = new File(com.baidu.swan.apps.r.d.agZ().getPath() + File.separator + "launch_tips" + File.separator + appId);
                if (file.exists()) {
                    com.baidu.swan.d.d.safeDeleteFile(file);
                }
                com.baidu.swan.d.d.createNewFileSafely(file);
            }
        }
        return file;
    }
}
