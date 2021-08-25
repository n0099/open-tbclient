package c.a.o0.n.j.i;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f11992a;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f11992a == null) {
                synchronized (h.class) {
                    if (f11992a == null) {
                        f11992a = new h();
                    }
                }
            }
            return f11992a;
        }
        return (h) invokeV.objValue;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (c.a.o0.n.c.f11828a) {
            String str = WebGLImageLoader.DATA_URL + jSONObject;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null || c.a.o0.n.c.b() == null || c.a.o0.n.c.b().j() == null) {
            return;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("webview");
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("js");
        boolean o = optJSONArray != null ? c.a.o0.n.c.b().o(false, optJSONArray) : true;
        boolean o2 = optJSONArray2 != null ? c.a.o0.n.c.b().o(true, optJSONArray2) : true;
        if (o && o2) {
            c.a.o0.n.c.b().j().putString("key_online_description_fix_version", optString);
        }
    }
}
