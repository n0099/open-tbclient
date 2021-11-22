package b.a.q0.s.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes4.dex */
public class j2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f14156a;

    /* renamed from: b  reason: collision with root package name */
    public String f14157b;

    /* renamed from: c  reason: collision with root package name */
    public int f14158c;

    /* renamed from: d  reason: collision with root package name */
    public int f14159d;

    public j2() {
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
        this.f14156a = jSONObject.optLong("birthday_time", 0L);
        this.f14159d = jSONObject.optInt("birthday_show_status", 0);
        this.f14157b = jSONObject.optString("constellation", "");
        this.f14158c = jSONObject.optInt("age", 0);
    }

    public void b(BirthdayInfo birthdayInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, birthdayInfo) == null) || birthdayInfo == null) {
            return;
        }
        this.f14156a = birthdayInfo.birthday_time.longValue();
        this.f14159d = birthdayInfo.birthday_show_status.intValue();
        this.f14157b = birthdayInfo.constellation;
        this.f14158c = birthdayInfo.age.intValue();
    }
}
