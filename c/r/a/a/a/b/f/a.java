package c.r.a.a.a.b.f;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import c.r.a.a.c.b.c;
import com.baidu.android.imsdk.internal.Constants;
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

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f35278b;

    /* renamed from: c  reason: collision with root package name */
    public static final Uri f35279c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f35280a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-784784497, "Lc/r/a/a/a/b/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-784784497, "Lc/r/a/a/a/b/f/a;");
                return;
            }
        }
        f35279c = Uri.parse("content://cn.nubia.identity/identity");
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35280a = context;
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f35278b == null) {
                synchronized (a.class) {
                    if (f35278b == null) {
                        f35278b = new a(context);
                    }
                }
            }
            return f35278b;
        }
        return (a) invokeL.objValue;
    }

    public final String b(String str, String str2) {
        Bundle call;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    ContentProviderClient acquireUnstableContentProviderClient = this.f35280a.getContentResolver().acquireUnstableContentProviderClient(f35279c);
                    call = acquireUnstableContentProviderClient.call(str2, null, null);
                    if (acquireUnstableContentProviderClient != null) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            acquireUnstableContentProviderClient.close();
                        } else {
                            acquireUnstableContentProviderClient.release();
                        }
                    }
                } else {
                    call = this.f35280a.getContentResolver().call(f35279c, str2, (String) null, (Bundle) null);
                }
                return (call == null || call.getInt("code", -1) != 0) ? "" : call.getString("id");
            } catch (Throwable th) {
                c.c(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public final boolean c() {
        Bundle call;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    ContentProviderClient acquireUnstableContentProviderClient = this.f35280a.getContentResolver().acquireUnstableContentProviderClient(f35279c);
                    call = acquireUnstableContentProviderClient.call("isSupport", null, null);
                    if (acquireUnstableContentProviderClient != null) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            acquireUnstableContentProviderClient.close();
                        } else {
                            acquireUnstableContentProviderClient.release();
                        }
                    }
                } else {
                    call = this.f35280a.getContentResolver().call(f35279c, "isSupport", (String) null, (Bundle) null);
                }
                if (call.getInt("code", -1) == 0) {
                    return call.getBoolean("issupport", true);
                }
                return false;
            } catch (Throwable th) {
                c.c(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b(null, "getOAID") : (String) invokeV.objValue;
    }
}
