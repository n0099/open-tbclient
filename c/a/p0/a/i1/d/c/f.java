package c.a.p0.a.i1.d.c;

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

    /* renamed from: a  reason: collision with root package name */
    public int f6755a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6756b;

    /* renamed from: c  reason: collision with root package name */
    public String f6757c;

    /* renamed from: d  reason: collision with root package name */
    public String f6758d;

    /* renamed from: e  reason: collision with root package name */
    public int f6759e;

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
        this.f6755a = 3;
        this.f6756b = true;
        this.f6758d = com.alipay.sdk.widget.d.u;
        this.f6759e = 60;
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
                    fVar.f6755a = i2;
                }
                fVar.f6756b = jSONObject.optBoolean("compressed", true);
                int optInt = jSONObject.optInt("maxDuration", 60);
                fVar.f6759e = optInt <= 60 ? optInt : 60;
                fVar.f6758d = jSONObject.optString("camera");
                fVar.f6757c = jSONObject.optString("cb");
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }
}
