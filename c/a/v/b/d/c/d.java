package c.a.v.b.d.c;

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
    public String f21433b;

    /* renamed from: c  reason: collision with root package name */
    public String f21434c;

    /* renamed from: d  reason: collision with root package name */
    public String f21435d;

    /* renamed from: e  reason: collision with root package name */
    public LiveHostInfo f21436e;

    /* renamed from: f  reason: collision with root package name */
    public LiveStatInfo f21437f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21438g;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f21438g = true;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = false;
        jSONObject.optString("feed_id");
        this.f21433b = jSONObject.optString("nid");
        this.f21434c = jSONObject.optString("room_id");
        jSONObject.optString("title");
        jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
        this.f21435d = jSONObject.optString("cmd");
        JSONObject optJSONObject = jSONObject.optJSONObject("host");
        if (optJSONObject != null) {
            LiveHostInfo liveHostInfo = new LiveHostInfo();
            this.f21436e = liveHostInfo;
            liveHostInfo.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("stat");
        if (optJSONObject2 != null) {
            LiveStatInfo liveStatInfo = new LiveStatInfo();
            this.f21437f = liveStatInfo;
            liveStatInfo.parserJson(optJSONObject2);
        }
    }
}
