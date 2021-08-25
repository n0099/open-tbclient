package c.a.o0.a.h0.c.b;

import android.text.TextUtils;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5778c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f5779d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f5780a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f5781b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1194790756, "Lc/a/o0/a/h0/c/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1194790756, "Lc/a/o0/a/h0/c/b/a;");
                return;
            }
        }
        f5778c = k.f7049a;
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
                return;
            }
        }
        this.f5780a = false;
        this.f5781b = new HashMap<>();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f5779d == null) {
                synchronized (a.class) {
                    if (f5779d == null) {
                        f5779d = new a();
                    }
                }
            }
            return f5779d;
        }
        return (a) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5780a : invokeV.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            HashMap<String, Long> hashMap = this.f5781b;
            if (hashMap != null && hashMap.containsKey(str) && currentTimeMillis - this.f5781b.get(str).longValue() <= 18000000) {
                if (f5778c) {
                    String str2 = "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑";
                    return true;
                }
                return true;
            }
            if (f5778c) {
                HashMap<String, Long> hashMap2 = this.f5781b;
                if (hashMap2 != null && hashMap2.containsKey(str)) {
                    String str3 = "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.f5781b.get(str) + " ，id = " + str;
                } else {
                    String str4 = "小程序未被标记未无更新， id = " + str;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
