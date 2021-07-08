package com.baidu.cyberplayer.sdk.extractor;

import android.os.Bundle;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerService;
import com.baidu.cyberplayer.sdk.remote.a;
import com.baidu.cyberplayer.sdk.remote.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c extends a.AbstractBinderC0091a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CyberExtractor f4900a;

    /* renamed from: b  reason: collision with root package name */
    public RemotePlayerService f4901b;

    public c(RemotePlayerService remotePlayerService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {remotePlayerService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4901b = remotePlayerService;
    }

    private CyberExtractor c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.f4900a == null) {
                synchronized (this) {
                    if (this.f4900a == null) {
                        this.f4900a = new CyberExtractor(false);
                    }
                }
            }
            return this.f4900a;
        }
        return (CyberExtractor) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public Bundle a() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c().getMetaData() : (Bundle) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(int i2, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j)}) == null) {
            c().setOption(i2, str, j);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(e eVar) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            c().setDataSource(CyberPlayerManager.getApplicationContext(), eVar.a(), eVar.b());
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void b() throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            CyberLog.i("RemoteExtractor", "release");
            synchronized (this) {
                if (this.f4900a != null) {
                    this.f4900a.release();
                    this.f4900a = null;
                }
            }
            this.f4901b = null;
        }
    }
}
