package c.f.b.a;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.x;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public final class q implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Activity a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f23316b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f23317c;

    public q(l lVar, Activity activity, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, activity, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23317c = lVar;
        this.a = activity;
        this.f23316b = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                aVar = this.f23317c.f23307d;
                String str = this.a.getApplicationInfo().packageName;
                l lVar = this.f23317c;
                l = l.l();
                aVar.a(str, Collections.singletonList(l), new Bundle(), new x(this, atomicBoolean));
                new Handler().postDelayed(new r(this, atomicBoolean), 3000L);
            } catch (RemoteException e2) {
                Log.w("ARCore-InstallService", "requestInstall threw, launching fullscreen.", e2);
                l lVar2 = this.f23317c;
                l.n(this.a, this.f23316b);
            }
        }
    }
}
