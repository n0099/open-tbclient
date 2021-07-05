package com.baidu.ar.auth;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.k;
import com.baidu.ar.h.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class h implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k[] jQ;
    public volatile boolean jR;
    public volatile boolean jS;

    public h(k... kVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.jQ = kVarArr;
        this.jR = false;
    }

    @Override // com.baidu.ar.auth.k
    public void a(k.a aVar) {
        k[] kVarArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (kVarArr = this.jQ) == null) {
            return;
        }
        for (k kVar : kVarArr) {
            kVar.a(aVar);
        }
    }

    @Override // com.baidu.ar.auth.k
    public void doAuth(Context context, IAuthCallback iAuthCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, iAuthCallback) == null) {
            synchronized (this) {
                if (this.jR) {
                    return;
                }
                k[] kVarArr = this.jQ;
                if (kVarArr == null || kVarArr.length <= 0) {
                    r.a(new Runnable(this, iAuthCallback) { // from class: com.baidu.ar.auth.h.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ h jU;
                        public final /* synthetic */ IAuthCallback jl;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iAuthCallback};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.jU = this;
                            this.jl = iAuthCallback;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IAuthCallback iAuthCallback2;
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (iAuthCallback2 = this.jl) == null) {
                                return;
                            }
                            iAuthCallback2.onError("无效的鉴权组合方式", 0);
                        }
                    }, 0L);
                    return;
                }
                this.jR = true;
                k[] kVarArr2 = this.jQ;
                int[] iArr = {0, kVarArr2.length};
                for (k kVar : kVarArr2) {
                    kVar.doAuth(context, new IAuthCallback(this, iArr, iAuthCallback) { // from class: com.baidu.ar.auth.h.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ int[] jT;
                        public final /* synthetic */ h jU;
                        public final /* synthetic */ IAuthCallback jl;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iArr, iAuthCallback};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.jU = this;
                            this.jT = iArr;
                            this.jl = iAuthCallback;
                        }

                        @Override // com.baidu.ar.auth.IAuthCallback
                        public void onError(String str, int i2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048576, this, str, i2) == null) {
                                synchronized (this) {
                                    boolean z = this.jU.jR;
                                    this.jU.jR = false;
                                    this.jU.a((k.a) null);
                                    if (z && this.jl != null) {
                                        this.jl.onError(str, i2);
                                    }
                                }
                            }
                        }

                        @Override // com.baidu.ar.auth.IAuthCallback
                        public void onSuccess() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                synchronized (this) {
                                    if (!this.jU.jS && this.jU.jR) {
                                        int[] iArr2 = this.jT;
                                        iArr2[0] = iArr2[0] + 1;
                                        if (this.jT[0] == this.jT[1]) {
                                            this.jU.jS = true;
                                            if (this.jl != null) {
                                                this.jl.onSuccess();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    });
                }
            }
        }
    }
}
