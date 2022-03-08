package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.data.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.f;
import com.alipay.sdk.util.j;
import com.alipay.sdk.util.l;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes3.dex */
public class AuthTask {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f29379c;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.sdk.widget.a f29380b;

    /* loaded from: classes3.dex */
    public class a implements f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AuthTask a;

        public a(AuthTask authTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = authTask;
        }

        @Override // com.alipay.sdk.util.f.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }

        @Override // com.alipay.sdk.util.f.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

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
        f29379c = f.class;
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
        this.a = activity;
        com.alipay.sdk.sys.b.d().a(this.a);
        this.f29380b = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.k);
    }

    private f.e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? new a(this) : (f.e) invokeV.objValue;
    }

    private void c() {
        com.alipay.sdk.widget.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (aVar = this.f29380b) == null) {
            return;
        }
        aVar.d();
    }

    public synchronized String auth(String str, boolean z) {
        InterceptResult invokeLZ;
        String innerAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            synchronized (this) {
                innerAuth = innerAuth(new com.alipay.sdk.sys.a(this.a, str, "auth"), str, z);
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
                com.alipay.sdk.sys.a aVar = new com.alipay.sdk.sys.a(this.a, str, "authV2");
                a2 = j.a(aVar, innerAuth(aVar, str, z));
            }
            return a2;
        }
        return (Map) invokeLZ.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x006d, code lost:
        if (com.alipay.sdk.data.a.u().q() == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c1, code lost:
        if (com.alipay.sdk.data.a.u().q() != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c3, code lost:
        com.alipay.sdk.data.a.u().a(r5, r4.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00cc, code lost:
        a();
        com.alipay.sdk.app.statistic.a.b(r4.a, r5, r6, r5.f29536d);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String innerAuth(com.alipay.sdk.sys.a aVar, String str, boolean z) {
        InterceptResult invokeLLZ;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, aVar, str, z)) == null) {
            synchronized (this) {
                if (z) {
                    c();
                }
                com.alipay.sdk.sys.b.d().a(this.a);
                a2 = b.a();
                com.alipay.sdk.app.a.a("");
                try {
                    a2 = a(this.a, str, aVar);
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.Z, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.a0, j.a(a2, "resultStatus") + "|" + j.a(a2, "memo"));
                } catch (Exception e2) {
                    com.alipay.sdk.util.c.a(e2);
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.Z, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.a0, j.a(a2, "resultStatus") + "|" + j.a(a2, "memo"));
                }
            }
            return a2;
        }
        return (String) invokeLLZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.alipay.sdk.widget.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (aVar = this.f29380b) == null) {
            return;
        }
        aVar.a();
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(Activity activity, String str, com.alipay.sdk.sys.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, this, activity, str, aVar)) == null) {
            c();
            c cVar = null;
            try {
                try {
                    List<com.alipay.sdk.protocol.b> a2 = com.alipay.sdk.protocol.b.a(new com.alipay.sdk.packet.impl.a().a(aVar, activity, str).c().optJSONObject("form").optJSONObject(com.alipay.sdk.cons.c.f29468d));
                    a();
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        if (a2.get(i2).a() == com.alipay.sdk.protocol.a.f29525c) {
                            return a(aVar, a2.get(i2));
                        }
                    }
                    a();
                } finally {
                    a();
                }
            } catch (IOException e2) {
                c b2 = c.b(c.f29430f.b());
                com.alipay.sdk.app.statistic.a.a(aVar, "net", e2);
                cVar = b2;
                if (cVar == null) {
                }
                return b.a(cVar.b(), cVar.a(), "");
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.G, th);
                if (cVar == null) {
                }
                return b.a(cVar.b(), cVar.a(), "");
            }
            if (cVar == null) {
                cVar = c.b(c.f29428d.b());
            }
            return b.a(cVar.b(), cVar.a(), "");
        }
        return (String) invokeLLL.objValue;
    }

    private String a(Activity activity, String str, com.alipay.sdk.sys.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, activity, str, aVar)) == null) {
            String a2 = aVar.a(str);
            List<a.b> k = com.alipay.sdk.data.a.u().k();
            if (!com.alipay.sdk.data.a.u().f29480g || k == null) {
                k = com.alipay.sdk.app.a.f29425d;
            }
            if (l.b(aVar, this.a, k)) {
                String a3 = new f(activity, aVar, b()).a(a2);
                if (!TextUtils.equals(a3, f.f29566j) && !TextUtils.equals(a3, f.k)) {
                    return TextUtils.isEmpty(a3) ? b.a() : a3;
                }
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.m0);
                return b(activity, a2, aVar);
            }
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.n0);
            return b(activity, a2, aVar);
        }
        return (String) invokeLLL.objValue;
    }

    private String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.protocol.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, aVar, bVar)) == null) {
            String[] c2 = bVar.c();
            Bundle bundle = new Bundle();
            bundle.putString("url", c2[0]);
            Intent intent = new Intent(this.a, H5AuthActivity.class);
            intent.putExtras(bundle);
            a.C1689a.a(aVar, intent);
            this.a.startActivity(intent);
            synchronized (f29379c) {
                try {
                    f29379c.wait();
                } catch (InterruptedException unused) {
                    return b.a();
                }
            }
            String d2 = b.d();
            return TextUtils.isEmpty(d2) ? b.a() : d2;
        }
        return (String) invokeLL.objValue;
    }
}
