package c.a.o0.t;

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
/* loaded from: classes2.dex */
public class i implements c.a.d.o.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f11455b;

    /* renamed from: c  reason: collision with root package name */
    public String f11456c;

    /* renamed from: d  reason: collision with root package name */
    public int f11457d;

    /* renamed from: e  reason: collision with root package name */
    public int f11458e;

    /* renamed from: f  reason: collision with root package name */
    public String f11459f;

    /* renamed from: g  reason: collision with root package name */
    public String f11460g;

    /* renamed from: h  reason: collision with root package name */
    public List<h> f11461h;
    public String i;
    public boolean j;
    public int k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(997679605, "Lc/a/o0/t/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(997679605, "Lc/a/o0/t/i;");
                return;
            }
        }
        l = BdUniqueId.gen();
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.a = jSONObject.optString("user_id");
        this.f11455b = jSONObject.optString("name_show");
        this.f11456c = jSONObject.optString("user_portrait");
        this.f11457d = jSONObject.optInt("user_gender");
        this.f11458e = jSONObject.optInt("user_age", 0);
        this.f11459f = jSONObject.optString("user_constellation");
        this.f11460g = jSONObject.optString("distance");
        JSONArray optJSONArray = jSONObject.optJSONArray("favorite_forum_list");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            this.f11461h = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                h hVar = new h();
                hVar.a(optJSONArray.optJSONObject(i));
                this.f11461h.add(hVar);
            }
        }
        this.i = jSONObject.optString("user_slogan");
        this.j = jSONObject.optInt("is_friend", 0) == 1;
        this.k = jSONObject.optInt("active_status", 0);
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l : (BdUniqueId) invokeV.objValue;
    }
}
