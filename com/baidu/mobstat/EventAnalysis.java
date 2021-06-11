package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class EventAnalysis {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, a> f8431a = new HashMap();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f8432a;

        /* renamed from: b  reason: collision with root package name */
        public String f8433b;

        /* renamed from: c  reason: collision with root package name */
        public long f8434c;

        public a() {
        }
    }

    private void a(Context context, long j, String str, String str2, int i2, long j2, long j3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        DataCore.instance().putEvent(context, getEvent(context, j, str, str2, i2, j2, j3, "", "", 0, 0, extraInfo, map, z));
        DataCore.instance().flush(context);
    }

    public static boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str) || new JSONObject().toString().equals(str)) {
            return (TextUtils.isEmpty(str2) || new JSONArray().toString().equals(str2)) ? false : true;
        }
        return true;
    }

    public static void doEventMerge(JSONArray jSONArray, JSONObject jSONObject) {
        String optString;
        String optString2;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        int i2;
        Config.EventViewType.EDIT.getValue();
        try {
            long optLong = jSONObject.optLong("ss");
            String string = jSONObject.getString("i");
            String string2 = jSONObject.getString("l");
            long j = jSONObject.getLong("t") / 3600000;
            String optString3 = jSONObject.optString("s");
            int optInt = jSONObject.optInt("at");
            String optString4 = jSONObject.optString("h");
            if (optInt != 3) {
                jSONArray2 = jSONObject.optJSONArray(Config.EVENT_NATIVE_VIEW_HIERARCHY);
                jSONArray3 = jSONObject.optJSONArray(Config.EVENT_H5_VIEW_HIERARCHY);
                optString = "";
                optString2 = optString;
            } else {
                optString = jSONObject.optString(Config.EVENT_NATIVE_VIEW_HIERARCHY);
                optString2 = jSONObject.optString(Config.EVENT_H5_VIEW_HIERARCHY);
                jSONArray2 = null;
                jSONArray3 = null;
            }
            String optString5 = jSONObject.optString("p");
            String optString6 = jSONObject.optString("p2");
            String optString7 = jSONObject.optString("rn");
            int optInt2 = jSONObject.optInt("v");
            String optString8 = jSONObject.optString("ext");
            String optString9 = jSONObject.optString(Config.EVENT_ATTR);
            int optInt3 = jSONObject.optInt("h5");
            String optString10 = jSONObject.optString("sign");
            try {
                i2 = jSONObject.getInt("d");
            } catch (JSONException unused) {
                i2 = 0;
            }
            if (i2 == 0 && !b(optString8, optString9)) {
                a(jSONArray, jSONObject, optLong, string, string2, optString3, j, optString4, jSONArray2, jSONArray3, optString5, optString6, optString7, optInt2, optInt, optString, optString2, optInt3, optString10);
                return;
            }
            int length = jSONArray.length();
            jSONObject.put("s", "0");
            jSONArray.put(length, jSONObject);
        } catch (JSONException unused2) {
        }
    }

    public static JSONObject getEvent(Context context, long j, String str, String str2, int i2, long j2, long j3, String str3, String str4, int i3, int i4, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        return getEvent(context, j, str, str2, i2, j2, j3, str3, null, null, str4, null, null, i3, i4, extraInfo, map, "", "", z);
    }

    public void flushEvent(Context context, long j, String str, String str2, int i2, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        DataCore.instance().putEvent(context, getEvent(context, j, str, str2, i2, j2, 0L, "", jSONArray, jSONArray2, str3, str4, str5, Config.EventViewType.EDIT.getValue(), 2, null, map, "", "", z));
        DataCore.instance().flush(context);
    }

    public void onEvent(Context context, long j, String str, String str2, int i2, long j2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        a(context, j, str, str2, i2, j2, 0L, extraInfo, map, z);
    }

    public void onEventDuration(Context context, long j, String str, String str2, long j2, long j3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        if (j3 <= 0) {
            return;
        }
        a(context, j, str, str2, 1, j2, j3, extraInfo, map, z);
    }

    public void onEventEnd(Context context, long j, String str, String str2, long j2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        String a2 = a(str, str2);
        a aVar = this.f8431a.get(a2);
        if (aVar == null) {
            bc c2 = bc.c();
            c2.b("[WARNING] eventId: " + str + ", with label: " + str2 + " is not started or alread ended");
        } else if ((str != null && !str.equals(aVar.f8432a)) || (str2 != null && !str2.equals(aVar.f8433b))) {
            bc.c().b("[WARNING] eventId/label pair not match");
        } else {
            this.f8431a.remove(a2);
            long j3 = j2 - aVar.f8434c;
            if (j3 < 0) {
                bc.c().b("[WARNING] onEventEnd must be invoked after onEventStart");
            }
            onEventDuration(context, j, str, str2, aVar.f8434c, j3, extraInfo, map, z);
        }
    }

    public void onEventStart(Context context, String str, String str2, long j) {
        a aVar = new a();
        aVar.f8434c = j;
        aVar.f8432a = str;
        aVar.f8433b = str2;
        String a2 = a(str, str2);
        if (this.f8431a.containsKey(a2)) {
            bc c2 = bc.c();
            c2.b("[WARNING] eventId: " + str + ", with label: " + str2 + " is duplicated, older is removed");
        }
        this.f8431a.put(a2, aVar);
    }

    public static JSONObject getEvent(Context context, long j, String str, String str2, int i2, long j2, long j3, String str3, JSONArray jSONArray, JSONArray jSONArray2, String str4, String str5, String str6, int i3, int i4, ExtraInfo extraInfo, Map<String, String> map, String str7, String str8, boolean z) {
        return getEvent(context, j, str, str2, i2, j2, j3, str3, jSONArray, jSONArray2, str4, str5, str6, i3, i4, extraInfo, map, str7, str8, z, null, "");
    }

    public void onEvent(Context context, long j, String str, String str2, int i2, long j2, String str3, String str4, int i3, boolean z) {
        a(context, j, str, str2, i2, j2, 0L, str3, str4, i3);
    }

    public static JSONObject getEvent(Context context, long j, String str, String str2, int i2, long j2, long j3, String str3, JSONArray jSONArray, JSONArray jSONArray2, String str4, String str5, String str6, int i3, int i4, ExtraInfo extraInfo, Map<String, String> map, String str7, String str8, boolean z, JSONObject jSONObject, String str9) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ss", j);
            jSONObject2.put("i", str);
            jSONObject2.put("l", str2);
            jSONObject2.put("c", i2);
            jSONObject2.put("t", j2);
            jSONObject2.put("d", j3);
            jSONObject2.put("h", str3);
            if (i4 != 3) {
                jSONObject2.put(Config.EVENT_NATIVE_VIEW_HIERARCHY, jSONArray);
                jSONObject2.put(Config.EVENT_H5_VIEW_HIERARCHY, jSONArray2);
            } else {
                jSONObject2.put(Config.EVENT_NATIVE_VIEW_HIERARCHY, str7);
                jSONObject2.put(Config.EVENT_H5_VIEW_HIERARCHY, str8);
            }
            jSONObject2.put("p", str4);
            jSONObject2.put("p2", str5);
            jSONObject2.put("rn", str6);
            jSONObject2.put("v", i3);
            jSONObject2.put("at", i4);
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
                        jSONObject3.put(Config.APP_KEY, key);
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
            jSONObject2.put("sign", TextUtils.isEmpty(str9) ? "" : str9);
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    public void onEvent(Context context, long j, String str, String str2, int i2, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        flushEvent(context, j, str, str2, i2, j2, jSONArray, jSONArray2, str3, str4, str5, map, z);
    }

    private void a(Context context, long j, String str, String str2, int i2, long j2, long j3, String str3, String str4, int i3) {
        DataCore.instance().putEvent(context, getEvent(context, j, str, str2, i2, j2, j3, str3, str4, i3, 1, null, null, false));
        DataCore.instance().flush(context);
    }

    private String a(String str, String str2) {
        return "__sdk_" + str + "$|$" + str2;
    }

    public static boolean a(String str, int i2) {
        int i3;
        if (str == null) {
            return false;
        }
        try {
            i3 = str.getBytes().length;
        } catch (Exception unused) {
            i3 = 0;
        }
        return i3 > i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r37.equals("") != false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0166, code lost:
        if (r4.equalsIgnoreCase(r23) != false) goto L86;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(JSONArray jSONArray, JSONObject jSONObject, long j, String str, String str2, String str3, long j2, String str4, JSONArray jSONArray2, JSONArray jSONArray3, String str5, String str6, String str7, int i2, int i3, String str8, String str9, int i4, String str10) {
        JSONObject jSONObject2;
        int i5;
        int i6;
        String str11;
        String str12;
        int i7;
        String str13;
        String str14;
        String str15;
        int i8;
        int i9;
        JSONObject jSONObject3;
        long optLong;
        String string;
        String string2;
        long j3;
        int i10;
        String optString;
        String optString2;
        String optString3;
        String optString4;
        int optInt;
        int optInt2;
        String str16;
        String str17;
        JSONArray optJSONArray;
        String str18;
        String str19;
        String optString5;
        String str20;
        String optString6;
        int optInt3;
        String optString7;
        long j4;
        JSONArray jSONArray4 = jSONArray;
        JSONObject jSONObject4 = jSONObject;
        String str21 = "t";
        JSONArray jSONArray5 = "c";
        int length = jSONArray.length();
        String str22 = "0|";
        String str23 = "s";
        String str24 = "";
        if (str3 != null) {
        }
        jSONObject4.put("s", "0|");
        int i11 = length;
        int i12 = 0;
        while (true) {
            if (i12 >= length) {
                jSONObject2 = jSONObject4;
                i5 = length;
                i6 = i11;
                break;
            }
            try {
                jSONObject3 = jSONArray4.getJSONObject(i12);
                optLong = jSONObject3.optLong("ss");
                string = jSONObject3.getString("i");
                string2 = jSONObject3.getString("l");
                j3 = jSONObject3.getLong(str21) / 3600000;
                try {
                    i10 = jSONObject3.getInt("d");
                    str13 = str22;
                } catch (JSONException unused) {
                    str13 = str22;
                    i10 = 0;
                }
            } catch (JSONException unused2) {
                str11 = str21;
                str12 = jSONArray5;
                i7 = length;
                str13 = str22;
            }
            try {
                optString = jSONObject3.optString("h");
                i9 = i11;
                try {
                    optString2 = jSONObject3.optString("p");
                    optString3 = jSONObject3.optString("p2");
                    i7 = length;
                    try {
                        optString4 = jSONObject3.optString("rn");
                        i8 = i12;
                    } catch (JSONException unused3) {
                        str11 = str21;
                        str12 = jSONArray5;
                        str14 = str23;
                        str15 = str24;
                        i8 = i12;
                        jSONObject2 = jSONObject4;
                        jSONArray5 = str12;
                        i12 = i8 + 1;
                        str23 = str14;
                        jSONObject4 = jSONObject2;
                        str22 = str13;
                        i11 = i9;
                        length = i7;
                        str21 = str11;
                        str24 = str15;
                        jSONArray4 = jSONArray;
                    }
                } catch (JSONException unused4) {
                    str11 = str21;
                    str12 = jSONArray5;
                    i7 = length;
                }
            } catch (JSONException unused5) {
                str11 = str21;
                str12 = jSONArray5;
                i7 = length;
                str14 = str23;
                str15 = str24;
                i8 = i12;
                i9 = i11;
                jSONObject2 = jSONObject4;
                jSONArray5 = str12;
                i12 = i8 + 1;
                str23 = str14;
                jSONObject4 = jSONObject2;
                str22 = str13;
                i11 = i9;
                length = i7;
                str21 = str11;
                str24 = str15;
                jSONArray4 = jSONArray;
            }
            try {
                optInt = jSONObject3.optInt("v");
                str11 = str21;
                try {
                    optInt2 = jSONObject3.optInt("at");
                    str15 = str24;
                    str16 = str23;
                    if (optInt2 != 3) {
                        try {
                            str17 = jSONArray5;
                            optJSONArray = jSONObject3.optJSONArray(Config.EVENT_NATIVE_VIEW_HIERARCHY);
                            jSONArray5 = jSONObject3.optJSONArray(Config.EVENT_H5_VIEW_HIERARCHY);
                            str18 = str15;
                            str19 = str18;
                        } catch (JSONException unused6) {
                            jSONObject2 = jSONObject;
                            str12 = jSONArray5;
                        }
                    } else {
                        str18 = jSONObject3.optString(Config.EVENT_NATIVE_VIEW_HIERARCHY);
                        str17 = jSONArray5;
                        jSONArray5 = null;
                        optJSONArray = null;
                        str19 = jSONObject3.optString(Config.EVENT_H5_VIEW_HIERARCHY);
                    }
                    try {
                        optString5 = jSONObject3.optString("ext");
                        str20 = str18;
                        optString6 = jSONObject3.optString(Config.EVENT_ATTR);
                        optInt3 = jSONObject3.optInt("h5");
                        optString7 = jSONObject3.optString("sign");
                    } catch (JSONException unused7) {
                    }
                } catch (JSONException unused8) {
                    jSONObject2 = jSONObject4;
                    str12 = jSONArray5;
                    str14 = str23;
                    str15 = str24;
                }
            } catch (JSONException unused9) {
                str11 = str21;
                str12 = jSONArray5;
                str14 = str23;
                str15 = str24;
                jSONObject2 = jSONObject4;
                jSONArray5 = str12;
                i12 = i8 + 1;
                str23 = str14;
                jSONObject4 = jSONObject2;
                str22 = str13;
                i11 = i9;
                length = i7;
                str21 = str11;
                str24 = str15;
                jSONArray4 = jSONArray;
            }
            if (j3 == j2 && i10 == 0 && !b(optString5, optString6) && optLong == j && string.equals(str) && string2.equals(str2) && optString.equals(str4) && optString2.equals(str5)) {
                if (optString3.equals(str6) && a(optJSONArray, jSONArray2)) {
                    if (a(jSONArray5, jSONArray3) && optString4.equals(str7) && optInt == i2) {
                        if (optInt2 == i3) {
                            if (str20.equals(str8)) {
                                if (str19.equals(str9)) {
                                    if (optInt3 == i4) {
                                        try {
                                            if (optString7.equals(str10)) {
                                                jSONObject2 = jSONObject;
                                                str12 = str17;
                                                try {
                                                    int i13 = jSONObject2.getInt(str12) + jSONObject3.getInt(str12);
                                                    str14 = str16;
                                                    try {
                                                        String optString8 = jSONObject3.optString(str14);
                                                        if (optString8 != null) {
                                                            try {
                                                            } catch (JSONException unused10) {
                                                                str15 = str15;
                                                            }
                                                        }
                                                        optString8 = str13;
                                                        str15 = str15;
                                                        try {
                                                            long j5 = jSONObject2.getLong(str11) - jSONObject3.getLong(str11);
                                                            if (j5 < 0) {
                                                                str11 = str11;
                                                                j4 = 0;
                                                            } else {
                                                                str11 = str11;
                                                                j4 = j5;
                                                            }
                                                            String str25 = optString8 + j4 + "|";
                                                            try {
                                                                jSONObject3.remove(str12);
                                                                jSONObject3.put(str12, i13);
                                                                jSONObject3.put(str14, str25);
                                                                a(jSONObject3, jSONObject2);
                                                                i5 = i7;
                                                                i6 = i8;
                                                                break;
                                                            } catch (JSONException unused11) {
                                                                i9 = i8;
                                                            }
                                                        } catch (JSONException unused12) {
                                                            str11 = str11;
                                                        }
                                                    } catch (JSONException unused13) {
                                                        continue;
                                                    }
                                                } catch (JSONException unused14) {
                                                }
                                            }
                                        } catch (JSONException unused15) {
                                        }
                                        jSONObject2 = jSONObject;
                                        str12 = str17;
                                        str14 = str16;
                                        jSONArray5 = str12;
                                        i12 = i8 + 1;
                                        str23 = str14;
                                        jSONObject4 = jSONObject2;
                                        str22 = str13;
                                        i11 = i9;
                                        length = i7;
                                        str21 = str11;
                                        str24 = str15;
                                        jSONArray4 = jSONArray;
                                    } else {
                                        jSONObject2 = jSONObject;
                                        str12 = str17;
                                        str14 = str16;
                                        jSONArray5 = str12;
                                        i12 = i8 + 1;
                                        str23 = str14;
                                        jSONObject4 = jSONObject2;
                                        str22 = str13;
                                        i11 = i9;
                                        length = i7;
                                        str21 = str11;
                                        str24 = str15;
                                        jSONArray4 = jSONArray;
                                    }
                                }
                                jSONObject2 = jSONObject;
                                str12 = str17;
                                str14 = str16;
                                jSONArray5 = str12;
                                i12 = i8 + 1;
                                str23 = str14;
                                jSONObject4 = jSONObject2;
                                str22 = str13;
                                i11 = i9;
                                length = i7;
                                str21 = str11;
                                str24 = str15;
                                jSONArray4 = jSONArray;
                            }
                            jSONObject2 = jSONObject;
                            str12 = str17;
                            str14 = str16;
                            jSONArray5 = str12;
                            i12 = i8 + 1;
                            str23 = str14;
                            jSONObject4 = jSONObject2;
                            str22 = str13;
                            i11 = i9;
                            length = i7;
                            str21 = str11;
                            str24 = str15;
                            jSONArray4 = jSONArray;
                        } else {
                            jSONObject2 = jSONObject;
                            str12 = str17;
                            str14 = str16;
                            jSONArray5 = str12;
                            i12 = i8 + 1;
                            str23 = str14;
                            jSONObject4 = jSONObject2;
                            str22 = str13;
                            i11 = i9;
                            length = i7;
                            str21 = str11;
                            str24 = str15;
                            jSONArray4 = jSONArray;
                        }
                    }
                    jSONObject2 = jSONObject;
                    str12 = str17;
                    str14 = str16;
                    jSONArray5 = str12;
                    i12 = i8 + 1;
                    str23 = str14;
                    jSONObject4 = jSONObject2;
                    str22 = str13;
                    i11 = i9;
                    length = i7;
                    str21 = str11;
                    str24 = str15;
                    jSONArray4 = jSONArray;
                }
                jSONObject2 = jSONObject;
                str12 = str17;
                str14 = str16;
                jSONArray5 = str12;
                i12 = i8 + 1;
                str23 = str14;
                jSONObject4 = jSONObject2;
                str22 = str13;
                i11 = i9;
                length = i7;
                str21 = str11;
                str24 = str15;
                jSONArray4 = jSONArray;
            }
            jSONObject2 = jSONObject;
            str12 = str17;
            str14 = str16;
            jSONArray5 = str12;
            i12 = i8 + 1;
            str23 = str14;
            jSONObject4 = jSONObject2;
            str22 = str13;
            i11 = i9;
            length = i7;
            str21 = str11;
            str24 = str15;
            jSONArray4 = jSONArray;
        }
        if (i6 < i5) {
            return;
        }
        try {
            jSONArray.put(i5, jSONObject2);
        } catch (JSONException unused16) {
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray;
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Config.EVENT_HEAT_POINT);
        if (optJSONArray2 != null && optJSONArray2.length() != 0) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    jSONArray.put(optJSONArray2.getJSONObject(i2));
                } catch (Exception unused) {
                }
            }
        }
        if (jSONArray.length() < 10 && (optJSONArray = jSONObject2.optJSONArray(Config.EVENT_HEAT_POINT)) != null && optJSONArray.length() != 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                try {
                    jSONArray.put(optJSONArray.getJSONObject(i3));
                } catch (Exception unused2) {
                }
            }
        }
        if (jSONArray.length() != 0) {
            try {
                jSONObject.put(Config.EVENT_HEAT_POINT, jSONArray);
            } catch (Exception unused3) {
            }
        }
    }

    public static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || !jSONArray.toString().equals(jSONArray2.toString())) ? false : true;
    }
}
