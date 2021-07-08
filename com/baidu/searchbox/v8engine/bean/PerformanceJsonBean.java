package com.baidu.searchbox.v8engine.bean;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@NotProguard
/* loaded from: classes2.dex */
public class PerformanceJsonBean {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_GAP = "gap";
    public static final String KEY_ID = "id";
    public static final String KEY_TIMESTAMP = "timestamp";
    public static final String TAG = "PerformanceJsonBean";
    public transient /* synthetic */ FieldHolder $fh;
    public List<PerformanceJsonObject> mPerformanceJsonObjectList;

    /* loaded from: classes2.dex */
    public static class PerformanceJsonObject {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String name;
        public long time;

        public PerformanceJsonObject(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.name = str;
            this.time = j;
        }
    }

    public PerformanceJsonBean() {
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
        this.mPerformanceJsonObjectList = new ArrayList();
    }

    private long checkNull(Long l) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, l)) == null) {
            if (l == null) {
                return 0L;
            }
            return l.longValue();
        }
        return invokeL.longValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mPerformanceJsonObjectList.clear();
        }
    }

    public PerformanceJsonObject get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            for (PerformanceJsonObject performanceJsonObject : this.mPerformanceJsonObjectList) {
                if (performanceJsonObject.name.equals(str)) {
                    return performanceJsonObject;
                }
            }
            return null;
        }
        return (PerformanceJsonObject) invokeL.objValue;
    }

    public List<PerformanceJsonObject> getPerformanceJsonObjectList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<PerformanceJsonObject> list = this.mPerformanceJsonObjectList;
            return list == null ? new ArrayList() : list;
        }
        return (List) invokeV.objValue;
    }

    public void put(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            put(str, System.currentTimeMillis());
        }
    }

    public JSONArray toJSONArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                for (PerformanceJsonObject performanceJsonObject : this.mPerformanceJsonObjectList) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", performanceJsonObject.name);
                    jSONObject.put("timestamp", performanceJsonObject.time);
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            clear();
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? toJSONArray().toString() : (String) invokeV.objValue;
    }

    public void put(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) {
            this.mPerformanceJsonObjectList.add(new PerformanceJsonObject(str, j));
        }
    }

    public void put(PerformanceJsonBean performanceJsonBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, performanceJsonBean) == null) {
            this.mPerformanceJsonObjectList.addAll(performanceJsonBean.getPerformanceJsonObjectList());
        }
    }
}
