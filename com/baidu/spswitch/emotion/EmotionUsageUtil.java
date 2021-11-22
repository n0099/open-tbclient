package com.baidu.spswitch.emotion;

import android.text.TextUtils;
import android.util.LruCache;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.resource.EmotionAPSManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class EmotionUsageUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EMOTION_USAGE_FILE_NAME = "emotion-usage.json";
    public static int LRU_MAX_COUNT = 5;
    public static LruCache<String, Object> sUsageData;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-607198193, "Lcom/baidu/spswitch/emotion/EmotionUsageUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-607198193, "Lcom/baidu/spswitch/emotion/EmotionUsageUtil;");
                return;
            }
        }
        sUsageData = new LruCache<>(LRU_MAX_COUNT);
        restoreFromDisk();
    }

    public EmotionUsageUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<String> getEmotionUsageList(Map<String, EmotionUtils.EmotionClassic> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, map)) == null) {
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
        return (List) invokeL.objValue;
    }

    public static File getRootDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new File(AppRuntime.getAppContext().getFilesDir().getPath(), EmotionAPSManager.EMOTION_ROOT_DIR_NAME) : (File) invokeV.objValue;
    }

    public static Map<String, Object> jsonToMap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
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
        return (Map) invokeL.objValue;
    }

    public static void makeRootDirIfNecessary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            File rootDir = getRootDir();
            if (rootDir.exists()) {
                return;
            }
            rootDir.mkdirs();
        }
    }

    public static String mapToJson(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, map)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static void recordEmotionUsage(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        sUsageData.put(str, new Object());
        saveToDisk();
    }

    public static void restoreFromDisk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.spswitch.emotion.EmotionUsageUtil.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Map jsonToMap;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
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
                }
            }, "EmotionUsageRestoreFromDisk", 1);
        }
    }

    public static void saveToDisk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.spswitch.emotion.EmotionUsageUtil.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || EmotionUsageUtil.sUsageData.size() <= 0) {
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
}
