package c.a.q0.s.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes3.dex */
public class j2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f14240a;

    /* renamed from: b  reason: collision with root package name */
    public String f14241b;

    /* renamed from: c  reason: collision with root package name */
    public int f14242c;

    /* renamed from: d  reason: collision with root package name */
    public int f14243d;

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
        this.f14240a = jSONObject.optLong("birthday_time", 0L);
        this.f14243d = jSONObject.optInt("birthday_show_status", 0);
        this.f14241b = jSONObject.optString("constellation", "");
        this.f14242c = jSONObject.optInt("age", 0);
    }

    public void b(BirthdayInfo birthdayInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, birthdayInfo) == null) || birthdayInfo == null) {
            return;
        }
        this.f14240a = birthdayInfo.birthday_time.longValue();
        this.f14243d = birthdayInfo.birthday_show_status.intValue();
        this.f14241b = birthdayInfo.constellation;
        this.f14242c = birthdayInfo.age.intValue();
    }
}
