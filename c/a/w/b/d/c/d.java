package c.a.w.b.d.c;

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
    public boolean f30334a;

    /* renamed from: b  reason: collision with root package name */
    public String f30335b;

    /* renamed from: c  reason: collision with root package name */
    public String f30336c;

    /* renamed from: d  reason: collision with root package name */
    public String f30337d;

    /* renamed from: e  reason: collision with root package name */
    public LiveHostInfo f30338e;

    /* renamed from: f  reason: collision with root package name */
    public LiveStatInfo f30339f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30340g;

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
        this.f30334a = false;
        this.f30340g = true;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f30334a = false;
        jSONObject.optString("feed_id");
        this.f30335b = jSONObject.optString("nid");
        this.f30336c = jSONObject.optString("room_id");
        jSONObject.optString("title");
        jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
        this.f30337d = jSONObject.optString("cmd");
        JSONObject optJSONObject = jSONObject.optJSONObject("host");
        if (optJSONObject != null) {
            LiveHostInfo liveHostInfo = new LiveHostInfo();
            this.f30338e = liveHostInfo;
            liveHostInfo.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("stat");
        if (optJSONObject2 != null) {
            LiveStatInfo liveStatInfo = new LiveStatInfo();
            this.f30339f = liveStatInfo;
            liveStatInfo.parserJson(optJSONObject2);
        }
    }
}
