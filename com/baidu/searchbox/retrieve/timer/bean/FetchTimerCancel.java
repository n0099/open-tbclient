package com.baidu.searchbox.retrieve.timer.bean;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.retrieve.file.util.Constants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FetchTimerCancel extends FetchBasicTimer {
    public static final String CANCEL_JOB_ID = "jobId";

    public static FetchTimerCancelBean parseJsonContent(JSONObject jSONObject) {
        FetchTimerBasicBean parseJsonContent;
        JSONObject optJSONObject;
        if (jSONObject == null || (parseJsonContent = FetchBasicTimer.parseJsonContent(jSONObject)) == null || (optJSONObject = jSONObject.optJSONObject("info")) == null) {
            return null;
        }
        String type = parseJsonContent.getType();
        if (!TextUtils.equals(Constants.FetchType.FETCH_TIMER_TYPE, type)) {
            return null;
        }
        String jobId = parseJsonContent.getJobId();
        String version = parseJsonContent.getVersion();
        try {
            long expiredTime = parseJsonContent.getExpiredTime();
            String optString = optJSONObject.optString("jobId");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            return new FetchTimerCancelBean(jobId, type, version, expiredTime, optString);
        } catch (Exception e) {
            FetchBasicTimer.reportTaskCheckFail(type, jobId, version, jSONObject);
            if (FetchBasicTimer.DEBUG) {
                Log.d(FetchBasicTimer.TAG, e.getMessage());
            }
            FetchBasicTimer.reportTaskCheckFail(type, jobId, version, jSONObject);
            return null;
        }
    }
}
