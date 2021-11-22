package b.a.p0.a.o0.d;

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
    public String f7450c;

    /* renamed from: d  reason: collision with root package name */
    public String f7451d;

    /* renamed from: e  reason: collision with root package name */
    public String f7452e;

    /* renamed from: f  reason: collision with root package name */
    public String f7453f;

    /* renamed from: g  reason: collision with root package name */
    public String f7454g;

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
        this.f7439a = FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE;
    }

    @Override // b.a.p0.a.o0.d.b
    public void m(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            map.put("fromId", this.f7450c);
            map.put("toId", this.f7451d);
            map.put("toTabIndex", this.f7454g);
            if (!TextUtils.isEmpty(this.f7452e)) {
                map.put("routeType", this.f7452e);
            }
            if (TextUtils.isEmpty(this.f7453f)) {
                return;
            }
            map.put("toPage", this.f7453f);
        }
    }
}
