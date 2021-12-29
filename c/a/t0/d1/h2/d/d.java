package c.a.t0.d1.h2.d;

import c.a.d.n.e.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d implements n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f16458e;

    /* renamed from: f  reason: collision with root package name */
    public String f16459f;

    /* renamed from: g  reason: collision with root package name */
    public String f16460g;

    /* renamed from: h  reason: collision with root package name */
    public String f16461h;

    /* renamed from: i  reason: collision with root package name */
    public String f16462i;

    /* renamed from: j  reason: collision with root package name */
    public String f16463j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f16464k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(185422930, "Lc/a/t0/d1/h2/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(185422930, "Lc/a/t0/d1/h2/d/d;");
                return;
            }
        }
        l = BdUniqueId.gen();
    }

    public d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (jSONObject == null) {
            return;
        }
        this.f16458e = jSONObject.optString("id");
        this.f16459f = jSONObject.optString("main_tower_id");
        jSONObject.optString("forum_id");
        this.f16460g = jSONObject.optString("user_id");
        this.f16461h = jSONObject.optString("user_name");
        jSONObject.optString("create_time");
        this.f16462i = jSONObject.optString("content");
        jSONObject.optString("reply_user_id");
        this.f16463j = jSONObject.optString("time_passed");
        this.f16464k = jSONObject.optInt("is_main_tower_user", 0) == 1;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof d) {
                return this.f16458e.equals(((d) obj).f16458e);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l : (BdUniqueId) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (Integer.valueOf(this.f16458e).intValue() * 31) + 7 : invokeV.intValue;
    }
}
