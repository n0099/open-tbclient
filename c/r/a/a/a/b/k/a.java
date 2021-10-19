package c.r.a.a.a.b.k;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.j.a f35548a;

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f35549b;

    /* renamed from: c  reason: collision with root package name */
    public Context f35550c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f35551d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f35552e;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35548a = null;
        this.f35551d = new CountDownLatch(1);
        this.f35552e = new b(this);
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                context.getPackageManager().getPackageInfo("com.mdid.msa", 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            try {
                if (this.f35552e == null || context == null) {
                    return;
                }
                context.unbindService(this.f35552e);
            } catch (Throwable th) {
                c.r.a.a.c.b.c.c(th);
            }
        }
    }

    public final void c(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar) == null) {
            try {
                this.f35549b = bVar;
                this.f35550c = context;
                if (f(context)) {
                    String packageName = context.getPackageName();
                    Intent intent = new Intent();
                    intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
                    intent.setAction("com.bun.msa.action.start.service");
                    intent.putExtra("com.bun.msa.param.pkgname", packageName);
                    intent.putExtra("com.bun.msa.param.runinset", true);
                    context.startService(intent);
                }
                Intent intent2 = new Intent();
                intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
                intent2.setAction("com.bun.msa.action.bindto.service");
                intent2.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
                if (!context.bindService(intent2, this.f35552e, 1)) {
                    d(false);
                    return;
                }
                this.f35551d.await(10L, TimeUnit.SECONDS);
                if (this.f35548a != null) {
                    d(true);
                } else {
                    d(false);
                }
            } catch (Throwable th) {
                c.r.a.a.c.b.c.c(th);
                d(false);
            }
        }
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                try {
                    String a2 = this.f35548a.a();
                    if (!TextUtils.isEmpty(a2)) {
                        this.f35549b.a(a2);
                        return;
                    }
                } catch (Throwable th) {
                    c.r.a.a.c.b.c.c(th);
                    return;
                }
            }
            this.f35549b.e();
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                return this.f35550c.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
