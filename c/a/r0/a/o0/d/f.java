package c.a.r0.a.o0.d;

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
    public String f8218c;

    /* renamed from: d  reason: collision with root package name */
    public String f8219d;

    /* renamed from: e  reason: collision with root package name */
    public String f8220e;

    /* renamed from: f  reason: collision with root package name */
    public String f8221f;

    /* renamed from: g  reason: collision with root package name */
    public String f8222g;

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

    @Override // c.a.r0.a.o0.d.b
    public void m(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            map.put("fromId", this.f8218c);
            map.put("toId", this.f8219d);
            map.put("toTabIndex", this.f8222g);
            if (!TextUtils.isEmpty(this.f8220e)) {
                map.put("routeType", this.f8220e);
            }
            if (TextUtils.isEmpty(this.f8221f)) {
                return;
            }
            map.put("toPage", this.f8221f);
        }
    }
}
