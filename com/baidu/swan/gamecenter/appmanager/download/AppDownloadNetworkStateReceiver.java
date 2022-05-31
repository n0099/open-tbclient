package com.baidu.swan.gamecenter.appmanager.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cw2;
import com.repackage.fq3;
import com.repackage.gz2;
import com.repackage.qq3;
import com.repackage.rf1;
import com.repackage.tq3;
/* loaded from: classes2.dex */
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
        DEBUG = rf1.a;
    }

    public AppDownloadNetworkStateReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (DEBUG) {
            Log.d("NetworkBroadcast", "——> onReceive: ");
        }
        if (SwanAppNetworkUtils.NetType.WIFI == SwanAppNetworkUtils.f() && qq3.a().b()) {
            if (ProcessUtils.isMainProcess()) {
                fq3.n().D();
                return;
            }
            cw2 z = gz2.J().z();
            if (z != null) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "resumeAllDownload");
                z.V(bundle, tq3.class);
            }
        } else if (ProcessUtils.isMainProcess()) {
            fq3.n().u();
        } else {
            cw2 z2 = gz2.J().z();
            if (z2 != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("operation", "pauseAllDownload");
                z2.V(bundle2, tq3.class);
            }
        }
    }
}
