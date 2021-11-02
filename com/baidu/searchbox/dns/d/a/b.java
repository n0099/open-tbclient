package com.baidu.searchbox.dns.d.a;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.d.c;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import com.yy.gslbsdk.db.ResultTB;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, a> T;
    public HashMap<String, a> U;
    public boolean V;
    public String W;
    public String X;
    public boolean o;

    public b(String str) {
        JSONObject optJSONObject;
        JSONObject jSONObject;
        String str2;
        ArrayList arrayList;
        ArrayList ipList;
        String str3;
        String str4;
        String str5;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        ArrayList arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.V = false;
        this.o = false;
        this.W = null;
        this.X = null;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject5 = new JSONObject(str);
            String optString = jSONObject5.optString("msg", "error");
            String optString2 = jSONObject5.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
            int optInt = jSONObject5.optInt(ResultTB.TTL, 60) * 1000;
            JSONObject optJSONObject2 = jSONObject5.optJSONObject("data");
            JSONObject optJSONObject3 = jSONObject5.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_BACKUP);
            JSONObject optJSONObject4 = jSONObject5.optJSONObject(HttpDnsCacheForHost.JSON_KEY_EXTINFO);
            this.X = jSONObject5.optString("version");
            long optLong = jSONObject5.optLong("cachetime", System.currentTimeMillis());
            String str6 = HttpDnsCacheForHost.JSON_KEY_IPV6;
            String str7 = "ip";
            if (optJSONObject2 != null) {
                Iterator<String> keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject5 = optJSONObject2.optJSONObject(next);
                    if (optJSONObject5 != null) {
                        JSONArray optJSONArray = optJSONObject5.optJSONArray(str7);
                        ArrayList arrayList3 = new ArrayList(optJSONArray.length());
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            arrayList3.add(optJSONArray.getString(i4));
                        }
                        JSONArray optJSONArray2 = optJSONObject5.optJSONArray(str6);
                        if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                            arrayList2 = null;
                        } else {
                            ArrayList arrayList4 = new ArrayList(optJSONArray2.length());
                            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                arrayList4.add(optJSONArray2.getString(i5));
                            }
                            arrayList2 = arrayList4;
                        }
                        if (!arrayList3.isEmpty() || (arrayList2 != null && !arrayList2.isEmpty())) {
                            String str8 = optString2;
                            str3 = str6;
                            str5 = str7;
                            jSONObject4 = optJSONObject2;
                            jSONObject2 = optJSONObject4;
                            str4 = optString2;
                            jSONObject3 = optJSONObject3;
                            a aVar = new a(optString, optInt, str8, optLong, arrayList3, arrayList2);
                            if (this.T == null) {
                                this.T = new HashMap<>();
                            }
                            this.T.put(next, aVar);
                            if ("httpsdns.baidu.com".equalsIgnoreCase(next) && arrayList3.size() > 0) {
                                c.k((String) arrayList3.get(0));
                                c.a(optLong);
                                str7 = str5;
                                optJSONObject3 = jSONObject3;
                                optJSONObject2 = jSONObject4;
                                str6 = str3;
                                optJSONObject4 = jSONObject2;
                                optString2 = str4;
                            }
                        }
                    } else {
                        str3 = str6;
                        str4 = optString2;
                        str5 = str7;
                        jSONObject2 = optJSONObject4;
                        jSONObject3 = optJSONObject3;
                        jSONObject4 = optJSONObject2;
                    }
                    str7 = str5;
                    optJSONObject3 = jSONObject3;
                    optJSONObject2 = jSONObject4;
                    str6 = str3;
                    optJSONObject4 = jSONObject2;
                    optString2 = str4;
                }
            }
            String str9 = str6;
            String str10 = optString2;
            String str11 = str7;
            JSONObject jSONObject6 = optJSONObject4;
            JSONObject jSONObject7 = optJSONObject3;
            if (jSONObject7 != null) {
                Iterator<String> keys2 = jSONObject7.keys();
                this.U = new HashMap<>();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    JSONObject optJSONObject6 = jSONObject7.optJSONObject(next2);
                    if (optJSONObject6 != null) {
                        JSONArray optJSONArray3 = optJSONObject6.optJSONArray(str11);
                        ArrayList arrayList5 = new ArrayList(optJSONArray3.length());
                        for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                            arrayList5.add(optJSONArray3.getString(i6));
                        }
                        if (!arrayList5.isEmpty()) {
                            this.U.put(next2, new a(optString, optInt, str10, optLong, arrayList5, null));
                        }
                    }
                }
                this.W = jSONObject7.toString();
            }
            if (jSONObject6 != null) {
                this.V = true;
                boolean optBoolean = jSONObject6.optBoolean("ipv6-test-area");
                this.o = optBoolean;
                if (!optBoolean || (optJSONObject = jSONObject6.optJSONObject(HttpDnsCacheForHost.JSON_KEY_IPV6_GROUP)) == null) {
                    return;
                }
                Iterator<String> keys3 = optJSONObject.keys();
                while (keys3.hasNext()) {
                    String next3 = keys3.next();
                    JSONObject optJSONObject7 = optJSONObject.optJSONObject(next3);
                    if (optJSONObject7 != null) {
                        str2 = str9;
                        JSONArray optJSONArray4 = optJSONObject7.optJSONArray(str2);
                        if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                            ArrayList arrayList6 = new ArrayList(optJSONArray4.length());
                            for (int i7 = 0; i7 < optJSONArray4.length(); i7++) {
                                arrayList6.add(optJSONArray4.getString(i7));
                            }
                            JSONArray optJSONArray5 = optJSONObject7.optJSONArray(str11);
                            if (optJSONArray5 == null || optJSONArray5.length() <= 0) {
                                arrayList = null;
                            } else {
                                arrayList = new ArrayList(optJSONArray5.length());
                                for (int i8 = 0; i8 < optJSONArray5.length(); i8++) {
                                    arrayList.add(optJSONArray5.getString(i8));
                                }
                            }
                            if (this.T == null) {
                                this.T = new HashMap<>();
                            }
                            if (arrayList != null && !arrayList.isEmpty()) {
                                ipList = arrayList;
                                jSONObject = optJSONObject;
                                this.T.put(next3, new a(optString, optInt, str10, optLong, ipList, arrayList6));
                            }
                            ipList = this.T.get(next3).getIpList();
                            jSONObject = optJSONObject;
                            this.T.put(next3, new a(optString, optInt, str10, optLong, ipList, arrayList6));
                        }
                        str9 = str2;
                    } else {
                        jSONObject = optJSONObject;
                        str2 = str9;
                    }
                    optJSONObject = jSONObject;
                    str9 = str2;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public Map<String, a> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap<String, a> hashMap = this.T;
            if (hashMap != null) {
                return Collections.unmodifiableMap(hashMap);
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, a> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap<String, a> hashMap = this.U;
            if (hashMap != null) {
                return Collections.unmodifiableMap(hashMap);
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.X : (String) invokeV.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.V : invokeV.booleanValue;
    }

    public boolean isIPv6TestArea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.o : invokeV.booleanValue;
    }
}
