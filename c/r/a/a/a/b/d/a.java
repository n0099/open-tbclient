package c.r.a.a.a.b.d;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import c.r.a.a.c.b.c;
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
    public Context f35485a;

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.c.a f35486b;

    /* renamed from: c  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f35487c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f35488d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f35489e;

    public a(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35485a = null;
        this.f35488d = new CountDownLatch(1);
        this.f35489e = new b(this);
        try {
            this.f35485a = context;
            this.f35487c = bVar;
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.f35485a.bindService(intent, this.f35489e, 1)) {
                c(false);
                c.b("bindService Failed!");
                return;
            }
            this.f35488d.await(10L, TimeUnit.SECONDS);
            if (this.f35486b != null) {
                c(true);
            } else {
                c(false);
            }
        } catch (Throwable th) {
            c.c(th);
            c(false);
        }
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                try {
                    String f2 = f();
                    if (!TextUtils.isEmpty(f2)) {
                        this.f35487c.a(f2);
                        return;
                    }
                } catch (Throwable th) {
                    c.c(th);
                    return;
                }
            }
            this.f35487c.e();
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return this.f35485a.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
            } catch (Throwable th) {
                c.c(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                this.f35485a.unbindService(this.f35489e);
                c.b("unBind Service");
            } catch (Throwable th) {
                c.c(th);
            }
            this.f35486b = null;
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                if (this.f35486b != null) {
                    return this.f35486b.a();
                }
                return null;
            } catch (Throwable th) {
                c.c(th);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
