package cn.com.chinatelecom.gateway.lib.c;

import android.net.ConnectivityManager;
import android.net.Network;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class l extends ConnectivityManager.NetworkCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public /* synthetic */ j a;

    public l(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        long j;
        m mVar;
        ConnectivityManager connectivityManager;
        String str;
        ConnectivityManager connectivityManager2;
        m mVar2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, network) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            j jVar = this.a;
            j = jVar.g;
            jVar.f = currentTimeMillis - j;
            j.a(this.a, true);
            mVar = this.a.e;
            if (mVar != null) {
                mVar2 = this.a.e;
                j2 = this.a.f;
                mVar2.a(network, j2);
            }
            connectivityManager = this.a.c;
            if (connectivityManager != null) {
                try {
                    connectivityManager2 = this.a.c;
                    connectivityManager2.unregisterNetworkCallback(this);
                    j.a(this.a, (ConnectivityManager) null);
                } catch (Throwable th) {
                    str = j.a;
                    CtAuth.warn(str, "switchToMobileForAboveL", th);
                }
            }
        }
    }
}
