package c.a.s0.a.o0.d;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.Map;
/* loaded from: classes.dex */
public class f extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f8278c;

    /* renamed from: d  reason: collision with root package name */
    public String f8279d;

    /* renamed from: e  reason: collision with root package name */
    public String f8280e;

    /* renamed from: f  reason: collision with root package name */
    public String f8281f;

    /* renamed from: g  reason: collision with root package name */
    public String f8282g;

    public f() {
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
        this.a = FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE;
    }

    @Override // c.a.s0.a.o0.d.b
    public void m(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            map.put("fromId", this.f8278c);
            map.put("toId", this.f8279d);
            map.put("toTabIndex", this.f8282g);
            if (!TextUtils.isEmpty(this.f8280e)) {
                map.put("routeType", this.f8280e);
            }
            if (TextUtils.isEmpty(this.f8281f)) {
                return;
            }
            map.put("toPage", this.f8281f);
        }
    }
}
