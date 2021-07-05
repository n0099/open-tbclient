package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.data.a;
import com.alipay.sdk.util.e;
import com.alipay.sdk.util.l;
import com.alipay.sdk.util.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class AuthTask {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f1750a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Activity f1751b;

    /* renamed from: c  reason: collision with root package name */
    public com.alipay.sdk.widget.a f1752c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1081680512, "Lcom/alipay/sdk/app/AuthTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1081680512, "Lcom/alipay/sdk/app/AuthTask;");
                return;
            }
        }
        f1750a = com.alipay.sdk.util.e.class;
    }

    public AuthTask(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1751b = activity;
        com.alipay.sdk.sys.b.a().a(this.f1751b, com.alipay.sdk.data.c.b());
        com.alipay.sdk.app.statistic.a.a(activity);
        this.f1752c = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f2015c);
    }

    private void b() {
        com.alipay.sdk.widget.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (aVar = this.f1752c) == null) {
            return;
        }
        aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.alipay.sdk.widget.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (aVar = this.f1752c) == null) {
            return;
        }
        aVar.c();
    }

    public synchronized String auth(String str, boolean z) {
        InterceptResult invokeLZ;
        String c2;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            synchronized (this) {
                if (z) {
                    b();
                }
                com.alipay.sdk.sys.b.a().a(this.f1751b, com.alipay.sdk.data.c.b());
                c2 = j.c();
                i.a("");
                try {
                    c2 = a(this.f1751b, str);
                    com.alipay.sdk.data.a.g().a(this.f1751b);
                    c();
                    activity = this.f1751b;
                } catch (Exception e2) {
                    com.alipay.sdk.util.c.a(e2);
                    com.alipay.sdk.data.a.g().a(this.f1751b);
                    c();
                    activity = this.f1751b;
                }
                com.alipay.sdk.app.statistic.a.b(activity, str);
            }
            return c2;
        }
        return (String) invokeLZ.objValue;
    }

    public synchronized Map<String, String> authV2(String str, boolean z) {
        InterceptResult invokeLZ;
        Map<String, String> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            synchronized (this) {
                a2 = l.a(auth(str, z));
            }
            return a2;
        }
        return (Map) invokeLZ.objValue;
    }

    private e.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new a(this) : (e.a) invokeV.objValue;
    }

    private String a(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, activity, str)) == null) {
            String a2 = new com.alipay.sdk.sys.a(this.f1751b).a(str);
            List<a.C0016a> f2 = com.alipay.sdk.data.a.g().f();
            if (!com.alipay.sdk.data.a.g().q || f2 == null) {
                f2 = i.f1803a;
            }
            if (n.b(this.f1751b, f2)) {
                String a3 = new com.alipay.sdk.util.e(activity, a()).a(a2);
                if (!TextUtils.equals(a3, com.alipay.sdk.util.e.f1966a) && !TextUtils.equals(a3, com.alipay.sdk.util.e.f1967b)) {
                    return TextUtils.isEmpty(a3) ? j.c() : a3;
                }
                com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.O, "");
                return b(activity, a2);
            }
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.P, "");
            return b(activity, a2);
        }
        return (String) invokeLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, CONST]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    private String b(Activity activity, String str) {
        InterceptResult invokeLL;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, activity, str)) == null) {
            b();
            try {
                try {
                    List<com.alipay.sdk.protocol.b> a2 = com.alipay.sdk.protocol.b.a(new com.alipay.sdk.packet.impl.a().a(activity, str).c().optJSONObject("form").optJSONObject(com.alipay.sdk.cons.c.f1852d));
                    c();
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        if (a2.get(i2).b() == com.alipay.sdk.protocol.a.f1918b) {
                            return a(a2.get(i2));
                        }
                    }
                } finally {
                    c();
                }
            } catch (IOException e2) {
                k b2 = k.b(k.f1812d.a());
                com.alipay.sdk.app.statistic.a.a("net", e2);
                c();
                kVar = b2;
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.v, th);
            }
            c();
            kVar = null;
            if (kVar == null) {
                kVar = k.b(k.f1810b.a());
            }
            return j.a(kVar.a(), kVar.b(), "");
        }
        return (String) invokeLL.objValue;
    }

    private String a(com.alipay.sdk.protocol.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, bVar)) == null) {
            String[] c2 = bVar.c();
            Bundle bundle = new Bundle();
            bundle.putString("url", c2[0]);
            Intent intent = new Intent(this.f1751b, H5AuthActivity.class);
            intent.putExtras(bundle);
            this.f1751b.startActivity(intent);
            synchronized (f1750a) {
                try {
                    f1750a.wait();
                } catch (InterruptedException unused) {
                    return j.c();
                }
            }
            String a2 = j.a();
            return TextUtils.isEmpty(a2) ? j.c() : a2;
        }
        return (String) invokeL.objValue;
    }
}
