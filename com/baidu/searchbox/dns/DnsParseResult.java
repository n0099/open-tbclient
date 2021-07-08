package com.baidu.searchbox.dns;

import com.baidu.android.imsdk.internal.Constants;
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
    public int l;
    public List<String> m;
    public int stackType;
    public int type;

    public DnsParseResult(List<String> list, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.stackType = 0;
        if (list != null && !list.isEmpty()) {
            this.m = Collections.unmodifiableList(list);
        } else {
            this.m = null;
        }
        this.type = i2;
        this.l = i3;
        this.stackType = i4;
    }

    public List<String> getIpList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : (List) invokeV.objValue;
    }

    public int getStackType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.stackType : invokeV.intValue;
    }

    public int getSubType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.type : invokeV.intValue;
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.type);
                jSONObject.put("subType", this.l);
                jSONObject.put("ipList", new JSONArray((Collection) this.m));
                jSONObject.put("stackType", this.stackType);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
