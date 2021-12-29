package c.a.s0.u;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i implements c.a.d.n.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f14469e;

    /* renamed from: f  reason: collision with root package name */
    public String f14470f;

    /* renamed from: g  reason: collision with root package name */
    public String f14471g;

    /* renamed from: h  reason: collision with root package name */
    public int f14472h;

    /* renamed from: i  reason: collision with root package name */
    public int f14473i;

    /* renamed from: j  reason: collision with root package name */
    public String f14474j;

    /* renamed from: k  reason: collision with root package name */
    public String f14475k;
    public List<h> l;
    public String m;
    public boolean n;
    public int o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(252756824, "Lc/a/s0/u/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(252756824, "Lc/a/s0/u/i;");
                return;
            }
        }
        p = BdUniqueId.gen();
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f14469e = jSONObject.optString("user_id");
        this.f14470f = jSONObject.optString("name_show");
        this.f14471g = jSONObject.optString("user_portrait");
        this.f14472h = jSONObject.optInt("user_gender");
        this.f14473i = jSONObject.optInt("user_age", 0);
        this.f14474j = jSONObject.optString("user_constellation");
        this.f14475k = jSONObject.optString("distance");
        JSONArray optJSONArray = jSONObject.optJSONArray("favorite_forum_list");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            this.l = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                h hVar = new h();
                hVar.a(optJSONArray.optJSONObject(i2));
                this.l.add(hVar);
            }
        }
        this.m = jSONObject.optString("user_slogan");
        this.n = jSONObject.optInt("is_friend", 0) == 1;
        this.o = jSONObject.optInt("active_status", 0);
    }

    @Override // c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? p : (BdUniqueId) invokeV.objValue;
    }
}
