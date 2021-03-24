package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RetrieveTaskManager {
    public static final String ACTION_FETCH_LOG_NOTICE = "fetch_log_notice";
    public static final String DATA = "data";
    public static final String KEY = "api";
    public static final String TAG = "RetrieveTaskManager";
    public static volatile RetrieveTaskManager instance;
    public Context mContext;

    public RetrieveTaskManager(Context context) {
        this.mContext = context;
    }

    public static RetrieveTaskManager getInstance(Context context) {
        if (instance == null) {
            synchronized (RetrieveTaskManager.class) {
                if (instance == null) {
                    instance = new RetrieveTaskManager(context);
                }
            }
        }
        return instance;
    }

    public void dispatch(JSONObject jSONObject) {
        if (jSONObject == null) {
            LogUtils.d(TAG, "retrieve-->dispatch jsondata is null");
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            LogUtils.d(TAG, "retrieve-->dispatch jsondata data value is null");
            return;
        }
        String optString = optJSONObject.optString(KEY);
        if (!TextUtils.equals(ACTION_FETCH_LOG_NOTICE, optString)) {
            LogUtils.d(TAG, "retrieve-->dispatch jsondata api value not equal fetch_log_notice:" + optString);
            return;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 == null) {
            LogUtils.d(TAG, "retrieve-->dispatch jsondata inner data value is null");
        } else {
            RetrieveProcesser.process(optJSONObject2, this.mContext);
        }
    }
}
