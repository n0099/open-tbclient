package c.r.a.a.a.b.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import c.r.a.a.c.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yxcorp.kuaishou.addfp.a.b.b.e;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes4.dex */
public final class b implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ a f35511e;

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35511e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        CountDownLatch countDownLatch3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
            try {
                this.f35511e.f35508c = e.a(iBinder);
            } catch (Throwable th) {
                try {
                    c.c(th);
                    countDownLatch3 = this.f35511e.f35509d;
                    if (countDownLatch3 == null) {
                    }
                } finally {
                    countDownLatch = this.f35511e.f35509d;
                    if (countDownLatch != null) {
                        countDownLatch2 = this.f35511e.f35509d;
                        countDownLatch2.countDown();
                    }
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            this.f35511e.f35508c = null;
        }
    }
}
