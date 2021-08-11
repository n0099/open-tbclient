package c.a.n0.a.h0.q;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a2.d;
import c.a.n0.a.a2.e;
import c.a.n0.a.k;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6100a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f6101b;

    /* renamed from: c  reason: collision with root package name */
    public static final LruCache<String, Long> f6102c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.h0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0238a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f6104f;

        public RunnableC0238a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6103e = str;
            this.f6104f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = a.f6100a ? System.currentTimeMillis() : 0L;
                Set<String> h2 = b.g().h(this.f6103e, true);
                if (h2 == null || h2.size() <= 0) {
                    return;
                }
                if (a.f6100a) {
                    String str = "start prelink, swan is already launched - " + this.f6104f;
                }
                for (String str2 : h2) {
                    if (a.d(str2)) {
                        a.f6102c.put(str2, Long.valueOf(System.currentTimeMillis()));
                        b.g().m(str2);
                    }
                }
                if (a.f6100a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str3 = " prelink - " + this.f6103e + ", cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(829001130, "Lc/a/n0/a/h0/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(829001130, "Lc/a/n0/a/h0/q/a;");
                return;
            }
        }
        f6100a = k.f6803a;
        f6101b = false;
        f6102c = 0 != 0 ? new LruCache<>(10) : null;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (f6100a) {
                String str2 = "prelink url - " + str;
                String str3 = "prelink LRU size - " + f6102c.size();
            }
            Long l = f6102c.get(str);
            if (l == null) {
                boolean z = f6100a;
                return true;
            }
            boolean z2 = System.currentTimeMillis() - l.longValue() > 30000;
            if (f6100a) {
                String str4 = "url in LRU, time is out - " + z2;
            }
            return z2;
        }
        return invokeL.booleanValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            if (!f6101b) {
                boolean z = f6100a;
            } else if (TextUtils.isEmpty(str)) {
                boolean z2 = f6100a;
            } else {
                e r = d.g().r();
                if (r == null) {
                    boolean z3 = f6100a;
                } else if (TextUtils.equals(r.f4284f, str)) {
                    f(str, r.e());
                }
            }
        }
    }

    public static void f(@NonNull String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, str, z) == null) {
            ExecutorUtilsExt.postOnSerial(new RunnableC0238a(str, z), "SwanPreLinkWhenPreload");
        }
    }
}
