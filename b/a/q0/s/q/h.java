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
    public long f14114a;

    /* renamed from: b  reason: collision with root package name */
    public String f14115b;

    /* renamed from: c  reason: collision with root package name */
    public String f14116c;

    /* renamed from: d  reason: collision with root package name */
    public int f14117d;

    /* renamed from: e  reason: collision with root package name */
    public int f14118e;

    /* renamed from: f  reason: collision with root package name */
    public String f14119f;

    /* renamed from: g  reason: collision with root package name */
    public String f14120g;

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
            this.f14114a = jSONObject.optLong("activity_id");
            this.f14115b = jSONObject.optString("main_title");
            this.f14116c = jSONObject.optString("sub_title");
            this.f14117d = jSONObject.optInt("back_pic_width");
            this.f14118e = jSONObject.optInt("back_pic_height");
            this.f14119f = jSONObject.optString("back_pic");
            this.f14120g = jSONObject.optString("subpage_link");
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
            this.f14114a = activityInfo.activity_id.longValue();
            this.f14115b = activityInfo.main_title;
            this.f14116c = activityInfo.sub_title;
            this.f14117d = activityInfo.back_pic_width.intValue();
            this.f14118e = activityInfo.back_pic_height.intValue();
            this.f14119f = activityInfo.back_pic;
            this.f14120g = activityInfo.subpage_link;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
