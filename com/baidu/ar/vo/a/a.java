package com.baidu.ar.vo.a;

import com.baidu.ar.h.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static b aW(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            File file = new File(str, "targets.json");
            if (file.exists()) {
                try {
                    return i(new JSONObject(i.f(file)).optJSONObject("slam_model"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public static b i(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            try {
                if (jSONObject.has("id")) {
                    bVar.setId(jSONObject.getString("id"));
                }
                if (jSONObject.has("place_type")) {
                    bVar.T(jSONObject.getInt("place_type"));
                }
                if (jSONObject.has("position")) {
                    bVar.aX(jSONObject.getString("position"));
                }
                if (jSONObject.has("distance")) {
                    bVar.U(jSONObject.getInt("distance"));
                }
                if (jSONObject.has("pitch_angle")) {
                    bVar.V(jSONObject.getInt("pitch_angle"));
                }
                if (jSONObject.has("rotation")) {
                    bVar.aY(jSONObject.getString("rotation"));
                }
                if (jSONObject.has("immediately_place_model")) {
                    boolean z = true;
                    if (jSONObject.getInt("immediately_place_model") != 1) {
                        z = false;
                    }
                    bVar.V(z);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }
}
