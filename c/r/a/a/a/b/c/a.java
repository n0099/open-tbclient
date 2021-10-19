package c.r.a.a.a.b.c;

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
import com.yxcorp.kuaishou.addfp.a.b.b.d;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f35506a;

    /* renamed from: b  reason: collision with root package name */
    public Context f35507b;

    /* renamed from: c  reason: collision with root package name */
    public d f35508c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f35509d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f35510e;

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
        this.f35508c = null;
        this.f35509d = new CountDownLatch(1);
        this.f35510e = new b(this);
        this.f35507b = context;
    }

    public final void c() {
        ServiceConnection serviceConnection;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (serviceConnection = this.f35510e) == null || (context = this.f35507b) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            try {
                this.f35506a = bVar;
                Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent.setPackage("com.huawei.hwid");
                if (!this.f35507b.bindService(intent, this.f35510e, 1)) {
                    e(false);
                    return;
                }
                this.f35509d.await(10L, TimeUnit.SECONDS);
                if (this.f35508c != null) {
                    e(true);
                } else {
                    e(false);
                }
            } catch (Throwable th) {
                c.c(th);
                e(false);
            }
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            try {
                if (!z) {
                    this.f35506a.e();
                    return;
                }
                String a2 = this.f35508c.a();
                if (TextUtils.isEmpty(a2)) {
                    this.f35506a.a(a2);
                }
            } catch (Throwable th) {
                c.c(th);
            }
        }
    }
}
