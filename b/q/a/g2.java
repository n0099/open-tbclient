package b.q.a;

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
    public static g2 f33319b;

    /* renamed from: c  reason: collision with root package name */
    public static String f33320c;

    /* renamed from: d  reason: collision with root package name */
    public static String f33321d;

    /* renamed from: e  reason: collision with root package name */
    public static String f33322e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f33323a;

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
        this.f33323a = context;
    }

    public static g2 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f33319b == null) {
                synchronized (g2.class) {
                    if (f33319b == null) {
                        f33319b = new g2(context);
                    }
                }
            }
            return f33319b;
        }
        return (g2) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33321d : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(f33320c)) {
                try {
                    return m2.E(this.f33323a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
            return f33320c;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f33322e : (String) invokeV.objValue;
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
                    FunOpenIDSdk.getOaid(this.f33323a, new d2(this));
                } catch (Exception unused2) {
                }
            }
        }
    }
}
