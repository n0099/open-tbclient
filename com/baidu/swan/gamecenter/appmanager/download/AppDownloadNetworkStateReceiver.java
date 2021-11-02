package com.baidu.swan.gamecenter.appmanager.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import b.a.p0.a.a2.d;
import b.a.p0.a.k;
import b.a.p0.g.c.a;
import b.a.p0.g.c.d.b;
import b.a.p0.g.c.d.e;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AppDownloadNetworkStateReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String KEY_OPERATION = "operation";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-446394148, "Lcom/baidu/swan/gamecenter/appmanager/download/AppDownloadNetworkStateReceiver;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-446394148, "Lcom/baidu/swan/gamecenter/appmanager/download/AppDownloadNetworkStateReceiver;");
                return;
            }
        }
        DEBUG = k.f6397a;
    }

    public AppDownloadNetworkStateReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || context == null || intent == null || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            return;
        }
        boolean z = DEBUG;
        if (b.a().b() && SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType.WIFI) {
            if (ProcessUtils.isMainProcess()) {
                a.n().D();
                return;
            }
            b.a.p0.a.v1.c.e.a z2 = d.g().z();
            if (z2 != null) {
                Bundle bundle = new Bundle();
                bundle.putString(KEY_OPERATION, "resumeAllDownload");
                z2.K(bundle, e.class);
            }
        } else if (ProcessUtils.isMainProcess()) {
            a.n().u();
        } else {
            b.a.p0.a.v1.c.e.a z3 = d.g().z();
            if (z3 != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(KEY_OPERATION, "pauseAllDownload");
                z3.K(bundle2, e.class);
            }
        }
    }
}
