package com.baidu.searchbox.live.ubc;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class FlowInfoHelper {
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
    public static HashMap<String, Object> mLaunchInfo;
    public static final Boolean IS_DEBUG = Boolean.TRUE;
    public static final Boolean IS_CLIENT = Boolean.FALSE;
    public static HashMap<String, HashMap<String, Object>> flowInfo = new HashMap<>();

    private void addRoomId(String str, HashMap<String, Object> hashMap) {
        if (TextUtils.isEmpty(str)) {
            mLaunchInfo = hashMap;
        } else {
            flowInfo.put(str, hashMap);
        }
    }

    public static void addSigleStartTime(HashMap<String, Object> hashMap, String str) {
        HashMap hashMap2 = (HashMap) hashMap.get(KEY_SIGLE_EVENTLIST);
        if (hashMap2 == null) {
            hashMap2 = new HashMap();
            hashMap.put(KEY_SIGLE_EVENTLIST, hashMap2);
        }
        hashMap2.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static Object get(HashMap<String, Object> hashMap, String str) {
        if (hashMap != null && str != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public static Long getSigleStartTime(HashMap<String, Object> hashMap, String str) {
        HashMap hashMap2 = (HashMap) hashMap.get(KEY_SIGLE_EVENTLIST);
        if (hashMap2 != null) {
            return (Long) hashMap2.get(str);
        }
        return null;
    }

    public static Object remove(HashMap<String, Object> hashMap, String str) {
        if (hashMap != null && str != null) {
            return hashMap.remove(str);
        }
        return null;
    }

    public static Long removeSingleStartTime(HashMap<String, Object> hashMap, String str) {
        HashMap hashMap2 = (HashMap) hashMap.get(KEY_SIGLE_EVENTLIST);
        if (hashMap2 != null) {
            return (Long) hashMap2.remove(str);
        }
        return null;
    }

    public static HashMap<String, Object> createFlow(String str) {
        if (IS_DEBUG.booleanValue()) {
            logDebug("createEmptyFlow " + str);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        put(hashMap, KEY_PART_STARTTIME, Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            put(hashMap, KEY_ROOM_ID, str);
        }
        return hashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: java.util.HashMap<java.lang.String, java.lang.Long> */
    /* JADX WARN: Multi-variable type inference failed */
    public static void endAllSigleSlot(HashMap<String, Object> hashMap) {
        HashMap hashMap2 = (HashMap) hashMap.get(KEY_SIGLE_EVENTLIST);
        if (hashMap2 != null) {
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

    public static HashMap<String, Object> endFlow(String str, HashMap<String, Object> hashMap, String str2) {
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

    public static void endSingleSlot(HashMap<String, Object> hashMap, String str) {
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

    public static JSONArray eventlistToJSONArray(HashMap<String, Long> hashMap) {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("id", entry.getKey());
                jSONObject.putOpt("timestamp", String.valueOf(((float) entry.getValue().longValue()) / 1000.0f));
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray;
    }

    public static JSONArray partToJSONArray(HashMap<String, Long> hashMap) {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("id", entry.getKey());
                jSONObject.putOpt("d", String.valueOf(entry.getValue().longValue() / 1000));
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray;
    }

    public static void flowEndLinkSlot(HashMap<String, Object> hashMap, String str, String str2) {
        Long l;
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

    public static HashMap<String, Long> getAndCreateEventList(HashMap<String, Object> hashMap) {
        HashMap<String, Long> hashMap2 = (HashMap) hashMap.get(KEY_EVENTLIST);
        if (hashMap2 == null) {
            HashMap<String, Long> hashMap3 = new HashMap<>();
            hashMap.put(KEY_EVENTLIST, hashMap3);
            return hashMap3;
        }
        return hashMap2;
    }

    public static HashMap<String, Long> getAndCreateLinkedPartList(HashMap<String, Object> hashMap) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) hashMap.get(KEY_LINKED_PART);
        if (linkedHashMap == null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            hashMap.put(KEY_LINKED_PART, linkedHashMap2);
            return linkedHashMap2;
        }
        return linkedHashMap;
    }

    public static HashMap<String, Long> getAndCreatePartList(HashMap<String, Object> hashMap) {
        HashMap<String, Long> hashMap2 = (HashMap) hashMap.get("part");
        if (hashMap2 == null) {
            HashMap<String, Long> hashMap3 = new HashMap<>();
            hashMap.put("part", hashMap3);
            return hashMap3;
        }
        return hashMap2;
    }

    public static boolean isFlowClosed(HashMap<String, Object> hashMap) {
        Object obj = get(hashMap, KEY_IS_CLOSED);
        if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
            return true;
        }
        return false;
    }

    public static void logDebug(String str) {
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null && appInfoService.isDebug()) {
            Log.d(TAG, str);
        }
    }

    public static HashMap<String, Object> popFlow(String str) {
        if (IS_DEBUG.booleanValue()) {
            logDebug("popFlow " + str);
        }
        HashMap<String, Object> hashMap = mLaunchInfo;
        updateFlow(null);
        return hashMap;
    }

    private HashMap<String, Object> remove(String str) {
        if (TextUtils.isEmpty(str)) {
            HashMap<String, Object> hashMap = mLaunchInfo;
            mLaunchInfo = null;
            return hashMap;
        }
        HashMap<String, Object> remove = flowInfo.remove(str);
        if (remove == null) {
            HashMap<String, Object> hashMap2 = mLaunchInfo;
            mLaunchInfo = null;
            return hashMap2;
        }
        return remove;
    }

    public static void updateFlow(HashMap<String, Object> hashMap) {
        mLaunchInfo = hashMap;
    }

    public HashMap<String, Object> getOrCreateFlowInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            startNewFlow(str, false);
            return mLaunchInfo;
        }
        HashMap<String, Object> hashMap = flowInfo.get(str);
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

    public static void put(HashMap<String, Object> hashMap, String str, Object obj) {
        if (hashMap != null) {
            if (IS_DEBUG.booleanValue()) {
                logDebug("+ " + str + ": " + obj);
            }
            hashMap.put(str, obj);
        }
    }

    public static HashMap<String, Object> startNewFlow(String str, boolean z) {
        HashMap<String, Object> hashMap = mLaunchInfo;
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

    public static void startSingleSlot(HashMap<String, Object> hashMap, String str) {
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

    public static void startSigleLineSlot(HashMap<String, Object> hashMap, String str, boolean z) {
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

    public static JSONObject toJson(HashMap<String, Object> hashMap, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
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
                    jSONObject.put(entry.getKey(), entry.getValue());
                    if (IS_DEBUG.booleanValue()) {
                        logDebug("toJson " + entry.getKey() + ": " + entry.getValue());
                    }
                } catch (Exception e4) {
                    logDebug(e4.getMessage());
                    e4.printStackTrace();
                }
            }
        }
        return jSONObject;
    }
}
