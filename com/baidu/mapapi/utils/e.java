package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f39916a;

    public e(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39916a = dVar;
    }

    @Override // com.baidu.mapframework.open.aidl.b
    public void a(IBinder iBinder) throws RemoteException {
        IComOpenClient iComOpenClient;
        boolean z;
        String unused;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iBinder) == null) {
            unused = b.f39908c;
            iComOpenClient = b.f39910e;
            if (iComOpenClient != null) {
                IComOpenClient unused2 = b.f39910e = null;
            }
            IComOpenClient unused3 = b.f39910e = IComOpenClient.a.a(iBinder);
            z = b.t;
            if (!z) {
                b.a(b.f39906a);
            }
            boolean unused4 = b.t = true;
        }
    }
}
