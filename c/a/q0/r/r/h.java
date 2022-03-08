package c.a.q0.r.r;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.ActivityInfo;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public String f13286b;

    /* renamed from: c  reason: collision with root package name */
    public String f13287c;

    /* renamed from: d  reason: collision with root package name */
    public int f13288d;

    /* renamed from: e  reason: collision with root package name */
    public int f13289e;

    /* renamed from: f  reason: collision with root package name */
    public String f13290f;

    /* renamed from: g  reason: collision with root package name */
    public String f13291g;

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
            this.a = jSONObject.optLong("activity_id");
            this.f13286b = jSONObject.optString("main_title");
            this.f13287c = jSONObject.optString("sub_title");
            this.f13288d = jSONObject.optInt("back_pic_width");
            this.f13289e = jSONObject.optInt("back_pic_height");
            this.f13290f = jSONObject.optString("back_pic");
            this.f13291g = jSONObject.optString("subpage_link");
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
            this.a = activityInfo.activity_id.longValue();
            this.f13286b = activityInfo.main_title;
            this.f13287c = activityInfo.sub_title;
            this.f13288d = activityInfo.back_pic_width.intValue();
            this.f13289e = activityInfo.back_pic_height.intValue();
            this.f13290f = activityInfo.back_pic;
            this.f13291g = activityInfo.subpage_link;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
