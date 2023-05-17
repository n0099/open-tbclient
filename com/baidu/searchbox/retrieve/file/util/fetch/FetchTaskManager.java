package com.baidu.searchbox.retrieve.file.util.fetch;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FetchTaskManager {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String JSON_TIMER_JOB_ID_KEY = "jobId";
    public static final String JSON_TIMER_JOB_ORIGIN_KEY = "jobOrigin";
    public static final String SP_FETCH_DEBUG_KEY = "fetch_debug_key";
    public static final String SP_FETCH_TASK_STORE = "com.baidu.searchbox.fetch.task";
    public static final String SP_TASK_ORIGIN_KEY = "fetch_task_origin";
    public static final String SP_TASK_ORIGIN_TIMER_LIST_KEY = "fetch_task_origin_timer_list";
    public static final String SP_TASK_RETRY_COUNT_KEY = "fetch_task_retry_count";
    public static final String TAG = "FetchTaskManager";
    public static volatile FetchTaskManager sSingleton;
    public final SharedPrefsWrapper mSharedPrefsWrapper = new SharedPrefsWrapper(KVStorageFactory.getSharedPreferences(SP_FETCH_TASK_STORE));

    public static FetchTaskManager getInstance() {
        if (sSingleton == null) {
            synchronized (FetchTaskManager.class) {
                if (sSingleton == null) {
                    sSingleton = new FetchTaskManager();
                }
            }
        }
        return sSingleton;
    }

    public void clearOriginData() {
        saveOriginData("");
    }

    public String getOriginData() {
        return this.mSharedPrefsWrapper.getString(SP_TASK_ORIGIN_KEY, "");
    }

    public int getRetryCount() {
        return this.mSharedPrefsWrapper.getInt(SP_TASK_RETRY_COUNT_KEY, 0);
    }

    public boolean isDebug() {
        return this.mSharedPrefsWrapper.getBoolean(SP_FETCH_DEBUG_KEY, false);
    }

    public synchronized List<JSONObject> getAllOriginTimerData() {
        String string = this.mSharedPrefsWrapper.getString(SP_TASK_ORIGIN_TIMER_LIST_KEY, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(((JSONObject) jSONArray.get(i)).optJSONObject(JSON_TIMER_JOB_ORIGIN_KEY));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, e.getMessage());
            }
            this.mSharedPrefsWrapper.putString(SP_TASK_ORIGIN_TIMER_LIST_KEY, "");
        }
        return arrayList;
    }

    public synchronized void removeOriginTimerData(String str) {
        String str2;
        String string = this.mSharedPrefsWrapper.getString(SP_TASK_ORIGIN_TIMER_LIST_KEY, "");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                JSONArray jSONArray2 = new JSONArray();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    if (!str.equals(jSONObject.optString("jobId"))) {
                        jSONArray2.put(jSONObject);
                    }
                }
                SharedPrefsWrapper sharedPrefsWrapper = this.mSharedPrefsWrapper;
                if (jSONArray2.length() > 0) {
                    str2 = jSONArray.toString();
                } else {
                    str2 = "";
                }
                sharedPrefsWrapper.putString(SP_TASK_ORIGIN_TIMER_LIST_KEY, str2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e(TAG, e.getMessage());
                }
                this.mSharedPrefsWrapper.putString(SP_TASK_ORIGIN_TIMER_LIST_KEY, "");
            }
        }
    }

    public void saveOriginData(String str) {
        SharedPrefsWrapper sharedPrefsWrapper = this.mSharedPrefsWrapper;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sharedPrefsWrapper.putString(SP_TASK_ORIGIN_KEY, str);
    }

    public void saveRetryCount(int i) {
        this.mSharedPrefsWrapper.putInt(SP_TASK_RETRY_COUNT_KEY, i);
    }

    public void setDebug(boolean z) {
        this.mSharedPrefsWrapper.putBoolean(SP_FETCH_DEBUG_KEY, z);
    }

    public synchronized void saveOriginTimerData(String str, JSONObject jSONObject) {
        JSONArray jSONArray;
        String string = this.mSharedPrefsWrapper.getString(SP_TASK_ORIGIN_TIMER_LIST_KEY, "");
        try {
            if (TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(string);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("jobId", str);
            jSONObject2.put(JSON_TIMER_JOB_ORIGIN_KEY, jSONObject);
            jSONArray.put(jSONObject2);
            this.mSharedPrefsWrapper.putString(SP_TASK_ORIGIN_TIMER_LIST_KEY, jSONArray.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, e.getMessage());
            }
        }
    }
}
