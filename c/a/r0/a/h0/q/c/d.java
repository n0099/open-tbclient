package c.a.r0.a.h0.q.c;

import android.text.TextUtils;
import android.util.LruCache;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f6847b;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, Long> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78952879, "Lc/a/r0/a/h0/q/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78952879, "Lc/a/r0/a/h0/q/c/d;");
                return;
            }
        }
        f6847b = k.a;
    }

    public d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        i2 = i2 <= 0 ? 10 : i2;
        this.a = new LruCache<>(i2);
        if (f6847b) {
            String str = "lru size - " + i2;
        }
    }

    @Override // c.a.r0.a.h0.q.c.a
    public b a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (f6847b) {
                String str3 = "prelink LRU size - " + this.a.size();
            }
            Long l = this.a.get(str2);
            if (l == null) {
                return null;
            }
            b bVar = new b();
            bVar.a = ProcessUtils.getCurProcessName();
            bVar.f6845b = l.longValue();
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    @Override // c.a.r0.a.h0.q.c.a
    public void b(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, z) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (f6847b) {
            String str3 = "record : appId-" + str + ", url-" + str2;
        }
        this.a.put(str2, Long.valueOf(System.currentTimeMillis()));
    }
}
