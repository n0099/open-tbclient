package b.a.q0.s.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.ActivityInfo;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f13334a;

    /* renamed from: b  reason: collision with root package name */
    public String f13335b;

    /* renamed from: c  reason: collision with root package name */
    public String f13336c;

    /* renamed from: d  reason: collision with root package name */
    public int f13337d;

    /* renamed from: e  reason: collision with root package name */
    public int f13338e;

    /* renamed from: f  reason: collision with root package name */
    public String f13339f;

    /* renamed from: g  reason: collision with root package name */
    public String f13340g;

    public h() {
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

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f13334a = jSONObject.optLong("activity_id");
            this.f13335b = jSONObject.optString("main_title");
            this.f13336c = jSONObject.optString("sub_title");
            this.f13337d = jSONObject.optInt("back_pic_width");
            this.f13338e = jSONObject.optInt("back_pic_height");
            this.f13339f = jSONObject.optString("back_pic");
            this.f13340g = jSONObject.optString("subpage_link");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void b(ActivityInfo activityInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activityInfo) == null) || activityInfo == null) {
            return;
        }
        try {
            this.f13334a = activityInfo.activity_id.longValue();
            this.f13335b = activityInfo.main_title;
            this.f13336c = activityInfo.sub_title;
            this.f13337d = activityInfo.back_pic_width.intValue();
            this.f13338e = activityInfo.back_pic_height.intValue();
            this.f13339f = activityInfo.back_pic;
            this.f13340g = activityInfo.subpage_link;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
