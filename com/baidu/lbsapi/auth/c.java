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

    /* renamed from: a  reason: collision with root package name */
    public Context f6385a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f6386b;

    /* renamed from: c  reason: collision with root package name */
    public a<String> f6387c;

    /* loaded from: classes2.dex */
    public interface a<Result> {
        void a(Result result);
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6386b = null;
        this.f6387c = null;
        this.f6385a = context;
    }

    private HashMap<String, String> a(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, hashMap)) == null) {
            HashMap<String, String> hashMap2 = new HashMap<>();
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
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            a<String> aVar = this.f6387c;
            if (aVar != null) {
                aVar.a(jSONObject.toString());
            }
        }
    }

    public void a(HashMap<String, String> hashMap, a<String> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hashMap, aVar) == null) {
            this.f6386b = a(hashMap);
            this.f6387c = aVar;
            new Thread(new d(this)).start();
        }
    }
}
