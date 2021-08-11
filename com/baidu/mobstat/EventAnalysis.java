package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class EventAnalysis {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, a> f42844a;

    /* renamed from: com.baidu.mobstat.EventAnalysis$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f42845a;

        /* renamed from: b  reason: collision with root package name */
        public String f42846b;

        /* renamed from: c  reason: collision with root package name */
        public long f42847c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public EventAnalysis() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42844a = new HashMap();
    }

    private void a(Context context, long j2, String str, String str2, int i2, long j3, long j4, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), extraInfo, map, Boolean.valueOf(z)}) == null) {
            DataCore.instance().putEvent(context, getEvent(context, j2, str, str2, i2, j3, j4, "", "", 0, 0, extraInfo, map, z));
            DataCore.instance().flush(context);
        }
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || new JSONObject().toString().equals(str)) {
                return (TextUtils.isEmpty(str2) || new JSONArray().toString().equals(str2)) ? false : true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void doEventMerge(JSONArray jSONArray, JSONObject jSONObject) {
        String optString;
        String optString2;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, jSONArray, jSONObject) == null) {
            Config.EventViewType.EDIT.getValue();
            try {
                long optLong = jSONObject.optLong("ss");
                String string = jSONObject.getString("i");
                String string2 = jSONObject.getString("l");
                long j2 = jSONObject.getLong("t") / 3600000;
                String optString3 = jSONObject.optString("s");
                int optInt = jSONObject.optInt("at");
                String optString4 = jSONObject.optString("h");
                if (optInt != 3) {
                    jSONArray2 = jSONObject.optJSONArray("h2");
                    jSONArray3 = jSONObject.optJSONArray("h3");
                    optString = "";
                    optString2 = optString;
                } else {
                    optString = jSONObject.optString("h2");
                    optString2 = jSONObject.optString("h3");
                    jSONArray2 = null;
                    jSONArray3 = null;
                }
                String optString5 = jSONObject.optString("p");
                String optString6 = jSONObject.optString("p2");
                String optString7 = jSONObject.optString("rn");
                int optInt2 = jSONObject.optInt("v");
                String optString8 = jSONObject.optString("ext");
                String optString9 = jSONObject.optString("attribute");
                int optInt3 = jSONObject.optInt("h5");
                String optString10 = jSONObject.optString("sign");
                try {
                    i2 = jSONObject.getInt("d");
                } catch (JSONException unused) {
                    i2 = 0;
                }
                if (i2 == 0 && !b(optString8, optString9)) {
                    a(jSONArray, jSONObject, optLong, string, string2, optString3, j2, optString4, jSONArray2, jSONArray3, optString5, optString6, optString7, optInt2, optInt, optString, optString2, optInt3, optString10);
                    return;
                }
                int length = jSONArray.length();
                jSONObject.put("s", "0");
                jSONArray.put(length, jSONObject);
            } catch (JSONException unused2) {
            }
        }
    }

    public static JSONObject getEvent(Context context, long j2, String str, String str2, int i2, long j3, long j4, String str3, String str4, int i3, int i4, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), str3, str4, Integer.valueOf(i3), Integer.valueOf(i4), extraInfo, map, Boolean.valueOf(z)})) == null) ? getEvent(context, j2, str, str2, i2, j3, j4, str3, null, null, str4, null, null, i3, i4, extraInfo, map, "", "", z) : (JSONObject) invokeCommon.objValue;
    }

    public void flushEvent(Context context, long j2, String str, String str2, int i2, long j3, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), jSONArray, jSONArray2, str3, str4, str5, map, Boolean.valueOf(z)}) == null) {
            DataCore.instance().putEvent(context, getEvent(context, j2, str, str2, i2, j3, 0L, "", jSONArray, jSONArray2, str3, str4, str5, Config.EventViewType.EDIT.getValue(), 2, null, map, "", "", z));
            DataCore.instance().flush(context);
        }
    }

    public void onEvent(Context context, long j2, String str, String str2, int i2, long j3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), extraInfo, map, Boolean.valueOf(z)}) == null) {
            a(context, j2, str, str2, i2, j3, 0L, extraInfo, map, z);
        }
    }

    public void onEventDuration(Context context, long j2, String str, String str2, long j3, long j4, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j2), str, str2, Long.valueOf(j3), Long.valueOf(j4), extraInfo, map, Boolean.valueOf(z)}) == null) || j4 <= 0) {
            return;
        }
        a(context, j2, str, str2, 1, j3, j4, extraInfo, map, z);
    }

    public void onEventEnd(Context context, long j2, String str, String str2, long j3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j2), str, str2, Long.valueOf(j3), extraInfo, map, Boolean.valueOf(z)}) == null) {
            String a2 = a(str, str2);
            a aVar = this.f42844a.get(a2);
            if (aVar == null) {
                bc c2 = bc.c();
                c2.b("[WARNING] eventId: " + str + ", with label: " + str2 + " is not started or alread ended");
            } else if ((str != null && !str.equals(aVar.f42845a)) || (str2 != null && !str2.equals(aVar.f42846b))) {
                bc.c().b("[WARNING] eventId/label pair not match");
            } else {
                this.f42844a.remove(a2);
                long j4 = j3 - aVar.f42847c;
                if (j4 < 0) {
                    bc.c().b("[WARNING] onEventEnd must be invoked after onEventStart");
                }
                onEventDuration(context, j2, str, str2, aVar.f42847c, j4, extraInfo, map, z);
            }
        }
    }

    public void onEventStart(Context context, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, str2, Long.valueOf(j2)}) == null) {
            a aVar = new a(null);
            aVar.f42847c = j2;
            aVar.f42845a = str;
            aVar.f42846b = str2;
            String a2 = a(str, str2);
            if (this.f42844a.containsKey(a2)) {
                bc c2 = bc.c();
                c2.b("[WARNING] eventId: " + str + ", with label: " + str2 + " is duplicated, older is removed");
            }
            this.f42844a.put(a2, aVar);
        }
    }

    public static JSONObject getEvent(Context context, long j2, String str, String str2, int i2, long j3, long j4, String str3, JSONArray jSONArray, JSONArray jSONArray2, String str4, String str5, String str6, int i3, int i4, ExtraInfo extraInfo, Map<String, String> map, String str7, String str8, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), str3, jSONArray, jSONArray2, str4, str5, str6, Integer.valueOf(i3), Integer.valueOf(i4), extraInfo, map, str7, str8, Boolean.valueOf(z)})) == null) ? getEvent(context, j2, str, str2, i2, j3, j4, str3, jSONArray, jSONArray2, str4, str5, str6, i3, i4, extraInfo, map, str7, str8, z, null, "") : (JSONObject) invokeCommon.objValue;
    }

    public void onEvent(Context context, long j2, String str, String str2, int i2, long j3, String str3, String str4, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), str3, str4, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            a(context, j2, str, str2, i2, j3, 0L, str3, str4, i3);
        }
    }

    public static JSONObject getEvent(Context context, long j2, String str, String str2, int i2, long j3, long j4, String str3, JSONArray jSONArray, JSONArray jSONArray2, String str4, String str5, String str6, int i3, int i4, ExtraInfo extraInfo, Map<String, String> map, String str7, String str8, boolean z, JSONObject jSONObject, String str9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), str3, jSONArray, jSONArray2, str4, str5, str6, Integer.valueOf(i3), Integer.valueOf(i4), extraInfo, map, str7, str8, Boolean.valueOf(z), jSONObject, str9})) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ss", j2);
                jSONObject2.put("i", str);
                jSONObject2.put("l", str2);
                jSONObject2.put("c", i2);
                jSONObject2.put("t", j3);
                jSONObject2.put("d", j4);
                jSONObject2.put("h", str3);
                if (i4 != 3) {
                    jSONObject2.put("h2", jSONArray);
                    jSONObject2.put("h3", jSONArray2);
                } else {
                    jSONObject2.put("h2", str7);
                    jSONObject2.put("h3", str8);
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
                            jSONObject3.put("k", key);
                            jSONObject3.put("v", value);
                            jSONArray3.put(jSONObject3);
                        }
                    }
                    if (jSONArray3.length() != 0) {
                        jSONObject2.put("attribute", jSONArray3);
                    }
                }
                if (jSONObject != null && jSONObject.length() != 0) {
                    JSONArray jSONArray4 = new JSONArray();
                    jSONArray4.put(jSONObject);
                    jSONObject2.put("point", jSONArray4);
                }
                jSONObject2.put("sign", TextUtils.isEmpty(str9) ? "" : str9);
            } catch (Exception unused) {
            }
            return jSONObject2;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public void onEvent(Context context, long j2, String str, String str2, int i2, long j3, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), jSONArray, jSONArray2, str3, str4, str5, map, Boolean.valueOf(z)}) == null) {
            flushEvent(context, j2, str, str2, i2, j3, jSONArray, jSONArray2, str3, str4, str5, map, z);
        }
    }

    private void a(Context context, long j2, String str, String str2, int i2, long j3, long j4, String str3, String str4, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), str3, str4, Integer.valueOf(i3)}) == null) {
            DataCore.instance().putEvent(context, getEvent(context, j2, str, str2, i2, j3, j4, str3, str4, i3, 1, null, null, false));
            DataCore.instance().flush(context);
        }
    }

    private String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) {
            return "__sdk_" + str + "$|$" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(String str, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, str, i2)) == null) {
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
        return invokeLI.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x0167, code lost:
        if (r4.equalsIgnoreCase(r23) != false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r37.equals("") != false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(JSONArray jSONArray, JSONObject jSONObject, long j2, String str, String str2, String str3, long j3, String str4, JSONArray jSONArray2, JSONArray jSONArray3, String str5, String str6, String str7, int i2, int i3, String str8, String str9, int i4, String str10) {
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
        long j4;
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
        long j5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{jSONArray, jSONObject, Long.valueOf(j2), str, str2, str3, Long.valueOf(j3), str4, jSONArray2, jSONArray3, str5, str6, str7, Integer.valueOf(i2), Integer.valueOf(i3), str8, str9, Integer.valueOf(i4), str10}) == null) {
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
                    j4 = jSONObject3.getLong(str21) / 3600000;
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
                                optJSONArray = jSONObject3.optJSONArray("h2");
                                jSONArray5 = jSONObject3.optJSONArray("h3");
                                str18 = str15;
                                str19 = str18;
                            } catch (JSONException unused6) {
                                jSONObject2 = jSONObject;
                                str12 = jSONArray5;
                            }
                        } else {
                            str18 = jSONObject3.optString("h2");
                            str17 = jSONArray5;
                            jSONArray5 = null;
                            optJSONArray = null;
                            str19 = jSONObject3.optString("h3");
                        }
                        try {
                            optString5 = jSONObject3.optString("ext");
                            str20 = str18;
                            optString6 = jSONObject3.optString("attribute");
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
                if (j4 == j3 && i10 == 0 && !b(optString5, optString6) && optLong == j2 && string.equals(str) && string2.equals(str2) && optString.equals(str4) && optString2.equals(str5)) {
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
                                                                long j6 = jSONObject2.getLong(str11) - jSONObject3.getLong(str11);
                                                                if (j6 < 0) {
                                                                    str11 = str11;
                                                                    j5 = 0;
                                                                } else {
                                                                    str11 = str11;
                                                                    j5 = j6;
                                                                }
                                                                String str25 = optString8 + j5 + "|";
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
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, jSONObject, jSONObject2) == null) || jSONObject == null || jSONObject2 == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("point");
        if (optJSONArray2 != null && optJSONArray2.length() != 0) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    jSONArray.put(optJSONArray2.getJSONObject(i2));
                } catch (Exception unused) {
                }
            }
        }
        if (jSONArray.length() < 10 && (optJSONArray = jSONObject2.optJSONArray("point")) != null && optJSONArray.length() != 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                try {
                    jSONArray.put(optJSONArray.getJSONObject(i3));
                } catch (Exception unused2) {
                }
            }
        }
        if (jSONArray.length() != 0) {
            try {
                jSONObject.put("point", jSONArray);
            } catch (Exception unused3) {
            }
        }
    }

    public static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, jSONArray, jSONArray2)) == null) {
            if (jSONArray == null && jSONArray2 == null) {
                return true;
            }
            return (jSONArray == null || jSONArray2 == null || !jSONArray.toString().equals(jSONArray2.toString())) ? false : true;
        }
        return invokeLL.booleanValue;
    }
}
