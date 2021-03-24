package com.baidu.spswitch.emotion;

import android.text.TextUtils;
import android.util.LruCache;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.resource.EmotionAPSManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class EmotionUsageUtil {
    public static final String EMOTION_USAGE_FILE_NAME = "emotion-usage.json";
    public static int LRU_MAX_COUNT = 5;
    public static LruCache<String, Object> sUsageData = new LruCache<>(LRU_MAX_COUNT);

    static {
        restoreFromDisk();
    }

    public static List<String> getEmotionUsageList(Map<String, EmotionUtils.EmotionClassic> map) {
        if (sUsageData.size() > 0) {
            boolean z = map != null && map.size() > 0;
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Object> entry : sUsageData.snapshot().entrySet()) {
                if (z) {
                    if (map.containsKey(entry.getKey())) {
                        arrayList.add(entry.getKey());
                    }
                } else {
                    arrayList.add(entry.getKey());
                }
            }
            Collections.reverse(arrayList);
            return arrayList;
        }
        return null;
    }

    public static File getRootDir() {
        return new File(AppRuntime.getAppContext().getFilesDir().getPath(), EmotionAPSManager.EMOTION_ROOT_DIR_NAME);
    }

    public static Map<String, Object> jsonToMap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id", "");
                    if (!TextUtils.isEmpty(optString)) {
                        hashMap.put(optString, new Object());
                    }
                }
            }
            if (hashMap.isEmpty()) {
                return null;
            }
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void makeRootDirIfNecessary() {
        File rootDir = getRootDir();
        if (rootDir.exists()) {
            return;
        }
        rootDir.mkdirs();
    }

    public static String mapToJson(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        if (entrySet != null) {
            for (Map.Entry<String, Object> entry : entrySet) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", key);
                        jSONArray.put(jSONObject);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return jSONArray.length() > 0 ? jSONArray.toString() : "";
    }

    public static void recordEmotionUsage(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sUsageData.put(str, new Object());
        saveToDisk();
    }

    public static void restoreFromDisk() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.spswitch.emotion.EmotionUsageUtil.2
            @Override // java.lang.Runnable
            public void run() {
                Map jsonToMap;
                EmotionUsageUtil.makeRootDirIfNecessary();
                File file = new File(EmotionUsageUtil.getRootDir(), EmotionUsageUtil.EMOTION_USAGE_FILE_NAME);
                if (file.exists()) {
                    String readFileData = FileUtils.readFileData(file);
                    if (TextUtils.isEmpty(readFileData) || (jsonToMap = EmotionUsageUtil.jsonToMap(readFileData)) == null || jsonToMap.isEmpty()) {
                        return;
                    }
                    EmotionUsageUtil.sUsageData.evictAll();
                    Set<Map.Entry> entrySet = jsonToMap.entrySet();
                    if (entrySet != null) {
                        for (Map.Entry entry : entrySet) {
                            EmotionUsageUtil.sUsageData.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
        }, "EmotionUsageRestoreFromDisk", 1);
    }

    public static void saveToDisk() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.spswitch.emotion.EmotionUsageUtil.1
            @Override // java.lang.Runnable
            public void run() {
                if (EmotionUsageUtil.sUsageData.size() <= 0) {
                    return;
                }
                String mapToJson = EmotionUsageUtil.mapToJson(EmotionUsageUtil.sUsageData.snapshot());
                if (TextUtils.isEmpty(mapToJson)) {
                    return;
                }
                EmotionUsageUtil.makeRootDirIfNecessary();
                File file = new File(EmotionUsageUtil.getRootDir(), EmotionUsageUtil.EMOTION_USAGE_FILE_NAME);
                FileUtils.deleteFile(file);
                FileUtils.saveFile(mapToJson, file);
            }
        }, "EmotionUsageSaveToDisk", 2);
    }
}
