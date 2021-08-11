package c.a.p0.w0.d;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.funAd.strategy.FunAdSidConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f27291b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, FunAdSidConfigData> f27292a;

    public b() {
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
        HashMap hashMap = new HashMap();
        this.f27292a = hashMap;
        hashMap.clear();
        this.f27292a.putAll(c());
    }

    public static b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f27291b == null) {
                synchronized (b.class) {
                    if (f27291b == null) {
                        f27291b = new b();
                    }
                }
            }
            return f27291b;
        }
        return (b) invokeV.objValue;
    }

    public final FunAdSidConfigData a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            FunAdSidConfigData funAdSidConfigData = new FunAdSidConfigData();
            funAdSidConfigData.parserJson(jSONObject);
            return funAdSidConfigData;
        }
        return (FunAdSidConfigData) invokeL.objValue;
    }

    public FunAdSidConfigData b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f27292a == null || TextUtils.isEmpty(str) || !this.f27292a.containsKey(str)) {
                return null;
            }
            return this.f27292a.get(str);
        }
        return (FunAdSidConfigData) invokeL.objValue;
    }

    public final Map<String, FunAdSidConfigData> c() {
        InterceptResult invokeV;
        FunAdSidConfigData d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap hashMap = new HashMap();
            for (String str : c.e().c()) {
                if (!TextUtils.isEmpty(str) && (d2 = d(str)) != null) {
                    hashMap.put(str, d2);
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public final FunAdSidConfigData d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            JSONObject jSONObject = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String string = c.g().getString(str, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e2) {
                BdLog.detailException(e2);
            }
            return a(jSONObject);
        }
        return (FunAdSidConfigData) invokeL.objValue;
    }

    public void f(String str, FunAdSidConfigData funAdSidConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, funAdSidConfigData) == null) || this.f27292a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f27292a.put(str, funAdSidConfigData);
        g(str);
    }

    public final void g(String str) {
        FunAdSidConfigData funAdSidConfigData;
        JSONObject json;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.f27292a == null || TextUtils.isEmpty(str) || !this.f27292a.containsKey(str) || (funAdSidConfigData = this.f27292a.get(str)) == null || (json = funAdSidConfigData.toJson()) == null) {
            return;
        }
        EditorHelper.putString(c.g(), str, json.toString());
    }
}
