package com.baidu.searchbox.retrieve.timer.bean;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.retrieve.file.util.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FetchTimer extends FetchBasicTimer {
    public static final String END_TIME = "endTime";
    public static final String FREQUENCY = "frequency";
    public static final String MAX_TOTAL_FILE_SIZE = "maxTotalFileSize";
    public static final String NETWORK = "network";
    public static final String SPACE = "space";
    public static final String START_TIME = "startTime";

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static FetchTimerBean parseJsonContent(JSONObject jSONObject) {
        FetchTimerBasicBean parseJsonContent;
        JSONObject optJSONObject;
        String str;
        String str2;
        JSONObject jSONObject2;
        String str3;
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
            String optString = optJSONObject.optString("startTime");
            String optString2 = optJSONObject.optString("endTime");
            long parseLong = Long.parseLong(optString) * 1000;
            long parseLong2 = Long.parseLong(optString2) * 1000;
            ArrayList arrayList = new ArrayList();
            String optString3 = optJSONObject.optString("space");
            if (!TextUtils.isEmpty(optString3)) {
                try {
                    arrayList.addAll(Arrays.asList(optString3.split(",")));
                } catch (Exception e) {
                    e = e;
                    jSONObject2 = jSONObject;
                    str = version;
                    str3 = type;
                    str2 = jobId;
                    FetchBasicTimer.reportTaskCheckFail(str3, str2, str, jSONObject2);
                    if (FetchBasicTimer.DEBUG) {
                    }
                    FetchBasicTimer.reportTaskCheckFail(str3, str2, str, jSONObject2);
                    return null;
                }
            }
            String optString4 = optJSONObject.optString("network");
            long parseLong3 = Long.parseLong(optJSONObject.optString("maxTotalFileSize"));
            String optString5 = optJSONObject.optString(FREQUENCY);
            if (TextUtils.isEmpty(optString5)) {
                FetchBasicTimer.reportTaskCheckFail(type, jobId, version, jSONObject);
            }
            str = version;
            str2 = jobId;
            try {
                return new FetchTimerBean(jobId, type, version, expiredTime, parseLong, parseLong2, parseLong3, arrayList, optString4, Integer.parseInt(optString5));
            } catch (Exception e2) {
                e = e2;
                jSONObject2 = jSONObject;
                str3 = type;
                FetchBasicTimer.reportTaskCheckFail(str3, str2, str, jSONObject2);
                if (FetchBasicTimer.DEBUG) {
                    Log.d(FetchBasicTimer.TAG, e.getMessage());
                }
                FetchBasicTimer.reportTaskCheckFail(str3, str2, str, jSONObject2);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            str = version;
            str2 = jobId;
            jSONObject2 = jSONObject;
            str3 = type;
        }
    }
}
