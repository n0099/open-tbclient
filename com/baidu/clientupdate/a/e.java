package com.baidu.clientupdate.a;

import android.util.Log;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.LogUtil;
/* loaded from: classes2.dex */
public class e extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ byte[] a;
    public final /* synthetic */ d b;

    public e(d dVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = dVar;
        this.a = bArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.run();
            try {
                this.b.a();
                bVar = this.b.d;
                bVar.a(this.a);
            } catch (Exception e) {
                LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e));
            }
        }
    }
}
