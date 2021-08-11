package c.a.v.b.d.c;

import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveStatInfo;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f29993a;

    /* renamed from: b  reason: collision with root package name */
    public String f29994b;

    /* renamed from: c  reason: collision with root package name */
    public String f29995c;

    /* renamed from: d  reason: collision with root package name */
    public String f29996d;

    /* renamed from: e  reason: collision with root package name */
    public LiveHostInfo f29997e;

    /* renamed from: f  reason: collision with root package name */
    public LiveStatInfo f29998f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29999g;

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
        this.f29993a = false;
        this.f29999g = true;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f29993a = false;
        jSONObject.optString("feed_id");
        this.f29994b = jSONObject.optString("nid");
        this.f29995c = jSONObject.optString("room_id");
        jSONObject.optString("title");
        jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
        this.f29996d = jSONObject.optString("cmd");
        JSONObject optJSONObject = jSONObject.optJSONObject("host");
        if (optJSONObject != null) {
            LiveHostInfo liveHostInfo = new LiveHostInfo();
            this.f29997e = liveHostInfo;
            liveHostInfo.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("stat");
        if (optJSONObject2 != null) {
            LiveStatInfo liveStatInfo = new LiveStatInfo();
            this.f29998f = liveStatInfo;
            liveStatInfo.parserJson(optJSONObject2);
        }
    }
}
