package c.a.p0.a.j1.d.c;

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
    public boolean f6557b;

    /* renamed from: c  reason: collision with root package name */
    public String f6558c;

    /* renamed from: d  reason: collision with root package name */
    public String f6559d;

    /* renamed from: e  reason: collision with root package name */
    public int f6560e;

    public f() {
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
        this.a = 3;
        this.f6557b = true;
        this.f6559d = com.alipay.sdk.widget.d.u;
        this.f6560e = 60;
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
                    int i2 = 0;
                    for (int i3 = 0; i3 < length; i3++) {
                        String optString = optJSONArray.optString(i3);
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
                            i2 |= 1;
                        } else if (c2 == 1) {
                            i2 |= 2;
                        }
                    }
                    fVar.a = i2;
                }
                fVar.f6557b = jSONObject.optBoolean("compressed", true);
                int optInt = jSONObject.optInt("maxDuration", 60);
                fVar.f6560e = optInt <= 60 ? optInt : 60;
                fVar.f6559d = jSONObject.optString("camera");
                fVar.f6558c = jSONObject.optString("cb");
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }
}
