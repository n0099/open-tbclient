package c.a.s0.s.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.ActivityInfo;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public String f13714b;

    /* renamed from: c  reason: collision with root package name */
    public String f13715c;

    /* renamed from: d  reason: collision with root package name */
    public int f13716d;

    /* renamed from: e  reason: collision with root package name */
    public int f13717e;

    /* renamed from: f  reason: collision with root package name */
    public String f13718f;

    /* renamed from: g  reason: collision with root package name */
    public String f13719g;

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
            this.f13714b = jSONObject.optString("main_title");
            this.f13715c = jSONObject.optString("sub_title");
            this.f13716d = jSONObject.optInt("back_pic_width");
            this.f13717e = jSONObject.optInt("back_pic_height");
            this.f13718f = jSONObject.optString("back_pic");
            this.f13719g = jSONObject.optString("subpage_link");
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
            this.f13714b = activityInfo.main_title;
            this.f13715c = activityInfo.sub_title;
            this.f13716d = activityInfo.back_pic_width.intValue();
            this.f13717e = activityInfo.back_pic_height.intValue();
            this.f13718f = activityInfo.back_pic;
            this.f13719g = activityInfo.subpage_link;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
