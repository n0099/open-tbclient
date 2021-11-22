package com.baidu.clientupdate.a;

import android.util.Log;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.LogUtil;
/* loaded from: classes7.dex */
public class e extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ byte[] f37721a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f37722b;

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
        this.f37722b = dVar;
        this.f37721a = bArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.run();
            try {
                this.f37722b.a();
                bVar = this.f37722b.f37720d;
                bVar.a(this.f37721a);
            } catch (Exception e2) {
                LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e2));
            }
        }
    }
}
