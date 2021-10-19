package c.a.q0.s.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class z1 implements c.a.q0.s.f0.o.c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14393a;

    /* renamed from: b  reason: collision with root package name */
    public String f14394b;

    /* renamed from: c  reason: collision with root package name */
    public String f14395c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14396d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14397e;

    /* renamed from: f  reason: collision with root package name */
    public int f14398f;

    /* renamed from: g  reason: collision with root package name */
    public e0 f14399g;

    /* renamed from: h  reason: collision with root package name */
    public int f14400h;

    /* renamed from: i  reason: collision with root package name */
    public int f14401i;

    /* renamed from: j  reason: collision with root package name */
    public String f14402j;

    public z1() {
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

    @Override // c.a.q0.s.f0.o.c.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f14397e = z;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14395c : (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14398f : invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14397e : invokeV.booleanValue;
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f14393a = String.valueOf(jSONObject.optLong("id", 0L));
        this.f14394b = jSONObject.optString("name");
        this.f14395c = jSONObject.optString("avatar");
        this.f14398f = jSONObject.optInt("level_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            e0 e0Var = new e0();
            this.f14399g = e0Var;
            e0Var.a(optJSONObject);
        }
        int optInt = jSONObject.optInt("memberNum", 0);
        this.f14401i = optInt;
        if (optInt == 0) {
            this.f14401i = jSONObject.optInt("member_num", 0);
        }
        this.f14400h = jSONObject.optInt("post_num", 0);
    }

    public void f(SimpleForum simpleForum) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, simpleForum) == null) || simpleForum == null) {
            return;
        }
        this.f14393a = String.valueOf(simpleForum.id);
        this.f14394b = simpleForum.name;
        this.f14395c = simpleForum.avatar;
        this.f14396d = simpleForum.is_liked.intValue() == 1;
        this.f14398f = simpleForum.level_id.intValue();
        if (simpleForum.multi_forum_perm != null) {
            e0 e0Var = new e0();
            this.f14399g = e0Var;
            e0Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.f14401i = simpleForum.member_num.intValue();
        this.f14400h = simpleForum.post_num.intValue();
        this.f14402j = simpleForum.first_class;
    }

    @Override // c.a.q0.s.f0.o.c.b
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14393a : (String) invokeV.objValue;
    }

    @Override // c.a.q0.s.f0.o.c.b
    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14394b : (String) invokeV.objValue;
    }

    @Override // c.a.q0.s.f0.o.a
    public boolean getIsLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f14396d : invokeV.booleanValue;
    }

    @Override // c.a.q0.s.f0.o.a
    public void setIsLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f14396d = z;
        }
    }
}
