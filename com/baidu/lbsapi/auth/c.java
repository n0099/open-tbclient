package com.baidu.lbsapi.auth;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public HashMap b;
    public a c;

    /* loaded from: classes2.dex */
    public interface a {
        void a(Object obj);
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.a = context;
    }

    private HashMap a(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, hashMap)) == null) {
            HashMap hashMap2 = new HashMap();
            for (String str : hashMap.keySet()) {
                String str2 = str.toString();
                hashMap2.put(str2, hashMap.get(str2));
            }
            return hashMap2;
        }
        return (HashMap) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            if (str == null) {
                str = "";
            }
            try {
                jSONObject = new JSONObject(str);
                if (!jSONObject.has("status")) {
                    jSONObject.put("status", -1);
                }
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("status", -1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(jSONObject.toString());
            }
        }
    }

    public void a(HashMap hashMap, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hashMap, aVar) == null) {
            this.b = a(hashMap);
            this.c = aVar;
            new Thread(new d(this)).start();
        }
    }
}
