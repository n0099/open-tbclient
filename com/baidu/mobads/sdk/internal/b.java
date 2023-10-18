package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public List<a> b;

    public b() {
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
        this.a = 0;
        this.b = new ArrayList();
    }

    public List<a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public static b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            b bVar = new b();
            if (TextUtils.isEmpty(str)) {
                return bVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                bVar.a = jSONObject.optInt("n", 0);
                int optInt = jSONObject.optInt("enc", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("ad");
                if (optInt == 1) {
                    String optString = jSONObject.optString("ad");
                    if (!TextUtils.isEmpty(optString)) {
                        String b = g.b(optString);
                        if (!TextUtils.isEmpty(b)) {
                            optJSONArray = new JSONArray(b);
                        }
                    }
                }
                bVar.b = a.a(optJSONArray);
                return bVar;
            } catch (Throwable th) {
                th.printStackTrace();
                return bVar;
            }
        }
        return (b) invokeL.objValue;
    }
}
