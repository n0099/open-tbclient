package c.a.q0.v.d.c.f.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f25113e;

    /* renamed from: f  reason: collision with root package name */
    public String f25114f;

    /* renamed from: g  reason: collision with root package name */
    public String f25115g;

    /* renamed from: h  reason: collision with root package name */
    public String f25116h;

    /* renamed from: i  reason: collision with root package name */
    public String f25117i;

    /* renamed from: j  reason: collision with root package name */
    public String f25118j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1168471721, "Lc/a/q0/v/d/c/f/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1168471721, "Lc/a/q0/v/d/c/f/b/b;");
                return;
            }
        }
        k = BdUniqueId.gen();
    }

    public b() {
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

    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f25113e = jSONObject.optString("user_id");
        this.f25114f = jSONObject.optString("user_name");
        this.f25115g = jSONObject.optString("user_nickname");
        this.f25116h = jSONObject.optString("portrait");
        this.f25117i = jSONObject.optString("user_brief");
        jSONObject.optLong(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY);
        this.f25118j = jSONObject.optString("remark");
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? k : (BdUniqueId) invokeV.objValue;
    }
}
