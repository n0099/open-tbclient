package com.baidu.searchbox.player.policy;

import android.text.TextUtils;
import com.baidu.searchbox.player.helper.PlayPerRecord;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PrefetchPolicy {
    public static final String PRELINNK_TAG = "PreLink";
    public static final String TAG = "SmartPrefetchPolicy";
    public String calcCnt;
    public String coeDeviceDynamic;
    public String coeDeviceStatic;
    public String coeDuration;
    public String coeNetwork;
    public String ctrPass;
    public String expiredCount;
    public String expiredTime;
    public String lineDuration;

    public String getThreshold() {
        return this.lineDuration;
    }

    public static boolean isValid(PrefetchPolicy prefetchPolicy) {
        if (prefetchPolicy != null && !TextUtils.isEmpty(prefetchPolicy.lineDuration) && !TextUtils.isEmpty(prefetchPolicy.expiredTime) && !TextUtils.isEmpty(prefetchPolicy.expiredCount)) {
            return true;
        }
        return false;
    }

    public static Map<String, String> jsonToMap(JSONObject jSONObject) {
        PrefetchPolicy jsonToModel = jsonToModel(jSONObject);
        if (jsonToModel == null) {
            return null;
        }
        return modelToMap(jsonToModel);
    }

    public static PrefetchPolicy jsonToModel(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PrefetchPolicy prefetchPolicy = new PrefetchPolicy();
        prefetchPolicy.lineDuration = jSONObject.optString("line_duration");
        prefetchPolicy.expiredTime = jSONObject.optString("expired_time");
        prefetchPolicy.expiredCount = jSONObject.optString("expired_count");
        prefetchPolicy.calcCnt = jSONObject.optString("calc_cnt");
        prefetchPolicy.ctrPass = jSONObject.optString("ctr_pass");
        prefetchPolicy.coeDuration = jSONObject.optString("coe_duration");
        prefetchPolicy.coeNetwork = jSONObject.optString("coe_network");
        prefetchPolicy.coeDeviceStatic = jSONObject.optString("coe_device_static");
        prefetchPolicy.coeDeviceDynamic = jSONObject.optString("coe_device_dynamic");
        return prefetchPolicy;
    }

    public static Map<String, String> modelToMap(PrefetchPolicy prefetchPolicy) {
        if (prefetchPolicy == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lineDuration", prefetchPolicy.lineDuration);
        hashMap.put("expiredTime", prefetchPolicy.expiredTime);
        hashMap.put("expiredCount", prefetchPolicy.expiredCount);
        hashMap.put("calcCnt", prefetchPolicy.calcCnt);
        hashMap.put("ctrPass", prefetchPolicy.ctrPass);
        hashMap.put("coeDuration", prefetchPolicy.coeDuration);
        hashMap.put("coeNetwork", prefetchPolicy.coeNetwork);
        hashMap.put("coeDeviceStatic", prefetchPolicy.coeDeviceStatic);
        hashMap.put("coeDeviceDynamic", prefetchPolicy.coeDeviceDynamic);
        return hashMap;
    }

    public static PrefetchPolicy mapToModel(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        PrefetchPolicy prefetchPolicy = new PrefetchPolicy();
        prefetchPolicy.lineDuration = map.get("lineDuration");
        prefetchPolicy.expiredTime = map.get("expiredTime");
        prefetchPolicy.expiredCount = map.get("expiredCount");
        prefetchPolicy.calcCnt = map.get("calcCnt");
        prefetchPolicy.ctrPass = map.get("ctrPass");
        prefetchPolicy.coeDuration = map.get("coeDuration");
        prefetchPolicy.coeNetwork = map.get("coeNetwork");
        prefetchPolicy.coeDeviceStatic = map.get("coeDeviceStatic");
        prefetchPolicy.coeDeviceDynamic = map.get("coeDeviceDynamic");
        if (!isValid(prefetchPolicy)) {
            return null;
        }
        return prefetchPolicy;
    }

    public static boolean needPrefetch(PrefetchPolicy prefetchPolicy) {
        int i;
        if (prefetchPolicy == null) {
            return true;
        }
        int parseIntSafe = BdPlayerUtils.parseIntSafe(prefetchPolicy.lineDuration);
        int parseIntSafe2 = BdPlayerUtils.parseIntSafe(prefetchPolicy.expiredTime);
        int parseIntSafe3 = BdPlayerUtils.parseIntSafe(prefetchPolicy.expiredCount);
        int parseIntSafe4 = BdPlayerUtils.parseIntSafe(prefetchPolicy.calcCnt, 1);
        if (parseIntSafe > 0 && parseIntSafe2 > 0 && parseIntSafe3 > 0) {
            long j = 0;
            int size = PlayPerRecord.sRecords.size();
            int i2 = size - 1;
            int i3 = 0;
            while (size >= parseIntSafe4 && i2 >= 0) {
                PlayPerRecord.PerRecord perRecord = PlayPerRecord.sRecords.get(i2);
                i = parseIntSafe;
                if (Math.abs(perRecord.endTime - System.currentTimeMillis()) < parseIntSafe2) {
                    BdVideoLog.d(TAG, "=======>calculate record : " + perRecord);
                    j += perRecord.getDuration();
                    i3++;
                    if (i3 >= parseIntSafe3) {
                        break;
                    }
                }
                i2--;
                parseIntSafe = i;
            }
            i = parseIntSafe;
            if (i3 > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("=======>average time : ");
                long j2 = j / i3;
                sb.append(j2);
                BdVideoLog.d(TAG, sb.toString());
                if (j2 < i) {
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public String toString() {
        return "SmartPrefetchPolicy{lineDuration='" + this.lineDuration + "', expiredTime='" + this.expiredTime + "', expiredCount='" + this.expiredCount + "', calcCnt='" + this.calcCnt + "', ctrPass='" + this.ctrPass + "', coeDuration='" + this.coeDuration + "', coeNetwork='" + this.coeNetwork + "', coeDeviceStatic='" + this.coeDeviceStatic + "', coeDeviceDynamic='" + this.coeDeviceDynamic + "'}";
    }
}
