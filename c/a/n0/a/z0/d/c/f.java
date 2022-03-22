package c.a.n0.a.z0.d.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7885b;

    /* renamed from: c  reason: collision with root package name */
    public String f7886c;

    /* renamed from: d  reason: collision with root package name */
    public String f7887d;

    /* renamed from: e  reason: collision with root package name */
    public int f7888e;

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
        this.a = 3;
        this.f7885b = true;
        this.f7887d = "back";
        this.f7888e = 60;
    }

    public static f a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            f fVar = new f();
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    int i = 0;
                    for (int i2 = 0; i2 < length; i2++) {
                        String optString = optJSONArray.optString(i2);
                        char c2 = 65535;
                        int hashCode = optString.hashCode();
                        if (hashCode != -1367751899) {
                            if (hashCode == 92896879 && optString.equals("album")) {
                                c2 = 0;
                            }
                        } else if (optString.equals("camera")) {
                            c2 = 1;
                        }
                        if (c2 == 0) {
                            i |= 1;
                        } else if (c2 == 1) {
                            i |= 2;
                        }
                    }
                    fVar.a = i;
                }
                fVar.f7885b = jSONObject.optBoolean("compressed", true);
                int optInt = jSONObject.optInt("maxDuration", 60);
                fVar.f7888e = optInt <= 60 ? optInt : 60;
                fVar.f7887d = jSONObject.optString("camera");
                fVar.f7886c = jSONObject.optString("cb");
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }
}
