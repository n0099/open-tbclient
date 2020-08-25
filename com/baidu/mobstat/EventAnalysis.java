package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.mobstat.Config;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class EventAnalysis {
    private Map<String, a> a = new HashMap();

    public void onEvent(Context context, long j, String str, String str2, int i, long j2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        a(context, j, str, str2, i, j2, 0L, extraInfo, map, z);
    }

    public void onEvent(Context context, long j, String str, String str2, int i, long j2, String str3, String str4, int i2, boolean z) {
        a(context, j, str, str2, i, j2, 0L, str3, str4, i2);
    }

    public void onEvent(Context context, long j, String str, String str2, int i, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        flushEvent(context, j, str, str2, i, j2, jSONArray, jSONArray2, str3, str4, str5, map, z);
    }

    public void onEventStart(Context context, String str, String str2, long j) {
        a aVar = new a();
        aVar.c = j;
        aVar.a = str;
        aVar.b = str2;
        String a2 = a(str, str2);
        if (this.a.containsKey(a2)) {
            bc.c().b("[WARNING] eventId: " + str + ", with label: " + str2 + " is duplicated, older is removed");
        }
        this.a.put(a2, aVar);
    }

    public void onEventEnd(Context context, long j, String str, String str2, long j2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        String a2 = a(str, str2);
        a aVar = this.a.get(a2);
        if (aVar == null) {
            bc.c().b("[WARNING] eventId: " + str + ", with label: " + str2 + " is not started or alread ended");
        } else if ((str != null && !str.equals(aVar.a)) || (str2 != null && !str2.equals(aVar.b))) {
            bc.c().b("[WARNING] eventId/label pair not match");
        } else {
            this.a.remove(a2);
            long j3 = j2 - aVar.c;
            if (j3 < 0) {
                bc.c().b("[WARNING] onEventEnd must be invoked after onEventStart");
            }
            onEventDuration(context, j, str, str2, aVar.c, j3, extraInfo, map, z);
        }
    }

    public void onEventDuration(Context context, long j, String str, String str2, long j2, long j3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        if (j3 > 0) {
            a(context, j, str, str2, 1, j2, j3, extraInfo, map, z);
        }
    }

    private void a(Context context, long j, String str, String str2, int i, long j2, long j3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        DataCore.instance().putEvent(context, getEvent(context, j, str, str2, i, j2, j3, "", "", 0, 0, extraInfo, map, z));
        DataCore.instance().flush(context);
    }

    private void a(Context context, long j, String str, String str2, int i, long j2, long j3, String str3, String str4, int i2) {
        DataCore.instance().putEvent(context, getEvent(context, j, str, str2, i, j2, j3, str3, str4, i2, 1, null, null, false));
        DataCore.instance().flush(context);
    }

    public void flushEvent(Context context, long j, String str, String str2, int i, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        DataCore.instance().putEvent(context, getEvent(context, j, str, str2, i, j2, 0L, "", jSONArray, jSONArray2, str3, str4, str5, Config.EventViewType.EDIT.getValue(), 2, null, map, "", "", z));
        DataCore.instance().flush(context);
    }

    private String a(String str, String str2) {
        return "__sdk_" + str + "$|$" + str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a {
        String a;
        String b;
        long c;

        private a() {
        }
    }

    public static JSONObject getEvent(Context context, long j, String str, String str2, int i, long j2, long j3, String str3, String str4, int i2, int i3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        return getEvent(context, j, str, str2, i, j2, j3, str3, null, null, str4, null, null, i2, i3, extraInfo, map, "", "", z);
    }

    public static JSONObject getEvent(Context context, long j, String str, String str2, int i, long j2, long j3, String str3, JSONArray jSONArray, JSONArray jSONArray2, String str4, String str5, String str6, int i2, int i3, ExtraInfo extraInfo, Map<String, String> map, String str7, String str8, boolean z) {
        return getEvent(context, j, str, str2, i, j2, j3, str3, jSONArray, jSONArray2, str4, str5, str6, i2, i3, extraInfo, map, str7, str8, z, null, "");
    }

    public static JSONObject getEvent(Context context, long j, String str, String str2, int i, long j2, long j3, String str3, JSONArray jSONArray, JSONArray jSONArray2, String str4, String str5, String str6, int i2, int i3, ExtraInfo extraInfo, Map<String, String> map, String str7, String str8, boolean z, JSONObject jSONObject, String str9) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ss", j);
            jSONObject2.put("i", str);
            jSONObject2.put("l", str2);
            jSONObject2.put("c", i);
            jSONObject2.put("t", j2);
            jSONObject2.put("d", j3);
            jSONObject2.put("h", str3);
            if (i3 != 3) {
                jSONObject2.put(Config.EVENT_NATIVE_VIEW_HIERARCHY, jSONArray);
                jSONObject2.put(Config.EVENT_H5_VIEW_HIERARCHY, jSONArray2);
            } else {
                jSONObject2.put(Config.EVENT_NATIVE_VIEW_HIERARCHY, str7);
                jSONObject2.put(Config.EVENT_H5_VIEW_HIERARCHY, str8);
            }
            jSONObject2.put("p", str4);
            jSONObject2.put("p2", str5);
            jSONObject2.put("rn", str6);
            jSONObject2.put("v", i2);
            jSONObject2.put("at", i3);
            jSONObject2.put("h5", z ? 1 : 0);
            if (extraInfo != null && extraInfo.dumpToJson().length() != 0) {
                jSONObject2.put("ext", extraInfo.dumpToJson());
            }
            if (map != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value) && !a(value, 1024)) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("k", key);
                        jSONObject3.put("v", value);
                        jSONArray3.put(jSONObject3);
                    }
                }
                if (jSONArray3.length() != 0) {
                    jSONObject2.put(Config.EVENT_ATTR, jSONArray3);
                }
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                JSONArray jSONArray4 = new JSONArray();
                jSONArray4.put(jSONObject);
                jSONObject2.put(Config.EVENT_HEAT_POINT, jSONArray4);
            }
            if (TextUtils.isEmpty(str9)) {
                str9 = "";
            }
            jSONObject2.put("sign", str9);
        } catch (Exception e) {
        }
        return jSONObject2;
    }

    private static boolean a(String str, int i) {
        int i2;
        if (str == null) {
            return false;
        }
        try {
            i2 = str.getBytes().length;
        } catch (Exception e) {
            i2 = 0;
        }
        return i2 > i;
    }

    private static boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str) || new JSONObject().toString().equals(str)) {
            return (TextUtils.isEmpty(str2) || new JSONArray().toString().equals(str2)) ? false : true;
        }
        return true;
    }

    public static void doEventMerge(JSONArray jSONArray, JSONObject jSONObject) {
        int i = 0;
        JSONArray jSONArray2 = null;
        JSONArray jSONArray3 = null;
        String str = "";
        String str2 = "";
        Config.EventViewType.EDIT.getValue();
        try {
            long optLong = jSONObject.optLong("ss");
            String string = jSONObject.getString("i");
            String string2 = jSONObject.getString("l");
            long j = jSONObject.getLong("t") / BdKVCache.MILLS_1Hour;
            String optString = jSONObject.optString("s");
            int optInt = jSONObject.optInt("at");
            String optString2 = jSONObject.optString("h");
            if (optInt != 3) {
                jSONArray2 = jSONObject.optJSONArray(Config.EVENT_NATIVE_VIEW_HIERARCHY);
                jSONArray3 = jSONObject.optJSONArray(Config.EVENT_H5_VIEW_HIERARCHY);
            } else {
                str = jSONObject.optString(Config.EVENT_NATIVE_VIEW_HIERARCHY);
                str2 = jSONObject.optString(Config.EVENT_H5_VIEW_HIERARCHY);
            }
            String optString3 = jSONObject.optString("p");
            String optString4 = jSONObject.optString("p2");
            String optString5 = jSONObject.optString("rn");
            int optInt2 = jSONObject.optInt("v");
            String optString6 = jSONObject.optString("ext");
            String optString7 = jSONObject.optString(Config.EVENT_ATTR);
            int optInt3 = jSONObject.optInt("h5");
            String optString8 = jSONObject.optString("sign");
            try {
                i = jSONObject.getInt("d");
            } catch (JSONException e) {
            }
            if (i == 0 && !b(optString6, optString7)) {
                a(jSONArray, jSONObject, optLong, string, string2, optString, j, optString2, jSONArray2, jSONArray3, optString3, optString4, optString5, optInt2, optInt, str, str2, optInt3, optString8);
                return;
            }
            int length = jSONArray.length();
            try {
                jSONObject.put("s", "0");
                jSONArray.put(length, jSONObject);
            } catch (JSONException e2) {
            }
        } catch (JSONException e3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
        if (r33.equals("") != false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(JSONArray jSONArray, JSONObject jSONObject, long j, String str, String str2, String str3, long j2, String str4, JSONArray jSONArray2, JSONArray jSONArray3, String str5, String str6, String str7, int i, int i2, String str8, String str9, int i3, String str10) {
        int i4;
        int length = jSONArray.length();
        if (str3 != null) {
        }
        jSONObject.put("s", "0|");
        int i5 = 0;
        int i6 = length;
        while (true) {
            if (i5 >= length) {
                i5 = i6;
                break;
            }
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                long optLong = jSONObject2.optLong("ss");
                String string = jSONObject2.getString("i");
                String string2 = jSONObject2.getString("l");
                long j3 = jSONObject2.getLong("t") / BdKVCache.MILLS_1Hour;
                try {
                    i4 = jSONObject2.getInt("d");
                } catch (JSONException e) {
                    i4 = 0;
                }
                String optString = jSONObject2.optString("h");
                String optString2 = jSONObject2.optString("p");
                String optString3 = jSONObject2.optString("p2");
                String optString4 = jSONObject2.optString("rn");
                int optInt = jSONObject2.optInt("v");
                int optInt2 = jSONObject2.optInt("at");
                JSONArray jSONArray4 = null;
                JSONArray jSONArray5 = null;
                String str11 = "";
                String str12 = "";
                if (optInt2 != 3) {
                    jSONArray4 = jSONObject2.optJSONArray(Config.EVENT_NATIVE_VIEW_HIERARCHY);
                    jSONArray5 = jSONObject2.optJSONArray(Config.EVENT_H5_VIEW_HIERARCHY);
                } else {
                    str11 = jSONObject2.optString(Config.EVENT_NATIVE_VIEW_HIERARCHY);
                    str12 = jSONObject2.optString(Config.EVENT_H5_VIEW_HIERARCHY);
                }
                String optString5 = jSONObject2.optString("ext");
                String optString6 = jSONObject2.optString(Config.EVENT_ATTR);
                int optInt3 = jSONObject2.optInt("h5");
                String optString7 = jSONObject2.optString("sign");
                if (j3 == j2 && i4 == 0 && !b(optString5, optString6) && optLong == j && string.equals(str) && string2.equals(str2) && optString.equals(str4) && optString2.equals(str5) && optString3.equals(str6) && a(jSONArray4, jSONArray2) && a(jSONArray5, jSONArray3) && optString4.equals(str7) && optInt == i && optInt2 == i2 && str11.equals(str8) && str12.equals(str9) && optInt3 == i3 && optString7.equals(str10)) {
                    int i7 = jSONObject.getInt("c") + jSONObject2.getInt("c");
                    String optString8 = jSONObject2.optString("s");
                    String str13 = (optString8 == null || optString8.equalsIgnoreCase("")) ? "0|" : optString8;
                    long j4 = jSONObject.getLong("t") - jSONObject2.getLong("t");
                    if (j4 < 0) {
                        j4 = 0;
                    }
                    String str14 = str13 + j4 + "|";
                    try {
                        jSONObject2.remove("c");
                        jSONObject2.put("c", i7);
                        jSONObject2.put("s", str14);
                        a(jSONObject2, jSONObject);
                        break;
                    } catch (JSONException e2) {
                        i6 = i5;
                    }
                }
            } catch (JSONException e3) {
            }
            i5++;
        }
        if (i5 >= length) {
            try {
                jSONArray.put(length, jSONObject);
            } catch (JSONException e4) {
            }
        }
    }

    private static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray;
        if (jSONObject != null && jSONObject2 != null) {
            JSONArray jSONArray = new JSONArray();
            JSONArray optJSONArray2 = jSONObject.optJSONArray(Config.EVENT_HEAT_POINT);
            if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    try {
                        jSONArray.put(optJSONArray2.getJSONObject(i));
                    } catch (Exception e) {
                    }
                }
            }
            if (jSONArray.length() < 10 && (optJSONArray = jSONObject2.optJSONArray(Config.EVENT_HEAT_POINT)) != null && optJSONArray.length() != 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    try {
                        jSONArray.put(optJSONArray.getJSONObject(i2));
                    } catch (Exception e2) {
                    }
                }
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                try {
                    jSONObject.put(Config.EVENT_HEAT_POINT, jSONArray);
                } catch (Exception e3) {
                }
            }
        }
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || !jSONArray.toString().equals(jSONArray2.toString())) ? false : true;
    }
}
