package c.a.w.b.d.c;

import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveStatInfo;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f26296b;

    /* renamed from: c  reason: collision with root package name */
    public String f26297c;

    /* renamed from: d  reason: collision with root package name */
    public String f26298d;

    /* renamed from: e  reason: collision with root package name */
    public LiveHostInfo f26299e;

    /* renamed from: f  reason: collision with root package name */
    public LiveStatInfo f26300f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26301g;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f26301g = true;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = false;
        jSONObject.optString("feed_id");
        this.f26296b = jSONObject.optString("nid");
        this.f26297c = jSONObject.optString("room_id");
        jSONObject.optString("title");
        jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
        this.f26298d = jSONObject.optString("cmd");
        JSONObject optJSONObject = jSONObject.optJSONObject("host");
        if (optJSONObject != null) {
            LiveHostInfo liveHostInfo = new LiveHostInfo();
            this.f26299e = liveHostInfo;
            liveHostInfo.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("stat");
        if (optJSONObject2 != null) {
            LiveStatInfo liveStatInfo = new LiveStatInfo();
            this.f26300f = liveStatInfo;
            liveStatInfo.parserJson(optJSONObject2);
        }
    }
}
