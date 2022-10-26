package com.baidu.searchbox.live.ubc;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class FlowInfoHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Boolean IS_CLIENT;
    public static final Boolean IS_DEBUG;
    public static final String KEY_EVENTLIST = "eventlist";
    public static final String KEY_EVENTLIST_ID = "id";
    public static final String KEY_EVENTLIST_T = "timestamp";
    public static final String KEY_IS_CLOSED = "is_closed";
    public static final String KEY_IS_COLDLAUNCH = "isColdLaunch";
    public static final String KEY_LAST_LINK_SLOT_TAG = "last_link_slot_tag";
    public static final String KEY_LAST_SLOT = "last_slot";
    public static final String KEY_LINKED_PART = "linked_part";
    public static final String KEY_PART = "part";
    public static final String KEY_PART_D = "d";
    public static final String KEY_PART_DURATION = "launch_duration";
    public static final String KEY_PART_ID = "id";
    public static final String KEY_PART_STARTTIME = "part_starttime";
    public static final String KEY_PLUGIN_INFO = "plugininfo";
    public static final String KEY_ROOM_ID = "roomID";
    public static final String KEY_SIGLE_EVENTLIST = "sigle_eventlist";
    public static final String KEY_SIGLE_PART = "sigle_part";
    public static final String TAG = "lp-ubcClient";
    public static final String V_SLOT_LINK_CONNECTOR = "_to_";
    public static HashMap flowInfo;
    public static HashMap mLaunchInfo;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(355764815, "Lcom/baidu/searchbox/live/ubc/FlowInfoHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(355764815, "Lcom/baidu/searchbox/live/ubc/FlowInfoHelper;");
                return;
            }
        }
        IS_DEBUG = Boolean.TRUE;
        IS_CLIENT = Boolean.FALSE;
        flowInfo = new HashMap();
    }

    public FlowInfoHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void addRoomId(String str, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, hashMap) == null) {
            if (TextUtils.isEmpty(str)) {
                mLaunchInfo = hashMap;
            } else {
                flowInfo.put(str, hashMap);
            }
        }
    }

    public static void addSigleStartTime(HashMap hashMap, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, hashMap, str) == null) {
            HashMap hashMap2 = (HashMap) hashMap.get(KEY_SIGLE_EVENTLIST);
            if (hashMap2 == null) {
                hashMap2 = new HashMap();
                hashMap.put(KEY_SIGLE_EVENTLIST, hashMap2);
            }
            hashMap2.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static Object get(HashMap hashMap, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, hashMap, str)) == null) {
            if (hashMap != null && str != null) {
                return hashMap.get(str);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static Long getSigleStartTime(HashMap hashMap, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, hashMap, str)) == null) {
            HashMap hashMap2 = (HashMap) hashMap.get(KEY_SIGLE_EVENTLIST);
            if (hashMap2 != null) {
                return (Long) hashMap2.get(str);
            }
            return null;
        }
        return (Long) invokeLL.objValue;
    }

    public static Object remove(HashMap hashMap, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, hashMap, str)) == null) {
            if (hashMap != null && str != null) {
                return hashMap.remove(str);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static Long removeSingleStartTime(HashMap hashMap, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, hashMap, str)) == null) {
            HashMap hashMap2 = (HashMap) hashMap.get(KEY_SIGLE_EVENTLIST);
            if (hashMap2 != null) {
                return (Long) hashMap2.remove(str);
            }
            return null;
        }
        return (Long) invokeLL.objValue;
    }

    public static HashMap createFlow(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (IS_DEBUG.booleanValue()) {
                logDebug("createEmptyFlow " + str);
            }
            HashMap hashMap = new HashMap();
            put(hashMap, KEY_PART_STARTTIME, Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.isEmpty(str)) {
                put(hashMap, KEY_ROOM_ID, str);
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static JSONArray eventlistToJSONArray(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, hashMap)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry entry : hashMap.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("id", entry.getKey());
                    jSONObject.putOpt("timestamp", String.valueOf(((float) ((Long) entry.getValue()).longValue()) / 1000.0f));
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static JSONArray partToJSONArray(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, hashMap)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry entry : hashMap.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("id", entry.getKey());
                    jSONObject.putOpt("d", String.valueOf(((Long) entry.getValue()).longValue() / 1000));
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static void endAllSigleSlot(HashMap hashMap) {
        HashMap hashMap2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, hashMap) == null) && (hashMap2 = (HashMap) hashMap.get(KEY_SIGLE_EVENTLIST)) != null) {
            for (Map.Entry entry : hashMap2.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    Long valueOf = Long.valueOf(System.currentTimeMillis() - ((Long) entry.getValue()).longValue());
                    if (IS_DEBUG.booleanValue()) {
                        logDebug("endAllSigleSlot " + ((String) entry.getKey()) + ": " + valueOf);
                    }
                    getAndCreatePartList(hashMap).put(entry.getKey(), valueOf);
                }
            }
            hashMap2.clear();
        }
    }

    public static HashMap endFlow(String str, HashMap hashMap, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, str, hashMap, str2)) == null) {
            if (IS_DEBUG.booleanValue()) {
                logDebug("endFlow " + str);
            }
            Object obj = get(hashMap, KEY_PART_STARTTIME);
            if (obj instanceof Long) {
                put(hashMap, KEY_PART_DURATION, Float.valueOf(((float) (System.currentTimeMillis() - ((Long) obj).longValue())) / 1000.0f));
            }
            if (!TextUtils.isEmpty(str)) {
                Object obj2 = get(hashMap, KEY_ROOM_ID);
                if ((obj2 instanceof String) && !TextUtils.isEmpty((String) obj2) && !str.equals(obj2) && IS_DEBUG.booleanValue()) {
                    logDebug("popLaunchInfo " + str + " != " + obj2 + "(old)");
                }
            }
            endAllSigleSlot(hashMap);
            startSigleLineSlot(hashMap, str2, false);
            put(hashMap, KEY_IS_CLOSED, Boolean.TRUE);
            return hashMap;
        }
        return (HashMap) invokeLLL.objValue;
    }

    public static void flowEndLinkSlot(HashMap hashMap, String str, String str2) {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, hashMap, str, str2) == null) {
            if (hashMap == null) {
                if (IS_DEBUG.booleanValue()) {
                    logDebug("flowEndLinkSlot " + str + " tobe " + str2 + " with map null return");
                    return;
                }
                return;
            }
            HashMap hashMap2 = (HashMap) hashMap.get(KEY_EVENTLIST);
            if (hashMap2 != null && (l = (Long) hashMap2.get(str)) != null) {
                long currentTimeMillis = System.currentTimeMillis() - l.longValue();
                if (IS_CLIENT.booleanValue()) {
                    getAndCreatePartList(hashMap).put(str2, Long.valueOf(currentTimeMillis));
                }
                getAndCreateLinkedPartList(hashMap).put(str2, Long.valueOf(currentTimeMillis));
                if (IS_DEBUG.booleanValue()) {
                    logDebug("flowEndLinkSlot " + str + " tobe " + str2 + " " + currentTimeMillis);
                }
            }
        }
    }

    public static void endSingleSlot(HashMap hashMap, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, hashMap, str) == null) {
            if (hashMap == null) {
                if (IS_DEBUG.booleanValue()) {
                    logDebug("flowEndSlot " + str + " with map null return");
                    return;
                }
                return;
            }
            Long removeSingleStartTime = removeSingleStartTime(hashMap, str);
            if (removeSingleStartTime != null) {
                long currentTimeMillis = System.currentTimeMillis() - removeSingleStartTime.longValue();
                if (IS_DEBUG.booleanValue()) {
                    logDebug("+ endSlot " + str + ": " + currentTimeMillis);
                }
                getAndCreatePartList(hashMap).put(str, Long.valueOf(currentTimeMillis));
            }
        }
    }

    public static HashMap getAndCreateEventList(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, hashMap)) == null) {
            HashMap hashMap2 = (HashMap) hashMap.get(KEY_EVENTLIST);
            if (hashMap2 == null) {
                HashMap hashMap3 = new HashMap();
                hashMap.put(KEY_EVENTLIST, hashMap3);
                return hashMap3;
            }
            return hashMap2;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap getAndCreateLinkedPartList(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, hashMap)) == null) {
            LinkedHashMap linkedHashMap = (LinkedHashMap) hashMap.get(KEY_LINKED_PART);
            if (linkedHashMap == null) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                hashMap.put(KEY_LINKED_PART, linkedHashMap2);
                return linkedHashMap2;
            }
            return linkedHashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap getAndCreatePartList(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, hashMap)) == null) {
            HashMap hashMap2 = (HashMap) hashMap.get("part");
            if (hashMap2 == null) {
                HashMap hashMap3 = new HashMap();
                hashMap.put("part", hashMap3);
                return hashMap3;
            }
            return hashMap2;
        }
        return (HashMap) invokeL.objValue;
    }

    public static boolean isFlowClosed(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, hashMap)) == null) {
            Object obj = get(hashMap, KEY_IS_CLOSED);
            if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void logDebug(String str) {
        AppInfoService appInfoService;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, null, str) == null) && (appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE())) != null && appInfoService.isDebug()) {
            Log.d(TAG, str);
        }
    }

    private HashMap remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                HashMap hashMap = mLaunchInfo;
                mLaunchInfo = null;
                return hashMap;
            }
            HashMap hashMap2 = (HashMap) flowInfo.remove(str);
            if (hashMap2 == null) {
                HashMap hashMap3 = mLaunchInfo;
                mLaunchInfo = null;
                return hashMap3;
            }
            return hashMap2;
        }
        return (HashMap) invokeL.objValue;
    }

    public static void updateFlow(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, hashMap) == null) {
            mLaunchInfo = hashMap;
        }
    }

    public static HashMap popFlow(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (IS_DEBUG.booleanValue()) {
                logDebug("popFlow " + str);
            }
            HashMap hashMap = mLaunchInfo;
            updateFlow(null);
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public HashMap getOrCreateFlowInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                startNewFlow(str, false);
                return mLaunchInfo;
            }
            HashMap hashMap = (HashMap) flowInfo.get(str);
            if (hashMap == null) {
                if (mLaunchInfo == null) {
                    startNewFlow(str, true);
                }
                hashMap = mLaunchInfo;
                addRoomId(str, hashMap);
                mLaunchInfo = null;
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static void put(HashMap hashMap, String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65555, null, hashMap, str, obj) == null) && hashMap != null) {
            if (IS_DEBUG.booleanValue()) {
                logDebug("+ " + str + ": " + obj);
            }
            hashMap.put(str, obj);
        }
    }

    public static HashMap startNewFlow(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65559, null, str, z)) == null) {
            HashMap hashMap = mLaunchInfo;
            if (hashMap != null && !isFlowClosed(hashMap) && !z) {
                if (!TextUtils.isEmpty(str)) {
                    Object obj = get(mLaunchInfo, KEY_ROOM_ID);
                    if ((obj instanceof String) && !TextUtils.isEmpty((String) obj) && !str.equals(obj)) {
                        if (IS_DEBUG.booleanValue()) {
                            logDebug("startNewFlow " + str + " != " + obj + "(old)");
                        }
                        mLaunchInfo = null;
                    }
                }
            } else {
                if (IS_DEBUG.booleanValue()) {
                    logDebug("createFlow " + str + ", force: " + z);
                }
                mLaunchInfo = createFlow(str);
            }
            return mLaunchInfo;
        }
        return (HashMap) invokeLZ.objValue;
    }

    public static void startSingleSlot(HashMap hashMap, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, hashMap, str) == null) {
            if (hashMap == null) {
                if (IS_DEBUG.booleanValue()) {
                    logDebug("flowStartSlot: " + str + " with map null return");
                }
            } else if (isFlowClosed(hashMap)) {
                if (IS_DEBUG.booleanValue()) {
                    logDebug("flowStartSlot: " + str + " with closed");
                }
            } else if (getSigleStartTime(hashMap, str) != null) {
                if (IS_DEBUG.booleanValue()) {
                    logDebug("flowStartSlot: " + str + " has same slot return");
                }
            } else {
                if (IS_DEBUG.booleanValue()) {
                    logDebug("flowStartSlot: " + str);
                }
                addSigleStartTime(hashMap, str);
            }
        }
    }

    public static void startSigleLineSlot(HashMap hashMap, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65560, null, hashMap, str, z) == null) {
            if (hashMap == null) {
                if (IS_DEBUG.booleanValue()) {
                    logDebug("staSigLin: " + str + ", link: " + z);
                }
            } else if (isFlowClosed(hashMap)) {
                if (IS_DEBUG.booleanValue()) {
                    logDebug("startSigleLineSlot: " + str + " with closed");
                }
            } else {
                Object remove = remove(hashMap, KEY_LAST_LINK_SLOT_TAG);
                if (remove instanceof String) {
                    String str2 = (String) remove;
                    if (!TextUtils.isEmpty(str2)) {
                        if (TextUtils.isEmpty(str)) {
                            flowEndLinkSlot(hashMap, str2, str2);
                        } else if (remove.equals(str)) {
                            if (IS_DEBUG.booleanValue()) {
                                logDebug("staSigLin: " + str + " is same cur LinkSlot return");
                            }
                            put(hashMap, KEY_LAST_LINK_SLOT_TAG, str);
                            return;
                        } else {
                            flowEndLinkSlot(hashMap, str2, str2 + V_SLOT_LINK_CONNECTOR + str);
                        }
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    getAndCreateEventList(hashMap).put(str, Long.valueOf(System.currentTimeMillis()));
                    if (z) {
                        put(hashMap, KEY_LAST_LINK_SLOT_TAG, str);
                    }
                }
            }
        }
    }

    public static JSONObject toJson(HashMap hashMap, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, hashMap, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                if (KEY_LINKED_PART.equals(entry.getKey())) {
                    if (entry.getValue() != null) {
                        try {
                            JSONObject jSONObject2 = new JSONObject((LinkedHashMap) entry.getValue());
                            if (IS_DEBUG.booleanValue()) {
                                logDebug("linked toJson part: " + jSONObject2.toString());
                            }
                            jSONObject.put("part", jSONObject2);
                        } catch (Exception e) {
                            logDebug(e.getMessage());
                            e.printStackTrace();
                        }
                    }
                } else if (KEY_EVENTLIST.equals(entry.getKey())) {
                    if (entry.getValue() != null) {
                        try {
                            JSONObject jSONObject3 = new JSONObject((HashMap) entry.getValue());
                            if (IS_DEBUG.booleanValue()) {
                                logDebug("toJson eventlist: " + jSONObject3.toString());
                            }
                            jSONObject.put(KEY_EVENTLIST, jSONObject3);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            logDebug("toJson eventlist: " + e2.getMessage());
                        }
                    }
                } else if ("part".equals(entry.getKey())) {
                    if (entry.getValue() != null) {
                        try {
                            JSONObject jSONObject4 = new JSONObject((HashMap) entry.getValue());
                            if (IS_DEBUG.booleanValue()) {
                                logDebug("sigleList toJson sigle_part: " + jSONObject4.toString());
                            }
                            jSONObject.put(KEY_SIGLE_PART, jSONObject4);
                        } catch (Exception e3) {
                            logDebug(e3.getMessage());
                            e3.printStackTrace();
                        }
                    }
                } else {
                    try {
                        jSONObject.put((String) entry.getKey(), entry.getValue());
                        if (IS_DEBUG.booleanValue()) {
                            logDebug("toJson " + ((String) entry.getKey()) + ": " + entry.getValue());
                        }
                    } catch (Exception e4) {
                        logDebug(e4.getMessage());
                        e4.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
