package c.a.p0.a.e0.d;

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
    public String f5006c;

    /* renamed from: d  reason: collision with root package name */
    public String f5007d;

    /* renamed from: e  reason: collision with root package name */
    public String f5008e;

    /* renamed from: f  reason: collision with root package name */
    public String f5009f;

    /* renamed from: g  reason: collision with root package name */
    public String f5010g;

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

    @Override // c.a.p0.a.e0.d.b
    public void m(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            map.put("fromId", this.f5006c);
            map.put("toId", this.f5007d);
            map.put("toTabIndex", this.f5010g);
            if (!TextUtils.isEmpty(this.f5008e)) {
                map.put("routeType", this.f5008e);
            }
            if (TextUtils.isEmpty(this.f5009f)) {
                return;
            }
            map.put("toPage", this.f5009f);
        }
    }
}
