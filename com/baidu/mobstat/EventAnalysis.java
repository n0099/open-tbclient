package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes2.dex */
public class EventAnalysis {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, a> a;

    /* renamed from: com.baidu.mobstat.EventAnalysis$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public long c;

        public a() {
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

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public EventAnalysis() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
    }

    private String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) {
            return "__sdk_" + str + "$|$" + str2;
        }
        return (String) invokeLL.objValue;
    }

    private void a(Context context, long j, String str, String str2, int i, long j2, long j3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, this, new Object[]{context, Long.valueOf(j), str, str2, Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), extraInfo, map, Boolean.valueOf(z)}) != null) || !bu.a().e()) {
            return;
        }
        DataCore.instance().putEvent(context, getEvent(context, j, str, str2, i, j2, j3, "", "", 0, 0, extraInfo, map, z));
        DataCore.instance().flush(context);
    }

    public void onEvent(Context context, long j, String str, String str2, int i, long j2, String str3, String str4, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j), str, str2, Integer.valueOf(i), Long.valueOf(j2), str3, str4, Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || !bu.a().e()) {
            return;
        }
        a(context, j, str, str2, i, j2, 0L, str3, str4, i2);
    }

    private void a(Context context, long j, String str, String str2, int i, long j2, long j3, String str3, String str4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{context, Long.valueOf(j), str, str2, Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), str3, str4, Integer.valueOf(i2)}) == null) {
            DataCore.instance().putEvent(context, getEvent(context, j, str, str2, i, j2, j3, str3, str4, i2, 1, null, null, false));
            DataCore.instance().flush(context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r37.equals("") != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0178, code lost:
        if (r4.equalsIgnoreCase(r23) != false) goto L92;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(JSONArray jSONArray, JSONObject jSONObject, long j, String str, String str2, String str3, long j2, String str4, JSONArray jSONArray2, JSONArray jSONArray3, String str5, String str6, String str7, int i, int i2, String str8, String str9, int i3, String str10, String str11) {
        int i4;
        int i5;
        String str12;
        String str13;
        int i6;
        String str14;
        String str15;
        String str16;
        int i7;
        int i8;
        JSONObject jSONObject2;
        long optLong;
        String string;
        String string2;
        long j3;
        int i9;
        String optString;
        String optString2;
        String optString3;
        String optString4;
        int optInt;
        int optInt2;
        String str17;
        String str18;
        JSONArray optJSONArray;
        String str19;
        String str20;
        String optString5;
        String str21;
        String optString6;
        int optInt3;
        String optString7;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{jSONArray, jSONObject, Long.valueOf(j), str, str2, str3, Long.valueOf(j2), str4, jSONArray2, jSONArray3, str5, str6, str7, Integer.valueOf(i), Integer.valueOf(i2), str8, str9, Integer.valueOf(i3), str10, str11}) == null) {
            JSONArray jSONArray4 = jSONArray;
            JSONObject jSONObject3 = jSONObject;
            String str22 = "t";
            JSONArray jSONArray5 = "c";
            int length = jSONArray.length();
            String str23 = "0|";
            String str24 = "s";
            String str25 = "";
            if (str3 != null) {
            }
            jSONObject3.put("s", "0|");
            int i10 = length;
            int i11 = 0;
            while (true) {
                if (i11 < length) {
                    try {
                        jSONObject2 = jSONArray4.getJSONObject(i11);
                        optLong = jSONObject2.optLong("ss");
                        string = jSONObject2.getString("i");
                        string2 = jSONObject2.getString("l");
                        j3 = jSONObject2.getLong(str22) / 3600000;
                        try {
                            i9 = jSONObject2.getInt("d");
                            str14 = str23;
                        } catch (JSONException unused) {
                            str14 = str23;
                            i9 = 0;
                        }
                    } catch (JSONException unused2) {
                        str12 = str22;
                        str13 = jSONArray5;
                        i6 = length;
                        str14 = str23;
                    }
                    try {
                        optString = jSONObject2.optString("h");
                        i8 = i10;
                        try {
                            optString2 = jSONObject2.optString("p");
                            optString3 = jSONObject2.optString("p2");
                            i6 = length;
                        } catch (JSONException unused3) {
                            str12 = str22;
                            str13 = jSONArray5;
                            i6 = length;
                        }
                    } catch (JSONException unused4) {
                        str12 = str22;
                        str13 = jSONArray5;
                        i6 = length;
                        str15 = str24;
                        str16 = str25;
                        i7 = i11;
                        i8 = i10;
                        jSONArray5 = str13;
                        i11 = i7 + 1;
                        str24 = str15;
                        str23 = str14;
                        i10 = i8;
                        length = i6;
                        str22 = str12;
                        str25 = str16;
                        jSONArray4 = jSONArray;
                    }
                    try {
                        optString4 = jSONObject2.optString("rn");
                        i7 = i11;
                        try {
                            optInt = jSONObject2.optInt("v");
                            str12 = str22;
                        } catch (JSONException unused5) {
                            str12 = str22;
                        }
                        try {
                            optInt2 = jSONObject2.optInt("at");
                            str16 = str25;
                            str17 = str24;
                            if (optInt2 != 3) {
                                try {
                                    str18 = jSONArray5;
                                    optJSONArray = jSONObject2.optJSONArray(Config.EVENT_NATIVE_VIEW_HIERARCHY);
                                    jSONArray5 = jSONObject2.optJSONArray(Config.EVENT_H5_VIEW_HIERARCHY);
                                    str19 = str16;
                                    str20 = str19;
                                } catch (JSONException unused6) {
                                    jSONObject3 = jSONObject;
                                    str13 = jSONArray5;
                                }
                            } else {
                                str19 = jSONObject2.optString(Config.EVENT_NATIVE_VIEW_HIERARCHY);
                                str18 = jSONArray5;
                                jSONArray5 = null;
                                optJSONArray = null;
                                str20 = jSONObject2.optString(Config.EVENT_H5_VIEW_HIERARCHY);
                            }
                            try {
                                optString5 = jSONObject2.optString("ext");
                                str21 = str19;
                                optString6 = jSONObject2.optString(Config.EVENT_ATTR);
                                optInt3 = jSONObject2.optInt("h5");
                                optString7 = jSONObject2.optString("sign");
                            } catch (JSONException unused7) {
                            }
                        } catch (JSONException unused8) {
                            str13 = jSONArray5;
                            str15 = str24;
                            str16 = str25;
                            jSONArray5 = str13;
                            i11 = i7 + 1;
                            str24 = str15;
                            str23 = str14;
                            i10 = i8;
                            length = i6;
                            str22 = str12;
                            str25 = str16;
                            jSONArray4 = jSONArray;
                        }
                    } catch (JSONException unused9) {
                        str12 = str22;
                        str13 = jSONArray5;
                        str15 = str24;
                        str16 = str25;
                        i7 = i11;
                        jSONArray5 = str13;
                        i11 = i7 + 1;
                        str24 = str15;
                        str23 = str14;
                        i10 = i8;
                        length = i6;
                        str22 = str12;
                        str25 = str16;
                        jSONArray4 = jSONArray;
                    }
                    if (j3 == j2 && i9 == 0 && !b(optString5, optString6)) {
                        String optString8 = jSONObject2.optString(Config.PY);
                        if (optLong == j && string.equals(str) && string2.equals(str2)) {
                            if (optString.equals(str4) && optString2.equals(str5)) {
                                if (optString3.equals(str6) && a(optJSONArray, jSONArray2)) {
                                    if (a(jSONArray5, jSONArray3) && optString4.equals(str7) && optInt == i) {
                                        if (optInt2 == i2) {
                                            if (str21.equals(str8)) {
                                                if (str20.equals(str9)) {
                                                    if (optInt3 == i3) {
                                                        try {
                                                            if (optString7.equals(str10) && optString8.equals(str11)) {
                                                                jSONObject3 = jSONObject;
                                                                str13 = str18;
                                                                try {
                                                                    int i12 = jSONObject3.getInt(str13) + jSONObject2.getInt(str13);
                                                                    str15 = str17;
                                                                    try {
                                                                        String optString9 = jSONObject2.optString(str15);
                                                                        if (optString9 != null) {
                                                                            try {
                                                                            } catch (JSONException unused10) {
                                                                                str16 = str16;
                                                                            }
                                                                        }
                                                                        optString9 = str14;
                                                                        str16 = str16;
                                                                        try {
                                                                            long j5 = jSONObject3.getLong(str12) - jSONObject2.getLong(str12);
                                                                            if (j5 < 0) {
                                                                                str12 = str12;
                                                                                j4 = 0;
                                                                            } else {
                                                                                str12 = str12;
                                                                                j4 = j5;
                                                                            }
                                                                            String str26 = optString9 + j4 + "|";
                                                                            try {
                                                                                jSONObject2.remove(str13);
                                                                                jSONObject2.put(str13, i12);
                                                                                jSONObject2.put(str15, str26);
                                                                                a(jSONObject2, jSONObject3);
                                                                                i4 = i6;
                                                                                i5 = i7;
                                                                                break;
                                                                            } catch (JSONException unused11) {
                                                                                i8 = i7;
                                                                            }
                                                                        } catch (JSONException unused12) {
                                                                            str12 = str12;
                                                                        }
                                                                    } catch (JSONException unused13) {
                                                                        continue;
                                                                    }
                                                                } catch (JSONException unused14) {
                                                                }
                                                            }
                                                        } catch (JSONException unused15) {
                                                        }
                                                    }
                                                    jSONObject3 = jSONObject;
                                                    str13 = str18;
                                                    str15 = str17;
                                                    jSONArray5 = str13;
                                                    i11 = i7 + 1;
                                                    str24 = str15;
                                                    str23 = str14;
                                                    i10 = i8;
                                                    length = i6;
                                                    str22 = str12;
                                                    str25 = str16;
                                                    jSONArray4 = jSONArray;
                                                }
                                                jSONObject3 = jSONObject;
                                                str13 = str18;
                                                str15 = str17;
                                                jSONArray5 = str13;
                                                i11 = i7 + 1;
                                                str24 = str15;
                                                str23 = str14;
                                                i10 = i8;
                                                length = i6;
                                                str22 = str12;
                                                str25 = str16;
                                                jSONArray4 = jSONArray;
                                            }
                                            jSONObject3 = jSONObject;
                                            str13 = str18;
                                            str15 = str17;
                                            jSONArray5 = str13;
                                            i11 = i7 + 1;
                                            str24 = str15;
                                            str23 = str14;
                                            i10 = i8;
                                            length = i6;
                                            str22 = str12;
                                            str25 = str16;
                                            jSONArray4 = jSONArray;
                                        } else {
                                            jSONObject3 = jSONObject;
                                            str13 = str18;
                                            str15 = str17;
                                            jSONArray5 = str13;
                                            i11 = i7 + 1;
                                            str24 = str15;
                                            str23 = str14;
                                            i10 = i8;
                                            length = i6;
                                            str22 = str12;
                                            str25 = str16;
                                            jSONArray4 = jSONArray;
                                        }
                                    }
                                    jSONObject3 = jSONObject;
                                    str13 = str18;
                                    str15 = str17;
                                    jSONArray5 = str13;
                                    i11 = i7 + 1;
                                    str24 = str15;
                                    str23 = str14;
                                    i10 = i8;
                                    length = i6;
                                    str22 = str12;
                                    str25 = str16;
                                    jSONArray4 = jSONArray;
                                }
                                jSONObject3 = jSONObject;
                                str13 = str18;
                                str15 = str17;
                                jSONArray5 = str13;
                                i11 = i7 + 1;
                                str24 = str15;
                                str23 = str14;
                                i10 = i8;
                                length = i6;
                                str22 = str12;
                                str25 = str16;
                                jSONArray4 = jSONArray;
                            }
                            jSONObject3 = jSONObject;
                            str13 = str18;
                            str15 = str17;
                            jSONArray5 = str13;
                            i11 = i7 + 1;
                            str24 = str15;
                            str23 = str14;
                            i10 = i8;
                            length = i6;
                            str22 = str12;
                            str25 = str16;
                            jSONArray4 = jSONArray;
                        }
                    }
                    jSONObject3 = jSONObject;
                    str13 = str18;
                    str15 = str17;
                    jSONArray5 = str13;
                    i11 = i7 + 1;
                    str24 = str15;
                    str23 = str14;
                    i10 = i8;
                    length = i6;
                    str22 = str12;
                    str25 = str16;
                    jSONArray4 = jSONArray;
                } else {
                    i4 = length;
                    i5 = i10;
                    break;
                }
            }
            if (i5 < i4) {
                return;
            }
            try {
                jSONArray.put(i4, jSONObject3);
            } catch (JSONException unused16) {
            }
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, jSONObject, jSONObject2) == null) && jSONObject != null && jSONObject2 != null) {
            JSONArray jSONArray = new JSONArray();
            JSONArray optJSONArray2 = jSONObject.optJSONArray(Config.EVENT_HEAT_POINT);
            if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    try {
                        jSONArray.put(optJSONArray2.getJSONObject(i));
                    } catch (Exception unused) {
                    }
                }
            }
            if (jSONArray.length() < 10 && (optJSONArray = jSONObject2.optJSONArray(Config.EVENT_HEAT_POINT)) != null && optJSONArray.length() != 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    try {
                        jSONArray.put(optJSONArray.getJSONObject(i2));
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
    }

    public static boolean a(String str, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            if (str == null) {
                return false;
            }
            try {
                i2 = str.getBytes().length;
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 <= i) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, jSONArray, jSONArray2)) == null) {
            if (jSONArray == null && jSONArray2 == null) {
                return true;
            }
            if (jSONArray != null && jSONArray2 != null && jSONArray.toString().equals(jSONArray2.toString())) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !new JSONObject().toString().equals(str)) {
                return true;
            }
            if (!TextUtils.isEmpty(str2) && !new JSONArray().toString().equals(str2)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void doEventMerge(JSONArray jSONArray, JSONObject jSONObject) {
        String optString;
        String optString2;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, jSONArray, jSONObject) == null) {
            Config.EventViewType.EDIT.getValue();
            try {
                String optString3 = jSONObject.optString(Config.PY);
                long optLong = jSONObject.optLong("ss");
                String string = jSONObject.getString("i");
                String string2 = jSONObject.getString("l");
                long j = jSONObject.getLong("t") / 3600000;
                String optString4 = jSONObject.optString("s");
                int optInt = jSONObject.optInt("at");
                String optString5 = jSONObject.optString("h");
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
                String optString6 = jSONObject.optString("p");
                String optString7 = jSONObject.optString("p2");
                String optString8 = jSONObject.optString("rn");
                int optInt2 = jSONObject.optInt("v");
                String optString9 = jSONObject.optString("ext");
                String optString10 = jSONObject.optString(Config.EVENT_ATTR);
                int optInt3 = jSONObject.optInt("h5");
                String optString11 = jSONObject.optString("sign");
                try {
                    i = jSONObject.getInt("d");
                } catch (JSONException unused) {
                    i = 0;
                }
                if (i == 0 && !b(optString9, optString10)) {
                    a(jSONArray, jSONObject, optLong, string, string2, optString4, j, optString5, jSONArray2, jSONArray3, optString6, optString7, optString8, optInt2, optInt, optString, optString2, optInt3, optString11, optString3);
                    return;
                }
                int length = jSONArray.length();
                jSONObject.put("s", "0");
                jSONArray.put(length, jSONObject);
            } catch (JSONException unused2) {
            }
        }
    }

    public static JSONObject getEvent(Context context, long j, String str, String str2, int i, long j2, long j3, String str3, String str4, int i2, int i3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, Long.valueOf(j), str, str2, Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), extraInfo, map, Boolean.valueOf(z)})) == null) {
            return getEvent(context, j, str, str2, i, j2, j3, str3, null, null, str4, null, null, i2, i3, extraInfo, map, "", "", z);
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject getEvent(Context context, long j, String str, String str2, int i, long j2, long j3, String str3, JSONArray jSONArray, JSONArray jSONArray2, String str4, String str5, String str6, int i2, int i3, ExtraInfo extraInfo, Map<String, String> map, String str7, String str8, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{context, Long.valueOf(j), str, str2, Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), str3, jSONArray, jSONArray2, str4, str5, str6, Integer.valueOf(i2), Integer.valueOf(i3), extraInfo, map, str7, str8, Boolean.valueOf(z)})) == null) {
            return getEvent(context, j, str, str2, "", i, j2, j3, str3, jSONArray, jSONArray2, str4, str5, str6, i2, i3, extraInfo, map, str7, str8, z, null, "", null);
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject getEvent(Context context, long j, String str, String str2, String str3, int i, long j2, long j3, String str4, JSONArray jSONArray, JSONArray jSONArray2, String str5, String str6, String str7, int i2, int i3, ExtraInfo extraInfo, Map<String, String> map, String str8, String str9, boolean z, JSONObject jSONObject, String str10, JSONArray jSONArray3) {
        InterceptResult invokeCommon;
        int i4;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{context, Long.valueOf(j), str, str2, str3, Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), str4, jSONArray, jSONArray2, str5, str6, str7, Integer.valueOf(i2), Integer.valueOf(i3), extraInfo, map, str8, str9, Boolean.valueOf(z), jSONObject, str10, jSONArray3})) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ss", j);
                jSONObject2.put("i", str);
                jSONObject2.put("l", str2);
                jSONObject2.put("c", i);
                jSONObject2.put("t", j2);
                jSONObject2.put("d", j3);
                jSONObject2.put("h", str4);
                if (i3 != 3) {
                    jSONObject2.put(Config.EVENT_NATIVE_VIEW_HIERARCHY, jSONArray);
                    jSONObject2.put(Config.EVENT_H5_VIEW_HIERARCHY, jSONArray2);
                } else {
                    jSONObject2.put(Config.EVENT_NATIVE_VIEW_HIERARCHY, str8);
                    jSONObject2.put(Config.EVENT_H5_VIEW_HIERARCHY, str9);
                    jSONObject2.put("content", str3);
                    jSONObject2.put(Config.PY, DataCore.instance().getEventPy());
                }
                jSONObject2.put("p", str5);
                jSONObject2.put("p2", str6);
                jSONObject2.put("rn", str7);
                jSONObject2.put("v", i2);
                jSONObject2.put("at", i3);
                if (z) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                jSONObject2.put("h5", i4);
                if (extraInfo != null && extraInfo.dumpToJson().length() != 0) {
                    jSONObject2.put("ext", extraInfo.dumpToJson());
                }
                if (map != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value) && !a(value, 1024)) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("k", key);
                            jSONObject3.put("v", value);
                            jSONArray4.put(jSONObject3);
                        }
                    }
                    if (jSONArray4.length() != 0) {
                        jSONObject2.put(Config.EVENT_ATTR, jSONArray4);
                    }
                }
                if (jSONObject != null && jSONObject.length() != 0) {
                    JSONArray jSONArray5 = new JSONArray();
                    jSONArray5.put(jSONObject);
                    jSONObject2.put(Config.EVENT_HEAT_POINT, jSONArray5);
                }
                Object obj2 = "";
                if (TextUtils.isEmpty(str10)) {
                    obj = "";
                } else {
                    obj = str10;
                }
                jSONObject2.put("sign", obj);
                if (jSONArray3 != null && jSONArray3.length() != 0) {
                    obj2 = jSONArray3;
                }
                jSONObject2.put("v5", obj2);
            } catch (Exception unused) {
            }
            return jSONObject2;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public void flushEvent(Context context, long j, String str, String str2, int i, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{context, Long.valueOf(j), str, str2, Integer.valueOf(i), Long.valueOf(j2), jSONArray, jSONArray2, str3, str4, str5, map, Boolean.valueOf(z)}) != null) || !bu.a().e()) {
            return;
        }
        DataCore.instance().putEvent(context, getEvent(context, j, str, str2, i, j2, 0L, "", jSONArray, jSONArray2, str3, str4, str5, Config.EventViewType.EDIT.getValue(), 2, null, map, "", "", z));
        DataCore.instance().flush(context);
    }

    public void onEvent(Context context, long j, String str, String str2, int i, long j2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), str, str2, Integer.valueOf(i), Long.valueOf(j2), extraInfo, map, Boolean.valueOf(z)}) != null) || !bu.a().e()) {
            return;
        }
        a(context, j, str, str2, i, j2, 0L, extraInfo, map, z);
    }

    public void onEventDuration(Context context, long j, String str, String str2, long j2, long j3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j), str, str2, Long.valueOf(j2), Long.valueOf(j3), extraInfo, map, Boolean.valueOf(z)}) != null) || !bu.a().e() || j3 <= 0) {
            return;
        }
        a(context, j, str, str2, 1, j2, j3, extraInfo, map, z);
    }

    public void onEvent(Context context, long j, String str, String str2, int i, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), str, str2, Integer.valueOf(i), Long.valueOf(j2), jSONArray, jSONArray2, str3, str4, str5, map, Boolean.valueOf(z)}) != null) || !bu.a().e()) {
            return;
        }
        flushEvent(context, j, str, str2, i, j2, jSONArray, jSONArray2, str3, str4, str5, map, z);
    }

    public void onEventEnd(Context context, long j, String str, String str2, long j2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), str, str2, Long.valueOf(j2), extraInfo, map, Boolean.valueOf(z)}) == null) {
            String a2 = a(str, str2);
            if (!bu.a().e()) {
                this.a.remove(a2);
                return;
            }
            a aVar = this.a.get(a2);
            if (aVar == null) {
                bb c = bb.c();
                c.b("[WARNING] eventId: " + str + ", with label: " + str2 + " is not started or alread ended");
            } else if ((str != null && !str.equals(aVar.a)) || (str2 != null && !str2.equals(aVar.b))) {
                bb.c().b("[WARNING] eventId/label pair not match");
            } else {
                this.a.remove(a2);
                long j3 = j2 - aVar.c;
                if (j3 < 0) {
                    bb.c().b("[WARNING] onEventEnd must be invoked after onEventStart");
                }
                onEventDuration(context, j, str, str2, aVar.c, j3, extraInfo, map, z);
            }
        }
    }

    public void onEventStart(Context context, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{context, str, str2, Long.valueOf(j)}) != null) || !bu.a().e()) {
            return;
        }
        a aVar = new a(null);
        aVar.c = j;
        aVar.a = str;
        aVar.b = str2;
        String a2 = a(str, str2);
        if (this.a.containsKey(a2)) {
            bb c = bb.c();
            c.b("[WARNING] eventId: " + str + ", with label: " + str2 + " is duplicated, older is removed");
        }
        this.a.put(a2, aVar);
    }
}
