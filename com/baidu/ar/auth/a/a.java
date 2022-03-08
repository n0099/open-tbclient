package com.baidu.ar.auth.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.AuthJni;
import com.baidu.ar.auth.IAuthenticateCallback;
import com.baidu.ar.auth.IAuthenticator;
import com.baidu.ar.h.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a implements IAuthenticator {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a ki;
    public transient /* synthetic */ FieldHolder $fh;
    public String js;
    public String jt;
    public d kh;
    public String mSecretKey;

    public a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.js = str;
        this.jt = str2;
        this.mSecretKey = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, byte[] bArr, IAuthenticateCallback iAuthenticateCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, context, bArr, iAuthenticateCallback) == null) {
            b.cE().init(context, bArr, iAuthenticateCallback);
        }
    }

    public static a b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            if (ki == null) {
                ki = new a(str, str2, str3);
            } else {
                ki.js = str;
                ki.jt = str2;
                ki.mSecretKey = str3;
            }
            return ki;
        }
        return (a) invokeLLL.objValue;
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
            ARAuth.setAuthLicense(bArr, this.js, this.jt, this.mSecretKey);
            if (this.kh == null) {
                d dVar = new d("AsyncAuthenticator");
                this.kh = dVar;
                dVar.start();
            }
            AuthJni.init();
            this.kh.execute(new Runnable(this, context, bArr, iAuthenticateCallback) { // from class: com.baidu.ar.auth.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ byte[] kj;
                public final /* synthetic */ IAuthenticateCallback kk;
                public final /* synthetic */ a kl;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, bArr, iAuthenticateCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.kl = this;
                    this.val$context = context;
                    this.kj = bArr;
                    this.kk = iAuthenticateCallback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.kl.a(this.val$context, this.kj, this.kk);
                    }
                }
            });
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
