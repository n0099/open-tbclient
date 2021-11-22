package b.a.p0.j.a0;

import android.text.TextUtils;
import b.a.p0.a.k;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10859a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(715699501, "Lb/a/p0/j/a0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(715699501, "Lb/a/p0/j/a0/a;");
                return;
            }
        }
        f10859a = k.f6863a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public <T> void a(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, responseCallback) == null) {
            if (f10859a) {
                String str3 = HttpRetryStatistic.RETRY_URL + str + "\nbody:" + str2;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b.a.p0.a.p.d.d e2 = b.a.p0.a.c1.a.e();
            if (e2.h() && e2.g(str)) {
                e2.e(str, str2, responseCallback);
                return;
            }
            b.a.p0.p.e.a.g().postStringRequest().url(str).cookieManager(b.a.p0.a.c1.a.q().a()).mediaType("application/json;charset=utf-8").content(str2).build().executeAsync(responseCallback);
        }
    }
}
