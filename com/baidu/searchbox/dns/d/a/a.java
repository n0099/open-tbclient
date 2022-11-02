package com.baidu.searchbox.dns.d.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import com.yy.gslbsdk.db.ResultTB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int B;
    public String C;
    public long D;
    public String Q;
    public List<String> R;
    public String S;
    public List<String> l;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.S = str;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(this.S);
                this.C = jSONObject.optString("msg", "error");
                this.Q = jSONObject.optString("area");
                this.B = jSONObject.optInt(ResultTB.TTL, -1);
                this.D = jSONObject.optLong("cachetime", -1L);
                JSONArray optJSONArray = jSONObject.optJSONArray("ip");
                this.l = new ArrayList(optJSONArray.length());
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.l.add(optJSONArray.getString(i3));
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray(HttpDnsCacheForHost.JSON_KEY_IPV6);
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    this.R = new ArrayList(optJSONArray2.length());
                    for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        this.R.add(optJSONArray2.getString(i4));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public a(String str, int i, String str2, long j, List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, Long.valueOf(j), list, list2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.C = str;
        this.B = i;
        this.Q = str2;
        this.D = j;
        this.l = list;
        this.R = list2;
        this.S = A();
    }

    private String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray((Collection) this.l);
                JSONArray jSONArray2 = new JSONArray((Collection) this.R);
                jSONObject.put("msg", this.C);
                jSONObject.put("area", this.Q);
                jSONObject.put(ResultTB.TTL, this.B);
                jSONObject.put("cachetime", this.D);
                jSONObject.put("ip", jSONArray);
                jSONObject.put(HttpDnsCacheForHost.JSON_KEY_IPV6, jSONArray2);
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : list) {
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public List<String> getIpList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.l != null) {
                if (DnsUtil.DEBUG) {
                    Log.i(DnsUtil.TAG, " getIp v4 List: " + b(this.l));
                }
                return Collections.unmodifiableList(this.l);
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public List<String> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.R != null) {
                if (DnsUtil.DEBUG) {
                    Log.i(DnsUtil.TAG, " getIp v6 List: " + b(this.R));
                }
                return Collections.unmodifiableList(this.R);
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.S;
        }
        return (String) invokeV.objValue;
    }
}
