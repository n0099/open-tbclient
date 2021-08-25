package c.r.a.a.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import c.r.a.a.c.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f35364a;

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.a.b f35365b;

    /* renamed from: c  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f35366c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f35367d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f35368e;

    public a(Context context) {
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
        this.f35367d = new CountDownLatch(1);
        this.f35368e = new b(this);
        this.f35364a = context;
    }

    public final void b() {
        ServiceConnection serviceConnection;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (serviceConnection = this.f35368e) == null || (context = this.f35364a) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void c(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            try {
                this.f35366c = bVar;
                Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
                ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                if (!this.f35364a.bindService(intent2, this.f35368e, 1)) {
                    d(false);
                    return;
                }
                this.f35367d.await(10L, TimeUnit.SECONDS);
                if (this.f35365b != null) {
                    d(true);
                } else {
                    d(false);
                }
            } catch (Throwable unused) {
                d(false);
            }
        }
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                try {
                    String a2 = this.f35365b.a();
                    if (!TextUtils.isEmpty(a2)) {
                        this.f35366c.a(a2);
                        return;
                    }
                } catch (Throwable th) {
                    c.c(th);
                    return;
                }
            }
            this.f35366c.e();
        }
    }
}
