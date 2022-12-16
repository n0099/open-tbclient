package com.baidu.searchbox.dns.transmit.model;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DnsModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ADDRESSTYPE_KEY = "addressType";
    public static final String AREA_KEY = "area";
    public static final String CACHETIME_KEY = "cachetime";
    public static final String CLIENTIP_KEY = "clientip";
    public static final int DEFAULT_TTL = 60;
    public static final String HTTPDNSIP_KEY = "httpdnsIp";
    public static final String IDCTOBGP_KEY = "idcToBgp";
    public static final String IPV6_KEY = "ipv6";
    public static final String IP_KEY = "ip";
    public static final String MSG_ERROR = "error";
    public static final String MSG_KEY = "msg";
    public static final String MSG_OK = "ok";
    public static final String MSG_STOP = "stop";
    public static final String MSG_WARNING = "warning";
    public static final String TTL_KEY = "ttl";
    public transient /* synthetic */ FieldHolder $fh;
    public int addressType;
    public String area;
    public long cacheTime;
    public String clientIp;
    public String httpdnsIp;
    public boolean idcToBgp;
    public List<String> ipList;
    public List<String> ipv6List;
    public String msg;
    public String rawString;
    public int ttl;

    public DnsModel(String str) {
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
        this.idcToBgp = false;
        this.rawString = str;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(this.rawString);
                this.msg = jSONObject.optString("msg", "error");
                this.area = jSONObject.optString(AREA_KEY);
                this.clientIp = jSONObject.optString(CLIENTIP_KEY);
                this.httpdnsIp = jSONObject.optString(HTTPDNSIP_KEY);
                this.addressType = jSONObject.optInt(ADDRESSTYPE_KEY);
                this.idcToBgp = jSONObject.optBoolean(IDCTOBGP_KEY);
                this.ttl = jSONObject.optInt("ttl", -1);
                this.cacheTime = jSONObject.optLong(CACHETIME_KEY, -1L);
                JSONArray optJSONArray = jSONObject.optJSONArray("ip");
                this.ipList = new ArrayList(optJSONArray.length());
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.ipList.add(optJSONArray.getString(i3));
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ipv6");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    this.ipv6List = new ArrayList(optJSONArray2.length());
                    for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        this.ipv6List.add(optJSONArray2.getString(i4));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public DnsModel(String str, int i, String str2, String str3, String str4, int i2, boolean z, long j, List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, Integer.valueOf(i), str2, str3, str4, Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j), list, list2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.idcToBgp = false;
        this.msg = str;
        this.ttl = i;
        this.area = str2;
        this.cacheTime = j;
        this.clientIp = str3;
        this.httpdnsIp = str4;
        this.addressType = i2;
        this.idcToBgp = z;
        this.ipList = list;
        this.ipv6List = list2;
        this.rawString = getRawString();
    }

    private String getRawString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray((Collection) this.ipList);
                JSONArray jSONArray2 = new JSONArray((Collection) this.ipv6List);
                jSONObject.put("msg", this.msg);
                jSONObject.put(AREA_KEY, this.area);
                jSONObject.put(CLIENTIP_KEY, this.clientIp);
                jSONObject.put(HTTPDNSIP_KEY, this.httpdnsIp);
                jSONObject.put(ADDRESSTYPE_KEY, this.addressType);
                jSONObject.put(IDCTOBGP_KEY, this.idcToBgp);
                jSONObject.put("ttl", this.ttl);
                jSONObject.put(CACHETIME_KEY, this.cacheTime);
                jSONObject.put("ip", jSONArray);
                jSONObject.put("ipv6", jSONArray2);
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String listToString(List<String> list) {
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

    public int getAddressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.addressType;
        }
        return invokeV.intValue;
    }

    public String getArea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.area;
        }
        return (String) invokeV.objValue;
    }

    public String getClientIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.clientIp;
        }
        return (String) invokeV.objValue;
    }

    public String getHttpdnsIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.httpdnsIp;
        }
        return (String) invokeV.objValue;
    }

    public boolean getIdcToBgp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.idcToBgp;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.rawString;
        }
        return (String) invokeV.objValue;
    }

    public List<String> getIpList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.ipList != null) {
                if (DnsUtil.DEBUG) {
                    Log.i(DnsUtil.TAG, " getIp v4 List: " + listToString(this.ipList));
                }
                return Collections.unmodifiableList(this.ipList);
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public List<String> getIpv6List() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.ipv6List != null) {
                if (DnsUtil.DEBUG) {
                    Log.i(DnsUtil.TAG, " getIp v6 List: " + listToString(this.ipv6List));
                }
                return Collections.unmodifiableList(this.ipv6List);
            }
            return null;
        }
        return (List) invokeV.objValue;
    }
}
