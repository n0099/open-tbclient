package com.baidu.clientupdate.a;

import android.util.Log;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.LogUtil;
/* loaded from: classes10.dex */
public class e extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f33369b;

    public e(d dVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33369b = dVar;
        this.a = bArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.run();
            try {
                this.f33369b.a();
                bVar = this.f33369b.f33368d;
                bVar.a(this.a);
            } catch (Exception e2) {
                LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e2));
            }
        }
    }
}
