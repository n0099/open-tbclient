package b.a.q0.s.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.SimpleForum;
/* loaded from: classes4.dex */
public class z1 implements b.a.q0.s.g0.o.c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14287a;

    /* renamed from: b  reason: collision with root package name */
    public String f14288b;

    /* renamed from: c  reason: collision with root package name */
    public String f14289c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14290d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14291e;

    /* renamed from: f  reason: collision with root package name */
    public int f14292f;

    /* renamed from: g  reason: collision with root package name */
    public e0 f14293g;

    /* renamed from: h  reason: collision with root package name */
    public int f14294h;

    /* renamed from: i  reason: collision with root package name */
    public int f14295i;
    public String j;

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

    @Override // b.a.q0.s.g0.o.c.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f14291e = z;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14289c : (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14292f : invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14291e : invokeV.booleanValue;
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f14287a = String.valueOf(jSONObject.optLong("id", 0L));
        this.f14288b = jSONObject.optString("name");
        this.f14289c = jSONObject.optString("avatar");
        this.f14292f = jSONObject.optInt("level_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            e0 e0Var = new e0();
            this.f14293g = e0Var;
            e0Var.a(optJSONObject);
        }
        int optInt = jSONObject.optInt("memberNum", 0);
        this.f14295i = optInt;
        if (optInt == 0) {
            this.f14295i = jSONObject.optInt("member_num", 0);
        }
        this.f14294h = jSONObject.optInt("post_num", 0);
    }

    public void f(SimpleForum simpleForum) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, simpleForum) == null) || simpleForum == null) {
            return;
        }
        this.f14287a = String.valueOf(simpleForum.id);
        this.f14288b = simpleForum.name;
        this.f14289c = simpleForum.avatar;
        this.f14290d = simpleForum.is_liked.intValue() == 1;
        this.f14292f = simpleForum.level_id.intValue();
        if (simpleForum.multi_forum_perm != null) {
            e0 e0Var = new e0();
            this.f14293g = e0Var;
            e0Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.f14295i = simpleForum.member_num.intValue();
        this.f14294h = simpleForum.post_num.intValue();
        this.j = simpleForum.first_class;
    }

    @Override // b.a.q0.s.g0.o.c.b
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14287a : (String) invokeV.objValue;
    }

    @Override // b.a.q0.s.g0.o.c.b
    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14288b : (String) invokeV.objValue;
    }

    @Override // b.a.q0.s.g0.o.a
    public boolean getIsLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f14290d : invokeV.booleanValue;
    }

    @Override // b.a.q0.s.g0.o.a
    public void setIsLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f14290d = z;
        }
    }
}
