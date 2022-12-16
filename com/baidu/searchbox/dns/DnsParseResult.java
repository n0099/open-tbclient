package com.baidu.searchbox.dns;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DnsParseResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NETWORK_STACK_TYPE_BOTH = 3;
    public static final int NETWORK_STACK_TYPE_IPV4 = 1;
    public static final int NETWORK_STACK_TYPE_IPV6 = 2;
    public static final int NETWORK_STACK_TYPE_NONE = 0;
    public static final int SUBTYPE_ASYNC_TASK_ONGOING = 4;
    public static final int SUBTYPE_BACKUP_IP = 5;
    public static final int SUBTYPE_CACHE_ERROR = 1004;
    public static final int SUBTYPE_CACHE_EXPIRE = 1003;
    public static final int SUBTYPE_CACHE_EXPIRE_DEFAULT = 1007;
    public static final int SUBTYPE_CACHE_EXPIRE_USE = 2009;
    public static final int SUBTYPE_CACHE_HIT = 2001;
    public static final int SUBTYPE_CACHE_HIT_DEFAULT = 2003;
    public static final int SUBTYPE_CACHE_HIT_PREFETCH = 1001;
    public static final int SUBTYPE_CACHE_LIST_ENMPTY = 1006;
    public static final int SUBTYPE_CACHE_TIME_INVALID = 1008;
    public static final int SUBTYPE_FORCE_HTTP = 2002;
    public static final int SUBTYPE_HTTP_CLOSE = 1;
    public static final int SUBTYPE_HTTP_ERROR = 2;
    public static final int SUBTYPE_HTTP_LIST_EMPTY = 3;
    public static final int SUBTYPE_NO_CACHE = 1002;
    public static final int SUBYYPE_CACHE_INVALID = 1005;
    public static final int TYPE_DNS_PROXY = 2000;
    public static final int TYPE_LOCAL = 0;
    public static final int TYPE_LOCAL_ASYNC_HTTP = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public int addressType;
    public String area;
    public String clientIp;
    public String httpdnsIp;
    public boolean idcToBgp;
    public List<String> ipList;
    public int stackType;
    public int subType;
    public int type;

    public DnsParseResult(List<String> list, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.stackType = 0;
        this.idcToBgp = false;
        if (list != null && !list.isEmpty()) {
            this.ipList = Collections.unmodifiableList(list);
        } else {
            this.ipList = null;
        }
        this.type = i;
        this.subType = i2;
        this.stackType = i3;
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

    public List<String> getIpList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.ipList;
        }
        return (List) invokeV.objValue;
    }

    public int getStackType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.stackType;
        }
        return invokeV.intValue;
    }

    public int getSubType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.subType;
        }
        return invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public void setHttpdnsInfo(String str, String str2, String str3, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, str2, str3, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.area = str;
            this.clientIp = str2;
            this.httpdnsIp = str3;
            this.addressType = i;
            this.idcToBgp = z;
        }
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.type);
                jSONObject.put(AdvisoryMsgBusinessExtra.SUBTYPE_KEY, this.subType);
                jSONObject.put("ipList", new JSONArray((Collection) this.ipList));
                jSONObject.put("stackType", this.stackType);
                jSONObject.put(DnsModel.AREA_KEY, this.area);
                jSONObject.put("clientIp", this.clientIp);
                jSONObject.put(DnsModel.HTTPDNSIP_KEY, this.httpdnsIp);
                jSONObject.put(DnsModel.ADDRESSTYPE_KEY, this.addressType);
                jSONObject.put(DnsModel.IDCTOBGP_KEY, this.idcToBgp);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
