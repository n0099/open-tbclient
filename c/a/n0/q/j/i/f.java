package c.a.n0.q.j.i;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static f f9242d;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public String f9243b;

    /* renamed from: c  reason: collision with root package name */
    public String f9244c;

    /* loaded from: classes2.dex */
    public static class a extends c.a.n0.w.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super("updatecore_node_tipmsgs");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public f() {
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
        this.a = new a();
        this.f9243b = AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1240);
        this.f9244c = AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1241);
    }

    public static f b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f9242d == null) {
                synchronized (f.class) {
                    if (f9242d == null) {
                        f9242d = new f();
                    }
                }
            }
            return f9242d;
        }
        return (f) invokeV.objValue;
    }

    public String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? this.a.getString(String.format("%04d", Long.valueOf(j)), this.f9243b) : (String) invokeJ.objValue;
    }

    public String c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? this.a.getString(String.format("%04d", Long.valueOf(j)), this.f9244c) : (String) invokeJ.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getString("tips_config_version", "0") : (String) invokeV.objValue;
    }

    public void e(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            hashMap.put(optJSONObject.optString("tipno"), optJSONObject.optString("tipmsg"));
        }
        f(hashMap, optString);
    }

    public void f(HashMap<String, String> hashMap, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, hashMap, str) == null) || hashMap == null || hashMap.isEmpty() || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = this.a.edit();
        edit.clear();
        edit.putString("tips_config_version", str);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            edit.putString(entry.getKey(), entry.getValue());
        }
        edit.apply();
    }
}
