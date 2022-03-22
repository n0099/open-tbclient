package c.a.n0.a.e0.d;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public class f extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f4236c;

    /* renamed from: d  reason: collision with root package name */
    public String f4237d;

    /* renamed from: e  reason: collision with root package name */
    public String f4238e;

    /* renamed from: f  reason: collision with root package name */
    public String f4239f;

    /* renamed from: g  reason: collision with root package name */
    public String f4240g;

    public f() {
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
        this.a = "route";
    }

    @Override // c.a.n0.a.e0.d.b
    public void m(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            map.put("fromId", this.f4236c);
            map.put("toId", this.f4237d);
            map.put("toTabIndex", this.f4240g);
            if (!TextUtils.isEmpty(this.f4238e)) {
                map.put("routeType", this.f4238e);
            }
            if (TextUtils.isEmpty(this.f4239f)) {
                return;
            }
            map.put("toPage", this.f4239f);
        }
    }
}
