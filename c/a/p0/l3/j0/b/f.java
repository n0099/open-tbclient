package c.a.p0.l3.j0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f16237b;

    /* renamed from: c  reason: collision with root package name */
    public int f16238c;

    /* renamed from: d  reason: collision with root package name */
    public long f16239d;

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
            }
        }
    }

    public static f a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            f fVar = new f();
            fVar.a = jSONObject.optInt("agree_num", -1);
            fVar.f16237b = jSONObject.optInt("share_num", -1);
            fVar.f16238c = jSONObject.optInt("reply_num", -1);
            fVar.f16239d = jSONObject.optLong("time", System.currentTimeMillis());
            return fVar;
        }
        return (f) invokeL.objValue;
    }
}
