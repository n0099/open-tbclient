package com.baidu.mobstat.dxmpay;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class EventAnalysis {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> a;

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
        this.a = new HashMap();
    }

    public static void doEventMerge(JSONArray jSONArray, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, jSONArray, jSONObject) == null) {
        }
    }

    public static JSONObject getEvent(Context context, long j2, String str, String str2, int i2, long j3, long j4, String str3, String str4, int i3, int i4, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), str3, str4, Integer.valueOf(i3), Integer.valueOf(i4), extraInfo, map, Boolean.valueOf(z)})) == null) ? getEvent(context, j2, str, str2, i2, j3, j4, str3, null, null, str4, null, null, i3, i4, extraInfo, map, "", "", z) : (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject getEvent(Context context, long j2, String str, String str2, String str3, int i2, long j3, long j4, String str4, JSONArray jSONArray, JSONArray jSONArray2, String str5, String str6, String str7, int i3, int i4, ExtraInfo extraInfo, Map<String, String> map, String str8, String str9, boolean z, JSONObject jSONObject, String str10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Long.valueOf(j2), str, str2, str3, Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), str4, jSONArray, jSONArray2, str5, str6, str7, Integer.valueOf(i3), Integer.valueOf(i4), extraInfo, map, str8, str9, Boolean.valueOf(z), jSONObject, str10})) == null) {
            return null;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public void flushEvent(Context context, long j2, String str, String str2, int i2, long j3, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), jSONArray, jSONArray2, str3, str4, str5, map, Boolean.valueOf(z)}) == null) {
        }
    }

    public void onEvent(Context context, long j2, String str, String str2, int i2, long j3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), extraInfo, map, Boolean.valueOf(z)}) == null) {
        }
    }

    public void onEvent(Context context, long j2, String str, String str2, int i2, long j3, String str3, String str4, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), str3, str4, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
        }
    }

    public void onEvent(Context context, long j2, String str, String str2, int i2, long j3, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), jSONArray, jSONArray2, str3, str4, str5, map, Boolean.valueOf(z)}) == null) {
        }
    }

    public void onEventDuration(Context context, long j2, String str, String str2, long j3, long j4, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j2), str, str2, Long.valueOf(j3), Long.valueOf(j4), extraInfo, map, Boolean.valueOf(z)}) == null) {
        }
    }

    public void onEventEnd(Context context, long j2, String str, String str2, long j3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j2), str, str2, Long.valueOf(j3), extraInfo, map, Boolean.valueOf(z)}) == null) {
        }
    }

    public void onEventStart(Context context, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, str2, Long.valueOf(j2)}) == null) {
        }
    }

    public static JSONObject getEvent(Context context, long j2, String str, String str2, int i2, long j3, long j4, String str3, JSONArray jSONArray, JSONArray jSONArray2, String str4, String str5, String str6, int i3, int i4, ExtraInfo extraInfo, Map<String, String> map, String str7, String str8, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), str3, jSONArray, jSONArray2, str4, str5, str6, Integer.valueOf(i3), Integer.valueOf(i4), extraInfo, map, str7, str8, Boolean.valueOf(z)})) == null) ? getEvent(context, j2, str, str2, "", i2, j3, j4, str3, jSONArray, jSONArray2, str4, str5, str6, i3, i4, extraInfo, map, str7, str8, z, null, "") : (JSONObject) invokeCommon.objValue;
    }
}
