package com.baidu.searchbox.crius.parser;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SyncInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String action;
    public ArrayList filters;
    public String valueCriusMap;
    public String valuePath;

    /* loaded from: classes2.dex */
    public class Filter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String filterPath;
        public String filterValue;

        public Filter() {
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

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return Objects.hash(this.filterPath, this.filterValue);
            }
            return invokeV.intValue;
        }

        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (!TextUtils.isEmpty(this.filterPath) && !TextUtils.isEmpty(this.filterValue)) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Filter.class != obj.getClass()) {
                    return false;
                }
                Filter filter = (Filter) obj;
                if (Objects.equals(this.filterPath, filter.filterPath) && Objects.equals(this.filterValue, filter.filterValue)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void parse(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            this.filterPath = jSONObject.optString("filter_path");
            this.filterValue = jSONObject.optString("filter_value");
        }
    }

    public SyncInfo() {
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

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return Objects.hash(this.action, this.valuePath, this.valueCriusMap, this.filters);
        }
        return invokeV.intValue;
    }

    public boolean isDataValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TextUtils.isEmpty(this.action) && !TextUtils.isEmpty(this.valuePath)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static SyncInfo parse(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            SyncInfo syncInfo = new SyncInfo();
            syncInfo.action = jSONObject.optString("action");
            syncInfo.valuePath = jSONObject.optString("value_path");
            syncInfo.valueCriusMap = jSONObject.optString("value_crius_map");
            if (jSONObject.has("filters") && (optJSONArray = jSONObject.optJSONArray("filters")) != null && optJSONArray.length() > 0) {
                syncInfo.filters = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    Filter filter = new Filter();
                    try {
                        filter.parse((JSONObject) optJSONArray.get(i));
                        syncInfo.filters.add(filter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return syncInfo;
        }
        return (SyncInfo) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SyncInfo.class != obj.getClass()) {
                return false;
            }
            SyncInfo syncInfo = (SyncInfo) obj;
            if (this.action.equals(syncInfo.action) && this.valuePath.equals(syncInfo.valuePath) && Objects.equals(this.valueCriusMap, syncInfo.valueCriusMap) && Objects.equals(this.filters, syncInfo.filters)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
