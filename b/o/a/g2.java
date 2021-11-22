package b.o.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.FunOpenIDSdk;
/* loaded from: classes6.dex */
public class g2 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static g2 f34153b;

    /* renamed from: c  reason: collision with root package name */
    public static String f34154c;

    /* renamed from: d  reason: collision with root package name */
    public static String f34155d;

    /* renamed from: e  reason: collision with root package name */
    public static String f34156e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f34157a;

    public g2(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34157a = context;
    }

    public static g2 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f34153b == null) {
                synchronized (g2.class) {
                    if (f34153b == null) {
                        f34153b = new g2(context);
                    }
                }
            }
            return f34153b;
        }
        return (g2) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f34155d : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(f34154c)) {
                try {
                    return m2.E(this.f34157a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
            return f34154c;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f34156e : (String) invokeV.objValue;
    }

    public void e() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                Class.forName("com.fun.openid.sdk.FunOpenIDSdk");
                Class.forName("com.fun.openid.sdk.OnGetOaidListener");
                z = true;
            } catch (Exception unused) {
                z = false;
            }
            if (z) {
                try {
                    FunOpenIDSdk.getOaid(this.f34157a, new d2(this));
                } catch (Exception unused2) {
                }
            }
        }
    }
}
