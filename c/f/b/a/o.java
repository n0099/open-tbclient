package c.f.b.a;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.u;
/* loaded from: classes3.dex */
public final class o implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArCoreApk.a f23313b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f23314c;

    public o(l lVar, Context context, ArCoreApk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23314c = lVar;
        this.a = context;
        this.f23313b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                aVar = this.f23314c.f23307d;
                String str = this.a.getApplicationInfo().packageName;
                l lVar = this.f23314c;
                l = l.l();
                aVar.a(str, l, new u(this));
            } catch (RemoteException e2) {
                Log.e("ARCore-InstallService", "requestInfo threw", e2);
                this.f23313b.a(ArCoreApk.Availability.UNKNOWN_ERROR);
            }
        }
    }
}
