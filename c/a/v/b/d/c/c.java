package c.a.v.b.d.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f29984a;

    /* renamed from: b  reason: collision with root package name */
    public String f29985b;

    /* renamed from: c  reason: collision with root package name */
    public String f29986c;

    /* renamed from: d  reason: collision with root package name */
    public String f29987d;

    /* renamed from: e  reason: collision with root package name */
    public a f29988e;

    /* renamed from: f  reason: collision with root package name */
    public e f29989f;

    /* renamed from: g  reason: collision with root package name */
    public g f29990g;

    /* renamed from: h  reason: collision with root package name */
    public LiveFeedWrapData f29991h;

    /* renamed from: i  reason: collision with root package name */
    public b f29992i;

    public c() {
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

    public void a(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            this.f29984a = i2;
            this.f29985b = str2;
            g gVar = new g();
            this.f29990g = gVar;
            gVar.b(null, b(str), this.f29984a);
            b bVar = new b();
            this.f29992i = bVar;
            bVar.a(null, b(str));
        }
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? "banner,tab,feed,follow,config".equals(str) : invokeL.booleanValue;
    }

    public void c(JSONObject jSONObject, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str, i2) == null) || jSONObject == null) {
            return;
        }
        this.f29984a = jSONObject.optInt("errno");
        this.f29985b = jSONObject.optString("msg");
        this.f29986c = jSONObject.optString("logid");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            return;
        }
        this.f29987d = optJSONObject.optString("resource");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("banner");
        if (optJSONObject2 != null) {
            a aVar = new a();
            this.f29988e = aVar;
            aVar.a(optJSONObject2);
        }
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("follow");
        if (optJSONObject3 != null) {
            e eVar = new e();
            this.f29989f = eVar;
            eVar.a(optJSONObject3);
        }
        JSONObject optJSONObject4 = optJSONObject.optJSONObject("tab");
        if (optJSONObject4 != null) {
            g gVar = new g();
            this.f29990g = gVar;
            gVar.b(optJSONObject4, b(str), this.f29984a);
        }
        JSONObject optJSONObject5 = optJSONObject.optJSONObject("feed");
        if (optJSONObject5 != null) {
            LiveFeedWrapData liveFeedWrapData = new LiveFeedWrapData();
            this.f29991h = liveFeedWrapData;
            liveFeedWrapData.parserJson(optJSONObject5, i2);
        }
        JSONObject optJSONObject6 = optJSONObject.optJSONObject("config");
        if (optJSONObject6 != null) {
            b bVar = new b();
            this.f29992i = bVar;
            bVar.a(optJSONObject6, b(str));
        }
    }
}
