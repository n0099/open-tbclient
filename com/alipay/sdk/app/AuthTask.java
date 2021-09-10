package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.data.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.e;
import com.alipay.sdk.util.i;
import com.alipay.sdk.util.k;
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
/* loaded from: classes4.dex */
public class AuthTask {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f35835a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Activity f35836b;

    /* renamed from: c  reason: collision with root package name */
    public com.alipay.sdk.widget.a f35837c;

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
        f35835a = e.class;
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
        this.f35836b = activity;
        com.alipay.sdk.sys.b.a().a(this.f35836b);
        this.f35837c = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f36110c);
    }

    private void b() {
        com.alipay.sdk.widget.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (aVar = this.f35837c) == null) {
            return;
        }
        aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.alipay.sdk.widget.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (aVar = this.f35837c) == null) {
            return;
        }
        aVar.c();
    }

    public synchronized String auth(String str, boolean z) {
        InterceptResult invokeLZ;
        String innerAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            synchronized (this) {
                innerAuth = innerAuth(new com.alipay.sdk.sys.a(this.f35836b, str, "auth"), str, z);
            }
            return innerAuth;
        }
        return (String) invokeLZ.objValue;
    }

    public synchronized Map<String, String> authV2(String str, boolean z) {
        InterceptResult invokeLZ;
        Map<String, String> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            synchronized (this) {
                com.alipay.sdk.sys.a aVar = new com.alipay.sdk.sys.a(this.f35836b, str, "authV2");
                a2 = i.a(aVar, innerAuth(aVar, str, z));
            }
            return a2;
        }
        return (Map) invokeLZ.objValue;
    }

    public synchronized String innerAuth(com.alipay.sdk.sys.a aVar, String str, boolean z) {
        InterceptResult invokeLLZ;
        String c2;
        Activity activity;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, aVar, str, z)) == null) {
            synchronized (this) {
                if (z) {
                    b();
                }
                com.alipay.sdk.sys.b.a().a(this.f35836b);
                c2 = b.c();
                a.a("");
                try {
                    c2 = a(this.f35836b, str, aVar);
                    com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.P, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.Q, i.a(c2, i.f36094a) + "|" + i.a(c2, i.f36095b));
                    if (!com.alipay.sdk.data.a.p().n()) {
                        com.alipay.sdk.data.a.p().a(aVar, this.f35836b);
                    }
                    c();
                    activity = this.f35836b;
                    str2 = aVar.q;
                } catch (Exception e2) {
                    com.alipay.sdk.util.c.a(e2);
                    com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.P, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.Q, i.a(c2, i.f36094a) + "|" + i.a(c2, i.f36095b));
                    if (!com.alipay.sdk.data.a.p().n()) {
                        com.alipay.sdk.data.a.p().a(aVar, this.f35836b);
                    }
                    c();
                    activity = this.f35836b;
                    str2 = aVar.q;
                }
                com.alipay.sdk.app.statistic.a.b(activity, aVar, str, str2);
            }
            return c2;
        }
        return (String) invokeLLZ.objValue;
    }

    private e.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new e.c(this) { // from class: com.alipay.sdk.app.AuthTask.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AuthTask f35838a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35838a = this;
            }

            @Override // com.alipay.sdk.util.e.c
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.alipay.sdk.util.e.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f35838a.c();
                }
            }
        } : (e.c) invokeV.objValue;
    }

    private String a(Activity activity, String str, com.alipay.sdk.sys.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, activity, str, aVar)) == null) {
            String a2 = aVar.a(str);
            List<a.C1563a> o = com.alipay.sdk.data.a.p().o();
            if (!com.alipay.sdk.data.a.p().f35962a || o == null) {
                o = a.f35891a;
            }
            if (k.b(aVar, this.f35836b, o)) {
                String a3 = new e(activity, aVar, a()).a(a2);
                if (!TextUtils.equals(a3, e.f36070a) && !TextUtils.equals(a3, e.f36071b)) {
                    return TextUtils.isEmpty(a3) ? b.c() : a3;
                }
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.ac);
                return b(activity, a2, aVar);
            }
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.ad);
            return b(activity, a2, aVar);
        }
        return (String) invokeLLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, CONST]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    private String b(Activity activity, String str, com.alipay.sdk.sys.a aVar) {
        InterceptResult invokeLLL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, activity, str, aVar)) == null) {
            b();
            try {
                try {
                    List<com.alipay.sdk.protocol.b> a2 = com.alipay.sdk.protocol.b.a(new com.alipay.sdk.packet.impl.a().a(aVar, activity, str).c().optJSONObject("form").optJSONObject(com.alipay.sdk.cons.c.f35946d));
                    c();
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        if (a2.get(i2).b() == com.alipay.sdk.protocol.a.f36020b) {
                            return a(aVar, a2.get(i2));
                        }
                    }
                } finally {
                    c();
                }
            } catch (IOException e2) {
                c b2 = c.b(c.f35900d.a());
                com.alipay.sdk.app.statistic.a.a(aVar, "net", e2);
                c();
                cVar = b2;
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.w, th);
            }
            c();
            cVar = null;
            if (cVar == null) {
                cVar = c.b(c.f35898b.a());
            }
            return b.a(cVar.a(), cVar.b(), "");
        }
        return (String) invokeLLL.objValue;
    }

    private String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.protocol.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar, bVar)) == null) {
            String[] c2 = bVar.c();
            Bundle bundle = new Bundle();
            bundle.putString("url", c2[0]);
            Intent intent = new Intent(this.f35836b, H5AuthActivity.class);
            intent.putExtras(bundle);
            a.C1565a.a(aVar, intent);
            this.f35836b.startActivity(intent);
            synchronized (f35835a) {
                try {
                    f35835a.wait();
                } catch (InterruptedException unused) {
                    return b.c();
                }
            }
            String a2 = b.a();
            return TextUtils.isEmpty(a2) ? b.c() : a2;
        }
        return (String) invokeLL.objValue;
    }
}
