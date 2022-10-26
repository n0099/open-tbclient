package com.baidu.ar.auth.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.IAuthenticateCallback;
import com.baidu.ar.auth.IAuthenticator;
import com.baidu.ar.auth.IDuMixAuthCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class b implements IAuthenticator {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b km;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static b cE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (km == null) {
                km = new b();
            }
            return km;
        }
        return (b) invokeV.objValue;
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void init(Context context, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bArr) == null) {
            init(context, bArr, null);
        }
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void init(Context context, byte[] bArr, IAuthenticateCallback iAuthenticateCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bArr, iAuthenticateCallback) == null) {
            com.baidu.ar.libloader.a.load(context, null);
            List[] listArr = {ARAuth.checkAuth(context, bArr, new IDuMixAuthCallback(this, context, listArr, iAuthenticateCallback) { // from class: com.baidu.ar.auth.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IAuthenticateCallback kk;
                public final /* synthetic */ List[] kn;
                public final /* synthetic */ b ko;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, listArr, iAuthenticateCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.ko = this;
                    this.val$context = context;
                    this.kn = listArr;
                    this.kk = iAuthenticateCallback;
                }

                @Override // com.baidu.ar.auth.IDuMixAuthCallback
                public void onAvailFeaturesUpdate(List list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                        this.kn[0] = list;
                        IAuthenticateCallback iAuthenticateCallback2 = this.kk;
                        if (iAuthenticateCallback2 != null) {
                            iAuthenticateCallback2.onAvailFeaturesChanged(list);
                        }
                    }
                }

                @Override // com.baidu.ar.auth.IDuMixAuthCallback
                public void onFeatureRejected(int i) {
                    IAuthenticateCallback iAuthenticateCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (iAuthenticateCallback2 = this.kk) == null) {
                        return;
                    }
                    iAuthenticateCallback2.onFeatureRejected(i);
                }

                @Override // com.baidu.ar.auth.IDuMixAuthCallback
                public void onResult(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                        if (z) {
                            ARAuth.doAuth(this.val$context, null);
                        } else {
                            this.kn[0].clear();
                        }
                        IAuthenticateCallback iAuthenticateCallback2 = this.kk;
                        if (iAuthenticateCallback2 != null) {
                            iAuthenticateCallback2.onResult(z, this.kn[0]);
                        }
                    }
                }
            })};
        }
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ARAuth.release();
        }
    }
}
