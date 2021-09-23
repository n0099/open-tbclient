package c.a.p0.a.o0.d;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f7815c;

    /* renamed from: d  reason: collision with root package name */
    public String f7816d;

    /* renamed from: e  reason: collision with root package name */
    public String f7817e;

    /* renamed from: f  reason: collision with root package name */
    public String f7818f;

    /* renamed from: g  reason: collision with root package name */
    public String f7819g;

    public e() {
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
        this.f7803a = FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE;
    }

    @Override // c.a.p0.a.o0.d.a
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = (c.a.p0.a.o0.a.c(str, "fromId", this.f7815c) + c.a.p0.a.o0.a.c(str, "toId", this.f7816d)) + c.a.p0.a.o0.a.c(str, "toTabIndex", this.f7819g);
            if (!TextUtils.isEmpty(this.f7817e)) {
                str2 = str2 + c.a.p0.a.o0.a.c(str, "routeType", this.f7817e);
            }
            if (TextUtils.isEmpty(this.f7818f)) {
                return str2;
            }
            return str2 + c.a.p0.a.o0.a.c(str, "toPage", this.f7818f);
        }
        return (String) invokeL.objValue;
    }
}
