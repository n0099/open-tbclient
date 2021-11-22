package com.baidu.swan.apps;

import b.a.p0.a.e0.d;
import b.a.p0.a.f1.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SwanAppClearCacheErrorActivity extends SwanAppErrorActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SwanAppClearCacheErrorActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean mHasGotoClearCache;

    public SwanAppClearCacheErrorActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void markHasGotoClearCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mHasGotoClearCache = true;
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onRestart();
            boolean z = SwanAppErrorActivity.DEBUG;
            if (this.mHasGotoClearCache) {
                this.mHasGotoClearCache = false;
                try {
                    b launchInfo = getLaunchInfo();
                    if (SwanAppNetworkUtils.i(this)) {
                        SwanLauncher.j().n(launchInfo, null);
                        finish();
                    }
                } catch (Exception e2) {
                    d.l(TAG, "SwanAppClearCacheErrorActivity#onRestart", e2);
                }
            }
        }
    }
}
