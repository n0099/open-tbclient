package com.baidu.searchbox.player.policy;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.helper.PlayPerRecord;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PrefetchPolicy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PRELINNK_TAG = "PreLink";
    public static final String TAG = "SmartPrefetchPolicy";
    public transient /* synthetic */ FieldHolder $fh;
    public String calcCnt;
    public String coeDeviceDynamic;
    public String coeDeviceStatic;
    public String coeDuration;
    public String coeNetwork;
    public String ctrPass;
    public String expiredCount;
    public String expiredTime;
    public String lineDuration;

    public PrefetchPolicy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String getThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.lineDuration;
        }
        return (String) invokeV.objValue;
    }

    public static boolean isValid(PrefetchPolicy prefetchPolicy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, prefetchPolicy)) == null) {
            if (prefetchPolicy != null && !TextUtils.isEmpty(prefetchPolicy.lineDuration) && !TextUtils.isEmpty(prefetchPolicy.expiredTime) && !TextUtils.isEmpty(prefetchPolicy.expiredCount)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static Map jsonToMap(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            PrefetchPolicy jsonToModel = jsonToModel(jSONObject);
            if (jsonToModel == null) {
                return null;
            }
            return modelToMap(jsonToModel);
        }
        return (Map) invokeL.objValue;
    }

    public static PrefetchPolicy jsonToModel(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
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
        return (PrefetchPolicy) invokeL.objValue;
    }

    public static PrefetchPolicy mapToModel(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, map)) == null) {
            if (map == null) {
                return null;
            }
            PrefetchPolicy prefetchPolicy = new PrefetchPolicy();
            prefetchPolicy.lineDuration = (String) map.get("lineDuration");
            prefetchPolicy.expiredTime = (String) map.get("expiredTime");
            prefetchPolicy.expiredCount = (String) map.get("expiredCount");
            prefetchPolicy.calcCnt = (String) map.get("calcCnt");
            prefetchPolicy.ctrPass = (String) map.get("ctrPass");
            prefetchPolicy.coeDuration = (String) map.get("coeDuration");
            prefetchPolicy.coeNetwork = (String) map.get("coeNetwork");
            prefetchPolicy.coeDeviceStatic = (String) map.get("coeDeviceStatic");
            prefetchPolicy.coeDeviceDynamic = (String) map.get("coeDeviceDynamic");
            if (!isValid(prefetchPolicy)) {
                return null;
            }
            return prefetchPolicy;
        }
        return (PrefetchPolicy) invokeL.objValue;
    }

    public static Map modelToMap(PrefetchPolicy prefetchPolicy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, prefetchPolicy)) == null) {
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
        return (Map) invokeL.objValue;
    }

    public static boolean needPrefetch(PrefetchPolicy prefetchPolicy) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, prefetchPolicy)) == null) {
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
                    PlayPerRecord.PerRecord perRecord = (PlayPerRecord.PerRecord) PlayPerRecord.sRecords.get(i2);
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
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SmartPrefetchPolicy{lineDuration='" + this.lineDuration + "', expiredTime='" + this.expiredTime + "', expiredCount='" + this.expiredCount + "', calcCnt='" + this.calcCnt + "', ctrPass='" + this.ctrPass + "', coeDuration='" + this.coeDuration + "', coeNetwork='" + this.coeNetwork + "', coeDeviceStatic='" + this.coeDeviceStatic + "', coeDeviceDynamic='" + this.coeDeviceDynamic + "'}";
        }
        return (String) invokeV.objValue;
    }
}
