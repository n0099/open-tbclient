package c.a.r0.d1.h2.d;

import c.a.d.m.e.n;
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
/* loaded from: classes5.dex */
public class d implements n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f15553e;

    /* renamed from: f  reason: collision with root package name */
    public String f15554f;

    /* renamed from: g  reason: collision with root package name */
    public String f15555g;

    /* renamed from: h  reason: collision with root package name */
    public String f15556h;

    /* renamed from: i  reason: collision with root package name */
    public String f15557i;

    /* renamed from: j  reason: collision with root package name */
    public String f15558j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f15559k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(772228944, "Lc/a/r0/d1/h2/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(772228944, "Lc/a/r0/d1/h2/d/d;");
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
        this.f15553e = jSONObject.optString("id");
        this.f15554f = jSONObject.optString("main_tower_id");
        jSONObject.optString("forum_id");
        this.f15555g = jSONObject.optString("user_id");
        this.f15556h = jSONObject.optString("user_name");
        jSONObject.optString("create_time");
        this.f15557i = jSONObject.optString("content");
        jSONObject.optString("reply_user_id");
        this.f15558j = jSONObject.optString("time_passed");
        this.f15559k = jSONObject.optInt("is_main_tower_user", 0) == 1;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof d) {
                return this.f15553e.equals(((d) obj).f15553e);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l : (BdUniqueId) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (Integer.valueOf(this.f15553e).intValue() * 31) + 7 : invokeV.intValue;
    }
}
