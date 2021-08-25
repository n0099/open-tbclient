package c.a.w.b.d.c;

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
    public int f30325a;

    /* renamed from: b  reason: collision with root package name */
    public String f30326b;

    /* renamed from: c  reason: collision with root package name */
    public String f30327c;

    /* renamed from: d  reason: collision with root package name */
    public String f30328d;

    /* renamed from: e  reason: collision with root package name */
    public a f30329e;

    /* renamed from: f  reason: collision with root package name */
    public e f30330f;

    /* renamed from: g  reason: collision with root package name */
    public g f30331g;

    /* renamed from: h  reason: collision with root package name */
    public LiveFeedWrapData f30332h;

    /* renamed from: i  reason: collision with root package name */
    public b f30333i;

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
            this.f30325a = i2;
            this.f30326b = str2;
            g gVar = new g();
            this.f30331g = gVar;
            gVar.b(null, b(str), this.f30325a);
            b bVar = new b();
            this.f30333i = bVar;
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
        this.f30325a = jSONObject.optInt("errno");
        this.f30326b = jSONObject.optString("msg");
        this.f30327c = jSONObject.optString("logid");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            return;
        }
        this.f30328d = optJSONObject.optString("resource");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("banner");
        if (optJSONObject2 != null) {
            a aVar = new a();
            this.f30329e = aVar;
            aVar.a(optJSONObject2);
        }
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("follow");
        if (optJSONObject3 != null) {
            e eVar = new e();
            this.f30330f = eVar;
            eVar.a(optJSONObject3);
        }
        JSONObject optJSONObject4 = optJSONObject.optJSONObject("tab");
        if (optJSONObject4 != null) {
            g gVar = new g();
            this.f30331g = gVar;
            gVar.b(optJSONObject4, b(str), this.f30325a);
        }
        JSONObject optJSONObject5 = optJSONObject.optJSONObject("feed");
        if (optJSONObject5 != null) {
            LiveFeedWrapData liveFeedWrapData = new LiveFeedWrapData();
            this.f30332h = liveFeedWrapData;
            liveFeedWrapData.parserJson(optJSONObject5, i2);
        }
        JSONObject optJSONObject6 = optJSONObject.optJSONObject("config");
        if (optJSONObject6 != null) {
            b bVar = new b();
            this.f30333i = bVar;
            bVar.a(optJSONObject6, b(str));
        }
    }
}
